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
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.g.a;
import com.baidu.tieba.g.b;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ai;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.q;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AgreeData;
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
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
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
/* loaded from: classes22.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0840a {
    private bd eBS;
    private com.baidu.tieba.tbadkCore.data.e eXh;
    private com.baidu.tbadk.core.message.a eXx;
    private com.baidu.adp.lib.d.b<ImageView> fMZ;
    private com.baidu.adp.lib.d.b<GifView> fNa;
    private com.baidu.adp.lib.d.b<TextView> fQq;
    private com.baidu.adp.lib.d.b<View> fQr;
    private com.baidu.adp.lib.d.b<LinearLayout> fQs;
    private com.baidu.adp.lib.d.b<RelativeLayout> fQt;
    private com.baidu.adp.lib.d.b<TbImageView> few;
    private LikeModel fgf;
    private VoiceManager iSW;
    private com.baidu.tieba.g.b iXQ;
    private com.baidu.tieba.frs.profession.permission.c iXq;
    private com.baidu.tieba.callfans.a ikq;
    public com.baidu.tbadk.core.util.am kJE;
    public bb kNm;
    private String lDO;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lHI;
    private View lHJ;
    int lHL;
    private bh lHO;
    private com.baidu.tieba.pb.pb.report.a lHT;
    private PbActivity lHp;
    private com.baidu.tieba.pb.pb.main.b.b lHs;
    private com.baidu.tbadk.core.dialog.i lIa;
    private com.baidu.tbadk.core.dialog.k lIb;
    private boolean lIc;
    private com.baidu.tieba.tbadkCore.data.f lIg;
    private com.baidu.tbadk.editortools.pb.g lIh;
    private com.baidu.tbadk.editortools.pb.e lIi;
    private com.baidu.tieba.frs.profession.permission.c lIk;
    private EmotionImageData lIl;
    private com.baidu.adp.base.e lIo;
    private com.baidu.tbadk.core.view.c lIp;
    private BdUniqueId lIq;
    private Runnable lIr;
    private com.baidu.adp.widget.ImageView.a lIs;
    private String lIt;
    private TbRichTextMemeInfo lIu;
    private List<a> lIx;
    public String lIz;
    private boolean lJc;
    private String lJl;
    private com.baidu.tbadk.core.data.s lJm;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a lJi = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.g.b.a
        public void cW(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dob();
            } else {
                com.baidu.tieba.pb.a.b.doa();
            }
        }
    };
    boolean lHq = true;
    private boolean lHr = false;
    private boolean lHt = false;
    private boolean bIA = false;
    private boolean lcW = false;
    private boolean lHu = true;
    private int lHv = 0;
    private com.baidu.tbadk.core.dialog.b lHw = null;
    private long ivA = -1;
    private long fCl = 0;
    private long lHx = 0;
    private long createTime = 0;
    private long fCb = 0;
    private boolean lHy = false;
    private com.baidu.tbadk.n.b lHz = null;
    private long lHA = 0;
    private boolean lHB = false;
    private long lHC = 0;
    private int jzy = 1;
    private String fwy = null;
    private boolean lHD = false;
    private boolean isFullScreen = false;
    private boolean lHE = false;
    private String lHF = "";
    private boolean lHG = true;
    private boolean lHH = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lHK = new int[2];
    private int lHM = -1;
    private int lHN = -1;
    public BdUniqueId lHP = BdUniqueId.gen();
    private boolean lHQ = false;
    private boolean lHR = com.baidu.tbadk.a.d.bkr();
    private PbInterviewStatusView.a lHS = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lHW.vr(!PbFragment.this.lHG);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lDS != null && PbFragment.this.lDS.bkY()) {
                        PbFragment.this.dpv();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lDS = null;
    private com.baidu.tbadk.baseEditMark.a lHU = null;
    private ForumManageModel fXd = null;
    private com.baidu.tbadk.coreExtra.model.a eTC = null;
    private com.baidu.tieba.pb.data.q lHV = null;
    private ShareSuccessReplyToServerModel joM = null;
    private az lHW = null;
    private boolean lHX = false;
    private boolean lHY = false;
    private boolean lHZ = false;
    private boolean geK = false;
    private boolean lId = false;
    private boolean lIe = false;
    private boolean lIf = false;
    private boolean lIj = false;
    public boolean lIm = false;
    private com.baidu.tbadk.editortools.pb.c fwB = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bCS() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fwC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bCR() {
            if (PbFragment.this.kNm == null || PbFragment.this.kNm.dtt() == null || !PbFragment.this.kNm.dtt().dYp()) {
                return !PbFragment.this.Hd(com.baidu.tbadk.core.util.am.eTx);
            }
            PbFragment.this.showToast(PbFragment.this.kNm.dtt().dYr());
            if (PbFragment.this.lIi != null && (PbFragment.this.lIi.bDi() || PbFragment.this.lIi.bDj())) {
                PbFragment.this.lIi.a(false, PbFragment.this.kNm.dtw());
            }
            PbFragment.this.kNm.vE(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lIn = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bCR() {
            if (PbFragment.this.kNm == null || PbFragment.this.kNm.dtu() == null || !PbFragment.this.kNm.dtu().dYp()) {
                return !PbFragment.this.Hd(com.baidu.tbadk.core.util.am.eTy);
            }
            PbFragment.this.showToast(PbFragment.this.kNm.dtu().dYr());
            if (PbFragment.this.lHW != null && PbFragment.this.lHW.dsa() != null && PbFragment.this.lHW.dsa().doW() != null && PbFragment.this.lHW.dsa().doW().bDj()) {
                PbFragment.this.lHW.dsa().doW().a(PbFragment.this.kNm.dtw());
            }
            PbFragment.this.kNm.vF(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean iTK = false;
    private int lIv = 0;
    private int lIw = -1;
    public int lIy = 0;
    private final a lIA = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lHW != null && PbFragment.this.lHW.dsa() != null) {
                v dsa = PbFragment.this.lHW.dsa();
                if (dsa.doU()) {
                    dsa.doT();
                    return true;
                }
            }
            if (PbFragment.this.lHW != null && PbFragment.this.lHW.dsZ()) {
                PbFragment.this.lHW.dta();
                return true;
            }
            return false;
        }
    };
    private final ai.a lIB = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void ah(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void p(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lHW.showToast(str);
            }
        }
    };
    private final CustomMessageListener lIC = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lDS != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lIi != null) {
                    PbFragment.this.lHW.vw(PbFragment.this.lIi.bDb());
                }
                PbFragment.this.lHW.dsc();
                PbFragment.this.lHW.dsS();
            }
        }
    };
    CustomMessageListener iUC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                PbFragment.this.lDS.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                if (PbFragment.this.lHW != null && PbFragment.this.lDS != null) {
                    PbFragment.this.lHW.b(PbFragment.this.lDS.getPbData(), PbFragment.this.lDS.dqm(), PbFragment.this.lDS.dqK(), PbFragment.this.lHW.getSkinType());
                }
                if (PbFragment.this.lHW != null && PbFragment.this.lHW.dsu() != null) {
                    PbFragment.this.lHW.dsu().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener lID = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lHW != null) {
                    if (booleanValue) {
                        PbFragment.this.lHW.cYn();
                    } else {
                        PbFragment.this.lHW.cYm();
                    }
                }
            }
        }
    };
    private CustomMessageListener lIE = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lIi != null) {
                    PbFragment.this.lHW.vw(PbFragment.this.lIi.bDb());
                }
                PbFragment.this.lHW.vy(false);
            }
        }
    };
    private CustomMessageListener lIF = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.p) eVar.getData());
                        return;
                    case 1:
                        PbFragment.this.a((ForumManageModel.b) eVar.getData(), false);
                        return;
                    case 2:
                        if (eVar.getData() == null) {
                            PbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbFragment.this.a(true, (MarkData) eVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener lIG = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lHW != null && PbFragment.this.lHW.dsu() != null) {
                PbFragment.this.lHW.dsu().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jhd = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener iUy = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bIA) {
                PbFragment.this.dpN();
            }
        }
    };
    private View.OnClickListener fxl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fwy);
        }
    };
    private CustomMessageListener lIH = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ah)) {
                com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) customResponsedMessage.getData();
                az.a aVar = new az.a();
                aVar.giftId = ahVar.id;
                aVar.giftName = ahVar.name;
                aVar.thumbnailUrl = ahVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDS.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lDS.dqB() != null && PbFragment.this.lDS.dqB().getUserIdLong() == ahVar.toUserId) {
                        PbFragment.this.lHW.a(ahVar.sendCount, PbFragment.this.lDS.getPbData(), PbFragment.this.lDS.dqm(), PbFragment.this.lDS.dqK());
                    }
                    if (pbData.dmW() != null && pbData.dmW().size() >= 1 && pbData.dmW().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dmW().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lDS.dqk(), 0L);
                        if (j == ahVar.postId && j2 == ahVar.threadId) {
                            com.baidu.tbadk.core.data.az dPp = pbData.dmW().get(0).dPp();
                            if (dPp == null) {
                                dPp = new com.baidu.tbadk.core.data.az();
                            }
                            ArrayList<az.a> bnH = dPp.bnH();
                            if (bnH == null) {
                                bnH = new ArrayList<>();
                            }
                            bnH.add(0, aVar);
                            dPp.setTotal(ahVar.sendCount + dPp.getTotal());
                            dPp.D(bnH);
                            pbData.dmW().get(0).a(dPp);
                            PbFragment.this.lHW.dsu().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lII = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                PbFragment.this.lDS.getPbData().dno();
                PbFragment.this.lDS.dqG();
                if (PbFragment.this.lHW.dsu() != null) {
                    PbFragment.this.lHW.s(PbFragment.this.lDS.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jqi = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Qc(str);
                PbFragment.this.lDS.dqG();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lDS.getPbData().dmW() != null) {
                    ArrayList<PostData> dmW = PbFragment.this.lDS.getPbData().dmW();
                    Iterator<PostData> it = dmW.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            nVar = null;
                            break;
                        }
                        PostData next = it.next();
                        if ((next instanceof com.baidu.tieba.tbadkCore.data.n) && str.equals(((com.baidu.tieba.tbadkCore.data.n) next).getAdId())) {
                            nVar = (com.baidu.tieba.tbadkCore.data.n) next;
                            break;
                        }
                    }
                    if (nVar != null) {
                        dmW.remove(nVar);
                        if (PbFragment.this.lHW.dsu() != null && PbFragment.this.lHW.dsu().getDataList() != null) {
                            PbFragment.this.lHW.dsu().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.lHW.getListView() != null && PbFragment.this.lHW.getListView().getData() != null) {
                            PbFragment.this.lHW.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.lHW.dsu() != null) {
                            PbFragment.this.lHW.dsu().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lHW.dsu() != null) {
                    PbFragment.this.lHW.s(PbFragment.this.lDS.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a lIJ = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dtM()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a lIK = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ah(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.lHW != null) {
                PbFragment.this.lHW.fp(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean lIL = false;
    private PraiseModel lIM = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void FQ(String str) {
            PbFragment.this.lIL = false;
            if (PbFragment.this.lIM != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDS.getPbData();
                if (pbData.dmU().boA().getIsLike() == 1) {
                    PbFragment.this.Bf(0);
                } else {
                    PbFragment.this.Bf(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dmU()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.lIL = false;
            if (PbFragment.this.lIM != null && str != null) {
                if (AntiHelper.bP(i, str)) {
                    AntiHelper.bn(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a lIN = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void uU(boolean z) {
            PbFragment.this.uS(z);
            if (PbFragment.this.lHW.dtf() != null && z) {
                PbFragment.this.lHW.vr(false);
            }
            PbFragment.this.lHW.vt(z);
        }
    };
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().flk != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().flk, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.dnd().boP() != null && PbFragment.this.dnd().boP().getGodUserData() != null) {
                            PbFragment.this.dnd().boP().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().dmU() != null && PbFragment.this.lDS.getPbData().dmU().boP() != null) {
                            PbFragment.this.lDS.getPbData().dmU().boP().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h iSa = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.lHp.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a lIO = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lHW.cku();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.Hf(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.k.a.cMZ();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c fos = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.dpf();
            }
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                if (view != null) {
                    if (view.getId() == R.id.richText) {
                        if (PbFragment.this.du(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.lHW.dpd() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").dY("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.doc() != null && PbFragment.this.doc().iCs != null) {
                                PbFragment.this.doc().iCs.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = null;
                        if (view.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view.getTag();
                        }
                        if (sparseArray != null) {
                            PbFragment.this.d(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (PbFragment.this.lIi != null) {
                    PbFragment.this.lHW.vw(PbFragment.this.lIi.bDb());
                }
                PbFragment.this.lHW.dsc();
                PbFragment.this.lHW.dsS();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lIP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lIq) {
                PbFragment.this.lHW.cku();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDS.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dnk().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lIp.showSuccessToast(PbFragment.this.lIo.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lIo.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.Ea(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dpJ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.au.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lIo.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lIp.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lIQ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lIq) {
                PbFragment.this.lHW.cku();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lIp.showSuccessToast(PbFragment.this.lIo.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.au.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lIo.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lIp.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lIR = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lIq) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lHW.cku();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nAM;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
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
                    PbFragment.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbFragment.this.lHW.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lIS = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lHW.dsd() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.dpf();
            }
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.iTK = true;
                }
            }
        }
    };
    public a.b lor = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cCG();
            com.baidu.tbadk.core.data.ax pageData = PbFragment.this.lDS.getPageData();
            int pageNum = PbFragment.this.lHW.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bnA()) {
                PbFragment.this.lHW.dsS();
                PbFragment.this.cCF();
                PbFragment.this.lHW.dsz();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lDS.Hj(PbFragment.this.lHW.getPageNum());
                    if (PbFragment.this.lHs != null) {
                        PbFragment.this.lHs.showFloatingView();
                    }
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
                aVar.dismiss();
            } else {
                PbFragment.this.showToast(R.string.pb_page_error);
            }
        }
    };
    private k.c lIT = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lIa != null) {
                PbFragment.this.lIa.dismiss();
            }
            PbFragment.this.Hc(i);
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    PbFragment.this.dv(view2);
                    view2.performClick();
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    PbFragment.this.dv(view3);
                    view3.performClick();
                    return;
                case -2:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (com.baidu.tbadk.a.d.bkD() || com.baidu.tbadk.a.d.bkE()) {
                        View view4 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_2);
                        PbFragment.this.dv(view4);
                        ((AgreeView) view4).getImgDisagree().performClick();
                        return;
                    }
                    View view5 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_1);
                    PbFragment.this.dv(view5);
                    ((AgreeView) view5).getImgDisagree().performClick();
                    return;
                case -1:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (com.baidu.tbadk.a.d.bkD() || com.baidu.tbadk.a.d.bkE()) {
                        View view6 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_2);
                        PbFragment.this.dv(view6);
                        ((AgreeView) view6).getImgAgree().performClick();
                        return;
                    }
                    View view7 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_1);
                    PbFragment.this.dv(view7);
                    ((AgreeView) view7).getImgAgree().performClick();
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (PbFragment.this.lIs != null && !TextUtils.isEmpty(PbFragment.this.lIt)) {
                        if (PbFragment.this.lIu == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lIt));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.lIt;
                            aVar.pkgId = PbFragment.this.lIu.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lIu.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lIs = null;
                        PbFragment.this.lIt = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lIs != null && !TextUtils.isEmpty(PbFragment.this.lIt)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eBS == null) {
                                PbFragment.this.eBS = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eBS.j(PbFragment.this.lIt, PbFragment.this.lIs.getImageByte());
                            PbFragment.this.lIs = null;
                            PbFragment.this.lIt = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.jZf != null) {
                        PbFragment.this.jZf.gD(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.jZf = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").al("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.dw(view);
                        if (PbFragment.this.lDS.getPbData().dmU() != null && PbFragment.this.lDS.getPbData().dmU().boP() != null && PbFragment.this.lDS.getPbData().dmU().boP().getUserId() != null && PbFragment.this.lHU != null) {
                            int h = PbFragment.this.h(PbFragment.this.lDS.getPbData());
                            by dmU = PbFragment.this.lDS.getPbData().dmU();
                            if (dmU.bnx()) {
                                i2 = 2;
                            } else if (dmU.bny()) {
                                i2 = 3;
                            } else if (dmU.bqM()) {
                                i2 = 4;
                            } else {
                                i2 = dmU.bqN() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dY("tid", PbFragment.this.lDS.lLj).al("obj_locate", 2).dY("obj_id", PbFragment.this.lDS.getPbData().dmU().boP().getUserId()).al("obj_type", PbFragment.this.lHU.bkY() ? 0 : 1).al("obj_source", h).al("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13079"));
                        PbFragment.this.Qe((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").al("obj_locate", 4));
                        SparseArray<Object> sparseArray4 = (SparseArray) tag;
                        if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray4.put(R.id.tag_from, 0);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.c(sparseArray4);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.lHW.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null) {
                        boolean booleanValue = ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray6.put(R.id.tag_from, 1);
                                sparseArray6.put(R.id.tag_check_mute_from, 2);
                                PbFragment.this.c(sparseArray6);
                                return;
                            }
                            sparseArray6.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.lHW.dD(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lHW.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bqI() != null) {
                            PbFragment.this.d(postData.bqI());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    public SortSwitchButton.a lIU = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean Az(int i) {
            PbFragment.this.lHW.dsS();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lDS == null || PbFragment.this.lDS.isLoading) {
                    return false;
                }
                PbFragment.this.cCF();
                PbFragment.this.lHW.dsz();
                if (PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().lAL != null && PbFragment.this.lDS.getPbData().lAL.size() > i) {
                    int intValue = PbFragment.this.lDS.getPbData().lAL.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13699").dY("tid", PbFragment.this.lDS.dql()).dY("fid", PbFragment.this.lDS.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_type", Hh(intValue)));
                    if (PbFragment.this.lDS.Ho(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lHW.vm(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int Hh(int i) {
            if (i == 2) {
                return 1;
            }
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            return 0;
        }
    };
    public final View.OnClickListener iVJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        /* JADX WARN: Removed duplicated region for block: B:799:0x23cf  */
        /* JADX WARN: Removed duplicated region for block: B:802:0x2413  */
        /* JADX WARN: Removed duplicated region for block: B:819:0x25ec  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            String name;
            int i;
            int i2;
            cd cdVar;
            SparseArray sparseArray;
            boolean z2;
            String str;
            com.baidu.tbadk.core.dialog.g gVar4;
            String[] strArr;
            com.baidu.tieba.pb.data.f pbData;
            boolean C;
            String name2;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.lHW.dsO()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lDS.va(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lHW.dsA();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().drB()) {
                        if (PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().drC()) {
                            if (view == PbFragment.this.lHW.lPe.fEN) {
                                if (PbFragment.this.lHW.vv(PbFragment.this.lDS.dqs())) {
                                    PbFragment.this.cCF();
                                    return;
                                }
                                PbFragment.this.lHu = false;
                                PbFragment.this.lHt = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.lHp, PbFragment.this.lHW.lPe.fEN);
                                PbFragment.this.lHp.finish();
                            } else if (view != PbFragment.this.lHW.dsx() && (PbFragment.this.lHW.lPe.dtZ() == null || (view != PbFragment.this.lHW.lPe.dtZ().drA() && view != PbFragment.this.lHW.lPe.dtZ().dry()))) {
                                if (view == PbFragment.this.lHW.dsW()) {
                                    if (PbFragment.this.lDS != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDS.getPbData().dmU().boO().getLink());
                                    }
                                } else if (view != PbFragment.this.lHW.lPe.lVC) {
                                    if (view == PbFragment.this.lHW.lPe.jjp) {
                                        if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                                            ArrayList<PostData> dmW = PbFragment.this.lDS.getPbData().dmW();
                                            if ((dmW == null || dmW.size() <= 0) && PbFragment.this.lDS.dqm()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12378").dY("tid", PbFragment.this.lDS.dqk()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", PbFragment.this.lDS.getForumId()));
                                            if (!PbFragment.this.lHW.dtk()) {
                                                PbFragment.this.lHW.dsc();
                                            }
                                            PbFragment.this.dpn();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lHW.uH(true);
                                            PbFragment.this.lHW.dsc();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lHW.cYn();
                                                PbFragment.this.cCF();
                                                PbFragment.this.lHW.dsz();
                                                PbFragment.this.lDS.Qj(PbFragment.this.dpz());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().drx()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lHW.lPe.dtZ() != null && view == PbFragment.this.lHW.lPe.dtZ().drw()) {
                                                PbFragment.this.lHW.lPe.bca();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.Hg(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().dru()) {
                                                    if (PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().drE()) {
                                                        if (PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().drv()) {
                                                            if (PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().drF()) {
                                                                if (PbFragment.this.lHW.dtf() == view) {
                                                                    if (PbFragment.this.lHW.dtf().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lDS.getPbData();
                                                                        if (pbData2 != null && pbData2.dmU() != null && pbData2.dmU().bov() != null) {
                                                                            String bol = pbData2.dmU().bov().bol();
                                                                            if (StringUtils.isNull(bol)) {
                                                                                bol = pbData2.dmU().bov().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11107").dY("obj_id", bol));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gv("c10725", null);
                                                                    }
                                                                    PbFragment.this.dpG();
                                                                } else if (PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().drD()) {
                                                                    if (PbFragment.this.lHW.lPe.dtZ() != null && view == PbFragment.this.lHW.lPe.dtZ().drz()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lHW.b(PbFragment.this.lDS.getPbData(), PbFragment.this.lDS.dqm(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lHW.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lHW.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lHW.lPe.bca();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar.dY("tid", PbFragment.this.lDS.dqk());
                                                                            arVar.dY("fid", PbFragment.this.lDS.getForumId());
                                                                            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar.al("obj_locate", 4);
                                                                            TiebaStatic.log(arVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                                                                                PbFragment.this.lHW.dsS();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dPt() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12630"));
                                                                                    }
                                                                                    if (postData.nmE != null) {
                                                                                        com.baidu.tbadk.core.util.ar btS = postData.nmE.btS();
                                                                                        btS.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            btS.al("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            btS.al("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(btS);
                                                                                    }
                                                                                    String dqk = PbFragment.this.lDS.dqk();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lDS.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lDS.getPbData().dnj();
                                                                                    }
                                                                                    PbFragment.this.cCF();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a Qh = PbFragment.this.Qh(id);
                                                                                        if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && Qh != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dqk, id, "pb", true, null, true, null, i3, postData.duZ(), PbFragment.this.lDS.getPbData().getAnti(), false, postData.boP().getIconInfo()).addBigImageData(Qh.lEa, Qh.eCN, Qh.eCL, Qh.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lDS.dqV());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lDS.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lDS.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lDS.dqu());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a Qh2 = PbFragment.this.Qh(id);
                                                                                        if (postData != null && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && Qh2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dqk, id, "pb", true, null, false, str2, i3, postData.duZ(), PbFragment.this.lDS.getPbData().getAnti(), false, postData.boP().getIconInfo()).addBigImageData(Qh2.lEa, Qh2.eCN, Qh2.eCL, Qh2.index);
                                                                                            if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lDS.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lDS.dqu());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lDS.dqV());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lDS.getFromForumId());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData2));
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").al("obj_locate", 3).dY("fid", PbFragment.this.lDS.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lDS != null) {
                                                                            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar2.dY("tid", PbFragment.this.lDS.dqk());
                                                                            arVar2.dY("fid", PbFragment.this.lDS.getForumId());
                                                                            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar2.al("obj_locate", 5);
                                                                            TiebaStatic.log(arVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.nmE != null) {
                                                                                        com.baidu.tbadk.core.util.ar btS2 = postData3.nmE.btS();
                                                                                        btS2.delete("obj_locate");
                                                                                        btS2.al("obj_locate", 8);
                                                                                        TiebaStatic.log(btS2);
                                                                                    }
                                                                                    if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                                                                                        String dqk2 = PbFragment.this.lDS.dqk();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lDS.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lDS.getPbData().dnj();
                                                                                        }
                                                                                        PbActivity.a Qh3 = PbFragment.this.Qh(id2);
                                                                                        if (Qh3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dqk2, id2, "pb", true, null, false, null, i4, postData3.duZ(), PbFragment.this.lDS.getPbData().getAnti(), false, postData3.boP().getIconInfo()).addBigImageData(Qh3.lEa, Qh3.eCN, Qh3.eCL, Qh3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lDS.dqV());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lDS.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lDS.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lDS.dqu());
                                                                                            if (PbFragment.this.lDS.getPbData().dnE() != null) {
                                                                                                addBigImageData3.setHasForumRule(PbFragment.this.lDS.getPbData().dnE().has_forum_rule.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lDS.getPbData().getUserData() != null) {
                                                                                                addBigImageData3.setIsManager(PbFragment.this.lDS.getPbData().getUserData().getIs_manager());
                                                                                            }
                                                                                            if (PbFragment.this.lDS.getPbData().getForum().getDeletedReasonInfo() != null) {
                                                                                                addBigImageData3.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.lDS.getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                                addBigImageData3.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.lDS.getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lDS.getPbData().getForum() != null) {
                                                                                                addBigImageData3.setForumHeadUrl(PbFragment.this.lDS.getPbData().getForum().getImage_url());
                                                                                                addBigImageData3.setUserLevel(PbFragment.this.lDS.getPbData().getForum().getUser_level());
                                                                                            }
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData3));
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
                                                                    } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                        if (PbFragment.this.lDS != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                arVar3.dY("tid", PbFragment.this.lDS.dqk());
                                                                                arVar3.dY("fid", PbFragment.this.lDS.getForumId());
                                                                                arVar3.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                arVar3.al("obj_locate", 6);
                                                                                TiebaStatic.log(arVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.nmE != null) {
                                                                                        com.baidu.tbadk.core.util.ar btS3 = postData4.nmE.btS();
                                                                                        btS3.delete("obj_locate");
                                                                                        btS3.al("obj_locate", 8);
                                                                                        TiebaStatic.log(btS3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dY("tid", PbFragment.this.lDS.dql()).dY("fid", PbFragment.this.lDS.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", postData4.getId()).al("obj_source", 1).al("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.dpc().drZ() != null && postData4.boP() != null && postData4.dPh() != 1) {
                                                                                        if (PbFragment.this.dpc().dsa() != null) {
                                                                                            PbFragment.this.dpc().dsa().doS();
                                                                                        }
                                                                                        if ((PbFragment.this.lHR || com.baidu.tbadk.a.d.bkh()) && postData4.dPe() != null && postData4.dPe().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.bki()) {
                                                                                                PbFragment.this.a(postData4, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData4, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.lDS.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.lDS.getPbData().dmU());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.dpc().drZ().d(pVar);
                                                                                            PbFragment.this.dpc().drZ().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.boP().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lIi != null) {
                                                                                                PbFragment.this.lHW.vw(PbFragment.this.lIi.bDb());
                                                                                            }
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
                                                                    } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                        if (view != PbFragment.this.lHW.dov()) {
                                                                            if (view == PbFragment.this.lHW.lPe.dua()) {
                                                                                PbFragment.this.lHW.dsG();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (cdVar = (cd) view.getTag()) != null && !StringUtils.isNull(cdVar.brj())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        bf.bua().b(PbFragment.this.getPageContext(), new String[]{cdVar.brj()});
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11740"));
                                                                                        if (view != null && view.getTag() != null) {
                                                                                            SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                            PostData postData5 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                            if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12006").dY("tid", PbFragment.this.lDS.lLj));
                                                                                            }
                                                                                            if (PbFragment.this.lIb == null) {
                                                                                                PbFragment.this.lIb = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lIb.a(PbFragment.this.lIT);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.dy(view);
                                                                                            if (!PbFragment.this.dy(view) || PbFragment.this.lIs == null || !PbFragment.this.lIs.isGif()) {
                                                                                            }
                                                                                            boolean z3 = false;
                                                                                            boolean z4 = false;
                                                                                            boolean z5 = false;
                                                                                            boolean z6 = false;
                                                                                            boolean z7 = false;
                                                                                            String str3 = null;
                                                                                            if (sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                                ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                                z3 = ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z4 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                                z5 = ((Boolean) sparseArray5.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z6 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                                z7 = ((Boolean) sparseArray5.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_forbid_user_post_id) instanceof String) {
                                                                                                str3 = (String) sparseArray5.get(R.id.tag_forbid_user_post_id);
                                                                                            }
                                                                                            if (postData5 != null) {
                                                                                                if (postData5.dPj() != null && postData5.dPj().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lIb);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar5.eNK.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.jZf = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lDS.getPbData().bkY()) {
                                                                                                String bkX = PbFragment.this.lDS.getPbData().bkX();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bkX) && bkX.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lIb);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lIb);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.jZf);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.eNK.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lIb);
                                                                                                            SparseArray sparseArray8 = new SparseArray();
                                                                                                            sparseArray8.put(R.id.tag_user_mute_visible, true);
                                                                                                            sparseArray8.put(R.id.tag_is_mem, sparseArray5.get(R.id.tag_is_mem));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_userid, sparseArray5.get(R.id.tag_user_mute_mute_userid));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_username, sparseArray5.get(R.id.tag_user_mute_mute_username));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_nameshow, sparseArray5.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_post_id, sparseArray5.get(R.id.tag_user_mute_post_id));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_thread_id, sparseArray5.get(R.id.tag_user_mute_thread_id));
                                                                                                            sparseArray8.put(R.id.tag_del_post_is_self, sparseArray5.get(R.id.tag_del_post_is_self));
                                                                                                            sparseArray8.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                            sparseArray8.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                            sparseArray8.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            gVar.eNK.setTag(sparseArray8);
                                                                                                            arrayList.add(gVar6);
                                                                                                        } else {
                                                                                                            if (PbFragment.this.uO(z3) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lIb);
                                                                                                                gVar7.eNK.setTag(str3);
                                                                                                                arrayList.add(gVar7);
                                                                                                            }
                                                                                                        }
                                                                                                        if (z5) {
                                                                                                            SparseArray sparseArray9 = new SparseArray();
                                                                                                            sparseArray9.put(R.id.tag_should_manage_visible, true);
                                                                                                            sparseArray9.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name, sparseArray5.get(R.id.tag_forbid_user_name));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name_show, sparseArray5.get(R.id.tag_forbid_user_name_show));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_portrait, sparseArray5.get(R.id.tag_forbid_user_portrait));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_post_id, str3);
                                                                                                            if (z6) {
                                                                                                                sparseArray9.put(R.id.tag_user_mute_visible, true);
                                                                                                                sparseArray9.put(R.id.tag_is_mem, sparseArray5.get(R.id.tag_is_mem));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_mute_userid, sparseArray5.get(R.id.tag_user_mute_mute_userid));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_mute_username, sparseArray5.get(R.id.tag_user_mute_mute_username));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_mute_nameshow, sparseArray5.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_post_id, sparseArray5.get(R.id.tag_user_mute_post_id));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_thread_id, sparseArray5.get(R.id.tag_user_mute_thread_id));
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                            }
                                                                                                            if (z7) {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                                sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                                sparseArray9.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                                sparseArray9.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lIb);
                                                                                                                gVar2.eNK.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lIb);
                                                                                                            gVar3.eNK.setTag(sparseArray9);
                                                                                                        } else if (!z7) {
                                                                                                            gVar2 = null;
                                                                                                            gVar3 = null;
                                                                                                        } else {
                                                                                                            SparseArray sparseArray10 = new SparseArray();
                                                                                                            sparseArray10.put(R.id.tag_should_manage_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_user_mute_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_should_delete_visible, true);
                                                                                                            sparseArray10.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                            sparseArray10.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                            sparseArray10.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                            if (PbFragment.this.lDS.getPbData().dnj() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lIb);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lIb);
                                                                                                            }
                                                                                                            gVar2.eNK.setTag(sparseArray10);
                                                                                                            gVar3 = null;
                                                                                                        }
                                                                                                        if (gVar2 != null) {
                                                                                                            arrayList.add(gVar2);
                                                                                                        }
                                                                                                        if (gVar3 != null) {
                                                                                                            arrayList.add(gVar3);
                                                                                                        }
                                                                                                    }
                                                                                                    PbFragment.this.lIb.bu(arrayList);
                                                                                                    PbFragment.this.lIa = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lIb);
                                                                                                    PbFragment.this.lIa.RU();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.jZf);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.eNK.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lIb.bu(arrayList);
                                                                                            PbFragment.this.lIa = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lIb);
                                                                                            PbFragment.this.lIa.RU();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().dmU() != null && PbFragment.this.lDS.getPbData().dmU().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lDS.getPbData().dmU().getActUrl());
                                                                                        if (PbFragment.this.lDS.getPbData().dmU().bpC() != 1) {
                                                                                            if (PbFragment.this.lDS.getPbData().dmU().bpC() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10912").dY("fid", PbFragment.this.lDS.getPbData().getForumId()).dY("tid", PbFragment.this.lDS.getPbData().getThreadId()).dY("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lDS.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lHW.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (com.baidu.tbadk.core.util.bh.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.bsO().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.lHW.dsc();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.dpl() == 1 && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10397").dY("fid", PbFragment.this.lDS.getPbData().getForumId()).dY("tid", PbFragment.this.lDS.getPbData().getThreadId()).dY("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.dpl() == 1 && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10507").dY("fid", PbFragment.this.lDS.getPbData().getForumId()).dY("tid", PbFragment.this.lDS.getPbData().getThreadId()).dY("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dpB();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dpC();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().dnq() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lDS.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11679").dY("fid", pbData3.getForumId()));
                                                                                        bf.bua().b(PbFragment.this.getPageContext(), new String[]{pbData3.dnq().dnF()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().dnq() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lDS.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dY("fid", pbData4.getForumId()));
                                                                                        bf.bua().b(PbFragment.this.getPageContext(), new String[]{pbData4.dnq().dnF()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.lIv >= 0) {
                                                                                        if (PbFragment.this.lDS != null) {
                                                                                            PbFragment.this.lDS.dqW();
                                                                                        }
                                                                                        if (PbFragment.this.lDS != null && PbFragment.this.lHW.dsu() != null) {
                                                                                            PbFragment.this.lHW.dsu().a(PbFragment.this.lDS.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.lIv = 0;
                                                                                        if (PbFragment.this.lDS != null) {
                                                                                            PbFragment.this.lHW.getListView().setSelection(PbFragment.this.lDS.dqZ());
                                                                                            PbFragment.this.lDS.dg(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.Hg(8);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                                    SparseArray sparseArray11 = null;
                                                                                    if (view.getTag() instanceof SparseArray) {
                                                                                        sparseArray11 = (SparseArray) view.getTag();
                                                                                    }
                                                                                    if (sparseArray11 != null) {
                                                                                        PbFragment.this.d(sparseArray11);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                                    if (PbFragment.this.lHW.getListView() != null && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lHW.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lHW.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dnv = PbFragment.this.lDS.getPbData().dnv();
                                                                                        boolean z8 = PbFragment.this.lHW.dsb() != null && PbFragment.this.lHW.dsb().cak();
                                                                                        boolean dsP = PbFragment.this.lHW.dsP();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (dnv && PbFragment.this.lHW.dsb() != null && PbFragment.this.lHW.dsb().bSt() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lHW.dsb().dtJ();
                                                                                            z9 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.lHW.dsb().bSt().getHeight() - PbFragment.this.lHW.dsb().dtJ());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.Qi("c13568");
                                                                                        if ((PbFragment.this.lDS.getPbData().dmU() != null && PbFragment.this.lDS.getPbData().dmU().boG() <= 0) || (dsP && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.dpi();
                                                                                                if (PbFragment.this.lDS.getPbData().dmU().boP() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", PbFragment.this.lDS.lLj).dY("fid", PbFragment.this.lDS.getPbData().getForumId()).al("obj_locate", 2).dY("uid", PbFragment.this.lDS.getPbData().dmU().boP().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dnv) {
                                                                                                if (PbFragment.this.lHW.lQo != null && PbFragment.this.lHW.lQo.lRx != null && PbFragment.this.lHW.lQo.lRx.getView() != null) {
                                                                                                    if (PbFragment.this.lHW.lQo.lRx.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dpr();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.lHW.dsb() != null && PbFragment.this.lHW.dsb().bSt() != null) {
                                                                                                            i6 = PbFragment.this.lHW.dsb().bSt().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.lHW.lQo.lRx.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lHW.dsl() != null) {
                                                                                                z10 = PbFragment.this.lHW.dsl().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.lHW.lQo != null && PbFragment.this.lHW.lQo.lRx != null && PbFragment.this.lHW.lQo.lRx.getView() != null && PbFragment.this.lHW.lQo.lRx.getView().getParent() != null && PbFragment.this.lHW.lPe != null && PbFragment.this.lHW.lPe.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.lHW.lQo.lRx.getView().getTop() - PbFragment.this.lHW.lPe.mNavigationBar.getBottom() < PbFragment.this.lHW.lQo.lRx.lOD.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || dsP) {
                                                                                                PbFragment.this.lHM = firstVisiblePosition;
                                                                                                PbFragment.this.lHN = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lHW.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.lHW.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lHW.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lHM > 0) {
                                                                                                if (PbFragment.this.lHW.getListView().getChildAt(PbFragment.this.lHM) != null) {
                                                                                                    PbFragment.this.lHW.getListView().smoothScrollToPosition(PbFragment.this.lHM, PbFragment.this.lHN, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lHW.getListView().setSelectionFromTop(PbFragment.this.lHM, PbFragment.this.lHN + equipmentHeight);
                                                                                                    PbFragment.this.lHW.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dpr = PbFragment.this.dpr();
                                                                                                if (PbFragment.this.dpq() != -1) {
                                                                                                    dpr--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dpr < 0) {
                                                                                                    i = PbFragment.this.lHW.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.lHW.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = dpr;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!dnv || PbFragment.this.lHW.dsb() == null) {
                                                                                                    if (PbFragment.this.lHW.lPe != null && PbFragment.this.lHW.lPe.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.lHW.lPe.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.lHW.dsb().dtI();
                                                                                                }
                                                                                                if (PbFragment.this.lHW.lQo == null || PbFragment.this.lHW.lQo.lRx == null || PbFragment.this.lHW.lQo.lRx.getView() == null || PbFragment.this.lHW.lQo.lRx.getView().getParent() == null) {
                                                                                                    PbFragment.this.lHW.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.lHW.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.lHW.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lHW.getListView().smoothScrollBy(PbFragment.this.lHW.lQo.lRx.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lDS.getPbData().dmU() != null && PbFragment.this.lDS.getPbData().dmU().boP() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", PbFragment.this.lDS.lLj).dY("fid", PbFragment.this.lDS.getPbData().getForumId()).al("obj_locate", 2).dY("uid", PbFragment.this.lDS.getPbData().dmU().boP().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(PbFragment.this.lDS.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lDS.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lDS.doe()) || PbFragment.this.lDS.getAppealInfo() == null) {
                                                                                                PbFragment.this.lHp.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lDS.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lDS.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.lHp.finish();
                                                                                            return;
                                                                                        }
                                                                                        String doe = PbFragment.this.lDS.doe();
                                                                                        if (PbFragment.this.lDS.dqn() && doe != null && doe.equals(name)) {
                                                                                            PbFragment.this.lHp.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lDS.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c13401");
                                                                                        arVar4.dY("tid", PbFragment.this.lDS.dqk());
                                                                                        arVar4.dY("fid", PbFragment.this.lDS.getForumId());
                                                                                        arVar4.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lDS.getPbData().dmU() != null) {
                                                                                            arVar4.dY("nid", PbFragment.this.lDS.getPbData().dmU().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(arVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof by) {
                                                                                        by byVar = (by) view.getTag();
                                                                                        if (PbFragment.this.lDS.dqV() == 3 && PbFragment.this.dod() && PbFragment.this.lDS.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.lDS.getPbData().dnr())) {
                                                                                            PbFragment.this.lHp.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(byVar.boT(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar5 = new com.baidu.tbadk.core.util.ar("c13399");
                                                                                        arVar5.dY("tid", byVar.getId());
                                                                                        arVar5.w("fid", byVar.getFid());
                                                                                        arVar5.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar5.dY("nid", byVar.getNid());
                                                                                        TiebaStatic.log(arVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.lDS != null) {
                                                                                        com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                        arVar6.dY("tid", PbFragment.this.lDS.dqk());
                                                                                        arVar6.dY("fid", PbFragment.this.lDS.getForumId());
                                                                                        arVar6.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar6.al("obj_locate", 2);
                                                                                        TiebaStatic.log(arVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lDS.getPbData();
                                                                                        if (PbFragment.this.lHV == null) {
                                                                                            PbFragment.this.lHV = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.ar("c13446").w("forum_id", j2).btT();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lIX);
                                                                                        PbFragment.this.lHV.F(j, j2);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_video_thread_smart_app_layout) {
                                                                                    if (view.getTag() instanceof SmartApp) {
                                                                                        SmartApp smartApp = (SmartApp) view.getTag();
                                                                                        if (!com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                            if (!StringUtils.isNull(smartApp.h5_url)) {
                                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), smartApp.h5_url);
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13274").dY("fid", PbFragment.this.lDS.getForumId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("obj_name", smartApp.name).w("obj_id", smartApp.swan_app_id.longValue()).dY("obj_source", "PB_card").dY("tid", PbFragment.this.lDS.dqk()).al("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof by) {
                                                                                        by byVar2 = (by) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(byVar2.boT(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_click").dY("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 9).al("obj_locate", 9).w("obj_id", byVar2.getFid()).dY("tid", byVar2.getId()).al("thread_type", byVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof by) && PbFragment.this.checkUpIsLogin()) {
                                                                                        by byVar3 = (by) view.getTag();
                                                                                        if (PbFragment.this.fgf != null) {
                                                                                            PbFragment.this.fgf.gu(byVar3.boT(), String.valueOf(byVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_click").dY("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 10).al("obj_locate", 11).w("obj_id", byVar3.getFid()).dY("tid", byVar3.getId()).al("thread_type", byVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_floor_right_top_feedback || id3 == R.id.pb_post_op_more) {
                                                                                    com.baidu.tbadk.core.util.ar arVar7 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                    arVar7.dY("tid", PbFragment.this.lDS.dqk());
                                                                                    arVar7.dY("fid", PbFragment.this.lDS.getForumId());
                                                                                    arVar7.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    arVar7.al("obj_locate", 7);
                                                                                    TiebaStatic.log(arVar7);
                                                                                    PbFragment.this.lHq = false;
                                                                                    PbFragment.this.dx(view);
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lDS.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lDS.dqk(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lDS.getPbData().dmU().bpk())));
                                                                        }
                                                                    } else {
                                                                        try {
                                                                            sparseArray = (SparseArray) view.getTag();
                                                                        } catch (ClassCastException e) {
                                                                            e.printStackTrace();
                                                                            sparseArray = null;
                                                                        }
                                                                        PostData postData6 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                        if (postData6 != null) {
                                                                            if (PbFragment.this.lIb == null) {
                                                                                PbFragment.this.lIb = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lIb.a(PbFragment.this.lIT);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.dol().getPbData() != null && PbFragment.this.dol().getPbData().dny();
                                                                            if (view != null && sparseArray != null) {
                                                                                boolean z12 = false;
                                                                                boolean z13 = false;
                                                                                boolean z14 = false;
                                                                                boolean z15 = false;
                                                                                if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                                    z2 = false;
                                                                                } else {
                                                                                    z2 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z12 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                    z13 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z14 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                    z15 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                }
                                                                                if (!(sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                                                                    str = null;
                                                                                } else {
                                                                                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                                                                                }
                                                                                if (postData6.bqI() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bqI().hasAgree && postData6.bqs() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lIb);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar8.eNK.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lIb);
                                                                                        SparseArray sparseArray13 = new SparseArray();
                                                                                        sparseArray13.put(R.id.tag_user_mute_visible, true);
                                                                                        sparseArray13.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                                                                        sparseArray13.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                                                                        sparseArray13.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                                                                        sparseArray13.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                                                                        sparseArray13.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                                                                        sparseArray13.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                                                                                        sparseArray13.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                                                                                        sparseArray13.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                        sparseArray13.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                        sparseArray13.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                        gVar9.eNK.setTag(sparseArray13);
                                                                                        arrayList2.add(gVar9);
                                                                                    } else {
                                                                                        if ((PbFragment.this.uO(z2) && TbadkCoreApplication.isLogin()) && !z11) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lIb);
                                                                                            gVar10.eNK.setTag(str);
                                                                                            arrayList2.add(gVar10);
                                                                                        }
                                                                                    }
                                                                                    com.baidu.tbadk.core.dialog.g gVar11 = null;
                                                                                    if (z13) {
                                                                                        SparseArray sparseArray14 = new SparseArray();
                                                                                        sparseArray14.put(R.id.tag_should_manage_visible, true);
                                                                                        sparseArray14.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_post_id, str);
                                                                                        if (z14) {
                                                                                            sparseArray14.put(R.id.tag_user_mute_visible, true);
                                                                                            sparseArray14.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                                                                            sparseArray14.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                                                                            sparseArray14.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                                                                            sparseArray14.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                                                                            sparseArray14.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                                                                            sparseArray14.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_user_mute_visible, false);
                                                                                        }
                                                                                        if (z15) {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray14.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray14.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray14.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lIb);
                                                                                            gVar11.eNK.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lIb);
                                                                                        gVar4.eNK.setTag(sparseArray14);
                                                                                    } else {
                                                                                        if (z15) {
                                                                                            SparseArray sparseArray15 = new SparseArray();
                                                                                            sparseArray15.put(R.id.tag_should_manage_visible, false);
                                                                                            sparseArray15.put(R.id.tag_user_mute_visible, false);
                                                                                            sparseArray15.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray15.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                            sparseArray15.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray15.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray15.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            if (PbFragment.this.lDS.getPbData().dnj() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lIb);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lIb);
                                                                                            }
                                                                                            gVar11.eNK.setTag(sparseArray15);
                                                                                        }
                                                                                        gVar4 = null;
                                                                                    }
                                                                                    if (gVar11 != null) {
                                                                                        arrayList2.add(gVar11);
                                                                                    }
                                                                                    if (gVar4 != null) {
                                                                                        arrayList2.add(gVar4);
                                                                                    }
                                                                                }
                                                                                PbFragment.this.lIb.bu(arrayList2);
                                                                                PbFragment.this.lIa = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lIb);
                                                                                PbFragment.this.lIa.RU();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lHW.dsS();
                                                                    SparseArray<Object> b3 = PbFragment.this.lHW.b(PbFragment.this.lDS.getPbData(), PbFragment.this.lDS.dqm(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDS.getPbData().getForum().getId(), PbFragment.this.lDS.getPbData().getForum().getName(), PbFragment.this.lDS.getPbData().dmU().getId(), String.valueOf(PbFragment.this.lDS.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } else {
                                                                    PbFragment.this.showToast(R.string.network_not_available);
                                                                    return;
                                                                }
                                                            } else {
                                                                int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                if (skinType == 1) {
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    com.baidu.tbadk.core.util.ap.C(true, false);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).al("obj_type", 0).al("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).al("obj_type", 1).al("obj_source", 1));
                                                                }
                                                                PbFragment.this.lHW.lPe.dtY();
                                                            }
                                                        } else if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().dmU() != null) {
                                                            PbFragment.this.lHW.lPe.bca();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13062"));
                                                            PbFragment.this.Qe(PbFragment.this.lDS.getPbData().dmU().bpg());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lHW.dsS();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lDS.dqE()));
                                                                return;
                                                            }
                                                            PbFragment.this.cCF();
                                                            PbFragment.this.lHW.dsz();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lDS.getPbData().lAL == null || PbFragment.this.lDS.getPbData().lAL.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lDS.getPbData().lAL.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.lDS.getPbData().lAL.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.lDS.getPbData().lAL.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lDS.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.lDS.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.lDS.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.lDS.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12097").al("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).al("obj_type", i10));
                                                                    if (PbFragment.this.lDS.getPbData().lAL != null && PbFragment.this.lDS.getPbData().lAL.size() > i9) {
                                                                        i9 = PbFragment.this.lDS.getPbData().lAL.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean Ho = PbFragment.this.lDS.Ho(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lDS.dqE()));
                                                                    if (Ho) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lHW.vm(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.RU();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.lHW.dsS();
                                                    if (PbFragment.this.dol().getPbData().lAM != 2) {
                                                        if (PbFragment.this.lDS.getPageData() != null) {
                                                            PbFragment.this.lHW.a(PbFragment.this.lDS.getPageData(), PbFragment.this.lor);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lDS.getPbData()) != null) {
                                                by dmU = pbData.dmU();
                                                if (dmU != null && dmU.boP() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", PbFragment.this.lDS.lLj).dY("fid", pbData.getForumId()).al("obj_locate", 4).dY("uid", dmU.boP().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (dmU != null) {
                                                    if (dmU.bnx()) {
                                                        i9 = 2;
                                                    } else if (dmU.bny()) {
                                                        i9 = 3;
                                                    } else if (dmU.bqM()) {
                                                        i9 = 4;
                                                    } else if (dmU.bqN()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.ar arVar8 = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                arVar8.dY("tid", PbFragment.this.lDS.dqk());
                                                arVar8.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                arVar8.dY("fid", PbFragment.this.lDS.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    arVar8.al("obj_locate", 5);
                                                } else {
                                                    arVar8.al("obj_locate", 6);
                                                }
                                                arVar8.al("obj_name", i9);
                                                arVar8.al("obj_type", 1);
                                                if (dmU != null) {
                                                    if (dmU.bnx()) {
                                                        arVar8.al("obj_type", 10);
                                                    } else if (dmU.bny()) {
                                                        arVar8.al("obj_type", 9);
                                                    } else if (dmU.bqN()) {
                                                        arVar8.al("obj_type", 8);
                                                    } else if (dmU.bqM()) {
                                                        arVar8.al("obj_type", 7);
                                                    } else if (dmU.isShareThread) {
                                                        arVar8.al("obj_type", 6);
                                                    } else if (dmU.threadType == 0) {
                                                        arVar8.al("obj_type", 1);
                                                    } else if (dmU.threadType == 40) {
                                                        arVar8.al("obj_type", 2);
                                                    } else if (dmU.threadType == 49) {
                                                        arVar8.al("obj_type", 3);
                                                    } else if (dmU.threadType == 54) {
                                                        arVar8.al("obj_type", 4);
                                                    } else {
                                                        arVar8.al("obj_type", 5);
                                                    }
                                                    arVar8.al(IntentConfig.CARD_TYPE, dmU.bqQ());
                                                    arVar8.dY(IntentConfig.RECOM_SOURCE, dmU.mRecomSource);
                                                    arVar8.dY("ab_tag", dmU.mRecomAbTag);
                                                    arVar8.dY("weight", dmU.mRecomWeight);
                                                    arVar8.dY("extra", dmU.mRecomExtra);
                                                    arVar8.dY("nid", dmU.getNid());
                                                    if (dmU.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(dmU.getBaijiahaoData().oriUgcVid)) {
                                                        arVar8.dY("obj_param6", dmU.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    arVar8.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.dpR() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.dpR(), arVar8);
                                                }
                                                TiebaStatic.log(arVar8);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dmW2 = PbFragment.this.lDS.getPbData().dmW();
                                                    if ((dmW2 != null && dmW2.size() > 0) || !PbFragment.this.lDS.dqm()) {
                                                        PbFragment.this.lHW.dsS();
                                                        PbFragment.this.cCF();
                                                        if (pbData.dnq() != null && !StringUtils.isNull(pbData.dnq().bmL(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dY("fid", PbFragment.this.lDS.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dmU)) {
                                                            if (PbFragment.this.lHW != null) {
                                                                PbFragment.this.lHW.dsV();
                                                                PbFragment.this.lHW.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lHW.showLoadingDialog();
                                                                PbFragment.this.lDS.dqQ().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i10 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i10 = 1;
                                                                }
                                                                PbFragment.this.Hf(i10);
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                        return;
                                                    }
                                                } else {
                                                    com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lHW.dsS();
                                            if (PbFragment.this.lHW.lPe.dtZ() != null && view == PbFragment.this.lHW.lPe.dtZ().drx() && !PbFragment.this.lHW.dtk()) {
                                                PbFragment.this.lHW.dsc();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cCF();
                                                PbFragment.this.lHW.dsz();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    C = PbFragment.this.lDS.C(true, PbFragment.this.dpz());
                                                } else {
                                                    C = view.getId() == R.id.reply_title ? PbFragment.this.lDS.C(false, PbFragment.this.dpz()) : PbFragment.this.lDS.Qj(PbFragment.this.dpz());
                                                }
                                                view.setTag(Boolean.valueOf(C));
                                                if (C) {
                                                    PbFragment.this.lHW.uH(true);
                                                    PbFragment.this.lHW.cYn();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lHW.vm(true);
                                                }
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.lHW.dsS();
                                        if (PbFragment.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lDS.Hp(PbFragment.this.lHW.dsE()) != null) {
                                            PbFragment.this.dpu();
                                            if (PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().dmU() != null && PbFragment.this.lDS.getPbData().dmU().boP() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", PbFragment.this.lDS.lLj).dY("fid", PbFragment.this.lDS.getPbData().getForumId()).al("obj_locate", 3).dY("uid", PbFragment.this.lDS.getPbData().dmU().boP().getUserId()));
                                            }
                                            if (PbFragment.this.lDS.getPbData().dmU() != null && PbFragment.this.lDS.getPbData().dmU().boP() != null && PbFragment.this.lDS.getPbData().dmU().boP().getUserId() != null && PbFragment.this.lHU != null) {
                                                int h = PbFragment.this.h(PbFragment.this.lDS.getPbData());
                                                by dmU2 = PbFragment.this.lDS.getPbData().dmU();
                                                int i11 = 1;
                                                if (dmU2.bnx()) {
                                                    i11 = 2;
                                                } else if (dmU2.bny()) {
                                                    i11 = 3;
                                                } else if (dmU2.bqM()) {
                                                    i11 = 4;
                                                } else if (dmU2.bqN()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dY("tid", PbFragment.this.lDS.lLj).al("obj_locate", 1).dY("obj_id", PbFragment.this.lDS.getPbData().dmU().boP().getUserId()).al("obj_type", PbFragment.this.lHU.bkY() ? 0 : 1).al("obj_source", h).al("obj_param1", i11));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else {
                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                    if (PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().dmU() != null && PbFragment.this.lDS.getPbData().dmU().bnv() && PbFragment.this.lDS.getPbData().dmU().bph() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11922"));
                                    }
                                    if (PbFragment.this.lDS.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lDS.doe()) || PbFragment.this.lDS.getAppealInfo() == null) {
                                            PbFragment.this.lHp.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lDS.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lDS.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.lHp.finish();
                                        return;
                                    }
                                    String doe2 = PbFragment.this.lDS.doe();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lDS.dqn() && doe2 != null && doe2.equals(name2)) {
                                        PbFragment.this.lHp.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lDS.getPbData() != null) {
                                    if ((PbFragment.this.lDS.getPbData().dnj() == 1 || PbFragment.this.lDS.getPbData().dnj() == 3) && !PbFragment.this.fXd.dQc()) {
                                        PbFragment.this.lHW.dsS();
                                        int i12 = 0;
                                        if (PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().dry()) {
                                            if (PbFragment.this.lHW.lPe.dtZ() == null || view != PbFragment.this.lHW.lPe.dtZ().drA()) {
                                                if (view == PbFragment.this.lHW.dsx()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.lDS.getPbData().dmU().boL() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.lDS.getPbData().dmU().boK() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.lDS.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.lDS.getPbData().dmU().getId();
                                        PbFragment.this.lHW.dsw();
                                        PbFragment.this.fXd.c(id4, name3, id5, i12, PbFragment.this.lHW.dsy());
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                PbFragment.this.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            PbFragment.this.lHW.lPe.dtY();
                            if (PbFragment.this.lDS != null) {
                                PbFragment.this.ikq.setThreadId(PbFragment.this.lDS.dqk());
                            }
                            int i13 = 1;
                            if (PbFragment.this.lDS == null || !PbFragment.this.lDS.isPrivacy()) {
                                PbFragment.this.ikq.crD();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dol() != null && PbFragment.this.dol().getPbData() != null && PbFragment.this.dol().getPbData().getThreadId() != null && PbFragment.this.dol().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.dol() != null && PbFragment.this.dol().getPbData() != null) {
                                    PbFragment.this.ikq.l(3, i13, PbFragment.this.dol().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dol() != null && PbFragment.this.dol().getPbData() != null) {
                                    PbFragment.this.ikq.l(3, 3, PbFragment.this.dol().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lHW.dsS();
                        PbFragment.this.cCF();
                        PbFragment.this.lHW.dsz();
                        PbFragment.this.lHW.showLoadingDialog();
                        if (PbFragment.this.lHW.dsl() != null) {
                            PbFragment.this.lHW.dsl().setVisibility(8);
                        }
                        PbFragment.this.lDS.Hj(1);
                        if (PbFragment.this.lHs != null) {
                            PbFragment.this.lHs.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String dpj = PbFragment.this.dpj();
                        if (!TextUtils.isEmpty(dpj)) {
                            bf.bua().b(PbFragment.this.getPageContext(), new String[]{dpj});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar9 = new com.baidu.tbadk.core.util.ar("c13398");
                arVar9.dY("tid", PbFragment.this.lDS.dqk());
                arVar9.dY("fid", PbFragment.this.lDS.getForumId());
                arVar9.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar9.al("obj_locate", 1);
                TiebaStatic.log(arVar9);
                if (PbFragment.this.lHB) {
                    PbFragment.this.lHB = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.dpc().drZ() != null && postData7.boP() != null && postData7.dPh() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.dpc().dsa() != null) {
                                PbFragment.this.dpc().dsa().doS();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.lDS.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.lDS.getPbData().dmU());
                            pVar2.g(postData7);
                            PbFragment.this.dpc().drZ().d(pVar2);
                            PbFragment.this.dpc().drZ().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.boP().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lDS.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lIi != null) {
                                PbFragment.this.lHW.vw(PbFragment.this.lIi.bDb());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lIV = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lDS != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lDS.lLj)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lDS.getPbData() != null) {
                    arVar.dY("fid", PbFragment.this.lDS.getPbData().getForumId());
                }
                arVar.dY("tid", PbFragment.this.lDS.dqk());
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            PbFragment.this.cCF();
            PbFragment.this.lHW.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbFragment.this.g(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.lDS.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDS.getPbData();
                            if (pbData != null && pbData.dmU() != null && pbData.dmU().boP() != null && (userId = pbData.dmU().boP().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lDS.dqx()) {
                                PbFragment.this.lHW.dsz();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lDS.dqx()) {
                            PbFragment.this.lHW.dsz();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lHW.s(PbFragment.this.lDS.getPbData());
                    }
                    if (PbFragment.this.lDS.dqr()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10369").dY("tid", PbFragment.this.lDS.dqk()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.uN(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lIi.bDi() || PbFragment.this.lIi.bDj()) {
                    PbFragment.this.lIi.a(false, postWriteCallBackData);
                }
                PbFragment.this.kNm.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kJE != null) {
                    PbFragment.this.kJE.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Bq(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bq(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).brv();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").al("obj_locate", 1).al("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d lIW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                    arVar.dY("fid", PbFragment.this.lDS.getPbData().getForumId());
                }
                if (PbFragment.this.lDS != null) {
                    arVar.dY("tid", PbFragment.this.lDS.dqk());
                }
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (PbFragment.this.kNm != null) {
                    PbFragment.this.kNm.dtr();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(PbFragment.this.getPageContext(), postWriteCallBackData);
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.kJE != null) {
                    PbFragment.this.kJE.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Bq(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bq(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).brv();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").al("obj_locate", 1).al("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kNm != null) {
                if (PbFragment.this.lHW != null && PbFragment.this.lHW.dsa() != null && PbFragment.this.lHW.dsa().doW() != null && PbFragment.this.lHW.dsa().doW().bDj()) {
                    PbFragment.this.lHW.dsa().doW().a(postWriteCallBackData);
                }
                PbFragment.this.kNm.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lIX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dtn;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.lHp.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lHW != null && (dtn = PbFragment.this.lHW.dtn()) != null && PbFragment.this.lHW.getListView() != null) {
                            PbFragment.this.lHW.getListView().removeHeaderView(dtn);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lIY = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h sg;
            if (!z || fVar == null || fVar.dnh() != null || com.baidu.tbadk.core.util.y.getCount(fVar.dmW()) >= 1) {
                PbFragment.this.lcW = true;
                PbFragment.this.lHW.dsB();
                if (fVar == null || !fVar.dnc()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lHW.getView());
                }
                PbFragment.this.lHW.cYm();
                if (PbFragment.this.isFullScreen || PbFragment.this.lHW.dtk()) {
                    PbFragment.this.lHW.dtb();
                } else if (!PbFragment.this.lHW.dsY()) {
                    PbFragment.this.lHW.vy(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.geK = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lHW.getView());
                    PbFragment.this.lHW.dsK();
                }
                if (z && fVar != null) {
                    by dmU = fVar.dmU();
                    if (dmU == null || !dmU.bnz()) {
                        PbFragment.this.d(PbFragment.this.lIh);
                    } else {
                        dpT();
                    }
                    PbFragment.this.lHW.dsa().setPbData(fVar);
                    PbFragment.this.lHW.bYt();
                    if (dmU != null && dmU.bqc() != null) {
                        PbFragment.this.a(dmU.bqc());
                    }
                    if (PbFragment.this.lIi != null) {
                        PbFragment.this.lHW.vw(PbFragment.this.lIi.bDb());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dmW() != null && fVar.dmW().size() >= 1 && fVar.dmW().get(0) != null) {
                        PbFragment.this.lDS.Ql(fVar.dmW().get(0).getId());
                    } else if (fVar.dnh() != null) {
                        PbFragment.this.lDS.Ql(fVar.dnh().getId());
                    }
                    if (PbFragment.this.lIi != null) {
                        PbFragment.this.lIi.a(fVar.getAnti());
                        PbFragment.this.lIi.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lIi.setThreadData(dmU);
                        PbFragment.this.lIi.a(PbFragment.this.lDS.dqB(), PbFragment.this.lDS.dqk(), PbFragment.this.lDS.dqS());
                        if (dmU != null) {
                            PbFragment.this.lIi.kD(dmU.bqo());
                        }
                    }
                    if (PbFragment.this.lHU != null) {
                        PbFragment.this.lHU.iH(fVar.bkY());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.dny()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lHW.vx(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lHW.a(fVar, i2, i3, PbFragment.this.lDS.dqm(), i4, PbFragment.this.lDS.getIsFromMark());
                    PbFragment.this.lHW.d(fVar, PbFragment.this.lDS.dqm());
                    PbFragment.this.lHW.vu(PbFragment.this.lDS.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fwy = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fwy) && PbFragment.this.lIi != null && PbFragment.this.lIi.bCn() != null && (sg = PbFragment.this.lIi.bCn().sg(6)) != null && !TextUtils.isEmpty(PbFragment.this.fwy)) {
                            ((View) sg).setOnClickListener(PbFragment.this.fxl);
                        }
                    }
                    if (PbFragment.this.lId) {
                        PbFragment.this.lId = false;
                        final int dpq = PbFragment.this.dpq();
                        if (!fVar.dnv()) {
                            PbFragment.this.lHW.Hw(dpq);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dpq, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lIe) {
                        PbFragment.this.lIe = false;
                        final int dpq2 = PbFragment.this.dpq();
                        final boolean z2 = dpq2 != -1;
                        if (!z2) {
                            dpq2 = PbFragment.this.dpr();
                        }
                        if (PbFragment.this.lHW != null) {
                            if (!fVar.dnv()) {
                                PbFragment.this.lHW.Hw(dpq2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dpq2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lHW.setSelectionFromTop(dpq2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lHW.setSelectionFromTop(dpq2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lHW.vz(true);
                                PbFragment.this.lHW.vy(false);
                            }
                        }
                    } else if (PbFragment.this.lIf) {
                        PbFragment.this.lIf = false;
                        PbFragment.this.lHW.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lHW.dsF();
                    }
                    PbFragment.this.lDS.a(fVar.getForum(), PbFragment.this.lIJ);
                    PbFragment.this.lDS.a(PbFragment.this.lIK);
                    if (PbFragment.this.kJE != null && dmU != null && dmU.boP() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dmU.boP());
                        PbFragment.this.kJE.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.geK && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lDS.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lDS.getAppealInfo().lAD)) {
                                    PbFragment.this.lHW.a(PbFragment.this.lDS.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lHW.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lHW.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lHW.dtb();
                            PbFragment.this.lHW.dsJ();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lDS.dqk());
                            jSONObject.put("fid", PbFragment.this.lDS.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                        kVar.setOpType("2");
                        kVar.start();
                    }
                    if (i == -1) {
                        PbFragment.this.lHW.Qr("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                            arrayList = PbFragment.this.lDS.getPbData().dmW();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dPh() != 1)) {
                            PbFragment.this.lHW.Qr(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dpK()) {
                                PbFragment.this.lHW.Qs(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lHW.Qs(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lHW.s(PbFragment.this.lDS.getPbData());
                        }
                    }
                    PbFragment.this.lHW.endLoadData();
                }
                if (fVar != null && fVar.lAS && PbFragment.this.fCl == 0) {
                    PbFragment.this.fCl = System.currentTimeMillis() - PbFragment.this.ivA;
                }
                if (!PbFragment.this.dol().dqm() || PbFragment.this.dol().getPbData().getPage().bnG() != 0 || PbFragment.this.dol().dqN()) {
                    PbFragment.this.lIj = true;
                    return;
                }
                return;
            }
            PbFragment.this.lDS.Hj(1);
            if (PbFragment.this.lHs != null) {
                PbFragment.this.lHs.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dpT() {
            if (PbFragment.this.lDS != null) {
                if (PbFragment.this.lIi == null || !PbFragment.this.lIi.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lIi = (com.baidu.tbadk.editortools.pb.e) dVar.eN(PbFragment.this.getContext());
                    PbFragment.this.lIi.a(PbFragment.this.lHp.getPageContext());
                    PbFragment.this.lIi.a(PbFragment.this.fwI);
                    PbFragment.this.lIi.a(PbFragment.this.fwB);
                    PbFragment.this.lIi.a(PbFragment.this.lHp.getPageContext(), PbFragment.this.lHp.getIntent() == null ? null : PbFragment.this.lHp.getIntent().getExtras());
                    PbFragment.this.lIi.bCn().ks(true);
                    PbFragment.this.lHW.setEditorTools(PbFragment.this.lIi.bCn());
                    if (!PbFragment.this.lDS.dqs()) {
                        PbFragment.this.lIi.DV(PbFragment.this.lDS.dqk());
                    }
                    if (PbFragment.this.lDS.dqT()) {
                        PbFragment.this.lIi.DT(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lHW != null) {
                        PbFragment.this.lIi.DT(PbFragment.this.lHW.dse());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lHW.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.l.bFl().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.ivA : j;
                if (PbFragment.this.fCl == 0) {
                    PbFragment.this.fCl = currentTimeMillis;
                }
                com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, PbFragment.this.fCb, PbFragment.this.createTime, PbFragment.this.fCl, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fCb = 0L;
                if (hVar != null) {
                    hVar.bFi();
                }
                if (z2) {
                    hVar.fCu = currentTimeMillis;
                    hVar.kR(true);
                }
                if (!z2 && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().dmU() != null) {
                    int threadType = PbFragment.this.lDS.getPbData().dmU().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.au.equals(PbFragment.this.lHF, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.au.equals(PbFragment.this.lHF, "from_frs")) {
                                com.baidu.tbadk.n.h hVar2 = new com.baidu.tbadk.n.h();
                                hVar2.setSubType(1000);
                                hVar2.fCw = currentTimeMillis;
                                hVar2.sJ(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.fCw = currentTimeMillis;
                        dVar.sJ(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener lIZ = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.dpm();
            }
        }
    };
    private final a.InterfaceC0583a lJa = new a.InterfaceC0583a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0583a
        public void d(boolean z, boolean z2, String str) {
            PbFragment.this.lHW.dsB();
            if (z) {
                if (PbFragment.this.lHU != null) {
                    PbFragment.this.lHU.iH(z2);
                }
                PbFragment.this.lDS.vc(z2);
                if (PbFragment.this.lDS.bkY()) {
                    PbFragment.this.dpv();
                } else {
                    PbFragment.this.lHW.s(PbFragment.this.lDS.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lHU != null) {
                        if (PbFragment.this.lHU.blb() != null && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.lDS.getPbData().dmU() != null && PbFragment.this.lDS.getPbData().dmU().boP() != null) {
                            MarkData blb = PbFragment.this.lHU.blb();
                            MetaData boP = PbFragment.this.lDS.getPbData().dmU().boP();
                            if (blb != null && boP != null) {
                                if (!com.baidu.tbadk.core.util.au.equals(TbadkCoreApplication.getCurrentAccount(), boP.getUserId()) && !boP.hadConcerned()) {
                                    PbFragment.this.b(boP);
                                } else {
                                    PbFragment.this.showToast(R.string.add_mark_on_pb);
                                    if (com.baidu.tbadk.coreExtra.c.a.F(PbFragment.this.getContext(), 0)) {
                                        com.baidu.tbadk.coreExtra.c.a.a(PbFragment.this.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    PbFragment.this.dps();
                    return;
                }
                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbFragment.this.GT(PbFragment.this.mLastScrollState) && PbFragment.this.GT(i)) {
                if (PbFragment.this.lHW != null) {
                    PbFragment.this.lHW.dsS();
                    if (PbFragment.this.lIi != null && !PbFragment.this.lHW.dsd()) {
                        PbFragment.this.lHW.vw(PbFragment.this.lIi.bDb());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lHW.dsc();
                    }
                }
                if (!PbFragment.this.lHy) {
                    PbFragment.this.lHy = true;
                }
            }
            if (PbFragment.this.lHW != null) {
                PbFragment.this.lHW.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lHs != null) {
                PbFragment.this.lHs.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lHz == null) {
                PbFragment.this.lHz = new com.baidu.tbadk.n.b();
                PbFragment.this.lHz.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.lHz.bFe();
            } else {
                PbFragment.this.lHz.bFd();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.t.c.dOf().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dmW;
            if (PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null && PbFragment.this.lHW != null && PbFragment.this.lHW.dsu() != null) {
                PbFragment.this.lHW.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.lHs != null) {
                    PbFragment.this.lHs.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lDS.dqJ() && (dmW = PbFragment.this.lDS.getPbData().dmW()) != null && !dmW.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lHW.dsu().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDS.getPbData();
                    if (pbData != null) {
                        if (pbData.dmX() != null && pbData.dmX().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dmY() != null && pbData.dmY().hasData()) {
                            headerCount--;
                        }
                        int size = dmW.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d ikv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.fXd.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.lDS.dqG();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.lXy != 1002 || bVar.gZt) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lHW.a(1, dVar.mSuccess, dVar.noK, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.fXd.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lHW.a(PbFragment.this.fXd.getLoadDataMode(), gVar.mSuccess, gVar.noK, false);
                            PbFragment.this.lHW.bf(gVar.noN);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lHW.a(PbFragment.this.fXd.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lJb = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c gcs = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dpA()) {
                PbFragment.this.lHp.finish();
            }
            if (!PbFragment.this.lDS.vb(true)) {
                PbFragment.this.lHW.dsC();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lJd = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lJc && PbFragment.this.dpA()) {
                PbFragment.this.dpC();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lHQ && PbFragment.this.lHW != null && PbFragment.this.lHW.dtp() && PbFragment.this.lDS != null) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13999");
                    arVar.dY("tid", PbFragment.this.lDS.dqk());
                    arVar.dY("fid", PbFragment.this.lDS.getForumId());
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (!PbFragment.this.lDS.dqn()) {
                        if (!PbFragment.this.lDS.dqq()) {
                            if (PbFragment.this.lDS.dqp()) {
                                i = 1;
                            }
                        } else {
                            i = 3;
                        }
                    } else {
                        i = 4;
                    }
                    arVar.al("obj_type", i);
                    TiebaStatic.log(arVar);
                    PbFragment.this.lHQ = true;
                }
                if (PbFragment.this.lDS.va(false)) {
                    PbFragment.this.lHW.dsA();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lDS.getPbData() != null) {
                    PbFragment.this.lHW.dsX();
                }
                PbFragment.this.lJc = true;
            }
        }
    };
    private int lJe = 0;
    private final TbRichTextView.i fNk = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dsu;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lHW.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                arVar.dY("tid", PbFragment.this.lDS.dqk());
                arVar.dY("fid", PbFragment.this.lDS.getForumId());
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.al("obj_locate", 3);
                arVar.al("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(arVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lDS.lEP.dny()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bID() != null) {
                            ArrayList<TbRichTextImageInfo> bID = tbRichTextView.getRichText().bID();
                            int i4 = 0;
                            while (i4 < bID.size()) {
                                if (bID.get(i4) != null) {
                                    arrayList.add(bID.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bID.get(i4).getSrc()) || str.equals(bID.get(i4).bIX()) || str.equals(bID.get(i4).bIU()) || str.equals(bID.get(i4).bIW()) || str.equals(bID.get(i4).bJa()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bID.get(i4).getSrc();
                                    imageUrlData.originalUrl = bID.get(i4).getSrc();
                                    imageUrlData.isLongPic = bID.get(i4).bJc();
                                    concurrentHashMap.put(bID.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).oj(i3).iN(false).iO(PbFragment.this.lDS.dqD()).a(concurrentHashMap).iP(true).iQ(false).iR(PbFragment.this.dpK()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lDS != null) {
                            aVar.AL(PbFragment.this.lDS.getFromForumId());
                            if (PbFragment.this.lDS.getPbData() != null) {
                                aVar.s(PbFragment.this.lDS.getPbData().dmU());
                            }
                        }
                        ImageViewerConfig ez = aVar.ez(PbFragment.this.getPageContext().getPageActivity());
                        ez.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.lEb) {
                        TbRichText bz = PbFragment.this.bz(str, i);
                        if (bz != null && PbFragment.this.lJe >= 0 && PbFragment.this.lJe < bz.bIC().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bz.bIC().get(PbFragment.this.lJe));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lEa.size()) {
                                    break;
                                } else if (!aVar2.lEa.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bz.getPostId() != 0 && (dsu = PbFragment.this.lHW.dsu()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = dsu.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && bz.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bz.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lDS.dqS(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lDS.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.eCN.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.x(arrayList2).AG(aVar2.forumName).AH(aVar2.forumId).AI(aVar2.threadId).iN(aVar2.eCL).iP(true).AJ(aVar2.lastId).iO(PbFragment.this.lDS.dqD()).a(concurrentHashMap2).iQ(false).iR(PbFragment.this.dpK()).AK(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lDS != null) {
                                aVar3.AL(PbFragment.this.lDS.getFromForumId());
                                if (PbFragment.this.lDS.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lDS.getPbData().dmU());
                                }
                            }
                            ImageViewerConfig ez2 = aVar3.ez(PbFragment.this.getPageContext().getPageActivity());
                            ez2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.lEa, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.eCN.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).AG(aVar2.forumName).AH(aVar2.forumId).AI(aVar2.threadId).iN(aVar2.eCL).iP(true).AJ(aVar2.lEa.get(0)).iO(PbFragment.this.lDS.dqD()).a(concurrentHashMap3).iQ(false).iR(PbFragment.this.dpK()).AK(aVar2.postId).iS(false);
                    if (PbFragment.this.lDS != null) {
                        aVar4.AL(PbFragment.this.lDS.getFromForumId());
                        if (PbFragment.this.lDS.getPbData() != null) {
                            aVar4.s(PbFragment.this.lDS.getPbData().dmU());
                        }
                    }
                    ImageViewerConfig ez3 = aVar4.ez(PbFragment.this.getPageContext().getPageActivity());
                    ez3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.lHJ = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lJf = false;
    PostData jZf = null;
    private final b.InterfaceC0586b lJg = new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jZf != null) {
                if (i == 0) {
                    PbFragment.this.jZf.gD(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.jZf = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.jZf);
                }
            }
        }
    };
    private final b.InterfaceC0586b lJh = new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lIs != null && !TextUtils.isEmpty(PbFragment.this.lIt)) {
                if (i == 0) {
                    if (PbFragment.this.lIu == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lIt));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.lIt;
                        aVar.pkgId = PbFragment.this.lIu.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lIu.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.eBS == null) {
                            PbFragment.this.eBS = new bd(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.eBS.j(PbFragment.this.lIt, PbFragment.this.lIs.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lIs = null;
                PbFragment.this.lIt = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment.this.lHq = true;
            return PbFragment.this.dx(view);
        }
    };
    private final NoNetworkView.a iQh = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bIA && z && !PbFragment.this.lDS.dqt()) {
                PbFragment.this.dpx();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.iXQ.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0756a irO = new a.InterfaceC0756a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int gYZ = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void G(int i, int i2) {
            if (ay(i2) && PbFragment.this.lHW != null && PbFragment.this.lHs != null) {
                PbFragment.this.lHs.qn(true);
                if (Math.abs(i2) > this.gYZ) {
                    PbFragment.this.lHs.hideFloatingView();
                }
                if (PbFragment.this.dpA()) {
                    PbFragment.this.lHW.dsr();
                    PbFragment.this.lHW.dss();
                }
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void H(int i, int i2) {
            if (ay(i2) && PbFragment.this.lHW != null && PbFragment.this.lHs != null) {
                PbFragment.this.lHW.dtc();
                PbFragment.this.lHs.qn(false);
                PbFragment.this.lHs.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void ck(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void I(int i, int i2) {
        }

        private boolean ay(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final q.a lGt = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void q(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lHW.Qt(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lJj = -1;
    private int lJk = -1;

    /* loaded from: classes22.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes22.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes22.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e doX() {
        return this.lIi;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.dnN() != null) {
            String id = pVar.dnN().getId();
            ArrayList<PostData> dmW = this.lDS.getPbData().dmW();
            int i = 0;
            while (true) {
                if (i >= dmW.size()) {
                    z = true;
                    break;
                }
                PostData postData = dmW.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dnV = pVar.dnV();
                    postData.KU(pVar.getTotalCount());
                    if (postData.dPe() == null || dnV == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dnV.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.boP() != null && (metaData = postData.getUserMap().get(next.boP().getUserId())) != null) {
                                next.a(metaData);
                                next.yc(true);
                                next.a(getPageContext(), this.lDS.Qk(metaData.getUserId()));
                            }
                        }
                        z = dnV.size() != postData.dPe().size();
                        if (postData.dPe() != null && postData.dPe().size() < 2) {
                            postData.dPe().clear();
                            postData.dPe().addAll(dnV);
                        }
                    }
                    if (postData.dPa() != null) {
                        postData.dPb();
                    }
                }
            }
            if (!this.lDS.getIsFromMark() && z) {
                this.lHW.s(this.lDS.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qc(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n dnm = this.lDS.getPbData().dnm();
            if (dnm != null && str.equals(dnm.getAdId())) {
                if (dnm.dOV() != null) {
                    dnm.dOV().legoCard = null;
                }
                this.lDS.getPbData().dnn();
            }
            com.baidu.tieba.tbadkCore.data.n dqz = this.lDS.dqz();
            if (dqz != null && str.equals(dqz.getAdId())) {
                this.lDS.dqA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lIa != null && this.lIa.isShowing()) {
                this.lIa.dismiss();
                this.lIa = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lIa != null) {
                            PbFragment.this.lIa.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lHW.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lIq);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lIq);
                            PbFragment.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow));
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
                kVar.bu(arrayList);
                this.lIa = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lIa.RU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf(int i) {
        by dmU;
        if (this.lDS != null && this.lDS.getPbData() != null && (dmU = this.lDS.getPbData().dmU()) != null) {
            if (i == 1) {
                PraiseData boA = dmU.boA();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (boA == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        dmU.a(praiseData);
                    } else {
                        dmU.boA().getUser().add(0, metaData);
                        dmU.boA().setNum(dmU.boA().getNum() + 1);
                        dmU.boA().setIsLike(i);
                    }
                }
                if (dmU.boA() != null) {
                    if (dmU.boA().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.au.numFormatOver10000(dmU.boA().getNum());
                    }
                }
            } else if (dmU.boA() != null) {
                dmU.boA().setIsLike(i);
                dmU.boA().setNum(dmU.boA().getNum() - 1);
                ArrayList<MetaData> user = dmU.boA().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dmU.boA().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dmU.boA().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dmU.boA().getNum() + "";
                }
            }
            if (this.lDS.dqm()) {
                this.lHW.dsu().notifyDataSetChanged();
            } else {
                this.lHW.t(this.lDS.getPbData());
            }
        }
    }

    public static PbFragment doY() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lHp = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lDS.aD(bundle);
        if (this.iSW != null) {
            this.iSW.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lIi.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lHx = System.currentTimeMillis();
        this.lIo = getPageContext();
        final Intent intent = this.lHp.getIntent();
        if (intent != null) {
            this.ivA = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lHF = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lHF)) {
                    this.lHF = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lHF)) {
                this.lHt = true;
            }
            this.lJj = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lJk = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lJl = intent.getStringExtra("key_manga_title");
            this.lId = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lIe = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lIf = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dpA()) {
                this.lHp.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.lIw = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lHO = new bh();
            this.lHO.C(intent);
            this.lIy = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lIy == 0) {
                this.lIy = intent.getIntExtra("key_start_from", 0);
            }
            this.lIz = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.ivA = System.currentTimeMillis();
        }
        this.fCb = this.lHx - this.ivA;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.lHv = 0;
        aC(bundle);
        if (this.lDS.getPbData() != null) {
            this.lDS.getPbData().PW(this.source);
        }
        dpb();
        if (intent != null && this.lHW != null) {
            this.lHW.lPc = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lIr == null) {
                    this.lIr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lHW.Qv(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.lIr, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lDS.getPbData() != null) {
                this.lDS.Qn(stringExtra);
            }
        }
        this.iSW = new VoiceManager();
        this.iSW.onCreate(getPageContext());
        initData(bundle);
        this.lIh = new com.baidu.tbadk.editortools.pb.g();
        d(this.lIh);
        this.lIi = (com.baidu.tbadk.editortools.pb.e) this.lIh.eN(getActivity());
        this.lIi.a(this.lHp.getPageContext());
        this.lIi.a(this.fwI);
        this.lIi.a(this.fwB);
        this.lIi.setFrom(1);
        this.lIi.a(this.lHp.getPageContext(), bundle);
        this.lIi.bCn().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lIi.bCn().ks(true);
        uM(true);
        this.lIi.a(this.lDS.dqB(), this.lDS.dqk(), this.lDS.dqS());
        registerListener(this.lIE);
        if (!this.lDS.dqs()) {
            this.lIi.DV(this.lDS.dqk());
        }
        if (this.lDS.dqT()) {
            this.lIi.DT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lHW != null) {
            this.lIi.DT(this.lHW.dse());
        }
        registerListener(this.lID);
        registerListener(this.lIF);
        registerListener(this.lIG);
        registerListener(this.iUC);
        registerListener(this.lIS);
        registerListener(this.lIC);
        this.lIg = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.nlj);
        this.lIg.dOO();
        registerListener(this.lIH);
        registerListener(this.eTG);
        this.lDS.dqL();
        registerListener(this.lIZ);
        registerListener(this.iUK);
        registerListener(this.lIV);
        if (this.lHW != null && this.lHW.dtg() != null && this.lHW.dth() != null) {
            this.lHs = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lHW.dtg(), this.lHW.dth(), this.lHW.dsl());
            this.lHs.a(this.lIN);
        }
        if (this.lHr && this.lHW != null && this.lHW.dth() != null) {
            this.lHW.dth().setVisibility(8);
        }
        this.lIp = new com.baidu.tbadk.core.view.c();
        this.lIp.toastTime = 1000L;
        registerListener(this.lIR);
        registerListener(this.lIP);
        registerListener(this.lIQ);
        registerListener(this.jqi);
        registerListener(this.iUy);
        this.lII.setSelfListener(true);
        this.lII.setTag(this.lHp.getUniqueId());
        this.lII.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lII);
        registerResponsedEventListener(TipEvent.class, this.iSa);
        this.lIq = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lIq;
        userMuteAddAndDelCustomMessage.setTag(this.lIq);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lIq;
        userMuteCheckCustomMessage.setTag(this.lIq);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lDS.dqQ().a(this.lIO);
        this.kNm = new bb();
        if (this.lIi.bCT() != null) {
            this.kNm.e(this.lIi.bCT().getInputView());
        }
        this.lIi.a(this.fwC);
        this.joM = new ShareSuccessReplyToServerModel();
        a(this.lIA);
        this.kJE = new com.baidu.tbadk.core.util.am(getPageContext());
        this.kJE.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.eTx) {
                        PbFragment.this.lIi.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.eTy && PbFragment.this.lHW != null && PbFragment.this.lHW.dsa() != null && PbFragment.this.lHW.dsa().doW() != null) {
                        PbFragment.this.lHW.dsa().doW().bDr();
                    } else if (i == com.baidu.tbadk.core.util.am.eTz) {
                        PbFragment.this.c(PbFragment.this.lIl);
                    }
                }
            }
        });
        this.lHT = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lHT.w(getUniqueId());
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
        com.baidu.tbadk.core.business.a.bmh().dK("3", "");
        this.ikq = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.lHx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lDS != null) {
            gVar.setForumName(this.lDS.doe());
            if (this.lDS.getPbData() != null && this.lDS.getPbData().getForum() != null) {
                gVar.a(this.lDS.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lDS);
        }
    }

    public String doZ() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b dpa() {
        return this.lHs;
    }

    private void uM(boolean z) {
        this.lIi.kA(z);
        this.lIi.kB(z);
        this.lIi.kC(z);
    }

    private void dpb() {
        this.fgf = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iSW != null) {
            this.iSW.onStart(getPageContext());
        }
    }

    public az dpc() {
        return this.lHW;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dol() {
        return this.lDS;
    }

    public void Qd(String str) {
        if (this.lDS != null && !StringUtils.isNull(str) && this.lHW != null) {
            this.lHW.vB(true);
            this.lDS.Qd(str);
            this.lHD = true;
            this.lHW.dsS();
            this.lHW.dtb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.bIA = false;
        } else {
            this.bIA = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.lHv = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.lHv == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.iSW != null) {
            this.iSW.onPause(getPageContext());
        }
        if (this.lHW != null) {
            this.lHW.onPause();
        }
        if (!this.lDS.dqs()) {
            this.lIi.DU(this.lDS.dqk());
        }
        if (this.lDS != null) {
            this.lDS.dqM();
        }
        com.baidu.tbadk.BdToken.c.biD().biO();
        MessageManager.getInstance().unRegisterListener(this.jhd);
        cRx();
        MessageManager.getInstance().unRegisterListener(this.lIP);
        MessageManager.getInstance().unRegisterListener(this.lIQ);
        MessageManager.getInstance().unRegisterListener(this.lIR);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean dpd() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lDS.getPbData(), this.lDS.dqm(), this.lDS.dqK());
        return (a2 == null || a2.boP() == null || a2.boP().getGodUserData() == null || a2.boP().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bIA = false;
        super.onResume();
        if (this.lHH) {
            this.lHH = false;
            dpG();
        }
        if (dpd()) {
            this.lHA = System.currentTimeMillis();
        } else {
            this.lHA = -1L;
        }
        if (this.lHW != null && this.lHW.getView() != null) {
            if (!this.lcW) {
                dpy();
            } else {
                hideLoadingView(this.lHW.getView());
            }
            this.lHW.onResume();
        }
        if (this.lHv == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lHW != null) {
            noNetworkView = this.lHW.drX();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.iSW != null) {
            this.iSW.onResume(getPageContext());
        }
        registerListener(this.jhd);
        this.lIc = false;
        dpF();
        registerListener(this.lIP);
        registerListener(this.lIQ);
        registerListener(this.lIR);
        if (this.iTK) {
            dpx();
            this.iTK = false;
        }
        dpN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lHW.vq(z);
        if (this.lIa != null) {
            this.lIa.dismiss();
        }
        if (z && this.lIc) {
            this.lHW.dsA();
            this.lDS.va(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lHA > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10804").dY("obj_duration", (System.currentTimeMillis() - this.lHA) + ""));
            this.lHA = 0L;
        }
        if (dpc().dsa() != null) {
            dpc().dsa().onStop();
        }
        if (this.lHW.lPe != null && !this.lHW.lPe.dub()) {
            this.lHW.lPe.releaseResources();
        }
        if (this.lDS != null && this.lDS.getPbData() != null && this.lDS.getPbData().getForum() != null && this.lDS.getPbData().dmU() != null) {
            com.baidu.tbadk.distribute.a.bCa().b(getPageContext().getPageActivity(), "pb", this.lDS.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lDS.getPbData().dmU().getId(), 0L));
        }
        if (this.iSW != null) {
            this.iSW.onStop(getPageContext());
        }
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lHP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13266");
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("fid", this.lDS.getPbData().getForumId());
            arVar.dY("tid", this.lDS.dqk());
            arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(arVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.lHy && this.lHW != null) {
            this.lHy = true;
            a(false, (PostData) null);
        }
        if (this.lDS != null) {
            this.lDS.cancelLoadData();
            this.lDS.destory();
            if (this.lDS.dqP() != null) {
                this.lDS.dqP().onDestroy();
            }
        }
        if (this.lIi != null) {
            this.lIi.onDestroy();
        }
        if (this.fXd != null) {
            this.fXd.cancelLoadData();
        }
        if (this.fgf != null) {
            this.fgf.dOB();
        }
        if (this.lHW != null) {
            this.lHW.onDestroy();
            if (this.lHW.lPe != null) {
                this.lHW.lPe.releaseResources();
            }
        }
        if (this.lHz != null) {
            this.lHz.bFf();
        }
        if (this.lHs != null) {
            this.lHs.cEw();
        }
        super.onDestroy();
        if (this.iSW != null) {
            this.iSW.onDestory(getPageContext());
        }
        if (this.lHW != null) {
            this.lHW.dsS();
        }
        MessageManager.getInstance().unRegisterListener(this.lIP);
        MessageManager.getInstance().unRegisterListener(this.lIQ);
        MessageManager.getInstance().unRegisterListener(this.lIR);
        MessageManager.getInstance().unRegisterListener(this.lIq);
        MessageManager.getInstance().unRegisterListener(this.lIS);
        MessageManager.getInstance().unRegisterListener(this.iUK);
        MessageManager.getInstance().unRegisterListener(this.jqi);
        MessageManager.getInstance().unRegisterListener(this.lIX);
        MessageManager.getInstance().unRegisterListener(this.lII);
        this.lIo = null;
        this.lIp = null;
        com.baidu.tieba.recapp.d.a.dFY().dGb();
        if (this.lIr != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lIr);
        }
        if (this.lHI != null) {
            this.lHI.cancelLoadData();
        }
        if (this.lHW != null && this.lHW.lPe != null) {
            this.lHW.lPe.duf();
        }
        if (this.joM != null) {
            this.joM.cancelLoadData();
        }
        this.kNm.onDestroy();
        if (this.lDS != null && this.lDS.dqR() != null) {
            this.lDS.dqR().onDestroy();
        }
        if (this.kJE != null) {
            this.kJE.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dsu;
        ArrayList<PostData> doH;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bxf() && this.lHW != null && (dsu = this.lHW.dsu()) != null && (doH = dsu.doH()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = doH.iterator();
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
                        bVar.imG = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eKB == 1 && !TextUtils.isEmpty(id)) {
                    next.eKB = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.imG = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.lDS == null || this.lDS.getPbData() == null || this.lDS.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.lDS.getPbData().getForum().getFirst_class();
                    str2 = this.lDS.getPbData().getForum().getSecond_class();
                    str = this.lDS.getPbData().getForum().getId();
                    str4 = this.lDS.dqk();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.bxi());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lHW.onChangeSkinType(i);
            if (this.lIi != null && this.lIi.bCn() != null) {
                this.lIi.bCn().onChangeSkinType(i);
            }
            if (this.lHW.drX() != null) {
                this.lHW.drX().onChangeSkinType(getPageContext(), i);
            }
            this.kNm.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.CAM_X0201));
            this.mSkinType = i;
            cCF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lHW = new az(this, this.iVJ, this.fos);
        this.iXQ = new com.baidu.tieba.g.b(getActivity());
        this.iXQ.a(lJi);
        this.iXQ.a(this.irO);
        this.lHW.setOnScrollListener(this.mOnScrollListener);
        this.lHW.d(this.lJd);
        this.lHW.setListPullRefreshListener(this.gcs);
        this.lHW.uy(com.baidu.tbadk.core.k.blV().isShowImages());
        this.lHW.setOnImageClickListener(this.fNk);
        this.lHW.b(this.mOnLongClickListener);
        this.lHW.g(this.iQh);
        this.lHW.a(this.lJb);
        this.lHW.vq(this.mIsLogin);
        if (this.lHp.getIntent() != null) {
            this.lHW.vC(this.lHp.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lHW.drZ().setFromForumId(this.lDS.getFromForumId());
        this.lHW.setEditorTools(this.lIi.bCn());
        this.lIi.DT(this.lHW.dse());
        this.lHW.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lDS.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDS.getPbData().getForum().getId(), PbFragment.this.lDS.getPbData().getForum().getName(), PbFragment.this.lDS.getPbData().dmU().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lHW.vD(this.lDS.dqp());
        this.lHW.Hq(this.lDS.dqV());
        return this.lHW.getView();
    }

    public void dpe() {
        if (this.lHW != null && this.lDS != null) {
            if ((this.lDS.getPbData() != null || this.lDS.getPbData().dnu() != null) && checkUpIsLogin() && this.lHW.dsu() != null && this.lHW.dsu().doM() != null) {
                this.lHW.dsu().doM().CB(this.lDS.dqk());
            }
        }
    }

    public void dpf() {
        TiebaStatic.log("c12181");
        if (this.lHW != null && this.lDS != null) {
            if ((this.lHW == null || this.lHW.dsd()) && this.lDS.getPbData() != null && this.lDS.getPbData().dnu() != null) {
                com.baidu.tieba.pb.data.o dnu = this.lDS.getPbData().dnu();
                if (checkUpIsLogin()) {
                    if ((!dnu.dnP() || dnu.bqs() != 2) && this.lHW.dsu() != null && this.lHW.dsu().doM() != null) {
                        this.lHW.dsu().doM().CB(this.lDS.dqk());
                    }
                    if (System.currentTimeMillis() - this.lHC > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).wm(false);
                        this.lHC = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean du(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.eJk && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.blV().isShowImages()) {
                    return Qg(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.lDS == null || this.lDS.getPbData() == null) {
                        return true;
                    }
                    if (dpc().dsa() != null) {
                        dpc().dsa().doS();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.lDS.getPbData().getForum());
                    pVar.setThreadData(this.lDS.getPbData().dmU());
                    pVar.g(postData);
                    dpc().drZ().d(pVar);
                    dpc().drZ().setPostId(postData.getId());
                    a(view, postData.boP().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lIi != null) {
                        this.lHW.vw(this.lIi.bDb());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void dpg() {
        if (this.lHw == null) {
            this.lHw = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lHw.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lDO = PbFragment.this.lDO.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDO);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lDS.dqk(), PbFragment.this.lDO, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lDO = PbFragment.this.lDO.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDO);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lDS.dqk(), PbFragment.this.lDO, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lDO = PbFragment.this.lDO.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDO);
                        bVar.dismiss();
                    }
                }
            }).oW(b.a.BOTTOM_TO_TOP).oX(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.lIY.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).dwh(), "", 1);
    }

    private void aC(Bundle bundle) {
        this.lDS = this.lHp.dol();
        if (this.lDS.dqO() != null) {
            this.lDS.dqO().a(this.lGt);
        }
        if (this.lDS.dqP() != null) {
            this.lDS.dqP().b(this.lIB);
        }
        if (StringUtils.isNull(this.lDS.dqk())) {
            this.lHp.finish();
        } else if ("from_tieba_kuang".equals(this.lHF) && this.lHF != null) {
            this.lDS.Hq(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lHU = com.baidu.tbadk.baseEditMark.a.a(this.lHp);
        if (this.lHU != null) {
            this.lHU.a(this.lJa);
        }
        this.fXd = new ForumManageModel(this.lHp);
        this.fXd.setLoadDataCallBack(this.ikv);
        this.eTC = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lIM.setUniqueId(getUniqueId());
        this.lIM.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lHW.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lIq;
        userMuteCheckCustomMessage.setTag(this.lIq);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c14000").dY("tid", this.lDS.lLj).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.HE(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lHq ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    private boolean dph() {
        if (this.lDS == null || this.lDS.getPbData() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.lDS.getPbData().dmU()) || AntiHelper.a(getPageContext(), this.lDS.getPbData().getAnti());
    }

    public void dpi() {
        if (checkUpIsLogin() && this.lDS != null && this.lDS.getPbData() != null && this.lDS.getPbData().getForum() != null && !dph()) {
            if (this.lDS.getPbData().dny()) {
                this.lHW.cQY();
                return;
            }
            if (this.iXq == null) {
                this.iXq = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iXq.Bo(0);
                this.iXq.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qi(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qj(boolean z) {
                        if (z) {
                            if (PbFragment.this.lIi != null && PbFragment.this.lIi.bCn() != null) {
                                PbFragment.this.lIi.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lHW.cQY();
                        }
                    }
                });
            }
            this.iXq.G(this.lDS.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lDS.dqk(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpj() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lDS == null || (pbData = this.lDS.getPbData()) == null) {
            return null;
        }
        return pbData.dni().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmU() != null) {
            if (fVar.dmU().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dmU().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dmU().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dph() && dpk()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lHK);
                this.lHL = ((View) view.getParent()).getMeasuredHeight();
            }
            if (dpc().dsa() != null && postData != null) {
                String str3 = "";
                if (postData.dPj() != null) {
                    str3 = postData.dPj().toString();
                }
                dpc().dsa().Qb(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.boP().getName_show(), str3));
            }
            if (this.lDS.getPbData() != null && this.lDS.getPbData().dny()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.lHp.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.dpc().getListView().smoothScrollBy((PbFragment.this.lHK[1] + PbFragment.this.lHL) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dpc().dsa() != null) {
                            PbFragment.this.lIi.bCn().setVisibility(8);
                            PbFragment.this.dpc().dsa().h(str, str2, PbFragment.this.dpc().dse(), (PbFragment.this.lDS == null || PbFragment.this.lDS.getPbData() == null || PbFragment.this.lDS.getPbData().dmU() == null || !PbFragment.this.lDS.getPbData().dmU().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doW = PbFragment.this.dpc().dsa().doW();
                            if (doW != null && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                                doW.a(PbFragment.this.lDS.getPbData().getAnti());
                                doW.setThreadData(PbFragment.this.lDS.getPbData().dmU());
                            }
                            if (PbFragment.this.kNm.dtv() == null && PbFragment.this.dpc().dsa().doW().bDz() != null) {
                                PbFragment.this.dpc().dsa().doW().bDz().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kNm != null && PbFragment.this.kNm.dtu() != null) {
                                            if (!PbFragment.this.kNm.dtu().dYq()) {
                                                PbFragment.this.kNm.vF(false);
                                            }
                                            PbFragment.this.kNm.dtu().zc(false);
                                        }
                                    }
                                });
                                PbFragment.this.kNm.f(PbFragment.this.dpc().dsa().doW().bDz().getInputView());
                                PbFragment.this.dpc().dsa().doW().a(PbFragment.this.lIn);
                            }
                        }
                        PbFragment.this.dpc().dtb();
                    }
                }, 0L);
                return;
            }
            if (this.lIk == null) {
                this.lIk = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lIk.Bo(1);
                this.lIk.a(new AnonymousClass39(str, str2));
            }
            if (this.lDS != null && this.lDS.getPbData() != null && this.lDS.getPbData().getForum() != null) {
                this.lIk.G(this.lDS.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lDS.dqk(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lJs;
        final /* synthetic */ String lJt;

        AnonymousClass39(String str, String str2) {
            this.lJs = str;
            this.lJt = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qi(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qj(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        }
                        PbFragment.this.dpc().getListView().smoothScrollBy((PbFragment.this.lHK[1] + PbFragment.this.lHL) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dpc().dsa() != null) {
                            PbFragment.this.lIi.bCn().setVisibility(8);
                            PbFragment.this.dpc().dsa().h(AnonymousClass39.this.lJs, AnonymousClass39.this.lJt, PbFragment.this.dpc().dse(), (PbFragment.this.lDS == null || PbFragment.this.lDS.getPbData() == null || PbFragment.this.lDS.getPbData().dmU() == null || !PbFragment.this.lDS.getPbData().dmU().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doW = PbFragment.this.dpc().dsa().doW();
                            if (doW != null && PbFragment.this.lDS != null && PbFragment.this.lDS.getPbData() != null) {
                                doW.a(PbFragment.this.lDS.getPbData().getAnti());
                                doW.setThreadData(PbFragment.this.lDS.getPbData().dmU());
                            }
                            if (PbFragment.this.kNm.dtv() == null && PbFragment.this.dpc().dsa().doW().bDz() != null) {
                                PbFragment.this.dpc().dsa().doW().bDz().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kNm != null && PbFragment.this.kNm.dtu() != null) {
                                            if (!PbFragment.this.kNm.dtu().dYq()) {
                                                PbFragment.this.kNm.vF(false);
                                            }
                                            PbFragment.this.kNm.dtu().zc(false);
                                        }
                                    }
                                });
                                PbFragment.this.kNm.f(PbFragment.this.dpc().dsa().doW().bDz().getInputView());
                                PbFragment.this.dpc().dsa().doW().a(PbFragment.this.lIn);
                            }
                        }
                        PbFragment.this.dpc().dtb();
                    }
                }, 0L);
            }
        }
    }

    public boolean dpk() {
        if ((this.lDS.getPbData() != null && this.lDS.getPbData().dny()) || this.kJE == null || this.lDS.getPbData() == null || this.lDS.getPbData().getAnti() == null) {
            return true;
        }
        return this.kJE.pP(this.lDS.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Hd(int i) {
        if (this.kJE == null || this.lDS.getPbData() == null || this.lDS.getPbData().getAnti() == null) {
            return true;
        }
        return this.kJE.aQ(this.lDS.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lDS != null && this.lDS.getPbData() != null && postData.dPh() != 1) {
            String dqk = this.lDS.dqk();
            String id = postData.getId();
            int i = 0;
            if (this.lDS.getPbData() != null) {
                i = this.lDS.getPbData().dnj();
            }
            PbActivity.a Qh = Qh(id);
            if (Qh != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dqk, id, "pb", true, null, false, null, i, postData.duZ(), this.lDS.getPbData().getAnti(), false, postData.boP() != null ? postData.boP().getIconInfo() : null).addBigImageData(Qh.lEa, Qh.eCN, Qh.eCL, Qh.index);
                addBigImageData.setKeyPageStartFrom(this.lDS.dqV());
                addBigImageData.setFromFrsForumId(this.lDS.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lDS.getForumId());
                addBigImageData.setBjhData(this.lDS.dqu());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dpl() {
        if (this.lDS.getPbData() == null || this.lDS.getPbData().dmU() == null) {
            return -1;
        }
        return this.lDS.getPbData().dmU().bpC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dol() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dol().Qm(postWriteCallBackData.getPostId());
            this.lIv = this.lHW.dsg();
            this.lDS.dg(this.lIv, this.lHW.dsh());
        }
        this.lHW.dsS();
        this.kNm.dts();
        if (this.lIi != null) {
            this.lHW.vw(this.lIi.bDb());
        }
        this.lHW.drY();
        this.lHW.vy(true);
        this.lDS.dqG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(boolean z) {
        if (this.lDS != null && this.lDS.lEP != null && this.lDS.lEP.dmU() != null) {
            by dmU = this.lDS.lEP.dmU();
            dmU.mRecomAbTag = this.lDS.drg();
            dmU.mRecomWeight = this.lDS.dre();
            dmU.mRecomSource = this.lDS.drf();
            dmU.mRecomExtra = this.lDS.drh();
            if (dmU.getFid() == 0) {
                dmU.setFid(com.baidu.adp.lib.f.b.toLong(this.lDS.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmU, "c13563");
            TbPageTag fa = com.baidu.tbadk.pageInfo.c.fa(getContext());
            if (fa != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(fa.locatePage)) {
                a2.dY("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dY("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (fa != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(fa.locatePage)) {
                a2.dY("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dY("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.al("reply_type", 1);
                if (z) {
                    a2.al("obj_type", 2);
                } else {
                    a2.al("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c eX = com.baidu.tbadk.pageExtra.d.eX(getContext());
                if (eX != null) {
                    a2.dY("obj_cur_page", eX.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                    a2.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpm() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.SQ(this.lDS.getForumId()) && this.lDS.getPbData() != null && this.lDS.getPbData().getForum() != null) {
            if (this.lDS.getPbData().getForum().isLike() == 1) {
                this.lDS.dqR().gn(this.lDS.getForumId(), this.lDS.dqk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uO(boolean z) {
        if (this.lDS == null || this.lDS.getPbData() == null) {
            return false;
        }
        return ((this.lDS.getPbData().dnj() != 0) || this.lDS.getPbData().dmU() == null || this.lDS.getPbData().dmU().boP() == null || TextUtils.equals(this.lDS.getPbData().dmU().boP().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean uP(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ac acVar;
        if (this.lDS == null || this.lDS.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lDS.getPbData();
        if (pbData.getUserData() == null || !pbData.getUserData().isForumBusinessAccount() || com.baidu.tieba.frs.ax.isOn()) {
            by dmU = pbData.dmU();
            if (dmU != null) {
                if (dmU.bnx() || dmU.bny()) {
                    return false;
                }
                if (dmU.bqM() || dmU.bqN()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dnj() != 0) {
                    return pbData.dnj() != 3;
                }
                List<bu> dnr = pbData.dnr();
                if (com.baidu.tbadk.core.util.y.getCount(dnr) > 0) {
                    for (bu buVar : dnr) {
                        if (buVar != null && (acVar = buVar.eIt) != null && acVar.eGf && !acVar.eGg && (acVar.type == 1 || acVar.type == 2)) {
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
        return false;
    }

    private boolean uQ(boolean z) {
        if (z || this.lDS == null || this.lDS.getPbData() == null) {
            return false;
        }
        return ((this.lDS.getPbData().getForum() != null && this.lDS.getPbData().getForum().isBlockBawuDelete) || this.lDS.getPbData().dnj() == 0 || this.lDS.getPbData().dnj() == 3) ? false : true;
    }

    public void dpn() {
        com.baidu.tieba.pb.data.f pbData;
        by dmU;
        boolean z = true;
        if (this.lDS != null && this.lDS.getPbData() != null && (dmU = (pbData = this.lDS.getPbData()).dmU()) != null && dmU.boP() != null) {
            this.lHW.drY();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dmU.boP().getUserId());
            ak akVar = new ak();
            int dnj = this.lDS.getPbData().dnj();
            if (dnj == 1 || dnj == 3) {
                akVar.lNs = true;
                akVar.lNr = true;
                akVar.lNx = dmU.boK() == 1;
                akVar.lNw = dmU.boL() == 1;
            } else {
                akVar.lNs = false;
                akVar.lNr = false;
            }
            if (dnj == 1002 && !equals) {
                akVar.lNy = true;
            }
            akVar.lNp = uP(equals);
            akVar.lNt = dpo();
            akVar.lNq = uQ(equals);
            akVar.FT = this.lDS.dqm();
            akVar.lNm = true;
            akVar.lNl = uO(equals);
            akVar.lNk = equals && this.lHW.dsH();
            akVar.lNv = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.lNu = true;
            akVar.isHostOnly = this.lDS.getHostMode();
            akVar.lNo = true;
            if (dmU.bph() == null) {
                akVar.lNn = true;
            } else {
                akVar.lNn = false;
            }
            if (pbData.dny()) {
                akVar.lNm = false;
                akVar.lNo = false;
                akVar.lNn = false;
                akVar.lNr = false;
                akVar.lNs = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dny()) {
                z = false;
            }
            akVar.lNz = z;
            this.lHW.lPe.a(akVar);
        }
    }

    private boolean dpo() {
        if (this.lDS != null && this.lDS.dqm()) {
            return this.lDS.getPageData() == null || this.lDS.getPageData().bnG() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            n(postData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dpp() {
        return this.lIY;
    }

    public int dpq() {
        if (dpc() == null || dpc().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dpc().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).Wv == com.baidu.tieba.pb.data.n.lCd) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dpr() {
        if (dpc() == null || dpc().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dpc().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.nlJ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dpx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dps() {
        if (this.lDS != null && this.lDS.lEP != null && this.lDS.lEP.dmU() != null) {
            by dmU = this.lDS.lEP.dmU();
            dmU.mRecomAbTag = this.lDS.drg();
            dmU.mRecomWeight = this.lDS.dre();
            dmU.mRecomSource = this.lDS.drf();
            dmU.mRecomExtra = this.lDS.drh();
            dmU.eMG = this.lDS.dqs();
            if (dmU.getFid() == 0) {
                dmU.setFid(com.baidu.adp.lib.f.b.toLong(this.lDS.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmU, "c13562");
            TbPageTag fa = com.baidu.tbadk.pageInfo.c.fa(getContext());
            if (fa != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(fa.locatePage)) {
                a2.dY("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dY("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (fa != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(fa.locatePage)) {
                a2.dY("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dY("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.Bp(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Bq(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jl(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12528").dY("obj_id", metaData.getUserId()).al("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12528").dY("obj_id", metaData.getUserId()).al("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.eTC.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lDS.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).brv();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lHW.dsB();
        this.lDS.vc(z);
        if (this.lHU != null) {
            this.lHU.iH(z);
            if (markData != null) {
                this.lHU.a(markData);
            }
        }
        if (this.lDS.bkY()) {
            dpv();
        } else {
            this.lHW.s(this.lDS.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GT(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qe(String str) {
        if (this.lDS != null && this.lDS.getPbData() != null && this.lDS.getPbData().dny()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lDS.dqk(), str);
            by dmU = this.lDS.getPbData().dmU();
            if (dmU.bnx()) {
                format = format + "&channelid=33833";
            } else if (dmU.bqL()) {
                format = format + "&channelid=33842";
            } else if (dmU.bny()) {
                format = format + "&channelid=33840";
            }
            Qf(format);
            return;
        }
        this.lHT.QF(str);
    }

    private void Qf(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.lDS.dqs()) {
                    antiData.setBlock_forum_name(this.lDS.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lDS.getPbData().getForum().getId());
                    antiData.setUser_name(this.lDS.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lDS.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (dpc() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
                } else {
                    com.baidu.tieba.tbadkCore.writeModel.c.h(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bP(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            Ea(str);
        } else {
            this.lHW.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.noK) ? bVar.noK : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Bq(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jl(true);
                aVar.b(getPageContext());
                aVar.brv();
            } else {
                this.lHW.a(0, bVar.mSuccess, bVar.noK, z);
            }
            if (bVar.mSuccess) {
                if (bVar.izQ == 1) {
                    ArrayList<PostData> dmW = this.lDS.getPbData().dmW();
                    int size = dmW.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dmW.get(i).getId())) {
                            i++;
                        } else {
                            dmW.remove(i);
                            break;
                        }
                    }
                    this.lDS.getPbData().dmU().oD(this.lDS.getPbData().dmU().boG() - 1);
                    this.lHW.s(this.lDS.getPbData());
                } else if (bVar.izQ == 0) {
                    dpt();
                } else if (bVar.izQ == 2) {
                    ArrayList<PostData> dmW2 = this.lDS.getPbData().dmW();
                    int size2 = dmW2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dmW2.get(i2).dPe().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dmW2.get(i2).dPe().get(i3).getId())) {
                                i3++;
                            } else {
                                dmW2.get(i2).dPe().remove(i3);
                                dmW2.get(i2).dPg();
                                z2 = true;
                                break;
                            }
                        }
                        dmW2.get(i2).TG(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lHW.s(this.lDS.getPbData());
                    }
                    a(bVar, this.lHW);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.lHW.a(this.fXd.getLoadDataMode(), gVar.mSuccess, gVar.noK, false);
            if (gVar.mSuccess) {
                this.lHX = true;
                if (i == 2 || i == 3) {
                    this.lHY = true;
                    this.lHZ = false;
                } else if (i == 4 || i == 5) {
                    this.lHY = false;
                    this.lHZ = true;
                }
                if (i == 2) {
                    this.lDS.getPbData().dmU().oG(1);
                    this.lDS.setIsGood(1);
                } else if (i == 3) {
                    this.lDS.getPbData().dmU().oG(0);
                    this.lDS.setIsGood(0);
                } else if (i == 4) {
                    this.lDS.getPbData().dmU().oF(1);
                    this.lDS.Hi(1);
                } else if (i == 5) {
                    this.lDS.getPbData().dmU().oF(0);
                    this.lDS.Hi(0);
                }
                this.lHW.c(this.lDS.getPbData(), this.lDS.dqm());
            }
        }
    }

    private void dpt() {
        if (this.lDS.dqn() || this.lDS.dqp()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lDS.dqk());
            PbActivity pbActivity = this.lHp;
            PbActivity pbActivity2 = this.lHp;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lDS.dqk()));
        if (dpw()) {
            this.lHp.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doy() {
        this.lHp.doy();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dng;
        boolean z = false;
        if (this.lHW != null) {
            this.lHW.dsS();
        }
        if (this.lDS != null && this.lDS.getPbData() != null && !this.lDS.getPbData().dny()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lDS.getPbData().dmU().getId();
            if (this.lDS.isShareThread() && this.lDS.getPbData().dmU().eLH != null) {
                historyMessage.threadName = this.lDS.getPbData().dmU().eLH.showText;
            } else {
                historyMessage.threadName = this.lDS.getPbData().dmU().getTitle();
            }
            if (this.lDS.isShareThread() && !dod()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lDS.getPbData().getForum().getName();
            }
            ArrayList<PostData> dmW = this.lDS.getPbData().dmW();
            int dsD = this.lHW != null ? this.lHW.dsD() : 0;
            if (dmW != null && dsD >= 0 && dsD < dmW.size()) {
                historyMessage.postID = dmW.get(dsD).getId();
            }
            historyMessage.isHostOnly = this.lDS.getHostMode();
            historyMessage.isSquence = this.lDS.dqm();
            historyMessage.isShareThread = this.lDS.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lIi != null) {
            this.lIi.onDestroy();
        }
        if (this.lHu && dpc() != null) {
            dpc().dtl();
        }
        if (this.lDS != null && (this.lDS.dqn() || this.lDS.dqp())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lDS.dqk());
            if (this.lHX) {
                if (this.lHZ) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lDS.cuU());
                }
                if (this.lHY) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lDS.getIsGood());
                }
            }
            if (this.lDS.getPbData() != null && System.currentTimeMillis() - this.lHx >= 40000 && (dng = this.lDS.getPbData().dng()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dng.getDataList())) {
                intent.putExtra("guess_like_data", dng);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lIw);
            }
            PbActivity pbActivity = this.lHp;
            PbActivity pbActivity2 = this.lHp;
            pbActivity.setResult(-1, intent);
        }
        if (dpw()) {
            if (this.lDS != null && this.lHW != null && this.lHW.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lDS.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dnc() && !this.lHD && pbData.lAN == null) {
                        as drJ = as.drJ();
                        com.baidu.tieba.pb.data.f dqv = this.lDS.dqv();
                        Parcelable onSaveInstanceState = this.lHW.getListView().onSaveInstanceState();
                        boolean dqm = this.lDS.dqm();
                        boolean hostMode = this.lDS.getHostMode();
                        if (this.lHW.dsl() != null && this.lHW.dsl().getVisibility() == 0) {
                            z = true;
                        }
                        drJ.a(dqv, onSaveInstanceState, dqm, hostMode, z);
                        if (this.lIv >= 0 || this.lDS.dqX() != null) {
                            as.drJ().q(this.lDS.dqX());
                            as.drJ().p(this.lDS.dqY());
                            as.drJ().Hs(this.lDS.dqZ());
                        }
                    }
                }
            } else {
                as.drJ().reset();
            }
            doy();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lHW == null || !this.lHW.Hy(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean He(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lHp;
        if (i == 0) {
            this.lHW.drY();
            this.lHW.dsa().doS();
            this.lHW.vy(false);
        }
        this.lHW.dsc();
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
                        this.lIi.resetData();
                        this.lIi.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lIi.b(writeData);
                        com.baidu.tbadk.editortools.m sj = this.lIi.bCn().sj(6);
                        if (sj != null && sj.fub != null) {
                            sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lHp;
                        if (i == -1) {
                            this.lIi.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lHW.dsa() != null && this.lHW.dsa().doW() != null) {
                            com.baidu.tbadk.editortools.pb.h doW = this.lHW.dsa().doW();
                            doW.setThreadData(this.lDS.getPbData().dmU());
                            doW.b(writeData);
                            doW.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m sj2 = doW.bCn().sj(6);
                            if (sj2 != null && sj2.fub != null) {
                                sj2.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lHp;
                            if (i == -1) {
                                doW.bDr();
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

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lIi.onActivityResult(i, i2, intent);
        if (this.lHI != null) {
            this.lHI.onActivityResult(i, i2, intent);
        }
        if (dpc().dsa() != null) {
            dpc().dsa().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dpu();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.drJ().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lDS != null) {
                                PbFragment.this.lDS.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.p.a.dEL().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lDS != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    S(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (intent != null) {
                        arVar.dY("tid", intent.getStringExtra("tid"));
                        arVar.dY("post_id", intent.getStringExtra("pid"));
                        arVar.al("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(arVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.p.a.dEL().F(getPageContext());
                        dpm();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.joM != null && shareItem != null && shareItem.linkUrl != null) {
                            this.joM.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bzM() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbFragment.this.getPageContext(), customDialogData).show();
                                        }
                                    }, 1000L);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                    this.lHW.uD(false);
                    if (this.lDS.getPbData() != null && this.lDS.getPbData().dmU() != null && this.lDS.getPbData().dmU().bpk() != null) {
                        this.lDS.getPbData().dmU().bpk().setStatus(2);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SELECT_LIKE_FORUM /* 25012 */:
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                    return;
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lIl = emotionImageData;
                        if (Hd(com.baidu.tbadk.core.util.am.eTz)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lHJ != null) {
                        this.lHW.dE(this.lHJ);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.lHI == null) {
                this.lHI = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lHp);
                this.lHI.b(this.fwB);
                this.lHI.c(this.fwI);
            }
            this.lHI.a(emotionImageData, dol(), dol().getPbData());
        }
    }

    private void S(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpu() {
        MarkData Hp;
        if (this.lHU != null) {
            if (this.lDS.getPbData() != null && this.lDS.getPbData().dny()) {
                Hp = this.lDS.Hp(0);
            } else {
                Hp = this.lDS.Hp(this.lHW.dsE());
            }
            if (Hp != null) {
                if (!Hp.isApp() || (Hp = this.lDS.Hp(this.lHW.dsE() + 1)) != null) {
                    this.lHW.dsz();
                    this.lHU.a(Hp);
                    if (!this.lHU.bkY()) {
                        this.lHU.bla();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lHU.bkZ();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpv() {
        com.baidu.tieba.pb.data.f pbData = this.lDS.getPbData();
        this.lDS.vc(true);
        if (this.lHU != null) {
            pbData.PV(this.lHU.bkX());
        }
        this.lHW.s(pbData);
    }

    private boolean dpw() {
        if (this.lDS == null) {
            return true;
        }
        if (this.lDS.getPbData() == null || !this.lDS.getPbData().dny()) {
            if (this.lDS.bkY()) {
                final MarkData dqF = this.lDS.dqF();
                if (dqF == null || !this.lDS.getIsFromMark()) {
                    return true;
                }
                final MarkData Hp = this.lDS.Hp(this.lHW.dsD());
                if (Hp == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dqF);
                    this.lHp.setResult(-1, intent);
                    return true;
                } else if (Hp.getPostId() == null || Hp.getPostId().equals(dqF.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dqF);
                    this.lHp.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.Bq(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lHU != null) {
                                if (PbFragment.this.lHU.bkY()) {
                                    PbFragment.this.lHU.bkZ();
                                    PbFragment.this.lHU.iH(false);
                                }
                                PbFragment.this.lHU.a(Hp);
                                PbFragment.this.lHU.iH(true);
                                PbFragment.this.lHU.bla();
                            }
                            dqF.setPostId(Hp.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqF);
                            PbFragment.this.lHp.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.doy();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqF);
                            PbFragment.this.lHp.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.doy();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lHW != null && PbFragment.this.lHW.getView() != null) {
                                PbFragment.this.lHW.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dqF);
                                PbFragment.this.lHp.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.doy();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.brv();
                    return false;
                }
            } else if (this.lDS.getPbData() == null || this.lDS.getPbData().dmW() == null || this.lDS.getPbData().dmW().size() <= 0 || !this.lDS.getIsFromMark()) {
                return true;
            } else {
                this.lHp.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.lHW == null) {
            return null;
        }
        return this.lHW.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bJm() {
        if (this.lHW == null) {
            return 0;
        }
        return this.lHW.dsQ();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bJn() {
        if (this.fMZ == null) {
            this.fMZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJz */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.blV().isShowImages();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ap.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.blV().isShowImages()) {
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
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
        return this.fMZ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bJo() {
        if (this.fQq == null) {
            this.fQq = TbRichTextView.J(getPageContext().getPageActivity(), 8);
        }
        return this.fQq;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bJp() {
        if (this.fNa == null) {
            this.fNa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cwL */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.blV().isShowImages();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.ap.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
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
                @Override // com.baidu.adp.lib.d.c
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (com.baidu.tbadk.core.k.blV().isShowImages()) {
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.bDT();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fNa;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bJq() {
        if (this.fQr == null) {
            this.fQr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpU */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dz */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dA */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).ccA();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dB */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fQr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bJs() {
        this.fQt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dpV */
            public RelativeLayout makeObject() {
                return new RelativeLayout(PbFragment.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.fQt;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bvR() {
        if (this.few == null) {
            this.few = UserIconBox.D(getPageContext().getPageActivity(), 8);
        }
        return this.few;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lHB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (be.Qw(str) && this.lDS != null && this.lDS.dqk() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").al("obj_param1", 1).dY("post_id", this.lDS.dqk()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fsY = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            be.dtx().f(getPageContext(), str);
        }
        this.lHB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
        be.dtx().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lHB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void az(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.lHW != null && this.lHW.dtg() != null && rect.top <= this.lHW.dtg().getHeight()) {
            rect.top += this.lHW.dtg().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lDS.getPbData();
            TbRichText bz = bz(str, i);
            if (bz != null && (tbRichTextData = bz.bIC().get(this.lJe)) != null) {
                aVar.postId = String.valueOf(bz.getPostId());
                aVar.lEa = new ArrayList<>();
                aVar.eCN = new ConcurrentHashMap<>();
                if (!tbRichTextData.bII().bIV()) {
                    aVar.lEb = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lEa.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bz.getPostId();
                    imageUrlData.mIsReserver = this.lDS.dqD();
                    imageUrlData.mIsSeeHost = this.lDS.getHostMode();
                    aVar.eCN.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dmU() != null) {
                            aVar.threadId = pbData.dmU().getId();
                        }
                        aVar.eCL = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lEb = true;
                int size = pbData.dmW().size();
                this.lJf = false;
                aVar.index = -1;
                int a2 = pbData.dnd() != null ? a(pbData.dnd().dPj(), bz, i, i, aVar.lEa, aVar.eCN) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dmW().get(i2);
                    if (postData.getId() == null || pbData.dnd() == null || pbData.dnd().getId() == null || !postData.getId().equals(pbData.dnd().getId())) {
                        a2 = a(postData.dPj(), bz, a2, i, aVar.lEa, aVar.eCN);
                    }
                }
                if (aVar.lEa.size() > 0) {
                    aVar.lastId = aVar.lEa.get(aVar.lEa.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dmU() != null) {
                        aVar.threadId = pbData.dmU().getId();
                    }
                    aVar.eCL = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bII() == null) {
            return null;
        }
        return tbRichTextData.bII().bJa();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bII() == null) {
            return 0L;
        }
        return tbRichTextData.bII().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bII() == null) {
            return false;
        }
        return tbRichTextData.bII().bJb();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bII() == null) {
            return false;
        }
        return tbRichTextData.bII().bJc();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bII;
        String str;
        if (tbRichText == tbRichText2) {
            this.lJf = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bIC().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bIC().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bII().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bII().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bII().bIV()) {
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
                            if (tbRichTextData != null && (bII = tbRichTextData.bII()) != null) {
                                String bIX = bII.bIX();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bII.bIY();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bIX;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lDS.dqk(), -1L);
                                imageUrlData.mIsReserver = this.lDS.dqD();
                                imageUrlData.mIsSeeHost = this.lDS.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lJf) {
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

    protected void n(PostData postData) {
        PostData dnd;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lDS.boX())) {
                z = true;
            }
            MarkData o = this.lDS.o(postData);
            if (this.lDS.getPbData() != null && this.lDS.getPbData().dny() && (dnd = dnd()) != null) {
                o = this.lDS.o(dnd);
            }
            if (o != null) {
                this.lHW.dsz();
                if (this.lHU != null) {
                    this.lHU.a(o);
                    if (!z) {
                        this.lHU.bla();
                    } else {
                        this.lHU.bkZ();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dx(View view) {
        boolean z;
        boolean z2;
        List<com.baidu.tbadk.core.dialog.g> list;
        com.baidu.tbadk.core.dialog.g gVar;
        SparseArray sparseArray;
        if (!isAdded()) {
            return true;
        }
        if (this.lHW != null) {
            if (this.lHW.dqc()) {
                return true;
            }
            this.lHW.dto();
        }
        SparseArray sparseArray2 = null;
        try {
            sparseArray2 = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        if (sparseArray2 == null) {
            if (dy(view)) {
                if (view instanceof TbImageView) {
                    this.lIs = ((TbImageView) view).getBdImage();
                    this.lIt = ((TbImageView) view).getUrl();
                    if (this.lIs == null || TextUtils.isEmpty(this.lIt)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lIu = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lIu = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lIs = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lIt = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lIu = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lIu = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lIs = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lIt = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lIu = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lIu = null;
                    }
                }
                if (view.getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                    } catch (ClassCastException e2) {
                        e2.printStackTrace();
                        sparseArray = sparseArray2;
                    }
                } else if (view.getParent().getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                    } catch (ClassCastException e3) {
                        e3.printStackTrace();
                        sparseArray = sparseArray2;
                    }
                } else {
                    this.lHW.a(this.lJh, this.lIs.isGif());
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
        this.jZf = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.jZf == null) {
            return true;
        }
        if (this.jZf.dPh() == 1 && dy(view)) {
            this.lHW.a(this.lJh, this.lIs.isGif());
            return true;
        } else if (this.lHU == null) {
            return true;
        } else {
            if (!this.lHU.bkY() || this.jZf.getId() == null || !this.jZf.getId().equals(this.lDS.boX())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = dol().getPbData() != null && dol().getPbData().dny();
            if (this.jZf.dPh() == 1) {
                if (!z3) {
                    this.lHW.a(this.lJg, z, false);
                }
                return true;
            }
            if (this.lIb == null) {
                this.lIb = new com.baidu.tbadk.core.dialog.k(getContext());
                this.lIb.a(this.lIT);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = dy(view) && !z3;
                boolean z5 = (!dy(view) || this.lIs == null || this.lIs.isGif()) ? false : true;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                String str = null;
                if (!(sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean)) {
                    z2 = false;
                } else {
                    z2 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z7 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z8 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z10 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
                }
                if (z4) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.save_to_emotion), this.lIb));
                }
                if (z5) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.save_to_local), this.lIb));
                }
                if (!z4 && !z5) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, getString(R.string.copy), this.lIb);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.jZf);
                    gVar2.eNK.setTag(sparseArray3);
                    arrayList.add(gVar2);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.remove_mark), this.lIb);
                    } else {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.mark), this.lIb);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.jZf);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar.eNK.setTag(sparseArray4);
                    arrayList.add(gVar);
                }
                if (this.mIsLogin && !this.lHR) {
                    if (!z8 && z7) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.mute_option), this.lIb);
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
                        gVar3.eNK.setTag(sparseArray5);
                        arrayList.add(gVar3);
                    } else {
                        if ((uO(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.report_text), this.lIb);
                            gVar4.eNK.setTag(str);
                            arrayList.add(gVar4);
                        }
                    }
                    com.baidu.tbadk.core.dialog.g gVar5 = null;
                    com.baidu.tbadk.core.dialog.g gVar6 = null;
                    if (z8) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.tag_should_manage_visible, true);
                        sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                        sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                        sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                        sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                        if (z9) {
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
                        if (z10) {
                            sparseArray6.put(R.id.tag_should_delete_visible, true);
                            sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                            sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                            sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lIb);
                            gVar6.eNK.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar5 = new com.baidu.tbadk.core.dialog.g(7, getString(R.string.bar_manager), this.lIb);
                        gVar5.eNK.setTag(sparseArray6);
                    } else if (z10) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.tag_should_manage_visible, false);
                        sparseArray7.put(R.id.tag_user_mute_visible, false);
                        sparseArray7.put(R.id.tag_should_delete_visible, true);
                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        if (this.lDS.getPbData().dnj() == 1002 && !z6) {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.report_text), this.lIb);
                        } else {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lIb);
                        }
                        gVar6.eNK.setTag(sparseArray7);
                    }
                    if (gVar6 != null) {
                        arrayList.add(gVar6);
                    }
                    if (gVar5 != null) {
                        arrayList.add(gVar5);
                    }
                }
                if (com.baidu.tbadk.a.d.bkG()) {
                    list = com.baidu.tieba.pb.pb.main.d.a.fs(com.baidu.tieba.pb.pb.main.d.a.v(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.jZf.bqI(), sparseArray2, this.lIb), this.lHq));
                    this.lIb.a(com.baidu.tieba.pb.pb.main.d.a.t(this.jZf));
                } else {
                    list = arrayList;
                }
                this.lIb.k(list, true);
                this.lIa = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.lIb);
                this.lIa.RU();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13272").dY("tid", this.lDS.lLj).dY("fid", this.lDS.getForumId()).dY("uid", this.lDS.getPbData().dmU().boP().getUserId()).dY("post_id", this.lDS.bCP()).al("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            a(postData, false);
        }
    }

    public boolean dy(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bz(String str, int i) {
        TbRichText tbRichText = null;
        if (this.lDS == null || this.lDS.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lDS.getPbData();
        if (pbData.dnd() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dnd());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dmW = pbData.dmW();
            c(pbData, dmW);
            return c(dmW, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AgreeData agreeData) {
        com.baidu.tbadk.pageExtra.c eX;
        int i = 1;
        if (agreeData != null) {
            if (this.eXx == null) {
                this.eXx = new com.baidu.tbadk.core.message.a();
            }
            if (this.eXh == null) {
                this.eXh = new com.baidu.tieba.tbadkCore.data.e();
                this.eXh.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eEJ = 5;
            dVar.eEP = 8;
            dVar.eEO = 2;
            if (dol() != null) {
                dVar.eEN = dol().dqV();
            }
            dVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eEQ = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eEQ = 1;
                        i = 0;
                    }
                }
                eX = com.baidu.tbadk.pageExtra.d.eX(getContext());
                if (eX != null) {
                    agreeData.objSource = eX.getCurrentPageKey();
                }
                this.eXx.a(agreeData, i, getUniqueId(), false);
                this.eXx.a(agreeData, this.eXh);
                if (this.lDS == null && this.lDS.getPbData() != null) {
                    this.eXx.a(dpR(), dVar, agreeData, this.lDS.getPbData().dmU());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eEQ = 1;
            }
            i = 0;
            eX = com.baidu.tbadk.pageExtra.d.eX(getContext());
            if (eX != null) {
            }
            this.eXx.a(agreeData, i, getUniqueId(), false);
            this.eXx.a(agreeData, this.eXh);
            if (this.lDS == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dni() != null && fVar.dni().lCs != null && (list = fVar.dni().lCs) != null && arrayList != null) {
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

    private TbRichText c(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> bIC;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dPj = arrayList.get(i2).dPj();
            if (dPj != null && (bIC = dPj.bIC()) != null) {
                int size = bIC.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bIC.get(i4) != null && bIC.get(i4).getType() == 8) {
                        i3++;
                        if (bIC.get(i4).bII().bIX().equals(str) || bIC.get(i4).bII().bIY().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bIC.get(i4).bII().getWidth() * equipmentDensity;
                            int height = bIC.get(i4).bII().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lJe = i4;
                            return dPj;
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

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.lDO = str;
            if (this.lHw == null) {
                dpg();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lHw.getItemView(1).setVisibility(8);
            } else {
                this.lHw.getItemView(1).setVisibility(0);
            }
            this.lHw.brx();
            this.lHB = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iSW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpx() {
        hideNetRefreshView(this.lHW.getView());
        dpy();
        if (this.lDS.dqy()) {
            this.lHW.dsz();
        }
        this.lHW.dsK();
    }

    private void dpy() {
        showLoadingView(this.lHW.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lHW.dtg().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCF() {
        if (this.iSW != null) {
            this.iSW.stopPlay();
        }
        if (this.lHp != null) {
            this.lHp.cCF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf(int i) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, dpl(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bJr() {
        if (this.fQs == null) {
            this.fQs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpW */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(PbFragment.this.getPageContext().getPageActivity());
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
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.fQs;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void cCG() {
        if (this.lHp != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.lHp.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lHp.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cBf() {
        if (this.lDS == null || this.lDS.getPbData() == null) {
            return null;
        }
        return this.lDS.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.lQs)).intValue();
            if (intValue == az.lQt) {
                if (!this.fXd.dQc()) {
                    this.lHW.dsw();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.fXd.TT(com.baidu.tbadk.core.util.au.S(jSONArray));
                    }
                    this.fXd.a(this.lDS.getPbData().getForum().getId(), this.lDS.getPbData().getForum().getName(), this.lDS.getPbData().dmU().getId(), str, intValue3, intValue2, booleanValue, this.lDS.getPbData().dmU().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.lQu || intValue == az.lQw) {
                if (this.lDS.dqO() != null) {
                    this.lDS.dqO().GY(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.lQu) {
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
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lIq);
        userMuteAddAndDelCustomMessage.setTag(this.lIq);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Qg(String str) {
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0840a
    public void uR(boolean z) {
        this.lIc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpz() {
        ArrayList<PostData> dmW;
        int count;
        if (this.lDS == null || this.lDS.getPbData() == null || this.lDS.getPbData().dmW() == null || (count = com.baidu.tbadk.core.util.y.getCount((dmW = this.lDS.getPbData().dmW()))) == 0) {
            return "";
        }
        if (this.lDS.dqD()) {
            Iterator<PostData> it = dmW.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dPh() == 1) {
                    return next.getId();
                }
            }
        }
        int dsD = this.lHW.dsD();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dmW, dsD);
        if (postData == null || postData.boP() == null) {
            return "";
        }
        if (this.lDS.Qk(postData.boP().getUserId())) {
            return postData.getId();
        }
        for (int i = dsD - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dmW, i);
            if (postData2 == null || postData2.boP() == null || postData2.boP().getUserId() == null) {
                break;
            } else if (this.lDS.Qk(postData2.boP().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dsD + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dmW, i2);
            if (postData3 == null || postData3.boP() == null || postData3.boP().getUserId() == null) {
                return "";
            }
            if (this.lDS.Qk(postData3.boP().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aB(Context context, String str) {
        this.lHB = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Qh(String str) {
        String str2;
        if (this.lDS.getPbData() == null || this.lDS.getPbData().dmW() == null || this.lDS.getPbData().dmW().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lDS.getPbData().dmW().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lDS.getPbData().dmW().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lDS.getPbData().dmW().get(i);
        if (postData.dPj() == null || postData.dPj().bIC() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dPj().bIC().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bII() != null) {
                    str2 = next.bII().bIX();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dpA() {
        return (!this.lHr && this.lJj == -1 && this.lJk == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null) {
            this.lJm = sVar;
            this.lHr = true;
            this.lHW.dsm();
            this.lHW.Qu(this.lJl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpB() {
        if (this.lJm != null) {
            if (this.lJj == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lJm.getCartoonId(), this.lJj, 0)));
                this.lHp.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpC() {
        if (this.lJm != null) {
            if (this.lJk == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lJm.getCartoonId(), this.lJk, 0)));
                this.lHp.finish();
            }
        }
    }

    public int dpD() {
        return this.lJj;
    }

    public int dpE() {
        return this.lJk;
    }

    private void cRx() {
        if (this.lDS != null && this.lDS.getPbData() != null && this.lDS.getPbData().dmU() != null && this.lDS.getPbData().dmU().bnv()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dpF() {
        if (this.lDS != null && this.lDS.getPbData() != null && this.lDS.getPbData().dmU() != null && this.lDS.getPbData().dmU().bnv()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dpG() {
        if (this.bIA) {
            this.lHH = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lDS.getPbData() != null && this.lDS.getPbData().dmU() != null && this.lDS.getPbData().dmU().bov() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lDS.getPbData().dmU().bov().getThreadId(), this.lDS.getPbData().dmU().bov().getTaskId(), this.lDS.getPbData().dmU().bov().getForumId(), this.lDS.getPbData().dmU().bov().getForumName(), this.lDS.getPbData().dmU().boK(), this.lDS.getPbData().dmU().boL())));
            this.lHt = true;
            this.lHp.finish();
        }
    }

    public String dpH() {
        return this.lHF;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dpI() {
        return this.lHS;
    }

    public void uS(boolean z) {
        this.lHG = z;
    }

    public boolean bmu() {
        if (this.lDS != null) {
            return this.lDS.dqn();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Bq(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lIo).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lIo.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lIo).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lIo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIo.getPageActivity());
            aVar.Bq(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lIo).brv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lHW.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIo.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.Bq(this.lIo.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bq(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lHW.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.84
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lIo).brv();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.Qw(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.d(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.jzy) {
            this.jzy = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.lHW != null) {
                this.lHW.onConfigurationChanged(configuration);
            }
            if (this.lIa != null) {
                this.lIa.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dpK() {
        if (this.lDS != null) {
            return this.lDS.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.lDS.getPbData().dni().lCs;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dPe().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dPe().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dPe().remove(i2);
                    list.get(i).dPg();
                    z = true;
                    break;
                }
            }
            list.get(i).TG(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.lDS.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.dnN().getId();
        List<PostData> list = this.lDS.getPbData().dni().lCs;
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
                ArrayList<PostData> dnV = pVar.dnV();
                postData.KU(pVar.getTotalCount());
                if (postData.dPe() != null) {
                    postData.dPe().clear();
                    postData.dPe().addAll(dnV);
                }
            }
        }
        if (!this.lDS.getIsFromMark()) {
            this.lHW.s(this.lDS.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a doc() {
        return this.lHp.doc();
    }

    public boolean dod() {
        if (this.lDS == null) {
            return false;
        }
        return this.lDS.dod();
    }

    public void uT(boolean z) {
        this.lHE = z;
    }

    public boolean dpL() {
        return this.lHE;
    }

    public void dpM() {
        if (this.lHW != null) {
            this.lHW.drY();
            cCG();
        }
    }

    public PostData dnd() {
        return this.lHW.b(this.lDS.lEP, this.lDS.dqm());
    }

    public void onBackPressed() {
        if (this.lIx != null && !this.lIx.isEmpty()) {
            int size = this.lIx.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lIx.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lIx == null) {
                this.lIx = new ArrayList();
            }
            if (!this.lIx.contains(aVar)) {
                this.lIx.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lIx == null) {
                this.lIx = new ArrayList();
            }
            if (!this.lIx.contains(aVar)) {
                this.lIx.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lIx != null) {
            this.lIx.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpN() {
        if (this.lDS != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lDS.dqk())) {
            com.baidu.tbadk.BdToken.c.biD().p(com.baidu.tbadk.BdToken.b.evv, com.baidu.adp.lib.f.b.toLong(this.lDS.dqk(), 0L));
        }
    }

    public bh dpO() {
        return this.lHO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi(String str) {
        if (this.lDS != null && this.lDS.getPbData() != null && this.lDS.getPbData().dmU() != null && this.lDS.getPbData().dmU().bnz()) {
            by dmU = this.lDS.getPbData().dmU();
            int i = 0;
            if (dmU.bnx()) {
                i = 1;
            } else if (dmU.bny()) {
                i = 2;
            } else if (dmU.bqM()) {
                i = 3;
            } else if (dmU.bqN()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(str);
            arVar.al("obj_source", 4);
            arVar.al("obj_type", i);
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg(final int i) {
        com.baidu.tbadk.util.ad.a(new com.baidu.tbadk.util.ac<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: blQ */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(PbFragment.this.getContext(), PbFragment.this.dpl(), i2, PbFragment.this.lDS);
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.86
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.ae(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), i, shareItem, false));
            }
        });
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13833");
        arVar.al("obj_locate", 1);
        if (i == 3) {
            arVar.al("obj_type", 1);
        } else if (i == 8) {
            arVar.al("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dpP() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dpQ() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dpR() {
        return this.lHp;
    }
}
