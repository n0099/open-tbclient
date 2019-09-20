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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
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
import com.baidu.tbadk.t.bf;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.pb.main.r;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.LikeModel;
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
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<PbActivity> {
    private com.baidu.adp.lib.e.b<ImageView> cKV;
    private com.baidu.adp.lib.e.b<GifView> cKW;
    private com.baidu.adp.lib.e.b<TextView> cNK;
    private com.baidu.adp.lib.e.b<View> cNL;
    private com.baidu.adp.lib.e.b<LinearLayout> cNM;
    private com.baidu.adp.lib.e.b<RelativeLayout> cNN;
    private com.baidu.adp.lib.e.b<TbImageView> cdT;
    private LikeModel cer;
    private com.baidu.tieba.f.b ebS;
    private au fYi;
    private VoiceManager fwa;
    private com.baidu.tieba.frs.profession.permission.c fzF;
    public com.baidu.tbadk.core.util.aj gYK;
    private String hMN;
    private com.baidu.tieba.pb.pb.main.b.b hMT;
    private com.baidu.tbadk.core.dialog.k hNA;
    private boolean hNC;
    private com.baidu.tieba.tbadkCore.data.f hNG;
    private com.baidu.tbadk.editortools.pb.f hNH;
    private com.baidu.tbadk.editortools.pb.d hNI;
    private com.baidu.tieba.frs.profession.permission.c hNK;
    private EmotionImageData hNL;
    private com.baidu.adp.base.e hNO;
    private com.baidu.tbadk.core.view.e hNP;
    private BdUniqueId hNQ;
    private Runnable hNR;
    private com.baidu.adp.widget.ImageView.a hNS;
    private String hNT;
    private TbRichTextMemeInfo hNU;
    private List<a> hNX;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hNj;
    private View hNk;
    int hNm;
    private com.baidu.tbadk.core.data.av hNn;
    private com.baidu.tieba.pb.pb.report.a hNq;
    public as hNy;
    private com.baidu.tbadk.core.dialog.i hNz;
    private boolean hOA;
    private String hOL;
    private com.baidu.tbadk.core.data.o hOM;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").P("obj_locate", at.a.bUN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").P("obj_locate", at.a.bUN));
        }
    };
    private static final b.a hOG = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.f.b.a
        public void jl(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bUs();
            } else {
                com.baidu.tieba.pb.a.b.bUr();
            }
        }
    };
    private boolean hMS = false;
    private boolean hMU = false;
    private boolean hMV = false;
    private boolean hqm = false;
    private boolean hMW = true;
    private int hMX = 0;
    private com.baidu.tbadk.core.dialog.b hMY = null;
    private long eZc = -1;
    private long cAY = 0;
    private long hMZ = 0;
    private long createTime = 0;
    private long cAQ = 0;
    private boolean hNa = false;
    private com.baidu.tbadk.p.b hNb = null;
    private long hNc = 0;
    private boolean hNd = false;
    private long hNe = 0;
    private int fVN = 1;
    private String cuL = null;
    private boolean hNf = false;
    private boolean isFullScreen = false;
    private String hNg = "";
    private boolean hNh = true;
    private boolean hNi = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hNl = new int[2];
    private PbInterviewStatusView.a hNo = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void G(boolean z) {
            PbActivity.this.hNt.oV(!PbActivity.this.hNh);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hNp != null && PbActivity.this.hNp.aaF()) {
                        PbActivity.this.bVp();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hNp = null;
    private com.baidu.tbadk.baseEditMark.a hNr = null;
    private ForumManageModel eFl = null;
    private com.baidu.tbadk.coreExtra.model.a bTT = null;
    private com.baidu.tieba.pb.data.l hNs = null;
    private ShareSuccessReplyToServerModel fMq = null;
    private aq hNt = null;
    public final com.baidu.tieba.pb.pb.main.b.a hNu = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hNv = false;
    private boolean hNw = false;
    private boolean hNx = false;
    private boolean hNB = false;
    private boolean hND = false;
    private boolean hNE = false;
    private boolean hNF = false;
    private boolean hNJ = false;
    public boolean hNM = false;
    private com.baidu.tbadk.editortools.pb.c cuO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void asL() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b cuP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean asK() {
            if (PbActivity.this.hNy == null || PbActivity.this.hNy.bZl() == null || !PbActivity.this.hNy.bZl().cAp()) {
                return !PbActivity.this.xO(com.baidu.tbadk.core.util.aj.bTO);
            }
            PbActivity.this.showToast(PbActivity.this.hNy.bZl().cAr());
            if (PbActivity.this.hNI != null && (PbActivity.this.hNI.asZ() || PbActivity.this.hNI.ata())) {
                PbActivity.this.hNI.a(false, PbActivity.this.hNy.bZo());
            }
            PbActivity.this.hNy.ph(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hNN = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean asK() {
            if (PbActivity.this.hNy == null || PbActivity.this.hNy.bZm() == null || !PbActivity.this.hNy.bZm().cAp()) {
                return !PbActivity.this.xO(com.baidu.tbadk.core.util.aj.bTP);
            }
            PbActivity.this.showToast(PbActivity.this.hNy.bZm().cAr());
            if (PbActivity.this.hNt != null && PbActivity.this.hNt.bXX() != null && PbActivity.this.hNt.bXX().bWp() != null && PbActivity.this.hNt.bXX().bWp().ata()) {
                PbActivity.this.hNt.bXX().bWp().a(PbActivity.this.hNy.bZo());
            }
            PbActivity.this.hNy.pi(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean fwP = false;
    private int hNV = 0;
    private int hNW = -1;
    private final a hNY = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hNt != null && PbActivity.this.hNt.bXX() != null) {
                s bXX = PbActivity.this.hNt.bXX();
                if (bXX.bWn()) {
                    bXX.bWm();
                    return true;
                }
            }
            if (PbActivity.this.hNt != null && PbActivity.this.hNt.bYS()) {
                PbActivity.this.hNt.bYT();
                return true;
            }
            return false;
        }
    };
    private r.a hNZ = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
    };
    private AddExperiencedModel.a fxb = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bVt();
        }
    };
    private final z.a hOa = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hNt.showToast(str);
            }
        }
    };
    private final CustomMessageListener hOb = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hNp != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hNI != null) {
                    PbActivity.this.hNt.pa(PbActivity.this.hNI.asT());
                }
                PbActivity.this.hNt.bXY();
                PbActivity.this.hNt.bYL();
            }
        }
    };
    CustomMessageListener fxv = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hNp.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hNt != null && PbActivity.this.hNp != null) {
                    PbActivity.this.hNt.d(PbActivity.this.hNp.getPbData(), PbActivity.this.hNp.bWz(), PbActivity.this.hNp.bWU());
                }
                if (PbActivity.this.hNt != null && PbActivity.this.hNt.bYp() != null) {
                    PbActivity.this.hNt.bYp().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hOc = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hNt != null) {
                    if (booleanValue) {
                        PbActivity.this.hNt.bFK();
                    } else {
                        PbActivity.this.hNt.bFJ();
                    }
                }
            }
        }
    };
    private CustomMessageListener hOd = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hNI != null) {
                    PbActivity.this.hNt.pa(PbActivity.this.hNI.asT());
                }
                PbActivity.this.hNt.pc(false);
            }
        }
    };
    private CustomMessageListener hOe = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.k) eVar.getData());
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
    private CustomMessageListener hOf = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hNt != null && PbActivity.this.hNt.bYp() != null) {
                PbActivity.this.hNt.bYp().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gCG = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener fxs = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hMV) {
                PbActivity.this.bVJ();
            }
        }
    };
    private h.a hOg = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void v(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.xQ(2);
                aj.bXI().reset();
                PbActivity.this.hNp.bWV();
                boolean z2 = false;
                ArrayList<PostData> bTA = PbActivity.this.hNp.getPbData().bTA();
                if (bTA != null) {
                    Iterator<PostData> it = bTA.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.cqI().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hNt.m(PbActivity.this.hNp.getPbData());
                    }
                    PbActivity.this.showToast(R.string.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(R.string.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(R.string.operation_failed);
        }
    };
    private View.OnClickListener cvz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.cuL);
        }
    };
    private CustomMessageListener hOh = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hNp.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hNp.bWL() != null && PbActivity.this.hNp.bWL().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hNt.a(aaVar.sendCount, PbActivity.this.hNp.getPbData(), PbActivity.this.hNp.bWz(), PbActivity.this.hNp.bWU());
                    }
                    if (pbData.bTA() != null && pbData.bTA().size() >= 1 && pbData.bTA().get(0) != null) {
                        long e = com.baidu.adp.lib.g.b.e(pbData.bTA().get(0).getId(), 0L);
                        long e2 = com.baidu.adp.lib.g.b.e(PbActivity.this.hNp.bWy(), 0L);
                        if (e == aaVar.postId && e2 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cqH = pbData.bTA().get(0).cqH();
                            if (cqH == null) {
                                cqH = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> ady = cqH.ady();
                            if (ady == null) {
                                ady = new ArrayList<>();
                            }
                            ady.add(0, aVar);
                            cqH.setTotal(aaVar.sendCount + cqH.getTotal());
                            cqH.p(ady);
                            pbData.bTA().get(0).a(cqH);
                            PbActivity.this.hNt.bYp().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fNB = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                PbActivity.this.Cm((String) customResponsedMessage.getData());
                PbActivity.this.hNp.bWR();
                if (PbActivity.this.hNt.bYp() != null) {
                    PbActivity.this.hNt.m(PbActivity.this.hNp.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hOi = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bZv()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hOj = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aj(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.aa(list) && PbActivity.this.hNt != null) {
                PbActivity.this.hNt.dJ(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hOk = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.cF(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.iE().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19.1
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
    private boolean hOl = false;
    private PraiseModel hOm = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void td(String str) {
            PbActivity.this.hOl = false;
            if (PbActivity.this.hOm != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hNp.getPbData();
                if (pbData.bTy().aeo().getIsLike() == 1) {
                    PbActivity.this.sz(0);
                } else {
                    PbActivity.this.sz(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bTy()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbActivity.this.hOl = false;
            if (PbActivity.this.hOm != null && str != null) {
                if (AntiHelper.aG(i, str)) {
                    AntiHelper.aQ(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hOn = 0;
    private boolean hOo = true;
    private b.a hOp = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void ow(boolean z) {
            PbActivity.this.ov(z);
            if (PbActivity.this.hNt.bYY() != null && z) {
                PbActivity.this.hNt.oV(false);
            }
            PbActivity.this.hNt.oX(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().ciI != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().ciI, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").P("obj_locate", at.a.bUN));
                        }
                    } else if (updateAttentionMessage.getData().Hs) {
                        if (PbActivity.this.bTF().aeC() != null && PbActivity.this.bTF().aeC().getGodUserData() != null) {
                            PbActivity.this.bTF().aeC().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().aeC() != null) {
                            PbActivity.this.hNp.getPbData().bTy().aeC().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a ebj = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hNt.aVf();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.xR(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.bvw();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(R.string.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c cmw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            PbActivity.this.bUZ();
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (PbActivity.this.cw(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                    if (PbActivity.this.hNt != null && PbActivity.this.hNt.bUX() && view.getId() == R.id.pb_head_user_info_root) {
                        if (view.getTag(R.id.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").bT(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(R.id.tag_user_id)));
                        }
                        if (PbActivity.this.hNu != null && PbActivity.this.hNu.fYB != null) {
                            PbActivity.this.hNu.fYB.onClick(view);
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
            if (PbActivity.this.hNI != null) {
                PbActivity.this.hNt.pa(PbActivity.this.hNI.asT());
            }
            PbActivity.this.hNt.bXY();
            PbActivity.this.hNt.bYL();
            return true;
        }
    });
    private CustomMessageListener hOq = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hNQ) {
                PbActivity.this.hNt.aVf();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hNp.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bTL().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hNP.i(PbActivity.this.hNO.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hNO.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbActivity.this.qG(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bVF();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hNO.getResources().getString(R.string.mute_fail);
                    }
                    PbActivity.this.hNP.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hOr = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hNQ) {
                PbActivity.this.hNt.aVf();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hNP.i(PbActivity.this.hNO.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hNO.getResources().getString(R.string.un_mute_fail);
                }
                PbActivity.this.hNP.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hOs = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hNQ) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hNt.aVf();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.jwQ;
                if (aVar.error == 0 && dataRes != null) {
                    int f = com.baidu.adp.lib.g.b.f(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = f == 1;
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.hNt.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hOt = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hNt.bXZ() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bUZ();
            }
        }
    };
    private CustomMessageListener fxC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.fwP = true;
                }
            }
        }
    };
    public a.b hBx = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bnf();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hNp.getPageData();
            int pageNum = PbActivity.this.hNt.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.adr()) {
                PbActivity.this.hNt.bYL();
                PbActivity.this.xQ(2);
                PbActivity.this.bne();
                PbActivity.this.hNt.bYt();
                if (com.baidu.adp.lib.util.j.kc()) {
                    PbActivity.this.hNp.xY(PbActivity.this.hNt.getPageNum());
                    if (PbActivity.this.hMT != null) {
                        PbActivity.this.hMT.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(R.string.pb_page_error);
            }
        }
    };
    public final View.OnClickListener fyk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Multi-variable search result rejected for r4v291, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v295, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v322, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v436, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:582:0x1c2e  */
        /* JADX WARN: Removed duplicated region for block: B:585:0x1c77  */
        /* JADX WARN: Removed duplicated region for block: B:602:0x1e8d  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            String str;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            boolean or;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            long j;
            String str2;
            int i;
            int i2;
            int i3;
            bm bmVar;
            String[] strArr;
            boolean u;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.hNt.bYH()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hNp.oG(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hNt.bYu();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hNt.hWn.bZJ() == null || view != PbActivity.this.hNt.hWn.bZJ().bXD()) {
                        if (view == PbActivity.this.hNt.hWn.cDi) {
                            if (PbActivity.this.hNt.oZ(PbActivity.this.hNp.bWE())) {
                                PbActivity.this.bne();
                                return;
                            }
                            PbActivity.this.hMW = false;
                            PbActivity.this.hMU = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hNt.hWn.cDi);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hNt.bYr() && (PbActivity.this.hNt.hWn.bZJ() == null || (view != PbActivity.this.hNt.hWn.bZJ().bXC() && view != PbActivity.this.hNt.hWn.bZJ().bXA()))) {
                            if (view == PbActivity.this.hNt.bYO()) {
                                if (PbActivity.this.hNp != null) {
                                    com.baidu.tbadk.browser.a.ae(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hNp.getPbData().bTy().aeB().getLink());
                                }
                            } else if (view != PbActivity.this.hNt.hWn.ibI) {
                                if (view == PbActivity.this.hNt.hWn.ibJ) {
                                    if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                                        ArrayList<PostData> bTA = PbActivity.this.hNp.getPbData().bTA();
                                        if ((bTA == null || bTA.size() <= 0) && PbActivity.this.hNp.bWz()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").bT("tid", PbActivity.this.hNp.bWy()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", PbActivity.this.hNp.getForumId()));
                                        if (!PbActivity.this.hNt.bZd()) {
                                            PbActivity.this.hNt.bXY();
                                        }
                                        PbActivity.this.bVh();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.kc()) {
                                        PbActivity.this.hNt.oA(true);
                                        PbActivity.this.hNt.bXY();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hNt.bFK();
                                            PbActivity.this.bne();
                                            PbActivity.this.hNt.bYt();
                                            PbActivity.this.hNp.Ct(PbActivity.this.bVu());
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.xQ(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbActivity.this.hNt.hWn.bZJ() == null || view != PbActivity.this.hNt.hWn.bZJ().bXz()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbActivity.this.hNt.hWn.bZJ() != null && view == PbActivity.this.hNt.hWn.bZJ().getCancelView()) {
                                            PbActivity.this.hNt.hWn.UQ();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbActivity.this.hNt.hWn.bZJ() == null || view != PbActivity.this.hNt.hWn.bZJ().bXx()) {
                                                if ((PbActivity.this.hNt.hWn.bZJ() == null || view != PbActivity.this.hNt.hWn.bZJ().bXF()) && view.getId() != R.id.pb_sort) {
                                                    if (PbActivity.this.hNt.hWn.bZJ() == null || view != PbActivity.this.hNt.hWn.bZJ().bXy()) {
                                                        if (PbActivity.this.hNt.hWn.bZJ() == null || view != PbActivity.this.hNt.hWn.bZJ().bXG()) {
                                                            if (PbActivity.this.hNt.bYY() == view) {
                                                                if (PbActivity.this.hNt.bYY().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hNp.getPbData();
                                                                    if (pbData != null && pbData.bTy() != null && pbData.bTy().aei() != null) {
                                                                        String adZ = pbData.bTy().aei().adZ();
                                                                        if (StringUtils.isNull(adZ)) {
                                                                            adZ = pbData.bTy().aei().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").bT(VideoPlayActivityConfig.OBJ_ID, adZ));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.en("c10725", null);
                                                                }
                                                                PbActivity.this.bVB();
                                                            } else if (PbActivity.this.hNt.hWn.bZJ() == null || view != PbActivity.this.hNt.hWn.bZJ().bXE()) {
                                                                if (PbActivity.this.hNt.hWn.bZJ() != null && view == PbActivity.this.hNt.hWn.bZJ().bXB()) {
                                                                    if (com.baidu.adp.lib.util.j.kc()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hNt.c(PbActivity.this.hNp.getPbData(), PbActivity.this.hNp.bWz(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(R.id.tag_del_multi_forum))) {
                                                                                PbActivity.this.hNt.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hNt.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) c2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hNt.hWn.UQ();
                                                                    } else {
                                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hNp != null && view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.bT("tid", PbActivity.this.hNp.bWy());
                                                                        anVar.bT("fid", PbActivity.this.hNp.getForumId());
                                                                        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.P("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hNp.getPbData() != null) {
                                                                            PbActivity.this.hNt.bYL();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cqL() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.jjw != null) {
                                                                                    com.baidu.tbadk.core.util.an ajp = postData.jjw.ajp();
                                                                                    ajp.nX("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        ajp.P("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        ajp.P("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(ajp);
                                                                                }
                                                                                String bWy = PbActivity.this.hNp.bWy();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hNp.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hNp.getPbData().bTK();
                                                                                }
                                                                                PbActivity.this.bne();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    c Cr = PbActivity.this.Cr(id);
                                                                                    if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && Cr != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bWy, id, "pb", true, null, true, null, i4, postData.caC(), PbActivity.this.hNp.getPbData().getAnti(), false, postData.aeC().getIconInfo()).addBigImageData(Cr.hPo, Cr.hPp, Cr.hPq, Cr.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hNp.bXh());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hNp.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c Cr2 = PbActivity.this.Cr(id);
                                                                                    if (postData != null && PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && Cr2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bWy, id, "pb", true, null, false, null, i4, postData.caC(), PbActivity.this.hNp.getPbData().getAnti(), false, postData.aeC().getIconInfo()).addBigImageData(Cr2.hPo, Cr2.hPp, Cr2.hPq, Cr2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hNp.bXh());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hNp.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").P("obj_locate", 3).bT("fid", PbActivity.this.hNp.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbActivity.this.hNp != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.bT("tid", PbActivity.this.hNp.bWy());
                                                                        anVar2.bT("fid", PbActivity.this.hNp.getForumId());
                                                                        anVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.P("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                                                                                    String bWy2 = PbActivity.this.hNp.bWy();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hNp.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hNp.getPbData().bTK();
                                                                                    }
                                                                                    c Cr3 = PbActivity.this.Cr(id2);
                                                                                    if (Cr3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bWy2, id2, "pb", true, null, false, null, i5, postData2.caC(), PbActivity.this.hNp.getPbData().getAnti(), false, postData2.aeC().getIconInfo()).addBigImageData(Cr3.hPo, Cr3.hPp, Cr3.hPq, Cr3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hNp.bXh());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hNp.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply) {
                                                                    if (PbActivity.this.hNp != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.bT("tid", PbActivity.this.hNp.bWy());
                                                                        anVar3.bT("fid", PbActivity.this.hNp.getForumId());
                                                                        anVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.P("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.bUW().bXW() != null && postData3.aeC() != null && postData3.cqz() != 1) {
                                                                                    if (PbActivity.this.bUW().bXX() != null) {
                                                                                        PbActivity.this.bUW().bXX().bWl();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                    kVar.a(PbActivity.this.hNp.getPbData().getForum());
                                                                                    kVar.ak(PbActivity.this.hNp.getPbData().bTy());
                                                                                    kVar.e(postData3);
                                                                                    PbActivity.this.bUW().bXW().d(kVar);
                                                                                    PbActivity.this.bUW().bXW().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.aeC().getUserId(), "");
                                                                                    if (PbActivity.this.hNI != null) {
                                                                                        PbActivity.this.hNt.pa(PbActivity.this.hNI.asT());
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } else if (view != PbActivity.this.hNt.bUQ()) {
                                                                    if (view == PbActivity.this.hNt.hWn.bZK()) {
                                                                        PbActivity.this.hNt.bYA();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbActivity.this.checkUpIsLogin() && (bmVar = (bm) view.getTag()) != null && !StringUtils.isNull(bmVar.agE())) {
                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.ajK().c(PbActivity.this.getPageContext(), new String[]{bmVar.agE()});
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right || id3 == R.id.image_more_tip) {
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                if (view != null && view.getTag() != null) {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").bT("tid", PbActivity.this.hNp.hSu));
                                                                                    }
                                                                                    if (PbActivity.this.hNA == null) {
                                                                                        PbActivity.this.hNA = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                                                                                        PbActivity.this.hNA.a(PbActivity.this.hOF);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cy(view);
                                                                                    if (!PbActivity.this.cy(view) || PbActivity.this.hNS == null || !PbActivity.this.hNS.isGif()) {
                                                                                    }
                                                                                    boolean z3 = false;
                                                                                    boolean z4 = false;
                                                                                    boolean z5 = false;
                                                                                    boolean z6 = false;
                                                                                    boolean z7 = false;
                                                                                    if (!(sparseArray4.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                        z = false;
                                                                                    } else {
                                                                                        z = ((Boolean) sparseArray4.get(R.id.tag_should_hide_chudian_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                        ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                        z3 = ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z4 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                        z5 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z6 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                        z7 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                    }
                                                                                    if (!(sparseArray4.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                                                                        str = null;
                                                                                    } else {
                                                                                        str = (String) sparseArray4.get(R.id.tag_forbid_user_post_id);
                                                                                    }
                                                                                    if (z) {
                                                                                        if (!(sparseArray4.get(R.id.tag_chudian_template_id) instanceof Long)) {
                                                                                            j = 0;
                                                                                        } else {
                                                                                            j = ((Long) sparseArray4.get(R.id.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (!(sparseArray4.get(R.id.tag_chudian_monitor_id) instanceof String)) {
                                                                                            str2 = "";
                                                                                        } else {
                                                                                            str2 = (String) sparseArray4.get(R.id.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (!(sparseArray4.get(R.id.tag_chudian_hide_day) instanceof Integer)) {
                                                                                            i = 0;
                                                                                        } else {
                                                                                            i = ((Integer) sparseArray4.get(R.id.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hNA);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cqB() != null && postData4.cqB().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hNA);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbActivity.this.gpL = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hNp.getPbData().aaF()) {
                                                                                        String aaE = PbActivity.this.hNp.getPbData().aaE();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(aaE) && aaE.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hNA);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hNA);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbActivity.this.gpL);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hNA);
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_user_mute_visible, true);
                                                                                                    sparseArray7.put(R.id.tag_is_mem, sparseArray4.get(R.id.tag_is_mem));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_mute_userid, sparseArray4.get(R.id.tag_user_mute_mute_userid));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_mute_username, sparseArray4.get(R.id.tag_user_mute_mute_username));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_mute_nameshow, sparseArray4.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_post_id, sparseArray4.get(R.id.tag_user_mute_post_id));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_thread_id, sparseArray4.get(R.id.tag_user_mute_thread_id));
                                                                                                    sparseArray7.put(R.id.tag_del_post_is_self, sparseArray4.get(R.id.tag_del_post_is_self));
                                                                                                    sparseArray7.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                    sparseArray7.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    gVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar6);
                                                                                                } else {
                                                                                                    if (!ap.m(PbActivity.this.gpL)) {
                                                                                                        or = PbActivity.this.or(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        or = false;
                                                                                                    }
                                                                                                    if (or) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hNA);
                                                                                                        gVar7.mTextView.setTag(str);
                                                                                                        arrayList.add(gVar7);
                                                                                                    }
                                                                                                }
                                                                                                if (z5) {
                                                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                                                    sparseArray8.put(R.id.tag_should_manage_visible, true);
                                                                                                    sparseArray8.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name, sparseArray4.get(R.id.tag_forbid_user_name));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name_show, sparseArray4.get(R.id.tag_forbid_user_name_show));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_portrait, sparseArray4.get(R.id.tag_forbid_user_portrait));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_post_id, str);
                                                                                                    if (z6) {
                                                                                                        sparseArray8.put(R.id.tag_user_mute_visible, true);
                                                                                                        sparseArray8.put(R.id.tag_is_mem, sparseArray4.get(R.id.tag_is_mem));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_mute_userid, sparseArray4.get(R.id.tag_user_mute_mute_userid));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_mute_username, sparseArray4.get(R.id.tag_user_mute_mute_username));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_mute_nameshow, sparseArray4.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_post_id, sparseArray4.get(R.id.tag_user_mute_post_id));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_thread_id, sparseArray4.get(R.id.tag_user_mute_thread_id));
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_user_mute_visible, false);
                                                                                                    }
                                                                                                    if (z7) {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, true);
                                                                                                        sparseArray8.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                        sparseArray8.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                        sparseArray8.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hNA);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hNA);
                                                                                                    gVar3.mTextView.setTag(sparseArray8);
                                                                                                } else if (!z7) {
                                                                                                    gVar2 = null;
                                                                                                    gVar3 = null;
                                                                                                } else {
                                                                                                    SparseArray sparseArray9 = new SparseArray();
                                                                                                    sparseArray9.put(R.id.tag_should_manage_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                    sparseArray9.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                    sparseArray9.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                    sparseArray9.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                    if (PbActivity.this.hNp.getPbData().bTK() == 1002 && !z3) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hNA);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hNA);
                                                                                                    }
                                                                                                    gVar2.mTextView.setTag(sparseArray9);
                                                                                                    gVar3 = null;
                                                                                                }
                                                                                                if (gVar2 != null) {
                                                                                                    arrayList.add(gVar2);
                                                                                                }
                                                                                                if (gVar3 != null) {
                                                                                                    arrayList.add(gVar3);
                                                                                                }
                                                                                            }
                                                                                            PbActivity.this.hNA.W(arrayList);
                                                                                            PbActivity.this.hNz = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hNA);
                                                                                            PbActivity.this.hNz.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbActivity.this.gpL);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hNA.W(arrayList);
                                                                                    PbActivity.this.hNz = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hNA);
                                                                                    PbActivity.this.hNz.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), PbActivity.this.hNp.getPbData().bTy().getActUrl());
                                                                                if (PbActivity.this.hNp.getPbData().bTy().afm() != 1) {
                                                                                    if (PbActivity.this.hNp.getPbData().bTy().afm() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").bT("fid", PbActivity.this.hNp.getPbData().getForumId()).bT("tid", PbActivity.this.hNp.getPbData().getThreadId()).bT("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hNp.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hNt.setSelection(0);
                                                                                } else {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.cF(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbActivity.this.hNt.bXY();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bVe() == 1 && PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").bT("fid", PbActivity.this.hNp.getPbData().getForumId()).bT("tid", PbActivity.this.hNp.getPbData().getThreadId()).bT("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bVe() == 1 && PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").bT("fid", PbActivity.this.hNp.getPbData().getForumId()).bT("tid", PbActivity.this.hNp.getPbData().getThreadId()).bT("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbActivity.this.bVw();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbActivity.this.bVx();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTR() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hNp.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").bT("fid", pbData2.getForumId()));
                                                                                ba.ajK().c(PbActivity.this.getPageContext(), new String[]{pbData2.bTR().bTY()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTR() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hNp.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bT("fid", pbData3.getForumId()));
                                                                                ba.ajK().c(PbActivity.this.getPageContext(), new String[]{pbData3.bTR().bTY()});
                                                                            }
                                                                        } else if (PbActivity.this.hNt.hWn.bZJ() != null && view == PbActivity.this.hNt.hWn.bZJ().bXH()) {
                                                                            if (PbActivity.this.hNp == null || PbActivity.this.hNp.getPbData() == null || PbActivity.this.hNp.getPbData().bTy() == null) {
                                                                                PbActivity.this.hNt.hWn.UQ();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.kt()) {
                                                                                PbActivity.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hNp.getPbData().bTy().aej() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hNp.bWy(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(R.string.haved_fans_called)).agW();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").P("obj_locate", PbActivity.this.aw(PbActivity.this.hNp.getPbData().bTy())).bT("tid", PbActivity.this.hNp.getPbData().bTy().getTid()).P("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hNV >= 0) {
                                                                                if (PbActivity.this.hNp != null) {
                                                                                    PbActivity.this.hNp.bXi();
                                                                                }
                                                                                if (PbActivity.this.hNt.bYp() != null) {
                                                                                    PbActivity.this.hNt.bYp().a(PbActivity.this.hNp.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hNt.getListView().setSelection(PbActivity.this.hNp.bXl());
                                                                                PbActivity.this.hNV = 0;
                                                                                if (PbActivity.this.hNp != null) {
                                                                                    PbActivity.this.hNp.ch(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbActivity.this.bVb();
                                                                        } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                            SparseArray sparseArray10 = null;
                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                sparseArray10 = (SparseArray) view.getTag();
                                                                            }
                                                                            if (sparseArray10 != null) {
                                                                                PbActivity.this.d(sparseArray10);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                            if (PbActivity.this.hNt.getListView() != null && PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hNt.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbActivity.this.hNt.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean bTW = PbActivity.this.hNp.getPbData().bTW();
                                                                                boolean z8 = PbActivity.this.hNt.hWh != null && PbActivity.this.hNt.hWh.caS();
                                                                                boolean bYI = PbActivity.this.hNt.bYI();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bTW && PbActivity.this.hNt.hWh != null && PbActivity.this.hNt.hWh.aJY() != null) {
                                                                                    int af = ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)) - PbActivity.this.hNt.hWh.caT();
                                                                                    z9 = firstVisiblePosition == 0 && (top == af || top == PbActivity.this.hNt.hWh.aJY().getHeight() - PbActivity.this.hNt.hWh.caT());
                                                                                    i7 = af;
                                                                                }
                                                                                if ((PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().aet() <= 0) || (bYI && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bVb();
                                                                                        if (PbActivity.this.hNp.getPbData().bTy().aeC() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hNp.hSu).bT("fid", PbActivity.this.hNp.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hNp.getPbData().bTy().aeC().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.6d);
                                                                                    if (bTW) {
                                                                                        if (PbActivity.this.hNt.hYc != null && PbActivity.this.hNt.hYc.hZm != null && PbActivity.this.hNt.hYc.hZm.getView() != null) {
                                                                                            if (PbActivity.this.hNt.hYc.hZm.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bVk();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hNt.hWh.aJY() != null) {
                                                                                                    i8 = PbActivity.this.hNt.hWh.aJY().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hNt.hYc.hZm.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hNt.bYg() != null) {
                                                                                        z10 = PbActivity.this.hNt.bYg().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hNt.hYc != null && PbActivity.this.hNt.hYc.hZm != null && PbActivity.this.hNt.hYc.hZm.getView() != null && PbActivity.this.hNt.hYc.hZm.getView().getParent() != null && PbActivity.this.hNt.hWn != null && PbActivity.this.hNt.hWn.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hNt.hYc.hZm.getView().getTop() - PbActivity.this.hNt.hWn.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bYI) {
                                                                                        int bVk = PbActivity.this.bVk();
                                                                                        if (PbActivity.this.bVj() != -1) {
                                                                                            bVk--;
                                                                                        }
                                                                                        int g = com.baidu.adp.lib.util.l.g(PbActivity.this, R.dimen.tbds116);
                                                                                        if (bVk < 0) {
                                                                                            i2 = PbActivity.this.hNt.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.Z(PbActivity.this.hNt.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bVk;
                                                                                            i3 = g;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bTW || PbActivity.this.hNt.hWh.aJY() == null) {
                                                                                            if (PbActivity.this.hNt.hWn != null && PbActivity.this.hNt.hWn.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hNt.hWn.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hNt.hWh.aJY().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hNt.hYc == null || PbActivity.this.hNt.hYc.hZm == null || PbActivity.this.hNt.hYc.hZm.getView() == null || PbActivity.this.hNt.hYc.hZm.getView().getParent() == null) {
                                                                                            PbActivity.this.hNt.getListView().setSelectionFromTop(i2, i3 + ah);
                                                                                            PbActivity.this.hNt.getListView().smoothScrollBy(ah, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hNt.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hNt.getListView().smoothScrollBy(PbActivity.this.hNt.hYc.hZm.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-ah))) {
                                                                                        PbActivity.this.hNt.getListView().setSelectionFromTop(0, i7 - ah);
                                                                                        PbActivity.this.hNt.getListView().smoothScrollBy(-ah, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hNt.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().aeC() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hNp.hSu).bT("fid", PbActivity.this.hNp.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hNp.getPbData().bTy().aeC().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbActivity.this.hNp.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hNp.bXh() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hNp.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.bT("tid", PbActivity.this.hNp.bWy());
                                                                                anVar4.bT("fid", PbActivity.this.hNp.getForumId());
                                                                                anVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bh) {
                                                                                bh bhVar = (bh) view.getTag();
                                                                                if (PbActivity.this.hNp.bXh() == 3 && PbActivity.this.bUu() && PbActivity.this.hNp.getPbData() != null && com.baidu.tbadk.core.util.v.aa(PbActivity.this.hNp.getPbData().bTT())) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(bhVar.aeH(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.bT("tid", bhVar.getId());
                                                                                anVar5.n("fid", bhVar.getFid());
                                                                                anVar5.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbActivity.this.hNp != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.bT("tid", PbActivity.this.hNp.bWy());
                                                                                anVar6.bT("fid", PbActivity.this.hNp.getForumId());
                                                                                anVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.P("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.hNp.getPbData();
                                                                                if (PbActivity.this.hNs == null) {
                                                                                    PbActivity.this.hNs = new com.baidu.tieba.pb.data.l(PbActivity.this.getPageContext());
                                                                                }
                                                                                long e = com.baidu.adp.lib.g.b.e(pbData4.getThreadId(), 0L);
                                                                                long e2 = com.baidu.adp.lib.g.b.e(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").n("forum_id", e2).ajq();
                                                                                PbActivity.this.registerListener(PbActivity.this.hOv);
                                                                                PbActivity.this.hNs.s(e, e2);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_video_thread_smart_app_layout) {
                                                                            if (view.getTag() instanceof SmartApp) {
                                                                                SmartApp smartApp = (SmartApp) view.getTag();
                                                                                if (!com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                    if (!StringUtils.isNull(smartApp.h5_url)) {
                                                                                        com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), smartApp.h5_url);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").bT("fid", PbActivity.this.hNp.getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", smartApp.name).n(VideoPlayActivityConfig.OBJ_ID, smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "PB_card").bT("tid", PbActivity.this.hNp.bWy()).P("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bh) {
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(((bh) view.getTag()).aeH(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").bT("page_type", "a005").P("obj_isad", 1).P("obj_adlocate", 9));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bh) && PbActivity.this.checkUpIsLogin()) {
                                                                                bh bhVar2 = (bh) view.getTag();
                                                                                if (PbActivity.this.cer != null) {
                                                                                    PbActivity.this.cer.em(bhVar2.aeH(), String.valueOf(bhVar2.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").bT("page_type", "a005").P("obj_isad", 1).P("obj_adlocate", 10));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.e(PbActivity.this.hNp.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.e(PbActivity.this.hNp.bWy(), 0L), com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hNp.getPbData().bTy().aeW())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.kc()) {
                                                                PbActivity.this.hNt.bYL();
                                                                SparseArray<Object> c3 = PbActivity.this.hNt.c(PbActivity.this.hNp.getPbData(), PbActivity.this.hNp.bWz(), 1);
                                                                if (c3 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hNp.getPbData().getForum().getId(), PbActivity.this.hNp.getPbData().getForum().getName(), PbActivity.this.hNp.getPbData().bTy().getId(), String.valueOf(PbActivity.this.hNp.getPbData().getUserData().getUserId()), (String) c3.get(R.id.tag_forbid_user_name), (String) c3.get(R.id.tag_forbid_user_name_show), (String) c3.get(R.id.tag_forbid_user_post_id), (String) c3.get(R.id.tag_forbid_user_portrait))));
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(R.string.network_not_available);
                                                                return;
                                                            }
                                                        } else {
                                                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                            UtilHelper.showSkinChangeAnimation(PbActivity.this.getActivity());
                                                            if (skinType == 1) {
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                if (com.baidu.tbadk.core.util.am.ajn()) {
                                                                    UtilHelper.setNavigationBarBackground(PbActivity.this.getActivity(), PbActivity.this.getResources().getColor(R.color.cp_bg_line_d_2));
                                                                    TbadkCoreApplication.getInst().setSkinType(4);
                                                                } else {
                                                                    UtilHelper.setNavigationBarBackground(PbActivity.this.getActivity(), PbActivity.this.getResources().getColor(R.color.cp_bg_line_d));
                                                                    TbadkCoreApplication.getInst().setSkinType(0);
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10647").P("obj_type", 0).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbActivity.this.getActivity(), PbActivity.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10647").P("obj_type", 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                            }
                                                            PbActivity.this.hNt.hWn.bZI();
                                                        }
                                                    } else if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTy() != null) {
                                                        PbActivity.this.hNt.hWn.UQ();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbActivity.this.Co(PbActivity.this.hNp.getPbData().bTy().aeS());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hNt.bYL();
                                                    if (com.baidu.adp.lib.util.j.kc()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hNp.bWP()));
                                                            return;
                                                        }
                                                        PbActivity.this.xQ(2);
                                                        PbActivity.this.bne();
                                                        PbActivity.this.hNt.bYt();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hNp.getPbData().hKH == null || PbActivity.this.hNp.getPbData().hKH.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(R.string.sort_type_new), PbActivity.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hNp.getPbData().hKH.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hNp.getPbData().hKH.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hNp.getPbData().hKH.get(i10).sort_name + PbActivity.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbActivity.this.hNp.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hNp.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hNp.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hNp.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != R.id.pb_sort ? 1 : 0).P("obj_type", i12));
                                                                if (PbActivity.this.hNp.getPbData().hKH != null && PbActivity.this.hNp.getPbData().hKH.size() > i11) {
                                                                    i11 = PbActivity.this.hNp.getPbData().hKH.get(i11).sort_type.intValue();
                                                                }
                                                                boolean yd = PbActivity.this.hNp.yd(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hNp.bWP()));
                                                                if (yd) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hNt.oR(true);
                                                                }
                                                            }
                                                        });
                                                        iVar.showDialog();
                                                    } else {
                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                        return;
                                                    }
                                                }
                                            } else {
                                                PbActivity.this.hNt.bYL();
                                                if (PbActivity.this.bUE().getPbData().hKI != 2) {
                                                    if (PbActivity.this.hNp.getPageData() != null) {
                                                        PbActivity.this.hNt.a(PbActivity.this.hNp.getPageData(), PbActivity.this.hBx);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (bf.iN() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().aeC() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hNp.hSu).bT("fid", PbActivity.this.hNp.getPbData().getForumId()).P("obj_locate", 4).bT("uid", PbActivity.this.hNp.getPbData().bTy().aeC().getUserId()));
                                            }
                                            if (PbActivity.this.hNp != null) {
                                                com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an("c12386");
                                                anVar7.bT("tid", PbActivity.this.hNp.bWy());
                                                anVar7.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                anVar7.bT("fid", PbActivity.this.hNp.getForumId());
                                                anVar7.P("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    anVar7.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(anVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.kt()) {
                                                if (PbActivity.this.hNp.getPbData() != null) {
                                                    ArrayList<PostData> bTA2 = PbActivity.this.hNp.getPbData().bTA();
                                                    if ((bTA2 != null && bTA2.size() > 0) || !PbActivity.this.hNp.bWz()) {
                                                        PbActivity.this.hNt.bYL();
                                                        PbActivity.this.bne();
                                                        PbActivity.this.xQ(2);
                                                        if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTR() != null && !StringUtils.isNull(PbActivity.this.hNp.getPbData().bTR().acZ(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bT("fid", PbActivity.this.hNp.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                        if (bf.iN()) {
                                                            PbActivity.this.xR(2);
                                                        } else {
                                                            PbActivity.this.hNt.showLoadingDialog();
                                                            PbActivity.this.hNp.bXc().p(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                        }
                                                    } else {
                                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                        return;
                                                    }
                                                } else {
                                                    com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.showToast(R.string.neterror);
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.kc()) {
                                        PbActivity.this.hNt.bYL();
                                        if (PbActivity.this.hNt.hWn.bZJ() != null && view == PbActivity.this.hNt.hWn.bZJ().bXz() && !PbActivity.this.hNt.bZd()) {
                                            PbActivity.this.hNt.bXY();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bne();
                                            PbActivity.this.hNt.bYt();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                u = PbActivity.this.hNp.u(true, PbActivity.this.bVu());
                                            } else {
                                                u = view.getId() == R.id.reply_title ? PbActivity.this.hNp.u(false, PbActivity.this.bVu()) : PbActivity.this.hNp.Ct(PbActivity.this.bVu());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hNt.oA(true);
                                                PbActivity.this.hNt.bFK();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hNt.oR(true);
                                            }
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.xQ(2);
                                        } else {
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(R.string.network_not_available);
                                        view.setTag(Boolean.FALSE);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.kc()) {
                                    PbActivity.this.hNt.bYL();
                                    if (PbActivity.this.xP(11009) && PbActivity.this.hNp.ye(PbActivity.this.hNt.bYy()) != null) {
                                        PbActivity.this.bVo();
                                        if (PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().aeC() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hNp.hSu).bT("fid", PbActivity.this.hNp.getPbData().getForumId()).P("obj_locate", 3).bT("uid", PbActivity.this.hNp.getPbData().bTy().aeC().getUserId()));
                                        }
                                        if (PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().aeC() != null && PbActivity.this.hNp.getPbData().bTy().aeC().getUserId() != null && PbActivity.this.hNr != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bT("tid", PbActivity.this.hNp.hSu).P("obj_locate", 1).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hNp.getPbData().bTy().aeC().getUserId()).P("obj_type", PbActivity.this.hNr.aaF() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hNp.getPbData())));
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(R.string.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().afw() && PbActivity.this.hNp.getPbData().bTy().aeT() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbActivity.this.hNp.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hNp.bUv()) && PbActivity.this.hNp.getAppealInfo() != null) {
                                        name = PbActivity.this.hNp.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hNp.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bUv = PbActivity.this.hNp.bUv();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hNp.bWA() && bUv != null && bUv.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.kc()) {
                            if (PbActivity.this.hNp.getPbData() != null) {
                                if ((PbActivity.this.hNp.getPbData().bTK() == 1 || PbActivity.this.hNp.getPbData().bTK() == 3) && !PbActivity.this.eFl.crl()) {
                                    PbActivity.this.hNt.bYL();
                                    int i11 = 0;
                                    if (PbActivity.this.hNt.hWn.bZJ() == null || view != PbActivity.this.hNt.hWn.bZJ().bXA()) {
                                        if (PbActivity.this.hNt.hWn.bZJ() == null || view != PbActivity.this.hNt.hWn.bZJ().bXC()) {
                                            if (view == PbActivity.this.hNt.bYr()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hNp.getPbData().bTy().aey() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hNp.getPbData().bTy().aex() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hNp.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hNp.getPbData().bTy().getId();
                                    PbActivity.this.hNt.bYq();
                                    PbActivity.this.eFl.a(id4, name2, id5, i11, PbActivity.this.hNt.bYs());
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(R.string.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.kc()) {
                        PbActivity.this.hNt.bYL();
                        PbActivity.this.bne();
                        PbActivity.this.hNt.bYt();
                        PbActivity.this.hNt.showLoadingDialog();
                        if (PbActivity.this.hNt.bYg() != null) {
                            PbActivity.this.hNt.bYg().setVisibility(8);
                        }
                        PbActivity.this.hNp.xY(1);
                        if (PbActivity.this.hMT != null) {
                            PbActivity.this.hMT.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String bVc = PbActivity.this.bVc();
                        if (!TextUtils.isEmpty(bVc)) {
                            ba.ajK().c(PbActivity.this.getPageContext(), new String[]{bVc});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hNp != null) {
                    com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                    anVar8.bT("tid", PbActivity.this.hNp.bWy());
                    anVar8.bT("fid", PbActivity.this.hNp.getForumId());
                    anVar8.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar8.P("obj_locate", 1);
                    TiebaStatic.log(anVar8);
                }
                if (PbActivity.this.hNd) {
                    PbActivity.this.hNd = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.bUW().bXW() != null && postData5.aeC() != null && postData5.cqz() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bUW().bXX() != null) {
                                PbActivity.this.bUW().bXX().bWl();
                            }
                            com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                            kVar2.a(PbActivity.this.hNp.getPbData().getForum());
                            kVar2.ak(PbActivity.this.hNp.getPbData().bTy());
                            kVar2.e(postData5);
                            PbActivity.this.bUW().bXW().d(kVar2);
                            PbActivity.this.bUW().bXW().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.aeC().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hNp.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hNI != null) {
                                PbActivity.this.hNt.pa(PbActivity.this.hNI.asT());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d cuV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                    anVar.bT("fid", PbActivity.this.hNp.getPbData().getForumId());
                }
                if (PbActivity.this.hNp != null) {
                    anVar.bT("tid", PbActivity.this.hNp.bWy());
                }
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbActivity.this.bne();
            PbActivity.this.hNt.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.t.av.awe() && PbActivity.this.bUE() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bUE().Cw(postWriteCallBackData.getPostId());
                    PbActivity.this.hNV = PbActivity.this.hNt.bYc();
                    if (PbActivity.this.hNp != null) {
                        PbActivity.this.hNp.ch(PbActivity.this.hNV, PbActivity.this.hNt.bYd());
                    }
                }
                PbActivity.this.hNt.bYL();
                PbActivity.this.hNy.bZk();
                if (PbActivity.this.hNI != null) {
                    PbActivity.this.hNt.pa(PbActivity.this.hNI.asT());
                }
                PbActivity.this.hNt.bXV();
                PbActivity.this.hNt.pc(true);
                PbActivity.this.hNp.bWR();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hNp.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hNp.getPbData();
                            if (pbData != null && pbData.bTy() != null && pbData.bTy().aeC() != null && (userId = pbData.bTy().aeC().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.t.av.awe() && PbActivity.this.hNp.bWI()) {
                                PbActivity.this.hNt.bYt();
                            }
                        } else if (!com.baidu.tbadk.t.av.awe() && PbActivity.this.hNp.bWI()) {
                            PbActivity.this.hNt.bYt();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hNt.m(PbActivity.this.hNp.getPbData());
                    }
                    if (PbActivity.this.hNp.bWD()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").bT("tid", PbActivity.this.hNp.bWy()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hNI.asZ() || PbActivity.this.hNI.ata()) {
                    PbActivity.this.hNI.a(false, postWriteCallBackData);
                }
                PbActivity.this.hNy.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gYK != null) {
                    PbActivity.this.gYK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (yVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hOu = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                    anVar.bT("fid", PbActivity.this.hNp.getPbData().getForumId());
                }
                if (PbActivity.this.hNp != null) {
                    anVar.bT("tid", PbActivity.this.hNp.bWy());
                }
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbActivity.this.hNy != null) {
                    PbActivity.this.hNy.bZj();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gYK != null) {
                    PbActivity.this.gYK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hNy != null) {
                if (PbActivity.this.hNt != null && PbActivity.this.hNt.bXX() != null && PbActivity.this.hNt.bXX().bWp() != null && PbActivity.this.hNt.bXX().bWp().ata()) {
                    PbActivity.this.hNt.bXX().bWp().a(postWriteCallBackData);
                }
                PbActivity.this.hNy.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hOv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView bZi;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbActivity.this.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbActivity.this.hNt != null && (bZi = PbActivity.this.hNt.bZi()) != null && PbActivity.this.hNt.getListView() != null) {
                            PbActivity.this.hNt.getListView().removeHeaderView(bZi);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a hOw = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g kq;
            if (!z || dVar == null || dVar.bTI() != null || com.baidu.tbadk.core.util.v.Z(dVar.bTA()) >= 1) {
                PbActivity.this.hqm = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hNt.bYv();
                if (dVar == null || !dVar.bTE()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hNt.getView());
                }
                PbActivity.this.hNt.bFJ();
                if (PbActivity.this.isFullScreen || PbActivity.this.hNt.bZd()) {
                    PbActivity.this.hNt.bYU();
                } else if (!PbActivity.this.hNt.bYR()) {
                    PbActivity.this.hNt.pc(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hNB = true;
                }
                if (dVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hNt.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hNt.aWv();
                    if (dVar.bTy() != null && dVar.bTy().afF() != null) {
                        PbActivity.this.a(dVar.bTy().afF());
                    }
                    PbActivity.this.bUS();
                    if (PbActivity.this.hNI != null) {
                        PbActivity.this.hNt.pa(PbActivity.this.hNI.asT());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bTA() != null && dVar.bTA().size() >= 1 && dVar.bTA().get(0) != null) {
                        PbActivity.this.hNp.Cv(dVar.bTA().get(0).getId());
                    } else if (dVar.bTI() != null) {
                        PbActivity.this.hNp.Cv(dVar.bTI().getId());
                    }
                    if (PbActivity.this.hNI != null) {
                        PbActivity.this.hNI.a(dVar.getAnti());
                        PbActivity.this.hNI.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hNI.a(PbActivity.this.hNp.bWL(), PbActivity.this.hNp.bWy(), PbActivity.this.hNp.bXe());
                        if (dVar.bTy() != null) {
                            PbActivity.this.hNI.fr(dVar.bTy().afU());
                        }
                    }
                    if (PbActivity.this.hNr != null) {
                        PbActivity.this.hNr.dx(dVar.aaF());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hNt.pb(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hNt.a(dVar, i2, i3, PbActivity.this.hNp.bWz(), i4, PbActivity.this.hNp.getIsFromMark());
                    PbActivity.this.hNt.e(dVar, PbActivity.this.hNp.bWz());
                    PbActivity.this.hNt.oY(PbActivity.this.hNp.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.cuL = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.cuL) && PbActivity.this.hNI != null && PbActivity.this.hNI.asm() != null && (kq = PbActivity.this.hNI.asm().kq(6)) != null && !TextUtils.isEmpty(PbActivity.this.cuL)) {
                            ((View) kq).setOnClickListener(PbActivity.this.cvz);
                        }
                    }
                    if (PbActivity.this.hND) {
                        PbActivity.this.hND = false;
                        final int bVj = PbActivity.this.bVj();
                        if (!dVar.bTW()) {
                            PbActivity.this.hNt.yk(bVj);
                        } else {
                            final int af = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bVj, af);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hNE) {
                        PbActivity.this.hNE = false;
                        final int bVj2 = PbActivity.this.bVj();
                        final boolean z2 = bVj2 != -1;
                        if (!z2) {
                            bVj2 = PbActivity.this.bVk();
                        }
                        if (PbActivity.this.hNt != null) {
                            if (!dVar.bTW()) {
                                PbActivity.this.hNt.yk(bVj2);
                            } else {
                                final int af2 = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bVj2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hNt.setSelectionFromTop(bVj2, af2);
                                            } else {
                                                PbActivity.this.hNt.setSelectionFromTop(bVj2 - 1, af2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hNt.pd(true);
                                PbActivity.this.hNt.pc(false);
                            }
                        }
                    } else if (PbActivity.this.hNF) {
                        PbActivity.this.hNF = false;
                        PbActivity.this.hNt.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hNt.bYz();
                    }
                    PbActivity.this.hNp.a(dVar.getForum(), PbActivity.this.hOi);
                    PbActivity.this.hNp.a(PbActivity.this.hOj);
                    if (PbActivity.this.gYK != null && dVar.bTy() != null && dVar.bTy().aeC() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bTy().aeC());
                        PbActivity.this.gYK.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hNB && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hNp != null && PbActivity.this.hNp.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hNp.getAppealInfo().hKb)) {
                                    PbActivity.this.hNt.a(PbActivity.this.hNp.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hNt.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hNt.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                            }
                            PbActivity.this.hNt.bYU();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hNp.bWy());
                            jSONObject.put("fid", PbActivity.this.hNp.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                        kVar.setOpType("2");
                        kVar.start();
                    }
                    if (i == -1) {
                        PbActivity.this.hNt.Cz("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                            arrayList = PbActivity.this.hNp.getPbData().bTA();
                        }
                        if (com.baidu.tbadk.core.util.v.Z(arrayList) != 0 && (com.baidu.tbadk.core.util.v.Z(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cqz() != 1)) {
                            PbActivity.this.hNt.Cz(PbActivity.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbActivity.this.bVH()) {
                            PbActivity.this.hNt.CA(PbActivity.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbActivity.this.hNt.CA(PbActivity.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbActivity.this.hNt.akS();
                }
                PbActivity.this.cAY = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bUE().bWz() || PbActivity.this.bUE().getPbData().getPage().adx() != 0 || PbActivity.this.bUE().bWY()) {
                    PbActivity.this.hNJ = true;
                    return;
                }
                return;
            }
            PbActivity.this.hNp.xY(1);
            if (PbActivity.this.hMT != null) {
                PbActivity.this.hMT.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hNt.m(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.p.m.avH().avI()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eZc : j;
                com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, PbActivity.this.cAQ, PbActivity.this.createTime, PbActivity.this.cAY, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.cAQ = 0L;
                if (iVar != null) {
                    iVar.avE();
                }
                if (z2) {
                    iVar.cBh = currentTimeMillis;
                    iVar.fH(true);
                }
                if (!z2 && PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTy() != null) {
                    int threadType = PbActivity.this.hNp.getPbData().bTy().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.bV(PbActivity.this.hNg, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.bV(PbActivity.this.hNg, "from_frs")) {
                                com.baidu.tbadk.p.i iVar2 = new com.baidu.tbadk.p.i();
                                iVar2.kU(1000);
                                iVar2.cBj = currentTimeMillis;
                                iVar2.kV(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.p.d dVar = new com.baidu.tbadk.p.d();
                        dVar.pageType = 1;
                        dVar.kU(1005);
                        dVar.cBj = currentTimeMillis;
                        dVar.kV(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hOx = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bVf();
            }
        }
    };
    private final a.InterfaceC0247a hOy = new a.InterfaceC0247a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0247a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hNt.bYv();
            if (z) {
                if (PbActivity.this.hNr != null) {
                    PbActivity.this.hNr.dx(z2);
                }
                PbActivity.this.hNp.oI(z2);
                if (PbActivity.this.hNp.aaF()) {
                    PbActivity.this.bVp();
                } else {
                    PbActivity.this.hNt.m(PbActivity.this.hNp.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hNr != null && PbActivity.this.hNr.aaI() != null && PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().aeC() != null) {
                        MarkData aaI = PbActivity.this.hNr.aaI();
                        MetaData aeC = PbActivity.this.hNp.getPbData().bTy().aeC();
                        if (aaI != null && aeC != null) {
                            if (!com.baidu.tbadk.core.util.aq.bV(TbadkCoreApplication.getCurrentAccount(), aeC.getUserId()) && !aeC.hadConcerned()) {
                                PbActivity.this.b(aeC);
                                return;
                            } else {
                                PbActivity.this.showToast(R.string.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(R.string.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.xM(PbActivity.this.mLastScrollState) && PbActivity.this.xM(i)) {
                if (PbActivity.this.hNt != null) {
                    PbActivity.this.hNt.bYL();
                    if (PbActivity.this.hNI != null && !PbActivity.this.hNt.bXZ()) {
                        PbActivity.this.hNt.pa(PbActivity.this.hNI.asT());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hNt.bXY();
                    }
                }
                if (!PbActivity.this.hNa) {
                    PbActivity.this.hNa = true;
                    PbActivity.this.hNt.bYQ();
                }
            }
            PbActivity.this.hNt.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hMT != null) {
                PbActivity.this.hMT.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hNb == null) {
                PbActivity.this.hNb = new com.baidu.tbadk.p.b();
                PbActivity.this.hNb.kU(1001);
            }
            if (i == 0) {
                PbActivity.this.hNb.avy();
            } else {
                PbActivity.this.hNb.avx();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.cpt().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bTA;
            if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNt != null && PbActivity.this.hNt.bYp() != null) {
                PbActivity.this.hNt.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hMT != null) {
                    PbActivity.this.hMT.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hNp.bWT() && (bTA = PbActivity.this.hNp.getPbData().bTA()) != null && !bTA.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hNt.bYp().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hNp.getPbData();
                    if (pbData != null) {
                        if (pbData.bTB() != null && pbData.bTB().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bTC() != null && pbData.bTC().hasData()) {
                            headerCount--;
                        }
                        int size = bTA.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eFp = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eFl.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hNp.bWR();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.idK != 1002 || bVar.gbx) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hNt.a(1, dVar.FU, dVar.jlh, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eFl.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hNt.a(PbActivity.this.eFl.getLoadDataMode(), gVar.FU, gVar.jlh, false);
                        PbActivity.this.hNt.ax(gVar.jlk);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hNt.a(PbActivity.this.eFl.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hOz = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final h.c daZ = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            if (PbActivity.this.bVv()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hNp.oH(true)) {
                PbActivity.this.hNt.bYw();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fQE = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hOA && PbActivity.this.bVv()) {
                PbActivity.this.bVx();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hNp.oG(false)) {
                    PbActivity.this.hNt.bYu();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hNp.getPbData() != null) {
                    PbActivity.this.hNt.bYP();
                }
                PbActivity.this.hOA = true;
            }
        }
    };
    private int hOB = 0;
    private final TbRichTextView.h cLe = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bYp;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hNp != null) {
                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                        anVar.bT("tid", PbActivity.this.hNp.bWy());
                        anVar.bT("fid", PbActivity.this.hNp.getForumId());
                        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar.P("obj_locate", 3);
                        anVar.P("obj_type", z2 ? 1 : 2);
                        TiebaStatic.log(anVar);
                    }
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        boolean isGif = ((TbImageView) view).isGif();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                        }
                        PbActivity.this.hNk = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hPr) {
                        TbRichText bg = PbActivity.this.bg(str, i);
                        if (bg != null && PbActivity.this.hOB >= 0 && PbActivity.this.hOB < bg.ayZ().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bg.ayZ().get(PbActivity.this.hOB));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hPo.size()) {
                                    break;
                                } else if (!cVar.hPo.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bg.getPostId() != 0 && (bYp = PbActivity.this.hNt.bYp()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bYp.getDataList();
                                if (com.baidu.tbadk.core.util.v.Z(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bg.getPostId() == com.baidu.adp.lib.g.b.e(((PostData) next).getId(), 0L)) {
                                            if (bg.getPostId() != com.baidu.adp.lib.g.b.e(PbActivity.this.hNp.bXe(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hNp.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.aa(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hPp.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hPq, cVar.lastId, PbActivity.this.hNp.bWO(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.o(rect);
                            createConfig.setIsHotSort(PbActivity.this.hNp.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hPo, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.aa(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hPp.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hPq, cVar.hPo.get(0), PbActivity.this.hNp.bWO(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hNp.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hNt.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hOC = false;
    PostData gpL = null;
    private final b.a hOD = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.gpL != null) {
                if (i == 0) {
                    PbActivity.this.gpL.en(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.gpL = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.gpL);
                }
            }
        }
    };
    private final b.a hOE = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hNS != null && !TextUtils.isEmpty(PbActivity.this.hNT)) {
                if (i == 0) {
                    if (PbActivity.this.hNU == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hNT));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hNT;
                        aVar.pkgId = PbActivity.this.hNU.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hNU.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    PbActivity.this.mPermissionJudgement.ake();
                    PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.ad(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fYi == null) {
                            PbActivity.this.fYi = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fYi.h(PbActivity.this.hNT, PbActivity.this.hNS.nN());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hNS = null;
                PbActivity.this.hNT = null;
            }
        }
    };
    private final View.OnLongClickListener cnB = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        /* JADX WARN: Removed duplicated region for block: B:27:0x0099 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01eb  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            String str;
            boolean or;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            int i;
            SparseArray sparseArray;
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (PbActivity.this.cy(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.hNS = ((TbImageView) view).getBdImage();
                        PbActivity.this.hNT = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hNS == null || TextUtils.isEmpty(PbActivity.this.hNT)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hNU = null;
                        } else {
                            PbActivity.this.hNU = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hNS = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hNT = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hNU = null;
                            } else {
                                PbActivity.this.hNU = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hNS = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hNT = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hNU = null;
                        } else {
                            PbActivity.this.hNU = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e2) {
                            e2.printStackTrace();
                            sparseArray = sparseArray2;
                        }
                    } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                        PbActivity.this.hNt.a(PbActivity.this.hOE, PbActivity.this.hNS.isGif());
                    } else {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray = sparseArray2;
                        }
                    }
                    if (sparseArray != null) {
                        return true;
                    }
                    sparseArray2 = sparseArray;
                }
                sparseArray = sparseArray2;
                if (sparseArray != null) {
                }
            }
            PbActivity.this.gpL = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbActivity.this.gpL == null) {
                return true;
            }
            if (PbActivity.this.gpL.cqz() != 1 || !PbActivity.this.cy(view)) {
                if (PbActivity.this.hNr != null) {
                    if (!PbActivity.this.hNr.aaF() || PbActivity.this.gpL.getId() == null || !PbActivity.this.gpL.getId().equals(PbActivity.this.hNp.aeL())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.gpL.cqz() == 1) {
                        PbActivity.this.hNt.a(PbActivity.this.hOD, z, false);
                        return true;
                    }
                    if (PbActivity.this.hNA == null) {
                        PbActivity.this.hNA = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                        PbActivity.this.hNA.a(PbActivity.this.hOF);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cy = PbActivity.this.cy(view);
                        boolean z3 = (!PbActivity.this.cy(view) || PbActivity.this.hNS == null || PbActivity.this.hNS.isGif()) ? false : true;
                        boolean z4 = false;
                        boolean z5 = false;
                        boolean z6 = false;
                        boolean z7 = false;
                        boolean z8 = false;
                        boolean z9 = false;
                        if (sparseArray2.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean) {
                            z2 = ((Boolean) sparseArray2.get(R.id.tag_should_hide_chudian_visible)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean) {
                            z4 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                            z5 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                            z6 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                            z7 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                            z8 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                            z9 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                        }
                        if (!(sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                            str = null;
                        } else {
                            str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
                        }
                        if (z2) {
                            long j = 0;
                            String str2 = "";
                            if (sparseArray2.get(R.id.tag_chudian_template_id) instanceof Long) {
                                j = ((Long) sparseArray2.get(R.id.tag_chudian_template_id)).longValue();
                            }
                            if (sparseArray2.get(R.id.tag_chudian_monitor_id) instanceof String) {
                                str2 = (String) sparseArray2.get(R.id.tag_chudian_monitor_id);
                            }
                            if (!(sparseArray2.get(R.id.tag_chudian_hide_day) instanceof Integer)) {
                                i = 0;
                            } else {
                                i = ((Integer) sparseArray2.get(R.id.tag_chudian_hide_day)).intValue();
                            }
                            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hNA);
                            gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                            gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                            gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(gVar3);
                        }
                        if (cy) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbActivity.this.getString(R.string.save_to_emotion), PbActivity.this.hNA));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbActivity.this.getString(R.string.save_to_local), PbActivity.this.hNA));
                        }
                        if (!cy && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hNA);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(R.id.tag_clip_board, PbActivity.this.gpL);
                            gVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(gVar4);
                        }
                        if (!z4) {
                            if (z) {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hNA);
                            } else {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hNA);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(R.id.tag_clip_board, PbActivity.this.gpL);
                            sparseArray4.put(R.id.tag_is_subpb, false);
                            gVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(gVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hNA);
                                SparseArray sparseArray5 = new SparseArray();
                                sparseArray5.put(R.id.tag_user_mute_visible, true);
                                sparseArray5.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                                sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                                sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                                sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                                sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                                sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                                sparseArray5.put(R.id.tag_del_post_is_self, sparseArray2.get(R.id.tag_del_post_is_self));
                                sparseArray5.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                sparseArray5.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                sparseArray5.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                gVar5.mTextView.setTag(sparseArray5);
                                arrayList.add(gVar5);
                            } else {
                                if (!ap.m(PbActivity.this.gpL)) {
                                    or = PbActivity.this.or(z5) & PbActivity.this.isLogin();
                                } else {
                                    or = false;
                                }
                                if (or) {
                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hNA);
                                    gVar6.mTextView.setTag(str);
                                    arrayList.add(gVar6);
                                }
                            }
                            com.baidu.tbadk.core.dialog.g gVar7 = null;
                            if (z7) {
                                SparseArray sparseArray6 = new SparseArray();
                                sparseArray6.put(R.id.tag_should_manage_visible, true);
                                sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                                sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                                sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                                sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                                if (z8) {
                                    sparseArray6.put(R.id.tag_user_mute_visible, true);
                                    sparseArray6.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                                    sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                                    sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                                    sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                                    sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                                    sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                                } else {
                                    sparseArray6.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z9) {
                                    sparseArray6.put(R.id.tag_should_delete_visible, true);
                                    sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                    sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                    gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hNA);
                                    gVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(R.id.tag_should_delete_visible, false);
                                }
                                gVar = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hNA);
                                gVar.mTextView.setTag(sparseArray6);
                            } else {
                                if (z9) {
                                    SparseArray sparseArray7 = new SparseArray();
                                    sparseArray7.put(R.id.tag_should_manage_visible, false);
                                    sparseArray7.put(R.id.tag_user_mute_visible, false);
                                    sparseArray7.put(R.id.tag_should_delete_visible, true);
                                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                    sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                    if (PbActivity.this.hNp.getPbData().bTK() == 1002 && !z5) {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hNA);
                                    } else {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hNA);
                                    }
                                    gVar7.mTextView.setTag(sparseArray7);
                                }
                                gVar = null;
                            }
                            if (gVar7 != null) {
                                arrayList.add(gVar7);
                            }
                            if (gVar != null) {
                                arrayList.add(gVar);
                            }
                        }
                        PbActivity.this.hNA.W(arrayList);
                        PbActivity.this.hNz = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hNA);
                        PbActivity.this.hNz.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").bT("tid", PbActivity.this.hNp.hSu).bT("fid", PbActivity.this.hNp.getForumId()).bT("uid", PbActivity.this.hNp.getPbData().bTy().aeC().getUserId()).bT("post_id", PbActivity.this.hNp.asI()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hNt.a(PbActivity.this.hOE, PbActivity.this.hNS.isGif());
            return true;
        }
    };
    private k.c hOF = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbActivity.this.hNz != null) {
                PbActivity.this.hNz.dismiss();
            }
            switch (i) {
                case 0:
                    long j = -1;
                    String str = "";
                    int i2 = 0;
                    if (view.getTag(R.id.tag_chudian_template_id) instanceof Long) {
                        j = ((Long) view.getTag(R.id.tag_chudian_template_id)).longValue();
                    }
                    if (view.getTag(R.id.tag_chudian_monitor_id) instanceof String) {
                        str = (String) view.getTag(R.id.tag_chudian_monitor_id);
                    }
                    if (view.getTag(R.id.tag_chudian_hide_day) instanceof Integer) {
                        i2 = ((Integer) view.getTag(R.id.tag_chudian_hide_day)).intValue();
                    }
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hNp.getPbData();
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    if (pbData != null && pbData.getForum() != null) {
                        str2 = pbData.getForum().getId();
                        str3 = pbData.getForum().getName();
                        str4 = pbData.getThreadId();
                    }
                    com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                    PbActivity.this.a(j, str, str2, str3, str4, i2);
                    return;
                case 1:
                    if (PbActivity.this.hNS != null && !TextUtils.isEmpty(PbActivity.this.hNT)) {
                        if (PbActivity.this.hNU == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hNT));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hNT;
                            aVar.pkgId = PbActivity.this.hNU.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hNU.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hNS = null;
                        PbActivity.this.hNT = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hNS != null && !TextUtils.isEmpty(PbActivity.this.hNT)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                        }
                        PbActivity.this.mPermissionJudgement.ake();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.ad(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fYi == null) {
                                PbActivity.this.fYi = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fYi.h(PbActivity.this.hNT, PbActivity.this.hNS.nN());
                            PbActivity.this.hNS = null;
                            PbActivity.this.hNT = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.gpL != null) {
                        PbActivity.this.gpL.en(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.gpL = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").P("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.cx(view);
                        if (PbActivity.this.hNp.getPbData().bTy() != null && PbActivity.this.hNp.getPbData().bTy().aeC() != null && PbActivity.this.hNp.getPbData().bTy().aeC().getUserId() != null && PbActivity.this.hNr != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bT("tid", PbActivity.this.hNp.hSu).P("obj_locate", 2).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hNp.getPbData().bTy().aeC().getUserId()).P("obj_type", PbActivity.this.hNr.aaF() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hNp.getPbData())));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!com.baidu.adp.lib.util.j.kc()) {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13079"));
                        PbActivity.this.Co((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").P("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            PbActivity.this.c(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbActivity.this.hNt.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.kc()) {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray3.put(R.id.tag_from, 1);
                                sparseArray3.put(R.id.tag_check_mute_from, 2);
                                PbActivity.this.c(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            PbActivity.this.hNt.cE(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hNt.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final NoNetworkView.a ftG = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            if (!PbActivity.this.hMV && z && !PbActivity.this.hNp.bWF()) {
                PbActivity.this.bVr();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener cnr = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.ebS.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0316a ebT = new a.InterfaceC0316a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        final int emE;

        {
            this.emE = (int) PbActivity.this.getResources().getDimension(R.dimen.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aY(int i, int i2) {
            if (ax(i2) && PbActivity.this.hNt != null && PbActivity.this.hMT != null) {
                PbActivity.this.hNt.bYV();
                PbActivity.this.hMT.ko(false);
                PbActivity.this.hMT.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aZ(int i, int i2) {
            if (ax(i2) && PbActivity.this.hNt != null && PbActivity.this.hMT != null) {
                PbActivity.this.hMT.ko(true);
                if (Math.abs(i2) > this.emE) {
                    PbActivity.this.hMT.hideFloatingView();
                }
                if (PbActivity.this.bVv()) {
                    PbActivity.this.hNt.bYm();
                    PbActivity.this.hNt.bYn();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void ba(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String hOH = null;
    private final m.a hOI = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void n(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hOH = str2;
                PbActivity.this.hNt.CB(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hOJ = -1;
    private int hOK = -1;
    private CustomMessageListener hON = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bEH == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0249a) {
                    if (aVar.bEI != null && !aVar.bEI.hasError() && aVar.bEI.getError() == 0) {
                        if (PbActivity.this.hNt != null) {
                            PbActivity.this.hNt.q(((a.C0249a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bVG();
                        }
                    } else if (z) {
                        if (aVar.bEI != null && aVar.bEI.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bEI.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bEI != null && !aVar.bEI.hasError() && aVar.bEI.getError() == 0) {
                        if (PbActivity.this.hNt != null && PbActivity.this.hNt != null) {
                            PbActivity.this.hNt.q(((a.C0249a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bEI != null && aVar.bEI.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bEI.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bEI == null || aVar.bEI.hasError() || aVar.bEI.getError() != 0) {
                        if (z) {
                            if (aVar.bEI != null && aVar.bEI.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bEI.getErrorString());
                            } else {
                                PbActivity.this.showToast(R.string.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(R.string.channel_need_push), 1).show();
                    }
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void m(Object obj);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public ArrayList<String> hPo;
        public ConcurrentHashMap<String, ImageUrlData> hPp;
        public boolean hPr;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hPq = false;
        public boolean hPs = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes4.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d bUR() {
        return this.hNI;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        boolean z = true;
        if (kVar.bUh() != null) {
            String id = kVar.bUh().getId();
            ArrayList<PostData> bTA = this.hNp.getPbData().bTA();
            int i = 0;
            while (true) {
                if (i >= bTA.size()) {
                    break;
                }
                PostData postData = bTA.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bUl = kVar.bUl();
                    postData.Bj(kVar.getTotalCount());
                    if (postData.cqw() != null && bUl != null) {
                        Iterator<PostData> it = bUl.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aeC() != null && (metaData = postData.getUserMap().get(next.aeC().getUserId())) != null) {
                                next.a(metaData);
                                next.rh(true);
                                next.a(getPageContext(), this.hNp.Cu(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bUl.size() != postData.cqw().size();
                        postData.cqw().clear();
                        postData.cqw().addAll(bUl);
                        z = z2;
                    }
                    if (postData.cqs() != null) {
                        postData.cqt();
                    }
                }
            }
            if (!this.hNp.getIsFromMark() && z) {
                this.hNt.m(this.hNp.getPbData());
            }
            if (z) {
                c(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cm(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bTN = this.hNp.getPbData().bTN();
            if (bTN != null && str.equals(bTN.getAdId())) {
                if (bTN.cqn() != null) {
                    bTN.cqn().legoCard = null;
                }
                this.hNp.getPbData().bTO();
            }
            com.baidu.tieba.tbadkCore.data.m bWJ = this.hNp.bWJ();
            if (bWJ != null && str.equals(bWJ.getAdId())) {
                this.hNp.bWK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.hNz != null && this.hNz.isShowing()) {
                this.hNz.dismiss();
                this.hNz = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this);
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbActivity.this.hNz != null) {
                            PbActivity.this.hNz.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hNt.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbActivity.this.hNQ);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hNQ);
                            PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                int i = -1;
                if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(0, getResources().getString(R.string.delete), kVar));
                }
                if (z) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getResources().getString(R.string.un_mute), kVar));
                } else {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getResources().getString(R.string.mute), kVar));
                }
                kVar.W(arrayList);
                this.hNz = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.hNz.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz(int i) {
        bh bTy;
        if (this.hNp != null && this.hNp.getPbData() != null && (bTy = this.hNp.getPbData().bTy()) != null) {
            if (i == 1) {
                PraiseData aeo = bTy.aeo();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aeo == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bTy.a(praiseData);
                    } else {
                        bTy.aeo().getUser().add(0, metaData);
                        bTy.aeo().setNum(bTy.aeo().getNum() + 1);
                        bTy.aeo().setIsLike(i);
                    }
                }
                if (bTy.aeo() != null) {
                    if (bTy.aeo().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.aM(bTy.aeo().getNum());
                    }
                }
            } else if (bTy.aeo() != null) {
                bTy.aeo().setIsLike(i);
                bTy.aeo().setNum(bTy.aeo().getNum() - 1);
                ArrayList<MetaData> user = bTy.aeo().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bTy.aeo().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bTy.aeo().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = bTy.aeo().getNum() + "";
                }
            }
            if (this.hNp.bWz()) {
                this.hNt.bYp().notifyDataSetChanged();
            } else {
                this.hNt.n(this.hNp.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hNp.ab(bundle);
        if (this.fwa != null) {
            this.fwa.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hNI.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hMZ = System.currentTimeMillis();
        this.hNO = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eZc = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hNg = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hNg) && intent.getData() != null) {
                this.hNg = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hNg)) {
                this.hMU = true;
            }
            this.hOJ = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hOK = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hOL = intent.getStringExtra("key_manga_title");
            this.hND = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hNE = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hNF = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bVv()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.hNW = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.hNn = new com.baidu.tbadk.core.data.av();
            this.hNn.O(intent);
        } else {
            this.eZc = System.currentTimeMillis();
        }
        this.cAQ = this.hMZ - this.eZc;
        super.onCreate(bundle);
        this.hMX = 0;
        aa(bundle);
        if (this.hNp != null && this.hNp.getPbData() != null) {
            this.hNp.getPbData().Ck(this.source);
        }
        bUV();
        initUI();
        if (intent != null && this.hNt != null) {
            this.hNt.hWg = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hNR == null) {
                    this.hNR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hNt.CD("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hNR, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hNp != null && this.hNp.getPbData() != null) {
                this.hNp.Cx(stringExtra);
            }
        }
        this.fwa = new VoiceManager();
        this.fwa.onCreate(getPageContext());
        initData(bundle);
        this.hNH = new com.baidu.tbadk.editortools.pb.f();
        bUS();
        this.hNI = (com.baidu.tbadk.editortools.pb.d) this.hNH.cK(getActivity());
        this.hNI.b(this);
        this.hNI.a(this.cuV);
        this.hNI.a(this.cuO);
        this.hNI.a(this, bundle);
        this.hNI.asm().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hNI.asm().fk(true);
        oq(true);
        this.hNt.setEditorTools(this.hNI.asm());
        this.hNI.a(this.hNp.bWL(), this.hNp.bWy(), this.hNp.bXe());
        registerListener(this.hOd);
        if (!this.hNp.bWE()) {
            this.hNI.qB(this.hNp.bWy());
        }
        if (this.hNp.bXf()) {
            this.hNI.qz(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.hNt != null) {
            this.hNI.qz(this.hNt.bYa());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hOc);
        registerListener(this.hOe);
        registerListener(this.hOf);
        registerListener(this.fxv);
        registerListener(this.hOt);
        registerListener(this.hOb);
        this.hNG = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.jhY);
        this.hNG.cqa();
        registerListener(this.hOh);
        registerListener(this.mAttentionListener);
        if (this.hNp != null) {
            this.hNp.bWW();
        }
        registerListener(this.hOx);
        registerListener(this.hON);
        registerListener(this.fxC);
        if (this.hNt != null && this.hNt.bYZ() != null && this.hNt.bZa() != null) {
            this.hMT = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hNt.bYZ(), this.hNt.bZa(), this.hNt.bYg());
            this.hMT.a(this.hOp);
        }
        if (this.hMS && this.hNt != null && this.hNt.bZa() != null) {
            this.hNt.bZa().setVisibility(8);
        }
        this.hNP = new com.baidu.tbadk.core.view.e();
        this.hNP.bZH = 1000L;
        registerListener(this.hOs);
        registerListener(this.hOq);
        registerListener(this.hOr);
        registerListener(this.fNB);
        registerListener(this.fxs);
        this.hNQ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hNQ;
        userMuteAddAndDelCustomMessage.setTag(this.hNQ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hNQ;
        userMuteCheckCustomMessage.setTag(this.hNQ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hNp.bXc().a(this.ebj);
        this.hNy = new as();
        if (this.hNI.asM() != null) {
            this.hNy.k(this.hNI.asM().getInputView());
        }
        this.hNI.a(this.cuP);
        this.fMq = new ShareSuccessReplyToServerModel();
        a(this.hNY);
        this.gYK = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gYK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bTO) {
                        PbActivity.this.hNI.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bTP && PbActivity.this.hNt != null && PbActivity.this.hNt.bXX() != null && PbActivity.this.hNt.bXX().bWp() != null) {
                        PbActivity.this.hNt.bXX().bWp().atf();
                    } else if (i == com.baidu.tbadk.core.util.aj.bTQ) {
                        PbActivity.this.c(PbActivity.this.hNL);
                    }
                }
            }
        });
        this.hNq = new com.baidu.tieba.pb.pb.report.a(this);
        this.hNq.r(getUniqueId());
        com.baidu.tieba.q.c.cpt().u(getUniqueId());
        com.baidu.tbadk.core.business.a.acw().bB("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.kd() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
        }
        this.createTime = System.currentTimeMillis() - this.hMZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUS() {
        if (this.hNH != null && this.hNp != null) {
            this.hNH.setForumName(this.hNp.bUv());
            if (this.hNp.getPbData() != null && this.hNp.getPbData().getForum() != null) {
                this.hNH.a(this.hNp.getPbData().getForum());
            }
            this.hNH.setFrom("pb");
            this.hNH.a(this.hNp);
        }
    }

    public String bUT() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bUU() {
        return this.hMT;
    }

    private void oq(boolean z) {
        this.hNI.fo(z);
        this.hNI.fp(z);
        this.hNI.fq(z);
    }

    private void bUV() {
        this.cer = new LikeModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTW() && !z && this.hNt != null && this.hNt.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.hNt.getView().setSystemUiVisibility(4);
        }
        this.hNM = z;
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
            Rect rect = new Rect();
            frameLayout.getWindowVisibleDisplayFrame(rect);
            ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
            childAt.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fwa != null) {
            this.fwa.onStart(getPageContext());
        }
    }

    public aq bUW() {
        return this.hNt;
    }

    public PbModel bUE() {
        return this.hNp;
    }

    public void Cn(String str) {
        if (this.hNp != null && !StringUtils.isNull(str) && this.hNt != null) {
            this.hNt.pf(true);
            this.hNp.Cn(str);
            this.hNf = true;
            this.hNt.bYL();
            this.hNt.bYU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hMV = false;
        } else {
            this.hMV = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hMX = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hMX == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.fwa != null) {
            this.fwa.onPause(getPageContext());
        }
        if (this.hNt != null) {
            this.hNt.onPause();
        }
        if (!this.hNp.bWE()) {
            this.hNI.qA(this.hNp.bWy());
        }
        if (this.hNp != null) {
            this.hNp.bWX();
        }
        com.baidu.tbadk.BdToken.c.Zk().Zp();
        MessageManager.getInstance().unRegisterListener(this.gCG);
        bzj();
        MessageManager.getInstance().unRegisterListener(this.hOq);
        MessageManager.getInstance().unRegisterListener(this.hOr);
        MessageManager.getInstance().unRegisterListener(this.hOs);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bUX() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hNp.getPbData(), this.hNp.bWz(), this.hNp.bWU());
        return (a2 == null || a2.aeC() == null || a2.aeC().getGodUserData() == null || a2.aeC().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hMV = false;
        super.onResume();
        if (this.hNi) {
            this.hNi = false;
            bVB();
        }
        if (bUX()) {
            this.hNc = System.currentTimeMillis();
        } else {
            this.hNc = -1L;
        }
        if (this.hNt != null && this.hNt.getView() != null) {
            if (!this.hqm) {
                bVs();
            } else {
                hideLoadingView(this.hNt.getView());
            }
            this.hNt.onResume();
        }
        if (this.hMX == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hNt != null) {
            noNetworkView = this.hNt.bXU();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kc()) {
            noNetworkView.er(false);
        }
        if (this.fwa != null) {
            this.fwa.onResume(getPageContext());
        }
        registerListener(this.gCG);
        this.hNC = false;
        bVA();
        registerListener(this.hOq);
        registerListener(this.hOr);
        registerListener(this.hOs);
        if (this.fwP) {
            bVr();
            this.fwP = false;
        }
        bVJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hNt.oU(z);
        if (this.hNz != null) {
            this.hNz.dismiss();
        }
        if (z && this.hNC) {
            this.hNt.bYu();
            this.hNp.oG(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hNc > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").bT("obj_duration", (System.currentTimeMillis() - this.hNc) + ""));
            this.hNc = 0L;
        }
        if (bUW().bXX() != null) {
            bUW().bXX().onStop();
        }
        if (this.hNt.hWn != null && !this.hNt.hWn.bbd()) {
            this.hNt.hWn.bKG();
        }
        if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().getForum() != null && this.hNp.getPbData().bTy() != null) {
            com.baidu.tbadk.distribute.a.arZ().a(getPageContext().getPageActivity(), "pb", this.hNp.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.e(this.hNp.getPbData().bTy().getId(), 0L));
        }
        if (this.fwa != null) {
            this.fwa.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.cpt().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.cpt().v(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bT("fid", this.hNp.getPbData().getForumId());
            anVar.bT("tid", this.hNp.bWy());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hNa && this.hNt != null) {
            this.hNa = true;
            this.hNt.bYQ();
            a(false, (PostData) null);
        }
        if (this.hNp != null) {
            this.hNp.cancelLoadData();
            this.hNp.destory();
            if (this.hNp.bXb() != null) {
                this.hNp.bXb().onDestroy();
            }
        }
        if (this.hNI != null) {
            this.hNI.onDestroy();
        }
        if (this.eFl != null) {
            this.eFl.cancelLoadData();
        }
        if (this.cer != null) {
            this.cer.cpO();
        }
        if (this.hNt != null) {
            this.hNt.onDestroy();
            if (this.hNt.hWn != null) {
                this.hNt.hWn.bKG();
            }
        }
        if (this.hNb != null) {
            this.hNb.avz();
        }
        if (this.hMT != null) {
            this.hMT.awJ();
        }
        super.onDestroy();
        if (this.fwa != null) {
            this.fwa.onDestory(getPageContext());
        }
        this.hNt.bYL();
        MessageManager.getInstance().unRegisterListener(this.hOq);
        MessageManager.getInstance().unRegisterListener(this.hOr);
        MessageManager.getInstance().unRegisterListener(this.hOs);
        MessageManager.getInstance().unRegisterListener(this.hNQ);
        MessageManager.getInstance().unRegisterListener(this.hOt);
        MessageManager.getInstance().unRegisterListener(this.fxC);
        MessageManager.getInstance().unRegisterListener(this.fNB);
        MessageManager.getInstance().unRegisterListener(this.hOv);
        this.hNO = null;
        this.hNP = null;
        com.baidu.tieba.recapp.d.a.cjz().cjB();
        if (this.hNR != null) {
            getSafeHandler().removeCallbacks(this.hNR);
        }
        if (this.hNj != null) {
            this.hNj.cancelLoadData();
        }
        if (this.hNt != null && this.hNt.hWn != null) {
            this.hNt.hWn.bZN();
        }
        if (this.fMq != null) {
            this.fMq.cancelLoadData();
        }
        this.hNy.onDestroy();
        if (this.hNp != null && this.hNp.bXd() != null) {
            this.hNp.bXd().onDestroy();
        }
        if (this.gYK != null) {
            this.gYK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bYp;
        ArrayList<PostData> bWa;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.amp() && this.hNt != null && (bYp = this.hNt.bYp()) != null && (bWa = bYp.bWa()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bWa.iterator();
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
                        bVar.eHh = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.bLe == 1 && !TextUtils.isEmpty(id)) {
                    next.bLe = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.eHh = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hNp == null || this.hNp.getPbData() == null || this.hNp.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hNp.getPbData().getForum().getFirst_class();
                    str2 = this.hNp.getPbData().getForum().getSecond_class();
                    str = this.hNp.getPbData().getForum().getId();
                    str4 = this.hNp.bWy();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.ams());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.hNt.onChangeSkinType(i);
            if (this.hNI != null && this.hNI.asm() != null) {
                this.hNI.asm().onChangeSkinType(i);
            }
            if (this.hNt.bXU() != null) {
                this.hNt.bXU().onChangeSkinType(getPageContext(), i);
            }
            this.hNy.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.a(i, getResources(), (int) R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hNt = new aq(this, this.fyk, this.cmw);
        this.ebS = new com.baidu.tieba.f.b(getActivity());
        this.ebS.a(hOG);
        this.ebS.a(this.ebT);
        this.hNt.setOnScrollListener(this.mOnScrollListener);
        this.hNt.e(this.fQE);
        this.hNt.setListPullRefreshListener(this.daZ);
        this.hNt.ok(com.baidu.tbadk.core.i.ace().aci());
        this.hNt.setOnImageClickListener(this.cLe);
        this.hNt.b(this.cnB);
        this.hNt.h(this.ftG);
        this.hNt.a(this.hOz);
        this.hNt.oU(this.mIsLogin);
        if (getIntent() != null) {
            this.hNt.pg(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hNt.bXW().setFromForumId(this.hNp.getFromForumId());
    }

    public void bUY() {
        if (this.hNt != null && this.hNp != null) {
            if ((this.hNp.getPbData() != null || this.hNp.getPbData().bTV() != null) && checkUpIsLogin() && this.hNt.bYp() != null && this.hNt.bYp().bWf() != null) {
                this.hNt.bYp().bWf().pa(this.hNp.bWy());
            }
        }
    }

    public void bUZ() {
        TiebaStatic.log("c12181");
        if (this.hNt != null && this.hNp != null) {
            if (this.hNt == null || this.hNt.bXZ()) {
                if (this.hNp.getPbData() != null || this.hNp.getPbData().bTV() != null) {
                    com.baidu.tieba.pb.data.j bTV = this.hNp.getPbData().bTV();
                    if (checkUpIsLogin()) {
                        if ((!bTV.bUe() || bTV.afY() != 2) && this.hNt.bYp() != null && this.hNt.bYp().bWf() != null) {
                            this.hNt.bYp().bWf().pa(this.hNp.bWy());
                        }
                        if (System.currentTimeMillis() - this.hNe > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).pA(false);
                            this.hNe = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cw(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.jiB && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.ace().aci()) {
                    return Cq(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hNp == null || this.hNp.getPbData() == null) {
                        return true;
                    }
                    if (bUW().bXX() != null) {
                        bUW().bXX().bWl();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.hNp.getPbData().getForum());
                    kVar.ak(this.hNp.getPbData().bTy());
                    kVar.e(postData);
                    bUW().bXW().d(kVar);
                    bUW().bXW().setPostId(postData.getId());
                    a(view, postData.aeC().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hNI != null) {
                        this.hNt.pa(this.hNI.asT());
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
        if (this.hNt != null) {
            if (z && !this.hqm) {
                bVs();
            } else {
                hideLoadingView(this.hNt.getView());
            }
            if (z && this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTW() && this.hNt.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                this.hNt.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bVa() {
        if (this.hMY == null) {
            this.hMY = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hMY.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hMN = PbActivity.this.hMN.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hMN);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hNp.bWy(), PbActivity.this.hMN, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hMN = PbActivity.this.hMN.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hMN);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hNp.bWy(), PbActivity.this.hMN, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hMN = PbActivity.this.hMN.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hMN);
                        bVar.dismiss();
                    }
                }
            }).hA(R.style.dialog_ani_b2t).hB(17).d(getPageContext());
        }
    }

    private void aa(Bundle bundle) {
        this.hNp = new PbModel(this);
        this.hNp.a(this.hOw);
        if (this.hNp.bXa() != null) {
            this.hNp.bXa().a(this.hOI);
        }
        if (this.hNp.bWZ() != null) {
            this.hNp.bWZ().a(this.hOg);
        }
        if (this.hNp.bXb() != null) {
            this.hNp.bXb().b(this.hOa);
        }
        if (bundle != null) {
            this.hNp.initWithBundle(bundle);
        } else {
            this.hNp.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hNp.oJ(true);
        }
        aj.bXI().au(this.hNp.bWw(), this.hNp.getIsFromMark());
        if (StringUtils.isNull(this.hNp.bWy())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hNg) && this.hNg != null) {
            this.hNp.yf(6);
        }
        this.hNp.auR();
    }

    private void initData(Bundle bundle) {
        this.hNr = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hNr != null) {
            this.hNr.a(this.hOy);
        }
        this.eFl = new ForumManageModel(this);
        this.eFl.setLoadDataCallBack(this.eFp);
        this.bTT = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hNt.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kc()) {
                    PbActivity.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hNp.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hNp.getPbData().getForum().getId(), PbActivity.this.hNp.getPbData().getForum().getName(), PbActivity.this.hNp.getPbData().bTy().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hOm.setUniqueId(getUniqueId());
        this.hOm.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hNt.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.e(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.e((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hNQ;
        userMuteCheckCustomMessage.setTag(this.hNQ);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bVb() {
        if (checkUpIsLogin()) {
            if (this.fzF == null) {
                this.fzF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fzF.sG(0);
                this.fzF.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ki(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void n(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void kj(boolean z) {
                        if (z) {
                            PbActivity.this.hNt.byv();
                        }
                    }
                });
            }
            if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().getForum() != null) {
                this.fzF.v(this.hNp.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.e(this.hNp.bWy(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bVc() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hNp != null && (pbData = this.hNp.getPbData()) != null) {
            return pbData.bTJ().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bTy() != null) {
            if (dVar.bTy().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bTy().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bTy().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bVd()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hNl);
                this.hNm = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hNK == null) {
                this.hNK = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hNK.sG(1);
                this.hNK.a(new AnonymousClass40(str, str2));
            }
            if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().getForum() != null) {
                this.hNK.v(this.hNp.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.e(this.hNp.bWy(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$40  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String hOX;
        final /* synthetic */ String hOY;

        AnonymousClass40(String str, String str2) {
            this.hOX = str;
            this.hOY = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ki(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kj(boolean z) {
            if (z) {
                PbActivity.this.getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int g;
                        int ah = com.baidu.adp.lib.util.l.ah(PbActivity.this.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            g = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.g(PbActivity.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            g = (ah / 2) + com.baidu.adp.lib.util.l.g(PbActivity.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbActivity.this.bUW().getListView().smoothScrollBy((PbActivity.this.hNl[1] + PbActivity.this.hNm) - (ah - g), 50);
                        if (PbActivity.this.bUW().bXX() != null) {
                            PbActivity.this.hNI.asm().setVisibility(8);
                            PbActivity.this.bUW().bXX().aa(AnonymousClass40.this.hOX, AnonymousClass40.this.hOY, PbActivity.this.bUW().bYa());
                            com.baidu.tbadk.editortools.pb.g bWp = PbActivity.this.bUW().bXX().bWp();
                            if (bWp != null && PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                                bWp.a(PbActivity.this.hNp.getPbData().getAnti());
                            }
                            if (PbActivity.this.hNy.bZn() == null && PbActivity.this.bUW().bXX().bWp().atn() != null) {
                                PbActivity.this.bUW().bXX().bWp().atn().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hNy != null && PbActivity.this.hNy.bZm() != null) {
                                            if (!PbActivity.this.hNy.bZm().cAq()) {
                                                PbActivity.this.hNy.pi(false);
                                            }
                                            PbActivity.this.hNy.bZm().se(false);
                                        }
                                    }
                                });
                                PbActivity.this.hNy.l(PbActivity.this.bUW().bXX().bWp().atn().getInputView());
                                PbActivity.this.bUW().bXX().bWp().a(PbActivity.this.hNN);
                            }
                        }
                        PbActivity.this.bUW().bYU();
                    }
                }, 0L);
            }
        }
    }

    public boolean bVd() {
        if (this.gYK == null || this.hNp.getPbData() == null || this.hNp.getPbData().getAnti() == null) {
            return true;
        }
        return this.gYK.m19if(this.hNp.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean xO(int i) {
        if (this.gYK == null || this.hNp.getPbData() == null || this.hNp.getPbData().getAnti() == null) {
            return true;
        }
        return this.gYK.U(this.hNp.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.hNp != null && this.hNp.getPbData() != null && postData.cqz() != 1) {
            String bWy = this.hNp.bWy();
            String id = postData.getId();
            int bTK = this.hNp.getPbData() != null ? this.hNp.getPbData().bTK() : 0;
            c Cr = Cr(id);
            if (Cr != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bWy, id, "pb", true, null, false, null, bTK, postData.caC(), this.hNp.getPbData().getAnti(), false, postData.aeC() != null ? postData.aeC().getIconInfo() : null).addBigImageData(Cr.hPo, Cr.hPp, Cr.hPq, Cr.index);
                addBigImageData.setKeyPageStartFrom(this.hNp.bXh());
                addBigImageData.setFromFrsForumId(this.hNp.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVe() {
        if (this.hNp.getPbData() == null || this.hNp.getPbData().bTy() == null) {
            return -1;
        }
        return this.hNp.getPbData().bTy().afm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVf() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.EG(this.hNp.getForumId()) && this.hNp.getPbData() != null && this.hNp.getPbData().getForum() != null) {
            if (this.hNp.getPbData().getForum().isLike() == 1) {
                this.hNp.bXd().ef(this.hNp.getForumId(), this.hNp.bWy());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean or(boolean z) {
        if (this.hNp == null || this.hNp.getPbData() == null) {
            return false;
        }
        return ((this.hNp.getPbData().bTK() != 0) || this.hNp.getPbData().bTy() == null || this.hNp.getPbData().bTy().aeC() == null || TextUtils.equals(this.hNp.getPbData().bTy().aeC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bVg() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.t.y.awf()) {
            return "";
        }
        PostData bTF = bTF();
        if (this.hNp == null || (pbData = this.hNp.getPbData()) == null || pbData.getUserData() == null || pbData.bTy() == null || bTF == null || bTF.aeC() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bTF.aeC().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bTy().aej() == 0) {
            return "";
        }
        if (pbData.bTy().aej() == 0) {
            return getPageContext().getString(R.string.fans_call);
        }
        return getPageContext().getString(R.string.haved_fans_call);
    }

    private boolean os(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.v vVar;
        if (z) {
            return true;
        }
        if (this.hNp == null || this.hNp.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hNp.getPbData();
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.bTK() != 0) {
                return pbData.bTK() != 3;
            }
            List<bd> bTT = pbData.bTT();
            if (com.baidu.tbadk.core.util.v.Z(bTT) > 0) {
                for (bd bdVar : bTT) {
                    if (bdVar != null && (vVar = bdVar.bJu) != null && vVar.bHj && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            return z2;
        }
        return false;
    }

    private boolean ot(boolean z) {
        if (z || this.hNp == null || this.hNp.getPbData() == null) {
            return false;
        }
        return ((this.hNp.getPbData().getForum() != null && this.hNp.getPbData().getForum().isBlockBawuDelete) || this.hNp.getPbData().bTK() == 0 || this.hNp.getPbData().bTK() == 3) ? false : true;
    }

    public void bVh() {
        if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTy() != null && this.hNp.getPbData().bTy().aeC() != null) {
            if (this.hNt != null) {
                this.hNt.bXV();
            }
            bh bTy = this.hNp.getPbData().bTy();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bTy.aeC().getUserId());
            ab abVar = new ab();
            int bTK = this.hNp.getPbData().bTK();
            if (bTK == 1 || bTK == 3) {
                abVar.hUx = true;
                abVar.hUw = true;
                abVar.hUE = bTy.aex() == 1;
                abVar.hUD = bTy.aey() == 1;
            } else {
                abVar.hUx = false;
                abVar.hUw = false;
            }
            if (bTK == 1002 && !equals) {
                abVar.hUI = true;
            }
            abVar.hUy = os(equals);
            abVar.hUz = bVi();
            abVar.hUA = ot(equals);
            abVar.oy = this.hNp.bWz();
            abVar.hUv = true;
            abVar.hUu = or(equals);
            abVar.hUG = bVg();
            abVar.hUt = equals && this.hNt.bYB();
            abVar.hUB = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hUC = true;
            abVar.isHostOnly = this.hNp.getHostMode();
            abVar.hUF = true;
            if (bTy.aeT() == null) {
                abVar.hUH = true;
            } else {
                abVar.hUH = false;
            }
            this.hNt.hWn.a(abVar);
        }
    }

    private boolean bVi() {
        if (this.hNp != null && this.hNp.bWz()) {
            return this.hNp.getPageData() == null || this.hNp.getPageData().adx() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            f(postData);
        }
    }

    public int bVj() {
        if (bUW() == null || bUW().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bUW().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.i) && ((com.baidu.tieba.pb.data.i) mVar).mType == com.baidu.tieba.pb.data.i.hLc) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVk() {
        if (bUW() == null || bUW().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bUW().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.jiA) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bVr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.mP(getResources().getString(R.string.mark_done));
            aVar.dX(true);
            aVar.mQ(getResources().getString(R.string.mark_like));
            aVar.dW(true);
            aVar.dQ(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).P("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).P("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.bTT.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hNp.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).agO();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hNt.bYv();
        this.hNp.oI(z);
        if (this.hNr != null) {
            this.hNr.dx(z);
            if (markData != null) {
                this.hNr.a(markData);
            }
        }
        if (this.hNp.aaF()) {
            bVp();
        } else {
            this.hNt.m(this.hNp.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xM(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Co(String str) {
        this.hNq.CM(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hNp.bWE()) {
                    antiData.setBlock_forum_name(this.hNp.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hNp.getPbData().getForum().getId());
                    antiData.setUser_name(this.hNp.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hNp.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bUW() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").P("obj_locate", at.a.bUL));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").P("obj_locate", at.a.bUL));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").P("obj_locate", at.a.bUL));
            }
        } else if (i == 230277) {
            qG(str);
        } else {
            this.hNt.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.jlh) ? bVar.jlh : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mQ(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.dQ(true);
                aVar.b(getPageContext());
                aVar.agO();
            } else {
                this.hNt.a(0, bVar.FU, bVar.jlh, z);
            }
            if (bVar.FU) {
                if (bVar.fco == 1) {
                    ArrayList<PostData> bTA = this.hNp.getPbData().bTA();
                    int size = bTA.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bTA.get(i).getId())) {
                            i++;
                        } else {
                            bTA.remove(i);
                            break;
                        }
                    }
                    this.hNp.getPbData().bTy().hj(this.hNp.getPbData().bTy().aet() - 1);
                    this.hNt.m(this.hNp.getPbData());
                } else if (bVar.fco == 0) {
                    bVl();
                } else if (bVar.fco == 2) {
                    ArrayList<PostData> bTA2 = this.hNp.getPbData().bTA();
                    int size2 = bTA2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bTA2.get(i2).cqw().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bTA2.get(i2).cqw().get(i3).getId())) {
                                i3++;
                            } else {
                                bTA2.get(i2).cqw().remove(i3);
                                bTA2.get(i2).cqy();
                                z2 = true;
                                break;
                            }
                        }
                        bTA2.get(i2).Fk(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hNt.m(this.hNp.getPbData());
                    }
                    a(bVar, this.hNt);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hNt.a(this.eFl.getLoadDataMode(), gVar.FU, gVar.jlh, false);
            if (gVar.FU) {
                this.hNv = true;
                if (i == 2 || i == 3) {
                    this.hNw = true;
                    this.hNx = false;
                } else if (i == 4 || i == 5) {
                    this.hNw = false;
                    this.hNx = true;
                }
                if (i == 2) {
                    this.hNp.getPbData().bTy().hm(1);
                    this.hNp.setIsGood(1);
                } else if (i == 3) {
                    this.hNp.getPbData().bTy().hm(0);
                    this.hNp.setIsGood(0);
                } else if (i == 4) {
                    this.hNp.getPbData().bTy().hl(1);
                    this.hNp.pZ(1);
                } else if (i == 5) {
                    this.hNp.getPbData().bTy().hl(0);
                    this.hNp.pZ(0);
                }
                this.hNt.d(this.hNp.getPbData(), this.hNp.bWz());
            }
        }
    }

    private void bVl() {
        if (this.hNp.bWA() || this.hNp.bWC()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hNp.bWy());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hNp.bWy()));
        if (bVq()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bTH;
        boolean z = false;
        if (this.hNt != null) {
            this.hNt.bYL();
        }
        if (this.hNp != null && this.hNp.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hNp.getPbData().bTy().getId();
            if (this.hNp.isShareThread() && this.hNp.getPbData().bTy().bMt != null) {
                historyMessage.threadName = this.hNp.getPbData().bTy().bMt.showText;
            } else {
                historyMessage.threadName = this.hNp.getPbData().bTy().getTitle();
            }
            if (this.hNp.isShareThread() && !bUu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hNp.getPbData().getForum().getName();
            }
            ArrayList<PostData> bTA = this.hNp.getPbData().bTA();
            int bYx = this.hNt != null ? this.hNt.bYx() : 0;
            if (bTA != null && bYx >= 0 && bYx < bTA.size()) {
                historyMessage.postID = bTA.get(bYx).getId();
            }
            historyMessage.isHostOnly = this.hNp.getHostMode();
            historyMessage.isSquence = this.hNp.bWz();
            historyMessage.isShareThread = this.hNp.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hNI != null) {
            this.hNI.onDestroy();
        }
        if (this.hMW && bUW() != null) {
            bUW().bZe();
        }
        if (this.hNp != null && (this.hNp.bWA() || this.hNp.bWC())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hNp.bWy());
            if (this.hNv) {
                if (this.hNx) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hNp.bfV());
                }
                if (this.hNw) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hNp.getIsGood());
                }
            }
            if (this.hNp.getPbData() != null && System.currentTimeMillis() - this.hMZ >= 40000 && (bTH = this.hNp.getPbData().bTH()) != null && !com.baidu.tbadk.core.util.v.aa(bTH.getDataList())) {
                intent.putExtra("guess_like_data", bTH);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hNW);
            }
            setResult(-1, intent);
        }
        if (bVq()) {
            if (this.hNp != null && this.hNt != null && this.hNt.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hNp.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bTE() && !this.hNf && pbData.hKJ == null) {
                        aj bXI = aj.bXI();
                        com.baidu.tieba.pb.data.d bWG = this.hNp.bWG();
                        Parcelable onSaveInstanceState = this.hNt.getListView().onSaveInstanceState();
                        boolean bWz = this.hNp.bWz();
                        boolean hostMode = this.hNp.getHostMode();
                        if (this.hNt.bYg() != null && this.hNt.bYg().getVisibility() == 0) {
                            z = true;
                        }
                        bXI.a(bWG, onSaveInstanceState, bWz, hostMode, z);
                        if (this.hNV >= 0 || this.hNp.bXj() != null) {
                            aj.bXI().l(this.hNp.bXj());
                            aj.bXI().k(this.hNp.bXk());
                            aj.bXI().yh(this.hNp.bXl());
                        }
                    }
                }
            } else {
                aj.bXI().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hNt == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hNt.ym(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xP(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.hNt.bXV();
            this.hNt.bXX().bWl();
            this.hNt.pc(false);
        }
        this.hNt.bXY();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.hNI.resetData();
                        this.hNI.b(writeData);
                        this.hNI.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k kt = this.hNI.asm().kt(6);
                        if (kt != null && kt.csV != null) {
                            kt.csV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hNI.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hNt.bXX() != null && this.hNt.bXX().bWp() != null) {
                            com.baidu.tbadk.editortools.pb.g bWp = this.hNt.bXX().bWp();
                            bWp.b(writeData);
                            bWp.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k kt2 = bWp.asm().kt(6);
                            if (kt2 != null && kt2.csV != null) {
                                kt2.csV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bWp.atf();
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
        this.hNI.onActivityResult(i, i2, intent);
        if (this.hNj != null) {
            this.hNj.onActivityResult(i, i2, intent);
        }
        if (bUW().bXX() != null) {
            bUW().bXX().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    bVo();
                    return;
                case 13008:
                    aj.bXI().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hNp != null) {
                                PbActivity.this.hNp.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.cir().y(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hNp != null) {
                        a(bVn(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    ai(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.cir().y(getPageContext());
                        bVf();
                        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.fMq != null && shareItem != null && shareItem.linkUrl != null) {
                            this.fMq.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void apb() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59.1
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
                    this.hNt.op(false);
                    if (this.hNp.getPbData() != null && this.hNp.getPbData().bTy() != null && this.hNp.getPbData().bTy().aeW() != null) {
                        this.hNp.getPbData().bTy().aeW().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hNL = emotionImageData;
                        if (xO(com.baidu.tbadk.core.util.aj.bTQ)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hNt != null && this.hNt.hWn != null) {
                        this.hNt.hWn.UQ();
                        this.hNt.hWn.bZG();
                        if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTy() != null) {
                            this.hNp.getPbData().bTy().hg(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hNk != null) {
                        this.hNt.cF(this.hNk);
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
            if (this.hNj == null) {
                this.hNj = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hNj.b(this.cuO);
                this.hNj.c(this.cuV);
            }
            this.hNj.a(emotionImageData, bUE(), bUE().getPbData());
        }
    }

    private ShareFromPBMsgData bVn() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ed = this.hNp.getPbData().ed(getPageContext().getPageActivity());
        PostData bYb = this.hNt.bYb();
        String str = "";
        if (bYb != null) {
            str = bYb.getId();
            String eo = bYb.eo(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(eo)) {
                ed[1] = eo;
            }
        }
        String aeS = this.hNp.getPbData().bTy().aeS();
        if (aeS != null && aeS.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ed[1]);
        shareFromPBMsgData.setImageUrl(ed[0]);
        shareFromPBMsgData.setForumName(this.hNp.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hNp.getPbData().bTy().getId());
        shareFromPBMsgData.setTitle(this.hNp.getPbData().bTy().getTitle());
        return shareFromPBMsgData;
    }

    private void ai(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bVn(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTy() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hy(1);
            aVar.aH(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null) {
                        com.baidu.tbadk.core.util.an bT = new com.baidu.tbadk.core.util.an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).P("obj_param1", 3).bT("fid", PbActivity.this.hNp.getForumId()).bT("tid", PbActivity.this.hNp.bWy());
                        if (PbActivity.this.d(PbActivity.this.hNp.getPbData()) != 0) {
                            bT.P("obj_type", PbActivity.this.d(PbActivity.this.hNp.getPbData()));
                        }
                        TiebaStatic.log(bT);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.dR(true);
            aVar.b(getPageContext()).agO();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), this.hNp.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTy() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hy(1);
            aVar.aH(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.dR(true);
            aVar.b(getPageContext()).agO();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), this.hNp.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVo() {
        MarkData ye;
        if (this.hNr != null && (ye = this.hNp.ye(this.hNt.bYy())) != null) {
            if (!ye.isApp() || (ye = this.hNp.ye(this.hNt.bYy() + 1)) != null) {
                this.hNt.bYt();
                this.hNr.a(ye);
                if (!this.hNr.aaF()) {
                    this.hNr.aaH();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hNr.aaG();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVp() {
        com.baidu.tieba.pb.data.d pbData = this.hNp.getPbData();
        this.hNp.oI(true);
        if (this.hNr != null) {
            pbData.Cj(this.hNr.aaE());
        }
        this.hNt.m(pbData);
    }

    private boolean bVq() {
        if (this.hNp == null) {
            return true;
        }
        if (this.hNp.aaF()) {
            final MarkData bWQ = this.hNp.bWQ();
            if (bWQ == null || !this.hNp.getIsFromMark()) {
                return true;
            }
            final MarkData ye = this.hNp.ye(this.hNt.bYx());
            if (ye == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bWQ);
                setResult(-1, intent);
                return true;
            } else if (ye.getPostId() == null || ye.getPostId().equals(bWQ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bWQ);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mQ(getPageContext().getString(R.string.alert_update_mark));
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hNr != null) {
                            if (PbActivity.this.hNr.aaF()) {
                                PbActivity.this.hNr.aaG();
                                PbActivity.this.hNr.dx(false);
                            }
                            PbActivity.this.hNr.a(ye);
                            PbActivity.this.hNr.dx(true);
                            PbActivity.this.hNr.aaH();
                        }
                        bWQ.setPostId(ye.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bWQ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bVm();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bWQ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bVm();
                    }
                });
                aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hNt != null && PbActivity.this.hNt.getView() != null) {
                            PbActivity.this.hNt.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bWQ);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bVm();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.agO();
                return false;
            }
        } else if (this.hNp.getPbData() == null || this.hNp.getPbData().bTA() == null || this.hNp.getPbData().bTA().size() <= 0 || !this.hNp.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hNt == null) {
            return null;
        }
        return this.hNt.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azG() {
        if (this.hNt == null) {
            return 0;
        }
        return this.hNt.bYJ();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azH() {
        if (this.cKV == null) {
            this.cKV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean aci = com.baidu.tbadk.core.i.ace().aci();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
                    if (aci) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.ace().aci()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.cKV;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azI() {
        if (this.cNK == null) {
            this.cNK = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cNK;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azJ() {
        if (this.cKW == null) {
            this.cKW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVM */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbActivity.this.getPageContext().getPageActivity());
                    boolean aci = com.baidu.tbadk.core.i.ace().aci();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
                    if (aci) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.setBackgroundDrawable(null);
                    gifView.setImageDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (com.baidu.tbadk.core.i.ace().aci()) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.atH();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cKW;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azK() {
        if (this.cNL == null) {
            this.cNL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVN */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cz */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cA */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).crJ();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cB */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.cNL;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azM() {
        this.cNN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bVO */
            public RelativeLayout makeObject() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.cNN;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> als() {
        if (this.cdT == null) {
            this.cdT = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.cdT;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hNd = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (av.CE(str) && this.hNp != null && this.hNp.bWy() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").P("obj_param1", 1).bT("post_id", this.hNp.bWy()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.crU = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
            }
        } else {
            av.bZp().c(getPageContext(), str);
        }
        this.hNd = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        av.bZp().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hNd = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Rect rect) {
        if (rect != null && this.hNt != null && this.hNt.bYZ() != null && rect.top <= this.hNt.bYZ().getHeight()) {
            rect.top += this.hNt.bYZ().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hNp.getPbData();
            TbRichText bg = bg(str, i);
            if (bg != null && (tbRichTextData = bg.ayZ().get(this.hOB)) != null) {
                cVar.hPo = new ArrayList<>();
                cVar.hPp = new ConcurrentHashMap<>();
                if (!tbRichTextData.azg().azs()) {
                    cVar.hPr = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hPo.add(b2);
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
                    imageUrlData.postId = bg.getPostId();
                    imageUrlData.mIsReserver = this.hNp.bWO();
                    imageUrlData.mIsSeeHost = this.hNp.getHostMode();
                    cVar.hPp.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bTy() != null) {
                            cVar.threadId = pbData.bTy().getId();
                        }
                        cVar.hPq = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.e(cVar.threadId, -1L);
                    return;
                }
                cVar.hPr = true;
                int size = pbData.bTA().size();
                this.hOC = false;
                cVar.index = -1;
                if (pbData.bTF() != null) {
                    PostData bTF = pbData.bTF();
                    TbRichText cqB = bTF.cqB();
                    if (!ap.m(bTF)) {
                        i2 = a(cqB, bg, i, i, cVar.hPo, cVar.hPp);
                    } else {
                        i2 = a(bTF, i, cVar.hPo, cVar.hPp);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bTA().get(i4);
                    if (postData.getId() == null || pbData.bTF() == null || pbData.bTF().getId() == null || !postData.getId().equals(pbData.bTF().getId())) {
                        TbRichText cqB2 = postData.cqB();
                        if (!ap.m(postData)) {
                            i3 = a(cqB2, bg, i3, i, cVar.hPo, cVar.hPp);
                        } else {
                            i3 = a(postData, i3, cVar.hPo, cVar.hPp);
                        }
                    }
                }
                if (cVar.hPo.size() > 0) {
                    cVar.lastId = cVar.hPo.get(cVar.hPo.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bTy() != null) {
                        cVar.threadId = pbData.bTy().getId();
                    }
                    cVar.hPq = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azg() == null) {
            return null;
        }
        return tbRichTextData.azg().azx();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azg() == null) {
            return 0L;
        }
        return tbRichTextData.azg().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azg() == null) {
            return false;
        }
        return tbRichTextData.azg().azy();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azg() == null) {
            return false;
        }
        return tbRichTextData.azg().azz();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo azg;
        String str;
        if (tbRichText == tbRichText2) {
            this.hOC = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.ayZ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.ayZ().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.azg().getWidth() * ai;
                    int height = ai * tbRichTextData.azg().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.azg().azs()) {
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
                            if (tbRichTextData != null && (azg = tbRichTextData.azg()) != null) {
                                String azu = azg.azu();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = azg.azv();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = azu;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.e(this.hNp.bWy(), -1L);
                                imageUrlData.mIsReserver = this.hNp.bWO();
                                imageUrlData.mIsSeeHost = this.hNp.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hOC) {
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
        com.baidu.tieba.tbadkCore.data.i cqI;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cqe;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cqe = (cqI = postData.cqI()).cqe()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cqe.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cqe.get(i3);
                if (kVar != null) {
                    String cqi = kVar.cqi();
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(cqi)) {
                        arrayList.add(cqi);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cqi;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cqh();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.e(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.e(this.hNp.bWy(), -1L);
                        imageUrlData.mIsReserver = this.hNp.bWO();
                        imageUrlData.mIsSeeHost = this.hNp.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cqI.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cqi, imageUrlData);
                        }
                        if (!this.hOC) {
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
            if (postData.getId() != null && postData.getId().equals(this.hNp.aeL())) {
                z = true;
            }
            MarkData j = this.hNp.j(postData);
            if (j != null) {
                this.hNt.bYt();
                if (this.hNr != null) {
                    this.hNr.a(j);
                    if (!z) {
                        this.hNr.aaH();
                    } else {
                        this.hNr.aaG();
                    }
                }
            }
        }
    }

    public boolean cy(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bg(String str, int i) {
        TbRichText tbRichText = null;
        if (this.hNp == null || this.hNp.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hNp.getPbData();
        if (pbData.bTF() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bTF());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bTA = pbData.bTA();
            a(pbData, bTA);
            return a(bTA, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bTJ() != null && dVar.bTJ().hLr != null && (list = dVar.bTJ().hLr) != null && arrayList != null) {
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

    private long Cp(String str) {
        ArrayList<PostData> bTA;
        com.baidu.tieba.pb.data.d pbData = this.hNp.getPbData();
        if (pbData != null && (bTA = pbData.bTA()) != null && !bTA.isEmpty()) {
            Iterator<PostData> it = bTA.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cqI = next.cqI();
                if (cqI != null && cqI.jih) {
                    Iterator<TbRichTextData> it2 = next.cqB().ayZ().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.azp().getLink().equals(str)) {
                            return cqI.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> ayZ;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cqB = arrayList.get(i2).cqB();
            if (cqB != null && (ayZ = cqB.ayZ()) != null) {
                int size = ayZ.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (ayZ.get(i4) != null && ayZ.get(i4).getType() == 8) {
                        i3++;
                        if (ayZ.get(i4).azg().azu().equals(str) || ayZ.get(i4).azg().azv().equals(str)) {
                            int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                            int width = ayZ.get(i4).azg().getWidth() * ai;
                            int height = ayZ.get(i4).azg().getHeight() * ai;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hOB = i4;
                            return cqB;
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
    public void n(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.hMN = str;
            if (this.hMY == null) {
                bVa();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hMY.hD(1).setVisibility(8);
            } else {
                this.hMY.hD(1).setVisibility(0);
            }
            this.hMY.agR();
            this.hNd = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fwa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVr() {
        hideNetRefreshView(this.hNt.getView());
        bVs();
        if (this.hNp.auR()) {
            this.hNt.bYt();
        }
    }

    private void bVs() {
        showLoadingView(this.hNt.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View atX = getLoadingView().atX();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) atX.getLayoutParams();
        layoutParams.addRule(3, this.hNt.bYZ().getId());
        atX.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bne() {
        if (this.fwa != null) {
            this.fwa.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xQ(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004020, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void xR(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        bh bTy;
        if (this.hNp.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hNp.getPbData();
            pbData.getForum().getName();
            String title = pbData.bTy().getTitle();
            int i2 = this.hNp.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.EG(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hNp.bWy() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] ed = pbData.ed(getPageContext().getPageActivity());
                    str = ed[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = ed[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bVe() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").bT("fid", pbData.getForumId()).bT("tid", pbData.getThreadId()).bT("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                    eVar.title = title;
                    eVar.content = str2;
                    eVar.linkUrl = str3;
                    eVar.clu = true;
                    eVar.clB = z;
                    eVar.extData = this.hNp.bWy();
                    eVar.clN = 3;
                    eVar.clM = i;
                    eVar.fid = this.hNp.getForumId();
                    eVar.tid = this.hNp.bWy();
                    eVar.clR = d(pbData);
                    eVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        eVar.imageUri = parse;
                    }
                    bTy = this.hNp.getPbData().bTy();
                    eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bTy);
                    TbadkCoreApplication.getInst().setShareItem(eVar);
                    if (bTy != null) {
                        eVar.cmb = bTy.getShareImageUrl();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", eVar.clN);
                    bundle.putInt("obj_type", eVar.clR);
                    bundle.putString("fid", eVar.fid);
                    bundle.putString("tid", eVar.tid);
                    bundle.putString("uid", eVar.uid);
                    eVar.E(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTW() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                                PbActivity.this.hNt.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.bch().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hNp.bWy() + "?share=9105&fr=share&see_lz=" + i2;
            String[] ed2 = pbData.ed(getPageContext().getPageActivity());
            str = ed2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = ed2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bVe() == 1) {
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = str2;
            eVar2.linkUrl = str32;
            eVar2.clu = true;
            eVar2.clB = z;
            eVar2.extData = this.hNp.bWy();
            eVar2.clN = 3;
            eVar2.clM = i;
            eVar2.fid = this.hNp.getForumId();
            eVar2.tid = this.hNp.bWy();
            eVar2.clR = d(pbData);
            eVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            bTy = this.hNp.getPbData().bTy();
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bTy);
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            if (bTy != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.clN);
            bundle2.putInt("obj_type", eVar2.clR);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putString("uid", eVar2.uid);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hNp != null && PbActivity.this.hNp.getPbData() != null && PbActivity.this.hNp.getPbData().bTW() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                        PbActivity.this.hNt.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.bch().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bTy() != null) {
            if (dVar.bTy().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bTy().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVt() {
        com.baidu.tbadk.util.z.a(new com.baidu.tbadk.util.y<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.y
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.EH(PbActivity.this.hNp.getForumId()));
            }
        }, new com.baidu.tbadk.util.j<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hNt.bZf();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azL() {
        if (this.cNM == null) {
            this.cNM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVP */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
                    linearLayout.setId(R.id.pb_text_voice_layout);
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
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.cNM;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void bnf() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData blT() {
        if (this.hNp == null || this.hNp.getPbData() == null) {
            return null;
        }
        return this.hNp.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.agQ() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.agQ();
            int intValue = ((Integer) sparseArray.get(aq.hYg)).intValue();
            if (intValue == aq.hYh) {
                if (!this.eFl.crl()) {
                    this.hNt.bYq();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eFl.Fq(com.baidu.tbadk.core.util.aq.y(jSONArray));
                    }
                    this.eFl.a(this.hNp.getPbData().getForum().getId(), this.hNp.getPbData().getForum().getName(), this.hNp.getPbData().bTy().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hYi || intValue == aq.hYk) {
                if (this.hNp.bXa() != null) {
                    this.hNp.bXa().xU(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hYi) {
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
        if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
        }
        if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hNQ);
        userMuteAddAndDelCustomMessage.setTag(this.hNQ);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Cq(String str) {
        if (!StringUtils.isNull(str) && bc.cF(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void ou(boolean z) {
        this.hNC = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bVu() {
        ArrayList<PostData> bTA;
        int Z;
        if (this.hNp == null || this.hNp.getPbData() == null || this.hNp.getPbData().bTA() == null || (Z = com.baidu.tbadk.core.util.v.Z((bTA = this.hNp.getPbData().bTA()))) == 0) {
            return "";
        }
        if (this.hNp.bWO()) {
            Iterator<PostData> it = bTA.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cqz() == 1) {
                    return next.getId();
                }
            }
        }
        int bYx = this.hNt.bYx();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bTA, bYx);
        if (postData == null || postData.aeC() == null) {
            return "";
        }
        if (this.hNp.Cu(postData.aeC().getUserId())) {
            return postData.getId();
        }
        for (int i = bYx - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bTA, i);
            if (postData2 == null || postData2.aeC() == null || postData2.aeC().getUserId() == null) {
                break;
            } else if (this.hNp.Cu(postData2.aeC().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bYx + 1; i2 < Z; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bTA, i2);
            if (postData3 == null || postData3.aeC() == null || postData3.aeC().getUserId() == null) {
                return "";
            }
            if (this.hNp.Cu(postData3.aeC().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.ajK().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(Cp(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hNp.getPbData().getForum().getId(), this.hNp.getPbData().getForum().getName(), this.hNp.getPbData().bTy().getTid());
            }
            this.hNd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.mQ(getResources().getString(R.string.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.mQ(getResources().getString(R.string.make_sure_hide));
        }
        aVar.a(getResources().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hNp.bWZ() != null) {
                    PbActivity.this.hNp.bWZ().eo(j);
                }
            }
        });
        aVar.b(getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.dR(false);
        aVar.b(getPageContext());
        aVar.agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Cr(String str) {
        String str2;
        if (this.hNp.getPbData() == null || this.hNp.getPbData().bTA() == null || this.hNp.getPbData().bTA().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hNp.getPbData().bTA().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hNp.getPbData().bTA().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hNp.getPbData().bTA().get(i);
        if (postData.cqB() == null || postData.cqB().ayZ() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cqB().ayZ().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.azg() != null) {
                    str2 = next.azg().azu();
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
        if (this.hMU) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hMU = false;
        } else if (bVv()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hMU) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hMU = false;
        } else if (bVv()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.hNp != null) {
                if (this.hNp.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.e(this.hNp.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.e(this.hNp.bWy(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.rf(TbadkCoreApplication.getInst().getAdAdSense().cgM);
            }
        }
        return pageStayDurationItem;
    }

    public boolean bVv() {
        return (!this.hMS && this.hOJ == -1 && this.hOK == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hOM = oVar;
            this.hMS = true;
            this.hNt.bYh();
            this.hNt.CC(this.hOL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVw() {
        if (this.hOM != null) {
            if (this.hOJ == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cE(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hOM.getCartoonId(), this.hOJ, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVx() {
        if (this.hOM != null) {
            if (this.hOK == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cE(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hOM.getCartoonId(), this.hOK, 0)));
                finish();
            }
        }
    }

    public int bVy() {
        return this.hOJ;
    }

    public int bVz() {
        return this.hOK;
    }

    private void bzj() {
        if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTy() != null && this.hNp.getPbData().bTy().afw()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bVA() {
        if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTy() != null && this.hNp.getPbData().bTy().afw()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bVB() {
        if (this.hMV) {
            this.hNi = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTy() != null && this.hNp.getPbData().bTy().aei() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hNp.getPbData().bTy().aei().getThreadId(), this.hNp.getPbData().bTy().aei().getTaskId(), this.hNp.getPbData().bTy().aei().getForumId(), this.hNp.getPbData().bTy().aei().getForumName(), this.hNp.getPbData().bTy().aex(), this.hNp.getPbData().bTy().aey())));
            this.hMU = true;
            finish();
        }
    }

    public String bVC() {
        return this.hNg;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bVD() {
        return this.hNo;
    }

    public void ov(boolean z) {
        this.hNh = z;
    }

    public boolean bVE() {
        if (this.hNp != null) {
            return this.hNp.bWA();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mQ(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hNO).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hNO.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hNO).agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hNO != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNO.getPageActivity());
            aVar.mQ(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hNO).agO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hNt.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNO.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.mQ(this.hNO.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mQ(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hNt.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hNO).agO();
    }

    public void bVG() {
        if (this.hNp != null && this.hNp.getPbData() != null && this.hNp.getPbData().bTy() != null && this.hNp.getPbData().bTy().afM() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.hv(R.string.channel_open_push_message);
            aVar.a(R.string.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hNp.getPbData().bTy().afM().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(R.string.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.agO();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.CE(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.fVN) {
            this.fVN = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.hNt != null) {
                this.hNt.onConfigurationChanged(configuration);
            }
            if (this.hNz != null) {
                this.hNz.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921419, configuration));
        }
    }

    public boolean bVH() {
        if (this.hNp != null) {
            return this.hNp.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hNp.getPbData().bTJ().hLr;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cqw().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cqw().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cqw().remove(i2);
                    list.get(i).cqy();
                    z = true;
                    break;
                }
            }
            list.get(i).Fk(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.hNp.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bUh().getId();
        List<PostData> list = this.hNp.getPbData().bTJ().hLr;
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
                ArrayList<PostData> bUl = kVar.bUl();
                postData.Bj(kVar.getTotalCount());
                if (postData.cqw() != null) {
                    postData.cqw().clear();
                    postData.cqw().addAll(bUl);
                }
            }
        }
        if (!this.hNp.getIsFromMark()) {
            this.hNt.m(this.hNp.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bUt() {
        return this.hNu;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bUu() {
        if (this.hNp == null) {
            return false;
        }
        return this.hNp.bUu();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bUv() {
        if (this.hNp != null) {
            return this.hNp.bUv();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bUw() {
        if (this.hNp == null || this.hNp.getPbData() == null) {
            return 0;
        }
        return this.hNp.getPbData().bTK();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Cl(String str) {
        return this.hNp != null && this.hNp.Cu(str);
    }

    public void bVI() {
        if (this.hNt != null) {
            this.hNt.bXV();
            bnf();
        }
    }

    public PostData bTF() {
        return this.hNt.c(this.hNp.hSQ, this.hNp.bWz());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aw(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.isLinkThread()) {
                return 3;
            }
            if (bhVar.afO()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hNX != null && !this.hNX.isEmpty()) {
            int size = this.hNX.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hNX.get(i).onBackPressed()) {
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
            if (this.hNX == null) {
                this.hNX = new ArrayList();
            }
            if (!this.hNX.contains(aVar)) {
                this.hNX.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hNX == null) {
                this.hNX = new ArrayList();
            }
            if (!this.hNX.contains(aVar)) {
                this.hNX.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hNX != null) {
            this.hNX.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVJ() {
        if (this.hNp != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.hNp.bWy())) {
            com.baidu.tbadk.BdToken.c.Zk().k(com.baidu.tbadk.BdToken.b.byl, com.baidu.adp.lib.g.b.e(this.hNp.bWy(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hNp == null || com.baidu.tbadk.core.util.aq.isEmpty(this.hNp.bWy())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.e(this.hNp.bWy(), 0L);
    }

    public com.baidu.tbadk.core.data.av bVK() {
        return this.hNn;
    }
}
