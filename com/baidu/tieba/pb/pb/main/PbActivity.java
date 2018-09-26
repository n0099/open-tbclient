package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
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
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
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
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PostPraiseView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
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
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.pb.main.r;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.share.AddExperiencedModel;
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
import com.baidu.tieba.view.Thread2GroupShareView;
import com.tencent.connect.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<PbActivity> {
    private com.baidu.adp.lib.e.b<TbImageView> aBR;
    private com.baidu.tieba.f.b bPP;
    private com.baidu.adp.lib.e.b<ImageView> bjq;
    private com.baidu.adp.lib.e.b<TextView> bjr;
    private com.baidu.adp.lib.e.b<View> bjs;
    private com.baidu.adp.lib.e.b<LinearLayout> bjt;
    private com.baidu.adp.lib.e.b<RelativeLayout> bju;
    private com.baidu.adp.lib.e.b<GifView> bjv;
    private com.baidu.tbadk.core.util.b.a bqO;
    private com.baidu.tbadk.core.dialog.h dsX;
    private VoiceManager dsk;
    public com.baidu.tbadk.core.util.aj ePn;
    private String fCE;
    private com.baidu.tieba.pb.pb.main.b.b fCK;
    private BdUniqueId fDA;
    private Runnable fDB;
    private av fDC;
    private com.baidu.adp.widget.ImageView.a fDD;
    private String fDE;
    private TbRichTextMemeInfo fDF;
    private List<a> fDI;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fDa;
    private View fDb;
    private com.baidu.tieba.pb.pb.report.a fDe;
    public at fDl;
    private y fDm;
    private boolean fDo;
    private com.baidu.tieba.tbadkCore.data.e fDr;
    private com.baidu.tbadk.editortools.pb.f fDs;
    private com.baidu.tbadk.editortools.pb.d fDt;
    private EmotionImageData fDv;
    private com.baidu.adp.base.e fDy;
    private com.baidu.tbadk.core.view.g fDz;
    private boolean fEk;
    private String fEv;
    private com.baidu.tbadk.core.data.m fEw;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").w("obj_locate", as.a.atP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").w("obj_locate", as.a.atP));
        }
    };
    private static final b.a fEq = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // com.baidu.tieba.f.b.a
        public void ft(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bcC();
            } else {
                com.baidu.tieba.pb.a.b.bcB();
            }
        }
    };
    private boolean fCJ = false;
    private boolean fCL = false;
    private boolean fCM = false;
    private boolean fgn = false;
    private boolean fCN = true;
    private int fCO = 0;
    private com.baidu.tbadk.core.dialog.b fCP = null;
    private long cYB = -1;
    private long aXi = 0;
    private long fCQ = 0;
    private long createTime = 0;
    private long aXa = 0;
    private boolean fCR = false;
    private com.baidu.tbadk.l.b fCS = null;
    private long fCT = 0;
    private boolean fCU = false;
    private long fCV = 0;
    private String aRh = null;
    private boolean fCW = false;
    private boolean isFullScreen = false;
    private String fCX = "";
    private boolean fCY = true;
    private boolean fCZ = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fDc = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void A(boolean z) {
            PbActivity.this.fDg.kG(!PbActivity.this.fCY);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fDd != null && PbActivity.this.fDd.sR()) {
                        PbActivity.this.bdy();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fDd = null;
    private com.baidu.tbadk.baseEditMark.a fDf = null;
    private ForumManageModel cFB = null;
    private com.baidu.tbadk.coreExtra.model.a atd = null;
    private ShareSuccessReplyToServerModel dId = null;
    private ar fDg = null;
    public final com.baidu.tieba.pb.pb.main.b.a fDh = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean fDi = false;
    private boolean fDj = false;
    private boolean fDk = false;
    private boolean fDn = false;
    private boolean fDp = false;
    private boolean fDq = false;
    private boolean fDu = false;
    public boolean fDw = false;
    private com.baidu.tbadk.editortools.pb.c aRk = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Jh() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aRl = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Jg() {
            if (PbActivity.this.fDl == null || PbActivity.this.fDl.bhl() == null || !PbActivity.this.fDl.bhl().bIg()) {
                return !PbActivity.this.qT(com.baidu.tbadk.core.util.aj.asY);
            }
            PbActivity.this.showToast(PbActivity.this.fDl.bhl().bIi());
            if (PbActivity.this.fDt != null && (PbActivity.this.fDt.Jv() || PbActivity.this.fDt.Jw())) {
                PbActivity.this.fDt.a(false, PbActivity.this.fDl.bho());
            }
            PbActivity.this.fDl.kS(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fDx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Jg() {
            if (PbActivity.this.fDl == null || PbActivity.this.fDl.bhm() == null || !PbActivity.this.fDl.bhm().bIg()) {
                return !PbActivity.this.qT(com.baidu.tbadk.core.util.aj.asZ);
            }
            PbActivity.this.showToast(PbActivity.this.fDl.bhm().bIi());
            if (PbActivity.this.fDg != null && PbActivity.this.fDg.bfZ() != null && PbActivity.this.fDg.bfZ().bev() != null && PbActivity.this.fDg.bfZ().bev().Jw()) {
                PbActivity.this.fDg.bfZ().bev().a(PbActivity.this.fDl.bho());
            }
            PbActivity.this.fDl.kT(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dsT = false;
    private int fDG = 0;
    private int fDH = -1;
    private final a fDJ = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fDg != null && PbActivity.this.fDg.bfZ() != null) {
                s bfZ = PbActivity.this.fDg.bfZ();
                if (bfZ.bes()) {
                    bfZ.ber();
                    return true;
                }
            }
            if (PbActivity.this.fDg != null && PbActivity.this.fDg.bgR()) {
                PbActivity.this.fDg.bgS();
                return true;
            }
            return false;
        }
    };
    private r.a fDK = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
    };
    private AddExperiencedModel.a dtc = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bdC();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final z.a fDL = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void H(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fDg.showToast(str);
            }
        }
    };
    private final CustomMessageListener fDM = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fDd != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fDt != null) {
                    PbActivity.this.fDg.kL(PbActivity.this.fDt.Jp());
                }
                PbActivity.this.fDg.bga();
                PbActivity.this.fDg.bgK();
            }
        }
    };
    CustomMessageListener dtu = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.fDd.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.fDg != null && PbActivity.this.fDd != null) {
                    PbActivity.this.fDg.d(PbActivity.this.fDd.getPbData(), PbActivity.this.fDd.beE(), PbActivity.this.fDd.getRequestType());
                }
                if (PbActivity.this.fDg != null && PbActivity.this.fDg.bgr() != null) {
                    PbActivity.this.fDg.bgr().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fDN = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fDg != null) {
                    if (booleanValue) {
                        PbActivity.this.fDg.aNS();
                    } else {
                        PbActivity.this.fDg.aNR();
                    }
                }
            }
        }
    };
    private CustomMessageListener fDO = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fDt != null) {
                    PbActivity.this.fDg.kL(PbActivity.this.fDt.Jp());
                }
                PbActivity.this.fDg.kN(false);
            }
        }
    };
    private CustomMessageListener fDP = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customResponsedMessage.getData();
                switch (dVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.j) dVar.getData());
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
    private CustomMessageListener fDQ = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fDg != null && PbActivity.this.fDg.bgr() != null) {
                PbActivity.this.fDg.bgr().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener etb = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fDR = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.qV(2);
                aj.bfL().reset();
                PbActivity.this.fDd.beW();
                boolean z2 = false;
                ArrayList<PostData> bbL = PbActivity.this.fDd.getPbData().bbL();
                if (bbL != null) {
                    Iterator<PostData> it = bbL.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.byV().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fDg.n(PbActivity.this.fDd.getPbData());
                    }
                    PbActivity.this.showToast(e.j.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(e.j.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(e.j.operation_failed);
        }
    };
    private View.OnClickListener aRR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aRh);
        }
    };
    private CustomMessageListener fDS = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fDd.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fDd.beN() != null && PbActivity.this.fDd.beN().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fDg.a(yVar.sendCount, PbActivity.this.fDd.getPbData(), PbActivity.this.fDd.beE(), PbActivity.this.fDd.getRequestType());
                    }
                    if (pbData.bbL() != null && pbData.bbL().size() >= 1 && pbData.bbL().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bbL().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.fDd.beD(), 0L);
                        if (d2 == yVar.postId && d3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am byU = pbData.bbL().get(0).byU();
                            if (byU == null) {
                                byU = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> vx = byU.vx();
                            if (vx == null) {
                                vx = new ArrayList<>();
                            }
                            vx.add(0, aVar);
                            byU.bY(yVar.sendCount + byU.vw());
                            byU.k(vx);
                            pbData.bbL().get(0).a(byU);
                            PbActivity.this.fDg.bgr().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener dKY = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null) {
                PbActivity.this.rK((String) customResponsedMessage.getData());
                PbActivity.this.fDd.beT();
                if (PbActivity.this.fDg.bgr() != null) {
                    PbActivity.this.fDg.n(PbActivity.this.fDd.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a fDT = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.arp() != null && !aVar.arp().isEmpty()) {
                    PbActivity.this.fDg.a(aVar, PbActivity.this.fDV);
                }
                PbActivity.this.fDg.a(aVar, PbActivity.this.fDd.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bhv()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fDU = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void H(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.z(list) && PbActivity.this.fDg != null) {
                PbActivity.this.fDg.cX(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fDV = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bA(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.jn().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbActivity.this.getUniqueId());
            } else {
                PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_BOTTOM)));
            }
        }
    };
    private boolean fDW = false;
    private PraiseModel fDX = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void jv(String str) {
            PbActivity.this.fDW = false;
            if (PbActivity.this.fDX != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fDd.getPbData();
                if (pbData.bbJ().vZ().getIsLike() == 1) {
                    PbActivity.this.lq(0);
                } else {
                    PbActivity.this.lq(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bbJ()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Q(int i, String str) {
            PbActivity.this.fDW = false;
            if (PbActivity.this.fDX != null && str != null) {
                if (AntiHelper.am(i, str)) {
                    AntiHelper.aG(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fDY = 0;
    private boolean fDZ = true;
    private b.a fEa = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void kg(boolean z) {
            PbActivity.this.kf(z);
            if (PbActivity.this.fDg.bgX() != null && z) {
                PbActivity.this.fDg.kG(false);
            }
            PbActivity.this.fDg.kI(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aGz != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aGz, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").w("obj_locate", as.a.atP));
                        }
                    } else if (updateAttentionMessage.getData().IM) {
                        if (PbActivity.this.bbQ().wm() != null && PbActivity.this.bbQ().wm().getGodUserData() != null) {
                            PbActivity.this.bbQ().wm().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bbJ() != null && PbActivity.this.fDd.getPbData().bbJ().wm() != null) {
                            PbActivity.this.fDd.getPbData().bbJ().wm().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a ciz = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fDg.agD();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.qW(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.aEZ();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(e.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bjA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            PbActivity.this.bdi();
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == e.g.richText) {
                    if (PbActivity.this.bq(view)) {
                        return true;
                    }
                } else if (view.getId() == e.g.pb_floor_item_layout) {
                    if (view.getTag(e.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(e.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != e.g.pb_post_header_layout) {
                    if (PbActivity.this.fDg != null && PbActivity.this.fDg.bdg() && view.getId() == e.g.pb_head_user_info_root) {
                        if (view.getTag(e.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").al(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(e.g.tag_user_id)));
                        }
                        if (PbActivity.this.fDh != null && PbActivity.this.fDh.dSp != null) {
                            PbActivity.this.fDh.dSp.onClick(view);
                        }
                    }
                } else {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        PbActivity.this.c(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (PbActivity.this.fDt != null) {
                PbActivity.this.fDg.kL(PbActivity.this.fDt.Jp());
            }
            PbActivity.this.fDg.bga();
            PbActivity.this.fDg.bgK();
            return true;
        }
    });
    private CustomMessageListener fEb = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fDA) {
                PbActivity.this.fDg.agD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fDd.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bbX().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fDz.e(PbActivity.this.fDy.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fDy.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.hn(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bdO();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ao.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fDy.getResources().getString(e.j.mute_fail);
                    }
                    PbActivity.this.fDz.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fEc = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fDA) {
                PbActivity.this.fDg.agD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fDz.e(PbActivity.this.fDy.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ao.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fDy.getResources().getString(e.j.un_mute_fail);
                }
                PbActivity.this.fDz.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fEd = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fDA) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fDg.agD();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hjk;
                if (aVar.error == 0 && dataRes != null) {
                    int l = com.baidu.adp.lib.g.b.l(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = l == 1;
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        sparseArray.put(e.g.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(e.g.tag_user_mute_msg, str);
                    }
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(e.g.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(e.g.tag_from)).intValue();
                if (intValue == 0) {
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.fDg.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fEe = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fDg.bgb() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bdi();
            }
        }
    };
    private CustomMessageListener dtB = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dsT = true;
                }
            }
        }
    };
    public a.b fre = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.awu();
            com.baidu.tbadk.core.data.al pageData = PbActivity.this.fDd.getPageData();
            int pageNum = PbActivity.this.fDg.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(e.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.vp()) {
                PbActivity.this.fDg.bgK();
                PbActivity.this.qV(2);
                PbActivity.this.awt();
                PbActivity.this.fDg.bgv();
                if (com.baidu.adp.lib.util.j.kK()) {
                    PbActivity.this.fDd.rd(PbActivity.this.fDg.getPageNum());
                    if (PbActivity.this.fCK != null) {
                        PbActivity.this.fCK.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(e.j.pb_page_error);
            }
        }
    };
    public final View.OnClickListener dud = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Multi-variable search result rejected for r2v175, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v179, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v206, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v315, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            String name;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String str;
            int i;
            bg bgVar;
            String[] strArr;
            boolean q;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fDg.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fDd.kp(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fDg.bgw();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfE()) {
                        if (view == PbActivity.this.fDg.fMc.aZe) {
                            if (PbActivity.this.fDg.kK(PbActivity.this.fDd.beK())) {
                                PbActivity.this.awt();
                                return;
                            }
                            PbActivity.this.fCN = false;
                            PbActivity.this.fCL = false;
                            com.baidu.adp.lib.util.l.a(PbActivity.this, PbActivity.this.fDg.fMc.aZe);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fDg.bgt() && (PbActivity.this.fDg.fMc.bhH() == null || (view != PbActivity.this.fDg.fMc.bhH().bfD() && view != PbActivity.this.fDg.fMc.bhH().bfB()))) {
                            if (view == PbActivity.this.fDg.bgN()) {
                                if (PbActivity.this.fDd != null) {
                                    com.baidu.tbadk.browser.a.ae(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fDd.getPbData().bbJ().wl().getLink());
                                }
                            } else if (view != PbActivity.this.fDg.fMc.fRd && view.getId() != e.g.view_forum_name) {
                                if (view == PbActivity.this.fDg.fMc.fRe) {
                                    if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null) {
                                        ArrayList<PostData> bbL = PbActivity.this.fDd.getPbData().bbL();
                                        if ((bbL == null || bbL.size() <= 0) && PbActivity.this.fDd.beE()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").al("tid", PbActivity.this.fDd.beD()).al("uid", TbadkCoreApplication.getCurrentAccount()).al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getForumId()));
                                        if (!PbActivity.this.fDg.bhc()) {
                                            PbActivity.this.fDg.bga();
                                        }
                                        PbActivity.this.bdq();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != e.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfp()) {
                                        if ((PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfA()) && view.getId() != e.g.floor_owner_reply && view.getId() != e.g.reply_title) {
                                            if (PbActivity.this.fDg.fMc.bhH() == null || (view != PbActivity.this.fDg.fMc.bhH().getCancelView() && view != PbActivity.this.fDg.fMc.bhH().bfz())) {
                                                if (view != PbActivity.this.fDg.fMc.fRf && view.getId() != e.g.share_num_container) {
                                                    if (PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfx()) {
                                                        if ((PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfG()) && view.getId() != e.g.pb_sort) {
                                                            if (PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfy()) {
                                                                if (PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfH()) {
                                                                    if (PbActivity.this.fDm == null || view != PbActivity.this.fDm.bfr()) {
                                                                        if (PbActivity.this.fDm == null || view != PbActivity.this.fDm.bfp()) {
                                                                            if (PbActivity.this.fDm == null || view != PbActivity.this.fDm.bfs()) {
                                                                                if (PbActivity.this.fDm == null || view != PbActivity.this.fDm.bft()) {
                                                                                    if (PbActivity.this.fDm == null || view != PbActivity.this.fDm.bfv()) {
                                                                                        if (PbActivity.this.fDm == null || view != PbActivity.this.fDm.bfw()) {
                                                                                            if (PbActivity.this.fDm == null || view != PbActivity.this.fDm.bfu()) {
                                                                                                if (PbActivity.this.fDg.bgX() == view) {
                                                                                                    if (PbActivity.this.fDg.bgX().getIndicateStatus()) {
                                                                                                        com.baidu.tieba.pb.data.d pbData = PbActivity.this.fDd.getPbData();
                                                                                                        if (pbData != null && pbData.bbJ() != null && pbData.bbJ().vT() != null) {
                                                                                                            String uL = pbData.bbJ().vT().uL();
                                                                                                            if (StringUtils.isNull(uL)) {
                                                                                                                uL = pbData.bbJ().vT().getTaskId();
                                                                                                            }
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").al(VideoPlayActivityConfig.OBJ_ID, uL));
                                                                                                        }
                                                                                                    } else {
                                                                                                        com.baidu.tieba.tbadkCore.d.a.cv("c10725", null);
                                                                                                    }
                                                                                                    PbActivity.this.bdK();
                                                                                                } else if (PbActivity.this.fDg.bgq() != view) {
                                                                                                    if (PbActivity.this.fDm == null || view != PbActivity.this.fDm.bfq()) {
                                                                                                        if (PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfF()) {
                                                                                                            if (PbActivity.this.fDg.fMc.bhH() != null && view == PbActivity.this.fDg.fMc.bhH().bfC()) {
                                                                                                                if (com.baidu.adp.lib.util.j.kK()) {
                                                                                                                    SparseArray<Object> c2 = PbActivity.this.fDg.c(PbActivity.this.fDd.getPbData(), PbActivity.this.fDd.beE(), 1);
                                                                                                                    if (c2 != null) {
                                                                                                                        if (StringUtils.isNull((String) c2.get(e.g.tag_del_multi_forum))) {
                                                                                                                            PbActivity.this.fDg.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                                        } else {
                                                                                                                            PbActivity.this.fDg.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(e.g.tag_del_multi_forum));
                                                                                                                        }
                                                                                                                    }
                                                                                                                    PbActivity.this.fDg.fMc.tF();
                                                                                                                } else {
                                                                                                                    PbActivity.this.showToast(e.j.network_not_available);
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (view.getId() != e.g.sub_pb_more && view.getId() != e.g.sub_pb_item && view.getId() != e.g.pb_floor_reply_more && view.getId() != e.g.new_sub_pb_list_richText) {
                                                                                                                if (view != PbActivity.this.fDg.bcZ()) {
                                                                                                                    if (view == PbActivity.this.fDg.fMc.bhI()) {
                                                                                                                        PbActivity.this.fDg.bgC();
                                                                                                                    } else {
                                                                                                                        int id = view.getId();
                                                                                                                        if (id == e.g.pb_u9_text_view) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin() && (bgVar = (bg) view.getTag()) != null && !StringUtils.isNull(bgVar.ya())) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                                ay.AN().c(PbActivity.this.getPageContext(), new String[]{bgVar.ya()});
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.replybtn || id == e.g.cover_reply_content || id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right || id == e.g.image_more_tip) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11740"));
                                                                                                                                PostData postData = null;
                                                                                                                                if (view != null && view.getTag() != null) {
                                                                                                                                    postData = (PostData) ((SparseArray) view.getTag()).get(e.g.tag_load_sub_data);
                                                                                                                                    if (PbActivity.this.fDm == null) {
                                                                                                                                        PbActivity.this.fDm = new y(PbActivity.this.getPageContext(), PbActivity.this.dud);
                                                                                                                                        PbActivity.this.fDg.bC(PbActivity.this.fDm.getView());
                                                                                                                                        PbActivity.this.fDm.kt(PbActivity.this.mIsLogin);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fDm.showDialog();
                                                                                                                                    if (id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right) {
                                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").al("tid", PbActivity.this.fDd.fIj));
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray = new SparseArray();
                                                                                                                                    sparseArray.put(e.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(e.g.tag_clip_board));
                                                                                                                                    sparseArray.put(e.g.tag_is_subpb, false);
                                                                                                                                    PbActivity.this.fDm.bfp().setTag(sparseArray);
                                                                                                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                                                                    boolean booleanValue = ((Boolean) sparseArray2.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                                                                    boolean booleanValue2 = ((Boolean) sparseArray2.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                                                    boolean booleanValue3 = ((Boolean) sparseArray2.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                                                                    if (!(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                        z = false;
                                                                                                                                    } else {
                                                                                                                                        z = ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                    }
                                                                                                                                    String str2 = null;
                                                                                                                                    if (sparseArray2.get(e.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                        str2 = (String) sparseArray2.get(e.g.tag_forbid_user_post_id);
                                                                                                                                    }
                                                                                                                                    if (booleanValue) {
                                                                                                                                        SparseArray sparseArray3 = new SparseArray();
                                                                                                                                        sparseArray3.put(e.g.tag_should_manage_visible, true);
                                                                                                                                        sparseArray3.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_name, sparseArray2.get(e.g.tag_forbid_user_name));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_name_show, sparseArray2.get(e.g.tag_forbid_user_name_show));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_portrait, sparseArray2.get(e.g.tag_forbid_user_portrait));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_post_id, str2);
                                                                                                                                        if (booleanValue2) {
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_visible, true);
                                                                                                                                            sparseArray3.put(e.g.tag_is_mem, sparseArray2.get(e.g.tag_is_mem));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_userid, sparseArray2.get(e.g.tag_user_mute_mute_userid));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_username, sparseArray2.get(e.g.tag_user_mute_mute_username));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_nameshow, sparseArray2.get(e.g.tag_user_mute_mute_nameshow));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_post_id, sparseArray2.get(e.g.tag_user_mute_post_id));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_thread_id, sparseArray2.get(e.g.tag_user_mute_thread_id));
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        }
                                                                                                                                        if (booleanValue3) {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, true);
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                            PbActivity.this.fDm.bfs().setVisibility(0);
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, false);
                                                                                                                                            PbActivity.this.fDm.bfs().setVisibility(8);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fDm.bfq().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fDm.bfs().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fDm.bfq().setText(e.j.bar_manager);
                                                                                                                                        PbActivity.this.fDm.bfq().setVisibility(0);
                                                                                                                                    } else if (!booleanValue3) {
                                                                                                                                        PbActivity.this.fDm.bfq().setVisibility(8);
                                                                                                                                        PbActivity.this.fDm.bfs().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        SparseArray sparseArray4 = new SparseArray();
                                                                                                                                        sparseArray4.put(e.g.tag_should_manage_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_should_delete_visible, true);
                                                                                                                                        sparseArray4.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                        PbActivity.this.fDm.bfq().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fDm.bfs().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fDm.bfq().setText(e.j.delete);
                                                                                                                                        PbActivity.this.fDm.bfs().setVisibility(0);
                                                                                                                                        if (PbActivity.this.fDd.getPbData().bbV() != 1002 || z) {
                                                                                                                                            PbActivity.this.fDm.bfs().setText(e.j.delete);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fDm.bfs().setText(e.j.report_text);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fDm.bfq().setVisibility(8);
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                                                                    if (!(sparseArray5.get(e.g.tag_user_mute_visible) instanceof Boolean)) {
                                                                                                                                        z2 = false;
                                                                                                                                    } else {
                                                                                                                                        z2 = ((Boolean) sparseArray5.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                                                    }
                                                                                                                                    if (!((Boolean) sparseArray5.get(e.g.tag_should_manage_visible)).booleanValue() && z2) {
                                                                                                                                        SparseArray sparseArray6 = new SparseArray();
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_visible, true);
                                                                                                                                        sparseArray6.put(e.g.tag_is_mem, sparseArray5.get(e.g.tag_is_mem));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_userid, sparseArray5.get(e.g.tag_user_mute_mute_userid));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_username, sparseArray5.get(e.g.tag_user_mute_mute_username));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_nameshow, sparseArray5.get(e.g.tag_user_mute_mute_nameshow));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_post_id, sparseArray5.get(e.g.tag_user_mute_post_id));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_thread_id, sparseArray5.get(e.g.tag_user_mute_thread_id));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_is_self, sparseArray5.get(e.g.tag_del_post_is_self));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_type, sparseArray5.get(e.g.tag_del_post_type));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_id, sparseArray5.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray6.put(e.g.tag_manage_user_identity, sparseArray5.get(e.g.tag_manage_user_identity));
                                                                                                                                        PbActivity.this.fDm.bfr().setTag(sparseArray6);
                                                                                                                                        PbActivity.this.fDm.bfr().setVisibility(0);
                                                                                                                                        PbActivity.this.fDm.bfq().setVisibility(8);
                                                                                                                                        PbActivity.this.fDm.bfr().setText(e.j.mute_option);
                                                                                                                                    } else {
                                                                                                                                        if (!(sparseArray5.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                            z3 = false;
                                                                                                                                        } else {
                                                                                                                                            z3 = ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                        }
                                                                                                                                        String str3 = null;
                                                                                                                                        if (sparseArray5.get(e.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                            str3 = (String) sparseArray5.get(e.g.tag_forbid_user_post_id);
                                                                                                                                        }
                                                                                                                                        boolean kb = PbActivity.this.kb(z3) & PbActivity.this.isLogin();
                                                                                                                                        PbActivity.this.fEn = (PostData) sparseArray5.get(e.g.tag_clip_board);
                                                                                                                                        if (aq.k(PbActivity.this.fEn) ? false : kb) {
                                                                                                                                            PbActivity.this.fDm.bfr().setVisibility(0);
                                                                                                                                            PbActivity.this.fDm.bfr().setTag(str3);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fDm.bfr().setVisibility(8);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                                                                                                                    long j = 0;
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                        z4 = false;
                                                                                                                                    } else {
                                                                                                                                        z4 = ((Boolean) sparseArray7.get(e.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                                    }
                                                                                                                                    if (sparseArray7.get(e.g.tag_chudian_template_id) instanceof Long) {
                                                                                                                                        j = ((Long) sparseArray7.get(e.g.tag_chudian_template_id)).longValue();
                                                                                                                                    }
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_chudian_monitor_id) instanceof String)) {
                                                                                                                                        str = "";
                                                                                                                                    } else {
                                                                                                                                        str = (String) sparseArray7.get(e.g.tag_chudian_monitor_id);
                                                                                                                                    }
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_chudian_hide_day) instanceof Integer)) {
                                                                                                                                        i = 0;
                                                                                                                                    } else {
                                                                                                                                        i = ((Integer) sparseArray7.get(e.g.tag_chudian_hide_day)).intValue();
                                                                                                                                    }
                                                                                                                                    if (z4) {
                                                                                                                                        PbActivity.this.fDm.bfu().setVisibility(0);
                                                                                                                                        PbActivity.this.fDm.bfu().setTag(e.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                        PbActivity.this.fDm.bfu().setTag(e.g.tag_chudian_monitor_id, str);
                                                                                                                                        PbActivity.this.fDm.bfu().setTag(e.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fDm.bfu().setVisibility(8);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                boolean z5 = false;
                                                                                                                                if (PbActivity.this.fDd.getPbData().sR()) {
                                                                                                                                    String sQ = PbActivity.this.fDd.getPbData().sQ();
                                                                                                                                    if (postData != null && !com.baidu.adp.lib.util.k.isEmpty(sQ) && sQ.equals(postData.getId())) {
                                                                                                                                        z5 = true;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (z5) {
                                                                                                                                    PbActivity.this.fDm.bfp().setText(e.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fDm.bfp().setText(e.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fDm.bfw().setVisibility(8);
                                                                                                                                PbActivity.this.fDm.bfv().setVisibility(8);
                                                                                                                                if (postData != null) {
                                                                                                                                    if (postData.byO() == null || postData.byO().toString().length() <= 0) {
                                                                                                                                        PbActivity.this.fDm.bft().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fDm.bft().setVisibility(0);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fEn = postData;
                                                                                                                                }
                                                                                                                                PbActivity.this.fDm.refreshUI();
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_act_btn) {
                                                                                                                            if (PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bbJ() != null && PbActivity.this.fDd.getPbData().bbJ().getActUrl() != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), PbActivity.this.fDd.getPbData().bbJ().getActUrl());
                                                                                                                                if (PbActivity.this.fDd.getPbData().bbJ().wQ() != 1) {
                                                                                                                                    if (PbActivity.this.fDd.getPbData().bbJ().wQ() == 2) {
                                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.lottery_tail) {
                                                                                                                            if (view.getTag(e.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                                String str4 = (String) view.getTag(e.g.tag_pb_lottery_tail_link);
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getPbData().getForumId()).al("tid", PbActivity.this.fDd.getPbData().getThreadId()).al("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                                if (PbActivity.this.fDd.getPbData().getThreadId().equals(str4)) {
                                                                                                                                    PbActivity.this.fDg.setSelection(0);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_item_tail_content) {
                                                                                                                            if (ba.bA(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                                String string = TbadkCoreApplication.getInst().getString(e.j.tail_web_view_title);
                                                                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                                if (!StringUtils.isNull(string2)) {
                                                                                                                                    TiebaStatic.log("c10056");
                                                                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                                }
                                                                                                                                PbActivity.this.fDg.bga();
                                                                                                                            }
                                                                                                                        } else if (id == e.g.join_vote_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                if (PbActivity.this.bdn() == 1 && PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getPbData().getForumId()).al("tid", PbActivity.this.fDd.getPbData().getThreadId()).al("uid", currentAccount));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.look_all_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                if (PbActivity.this.bdn() == 1 && PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getPbData().getForumId()).al("tid", PbActivity.this.fDd.getPbData().getThreadId()).al("uid", currentAccount2));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.manga_prev_btn) {
                                                                                                                            PbActivity.this.bdF();
                                                                                                                        } else if (id == e.g.manga_next_btn) {
                                                                                                                            PbActivity.this.bdG();
                                                                                                                        } else if (id == e.g.yule_head_img_img) {
                                                                                                                            if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bcd() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fDd.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").al(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                                ay.AN().c(PbActivity.this.getPageContext(), new String[]{pbData2.bcd().bcm()});
                                                                                                                            }
                                                                                                                        } else if (id == e.g.yule_head_img_all_rank) {
                                                                                                                            if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bcd() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fDd.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").al(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                                ay.AN().c(PbActivity.this.getPageContext(), new String[]{pbData3.bcd().bcm()});
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.fDg.fMc.bhH() != null && view == PbActivity.this.fDg.fMc.bhH().bfI()) {
                                                                                                                            if (PbActivity.this.fDd == null || PbActivity.this.fDd.getPbData() == null || PbActivity.this.fDd.getPbData().bbJ() == null) {
                                                                                                                                PbActivity.this.fDg.fMc.tF();
                                                                                                                                return;
                                                                                                                            } else if (!com.baidu.adp.lib.util.l.lb()) {
                                                                                                                                PbActivity.this.showToast(e.j.neterror);
                                                                                                                                return;
                                                                                                                            } else {
                                                                                                                                int i2 = 1;
                                                                                                                                if (PbActivity.this.fDd.getPbData().bbJ().vU() == 0) {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fDd.beD(), 25028)));
                                                                                                                                } else {
                                                                                                                                    BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(e.j.haved_fans_called)).yt();
                                                                                                                                    i2 = 2;
                                                                                                                                }
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").w("obj_locate", PbActivity.this.al(PbActivity.this.fDd.getPbData().bbJ())).al("tid", PbActivity.this.fDd.getPbData().bbJ().getTid()).w("obj_type", i2));
                                                                                                                            }
                                                                                                                        } else if (id == e.g.tv_pb_reply_more) {
                                                                                                                            if (PbActivity.this.fDG >= 0) {
                                                                                                                                if (PbActivity.this.fDd != null) {
                                                                                                                                    PbActivity.this.fDd.bfj();
                                                                                                                                }
                                                                                                                                if (PbActivity.this.fDg.bgr() != null) {
                                                                                                                                    PbActivity.this.fDg.bgr().a(PbActivity.this.fDd.getPbData(), false);
                                                                                                                                }
                                                                                                                                PbActivity.this.fDg.getListView().setSelection(PbActivity.this.fDd.bfm());
                                                                                                                                PbActivity.this.fDG = 0;
                                                                                                                                if (PbActivity.this.fDd != null) {
                                                                                                                                    PbActivity.this.fDd.bu(0, 0);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.single_bar_tips) {
                                                                                                                            PbActivity.this.fDg.bhg();
                                                                                                                        } else if (id == e.g.pb_post_recommend_live_layout) {
                                                                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                                TiebaStatic.log("c12640");
                                                                                                                            }
                                                                                                                        } else if (id == e.g.thread_info_commont_container) {
                                                                                                                            PbActivity.this.fDg.bgf();
                                                                                                                        } else if (id == e.g.new_sub_pb_list_richText) {
                                                                                                                            SparseArray sparseArray8 = null;
                                                                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                                                                sparseArray8 = (SparseArray) view.getTag();
                                                                                                                            }
                                                                                                                            if (sparseArray8 != null) {
                                                                                                                                PbActivity.this.c(sparseArray8);
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.fDd.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.fDd.beD(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fDd.getPbData().bbJ().wH())));
                                                                                                                }
                                                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                if (PbActivity.this.fDd.getPbData() != null) {
                                                                                                                    PbActivity.this.fDg.bgK();
                                                                                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                    PostData postData2 = (PostData) sparseArray9.get(e.g.tag_load_sub_data);
                                                                                                                    View view2 = (View) sparseArray9.get(e.g.tag_load_sub_view);
                                                                                                                    if (postData2 != null && view2 != null) {
                                                                                                                        if (postData2.byY() == 1) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                                                        }
                                                                                                                        String beD = PbActivity.this.fDd.beD();
                                                                                                                        String id2 = postData2.getId();
                                                                                                                        int i3 = 0;
                                                                                                                        if (PbActivity.this.fDd.getPbData() != null) {
                                                                                                                            i3 = PbActivity.this.fDd.getPbData().bbV();
                                                                                                                        }
                                                                                                                        PbActivity.this.awt();
                                                                                                                        if (view.getId() == e.g.replybtn) {
                                                                                                                            c rP = PbActivity.this.rP(id2);
                                                                                                                            if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && rP != null) {
                                                                                                                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(beD, id2, "pb", true, null, true, null, i3, postData2.bix(), PbActivity.this.fDd.getPbData().vj(), false, postData2.wm().getIconInfo()).addBigImageData(rP.fEX, rP.fEY, rP.fEZ, rP.index);
                                                                                                                                addBigImageData.setKeyPageStartFrom(PbActivity.this.fDd.bfi());
                                                                                                                                addBigImageData.setFromFrsForumId(PbActivity.this.fDd.getFromForumId());
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            c rP2 = PbActivity.this.rP(id2);
                                                                                                                            if (postData2 != null && PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && rP2 != null) {
                                                                                                                                SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(beD, id2, "pb", true, null, false, null, i3, postData2.bix(), PbActivity.this.fDd.getPbData().vj(), false, postData2.wm().getIconInfo()).addBigImageData(rP2.fEX, rP2.fEY, rP2.fEZ, rP2.index);
                                                                                                                                addBigImageData2.setKeyPageStartFrom(PbActivity.this.fDd.bfi());
                                                                                                                                addBigImageData2.setFromFrsForumId(PbActivity.this.fDd.getFromForumId());
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData2));
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
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").w("obj_locate", 3).al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getPbData().getForumId()));
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (com.baidu.adp.lib.util.j.kK()) {
                                                                                                            PbActivity.this.fDg.bgK();
                                                                                                            SparseArray<Object> c3 = PbActivity.this.fDg.c(PbActivity.this.fDd.getPbData(), PbActivity.this.fDd.beE(), 1);
                                                                                                            if (c3 != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fDd.getPbData().bbH().getId(), PbActivity.this.fDd.getPbData().bbH().getName(), PbActivity.this.fDd.getPbData().bbJ().getId(), String.valueOf(PbActivity.this.fDd.getPbData().getUserData().getUserId()), (String) c3.get(e.g.tag_forbid_user_name), (String) c3.get(e.g.tag_forbid_user_name_show), (String) c3.get(e.g.tag_forbid_user_post_id), (String) c3.get(e.g.tag_forbid_user_portrait))));
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(e.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (!com.baidu.adp.lib.util.j.kK()) {
                                                                                                        PbActivity.this.showToast(e.j.network_not_available);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        SparseArray<Object> sparseArray10 = (SparseArray) view.getTag();
                                                                                                        if (sparseArray10 != null) {
                                                                                                            boolean booleanValue4 = ((Boolean) sparseArray10.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                                            boolean booleanValue5 = ((Boolean) sparseArray10.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                                            boolean booleanValue6 = ((Boolean) sparseArray10.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                            if (booleanValue4) {
                                                                                                                if (booleanValue6) {
                                                                                                                    sparseArray10.put(e.g.tag_from, 1);
                                                                                                                    sparseArray10.put(e.g.tag_check_mute_from, 2);
                                                                                                                    PbActivity.this.b(sparseArray10);
                                                                                                                } else {
                                                                                                                    sparseArray10.put(e.g.tag_check_mute_from, 2);
                                                                                                                    PbActivity.this.fDg.bA(view);
                                                                                                                }
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.fDg.a(((Integer) sparseArray10.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray10.get(e.g.tag_del_post_id), ((Integer) sparseArray10.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").w("obj_locate", 2).al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getPbData().getForumId()));
                                                                                                    return;
                                                                                                } else {
                                                                                                    PbActivity.this.bdb();
                                                                                                }
                                                                                            } else {
                                                                                                long j2 = -1;
                                                                                                String str5 = "";
                                                                                                int i4 = 0;
                                                                                                if (view.getTag(e.g.tag_chudian_template_id) instanceof Long) {
                                                                                                    j2 = ((Long) view.getTag(e.g.tag_chudian_template_id)).longValue();
                                                                                                }
                                                                                                if (view.getTag(e.g.tag_chudian_monitor_id) instanceof String) {
                                                                                                    str5 = (String) view.getTag(e.g.tag_chudian_monitor_id);
                                                                                                }
                                                                                                if (view.getTag(e.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                                    i4 = ((Integer) view.getTag(e.g.tag_chudian_hide_day)).intValue();
                                                                                                }
                                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fDd.getPbData();
                                                                                                String str6 = null;
                                                                                                String str7 = null;
                                                                                                String str8 = null;
                                                                                                if (pbData4 != null && pbData4.bbH() != null) {
                                                                                                    str6 = pbData4.bbH().getId();
                                                                                                    str7 = pbData4.bbH().getName();
                                                                                                    str8 = pbData4.getThreadId();
                                                                                                }
                                                                                                com.baidu.tieba.pb.a.a(j2, str5, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str6, str7, str8);
                                                                                                PbActivity.this.a(j2, str5, str6, str7, str8, i4);
                                                                                            }
                                                                                        } else if (PbActivity.this.fDD != null && !TextUtils.isEmpty(PbActivity.this.fDE)) {
                                                                                            if (PbActivity.this.bqO == null) {
                                                                                                PbActivity.this.bqO = new com.baidu.tbadk.core.util.b.a();
                                                                                            }
                                                                                            PbActivity.this.bqO.Bb();
                                                                                            PbActivity.this.bqO.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                            if (!PbActivity.this.bqO.x(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                if (PbActivity.this.fDC == null) {
                                                                                                    PbActivity.this.fDC = new av(PbActivity.this.getPageContext());
                                                                                                }
                                                                                                PbActivity.this.fDC.i(PbActivity.this.fDE, PbActivity.this.fDD.ok());
                                                                                                PbActivity.this.fDD = null;
                                                                                                PbActivity.this.fDE = null;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.fDD != null && !TextUtils.isEmpty(PbActivity.this.fDE)) {
                                                                                        if (PbActivity.this.fDF == null) {
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fDE));
                                                                                        } else {
                                                                                            d.a aVar = new d.a();
                                                                                            aVar.url = PbActivity.this.fDE;
                                                                                            aVar.pkgId = PbActivity.this.fDF.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fDF.memeInfo.pck_id;
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                                        }
                                                                                        PbActivity.this.fDD = null;
                                                                                        PbActivity.this.fDE = null;
                                                                                    }
                                                                                } else if (PbActivity.this.fEn != null) {
                                                                                    PbActivity.this.fEn.cO(PbActivity.this.getPageContext().getPageActivity());
                                                                                    PbActivity.this.fEn = null;
                                                                                }
                                                                            } else {
                                                                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                                                                if (sparseArray11 != null) {
                                                                                    if ((sparseArray11.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_id) instanceof String) && (sparseArray11.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                        PbActivity.this.fDg.a(((Integer) sparseArray11.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(e.g.tag_del_post_id), ((Integer) sparseArray11.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").w("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bs(view);
                                                                                if (PbActivity.this.fDd.getPbData().bbJ() != null && PbActivity.this.fDd.getPbData().bbJ().wm() != null && PbActivity.this.fDd.getPbData().bbJ().wm().getUserId() != null && PbActivity.this.fDf != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").al("tid", PbActivity.this.fDd.fIj).w("obj_locate", 2).al(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fDd.getPbData().bbJ().wm().getUserId()).w("obj_type", PbActivity.this.fDf.sR() ? 0 : 1).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fDd.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (!com.baidu.adp.lib.util.j.kK()) {
                                                                        PbActivity.this.showToast(e.j.network_not_available);
                                                                        return;
                                                                    } else {
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13079"));
                                                                            PbActivity.this.rM((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").w("obj_locate", 4));
                                                                            SparseArray<Object> sparseArray12 = (SparseArray) tag;
                                                                            if ((sparseArray12.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray12.get(e.g.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray12.put(e.g.tag_from, 0);
                                                                                sparseArray12.put(e.g.tag_check_mute_from, 2);
                                                                                PbActivity.this.b(sparseArray12);
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").w("obj_type", 0).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").w("obj_type", 1).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.fDg.fMc.bhG();
                                                                }
                                                            } else if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bbJ() != null) {
                                                                PbActivity.this.fDg.fMc.tF();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                                PbActivity.this.rM(PbActivity.this.fDd.getPbData().bbJ().wD());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fDg.bgK();
                                                            if (com.baidu.adp.lib.util.j.kK()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Integer.valueOf(PbActivity.this.fDd.beR()));
                                                                    return;
                                                                }
                                                                PbActivity.this.qV(2);
                                                                PbActivity.this.awt();
                                                                PbActivity.this.fDg.bgv();
                                                                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(PbActivity.this.getPageContext().getPageActivity());
                                                                if (PbActivity.this.fDd.getPbData().fAD == null || PbActivity.this.fDd.getPbData().fAD.size() <= 0) {
                                                                    strArr = new String[]{PbActivity.this.getResources().getString(e.j.sort_type_new), PbActivity.this.getResources().getString(e.j.sort_type_old)};
                                                                } else {
                                                                    String[] strArr2 = new String[PbActivity.this.fDd.getPbData().fAD.size()];
                                                                    int i5 = 0;
                                                                    while (true) {
                                                                        int i6 = i5;
                                                                        if (i6 >= PbActivity.this.fDd.getPbData().fAD.size()) {
                                                                            break;
                                                                        }
                                                                        strArr2[i6] = PbActivity.this.fDd.getPbData().fAD.get(i6).sort_name + PbActivity.this.getResources().getString(e.j.sort_static);
                                                                        i5 = i6 + 1;
                                                                    }
                                                                    strArr = strArr2;
                                                                }
                                                                bVar.a(strArr, new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                                                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                                                                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i7, View view3) {
                                                                        int i8 = 2;
                                                                        if (PbActivity.this.fDd.Xb() == 1 && i7 == 1) {
                                                                            i8 = 0;
                                                                        } else if (PbActivity.this.fDd.Xb() == 2 && i7 == 0) {
                                                                            i8 = 1;
                                                                        } else if (PbActivity.this.fDd.Xb() != 3 || i7 == 2) {
                                                                            i8 = (i7 != 2 || PbActivity.this.fDd.Xb() == 3) ? 0 : 3;
                                                                        }
                                                                        TiebaStatic.log("c12097");
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != e.g.pb_sort ? 1 : 0).w("obj_type", i8));
                                                                        if (PbActivity.this.fDd.getPbData().fAD != null && PbActivity.this.fDd.getPbData().fAD.size() > i7) {
                                                                            i7 = PbActivity.this.fDd.getPbData().fAD.get(i7).sort_type.intValue();
                                                                        }
                                                                        boolean ri = PbActivity.this.fDd.ri(i7);
                                                                        view.setTag(Integer.valueOf(PbActivity.this.fDd.beR()));
                                                                        if (ri) {
                                                                            PbActivity.this.mIsLoading = true;
                                                                            PbActivity.this.fDg.kB(true);
                                                                        }
                                                                        bVar2.dismiss();
                                                                    }
                                                                });
                                                                bVar.d(PbActivity.this.getPageContext()).yo();
                                                            } else {
                                                                PbActivity.this.showToast(e.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fDg.bgK();
                                                        if (PbActivity.this.bcO().getPbData().fAE != 2) {
                                                            if (PbActivity.this.fDd.getPageData() != null) {
                                                                PbActivity.this.fDg.a(PbActivity.this.fDd.getPageData(), PbActivity.this.fre);
                                                            }
                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            PbActivity.this.showToast(e.j.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (com.baidu.tbadk.p.aw.jw() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fDd != null) {
                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12386");
                                                        amVar.al("tid", PbActivity.this.fDd.beD());
                                                        amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
                                                        amVar.al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getForumId());
                                                        amVar.w("obj_locate", 6);
                                                        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        TiebaStatic.log(amVar);
                                                    }
                                                    if (com.baidu.adp.lib.util.l.lb()) {
                                                        if (PbActivity.this.fDd.getPbData() != null) {
                                                            ArrayList<PostData> bbL2 = PbActivity.this.fDd.getPbData().bbL();
                                                            if ((bbL2 != null && bbL2.size() > 0) || !PbActivity.this.fDd.beE()) {
                                                                PbActivity.this.fDg.bgK();
                                                                PbActivity.this.awt();
                                                                PbActivity.this.qV(2);
                                                                if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bcd() != null && !StringUtils.isNull(PbActivity.this.fDd.getPbData().bcd().uW(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                                if (com.baidu.tbadk.p.aw.jw()) {
                                                                    PbActivity.this.qW(2);
                                                                } else {
                                                                    PbActivity.this.fDg.showLoadingDialog();
                                                                    PbActivity.this.fDd.bfd().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                }
                                                            } else {
                                                                com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        PbActivity.this.showToast(e.j.neterror);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.fDg.fMc.tF();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.kK()) {
                                            PbActivity.this.fDg.bgK();
                                            if (PbActivity.this.fDg.fMc.bhH() != null && view == PbActivity.this.fDg.fMc.bhH().bfA() && !PbActivity.this.fDg.bhc()) {
                                                PbActivity.this.fDg.bga();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.awt();
                                                PbActivity.this.fDg.bgv();
                                                if (view.getId() == e.g.floor_owner_reply) {
                                                    q = PbActivity.this.fDd.q(true, PbActivity.this.bdD());
                                                } else {
                                                    q = view.getId() == e.g.reply_title ? PbActivity.this.fDd.q(false, PbActivity.this.bdD()) : PbActivity.this.fDd.rQ(PbActivity.this.bdD());
                                                }
                                                view.setTag(Boolean.valueOf(q));
                                                if (q) {
                                                    PbActivity.this.fDg.kk(true);
                                                    PbActivity.this.fDg.aNS();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fDg.kB(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.qV(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(e.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.kK()) {
                                        PbActivity.this.fDg.bgK();
                                        if (PbActivity.this.qU(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fDd.rj(PbActivity.this.fDg.bgA()) != null) {
                                            PbActivity.this.bdx();
                                            if (PbActivity.this.fDd.getPbData().bbJ() != null && PbActivity.this.fDd.getPbData().bbJ().wm() != null && PbActivity.this.fDd.getPbData().bbJ().wm().getUserId() != null && PbActivity.this.fDf != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").al("tid", PbActivity.this.fDd.fIj).w("obj_locate", 1).al(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fDd.getPbData().bbJ().wm().getUserId()).w("obj_type", PbActivity.this.fDf.sR() ? 0 : 1).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fDd.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(e.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.kK()) {
                                    PbActivity.this.fDg.kk(true);
                                    PbActivity.this.fDg.bga();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fDg.aNS();
                                        PbActivity.this.awt();
                                        PbActivity.this.fDg.bgv();
                                        PbActivity.this.fDd.rQ(PbActivity.this.bdD());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.qV(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(e.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bbJ() != null && PbActivity.this.fDd.getPbData().bbJ().xa() && PbActivity.this.fDd.getPbData().bbJ().wE() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.fDd.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fDd.bcF()) && PbActivity.this.fDd.getAppealInfo() != null) {
                                        name = PbActivity.this.fDd.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fDd.getPbData().bbH().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bcF = PbActivity.this.fDd.bcF();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fDd.beF() && bcF != null && bcF.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.kK()) {
                            if (PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bbV() == 1 && !PbActivity.this.cFB.bzy()) {
                                PbActivity.this.fDg.bgK();
                                int i7 = 0;
                                if (PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfB()) {
                                    if (PbActivity.this.fDg.fMc.bhH() == null || view != PbActivity.this.fDg.fMc.bhH().bfD()) {
                                        if (view == PbActivity.this.fDg.bgt()) {
                                            i7 = 2;
                                        }
                                    } else if (PbActivity.this.fDd.getPbData().bbJ().wi() == 1) {
                                        i7 = 3;
                                    } else {
                                        i7 = 6;
                                    }
                                } else if (PbActivity.this.fDd.getPbData().bbJ().wh() == 1) {
                                    i7 = 5;
                                } else {
                                    i7 = 4;
                                }
                                ForumData bbH = PbActivity.this.fDd.getPbData().bbH();
                                String name2 = bbH.getName();
                                String id3 = bbH.getId();
                                String id4 = PbActivity.this.fDd.getPbData().bbJ().getId();
                                PbActivity.this.fDg.bgs();
                                PbActivity.this.cFB.a(id3, name2, id4, i7, PbActivity.this.fDg.bgu());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(e.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.kK()) {
                        PbActivity.this.fDg.bgK();
                        PbActivity.this.awt();
                        PbActivity.this.fDg.bgv();
                        PbActivity.this.fDg.showLoadingDialog();
                        if (PbActivity.this.fDg.bgi() != null) {
                            PbActivity.this.fDg.bgi().setVisibility(8);
                        }
                        PbActivity.this.fDd.rd(1);
                        if (PbActivity.this.fCK != null) {
                            PbActivity.this.fCK.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(e.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(e.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == e.g.reply_god_title_group) {
                        String bdk = PbActivity.this.bdk();
                        if (!TextUtils.isEmpty(bdk)) {
                            ay.AN().c(PbActivity.this.getPageContext(), new String[]{bdk});
                        }
                    }
                } else if (PbActivity.this.fCU) {
                    PbActivity.this.fCU = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(e.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData3 = (PostData) obj;
                            if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.bdf().bfY() != null && postData3.wm() != null && postData3.byM() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bdf().bfZ() != null) {
                                    PbActivity.this.bdf().bfZ().beq();
                                }
                                com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                jVar.a(PbActivity.this.fDd.getPbData().bbH());
                                jVar.aa(PbActivity.this.fDd.getPbData().bbJ());
                                jVar.e(postData3);
                                PbActivity.this.bdf().bfY().d(jVar);
                                PbActivity.this.bdf().bfY().setPostId(postData3.getId());
                                PbActivity.this.a(view, postData3.wm().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fDt != null) {
                                    PbActivity.this.fDg.kL(PbActivity.this.fDt.Jp());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aRr = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.v vVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null) {
                    amVar.al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getPbData().getForumId());
                }
                if (PbActivity.this.fDd != null) {
                    amVar.al("tid", PbActivity.this.fDd.beD());
                }
                amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.awt();
            PbActivity.this.fDg.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.an.Mq() && PbActivity.this.bcO() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bcO().rT(postWriteCallBackData.getPostId());
                    PbActivity.this.fDG = PbActivity.this.fDg.bgd();
                    if (PbActivity.this.fDd != null) {
                        PbActivity.this.fDd.bu(PbActivity.this.fDG, PbActivity.this.fDg.bge());
                    }
                }
                PbActivity.this.fDg.bgK();
                PbActivity.this.fDl.bhk();
                if (PbActivity.this.fDt != null) {
                    PbActivity.this.fDg.kL(PbActivity.this.fDt.Jp());
                }
                PbActivity.this.fDg.bfX();
                PbActivity.this.fDg.kN(true);
                PbActivity.this.fDd.beT();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fDd.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fDd.getPbData();
                            if (pbData != null && pbData.bbJ() != null && pbData.bbJ().wm() != null && (userId = pbData.bbJ().wm().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.an.Mq() && PbActivity.this.fDd.beM()) {
                                PbActivity.this.fDg.bgv();
                            }
                        } else if (!com.baidu.tbadk.p.an.Mq() && PbActivity.this.fDd.beM()) {
                            PbActivity.this.fDg.bgv();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fDg.n(PbActivity.this.fDd.getPbData());
                    }
                    if (PbActivity.this.fDd.beI()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").al("tid", PbActivity.this.fDd.beD()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fDt.Jv() || PbActivity.this.fDt.Jw()) {
                    PbActivity.this.fDt.a(false, postWriteCallBackData);
                }
                PbActivity.this.fDl.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.ePn != null) {
                    PbActivity.this.ePn.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (vVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fEf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.v vVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null) {
                    amVar.al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getPbData().getForumId());
                }
                if (PbActivity.this.fDd != null) {
                    amVar.al("tid", PbActivity.this.fDd.beD());
                }
                amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.fDl != null) {
                    PbActivity.this.fDl.bhj();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.ePn != null) {
                    PbActivity.this.ePn.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.fDl != null) {
                if (PbActivity.this.fDg != null && PbActivity.this.fDg.bfZ() != null && PbActivity.this.fDg.bfZ().bev() != null && PbActivity.this.fDg.bfZ().bev().Jw()) {
                    PbActivity.this.fDg.bfZ().bev().a(postWriteCallBackData);
                }
                PbActivity.this.fDl.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fEg = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g eW;
            if (!z || dVar == null || dVar.bbT() != null || com.baidu.tbadk.core.util.v.y(dVar.bbL()) >= 1) {
                PbActivity.this.fgn = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fDg.bgx();
                if (dVar == null || !dVar.bbP()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fDg.getView());
                }
                PbActivity.this.fDg.aNR();
                if (PbActivity.this.isFullScreen || PbActivity.this.fDg.bhc()) {
                    PbActivity.this.fDg.bgT();
                } else if (!PbActivity.this.fDg.bgQ()) {
                    PbActivity.this.fDg.kN(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fDn = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.fDg.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.fDg.aiB();
                    if (dVar.bbJ() != null && dVar.bbJ().xh() != null) {
                        PbActivity.this.a(dVar.bbJ().xh());
                    }
                    PbActivity.this.bdc();
                    if (PbActivity.this.fDt != null) {
                        PbActivity.this.fDg.kL(PbActivity.this.fDt.Jp());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bbL() != null && dVar.bbL().size() >= 1 && dVar.bbL().get(0) != null) {
                        PbActivity.this.fDd.rS(dVar.bbL().get(0).getId());
                    } else if (dVar.bbT() != null) {
                        PbActivity.this.fDd.rS(dVar.bbT().getId());
                    }
                    if (PbActivity.this.fDt != null) {
                        PbActivity.this.fDt.a(dVar.vj());
                        PbActivity.this.fDt.a(dVar.bbH(), dVar.getUserData());
                        PbActivity.this.fDt.a(PbActivity.this.fDd.beN(), PbActivity.this.fDd.beD(), PbActivity.this.fDd.bff());
                        if (dVar.bbJ() != null) {
                            PbActivity.this.fDt.bW(dVar.bbJ().xx());
                        }
                    }
                    if (PbActivity.this.fDf != null) {
                        PbActivity.this.fDf.an(dVar.sR());
                    }
                    if (dVar == null || dVar.bbW() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fDg.kM(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fDg.a(dVar, i2, i3, PbActivity.this.fDd.beE(), i4, PbActivity.this.fDd.getIsFromMark());
                    PbActivity.this.fDg.d(dVar, PbActivity.this.fDd.beE());
                    PbActivity.this.fDg.kJ(PbActivity.this.fDd.getHostMode());
                    AntiData vj = dVar.vj();
                    if (vj != null) {
                        PbActivity.this.aRh = vj.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aRh) && PbActivity.this.fDt != null && PbActivity.this.fDt.IJ() != null && (eW = PbActivity.this.fDt.IJ().eW(6)) != null && !TextUtils.isEmpty(PbActivity.this.aRh)) {
                            ((View) eW).setOnClickListener(PbActivity.this.aRR);
                        }
                    }
                    if (PbActivity.this.fDp) {
                        PbActivity.this.fDp = false;
                        final int bds = PbActivity.this.bds();
                        if (dVar.bci()) {
                            final int aO = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bds, aO);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bdf().rp(bds);
                        }
                    }
                    if (PbActivity.this.fDq) {
                        PbActivity.this.fDq = false;
                        final int bds2 = PbActivity.this.bds();
                        final boolean z2 = bds2 != -1;
                        if (!z2) {
                            bds2 = PbActivity.this.bdt();
                        }
                        if (PbActivity.this.bdf() != null) {
                            if (dVar.bci()) {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bds2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bds2, aO2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bds2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.bdf().kO(true);
                            } else {
                                PbActivity.this.bdf().rp(bds2);
                            }
                        }
                    } else {
                        PbActivity.this.fDg.bgB();
                    }
                    PbActivity.this.fDd.a(dVar.bbH(), PbActivity.this.fDT);
                    PbActivity.this.fDd.a(PbActivity.this.fDU);
                    if (PbActivity.this.ePn != null && dVar.bbJ() != null && dVar.bbJ().wm() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bbJ().wm());
                        PbActivity.this.ePn.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fDn && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fDd != null && PbActivity.this.fDd.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fDd.getAppealInfo().fzV)) {
                                    PbActivity.this.fDg.a(PbActivity.this.fDd.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fDg.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0141e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fDg.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0141e.ds200));
                            }
                            PbActivity.this.fDg.bgT();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fDd.beD());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.j jVar = new com.baidu.tbadk.core.util.j();
                        jVar.setOpType("2");
                        jVar.start();
                    }
                    if (i != -1) {
                        PbActivity.this.fDg.rW(PbActivity.this.getResources().getString(e.j.list_no_more_new));
                    } else {
                        PbActivity.this.fDg.rW("");
                    }
                    PbActivity.this.fDg.BJ();
                }
                PbActivity.this.aXi = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bcO().beE() || PbActivity.this.bcO().getPbData().vy().vv() != 0 || PbActivity.this.bcO().beZ()) {
                    PbActivity.this.fDu = true;
                    return;
                }
                return;
            }
            PbActivity.this.fDd.rd(1);
            if (PbActivity.this.fCK != null) {
                PbActivity.this.fCK.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fDg.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.m.LZ().Ma()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.cYB : j;
                com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, PbActivity.this.aXa, PbActivity.this.createTime, PbActivity.this.aXi, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aXa = 0L;
                if (iVar != null) {
                    iVar.LW();
                }
                if (z2) {
                    iVar.aXr = currentTimeMillis;
                    iVar.ck(true);
                }
                if (!z2 && PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bbJ() != null) {
                    int threadType = PbActivity.this.fDd.getPbData().bbJ().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fCX, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fCX, "from_frs")) {
                                com.baidu.tbadk.l.i iVar2 = new com.baidu.tbadk.l.i();
                                iVar2.fx(1000);
                                iVar2.aXt = currentTimeMillis;
                                iVar2.fy(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.l.d dVar = new com.baidu.tbadk.l.d();
                        dVar.pageType = 1;
                        dVar.fx(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
                        dVar.aXt = currentTimeMillis;
                        dVar.fy(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fEh = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bdo();
            }
        }
    };
    private final a.InterfaceC0096a fEi = new a.InterfaceC0096a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0096a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fDg.bgx();
            if (z) {
                if (PbActivity.this.fDf != null) {
                    PbActivity.this.fDf.an(z2);
                }
                PbActivity.this.fDd.kr(z2);
                if (PbActivity.this.fDd.sR()) {
                    PbActivity.this.bdy();
                } else {
                    PbActivity.this.fDg.n(PbActivity.this.fDd.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fDf != null && PbActivity.this.fDf.sU() != null && PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bbJ() != null && PbActivity.this.fDd.getPbData().bbJ().wm() != null) {
                        MarkData sU = PbActivity.this.fDf.sU();
                        MetaData wm = PbActivity.this.fDd.getPbData().bbJ().wm();
                        if (sU != null && wm != null) {
                            if (!com.baidu.tbadk.core.util.ao.equals(TbadkCoreApplication.getCurrentAccount(), wm.getUserId()) && !wm.hadConcerned()) {
                                PbActivity.this.b(wm);
                                return;
                            } else {
                                PbActivity.this.showToast(e.j.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.qR(PbActivity.this.mLastScrollState) && PbActivity.this.qR(i)) {
                if (PbActivity.this.fDg != null) {
                    PbActivity.this.fDg.bgK();
                    if (PbActivity.this.fDt != null && !PbActivity.this.fDg.bgb()) {
                        PbActivity.this.fDg.kL(PbActivity.this.fDt.Jp());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fDg.bga();
                    }
                }
                if (!PbActivity.this.fCR) {
                    PbActivity.this.fCR = true;
                    PbActivity.this.fDg.bgP();
                }
            }
            PbActivity.this.fDg.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fCK != null) {
                PbActivity.this.fCK.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fCS == null) {
                PbActivity.this.fCS = new com.baidu.tbadk.l.b();
                PbActivity.this.fCS.fx(1001);
            }
            if (i == 0) {
                PbActivity.this.fCS.LQ();
            } else {
                PbActivity.this.fCS.LP();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bbL;
            if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDg != null && PbActivity.this.fDg.bgr() != null) {
                PbActivity.this.fDg.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fCK != null) {
                    PbActivity.this.fCK.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fDd.beV() && (bbL = PbActivity.this.fDd.getPbData().bbL()) != null && !bbL.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fDg.bgr().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fDd.getPbData();
                    if (pbData != null) {
                        if (pbData.bbM() != null && pbData.bbM().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bbN() != null && pbData.bbN().hasData()) {
                            headerCount--;
                        }
                        int size = bbL.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cFF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.adp.base.d
        public void j(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cFB.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fDd.beT();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fSV != 1002 || bVar.dXb) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fDg.a(1, dVar.Hs, dVar.gXX, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cFB.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fDg.a(PbActivity.this.cFB.getLoadDataMode(), gVar.Hs, gVar.gXX, false);
                        PbActivity.this.fDg.aq(gVar.gYa);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fDg.a(PbActivity.this.cFB.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fEj = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
    };
    private final j.b bvp = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.tbadk.core.view.j.b
        public void bf(boolean z) {
            if (PbActivity.this.bdE()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fDd.kq(true)) {
                PbActivity.this.fDg.bgy();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e dLy = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fEk && PbActivity.this.bdE()) {
                PbActivity.this.bdG();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fDd.kp(false)) {
                    PbActivity.this.fDg.bgw();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fDd.getPbData() != null) {
                    PbActivity.this.fDg.bgO();
                }
                PbActivity.this.fEk = true;
            }
        }
    };
    private int fEl = 0;
    private final TbRichTextView.h bjz = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fDg.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(e.g.tag_rich_text_meme_info) != null && (view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    PbActivity.this.fDb = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fFa) {
                    TbRichText aG = PbActivity.this.aG(str, i);
                    if (aG != null && PbActivity.this.fEl >= 0 && PbActivity.this.fEl < aG.OP().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aG.OP().get(PbActivity.this.fEl));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fEX.size()) {
                                break;
                            } else if (!cVar.fEX.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.z(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fEY.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fEZ, cVar.lastId, PbActivity.this.fDd.beQ(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbActivity.this.l(rect);
                        createConfig.setIsHotSort(PbActivity.this.fDd.Xb() == 2);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.d(cVar.fEX, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.z(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fEY.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fEZ, cVar.fEX.get(0), PbActivity.this.fDd.beQ(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                createConfig2.setIsHotSort(PbActivity.this.fDd.Xb() == 2);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fEm = false;
    PostData fEn = null;
    private final b.InterfaceC0100b fEo = new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fEn != null) {
                if (i == 0) {
                    PbActivity.this.fEn.cO(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fEn = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fEn);
                }
            }
        }
    };
    private final b.InterfaceC0100b fEp = new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fDD != null && !TextUtils.isEmpty(PbActivity.this.fDE)) {
                if (i == 0) {
                    if (PbActivity.this.fDF == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fDE));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fDE;
                        aVar.pkgId = PbActivity.this.fDF.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fDF.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.bqO == null) {
                        PbActivity.this.bqO = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bqO.Bb();
                    PbActivity.this.bqO.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bqO.x(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fDC == null) {
                            PbActivity.this.fDC = new av(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fDC.i(PbActivity.this.fDE, PbActivity.this.fDD.ok());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fDD = null;
                PbActivity.this.fDE = null;
            }
        }
    };
    private final View.OnLongClickListener aKx = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX WARN: Removed duplicated region for block: B:122:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0190  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            SparseArray<Object> sparseArray;
            boolean z;
            SparseArray<Object> sparseArray2;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (PbActivity.this.bt(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.fDD = ((TbImageView) view).getBdImage();
                        PbActivity.this.fDE = ((TbImageView) view).getUrl();
                        if (PbActivity.this.fDD != null && !TextUtils.isEmpty(PbActivity.this.fDE)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fDF = null;
                            } else {
                                PbActivity.this.fDF = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                PbActivity.this.fDg.a(PbActivity.this.fEp, PbActivity.this.fDD.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                sparseArray = sparseArray2;
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.fDD = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.fDE = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fDF = null;
                            } else {
                                PbActivity.this.fDF = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.fDD = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.fDE = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.fDF = null;
                        } else {
                            PbActivity.this.fDF = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                        }
                    }
                    if (!(view.getParent() instanceof TbRichTextView)) {
                    }
                    if (sparseArray2 != null) {
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 != null) {
                }
                return true;
            }
            PbActivity.this.fEn = (PostData) sparseArray.get(e.g.tag_clip_board);
            if (PbActivity.this.fEn != null) {
                if (PbActivity.this.fEn.byM() != 1 || !PbActivity.this.bt(view)) {
                    if (PbActivity.this.fDf != null) {
                        boolean z2 = PbActivity.this.fDf.sR() && PbActivity.this.fEn.getId() != null && PbActivity.this.fEn.getId().equals(PbActivity.this.fDd.ww());
                        if (view == null || sparseArray == null) {
                            z = false;
                        } else {
                            if (PbActivity.this.fDm == null) {
                                PbActivity.this.fDm = new y(PbActivity.this.getPageContext(), PbActivity.this.dud);
                                PbActivity.this.fDg.bC(PbActivity.this.fDm.getView());
                                PbActivity.this.fDm.kt(PbActivity.this.mIsLogin);
                            }
                            if (PbActivity.this.fEn.byM() == 1) {
                                PbActivity.this.fDg.a(PbActivity.this.fEo, z2, false);
                            } else {
                                PbActivity.this.fDm.showDialog();
                                z = PbActivity.this.kb(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & PbActivity.this.isLogin();
                            }
                        }
                        boolean booleanValue = sparseArray.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            PbActivity.this.fDm.bfp().setText(e.j.remove_mark);
                        } else {
                            PbActivity.this.fDm.bfp().setText(e.j.mark);
                        }
                        if (booleanValue) {
                            PbActivity.this.fDm.bfp().setVisibility(8);
                        } else {
                            PbActivity.this.fDm.bfp().setVisibility(0);
                        }
                        if (PbActivity.this.bt(view)) {
                            if (PbActivity.this.fDD != null && !PbActivity.this.fDD.isGif()) {
                                sparseArray.put(e.g.tag_richtext_image, true);
                            } else {
                                sparseArray.put(e.g.tag_richtext_image, false);
                            }
                            sparseArray.put(e.g.tag_richtext_emotion, true);
                        } else {
                            sparseArray.put(e.g.tag_richtext_image, false);
                            sparseArray.put(e.g.tag_richtext_emotion, false);
                        }
                        PbActivity.this.fDm.a(sparseArray, PbActivity.this.fDd.getPbData().bbV(), z);
                        PbActivity.this.fDm.refreshUI();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").al("tid", PbActivity.this.fDd.fIj).al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getForumId()).al("uid", PbActivity.this.fDd.getPbData().bbJ().wm().getUserId()).al("post_id", PbActivity.this.fDd.Je()).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, booleanValue ? 2 : 1));
                    }
                } else {
                    PbActivity.this.fDg.a(PbActivity.this.fEp, PbActivity.this.fDD.isGif());
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dpW = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bd(boolean z) {
            if (!PbActivity.this.fCM && z && !PbActivity.this.fDd.beL()) {
                PbActivity.this.bdA();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0141e.ds200));
        }
    };
    public View.OnTouchListener aZX = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.bPP.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0145a bPQ = new a.InterfaceC0145a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        final int ctq;

        {
            this.ctq = (int) PbActivity.this.getResources().getDimension(e.C0141e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ac(int i, int i2) {
            if (af(i2) && PbActivity.this.fDg != null && PbActivity.this.fCK != null) {
                PbActivity.this.fDg.bgU();
                PbActivity.this.fCK.gk(false);
                PbActivity.this.fCK.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ad(int i, int i2) {
            if (af(i2) && PbActivity.this.fDg != null && PbActivity.this.fCK != null) {
                PbActivity.this.fCK.gk(true);
                if (Math.abs(i2) > this.ctq) {
                    PbActivity.this.fCK.hideFloatingView();
                }
                if (PbActivity.this.bdE()) {
                    PbActivity.this.fDg.bgn();
                    PbActivity.this.fDg.bgo();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ae(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fEr = null;
    private final m.a fEs = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void h(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(e.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fEr = str2;
                PbActivity.this.fDg.rX(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fEt = -1;
    private int fEu = -1;
    private CustomMessageListener fEx = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.afv == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0098a) {
                    if (aVar.afw != null && !aVar.afw.hasError() && aVar.afw.getError() == 0) {
                        if (PbActivity.this.fDg != null) {
                            PbActivity.this.fDg.n(((a.C0098a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bdP();
                        }
                    } else if (z) {
                        if (aVar.afw != null && aVar.afw.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.afw.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.afw != null && !aVar.afw.hasError() && aVar.afw.getError() == 0) {
                        if (PbActivity.this.fDg != null && PbActivity.this.fDg != null) {
                            PbActivity.this.fDg.n(((a.C0098a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.afw != null && aVar.afw.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.afw.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.afw == null || aVar.afw.hasError() || aVar.afw.getError() != 0) {
                        if (z) {
                            if (aVar.afw != null && aVar.afw.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.afw.getErrorString());
                            } else {
                                PbActivity.this.showToast(e.j.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(e.j.channel_need_push), 1).show();
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void j(Object obj);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public ArrayList<String> fEX;
        public ConcurrentHashMap<String, ImageUrlData> fEY;
        public boolean fFa;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fEZ = false;
        public boolean fFb = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes2.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d bda() {
        return this.fDt;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bcq() != null) {
            String id = jVar.bcq().getId();
            ArrayList<PostData> bbL = this.fDd.getPbData().bbL();
            int i = 0;
            while (true) {
                if (i >= bbL.size()) {
                    break;
                }
                PostData postData = bbL.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bcu = jVar.bcu();
                    postData.ui(jVar.getTotalCount());
                    if (postData.byJ() != null && bcu != null) {
                        Iterator<PostData> it = bcu.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.wm() != null && (metaData = postData.getUserMap().get(next.wm().getUserId())) != null) {
                                next.a(metaData);
                                next.mQ(true);
                                next.b(getPageContext(), this.fDd.rR(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bcu.size() != postData.byJ().size();
                        postData.byJ().clear();
                        postData.byJ().addAll(bcu);
                        z = z2;
                    }
                    if (postData.byF() != null) {
                        postData.byG();
                    }
                }
            }
            if (!this.fDd.getIsFromMark() && z) {
                this.fDg.n(this.fDd.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rK(String str) {
        com.baidu.tieba.tbadkCore.data.l bbZ;
        if (!TextUtils.isEmpty(str) && (bbZ = this.fDd.getPbData().bbZ()) != null && str.equals(bbZ.getAdId())) {
            if (bbZ.byA() != null) {
                bbZ.byA().legoCard = null;
            }
            this.fDd.getPbData().bca();
        }
    }

    public void bdb() {
        com.baidu.tieba.pb.data.d pbData;
        bb bbJ;
        if (!this.fDW) {
            if (!com.baidu.adp.lib.util.l.lb()) {
                showToast(e.j.no_network_guide);
            } else if (this.fDZ) {
                this.fDW = true;
                if (this.fDd != null && (pbData = this.fDd.getPbData()) != null && (bbJ = pbData.bbJ()) != null) {
                    int isLike = bbJ.vZ() == null ? 0 : bbJ.vZ().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10796").al("tid", bbJ.getId()));
                    }
                    if (this.fDX != null) {
                        this.fDX.a(bbJ.wD(), bbJ.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer)) {
            final String str = (String) sparseArray.get(e.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
                bVar.cs(e.j.operation);
                int i = -1;
                if (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(e.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(e.j.delete);
                    strArr[1] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr, new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fDg.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fDA);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fDA);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fDA);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fDA);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).yo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(int i) {
        bb bbJ;
        String str;
        String J;
        if (this.fDd != null && this.fDd.getPbData() != null && (bbJ = this.fDd.getPbData().bbJ()) != null) {
            if (i == 1) {
                PraiseData vZ = bbJ.vZ();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (vZ == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bbJ.a(praiseData);
                    } else {
                        bbJ.vZ().getUser().add(0, metaData);
                        bbJ.vZ().setNum(bbJ.vZ().getNum() + 1);
                        bbJ.vZ().setIsLike(i);
                    }
                }
                if (bbJ.vZ() != null) {
                    if (bbJ.vZ().getNum() < 1) {
                        J = getResources().getString(e.j.zan);
                    } else {
                        J = com.baidu.tbadk.core.util.ao.J(bbJ.vZ().getNum());
                    }
                    this.fDg.N(J, true);
                }
            } else if (bbJ.vZ() != null) {
                bbJ.vZ().setIsLike(i);
                bbJ.vZ().setNum(bbJ.vZ().getNum() - 1);
                ArrayList<MetaData> user = bbJ.vZ().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bbJ.vZ().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bbJ.vZ().getNum() < 1) {
                    str = getResources().getString(e.j.zan);
                } else {
                    str = bbJ.vZ().getNum() + "";
                }
                this.fDg.N(str, false);
            }
            if (this.fDd.beE()) {
                this.fDg.bgr().notifyDataSetChanged();
            } else {
                this.fDg.o(this.fDd.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fDd.z(bundle);
        if (this.dsk != null) {
            this.dsk.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fDt.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fCQ = System.currentTimeMillis();
        this.fDy = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cYB = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fCX = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fCX) && intent.getData() != null) {
                this.fCX = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fCX)) {
                this.fCL = true;
            }
            this.fEt = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fEu = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fEv = intent.getStringExtra("key_manga_title");
            this.fDp = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fDq = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bdE()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ao.isEmpty(this.source) ? "" : this.source;
            this.fDH = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.cYB = System.currentTimeMillis();
        }
        this.aXa = this.fCQ - this.cYB;
        super.onCreate(bundle);
        this.fCO = 0;
        y(bundle);
        if (this.fDd != null && this.fDd.getPbData() != null) {
            this.fDd.getPbData().rI(this.source);
        }
        initUI();
        if (intent != null && this.fDg != null) {
            this.fDg.fLV = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fDB == null) {
                    this.fDB = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fDg.rZ("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fDB, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fDd != null && this.fDd.getPbData() != null) {
                this.fDd.rU(stringExtra);
            }
        }
        this.dsk = new VoiceManager();
        this.dsk.onCreate(getPageContext());
        initData(bundle);
        this.fDs = new com.baidu.tbadk.editortools.pb.f();
        bdc();
        this.fDt = (com.baidu.tbadk.editortools.pb.d) this.fDs.bE(getActivity());
        this.fDt.b(this);
        this.fDt.a(this.aRr);
        this.fDt.a(this.aRk);
        this.fDt.a(this, bundle);
        this.fDt.IJ().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fDt.IJ().bP(true);
        ka(true);
        this.fDg.setEditorTools(this.fDt.IJ());
        this.fDt.a(this.fDd.beN(), this.fDd.beD(), this.fDd.bff());
        registerListener(this.fDO);
        if (!this.fDd.beK()) {
            this.fDt.hh(this.fDd.beD());
        }
        if (this.fDd.bfg()) {
            this.fDt.hf(getPageContext().getString(e.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fDt.hf(getPageContext().getString(e.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fDN);
        registerListener(this.fDP);
        registerListener(this.fDQ);
        registerListener(this.dtu);
        registerListener(this.fEe);
        registerListener(this.fDM);
        this.fDr = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gUZ);
        this.fDr.byn();
        registerListener(this.fDS);
        registerListener(this.mAttentionListener);
        if (this.fDd != null) {
            this.fDd.beX();
        }
        registerListener(this.fEh);
        registerListener(this.fEx);
        registerListener(this.dtB);
        if (this.fDg != null && this.fDg.bgY() != null && this.fDg.bgZ() != null) {
            this.fCK = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.fDg.bgY(), this.fDg.bgZ(), this.fDg.bgi());
            this.fCK.a(this.fEa);
        }
        if (this.fCJ && this.fDg != null && this.fDg.bgZ() != null) {
            this.fDg.bgZ().setVisibility(8);
        }
        this.fDz = new com.baidu.tbadk.core.view.g();
        this.fDz.ayd = 1000L;
        registerListener(this.fEd);
        registerListener(this.fEb);
        registerListener(this.fEc);
        registerListener(this.dKY);
        this.fDA = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fDA;
        userMuteAddAndDelCustomMessage.setTag(this.fDA);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fDA;
        userMuteCheckCustomMessage.setTag(this.fDA);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fDd.bfd().a(this.ciz);
        this.fDl = new at();
        if (this.fDt.Ji() != null) {
            this.fDl.g(this.fDt.Ji().getInputView());
        }
        this.fDt.a(this.aRl);
        this.dId = new ShareSuccessReplyToServerModel();
        a(this.fDJ);
        this.ePn = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.ePn.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.asY) {
                        PbActivity.this.fDt.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.asZ && PbActivity.this.fDg != null && PbActivity.this.fDg.bfZ() != null && PbActivity.this.fDg.bfZ().bev() != null) {
                        PbActivity.this.fDg.bfZ().bev().JB();
                    } else if (i == com.baidu.tbadk.core.util.aj.ata) {
                        PbActivity.this.c(PbActivity.this.fDv);
                    }
                }
            }
        });
        this.fDe = new com.baidu.tieba.pb.pb.report.a(this);
        this.fDe.o(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.fCQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdc() {
        if (this.fDs != null && this.fDd != null) {
            this.fDs.setForumName(this.fDd.bcF());
            if (this.fDd.getPbData() != null && this.fDd.getPbData().bbH() != null) {
                this.fDs.a(this.fDd.getPbData().bbH());
            }
            this.fDs.setFrom("pb");
            this.fDs.a(this.fDd);
        }
    }

    public String bdd() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bde() {
        return this.fCK;
    }

    private void ka(boolean z) {
        this.fDt.bT(z);
        this.fDt.bU(z);
        this.fDt.bV(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bci() && !z && this.fDg != null && this.fDg.getView() != null) {
            this.fDg.getView().setSystemUiVisibility(4);
        }
        this.fDw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dsk != null) {
            this.dsk.onStart(getPageContext());
        }
    }

    public ar bdf() {
        return this.fDg;
    }

    public PbModel bcO() {
        return this.fDd;
    }

    public void rL(String str) {
        if (this.fDd != null && !StringUtils.isNull(str) && this.fDg != null) {
            this.fDg.kQ(true);
            this.fDd.rL(str);
            this.fCW = true;
            this.fDg.bgK();
            this.fDg.bgT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fCM = false;
        } else {
            this.fCM = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fCO = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fCO == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dsk != null) {
            this.dsk.onPause(getPageContext());
        }
        if (this.fDg != null) {
            this.fDg.onPause();
        }
        if (!this.fDd.beK()) {
            this.fDt.hg(this.fDd.beD());
        }
        if (this.fDd != null) {
            this.fDd.beY();
        }
        MessageManager.getInstance().unRegisterListener(this.etb);
        aHx();
        MessageManager.getInstance().unRegisterListener(this.fEb);
        MessageManager.getInstance().unRegisterListener(this.fEc);
        MessageManager.getInstance().unRegisterListener(this.fEd);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bdg() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fDd.getPbData(), this.fDd.beE(), this.fDd.getRequestType());
        return (a2 == null || a2.wm() == null || a2.wm().getGodUserData() == null || a2.wm().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fCM = false;
        super.onResume();
        if (this.fCZ) {
            this.fCZ = false;
            bdK();
        }
        if (bdg()) {
            this.fCT = System.currentTimeMillis();
        } else {
            this.fCT = -1L;
        }
        if (this.fDg != null && this.fDg.getView() != null) {
            if (!this.fgn) {
                bdB();
            } else {
                hideLoadingView(this.fDg.getView());
            }
            this.fDg.onResume();
        }
        if (this.fCO == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fDg != null) {
            noNetworkView = this.fDg.bfW();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kK()) {
            noNetworkView.bc(false);
        }
        if (this.dsk != null) {
            this.dsk.onResume(getPageContext());
        }
        registerListener(this.etb);
        this.fDo = false;
        bdJ();
        registerListener(this.fEb);
        registerListener(this.fEc);
        registerListener(this.fEd);
        if (this.dsT) {
            bdA();
            this.dsT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fDg.kE(z);
        if (this.fDm != null) {
            this.fDm.kt(z);
        }
        if (z && this.fDo) {
            this.fDg.bgw();
            this.fDd.kp(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fCT > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").al("obj_duration", (System.currentTimeMillis() - this.fCT) + ""));
            this.fCT = 0L;
        }
        if (bdf().bfZ() != null) {
            bdf().bfZ().onStop();
        }
        if (this.fDg.fMc != null && !this.fDg.fMc.alt()) {
            this.fDg.fMc.aSR();
        }
        if (this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bbH() != null && this.fDd.getPbData().bbJ() != null) {
            com.baidu.tbadk.distribute.a.Iv().a(getPageContext().getPageActivity(), "pb", this.fDd.getPbData().bbH().getId(), com.baidu.adp.lib.g.b.d(this.fDd.getPbData().bbJ().getId(), 0L));
        }
        if (this.dsk != null) {
            this.dsk.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.al(ImageViewerConfig.FORUM_ID, this.fDd.getPbData().getForumId());
            amVar.al("tid", this.fDd.beD());
            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.fCR && this.fDg != null) {
            this.fCR = true;
            this.fDg.bgP();
            a(false, (PostData) null);
        }
        if (this.fDd != null) {
            this.fDd.cancelLoadData();
            this.fDd.destory();
            if (this.fDd.bfc() != null) {
                this.fDd.bfc().onDestroy();
            }
        }
        if (this.fDt != null) {
            this.fDt.onDestroy();
        }
        if (this.cFB != null) {
            this.cFB.cancelLoadData();
        }
        if (this.fDg != null) {
            this.fDg.onDestroy();
            if (this.fDg.fMc != null) {
                this.fDg.fMc.aSR();
            }
        }
        if (this.fCS != null) {
            this.fCS.LR();
        }
        if (this.fCK != null) {
            this.fCK.MP();
        }
        super.onDestroy();
        if (this.dsk != null) {
            this.dsk.onDestory(getPageContext());
        }
        this.fDg.bgK();
        MessageManager.getInstance().unRegisterListener(this.fEb);
        MessageManager.getInstance().unRegisterListener(this.fEc);
        MessageManager.getInstance().unRegisterListener(this.fEd);
        MessageManager.getInstance().unRegisterListener(this.fDA);
        MessageManager.getInstance().unRegisterListener(this.fEe);
        MessageManager.getInstance().unRegisterListener(this.dtB);
        MessageManager.getInstance().unRegisterListener(this.dKY);
        this.fDy = null;
        this.fDz = null;
        com.baidu.tieba.recapp.d.a.bqL().bqN();
        if (this.fDB != null) {
            getSafeHandler().removeCallbacks(this.fDB);
        }
        if (this.fDa != null) {
            this.fDa.cancelLoadData();
        }
        if (this.fDg != null && this.fDg.fMc != null) {
            this.fDg.fMc.bhL();
        }
        if (this.dId != null) {
            this.dId.cancelLoadData();
        }
        this.fDl.onDestroy();
        if (this.dsX != null) {
            this.dsX.onDestroy();
        }
        if (this.fDd != null && this.fDd.bfe() != null) {
            this.fDd.bfe().onDestroy();
        }
        if (this.ePn != null) {
            this.ePn.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bgr;
        ArrayList<PostData> beh;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.Da() && this.fDg != null && (bgr = this.fDg.bgr()) != null && (beh = bgr.beh()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = beh.iterator();
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
                        bVar.mPid = id;
                        bVar.cHA = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.alb == 1 && !TextUtils.isEmpty(id)) {
                    next.alb = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.cHA = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fDd == null || this.fDd.getPbData() == null || this.fDd.getPbData().bbH() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fDd.getPbData().bbH().getFirst_class();
                    str2 = this.fDd.getPbData().bbH().getSecond_class();
                    str = this.fDd.getPbData().bbH().getId();
                    str4 = this.fDd.beD();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Dd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fDg.onChangeSkinType(i);
            if (this.fDt != null && this.fDt.IJ() != null) {
                this.fDt.IJ().onChangeSkinType(i);
            }
            if (this.fDg.bfW() != null) {
                this.fDg.bfW().onChangeSkinType(getPageContext(), i);
            }
            this.fDl.onChangeSkinType();
            if (this.dsX != null) {
                this.dsX.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fDg = new ar(this, this.dud, this.bjA);
        this.bPP = new com.baidu.tieba.f.b(getActivity());
        this.bPP.a(fEq);
        this.bPP.a(this.bPQ);
        this.fDg.setOnScrollListener(this.mOnScrollListener);
        this.fDg.e(this.dLy);
        this.fDg.a(this.bvp);
        this.fDg.jU(com.baidu.tbadk.core.i.uj().un());
        this.fDg.setOnImageClickListener(this.bjz);
        this.fDg.b(this.aKx);
        this.fDg.h(this.dpW);
        this.fDg.a(this.fEj);
        this.fDg.kE(this.mIsLogin);
        if (getIntent() != null) {
            this.fDg.kR(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.fDg.bfY().setFromForumId(this.fDd.getFromForumId());
    }

    public void bdh() {
        if (this.fDg != null && this.fDd != null) {
            if (this.fDd.getPbData() != null || this.fDd.getPbData().bch() != null) {
                TiebaStatic.log(bdl().w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).w("obj_locate", 4).w(VideoPlayActivityConfig.OBJ_ID, bcO().getPbData().bch().bcn() ? 0 : 1));
                if (checkUpIsLogin() && this.fDg.bgr() != null && this.fDg.bgr().bem() != null) {
                    this.fDg.bgr().bem().fJ(this.fDd.beD());
                }
            }
        }
    }

    public void bdi() {
        TiebaStatic.log("c12181");
        if (this.fDg != null && this.fDd != null) {
            if (this.fDg == null || this.fDg.bgb()) {
                if (this.fDd.getPbData() != null || this.fDd.getPbData().bch() != null) {
                    com.baidu.tieba.pb.data.i bch = this.fDd.getPbData().bch();
                    TiebaStatic.log(bdl().w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).w("obj_locate", 4).w(VideoPlayActivityConfig.OBJ_ID, bch.bcn() ? 0 : 1));
                    if (checkUpIsLogin()) {
                        if ((!bch.bcn() || bch.xB() != 2) && this.fDg.bgr() != null && this.fDg.bgr().bem() != null) {
                            this.fDg.bgr().bem().fJ(this.fDd.beD());
                        }
                        if (System.currentTimeMillis() - this.fCV > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).lm(false);
                            this.fCV = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bq(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(e.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.gVB && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.uj().un()) {
                    return rO(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fDd == null || this.fDd.getPbData() == null) {
                        return true;
                    }
                    if (bdf().bfZ() != null) {
                        bdf().bfZ().beq();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.fDd.getPbData().bbH());
                    jVar.aa(this.fDd.getPbData().bbJ());
                    jVar.e(postData);
                    bdf().bfY().d(jVar);
                    bdf().bfY().setPostId(postData.getId());
                    a(view, postData.wm().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fDt != null) {
                        this.fDg.kL(this.fDt.Jp());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.fDg != null) {
            if (z && !this.fgn) {
                bdB();
            } else {
                hideLoadingView(this.fDg.getView());
            }
            if (z && this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bci() && this.fDg.getView() != null) {
                this.fDg.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bdj() {
        if (this.fCP == null) {
            this.fCP = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fCP.a(new String[]{getPageContext().getString(e.j.call_phone), getPageContext().getString(e.j.sms_phone), getPageContext().getString(e.j.search_in_baidu)}, new b.InterfaceC0100b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fCE = PbActivity.this.fCE.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fCE);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fDd.beD(), PbActivity.this.fCE, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fCE = PbActivity.this.fCE.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fCE);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fDd.beD(), PbActivity.this.fCE, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fCE = PbActivity.this.fCE.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fCE);
                        bVar.dismiss();
                    }
                }
            }).ct(b.a.anH).cu(17).d(getPageContext());
        }
    }

    private void y(Bundle bundle) {
        this.fDd = new PbModel(this);
        this.fDd.a(this.fEg);
        if (this.fDd.bfb() != null) {
            this.fDd.bfb().a(this.fEs);
        }
        if (this.fDd.bfa() != null) {
            this.fDd.bfa().a(this.fDR);
        }
        if (this.fDd.bfc() != null) {
            this.fDd.bfc().b(this.fDL);
        }
        if (bundle != null) {
            this.fDd.initWithBundle(bundle);
        } else {
            this.fDd.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fDd.ks(true);
        }
        aj.bfL().M(this.fDd.beC(), this.fDd.getIsFromMark());
        if (StringUtils.isNull(this.fDd.beD())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fCX) && this.fCX != null) {
            this.fDd.rk(6);
        }
        this.fDd.Ll();
    }

    private void initData(Bundle bundle) {
        this.fDf = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fDf != null) {
            this.fDf.a(this.fEi);
        }
        this.cFB = new ForumManageModel(this);
        this.cFB.setLoadDataCallBack(this.cFF);
        this.atd = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fDg.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void j(Object obj) {
                if (!com.baidu.adp.lib.util.j.kK()) {
                    PbActivity.this.showToast(e.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fDd.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                String str3 = "";
                if (objArr.length > 3) {
                    str3 = String.valueOf(objArr[3]);
                }
                String str4 = "";
                if (objArr.length > 4) {
                    str4 = String.valueOf(objArr[4]);
                }
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fDd.getPbData().bbH().getId(), PbActivity.this.fDd.getPbData().bbH().getName(), PbActivity.this.fDd.getPbData().bbJ().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.fDX.setUniqueId(getUniqueId());
        this.fDX.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fDg.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(e.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fDA;
        userMuteCheckCustomMessage.setTag(this.fDA);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bdk() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fDd != null && (pbData = this.fDd.getPbData()) != null) {
            return pbData.bbU().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bbJ() != null) {
            if (dVar.bbJ().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bbJ().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bbJ().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData br(View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(e.g.tag_clip_board)) != null) {
            if (view instanceof PostPraiseView) {
                ((PostPraiseView) view).L(view);
                return postData;
            }
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.am bdl() {
        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12003");
        amVar.al("tid", this.fDd.fIj);
        amVar.w("obj_type", 0);
        amVar.al(ImageViewerConfig.FORUM_ID, this.fDd.getForumId());
        amVar.w("obj_param1", this.fDd.getPbData().bbJ().getThreadType() == 40 ? 2 : 1);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.al("obj_param2", TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && bdm()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
                @Override // java.lang.Runnable
                public void run() {
                    int h;
                    int aQ = (com.baidu.adp.lib.util.l.aQ(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        h = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0141e.ds120);
                    } else {
                        h = com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0141e.ds640);
                    }
                    int i = h - aQ;
                    if (i > 0) {
                        PbActivity.this.bdf().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bdf().bfZ() != null) {
                        PbActivity.this.fDt.IJ().setVisibility(8);
                        PbActivity.this.bdf().bfZ().bW(str, str2);
                        com.baidu.tbadk.editortools.pb.g bev = PbActivity.this.bdf().bfZ().bev();
                        if (bev != null && PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null) {
                            bev.a(PbActivity.this.fDd.getPbData().vj());
                        }
                        if (PbActivity.this.fDl.bhn() == null && PbActivity.this.bdf().bfZ().bev().JJ() != null) {
                            PbActivity.this.bdf().bfZ().bev().JJ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fDl != null && PbActivity.this.fDl.bhm() != null) {
                                        if (!PbActivity.this.fDl.bhm().bIh()) {
                                            PbActivity.this.fDl.kT(false);
                                        }
                                        PbActivity.this.fDl.bhm().nL(false);
                                    }
                                }
                            });
                            PbActivity.this.fDl.h(PbActivity.this.bdf().bfZ().bev().JJ().getInputView());
                            PbActivity.this.bdf().bfZ().bev().a(PbActivity.this.fDx);
                        }
                    }
                    PbActivity.this.bdf().bgT();
                }
            }, 500L);
        }
    }

    public boolean bdm() {
        if (this.ePn == null || this.fDd.getPbData() == null || this.fDd.getPbData().vj() == null) {
            return true;
        }
        return this.ePn.cY(this.fDd.getPbData().vj().replyPrivateFlag);
    }

    public boolean qT(int i) {
        if (this.ePn == null || this.fDd.getPbData() == null || this.fDd.getPbData().vj() == null) {
            return true;
        }
        return this.ePn.w(this.fDd.getPbData().vj().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(e.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null && this.fDd != null && this.fDd.getPbData() != null && postData.byM() != 1) {
            String beD = this.fDd.beD();
            String id = postData.getId();
            int bbV = this.fDd.getPbData() != null ? this.fDd.getPbData().bbV() : 0;
            c rP = rP(id);
            if (rP != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(beD, id, "pb", true, null, false, null, bbV, postData.bix(), this.fDd.getPbData().vj(), false, postData.wm() != null ? postData.wm().getIconInfo() : null).addBigImageData(rP.fEX, rP.fEY, rP.fEZ, rP.index);
                addBigImageData.setKeyPageStartFrom(this.fDd.bfi());
                addBigImageData.setFromFrsForumId(this.fDd.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdn() {
        if (this.fDd.getPbData() == null || this.fDd.getPbData().bbJ() == null) {
            return -1;
        }
        return this.fDd.getPbData().bbJ().wQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdo() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.tQ(this.fDd.getForumId()) && this.fDd.getPbData() != null && this.fDd.getPbData().bbH() != null) {
            if (this.fDd.getPbData().bbH().isLike() == 1) {
                this.fDd.bfe().co(this.fDd.getForumId(), this.fDd.beD());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kb(boolean z) {
        if (this.fDd == null || this.fDd.getPbData() == null) {
            return false;
        }
        return ((this.fDd.getPbData().bbV() != 0) || this.fDd.getPbData().bbJ() == null || this.fDd.getPbData().bbJ().wm() == null || TextUtils.equals(this.fDd.getPbData().bbJ().wm().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bdp() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.p.t.Mr()) {
            return "";
        }
        PostData bbQ = bbQ();
        if (this.fDd == null || (pbData = this.fDd.getPbData()) == null || pbData.getUserData() == null || pbData.bbJ() == null || bbQ == null || bbQ.wm() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bbQ.wm().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bbJ().vU() == 0) {
            return "";
        }
        if (pbData.bbJ().vU() == 0) {
            return getPageContext().getString(e.j.fans_call);
        }
        return getPageContext().getString(e.j.haved_fans_call);
    }

    private boolean kc(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fDd == null || this.fDd.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fDd.getPbData();
        if (pbData.bbV() == 0) {
            List<com.baidu.tbadk.core.data.ay> bcf = pbData.bcf();
            if (com.baidu.tbadk.core.util.v.y(bcf) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : bcf) {
                    if (ayVar != null && (tVar = ayVar.ajR) != null && tVar.ahQ && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            return z2;
        }
        return true;
    }

    private boolean kd(boolean z) {
        return (z || this.fDd == null || this.fDd.getPbData() == null || this.fDd.getPbData().bbV() == 0) ? false : true;
    }

    public void bdq() {
        if (this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bbJ() != null && this.fDd.getPbData().bbJ().wm() != null) {
            if (this.fDg != null) {
                this.fDg.bfX();
            }
            bb bbJ = this.fDd.getPbData().bbJ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbJ.wm().getUserId());
            ab abVar = new ab();
            int bbV = this.fDd.getPbData().bbV();
            if (bbV == 1) {
                abVar.fKl = true;
                abVar.fKk = true;
                abVar.fKs = bbJ.wh() == 1;
                abVar.fKr = bbJ.wi() == 1;
            } else {
                abVar.fKl = false;
                abVar.fKk = false;
            }
            if (bbV == 1002 && !equals) {
                abVar.fKw = true;
            }
            abVar.fKi = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            abVar.fKm = kc(equals);
            abVar.fKn = bdr();
            abVar.fKo = kd(equals);
            abVar.qm = this.fDd.beE();
            abVar.fKj = true;
            abVar.fBb = this.fDf != null && this.fDf.sR();
            abVar.fKh = kb(equals);
            abVar.fKu = bdp();
            abVar.fKg = equals && this.fDg.bgD();
            abVar.fKp = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fKq = true;
            abVar.isHostOnly = this.fDd.getHostMode();
            abVar.fKt = true;
            if (bbJ.wE() == null) {
                abVar.fKv = true;
            } else {
                abVar.fKv = false;
            }
            this.fDg.fMc.a(abVar);
        }
    }

    private boolean bdr() {
        if (this.fDd != null && this.fDd.beE()) {
            return this.fDd.getPageData() == null || this.fDd.getPageData().vv() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null) {
            f(postData);
        }
    }

    public int bds() {
        if (bdf() == null || bdf().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bdf().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fAO) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdt() {
        if (bdf() == null || bdf().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bdf().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.gVA) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bdA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.dS(getResources().getString(e.j.mark_done));
            aVar.aL(true);
            aVar.dT(getResources().getString(e.j.mark_like));
            aVar.aK(true);
            aVar.aE(false);
            aVar.b(getResources().getString(e.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").al(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).w("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(e.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").al(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).w("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.atd.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fDd.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).yl();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fDg.bgx();
        this.fDd.kr(z);
        if (this.fDf != null) {
            this.fDf.an(z);
            if (markData != null) {
                this.fDf.a(markData);
            }
        }
        if (this.fDd.sR()) {
            bdy();
        } else {
            this.fDg.n(this.fDd.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qR(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rM(String str) {
        this.fDe.si(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fDd.beK()) {
                    antiData.setBlock_forum_name(this.fDd.getPbData().bbH().getName());
                    antiData.setBlock_forum_id(this.fDd.getPbData().bbH().getId());
                    antiData.setUser_name(this.fDd.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fDd.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else if (bdf() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.am(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").w("obj_locate", as.a.atN));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").w("obj_locate", as.a.atN));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").w("obj_locate", as.a.atN));
            }
        } else if (i == 230277) {
            hn(str);
        } else {
            this.fDg.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.gXX) ? bVar.gXX : getString(e.j.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dT(string);
                aVar.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.aE(true);
                aVar.b(getPageContext());
                aVar.yl();
            } else {
                this.fDg.a(0, bVar.Hs, bVar.gXX, z);
            }
            if (bVar.Hs) {
                if (bVar.gXV == 1) {
                    ArrayList<PostData> bbL = this.fDd.getPbData().bbL();
                    int size = bbL.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bbL.get(i).getId())) {
                            i++;
                        } else {
                            bbL.remove(i);
                            break;
                        }
                    }
                    this.fDg.n(this.fDd.getPbData());
                } else if (bVar.gXV == 0) {
                    bdu();
                } else if (bVar.gXV == 2) {
                    ArrayList<PostData> bbL2 = this.fDd.getPbData().bbL();
                    int size2 = bbL2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bbL2.get(i2).byJ().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bbL2.get(i2).byJ().get(i3).getId())) {
                                i3++;
                            } else {
                                bbL2.get(i2).byJ().remove(i3);
                                bbL2.get(i2).byL();
                                z2 = true;
                                break;
                            }
                        }
                        bbL2.get(i2).uv(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fDg.n(this.fDd.getPbData());
                    }
                    a(bVar, this.fDg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fDg.a(this.cFB.getLoadDataMode(), gVar.Hs, gVar.gXX, false);
            if (gVar.Hs) {
                this.fDi = true;
                if (i == 2 || i == 3) {
                    this.fDj = true;
                    this.fDk = false;
                } else if (i == 4 || i == 5) {
                    this.fDj = false;
                    this.fDk = true;
                }
                if (i == 2) {
                    this.fDd.getPbData().bbJ().cf(1);
                    this.fDd.setIsGood(1);
                } else if (i == 3) {
                    this.fDd.getPbData().bbJ().cf(0);
                    this.fDd.setIsGood(0);
                } else if (i == 4) {
                    this.fDd.getPbData().bbJ().ce(1);
                    this.fDd.jH(1);
                } else if (i == 5) {
                    this.fDd.getPbData().bbJ().ce(0);
                    this.fDd.jH(0);
                }
                this.fDg.c(this.fDd.getPbData(), this.fDd.beE());
            }
        }
    }

    private void bdu() {
        if (this.fDd.beF() || this.fDd.beH()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fDd.beD());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fDd.beD()));
        if (bdz()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdv() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bbS;
        boolean z = false;
        if (this.fDg != null) {
            this.fDg.bgK();
        }
        if (this.fDd != null && this.fDd.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fDd.getPbData().bbJ().getId();
            if (this.fDd.isShareThread() && this.fDd.getPbData().bbJ().aml != null) {
                historyMessage.threadName = this.fDd.getPbData().bbJ().aml.showText;
            } else {
                historyMessage.threadName = this.fDd.getPbData().bbJ().getTitle();
            }
            if (this.fDd.isShareThread() && !bcE()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fDd.getPbData().bbH().getName();
            }
            ArrayList<PostData> bbL = this.fDd.getPbData().bbL();
            int bgz = this.fDg != null ? this.fDg.bgz() : 0;
            if (bbL != null && bgz >= 0 && bgz < bbL.size()) {
                historyMessage.postID = bbL.get(bgz).getId();
            }
            historyMessage.isHostOnly = this.fDd.getHostMode();
            historyMessage.isSquence = this.fDd.beE();
            historyMessage.isShareThread = this.fDd.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fDt != null) {
            this.fDt.onDestroy();
        }
        if (this.fCN && bdf() != null) {
            bdf().bhd();
        }
        if (this.fDd != null && (this.fDd.beF() || this.fDd.beH())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fDd.beD());
            if (this.fDi) {
                if (this.fDk) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fDd.beJ());
                }
                if (this.fDj) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fDd.getIsGood());
                }
            }
            if (this.fDd.getPbData() != null && System.currentTimeMillis() - this.fCQ >= 40000 && (bbS = this.fDd.getPbData().bbS()) != null && !com.baidu.tbadk.core.util.v.z(bbS.getDataList())) {
                intent.putExtra("guess_like_data", bbS);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fDH);
            }
            setResult(-1, intent);
        }
        if (bdz()) {
            if (this.fDd != null && this.fDg != null && this.fDg.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fDd.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bbP() && !this.fCW) {
                        aj bfL = aj.bfL();
                        com.baidu.tieba.pb.data.d pbData2 = this.fDd.getPbData();
                        Parcelable onSaveInstanceState = this.fDg.getListView().onSaveInstanceState();
                        boolean beE = this.fDd.beE();
                        boolean hostMode = this.fDd.getHostMode();
                        if (this.fDg.bgi() != null && this.fDg.bgi().getVisibility() == 0) {
                            z = true;
                        }
                        bfL.a(pbData2, onSaveInstanceState, beE, hostMode, z);
                        if (this.fDG >= 0 || this.fDd.bfk() != null) {
                            aj.bfL().j(this.fDd.bfk());
                            aj.bfL().i(this.fDd.bfl());
                            aj.bfL().rm(this.fDd.bfm());
                        }
                    }
                }
            } else {
                aj.bfL().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fDg == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fDg.rq(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qU(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fDg.bfX();
            this.fDg.bfZ().beq();
            this.fDg.kN(false);
        }
        this.fDg.bga();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fDt.resetData();
                        this.fDt.b(writeData);
                        this.fDt.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k eZ = this.fDt.IJ().eZ(6);
                        if (eZ != null && eZ.aPu != null) {
                            eZ.aPu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fDt.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fDg.bfZ() != null && this.fDg.bfZ().bev() != null) {
                            com.baidu.tbadk.editortools.pb.g bev = this.fDg.bfZ().bev();
                            bev.b(writeData);
                            bev.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k eZ2 = bev.IJ().eZ(6);
                            if (eZ2 != null && eZ2.aPu != null) {
                                eZ2.aPu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bev.JB();
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.fDt.onActivityResult(i, i2, intent);
        if (this.fDa != null) {
            this.fDa.onActivityResult(i, i2, intent);
        }
        if (bdf().bfZ() != null) {
            bdf().bfZ().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bdx();
                    return;
                case 13008:
                    aj.bfL().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fDd != null) {
                                PbActivity.this.fDd.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bpD().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fDd != null) {
                        a(bdw(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    J(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bpD().x(getPageContext());
                        bdo();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dId != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dId.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void FH() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55.1
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
                    this.fDg.jZ(false);
                    if (this.fDd.getPbData() != null && this.fDd.getPbData().bbJ() != null && this.fDd.getPbData().bbJ().wH() != null) {
                        this.fDd.getPbData().bbJ().wH().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fDv = emotionImageData;
                        if (qT(com.baidu.tbadk.core.util.aj.ata)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fDg != null && this.fDg.fMc != null) {
                        this.fDg.fMc.tF();
                        this.fDg.fMc.bhF();
                        if (this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bbJ() != null) {
                            this.fDd.getPbData().bbJ().ca(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fDb != null) {
                        this.fDg.bB(this.fDb);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.fDa == null) {
                this.fDa = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fDa.b(this.aRk);
                this.fDa.c(this.aRr);
            }
            this.fDa.a(emotionImageData, bcO(), bcO().getPbData());
        }
    }

    private ShareFromPBMsgData bdw() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] cD = this.fDd.getPbData().cD(getPageContext().getPageActivity());
        PostData bgc = this.fDg.bgc();
        String str = "";
        if (bgc != null) {
            str = bgc.getId();
            String cP = bgc.cP(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(cP)) {
                cD[1] = cP;
            }
        }
        String wD = this.fDd.getPbData().bbJ().wD();
        if (wD != null && wD.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(cD[1]);
        shareFromPBMsgData.setImageUrl(cD[0]);
        shareFromPBMsgData.setForumName(this.fDd.getPbData().bbH().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fDd.getPbData().bbJ().getId());
        shareFromPBMsgData.setTitle(this.fDd.getPbData().bbJ().getTitle());
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bdw(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bbJ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cr(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null) {
                        com.baidu.tbadk.core.util.am al = new com.baidu.tbadk.core.util.am("share_success").w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).w("obj_param1", 3).al(ImageViewerConfig.FORUM_ID, PbActivity.this.fDd.getForumId()).al("tid", PbActivity.this.fDd.beD());
                        if (PbActivity.this.e(PbActivity.this.fDd.getPbData()) != 0) {
                            al.w("obj_type", PbActivity.this.e(PbActivity.this.fDd.getPbData()));
                        }
                        TiebaStatic.log(al);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aF(true);
            aVar.b(getPageContext()).yl();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.E(shareFromPBMsgData.getImageUrl(), this.fDd.getPbData().bbW() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bbJ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cr(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aF(true);
            aVar.b(getPageContext()).yl();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.E(shareFromPBMsgData.getImageUrl(), this.fDd.getPbData().bbW() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdx() {
        MarkData rj;
        if (this.fDf != null && (rj = this.fDd.rj(this.fDg.bgA())) != null) {
            if (!rj.isApp() || (rj = this.fDd.rj(this.fDg.bgA() + 1)) != null) {
                this.fDg.bgv();
                this.fDf.a(rj);
                if (!this.fDf.sR()) {
                    this.fDf.sT();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fDf.sS();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdy() {
        com.baidu.tieba.pb.data.d pbData = this.fDd.getPbData();
        this.fDd.kr(true);
        if (this.fDf != null) {
            pbData.rH(this.fDf.sQ());
        }
        this.fDg.n(pbData);
    }

    private boolean bdz() {
        if (this.fDd == null) {
            return true;
        }
        if (this.fDd.sR()) {
            final MarkData beS = this.fDd.beS();
            if (beS == null || !this.fDd.getIsFromMark()) {
                return true;
            }
            final MarkData rj = this.fDd.rj(this.fDg.bgz());
            if (rj == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", beS);
                setResult(-1, intent);
                return true;
            } else if (rj.getPostId() == null || rj.getPostId().equals(beS.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", beS);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dT(getPageContext().getString(e.j.alert_update_mark));
                aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fDf != null) {
                            if (PbActivity.this.fDf.sR()) {
                                PbActivity.this.fDf.sS();
                                PbActivity.this.fDf.an(false);
                            }
                            PbActivity.this.fDf.a(rj);
                            PbActivity.this.fDf.an(true);
                            PbActivity.this.fDf.sT();
                        }
                        beS.setPostId(rj.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", beS);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bdv();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", beS);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bdv();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fDg != null && PbActivity.this.fDg.getView() != null) {
                            PbActivity.this.fDg.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", beS);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bdv();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.yl();
                return false;
            }
        } else if (this.fDd.getPbData() == null || this.fDd.getPbData().bbL() == null || this.fDd.getPbData().bbL().size() <= 0 || !this.fDd.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fDg == null) {
            return null;
        }
        return this.fDg.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Pw() {
        if (this.fDg == null) {
            return 0;
        }
        return this.fDg.bgI();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Px() {
        if (this.bjq == null) {
            this.bjq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ahM */
                public ImageView jm() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean un = com.baidu.tbadk.core.i.uj().un();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(e.d.common_color_10220));
                    if (un) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(e.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public void r(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public ImageView s(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.uj().un()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(e.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public ImageView t(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bjq;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Py() {
        if (this.bjr == null) {
            this.bjr = TbRichTextView.m(getPageContext().getPageActivity(), 8);
        }
        return this.bjr;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Pz() {
        if (this.bjv == null) {
            this.bjv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdT */
                public GifView jm() {
                    return new GifView(PbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void r(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView s(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView t(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.Kd();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bjv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> PA() {
        if (this.bjs == null) {
            this.bjs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdU */
                public View jm() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0141e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bv */
                public void r(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bw */
                public View s(View view) {
                    ((PlayVoiceBntNew) view).bzY();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bx */
                public View t(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bjs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> PC() {
        this.bju = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bdV */
            public RelativeLayout jm() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void r(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout s(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout t(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bju;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Cc() {
        if (this.aBR == null) {
            this.aBR = UserIconBox.k(getPageContext().getPageActivity(), 8);
        }
        return this.aBR;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fCU = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (aw.sa(str) && this.fDd != null && this.fDd.beD() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").w("obj_param1", 1).al("post_id", this.fDd.beD()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                iVar.mLink = str;
                iVar.type = 3;
                iVar.aOx = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
            }
        } else {
            aw.bhp().c(getPageContext(), str);
        }
        this.fCU = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        aw.bhp().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fCU = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Rect rect) {
        if (rect != null && this.fDg != null && this.fDg.bgY() != null && rect.top <= this.fDg.bgY().getHeight()) {
            rect.top += this.fDg.bgY().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.fDd.getPbData();
            TbRichText aG = aG(str, i);
            if (aG != null && (tbRichTextData = aG.OP().get(this.fEl)) != null) {
                cVar.fEX = new ArrayList<>();
                cVar.fEY = new ConcurrentHashMap<>();
                if (!tbRichTextData.OV().Ph()) {
                    cVar.fFa = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fEX.add(b2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = aG.getPostId();
                    imageUrlData.mIsReserver = this.fDd.beQ();
                    imageUrlData.mIsSeeHost = this.fDd.getHostMode();
                    cVar.fEY.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.bbH() != null) {
                            cVar.forumName = pbData.bbH().getName();
                            cVar.forumId = pbData.bbH().getId();
                        }
                        if (pbData.bbJ() != null) {
                            cVar.threadId = pbData.bbJ().getId();
                        }
                        cVar.fEZ = pbData.bbW() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.fFa = true;
                int size = pbData.bbL().size();
                this.fEm = false;
                cVar.index = -1;
                if (pbData.bbQ() != null) {
                    PostData bbQ = pbData.bbQ();
                    TbRichText byO = bbQ.byO();
                    if (!aq.k(bbQ)) {
                        i2 = a(byO, aG, i, i, cVar.fEX, cVar.fEY);
                    } else {
                        i2 = a(bbQ, i, cVar.fEX, cVar.fEY);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bbL().get(i4);
                    if (postData.getId() == null || pbData.bbQ() == null || pbData.bbQ().getId() == null || !postData.getId().equals(pbData.bbQ().getId())) {
                        TbRichText byO2 = postData.byO();
                        if (!aq.k(postData)) {
                            i3 = a(byO2, aG, i3, i, cVar.fEX, cVar.fEY);
                        } else {
                            i3 = a(postData, i3, cVar.fEX, cVar.fEY);
                        }
                    }
                }
                if (cVar.fEX.size() > 0) {
                    cVar.lastId = cVar.fEX.get(cVar.fEX.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.bbH() != null) {
                        cVar.forumName = pbData.bbH().getName();
                        cVar.forumId = pbData.bbH().getId();
                    }
                    if (pbData.bbJ() != null) {
                        cVar.threadId = pbData.bbJ().getId();
                    }
                    cVar.fEZ = pbData.bbW() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.OV() == null) {
            return null;
        }
        return tbRichTextData.OV().Pn();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.OV() == null) {
            return 0L;
        }
        return tbRichTextData.OV().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.OV() == null) {
            return false;
        }
        return tbRichTextData.OV().Po();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.OV() == null) {
            return false;
        }
        return tbRichTextData.OV().Pp();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo OV;
        String str;
        if (tbRichText == tbRichText2) {
            this.fEm = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.OP().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.OP().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.OV().getWidth() * aR;
                    int height = aR * tbRichTextData.OV().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.OV().Ph()) {
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
                        String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                            if (tbRichTextData != null && (OV = tbRichTextData.OV()) != null) {
                                String Pk = OV.Pk();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = OV.Pl();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = Pk;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fDd.beD(), -1L);
                                imageUrlData.mIsReserver = this.fDd.beQ();
                                imageUrlData.mIsSeeHost = this.fDd.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fEm) {
                            i4 = i7 + 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    private int a(PostData postData, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        com.baidu.tieba.tbadkCore.data.h byV;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> byr;
        if (postData != null && arrayList != null && concurrentHashMap != null && (byr = (byV = postData.byV()).byr()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == byr.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = byr.get(i3);
                if (jVar != null) {
                    String byv = jVar.byv();
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(byv)) {
                        arrayList.add(byv);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = byv;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.byu();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fDd.beD(), -1L);
                        imageUrlData.mIsReserver = this.fDd.beQ();
                        imageUrlData.mIsSeeHost = this.fDd.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = byV.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(byv, imageUrlData);
                        }
                        if (!this.fEm) {
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
            if (postData.getId() != null && postData.getId().equals(this.fDd.ww())) {
                z = true;
            }
            MarkData h = this.fDd.h(postData);
            if (h != null) {
                this.fDg.bgv();
                if (this.fDf != null) {
                    this.fDf.a(h);
                    if (!z) {
                        this.fDf.sT();
                    } else {
                        this.fDf.sS();
                    }
                }
            }
        }
    }

    public boolean bt(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aG(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fDd == null || this.fDd.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fDd.getPbData();
        if (pbData.bbQ() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bbQ());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bbL = pbData.bbL();
            a(pbData, bbL);
            return a(bbL, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bbU() != null && dVar.bbU().fBd != null && (list = dVar.bbU().fBd) != null && arrayList != null) {
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

    private long rN(String str) {
        ArrayList<PostData> bbL;
        com.baidu.tieba.pb.data.d pbData = this.fDd.getPbData();
        if (pbData != null && (bbL = pbData.bbL()) != null && !bbL.isEmpty()) {
            Iterator<PostData> it = bbL.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h byV = next.byV();
                if (byV != null && byV.gVh) {
                    Iterator<TbRichTextData> it2 = next.byO().OP().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Pe().getLink().equals(str)) {
                            return byV.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> OP;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText byO = arrayList.get(i2).byO();
            if (byO != null && (OP = byO.OP()) != null) {
                int size = OP.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (OP.get(i4) != null && OP.get(i4).getType() == 8) {
                        i3++;
                        if (OP.get(i4).OV().Pk().equals(str) || OP.get(i4).OV().Pl().equals(str)) {
                            int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                            int width = OP.get(i4).OV().getWidth() * aR;
                            int height = OP.get(i4).OV().getHeight() * aR;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fEl = i4;
                            return byO;
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
    public void i(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.fCE = str;
            if (this.fCP == null) {
                bdj();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fCP.cx(1).setVisibility(8);
            } else {
                this.fCP.cx(1).setVisibility(0);
            }
            this.fCP.yo();
            this.fCU = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dsk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdA() {
        hideNetRefreshView(this.fDg.getView());
        bdB();
        if (this.fDd.Ll()) {
            this.fDg.bgv();
        }
    }

    private void bdB() {
        showLoadingView(this.fDg.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds400));
        View Ky = getLoadingView().Ky();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Ky.getLayoutParams();
        layoutParams.addRule(3, this.fDg.bgY().getId());
        Ky.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awt() {
        if (this.dsk != null) {
            this.dsk.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qV(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004020, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void qW(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fDd.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fDd.getPbData();
            pbData.bbH().getName();
            String title = pbData.bbJ().getTitle();
            int i2 = this.fDd.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.bbH() != null) {
                if ((pbData.bbH().isLike() == 1) && AddExperiencedModel.tQ(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fDd.beD() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] cD = pbData.cD(getPageContext().getPageActivity());
                    str = cD[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = cD[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bdn() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").al(ImageViewerConfig.FORUM_ID, pbData.getForumId()).al("tid", pbData.getThreadId()).al("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.aJh = true;
                    dVar.aJm = z;
                    dVar.extData = this.fDd.beD();
                    dVar.aJv = 3;
                    dVar.aJu = i;
                    dVar.fid = this.fDd.getForumId();
                    dVar.tid = this.fDd.beD();
                    dVar.aJw = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fDd.getPbData().bbJ());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aJv);
                    bundle.putInt("obj_type", dVar.aJw);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.f(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bci()) {
                                PbActivity.this.fDg.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.amB().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fDd.beD() + "?share=9105&fr=share&see_lz=" + i2;
            String[] cD2 = pbData.cD(getPageContext().getPageActivity());
            str = cD2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = cD2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bdn() == 1) {
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aJh = true;
            dVar2.aJm = z;
            dVar2.extData = this.fDd.beD();
            dVar2.aJv = 3;
            dVar2.aJu = i;
            dVar2.fid = this.fDd.getForumId();
            dVar2.tid = this.fDd.beD();
            dVar2.aJw = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fDd.getPbData().bbJ());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aJv);
            bundle2.putInt("obj_type", dVar2.aJw);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.f(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fDd != null && PbActivity.this.fDd.getPbData() != null && PbActivity.this.fDd.getPbData().bci()) {
                        PbActivity.this.fDg.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.amB().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bbJ() != null) {
            if (dVar.bbJ().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bbJ().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdC() {
        com.baidu.tbadk.util.x.a(new com.baidu.tbadk.util.w<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.w
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.tR(PbActivity.this.fDd.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fDg.bhe();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> PB() {
        if (this.bjt == null) {
            this.bjt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdW */
                public LinearLayout jm() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
                    linearLayout.setId(e.g.pb_text_voice_layout);
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
                /* renamed from: d */
                public void r(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout s(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout t(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.bjt;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fDg.bgq() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").w("obj_locate", 2).al(ImageViewerConfig.FORUM_ID, this.fDd.getPbData().getForumId()));
            } else {
                bb bbJ = this.fDd.getPbData().bbJ();
                if (view != null) {
                    boolean z = bbJ.vZ() == null || bbJ.vZ().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fDY > 1000) {
                            this.fDZ = true;
                            bu(view);
                        } else {
                            this.fDZ = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            l(view, this.fDZ);
                        } else {
                            k(view, this.fDZ);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        k(view, this.fDZ);
                    } else if (motionEvent.getAction() == 3) {
                        k(view, this.fDZ);
                    }
                }
            }
        }
        return false;
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fDY = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void l(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fDY = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bu(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void awu() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData avt() {
        if (this.fDd == null || this.fDd.getPbData() == null) {
            return null;
        }
        return this.fDd.getPbData().vj();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.yn() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.yn();
            int intValue = ((Integer) sparseArray.get(ar.fNP)).intValue();
            if (intValue == ar.fNQ) {
                if (!this.cFB.bzy()) {
                    this.fDg.bgs();
                    String str = (String) sparseArray.get(e.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.cFB.uB(com.baidu.tbadk.core.util.ao.h(jSONArray));
                    }
                    this.cFB.a(this.fDd.getPbData().bbH().getId(), this.fDd.getPbData().bbH().getName(), this.fDd.getPbData().bbJ().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == ar.fNR || intValue == ar.fNT) {
                if (this.fDd.bfb() != null) {
                    this.fDd.bfb().qZ(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.fNR) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(e.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(e.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(e.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(e.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(e.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(e.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(e.g.tag_user_mute_msg);
        }
        if (sparseArray.get(e.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fDA);
        userMuteAddAndDelCustomMessage.setTag(this.fDA);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean rO(String str) {
        if (!StringUtils.isNull(str) && ba.bA(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(e.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void ke(boolean z) {
        this.fDo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bdD() {
        ArrayList<PostData> bbL;
        int y;
        if (this.fDd == null || this.fDd.getPbData() == null || this.fDd.getPbData().bbL() == null || (y = com.baidu.tbadk.core.util.v.y((bbL = this.fDd.getPbData().bbL()))) == 0) {
            return "";
        }
        if (this.fDd.beQ()) {
            Iterator<PostData> it = bbL.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.byM() == 1) {
                    return next.getId();
                }
            }
        }
        int bgz = this.fDg.bgz();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bbL, bgz);
        if (postData == null || postData.wm() == null) {
            return "";
        }
        if (this.fDd.rR(postData.wm().getUserId())) {
            return postData.getId();
        }
        for (int i = bgz - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(bbL, i);
            if (postData2 == null || postData2.wm() == null || postData2.wm().getUserId() == null) {
                break;
            } else if (this.fDd.rR(postData2.wm().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bgz + 1; i2 < y; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(bbL, i2);
            if (postData3 == null || postData3.wm() == null || postData3.wm().getUserId() == null) {
                return "";
            }
            if (this.fDd.rR(postData3.wm().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ay.AN().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(rN(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fDd.getPbData().bbH().getId(), this.fDd.getPbData().bbH().getName(), this.fDd.getPbData().bbJ().getTid());
            }
            this.fCU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.dT(getResources().getString(e.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.dT(getResources().getString(e.j.make_sure_hide));
        }
        aVar.a(getResources().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fDd.bfa() != null) {
                    PbActivity.this.fDd.bfa().cK(j);
                }
            }
        });
        aVar.b(getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.aF(false);
        aVar.b(getPageContext());
        aVar.yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c rP(String str) {
        String str2;
        if (this.fDd.getPbData() == null || this.fDd.getPbData().bbL() == null || this.fDd.getPbData().bbL().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fDd.getPbData().bbL().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fDd.getPbData().bbL().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fDd.getPbData().bbL().get(i);
        if (postData.byO() == null || postData.byO().OP() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.byO().OP().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.OV() != null) {
                    str2 = next.OV().Pk();
                }
            }
        }
        str2 = null;
        a(str2, 0, cVar);
        com.baidu.tieba.pb.data.e.a(postData, cVar);
        return cVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fCL) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fCL = false;
        } else if (bdE()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fCL) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fCL = false;
        } else if (bdE()) {
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
        if (pageStayDurationItem != null && this.fDd != null) {
            if (this.fDd.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.fDd.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.fDd.beD(), 0L));
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bdE() {
        return (!this.fCJ && this.fEt == -1 && this.fEu == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fEw = mVar;
            this.fCJ = true;
            this.fDg.bgj();
            this.fDg.rY(this.fEv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdF() {
        if (this.fEw != null) {
            if (this.fEt == -1) {
                showToast(e.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bz(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fEw.getCartoonId(), this.fEt, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdG() {
        if (this.fEw != null) {
            if (this.fEu == -1) {
                showToast(e.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bz(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fEw.getCartoonId(), this.fEu, 0)));
                finish();
            }
        }
    }

    public int bdH() {
        return this.fEt;
    }

    public int bdI() {
        return this.fEu;
    }

    private void aHx() {
        if (this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bbJ() != null && this.fDd.getPbData().bbJ().xa()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bdJ() {
        if (this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bbJ() != null && this.fDd.getPbData().bbJ().xa()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bdK() {
        if (this.fCM) {
            this.fCZ = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fDd.getPbData() != null && this.fDd.getPbData().bbJ() != null && this.fDd.getPbData().bbJ().vT() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fDd.getPbData().bbJ().vT().getThreadId(), this.fDd.getPbData().bbJ().vT().getTaskId(), this.fDd.getPbData().bbJ().vT().getForumId(), this.fDd.getPbData().bbJ().vT().getForumName(), this.fDd.getPbData().bbJ().wh(), this.fDd.getPbData().bbJ().wi())));
            this.fCL = true;
            finish();
        }
    }

    public String bdL() {
        return this.fCX;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bdM() {
        return this.fDc;
    }

    public void kf(boolean z) {
        this.fCY = z;
    }

    public boolean bdN() {
        if (this.fDd != null) {
            return this.fDd.beF();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdO() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dT(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fDy).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fDy.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fDy).yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fDy != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fDy.getPageActivity());
            aVar.dT(str);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fDy).yl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fDg.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fDy.getPageActivity());
        if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            aVar.dT(this.fDy.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.dT(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fDg.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fDy).yl();
    }

    public void bdP() {
        if (this.fDd != null && this.fDd.getPbData() != null && this.fDd.getPbData().bbJ() != null && this.fDd.getPbData().bbJ().xp() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cp(e.j.channel_open_push_message);
            aVar.a(e.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fDd.getPbData().bbJ().xp().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(e.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.yl();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (aw.sa(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_wenxue)) != null) {
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
            this.isFullScreen = true;
        } else {
            this.isFullScreen = false;
        }
        if (this.fDg != null) {
            this.fDg.onConfigurationChanged(configuration);
        }
        if (this.fDm != null) {
            this.fDm.dismiss();
        }
    }

    public boolean bdQ() {
        if (this.fDd != null) {
            return this.fDd.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.fDd.getPbData().bbU().fBd;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).byJ().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).byJ().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).byJ().remove(i2);
                    list.get(i).byL();
                    z = true;
                    break;
                }
            }
            list.get(i).uv(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.n(this.fDd.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bcq().getId();
        List<PostData> list = this.fDd.getPbData().bbU().fBd;
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
                ArrayList<PostData> bcu = jVar.bcu();
                postData.ui(jVar.getTotalCount());
                if (postData.byJ() != null) {
                    postData.byJ().clear();
                    postData.byJ().addAll(bcu);
                }
            }
        }
        if (!this.fDd.getIsFromMark()) {
            this.fDg.n(this.fDd.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bcD() {
        return this.fDh;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bcE() {
        if (this.fDd == null) {
            return false;
        }
        return this.fDd.bcE();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bcF() {
        if (this.fDd != null) {
            return this.fDd.bcF();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bcG() {
        if (this.fDd == null || this.fDd.getPbData() == null) {
            return 0;
        }
        return this.fDd.getPbData().bbV();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean rJ(String str) {
        return this.fDd != null && this.fDd.rR(str);
    }

    public void bdR() {
        if (this.fDg != null) {
            this.fDg.bfX();
            awu();
        }
    }

    public PostData bbQ() {
        return this.fDg.b(this.fDd.fID, this.fDd.beE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.isLinkThread()) {
                return 3;
            }
            if (bbVar.xr()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fDI != null && !this.fDI.isEmpty()) {
            int size = this.fDI.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fDI.get(i).onBackPressed()) {
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
            if (this.fDI == null) {
                this.fDI = new ArrayList();
            }
            if (!this.fDI.contains(aVar)) {
                this.fDI.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fDI == null) {
                this.fDI = new ArrayList();
            }
            if (!this.fDI.contains(aVar)) {
                this.fDI.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fDI != null) {
            this.fDI.remove(aVar);
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dsX == null) {
            this.dsX = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dsX.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aM(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dsX.a(contriInfo, -1L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.k kVar) {
        com.baidu.tbadk.core.util.ad.a(kVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(kVar, getUniqueId(), this);
    }
}
