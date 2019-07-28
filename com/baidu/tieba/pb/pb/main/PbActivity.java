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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bl;
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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
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
    private com.baidu.adp.lib.e.b<ImageView> cJY;
    private com.baidu.adp.lib.e.b<GifView> cJZ;
    private com.baidu.adp.lib.e.b<TextView> cMN;
    private com.baidu.adp.lib.e.b<View> cMO;
    private com.baidu.adp.lib.e.b<LinearLayout> cMP;
    private com.baidu.adp.lib.e.b<RelativeLayout> cMQ;
    private com.baidu.adp.lib.e.b<TbImageView> ccT;
    private com.baidu.tieba.f.b eab;
    private au fVB;
    private VoiceManager ftO;
    private com.baidu.tieba.frs.profession.permission.c fxt;
    public com.baidu.tbadk.core.util.aj gVY;
    private String hJX;
    public as hKH;
    private com.baidu.tbadk.core.dialog.i hKI;
    private com.baidu.tbadk.core.dialog.k hKJ;
    private boolean hKL;
    private com.baidu.tieba.tbadkCore.data.f hKP;
    private com.baidu.tbadk.editortools.pb.f hKQ;
    private com.baidu.tbadk.editortools.pb.d hKR;
    private com.baidu.tieba.frs.profession.permission.c hKT;
    private EmotionImageData hKU;
    private com.baidu.adp.base.e hKX;
    private com.baidu.tbadk.core.view.e hKY;
    private BdUniqueId hKZ;
    private com.baidu.tieba.pb.pb.main.b.b hKd;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hKt;
    private View hKu;
    int hKw;
    private com.baidu.tieba.pb.pb.report.a hKz;
    private boolean hLJ;
    private String hLU;
    private com.baidu.tbadk.core.data.o hLV;
    private Runnable hLa;
    private com.baidu.adp.widget.ImageView.a hLb;
    private String hLc;
    private TbRichTextMemeInfo hLd;
    private List<a> hLg;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").P("obj_locate", au.a.bUe));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").P("obj_locate", au.a.bUe));
        }
    };
    private static final b.a hLP = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.f.b.a
        public void ji(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bTr();
            } else {
                com.baidu.tieba.pb.a.b.bTq();
            }
        }
    };
    private boolean hKc = false;
    private boolean hKe = false;
    private boolean hKf = false;
    private boolean hnA = false;
    private boolean hKg = true;
    private int hKh = 0;
    private com.baidu.tbadk.core.dialog.b hKi = null;
    private long eXm = -1;
    private long czV = 0;
    private long hKj = 0;
    private long createTime = 0;
    private long czN = 0;
    private boolean hKk = false;
    private com.baidu.tbadk.p.b hKl = null;
    private long hKm = 0;
    private boolean hKn = false;
    private long hKo = 0;
    private int fTg = 1;
    private String ctH = null;
    private boolean hKp = false;
    private boolean isFullScreen = false;
    private String hKq = "";
    private boolean hKr = true;
    private boolean hKs = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hKv = new int[2];
    private PbInterviewStatusView.a hKx = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void G(boolean z) {
            PbActivity.this.hKC.oR(!PbActivity.this.hKr);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hKy != null && PbActivity.this.hKy.aaB()) {
                        PbActivity.this.bUn();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hKy = null;
    private com.baidu.tbadk.baseEditMark.a hKA = null;
    private ForumManageModel eDv = null;
    private com.baidu.tbadk.coreExtra.model.a bTm = null;
    private com.baidu.tieba.pb.data.l hKB = null;
    private ShareSuccessReplyToServerModel fJN = null;
    private aq hKC = null;
    public final com.baidu.tieba.pb.pb.main.b.a hKD = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hKE = false;
    private boolean hKF = false;
    private boolean hKG = false;
    private boolean hKK = false;
    private boolean hKM = false;
    private boolean hKN = false;
    private boolean hKO = false;
    private boolean hKS = false;
    public boolean hKV = false;
    private com.baidu.tbadk.editortools.pb.c ctK = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void asx() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ctL = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean asw() {
            if (PbActivity.this.hKH == null || PbActivity.this.hKH.bYh() == null || !PbActivity.this.hKH.bYh().czg()) {
                return !PbActivity.this.xJ(com.baidu.tbadk.core.util.aj.bTh);
            }
            PbActivity.this.showToast(PbActivity.this.hKH.bYh().czi());
            if (PbActivity.this.hKR != null && (PbActivity.this.hKR.asL() || PbActivity.this.hKR.asM())) {
                PbActivity.this.hKR.a(false, PbActivity.this.hKH.bYk());
            }
            PbActivity.this.hKH.pd(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hKW = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean asw() {
            if (PbActivity.this.hKH == null || PbActivity.this.hKH.bYi() == null || !PbActivity.this.hKH.bYi().czg()) {
                return !PbActivity.this.xJ(com.baidu.tbadk.core.util.aj.bTi);
            }
            PbActivity.this.showToast(PbActivity.this.hKH.bYi().czi());
            if (PbActivity.this.hKC != null && PbActivity.this.hKC.bWT() != null && PbActivity.this.hKC.bWT().bVm() != null && PbActivity.this.hKC.bWT().bVm().asM()) {
                PbActivity.this.hKC.bWT().bVm().a(PbActivity.this.hKH.bYk());
            }
            PbActivity.this.hKH.pe(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean fuD = false;
    private int hLe = 0;
    private int hLf = -1;
    private final a hLh = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hKC != null && PbActivity.this.hKC.bWT() != null) {
                s bWT = PbActivity.this.hKC.bWT();
                if (bWT.bVk()) {
                    bWT.bVj();
                    return true;
                }
            }
            if (PbActivity.this.hKC != null && PbActivity.this.hKC.bXO()) {
                PbActivity.this.hKC.bXP();
                return true;
            }
            return false;
        }
    };
    private r.a hLi = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
    };
    private AddExperiencedModel.a fuP = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bUr();
        }
    };
    private final z.a hLj = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hKC.showToast(str);
            }
        }
    };
    private final CustomMessageListener hLk = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hKy != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hKR != null) {
                    PbActivity.this.hKC.oW(PbActivity.this.hKR.asF());
                }
                PbActivity.this.hKC.bWU();
                PbActivity.this.hKC.bXH();
            }
        }
    };
    CustomMessageListener fvj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hKy.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hKC != null && PbActivity.this.hKy != null) {
                    PbActivity.this.hKC.d(PbActivity.this.hKy.getPbData(), PbActivity.this.hKy.bVw(), PbActivity.this.hKy.bVR());
                }
                if (PbActivity.this.hKC != null && PbActivity.this.hKC.bXl() != null) {
                    PbActivity.this.hKC.bXl().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hLl = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hKC != null) {
                    if (booleanValue) {
                        PbActivity.this.hKC.bEI();
                    } else {
                        PbActivity.this.hKC.bEH();
                    }
                }
            }
        }
    };
    private CustomMessageListener hLm = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hKR != null) {
                    PbActivity.this.hKC.oW(PbActivity.this.hKR.asF());
                }
                PbActivity.this.hKC.oY(false);
            }
        }
    };
    private CustomMessageListener hLn = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
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
    private CustomMessageListener hLo = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hKC != null && PbActivity.this.hKC.bXl() != null) {
                PbActivity.this.hKC.bXl().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gzX = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener fvg = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hKf) {
                PbActivity.this.bUH();
            }
        }
    };
    private h.a hLp = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void v(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.xL(2);
                aj.bWF().reset();
                PbActivity.this.hKy.bVS();
                boolean z2 = false;
                ArrayList<PostData> bSz = PbActivity.this.hKy.getPbData().bSz();
                if (bSz != null) {
                    Iterator<PostData> it = bSz.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.cpy().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hKC.m(PbActivity.this.hKy.getPbData());
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
    private View.OnClickListener cuw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.ctH);
        }
    };
    private CustomMessageListener hLq = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hKy.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hKy.bVI() != null && PbActivity.this.hKy.bVI().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hKC.a(aaVar.sendCount, PbActivity.this.hKy.getPbData(), PbActivity.this.hKy.bVw(), PbActivity.this.hKy.bVR());
                    }
                    if (pbData.bSz() != null && pbData.bSz().size() >= 1 && pbData.bSz().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.bSz().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.hKy.bVv(), 0L);
                        if (c2 == aaVar.postId && c3 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cpx = pbData.bSz().get(0).cpx();
                            if (cpx == null) {
                                cpx = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> adt = cpx.adt();
                            if (adt == null) {
                                adt = new ArrayList<>();
                            }
                            adt.add(0, aVar);
                            cpx.setTotal(aaVar.sendCount + cpx.getTotal());
                            cpx.p(adt);
                            pbData.bSz().get(0).a(cpx);
                            PbActivity.this.hKC.bXl().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fKY = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                PbActivity.this.BM((String) customResponsedMessage.getData());
                PbActivity.this.hKy.bVO();
                if (PbActivity.this.hKC.bXl() != null) {
                    PbActivity.this.hKC.m(PbActivity.this.hKy.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hLr = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bYr()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hLs = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aj(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.aa(list) && PbActivity.this.hKC != null) {
                PbActivity.this.hKC.dK(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hLt = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bd.cF(PbActivity.this.getPageContext().getPageActivity());
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
    private boolean hLu = false;
    private PraiseModel hLv = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void sE(String str) {
            PbActivity.this.hLu = false;
            if (PbActivity.this.hLv != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hKy.getPbData();
                if (pbData.bSx().aej().getIsLike() == 1) {
                    PbActivity.this.st(0);
                } else {
                    PbActivity.this.st(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bSx()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbActivity.this.hLu = false;
            if (PbActivity.this.hLv != null && str != null) {
                if (AntiHelper.aG(i, str)) {
                    AntiHelper.aJ(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hLw = 0;
    private boolean hLx = true;
    private b.a hLy = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void os(boolean z) {
            PbActivity.this.or(z);
            if (PbActivity.this.hKC.bXU() != null && z) {
                PbActivity.this.hKC.oR(false);
            }
            PbActivity.this.hKC.oT(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().chF != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().chF, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").P("obj_locate", au.a.bUe));
                        }
                    } else if (updateAttentionMessage.getData().Hs) {
                        if (PbActivity.this.bSE().aex() != null && PbActivity.this.bSE().aex().getGodUserData() != null) {
                            PbActivity.this.bSE().aex().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().aex() != null) {
                            PbActivity.this.hKy.getPbData().bSx().aex().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a dZs = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hKC.aUz();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.xM(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.buv();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(R.string.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c clt = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            PbActivity.this.bTX();
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
                    if (PbActivity.this.cv(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                    if (PbActivity.this.hKC != null && PbActivity.this.hKC.bTV() && view.getId() == R.id.pb_head_user_info_root) {
                        if (view.getTag(R.id.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").bT(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(R.id.tag_user_id)));
                        }
                        if (PbActivity.this.hKD != null && PbActivity.this.hKD.fVU != null) {
                            PbActivity.this.hKD.fVU.onClick(view);
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
            if (PbActivity.this.hKR != null) {
                PbActivity.this.hKC.oW(PbActivity.this.hKR.asF());
            }
            PbActivity.this.hKC.bWU();
            PbActivity.this.hKC.bXH();
            return true;
        }
    });
    private CustomMessageListener hLz = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hKZ) {
                PbActivity.this.hKC.aUz();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hKy.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bSK().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hKY.i(PbActivity.this.hKX.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hKX.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbActivity.this.qv(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bUD();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hKX.getResources().getString(R.string.mute_fail);
                    }
                    PbActivity.this.hKY.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hLA = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hKZ) {
                PbActivity.this.hKC.aUz();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hKY.i(PbActivity.this.hKX.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hKX.getResources().getString(R.string.un_mute_fail);
                }
                PbActivity.this.hKY.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hLB = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hKZ) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hKC.aUz();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.jtn;
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
                    PbActivity.this.hKC.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hLC = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hKC.bWV() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bTX();
            }
        }
    };
    private CustomMessageListener fvq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.fuD = true;
                }
            }
        }
    };
    public a.b hyJ = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bmk();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hKy.getPageData();
            int pageNum = PbActivity.this.hKC.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.adm()) {
                PbActivity.this.hKC.bXH();
                PbActivity.this.xL(2);
                PbActivity.this.bmj();
                PbActivity.this.hKC.bXp();
                if (com.baidu.adp.lib.util.j.kc()) {
                    PbActivity.this.hKy.xT(PbActivity.this.hKC.getPageNum());
                    if (PbActivity.this.hKd != null) {
                        PbActivity.this.hKd.showFloatingView();
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
    public final View.OnClickListener fvY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Multi-variable search result rejected for r4v280, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v284, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v311, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v424, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:576:0x1c02  */
        /* JADX WARN: Removed duplicated region for block: B:579:0x1c4b  */
        /* JADX WARN: Removed duplicated region for block: B:596:0x1e65  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            String str;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            boolean on;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            long j;
            String str2;
            int i;
            int i2;
            int i3;
            bl blVar;
            String[] strArr;
            boolean u;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.hKC.bXD()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hKy.oC(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hKC.bXq();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hKC.hTu.bYE() == null || view != PbActivity.this.hKC.hTu.bYE().bWA()) {
                        if (view == PbActivity.this.hKC.hTu.cCf) {
                            if (PbActivity.this.hKC.oV(PbActivity.this.hKy.bVB())) {
                                PbActivity.this.bmj();
                                return;
                            }
                            PbActivity.this.hKg = false;
                            PbActivity.this.hKe = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hKC.hTu.cCf);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hKC.bXn() && (PbActivity.this.hKC.hTu.bYE() == null || (view != PbActivity.this.hKC.hTu.bYE().bWz() && view != PbActivity.this.hKC.hTu.bYE().bWx()))) {
                            if (view == PbActivity.this.hKC.bXK()) {
                                if (PbActivity.this.hKy != null) {
                                    com.baidu.tbadk.browser.a.ae(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKy.getPbData().bSx().aew().getLink());
                                }
                            } else if (view != PbActivity.this.hKC.hTu.hYP) {
                                if (view == PbActivity.this.hKC.hTu.hYQ) {
                                    if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                                        ArrayList<PostData> bSz = PbActivity.this.hKy.getPbData().bSz();
                                        if ((bSz == null || bSz.size() <= 0) && PbActivity.this.hKy.bVw()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").bT("tid", PbActivity.this.hKy.bVv()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", PbActivity.this.hKy.getForumId()));
                                        if (!PbActivity.this.hKC.bXZ()) {
                                            PbActivity.this.hKC.bWU();
                                        }
                                        PbActivity.this.bUf();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.kc()) {
                                        PbActivity.this.hKC.ow(true);
                                        PbActivity.this.hKC.bWU();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hKC.bEI();
                                            PbActivity.this.bmj();
                                            PbActivity.this.hKC.bXp();
                                            PbActivity.this.hKy.BT(PbActivity.this.bUs());
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.xL(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbActivity.this.hKC.hTu.bYE() == null || view != PbActivity.this.hKC.hTu.bYE().bWw()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbActivity.this.hKC.hTu.bYE() != null && view == PbActivity.this.hKC.hTu.bYE().getCancelView()) {
                                            PbActivity.this.hKC.hTu.UM();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbActivity.this.hKC.hTu.bYE() == null || view != PbActivity.this.hKC.hTu.bYE().bWu()) {
                                                if ((PbActivity.this.hKC.hTu.bYE() == null || view != PbActivity.this.hKC.hTu.bYE().bWC()) && view.getId() != R.id.pb_sort) {
                                                    if (PbActivity.this.hKC.hTu.bYE() == null || view != PbActivity.this.hKC.hTu.bYE().bWv()) {
                                                        if (PbActivity.this.hKC.hTu.bYE() == null || view != PbActivity.this.hKC.hTu.bYE().bWD()) {
                                                            if (PbActivity.this.hKC.bXU() == view) {
                                                                if (PbActivity.this.hKC.bXU().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hKy.getPbData();
                                                                    if (pbData != null && pbData.bSx() != null && pbData.bSx().aed() != null) {
                                                                        String adU = pbData.bSx().aed().adU();
                                                                        if (StringUtils.isNull(adU)) {
                                                                            adU = pbData.bSx().aed().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").bT(VideoPlayActivityConfig.OBJ_ID, adU));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.em("c10725", null);
                                                                }
                                                                PbActivity.this.bUz();
                                                            } else if (PbActivity.this.hKC.hTu.bYE() == null || view != PbActivity.this.hKC.hTu.bYE().bWB()) {
                                                                if (PbActivity.this.hKC.hTu.bYE() != null && view == PbActivity.this.hKC.hTu.bYE().bWy()) {
                                                                    if (com.baidu.adp.lib.util.j.kc()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hKC.c(PbActivity.this.hKy.getPbData(), PbActivity.this.hKy.bVw(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(R.id.tag_del_multi_forum))) {
                                                                                PbActivity.this.hKC.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hKC.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) c2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hKC.hTu.UM();
                                                                    } else {
                                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hKy != null && view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.bT("tid", PbActivity.this.hKy.bVv());
                                                                        anVar.bT("fid", PbActivity.this.hKy.getForumId());
                                                                        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.P("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hKy.getPbData() != null) {
                                                                            PbActivity.this.hKC.bXH();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cpB() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.jfT != null) {
                                                                                    com.baidu.tbadk.core.util.an ajh = postData.jfT.ajh();
                                                                                    ajh.nV("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        ajh.P("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        ajh.P("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(ajh);
                                                                                }
                                                                                String bVv = PbActivity.this.hKy.bVv();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hKy.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hKy.getPbData().bSJ();
                                                                                }
                                                                                PbActivity.this.bmj();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    c BR = PbActivity.this.BR(id);
                                                                                    if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && BR != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bVv, id, "pb", true, null, true, null, i4, postData.bZx(), PbActivity.this.hKy.getPbData().getAnti(), false, postData.aex().getIconInfo()).addBigImageData(BR.hMx, BR.hMy, BR.hMz, BR.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hKy.bWe());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hKy.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c BR2 = PbActivity.this.BR(id);
                                                                                    if (postData != null && PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && BR2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bVv, id, "pb", true, null, false, null, i4, postData.bZx(), PbActivity.this.hKy.getPbData().getAnti(), false, postData.aex().getIconInfo()).addBigImageData(BR2.hMx, BR2.hMy, BR2.hMz, BR2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hKy.bWe());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hKy.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").P("obj_locate", 3).bT("fid", PbActivity.this.hKy.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbActivity.this.hKy != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.bT("tid", PbActivity.this.hKy.bVv());
                                                                        anVar2.bT("fid", PbActivity.this.hKy.getForumId());
                                                                        anVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.P("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                                                                                    String bVv2 = PbActivity.this.hKy.bVv();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hKy.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hKy.getPbData().bSJ();
                                                                                    }
                                                                                    c BR3 = PbActivity.this.BR(id2);
                                                                                    if (BR3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bVv2, id2, "pb", true, null, false, null, i5, postData2.bZx(), PbActivity.this.hKy.getPbData().getAnti(), false, postData2.aex().getIconInfo()).addBigImageData(BR3.hMx, BR3.hMy, BR3.hMz, BR3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hKy.bWe());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hKy.getFromForumId());
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
                                                                    if (PbActivity.this.hKy != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.bT("tid", PbActivity.this.hKy.bVv());
                                                                        anVar3.bT("fid", PbActivity.this.hKy.getForumId());
                                                                        anVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.P("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.bTU().bWS() != null && postData3.aex() != null && postData3.cpp() != 1) {
                                                                                    if (PbActivity.this.bTU().bWT() != null) {
                                                                                        PbActivity.this.bTU().bWT().bVi();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                    kVar.a(PbActivity.this.hKy.getPbData().getForum());
                                                                                    kVar.ai(PbActivity.this.hKy.getPbData().bSx());
                                                                                    kVar.e(postData3);
                                                                                    PbActivity.this.bTU().bWS().d(kVar);
                                                                                    PbActivity.this.bTU().bWS().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.aex().getUserId(), "");
                                                                                    if (PbActivity.this.hKR != null) {
                                                                                        PbActivity.this.hKC.oW(PbActivity.this.hKR.asF());
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
                                                                } else if (view != PbActivity.this.hKC.bTP()) {
                                                                    if (view == PbActivity.this.hKC.hTu.bYF()) {
                                                                        PbActivity.this.hKC.bXw();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbActivity.this.checkUpIsLogin() && (blVar = (bl) view.getTag()) != null && !StringUtils.isNull(blVar.agy())) {
                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                bb.ajC().c(PbActivity.this.getPageContext(), new String[]{blVar.agy()});
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").bT("tid", PbActivity.this.hKy.hPC));
                                                                                    }
                                                                                    if (PbActivity.this.hKJ == null) {
                                                                                        PbActivity.this.hKJ = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                                                                                        PbActivity.this.hKJ.a(PbActivity.this.hLO);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cx(view);
                                                                                    if (!PbActivity.this.cx(view) || PbActivity.this.hLb == null || !PbActivity.this.hLb.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hKJ);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cpr() != null && postData4.cpr().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hKJ);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbActivity.this.gnc = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hKy.getPbData().aaB()) {
                                                                                        String aaA = PbActivity.this.hKy.getPbData().aaA();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(aaA) && aaA.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hKJ);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hKJ);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbActivity.this.gnc);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hKJ);
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
                                                                                                    if (!ap.m(PbActivity.this.gnc)) {
                                                                                                        on = PbActivity.this.on(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        on = false;
                                                                                                    }
                                                                                                    if (on) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hKJ);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hKJ);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hKJ);
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
                                                                                                    if (PbActivity.this.hKy.getPbData().bSJ() == 1002 && !z3) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hKJ);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hKJ);
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
                                                                                            PbActivity.this.hKJ.W(arrayList);
                                                                                            PbActivity.this.hKI = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hKJ.ahb());
                                                                                            PbActivity.this.hKI.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbActivity.this.gnc);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hKJ.W(arrayList);
                                                                                    PbActivity.this.hKI = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hKJ.ahb());
                                                                                    PbActivity.this.hKI.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), PbActivity.this.hKy.getPbData().bSx().getActUrl());
                                                                                if (PbActivity.this.hKy.getPbData().bSx().afh() != 1) {
                                                                                    if (PbActivity.this.hKy.getPbData().bSx().afh() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").bT("fid", PbActivity.this.hKy.getPbData().getForumId()).bT("tid", PbActivity.this.hKy.getPbData().getThreadId()).bT("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hKy.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hKC.setSelection(0);
                                                                                } else {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bd.cF(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.ahO().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbActivity.this.hKC.bWU();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bUc() == 1 && PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").bT("fid", PbActivity.this.hKy.getPbData().getForumId()).bT("tid", PbActivity.this.hKy.getPbData().getThreadId()).bT("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bUc() == 1 && PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").bT("fid", PbActivity.this.hKy.getPbData().getForumId()).bT("tid", PbActivity.this.hKy.getPbData().getThreadId()).bT("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbActivity.this.bUu();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbActivity.this.bUv();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSQ() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hKy.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").bT("fid", pbData2.getForumId()));
                                                                                bb.ajC().c(PbActivity.this.getPageContext(), new String[]{pbData2.bSQ().bSX()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSQ() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hKy.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bT("fid", pbData3.getForumId()));
                                                                                bb.ajC().c(PbActivity.this.getPageContext(), new String[]{pbData3.bSQ().bSX()});
                                                                            }
                                                                        } else if (PbActivity.this.hKC.hTu.bYE() != null && view == PbActivity.this.hKC.hTu.bYE().bWE()) {
                                                                            if (PbActivity.this.hKy == null || PbActivity.this.hKy.getPbData() == null || PbActivity.this.hKy.getPbData().bSx() == null) {
                                                                                PbActivity.this.hKC.hTu.UM();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.kt()) {
                                                                                PbActivity.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hKy.getPbData().bSx().aee() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKy.bVv(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(R.string.haved_fans_called)).agQ();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").P("obj_locate", PbActivity.this.au(PbActivity.this.hKy.getPbData().bSx())).bT("tid", PbActivity.this.hKy.getPbData().bSx().getTid()).P("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hLe >= 0) {
                                                                                if (PbActivity.this.hKy != null) {
                                                                                    PbActivity.this.hKy.bWf();
                                                                                }
                                                                                if (PbActivity.this.hKC.bXl() != null) {
                                                                                    PbActivity.this.hKC.bXl().a(PbActivity.this.hKy.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hKC.getListView().setSelection(PbActivity.this.hKy.bWi());
                                                                                PbActivity.this.hLe = 0;
                                                                                if (PbActivity.this.hKy != null) {
                                                                                    PbActivity.this.hKy.ch(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbActivity.this.bTZ();
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
                                                                            if (PbActivity.this.hKC.getListView() != null && PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hKC.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbActivity.this.hKC.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean bSV = PbActivity.this.hKy.getPbData().bSV();
                                                                                boolean z8 = PbActivity.this.hKC.hTo != null && PbActivity.this.hKC.hTo.bZN();
                                                                                boolean bXE = PbActivity.this.hKC.bXE();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bSV && PbActivity.this.hKC.hTo != null && PbActivity.this.hKC.hTo.aJs() != null) {
                                                                                    int af = ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)) - PbActivity.this.hKC.hTo.bZO();
                                                                                    z9 = firstVisiblePosition == 0 && (top == af || top == PbActivity.this.hKC.hTo.aJs().getHeight() - PbActivity.this.hKC.hTo.bZO());
                                                                                    i7 = af;
                                                                                }
                                                                                if ((PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().aeo() <= 0) || (bXE && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bTZ();
                                                                                        if (PbActivity.this.hKy.getPbData().bSx().aex() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hKy.hPC).bT("fid", PbActivity.this.hKy.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hKy.getPbData().bSx().aex().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.6d);
                                                                                    if (bSV) {
                                                                                        if (PbActivity.this.hKC.hVj != null && PbActivity.this.hKC.hVj.hWt != null && PbActivity.this.hKC.hVj.hWt.getView() != null) {
                                                                                            if (PbActivity.this.hKC.hVj.hWt.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bUi();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hKC.hTo.aJs() != null) {
                                                                                                    i8 = PbActivity.this.hKC.hTo.aJs().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hKC.hVj.hWt.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hKC.bXc() != null) {
                                                                                        z10 = PbActivity.this.hKC.bXc().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hKC.hVj != null && PbActivity.this.hKC.hVj.hWt != null && PbActivity.this.hKC.hVj.hWt.getView() != null && PbActivity.this.hKC.hVj.hWt.getView().getParent() != null && PbActivity.this.hKC.hTu != null && PbActivity.this.hKC.hTu.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hKC.hVj.hWt.getView().getTop() - PbActivity.this.hKC.hTu.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bXE) {
                                                                                        int bUi = PbActivity.this.bUi();
                                                                                        if (PbActivity.this.bUh() != -1) {
                                                                                            bUi--;
                                                                                        }
                                                                                        int g = com.baidu.adp.lib.util.l.g(PbActivity.this, R.dimen.tbds116);
                                                                                        if (bUi < 0) {
                                                                                            i2 = PbActivity.this.hKC.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.Z(PbActivity.this.hKC.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bUi;
                                                                                            i3 = g;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bSV || PbActivity.this.hKC.hTo.aJs() == null) {
                                                                                            if (PbActivity.this.hKC.hTu != null && PbActivity.this.hKC.hTu.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hKC.hTu.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hKC.hTo.aJs().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hKC.hVj == null || PbActivity.this.hKC.hVj.hWt == null || PbActivity.this.hKC.hVj.hWt.getView() == null || PbActivity.this.hKC.hVj.hWt.getView().getParent() == null) {
                                                                                            PbActivity.this.hKC.getListView().setSelectionFromTop(i2, i3 + ah);
                                                                                            PbActivity.this.hKC.getListView().smoothScrollBy(ah, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hKC.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hKC.getListView().smoothScrollBy(PbActivity.this.hKC.hVj.hWt.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-ah))) {
                                                                                        PbActivity.this.hKC.getListView().setSelectionFromTop(0, i7 - ah);
                                                                                        PbActivity.this.hKC.getListView().smoothScrollBy(-ah, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hKC.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().aex() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hKy.hPC).bT("fid", PbActivity.this.hKy.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hKy.getPbData().bSx().aex().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbActivity.this.hKy.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hKy.bWe() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hKy.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.bT("tid", PbActivity.this.hKy.bVv());
                                                                                anVar4.bT("fid", PbActivity.this.hKy.getForumId());
                                                                                anVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bg) {
                                                                                bg bgVar = (bg) view.getTag();
                                                                                if (PbActivity.this.hKy.bWe() == 3 && PbActivity.this.bTt() && PbActivity.this.hKy.getPbData() != null && com.baidu.tbadk.core.util.v.aa(PbActivity.this.hKy.getPbData().bSS())) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(bgVar.aeC(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.bT("tid", bgVar.getId());
                                                                                anVar5.l("fid", bgVar.getFid());
                                                                                anVar5.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbActivity.this.hKy != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.bT("tid", PbActivity.this.hKy.bVv());
                                                                                anVar6.bT("fid", PbActivity.this.hKy.getForumId());
                                                                                anVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.P("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.hKy.getPbData();
                                                                                if (PbActivity.this.hKB == null) {
                                                                                    PbActivity.this.hKB = new com.baidu.tieba.pb.data.l(PbActivity.this.getPageContext());
                                                                                }
                                                                                long c3 = com.baidu.adp.lib.g.b.c(pbData4.getThreadId(), 0L);
                                                                                long c4 = com.baidu.adp.lib.g.b.c(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").l("forum_id", c4).aji();
                                                                                PbActivity.this.registerListener(PbActivity.this.hLE);
                                                                                PbActivity.this.hKB.s(c3, c4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_video_thread_smart_app_layout && (view.getTag() instanceof SmartApp)) {
                                                                            SmartApp smartApp = (SmartApp) view.getTag();
                                                                            if (!com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                if (!StringUtils.isNull(smartApp.h5_url)) {
                                                                                    com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), smartApp.h5_url);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").bT("fid", PbActivity.this.hKy.getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "PB_card").bT("tid", PbActivity.this.hKy.bVv()).P("obj_param1", smartApp.is_game.intValue()));
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.hKy.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.hKy.bVv(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hKy.getPbData().bSx().aeR())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.kc()) {
                                                                PbActivity.this.hKC.bXH();
                                                                SparseArray<Object> c5 = PbActivity.this.hKC.c(PbActivity.this.hKy.getPbData(), PbActivity.this.hKy.bVw(), 1);
                                                                if (c5 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKy.getPbData().getForum().getId(), PbActivity.this.hKy.getPbData().getForum().getName(), PbActivity.this.hKy.getPbData().bSx().getId(), String.valueOf(PbActivity.this.hKy.getPbData().getUserData().getUserId()), (String) c5.get(R.id.tag_forbid_user_name), (String) c5.get(R.id.tag_forbid_user_name_show), (String) c5.get(R.id.tag_forbid_user_post_id), (String) c5.get(R.id.tag_forbid_user_portrait))));
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
                                                                UtilHelper.setNavigationBarBackground(PbActivity.this.getActivity(), PbActivity.this.getResources().getColor(R.color.cp_bg_line_d));
                                                                TbadkCoreApplication.getInst().setSkinType(0);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10647").P("obj_type", 0).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                            } else if (skinType == 0) {
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbActivity.this.getActivity(), PbActivity.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10647").P("obj_type", 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                            }
                                                            PbActivity.this.hKC.hTu.bYD();
                                                        }
                                                    } else if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSx() != null) {
                                                        PbActivity.this.hKC.hTu.UM();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbActivity.this.BO(PbActivity.this.hKy.getPbData().bSx().aeN());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hKC.bXH();
                                                    if (com.baidu.adp.lib.util.j.kc()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hKy.bVM()));
                                                            return;
                                                        }
                                                        PbActivity.this.xL(2);
                                                        PbActivity.this.bmj();
                                                        PbActivity.this.hKC.bXp();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hKy.getPbData().hHT == null || PbActivity.this.hKy.getPbData().hHT.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(R.string.sort_type_new), PbActivity.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hKy.getPbData().hHT.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hKy.getPbData().hHT.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hKy.getPbData().hHT.get(i10).sort_name + PbActivity.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbActivity.this.hKy.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hKy.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hKy.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hKy.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != R.id.pb_sort ? 1 : 0).P("obj_type", i12));
                                                                if (PbActivity.this.hKy.getPbData().hHT != null && PbActivity.this.hKy.getPbData().hHT.size() > i11) {
                                                                    i11 = PbActivity.this.hKy.getPbData().hHT.get(i11).sort_type.intValue();
                                                                }
                                                                boolean xY = PbActivity.this.hKy.xY(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hKy.bVM()));
                                                                if (xY) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hKC.oN(true);
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
                                                PbActivity.this.hKC.bXH();
                                                if (PbActivity.this.bTD().getPbData().hHU != 2) {
                                                    if (PbActivity.this.hKy.getPageData() != null) {
                                                        PbActivity.this.hKC.a(PbActivity.this.hKy.getPageData(), PbActivity.this.hyJ);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (bf.iN() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().aex() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hKy.hPC).bT("fid", PbActivity.this.hKy.getPbData().getForumId()).P("obj_locate", 4).bT("uid", PbActivity.this.hKy.getPbData().bSx().aex().getUserId()));
                                            }
                                            if (PbActivity.this.hKy != null) {
                                                com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an("c12386");
                                                anVar7.bT("tid", PbActivity.this.hKy.bVv());
                                                anVar7.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                anVar7.bT("fid", PbActivity.this.hKy.getForumId());
                                                anVar7.P("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    anVar7.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(anVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.kt()) {
                                                if (PbActivity.this.hKy.getPbData() != null) {
                                                    ArrayList<PostData> bSz2 = PbActivity.this.hKy.getPbData().bSz();
                                                    if ((bSz2 != null && bSz2.size() > 0) || !PbActivity.this.hKy.bVw()) {
                                                        PbActivity.this.hKC.bXH();
                                                        PbActivity.this.bmj();
                                                        PbActivity.this.xL(2);
                                                        if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSQ() != null && !StringUtils.isNull(PbActivity.this.hKy.getPbData().bSQ().acU(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bT("fid", PbActivity.this.hKy.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                        if (bf.iN()) {
                                                            PbActivity.this.xM(2);
                                                        } else {
                                                            PbActivity.this.hKC.showLoadingDialog();
                                                            PbActivity.this.hKy.bVZ().p(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                        PbActivity.this.hKC.bXH();
                                        if (PbActivity.this.hKC.hTu.bYE() != null && view == PbActivity.this.hKC.hTu.bYE().bWw() && !PbActivity.this.hKC.bXZ()) {
                                            PbActivity.this.hKC.bWU();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bmj();
                                            PbActivity.this.hKC.bXp();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                u = PbActivity.this.hKy.u(true, PbActivity.this.bUs());
                                            } else {
                                                u = view.getId() == R.id.reply_title ? PbActivity.this.hKy.u(false, PbActivity.this.bUs()) : PbActivity.this.hKy.BT(PbActivity.this.bUs());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hKC.ow(true);
                                                PbActivity.this.hKC.bEI();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hKC.oN(true);
                                            }
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.xL(2);
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
                                    PbActivity.this.hKC.bXH();
                                    if (PbActivity.this.xK(11009) && PbActivity.this.hKy.xZ(PbActivity.this.hKC.bXu()) != null) {
                                        PbActivity.this.bUm();
                                        if (PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().aex() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hKy.hPC).bT("fid", PbActivity.this.hKy.getPbData().getForumId()).P("obj_locate", 3).bT("uid", PbActivity.this.hKy.getPbData().bSx().aex().getUserId()));
                                        }
                                        if (PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().aex() != null && PbActivity.this.hKy.getPbData().bSx().aex().getUserId() != null && PbActivity.this.hKA != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bT("tid", PbActivity.this.hKy.hPC).P("obj_locate", 1).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hKy.getPbData().bSx().aex().getUserId()).P("obj_type", PbActivity.this.hKA.aaB() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hKy.getPbData())));
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
                                if (PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().afr() && PbActivity.this.hKy.getPbData().bSx().aeO() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbActivity.this.hKy.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hKy.bTu()) && PbActivity.this.hKy.getAppealInfo() != null) {
                                        name = PbActivity.this.hKy.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hKy.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bTu = PbActivity.this.hKy.bTu();
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hKy.bVx() && bTu != null && bTu.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.kc()) {
                            if (PbActivity.this.hKy.getPbData() != null) {
                                if ((PbActivity.this.hKy.getPbData().bSJ() == 1 || PbActivity.this.hKy.getPbData().bSJ() == 3) && !PbActivity.this.eDv.cqb()) {
                                    PbActivity.this.hKC.bXH();
                                    int i11 = 0;
                                    if (PbActivity.this.hKC.hTu.bYE() == null || view != PbActivity.this.hKC.hTu.bYE().bWx()) {
                                        if (PbActivity.this.hKC.hTu.bYE() == null || view != PbActivity.this.hKC.hTu.bYE().bWz()) {
                                            if (view == PbActivity.this.hKC.bXn()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hKy.getPbData().bSx().aet() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hKy.getPbData().bSx().aes() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hKy.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hKy.getPbData().bSx().getId();
                                    PbActivity.this.hKC.bXm();
                                    PbActivity.this.eDv.a(id4, name2, id5, i11, PbActivity.this.hKC.bXo());
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
                        PbActivity.this.hKC.bXH();
                        PbActivity.this.bmj();
                        PbActivity.this.hKC.bXp();
                        PbActivity.this.hKC.showLoadingDialog();
                        if (PbActivity.this.hKC.bXc() != null) {
                            PbActivity.this.hKC.bXc().setVisibility(8);
                        }
                        PbActivity.this.hKy.xT(1);
                        if (PbActivity.this.hKd != null) {
                            PbActivity.this.hKd.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String bUa = PbActivity.this.bUa();
                        if (!TextUtils.isEmpty(bUa)) {
                            bb.ajC().c(PbActivity.this.getPageContext(), new String[]{bUa});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hKy != null) {
                    com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                    anVar8.bT("tid", PbActivity.this.hKy.bVv());
                    anVar8.bT("fid", PbActivity.this.hKy.getForumId());
                    anVar8.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar8.P("obj_locate", 1);
                    TiebaStatic.log(anVar8);
                }
                if (PbActivity.this.hKn) {
                    PbActivity.this.hKn = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.bTU().bWS() != null && postData5.aex() != null && postData5.cpp() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bTU().bWT() != null) {
                                PbActivity.this.bTU().bWT().bVi();
                            }
                            com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                            kVar2.a(PbActivity.this.hKy.getPbData().getForum());
                            kVar2.ai(PbActivity.this.hKy.getPbData().bSx());
                            kVar2.e(postData5);
                            PbActivity.this.bTU().bWS().d(kVar2);
                            PbActivity.this.bTU().bWS().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.aex().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hKy.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hKR != null) {
                                PbActivity.this.hKC.oW(PbActivity.this.hKR.asF());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d ctR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                    anVar.bT("fid", PbActivity.this.hKy.getPbData().getForumId());
                }
                if (PbActivity.this.hKy != null) {
                    anVar.bT("tid", PbActivity.this.hKy.bVv());
                }
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbActivity.this.bmj();
            PbActivity.this.hKC.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.t.av.avQ() && PbActivity.this.bTD() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bTD().BW(postWriteCallBackData.getPostId());
                    PbActivity.this.hLe = PbActivity.this.hKC.bWY();
                    if (PbActivity.this.hKy != null) {
                        PbActivity.this.hKy.ch(PbActivity.this.hLe, PbActivity.this.hKC.bWZ());
                    }
                }
                PbActivity.this.hKC.bXH();
                PbActivity.this.hKH.bYg();
                if (PbActivity.this.hKR != null) {
                    PbActivity.this.hKC.oW(PbActivity.this.hKR.asF());
                }
                PbActivity.this.hKC.bWR();
                PbActivity.this.hKC.oY(true);
                PbActivity.this.hKy.bVO();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hKy.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hKy.getPbData();
                            if (pbData != null && pbData.bSx() != null && pbData.bSx().aex() != null && (userId = pbData.bSx().aex().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.t.av.avQ() && PbActivity.this.hKy.bVF()) {
                                PbActivity.this.hKC.bXp();
                            }
                        } else if (!com.baidu.tbadk.t.av.avQ() && PbActivity.this.hKy.bVF()) {
                            PbActivity.this.hKC.bXp();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hKC.m(PbActivity.this.hKy.getPbData());
                    }
                    if (PbActivity.this.hKy.bVA()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").bT("tid", PbActivity.this.hKy.bVv()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hKR.asL() || PbActivity.this.hKR.asM()) {
                    PbActivity.this.hKR.a(false, postWriteCallBackData);
                }
                PbActivity.this.hKH.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gVY != null) {
                    PbActivity.this.gVY.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hLD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                    anVar.bT("fid", PbActivity.this.hKy.getPbData().getForumId());
                }
                if (PbActivity.this.hKy != null) {
                    anVar.bT("tid", PbActivity.this.hKy.bVv());
                }
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbActivity.this.hKH != null) {
                    PbActivity.this.hKH.bYf();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gVY != null) {
                    PbActivity.this.gVY.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hKH != null) {
                if (PbActivity.this.hKC != null && PbActivity.this.hKC.bWT() != null && PbActivity.this.hKC.bWT().bVm() != null && PbActivity.this.hKC.bWT().bVm().asM()) {
                    PbActivity.this.hKC.bWT().bVm().a(postWriteCallBackData);
                }
                PbActivity.this.hKH.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hLE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView bYe;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbActivity.this.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbActivity.this.hKC != null && (bYe = PbActivity.this.hKC.bYe()) != null && PbActivity.this.hKC.getListView() != null) {
                            PbActivity.this.hKC.getListView().removeHeaderView(bYe);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a hLF = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g km;
            if (!z || dVar == null || dVar.bSH() != null || com.baidu.tbadk.core.util.v.Z(dVar.bSz()) >= 1) {
                PbActivity.this.hnA = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hKC.bXr();
                if (dVar == null || !dVar.bSD()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hKC.getView());
                }
                PbActivity.this.hKC.bEH();
                if (PbActivity.this.isFullScreen || PbActivity.this.hKC.bXZ()) {
                    PbActivity.this.hKC.bXQ();
                } else if (!PbActivity.this.hKC.bXN()) {
                    PbActivity.this.hKC.oY(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hKK = true;
                }
                if (dVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hKC.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hKC.aVP();
                    if (dVar.bSx() != null && dVar.bSx().afA() != null) {
                        PbActivity.this.a(dVar.bSx().afA());
                    }
                    PbActivity.this.bTR();
                    if (PbActivity.this.hKR != null) {
                        PbActivity.this.hKC.oW(PbActivity.this.hKR.asF());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bSz() != null && dVar.bSz().size() >= 1 && dVar.bSz().get(0) != null) {
                        PbActivity.this.hKy.BV(dVar.bSz().get(0).getId());
                    } else if (dVar.bSH() != null) {
                        PbActivity.this.hKy.BV(dVar.bSH().getId());
                    }
                    if (PbActivity.this.hKR != null) {
                        PbActivity.this.hKR.a(dVar.getAnti());
                        PbActivity.this.hKR.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hKR.a(PbActivity.this.hKy.bVI(), PbActivity.this.hKy.bVv(), PbActivity.this.hKy.bWb());
                        if (dVar.bSx() != null) {
                            PbActivity.this.hKR.fo(dVar.bSx().afP());
                        }
                    }
                    if (PbActivity.this.hKA != null) {
                        PbActivity.this.hKA.dx(dVar.aaB());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hKC.oX(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hKC.a(dVar, i2, i3, PbActivity.this.hKy.bVw(), i4, PbActivity.this.hKy.getIsFromMark());
                    PbActivity.this.hKC.e(dVar, PbActivity.this.hKy.bVw());
                    PbActivity.this.hKC.oU(PbActivity.this.hKy.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.ctH = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.ctH) && PbActivity.this.hKR != null && PbActivity.this.hKR.arY() != null && (km = PbActivity.this.hKR.arY().km(6)) != null && !TextUtils.isEmpty(PbActivity.this.ctH)) {
                            ((View) km).setOnClickListener(PbActivity.this.cuw);
                        }
                    }
                    if (PbActivity.this.hKM) {
                        PbActivity.this.hKM = false;
                        final int bUh = PbActivity.this.bUh();
                        if (!dVar.bSV()) {
                            PbActivity.this.hKC.yf(bUh);
                        } else {
                            final int af = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bUh, af);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hKN) {
                        PbActivity.this.hKN = false;
                        final int bUh2 = PbActivity.this.bUh();
                        final boolean z2 = bUh2 != -1;
                        if (!z2) {
                            bUh2 = PbActivity.this.bUi();
                        }
                        if (PbActivity.this.hKC != null) {
                            if (!dVar.bSV()) {
                                PbActivity.this.hKC.yf(bUh2);
                            } else {
                                final int af2 = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bUh2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hKC.setSelectionFromTop(bUh2, af2);
                                            } else {
                                                PbActivity.this.hKC.setSelectionFromTop(bUh2 - 1, af2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hKC.oZ(true);
                                PbActivity.this.hKC.oY(false);
                            }
                        }
                    } else if (PbActivity.this.hKO) {
                        PbActivity.this.hKO = false;
                        PbActivity.this.hKC.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hKC.bXv();
                    }
                    PbActivity.this.hKy.a(dVar.getForum(), PbActivity.this.hLr);
                    PbActivity.this.hKy.a(PbActivity.this.hLs);
                    if (PbActivity.this.gVY != null && dVar.bSx() != null && dVar.bSx().aex() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bSx().aex());
                        PbActivity.this.gVY.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hKK && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hKy != null && PbActivity.this.hKy.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hKy.getAppealInfo().hHn)) {
                                    PbActivity.this.hKC.a(PbActivity.this.hKy.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hKC.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hKC.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                            }
                            PbActivity.this.hKC.bXQ();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hKy.bVv());
                            jSONObject.put("fid", PbActivity.this.hKy.getForumId());
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
                        PbActivity.this.hKC.BZ("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                            arrayList = PbActivity.this.hKy.getPbData().bSz();
                        }
                        if (com.baidu.tbadk.core.util.v.Z(arrayList) != 0 && (com.baidu.tbadk.core.util.v.Z(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cpp() != 1)) {
                            PbActivity.this.hKC.BZ(PbActivity.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbActivity.this.bUF()) {
                            PbActivity.this.hKC.Ca(PbActivity.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbActivity.this.hKC.Ca(PbActivity.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbActivity.this.hKC.akE();
                }
                PbActivity.this.czV = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bTD().bVw() || PbActivity.this.bTD().getPbData().getPage().ads() != 0 || PbActivity.this.bTD().bVV()) {
                    PbActivity.this.hKS = true;
                    return;
                }
                return;
            }
            PbActivity.this.hKy.xT(1);
            if (PbActivity.this.hKd != null) {
                PbActivity.this.hKd.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hKC.m(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.p.m.avt().avu()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eXm : j;
                com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, PbActivity.this.czN, PbActivity.this.createTime, PbActivity.this.czV, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.czN = 0L;
                if (iVar != null) {
                    iVar.avq();
                }
                if (z2) {
                    iVar.cAe = currentTimeMillis;
                    iVar.fE(true);
                }
                if (!z2 && PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSx() != null) {
                    int threadType = PbActivity.this.hKy.getPbData().bSx().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.bV(PbActivity.this.hKq, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.bV(PbActivity.this.hKq, "from_frs")) {
                                com.baidu.tbadk.p.i iVar2 = new com.baidu.tbadk.p.i();
                                iVar2.kQ(1000);
                                iVar2.cAg = currentTimeMillis;
                                iVar2.kR(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.p.d dVar = new com.baidu.tbadk.p.d();
                        dVar.pageType = 1;
                        dVar.kQ(1005);
                        dVar.cAg = currentTimeMillis;
                        dVar.kR(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hLG = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bUd();
            }
        }
    };
    private final a.InterfaceC0238a hLH = new a.InterfaceC0238a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0238a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hKC.bXr();
            if (z) {
                if (PbActivity.this.hKA != null) {
                    PbActivity.this.hKA.dx(z2);
                }
                PbActivity.this.hKy.oE(z2);
                if (PbActivity.this.hKy.aaB()) {
                    PbActivity.this.bUn();
                } else {
                    PbActivity.this.hKC.m(PbActivity.this.hKy.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hKA != null && PbActivity.this.hKA.aaE() != null && PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().aex() != null) {
                        MarkData aaE = PbActivity.this.hKA.aaE();
                        MetaData aex = PbActivity.this.hKy.getPbData().bSx().aex();
                        if (aaE != null && aex != null) {
                            if (!com.baidu.tbadk.core.util.aq.bV(TbadkCoreApplication.getCurrentAccount(), aex.getUserId()) && !aex.hadConcerned()) {
                                PbActivity.this.b(aex);
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
            if (!PbActivity.this.xH(PbActivity.this.mLastScrollState) && PbActivity.this.xH(i)) {
                if (PbActivity.this.hKC != null) {
                    PbActivity.this.hKC.bXH();
                    if (PbActivity.this.hKR != null && !PbActivity.this.hKC.bWV()) {
                        PbActivity.this.hKC.oW(PbActivity.this.hKR.asF());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hKC.bWU();
                    }
                }
                if (!PbActivity.this.hKk) {
                    PbActivity.this.hKk = true;
                    PbActivity.this.hKC.bXM();
                }
            }
            PbActivity.this.hKC.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hKd != null) {
                PbActivity.this.hKd.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hKl == null) {
                PbActivity.this.hKl = new com.baidu.tbadk.p.b();
                PbActivity.this.hKl.kQ(1001);
            }
            if (i == 0) {
                PbActivity.this.hKl.avk();
            } else {
                PbActivity.this.hKl.avj();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.coo().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bSz;
            if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKC != null && PbActivity.this.hKC.bXl() != null) {
                PbActivity.this.hKC.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hKd != null) {
                    PbActivity.this.hKd.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hKy.bVQ() && (bSz = PbActivity.this.hKy.getPbData().bSz()) != null && !bSz.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hKC.bXl().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hKy.getPbData();
                    if (pbData != null) {
                        if (pbData.bSA() != null && pbData.bSA().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bSB() != null && pbData.bSB().hasData()) {
                            headerCount--;
                        }
                        int size = bSz.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eDz = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eDv.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hKy.bVO();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iaL != 1002 || bVar.fYQ) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hKC.a(1, dVar.FU, dVar.jhE, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eDv.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hKC.a(PbActivity.this.eDv.getLoadDataMode(), gVar.FU, gVar.jhE, false);
                        PbActivity.this.hKC.ax(gVar.jhH);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hKC.a(PbActivity.this.eDv.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hLI = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final h.c cZg = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (PbActivity.this.bUt()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hKy.oD(true)) {
                PbActivity.this.hKC.bXs();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fOa = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hLJ && PbActivity.this.bUt()) {
                PbActivity.this.bUv();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hKy.oC(false)) {
                    PbActivity.this.hKC.bXq();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hKy.getPbData() != null) {
                    PbActivity.this.hKC.bXL();
                }
                PbActivity.this.hLJ = true;
            }
        }
    };
    private int hLK = 0;
    private final TbRichTextView.h cKh = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bXl;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hKy != null) {
                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                        anVar.bT("tid", PbActivity.this.hKy.bVv());
                        anVar.bT("fid", PbActivity.this.hKy.getForumId());
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
                        PbActivity.this.hKu = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hMA) {
                        TbRichText be = PbActivity.this.be(str, i);
                        if (be != null && PbActivity.this.hLK >= 0 && PbActivity.this.hLK < be.ayL().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(be.ayL().get(PbActivity.this.hLK));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hMx.size()) {
                                    break;
                                } else if (!cVar.hMx.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (be.getPostId() != 0 && (bXl = PbActivity.this.hKC.bXl()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bXl.getDataList();
                                if (com.baidu.tbadk.core.util.v.Z(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && be.getPostId() == com.baidu.adp.lib.g.b.c(((PostData) next).getId(), 0L)) {
                                            if (be.getPostId() != com.baidu.adp.lib.g.b.c(PbActivity.this.hKy.bWb(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hKy.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.aa(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hMy.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hMz, cVar.lastId, PbActivity.this.hKy.bVL(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.o(rect);
                            createConfig.setIsHotSort(PbActivity.this.hKy.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hMx, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.aa(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hMy.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hMz, cVar.hMx.get(0), PbActivity.this.hKy.bVL(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hKy.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hKC.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hLL = false;
    PostData gnc = null;
    private final b.a hLM = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.gnc != null) {
                if (i == 0) {
                    PbActivity.this.gnc.el(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.gnc = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.gnc);
                }
            }
        }
    };
    private final b.a hLN = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hLb != null && !TextUtils.isEmpty(PbActivity.this.hLc)) {
                if (i == 0) {
                    if (PbActivity.this.hLd == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hLc));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hLc;
                        aVar.pkgId = PbActivity.this.hLd.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hLd.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.mPermissionJudgement.ajQ();
                    PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.ad(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fVB == null) {
                            PbActivity.this.fVB = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fVB.h(PbActivity.this.hLc, PbActivity.this.hLb.nN());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hLb = null;
                PbActivity.this.hLc = null;
            }
        }
    };
    private final View.OnLongClickListener cmy = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        /* JADX WARN: Removed duplicated region for block: B:27:0x0099 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01eb  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            String str;
            boolean on;
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
                if (PbActivity.this.cx(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.hLb = ((TbImageView) view).getBdImage();
                        PbActivity.this.hLc = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hLb == null || TextUtils.isEmpty(PbActivity.this.hLc)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hLd = null;
                        } else {
                            PbActivity.this.hLd = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hLb = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hLc = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hLd = null;
                            } else {
                                PbActivity.this.hLd = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hLb = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hLc = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hLd = null;
                        } else {
                            PbActivity.this.hLd = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbActivity.this.hKC.a(PbActivity.this.hLN, PbActivity.this.hLb.isGif());
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
            PbActivity.this.gnc = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbActivity.this.gnc == null) {
                return true;
            }
            if (PbActivity.this.gnc.cpp() != 1 || !PbActivity.this.cx(view)) {
                if (PbActivity.this.hKA != null) {
                    if (!PbActivity.this.hKA.aaB() || PbActivity.this.gnc.getId() == null || !PbActivity.this.gnc.getId().equals(PbActivity.this.hKy.aeG())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.gnc.cpp() == 1) {
                        PbActivity.this.hKC.a(PbActivity.this.hLM, z, false);
                        return true;
                    }
                    if (PbActivity.this.hKJ == null) {
                        PbActivity.this.hKJ = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                        PbActivity.this.hKJ.a(PbActivity.this.hLO);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cx = PbActivity.this.cx(view);
                        boolean z3 = (!PbActivity.this.cx(view) || PbActivity.this.hLb == null || PbActivity.this.hLb.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hKJ);
                            gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                            gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                            gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(gVar3);
                        }
                        if (cx) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbActivity.this.getString(R.string.save_to_emotion), PbActivity.this.hKJ));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbActivity.this.getString(R.string.save_to_local), PbActivity.this.hKJ));
                        }
                        if (!cx && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hKJ);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(R.id.tag_clip_board, PbActivity.this.gnc);
                            gVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(gVar4);
                        }
                        if (!z4) {
                            if (z) {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hKJ);
                            } else {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hKJ);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(R.id.tag_clip_board, PbActivity.this.gnc);
                            sparseArray4.put(R.id.tag_is_subpb, false);
                            gVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(gVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hKJ);
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
                                if (!ap.m(PbActivity.this.gnc)) {
                                    on = PbActivity.this.on(z5) & PbActivity.this.isLogin();
                                } else {
                                    on = false;
                                }
                                if (on) {
                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hKJ);
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
                                    gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hKJ);
                                    gVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(R.id.tag_should_delete_visible, false);
                                }
                                gVar = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hKJ);
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
                                    if (PbActivity.this.hKy.getPbData().bSJ() == 1002 && !z5) {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hKJ);
                                    } else {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hKJ);
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
                        PbActivity.this.hKJ.W(arrayList);
                        PbActivity.this.hKI = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hKJ.ahb());
                        PbActivity.this.hKI.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").bT("tid", PbActivity.this.hKy.hPC).bT("fid", PbActivity.this.hKy.getForumId()).bT("uid", PbActivity.this.hKy.getPbData().bSx().aex().getUserId()).bT("post_id", PbActivity.this.hKy.asu()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hKC.a(PbActivity.this.hLN, PbActivity.this.hLb.isGif());
            return true;
        }
    };
    private k.c hLO = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbActivity.this.hKI != null) {
                PbActivity.this.hKI.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hKy.getPbData();
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
                    if (PbActivity.this.hLb != null && !TextUtils.isEmpty(PbActivity.this.hLc)) {
                        if (PbActivity.this.hLd == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hLc));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hLc;
                            aVar.pkgId = PbActivity.this.hLd.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hLd.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hLb = null;
                        PbActivity.this.hLc = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hLb != null && !TextUtils.isEmpty(PbActivity.this.hLc)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.ajQ();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.ad(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fVB == null) {
                                PbActivity.this.fVB = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fVB.h(PbActivity.this.hLc, PbActivity.this.hLb.nN());
                            PbActivity.this.hLb = null;
                            PbActivity.this.hLc = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.gnc != null) {
                        PbActivity.this.gnc.el(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.gnc = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").P("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.cw(view);
                        if (PbActivity.this.hKy.getPbData().bSx() != null && PbActivity.this.hKy.getPbData().bSx().aex() != null && PbActivity.this.hKy.getPbData().bSx().aex().getUserId() != null && PbActivity.this.hKA != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bT("tid", PbActivity.this.hKy.hPC).P("obj_locate", 2).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hKy.getPbData().bSx().aex().getUserId()).P("obj_type", PbActivity.this.hKA.aaB() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hKy.getPbData())));
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
                        PbActivity.this.BO((String) tag);
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
                        PbActivity.this.hKC.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbActivity.this.hKC.cD(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hKC.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a fru = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (!PbActivity.this.hKf && z && !PbActivity.this.hKy.bVC()) {
                PbActivity.this.bUp();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener cmp = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.eab.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0305a eac = new a.InterfaceC0305a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        final int ekN;

        {
            this.ekN = (int) PbActivity.this.getResources().getDimension(R.dimen.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            if (ax(i2) && PbActivity.this.hKC != null && PbActivity.this.hKd != null) {
                PbActivity.this.hKC.bXR();
                PbActivity.this.hKd.kl(false);
                PbActivity.this.hKd.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            if (ax(i2) && PbActivity.this.hKC != null && PbActivity.this.hKd != null) {
                PbActivity.this.hKd.kl(true);
                if (Math.abs(i2) > this.ekN) {
                    PbActivity.this.hKd.hideFloatingView();
                }
                if (PbActivity.this.bUt()) {
                    PbActivity.this.hKC.bXi();
                    PbActivity.this.hKC.bXj();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void ba(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String hLQ = null;
    private final m.a hLR = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hLQ = str2;
                PbActivity.this.hKC.Cb(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hLS = -1;
    private int hLT = -1;
    private CustomMessageListener hLW = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bEi == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0240a) {
                    if (aVar.bEj != null && !aVar.bEj.hasError() && aVar.bEj.getError() == 0) {
                        if (PbActivity.this.hKC != null) {
                            PbActivity.this.hKC.q(((a.C0240a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bUE();
                        }
                    } else if (z) {
                        if (aVar.bEj != null && aVar.bEj.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bEj.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bEj != null && !aVar.bEj.hasError() && aVar.bEj.getError() == 0) {
                        if (PbActivity.this.hKC != null && PbActivity.this.hKC != null) {
                            PbActivity.this.hKC.q(((a.C0240a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bEj != null && aVar.bEj.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bEj.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bEj == null || aVar.bEj.hasError() || aVar.bEj.getError() != 0) {
                        if (z) {
                            if (aVar.bEj != null && aVar.bEj.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bEj.getErrorString());
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
        public boolean hMA;
        public ArrayList<String> hMx;
        public ConcurrentHashMap<String, ImageUrlData> hMy;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hMz = false;
        public boolean hMB = false;
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

    public com.baidu.tbadk.editortools.pb.d bTQ() {
        return this.hKR;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        boolean z = true;
        if (kVar.bTg() != null) {
            String id = kVar.bTg().getId();
            ArrayList<PostData> bSz = this.hKy.getPbData().bSz();
            int i = 0;
            while (true) {
                if (i >= bSz.size()) {
                    break;
                }
                PostData postData = bSz.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bTk = kVar.bTk();
                    postData.Bd(kVar.getTotalCount());
                    if (postData.cpm() != null && bTk != null) {
                        Iterator<PostData> it = bTk.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aex() != null && (metaData = postData.getUserMap().get(next.aex().getUserId())) != null) {
                                next.a(metaData);
                                next.rd(true);
                                next.a(getPageContext(), this.hKy.BU(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bTk.size() != postData.cpm().size();
                        postData.cpm().clear();
                        postData.cpm().addAll(bTk);
                        z = z2;
                    }
                    if (postData.cpi() != null) {
                        postData.cpj();
                    }
                }
            }
            if (!this.hKy.getIsFromMark() && z) {
                this.hKC.m(this.hKy.getPbData());
            }
            if (z) {
                c(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BM(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bSM = this.hKy.getPbData().bSM();
            if (bSM != null && str.equals(bSM.getAdId())) {
                if (bSM.cpd() != null) {
                    bSM.cpd().legoCard = null;
                }
                this.hKy.getPbData().bSN();
            }
            com.baidu.tieba.tbadkCore.data.m bVG = this.hKy.bVG();
            if (bVG != null && str.equals(bVG.getAdId())) {
                this.hKy.bVH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.hKI != null && this.hKI.isShowing()) {
                this.hKI.dismiss();
                this.hKI = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this);
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbActivity.this.hKI != null) {
                            PbActivity.this.hKI.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hKC.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbActivity.this.hKZ);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hKZ);
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
                this.hKI = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar.ahb());
                this.hKI.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(int i) {
        bg bSx;
        if (this.hKy != null && this.hKy.getPbData() != null && (bSx = this.hKy.getPbData().bSx()) != null) {
            if (i == 1) {
                PraiseData aej = bSx.aej();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aej == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bSx.a(praiseData);
                    } else {
                        bSx.aej().getUser().add(0, metaData);
                        bSx.aej().setNum(bSx.aej().getNum() + 1);
                        bSx.aej().setIsLike(i);
                    }
                }
                if (bSx.aej() != null) {
                    if (bSx.aej().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.aM(bSx.aej().getNum());
                    }
                }
            } else if (bSx.aej() != null) {
                bSx.aej().setIsLike(i);
                bSx.aej().setNum(bSx.aej().getNum() - 1);
                ArrayList<MetaData> user = bSx.aej().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bSx.aej().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bSx.aej().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = bSx.aej().getNum() + "";
                }
            }
            if (this.hKy.bVw()) {
                this.hKC.bXl().notifyDataSetChanged();
            } else {
                this.hKC.n(this.hKy.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hKy.ab(bundle);
        if (this.ftO != null) {
            this.ftO.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hKR.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hKj = System.currentTimeMillis();
        this.hKX = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eXm = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hKq = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hKq) && intent.getData() != null) {
                this.hKq = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hKq)) {
                this.hKe = true;
            }
            this.hLS = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hLT = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hLU = intent.getStringExtra("key_manga_title");
            this.hKM = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hKN = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hKO = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bUt()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.hLf = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.eXm = System.currentTimeMillis();
        }
        this.czN = this.hKj - this.eXm;
        super.onCreate(bundle);
        this.hKh = 0;
        aa(bundle);
        if (this.hKy != null && this.hKy.getPbData() != null) {
            this.hKy.getPbData().BK(this.source);
        }
        initUI();
        if (intent != null && this.hKC != null) {
            this.hKC.hTn = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hLa == null) {
                    this.hLa = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hKC.Cd("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hLa, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hKy != null && this.hKy.getPbData() != null) {
                this.hKy.BX(stringExtra);
            }
        }
        this.ftO = new VoiceManager();
        this.ftO.onCreate(getPageContext());
        initData(bundle);
        this.hKQ = new com.baidu.tbadk.editortools.pb.f();
        bTR();
        this.hKR = (com.baidu.tbadk.editortools.pb.d) this.hKQ.cK(getActivity());
        this.hKR.b(this);
        this.hKR.a(this.ctR);
        this.hKR.a(this.ctK);
        this.hKR.a(this, bundle);
        this.hKR.arY().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hKR.arY().fh(true);
        om(true);
        this.hKC.setEditorTools(this.hKR.arY());
        this.hKR.a(this.hKy.bVI(), this.hKy.bVv(), this.hKy.bWb());
        registerListener(this.hLm);
        if (!this.hKy.bVB()) {
            this.hKR.qq(this.hKy.bVv());
        }
        if (this.hKy.bWc()) {
            this.hKR.qo(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.hKC != null) {
            this.hKR.qo(this.hKC.bWW());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hLl);
        registerListener(this.hLn);
        registerListener(this.hLo);
        registerListener(this.fvj);
        registerListener(this.hLC);
        registerListener(this.hLk);
        this.hKP = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.jew);
        this.hKP.coQ();
        registerListener(this.hLq);
        registerListener(this.mAttentionListener);
        if (this.hKy != null) {
            this.hKy.bVT();
        }
        registerListener(this.hLG);
        registerListener(this.hLW);
        registerListener(this.fvq);
        if (this.hKC != null && this.hKC.bXV() != null && this.hKC.bXW() != null) {
            this.hKd = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hKC.bXV(), this.hKC.bXW(), this.hKC.bXc());
            this.hKd.a(this.hLy);
        }
        if (this.hKc && this.hKC != null && this.hKC.bXW() != null) {
            this.hKC.bXW().setVisibility(8);
        }
        this.hKY = new com.baidu.tbadk.core.view.e();
        this.hKY.bYI = 1000L;
        registerListener(this.hLB);
        registerListener(this.hLz);
        registerListener(this.hLA);
        registerListener(this.fKY);
        registerListener(this.fvg);
        this.hKZ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hKZ;
        userMuteAddAndDelCustomMessage.setTag(this.hKZ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hKZ;
        userMuteCheckCustomMessage.setTag(this.hKZ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hKy.bVZ().a(this.dZs);
        this.hKH = new as();
        if (this.hKR.asy() != null) {
            this.hKH.k(this.hKR.asy().getInputView());
        }
        this.hKR.a(this.ctL);
        this.fJN = new ShareSuccessReplyToServerModel();
        a(this.hLh);
        this.gVY = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gVY.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bTh) {
                        PbActivity.this.hKR.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bTi && PbActivity.this.hKC != null && PbActivity.this.hKC.bWT() != null && PbActivity.this.hKC.bWT().bVm() != null) {
                        PbActivity.this.hKC.bWT().bVm().asR();
                    } else if (i == com.baidu.tbadk.core.util.aj.bTj) {
                        PbActivity.this.c(PbActivity.this.hKU);
                    }
                }
            }
        });
        this.hKz = new com.baidu.tieba.pb.pb.report.a(this);
        this.hKz.r(getUniqueId());
        com.baidu.tieba.q.c.coo().u(getUniqueId());
        com.baidu.tbadk.core.business.a.acs().bB("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.kd() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
        }
        this.createTime = System.currentTimeMillis() - this.hKj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTR() {
        if (this.hKQ != null && this.hKy != null) {
            this.hKQ.setForumName(this.hKy.bTu());
            if (this.hKy.getPbData() != null && this.hKy.getPbData().getForum() != null) {
                this.hKQ.a(this.hKy.getPbData().getForum());
            }
            this.hKQ.setFrom("pb");
            this.hKQ.a(this.hKy);
        }
    }

    public String bTS() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bTT() {
        return this.hKd;
    }

    private void om(boolean z) {
        this.hKR.fl(z);
        this.hKR.fm(z);
        this.hKR.fn(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSV() && !z && this.hKC != null && this.hKC.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.hKC.getView().setSystemUiVisibility(4);
        }
        this.hKV = z;
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
        if (this.ftO != null) {
            this.ftO.onStart(getPageContext());
        }
    }

    public aq bTU() {
        return this.hKC;
    }

    public PbModel bTD() {
        return this.hKy;
    }

    public void BN(String str) {
        if (this.hKy != null && !StringUtils.isNull(str) && this.hKC != null) {
            this.hKC.pb(true);
            this.hKy.BN(str);
            this.hKp = true;
            this.hKC.bXH();
            this.hKC.bXQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hKf = false;
        } else {
            this.hKf = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hKh = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hKh == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.ftO != null) {
            this.ftO.onPause(getPageContext());
        }
        if (this.hKC != null) {
            this.hKC.onPause();
        }
        if (!this.hKy.bVB()) {
            this.hKR.qp(this.hKy.bVv());
        }
        if (this.hKy != null) {
            this.hKy.bVU();
        }
        com.baidu.tbadk.BdToken.c.Zg().Zl();
        MessageManager.getInstance().unRegisterListener(this.gzX);
        byh();
        MessageManager.getInstance().unRegisterListener(this.hLz);
        MessageManager.getInstance().unRegisterListener(this.hLA);
        MessageManager.getInstance().unRegisterListener(this.hLB);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bTV() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hKy.getPbData(), this.hKy.bVw(), this.hKy.bVR());
        return (a2 == null || a2.aex() == null || a2.aex().getGodUserData() == null || a2.aex().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hKf = false;
        super.onResume();
        if (this.hKs) {
            this.hKs = false;
            bUz();
        }
        if (bTV()) {
            this.hKm = System.currentTimeMillis();
        } else {
            this.hKm = -1L;
        }
        if (this.hKC != null && this.hKC.getView() != null) {
            if (!this.hnA) {
                bUq();
            } else {
                hideLoadingView(this.hKC.getView());
            }
            this.hKC.onResume();
        }
        if (this.hKh == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hKC != null) {
            noNetworkView = this.hKC.bWQ();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kc()) {
            noNetworkView.eo(false);
        }
        if (this.ftO != null) {
            this.ftO.onResume(getPageContext());
        }
        registerListener(this.gzX);
        this.hKL = false;
        bUy();
        registerListener(this.hLz);
        registerListener(this.hLA);
        registerListener(this.hLB);
        if (this.fuD) {
            bUp();
            this.fuD = false;
        }
        bUH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hKC.oQ(z);
        if (this.hKI != null) {
            this.hKI.dismiss();
        }
        if (z && this.hKL) {
            this.hKC.bXq();
            this.hKy.oC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hKm > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").bT("obj_duration", (System.currentTimeMillis() - this.hKm) + ""));
            this.hKm = 0L;
        }
        if (bTU().bWT() != null) {
            bTU().bWT().onStop();
        }
        if (this.hKC.hTu != null && !this.hKC.hTu.bax()) {
            this.hKC.hTu.bJF();
        }
        if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().getForum() != null && this.hKy.getPbData().bSx() != null) {
            com.baidu.tbadk.distribute.a.arL().a(getPageContext().getPageActivity(), "pb", this.hKy.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hKy.getPbData().bSx().getId(), 0L));
        }
        if (this.ftO != null) {
            this.ftO.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.coo().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bT("fid", this.hKy.getPbData().getForumId());
            anVar.bT("tid", this.hKy.bVv());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hKk && this.hKC != null) {
            this.hKk = true;
            this.hKC.bXM();
            a(false, (PostData) null);
        }
        if (this.hKy != null) {
            this.hKy.cancelLoadData();
            this.hKy.destory();
            if (this.hKy.bVY() != null) {
                this.hKy.bVY().onDestroy();
            }
        }
        if (this.hKR != null) {
            this.hKR.onDestroy();
        }
        if (this.eDv != null) {
            this.eDv.cancelLoadData();
        }
        if (this.hKC != null) {
            this.hKC.onDestroy();
            if (this.hKC.hTu != null) {
                this.hKC.hTu.bJF();
            }
        }
        if (this.hKl != null) {
            this.hKl.avl();
        }
        if (this.hKd != null) {
            this.hKd.awv();
        }
        super.onDestroy();
        if (this.ftO != null) {
            this.ftO.onDestory(getPageContext());
        }
        this.hKC.bXH();
        MessageManager.getInstance().unRegisterListener(this.hLz);
        MessageManager.getInstance().unRegisterListener(this.hLA);
        MessageManager.getInstance().unRegisterListener(this.hLB);
        MessageManager.getInstance().unRegisterListener(this.hKZ);
        MessageManager.getInstance().unRegisterListener(this.hLC);
        MessageManager.getInstance().unRegisterListener(this.fvq);
        MessageManager.getInstance().unRegisterListener(this.fKY);
        MessageManager.getInstance().unRegisterListener(this.hLE);
        this.hKX = null;
        this.hKY = null;
        com.baidu.tieba.recapp.d.a.cit().civ();
        if (this.hLa != null) {
            getSafeHandler().removeCallbacks(this.hLa);
        }
        if (this.hKt != null) {
            this.hKt.cancelLoadData();
        }
        if (this.hKC != null && this.hKC.hTu != null) {
            this.hKC.hTu.bYI();
        }
        if (this.fJN != null) {
            this.fJN.cancelLoadData();
        }
        this.hKH.onDestroy();
        if (this.hKy != null && this.hKy.bWa() != null) {
            this.hKy.bWa().onDestroy();
        }
        if (this.gVY != null) {
            this.gVY.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bXl;
        ArrayList<PostData> bUX;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.amb() && this.hKC != null && (bXl = this.hKC.bXl()) != null && (bUX = bXl.bUX()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bUX.iterator();
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
                        bVar.eFr = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.bKB == 1 && !TextUtils.isEmpty(id)) {
                    next.bKB = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.eFr = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hKy == null || this.hKy.getPbData() == null || this.hKy.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hKy.getPbData().getForum().getFirst_class();
                    str2 = this.hKy.getPbData().getForum().getSecond_class();
                    str = this.hKy.getPbData().getForum().getId();
                    str4 = this.hKy.bVv();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.ame());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.hKC.onChangeSkinType(i);
            if (this.hKR != null && this.hKR.arY() != null) {
                this.hKR.arY().onChangeSkinType(i);
            }
            if (this.hKC.bWQ() != null) {
                this.hKC.bWQ().onChangeSkinType(getPageContext(), i);
            }
            this.hKH.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.a(i, getResources(), (int) R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hKC = new aq(this, this.fvY, this.clt);
        this.eab = new com.baidu.tieba.f.b(getActivity());
        this.eab.a(hLP);
        this.eab.a(this.eac);
        this.hKC.setOnScrollListener(this.mOnScrollListener);
        this.hKC.e(this.fOa);
        this.hKC.setListPullRefreshListener(this.cZg);
        this.hKC.og(com.baidu.tbadk.core.i.aca().ace());
        this.hKC.setOnImageClickListener(this.cKh);
        this.hKC.b(this.cmy);
        this.hKC.h(this.fru);
        this.hKC.a(this.hLI);
        this.hKC.oQ(this.mIsLogin);
        if (getIntent() != null) {
            this.hKC.pc(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hKC.bWS().setFromForumId(this.hKy.getFromForumId());
    }

    public void bTW() {
        if (this.hKC != null && this.hKy != null) {
            if ((this.hKy.getPbData() != null || this.hKy.getPbData().bSU() != null) && checkUpIsLogin() && this.hKC.bXl() != null && this.hKC.bXl().bVc() != null) {
                this.hKC.bXl().bVc().oS(this.hKy.bVv());
            }
        }
    }

    public void bTX() {
        TiebaStatic.log("c12181");
        if (this.hKC != null && this.hKy != null) {
            if (this.hKC == null || this.hKC.bWV()) {
                if (this.hKy.getPbData() != null || this.hKy.getPbData().bSU() != null) {
                    com.baidu.tieba.pb.data.j bSU = this.hKy.getPbData().bSU();
                    if (checkUpIsLogin()) {
                        if ((!bSU.bTd() || bSU.afT() != 2) && this.hKC.bXl() != null && this.hKC.bXl().bVc() != null) {
                            this.hKC.bXl().bVc().oS(this.hKy.bVv());
                        }
                        if (System.currentTimeMillis() - this.hKo > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).pv(false);
                            this.hKo = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cv(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.jeY && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.aca().ace()) {
                    return BQ(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hKy == null || this.hKy.getPbData() == null) {
                        return true;
                    }
                    if (bTU().bWT() != null) {
                        bTU().bWT().bVi();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.hKy.getPbData().getForum());
                    kVar.ai(this.hKy.getPbData().bSx());
                    kVar.e(postData);
                    bTU().bWS().d(kVar);
                    bTU().bWS().setPostId(postData.getId());
                    a(view, postData.aex().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hKR != null) {
                        this.hKC.oW(this.hKR.asF());
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
        if (this.hKC != null) {
            if (z && !this.hnA) {
                bUq();
            } else {
                hideLoadingView(this.hKC.getView());
            }
            if (z && this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSV() && this.hKC.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                this.hKC.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bTY() {
        if (this.hKi == null) {
            this.hKi = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hKi.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hJX = PbActivity.this.hJX.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hJX);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hKy.bVv(), PbActivity.this.hJX, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hJX = PbActivity.this.hJX.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hJX);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hKy.bVv(), PbActivity.this.hJX, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hJX = PbActivity.this.hJX.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hJX);
                        bVar.dismiss();
                    }
                }
            }).hz(R.style.dialog_ani_b2t).hA(17).d(getPageContext());
        }
    }

    private void aa(Bundle bundle) {
        this.hKy = new PbModel(this);
        this.hKy.a(this.hLF);
        if (this.hKy.bVX() != null) {
            this.hKy.bVX().a(this.hLR);
        }
        if (this.hKy.bVW() != null) {
            this.hKy.bVW().a(this.hLp);
        }
        if (this.hKy.bVY() != null) {
            this.hKy.bVY().b(this.hLj);
        }
        if (bundle != null) {
            this.hKy.initWithBundle(bundle);
        } else {
            this.hKy.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hKy.oF(true);
        }
        aj.bWF().au(this.hKy.bVt(), this.hKy.getIsFromMark());
        if (StringUtils.isNull(this.hKy.bVv())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hKq) && this.hKq != null) {
            this.hKy.ya(6);
        }
        this.hKy.auD();
    }

    private void initData(Bundle bundle) {
        this.hKA = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hKA != null) {
            this.hKA.a(this.hLH);
        }
        this.eDv = new ForumManageModel(this);
        this.eDv.setLoadDataCallBack(this.eDz);
        this.bTm = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hKC.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kc()) {
                    PbActivity.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hKy.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKy.getPbData().getForum().getId(), PbActivity.this.hKy.getPbData().getForum().getName(), PbActivity.this.hKy.getPbData().bSx().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hLv.setUniqueId(getUniqueId());
        this.hLv.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hKC.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hKZ;
        userMuteCheckCustomMessage.setTag(this.hKZ);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bTZ() {
        if (checkUpIsLogin()) {
            if (this.fxt == null) {
                this.fxt = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fxt.sA(0);
                this.fxt.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void kf(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void n(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void kg(boolean z) {
                        if (z) {
                            PbActivity.this.hKC.bxt();
                        }
                    }
                });
            }
            if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().getForum() != null) {
                this.fxt.t(this.hKy.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hKy.bVv(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bUa() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hKy != null && (pbData = this.hKy.getPbData()) != null) {
            return pbData.bSI().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bSx() != null) {
            if (dVar.bSx().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bSx().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bSx().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bUb()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hKv);
                this.hKw = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hKT == null) {
                this.hKT = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hKT.sA(1);
                this.hKT.a(new AnonymousClass40(str, str2));
            }
            if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().getForum() != null) {
                this.hKT.t(this.hKy.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hKy.bVv(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$40  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String hMg;
        final /* synthetic */ String hMh;

        AnonymousClass40(String str, String str2) {
            this.hMg = str;
            this.hMh = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kf(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kg(boolean z) {
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
                        PbActivity.this.bTU().getListView().smoothScrollBy((PbActivity.this.hKv[1] + PbActivity.this.hKw) - (ah - g), 50);
                        if (PbActivity.this.bTU().bWT() != null) {
                            PbActivity.this.hKR.arY().setVisibility(8);
                            PbActivity.this.bTU().bWT().Y(AnonymousClass40.this.hMg, AnonymousClass40.this.hMh, PbActivity.this.bTU().bWW());
                            com.baidu.tbadk.editortools.pb.g bVm = PbActivity.this.bTU().bWT().bVm();
                            if (bVm != null && PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                                bVm.a(PbActivity.this.hKy.getPbData().getAnti());
                            }
                            if (PbActivity.this.hKH.bYj() == null && PbActivity.this.bTU().bWT().bVm().asZ() != null) {
                                PbActivity.this.bTU().bWT().bVm().asZ().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hKH != null && PbActivity.this.hKH.bYi() != null) {
                                            if (!PbActivity.this.hKH.bYi().czh()) {
                                                PbActivity.this.hKH.pe(false);
                                            }
                                            PbActivity.this.hKH.bYi().sa(false);
                                        }
                                    }
                                });
                                PbActivity.this.hKH.l(PbActivity.this.bTU().bWT().bVm().asZ().getInputView());
                                PbActivity.this.bTU().bWT().bVm().a(PbActivity.this.hKW);
                            }
                        }
                        PbActivity.this.bTU().bXQ();
                    }
                }, 0L);
            }
        }
    }

    public boolean bUb() {
        if (this.gVY == null || this.hKy.getPbData() == null || this.hKy.getPbData().getAnti() == null) {
            return true;
        }
        return this.gVY.m19if(this.hKy.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean xJ(int i) {
        if (this.gVY == null || this.hKy.getPbData() == null || this.hKy.getPbData().getAnti() == null) {
            return true;
        }
        return this.gVY.U(this.hKy.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.hKy != null && this.hKy.getPbData() != null && postData.cpp() != 1) {
            String bVv = this.hKy.bVv();
            String id = postData.getId();
            int bSJ = this.hKy.getPbData() != null ? this.hKy.getPbData().bSJ() : 0;
            c BR = BR(id);
            if (BR != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bVv, id, "pb", true, null, false, null, bSJ, postData.bZx(), this.hKy.getPbData().getAnti(), false, postData.aex() != null ? postData.aex().getIconInfo() : null).addBigImageData(BR.hMx, BR.hMy, BR.hMz, BR.index);
                addBigImageData.setKeyPageStartFrom(this.hKy.bWe());
                addBigImageData.setFromFrsForumId(this.hKy.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bUc() {
        if (this.hKy.getPbData() == null || this.hKy.getPbData().bSx() == null) {
            return -1;
        }
        return this.hKy.getPbData().bSx().afh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUd() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Ef(this.hKy.getForumId()) && this.hKy.getPbData() != null && this.hKy.getPbData().getForum() != null) {
            if (this.hKy.getPbData().getForum().isLike() == 1) {
                this.hKy.bWa().ee(this.hKy.getForumId(), this.hKy.bVv());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean on(boolean z) {
        if (this.hKy == null || this.hKy.getPbData() == null) {
            return false;
        }
        return ((this.hKy.getPbData().bSJ() != 0) || this.hKy.getPbData().bSx() == null || this.hKy.getPbData().bSx().aex() == null || TextUtils.equals(this.hKy.getPbData().bSx().aex().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bUe() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.t.y.avR()) {
            return "";
        }
        PostData bSE = bSE();
        if (this.hKy == null || (pbData = this.hKy.getPbData()) == null || pbData.getUserData() == null || pbData.bSx() == null || bSE == null || bSE.aex() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bSE.aex().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bSx().aee() == 0) {
            return "";
        }
        if (pbData.bSx().aee() == 0) {
            return getPageContext().getString(R.string.fans_call);
        }
        return getPageContext().getString(R.string.haved_fans_call);
    }

    private boolean oo(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.v vVar;
        if (z) {
            return true;
        }
        if (this.hKy == null || this.hKy.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hKy.getPbData();
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.bSJ() != 0) {
                return pbData.bSJ() != 3;
            }
            List<bc> bSS = pbData.bSS();
            if (com.baidu.tbadk.core.util.v.Z(bSS) > 0) {
                for (bc bcVar : bSS) {
                    if (bcVar != null && (vVar = bcVar.bIR) != null && vVar.bGK && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
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

    private boolean op(boolean z) {
        if (z || this.hKy == null || this.hKy.getPbData() == null) {
            return false;
        }
        return ((this.hKy.getPbData().getForum() != null && this.hKy.getPbData().getForum().isBlockBawuDelete) || this.hKy.getPbData().bSJ() == 0 || this.hKy.getPbData().bSJ() == 3) ? false : true;
    }

    public void bUf() {
        if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSx() != null && this.hKy.getPbData().bSx().aex() != null) {
            if (this.hKC != null) {
                this.hKC.bWR();
            }
            bg bSx = this.hKy.getPbData().bSx();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bSx.aex().getUserId());
            ab abVar = new ab();
            int bSJ = this.hKy.getPbData().bSJ();
            if (bSJ == 1 || bSJ == 3) {
                abVar.hRF = true;
                abVar.hRE = true;
                abVar.hRM = bSx.aes() == 1;
                abVar.hRL = bSx.aet() == 1;
            } else {
                abVar.hRF = false;
                abVar.hRE = false;
            }
            if (bSJ == 1002 && !equals) {
                abVar.hRQ = true;
            }
            abVar.hRG = oo(equals);
            abVar.hRH = bUg();
            abVar.hRI = op(equals);
            abVar.oy = this.hKy.bVw();
            abVar.hRD = true;
            abVar.hRC = on(equals);
            abVar.hRO = bUe();
            abVar.hRB = equals && this.hKC.bXx();
            abVar.hRJ = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hRK = true;
            abVar.isHostOnly = this.hKy.getHostMode();
            abVar.hRN = true;
            if (bSx.aeO() == null) {
                abVar.hRP = true;
            } else {
                abVar.hRP = false;
            }
            this.hKC.hTu.a(abVar);
        }
    }

    private boolean bUg() {
        if (this.hKy != null && this.hKy.bVw()) {
            return this.hKy.getPageData() == null || this.hKy.getPageData().ads() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(View view) {
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

    public int bUh() {
        if (bTU() == null || bTU().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bTU().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.i) && ((com.baidu.tieba.pb.data.i) mVar).mType == com.baidu.tieba.pb.data.i.hIm) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bUi() {
        if (bTU() == null || bTU().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bTU().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.jeX) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.mN(getResources().getString(R.string.mark_done));
            aVar.dX(true);
            aVar.mO(getResources().getString(R.string.mark_like));
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
                    PbActivity.this.bTm.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hKy.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).agI();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hKC.bXr();
        this.hKy.oE(z);
        if (this.hKA != null) {
            this.hKA.dx(z);
            if (markData != null) {
                this.hKA.a(markData);
            }
        }
        if (this.hKy.aaB()) {
            bUn();
        } else {
            this.hKC.m(this.hKy.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xH(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO(String str) {
        this.hKz.Cm(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hKy.bVB()) {
                    antiData.setBlock_forum_name(this.hKy.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hKy.getPbData().getForum().getId());
                    antiData.setUser_name(this.hKy.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hKy.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bTU() != null) {
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").P("obj_locate", au.a.bUc));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").P("obj_locate", au.a.bUc));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").P("obj_locate", au.a.bUc));
            }
        } else if (i == 230277) {
            qv(str);
        } else {
            this.hKC.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.jhE) ? bVar.jhE : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mO(string);
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
                aVar.agI();
            } else {
                this.hKC.a(0, bVar.FU, bVar.jhE, z);
            }
            if (bVar.FU) {
                if (bVar.fau == 1) {
                    ArrayList<PostData> bSz = this.hKy.getPbData().bSz();
                    int size = bSz.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bSz.get(i).getId())) {
                            i++;
                        } else {
                            bSz.remove(i);
                            break;
                        }
                    }
                    this.hKy.getPbData().bSx().hi(this.hKy.getPbData().bSx().aeo() - 1);
                    this.hKC.m(this.hKy.getPbData());
                } else if (bVar.fau == 0) {
                    bUj();
                } else if (bVar.fau == 2) {
                    ArrayList<PostData> bSz2 = this.hKy.getPbData().bSz();
                    int size2 = bSz2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bSz2.get(i2).cpm().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bSz2.get(i2).cpm().get(i3).getId())) {
                                i3++;
                            } else {
                                bSz2.get(i2).cpm().remove(i3);
                                bSz2.get(i2).cpo();
                                z2 = true;
                                break;
                            }
                        }
                        bSz2.get(i2).EJ(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hKC.m(this.hKy.getPbData());
                    }
                    a(bVar, this.hKC);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hKC.a(this.eDv.getLoadDataMode(), gVar.FU, gVar.jhE, false);
            if (gVar.FU) {
                this.hKE = true;
                if (i == 2 || i == 3) {
                    this.hKF = true;
                    this.hKG = false;
                } else if (i == 4 || i == 5) {
                    this.hKF = false;
                    this.hKG = true;
                }
                if (i == 2) {
                    this.hKy.getPbData().bSx().hl(1);
                    this.hKy.setIsGood(1);
                } else if (i == 3) {
                    this.hKy.getPbData().bSx().hl(0);
                    this.hKy.setIsGood(0);
                } else if (i == 4) {
                    this.hKy.getPbData().bSx().hk(1);
                    this.hKy.pU(1);
                } else if (i == 5) {
                    this.hKy.getPbData().bSx().hk(0);
                    this.hKy.pU(0);
                }
                this.hKC.d(this.hKy.getPbData(), this.hKy.bVw());
            }
        }
    }

    private void bUj() {
        if (this.hKy.bVx() || this.hKy.bVz()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hKy.bVv());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hKy.bVv()));
        if (bUo()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUk() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bSG;
        boolean z = false;
        if (this.hKC != null) {
            this.hKC.bXH();
        }
        if (this.hKy != null && this.hKy.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hKy.getPbData().bSx().getId();
            if (this.hKy.isShareThread() && this.hKy.getPbData().bSx().bLQ != null) {
                historyMessage.threadName = this.hKy.getPbData().bSx().bLQ.showText;
            } else {
                historyMessage.threadName = this.hKy.getPbData().bSx().getTitle();
            }
            if (this.hKy.isShareThread() && !bTt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hKy.getPbData().getForum().getName();
            }
            ArrayList<PostData> bSz = this.hKy.getPbData().bSz();
            int bXt = this.hKC != null ? this.hKC.bXt() : 0;
            if (bSz != null && bXt >= 0 && bXt < bSz.size()) {
                historyMessage.postID = bSz.get(bXt).getId();
            }
            historyMessage.isHostOnly = this.hKy.getHostMode();
            historyMessage.isSquence = this.hKy.bVw();
            historyMessage.isShareThread = this.hKy.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hKR != null) {
            this.hKR.onDestroy();
        }
        if (this.hKg && bTU() != null) {
            bTU().bYa();
        }
        if (this.hKy != null && (this.hKy.bVx() || this.hKy.bVz())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hKy.bVv());
            if (this.hKE) {
                if (this.hKG) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hKy.bfp());
                }
                if (this.hKF) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hKy.getIsGood());
                }
            }
            if (this.hKy.getPbData() != null && System.currentTimeMillis() - this.hKj >= 40000 && (bSG = this.hKy.getPbData().bSG()) != null && !com.baidu.tbadk.core.util.v.aa(bSG.getDataList())) {
                intent.putExtra("guess_like_data", bSG);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hLf);
            }
            setResult(-1, intent);
        }
        if (bUo()) {
            if (this.hKy != null && this.hKC != null && this.hKC.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hKy.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bSD() && !this.hKp && pbData.hHV == null) {
                        aj bWF = aj.bWF();
                        com.baidu.tieba.pb.data.d bVD = this.hKy.bVD();
                        Parcelable onSaveInstanceState = this.hKC.getListView().onSaveInstanceState();
                        boolean bVw = this.hKy.bVw();
                        boolean hostMode = this.hKy.getHostMode();
                        if (this.hKC.bXc() != null && this.hKC.bXc().getVisibility() == 0) {
                            z = true;
                        }
                        bWF.a(bVD, onSaveInstanceState, bVw, hostMode, z);
                        if (this.hLe >= 0 || this.hKy.bWg() != null) {
                            aj.bWF().l(this.hKy.bWg());
                            aj.bWF().k(this.hKy.bWh());
                            aj.bWF().yc(this.hKy.bWi());
                        }
                    }
                }
            } else {
                aj.bWF().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hKC == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hKC.yh(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xK(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.hKC.bWR();
            this.hKC.bWT().bVi();
            this.hKC.oY(false);
        }
        this.hKC.bWU();
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
                        this.hKR.resetData();
                        this.hKR.b(writeData);
                        this.hKR.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k kp = this.hKR.arY().kp(6);
                        if (kp != null && kp.crT != null) {
                            kp.crT.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hKR.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hKC.bWT() != null && this.hKC.bWT().bVm() != null) {
                            com.baidu.tbadk.editortools.pb.g bVm = this.hKC.bWT().bVm();
                            bVm.b(writeData);
                            bVm.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k kp2 = bVm.arY().kp(6);
                            if (kp2 != null && kp2.crT != null) {
                                kp2.crT.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bVm.asR();
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
        this.hKR.onActivityResult(i, i2, intent);
        if (this.hKt != null) {
            this.hKt.onActivityResult(i, i2, intent);
        }
        if (bTU().bWT() != null) {
            bTU().bWT().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    bUm();
                    return;
                case 13008:
                    aj.bWF().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hKy != null) {
                                PbActivity.this.hKy.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.chl().y(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hKy != null) {
                        a(bUl(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    ag(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.chl().y(getPageContext());
                        bUd();
                        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.fJN != null && shareItem != null && shareItem.linkUrl != null) {
                            this.fJN.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aoN() {
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
                    this.hKC.ol(false);
                    if (this.hKy.getPbData() != null && this.hKy.getPbData().bSx() != null && this.hKy.getPbData().bSx().aeR() != null) {
                        this.hKy.getPbData().bSx().aeR().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hKU = emotionImageData;
                        if (xJ(com.baidu.tbadk.core.util.aj.bTj)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hKC != null && this.hKC.hTu != null) {
                        this.hKC.hTu.UM();
                        this.hKC.hTu.bYC();
                        if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSx() != null) {
                            this.hKy.getPbData().bSx().hf(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hKu != null) {
                        this.hKC.cE(this.hKu);
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
            if (this.hKt == null) {
                this.hKt = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hKt.b(this.ctK);
                this.hKt.c(this.ctR);
            }
            this.hKt.a(emotionImageData, bTD(), bTD().getPbData());
        }
    }

    private ShareFromPBMsgData bUl() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] eb = this.hKy.getPbData().eb(getPageContext().getPageActivity());
        PostData bWX = this.hKC.bWX();
        String str = "";
        if (bWX != null) {
            str = bWX.getId();
            String em = bWX.em(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(em)) {
                eb[1] = em;
            }
        }
        String aeN = this.hKy.getPbData().bSx().aeN();
        if (aeN != null && aeN.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(eb[1]);
        shareFromPBMsgData.setImageUrl(eb[0]);
        shareFromPBMsgData.setForumName(this.hKy.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hKy.getPbData().bSx().getId());
        shareFromPBMsgData.setTitle(this.hKy.getPbData().bSx().getTitle());
        return shareFromPBMsgData;
    }

    private void ag(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bUl(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSx() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hx(1);
            aVar.aH(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null) {
                        com.baidu.tbadk.core.util.an bT = new com.baidu.tbadk.core.util.an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).P("obj_param1", 3).bT("fid", PbActivity.this.hKy.getForumId()).bT("tid", PbActivity.this.hKy.bVv());
                        if (PbActivity.this.d(PbActivity.this.hKy.getPbData()) != 0) {
                            bT.P("obj_type", PbActivity.this.d(PbActivity.this.hKy.getPbData()));
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
            aVar.b(getPageContext()).agI();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), this.hKy.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSx() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hx(1);
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
            aVar.b(getPageContext()).agI();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), this.hKy.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUm() {
        MarkData xZ;
        if (this.hKA != null && (xZ = this.hKy.xZ(this.hKC.bXu())) != null) {
            if (!xZ.isApp() || (xZ = this.hKy.xZ(this.hKC.bXu() + 1)) != null) {
                this.hKC.bXp();
                this.hKA.a(xZ);
                if (!this.hKA.aaB()) {
                    this.hKA.aaD();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hKA.aaC();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUn() {
        com.baidu.tieba.pb.data.d pbData = this.hKy.getPbData();
        this.hKy.oE(true);
        if (this.hKA != null) {
            pbData.BJ(this.hKA.aaA());
        }
        this.hKC.m(pbData);
    }

    private boolean bUo() {
        if (this.hKy == null) {
            return true;
        }
        if (this.hKy.aaB()) {
            final MarkData bVN = this.hKy.bVN();
            if (bVN == null || !this.hKy.getIsFromMark()) {
                return true;
            }
            final MarkData xZ = this.hKy.xZ(this.hKC.bXt());
            if (xZ == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bVN);
                setResult(-1, intent);
                return true;
            } else if (xZ.getPostId() == null || xZ.getPostId().equals(bVN.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bVN);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mO(getPageContext().getString(R.string.alert_update_mark));
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hKA != null) {
                            if (PbActivity.this.hKA.aaB()) {
                                PbActivity.this.hKA.aaC();
                                PbActivity.this.hKA.dx(false);
                            }
                            PbActivity.this.hKA.a(xZ);
                            PbActivity.this.hKA.dx(true);
                            PbActivity.this.hKA.aaD();
                        }
                        bVN.setPostId(xZ.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bVN);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bUk();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bVN);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bUk();
                    }
                });
                aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hKC != null && PbActivity.this.hKC.getView() != null) {
                            PbActivity.this.hKC.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bVN);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bUk();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.agI();
                return false;
            }
        } else if (this.hKy.getPbData() == null || this.hKy.getPbData().bSz() == null || this.hKy.getPbData().bSz().size() <= 0 || !this.hKy.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hKC == null) {
            return null;
        }
        return this.hKC.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azs() {
        if (this.hKC == null) {
            return 0;
        }
        return this.hKC.bXF();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azt() {
        if (this.cJY == null) {
            this.cJY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean ace = com.baidu.tbadk.core.i.aca().ace();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
                    if (ace) {
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
                        if (com.baidu.tbadk.core.i.aca().ace()) {
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
        return this.cJY;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azu() {
        if (this.cMN == null) {
            this.cMN = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cMN;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azv() {
        if (this.cJZ == null) {
            this.cJZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bUJ */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbActivity.this.getPageContext().getPageActivity());
                    boolean ace = com.baidu.tbadk.core.i.aca().ace();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
                    if (ace) {
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
                    if (com.baidu.tbadk.core.i.aca().ace()) {
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
                    gifView.att();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cJZ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azw() {
        if (this.cMO == null) {
            this.cMO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bUK */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cy */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cz */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cqz();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cA */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.cMO;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azy() {
        this.cMQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bUL */
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
        return this.cMQ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> ale() {
        if (this.ccT == null) {
            this.ccT = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.ccT;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hKn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (av.Ce(str) && this.hKy != null && this.hKy.bVv() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").P("obj_param1", 1).bT("post_id", this.hKy.bVv()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.cqS = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
            }
        } else {
            av.bYl().c(getPageContext(), str);
        }
        this.hKn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        av.bYl().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hKn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Rect rect) {
        if (rect != null && this.hKC != null && this.hKC.bXV() != null && rect.top <= this.hKC.bXV().getHeight()) {
            rect.top += this.hKC.bXV().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hKy.getPbData();
            TbRichText be = be(str, i);
            if (be != null && (tbRichTextData = be.ayL().get(this.hLK)) != null) {
                cVar.hMx = new ArrayList<>();
                cVar.hMy = new ConcurrentHashMap<>();
                if (!tbRichTextData.ayS().aze()) {
                    cVar.hMA = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hMx.add(b2);
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
                    imageUrlData.postId = be.getPostId();
                    imageUrlData.mIsReserver = this.hKy.bVL();
                    imageUrlData.mIsSeeHost = this.hKy.getHostMode();
                    cVar.hMy.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bSx() != null) {
                            cVar.threadId = pbData.bSx().getId();
                        }
                        cVar.hMz = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.hMA = true;
                int size = pbData.bSz().size();
                this.hLL = false;
                cVar.index = -1;
                if (pbData.bSE() != null) {
                    PostData bSE = pbData.bSE();
                    TbRichText cpr = bSE.cpr();
                    if (!ap.m(bSE)) {
                        i2 = a(cpr, be, i, i, cVar.hMx, cVar.hMy);
                    } else {
                        i2 = a(bSE, i, cVar.hMx, cVar.hMy);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bSz().get(i4);
                    if (postData.getId() == null || pbData.bSE() == null || pbData.bSE().getId() == null || !postData.getId().equals(pbData.bSE().getId())) {
                        TbRichText cpr2 = postData.cpr();
                        if (!ap.m(postData)) {
                            i3 = a(cpr2, be, i3, i, cVar.hMx, cVar.hMy);
                        } else {
                            i3 = a(postData, i3, cVar.hMx, cVar.hMy);
                        }
                    }
                }
                if (cVar.hMx.size() > 0) {
                    cVar.lastId = cVar.hMx.get(cVar.hMx.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bSx() != null) {
                        cVar.threadId = pbData.bSx().getId();
                    }
                    cVar.hMz = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ayS() == null) {
            return null;
        }
        return tbRichTextData.ayS().azj();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ayS() == null) {
            return 0L;
        }
        return tbRichTextData.ayS().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ayS() == null) {
            return false;
        }
        return tbRichTextData.ayS().azk();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ayS() == null) {
            return false;
        }
        return tbRichTextData.ayS().azl();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo ayS;
        String str;
        if (tbRichText == tbRichText2) {
            this.hLL = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.ayL().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.ayL().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.ayS().getWidth() * ai;
                    int height = ai * tbRichTextData.ayS().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.ayS().aze()) {
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
                            if (tbRichTextData != null && (ayS = tbRichTextData.ayS()) != null) {
                                String azg = ayS.azg();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = ayS.azh();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = azg;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hKy.bVv(), -1L);
                                imageUrlData.mIsReserver = this.hKy.bVL();
                                imageUrlData.mIsSeeHost = this.hKy.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hLL) {
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
        com.baidu.tieba.tbadkCore.data.i cpy;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> coU;
        if (postData != null && arrayList != null && concurrentHashMap != null && (coU = (cpy = postData.cpy()).coU()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == coU.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = coU.get(i3);
                if (kVar != null) {
                    String coY = kVar.coY();
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(coY)) {
                        arrayList.add(coY);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = coY;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.coX();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hKy.bVv(), -1L);
                        imageUrlData.mIsReserver = this.hKy.bVL();
                        imageUrlData.mIsSeeHost = this.hKy.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cpy.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(coY, imageUrlData);
                        }
                        if (!this.hLL) {
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
            if (postData.getId() != null && postData.getId().equals(this.hKy.aeG())) {
                z = true;
            }
            MarkData j = this.hKy.j(postData);
            if (j != null) {
                this.hKC.bXp();
                if (this.hKA != null) {
                    this.hKA.a(j);
                    if (!z) {
                        this.hKA.aaD();
                    } else {
                        this.hKA.aaC();
                    }
                }
            }
        }
    }

    public boolean cx(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText be(String str, int i) {
        TbRichText tbRichText = null;
        if (this.hKy == null || this.hKy.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hKy.getPbData();
        if (pbData.bSE() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bSE());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bSz = pbData.bSz();
            a(pbData, bSz);
            return a(bSz, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bSI() != null && dVar.bSI().hIB != null && (list = dVar.bSI().hIB) != null && arrayList != null) {
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

    private long BP(String str) {
        ArrayList<PostData> bSz;
        com.baidu.tieba.pb.data.d pbData = this.hKy.getPbData();
        if (pbData != null && (bSz = pbData.bSz()) != null && !bSz.isEmpty()) {
            Iterator<PostData> it = bSz.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cpy = next.cpy();
                if (cpy != null && cpy.jeE) {
                    Iterator<TbRichTextData> it2 = next.cpr().ayL().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.azb().getLink().equals(str)) {
                            return cpy.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> ayL;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cpr = arrayList.get(i2).cpr();
            if (cpr != null && (ayL = cpr.ayL()) != null) {
                int size = ayL.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (ayL.get(i4) != null && ayL.get(i4).getType() == 8) {
                        i3++;
                        if (ayL.get(i4).ayS().azg().equals(str) || ayL.get(i4).ayS().azh().equals(str)) {
                            int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                            int width = ayL.get(i4).ayS().getWidth() * ai;
                            int height = ayL.get(i4).ayS().getHeight() * ai;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hLK = i4;
                            return cpr;
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
            this.hJX = str;
            if (this.hKi == null) {
                bTY();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hKi.hC(1).setVisibility(8);
            } else {
                this.hKi.hC(1).setVisibility(0);
            }
            this.hKi.agL();
            this.hKn = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ftO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUp() {
        hideNetRefreshView(this.hKC.getView());
        bUq();
        if (this.hKy.auD()) {
            this.hKC.bXp();
        }
    }

    private void bUq() {
        showLoadingView(this.hKC.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View atJ = getLoadingView().atJ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) atJ.getLayoutParams();
        layoutParams.addRule(3, this.hKC.bXV().getId());
        atJ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmj() {
        if (this.ftO != null) {
            this.ftO.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL(int i) {
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
    public void xM(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        bg bSx;
        if (this.hKy.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hKy.getPbData();
            pbData.getForum().getName();
            String title = pbData.bSx().getTitle();
            int i2 = this.hKy.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Ef(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hKy.bVv() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] eb = pbData.eb(getPageContext().getPageActivity());
                    str = eb[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = eb[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bUc() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").bT("fid", pbData.getForumId()).bT("tid", pbData.getThreadId()).bT("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                    eVar.title = title;
                    eVar.content = str2;
                    eVar.linkUrl = str3;
                    eVar.cks = true;
                    eVar.ckz = z;
                    eVar.extData = this.hKy.bVv();
                    eVar.ckL = 3;
                    eVar.ckK = i;
                    eVar.fid = this.hKy.getForumId();
                    eVar.tid = this.hKy.bVv();
                    eVar.ckP = d(pbData);
                    eVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        eVar.imageUri = parse;
                    }
                    bSx = this.hKy.getPbData().bSx();
                    eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bSx);
                    TbadkCoreApplication.getInst().setShareItem(eVar);
                    if (bSx != null) {
                        eVar.ckZ = bSx.getShareImageUrl();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", eVar.ckL);
                    bundle.putInt("obj_type", eVar.ckP);
                    bundle.putString("fid", eVar.fid);
                    bundle.putString("tid", eVar.tid);
                    bundle.putString("uid", eVar.uid);
                    eVar.E(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSV() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                                PbActivity.this.hKC.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.bbB().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hKy.bVv() + "?share=9105&fr=share&see_lz=" + i2;
            String[] eb2 = pbData.eb(getPageContext().getPageActivity());
            str = eb2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = eb2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bUc() == 1) {
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = str2;
            eVar2.linkUrl = str32;
            eVar2.cks = true;
            eVar2.ckz = z;
            eVar2.extData = this.hKy.bVv();
            eVar2.ckL = 3;
            eVar2.ckK = i;
            eVar2.fid = this.hKy.getForumId();
            eVar2.tid = this.hKy.bVv();
            eVar2.ckP = d(pbData);
            eVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            bSx = this.hKy.getPbData().bSx();
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bSx);
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            if (bSx != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.ckL);
            bundle2.putInt("obj_type", eVar2.ckP);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putString("uid", eVar2.uid);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hKy != null && PbActivity.this.hKy.getPbData() != null && PbActivity.this.hKy.getPbData().bSV() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                        PbActivity.this.hKC.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.bbB().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bSx() != null) {
            if (dVar.bSx().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bSx().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUr() {
        com.baidu.tbadk.util.aa.a(new com.baidu.tbadk.util.z<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.Eg(PbActivity.this.hKy.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hKC.bYb();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azx() {
        if (this.cMP == null) {
            this.cMP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bUM */
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
        return this.cMP;
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

    public void bmk() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData blb() {
        if (this.hKy == null || this.hKy.getPbData() == null) {
            return null;
        }
        return this.hKy.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.agK() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.agK();
            int intValue = ((Integer) sparseArray.get(aq.hVn)).intValue();
            if (intValue == aq.hVo) {
                if (!this.eDv.cqb()) {
                    this.hKC.bXm();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eDv.EP(com.baidu.tbadk.core.util.aq.y(jSONArray));
                    }
                    this.eDv.a(this.hKy.getPbData().getForum().getId(), this.hKy.getPbData().getForum().getName(), this.hKy.getPbData().bSx().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hVp || intValue == aq.hVr) {
                if (this.hKy.bVX() != null) {
                    this.hKy.bVX().xP(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hVp) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hKZ);
        userMuteAddAndDelCustomMessage.setTag(this.hKZ);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean BQ(String str) {
        if (!StringUtils.isNull(str) && bd.cF(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("bubble_link", "");
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

    public void oq(boolean z) {
        this.hKL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bUs() {
        ArrayList<PostData> bSz;
        int Z;
        if (this.hKy == null || this.hKy.getPbData() == null || this.hKy.getPbData().bSz() == null || (Z = com.baidu.tbadk.core.util.v.Z((bSz = this.hKy.getPbData().bSz()))) == 0) {
            return "";
        }
        if (this.hKy.bVL()) {
            Iterator<PostData> it = bSz.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cpp() == 1) {
                    return next.getId();
                }
            }
        }
        int bXt = this.hKC.bXt();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bSz, bXt);
        if (postData == null || postData.aex() == null) {
            return "";
        }
        if (this.hKy.BU(postData.aex().getUserId())) {
            return postData.getId();
        }
        for (int i = bXt - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bSz, i);
            if (postData2 == null || postData2.aex() == null || postData2.aex().getUserId() == null) {
                break;
            } else if (this.hKy.BU(postData2.aex().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bXt + 1; i2 < Z; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bSz, i2);
            if (postData3 == null || postData3.aex() == null || postData3.aex().getUserId() == null) {
                return "";
            }
            if (this.hKy.BU(postData3.aex().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (bb.ajC().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(BP(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hKy.getPbData().getForum().getId(), this.hKy.getPbData().getForum().getName(), this.hKy.getPbData().bSx().getTid());
            }
            this.hKn = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.mO(getResources().getString(R.string.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.mO(getResources().getString(R.string.make_sure_hide));
        }
        aVar.a(getResources().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hKy.bVW() != null) {
                    PbActivity.this.hKy.bVW().el(j);
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
        aVar.agI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c BR(String str) {
        String str2;
        if (this.hKy.getPbData() == null || this.hKy.getPbData().bSz() == null || this.hKy.getPbData().bSz().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hKy.getPbData().bSz().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hKy.getPbData().bSz().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hKy.getPbData().bSz().get(i);
        if (postData.cpr() == null || postData.cpr().ayL() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cpr().ayL().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.ayS() != null) {
                    str2 = next.ayS().azg();
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
        if (this.hKe) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hKe = false;
        } else if (bUt()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hKe) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hKe = false;
        } else if (bUt()) {
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
            if (this.hKy != null) {
                if (this.hKy.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.hKy.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.hKy.bVv(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.qU(TbadkCoreApplication.getInst().getAdAdSense().cfM);
            }
        }
        return pageStayDurationItem;
    }

    public boolean bUt() {
        return (!this.hKc && this.hLS == -1 && this.hLT == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hLV = oVar;
            this.hKc = true;
            this.hKC.bXd();
            this.hKC.Cc(this.hLU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUu() {
        if (this.hLV != null) {
            if (this.hLS == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bd.cE(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hLV.getCartoonId(), this.hLS, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUv() {
        if (this.hLV != null) {
            if (this.hLT == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bd.cE(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hLV.getCartoonId(), this.hLT, 0)));
                finish();
            }
        }
    }

    public int bUw() {
        return this.hLS;
    }

    public int bUx() {
        return this.hLT;
    }

    private void byh() {
        if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSx() != null && this.hKy.getPbData().bSx().afr()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bUy() {
        if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSx() != null && this.hKy.getPbData().bSx().afr()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bUz() {
        if (this.hKf) {
            this.hKs = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSx() != null && this.hKy.getPbData().bSx().aed() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hKy.getPbData().bSx().aed().getThreadId(), this.hKy.getPbData().bSx().aed().getTaskId(), this.hKy.getPbData().bSx().aed().getForumId(), this.hKy.getPbData().bSx().aed().getForumName(), this.hKy.getPbData().bSx().aes(), this.hKy.getPbData().bSx().aet())));
            this.hKe = true;
            finish();
        }
    }

    public String bUA() {
        return this.hKq;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bUB() {
        return this.hKx;
    }

    public void or(boolean z) {
        this.hKr = z;
    }

    public boolean bUC() {
        if (this.hKy != null) {
            return this.hKy.bVx();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mO(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hKX).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hKX.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hKX).agI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hKX != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hKX.getPageActivity());
            aVar.mO(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hKX).agI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hKC.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hKX.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.mO(this.hKX.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mO(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hKC.showLoadingDialog();
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
        aVar.b(this.hKX).agI();
    }

    public void bUE() {
        if (this.hKy != null && this.hKy.getPbData() != null && this.hKy.getPbData().bSx() != null && this.hKy.getPbData().bSx().afH() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.hu(R.string.channel_open_push_message);
            aVar.a(R.string.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hKy.getPbData().bSx().afH().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.agI();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.Ce(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.fTg) {
            this.fTg = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.hKC != null) {
                this.hKC.onConfigurationChanged(configuration);
            }
            if (this.hKI != null) {
                this.hKI.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921419, configuration));
        }
    }

    public boolean bUF() {
        if (this.hKy != null) {
            return this.hKy.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hKy.getPbData().bSI().hIB;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cpm().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cpm().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cpm().remove(i2);
                    list.get(i).cpo();
                    z = true;
                    break;
                }
            }
            list.get(i).EJ(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.hKy.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bTg().getId();
        List<PostData> list = this.hKy.getPbData().bSI().hIB;
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
                ArrayList<PostData> bTk = kVar.bTk();
                postData.Bd(kVar.getTotalCount());
                if (postData.cpm() != null) {
                    postData.cpm().clear();
                    postData.cpm().addAll(bTk);
                }
            }
        }
        if (!this.hKy.getIsFromMark()) {
            this.hKC.m(this.hKy.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bTs() {
        return this.hKD;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bTt() {
        if (this.hKy == null) {
            return false;
        }
        return this.hKy.bTt();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bTu() {
        if (this.hKy != null) {
            return this.hKy.bTu();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bTv() {
        if (this.hKy == null || this.hKy.getPbData() == null) {
            return 0;
        }
        return this.hKy.getPbData().bSJ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean BL(String str) {
        return this.hKy != null && this.hKy.BU(str);
    }

    public void bUG() {
        if (this.hKC != null) {
            this.hKC.bWR();
            bmk();
        }
    }

    public PostData bSE() {
        return this.hKC.c(this.hKy.hPY, this.hKy.bVw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int au(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.isLinkThread()) {
                return 3;
            }
            if (bgVar.afJ()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hLg != null && !this.hLg.isEmpty()) {
            int size = this.hLg.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hLg.get(i).onBackPressed()) {
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
            if (this.hLg == null) {
                this.hLg = new ArrayList();
            }
            if (!this.hLg.contains(aVar)) {
                this.hLg.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hLg == null) {
                this.hLg = new ArrayList();
            }
            if (!this.hLg.contains(aVar)) {
                this.hLg.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hLg != null) {
            this.hLg.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUH() {
        if (this.hKy != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.hKy.bVv())) {
            com.baidu.tbadk.BdToken.c.Zg().k(com.baidu.tbadk.BdToken.b.bxN, com.baidu.adp.lib.g.b.c(this.hKy.bVv(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hKy == null || com.baidu.tbadk.core.util.aq.isEmpty(this.hKy.bVv())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.hKy.bVv(), 0L);
    }
}
