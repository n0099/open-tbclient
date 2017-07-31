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
    private com.baidu.adp.lib.e.b<ImageView> aRt;
    private com.baidu.adp.lib.e.b<TextView> aRu;
    private com.baidu.adp.lib.e.b<View> aRv;
    private com.baidu.adp.lib.e.b<View> aRw;
    private com.baidu.adp.lib.e.b<LinearLayout> aRx;
    private com.baidu.adp.lib.e.b<GifView> aRy;
    private com.baidu.adp.lib.e.b<TbImageView> apA;
    private VoiceManager ciW;
    private com.baidu.tbadk.i.a cjq;
    private com.baidu.tieba.e.b cma;
    private com.baidu.tieba.pb.pb.main.a.b eGR;
    private com.baidu.tbadk.core.dialog.a eGX;
    private String eGx;
    private com.baidu.tieba.tbadkCore.data.e eHC;
    private com.baidu.tbadk.editortools.pb.c eHD;
    private com.baidu.adp.base.e eHG;
    private com.baidu.tbadk.core.view.c eHH;
    private BdUniqueId eHI;
    private Runnable eHJ;
    private at eHL;
    private com.baidu.adp.widget.a.a eHM;
    private String eHN;
    private TbRichTextMemeInfo eHO;
    private boolean eHe;
    private com.baidu.tieba.pb.pb.main.b eHg;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eHm;
    private v eHu;
    private boolean eHz;
    private String eIA;
    private com.baidu.tbadk.core.data.n eIB;
    private boolean eIo;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eGQ = false;
    private boolean eGS = false;
    private boolean eGT = false;
    private boolean edZ = false;
    private boolean eGU = true;
    private int eGV = 0;
    private com.baidu.tbadk.core.dialog.b eGW = null;
    private long bYB = -1;
    private long aKi = 0;
    private long eGY = 0;
    private long createTime = 0;
    private long aKa = 0;
    private boolean eGZ = false;
    private com.baidu.tbadk.l.d eHa = null;
    private long eHb = 0;
    private boolean eHc = false;
    private boolean eHd = false;
    private long eHf = 0;
    private String aDZ = null;
    private boolean eHh = false;
    private boolean eHi = false;
    private String eHj = "";
    private boolean eHk = true;
    private boolean eHl = false;
    private String source = "";
    private PbInterviewStatusView.a eHn = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eHp.jE(!PbActivity.this.eHk);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eGz != null && PbActivity.this.eGz.nL()) {
                        PbActivity.this.aQD();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel eGz = null;
    private com.baidu.tbadk.baseEditMark.a eal = null;
    private ForumManageModel eHo = null;
    private aq eHp = null;
    public final com.baidu.tieba.pb.pb.main.a.a eHq = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eHr = false;
    private boolean eHs = false;
    private boolean eHt = false;
    private boolean eHv = false;
    private boolean eHw = false;
    private boolean eHx = false;
    private boolean eHy = false;
    private boolean eHA = false;
    private boolean eHB = false;
    private boolean eHE = false;
    private com.baidu.tbadk.editortools.pb.b aEe = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Dx() {
            PbActivity.this.showProgressBar();
        }
    };
    private boolean eHF = false;
    private int mLastScrollState = -1;
    private int eHK = 4;
    private boolean cjD = false;
    private int eHP = -1;
    private final w.a eHQ = new w.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void B(List<PostData> list) {
            if (PbActivity.this.eGz.getPbData().aPt() != null) {
                List<PostData> list2 = PbActivity.this.eGz.getPbData().aPt().eEO;
                int size = list2.size();
                if (!com.baidu.tbadk.core.util.u.v(list2)) {
                    PbActivity.this.eGz.getPbData().aPt().eEO.addAll(size, list);
                }
                PbActivity.this.eGz.a(PbActivity.this.eGz.getPbData(), size);
            }
            PbActivity.this.eHp.aTh().a(PbActivity.this.eGz.getPbData(), true);
            if (PbActivity.this.eHp != null && PbActivity.this.eHp.aTh() != null) {
                PbActivity.this.eHp.aTh().notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eHp.showToast(str);
            }
        }
    };
    private final CustomMessageListener eHR = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eGz != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eHD != null) {
                    PbActivity.this.eHp.hh(PbActivity.this.eHD.DG());
                }
                PbActivity.this.eHp.aST();
                PbActivity.this.eHD.DJ();
                PbActivity.this.eHp.aBk();
            }
        }
    };
    CustomMessageListener cjQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.eGz.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.eHp != null && PbActivity.this.eGz != null) {
                    PbActivity.this.eHp.d(PbActivity.this.eGz.getPbData(), PbActivity.this.eGz.aRy(), PbActivity.this.eGz.aRO());
                }
                if (PbActivity.this.eHp != null && PbActivity.this.eHp.aTh() != null) {
                    PbActivity.this.eHp.aTh().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eHS = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eHp != null) {
                    if (booleanValue) {
                        PbActivity.this.eHp.avO();
                    } else {
                        PbActivity.this.eHp.avN();
                    }
                }
            }
        }
    };
    private CustomMessageListener dIZ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eHD != null) {
                    PbActivity.this.eHp.hh(PbActivity.this.eHD.DG());
                }
                PbActivity.this.eHp.hi(false);
            }
        }
    };
    private CustomMessageListener dJv = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customResponsedMessage.getData();
                switch (dVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.n) dVar.getData());
                        return;
                    case 1:
                        PbActivity.this.a((ForumManageModel.b) dVar.getData(), false);
                        return;
                    case 2:
                        if (dVar.getData() == null) {
                            PbActivity.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbActivity.this.a(true, (MarkData) dVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener eHT = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eHp != null && PbActivity.this.eHp.aTh() != null) {
                PbActivity.this.eHp.aTh().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dir = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private i.a eHU = new i.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        @Override // com.baidu.tieba.pb.pb.main.i.a
        public void i(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.oR(2);
                ai.aSJ().reset();
                PbActivity.this.eGz.aRP();
                boolean z2 = false;
                ArrayList<PostData> aPl = PbActivity.this.eGz.getPbData().aPl();
                if (aPl != null) {
                    Iterator<PostData> it = aPl.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.k(next) && next.bsG().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eHp.m(PbActivity.this.eGz.getPbData());
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
    private View.OnClickListener dIY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aDZ);
        }
    };
    CustomMessageListener cSE = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_NICK_NAME_ACT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), (String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eHV = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                as.a aVar = new as.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.WY = abVar.WY;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGz.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eGz.aRF() != null && PbActivity.this.eGz.aRF().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eHp.a(abVar.sendCount, PbActivity.this.eGz.getPbData(), PbActivity.this.eGz.aRy(), PbActivity.this.eGz.aRO());
                    }
                    if (pbData.aPl() != null && pbData.aPl().size() >= 1 && pbData.aPl().get(0) != null) {
                        long d = com.baidu.adp.lib.g.b.d(pbData.aPl().get(0).getId(), 0L);
                        long d2 = com.baidu.adp.lib.g.b.d(PbActivity.this.eGz.getThreadID(), 0L);
                        if (d == abVar.postId && d2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.as bsF = pbData.aPl().get(0).bsF();
                            if (bsF == null) {
                                bsF = new com.baidu.tbadk.core.data.as();
                            }
                            ArrayList<as.a> qG = bsF.qG();
                            if (qG == null) {
                                qG = new ArrayList<>();
                            }
                            qG.add(0, aVar);
                            bsF.bN(abVar.sendCount + bsF.qF());
                            bsF.g(qG);
                            pbData.aPl().get(0).a(bsF);
                            PbActivity.this.eHp.aTh().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eHW = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null && aVar.acx() != null && !aVar.acx().isEmpty()) {
                PbActivity.this.eHp.a(aVar, PbActivity.this.eHX);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eHX = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
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
    private boolean eHY = false;
    private PraiseModel eHZ = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hO(String str) {
            PbActivity.this.eHY = false;
            if (PbActivity.this.eHZ != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGz.getPbData();
                if (pbData.aPj().rv().getIsLike() == 1) {
                    PbActivity.this.iY(0);
                } else {
                    PbActivity.this.iY(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aPj()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void A(int i, String str) {
            PbActivity.this.eHY = false;
            if (PbActivity.this.eHZ != null && str != null) {
                if (AntiHelper.tn(i)) {
                    AntiHelper.ar(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eIa = 0;
    private boolean eIb = true;
    private b.a eIc = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void ep(boolean z) {
            PbActivity.this.ja(z);
            if (PbActivity.this.eHp.aTF() != null && z) {
                PbActivity.this.eHp.jE(false);
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
                    if (updateAttentionMessage.getData().Ea) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aPq().getAuthor() != null && PbActivity.this.aPq().getAuthor().getGodUserData() != null) {
                            PbActivity.this.aPq().getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        PbActivity.this.c(updateAttentionMessage);
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        PbActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a boQ = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eHp.QY();
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
                    com.baidu.tieba.h.a.alW();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.l.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private CustomMessageListener eId = new CustomMessageListener(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()).getId() != PbActivity.this.getUniqueId().getId()) {
                PbActivity.this.eHv = false;
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eHp.aSU()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && ((PbActivity.this.eGz == null || PbActivity.this.eGz.getPbData() == null || !com.baidu.tieba.pb.e.T(PbActivity.this.eGz.getPbData().aPj())) && PbActivity.this.eGz != null && (PbActivity.this.eGz.getPbData() != null || PbActivity.this.eGz.getPbData().aPG() != null))) {
                    if (PbActivity.this.eGz.getPbData().aPG().aPM()) {
                        if (PbActivity.this.eGz.getPbData().aPG().eEA == 1 || PbActivity.this.eGz.getPbData().aPG().eEA == 3 || PbActivity.this.eGz.getPbData().aPG().eEA == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eGz.getPbData().aPG().aPM() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eGz.getPbData().aPG().aPM() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eHf > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).startAnimation(false);
                        PbActivity.this.eHf = System.currentTimeMillis();
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
                    if (PbActivity.this.eHp != null && PbActivity.this.eHp.aQo() && (view.getId() == d.h.pb_head_user_info_root || view == PbActivity.this.eHp.aTN())) {
                        if (view.getTag(d.h.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10630").aa("obj_id", (String) view.getTag(d.h.tag_user_id)));
                        }
                        if (PbActivity.this.eHq != null && PbActivity.this.eHq.eTL != null) {
                            PbActivity.this.eHq.eTL.onClick(view);
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
            if (PbActivity.this.eHD != null) {
                PbActivity.this.eHp.hh(PbActivity.this.eHD.DG());
            }
            PbActivity.this.eHp.aST();
            PbActivity.this.eHD.DJ();
            PbActivity.this.eHp.aBk();
            return true;
        }
    });
    private CustomMessageListener eIe = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eHI) {
                PbActivity.this.eHp.QY();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGz.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aPw().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eHH.c(PbActivity.this.eHG.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eHG.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    PbActivity.this.gc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aQU();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.al.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eHG.getResources().getString(d.l.mute_fail);
                    }
                    PbActivity.this.eHH.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eIf = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eHI) {
                PbActivity.this.eHp.QY();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eHH.c(PbActivity.this.eHG.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.al.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eHG.getResources().getString(d.l.un_mute_fail);
                }
                PbActivity.this.eHH.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eIg = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eHI) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eHp.QY();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.guH;
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
                    PbActivity.this.eHp.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eIh = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eHp.aSU() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aQn() != null && PbActivity.this.aQn().getPbData() != null && PbActivity.this.aQn().getPbData().aPG() != null && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.e.T(PbActivity.this.aQn().getPbData().aPj())) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aPM = PbActivity.this.aQn().getPbData().aPG().aPM();
                if (intValue < 10) {
                    if (aPM) {
                        if (PbActivity.this.eGz.getPbData().aPG().eEA == 1 || PbActivity.this.eGz.getPbData().aPG().eEA == 3 || PbActivity.this.eGz.getPbData().aPG().eEA == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eGz.getPbData().aPG().aPM() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPM ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eHf > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).startAnimation(false);
                        PbActivity.this.eHf = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue / 11, aPM);
                TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aPM ? 0 : 1));
            }
        }
    };
    private CustomMessageListener ckb = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cjD = true;
                }
            }
        }
    };
    public a.b eoq = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.afp();
            com.baidu.tbadk.core.data.ar aqn = PbActivity.this.eGz.aqn();
            int pageNum = PbActivity.this.eHp.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.l.pb_page_error);
            } else if (aqn == null || pageNum <= aqn.qy()) {
                PbActivity.this.eHp.aBk();
                PbActivity.this.oR(2);
                PbActivity.this.afo();
                PbActivity.this.eHp.aTm();
                if (com.baidu.adp.lib.util.i.hr()) {
                    PbActivity.this.eGz.oY(PbActivity.this.eHp.getPageNum());
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(d.l.pb_page_error);
            }
        }
    };
    public final View.OnClickListener ckz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
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
            com.baidu.tieba.pb.data.m aPG;
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
                    if ((PbActivity.this.eHp.eOm.aUH() != null && PbActivity.this.eHp.eOm.aUH().be(view)) || PbActivity.this.eHp.aTg() == view || view.getId() == d.h.pb_item_tail_content) {
                        if (PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && com.baidu.tieba.pb.e.T(PbActivity.this.eGz.getPbData().aPj())) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (view == PbActivity.this.eHp.getNextView()) {
                        if (!PbActivity.this.mIsLoading && PbActivity.this.eGz.jh(true)) {
                            PbActivity.this.mIsLoading = true;
                            PbActivity.this.eHp.aTn();
                        }
                    } else if (view == PbActivity.this.eHp.aSY()) {
                        PbActivity.this.eHp.aTe();
                        if (!UtilHelper.isFloatWindowOpAllowed(PbActivity.this.getPageContext().getPageActivity())) {
                            PbActivity.this.PS();
                            return;
                        }
                        PbActivity.this.eHv = true;
                        PbActivity.this.a(PbActivity.this.eGz.getPbData(), 0, 1, true, true);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10830").aa("tid", PbActivity.this.eGz.getThreadID()));
                        PbActivity.this.eHp.aBk();
                    } else if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSw()) {
                        if (view == PbActivity.this.eHp.eOm.aMa) {
                            if (PbActivity.this.eHp.jI(PbActivity.this.eGz.aRC())) {
                                PbActivity.this.afo();
                                return;
                            }
                            PbActivity.this.eGU = false;
                            PbActivity.this.eGS = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eHp.aTk() && (PbActivity.this.eHp.eOm.aUH() == null || (view != PbActivity.this.eHp.eOm.aUH().aSv() && view != PbActivity.this.eHp.eOm.aUH().aSt()))) {
                            if (view == PbActivity.this.eHp.aTz()) {
                                if (PbActivity.this.eGz != null) {
                                    com.baidu.tbadk.browser.a.T(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGz.getPbData().aPj().rE().getLink());
                                }
                            } else if (view != PbActivity.this.eHp.eOm.eUu) {
                                if (view == PbActivity.this.eHp.eOm.eUw) {
                                    if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null) {
                                        ArrayList<PostData> aPl = PbActivity.this.eGz.getPbData().aPl();
                                        if ((aPl != null && aPl.size() > 0) || !PbActivity.this.eGz.aRy()) {
                                            if (!PbActivity.this.eHp.aTO()) {
                                                PbActivity.this.eHp.aST();
                                            }
                                            PbActivity.this.aQu();
                                            return;
                                        }
                                        com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                        return;
                                    }
                                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                } else if (view != PbActivity.this.eHp.eOm.eUv && view.getId() != d.h.pb_god_user_tip_content) {
                                    if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSf()) {
                                        if ((PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSs()) && view.getId() != d.h.floor_owner_reply && view.getId() != d.h.reply_title) {
                                            if (PbActivity.this.eHp.eOm.aUH() == null || (view != PbActivity.this.eHp.eOm.aUH().getCancelView() && view != PbActivity.this.eHp.eOm.aUH().Vu())) {
                                                if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSy()) {
                                                    if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSn()) {
                                                        if ((PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSo()) && view.getId() != d.h.pb_sort) {
                                                            if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSp()) {
                                                                if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSq()) {
                                                                    if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSr()) {
                                                                        if (PbActivity.this.eHu == null || view != PbActivity.this.eHu.aSh()) {
                                                                            if (PbActivity.this.eHu == null || view != PbActivity.this.eHu.aSf()) {
                                                                                if (PbActivity.this.eHu == null || view != PbActivity.this.eHu.aSk()) {
                                                                                    if (PbActivity.this.eHu == null || view != PbActivity.this.eHu.aSi()) {
                                                                                        if (PbActivity.this.eHu == null || view != PbActivity.this.eHu.aSj()) {
                                                                                            if (PbActivity.this.eHp.aTF() == view) {
                                                                                                if (PbActivity.this.eHp.aTF().getIndicateStatus()) {
                                                                                                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGz.getPbData();
                                                                                                    if (pbData != null && pbData.aPj() != null && pbData.aPj().rn() != null) {
                                                                                                        String pH = pbData.aPj().rn().pH();
                                                                                                        if (StringUtils.isNull(pH)) {
                                                                                                            pH = pbData.aPj().rn().getTaskId();
                                                                                                        }
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11107").aa("obj_id", pH));
                                                                                                    }
                                                                                                } else {
                                                                                                    com.baidu.tieba.tbadkCore.d.a.cg("c10725", null);
                                                                                                }
                                                                                                PbActivity.this.aQP();
                                                                                                return;
                                                                                            } else if (PbActivity.this.eHp.aTg() != view) {
                                                                                                if (PbActivity.this.eHu == null || view != PbActivity.this.eHu.aSg()) {
                                                                                                    if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSx()) {
                                                                                                        if (PbActivity.this.eHp.eOm.aUH() != null && view == PbActivity.this.eHp.eOm.aUH().aSu()) {
                                                                                                            if (com.baidu.adp.lib.util.i.hr()) {
                                                                                                                SparseArray<Object> c2 = PbActivity.this.eHp.c(PbActivity.this.eGz.getPbData(), PbActivity.this.eGz.aRy(), 1);
                                                                                                                if (c2 != null) {
                                                                                                                    PbActivity.this.eHp.a(((Integer) c2.get(d.h.tag_del_post_type)).intValue(), (String) c2.get(d.h.tag_del_post_id), ((Integer) c2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.h.tag_del_post_is_self)).booleanValue());
                                                                                                                }
                                                                                                                PbActivity.this.eHp.eOm.oq();
                                                                                                                return;
                                                                                                            }
                                                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                                                            return;
                                                                                                        } else if (view.getId() != d.h.sub_pb_more && view.getId() != d.h.sub_pb_item && view.getId() != d.h.pb_floor_reply_more) {
                                                                                                            if (view != PbActivity.this.eHp.aQh()) {
                                                                                                                if (view == PbActivity.this.eHp.eOm.aUI()) {
                                                                                                                    PbActivity.this.eHp.aTs();
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
                                                                                                                    PostData ba = PbActivity.this.ba(view);
                                                                                                                    if (ba != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", ba.bsL() ? 0 : 1));
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.view_main_thread_praise_state) {
                                                                                                                    PbActivity.this.f(view, 2, false);
                                                                                                                    if (PbActivity.this.aQn() != null && PbActivity.this.aQn().getPbData() != null && PbActivity.this.aQn().getPbData().aPG() != null && PbActivity.this.aQn().getPbData().aPG() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aQn().getPbData().aPG().aPM() ? 0 : 1));
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.view_main_thread_praise_num || id == d.h.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && !StringUtils.isNull(PbActivity.this.eGz.getPbData().getThreadId()) && (aPG = PbActivity.this.eGz.getPbData().aPG()) != null && aPG.getPraiseNum() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.at.wf().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eGz.getPbData().getThreadId()});
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.replybtn || id == d.h.cover_reply_content || id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right || id == d.h.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.h.tag_load_sub_data);
                                                                                                                            if (postData2 == null || !com.baidu.tieba.pb.e.d(postData2)) {
                                                                                                                                if (PbActivity.this.eHu == null) {
                                                                                                                                    PbActivity.this.eHu = new v(PbActivity.this.getPageContext(), PbActivity.this.ckz);
                                                                                                                                    PbActivity.this.eHu.jm(PbActivity.this.mIsLogin);
                                                                                                                                }
                                                                                                                                PbActivity.this.eHu.showDialog();
                                                                                                                                boolean z6 = id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right;
                                                                                                                                if (z6) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12006").aa("tid", PbActivity.this.eGz.eKN));
                                                                                                                                }
                                                                                                                                SparseArray sparseArray2 = new SparseArray();
                                                                                                                                sparseArray2.put(d.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.h.tag_clip_board));
                                                                                                                                sparseArray2.put(d.h.tag_is_subpb, false);
                                                                                                                                PbActivity.this.eHu.aSf().setTag(sparseArray2);
                                                                                                                                PbActivity.this.eHu.aSk().setTag(view.getTag());
                                                                                                                                PbActivity.this.eHu.jo(z6);
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
                                                                                                                                        PbActivity.this.eHu.aSi().setVisibility(0);
                                                                                                                                    } else {
                                                                                                                                        sparseArray4.put(d.h.tag_should_delete_visible, false);
                                                                                                                                        PbActivity.this.eHu.aSi().setVisibility(8);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.eHu.aSg().setTag(sparseArray4);
                                                                                                                                    PbActivity.this.eHu.aSi().setTag(sparseArray4);
                                                                                                                                    PbActivity.this.eHu.aSg().setText(d.l.bar_manager);
                                                                                                                                    PbActivity.this.eHu.aSg().setVisibility(0);
                                                                                                                                } else if (!booleanValue3) {
                                                                                                                                    PbActivity.this.eHu.aSg().setVisibility(8);
                                                                                                                                    PbActivity.this.eHu.aSi().setVisibility(8);
                                                                                                                                } else {
                                                                                                                                    SparseArray sparseArray5 = new SparseArray();
                                                                                                                                    sparseArray5.put(d.h.tag_should_manage_visible, false);
                                                                                                                                    sparseArray5.put(d.h.tag_user_mute_visible, false);
                                                                                                                                    sparseArray5.put(d.h.tag_should_delete_visible, true);
                                                                                                                                    sparseArray5.put(d.h.tag_manage_user_identity, sparseArray3.get(d.h.tag_manage_user_identity));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_id, sparseArray3.get(d.h.tag_del_post_id));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_type, sparseArray3.get(d.h.tag_del_post_type));
                                                                                                                                    PbActivity.this.eHu.aSg().setTag(sparseArray5);
                                                                                                                                    PbActivity.this.eHu.aSi().setTag(sparseArray5);
                                                                                                                                    PbActivity.this.eHu.aSg().setText(d.l.delete);
                                                                                                                                    PbActivity.this.eHu.aSi().setVisibility(0);
                                                                                                                                    PbActivity.this.eHu.aSg().setVisibility(8);
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
                                                                                                                                    PbActivity.this.eHu.aSh().setTag(sparseArray7);
                                                                                                                                    PbActivity.this.eHu.aSh().setVisibility(0);
                                                                                                                                    PbActivity.this.eHu.aSg().setVisibility(8);
                                                                                                                                    PbActivity.this.eHu.aSh().setText(d.l.mute_option);
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
                                                                                                                                    PbActivity.this.eIs = (PostData) sparseArray6.get(d.h.tag_clip_board);
                                                                                                                                    if (ap.k(PbActivity.this.eIs) ? false : iW) {
                                                                                                                                        PbActivity.this.eHu.aSh().setVisibility(0);
                                                                                                                                        PbActivity.this.eHu.aSh().setTag(str3);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.eHu.aSh().setVisibility(8);
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
                                                                                                                                    PbActivity.this.eHu.aSj().setVisibility(0);
                                                                                                                                    PbActivity.this.eHu.aSj().setTag(d.h.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                    PbActivity.this.eHu.aSj().setTag(d.h.tag_chudian_monitor_id, str);
                                                                                                                                    PbActivity.this.eHu.aSj().setTag(d.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eHu.aSj().setVisibility(8);
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eGz.getPbData().nL()) {
                                                                                                                            String nK = PbActivity.this.eGz.getPbData().nK();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.j.isEmpty(nK) && nK.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.eHu.aSf().setText(d.l.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eHu.aSf().setText(d.l.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.eHu.jn(true);
                                                                                                                                PbActivity.this.eHu.refreshUI();
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.eHu.jn(true);
                                                                                                                        PbActivity.this.eHu.refreshUI();
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.pb_act_btn) {
                                                                                                                    if (PbActivity.this.eGz.getPbData() != null && PbActivity.this.eGz.getPbData().aPj() != null && PbActivity.this.eGz.getPbData().aPj().sl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), PbActivity.this.eGz.getPbData().aPj().sl());
                                                                                                                        if (PbActivity.this.eGz.getPbData().aPj().sj() != 1) {
                                                                                                                            if (PbActivity.this.eGz.getPbData().aPj().sj() == 2) {
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
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10912").aa("fid", PbActivity.this.eGz.getPbData().getForumId()).aa("tid", PbActivity.this.eGz.getPbData().getThreadId()).aa("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.eGz.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.eHp.setSelection(0);
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
                                                                                                                        PbActivity.this.eHp.aST();
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aQs() == 1) {
                                                                                                                            if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10397").aa("fid", PbActivity.this.eGz.getPbData().getForumId()).aa("tid", PbActivity.this.eGz.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else if (PbActivity.this.aQs() == 2 && PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10401").aa("fid", PbActivity.this.eGz.getPbData().getForumId()).aa("tid", PbActivity.this.eGz.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
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
                                                                                                                            if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10507").aa("fid", PbActivity.this.eGz.getPbData().getForumId()).aa("tid", PbActivity.this.eGz.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else if (PbActivity.this.aQs() == 2 && PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10508").aa("fid", PbActivity.this.eGz.getPbData().getForumId()).aa("tid", PbActivity.this.eGz.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.manga_prev_btn) {
                                                                                                                    PbActivity.this.aQK();
                                                                                                                    return;
                                                                                                                } else if (id == d.h.manga_next_btn) {
                                                                                                                    PbActivity.this.aQL();
                                                                                                                    return;
                                                                                                                } else if (id == d.h.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && PbActivity.this.eGz.getPbData().aPB() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eGz.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11679").aa("fid", pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.at.wf().c(PbActivity.this.getPageContext(), new String[]{pbData2.aPB().aPI()});
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.yule_head_img_all_rank && PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && PbActivity.this.eGz.getPbData().aPB() != null) {
                                                                                                                    com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eGz.getPbData();
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11678").aa("fid", pbData3.getForumId()));
                                                                                                                    com.baidu.tbadk.core.util.at.wf().c(PbActivity.this.getPageContext(), new String[]{pbData3.aPB().aPI()});
                                                                                                                    return;
                                                                                                                } else {
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.eGz.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.eGz.getThreadID(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eGz.getPbData().aPj().rZ())));
                                                                                                                return;
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                            if (PbActivity.this.eGz.getPbData() != null) {
                                                                                                                PbActivity.this.eHp.aBk();
                                                                                                                SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                PostData postData3 = (PostData) sparseArray9.get(d.h.tag_load_sub_data);
                                                                                                                View view2 = (View) sparseArray9.get(d.h.tag_load_sub_view);
                                                                                                                if (postData3 != null && view2 != null) {
                                                                                                                    String threadID = PbActivity.this.eGz.getThreadID();
                                                                                                                    String id2 = postData3.getId();
                                                                                                                    int i3 = 0;
                                                                                                                    if (PbActivity.this.eGz.getPbData() != null) {
                                                                                                                        i3 = PbActivity.this.eGz.getPbData().aPu();
                                                                                                                    }
                                                                                                                    if (!com.baidu.tieba.pb.e.d(postData3)) {
                                                                                                                        PbActivity.this.afo();
                                                                                                                        if (view.getId() == d.h.replybtn) {
                                                                                                                            b po = PbActivity.this.po(id2);
                                                                                                                            if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && po != null) {
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i3, postData3.aVI(), PbActivity.this.eGz.getPbData().qr(), false, postData3.getAuthor().getIconInfo()).addBigImageData(po.eIW, po.eIX, po.eIY, po.index)));
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
                                                                                                                            b po2 = PbActivity.this.po(id2);
                                                                                                                            if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && po2 != null && PbActivity.this.aQm().aSR() != null) {
                                                                                                                                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                                                                                                                                nVar.b(PbActivity.this.eGz.getPbData().aPh());
                                                                                                                                nVar.U(PbActivity.this.eGz.getPbData().aPj());
                                                                                                                                nVar.f(postData4);
                                                                                                                                PbActivity.this.aQm().aSR().d(nVar);
                                                                                                                                PbActivity.this.aQm().aSR().setPostId(str7);
                                                                                                                                PbActivity.this.a(view, str6, str5);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            b po3 = PbActivity.this.po(id2);
                                                                                                                            if (postData3 != null && PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && po3 != null) {
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i3, postData3.aVI(), PbActivity.this.eGz.getPbData().qr(), false, postData3.getAuthor().getIconInfo()).addBigImageData(po3.eIW, po3.eIX, po3.eIY, po3.index)));
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
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 3).aa("fid", PbActivity.this.eGz.getPbData().getForumId()));
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (com.baidu.adp.lib.util.i.hr()) {
                                                                                                        PbActivity.this.eHp.aBk();
                                                                                                        SparseArray<Object> c3 = PbActivity.this.eHp.c(PbActivity.this.eGz.getPbData(), PbActivity.this.eGz.aRy(), 1);
                                                                                                        if (c3 != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGz.getPbData().aPh().getId(), PbActivity.this.eGz.getPbData().aPh().getName(), PbActivity.this.eGz.getPbData().aPj().getId(), String.valueOf(PbActivity.this.eGz.getPbData().getUserData().getUserId()), (String) c3.get(d.h.tag_forbid_user_name), (String) c3.get(d.h.tag_forbid_user_post_id))));
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
                                                                                                        if (!com.baidu.tieba.c.a.Vm() || sparseArray11.get(d.h.tag_del_post_id) == null || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eGz.getThreadID(), (String) sparseArray11.get(d.h.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.eHp.bf(view);
                                                                                                                return;
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.eHp.a(((Integer) sparseArray11.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.h.tag_del_post_id), ((Integer) sparseArray11.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.h.tag_del_post_is_self)).booleanValue());
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", PbActivity.this.eGz.getPbData().getForumId()));
                                                                                                return;
                                                                                            } else {
                                                                                                PbActivity.this.aQj();
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
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eGz.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aPh() != null) {
                                                                                            str9 = pbData4.aPh().getId();
                                                                                            str10 = pbData4.aPh().getName();
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
                                                                                        if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.Vm() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eGz.getThreadID(), (String) sparseArray12.get(d.h.tag_del_post_id))) {
                                                                                            PbActivity.this.eHp.a(((Integer) sparseArray12.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.h.tag_del_post_id), intValue, booleanValue7);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                if (PbActivity.this.eHu.aSm()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12007").aa("tid", PbActivity.this.eGz.eKN));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eGz.getPbData() != null) {
                                                                                    PbActivity.this.eHp.aBk();
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
                                                                                        String threadID2 = PbActivity.this.eGz.getThreadID();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.eGz.getPbData() != null) {
                                                                                            i5 = PbActivity.this.eGz.getPbData().aPu();
                                                                                        }
                                                                                        PbActivity.this.afo();
                                                                                        b po4 = PbActivity.this.po(id3);
                                                                                        if (po4 != null) {
                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID2, id3, "pb", true, null, true, null, i5, postData.aVI(), PbActivity.this.eGz.getPbData().qr(), false, postData.getAuthor().getIconInfo()).addBigImageData(po4.eIW, po4.eIX, po4.eIY, po4.index)));
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
                                                                        if (!com.baidu.adp.lib.util.i.hr()) {
                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                            return;
                                                                        }
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            PbActivity.this.pl((String) tag);
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
                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), null, PbActivity.this.aQr(), true)));
                                                                    PbActivity.this.eHp.eOm.oq();
                                                                    PbActivity.this.eHp.eOm.aUH().aSz();
                                                                    return;
                                                                }
                                                                TiebaStatic.log("c10414");
                                                                PbActivity.this.eHp.aBk();
                                                                if (PbActivity.this.eHp.rs() == aq.eQc) {
                                                                    PbActivity.this.eHp.aTE();
                                                                    return;
                                                                } else if (PbActivity.this.eGz.aRW() != null) {
                                                                    PbActivity.this.eGz.aRW().oW(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                                                    return;
                                                                } else {
                                                                    return;
                                                                }
                                                            } else if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && PbActivity.this.eGz.getPbData().aPj() != null) {
                                                                PbActivity.this.eHp.eOm.oq();
                                                                PbActivity.this.pl(PbActivity.this.eGz.getPbData().aPj().rV());
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        PbActivity.this.eHp.aBk();
                                                        if (com.baidu.adp.lib.util.i.hr()) {
                                                            PbActivity.this.oR(2);
                                                            PbActivity.this.afo();
                                                            PbActivity.this.eHp.aTm();
                                                            PbActivity.this.eHp.aTh().jb(true);
                                                            boolean z7 = false;
                                                            if (!(view.getTag() instanceof Boolean)) {
                                                                PbActivity.this.eGz.aRI();
                                                            } else {
                                                                z7 = PbActivity.this.eGz.jj(!((Boolean) view.getTag()).booleanValue());
                                                            }
                                                            TiebaStatic.log("c12097");
                                                            if (z7 && PbActivity.this.getListView() != null) {
                                                                if (PbActivity.this.eHK > PbActivity.this.getListView().getFirstVisiblePosition()) {
                                                                    PbActivity.this.eHK = PbActivity.this.getListView().getFirstVisiblePosition();
                                                                }
                                                                View childAt = PbActivity.this.getListView().getChildAt(0);
                                                                int i6 = -1;
                                                                if (childAt != null) {
                                                                    i6 = childAt.getTop();
                                                                }
                                                                PbActivity.this.aQm().i(PbActivity.this.eHK, i6);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                        return;
                                                    }
                                                    PbActivity.this.eHp.aBk();
                                                    if (PbActivity.this.eGz.aqn() != null) {
                                                        PbActivity.this.eHp.a(PbActivity.this.eGz.aqn(), PbActivity.this.eoq);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    return;
                                                } else if (PbActivity.this.checkUpIsLogin()) {
                                                    if (com.baidu.adp.lib.util.k.hI()) {
                                                        PbActivity.this.eHp.aBk();
                                                        PbActivity.this.afo();
                                                        PbActivity.this.oR(2);
                                                        if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && PbActivity.this.eGz.getPbData().aPB() != null && !StringUtils.isNull(PbActivity.this.eGz.getPbData().aPB().pV(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11678").aa("fid", PbActivity.this.eGz.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11939"));
                                                        PbActivity.this.eHp.QX();
                                                        PbActivity.this.eGz.aRZ().p(CheckRealNameModel.TYPE_PB_SHARE, Integer.valueOf(view == PbActivity.this.eHp.ePL ? 1 : 2));
                                                        return;
                                                    }
                                                    PbActivity.this.showToast(d.l.neterror);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            PbActivity.this.eHp.eOm.oq();
                                        } else if (com.baidu.adp.lib.util.i.hr()) {
                                            PbActivity.this.eHp.aBk();
                                            if (PbActivity.this.eHp.eOm.aUH() != null && view == PbActivity.this.eHp.eOm.aUH().aSs() && !PbActivity.this.eHp.aTO()) {
                                                PbActivity.this.eHp.aST();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.eHp.eOm.eUv.setEnabled(false);
                                                PbActivity.this.afo();
                                                PbActivity.this.eHp.aTm();
                                                if (view.getId() == d.h.floor_owner_reply) {
                                                    i2 = PbActivity.this.eGz.i(true, PbActivity.this.aQI());
                                                } else {
                                                    i2 = view.getId() == d.h.reply_title ? PbActivity.this.eGz.i(false, PbActivity.this.aQI()) : PbActivity.this.eGz.pr(PbActivity.this.aQI());
                                                }
                                                if (i2) {
                                                    PbActivity.this.eHp.avO();
                                                    PbActivity.this.mIsLoading = true;
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.oR(2);
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.l.network_not_available);
                                        }
                                    } else if (com.baidu.adp.lib.util.i.hr()) {
                                        PbActivity.this.eHp.aBk();
                                        if (PbActivity.this.oQ(11009) && PbActivity.this.eGz.pf(PbActivity.this.eHp.aTr()) != null) {
                                            PbActivity.this.aQC();
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.l.network_not_available);
                                    }
                                } else if (com.baidu.adp.lib.util.i.hr()) {
                                    PbActivity.this.eHp.je(true);
                                    PbActivity.this.eHp.aST();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eHp.eOm.eUv.setEnabled(false);
                                        PbActivity.this.eHp.avO();
                                        PbActivity.this.afo();
                                        PbActivity.this.eHp.aTm();
                                        PbActivity.this.eGz.pr(PbActivity.this.aQI());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.oR(2);
                                    }
                                } else {
                                    PbActivity.this.showToast(d.l.network_not_available);
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.eGz.getPbData() != null && PbActivity.this.eGz.getPbData().aPj() != null && PbActivity.this.eGz.getPbData().aPj().ss() && PbActivity.this.eGz.getPbData().aPj().rW() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11922"));
                                }
                                if (PbActivity.this.eGz.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eGz.aRx()) && PbActivity.this.eGz.getAppealInfo() != null) {
                                        name = PbActivity.this.eGz.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eGz.getPbData().aPh().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aRx = PbActivity.this.eGz.aRx();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eGz.aRz() && aRx != null && aRx.equals(name)) {
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
                            if (PbActivity.this.eGz.getPbData().aPu() == 1 && !PbActivity.this.eHo.btk()) {
                                PbActivity.this.eHp.aBk();
                                int i7 = 0;
                                if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSt()) {
                                    if (PbActivity.this.eHp.eOm.aUH() == null || view != PbActivity.this.eHp.eOm.aUH().aSv()) {
                                        if (view == PbActivity.this.eHp.aTk()) {
                                            i7 = 2;
                                        }
                                    } else if (PbActivity.this.eGz.getPbData().aPj().rB() == 1) {
                                        i7 = 3;
                                    } else {
                                        i7 = 6;
                                    }
                                } else if (PbActivity.this.eGz.getPbData().aPj().rA() == 1) {
                                    i7 = 5;
                                } else {
                                    i7 = 4;
                                }
                                ForumData aPh = PbActivity.this.eGz.getPbData().aPh();
                                String name2 = aPh.getName();
                                String id4 = aPh.getId();
                                String id5 = PbActivity.this.eGz.getPbData().aPj().getId();
                                if (!com.baidu.tieba.c.a.Vm() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eHp.aTj();
                                    PbActivity.this.eHo.a(id4, name2, id5, i7, PbActivity.this.eHp.aTl());
                                }
                            }
                        } else {
                            PbActivity.this.showToast(d.l.network_not_available);
                        }
                    } else if (com.baidu.adp.lib.util.i.hr()) {
                        PbActivity.this.eHp.aBk();
                        PbActivity.this.afo();
                        PbActivity.this.eHp.aTm();
                        PbActivity.this.eHp.QX();
                        PbActivity.this.eGz.oY(1);
                    } else {
                        PbActivity.this.showToast(d.l.network_not_available);
                    }
                } else if (PbActivity.this.eHd) {
                    PbActivity.this.eHd = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.h.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && PbActivity.this.aQm().aSR() != null && postData5.getAuthor() != null && postData5.bsy() != 1 && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.e.d(postData5)) {
                                com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                                nVar2.b(PbActivity.this.eGz.getPbData().aPh());
                                nVar2.U(PbActivity.this.eGz.getPbData().aPj());
                                nVar2.f(postData5);
                                PbActivity.this.aQm().aSR().d(nVar2);
                                PbActivity.this.aQm().aSR().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.getAuthor().getUserId(), "");
                                TiebaStatic.log("c11743");
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aEl = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.afo();
            PbActivity.this.eHp.jF(z);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbActivity.this.eHp.aBk();
                if (PbActivity.this.eHD != null) {
                    PbActivity.this.eHp.hh(PbActivity.this.eHD.DG());
                }
                PbActivity.this.eHp.aSQ();
                PbActivity.this.eHp.hi(true);
                PbActivity.this.eGz.aRL();
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eGz.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGz.getPbData();
                            if (pbData != null && pbData.aPj() != null && pbData.aPj().getAuthor() != null && (userId = pbData.aPj().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && PbActivity.this.eGz.aRE()) {
                                PbActivity.this.eHp.aTm();
                            }
                        } else if (PbActivity.this.eGz.aRE()) {
                            PbActivity.this.eHp.aTm();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eHp.m(PbActivity.this.eGz.getPbData());
                    }
                    if (PbActivity.this.eGz.aRB()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10369").aa("tid", PbActivity.this.eGz.getThreadID()));
                    }
                }
            } else if (qVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    private final PbModel.a eIi = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eC;
            if (!z || fVar == null || fVar.aPs() != null || com.baidu.tbadk.core.util.u.u(fVar.aPl()) >= 1) {
                PbActivity.this.edZ = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eHp.aTo();
                if (fVar == null || !fVar.aPp()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eHp.getView());
                } else if (PbActivity.this.eHp.aSO() == null) {
                    PbActivity.this.eHF = true;
                }
                PbActivity.this.eHp.avN();
                PbActivity.this.eHp.aTi();
                if (PbActivity.this.eHi || PbActivity.this.eHp.aTO()) {
                    PbActivity.this.eHp.aTC();
                } else {
                    PbActivity.this.eHp.hi(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                    PbActivity.this.eHp.eOm.eUv.setEnabled(true);
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eHy = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eHp.Nr();
                    PbActivity.this.eHp.jK(fVar.aPp());
                    if (fVar.aPj() != null && fVar.aPj().sB() != null) {
                        PbActivity.this.a(fVar.aPj().sB());
                    }
                    if (PbActivity.this.eHD != null) {
                        PbActivity.this.eHp.hh(PbActivity.this.eHD.DG());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aPl() != null && fVar.aPl().size() >= 1 && fVar.aPl().get(0) != null) {
                        PbActivity.this.eGz.pt(fVar.aPl().get(0).getId());
                    } else if (fVar.aPs() != null) {
                        PbActivity.this.eGz.pt(fVar.aPs().getId());
                    }
                    if (PbActivity.this.eHD != null) {
                        PbActivity.this.eHD.a(fVar.qr());
                        PbActivity.this.eHD.a(fVar.aPh(), fVar.getUserData());
                        PbActivity.this.eHD.a(PbActivity.this.eGz.aRF(), PbActivity.this.eGz.getThreadID(), PbActivity.this.eGz.aSb());
                        if (fVar.aPj() != null) {
                            PbActivity.this.eHD.bL(fVar.aPj().sR());
                        }
                    }
                    if (PbActivity.this.eal != null) {
                        PbActivity.this.eal.ac(fVar.nL());
                    }
                    if (fVar == null || fVar.aPv() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eHp.jJ(PbActivity.this.mIsFromCDN);
                    if (PbActivity.this.eHv) {
                        PbActivity.this.a(PbActivity.this.eGz.getPbData(), -1, 0, false, true);
                    } else if (PbActivity.this.eHw && !PbActivity.this.eHx) {
                        PbActivity.this.a(PbActivity.this.eGz.getPbData(), -1, false, true);
                        PbActivity.this.eHx = true;
                        PbActivity.this.eHv = true;
                    }
                    PbActivity.this.eHp.a(fVar, i2, i3, PbActivity.this.eGz.aRy(), i4, PbActivity.this.eGz.getIsFromMark());
                    PbActivity.this.eHp.e(fVar, PbActivity.this.eGz.aRy());
                    PbActivity.this.eHp.jH(PbActivity.this.eGz.getHostMode());
                    if (PbActivity.this.eGz.aRU() != null) {
                        PbActivity.this.eHp.jG(PbActivity.this.eGz.aRU().aRt());
                    }
                    AntiData qr = fVar.qr();
                    if (qr != null) {
                        PbActivity.this.aDZ = qr.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aDZ) && PbActivity.this.eHD != null && PbActivity.this.eHD.Da() != null && (eC = PbActivity.this.eHD.Da().eC(6)) != null && !TextUtils.isEmpty(PbActivity.this.aDZ)) {
                            ((View) eC).setOnClickListener(PbActivity.this.dIY);
                        }
                    }
                    com.baidu.tieba.pb.e.pb(fVar.eEp);
                    if (PbActivity.this.eHA) {
                        PbActivity.this.eHA = false;
                        PbActivity.this.aQm().getListView().setSelection(PbActivity.this.aQw());
                    }
                    if (PbActivity.this.eHB) {
                        PbActivity.this.eHB = false;
                        int aQw = PbActivity.this.aQw();
                        if (aQw == -1) {
                            aQw = PbActivity.this.aQx();
                        }
                        if (PbActivity.this.aQm() != null && PbActivity.this.aQm().getListView() != null) {
                            PbActivity.this.aQm().getListView().setSelection(aQw);
                        }
                    }
                    PbActivity.this.eGz.a(fVar.aPh(), PbActivity.this.eHW);
                } else if (str != null) {
                    if (!PbActivity.this.eHy && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eGz != null && PbActivity.this.eGz.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eGz.getAppealInfo().eDK)) {
                                    PbActivity.this.eHp.a(PbActivity.this.eGz.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eHp.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eHp.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                            }
                            PbActivity.this.eHp.aTC();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i != -1) {
                        PbActivity.this.eHp.pv(PbActivity.this.getResources().getString(d.l.list_no_more_new));
                    } else {
                        PbActivity.this.eHp.pv("");
                    }
                    PbActivity.this.eHp.wX();
                }
                PbActivity.this.aKi = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aQn().aRy() || PbActivity.this.aQn().getPbData().qH().qE() != 0 || PbActivity.this.aQn().aRS()) {
                    PbActivity.this.eHE = true;
                    return;
                }
                return;
            }
            PbActivity.this.eGz.oY(1);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void c(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eHp.m(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.r.Gz().GA()) {
                com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m(i, z, responsedMessage, PbActivity.this.aKa, PbActivity.this.createTime, PbActivity.this.aKi, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.bYB : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aKa = 0L;
                if (mVar != null) {
                    mVar.Gu();
                }
            }
        }
    };
    private CustomMessageListener eIj = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aQs() == 1) {
                    PbActivity.this.aQA();
                }
                PbActivity.this.aQt();
            }
        }
    };
    private CustomMessageListener eIk = new CustomMessageListener(CmdConfigCustom.CMD_TTS_OPTION_PB) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
                com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
                if (aVar.tag == PbActivity.this.getUniqueId()) {
                    switch (aVar.eWK) {
                        case 0:
                            if (PbActivity.this.mIsLogin) {
                                if (PbActivity.this.eGz.jh(false)) {
                                    PbActivity.this.eHp.aTn();
                                    return;
                                } else if (PbActivity.this.eGz.getPbData() != null) {
                                    PbActivity.this.eHp.aTA();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        case 1:
                            if (!PbActivity.this.mIsLoading) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.eHp.eOm.eUv.setEnabled(false);
                                PbActivity.this.eHp.avO();
                                PbActivity.this.afo();
                                PbActivity.this.eHp.aTm();
                                PbActivity.this.eGz.pr(PbActivity.this.aQI());
                                return;
                            }
                            return;
                        case 2:
                            if (PbActivity.this.eGT) {
                                boolean hostMode = PbActivity.this.eGz.getHostMode();
                                boolean aRy = PbActivity.this.eGz.aRy();
                                String threadID = PbActivity.this.eGz.getThreadID();
                                String str = aVar.postId;
                                int i2 = aVar.eWL;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(PbActivity.this.getPageContext().getPageActivity());
                                pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aRy, null);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                                PbActivity.this.eHv = false;
                                PbActivity.this.finish();
                                return;
                            }
                            int i3 = aVar.eWL;
                            if (PbActivity.this.eGz.getHostMode()) {
                                i = i3 + 3;
                            } else {
                                i = i3 + 2;
                            }
                            PbActivity.this.eHp.getListView().setSelection(i);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    };
    private final a.InterfaceC0038a eIl = new a.InterfaceC0038a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0038a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eHp.aTo();
            if (z) {
                if (PbActivity.this.eal != null) {
                    PbActivity.this.eal.ac(z2);
                }
                PbActivity.this.eGz.jk(z2);
                if (PbActivity.this.eGz.nL()) {
                    PbActivity.this.aQD();
                } else {
                    PbActivity.this.eHp.m(PbActivity.this.eGz.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.eal != null) {
                        if (PbActivity.this.eal.nO() != null) {
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
                if (PbActivity.this.eHp != null) {
                    PbActivity.this.eHp.aBk();
                    if (PbActivity.this.eHD != null && !PbActivity.this.eHp.aSU()) {
                        PbActivity.this.eHp.hh(PbActivity.this.eHD.DG());
                    }
                    PbActivity.this.eHp.aST();
                }
                if (!PbActivity.this.eGZ) {
                    PbActivity.this.eGZ = true;
                    PbActivity.this.eHp.aTB();
                }
            }
            PbActivity.this.eHp.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eGR != null) {
                PbActivity.this.eGR.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eHa == null) {
                PbActivity.this.eHa = new com.baidu.tbadk.l.d();
                PbActivity.this.eHa.fi(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && PbActivity.this.eGz.getPbData().aPj() != null && PbActivity.this.eGz.getPbData().aPj().ss()) {
                    z = false;
                }
                if (PbActivity.this.eHp.aTh() != null && z) {
                    PbActivity.this.eHp.aTh().notifyDataSetChanged();
                }
                PbActivity.this.eHa.Gg();
            } else if (i == 1) {
                PbActivity.this.eHa.Gg();
            } else {
                PbActivity.this.eHa.Gg();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aPl;
            if (PbActivity.this.eGz != null && PbActivity.this.eGz.getPbData() != null && PbActivity.this.eHp != null && PbActivity.this.eHp.aTh() != null) {
                PbActivity.this.eHp.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eGR != null) {
                    PbActivity.this.eGR.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eGz.aRN() && (aPl = PbActivity.this.eGz.getPbData().aPl()) != null && !aPl.isEmpty()) {
                    int aRi = ((i + i2) - PbActivity.this.eHp.aTh().aRi()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGz.getPbData();
                    if (pbData != null) {
                        if (pbData.aPm() != null && pbData.aPm().hasData()) {
                            aRi--;
                        }
                        if (pbData.aPn() != null && pbData.aPn().hasData()) {
                            aRi--;
                        }
                        if (PbActivity.this.eHc) {
                            aRi--;
                        }
                        int size = aPl.size();
                        if (aRi < 0 || aRi >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eIm = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.adp.base.d
        public void g(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eHo.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eGz.aRL();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cHN || bVar.eWc <= 0 || bVar.gke == 0) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eHp.a(1, dVar.Cm, dVar.gkg, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eHo.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eHp.a(PbActivity.this.eHo.getLoadDataMode(), fVar.Cm, fVar.gkg, false);
                        PbActivity.this.eHp.am(fVar.gki);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eHp.a(PbActivity.this.eHo.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final c eIn = new c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
    };
    private final k.b baw = new k.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aQJ()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eGz.ji(true)) {
                PbActivity.this.eHp.aTp();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eIp = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eIo && PbActivity.this.aQJ()) {
                PbActivity.this.aQL();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eGz.jh(false)) {
                    PbActivity.this.eHp.aTn();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eGz.getPbData() != null) {
                    PbActivity.this.eHp.aTA();
                }
                PbActivity.this.eIo = true;
            }
        }
    };
    private int eIq = 0;
    private final TbRichTextView.e aRM = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
        public void a(View view, String str, int i) {
            TbRichTextData tbRichTextData;
            try {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                b bVar = new b();
                PbActivity.this.a(str, i, bVar);
                if (bVar.eJa) {
                    TbRichText ao = PbActivity.this.ao(str, i);
                    if (ao != null && (tbRichTextData = ao.Io().get(PbActivity.this.eIq)) != null && tbRichTextData.Iz() != null && tbRichTextData.Iz().memeInfo != null && !TextUtils.isEmpty(tbRichTextData.Iz().memeInfo.detail_link)) {
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextData.Iz().memeInfo.detail_link)));
                    }
                } else if (!bVar.eIZ) {
                    ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eIW, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eIY, bVar.eIW.get(0), PbActivity.this.eGz.aRJ(), bVar.eIX, true, false, PbActivity.this.eGz.getHostMode());
                    createConfig.getIntent().putExtra("from", "pb");
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                } else {
                    TbRichText ao2 = PbActivity.this.ao(str, i);
                    if (ao2 != null && PbActivity.this.eIq >= 0 && PbActivity.this.eIq < ao2.Io().size()) {
                        String c2 = com.baidu.tieba.pb.data.g.c(ao2.Io().get(PbActivity.this.eIq));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= bVar.eIW.size()) {
                                break;
                            } else if (!bVar.eIW.get(i3).equals(c2)) {
                                i2 = i3 + 1;
                            } else {
                                bVar.index = i3;
                                break;
                            }
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eIW, bVar.index, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eIY, bVar.lastId, PbActivity.this.eGz.aRJ(), bVar.eIX, true, false, PbActivity.this.eGz.getHostMode());
                        createConfig2.getIntent().putExtra("from", "pb");
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eIr = false;
    PostData eIs = null;
    private final b.InterfaceC0043b eIt = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eIs != null) {
                if (i == 0) {
                    PbActivity.this.eIs.bN(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eIs = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.h(PbActivity.this.eIs);
                }
            }
        }
    };
    private final b.InterfaceC0043b eIu = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eHM != null && !TextUtils.isEmpty(PbActivity.this.eHN)) {
                if (i == 0) {
                    if (PbActivity.this.eHO == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eHN));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eHN;
                        aVar.pkgId = PbActivity.this.eHO.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eHO.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eHL == null) {
                        PbActivity.this.eHL = new at(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eHL.h(PbActivity.this.eHN, PbActivity.this.eHM.la());
                }
                PbActivity.this.eHM = null;
                PbActivity.this.eHN = null;
            }
        }
    };
    private final View.OnLongClickListener awn = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eHM = ((TbImageView) view).getBdImage();
                PbActivity.this.eHN = ((TbImageView) view).getUrl();
                if (PbActivity.this.eHM != null && !TextUtils.isEmpty(PbActivity.this.eHN)) {
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eHO = null;
                    } else {
                        PbActivity.this.eHO = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eHp.a(PbActivity.this.eIu, PbActivity.this.eHM.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eIs = (PostData) sparseArray.get(d.h.tag_clip_board);
                    if (PbActivity.this.eIs != null && PbActivity.this.eal != null) {
                        PbActivity.this.eHp.a(PbActivity.this.eIt, PbActivity.this.eal.nL() && PbActivity.this.eIs.getId() != null && PbActivity.this.eIs.getId().equals(PbActivity.this.eGz.rO()), ((Boolean) sparseArray.get(d.h.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a bEV = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!PbActivity.this.eGT && z && !PbActivity.this.eGz.aRD()) {
                PbActivity.this.VF();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
        }
    };
    public View.OnTouchListener aMS = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).app()) {
                        break;
                    }
                }
            }
            PbActivity.this.cma.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0079a bWf = new a.InterfaceC0079a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        final int byc;

        {
            this.byc = (int) PbActivity.this.getResources().getDimension(d.f.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0079a
        public void ah(int i, int i2) {
            if (Y(i2) && PbActivity.this.eHp != null && PbActivity.this.eGR != null) {
                PbActivity.this.eGR.en(false);
                PbActivity.this.eGR.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0079a
        public void ai(int i, int i2) {
            if (Y(i2) && PbActivity.this.eHp != null && PbActivity.this.eGR != null) {
                PbActivity.this.eGR.en(true);
                if (Math.abs(i2) > this.byc) {
                    PbActivity.this.eGR.hideFloatingView();
                }
                if (PbActivity.this.aQJ()) {
                    PbActivity.this.eHp.aTc();
                    PbActivity.this.eHp.aTd();
                }
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eIv = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tieba.e.b.a
        public void ee(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aQa();
            } else {
                com.baidu.tieba.pb.a.b.aPZ();
            }
        }
    };
    private String eIw = null;
    private final m.a eIx = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.l.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eIw = str2;
                PbActivity.this.eHp.pw(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eIy = -1;
    private int eIz = -1;
    private CustomMessageListener eIC = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.TY == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0041a) {
                    if (aVar.TZ != null && !aVar.TZ.hasError() && aVar.TZ.getError() == 0) {
                        if (PbActivity.this.eHp != null) {
                            PbActivity.this.eHp.w(((a.C0041a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aQV();
                        }
                    } else if (z) {
                        if (aVar.TZ != null && aVar.TZ.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.TZ.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.TZ != null && !aVar.TZ.hasError() && aVar.TZ.getError() == 0) {
                        if (PbActivity.this.eHp != null && PbActivity.this.eHp != null) {
                            PbActivity.this.eHp.w(((a.C0041a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.TZ != null && aVar.TZ.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.TZ.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.TZ == null || aVar.TZ.hasError() || aVar.TZ.getError() != 0) {
                        if (z) {
                            if (aVar.TZ != null && aVar.TZ.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.TZ.getErrorString());
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
    private final CustomMessageListener cjU = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
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
    private d.b Kf = new d.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
        @Override // com.baidu.adp.widget.d.b
        public void ly() {
            PbActivity.this.eHp.aTQ();
        }

        @Override // com.baidu.adp.widget.d.b
        public void W(boolean z) {
            if (z) {
                PbActivity.this.eHp.aTR();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> eIW;
        public ConcurrentHashMap<String, ImageUrlData> eIX;
        public boolean eIZ;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eIY = false;
        public boolean eJa = false;
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
        return this.eHD;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        if (nVar.aPR() != null) {
            String id = nVar.aPR().getId();
            ArrayList<PostData> aPl = this.eGz.getPbData().aPl();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aPl.size()) {
                    break;
                }
                PostData postData = aPl.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aPV = nVar.aPV();
                    postData.th(nVar.getTotalCount());
                    if (postData.bsv() != null) {
                        postData.bsv().clear();
                        postData.bsv().addAll(aPV);
                    }
                }
            }
            this.eHp.m(this.eGz.getPbData());
            c(nVar);
        }
    }

    public void aQj() {
        com.baidu.tieba.pb.data.f pbData;
        bl aPj;
        if (!this.eHY) {
            if (!com.baidu.adp.lib.util.k.hI()) {
                showToast(d.l.no_network_guide);
            } else if (this.eIb) {
                this.eHY = true;
                if (this.eGz != null && (pbData = this.eGz.getPbData()) != null && (aPj = pbData.aPj()) != null) {
                    int isLike = aPj.rv() == null ? 0 : aPj.rv().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10796").aa("tid", aPj.getId()));
                    }
                    if (this.eHZ != null) {
                        this.eHZ.a(aPj.rV(), aPj.getId(), isLike, "pb");
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
                                    PbActivity.this.eHp.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eHI);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eHI);
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
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eHI);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eHI);
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
    public void iY(int i) {
        bl aPj;
        String str;
        String z;
        if (this.eGz != null && this.eGz.getPbData() != null && (aPj = this.eGz.getPbData().aPj()) != null) {
            if (i == 1) {
                PraiseData rv = aPj.rv();
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
                        aPj.a(praiseData);
                    } else {
                        aPj.rv().getUser().add(0, metaData);
                        aPj.rv().setNum(aPj.rv().getNum() + 1);
                        aPj.rv().setIsLike(i);
                    }
                }
                if (aPj.rv() != null) {
                    if (aPj.rv().getNum() < 1) {
                        z = getResources().getString(d.l.frs_item_praise_text);
                    } else {
                        z = com.baidu.tbadk.core.util.al.z(aPj.rv().getNum());
                    }
                    this.eHp.S(z, true);
                }
            } else if (aPj.rv() != null) {
                aPj.rv().setIsLike(i);
                aPj.rv().setNum(aPj.rv().getNum() - 1);
                ArrayList<MetaData> user = aPj.rv().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aPj.rv().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aPj.rv().getNum() < 1) {
                    str = getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = aPj.rv().getNum() + "";
                }
                this.eHp.S(str, false);
            }
            if (this.eGz.aRy()) {
                this.eHp.aTh().notifyDataSetChanged();
            } else {
                this.eHp.n(this.eGz.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.adp.framework.message.Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().asQ && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eGz != null && this.eGz.getPbData() != null && this.eHp != null) {
            this.eHp.d(this.eGz.getPbData(), this.eGz.aRy(), this.eGz.aRO());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eGz.r(bundle);
        if (this.ciW != null) {
            this.ciW.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eHD.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eHG = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.bYB = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eHj = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eHj)) {
                this.eGS = true;
            }
            this.eIy = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eIz = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eIA = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eHw = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.eHA = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eHB = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aQJ()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.al.isEmpty(this.source) ? "" : this.source;
            this.eHP = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.eHe = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.bYB = System.currentTimeMillis();
        }
        this.eGY = System.currentTimeMillis();
        this.aKa = this.eGY - this.bYB;
        super.onCreate(bundle);
        this.mSwipeBackLayout.setOnSlidingStateChangeListener(this.Kf);
        this.eGV = 0;
        t(bundle);
        if (this.eGz != null && this.eGz.getPbData() != null) {
            this.eGz.getPbData().ph(this.source);
        }
        initUI();
        if (intent != null && this.eHp != null) {
            this.eHp.eOc = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eHJ == null) {
                    this.eHJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eHp.py("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eHJ, 1500L);
            }
        }
        this.ciW = new VoiceManager();
        this.ciW.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
        dVar.setForumName(this.eGz.aRx());
        if (this.eGz.getPbData() != null && this.eGz.getPbData().aPh() != null) {
            dVar.setForumId(this.eGz.getPbData().aPh().getId());
        }
        dVar.setFrom("pb");
        dVar.a(this.eGz);
        this.eHD = (com.baidu.tbadk.editortools.pb.c) dVar.aR(getActivity());
        this.eHD.d(this);
        this.eHD.a(this.aEl);
        this.eHD.a(this.aEe);
        this.eHD.a(this, bundle);
        this.eHD.Da().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eHD.Da().bE(true);
        iV(true);
        this.eHp.setEditorTools(this.eHD.Da());
        this.eHD.a(this.eGz.aRF(), this.eGz.getThreadID(), this.eGz.aSb());
        registerListener(this.dIZ);
        if (!this.eGz.aRC()) {
            this.eHD.fW(this.eGz.getThreadID());
        }
        if (this.eGz.aSc()) {
            this.eHD.fU(getPageContext().getString(d.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eHD.fU(getPageContext().getString(d.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eGY;
        registerListener(this.eHS);
        registerListener(this.dJv);
        registerListener(this.eHT);
        registerListener(this.cjQ);
        registerListener(this.eIh);
        registerListener(this.eHR);
        this.eHC = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.ghn);
        this.eHC.brZ();
        registerListener(this.eHV);
        registerListener(this.bgL);
        if (this.eGz != null) {
            this.eGz.aRQ();
        }
        if (TbadkCoreApplication.getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.eId);
        registerListener(this.eIk);
        registerListener(this.eIj);
        registerListener(this.eIC);
        registerListener(this.ckb);
        this.eHg = new com.baidu.tieba.pb.pb.main.b(this.eGz, this);
        if (this.eHp != null && this.eHp.aTG() != null && this.eHp.aTH() != null) {
            this.eGR = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eHp.aTG(), this.eHp.aTH());
            this.eGR.a(this.eIc);
        }
        if (this.eGQ && this.eHp != null && this.eHp.aTH() != null) {
            this.eHp.aTH().setVisibility(8);
        }
        this.eHH = new com.baidu.tbadk.core.view.c();
        this.eHH.alm = 1000L;
        registerListener(this.eIg);
        registerListener(this.eIe);
        registerListener(this.eIf);
        this.eHI = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eHI;
        userMuteAddAndDelCustomMessage.setTag(this.eHI);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eHI;
        userMuteCheckCustomMessage.setTag(this.eHI);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eGz.aRZ().a(this.boQ);
        if ("from_tieba_kuang".equals(this.eHj)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12264").r("obj_type", 2).aa("tid", this.eGz.getThreadID()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    public String aQk() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aQl() {
        return this.eGR;
    }

    private void iV(boolean z) {
        this.eHD.bI(z);
        this.eHD.bJ(z);
        this.eHD.bK(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ciW != null) {
            this.ciW.onStart(getPageContext());
        }
    }

    public aq aQm() {
        return this.eHp;
    }

    public PbModel aQn() {
        return this.eGz;
    }

    public void pj(String str) {
        if (this.eGz != null && !StringUtils.isNull(str) && this.eHp != null) {
            this.eHp.aTi();
            this.eHp.jM(true);
            this.eGz.pj(str);
            this.eHh = true;
            this.eHp.aBk();
            this.eHp.aTC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eGT = false;
        } else {
            this.eGT = true;
        }
        super.onPause();
        if (this.eHp.aSO() != null && this.eHp.aSO().aQf() != null) {
            this.eHp.aSO().aQf().onPause();
        }
        BdListView listView = getListView();
        this.eGV = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eGV == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.ciW != null) {
            this.ciW.onPause(getPageContext());
        }
        if (this.eHp != null) {
            this.eHp.onPause();
        }
        if (!this.eGz.aRC()) {
            this.eHD.fV(this.eGz.getThreadID());
        }
        if (this.eGz != null) {
            this.eGz.aRR();
        }
        MessageManager.getInstance().unRegisterListener(this.dir);
        apJ();
        MessageManager.getInstance().unRegisterListener(this.eIe);
        MessageManager.getInstance().unRegisterListener(this.eIf);
        MessageManager.getInstance().unRegisterListener(this.eIg);
        MessageManager.getInstance().unRegisterListener(this.cjU);
        MessageManager.getInstance().unRegisterListener(this.cSE);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aQo() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eGz.getPbData(), this.eGz.aRy(), this.eGz.aRO());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eGT = false;
        super.onResume();
        if (this.eHl) {
            this.eHl = false;
            aQP();
        }
        if (this.eHp.aSO() != null && this.eHp.aSO().aQf() != null) {
            this.eHp.aSO().aQf().onResume();
        }
        if (aQo()) {
            this.eHb = System.currentTimeMillis();
        } else {
            this.eHb = -1L;
        }
        if (this.eHp != null && this.eHp.getView() != null) {
            if (!this.edZ) {
                aQG();
            } else {
                hideLoadingView(this.eHp.getView());
            }
            this.eHp.onResume();
        }
        if (this.eGV == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eHp != null) {
            noNetworkView = this.eHp.aSP();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hr()) {
            noNetworkView.aL(false);
        }
        if (this.ciW != null) {
            this.ciW.onResume(getPageContext());
        }
        registerListener(this.dir);
        this.eHz = false;
        aQO();
        registerListener(this.eIe);
        registerListener(this.eIf);
        registerListener(this.eIg);
        registerListener(this.cjU);
        registerListener(this.cSE);
        if (this.cjD) {
            VF();
            this.cjD = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eHp.jD(z);
        if (this.eHu != null) {
            this.eHu.jm(z);
        }
        if (z && this.eHz) {
            this.eHp.aTn();
            this.eGz.jh(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eHb > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10804").aa("obj_duration", (System.currentTimeMillis() - this.eHb) + ""));
            this.eHb = 0L;
        }
        if (this.eHD != null && this.eHD.Da() != null && this.eHD.Da().getVisibility() != 0) {
            this.eHD.DJ();
        }
        if (aQm().aSS() != null) {
            aQm().aSS().onStop();
        }
        if (this.eHp.eOm != null && !this.eHp.eOm.Xj()) {
            this.eHp.eOm.aBB();
        }
        if (this.eGz != null && this.eGz.getPbData() != null && this.eGz.getPbData().aPh() != null && this.eGz.getPbData().aPj() != null) {
            com.baidu.tbadk.distribute.a.CK().a(getPageContext().getPageActivity(), "pb", this.eGz.getPbData().aPh().getId(), com.baidu.adp.lib.g.b.d(this.eGz.getPbData().aPj().getId(), 0L));
        }
        if (this.ciW != null) {
            this.ciW.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.eHg != null) {
            this.eHg.destroy();
        }
        if (this.eHv && this.eGz != null) {
            a(this.eGz.getPbData(), -2, 0, false, false);
        }
        if (!this.eGZ && this.eHp != null) {
            this.eGZ = true;
            this.eHp.aTB();
            a(false, (PostData) null);
        }
        if (this.eGz != null) {
            this.eGz.cancelLoadData();
            this.eGz.destory();
            if (this.eGz.aRY() != null) {
                this.eGz.aRY().onDestroy();
            }
        }
        if (this.eHD != null) {
            this.eHD.onDestroy();
        }
        if (this.eHo != null) {
            this.eHo.cancelLoadData();
        }
        if (this.eHp != null) {
            this.eHp.onDestroy();
            if (this.eHp.eOm != null) {
                this.eHp.eOm.aBB();
            }
        }
        if (this.eHa != null) {
            this.eHa.onDestroy();
        }
        if (this.eGR != null) {
            this.eGR.Ho();
        }
        super.onDestroy();
        if (this.ciW != null) {
            this.ciW.onDestory(getPageContext());
        }
        if (this.cjq != null) {
            this.cjq.destory();
        }
        this.eHp.aBk();
        MessageManager.getInstance().unRegisterListener(this.eIe);
        MessageManager.getInstance().unRegisterListener(this.eIf);
        MessageManager.getInstance().unRegisterListener(this.eIg);
        MessageManager.getInstance().unRegisterListener(this.eHI);
        MessageManager.getInstance().unRegisterListener(this.eIh);
        MessageManager.getInstance().unRegisterListener(this.ckb);
        this.eHG = null;
        this.eHH = null;
        com.baidu.tieba.recapp.d.a.bii().bik();
        if (this.eHJ != null) {
            getSafeHandler().removeCallbacks(this.eHJ);
        }
        if (this.eHm != null) {
            this.eHm.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g aTh;
        ArrayList<PostData> aRj;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xW() && this.eHp != null && (aTh = this.eHp.aTh()) != null && (aRj = aTh.aRj()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aRj.iterator();
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
                        bVar.bDe = id;
                        bVar.bJn = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ZS == 1 && !TextUtils.isEmpty(id)) {
                    next.ZS = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bDe = id;
                    bVar2.bJn = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eGz == null || this.eGz.getPbData() == null || this.eGz.getPbData().aPh() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eGz.getPbData().aPh().getFirst_class();
                    str2 = this.eGz.getPbData().aPh().getSecond_class();
                    str = this.eGz.getPbData().aPh().getId();
                    str4 = this.eGz.getThreadID();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHp.onChangeSkinType(i);
        if (this.eHD != null && this.eHD.Da() != null) {
            this.eHD.Da().onChangeSkinType(i);
        }
        if (this.eHp.aSP() != null) {
            this.eHp.aSP().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eHp = new aq(this, this.ckz, this.aRN);
        this.cma = new com.baidu.tieba.e.b(getActivity());
        this.cma.a(this.eIv);
        this.cma.a(this.bWf);
        this.eHp.setOnScrollListener(this.mOnScrollListener);
        this.eHp.d(this.eIp);
        this.eHp.a(this.baw);
        this.eHp.iP(com.baidu.tbadk.core.h.oX().pd());
        this.eHp.setOnImageClickListener(this.aRM);
        this.eHp.a(this.awn);
        this.eHp.c(this.bEV);
        this.eHp.a(this.eIn);
        this.eHp.jD(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZ(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.ghQ == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oX().pd()) {
                    return false;
                }
                return pn(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eHp != null) {
            if (z && (!this.edZ || this.eHF)) {
                aQG();
            } else {
                hideLoadingView(this.eHp.getView());
            }
            this.eHF = false;
        }
    }

    private void aQp() {
        if (this.eGW == null) {
            this.eGW = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eGW.a(new String[]{getPageContext().getString(d.l.call_phone), getPageContext().getString(d.l.sms_phone), getPageContext().getString(d.l.search_in_baidu)}, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eGx = PbActivity.this.eGx.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGx);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eGz.getThreadID(), PbActivity.this.eGx, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eGx = PbActivity.this.eGx.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGx);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eGz.getThreadID(), PbActivity.this.eGx, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eGx = PbActivity.this.eGx.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGx);
                        bVar.dismiss();
                    }
                }
            }).cg(b.a.aci).ch(17).d(getPageContext());
        }
    }

    private void t(Bundle bundle) {
        this.eGz = new PbModel(this);
        this.eGz.a(this.eIi);
        if (this.eGz.aRW() != null) {
            this.eGz.aRW().a(this.eIx);
        }
        if (this.eGz.aRV() != null) {
            this.eGz.aRV().a(this.eHU);
        }
        if (this.eGz.aRY() != null) {
            this.eGz.aRY().a(this.eHQ);
        }
        if (bundle != null) {
            this.eGz.initWithBundle(bundle);
        } else {
            this.eGz.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eGz.jl(true);
        }
        ai.aSJ().R(this.eGz.aRw(), this.eGz.getIsFromMark());
        if (StringUtils.isNull(this.eGz.getThreadID())) {
            finish();
        } else {
            this.eGz.Fw();
        }
    }

    private void initData(Bundle bundle) {
        this.eal = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eal != null) {
            this.eal.a(this.eIl);
        }
        this.eHo = new ForumManageModel(this);
        this.eHo.setLoadDataCallBack(this.eIm);
        this.eHp.a(new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
            public void g(Object obj) {
                if (!com.baidu.adp.lib.util.i.hr()) {
                    PbActivity.this.showToast(d.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eGz.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGz.getPbData().aPh().getId(), PbActivity.this.eGz.getPbData().aPh().getName(), PbActivity.this.eGz.getPbData().aPj().getId(), valueOf, str, str2)));
            }
        });
        this.eHZ.setUniqueId(getUniqueId());
        this.eHZ.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eHp.QX();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(d.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eHI;
        userMuteCheckCustomMessage.setTag(this.eHI);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PS() {
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

    public PostData ba(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.h.tag_clip_board)) != null && !com.baidu.tieba.pb.e.d(postData)) {
            if (postData.bsL()) {
                postData.cT(postData.bsK() - 1);
            } else {
                postData.cT(postData.bsK() + 1);
            }
            postData.my(!postData.bsL());
            ((PbFloorAgreeView) view).a(postData.bsL(), postData.bsK(), true);
            final int i = postData.bsL() ? 0 : 1;
            this.eGz.aRX().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void oT(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).pw(i2);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pp(String str) {
                    com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), str);
                }
            });
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.aj aQq() {
        return new com.baidu.tbadk.core.util.aj("c12003").aa("tid", this.eGz.eKN).r("obj_type", 0).aa("fid", this.eGz.getForumId()).r("obj_param1", this.eGz.getPbData().aPj().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQr() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eGz != null && this.eGz.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eGz.getPbData();
            if (pbData.aPh() != null) {
                sb.append("forum_name=").append(pk(pbData.aPh().getName()));
                sb.append("&");
            }
            if (pbData.aPj() != null) {
                bl aPj = pbData.aPj();
                sb.append("thread_id=").append(aPj.getId());
                sb.append("&");
                sb.append("thread_title=").append(pk(aPj.getTitle()));
                if (aPj.getAuthor() != null && aPj.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aPj.getAuthor().getPortrait());
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
                        PbActivity.this.aQm().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aQm().aSS() != null) {
                        PbActivity.this.aQm().aSS().bL(str, str2);
                    }
                    PbActivity.this.aQm().aTC();
                }
            }, 500L);
        }
    }

    private String pk(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null && this.eGz != null && this.eGz.getPbData() != null && postData.bsy() > 1) {
            String threadID = this.eGz.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.eGz.getPbData() != null) {
                i = this.eGz.getPbData().aPu();
            }
            b po = po(id);
            if (po != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, postData.aVI(), this.eGz.getPbData().qr(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(po.eIW, po.eIX, po.eIY, po.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        an anVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.k.hI()) {
                showToast(d.l.no_network_guide);
            } else if (aQn() != null && aQn().getPbData() != null && aQn().getPbData().aPG() != null && !com.baidu.tieba.pb.e.T(aQn().getPbData().aPj())) {
                com.baidu.tieba.pb.data.m aPG = aQn().getPbData().aPG();
                if (view == null || !(view.getTag(d.h.pb_main_thread_praise_view) instanceof an)) {
                    anVar = null;
                } else {
                    anVar = (an) view.getTag(d.h.pb_main_thread_praise_view);
                }
                if (aPG != null) {
                    int i2 = -1;
                    if (z) {
                        aPG.oL(i);
                    } else if (aPG.aPM()) {
                        aPG.aPO();
                        i2 = 1;
                    } else {
                        aPG.oM(i);
                        i2 = 0;
                    }
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void oT(int i3) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pp(String str) {
                            com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), str);
                        }
                    };
                    if (this.eGz != null && this.eGz.aRX() != null) {
                        String str = "";
                        if (this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null) {
                            str = this.eGz.getPbData().aPj().rV();
                        }
                        if (this.eGz.getPbData() != null) {
                            this.eGz.getPbData().a(aPG);
                        }
                        if (z) {
                            this.eGz.aRX().a(str, 3, i, this.eGz.getForumId(), aVar);
                        } else {
                            this.eGz.aRX().a(str, i2, 3, i, this.eGz.getForumId(), aVar);
                            com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                            lVar.eEA = i2;
                            lVar.eEB = aPG;
                            lVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, lVar));
                        }
                    }
                    if (anVar != null) {
                        anVar.b(aPG);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQs() {
        if (this.eGz.getPbData() == null || this.eGz.getPbData().aPj() == null) {
            return -1;
        }
        return this.eGz.getPbData().aPj().sj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQt() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.pL(this.eGz.getForumId()) && this.eGz.getPbData() != null && this.eGz.getPbData().aPh() != null) {
            if (this.eGz.getPbData().aPh().isLike() == 1) {
                aQH();
                this.eGz.aSa().bN(this.eGz.getForumId(), this.eGz.getThreadID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iW(boolean z) {
        if (this.eGz == null || this.eGz.getPbData() == null) {
            return false;
        }
        return ((this.eGz.getPbData().aPu() != 0) || this.eGz.getPbData().aPj() == null || this.eGz.getPbData().aPj().getAuthor() == null || TextUtils.equals(this.eGz.getPbData().aPj().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean iX(boolean z) {
        if (z) {
            return true;
        }
        if (this.eGz == null || this.eGz.getPbData() == null) {
            return false;
        }
        return this.eGz.getPbData().aPu() != 0;
    }

    private boolean iY(boolean z) {
        return (z || this.eGz == null || this.eGz.getPbData() == null || this.eGz.getPbData().aPu() == 0) ? false : true;
    }

    public void aQu() {
        if (this.eGz != null && this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null && this.eGz.getPbData().aPj().getAuthor() != null) {
            if (this.eHp != null) {
                this.eHp.aSQ();
            }
            bl aPj = this.eGz.getPbData().aPj();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aPj.getAuthor().getUserId());
            GodUserData godUserData = aPj.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            y yVar = new y();
            if (this.eGz.getPbData().aPu() == 1) {
                yVar.eMB = true;
                yVar.eMA = true;
                yVar.eMG = aPj.rA() == 1;
                yVar.eMF = aPj.rB() == 1;
            } else {
                yVar.eMB = false;
                yVar.eMA = false;
            }
            yVar.eMz = TbadkCoreApplication.getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            yVar.eMx = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            yVar.eMC = iX(equals);
            yVar.eMD = aQv();
            yVar.eME = iY(equals);
            yVar.eMy = this.eGz.aRy();
            yVar.eEM = this.eal != null ? this.eal.nL() : false;
            yVar.eMw = iW(equals);
            yVar.eMu = equals && this.eHp.aTt();
            yVar.eMv = z;
            yVar.isHostOnly = this.eGz.getHostMode();
            if (aPj.rW() == null) {
                yVar.eMH = false;
            } else {
                yVar.eMH = true;
            }
            this.eHp.eOm.a(yVar);
        }
    }

    private boolean aQv() {
        if (this.eGz != null && this.eGz.aRy()) {
            return this.eGz.aqn() == null || this.eGz.aqn().qE() != 0;
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
        if (fVar != null && this.eGz != null) {
            ad adVar = new ad(getUniqueId());
            adVar.pbData = fVar;
            adVar.threadId = this.eGz.getThreadID();
            adVar.postId = this.eGz.getPostId();
            adVar.eNh = i;
            adVar.eNi = i2;
            adVar.eNg = this.eGz.getHostMode();
            adVar.eEM = this.eGz.nL();
            adVar.isSquence = this.eGz.aRy();
            adVar.loadType = this.eGz.aRT();
            adVar.eNj = z;
            adVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, adVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQw() {
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
            if ((fVar instanceof com.baidu.tieba.pb.data.k) && ((com.baidu.tieba.pb.data.k) fVar).mType == 0) {
                return i + headerViewsCount;
            }
        }
        return -1;
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
            if ((fVar instanceof PostData) && fVar.getType() == PostData.ghO) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.eGz != null) {
            ad adVar = new ad(getUniqueId());
            adVar.pbData = fVar;
            adVar.threadId = this.eGz.getThreadID();
            adVar.postId = this.eGz.getPostId();
            adVar.eNh = i;
            adVar.eNg = this.eGz.getHostMode();
            adVar.eEM = this.eGz.nL();
            adVar.isSquence = this.eGz.aRy();
            adVar.loadType = this.eGz.aRT();
            adVar.eNj = z;
            adVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, adVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        VF();
    }

    public void a(boolean z, MarkData markData) {
        this.eHp.aTo();
        this.eGz.jk(z);
        if (this.eal != null) {
            this.eal.ac(z);
            if (markData != null) {
                this.eal.a(markData);
            }
        }
        if (this.eGz.nL()) {
            aQD();
        } else {
            this.eHp.m(this.eGz.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oP(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl(String str) {
        if (!StringUtils.isNull(str) && this.eGz != null) {
            String threadID = this.eGz.getThreadID();
            String id = this.eGz.getPbData().aPh().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eGz.aRC()) {
                    antiData.setBlock_forum_name(this.eGz.getPbData().aPh().getName());
                    antiData.setBlock_forum_id(this.eGz.getPbData().aPh().getId());
                    antiData.setUser_name(this.eGz.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eGz.getPbData().getUserData().getUserId());
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
            gc(str);
        } else {
            this.eHp.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eHp.a(0, bVar.Cm, bVar.gkg, z);
            if (bVar.Cm) {
                if (bVar.gke == 1) {
                    ArrayList<PostData> aPl = this.eGz.getPbData().aPl();
                    int size = aPl.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aPl.get(i).getId())) {
                            i++;
                        } else {
                            aPl.remove(i);
                            break;
                        }
                    }
                    this.eHp.m(this.eGz.getPbData());
                } else if (bVar.gke == 0) {
                    aQy();
                } else if (bVar.gke == 2) {
                    ArrayList<PostData> aPl2 = this.eGz.getPbData().aPl();
                    int size2 = aPl2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aPl2.get(i2).bsv().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aPl2.get(i2).bsv().get(i3).getId())) {
                                i3++;
                            } else {
                                aPl2.get(i2).bsv().remove(i3);
                                aPl2.get(i2).bsx();
                                z2 = true;
                                break;
                            }
                        }
                        aPl2.get(i2).sb(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eHp.m(this.eGz.getPbData());
                    }
                    a(bVar, this.eHp);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eHp.a(this.eHo.getLoadDataMode(), fVar.Cm, fVar.gkg, false);
            if (fVar.Cm) {
                this.eHr = true;
                if (i == 2 || i == 3) {
                    this.eHs = true;
                    this.eHt = false;
                } else if (i == 4 || i == 5) {
                    this.eHs = false;
                    this.eHt = true;
                }
                if (i == 2) {
                    this.eGz.getPbData().aPj().bU(1);
                    this.eGz.setIsGood(1);
                } else if (i == 3) {
                    this.eGz.getPbData().aPj().bU(0);
                    this.eGz.setIsGood(0);
                } else if (i == 4) {
                    this.eGz.getPbData().aPj().bT(1);
                    this.eGz.hF(1);
                } else if (i == 5) {
                    this.eGz.getPbData().aPj().bT(0);
                    this.eGz.hF(0);
                }
                this.eHp.d(this.eGz.getPbData(), this.eGz.aRy());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aQy() {
        if (this.eGz.aRz() || this.eGz.aRA()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eGz.getThreadID());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eGz.getThreadID()));
        if (aQE()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQz() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aPr;
        if (this.eHp != null) {
            this.eHp.aBk();
        }
        if (this.eGz != null && this.eGz.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eGz.getPbData().aPj().getId();
            historyMessage.forumName = this.eGz.getPbData().aPh().getName();
            historyMessage.threadName = this.eGz.getPbData().aPj().getTitle();
            ArrayList<PostData> aPl = this.eGz.getPbData().aPl();
            int aTq = this.eHp != null ? this.eHp.aTq() : 0;
            if (aPl != null && aTq >= 0 && aTq < aPl.size()) {
                historyMessage.postID = aPl.get(aTq).getId();
            }
            historyMessage.isHostOnly = this.eGz.getHostMode();
            historyMessage.isSquence = this.eGz.aRy();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eHD != null) {
            this.eHD.onDestroy();
        }
        if (this.eGU && aQm() != null) {
            aQm().aTP();
        }
        if (this.eGz != null && (this.eGz.aRz() || this.eGz.aRA())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eGz.getThreadID());
            if (this.eHr) {
                if (this.eHt) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eGz.aBb());
                }
                if (this.eHs) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eGz.getIsGood());
                }
            }
            if (this.eGz.getPbData() != null && System.currentTimeMillis() - this.eGY >= 40000 && (aPr = this.eGz.getPbData().aPr()) != null && !com.baidu.tbadk.core.util.u.v(aPr.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aPr);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eHP);
            }
            setResult(-1, intent);
        }
        if (aQE()) {
            if (this.eGz != null && this.eHp != null && this.eHp.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eGz.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aPp() && !this.eHh) {
                        ai.aSJ().a(this.eGz.getPbData(), this.eHp.getListView().onSaveInstanceState(), this.eGz.aRy(), this.eGz.getHostMode());
                    }
                }
            } else {
                ai.aSJ().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eHp == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eHp.pk(i)) {
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
        this.eHD.onActivityResult(i, i2, intent);
        if (this.eHm != null) {
            this.eHm.onActivityResult(i, i2, intent);
        }
        if (aQm().aSS() != null) {
            aQm().aSS().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aQC();
                    return;
                case 13008:
                    ai.aSJ().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eGz != null) {
                                PbActivity.this.eGz.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eGz != null) {
                        a(aQB(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aQs() == 1) {
                        aQA();
                    }
                    String stringExtra = intent.getStringExtra("share_to");
                    if (!AddExperiencedModel.WEIXIN_FRIEND.equals(stringExtra) && !AddExperiencedModel.WEIXIN_TIMELINE.equals(stringExtra)) {
                        aQt();
                        return;
                    }
                    return;
                case 24008:
                    this.eHp.iU(false);
                    if (this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null && this.eGz.getPbData().aPj().rZ() != null) {
                        this.eGz.getPbData().aPj().rZ().setStatus(2);
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
            if (this.eHg != null) {
                this.eHg.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aQm() != null && aQi() != null && aQm().aSU() && com.baidu.tbadk.editortools.pb.a.Dw().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Dw().setStatus(0);
                    if (this.eHp != null) {
                        this.eHp.aST();
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
            if (this.eHm == null) {
                this.eHm = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eHm.b(this.aEe);
                this.eHm.c(this.aEl);
            }
            this.eHm.a(emotionImageData, aQn(), aQn().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQA() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null && this.eGz.getPbData().aPj().rQ() != null && this.eGz.getPbData().aPj().rQ().size() > 0 && this.eGz.getPbData().aPj().rQ().get(0) != null) {
            this.mAwardActId = this.eGz.getPbData().aPj().rQ().get(0).ps();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.d(this.eGz.getPbData().getThreadId(), 0L));
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
                    this.eHp.aTf();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aQB() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bD = this.eGz.getPbData().bD(getPageContext().getPageActivity());
        PostData aSV = this.eHp.aSV();
        String str = "";
        if (aSV != null) {
            str = aSV.getId();
            String bO = aSV.bO(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bO)) {
                bD[1] = bO;
            }
        }
        String rV = this.eGz.getPbData().aPj().rV();
        if (rV != null && rV.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bD[1]);
        shareFromPBMsgData.setImageUrl(bD[0]);
        shareFromPBMsgData.setForumName(this.eGz.getPbData().aPh().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eGz.getPbData().aPj().getId());
        shareFromPBMsgData.setTitle(this.eGz.getPbData().aPj().getTitle());
        return shareFromPBMsgData;
    }

    private void V(Intent intent) {
        b(aQB(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void b(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eGz != null && this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null) {
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
                    if (PbActivity.this.aQs() == 1) {
                        PbActivity.this.aQA();
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
                auVar.J(shareFromPBMsgData.getImageUrl(), this.eGz.getPbData().aPv() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eGz != null && this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null) {
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
                    if (PbActivity.this.aQs() == 1) {
                        PbActivity.this.aQA();
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
                auVar.J(shareFromPBMsgData.getImageUrl(), this.eGz.getPbData().aPv() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQC() {
        MarkData pf;
        if (this.eal != null && (pf = this.eGz.pf(this.eHp.aTr())) != null) {
            if (!pf.isApp() || (pf = this.eGz.pf(this.eHp.aTr() + 1)) != null) {
                this.eHp.aTm();
                this.eal.a(pf);
                if (!this.eal.nL()) {
                    this.eal.nN();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.eal.nM();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQD() {
        com.baidu.tieba.pb.data.f pbData = this.eGz.getPbData();
        this.eGz.jk(true);
        pbData.pg(this.eal.nK());
        this.eHp.m(pbData);
    }

    private boolean aQE() {
        if (this.eGz == null) {
            return true;
        }
        if (this.eGz.nL()) {
            final MarkData aRK = this.eGz.aRK();
            if (aRK == null || !this.eGz.getIsFromMark()) {
                return true;
            }
            final MarkData pf = this.eGz.pf(this.eHp.aTr());
            if (pf == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aRK);
                setResult(-1, intent);
                return true;
            } else if (pf.getPostId() == null || pf.getPostId().equals(aRK.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aRK);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cT(getPageContext().getString(d.l.alert_update_mark));
                aVar.a(d.l.alert_yes_btn, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.eal != null) {
                            if (PbActivity.this.eal.nL()) {
                                PbActivity.this.eal.nM();
                                PbActivity.this.eal.ac(false);
                            }
                            PbActivity.this.eal.a(pf);
                            PbActivity.this.eal.ac(true);
                            PbActivity.this.eal.nN();
                        }
                        aRK.setPostId(pf.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aRK);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aQz();
                    }
                });
                aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aRK);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aQz();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eHp != null && PbActivity.this.eHp.getView() != null) {
                            PbActivity.this.eHp.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aRK);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aQz();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.tr();
                return false;
            }
        } else if (this.eGz.getPbData() == null || this.eGz.getPbData().aPl() == null || this.eGz.getPbData().aPl().size() <= 0 || !this.eGz.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eHp == null) {
            return null;
        }
        return this.eHp.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        if (this.eHp == null) {
            return 0;
        }
        return this.eHp.aTw();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        if (this.aRt == null) {
            this.aRt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Ts */
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
        return this.aRt;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        if (this.aRu == null) {
            this.aRu = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aRu;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        if (this.aRy == null) {
            this.aRy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQZ */
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
        return this.aRy;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        if (this.aRw == null) {
            this.aRw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: amb */
                public View fT() {
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
        return this.aRw;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aRv == null) {
            this.aRv = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 6);
        }
        return this.aRv;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xn() {
        if (this.apA == null) {
            this.apA = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.apA;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eHd = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (av.pz(str) && this.eGz != null && this.eGz.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11664").r("obj_param1", 1).aa("post_id", this.eGz.getThreadID()));
        }
        av.aTT().f(getPageContext(), str);
        this.eHd = true;
    }

    private com.baidu.tbadk.core.dialog.a aQF() {
        if (this.eGX == null) {
            this.eGX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eGX.cS(getPageContext().getString(d.l.download_baidu_video_dialog));
            this.eGX.a(getPageContext().getString(d.l.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
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
            this.eGX.b(getPageContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eGX.ar(true);
            this.eGX.b(getPageContext());
            this.eGX.as(false);
        }
        this.eGX.tr();
        return this.eGX;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
        av.aTT().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eHd = true;
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
            aQF();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eHd = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eGz.getPbData();
            TbRichText ao = ao(str, i);
            if (ao != null && (tbRichTextData = ao.Io().get(this.eIq)) != null) {
                if (tbRichTextData.getType() == 20 || tbRichTextData.getType() == 17) {
                    bVar.eJa = true;
                    return;
                }
                bVar.eIW = new ArrayList<>();
                bVar.eIX = new ConcurrentHashMap<>();
                if (!tbRichTextData.It().IG()) {
                    bVar.eIZ = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.eIW.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = ao.getPostId();
                    imageUrlData.mIsReserver = this.eGz.aRJ();
                    imageUrlData.mIsSeeHost = this.eGz.getHostMode();
                    bVar.eIX.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aPh() != null) {
                            bVar.forumName = pbData.aPh().getName();
                            bVar.forumId = pbData.aPh().getId();
                        }
                        if (pbData.aPj() != null) {
                            bVar.threadId = pbData.aPj().getId();
                        }
                        bVar.eIY = pbData.aPv() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bVar.threadId, -1L);
                    return;
                }
                bVar.eIZ = true;
                int size = pbData.aPl().size();
                this.eIr = false;
                bVar.index = -1;
                if (pbData.aPq() != null) {
                    PostData aPq = pbData.aPq();
                    TbRichText aAP = aPq.aAP();
                    if (!ap.k(aPq)) {
                        i2 = a(aAP, ao, i, i, bVar.eIW, bVar.eIX);
                    } else {
                        i2 = a(aPq, i, bVar.eIW, bVar.eIX);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aPl().get(i4);
                    if (postData.getId() == null || pbData.aPq() == null || pbData.aPq().getId() == null || !postData.getId().equals(pbData.aPq().getId())) {
                        TbRichText aAP2 = postData.aAP();
                        if (!ap.k(postData)) {
                            i3 = a(aAP2, ao, i3, i, bVar.eIW, bVar.eIX);
                        } else {
                            i3 = a(postData, i3, bVar.eIW, bVar.eIX);
                        }
                    }
                }
                if (bVar.eIW.size() > 0) {
                    bVar.lastId = bVar.eIW.get(bVar.eIW.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aPh() != null) {
                        bVar.forumName = pbData.aPh().getName();
                        bVar.forumId = pbData.aPh().getId();
                    }
                    if (pbData.aPj() != null) {
                        bVar.threadId = pbData.aPj().getId();
                    }
                    bVar.eIY = pbData.aPv() == 1;
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
            this.eIr = true;
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
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.eGz.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eGz.aRJ();
                                imageUrlData.mIsSeeHost = this.eGz.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eIr) {
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
        com.baidu.tieba.tbadkCore.data.h bsG;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bsd;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bsd = (bsG = postData.bsG()).bsd()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bsd.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bsd.get(i3);
                if (jVar != null) {
                    String bsi = jVar.bsi();
                    if (!com.baidu.tbadk.core.util.al.isEmpty(bsi)) {
                        arrayList.add(bsi);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bsi;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bsh();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.eGz.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eGz.aRJ();
                        imageUrlData.mIsSeeHost = this.eGz.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bsG.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bsi, imageUrlData);
                        }
                        if (!this.eIr) {
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
            if (postData.getId() != null && postData.getId().equals(this.eGz.rO())) {
                z = true;
            }
            MarkData j = this.eGz.j(postData);
            if (j != null) {
                this.eHp.aTm();
                if (this.eal != null) {
                    this.eal.a(j);
                    if (!z) {
                        this.eal.nN();
                    } else {
                        this.eal.nM();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ao(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eGz == null || this.eGz.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eGz.getPbData();
        if (pbData.aPq() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aPq());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            return a(pbData.aPl(), str, i);
        }
        return tbRichText;
    }

    private long pm(String str) {
        ArrayList<PostData> aPl;
        com.baidu.tieba.pb.data.f pbData = this.eGz.getPbData();
        if (pbData != null && (aPl = pbData.aPl()) != null && !aPl.isEmpty()) {
            Iterator<PostData> it = aPl.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bsG = next.bsG();
                if (bsG != null && bsG.ghv) {
                    Iterator<TbRichTextData> it2 = next.aAP().Io().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IC().getLink().equals(str)) {
                            return bsG.getTemplateId();
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
            TbRichText aAP = arrayList.get(i2).aAP();
            if (aAP != null && (Io = aAP.Io()) != null) {
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
                            this.eIq = i4;
                            return aAP;
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
                                        this.eIq = i4;
                                        return aAP;
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
            this.eGx = str;
            if (this.eGW == null) {
                aQp();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eGW.cj(1).setVisibility(8);
            } else {
                this.eGW.cj(1).setVisibility(0);
            }
            this.eGW.tu();
            this.eHd = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ciW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VF() {
        hideNetRefreshView(this.eHp.getView());
        aQG();
        if (this.eGz.Fw()) {
            this.eHp.aTm();
        }
    }

    private void aQG() {
        showLoadingView(this.eHp.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds400));
        View EQ = getLoadingView().EQ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EQ.getLayoutParams();
        layoutParams.addRule(3, this.eHp.aTG().getId());
        EQ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        if (this.ciW != null) {
            this.ciW.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(int i) {
        if (this.eGz.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eGz.getPbData();
            String name = pbData.aPh().getName();
            String title = pbData.aPj().getTitle();
            int i2 = this.eGz.getHostMode() ? 1 : 0;
            boolean z = false;
            if (pbData != null && pbData.aPh() != null) {
                if ((pbData.aPh().isLike() == 1) && AddExperiencedModel.pL(pbData.getForumId())) {
                    z = true;
                }
            }
            String str = "http://tieba.baidu.com/p/" + this.eGz.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bD = pbData.bD(getPageContext().getPageActivity());
            String str2 = bD[0];
            if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str2 = str2.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bD[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aQs() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10399").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            } else if (aQs() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10406").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, name, str3);
            final com.baidu.tbadk.coreExtra.share.e eVar = new com.baidu.tbadk.coreExtra.share.e();
            eVar.title = title;
            eVar.content = format;
            eVar.linkUrl = str;
            eVar.avc = true;
            eVar.avf = z;
            eVar.extData = this.eGz.getThreadID();
            eVar.avm = 3;
            eVar.avl = i;
            eVar.fid = this.eGz.getForumId();
            if (parse != null) {
                eVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), eVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 23007)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10125").aa("tid", PbActivity.this.eGz.getThreadID()).r("obj_type", 1));
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

    private void aQH() {
        com.baidu.tbadk.util.u.a(new com.baidu.tbadk.util.t<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pM(PbActivity.this.eGz.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eHp.aTS();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        if (this.aRx == null) {
            this.aRx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRa */
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
        return this.aRx;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eHp.aTg() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", this.eGz.getPbData().getForumId()));
            } else {
                bl aPj = this.eGz.getPbData().aPj();
                if (view != null) {
                    boolean z = aPj.rv() == null || aPj.rv().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eIa > 1000) {
                            this.eIb = true;
                            bc(view);
                        } else {
                            this.eIb = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            k(view, this.eIb);
                        } else {
                            j(view, this.eIb);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        j(view, this.eIb);
                    } else if (motionEvent.getAction() == 3) {
                        j(view, this.eIb);
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
                    PbActivity.this.eIa = System.currentTimeMillis();
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
                    PbActivity.this.eIa = System.currentTimeMillis();
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

    public void afp() {
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
            int intValue = ((Integer) sparseArray.get(aq.eQe)).intValue();
            if (intValue == aq.eQf) {
                if (!this.eHo.btk()) {
                    this.eHp.aTj();
                    int intValue2 = ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue();
                    this.eHo.a(this.eGz.getPbData().aPh().getId(), this.eGz.getPbData().aPh().getName(), this.eGz.getPbData().aPj().getId(), (String) sparseArray.get(d.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == aq.eQg || intValue == aq.eQi) {
                if (this.eGz.aRW() != null) {
                    this.eGz.aRW().oW(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.eQg) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == aq.eQh) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eIw).pn()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eHI);
        userMuteAddAndDelCustomMessage.setTag(this.eHI);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pn(String str) {
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

    public void iZ(boolean z) {
        this.eHz = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQI() {
        ArrayList<PostData> aPl;
        int u;
        if (this.eGz == null || this.eGz.getPbData() == null || this.eGz.getPbData().aPl() == null || (u = com.baidu.tbadk.core.util.u.u((aPl = this.eGz.getPbData().aPl()))) == 0) {
            return "";
        }
        if (this.eGz.aRJ()) {
            Iterator<PostData> it = aPl.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bsy() == 1) {
                    return next.getId();
                }
            }
        }
        int aTq = this.eHp.aTq();
        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(aPl, aTq);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eGz.ps(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aTq - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.u.c(aPl, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eGz.ps(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aTq + 1; i2 < u; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.u.c(aPl, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eGz.ps(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.at.wf().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(pm(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eGz.getPbData().aPh().getId(), this.eGz.getPbData().aPh().getName(), this.eGz.getPbData().aPj().getTid());
            }
            this.eHd = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eGz.aRV() != null) {
                    PbActivity.this.eGz.aRV().cu(j);
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
    public b po(String str) {
        String str2;
        if (this.eGz.getPbData() == null || this.eGz.getPbData().aPl() == null || this.eGz.getPbData().aPl().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i >= this.eGz.getPbData().aPl().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eGz.getPbData().aPl().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eGz.getPbData().aPl().get(i);
        if (postData.aAP() == null || postData.aAP().Io() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aAP().Io().iterator();
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
        if (this.eGS) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eGS = false;
        } else if (aQJ()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eGS) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eGS = false;
        } else if (aQJ()) {
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
        if (pageStayDurationItem != null && this.eGz != null) {
            if (this.eGz.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.eGz.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.eGz.getThreadID(), 0L));
            if (this.eHe) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aQJ() {
        return (!this.eGQ && this.eIy == -1 && this.eIz == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eIB = nVar;
            this.eGQ = true;
            this.eHp.aSX();
            this.eHp.px(this.eIA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        if (this.eIB != null) {
            if (this.eIy == -1) {
                showToast(d.l.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aN(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eIB.getCartoonId(), this.eIy, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQL() {
        if (this.eIB != null) {
            if (this.eIz == -1) {
                showToast(d.l.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aN(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eIB.getCartoonId(), this.eIz, 0)));
                finish();
            }
        }
    }

    public int aQM() {
        return this.eIy;
    }

    public int aQN() {
        return this.eIz;
    }

    private void apJ() {
        if (this.eGz != null && this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null && this.eGz.getPbData().aPj().ss()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aQO() {
        if (this.eGz != null && this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null && this.eGz.getPbData().aPj().ss()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aQP() {
        if (this.eGT) {
            this.eHl = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null && this.eGz.getPbData().aPj().rn() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eGz.getPbData().aPj().rn().getThreadId(), this.eGz.getPbData().aPj().rn().getTaskId(), this.eGz.getPbData().aPj().rn().getForumId(), this.eGz.getPbData().aPj().rn().getForumName(), this.eGz.getPbData().aPj().rA(), this.eGz.getPbData().aPj().rB())));
            this.eGS = true;
            finish();
        }
    }

    public boolean aQQ() {
        return this.eGT;
    }

    public String aQR() {
        return this.eHj;
    }

    public PbInterviewStatusView.a aQS() {
        return this.eHn;
    }

    public void ja(boolean z) {
        this.eHk = z;
    }

    public boolean aQT() {
        if (this.eGz != null) {
            return this.eGz.aRz();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cT(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eHG).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eHG.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eHG).tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eHG != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHG.getPageActivity());
            aVar.cT(str);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eHG).tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eHp.QX();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHG.getPageActivity());
        if (com.baidu.tbadk.core.util.al.isEmpty(str)) {
            aVar.cT(this.eHG.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cT(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eHp.QX();
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
        aVar.b(this.eHG).tr();
    }

    public void aQV() {
        if (this.eGz != null && this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null && this.eGz.getPbData().aPj().sJ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cc(d.l.channel_open_push_message);
            aVar.a(d.l.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eGz.getPbData().aPj().sJ().channelId, true, PbActivity.this.getUniqueId())));
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
                if (av.pz(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_pb_wenxue)) != null) {
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
            this.eHi = true;
        } else {
            this.eHi = false;
        }
        if (this.eHp != null) {
            this.eHp.onConfigurationChanged(configuration);
        }
        if (this.eHu != null) {
            this.eHu.dismiss();
        }
    }

    public boolean aQW() {
        if (this.eGz != null) {
            return this.eGz.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.eGz.getPbData().aPt().eEO;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bsv().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bsv().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bsv().remove(i2);
                    list.get(i).bsx();
                    z = true;
                    break;
                }
            }
            list.get(i).sb(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.eGz.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.n nVar) {
        String id = nVar.aPR().getId();
        List<PostData> list = this.eGz.getPbData().aPt().eEO;
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
                ArrayList<PostData> aPV = nVar.aPV();
                postData.th(nVar.getTotalCount());
                if (postData.bsv() != null) {
                    postData.bsv().clear();
                    postData.bsv().addAll(aPV);
                }
            }
        }
        this.eHp.m(this.eGz.getPbData());
    }

    public boolean aQX() {
        boolean z = true;
        if (this.eGz == null) {
            return false;
        }
        switch (this.eGz.aSe()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eGz.getPbData() != null && this.eGz.getPbData().aPj() != null && this.eGz.getPbData().aPj().sR() && StringUtils.isNull(this.eGz.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aQY() {
        if (this.eHp != null) {
            this.eHp.aSQ();
            afp();
        }
    }

    public PostData aPq() {
        return this.eHp.c(this.eGz.eLd, this.eGz.aRy());
    }
}
