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
    private com.baidu.adp.lib.e.b<ImageView> cKf;
    private com.baidu.adp.lib.e.b<GifView> cKg;
    private com.baidu.adp.lib.e.b<TextView> cMU;
    private com.baidu.adp.lib.e.b<View> cMV;
    private com.baidu.adp.lib.e.b<LinearLayout> cMW;
    private com.baidu.adp.lib.e.b<RelativeLayout> cMX;
    private com.baidu.adp.lib.e.b<TbImageView> cda;
    private LikeModel cdy;
    private com.baidu.tieba.f.b eai;
    private au fWr;
    private VoiceManager fun;
    private com.baidu.tieba.frs.profession.permission.c fxS;
    public com.baidu.tbadk.core.util.aj gWQ;
    private String hKQ;
    private com.baidu.tieba.pb.pb.main.b.b hKW;
    public as hLB;
    private com.baidu.tbadk.core.dialog.i hLC;
    private com.baidu.tbadk.core.dialog.k hLD;
    private boolean hLF;
    private com.baidu.tieba.tbadkCore.data.f hLJ;
    private com.baidu.tbadk.editortools.pb.f hLK;
    private com.baidu.tbadk.editortools.pb.d hLL;
    private com.baidu.tieba.frs.profession.permission.c hLN;
    private EmotionImageData hLO;
    private com.baidu.adp.base.e hLR;
    private com.baidu.tbadk.core.view.e hLS;
    private BdUniqueId hLT;
    private Runnable hLU;
    private com.baidu.adp.widget.ImageView.a hLV;
    private String hLW;
    private TbRichTextMemeInfo hLX;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hLm;
    private View hLn;
    int hLp;
    private com.baidu.tbadk.core.data.av hLq;
    private com.baidu.tieba.pb.pb.report.a hLt;
    private boolean hMD;
    private String hMO;
    private com.baidu.tbadk.core.data.o hMP;
    private List<a> hMa;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").P("obj_locate", au.a.bUk));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").P("obj_locate", au.a.bUk));
        }
    };
    private static final b.a hMJ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.f.b.a
        public void ji(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bTF();
            } else {
                com.baidu.tieba.pb.a.b.bTE();
            }
        }
    };
    private boolean hKV = false;
    private boolean hKX = false;
    private boolean hKY = false;
    private boolean hos = false;
    private boolean hKZ = true;
    private int hLa = 0;
    private com.baidu.tbadk.core.dialog.b hLb = null;
    private long eXw = -1;
    private long cAc = 0;
    private long hLc = 0;
    private long createTime = 0;
    private long czU = 0;
    private boolean hLd = false;
    private com.baidu.tbadk.p.b hLe = null;
    private long hLf = 0;
    private boolean hLg = false;
    private long hLh = 0;
    private int fTW = 1;
    private String ctO = null;
    private boolean hLi = false;
    private boolean isFullScreen = false;
    private String hLj = "";
    private boolean hLk = true;
    private boolean hLl = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hLo = new int[2];
    private PbInterviewStatusView.a hLr = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void G(boolean z) {
            PbActivity.this.hLw.oR(!PbActivity.this.hLk);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hLs != null && PbActivity.this.hLs.aaB()) {
                        PbActivity.this.bUC();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hLs = null;
    private com.baidu.tbadk.baseEditMark.a hLu = null;
    private ForumManageModel eDC = null;
    private com.baidu.tbadk.coreExtra.model.a bTs = null;
    private com.baidu.tieba.pb.data.l hLv = null;
    private ShareSuccessReplyToServerModel fKB = null;
    private aq hLw = null;
    public final com.baidu.tieba.pb.pb.main.b.a hLx = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hLy = false;
    private boolean hLz = false;
    private boolean hLA = false;
    private boolean hLE = false;
    private boolean hLG = false;
    private boolean hLH = false;
    private boolean hLI = false;
    private boolean hLM = false;
    public boolean hLP = false;
    private com.baidu.tbadk.editortools.pb.c ctR = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void asz() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ctS = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean asy() {
            if (PbActivity.this.hLB == null || PbActivity.this.hLB.bYy() == null || !PbActivity.this.hLB.bYy().czB()) {
                return !PbActivity.this.xL(com.baidu.tbadk.core.util.aj.bTn);
            }
            PbActivity.this.showToast(PbActivity.this.hLB.bYy().czD());
            if (PbActivity.this.hLL != null && (PbActivity.this.hLL.asN() || PbActivity.this.hLL.asO())) {
                PbActivity.this.hLL.a(false, PbActivity.this.hLB.bYB());
            }
            PbActivity.this.hLB.pd(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hLQ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean asy() {
            if (PbActivity.this.hLB == null || PbActivity.this.hLB.bYz() == null || !PbActivity.this.hLB.bYz().czB()) {
                return !PbActivity.this.xL(com.baidu.tbadk.core.util.aj.bTo);
            }
            PbActivity.this.showToast(PbActivity.this.hLB.bYz().czD());
            if (PbActivity.this.hLw != null && PbActivity.this.hLw.bXk() != null && PbActivity.this.hLw.bXk().bVC() != null && PbActivity.this.hLw.bXk().bVC().asO()) {
                PbActivity.this.hLw.bXk().bVC().a(PbActivity.this.hLB.bYB());
            }
            PbActivity.this.hLB.pe(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean fvc = false;
    private int hLY = 0;
    private int hLZ = -1;
    private final a hMb = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hLw != null && PbActivity.this.hLw.bXk() != null) {
                s bXk = PbActivity.this.hLw.bXk();
                if (bXk.bVA()) {
                    bXk.bVz();
                    return true;
                }
            }
            if (PbActivity.this.hLw != null && PbActivity.this.hLw.bYf()) {
                PbActivity.this.hLw.bYg();
                return true;
            }
            return false;
        }
    };
    private r.a hMc = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
    };
    private AddExperiencedModel.a fvo = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bUG();
        }
    };
    private final z.a hMd = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hLw.showToast(str);
            }
        }
    };
    private final CustomMessageListener hMe = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hLs != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hLL != null) {
                    PbActivity.this.hLw.oW(PbActivity.this.hLL.asH());
                }
                PbActivity.this.hLw.bXl();
                PbActivity.this.hLw.bXY();
            }
        }
    };
    CustomMessageListener fvI = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hLs.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hLw != null && PbActivity.this.hLs != null) {
                    PbActivity.this.hLw.d(PbActivity.this.hLs.getPbData(), PbActivity.this.hLs.bVM(), PbActivity.this.hLs.bWh());
                }
                if (PbActivity.this.hLw != null && PbActivity.this.hLw.bXC() != null) {
                    PbActivity.this.hLw.bXC().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hMf = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hLw != null) {
                    if (booleanValue) {
                        PbActivity.this.hLw.bEW();
                    } else {
                        PbActivity.this.hLw.bEV();
                    }
                }
            }
        }
    };
    private CustomMessageListener hMg = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hLL != null) {
                    PbActivity.this.hLw.oW(PbActivity.this.hLL.asH());
                }
                PbActivity.this.hLw.oY(false);
            }
        }
    };
    private CustomMessageListener hMh = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
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
    private CustomMessageListener hMi = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hLw != null && PbActivity.this.hLw.bXC() != null) {
                PbActivity.this.hLw.bXC().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gAP = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener fvF = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hKY) {
                PbActivity.this.bUW();
            }
        }
    };
    private h.a hMj = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void v(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.xN(2);
                aj.bWV().reset();
                PbActivity.this.hLs.bWi();
                boolean z2 = false;
                ArrayList<PostData> bSN = PbActivity.this.hLs.getPbData().bSN();
                if (bSN != null) {
                    Iterator<PostData> it = bSN.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.cpU().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hLw.m(PbActivity.this.hLs.getPbData());
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
    private View.OnClickListener cuD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.ctO);
        }
    };
    private CustomMessageListener hMk = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLs.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hLs.bVY() != null && PbActivity.this.hLs.bVY().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hLw.a(aaVar.sendCount, PbActivity.this.hLs.getPbData(), PbActivity.this.hLs.bVM(), PbActivity.this.hLs.bWh());
                    }
                    if (pbData.bSN() != null && pbData.bSN().size() >= 1 && pbData.bSN().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.bSN().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.hLs.bVL(), 0L);
                        if (c2 == aaVar.postId && c3 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cpT = pbData.bSN().get(0).cpT();
                            if (cpT == null) {
                                cpT = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> adu = cpT.adu();
                            if (adu == null) {
                                adu = new ArrayList<>();
                            }
                            adu.add(0, aVar);
                            cpT.setTotal(aaVar.sendCount + cpT.getTotal());
                            cpT.p(adu);
                            pbData.bSN().get(0).a(cpT);
                            PbActivity.this.hLw.bXC().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fLM = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                PbActivity.this.BN((String) customResponsedMessage.getData());
                PbActivity.this.hLs.bWe();
                if (PbActivity.this.hLw.bXC() != null) {
                    PbActivity.this.hLw.m(PbActivity.this.hLs.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hMl = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bYI()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hMm = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aj(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.aa(list) && PbActivity.this.hLw != null) {
                PbActivity.this.hLw.dJ(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hMn = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
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
    private boolean hMo = false;
    private PraiseModel hMp = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void sE(String str) {
            PbActivity.this.hMo = false;
            if (PbActivity.this.hMp != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLs.getPbData();
                if (pbData.bSL().aek().getIsLike() == 1) {
                    PbActivity.this.sv(0);
                } else {
                    PbActivity.this.sv(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bSL()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbActivity.this.hMo = false;
            if (PbActivity.this.hMp != null && str != null) {
                if (AntiHelper.aG(i, str)) {
                    AntiHelper.aJ(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hMq = 0;
    private boolean hMr = true;
    private b.a hMs = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void os(boolean z) {
            PbActivity.this.or(z);
            if (PbActivity.this.hLw.bYl() != null && z) {
                PbActivity.this.hLw.oR(false);
            }
            PbActivity.this.hLw.oT(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().chM != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().chM, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").P("obj_locate", au.a.bUk));
                        }
                    } else if (updateAttentionMessage.getData().Hs) {
                        if (PbActivity.this.bSS().aey() != null && PbActivity.this.bSS().aey().getGodUserData() != null) {
                            PbActivity.this.bSS().aey().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().aey() != null) {
                            PbActivity.this.hLs.getPbData().bSL().aey().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a dZz = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hLw.aUB();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.xO(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.buI();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(R.string.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c clA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            PbActivity.this.bUm();
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
                    if (PbActivity.this.hLw != null && PbActivity.this.hLw.bUk() && view.getId() == R.id.pb_head_user_info_root) {
                        if (view.getTag(R.id.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").bT(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(R.id.tag_user_id)));
                        }
                        if (PbActivity.this.hLx != null && PbActivity.this.hLx.fWK != null) {
                            PbActivity.this.hLx.fWK.onClick(view);
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
            if (PbActivity.this.hLL != null) {
                PbActivity.this.hLw.oW(PbActivity.this.hLL.asH());
            }
            PbActivity.this.hLw.bXl();
            PbActivity.this.hLw.bXY();
            return true;
        }
    });
    private CustomMessageListener hMt = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hLT) {
                PbActivity.this.hLw.aUB();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLs.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bSY().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hLS.i(PbActivity.this.hLR.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hLR.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbActivity.this.qv(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bUS();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hLR.getResources().getString(R.string.mute_fail);
                    }
                    PbActivity.this.hLS.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hMu = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hLT) {
                PbActivity.this.hLw.aUB();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hLS.i(PbActivity.this.hLR.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hLR.getResources().getString(R.string.un_mute_fail);
                }
                PbActivity.this.hLS.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hMv = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hLT) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hLw.aUB();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.juu;
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
                    PbActivity.this.hLw.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hMw = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hLw.bXm() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bUm();
            }
        }
    };
    private CustomMessageListener fvP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.fvc = true;
                }
            }
        }
    };
    public a.b hzB = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bmu();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hLs.getPageData();
            int pageNum = PbActivity.this.hLw.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.adn()) {
                PbActivity.this.hLw.bXY();
                PbActivity.this.xN(2);
                PbActivity.this.bmt();
                PbActivity.this.hLw.bXG();
                if (com.baidu.adp.lib.util.j.kc()) {
                    PbActivity.this.hLs.xV(PbActivity.this.hLw.getPageNum());
                    if (PbActivity.this.hKW != null) {
                        PbActivity.this.hKW.showFloatingView();
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
    public final View.OnClickListener fwx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Multi-variable search result rejected for r4v291, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v295, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v322, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v435, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
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
            bm bmVar;
            String[] strArr;
            boolean u;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.hLw.bXU()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hLs.oC(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hLw.bXH();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hLw.hUq.bYV() == null || view != PbActivity.this.hLw.hUq.bYV().bWQ()) {
                        if (view == PbActivity.this.hLw.hUq.cCm) {
                            if (PbActivity.this.hLw.oV(PbActivity.this.hLs.bVR())) {
                                PbActivity.this.bmt();
                                return;
                            }
                            PbActivity.this.hKZ = false;
                            PbActivity.this.hKX = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hLw.hUq.cCm);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hLw.bXE() && (PbActivity.this.hLw.hUq.bYV() == null || (view != PbActivity.this.hLw.hUq.bYV().bWP() && view != PbActivity.this.hLw.hUq.bYV().bWN()))) {
                            if (view == PbActivity.this.hLw.bYb()) {
                                if (PbActivity.this.hLs != null) {
                                    com.baidu.tbadk.browser.a.ae(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLs.getPbData().bSL().aex().getLink());
                                }
                            } else if (view != PbActivity.this.hLw.hUq.hZL) {
                                if (view == PbActivity.this.hLw.hUq.hZM) {
                                    if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                                        ArrayList<PostData> bSN = PbActivity.this.hLs.getPbData().bSN();
                                        if ((bSN == null || bSN.size() <= 0) && PbActivity.this.hLs.bVM()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").bT("tid", PbActivity.this.hLs.bVL()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", PbActivity.this.hLs.getForumId()));
                                        if (!PbActivity.this.hLw.bYq()) {
                                            PbActivity.this.hLw.bXl();
                                        }
                                        PbActivity.this.bUu();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.kc()) {
                                        PbActivity.this.hLw.ow(true);
                                        PbActivity.this.hLw.bXl();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hLw.bEW();
                                            PbActivity.this.bmt();
                                            PbActivity.this.hLw.bXG();
                                            PbActivity.this.hLs.BU(PbActivity.this.bUH());
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.xN(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbActivity.this.hLw.hUq.bYV() == null || view != PbActivity.this.hLw.hUq.bYV().bWM()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbActivity.this.hLw.hUq.bYV() != null && view == PbActivity.this.hLw.hUq.bYV().getCancelView()) {
                                            PbActivity.this.hLw.hUq.UM();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbActivity.this.hLw.hUq.bYV() == null || view != PbActivity.this.hLw.hUq.bYV().bWK()) {
                                                if ((PbActivity.this.hLw.hUq.bYV() == null || view != PbActivity.this.hLw.hUq.bYV().bWS()) && view.getId() != R.id.pb_sort) {
                                                    if (PbActivity.this.hLw.hUq.bYV() == null || view != PbActivity.this.hLw.hUq.bYV().bWL()) {
                                                        if (PbActivity.this.hLw.hUq.bYV() == null || view != PbActivity.this.hLw.hUq.bYV().bWT()) {
                                                            if (PbActivity.this.hLw.bYl() == view) {
                                                                if (PbActivity.this.hLw.bYl().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLs.getPbData();
                                                                    if (pbData != null && pbData.bSL() != null && pbData.bSL().aee() != null) {
                                                                        String adV = pbData.bSL().aee().adV();
                                                                        if (StringUtils.isNull(adV)) {
                                                                            adV = pbData.bSL().aee().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").bT(VideoPlayActivityConfig.OBJ_ID, adV));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.em("c10725", null);
                                                                }
                                                                PbActivity.this.bUO();
                                                            } else if (PbActivity.this.hLw.hUq.bYV() == null || view != PbActivity.this.hLw.hUq.bYV().bWR()) {
                                                                if (PbActivity.this.hLw.hUq.bYV() != null && view == PbActivity.this.hLw.hUq.bYV().bWO()) {
                                                                    if (com.baidu.adp.lib.util.j.kc()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hLw.c(PbActivity.this.hLs.getPbData(), PbActivity.this.hLs.bVM(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(R.id.tag_del_multi_forum))) {
                                                                                PbActivity.this.hLw.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hLw.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) c2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hLw.hUq.UM();
                                                                    } else {
                                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hLs != null && view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.bT("tid", PbActivity.this.hLs.bVL());
                                                                        anVar.bT("fid", PbActivity.this.hLs.getForumId());
                                                                        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.P("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hLs.getPbData() != null) {
                                                                            PbActivity.this.hLw.bXY();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cpX() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.jha != null) {
                                                                                    com.baidu.tbadk.core.util.an ajj = postData.jha.ajj();
                                                                                    ajj.nV("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        ajj.P("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        ajj.P("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(ajj);
                                                                                }
                                                                                String bVL = PbActivity.this.hLs.bVL();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hLs.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hLs.getPbData().bSX();
                                                                                }
                                                                                PbActivity.this.bmt();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    c BS = PbActivity.this.BS(id);
                                                                                    if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && BS != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bVL, id, "pb", true, null, true, null, i4, postData.bZO(), PbActivity.this.hLs.getPbData().getAnti(), false, postData.aey().getIconInfo()).addBigImageData(BS.hNr, BS.hNs, BS.hNt, BS.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hLs.bWu());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hLs.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c BS2 = PbActivity.this.BS(id);
                                                                                    if (postData != null && PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && BS2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bVL, id, "pb", true, null, false, null, i4, postData.bZO(), PbActivity.this.hLs.getPbData().getAnti(), false, postData.aey().getIconInfo()).addBigImageData(BS2.hNr, BS2.hNs, BS2.hNt, BS2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hLs.bWu());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hLs.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").P("obj_locate", 3).bT("fid", PbActivity.this.hLs.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbActivity.this.hLs != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.bT("tid", PbActivity.this.hLs.bVL());
                                                                        anVar2.bT("fid", PbActivity.this.hLs.getForumId());
                                                                        anVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.P("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                                                                                    String bVL2 = PbActivity.this.hLs.bVL();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hLs.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hLs.getPbData().bSX();
                                                                                    }
                                                                                    c BS3 = PbActivity.this.BS(id2);
                                                                                    if (BS3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bVL2, id2, "pb", true, null, false, null, i5, postData2.bZO(), PbActivity.this.hLs.getPbData().getAnti(), false, postData2.aey().getIconInfo()).addBigImageData(BS3.hNr, BS3.hNs, BS3.hNt, BS3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hLs.bWu());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hLs.getFromForumId());
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
                                                                    if (PbActivity.this.hLs != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.bT("tid", PbActivity.this.hLs.bVL());
                                                                        anVar3.bT("fid", PbActivity.this.hLs.getForumId());
                                                                        anVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.P("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.bUj().bXj() != null && postData3.aey() != null && postData3.cpL() != 1) {
                                                                                    if (PbActivity.this.bUj().bXk() != null) {
                                                                                        PbActivity.this.bUj().bXk().bVy();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                    kVar.a(PbActivity.this.hLs.getPbData().getForum());
                                                                                    kVar.aj(PbActivity.this.hLs.getPbData().bSL());
                                                                                    kVar.e(postData3);
                                                                                    PbActivity.this.bUj().bXj().d(kVar);
                                                                                    PbActivity.this.bUj().bXj().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.aey().getUserId(), "");
                                                                                    if (PbActivity.this.hLL != null) {
                                                                                        PbActivity.this.hLw.oW(PbActivity.this.hLL.asH());
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
                                                                } else if (view != PbActivity.this.hLw.bUd()) {
                                                                    if (view == PbActivity.this.hLw.hUq.bYW()) {
                                                                        PbActivity.this.hLw.bXN();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbActivity.this.checkUpIsLogin() && (bmVar = (bm) view.getTag()) != null && !StringUtils.isNull(bmVar.agA())) {
                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                bb.ajE().c(PbActivity.this.getPageContext(), new String[]{bmVar.agA()});
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").bT("tid", PbActivity.this.hLs.hQx));
                                                                                    }
                                                                                    if (PbActivity.this.hLD == null) {
                                                                                        PbActivity.this.hLD = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                                                                                        PbActivity.this.hLD.a(PbActivity.this.hMI);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cy(view);
                                                                                    if (!PbActivity.this.cy(view) || PbActivity.this.hLV == null || !PbActivity.this.hLV.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hLD);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cpN() != null && postData4.cpN().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hLD);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbActivity.this.gnU = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hLs.getPbData().aaB()) {
                                                                                        String aaA = PbActivity.this.hLs.getPbData().aaA();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(aaA) && aaA.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hLD);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hLD);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbActivity.this.gnU);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hLD);
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
                                                                                                    if (!ap.m(PbActivity.this.gnU)) {
                                                                                                        on = PbActivity.this.on(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        on = false;
                                                                                                    }
                                                                                                    if (on) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hLD);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hLD);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hLD);
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
                                                                                                    if (PbActivity.this.hLs.getPbData().bSX() == 1002 && !z3) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hLD);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hLD);
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
                                                                                            PbActivity.this.hLD.W(arrayList);
                                                                                            PbActivity.this.hLC = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hLD.ahd());
                                                                                            PbActivity.this.hLC.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbActivity.this.gnU);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hLD.W(arrayList);
                                                                                    PbActivity.this.hLC = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hLD.ahd());
                                                                                    PbActivity.this.hLC.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), PbActivity.this.hLs.getPbData().bSL().getActUrl());
                                                                                if (PbActivity.this.hLs.getPbData().bSL().afi() != 1) {
                                                                                    if (PbActivity.this.hLs.getPbData().bSL().afi() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").bT("fid", PbActivity.this.hLs.getPbData().getForumId()).bT("tid", PbActivity.this.hLs.getPbData().getThreadId()).bT("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hLs.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hLw.setSelection(0);
                                                                                } else {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bd.cF(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbActivity.this.hLw.bXl();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bUr() == 1 && PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").bT("fid", PbActivity.this.hLs.getPbData().getForumId()).bT("tid", PbActivity.this.hLs.getPbData().getThreadId()).bT("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bUr() == 1 && PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").bT("fid", PbActivity.this.hLs.getPbData().getForumId()).bT("tid", PbActivity.this.hLs.getPbData().getThreadId()).bT("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbActivity.this.bUJ();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbActivity.this.bUK();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bTe() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hLs.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").bT("fid", pbData2.getForumId()));
                                                                                bb.ajE().c(PbActivity.this.getPageContext(), new String[]{pbData2.bTe().bTl()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bTe() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hLs.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bT("fid", pbData3.getForumId()));
                                                                                bb.ajE().c(PbActivity.this.getPageContext(), new String[]{pbData3.bTe().bTl()});
                                                                            }
                                                                        } else if (PbActivity.this.hLw.hUq.bYV() != null && view == PbActivity.this.hLw.hUq.bYV().bWU()) {
                                                                            if (PbActivity.this.hLs == null || PbActivity.this.hLs.getPbData() == null || PbActivity.this.hLs.getPbData().bSL() == null) {
                                                                                PbActivity.this.hLw.hUq.UM();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.kt()) {
                                                                                PbActivity.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hLs.getPbData().bSL().aef() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLs.bVL(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(R.string.haved_fans_called)).agS();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").P("obj_locate", PbActivity.this.av(PbActivity.this.hLs.getPbData().bSL())).bT("tid", PbActivity.this.hLs.getPbData().bSL().getTid()).P("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hLY >= 0) {
                                                                                if (PbActivity.this.hLs != null) {
                                                                                    PbActivity.this.hLs.bWv();
                                                                                }
                                                                                if (PbActivity.this.hLw.bXC() != null) {
                                                                                    PbActivity.this.hLw.bXC().a(PbActivity.this.hLs.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hLw.getListView().setSelection(PbActivity.this.hLs.bWy());
                                                                                PbActivity.this.hLY = 0;
                                                                                if (PbActivity.this.hLs != null) {
                                                                                    PbActivity.this.hLs.ch(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbActivity.this.bUo();
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
                                                                            if (PbActivity.this.hLw.getListView() != null && PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hLw.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbActivity.this.hLw.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean bTj = PbActivity.this.hLs.getPbData().bTj();
                                                                                boolean z8 = PbActivity.this.hLw.hUk != null && PbActivity.this.hLw.hUk.cae();
                                                                                boolean bXV = PbActivity.this.hLw.bXV();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bTj && PbActivity.this.hLw.hUk != null && PbActivity.this.hLw.hUk.aJu() != null) {
                                                                                    int af = ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)) - PbActivity.this.hLw.hUk.caf();
                                                                                    z9 = firstVisiblePosition == 0 && (top == af || top == PbActivity.this.hLw.hUk.aJu().getHeight() - PbActivity.this.hLw.hUk.caf());
                                                                                    i7 = af;
                                                                                }
                                                                                if ((PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().aep() <= 0) || (bXV && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bUo();
                                                                                        if (PbActivity.this.hLs.getPbData().bSL().aey() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hLs.hQx).bT("fid", PbActivity.this.hLs.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hLs.getPbData().bSL().aey().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.6d);
                                                                                    if (bTj) {
                                                                                        if (PbActivity.this.hLw.hWf != null && PbActivity.this.hLw.hWf.hXp != null && PbActivity.this.hLw.hWf.hXp.getView() != null) {
                                                                                            if (PbActivity.this.hLw.hWf.hXp.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bUx();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hLw.hUk.aJu() != null) {
                                                                                                    i8 = PbActivity.this.hLw.hUk.aJu().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hLw.hWf.hXp.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hLw.bXt() != null) {
                                                                                        z10 = PbActivity.this.hLw.bXt().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hLw.hWf != null && PbActivity.this.hLw.hWf.hXp != null && PbActivity.this.hLw.hWf.hXp.getView() != null && PbActivity.this.hLw.hWf.hXp.getView().getParent() != null && PbActivity.this.hLw.hUq != null && PbActivity.this.hLw.hUq.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hLw.hWf.hXp.getView().getTop() - PbActivity.this.hLw.hUq.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bXV) {
                                                                                        int bUx = PbActivity.this.bUx();
                                                                                        if (PbActivity.this.bUw() != -1) {
                                                                                            bUx--;
                                                                                        }
                                                                                        int g = com.baidu.adp.lib.util.l.g(PbActivity.this, R.dimen.tbds116);
                                                                                        if (bUx < 0) {
                                                                                            i2 = PbActivity.this.hLw.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.Z(PbActivity.this.hLw.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bUx;
                                                                                            i3 = g;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bTj || PbActivity.this.hLw.hUk.aJu() == null) {
                                                                                            if (PbActivity.this.hLw.hUq != null && PbActivity.this.hLw.hUq.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hLw.hUq.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hLw.hUk.aJu().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hLw.hWf == null || PbActivity.this.hLw.hWf.hXp == null || PbActivity.this.hLw.hWf.hXp.getView() == null || PbActivity.this.hLw.hWf.hXp.getView().getParent() == null) {
                                                                                            PbActivity.this.hLw.getListView().setSelectionFromTop(i2, i3 + ah);
                                                                                            PbActivity.this.hLw.getListView().smoothScrollBy(ah, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hLw.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hLw.getListView().smoothScrollBy(PbActivity.this.hLw.hWf.hXp.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-ah))) {
                                                                                        PbActivity.this.hLw.getListView().setSelectionFromTop(0, i7 - ah);
                                                                                        PbActivity.this.hLw.getListView().smoothScrollBy(-ah, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hLw.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().aey() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hLs.hQx).bT("fid", PbActivity.this.hLs.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hLs.getPbData().bSL().aey().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbActivity.this.hLs.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hLs.bWu() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hLs.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.bT("tid", PbActivity.this.hLs.bVL());
                                                                                anVar4.bT("fid", PbActivity.this.hLs.getForumId());
                                                                                anVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bh) {
                                                                                bh bhVar = (bh) view.getTag();
                                                                                if (PbActivity.this.hLs.bWu() == 3 && PbActivity.this.bTH() && PbActivity.this.hLs.getPbData() != null && com.baidu.tbadk.core.util.v.aa(PbActivity.this.hLs.getPbData().bTg())) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(bhVar.aeD(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.bT("tid", bhVar.getId());
                                                                                anVar5.l("fid", bhVar.getFid());
                                                                                anVar5.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbActivity.this.hLs != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.bT("tid", PbActivity.this.hLs.bVL());
                                                                                anVar6.bT("fid", PbActivity.this.hLs.getForumId());
                                                                                anVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.P("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.hLs.getPbData();
                                                                                if (PbActivity.this.hLv == null) {
                                                                                    PbActivity.this.hLv = new com.baidu.tieba.pb.data.l(PbActivity.this.getPageContext());
                                                                                }
                                                                                long c3 = com.baidu.adp.lib.g.b.c(pbData4.getThreadId(), 0L);
                                                                                long c4 = com.baidu.adp.lib.g.b.c(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").l("forum_id", c4).ajk();
                                                                                PbActivity.this.registerListener(PbActivity.this.hMy);
                                                                                PbActivity.this.hLv.s(c3, c4);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").bT("fid", PbActivity.this.hLs.getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "PB_card").bT("tid", PbActivity.this.hLs.bVL()).P("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bh) {
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(((bh) view.getTag()).aeD(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").bT("page_type", "a005").P("obj_isad", 1).P("obj_adlocate", 9));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bh) && PbActivity.this.checkUpIsLogin()) {
                                                                                bh bhVar2 = (bh) view.getTag();
                                                                                if (PbActivity.this.cdy != null) {
                                                                                    PbActivity.this.cdy.el(bhVar2.aeD(), String.valueOf(bhVar2.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").bT("page_type", "a005").P("obj_isad", 1).P("obj_adlocate", 10));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.hLs.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.hLs.bVL(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hLs.getPbData().bSL().aeS())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.kc()) {
                                                                PbActivity.this.hLw.bXY();
                                                                SparseArray<Object> c5 = PbActivity.this.hLw.c(PbActivity.this.hLs.getPbData(), PbActivity.this.hLs.bVM(), 1);
                                                                if (c5 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLs.getPbData().getForum().getId(), PbActivity.this.hLs.getPbData().getForum().getName(), PbActivity.this.hLs.getPbData().bSL().getId(), String.valueOf(PbActivity.this.hLs.getPbData().getUserData().getUserId()), (String) c5.get(R.id.tag_forbid_user_name), (String) c5.get(R.id.tag_forbid_user_name_show), (String) c5.get(R.id.tag_forbid_user_post_id), (String) c5.get(R.id.tag_forbid_user_portrait))));
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
                                                            PbActivity.this.hLw.hUq.bYU();
                                                        }
                                                    } else if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bSL() != null) {
                                                        PbActivity.this.hLw.hUq.UM();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbActivity.this.BP(PbActivity.this.hLs.getPbData().bSL().aeO());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hLw.bXY();
                                                    if (com.baidu.adp.lib.util.j.kc()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hLs.bWc()));
                                                            return;
                                                        }
                                                        PbActivity.this.xN(2);
                                                        PbActivity.this.bmt();
                                                        PbActivity.this.hLw.bXG();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hLs.getPbData().hIL == null || PbActivity.this.hLs.getPbData().hIL.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(R.string.sort_type_new), PbActivity.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hLs.getPbData().hIL.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hLs.getPbData().hIL.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hLs.getPbData().hIL.get(i10).sort_name + PbActivity.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbActivity.this.hLs.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hLs.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hLs.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hLs.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != R.id.pb_sort ? 1 : 0).P("obj_type", i12));
                                                                if (PbActivity.this.hLs.getPbData().hIL != null && PbActivity.this.hLs.getPbData().hIL.size() > i11) {
                                                                    i11 = PbActivity.this.hLs.getPbData().hIL.get(i11).sort_type.intValue();
                                                                }
                                                                boolean ya = PbActivity.this.hLs.ya(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hLs.bWc()));
                                                                if (ya) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hLw.oN(true);
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
                                                PbActivity.this.hLw.bXY();
                                                if (PbActivity.this.bTR().getPbData().hIM != 2) {
                                                    if (PbActivity.this.hLs.getPageData() != null) {
                                                        PbActivity.this.hLw.a(PbActivity.this.hLs.getPageData(), PbActivity.this.hzB);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (bf.iN() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().aey() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hLs.hQx).bT("fid", PbActivity.this.hLs.getPbData().getForumId()).P("obj_locate", 4).bT("uid", PbActivity.this.hLs.getPbData().bSL().aey().getUserId()));
                                            }
                                            if (PbActivity.this.hLs != null) {
                                                com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an("c12386");
                                                anVar7.bT("tid", PbActivity.this.hLs.bVL());
                                                anVar7.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                anVar7.bT("fid", PbActivity.this.hLs.getForumId());
                                                anVar7.P("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    anVar7.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(anVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.kt()) {
                                                if (PbActivity.this.hLs.getPbData() != null) {
                                                    ArrayList<PostData> bSN2 = PbActivity.this.hLs.getPbData().bSN();
                                                    if ((bSN2 != null && bSN2.size() > 0) || !PbActivity.this.hLs.bVM()) {
                                                        PbActivity.this.hLw.bXY();
                                                        PbActivity.this.bmt();
                                                        PbActivity.this.xN(2);
                                                        if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bTe() != null && !StringUtils.isNull(PbActivity.this.hLs.getPbData().bTe().acV(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bT("fid", PbActivity.this.hLs.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                        if (bf.iN()) {
                                                            PbActivity.this.xO(2);
                                                        } else {
                                                            PbActivity.this.hLw.showLoadingDialog();
                                                            PbActivity.this.hLs.bWp().p(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                        PbActivity.this.hLw.bXY();
                                        if (PbActivity.this.hLw.hUq.bYV() != null && view == PbActivity.this.hLw.hUq.bYV().bWM() && !PbActivity.this.hLw.bYq()) {
                                            PbActivity.this.hLw.bXl();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bmt();
                                            PbActivity.this.hLw.bXG();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                u = PbActivity.this.hLs.u(true, PbActivity.this.bUH());
                                            } else {
                                                u = view.getId() == R.id.reply_title ? PbActivity.this.hLs.u(false, PbActivity.this.bUH()) : PbActivity.this.hLs.BU(PbActivity.this.bUH());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hLw.ow(true);
                                                PbActivity.this.hLw.bEW();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hLw.oN(true);
                                            }
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.xN(2);
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
                                    PbActivity.this.hLw.bXY();
                                    if (PbActivity.this.xM(11009) && PbActivity.this.hLs.yb(PbActivity.this.hLw.bXL()) != null) {
                                        PbActivity.this.bUB();
                                        if (PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().aey() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", PbActivity.this.hLs.hQx).bT("fid", PbActivity.this.hLs.getPbData().getForumId()).P("obj_locate", 3).bT("uid", PbActivity.this.hLs.getPbData().bSL().aey().getUserId()));
                                        }
                                        if (PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().aey() != null && PbActivity.this.hLs.getPbData().bSL().aey().getUserId() != null && PbActivity.this.hLu != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bT("tid", PbActivity.this.hLs.hQx).P("obj_locate", 1).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hLs.getPbData().bSL().aey().getUserId()).P("obj_type", PbActivity.this.hLu.aaB() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hLs.getPbData())));
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
                                if (PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().afs() && PbActivity.this.hLs.getPbData().bSL().aeP() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbActivity.this.hLs.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hLs.bTI()) && PbActivity.this.hLs.getAppealInfo() != null) {
                                        name = PbActivity.this.hLs.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hLs.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bTI = PbActivity.this.hLs.bTI();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hLs.bVN() && bTI != null && bTI.equals(name)) {
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
                            if (PbActivity.this.hLs.getPbData() != null) {
                                if ((PbActivity.this.hLs.getPbData().bSX() == 1 || PbActivity.this.hLs.getPbData().bSX() == 3) && !PbActivity.this.eDC.cqx()) {
                                    PbActivity.this.hLw.bXY();
                                    int i11 = 0;
                                    if (PbActivity.this.hLw.hUq.bYV() == null || view != PbActivity.this.hLw.hUq.bYV().bWN()) {
                                        if (PbActivity.this.hLw.hUq.bYV() == null || view != PbActivity.this.hLw.hUq.bYV().bWP()) {
                                            if (view == PbActivity.this.hLw.bXE()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hLs.getPbData().bSL().aeu() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hLs.getPbData().bSL().aet() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hLs.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hLs.getPbData().bSL().getId();
                                    PbActivity.this.hLw.bXD();
                                    PbActivity.this.eDC.a(id4, name2, id5, i11, PbActivity.this.hLw.bXF());
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
                        PbActivity.this.hLw.bXY();
                        PbActivity.this.bmt();
                        PbActivity.this.hLw.bXG();
                        PbActivity.this.hLw.showLoadingDialog();
                        if (PbActivity.this.hLw.bXt() != null) {
                            PbActivity.this.hLw.bXt().setVisibility(8);
                        }
                        PbActivity.this.hLs.xV(1);
                        if (PbActivity.this.hKW != null) {
                            PbActivity.this.hKW.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String bUp = PbActivity.this.bUp();
                        if (!TextUtils.isEmpty(bUp)) {
                            bb.ajE().c(PbActivity.this.getPageContext(), new String[]{bUp});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hLs != null) {
                    com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                    anVar8.bT("tid", PbActivity.this.hLs.bVL());
                    anVar8.bT("fid", PbActivity.this.hLs.getForumId());
                    anVar8.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar8.P("obj_locate", 1);
                    TiebaStatic.log(anVar8);
                }
                if (PbActivity.this.hLg) {
                    PbActivity.this.hLg = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.bUj().bXj() != null && postData5.aey() != null && postData5.cpL() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bUj().bXk() != null) {
                                PbActivity.this.bUj().bXk().bVy();
                            }
                            com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                            kVar2.a(PbActivity.this.hLs.getPbData().getForum());
                            kVar2.aj(PbActivity.this.hLs.getPbData().bSL());
                            kVar2.e(postData5);
                            PbActivity.this.bUj().bXj().d(kVar2);
                            PbActivity.this.bUj().bXj().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.aey().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hLs.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hLL != null) {
                                PbActivity.this.hLw.oW(PbActivity.this.hLL.asH());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d ctY = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                    anVar.bT("fid", PbActivity.this.hLs.getPbData().getForumId());
                }
                if (PbActivity.this.hLs != null) {
                    anVar.bT("tid", PbActivity.this.hLs.bVL());
                }
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbActivity.this.bmt();
            PbActivity.this.hLw.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.t.av.avS() && PbActivity.this.bTR() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bTR().BX(postWriteCallBackData.getPostId());
                    PbActivity.this.hLY = PbActivity.this.hLw.bXp();
                    if (PbActivity.this.hLs != null) {
                        PbActivity.this.hLs.ch(PbActivity.this.hLY, PbActivity.this.hLw.bXq());
                    }
                }
                PbActivity.this.hLw.bXY();
                PbActivity.this.hLB.bYx();
                if (PbActivity.this.hLL != null) {
                    PbActivity.this.hLw.oW(PbActivity.this.hLL.asH());
                }
                PbActivity.this.hLw.bXi();
                PbActivity.this.hLw.oY(true);
                PbActivity.this.hLs.bWe();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hLs.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLs.getPbData();
                            if (pbData != null && pbData.bSL() != null && pbData.bSL().aey() != null && (userId = pbData.bSL().aey().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.t.av.avS() && PbActivity.this.hLs.bVV()) {
                                PbActivity.this.hLw.bXG();
                            }
                        } else if (!com.baidu.tbadk.t.av.avS() && PbActivity.this.hLs.bVV()) {
                            PbActivity.this.hLw.bXG();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hLw.m(PbActivity.this.hLs.getPbData());
                    }
                    if (PbActivity.this.hLs.bVQ()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").bT("tid", PbActivity.this.hLs.bVL()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hLL.asN() || PbActivity.this.hLL.asO()) {
                    PbActivity.this.hLL.a(false, postWriteCallBackData);
                }
                PbActivity.this.hLB.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gWQ != null) {
                    PbActivity.this.gWQ.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hMx = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                    anVar.bT("fid", PbActivity.this.hLs.getPbData().getForumId());
                }
                if (PbActivity.this.hLs != null) {
                    anVar.bT("tid", PbActivity.this.hLs.bVL());
                }
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbActivity.this.hLB != null) {
                    PbActivity.this.hLB.bYw();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gWQ != null) {
                    PbActivity.this.gWQ.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hLB != null) {
                if (PbActivity.this.hLw != null && PbActivity.this.hLw.bXk() != null && PbActivity.this.hLw.bXk().bVC() != null && PbActivity.this.hLw.bXk().bVC().asO()) {
                    PbActivity.this.hLw.bXk().bVC().a(postWriteCallBackData);
                }
                PbActivity.this.hLB.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hMy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView bYv;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbActivity.this.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbActivity.this.hLw != null && (bYv = PbActivity.this.hLw.bYv()) != null && PbActivity.this.hLw.getListView() != null) {
                            PbActivity.this.hLw.getListView().removeHeaderView(bYv);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a hMz = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g kn;
            if (!z || dVar == null || dVar.bSV() != null || com.baidu.tbadk.core.util.v.Z(dVar.bSN()) >= 1) {
                PbActivity.this.hos = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hLw.bXI();
                if (dVar == null || !dVar.bSR()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hLw.getView());
                }
                PbActivity.this.hLw.bEV();
                if (PbActivity.this.isFullScreen || PbActivity.this.hLw.bYq()) {
                    PbActivity.this.hLw.bYh();
                } else if (!PbActivity.this.hLw.bYe()) {
                    PbActivity.this.hLw.oY(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hLE = true;
                }
                if (dVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hLw.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hLw.aVR();
                    if (dVar.bSL() != null && dVar.bSL().afB() != null) {
                        PbActivity.this.a(dVar.bSL().afB());
                    }
                    PbActivity.this.bUf();
                    if (PbActivity.this.hLL != null) {
                        PbActivity.this.hLw.oW(PbActivity.this.hLL.asH());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bSN() != null && dVar.bSN().size() >= 1 && dVar.bSN().get(0) != null) {
                        PbActivity.this.hLs.BW(dVar.bSN().get(0).getId());
                    } else if (dVar.bSV() != null) {
                        PbActivity.this.hLs.BW(dVar.bSV().getId());
                    }
                    if (PbActivity.this.hLL != null) {
                        PbActivity.this.hLL.a(dVar.getAnti());
                        PbActivity.this.hLL.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hLL.a(PbActivity.this.hLs.bVY(), PbActivity.this.hLs.bVL(), PbActivity.this.hLs.bWr());
                        if (dVar.bSL() != null) {
                            PbActivity.this.hLL.fo(dVar.bSL().afQ());
                        }
                    }
                    if (PbActivity.this.hLu != null) {
                        PbActivity.this.hLu.dx(dVar.aaB());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hLw.oX(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hLw.a(dVar, i2, i3, PbActivity.this.hLs.bVM(), i4, PbActivity.this.hLs.getIsFromMark());
                    PbActivity.this.hLw.e(dVar, PbActivity.this.hLs.bVM());
                    PbActivity.this.hLw.oU(PbActivity.this.hLs.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.ctO = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.ctO) && PbActivity.this.hLL != null && PbActivity.this.hLL.asa() != null && (kn = PbActivity.this.hLL.asa().kn(6)) != null && !TextUtils.isEmpty(PbActivity.this.ctO)) {
                            ((View) kn).setOnClickListener(PbActivity.this.cuD);
                        }
                    }
                    if (PbActivity.this.hLG) {
                        PbActivity.this.hLG = false;
                        final int bUw = PbActivity.this.bUw();
                        if (!dVar.bTj()) {
                            PbActivity.this.hLw.yh(bUw);
                        } else {
                            final int af = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bUw, af);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hLH) {
                        PbActivity.this.hLH = false;
                        final int bUw2 = PbActivity.this.bUw();
                        final boolean z2 = bUw2 != -1;
                        if (!z2) {
                            bUw2 = PbActivity.this.bUx();
                        }
                        if (PbActivity.this.hLw != null) {
                            if (!dVar.bTj()) {
                                PbActivity.this.hLw.yh(bUw2);
                            } else {
                                final int af2 = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bUw2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hLw.setSelectionFromTop(bUw2, af2);
                                            } else {
                                                PbActivity.this.hLw.setSelectionFromTop(bUw2 - 1, af2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hLw.oZ(true);
                                PbActivity.this.hLw.oY(false);
                            }
                        }
                    } else if (PbActivity.this.hLI) {
                        PbActivity.this.hLI = false;
                        PbActivity.this.hLw.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hLw.bXM();
                    }
                    PbActivity.this.hLs.a(dVar.getForum(), PbActivity.this.hMl);
                    PbActivity.this.hLs.a(PbActivity.this.hMm);
                    if (PbActivity.this.gWQ != null && dVar.bSL() != null && dVar.bSL().aey() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bSL().aey());
                        PbActivity.this.gWQ.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hLE && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hLs != null && PbActivity.this.hLs.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hLs.getAppealInfo().hIf)) {
                                    PbActivity.this.hLw.a(PbActivity.this.hLs.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hLw.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hLw.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                            }
                            PbActivity.this.hLw.bYh();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hLs.bVL());
                            jSONObject.put("fid", PbActivity.this.hLs.getForumId());
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
                        PbActivity.this.hLw.Ca("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                            arrayList = PbActivity.this.hLs.getPbData().bSN();
                        }
                        if (com.baidu.tbadk.core.util.v.Z(arrayList) != 0 && (com.baidu.tbadk.core.util.v.Z(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cpL() != 1)) {
                            PbActivity.this.hLw.Ca(PbActivity.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbActivity.this.bUU()) {
                            PbActivity.this.hLw.Cb(PbActivity.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbActivity.this.hLw.Cb(PbActivity.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbActivity.this.hLw.akG();
                }
                PbActivity.this.cAc = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bTR().bVM() || PbActivity.this.bTR().getPbData().getPage().adt() != 0 || PbActivity.this.bTR().bWl()) {
                    PbActivity.this.hLM = true;
                    return;
                }
                return;
            }
            PbActivity.this.hLs.xV(1);
            if (PbActivity.this.hKW != null) {
                PbActivity.this.hKW.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hLw.m(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.p.m.avv().avw()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eXw : j;
                com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, PbActivity.this.czU, PbActivity.this.createTime, PbActivity.this.cAc, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.czU = 0L;
                if (iVar != null) {
                    iVar.avs();
                }
                if (z2) {
                    iVar.cAl = currentTimeMillis;
                    iVar.fE(true);
                }
                if (!z2 && PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bSL() != null) {
                    int threadType = PbActivity.this.hLs.getPbData().bSL().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.bV(PbActivity.this.hLj, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.bV(PbActivity.this.hLj, "from_frs")) {
                                com.baidu.tbadk.p.i iVar2 = new com.baidu.tbadk.p.i();
                                iVar2.kR(1000);
                                iVar2.cAn = currentTimeMillis;
                                iVar2.kS(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.p.d dVar = new com.baidu.tbadk.p.d();
                        dVar.pageType = 1;
                        dVar.kR(1005);
                        dVar.cAn = currentTimeMillis;
                        dVar.kS(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hMA = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bUs();
            }
        }
    };
    private final a.InterfaceC0238a hMB = new a.InterfaceC0238a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0238a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hLw.bXI();
            if (z) {
                if (PbActivity.this.hLu != null) {
                    PbActivity.this.hLu.dx(z2);
                }
                PbActivity.this.hLs.oE(z2);
                if (PbActivity.this.hLs.aaB()) {
                    PbActivity.this.bUC();
                } else {
                    PbActivity.this.hLw.m(PbActivity.this.hLs.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hLu != null && PbActivity.this.hLu.aaE() != null && PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().aey() != null) {
                        MarkData aaE = PbActivity.this.hLu.aaE();
                        MetaData aey = PbActivity.this.hLs.getPbData().bSL().aey();
                        if (aaE != null && aey != null) {
                            if (!com.baidu.tbadk.core.util.aq.bV(TbadkCoreApplication.getCurrentAccount(), aey.getUserId()) && !aey.hadConcerned()) {
                                PbActivity.this.b(aey);
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
            if (!PbActivity.this.xJ(PbActivity.this.mLastScrollState) && PbActivity.this.xJ(i)) {
                if (PbActivity.this.hLw != null) {
                    PbActivity.this.hLw.bXY();
                    if (PbActivity.this.hLL != null && !PbActivity.this.hLw.bXm()) {
                        PbActivity.this.hLw.oW(PbActivity.this.hLL.asH());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hLw.bXl();
                    }
                }
                if (!PbActivity.this.hLd) {
                    PbActivity.this.hLd = true;
                    PbActivity.this.hLw.bYd();
                }
            }
            PbActivity.this.hLw.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hKW != null) {
                PbActivity.this.hKW.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hLe == null) {
                PbActivity.this.hLe = new com.baidu.tbadk.p.b();
                PbActivity.this.hLe.kR(1001);
            }
            if (i == 0) {
                PbActivity.this.hLe.avm();
            } else {
                PbActivity.this.hLe.avl();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.coG().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bSN;
            if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLw != null && PbActivity.this.hLw.bXC() != null) {
                PbActivity.this.hLw.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hKW != null) {
                    PbActivity.this.hKW.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hLs.bWg() && (bSN = PbActivity.this.hLs.getPbData().bSN()) != null && !bSN.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hLw.bXC().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLs.getPbData();
                    if (pbData != null) {
                        if (pbData.bSO() != null && pbData.bSO().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bSP() != null && pbData.bSP().hasData()) {
                            headerCount--;
                        }
                        int size = bSN.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eDG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eDC.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hLs.bWe();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.ibI != 1002 || bVar.fZG) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hLw.a(1, dVar.FU, dVar.jiM, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eDC.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hLw.a(PbActivity.this.eDC.getLoadDataMode(), gVar.FU, gVar.jiM, false);
                        PbActivity.this.hLw.ax(gVar.jiP);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hLw.a(PbActivity.this.eDC.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hMC = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final h.c cZn = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (PbActivity.this.bUI()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hLs.oD(true)) {
                PbActivity.this.hLw.bXJ();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fOO = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hMD && PbActivity.this.bUI()) {
                PbActivity.this.bUK();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hLs.oC(false)) {
                    PbActivity.this.hLw.bXH();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hLs.getPbData() != null) {
                    PbActivity.this.hLw.bYc();
                }
                PbActivity.this.hMD = true;
            }
        }
    };
    private int hME = 0;
    private final TbRichTextView.h cKo = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bXC;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hLs != null) {
                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                        anVar.bT("tid", PbActivity.this.hLs.bVL());
                        anVar.bT("fid", PbActivity.this.hLs.getForumId());
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
                        PbActivity.this.hLn = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hNu) {
                        TbRichText be = PbActivity.this.be(str, i);
                        if (be != null && PbActivity.this.hME >= 0 && PbActivity.this.hME < be.ayN().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(be.ayN().get(PbActivity.this.hME));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hNr.size()) {
                                    break;
                                } else if (!cVar.hNr.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (be.getPostId() != 0 && (bXC = PbActivity.this.hLw.bXC()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bXC.getDataList();
                                if (com.baidu.tbadk.core.util.v.Z(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && be.getPostId() == com.baidu.adp.lib.g.b.c(((PostData) next).getId(), 0L)) {
                                            if (be.getPostId() != com.baidu.adp.lib.g.b.c(PbActivity.this.hLs.bWr(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hLs.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.aa(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hNs.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hNt, cVar.lastId, PbActivity.this.hLs.bWb(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.o(rect);
                            createConfig.setIsHotSort(PbActivity.this.hLs.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hNr, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.aa(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hNs.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hNt, cVar.hNr.get(0), PbActivity.this.hLs.bWb(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hLs.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hLw.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hMF = false;
    PostData gnU = null;
    private final b.a hMG = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.gnU != null) {
                if (i == 0) {
                    PbActivity.this.gnU.em(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.gnU = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.gnU);
                }
            }
        }
    };
    private final b.a hMH = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hLV != null && !TextUtils.isEmpty(PbActivity.this.hLW)) {
                if (i == 0) {
                    if (PbActivity.this.hLX == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hLW));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hLW;
                        aVar.pkgId = PbActivity.this.hLX.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hLX.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.mPermissionJudgement.ajS();
                    PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.ad(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fWr == null) {
                            PbActivity.this.fWr = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fWr.h(PbActivity.this.hLW, PbActivity.this.hLV.nN());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hLV = null;
                PbActivity.this.hLW = null;
            }
        }
    };
    private final View.OnLongClickListener cmF = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
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
                if (PbActivity.this.cy(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.hLV = ((TbImageView) view).getBdImage();
                        PbActivity.this.hLW = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hLV == null || TextUtils.isEmpty(PbActivity.this.hLW)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hLX = null;
                        } else {
                            PbActivity.this.hLX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hLV = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hLW = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hLX = null;
                            } else {
                                PbActivity.this.hLX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hLV = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hLW = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hLX = null;
                        } else {
                            PbActivity.this.hLX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbActivity.this.hLw.a(PbActivity.this.hMH, PbActivity.this.hLV.isGif());
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
            PbActivity.this.gnU = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbActivity.this.gnU == null) {
                return true;
            }
            if (PbActivity.this.gnU.cpL() != 1 || !PbActivity.this.cy(view)) {
                if (PbActivity.this.hLu != null) {
                    if (!PbActivity.this.hLu.aaB() || PbActivity.this.gnU.getId() == null || !PbActivity.this.gnU.getId().equals(PbActivity.this.hLs.aeH())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.gnU.cpL() == 1) {
                        PbActivity.this.hLw.a(PbActivity.this.hMG, z, false);
                        return true;
                    }
                    if (PbActivity.this.hLD == null) {
                        PbActivity.this.hLD = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                        PbActivity.this.hLD.a(PbActivity.this.hMI);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cy = PbActivity.this.cy(view);
                        boolean z3 = (!PbActivity.this.cy(view) || PbActivity.this.hLV == null || PbActivity.this.hLV.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hLD);
                            gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                            gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                            gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(gVar3);
                        }
                        if (cy) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbActivity.this.getString(R.string.save_to_emotion), PbActivity.this.hLD));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbActivity.this.getString(R.string.save_to_local), PbActivity.this.hLD));
                        }
                        if (!cy && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hLD);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(R.id.tag_clip_board, PbActivity.this.gnU);
                            gVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(gVar4);
                        }
                        if (!z4) {
                            if (z) {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hLD);
                            } else {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hLD);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(R.id.tag_clip_board, PbActivity.this.gnU);
                            sparseArray4.put(R.id.tag_is_subpb, false);
                            gVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(gVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hLD);
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
                                if (!ap.m(PbActivity.this.gnU)) {
                                    on = PbActivity.this.on(z5) & PbActivity.this.isLogin();
                                } else {
                                    on = false;
                                }
                                if (on) {
                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hLD);
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
                                    gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hLD);
                                    gVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(R.id.tag_should_delete_visible, false);
                                }
                                gVar = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hLD);
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
                                    if (PbActivity.this.hLs.getPbData().bSX() == 1002 && !z5) {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hLD);
                                    } else {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hLD);
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
                        PbActivity.this.hLD.W(arrayList);
                        PbActivity.this.hLC = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hLD.ahd());
                        PbActivity.this.hLC.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").bT("tid", PbActivity.this.hLs.hQx).bT("fid", PbActivity.this.hLs.getForumId()).bT("uid", PbActivity.this.hLs.getPbData().bSL().aey().getUserId()).bT("post_id", PbActivity.this.hLs.asw()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hLw.a(PbActivity.this.hMH, PbActivity.this.hLV.isGif());
            return true;
        }
    };
    private k.c hMI = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbActivity.this.hLC != null) {
                PbActivity.this.hLC.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLs.getPbData();
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
                    if (PbActivity.this.hLV != null && !TextUtils.isEmpty(PbActivity.this.hLW)) {
                        if (PbActivity.this.hLX == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hLW));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hLW;
                            aVar.pkgId = PbActivity.this.hLX.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hLX.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hLV = null;
                        PbActivity.this.hLW = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hLV != null && !TextUtils.isEmpty(PbActivity.this.hLW)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.ajS();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.ad(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fWr == null) {
                                PbActivity.this.fWr = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fWr.h(PbActivity.this.hLW, PbActivity.this.hLV.nN());
                            PbActivity.this.hLV = null;
                            PbActivity.this.hLW = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.gnU != null) {
                        PbActivity.this.gnU.em(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.gnU = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").P("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.cx(view);
                        if (PbActivity.this.hLs.getPbData().bSL() != null && PbActivity.this.hLs.getPbData().bSL().aey() != null && PbActivity.this.hLs.getPbData().bSL().aey().getUserId() != null && PbActivity.this.hLu != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bT("tid", PbActivity.this.hLs.hQx).P("obj_locate", 2).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hLs.getPbData().bSL().aey().getUserId()).P("obj_type", PbActivity.this.hLu.aaB() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hLs.getPbData())));
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
                        PbActivity.this.BP((String) tag);
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
                        PbActivity.this.hLw.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbActivity.this.hLw.cE(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hLw.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a frT = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (!PbActivity.this.hKY && z && !PbActivity.this.hLs.bVS()) {
                PbActivity.this.bUE();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener cmw = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.eai.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0305a eaj = new a.InterfaceC0305a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        final int ekU;

        {
            this.ekU = (int) PbActivity.this.getResources().getDimension(R.dimen.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            if (ax(i2) && PbActivity.this.hLw != null && PbActivity.this.hKW != null) {
                PbActivity.this.hLw.bYi();
                PbActivity.this.hKW.kl(false);
                PbActivity.this.hKW.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            if (ax(i2) && PbActivity.this.hLw != null && PbActivity.this.hKW != null) {
                PbActivity.this.hKW.kl(true);
                if (Math.abs(i2) > this.ekU) {
                    PbActivity.this.hKW.hideFloatingView();
                }
                if (PbActivity.this.bUI()) {
                    PbActivity.this.hLw.bXz();
                    PbActivity.this.hLw.bXA();
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
    private String hMK = null;
    private final m.a hML = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hMK = str2;
                PbActivity.this.hLw.Cc(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hMM = -1;
    private int hMN = -1;
    private CustomMessageListener hMQ = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bEj == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0240a) {
                    if (aVar.bEk != null && !aVar.bEk.hasError() && aVar.bEk.getError() == 0) {
                        if (PbActivity.this.hLw != null) {
                            PbActivity.this.hLw.q(((a.C0240a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bUT();
                        }
                    } else if (z) {
                        if (aVar.bEk != null && aVar.bEk.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bEk.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bEk != null && !aVar.bEk.hasError() && aVar.bEk.getError() == 0) {
                        if (PbActivity.this.hLw != null && PbActivity.this.hLw != null) {
                            PbActivity.this.hLw.q(((a.C0240a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bEk != null && aVar.bEk.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bEk.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bEk == null || aVar.bEk.hasError() || aVar.bEk.getError() != 0) {
                        if (z) {
                            if (aVar.bEk != null && aVar.bEk.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bEk.getErrorString());
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
        public ArrayList<String> hNr;
        public ConcurrentHashMap<String, ImageUrlData> hNs;
        public boolean hNu;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hNt = false;
        public boolean hNv = false;
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

    public com.baidu.tbadk.editortools.pb.d bUe() {
        return this.hLL;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        boolean z = true;
        if (kVar.bTu() != null) {
            String id = kVar.bTu().getId();
            ArrayList<PostData> bSN = this.hLs.getPbData().bSN();
            int i = 0;
            while (true) {
                if (i >= bSN.size()) {
                    break;
                }
                PostData postData = bSN.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bTy = kVar.bTy();
                    postData.Bf(kVar.getTotalCount());
                    if (postData.cpI() != null && bTy != null) {
                        Iterator<PostData> it = bTy.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aey() != null && (metaData = postData.getUserMap().get(next.aey().getUserId())) != null) {
                                next.a(metaData);
                                next.re(true);
                                next.a(getPageContext(), this.hLs.BV(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bTy.size() != postData.cpI().size();
                        postData.cpI().clear();
                        postData.cpI().addAll(bTy);
                        z = z2;
                    }
                    if (postData.cpE() != null) {
                        postData.cpF();
                    }
                }
            }
            if (!this.hLs.getIsFromMark() && z) {
                this.hLw.m(this.hLs.getPbData());
            }
            if (z) {
                c(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bTa = this.hLs.getPbData().bTa();
            if (bTa != null && str.equals(bTa.getAdId())) {
                if (bTa.cpz() != null) {
                    bTa.cpz().legoCard = null;
                }
                this.hLs.getPbData().bTb();
            }
            com.baidu.tieba.tbadkCore.data.m bVW = this.hLs.bVW();
            if (bVW != null && str.equals(bVW.getAdId())) {
                this.hLs.bVX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.hLC != null && this.hLC.isShowing()) {
                this.hLC.dismiss();
                this.hLC = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this);
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbActivity.this.hLC != null) {
                            PbActivity.this.hLC.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hLw.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbActivity.this.hLT);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hLT);
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
                this.hLC = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar.ahd());
                this.hLC.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv(int i) {
        bh bSL;
        if (this.hLs != null && this.hLs.getPbData() != null && (bSL = this.hLs.getPbData().bSL()) != null) {
            if (i == 1) {
                PraiseData aek = bSL.aek();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aek == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bSL.a(praiseData);
                    } else {
                        bSL.aek().getUser().add(0, metaData);
                        bSL.aek().setNum(bSL.aek().getNum() + 1);
                        bSL.aek().setIsLike(i);
                    }
                }
                if (bSL.aek() != null) {
                    if (bSL.aek().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.aM(bSL.aek().getNum());
                    }
                }
            } else if (bSL.aek() != null) {
                bSL.aek().setIsLike(i);
                bSL.aek().setNum(bSL.aek().getNum() - 1);
                ArrayList<MetaData> user = bSL.aek().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bSL.aek().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bSL.aek().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = bSL.aek().getNum() + "";
                }
            }
            if (this.hLs.bVM()) {
                this.hLw.bXC().notifyDataSetChanged();
            } else {
                this.hLw.n(this.hLs.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hLs.ab(bundle);
        if (this.fun != null) {
            this.fun.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hLL.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hLc = System.currentTimeMillis();
        this.hLR = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eXw = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hLj = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hLj) && intent.getData() != null) {
                this.hLj = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hLj)) {
                this.hKX = true;
            }
            this.hMM = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hMN = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hMO = intent.getStringExtra("key_manga_title");
            this.hLG = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hLH = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hLI = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bUI()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.hLZ = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.hLq = new com.baidu.tbadk.core.data.av();
            this.hLq.O(intent);
        } else {
            this.eXw = System.currentTimeMillis();
        }
        this.czU = this.hLc - this.eXw;
        super.onCreate(bundle);
        this.hLa = 0;
        aa(bundle);
        if (this.hLs != null && this.hLs.getPbData() != null) {
            this.hLs.getPbData().BL(this.source);
        }
        bUi();
        initUI();
        if (intent != null && this.hLw != null) {
            this.hLw.hUj = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hLU == null) {
                    this.hLU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hLw.Ce("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hLU, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hLs != null && this.hLs.getPbData() != null) {
                this.hLs.BY(stringExtra);
            }
        }
        this.fun = new VoiceManager();
        this.fun.onCreate(getPageContext());
        initData(bundle);
        this.hLK = new com.baidu.tbadk.editortools.pb.f();
        bUf();
        this.hLL = (com.baidu.tbadk.editortools.pb.d) this.hLK.cK(getActivity());
        this.hLL.b(this);
        this.hLL.a(this.ctY);
        this.hLL.a(this.ctR);
        this.hLL.a(this, bundle);
        this.hLL.asa().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hLL.asa().fh(true);
        om(true);
        this.hLw.setEditorTools(this.hLL.asa());
        this.hLL.a(this.hLs.bVY(), this.hLs.bVL(), this.hLs.bWr());
        registerListener(this.hMg);
        if (!this.hLs.bVR()) {
            this.hLL.qq(this.hLs.bVL());
        }
        if (this.hLs.bWs()) {
            this.hLL.qo(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.hLw != null) {
            this.hLL.qo(this.hLw.bXn());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hMf);
        registerListener(this.hMh);
        registerListener(this.hMi);
        registerListener(this.fvI);
        registerListener(this.hMw);
        registerListener(this.hMe);
        this.hLJ = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.jfD);
        this.hLJ.cpm();
        registerListener(this.hMk);
        registerListener(this.mAttentionListener);
        if (this.hLs != null) {
            this.hLs.bWj();
        }
        registerListener(this.hMA);
        registerListener(this.hMQ);
        registerListener(this.fvP);
        if (this.hLw != null && this.hLw.bYm() != null && this.hLw.bYn() != null) {
            this.hKW = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hLw.bYm(), this.hLw.bYn(), this.hLw.bXt());
            this.hKW.a(this.hMs);
        }
        if (this.hKV && this.hLw != null && this.hLw.bYn() != null) {
            this.hLw.bYn().setVisibility(8);
        }
        this.hLS = new com.baidu.tbadk.core.view.e();
        this.hLS.bYO = 1000L;
        registerListener(this.hMv);
        registerListener(this.hMt);
        registerListener(this.hMu);
        registerListener(this.fLM);
        registerListener(this.fvF);
        this.hLT = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hLT;
        userMuteAddAndDelCustomMessage.setTag(this.hLT);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hLT;
        userMuteCheckCustomMessage.setTag(this.hLT);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hLs.bWp().a(this.dZz);
        this.hLB = new as();
        if (this.hLL.asA() != null) {
            this.hLB.k(this.hLL.asA().getInputView());
        }
        this.hLL.a(this.ctS);
        this.fKB = new ShareSuccessReplyToServerModel();
        a(this.hMb);
        this.gWQ = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gWQ.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bTn) {
                        PbActivity.this.hLL.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bTo && PbActivity.this.hLw != null && PbActivity.this.hLw.bXk() != null && PbActivity.this.hLw.bXk().bVC() != null) {
                        PbActivity.this.hLw.bXk().bVC().asT();
                    } else if (i == com.baidu.tbadk.core.util.aj.bTp) {
                        PbActivity.this.c(PbActivity.this.hLO);
                    }
                }
            }
        });
        this.hLt = new com.baidu.tieba.pb.pb.report.a(this);
        this.hLt.r(getUniqueId());
        com.baidu.tieba.q.c.coG().u(getUniqueId());
        com.baidu.tbadk.core.business.a.acs().bB("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.kd() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
        }
        this.createTime = System.currentTimeMillis() - this.hLc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUf() {
        if (this.hLK != null && this.hLs != null) {
            this.hLK.setForumName(this.hLs.bTI());
            if (this.hLs.getPbData() != null && this.hLs.getPbData().getForum() != null) {
                this.hLK.a(this.hLs.getPbData().getForum());
            }
            this.hLK.setFrom("pb");
            this.hLK.a(this.hLs);
        }
    }

    public String bUg() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bUh() {
        return this.hKW;
    }

    private void om(boolean z) {
        this.hLL.fl(z);
        this.hLL.fm(z);
        this.hLL.fn(z);
    }

    private void bUi() {
        this.cdy = new LikeModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().bTj() && !z && this.hLw != null && this.hLw.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.hLw.getView().setSystemUiVisibility(4);
        }
        this.hLP = z;
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
        if (this.fun != null) {
            this.fun.onStart(getPageContext());
        }
    }

    public aq bUj() {
        return this.hLw;
    }

    public PbModel bTR() {
        return this.hLs;
    }

    public void BO(String str) {
        if (this.hLs != null && !StringUtils.isNull(str) && this.hLw != null) {
            this.hLw.pb(true);
            this.hLs.BO(str);
            this.hLi = true;
            this.hLw.bXY();
            this.hLw.bYh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hKY = false;
        } else {
            this.hKY = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hLa = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hLa == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.fun != null) {
            this.fun.onPause(getPageContext());
        }
        if (this.hLw != null) {
            this.hLw.onPause();
        }
        if (!this.hLs.bVR()) {
            this.hLL.qp(this.hLs.bVL());
        }
        if (this.hLs != null) {
            this.hLs.bWk();
        }
        com.baidu.tbadk.BdToken.c.Zg().Zl();
        MessageManager.getInstance().unRegisterListener(this.gAP);
        byv();
        MessageManager.getInstance().unRegisterListener(this.hMt);
        MessageManager.getInstance().unRegisterListener(this.hMu);
        MessageManager.getInstance().unRegisterListener(this.hMv);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bUk() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hLs.getPbData(), this.hLs.bVM(), this.hLs.bWh());
        return (a2 == null || a2.aey() == null || a2.aey().getGodUserData() == null || a2.aey().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hKY = false;
        super.onResume();
        if (this.hLl) {
            this.hLl = false;
            bUO();
        }
        if (bUk()) {
            this.hLf = System.currentTimeMillis();
        } else {
            this.hLf = -1L;
        }
        if (this.hLw != null && this.hLw.getView() != null) {
            if (!this.hos) {
                bUF();
            } else {
                hideLoadingView(this.hLw.getView());
            }
            this.hLw.onResume();
        }
        if (this.hLa == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hLw != null) {
            noNetworkView = this.hLw.bXh();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kc()) {
            noNetworkView.eo(false);
        }
        if (this.fun != null) {
            this.fun.onResume(getPageContext());
        }
        registerListener(this.gAP);
        this.hLF = false;
        bUN();
        registerListener(this.hMt);
        registerListener(this.hMu);
        registerListener(this.hMv);
        if (this.fvc) {
            bUE();
            this.fvc = false;
        }
        bUW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hLw.oQ(z);
        if (this.hLC != null) {
            this.hLC.dismiss();
        }
        if (z && this.hLF) {
            this.hLw.bXH();
            this.hLs.oC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hLf > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").bT("obj_duration", (System.currentTimeMillis() - this.hLf) + ""));
            this.hLf = 0L;
        }
        if (bUj().bXk() != null) {
            bUj().bXk().onStop();
        }
        if (this.hLw.hUq != null && !this.hLw.hUq.baz()) {
            this.hLw.hUq.bJT();
        }
        if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().getForum() != null && this.hLs.getPbData().bSL() != null) {
            com.baidu.tbadk.distribute.a.arN().a(getPageContext().getPageActivity(), "pb", this.hLs.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hLs.getPbData().bSL().getId(), 0L));
        }
        if (this.fun != null) {
            this.fun.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.coG().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.coG().v(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bT("fid", this.hLs.getPbData().getForumId());
            anVar.bT("tid", this.hLs.bVL());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hLd && this.hLw != null) {
            this.hLd = true;
            this.hLw.bYd();
            a(false, (PostData) null);
        }
        if (this.hLs != null) {
            this.hLs.cancelLoadData();
            this.hLs.destory();
            if (this.hLs.bWo() != null) {
                this.hLs.bWo().onDestroy();
            }
        }
        if (this.hLL != null) {
            this.hLL.onDestroy();
        }
        if (this.eDC != null) {
            this.eDC.cancelLoadData();
        }
        if (this.cdy != null) {
            this.cdy.cpa();
        }
        if (this.hLw != null) {
            this.hLw.onDestroy();
            if (this.hLw.hUq != null) {
                this.hLw.hUq.bJT();
            }
        }
        if (this.hLe != null) {
            this.hLe.avn();
        }
        if (this.hKW != null) {
            this.hKW.awx();
        }
        super.onDestroy();
        if (this.fun != null) {
            this.fun.onDestory(getPageContext());
        }
        this.hLw.bXY();
        MessageManager.getInstance().unRegisterListener(this.hMt);
        MessageManager.getInstance().unRegisterListener(this.hMu);
        MessageManager.getInstance().unRegisterListener(this.hMv);
        MessageManager.getInstance().unRegisterListener(this.hLT);
        MessageManager.getInstance().unRegisterListener(this.hMw);
        MessageManager.getInstance().unRegisterListener(this.fvP);
        MessageManager.getInstance().unRegisterListener(this.fLM);
        MessageManager.getInstance().unRegisterListener(this.hMy);
        this.hLR = null;
        this.hLS = null;
        com.baidu.tieba.recapp.d.a.ciL().ciN();
        if (this.hLU != null) {
            getSafeHandler().removeCallbacks(this.hLU);
        }
        if (this.hLm != null) {
            this.hLm.cancelLoadData();
        }
        if (this.hLw != null && this.hLw.hUq != null) {
            this.hLw.hUq.bYZ();
        }
        if (this.fKB != null) {
            this.fKB.cancelLoadData();
        }
        this.hLB.onDestroy();
        if (this.hLs != null && this.hLs.bWq() != null) {
            this.hLs.bWq().onDestroy();
        }
        if (this.gWQ != null) {
            this.gWQ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bXC;
        ArrayList<PostData> bVn;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.amd() && this.hLw != null && (bXC = this.hLw.bXC()) != null && (bVn = bXC.bVn()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bVn.iterator();
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
                        bVar.eFy = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.bKG == 1 && !TextUtils.isEmpty(id)) {
                    next.bKG = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.eFy = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hLs == null || this.hLs.getPbData() == null || this.hLs.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hLs.getPbData().getForum().getFirst_class();
                    str2 = this.hLs.getPbData().getForum().getSecond_class();
                    str = this.hLs.getPbData().getForum().getId();
                    str4 = this.hLs.bVL();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.amg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.hLw.onChangeSkinType(i);
            if (this.hLL != null && this.hLL.asa() != null) {
                this.hLL.asa().onChangeSkinType(i);
            }
            if (this.hLw.bXh() != null) {
                this.hLw.bXh().onChangeSkinType(getPageContext(), i);
            }
            this.hLB.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.a(i, getResources(), (int) R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hLw = new aq(this, this.fwx, this.clA);
        this.eai = new com.baidu.tieba.f.b(getActivity());
        this.eai.a(hMJ);
        this.eai.a(this.eaj);
        this.hLw.setOnScrollListener(this.mOnScrollListener);
        this.hLw.e(this.fOO);
        this.hLw.setListPullRefreshListener(this.cZn);
        this.hLw.og(com.baidu.tbadk.core.i.aca().ace());
        this.hLw.setOnImageClickListener(this.cKo);
        this.hLw.b(this.cmF);
        this.hLw.h(this.frT);
        this.hLw.a(this.hMC);
        this.hLw.oQ(this.mIsLogin);
        if (getIntent() != null) {
            this.hLw.pc(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hLw.bXj().setFromForumId(this.hLs.getFromForumId());
    }

    public void bUl() {
        if (this.hLw != null && this.hLs != null) {
            if ((this.hLs.getPbData() != null || this.hLs.getPbData().bTi() != null) && checkUpIsLogin() && this.hLw.bXC() != null && this.hLw.bXC().bVs() != null) {
                this.hLw.bXC().bVs().oS(this.hLs.bVL());
            }
        }
    }

    public void bUm() {
        TiebaStatic.log("c12181");
        if (this.hLw != null && this.hLs != null) {
            if (this.hLw == null || this.hLw.bXm()) {
                if (this.hLs.getPbData() != null || this.hLs.getPbData().bTi() != null) {
                    com.baidu.tieba.pb.data.j bTi = this.hLs.getPbData().bTi();
                    if (checkUpIsLogin()) {
                        if ((!bTi.bTr() || bTi.afU() != 2) && this.hLw.bXC() != null && this.hLw.bXC().bVs() != null) {
                            this.hLw.bXC().bVs().oS(this.hLs.bVL());
                        }
                        if (System.currentTimeMillis() - this.hLh > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).pw(false);
                            this.hLh = System.currentTimeMillis();
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
                if (postData.getType() != PostData.jgf && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.aca().ace()) {
                    return BR(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hLs == null || this.hLs.getPbData() == null) {
                        return true;
                    }
                    if (bUj().bXk() != null) {
                        bUj().bXk().bVy();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.hLs.getPbData().getForum());
                    kVar.aj(this.hLs.getPbData().bSL());
                    kVar.e(postData);
                    bUj().bXj().d(kVar);
                    bUj().bXj().setPostId(postData.getId());
                    a(view, postData.aey().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hLL != null) {
                        this.hLw.oW(this.hLL.asH());
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
        if (this.hLw != null) {
            if (z && !this.hos) {
                bUF();
            } else {
                hideLoadingView(this.hLw.getView());
            }
            if (z && this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().bTj() && this.hLw.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                this.hLw.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bUn() {
        if (this.hLb == null) {
            this.hLb = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hLb.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hKQ = PbActivity.this.hKQ.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKQ);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hLs.bVL(), PbActivity.this.hKQ, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hKQ = PbActivity.this.hKQ.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKQ);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hLs.bVL(), PbActivity.this.hKQ, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hKQ = PbActivity.this.hKQ.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKQ);
                        bVar.dismiss();
                    }
                }
            }).hz(R.style.dialog_ani_b2t).hA(17).d(getPageContext());
        }
    }

    private void aa(Bundle bundle) {
        this.hLs = new PbModel(this);
        this.hLs.a(this.hMz);
        if (this.hLs.bWn() != null) {
            this.hLs.bWn().a(this.hML);
        }
        if (this.hLs.bWm() != null) {
            this.hLs.bWm().a(this.hMj);
        }
        if (this.hLs.bWo() != null) {
            this.hLs.bWo().b(this.hMd);
        }
        if (bundle != null) {
            this.hLs.initWithBundle(bundle);
        } else {
            this.hLs.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hLs.oF(true);
        }
        aj.bWV().au(this.hLs.bVJ(), this.hLs.getIsFromMark());
        if (StringUtils.isNull(this.hLs.bVL())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hLj) && this.hLj != null) {
            this.hLs.yc(6);
        }
        this.hLs.auF();
    }

    private void initData(Bundle bundle) {
        this.hLu = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hLu != null) {
            this.hLu.a(this.hMB);
        }
        this.eDC = new ForumManageModel(this);
        this.eDC.setLoadDataCallBack(this.eDG);
        this.bTs = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hLw.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kc()) {
                    PbActivity.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hLs.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLs.getPbData().getForum().getId(), PbActivity.this.hLs.getPbData().getForum().getName(), PbActivity.this.hLs.getPbData().bSL().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hMp.setUniqueId(getUniqueId());
        this.hMp.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hLw.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hLT;
        userMuteCheckCustomMessage.setTag(this.hLT);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bUo() {
        if (checkUpIsLogin()) {
            if (this.fxS == null) {
                this.fxS = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fxS.sC(0);
                this.fxS.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void kf(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void n(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void kg(boolean z) {
                        if (z) {
                            PbActivity.this.hLw.bxH();
                        }
                    }
                });
            }
            if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().getForum() != null) {
                this.fxS.t(this.hLs.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hLs.bVL(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bUp() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hLs != null && (pbData = this.hLs.getPbData()) != null) {
            return pbData.bSW().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bSL() != null) {
            if (dVar.bSL().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bSL().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bSL().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bUq()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hLo);
                this.hLp = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hLN == null) {
                this.hLN = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hLN.sC(1);
                this.hLN.a(new AnonymousClass40(str, str2));
            }
            if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().getForum() != null) {
                this.hLN.t(this.hLs.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hLs.bVL(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$40  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String hNa;
        final /* synthetic */ String hNb;

        AnonymousClass40(String str, String str2) {
            this.hNa = str;
            this.hNb = str2;
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
                        PbActivity.this.bUj().getListView().smoothScrollBy((PbActivity.this.hLo[1] + PbActivity.this.hLp) - (ah - g), 50);
                        if (PbActivity.this.bUj().bXk() != null) {
                            PbActivity.this.hLL.asa().setVisibility(8);
                            PbActivity.this.bUj().bXk().Y(AnonymousClass40.this.hNa, AnonymousClass40.this.hNb, PbActivity.this.bUj().bXn());
                            com.baidu.tbadk.editortools.pb.g bVC = PbActivity.this.bUj().bXk().bVC();
                            if (bVC != null && PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                                bVC.a(PbActivity.this.hLs.getPbData().getAnti());
                            }
                            if (PbActivity.this.hLB.bYA() == null && PbActivity.this.bUj().bXk().bVC().atb() != null) {
                                PbActivity.this.bUj().bXk().bVC().atb().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hLB != null && PbActivity.this.hLB.bYz() != null) {
                                            if (!PbActivity.this.hLB.bYz().czC()) {
                                                PbActivity.this.hLB.pe(false);
                                            }
                                            PbActivity.this.hLB.bYz().sb(false);
                                        }
                                    }
                                });
                                PbActivity.this.hLB.l(PbActivity.this.bUj().bXk().bVC().atb().getInputView());
                                PbActivity.this.bUj().bXk().bVC().a(PbActivity.this.hLQ);
                            }
                        }
                        PbActivity.this.bUj().bYh();
                    }
                }, 0L);
            }
        }
    }

    public boolean bUq() {
        if (this.gWQ == null || this.hLs.getPbData() == null || this.hLs.getPbData().getAnti() == null) {
            return true;
        }
        return this.gWQ.m19if(this.hLs.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean xL(int i) {
        if (this.gWQ == null || this.hLs.getPbData() == null || this.hLs.getPbData().getAnti() == null) {
            return true;
        }
        return this.gWQ.U(this.hLs.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.hLs != null && this.hLs.getPbData() != null && postData.cpL() != 1) {
            String bVL = this.hLs.bVL();
            String id = postData.getId();
            int bSX = this.hLs.getPbData() != null ? this.hLs.getPbData().bSX() : 0;
            c BS = BS(id);
            if (BS != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bVL, id, "pb", true, null, false, null, bSX, postData.bZO(), this.hLs.getPbData().getAnti(), false, postData.aey() != null ? postData.aey().getIconInfo() : null).addBigImageData(BS.hNr, BS.hNs, BS.hNt, BS.index);
                addBigImageData.setKeyPageStartFrom(this.hLs.bWu());
                addBigImageData.setFromFrsForumId(this.hLs.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bUr() {
        if (this.hLs.getPbData() == null || this.hLs.getPbData().bSL() == null) {
            return -1;
        }
        return this.hLs.getPbData().bSL().afi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUs() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Eg(this.hLs.getForumId()) && this.hLs.getPbData() != null && this.hLs.getPbData().getForum() != null) {
            if (this.hLs.getPbData().getForum().isLike() == 1) {
                this.hLs.bWq().ee(this.hLs.getForumId(), this.hLs.bVL());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean on(boolean z) {
        if (this.hLs == null || this.hLs.getPbData() == null) {
            return false;
        }
        return ((this.hLs.getPbData().bSX() != 0) || this.hLs.getPbData().bSL() == null || this.hLs.getPbData().bSL().aey() == null || TextUtils.equals(this.hLs.getPbData().bSL().aey().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bUt() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.t.y.avT()) {
            return "";
        }
        PostData bSS = bSS();
        if (this.hLs == null || (pbData = this.hLs.getPbData()) == null || pbData.getUserData() == null || pbData.bSL() == null || bSS == null || bSS.aey() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bSS.aey().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bSL().aef() == 0) {
            return "";
        }
        if (pbData.bSL().aef() == 0) {
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
        if (this.hLs == null || this.hLs.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hLs.getPbData();
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.bSX() != 0) {
                return pbData.bSX() != 3;
            }
            List<com.baidu.tbadk.core.data.bd> bTg = pbData.bTg();
            if (com.baidu.tbadk.core.util.v.Z(bTg) > 0) {
                for (com.baidu.tbadk.core.data.bd bdVar : bTg) {
                    if (bdVar != null && (vVar = bdVar.bIW) != null && vVar.bGL && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
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
        if (z || this.hLs == null || this.hLs.getPbData() == null) {
            return false;
        }
        return ((this.hLs.getPbData().getForum() != null && this.hLs.getPbData().getForum().isBlockBawuDelete) || this.hLs.getPbData().bSX() == 0 || this.hLs.getPbData().bSX() == 3) ? false : true;
    }

    public void bUu() {
        if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().bSL() != null && this.hLs.getPbData().bSL().aey() != null) {
            if (this.hLw != null) {
                this.hLw.bXi();
            }
            bh bSL = this.hLs.getPbData().bSL();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bSL.aey().getUserId());
            ab abVar = new ab();
            int bSX = this.hLs.getPbData().bSX();
            if (bSX == 1 || bSX == 3) {
                abVar.hSA = true;
                abVar.hSz = true;
                abVar.hSH = bSL.aet() == 1;
                abVar.hSG = bSL.aeu() == 1;
            } else {
                abVar.hSA = false;
                abVar.hSz = false;
            }
            if (bSX == 1002 && !equals) {
                abVar.hSL = true;
            }
            abVar.hSB = oo(equals);
            abVar.hSC = bUv();
            abVar.hSD = op(equals);
            abVar.oy = this.hLs.bVM();
            abVar.hSy = true;
            abVar.hSx = on(equals);
            abVar.hSJ = bUt();
            abVar.hSw = equals && this.hLw.bXO();
            abVar.hSE = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hSF = true;
            abVar.isHostOnly = this.hLs.getHostMode();
            abVar.hSI = true;
            if (bSL.aeP() == null) {
                abVar.hSK = true;
            } else {
                abVar.hSK = false;
            }
            this.hLw.hUq.a(abVar);
        }
    }

    private boolean bUv() {
        if (this.hLs != null && this.hLs.bVM()) {
            return this.hLs.getPageData() == null || this.hLs.getPageData().adt() != 0;
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

    public int bUw() {
        if (bUj() == null || bUj().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bUj().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.i) && ((com.baidu.tieba.pb.data.i) mVar).mType == com.baidu.tieba.pb.data.i.hJf) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bUx() {
        if (bUj() == null || bUj().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bUj().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.jge) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bUE();
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
                    PbActivity.this.bTs.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hLs.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).agK();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hLw.bXI();
        this.hLs.oE(z);
        if (this.hLu != null) {
            this.hLu.dx(z);
            if (markData != null) {
                this.hLu.a(markData);
            }
        }
        if (this.hLs.aaB()) {
            bUC();
        } else {
            this.hLw.m(this.hLs.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xJ(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP(String str) {
        this.hLt.Cn(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hLs.bVR()) {
                    antiData.setBlock_forum_name(this.hLs.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hLs.getPbData().getForum().getId());
                    antiData.setUser_name(this.hLs.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hLs.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bUj() != null) {
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").P("obj_locate", au.a.bUi));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").P("obj_locate", au.a.bUi));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").P("obj_locate", au.a.bUi));
            }
        } else if (i == 230277) {
            qv(str);
        } else {
            this.hLw.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.jiM) ? bVar.jiM : getString(R.string.delete_fail);
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
                aVar.agK();
            } else {
                this.hLw.a(0, bVar.FU, bVar.jiM, z);
            }
            if (bVar.FU) {
                if (bVar.faI == 1) {
                    ArrayList<PostData> bSN = this.hLs.getPbData().bSN();
                    int size = bSN.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bSN.get(i).getId())) {
                            i++;
                        } else {
                            bSN.remove(i);
                            break;
                        }
                    }
                    this.hLs.getPbData().bSL().hi(this.hLs.getPbData().bSL().aep() - 1);
                    this.hLw.m(this.hLs.getPbData());
                } else if (bVar.faI == 0) {
                    bUy();
                } else if (bVar.faI == 2) {
                    ArrayList<PostData> bSN2 = this.hLs.getPbData().bSN();
                    int size2 = bSN2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bSN2.get(i2).cpI().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bSN2.get(i2).cpI().get(i3).getId())) {
                                i3++;
                            } else {
                                bSN2.get(i2).cpI().remove(i3);
                                bSN2.get(i2).cpK();
                                z2 = true;
                                break;
                            }
                        }
                        bSN2.get(i2).EK(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hLw.m(this.hLs.getPbData());
                    }
                    a(bVar, this.hLw);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hLw.a(this.eDC.getLoadDataMode(), gVar.FU, gVar.jiM, false);
            if (gVar.FU) {
                this.hLy = true;
                if (i == 2 || i == 3) {
                    this.hLz = true;
                    this.hLA = false;
                } else if (i == 4 || i == 5) {
                    this.hLz = false;
                    this.hLA = true;
                }
                if (i == 2) {
                    this.hLs.getPbData().bSL().hl(1);
                    this.hLs.setIsGood(1);
                } else if (i == 3) {
                    this.hLs.getPbData().bSL().hl(0);
                    this.hLs.setIsGood(0);
                } else if (i == 4) {
                    this.hLs.getPbData().bSL().hk(1);
                    this.hLs.pV(1);
                } else if (i == 5) {
                    this.hLs.getPbData().bSL().hk(0);
                    this.hLs.pV(0);
                }
                this.hLw.d(this.hLs.getPbData(), this.hLs.bVM());
            }
        }
    }

    private void bUy() {
        if (this.hLs.bVN() || this.hLs.bVP()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hLs.bVL());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hLs.bVL()));
        if (bUD()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUz() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bSU;
        boolean z = false;
        if (this.hLw != null) {
            this.hLw.bXY();
        }
        if (this.hLs != null && this.hLs.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hLs.getPbData().bSL().getId();
            if (this.hLs.isShareThread() && this.hLs.getPbData().bSL().bLV != null) {
                historyMessage.threadName = this.hLs.getPbData().bSL().bLV.showText;
            } else {
                historyMessage.threadName = this.hLs.getPbData().bSL().getTitle();
            }
            if (this.hLs.isShareThread() && !bTH()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hLs.getPbData().getForum().getName();
            }
            ArrayList<PostData> bSN = this.hLs.getPbData().bSN();
            int bXK = this.hLw != null ? this.hLw.bXK() : 0;
            if (bSN != null && bXK >= 0 && bXK < bSN.size()) {
                historyMessage.postID = bSN.get(bXK).getId();
            }
            historyMessage.isHostOnly = this.hLs.getHostMode();
            historyMessage.isSquence = this.hLs.bVM();
            historyMessage.isShareThread = this.hLs.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hLL != null) {
            this.hLL.onDestroy();
        }
        if (this.hKZ && bUj() != null) {
            bUj().bYr();
        }
        if (this.hLs != null && (this.hLs.bVN() || this.hLs.bVP())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hLs.bVL());
            if (this.hLy) {
                if (this.hLA) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hLs.bfr());
                }
                if (this.hLz) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hLs.getIsGood());
                }
            }
            if (this.hLs.getPbData() != null && System.currentTimeMillis() - this.hLc >= 40000 && (bSU = this.hLs.getPbData().bSU()) != null && !com.baidu.tbadk.core.util.v.aa(bSU.getDataList())) {
                intent.putExtra("guess_like_data", bSU);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hLZ);
            }
            setResult(-1, intent);
        }
        if (bUD()) {
            if (this.hLs != null && this.hLw != null && this.hLw.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hLs.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bSR() && !this.hLi && pbData.hIN == null) {
                        aj bWV = aj.bWV();
                        com.baidu.tieba.pb.data.d bVT = this.hLs.bVT();
                        Parcelable onSaveInstanceState = this.hLw.getListView().onSaveInstanceState();
                        boolean bVM = this.hLs.bVM();
                        boolean hostMode = this.hLs.getHostMode();
                        if (this.hLw.bXt() != null && this.hLw.bXt().getVisibility() == 0) {
                            z = true;
                        }
                        bWV.a(bVT, onSaveInstanceState, bVM, hostMode, z);
                        if (this.hLY >= 0 || this.hLs.bWw() != null) {
                            aj.bWV().l(this.hLs.bWw());
                            aj.bWV().k(this.hLs.bWx());
                            aj.bWV().ye(this.hLs.bWy());
                        }
                    }
                }
            } else {
                aj.bWV().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hLw == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hLw.yj(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xM(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.hLw.bXi();
            this.hLw.bXk().bVy();
            this.hLw.oY(false);
        }
        this.hLw.bXl();
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
                        this.hLL.resetData();
                        this.hLL.b(writeData);
                        this.hLL.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k kq = this.hLL.asa().kq(6);
                        if (kq != null && kq.csa != null) {
                            kq.csa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hLL.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hLw.bXk() != null && this.hLw.bXk().bVC() != null) {
                            com.baidu.tbadk.editortools.pb.g bVC = this.hLw.bXk().bVC();
                            bVC.b(writeData);
                            bVC.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k kq2 = bVC.asa().kq(6);
                            if (kq2 != null && kq2.csa != null) {
                                kq2.csa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bVC.asT();
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
        this.hLL.onActivityResult(i, i2, intent);
        if (this.hLm != null) {
            this.hLm.onActivityResult(i, i2, intent);
        }
        if (bUj().bXk() != null) {
            bUj().bXk().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    bUB();
                    return;
                case 13008:
                    aj.bWV().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hLs != null) {
                                PbActivity.this.hLs.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.chD().y(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hLs != null) {
                        a(bUA(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    ai(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.chD().y(getPageContext());
                        bUs();
                        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.fKB != null && shareItem != null && shareItem.linkUrl != null) {
                            this.fKB.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aoP() {
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
                    this.hLw.ol(false);
                    if (this.hLs.getPbData() != null && this.hLs.getPbData().bSL() != null && this.hLs.getPbData().bSL().aeS() != null) {
                        this.hLs.getPbData().bSL().aeS().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hLO = emotionImageData;
                        if (xL(com.baidu.tbadk.core.util.aj.bTp)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hLw != null && this.hLw.hUq != null) {
                        this.hLw.hUq.UM();
                        this.hLw.hUq.bYT();
                        if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().bSL() != null) {
                            this.hLs.getPbData().bSL().hf(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hLn != null) {
                        this.hLw.cF(this.hLn);
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
            if (this.hLm == null) {
                this.hLm = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hLm.b(this.ctR);
                this.hLm.c(this.ctY);
            }
            this.hLm.a(emotionImageData, bTR(), bTR().getPbData());
        }
    }

    private ShareFromPBMsgData bUA() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ec = this.hLs.getPbData().ec(getPageContext().getPageActivity());
        PostData bXo = this.hLw.bXo();
        String str = "";
        if (bXo != null) {
            str = bXo.getId();
            String en = bXo.en(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(en)) {
                ec[1] = en;
            }
        }
        String aeO = this.hLs.getPbData().bSL().aeO();
        if (aeO != null && aeO.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ec[1]);
        shareFromPBMsgData.setImageUrl(ec[0]);
        shareFromPBMsgData.setForumName(this.hLs.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hLs.getPbData().bSL().getId());
        shareFromPBMsgData.setTitle(this.hLs.getPbData().bSL().getTitle());
        return shareFromPBMsgData;
    }

    private void ai(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bUA(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().bSL() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hx(1);
            aVar.aH(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null) {
                        com.baidu.tbadk.core.util.an bT = new com.baidu.tbadk.core.util.an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).P("obj_param1", 3).bT("fid", PbActivity.this.hLs.getForumId()).bT("tid", PbActivity.this.hLs.bVL());
                        if (PbActivity.this.d(PbActivity.this.hLs.getPbData()) != 0) {
                            bT.P("obj_type", PbActivity.this.d(PbActivity.this.hLs.getPbData()));
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
            aVar.b(getPageContext()).agK();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), this.hLs.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().bSL() != null) {
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
            aVar.b(getPageContext()).agK();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), this.hLs.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUB() {
        MarkData yb;
        if (this.hLu != null && (yb = this.hLs.yb(this.hLw.bXL())) != null) {
            if (!yb.isApp() || (yb = this.hLs.yb(this.hLw.bXL() + 1)) != null) {
                this.hLw.bXG();
                this.hLu.a(yb);
                if (!this.hLu.aaB()) {
                    this.hLu.aaD();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hLu.aaC();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUC() {
        com.baidu.tieba.pb.data.d pbData = this.hLs.getPbData();
        this.hLs.oE(true);
        if (this.hLu != null) {
            pbData.BK(this.hLu.aaA());
        }
        this.hLw.m(pbData);
    }

    private boolean bUD() {
        if (this.hLs == null) {
            return true;
        }
        if (this.hLs.aaB()) {
            final MarkData bWd = this.hLs.bWd();
            if (bWd == null || !this.hLs.getIsFromMark()) {
                return true;
            }
            final MarkData yb = this.hLs.yb(this.hLw.bXK());
            if (yb == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bWd);
                setResult(-1, intent);
                return true;
            } else if (yb.getPostId() == null || yb.getPostId().equals(bWd.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bWd);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mO(getPageContext().getString(R.string.alert_update_mark));
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hLu != null) {
                            if (PbActivity.this.hLu.aaB()) {
                                PbActivity.this.hLu.aaC();
                                PbActivity.this.hLu.dx(false);
                            }
                            PbActivity.this.hLu.a(yb);
                            PbActivity.this.hLu.dx(true);
                            PbActivity.this.hLu.aaD();
                        }
                        bWd.setPostId(yb.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bWd);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bUz();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bWd);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bUz();
                    }
                });
                aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hLw != null && PbActivity.this.hLw.getView() != null) {
                            PbActivity.this.hLw.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bWd);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bUz();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.agK();
                return false;
            }
        } else if (this.hLs.getPbData() == null || this.hLs.getPbData().bSN() == null || this.hLs.getPbData().bSN().size() <= 0 || !this.hLs.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hLw == null) {
            return null;
        }
        return this.hLw.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azu() {
        if (this.hLw == null) {
            return 0;
        }
        return this.hLw.bXW();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azv() {
        if (this.cKf == null) {
            this.cKf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
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
        return this.cKf;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azw() {
        if (this.cMU == null) {
            this.cMU = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cMU;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azx() {
        if (this.cKg == null) {
            this.cKg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bUZ */
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
                    gifView.atv();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cKg;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azy() {
        if (this.cMV == null) {
            this.cMV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVa */
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
                    ((PlayVoiceBntNew) view).cqV();
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
        return this.cMV;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azA() {
        this.cMX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bVb */
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
        return this.cMX;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> alg() {
        if (this.cda == null) {
            this.cda = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.cda;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hLg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (av.Cf(str) && this.hLs != null && this.hLs.bVL() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").P("obj_param1", 1).bT("post_id", this.hLs.bVL()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.cqZ = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
            }
        } else {
            av.bYC().c(getPageContext(), str);
        }
        this.hLg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        av.bYC().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hLg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Rect rect) {
        if (rect != null && this.hLw != null && this.hLw.bYm() != null && rect.top <= this.hLw.bYm().getHeight()) {
            rect.top += this.hLw.bYm().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hLs.getPbData();
            TbRichText be = be(str, i);
            if (be != null && (tbRichTextData = be.ayN().get(this.hME)) != null) {
                cVar.hNr = new ArrayList<>();
                cVar.hNs = new ConcurrentHashMap<>();
                if (!tbRichTextData.ayU().azg()) {
                    cVar.hNu = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hNr.add(b2);
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
                    imageUrlData.mIsReserver = this.hLs.bWb();
                    imageUrlData.mIsSeeHost = this.hLs.getHostMode();
                    cVar.hNs.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bSL() != null) {
                            cVar.threadId = pbData.bSL().getId();
                        }
                        cVar.hNt = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.hNu = true;
                int size = pbData.bSN().size();
                this.hMF = false;
                cVar.index = -1;
                if (pbData.bSS() != null) {
                    PostData bSS = pbData.bSS();
                    TbRichText cpN = bSS.cpN();
                    if (!ap.m(bSS)) {
                        i2 = a(cpN, be, i, i, cVar.hNr, cVar.hNs);
                    } else {
                        i2 = a(bSS, i, cVar.hNr, cVar.hNs);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bSN().get(i4);
                    if (postData.getId() == null || pbData.bSS() == null || pbData.bSS().getId() == null || !postData.getId().equals(pbData.bSS().getId())) {
                        TbRichText cpN2 = postData.cpN();
                        if (!ap.m(postData)) {
                            i3 = a(cpN2, be, i3, i, cVar.hNr, cVar.hNs);
                        } else {
                            i3 = a(postData, i3, cVar.hNr, cVar.hNs);
                        }
                    }
                }
                if (cVar.hNr.size() > 0) {
                    cVar.lastId = cVar.hNr.get(cVar.hNr.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bSL() != null) {
                        cVar.threadId = pbData.bSL().getId();
                    }
                    cVar.hNt = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ayU() == null) {
            return null;
        }
        return tbRichTextData.ayU().azl();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ayU() == null) {
            return 0L;
        }
        return tbRichTextData.ayU().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ayU() == null) {
            return false;
        }
        return tbRichTextData.ayU().azm();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ayU() == null) {
            return false;
        }
        return tbRichTextData.ayU().azn();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo ayU;
        String str;
        if (tbRichText == tbRichText2) {
            this.hMF = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.ayN().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.ayN().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.ayU().getWidth() * ai;
                    int height = ai * tbRichTextData.ayU().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.ayU().azg()) {
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
                            if (tbRichTextData != null && (ayU = tbRichTextData.ayU()) != null) {
                                String azi = ayU.azi();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = ayU.azj();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = azi;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hLs.bVL(), -1L);
                                imageUrlData.mIsReserver = this.hLs.bWb();
                                imageUrlData.mIsSeeHost = this.hLs.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hMF) {
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
        com.baidu.tieba.tbadkCore.data.i cpU;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cpq;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cpq = (cpU = postData.cpU()).cpq()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cpq.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cpq.get(i3);
                if (kVar != null) {
                    String cpu = kVar.cpu();
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(cpu)) {
                        arrayList.add(cpu);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cpu;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cpt();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hLs.bVL(), -1L);
                        imageUrlData.mIsReserver = this.hLs.bWb();
                        imageUrlData.mIsSeeHost = this.hLs.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cpU.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cpu, imageUrlData);
                        }
                        if (!this.hMF) {
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
            if (postData.getId() != null && postData.getId().equals(this.hLs.aeH())) {
                z = true;
            }
            MarkData j = this.hLs.j(postData);
            if (j != null) {
                this.hLw.bXG();
                if (this.hLu != null) {
                    this.hLu.a(j);
                    if (!z) {
                        this.hLu.aaD();
                    } else {
                        this.hLu.aaC();
                    }
                }
            }
        }
    }

    public boolean cy(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText be(String str, int i) {
        TbRichText tbRichText = null;
        if (this.hLs == null || this.hLs.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hLs.getPbData();
        if (pbData.bSS() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bSS());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bSN = pbData.bSN();
            a(pbData, bSN);
            return a(bSN, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bSW() != null && dVar.bSW().hJu != null && (list = dVar.bSW().hJu) != null && arrayList != null) {
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

    private long BQ(String str) {
        ArrayList<PostData> bSN;
        com.baidu.tieba.pb.data.d pbData = this.hLs.getPbData();
        if (pbData != null && (bSN = pbData.bSN()) != null && !bSN.isEmpty()) {
            Iterator<PostData> it = bSN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cpU = next.cpU();
                if (cpU != null && cpU.jfL) {
                    Iterator<TbRichTextData> it2 = next.cpN().ayN().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.azd().getLink().equals(str)) {
                            return cpU.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> ayN;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cpN = arrayList.get(i2).cpN();
            if (cpN != null && (ayN = cpN.ayN()) != null) {
                int size = ayN.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (ayN.get(i4) != null && ayN.get(i4).getType() == 8) {
                        i3++;
                        if (ayN.get(i4).ayU().azi().equals(str) || ayN.get(i4).ayU().azj().equals(str)) {
                            int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                            int width = ayN.get(i4).ayU().getWidth() * ai;
                            int height = ayN.get(i4).ayU().getHeight() * ai;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hME = i4;
                            return cpN;
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
            this.hKQ = str;
            if (this.hLb == null) {
                bUn();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hLb.hC(1).setVisibility(8);
            } else {
                this.hLb.hC(1).setVisibility(0);
            }
            this.hLb.agN();
            this.hLg = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fun;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUE() {
        hideNetRefreshView(this.hLw.getView());
        bUF();
        if (this.hLs.auF()) {
            this.hLw.bXG();
        }
    }

    private void bUF() {
        showLoadingView(this.hLw.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View atL = getLoadingView().atL();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) atL.getLayoutParams();
        layoutParams.addRule(3, this.hLw.bYm().getId());
        atL.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmt() {
        if (this.fun != null) {
            this.fun.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
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
    public void xO(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        bh bSL;
        if (this.hLs.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hLs.getPbData();
            pbData.getForum().getName();
            String title = pbData.bSL().getTitle();
            int i2 = this.hLs.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Eg(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hLs.bVL() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] ec = pbData.ec(getPageContext().getPageActivity());
                    str = ec[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = ec[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bUr() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").bT("fid", pbData.getForumId()).bT("tid", pbData.getThreadId()).bT("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                    eVar.title = title;
                    eVar.content = str2;
                    eVar.linkUrl = str3;
                    eVar.ckz = true;
                    eVar.ckG = z;
                    eVar.extData = this.hLs.bVL();
                    eVar.ckS = 3;
                    eVar.ckR = i;
                    eVar.fid = this.hLs.getForumId();
                    eVar.tid = this.hLs.bVL();
                    eVar.ckW = d(pbData);
                    eVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        eVar.imageUri = parse;
                    }
                    bSL = this.hLs.getPbData().bSL();
                    eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bSL);
                    TbadkCoreApplication.getInst().setShareItem(eVar);
                    if (bSL != null) {
                        eVar.clg = bSL.getShareImageUrl();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", eVar.ckS);
                    bundle.putInt("obj_type", eVar.ckW);
                    bundle.putString("fid", eVar.fid);
                    bundle.putString("tid", eVar.tid);
                    bundle.putString("uid", eVar.uid);
                    eVar.E(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bTj() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                                PbActivity.this.hLw.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.bbD().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hLs.bVL() + "?share=9105&fr=share&see_lz=" + i2;
            String[] ec2 = pbData.ec(getPageContext().getPageActivity());
            str = ec2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = ec2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bUr() == 1) {
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = str2;
            eVar2.linkUrl = str32;
            eVar2.ckz = true;
            eVar2.ckG = z;
            eVar2.extData = this.hLs.bVL();
            eVar2.ckS = 3;
            eVar2.ckR = i;
            eVar2.fid = this.hLs.getForumId();
            eVar2.tid = this.hLs.bVL();
            eVar2.ckW = d(pbData);
            eVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            bSL = this.hLs.getPbData().bSL();
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bSL);
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            if (bSL != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.ckS);
            bundle2.putInt("obj_type", eVar2.ckW);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putString("uid", eVar2.uid);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hLs != null && PbActivity.this.hLs.getPbData() != null && PbActivity.this.hLs.getPbData().bTj() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                        PbActivity.this.hLw.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.bbD().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bSL() != null) {
            if (dVar.bSL().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bSL().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUG() {
        com.baidu.tbadk.util.aa.a(new com.baidu.tbadk.util.z<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.Eh(PbActivity.this.hLs.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hLw.bYs();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azz() {
        if (this.cMW == null) {
            this.cMW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bVc */
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
        return this.cMW;
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

    public void bmu() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bli() {
        if (this.hLs == null || this.hLs.getPbData() == null) {
            return null;
        }
        return this.hLs.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.agM() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.agM();
            int intValue = ((Integer) sparseArray.get(aq.hWj)).intValue();
            if (intValue == aq.hWk) {
                if (!this.eDC.cqx()) {
                    this.hLw.bXD();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eDC.EQ(com.baidu.tbadk.core.util.aq.y(jSONArray));
                    }
                    this.eDC.a(this.hLs.getPbData().getForum().getId(), this.hLs.getPbData().getForum().getName(), this.hLs.getPbData().bSL().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hWl || intValue == aq.hWn) {
                if (this.hLs.bWn() != null) {
                    this.hLs.bWn().xR(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hWl) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hLT);
        userMuteAddAndDelCustomMessage.setTag(this.hLT);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean BR(String str) {
        if (!StringUtils.isNull(str) && bd.cF(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("bubble_link", "");
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
        this.hLF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bUH() {
        ArrayList<PostData> bSN;
        int Z;
        if (this.hLs == null || this.hLs.getPbData() == null || this.hLs.getPbData().bSN() == null || (Z = com.baidu.tbadk.core.util.v.Z((bSN = this.hLs.getPbData().bSN()))) == 0) {
            return "";
        }
        if (this.hLs.bWb()) {
            Iterator<PostData> it = bSN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cpL() == 1) {
                    return next.getId();
                }
            }
        }
        int bXK = this.hLw.bXK();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bSN, bXK);
        if (postData == null || postData.aey() == null) {
            return "";
        }
        if (this.hLs.BV(postData.aey().getUserId())) {
            return postData.getId();
        }
        for (int i = bXK - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bSN, i);
            if (postData2 == null || postData2.aey() == null || postData2.aey().getUserId() == null) {
                break;
            } else if (this.hLs.BV(postData2.aey().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bXK + 1; i2 < Z; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bSN, i2);
            if (postData3 == null || postData3.aey() == null || postData3.aey().getUserId() == null) {
                return "";
            }
            if (this.hLs.BV(postData3.aey().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (bb.ajE().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(BQ(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hLs.getPbData().getForum().getId(), this.hLs.getPbData().getForum().getName(), this.hLs.getPbData().bSL().getTid());
            }
            this.hLg = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hLs.bWm() != null) {
                    PbActivity.this.hLs.bWm().el(j);
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
        aVar.agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c BS(String str) {
        String str2;
        if (this.hLs.getPbData() == null || this.hLs.getPbData().bSN() == null || this.hLs.getPbData().bSN().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hLs.getPbData().bSN().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hLs.getPbData().bSN().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hLs.getPbData().bSN().get(i);
        if (postData.cpN() == null || postData.cpN().ayN() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cpN().ayN().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.ayU() != null) {
                    str2 = next.ayU().azi();
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
        if (this.hKX) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hKX = false;
        } else if (bUI()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hKX) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hKX = false;
        } else if (bUI()) {
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
            if (this.hLs != null) {
                if (this.hLs.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.hLs.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.hLs.bVL(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.qU(TbadkCoreApplication.getInst().getAdAdSense().cfT);
            }
        }
        return pageStayDurationItem;
    }

    public boolean bUI() {
        return (!this.hKV && this.hMM == -1 && this.hMN == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hMP = oVar;
            this.hKV = true;
            this.hLw.bXu();
            this.hLw.Cd(this.hMO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUJ() {
        if (this.hMP != null) {
            if (this.hMM == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bd.cE(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hMP.getCartoonId(), this.hMM, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUK() {
        if (this.hMP != null) {
            if (this.hMN == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bd.cE(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hMP.getCartoonId(), this.hMN, 0)));
                finish();
            }
        }
    }

    public int bUL() {
        return this.hMM;
    }

    public int bUM() {
        return this.hMN;
    }

    private void byv() {
        if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().bSL() != null && this.hLs.getPbData().bSL().afs()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bUN() {
        if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().bSL() != null && this.hLs.getPbData().bSL().afs()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bUO() {
        if (this.hKY) {
            this.hLl = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hLs.getPbData() != null && this.hLs.getPbData().bSL() != null && this.hLs.getPbData().bSL().aee() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hLs.getPbData().bSL().aee().getThreadId(), this.hLs.getPbData().bSL().aee().getTaskId(), this.hLs.getPbData().bSL().aee().getForumId(), this.hLs.getPbData().bSL().aee().getForumName(), this.hLs.getPbData().bSL().aet(), this.hLs.getPbData().bSL().aeu())));
            this.hKX = true;
            finish();
        }
    }

    public String bUP() {
        return this.hLj;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bUQ() {
        return this.hLr;
    }

    public void or(boolean z) {
        this.hLk = z;
    }

    public boolean bUR() {
        if (this.hLs != null) {
            return this.hLs.bVN();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mO(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hLR).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hLR.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hLR).agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hLR != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLR.getPageActivity());
            aVar.mO(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hLR).agK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hLw.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLR.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.mO(this.hLR.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mO(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hLw.showLoadingDialog();
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
        aVar.b(this.hLR).agK();
    }

    public void bUT() {
        if (this.hLs != null && this.hLs.getPbData() != null && this.hLs.getPbData().bSL() != null && this.hLs.getPbData().bSL().afI() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.hu(R.string.channel_open_push_message);
            aVar.a(R.string.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hLs.getPbData().bSL().afI().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.agK();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.Cf(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.fTW) {
            this.fTW = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.hLw != null) {
                this.hLw.onConfigurationChanged(configuration);
            }
            if (this.hLC != null) {
                this.hLC.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921419, configuration));
        }
    }

    public boolean bUU() {
        if (this.hLs != null) {
            return this.hLs.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hLs.getPbData().bSW().hJu;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cpI().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cpI().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cpI().remove(i2);
                    list.get(i).cpK();
                    z = true;
                    break;
                }
            }
            list.get(i).EK(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.hLs.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bTu().getId();
        List<PostData> list = this.hLs.getPbData().bSW().hJu;
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
                ArrayList<PostData> bTy = kVar.bTy();
                postData.Bf(kVar.getTotalCount());
                if (postData.cpI() != null) {
                    postData.cpI().clear();
                    postData.cpI().addAll(bTy);
                }
            }
        }
        if (!this.hLs.getIsFromMark()) {
            this.hLw.m(this.hLs.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bTG() {
        return this.hLx;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bTH() {
        if (this.hLs == null) {
            return false;
        }
        return this.hLs.bTH();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bTI() {
        if (this.hLs != null) {
            return this.hLs.bTI();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bTJ() {
        if (this.hLs == null || this.hLs.getPbData() == null) {
            return 0;
        }
        return this.hLs.getPbData().bSX();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean BM(String str) {
        return this.hLs != null && this.hLs.BV(str);
    }

    public void bUV() {
        if (this.hLw != null) {
            this.hLw.bXi();
            bmu();
        }
    }

    public PostData bSS() {
        return this.hLw.c(this.hLs.hQT, this.hLs.bVM());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int av(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.isLinkThread()) {
                return 3;
            }
            if (bhVar.afK()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hMa != null && !this.hMa.isEmpty()) {
            int size = this.hMa.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hMa.get(i).onBackPressed()) {
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
            if (this.hMa == null) {
                this.hMa = new ArrayList();
            }
            if (!this.hMa.contains(aVar)) {
                this.hMa.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hMa == null) {
                this.hMa = new ArrayList();
            }
            if (!this.hMa.contains(aVar)) {
                this.hMa.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hMa != null) {
            this.hMa.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUW() {
        if (this.hLs != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.hLs.bVL())) {
            com.baidu.tbadk.BdToken.c.Zg().k(com.baidu.tbadk.BdToken.b.bxN, com.baidu.adp.lib.g.b.c(this.hLs.bVL(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hLs == null || com.baidu.tbadk.core.util.aq.isEmpty(this.hLs.bVL())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.hLs.bVL(), 0L);
    }

    public com.baidu.tbadk.core.data.av bUX() {
        return this.hLq;
    }
}
