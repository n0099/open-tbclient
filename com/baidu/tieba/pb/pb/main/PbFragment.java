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
    private VoiceManager iSU;
    private com.baidu.tieba.g.b iXO;
    private com.baidu.tieba.frs.profession.permission.c iXo;
    private com.baidu.tieba.callfans.a iko;
    public com.baidu.tbadk.core.util.am kJC;
    public bb kNk;
    private String lDM;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lHG;
    private View lHH;
    int lHJ;
    private bh lHM;
    private com.baidu.tieba.pb.pb.report.a lHR;
    private com.baidu.tbadk.core.dialog.i lHY;
    private com.baidu.tbadk.core.dialog.k lHZ;
    private PbActivity lHn;
    private com.baidu.tieba.pb.pb.main.b.b lHq;
    private boolean lIa;
    private com.baidu.tieba.tbadkCore.data.f lIe;
    private com.baidu.tbadk.editortools.pb.g lIf;
    private com.baidu.tbadk.editortools.pb.e lIg;
    private com.baidu.tieba.frs.profession.permission.c lIi;
    private EmotionImageData lIj;
    private com.baidu.adp.base.e lIm;
    private com.baidu.tbadk.core.view.c lIn;
    private BdUniqueId lIo;
    private Runnable lIp;
    private com.baidu.adp.widget.ImageView.a lIq;
    private String lIr;
    private TbRichTextMemeInfo lIs;
    private List<a> lIv;
    public String lIx;
    private boolean lJa;
    private String lJj;
    private com.baidu.tbadk.core.data.s lJk;
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
    private static final b.a lJg = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.g.b.a
        public void cW(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.doa();
            } else {
                com.baidu.tieba.pb.a.b.dnZ();
            }
        }
    };
    boolean lHo = true;
    private boolean lHp = false;
    private boolean lHr = false;
    private boolean bIA = false;
    private boolean lcU = false;
    private boolean lHs = true;
    private int lHt = 0;
    private com.baidu.tbadk.core.dialog.b lHu = null;
    private long ivy = -1;
    private long fCl = 0;
    private long lHv = 0;
    private long createTime = 0;
    private long fCb = 0;
    private boolean lHw = false;
    private com.baidu.tbadk.n.b lHx = null;
    private long lHy = 0;
    private boolean lHz = false;
    private long lHA = 0;
    private int jzw = 1;
    private String fwy = null;
    private boolean lHB = false;
    private boolean isFullScreen = false;
    private boolean lHC = false;
    private String lHD = "";
    private boolean lHE = true;
    private boolean lHF = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lHI = new int[2];
    private int lHK = -1;
    private int lHL = -1;
    public BdUniqueId lHN = BdUniqueId.gen();
    private boolean lHO = false;
    private boolean lHP = com.baidu.tbadk.a.d.bkr();
    private PbInterviewStatusView.a lHQ = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lHU.vr(!PbFragment.this.lHE);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.bkY()) {
                        PbFragment.this.dpu();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lDQ = null;
    private com.baidu.tbadk.baseEditMark.a lHS = null;
    private ForumManageModel fXb = null;
    private com.baidu.tbadk.coreExtra.model.a eTC = null;
    private com.baidu.tieba.pb.data.q lHT = null;
    private ShareSuccessReplyToServerModel joK = null;
    private az lHU = null;
    private boolean lHV = false;
    private boolean lHW = false;
    private boolean lHX = false;
    private boolean geI = false;
    private boolean lIb = false;
    private boolean lIc = false;
    private boolean lId = false;
    private boolean lIh = false;
    public boolean lIk = false;
    private com.baidu.tbadk.editortools.pb.c fwB = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bCS() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fwC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bCR() {
            if (PbFragment.this.kNk == null || PbFragment.this.kNk.dts() == null || !PbFragment.this.kNk.dts().dYo()) {
                return !PbFragment.this.Hd(com.baidu.tbadk.core.util.am.eTx);
            }
            PbFragment.this.showToast(PbFragment.this.kNk.dts().dYq());
            if (PbFragment.this.lIg != null && (PbFragment.this.lIg.bDi() || PbFragment.this.lIg.bDj())) {
                PbFragment.this.lIg.a(false, PbFragment.this.kNk.dtv());
            }
            PbFragment.this.kNk.vE(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lIl = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bCR() {
            if (PbFragment.this.kNk == null || PbFragment.this.kNk.dtt() == null || !PbFragment.this.kNk.dtt().dYo()) {
                return !PbFragment.this.Hd(com.baidu.tbadk.core.util.am.eTy);
            }
            PbFragment.this.showToast(PbFragment.this.kNk.dtt().dYq());
            if (PbFragment.this.lHU != null && PbFragment.this.lHU.drZ() != null && PbFragment.this.lHU.drZ().doV() != null && PbFragment.this.lHU.drZ().doV().bDj()) {
                PbFragment.this.lHU.drZ().doV().a(PbFragment.this.kNk.dtv());
            }
            PbFragment.this.kNk.vF(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean iTI = false;
    private int lIt = 0;
    private int lIu = -1;
    public int lIw = 0;
    private final a lIy = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lHU != null && PbFragment.this.lHU.drZ() != null) {
                v drZ = PbFragment.this.lHU.drZ();
                if (drZ.doT()) {
                    drZ.doS();
                    return true;
                }
            }
            if (PbFragment.this.lHU != null && PbFragment.this.lHU.dsY()) {
                PbFragment.this.lHU.dsZ();
                return true;
            }
            return false;
        }
    };
    private final ai.a lIz = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void ah(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void p(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lHU.showToast(str);
            }
        }
    };
    private final CustomMessageListener lIA = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lDQ != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lIg != null) {
                    PbFragment.this.lHU.vw(PbFragment.this.lIg.bDb());
                }
                PbFragment.this.lHU.dsb();
                PbFragment.this.lHU.dsR();
            }
        }
    };
    CustomMessageListener iUA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                PbFragment.this.lDQ.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                if (PbFragment.this.lHU != null && PbFragment.this.lDQ != null) {
                    PbFragment.this.lHU.b(PbFragment.this.lDQ.getPbData(), PbFragment.this.lDQ.dql(), PbFragment.this.lDQ.dqJ(), PbFragment.this.lHU.getSkinType());
                }
                if (PbFragment.this.lHU != null && PbFragment.this.lHU.dst() != null) {
                    PbFragment.this.lHU.dst().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener lIB = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lHU != null) {
                    if (booleanValue) {
                        PbFragment.this.lHU.cYm();
                    } else {
                        PbFragment.this.lHU.cYl();
                    }
                }
            }
        }
    };
    private CustomMessageListener lIC = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lIg != null) {
                    PbFragment.this.lHU.vw(PbFragment.this.lIg.bDb());
                }
                PbFragment.this.lHU.vy(false);
            }
        }
    };
    private CustomMessageListener lID = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener lIE = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lHU != null && PbFragment.this.lHU.dst() != null) {
                PbFragment.this.lHU.dst().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jhb = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener iUw = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bIA) {
                PbFragment.this.dpM();
            }
        }
    };
    private View.OnClickListener fxl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fwy);
        }
    };
    private CustomMessageListener lIF = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ah)) {
                com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) customResponsedMessage.getData();
                az.a aVar = new az.a();
                aVar.giftId = ahVar.id;
                aVar.giftName = ahVar.name;
                aVar.thumbnailUrl = ahVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDQ.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lDQ.dqA() != null && PbFragment.this.lDQ.dqA().getUserIdLong() == ahVar.toUserId) {
                        PbFragment.this.lHU.a(ahVar.sendCount, PbFragment.this.lDQ.getPbData(), PbFragment.this.lDQ.dql(), PbFragment.this.lDQ.dqJ());
                    }
                    if (pbData.dmV() != null && pbData.dmV().size() >= 1 && pbData.dmV().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dmV().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lDQ.dqj(), 0L);
                        if (j == ahVar.postId && j2 == ahVar.threadId) {
                            com.baidu.tbadk.core.data.az dPo = pbData.dmV().get(0).dPo();
                            if (dPo == null) {
                                dPo = new com.baidu.tbadk.core.data.az();
                            }
                            ArrayList<az.a> bnH = dPo.bnH();
                            if (bnH == null) {
                                bnH = new ArrayList<>();
                            }
                            bnH.add(0, aVar);
                            dPo.setTotal(ahVar.sendCount + dPo.getTotal());
                            dPo.D(bnH);
                            pbData.dmV().get(0).a(dPo);
                            PbFragment.this.lHU.dst().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lIG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                PbFragment.this.lDQ.getPbData().dnn();
                PbFragment.this.lDQ.dqF();
                if (PbFragment.this.lHU.dst() != null) {
                    PbFragment.this.lHU.s(PbFragment.this.lDQ.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jqg = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Qc(str);
                PbFragment.this.lDQ.dqF();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lDQ.getPbData().dmV() != null) {
                    ArrayList<PostData> dmV = PbFragment.this.lDQ.getPbData().dmV();
                    Iterator<PostData> it = dmV.iterator();
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
                        dmV.remove(nVar);
                        if (PbFragment.this.lHU.dst() != null && PbFragment.this.lHU.dst().getDataList() != null) {
                            PbFragment.this.lHU.dst().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.lHU.getListView() != null && PbFragment.this.lHU.getListView().getData() != null) {
                            PbFragment.this.lHU.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.lHU.dst() != null) {
                            PbFragment.this.lHU.dst().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lHU.dst() != null) {
                    PbFragment.this.lHU.s(PbFragment.this.lDQ.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a lIH = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dtL()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a lII = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ah(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.lHU != null) {
                PbFragment.this.lHU.fp(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean lIJ = false;
    private PraiseModel lIK = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void FQ(String str) {
            PbFragment.this.lIJ = false;
            if (PbFragment.this.lIK != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDQ.getPbData();
                if (pbData.dmT().boA().getIsLike() == 1) {
                    PbFragment.this.Bf(0);
                } else {
                    PbFragment.this.Bf(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dmT()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.lIJ = false;
            if (PbFragment.this.lIK != null && str != null) {
                if (AntiHelper.bP(i, str)) {
                    AntiHelper.bn(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a lIL = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void uU(boolean z) {
            PbFragment.this.uS(z);
            if (PbFragment.this.lHU.dte() != null && z) {
                PbFragment.this.lHU.vr(false);
            }
            PbFragment.this.lHU.vt(z);
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
                        if (PbFragment.this.dnc().boP() != null && PbFragment.this.dnc().boP().getGodUserData() != null) {
                            PbFragment.this.dnc().boP().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().dmT() != null && PbFragment.this.lDQ.getPbData().dmT().boP() != null) {
                            PbFragment.this.lDQ.getPbData().dmT().boP().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h iRY = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.lHn.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a lIM = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lHU.ckt();
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
                    com.baidu.tieba.k.a.cMY();
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
                PbFragment.this.dpe();
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
                        if (PbFragment.this.lHU.dpc() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").dY("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.dob() != null && PbFragment.this.dob().iCq != null) {
                                PbFragment.this.dob().iCq.onClick(view);
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
                if (PbFragment.this.lIg != null) {
                    PbFragment.this.lHU.vw(PbFragment.this.lIg.bDb());
                }
                PbFragment.this.lHU.dsb();
                PbFragment.this.lHU.dsR();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lIN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lIo) {
                PbFragment.this.lHU.ckt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDQ.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dnj().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lIn.showSuccessToast(PbFragment.this.lIm.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lIm.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.Ea(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dpI();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.au.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lIm.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lIn.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lIO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lIo) {
                PbFragment.this.lHU.ckt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lIn.showSuccessToast(PbFragment.this.lIm.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.au.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lIm.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lIn.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lIP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lIo) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lHU.ckt();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nAK;
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
                    PbFragment.this.lHU.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lIQ = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lHU.dsc() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.dpe();
            }
        }
    };
    private CustomMessageListener iUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.iTI = true;
                }
            }
        }
    };
    public a.b lop = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cCF();
            com.baidu.tbadk.core.data.ax pageData = PbFragment.this.lDQ.getPageData();
            int pageNum = PbFragment.this.lHU.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bnA()) {
                PbFragment.this.lHU.dsR();
                PbFragment.this.cCE();
                PbFragment.this.lHU.dsy();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lDQ.Hj(PbFragment.this.lHU.getPageNum());
                    if (PbFragment.this.lHq != null) {
                        PbFragment.this.lHq.showFloatingView();
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
    private k.c lIR = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lHY != null) {
                PbFragment.this.lHY.dismiss();
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
                    if (PbFragment.this.lIq != null && !TextUtils.isEmpty(PbFragment.this.lIr)) {
                        if (PbFragment.this.lIs == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lIr));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.lIr;
                            aVar.pkgId = PbFragment.this.lIs.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lIs.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lIq = null;
                        PbFragment.this.lIr = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lIq != null && !TextUtils.isEmpty(PbFragment.this.lIr)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eBS == null) {
                                PbFragment.this.eBS = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eBS.j(PbFragment.this.lIr, PbFragment.this.lIq.getImageByte());
                            PbFragment.this.lIq = null;
                            PbFragment.this.lIr = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.jZd != null) {
                        PbFragment.this.jZd.gD(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.jZd = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").al("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.dw(view);
                        if (PbFragment.this.lDQ.getPbData().dmT() != null && PbFragment.this.lDQ.getPbData().dmT().boP() != null && PbFragment.this.lDQ.getPbData().dmT().boP().getUserId() != null && PbFragment.this.lHS != null) {
                            int h = PbFragment.this.h(PbFragment.this.lDQ.getPbData());
                            by dmT = PbFragment.this.lDQ.getPbData().dmT();
                            if (dmT.bnx()) {
                                i2 = 2;
                            } else if (dmT.bny()) {
                                i2 = 3;
                            } else if (dmT.bqM()) {
                                i2 = 4;
                            } else {
                                i2 = dmT.bqN() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dY("tid", PbFragment.this.lDQ.lLh).al("obj_locate", 2).dY("obj_id", PbFragment.this.lDQ.getPbData().dmT().boP().getUserId()).al("obj_type", PbFragment.this.lHS.bkY() ? 0 : 1).al("obj_source", h).al("obj_param1", i2));
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
                        PbFragment.this.lHU.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.lHU.dD(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lHU.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
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
    public SortSwitchButton.a lIS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean Az(int i) {
            PbFragment.this.lHU.dsR();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lDQ == null || PbFragment.this.lDQ.isLoading) {
                    return false;
                }
                PbFragment.this.cCE();
                PbFragment.this.lHU.dsy();
                if (PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().lAJ != null && PbFragment.this.lDQ.getPbData().lAJ.size() > i) {
                    int intValue = PbFragment.this.lDQ.getPbData().lAJ.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13699").dY("tid", PbFragment.this.lDQ.dqk()).dY("fid", PbFragment.this.lDQ.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_type", Hh(intValue)));
                    if (PbFragment.this.lDQ.Ho(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lHU.vm(true);
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
    public final View.OnClickListener iVH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
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
                    if (view == PbFragment.this.lHU.dsN()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lDQ.va(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lHU.dsz();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().drA()) {
                        if (PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().drB()) {
                            if (view == PbFragment.this.lHU.lPc.fEN) {
                                if (PbFragment.this.lHU.vv(PbFragment.this.lDQ.dqr())) {
                                    PbFragment.this.cCE();
                                    return;
                                }
                                PbFragment.this.lHs = false;
                                PbFragment.this.lHr = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.lHn, PbFragment.this.lHU.lPc.fEN);
                                PbFragment.this.lHn.finish();
                            } else if (view != PbFragment.this.lHU.dsw() && (PbFragment.this.lHU.lPc.dtY() == null || (view != PbFragment.this.lHU.lPc.dtY().drz() && view != PbFragment.this.lHU.lPc.dtY().drx()))) {
                                if (view == PbFragment.this.lHU.dsV()) {
                                    if (PbFragment.this.lDQ != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDQ.getPbData().dmT().boO().getLink());
                                    }
                                } else if (view != PbFragment.this.lHU.lPc.lVA) {
                                    if (view == PbFragment.this.lHU.lPc.jjn) {
                                        if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                                            ArrayList<PostData> dmV = PbFragment.this.lDQ.getPbData().dmV();
                                            if ((dmV == null || dmV.size() <= 0) && PbFragment.this.lDQ.dql()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12378").dY("tid", PbFragment.this.lDQ.dqj()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", PbFragment.this.lDQ.getForumId()));
                                            if (!PbFragment.this.lHU.dtj()) {
                                                PbFragment.this.lHU.dsb();
                                            }
                                            PbFragment.this.dpm();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lHU.uH(true);
                                            PbFragment.this.lHU.dsb();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lHU.cYm();
                                                PbFragment.this.cCE();
                                                PbFragment.this.lHU.dsy();
                                                PbFragment.this.lDQ.Qj(PbFragment.this.dpy());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().drw()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lHU.lPc.dtY() != null && view == PbFragment.this.lHU.lPc.dtY().drv()) {
                                                PbFragment.this.lHU.lPc.bca();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.Hg(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().drt()) {
                                                    if (PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().drD()) {
                                                        if (PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().dru()) {
                                                            if (PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().drE()) {
                                                                if (PbFragment.this.lHU.dte() == view) {
                                                                    if (PbFragment.this.lHU.dte().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lDQ.getPbData();
                                                                        if (pbData2 != null && pbData2.dmT() != null && pbData2.dmT().bov() != null) {
                                                                            String bol = pbData2.dmT().bov().bol();
                                                                            if (StringUtils.isNull(bol)) {
                                                                                bol = pbData2.dmT().bov().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11107").dY("obj_id", bol));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gv("c10725", null);
                                                                    }
                                                                    PbFragment.this.dpF();
                                                                } else if (PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().drC()) {
                                                                    if (PbFragment.this.lHU.lPc.dtY() != null && view == PbFragment.this.lHU.lPc.dtY().dry()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lHU.b(PbFragment.this.lDQ.getPbData(), PbFragment.this.lDQ.dql(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lHU.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lHU.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lHU.lPc.bca();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar.dY("tid", PbFragment.this.lDQ.dqj());
                                                                            arVar.dY("fid", PbFragment.this.lDQ.getForumId());
                                                                            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar.al("obj_locate", 4);
                                                                            TiebaStatic.log(arVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                                                                                PbFragment.this.lHU.dsR();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dPs() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12630"));
                                                                                    }
                                                                                    if (postData.nmC != null) {
                                                                                        com.baidu.tbadk.core.util.ar btS = postData.nmC.btS();
                                                                                        btS.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            btS.al("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            btS.al("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(btS);
                                                                                    }
                                                                                    String dqj = PbFragment.this.lDQ.dqj();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lDQ.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lDQ.getPbData().dni();
                                                                                    }
                                                                                    PbFragment.this.cCE();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a Qh = PbFragment.this.Qh(id);
                                                                                        if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && Qh != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dqj, id, "pb", true, null, true, null, i3, postData.duY(), PbFragment.this.lDQ.getPbData().getAnti(), false, postData.boP().getIconInfo()).addBigImageData(Qh.lDY, Qh.eCN, Qh.eCL, Qh.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lDQ.dqU());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lDQ.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lDQ.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lDQ.dqt());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a Qh2 = PbFragment.this.Qh(id);
                                                                                        if (postData != null && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && Qh2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dqj, id, "pb", true, null, false, str2, i3, postData.duY(), PbFragment.this.lDQ.getPbData().getAnti(), false, postData.boP().getIconInfo()).addBigImageData(Qh2.lDY, Qh2.eCN, Qh2.eCL, Qh2.index);
                                                                                            if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lDQ.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lDQ.dqt());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lDQ.dqU());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lDQ.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").al("obj_locate", 3).dY("fid", PbFragment.this.lDQ.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lDQ != null) {
                                                                            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar2.dY("tid", PbFragment.this.lDQ.dqj());
                                                                            arVar2.dY("fid", PbFragment.this.lDQ.getForumId());
                                                                            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar2.al("obj_locate", 5);
                                                                            TiebaStatic.log(arVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.nmC != null) {
                                                                                        com.baidu.tbadk.core.util.ar btS2 = postData3.nmC.btS();
                                                                                        btS2.delete("obj_locate");
                                                                                        btS2.al("obj_locate", 8);
                                                                                        TiebaStatic.log(btS2);
                                                                                    }
                                                                                    if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                                                                                        String dqj2 = PbFragment.this.lDQ.dqj();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lDQ.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lDQ.getPbData().dni();
                                                                                        }
                                                                                        PbActivity.a Qh3 = PbFragment.this.Qh(id2);
                                                                                        if (Qh3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dqj2, id2, "pb", true, null, false, null, i4, postData3.duY(), PbFragment.this.lDQ.getPbData().getAnti(), false, postData3.boP().getIconInfo()).addBigImageData(Qh3.lDY, Qh3.eCN, Qh3.eCL, Qh3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lDQ.dqU());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lDQ.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lDQ.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lDQ.dqt());
                                                                                            if (PbFragment.this.lDQ.getPbData().dnD() != null) {
                                                                                                addBigImageData3.setHasForumRule(PbFragment.this.lDQ.getPbData().dnD().has_forum_rule.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lDQ.getPbData().getUserData() != null) {
                                                                                                addBigImageData3.setIsManager(PbFragment.this.lDQ.getPbData().getUserData().getIs_manager());
                                                                                            }
                                                                                            if (PbFragment.this.lDQ.getPbData().getForum().getDeletedReasonInfo() != null) {
                                                                                                addBigImageData3.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.lDQ.getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                                addBigImageData3.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.lDQ.getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lDQ.getPbData().getForum() != null) {
                                                                                                addBigImageData3.setForumHeadUrl(PbFragment.this.lDQ.getPbData().getForum().getImage_url());
                                                                                                addBigImageData3.setUserLevel(PbFragment.this.lDQ.getPbData().getForum().getUser_level());
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
                                                                        if (PbFragment.this.lDQ != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                arVar3.dY("tid", PbFragment.this.lDQ.dqj());
                                                                                arVar3.dY("fid", PbFragment.this.lDQ.getForumId());
                                                                                arVar3.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                arVar3.al("obj_locate", 6);
                                                                                TiebaStatic.log(arVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.nmC != null) {
                                                                                        com.baidu.tbadk.core.util.ar btS3 = postData4.nmC.btS();
                                                                                        btS3.delete("obj_locate");
                                                                                        btS3.al("obj_locate", 8);
                                                                                        TiebaStatic.log(btS3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dY("tid", PbFragment.this.lDQ.dqk()).dY("fid", PbFragment.this.lDQ.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", postData4.getId()).al("obj_source", 1).al("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.dpb().drY() != null && postData4.boP() != null && postData4.dPg() != 1) {
                                                                                        if (PbFragment.this.dpb().drZ() != null) {
                                                                                            PbFragment.this.dpb().drZ().doR();
                                                                                        }
                                                                                        if ((PbFragment.this.lHP || com.baidu.tbadk.a.d.bkh()) && postData4.dPd() != null && postData4.dPd().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.bki()) {
                                                                                                PbFragment.this.a(postData4, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData4, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.lDQ.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.lDQ.getPbData().dmT());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.dpb().drY().d(pVar);
                                                                                            PbFragment.this.dpb().drY().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.boP().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lIg != null) {
                                                                                                PbFragment.this.lHU.vw(PbFragment.this.lIg.bDb());
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
                                                                        if (view != PbFragment.this.lHU.dou()) {
                                                                            if (view == PbFragment.this.lHU.lPc.dtZ()) {
                                                                                PbFragment.this.lHU.dsF();
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12006").dY("tid", PbFragment.this.lDQ.lLh));
                                                                                            }
                                                                                            if (PbFragment.this.lHZ == null) {
                                                                                                PbFragment.this.lHZ = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lHZ.a(PbFragment.this.lIR);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.dy(view);
                                                                                            if (!PbFragment.this.dy(view) || PbFragment.this.lIq == null || !PbFragment.this.lIq.isGif()) {
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
                                                                                                if (postData5.dPi() != null && postData5.dPi().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lHZ);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar5.eNK.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.jZd = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lDQ.getPbData().bkY()) {
                                                                                                String bkX = PbFragment.this.lDQ.getPbData().bkX();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bkX) && bkX.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lHZ);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lHZ);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.jZd);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.eNK.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lHZ);
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
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lHZ);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lHZ);
                                                                                                                gVar2.eNK.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lHZ);
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
                                                                                                            if (PbFragment.this.lDQ.getPbData().dni() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lHZ);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lHZ);
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
                                                                                                    PbFragment.this.lHZ.bu(arrayList);
                                                                                                    PbFragment.this.lHY = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lHZ);
                                                                                                    PbFragment.this.lHY.RU();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.jZd);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.eNK.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lHZ.bu(arrayList);
                                                                                            PbFragment.this.lHY = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lHZ);
                                                                                            PbFragment.this.lHY.RU();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().dmT() != null && PbFragment.this.lDQ.getPbData().dmT().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lDQ.getPbData().dmT().getActUrl());
                                                                                        if (PbFragment.this.lDQ.getPbData().dmT().bpC() != 1) {
                                                                                            if (PbFragment.this.lDQ.getPbData().dmT().bpC() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10912").dY("fid", PbFragment.this.lDQ.getPbData().getForumId()).dY("tid", PbFragment.this.lDQ.getPbData().getThreadId()).dY("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lDQ.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lHU.setSelection(0);
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
                                                                                        PbFragment.this.lHU.dsb();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.dpk() == 1 && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10397").dY("fid", PbFragment.this.lDQ.getPbData().getForumId()).dY("tid", PbFragment.this.lDQ.getPbData().getThreadId()).dY("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.dpk() == 1 && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10507").dY("fid", PbFragment.this.lDQ.getPbData().getForumId()).dY("tid", PbFragment.this.lDQ.getPbData().getThreadId()).dY("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dpA();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dpB();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().dnp() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lDQ.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11679").dY("fid", pbData3.getForumId()));
                                                                                        bf.bua().b(PbFragment.this.getPageContext(), new String[]{pbData3.dnp().dnE()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().dnp() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lDQ.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dY("fid", pbData4.getForumId()));
                                                                                        bf.bua().b(PbFragment.this.getPageContext(), new String[]{pbData4.dnp().dnE()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.lIt >= 0) {
                                                                                        if (PbFragment.this.lDQ != null) {
                                                                                            PbFragment.this.lDQ.dqV();
                                                                                        }
                                                                                        if (PbFragment.this.lDQ != null && PbFragment.this.lHU.dst() != null) {
                                                                                            PbFragment.this.lHU.dst().a(PbFragment.this.lDQ.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.lIt = 0;
                                                                                        if (PbFragment.this.lDQ != null) {
                                                                                            PbFragment.this.lHU.getListView().setSelection(PbFragment.this.lDQ.dqY());
                                                                                            PbFragment.this.lDQ.dg(0, 0);
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
                                                                                    if (PbFragment.this.lHU.getListView() != null && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lHU.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lHU.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dnu = PbFragment.this.lDQ.getPbData().dnu();
                                                                                        boolean z8 = PbFragment.this.lHU.dsa() != null && PbFragment.this.lHU.dsa().caj();
                                                                                        boolean dsO = PbFragment.this.lHU.dsO();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (dnu && PbFragment.this.lHU.dsa() != null && PbFragment.this.lHU.dsa().bSs() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lHU.dsa().dtI();
                                                                                            z9 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.lHU.dsa().bSs().getHeight() - PbFragment.this.lHU.dsa().dtI());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.Qi("c13568");
                                                                                        if ((PbFragment.this.lDQ.getPbData().dmT() != null && PbFragment.this.lDQ.getPbData().dmT().boG() <= 0) || (dsO && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.dph();
                                                                                                if (PbFragment.this.lDQ.getPbData().dmT().boP() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", PbFragment.this.lDQ.lLh).dY("fid", PbFragment.this.lDQ.getPbData().getForumId()).al("obj_locate", 2).dY("uid", PbFragment.this.lDQ.getPbData().dmT().boP().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dnu) {
                                                                                                if (PbFragment.this.lHU.lQm != null && PbFragment.this.lHU.lQm.lRv != null && PbFragment.this.lHU.lQm.lRv.getView() != null) {
                                                                                                    if (PbFragment.this.lHU.lQm.lRv.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dpq();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.lHU.dsa() != null && PbFragment.this.lHU.dsa().bSs() != null) {
                                                                                                            i6 = PbFragment.this.lHU.dsa().bSs().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.lHU.lQm.lRv.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lHU.dsk() != null) {
                                                                                                z10 = PbFragment.this.lHU.dsk().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.lHU.lQm != null && PbFragment.this.lHU.lQm.lRv != null && PbFragment.this.lHU.lQm.lRv.getView() != null && PbFragment.this.lHU.lQm.lRv.getView().getParent() != null && PbFragment.this.lHU.lPc != null && PbFragment.this.lHU.lPc.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.lHU.lQm.lRv.getView().getTop() - PbFragment.this.lHU.lPc.mNavigationBar.getBottom() < PbFragment.this.lHU.lQm.lRv.lOB.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || dsO) {
                                                                                                PbFragment.this.lHK = firstVisiblePosition;
                                                                                                PbFragment.this.lHL = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lHU.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.lHU.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lHU.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lHK > 0) {
                                                                                                if (PbFragment.this.lHU.getListView().getChildAt(PbFragment.this.lHK) != null) {
                                                                                                    PbFragment.this.lHU.getListView().smoothScrollToPosition(PbFragment.this.lHK, PbFragment.this.lHL, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lHU.getListView().setSelectionFromTop(PbFragment.this.lHK, PbFragment.this.lHL + equipmentHeight);
                                                                                                    PbFragment.this.lHU.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dpq = PbFragment.this.dpq();
                                                                                                if (PbFragment.this.dpp() != -1) {
                                                                                                    dpq--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dpq < 0) {
                                                                                                    i = PbFragment.this.lHU.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.lHU.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = dpq;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!dnu || PbFragment.this.lHU.dsa() == null) {
                                                                                                    if (PbFragment.this.lHU.lPc != null && PbFragment.this.lHU.lPc.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.lHU.lPc.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.lHU.dsa().dtH();
                                                                                                }
                                                                                                if (PbFragment.this.lHU.lQm == null || PbFragment.this.lHU.lQm.lRv == null || PbFragment.this.lHU.lQm.lRv.getView() == null || PbFragment.this.lHU.lQm.lRv.getView().getParent() == null) {
                                                                                                    PbFragment.this.lHU.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.lHU.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.lHU.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lHU.getListView().smoothScrollBy(PbFragment.this.lHU.lQm.lRv.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lDQ.getPbData().dmT() != null && PbFragment.this.lDQ.getPbData().dmT().boP() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", PbFragment.this.lDQ.lLh).dY("fid", PbFragment.this.lDQ.getPbData().getForumId()).al("obj_locate", 2).dY("uid", PbFragment.this.lDQ.getPbData().dmT().boP().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(PbFragment.this.lDQ.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lDQ.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lDQ.dod()) || PbFragment.this.lDQ.getAppealInfo() == null) {
                                                                                                PbFragment.this.lHn.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lDQ.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lDQ.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.lHn.finish();
                                                                                            return;
                                                                                        }
                                                                                        String dod = PbFragment.this.lDQ.dod();
                                                                                        if (PbFragment.this.lDQ.dqm() && dod != null && dod.equals(name)) {
                                                                                            PbFragment.this.lHn.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lDQ.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c13401");
                                                                                        arVar4.dY("tid", PbFragment.this.lDQ.dqj());
                                                                                        arVar4.dY("fid", PbFragment.this.lDQ.getForumId());
                                                                                        arVar4.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lDQ.getPbData().dmT() != null) {
                                                                                            arVar4.dY("nid", PbFragment.this.lDQ.getPbData().dmT().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(arVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof by) {
                                                                                        by byVar = (by) view.getTag();
                                                                                        if (PbFragment.this.lDQ.dqU() == 3 && PbFragment.this.doc() && PbFragment.this.lDQ.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.lDQ.getPbData().dnq())) {
                                                                                            PbFragment.this.lHn.finish();
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
                                                                                    if (PbFragment.this.lDQ != null) {
                                                                                        com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                        arVar6.dY("tid", PbFragment.this.lDQ.dqj());
                                                                                        arVar6.dY("fid", PbFragment.this.lDQ.getForumId());
                                                                                        arVar6.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar6.al("obj_locate", 2);
                                                                                        TiebaStatic.log(arVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lDQ.getPbData();
                                                                                        if (PbFragment.this.lHT == null) {
                                                                                            PbFragment.this.lHT = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.ar("c13446").w("forum_id", j2).btT();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lIV);
                                                                                        PbFragment.this.lHT.F(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13274").dY("fid", PbFragment.this.lDQ.getForumId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("obj_name", smartApp.name).w("obj_id", smartApp.swan_app_id.longValue()).dY("obj_source", "PB_card").dY("tid", PbFragment.this.lDQ.dqj()).al("obj_param1", smartApp.is_game.intValue()));
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
                                                                                    arVar7.dY("tid", PbFragment.this.lDQ.dqj());
                                                                                    arVar7.dY("fid", PbFragment.this.lDQ.getForumId());
                                                                                    arVar7.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    arVar7.al("obj_locate", 7);
                                                                                    TiebaStatic.log(arVar7);
                                                                                    PbFragment.this.lHo = false;
                                                                                    PbFragment.this.dx(view);
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lDQ.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lDQ.dqj(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lDQ.getPbData().dmT().bpk())));
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
                                                                            if (PbFragment.this.lHZ == null) {
                                                                                PbFragment.this.lHZ = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lHZ.a(PbFragment.this.lIR);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.dok().getPbData() != null && PbFragment.this.dok().getPbData().dnx();
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
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bqI().hasAgree && postData6.bqs() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lHZ);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar8.eNK.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lHZ);
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
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lHZ);
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
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lHZ);
                                                                                            gVar11.eNK.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lHZ);
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
                                                                                            if (PbFragment.this.lDQ.getPbData().dni() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lHZ);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lHZ);
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
                                                                                PbFragment.this.lHZ.bu(arrayList2);
                                                                                PbFragment.this.lHY = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lHZ);
                                                                                PbFragment.this.lHY.RU();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lHU.dsR();
                                                                    SparseArray<Object> b3 = PbFragment.this.lHU.b(PbFragment.this.lDQ.getPbData(), PbFragment.this.lDQ.dql(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDQ.getPbData().getForum().getId(), PbFragment.this.lDQ.getPbData().getForum().getName(), PbFragment.this.lDQ.getPbData().dmT().getId(), String.valueOf(PbFragment.this.lDQ.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                PbFragment.this.lHU.lPc.dtX();
                                                            }
                                                        } else if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().dmT() != null) {
                                                            PbFragment.this.lHU.lPc.bca();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13062"));
                                                            PbFragment.this.Qe(PbFragment.this.lDQ.getPbData().dmT().bpg());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lHU.dsR();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lDQ.dqD()));
                                                                return;
                                                            }
                                                            PbFragment.this.cCE();
                                                            PbFragment.this.lHU.dsy();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lDQ.getPbData().lAJ == null || PbFragment.this.lDQ.getPbData().lAJ.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lDQ.getPbData().lAJ.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.lDQ.getPbData().lAJ.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.lDQ.getPbData().lAJ.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lDQ.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.lDQ.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.lDQ.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.lDQ.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12097").al("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).al("obj_type", i10));
                                                                    if (PbFragment.this.lDQ.getPbData().lAJ != null && PbFragment.this.lDQ.getPbData().lAJ.size() > i9) {
                                                                        i9 = PbFragment.this.lDQ.getPbData().lAJ.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean Ho = PbFragment.this.lDQ.Ho(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lDQ.dqD()));
                                                                    if (Ho) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lHU.vm(true);
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
                                                    PbFragment.this.lHU.dsR();
                                                    if (PbFragment.this.dok().getPbData().lAK != 2) {
                                                        if (PbFragment.this.lDQ.getPageData() != null) {
                                                            PbFragment.this.lHU.a(PbFragment.this.lDQ.getPageData(), PbFragment.this.lop);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lDQ.getPbData()) != null) {
                                                by dmT = pbData.dmT();
                                                if (dmT != null && dmT.boP() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", PbFragment.this.lDQ.lLh).dY("fid", pbData.getForumId()).al("obj_locate", 4).dY("uid", dmT.boP().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (dmT != null) {
                                                    if (dmT.bnx()) {
                                                        i9 = 2;
                                                    } else if (dmT.bny()) {
                                                        i9 = 3;
                                                    } else if (dmT.bqM()) {
                                                        i9 = 4;
                                                    } else if (dmT.bqN()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.ar arVar8 = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                arVar8.dY("tid", PbFragment.this.lDQ.dqj());
                                                arVar8.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                                arVar8.dY("fid", PbFragment.this.lDQ.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    arVar8.al("obj_locate", 5);
                                                } else {
                                                    arVar8.al("obj_locate", 6);
                                                }
                                                arVar8.al("obj_name", i9);
                                                arVar8.al("obj_type", 1);
                                                if (dmT != null) {
                                                    if (dmT.bnx()) {
                                                        arVar8.al("obj_type", 10);
                                                    } else if (dmT.bny()) {
                                                        arVar8.al("obj_type", 9);
                                                    } else if (dmT.bqN()) {
                                                        arVar8.al("obj_type", 8);
                                                    } else if (dmT.bqM()) {
                                                        arVar8.al("obj_type", 7);
                                                    } else if (dmT.isShareThread) {
                                                        arVar8.al("obj_type", 6);
                                                    } else if (dmT.threadType == 0) {
                                                        arVar8.al("obj_type", 1);
                                                    } else if (dmT.threadType == 40) {
                                                        arVar8.al("obj_type", 2);
                                                    } else if (dmT.threadType == 49) {
                                                        arVar8.al("obj_type", 3);
                                                    } else if (dmT.threadType == 54) {
                                                        arVar8.al("obj_type", 4);
                                                    } else {
                                                        arVar8.al("obj_type", 5);
                                                    }
                                                    arVar8.al(IntentConfig.CARD_TYPE, dmT.bqQ());
                                                    arVar8.dY(IntentConfig.RECOM_SOURCE, dmT.mRecomSource);
                                                    arVar8.dY("ab_tag", dmT.mRecomAbTag);
                                                    arVar8.dY("weight", dmT.mRecomWeight);
                                                    arVar8.dY("extra", dmT.mRecomExtra);
                                                    arVar8.dY("nid", dmT.getNid());
                                                    if (dmT.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(dmT.getBaijiahaoData().oriUgcVid)) {
                                                        arVar8.dY("obj_param6", dmT.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    arVar8.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.dpQ() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.dpQ(), arVar8);
                                                }
                                                TiebaStatic.log(arVar8);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dmV2 = PbFragment.this.lDQ.getPbData().dmV();
                                                    if ((dmV2 != null && dmV2.size() > 0) || !PbFragment.this.lDQ.dql()) {
                                                        PbFragment.this.lHU.dsR();
                                                        PbFragment.this.cCE();
                                                        if (pbData.dnp() != null && !StringUtils.isNull(pbData.dnp().bmL(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dY("fid", PbFragment.this.lDQ.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dmT)) {
                                                            if (PbFragment.this.lHU != null) {
                                                                PbFragment.this.lHU.dsU();
                                                                PbFragment.this.lHU.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lHU.showLoadingDialog();
                                                                PbFragment.this.lDQ.dqP().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
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
                                            PbFragment.this.lHU.dsR();
                                            if (PbFragment.this.lHU.lPc.dtY() != null && view == PbFragment.this.lHU.lPc.dtY().drw() && !PbFragment.this.lHU.dtj()) {
                                                PbFragment.this.lHU.dsb();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cCE();
                                                PbFragment.this.lHU.dsy();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    C = PbFragment.this.lDQ.C(true, PbFragment.this.dpy());
                                                } else {
                                                    C = view.getId() == R.id.reply_title ? PbFragment.this.lDQ.C(false, PbFragment.this.dpy()) : PbFragment.this.lDQ.Qj(PbFragment.this.dpy());
                                                }
                                                view.setTag(Boolean.valueOf(C));
                                                if (C) {
                                                    PbFragment.this.lHU.uH(true);
                                                    PbFragment.this.lHU.cYm();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lHU.vm(true);
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
                                        PbFragment.this.lHU.dsR();
                                        if (PbFragment.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lDQ.Hp(PbFragment.this.lHU.dsD()) != null) {
                                            PbFragment.this.dpt();
                                            if (PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().dmT() != null && PbFragment.this.lDQ.getPbData().dmT().boP() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", PbFragment.this.lDQ.lLh).dY("fid", PbFragment.this.lDQ.getPbData().getForumId()).al("obj_locate", 3).dY("uid", PbFragment.this.lDQ.getPbData().dmT().boP().getUserId()));
                                            }
                                            if (PbFragment.this.lDQ.getPbData().dmT() != null && PbFragment.this.lDQ.getPbData().dmT().boP() != null && PbFragment.this.lDQ.getPbData().dmT().boP().getUserId() != null && PbFragment.this.lHS != null) {
                                                int h = PbFragment.this.h(PbFragment.this.lDQ.getPbData());
                                                by dmT2 = PbFragment.this.lDQ.getPbData().dmT();
                                                int i11 = 1;
                                                if (dmT2.bnx()) {
                                                    i11 = 2;
                                                } else if (dmT2.bny()) {
                                                    i11 = 3;
                                                } else if (dmT2.bqM()) {
                                                    i11 = 4;
                                                } else if (dmT2.bqN()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dY("tid", PbFragment.this.lDQ.lLh).al("obj_locate", 1).dY("obj_id", PbFragment.this.lDQ.getPbData().dmT().boP().getUserId()).al("obj_type", PbFragment.this.lHS.bkY() ? 0 : 1).al("obj_source", h).al("obj_param1", i11));
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
                                    if (PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().dmT() != null && PbFragment.this.lDQ.getPbData().dmT().bnv() && PbFragment.this.lDQ.getPbData().dmT().bph() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11922"));
                                    }
                                    if (PbFragment.this.lDQ.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lDQ.dod()) || PbFragment.this.lDQ.getAppealInfo() == null) {
                                            PbFragment.this.lHn.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lDQ.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lDQ.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.lHn.finish();
                                        return;
                                    }
                                    String dod2 = PbFragment.this.lDQ.dod();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lDQ.dqm() && dod2 != null && dod2.equals(name2)) {
                                        PbFragment.this.lHn.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lDQ.getPbData() != null) {
                                    if ((PbFragment.this.lDQ.getPbData().dni() == 1 || PbFragment.this.lDQ.getPbData().dni() == 3) && !PbFragment.this.fXb.dQb()) {
                                        PbFragment.this.lHU.dsR();
                                        int i12 = 0;
                                        if (PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().drx()) {
                                            if (PbFragment.this.lHU.lPc.dtY() == null || view != PbFragment.this.lHU.lPc.dtY().drz()) {
                                                if (view == PbFragment.this.lHU.dsw()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.lDQ.getPbData().dmT().boL() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.lDQ.getPbData().dmT().boK() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.lDQ.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.lDQ.getPbData().dmT().getId();
                                        PbFragment.this.lHU.dsv();
                                        PbFragment.this.fXb.c(id4, name3, id5, i12, PbFragment.this.lHU.dsx());
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
                            PbFragment.this.lHU.lPc.dtX();
                            if (PbFragment.this.lDQ != null) {
                                PbFragment.this.iko.setThreadId(PbFragment.this.lDQ.dqj());
                            }
                            int i13 = 1;
                            if (PbFragment.this.lDQ == null || !PbFragment.this.lDQ.isPrivacy()) {
                                PbFragment.this.iko.crC();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dok() != null && PbFragment.this.dok().getPbData() != null && PbFragment.this.dok().getPbData().getThreadId() != null && PbFragment.this.dok().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.dok() != null && PbFragment.this.dok().getPbData() != null) {
                                    PbFragment.this.iko.l(3, i13, PbFragment.this.dok().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dok() != null && PbFragment.this.dok().getPbData() != null) {
                                    PbFragment.this.iko.l(3, 3, PbFragment.this.dok().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lHU.dsR();
                        PbFragment.this.cCE();
                        PbFragment.this.lHU.dsy();
                        PbFragment.this.lHU.showLoadingDialog();
                        if (PbFragment.this.lHU.dsk() != null) {
                            PbFragment.this.lHU.dsk().setVisibility(8);
                        }
                        PbFragment.this.lDQ.Hj(1);
                        if (PbFragment.this.lHq != null) {
                            PbFragment.this.lHq.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String dpi = PbFragment.this.dpi();
                        if (!TextUtils.isEmpty(dpi)) {
                            bf.bua().b(PbFragment.this.getPageContext(), new String[]{dpi});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar9 = new com.baidu.tbadk.core.util.ar("c13398");
                arVar9.dY("tid", PbFragment.this.lDQ.dqj());
                arVar9.dY("fid", PbFragment.this.lDQ.getForumId());
                arVar9.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar9.al("obj_locate", 1);
                TiebaStatic.log(arVar9);
                if (PbFragment.this.lHz) {
                    PbFragment.this.lHz = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.dpb().drY() != null && postData7.boP() != null && postData7.dPg() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.dpb().drZ() != null) {
                                PbFragment.this.dpb().drZ().doR();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.lDQ.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.lDQ.getPbData().dmT());
                            pVar2.g(postData7);
                            PbFragment.this.dpb().drY().d(pVar2);
                            PbFragment.this.dpb().drY().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.boP().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lDQ.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lIg != null) {
                                PbFragment.this.lHU.vw(PbFragment.this.lIg.bDb());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lIT = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lDQ != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lDQ.lLh)) {
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
                if (PbFragment.this.lDQ.getPbData() != null) {
                    arVar.dY("fid", PbFragment.this.lDQ.getPbData().getForumId());
                }
                arVar.dY("tid", PbFragment.this.lDQ.dqj());
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            PbFragment.this.cCE();
            PbFragment.this.lHU.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.lDQ.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDQ.getPbData();
                            if (pbData != null && pbData.dmT() != null && pbData.dmT().boP() != null && (userId = pbData.dmT().boP().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lDQ.dqw()) {
                                PbFragment.this.lHU.dsy();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lDQ.dqw()) {
                            PbFragment.this.lHU.dsy();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lHU.s(PbFragment.this.lDQ.getPbData());
                    }
                    if (PbFragment.this.lDQ.dqq()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10369").dY("tid", PbFragment.this.lDQ.dqj()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.uN(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lIg.bDi() || PbFragment.this.lIg.bDj()) {
                    PbFragment.this.lIg.a(false, postWriteCallBackData);
                }
                PbFragment.this.kNk.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kJC != null) {
                    PbFragment.this.kJC.a(postWriteCallBackData.getReplyPrivacyTip());
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
    public NewWriteModel.d lIU = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                    arVar.dY("fid", PbFragment.this.lDQ.getPbData().getForumId());
                }
                if (PbFragment.this.lDQ != null) {
                    arVar.dY("tid", PbFragment.this.lDQ.dqj());
                }
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (PbFragment.this.kNk != null) {
                    PbFragment.this.kNk.dtq();
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
                if (PbFragment.this.kJC != null) {
                    PbFragment.this.kJC.a(postWriteCallBackData.getReplyPrivacyTip());
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
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kNk != null) {
                if (PbFragment.this.lHU != null && PbFragment.this.lHU.drZ() != null && PbFragment.this.lHU.drZ().doV() != null && PbFragment.this.lHU.drZ().doV().bDj()) {
                    PbFragment.this.lHU.drZ().doV().a(postWriteCallBackData);
                }
                PbFragment.this.kNk.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lIV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dtm;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.lHn.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lHU != null && (dtm = PbFragment.this.lHU.dtm()) != null && PbFragment.this.lHU.getListView() != null) {
                            PbFragment.this.lHU.getListView().removeHeaderView(dtm);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lIW = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h sg;
            if (!z || fVar == null || fVar.dng() != null || com.baidu.tbadk.core.util.y.getCount(fVar.dmV()) >= 1) {
                PbFragment.this.lcU = true;
                PbFragment.this.lHU.dsA();
                if (fVar == null || !fVar.dnb()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lHU.getView());
                }
                PbFragment.this.lHU.cYl();
                if (PbFragment.this.isFullScreen || PbFragment.this.lHU.dtj()) {
                    PbFragment.this.lHU.dta();
                } else if (!PbFragment.this.lHU.dsX()) {
                    PbFragment.this.lHU.vy(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.geI = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lHU.getView());
                    PbFragment.this.lHU.dsJ();
                }
                if (z && fVar != null) {
                    by dmT = fVar.dmT();
                    if (dmT == null || !dmT.bnz()) {
                        PbFragment.this.d(PbFragment.this.lIf);
                    } else {
                        dpS();
                    }
                    PbFragment.this.lHU.drZ().setPbData(fVar);
                    PbFragment.this.lHU.bYs();
                    if (dmT != null && dmT.bqc() != null) {
                        PbFragment.this.a(dmT.bqc());
                    }
                    if (PbFragment.this.lIg != null) {
                        PbFragment.this.lHU.vw(PbFragment.this.lIg.bDb());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dmV() != null && fVar.dmV().size() >= 1 && fVar.dmV().get(0) != null) {
                        PbFragment.this.lDQ.Ql(fVar.dmV().get(0).getId());
                    } else if (fVar.dng() != null) {
                        PbFragment.this.lDQ.Ql(fVar.dng().getId());
                    }
                    if (PbFragment.this.lIg != null) {
                        PbFragment.this.lIg.a(fVar.getAnti());
                        PbFragment.this.lIg.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lIg.setThreadData(dmT);
                        PbFragment.this.lIg.a(PbFragment.this.lDQ.dqA(), PbFragment.this.lDQ.dqj(), PbFragment.this.lDQ.dqR());
                        if (dmT != null) {
                            PbFragment.this.lIg.kD(dmT.bqo());
                        }
                    }
                    if (PbFragment.this.lHS != null) {
                        PbFragment.this.lHS.iH(fVar.bkY());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.dnx()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lHU.vx(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lHU.a(fVar, i2, i3, PbFragment.this.lDQ.dql(), i4, PbFragment.this.lDQ.getIsFromMark());
                    PbFragment.this.lHU.d(fVar, PbFragment.this.lDQ.dql());
                    PbFragment.this.lHU.vu(PbFragment.this.lDQ.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fwy = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fwy) && PbFragment.this.lIg != null && PbFragment.this.lIg.bCn() != null && (sg = PbFragment.this.lIg.bCn().sg(6)) != null && !TextUtils.isEmpty(PbFragment.this.fwy)) {
                            ((View) sg).setOnClickListener(PbFragment.this.fxl);
                        }
                    }
                    if (PbFragment.this.lIb) {
                        PbFragment.this.lIb = false;
                        final int dpp = PbFragment.this.dpp();
                        if (!fVar.dnu()) {
                            PbFragment.this.lHU.Hw(dpp);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dpp, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lIc) {
                        PbFragment.this.lIc = false;
                        final int dpp2 = PbFragment.this.dpp();
                        final boolean z2 = dpp2 != -1;
                        if (!z2) {
                            dpp2 = PbFragment.this.dpq();
                        }
                        if (PbFragment.this.lHU != null) {
                            if (!fVar.dnu()) {
                                PbFragment.this.lHU.Hw(dpp2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dpp2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lHU.setSelectionFromTop(dpp2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lHU.setSelectionFromTop(dpp2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lHU.vz(true);
                                PbFragment.this.lHU.vy(false);
                            }
                        }
                    } else if (PbFragment.this.lId) {
                        PbFragment.this.lId = false;
                        PbFragment.this.lHU.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lHU.dsE();
                    }
                    PbFragment.this.lDQ.a(fVar.getForum(), PbFragment.this.lIH);
                    PbFragment.this.lDQ.a(PbFragment.this.lII);
                    if (PbFragment.this.kJC != null && dmT != null && dmT.boP() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dmT.boP());
                        PbFragment.this.kJC.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.geI && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lDQ.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lDQ.getAppealInfo().lAB)) {
                                    PbFragment.this.lHU.a(PbFragment.this.lDQ.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lHU.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lHU.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lHU.dta();
                            PbFragment.this.lHU.dsI();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lDQ.dqj());
                            jSONObject.put("fid", PbFragment.this.lDQ.getForumId());
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
                        PbFragment.this.lHU.Qr("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                            arrayList = PbFragment.this.lDQ.getPbData().dmV();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dPg() != 1)) {
                            PbFragment.this.lHU.Qr(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dpJ()) {
                                PbFragment.this.lHU.Qs(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lHU.Qs(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lHU.s(PbFragment.this.lDQ.getPbData());
                        }
                    }
                    PbFragment.this.lHU.endLoadData();
                }
                if (fVar != null && fVar.lAQ && PbFragment.this.fCl == 0) {
                    PbFragment.this.fCl = System.currentTimeMillis() - PbFragment.this.ivy;
                }
                if (!PbFragment.this.dok().dql() || PbFragment.this.dok().getPbData().getPage().bnG() != 0 || PbFragment.this.dok().dqM()) {
                    PbFragment.this.lIh = true;
                    return;
                }
                return;
            }
            PbFragment.this.lDQ.Hj(1);
            if (PbFragment.this.lHq != null) {
                PbFragment.this.lHq.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dpS() {
            if (PbFragment.this.lDQ != null) {
                if (PbFragment.this.lIg == null || !PbFragment.this.lIg.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lIg = (com.baidu.tbadk.editortools.pb.e) dVar.eN(PbFragment.this.getContext());
                    PbFragment.this.lIg.a(PbFragment.this.lHn.getPageContext());
                    PbFragment.this.lIg.a(PbFragment.this.fwI);
                    PbFragment.this.lIg.a(PbFragment.this.fwB);
                    PbFragment.this.lIg.a(PbFragment.this.lHn.getPageContext(), PbFragment.this.lHn.getIntent() == null ? null : PbFragment.this.lHn.getIntent().getExtras());
                    PbFragment.this.lIg.bCn().ks(true);
                    PbFragment.this.lHU.setEditorTools(PbFragment.this.lIg.bCn());
                    if (!PbFragment.this.lDQ.dqr()) {
                        PbFragment.this.lIg.DV(PbFragment.this.lDQ.dqj());
                    }
                    if (PbFragment.this.lDQ.dqS()) {
                        PbFragment.this.lIg.DT(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lHU != null) {
                        PbFragment.this.lIg.DT(PbFragment.this.lHU.dsd());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lHU.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.l.bFl().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.ivy : j;
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
                if (!z2 && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().dmT() != null) {
                    int threadType = PbFragment.this.lDQ.getPbData().dmT().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.au.equals(PbFragment.this.lHD, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.au.equals(PbFragment.this.lHD, "from_frs")) {
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
    private CustomMessageListener lIX = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.dpl();
            }
        }
    };
    private final a.InterfaceC0583a lIY = new a.InterfaceC0583a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0583a
        public void d(boolean z, boolean z2, String str) {
            PbFragment.this.lHU.dsA();
            if (z) {
                if (PbFragment.this.lHS != null) {
                    PbFragment.this.lHS.iH(z2);
                }
                PbFragment.this.lDQ.vc(z2);
                if (PbFragment.this.lDQ.bkY()) {
                    PbFragment.this.dpu();
                } else {
                    PbFragment.this.lHU.s(PbFragment.this.lDQ.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lHS != null) {
                        if (PbFragment.this.lHS.blb() != null && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lDQ.getPbData().dmT() != null && PbFragment.this.lDQ.getPbData().dmT().boP() != null) {
                            MarkData blb = PbFragment.this.lHS.blb();
                            MetaData boP = PbFragment.this.lDQ.getPbData().dmT().boP();
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
                    PbFragment.this.dpr();
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
                if (PbFragment.this.lHU != null) {
                    PbFragment.this.lHU.dsR();
                    if (PbFragment.this.lIg != null && !PbFragment.this.lHU.dsc()) {
                        PbFragment.this.lHU.vw(PbFragment.this.lIg.bDb());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lHU.dsb();
                    }
                }
                if (!PbFragment.this.lHw) {
                    PbFragment.this.lHw = true;
                }
            }
            if (PbFragment.this.lHU != null) {
                PbFragment.this.lHU.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lHq != null) {
                PbFragment.this.lHq.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lHx == null) {
                PbFragment.this.lHx = new com.baidu.tbadk.n.b();
                PbFragment.this.lHx.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.lHx.bFe();
            } else {
                PbFragment.this.lHx.bFd();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.t.c.dOe().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dmV;
            if (PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null && PbFragment.this.lHU != null && PbFragment.this.lHU.dst() != null) {
                PbFragment.this.lHU.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.lHq != null) {
                    PbFragment.this.lHq.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lDQ.dqI() && (dmV = PbFragment.this.lDQ.getPbData().dmV()) != null && !dmV.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lHU.dst().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lDQ.getPbData();
                    if (pbData != null) {
                        if (pbData.dmW() != null && pbData.dmW().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dmX() != null && pbData.dmX().hasData()) {
                            headerCount--;
                        }
                        int size = dmV.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d ikt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.fXb.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.lDQ.dqF();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.lXw != 1002 || bVar.gZr) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lHU.a(1, dVar.mSuccess, dVar.noI, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.fXb.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lHU.a(PbFragment.this.fXb.getLoadDataMode(), gVar.mSuccess, gVar.noI, false);
                            PbFragment.this.lHU.bf(gVar.noL);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lHU.a(PbFragment.this.fXb.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lIZ = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c gcq = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dpz()) {
                PbFragment.this.lHn.finish();
            }
            if (!PbFragment.this.lDQ.vb(true)) {
                PbFragment.this.lHU.dsB();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lJb = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lJa && PbFragment.this.dpz()) {
                PbFragment.this.dpB();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lHO && PbFragment.this.lHU != null && PbFragment.this.lHU.dto() && PbFragment.this.lDQ != null) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13999");
                    arVar.dY("tid", PbFragment.this.lDQ.dqj());
                    arVar.dY("fid", PbFragment.this.lDQ.getForumId());
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (!PbFragment.this.lDQ.dqm()) {
                        if (!PbFragment.this.lDQ.dqp()) {
                            if (PbFragment.this.lDQ.dqo()) {
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
                    PbFragment.this.lHO = true;
                }
                if (PbFragment.this.lDQ.va(false)) {
                    PbFragment.this.lHU.dsz();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lDQ.getPbData() != null) {
                    PbFragment.this.lHU.dsW();
                }
                PbFragment.this.lJa = true;
            }
        }
    };
    private int lJc = 0;
    private final TbRichTextView.i fNk = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dst;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lHU.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                arVar.dY("tid", PbFragment.this.lDQ.dqj());
                arVar.dY("fid", PbFragment.this.lDQ.getForumId());
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.al("obj_locate", 3);
                arVar.al("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(arVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lDQ.lEN.dnx()) {
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
                        aVar.x(arrayList).oj(i3).iN(false).iO(PbFragment.this.lDQ.dqC()).a(concurrentHashMap).iP(true).iQ(false).iR(PbFragment.this.dpJ()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lDQ != null) {
                            aVar.AL(PbFragment.this.lDQ.getFromForumId());
                            if (PbFragment.this.lDQ.getPbData() != null) {
                                aVar.s(PbFragment.this.lDQ.getPbData().dmT());
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
                    if (aVar2.lDZ) {
                        TbRichText bz = PbFragment.this.bz(str, i);
                        if (bz != null && PbFragment.this.lJc >= 0 && PbFragment.this.lJc < bz.bIC().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bz.bIC().get(PbFragment.this.lJc));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lDY.size()) {
                                    break;
                                } else if (!aVar2.lDY.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bz.getPostId() != 0 && (dst = PbFragment.this.lHU.dst()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = dst.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && bz.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bz.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lDQ.dqR(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lDQ.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
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
                            aVar3.x(arrayList2).AG(aVar2.forumName).AH(aVar2.forumId).AI(aVar2.threadId).iN(aVar2.eCL).iP(true).AJ(aVar2.lastId).iO(PbFragment.this.lDQ.dqC()).a(concurrentHashMap2).iQ(false).iR(PbFragment.this.dpJ()).AK(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lDQ != null) {
                                aVar3.AL(PbFragment.this.lDQ.getFromForumId());
                                if (PbFragment.this.lDQ.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lDQ.getPbData().dmT());
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
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.lDY, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.eCN.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).AG(aVar2.forumName).AH(aVar2.forumId).AI(aVar2.threadId).iN(aVar2.eCL).iP(true).AJ(aVar2.lDY.get(0)).iO(PbFragment.this.lDQ.dqC()).a(concurrentHashMap3).iQ(false).iR(PbFragment.this.dpJ()).AK(aVar2.postId).iS(false);
                    if (PbFragment.this.lDQ != null) {
                        aVar4.AL(PbFragment.this.lDQ.getFromForumId());
                        if (PbFragment.this.lDQ.getPbData() != null) {
                            aVar4.s(PbFragment.this.lDQ.getPbData().dmT());
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
                PbFragment.this.lHH = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lJd = false;
    PostData jZd = null;
    private final b.InterfaceC0586b lJe = new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jZd != null) {
                if (i == 0) {
                    PbFragment.this.jZd.gD(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.jZd = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.jZd);
                }
            }
        }
    };
    private final b.InterfaceC0586b lJf = new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lIq != null && !TextUtils.isEmpty(PbFragment.this.lIr)) {
                if (i == 0) {
                    if (PbFragment.this.lIs == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lIr));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.lIr;
                        aVar.pkgId = PbFragment.this.lIs.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lIs.memeInfo.pck_id;
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
                        PbFragment.this.eBS.j(PbFragment.this.lIr, PbFragment.this.lIq.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lIq = null;
                PbFragment.this.lIr = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment.this.lHo = true;
            return PbFragment.this.dx(view);
        }
    };
    private final NoNetworkView.a iQf = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bIA && z && !PbFragment.this.lDQ.dqs()) {
                PbFragment.this.dpw();
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
            PbFragment.this.iXO.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0756a irM = new a.InterfaceC0756a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int gYX = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void G(int i, int i2) {
            if (ay(i2) && PbFragment.this.lHU != null && PbFragment.this.lHq != null) {
                PbFragment.this.lHq.qn(true);
                if (Math.abs(i2) > this.gYX) {
                    PbFragment.this.lHq.hideFloatingView();
                }
                if (PbFragment.this.dpz()) {
                    PbFragment.this.lHU.dsq();
                    PbFragment.this.lHU.dsr();
                }
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void H(int i, int i2) {
            if (ay(i2) && PbFragment.this.lHU != null && PbFragment.this.lHq != null) {
                PbFragment.this.lHU.dtb();
                PbFragment.this.lHq.qn(false);
                PbFragment.this.lHq.showFloatingView();
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
    private final q.a lGr = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void q(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lHU.Qt(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lJh = -1;
    private int lJi = -1;

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

    public com.baidu.tbadk.editortools.pb.e doW() {
        return this.lIg;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.dnM() != null) {
            String id = pVar.dnM().getId();
            ArrayList<PostData> dmV = this.lDQ.getPbData().dmV();
            int i = 0;
            while (true) {
                if (i >= dmV.size()) {
                    z = true;
                    break;
                }
                PostData postData = dmV.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dnU = pVar.dnU();
                    postData.KU(pVar.getTotalCount());
                    if (postData.dPd() == null || dnU == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dnU.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.boP() != null && (metaData = postData.getUserMap().get(next.boP().getUserId())) != null) {
                                next.a(metaData);
                                next.yc(true);
                                next.a(getPageContext(), this.lDQ.Qk(metaData.getUserId()));
                            }
                        }
                        z = dnU.size() != postData.dPd().size();
                        if (postData.dPd() != null && postData.dPd().size() < 2) {
                            postData.dPd().clear();
                            postData.dPd().addAll(dnU);
                        }
                    }
                    if (postData.dOZ() != null) {
                        postData.dPa();
                    }
                }
            }
            if (!this.lDQ.getIsFromMark() && z) {
                this.lHU.s(this.lDQ.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qc(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n dnl = this.lDQ.getPbData().dnl();
            if (dnl != null && str.equals(dnl.getAdId())) {
                if (dnl.dOU() != null) {
                    dnl.dOU().legoCard = null;
                }
                this.lDQ.getPbData().dnm();
            }
            com.baidu.tieba.tbadkCore.data.n dqy = this.lDQ.dqy();
            if (dqy != null && str.equals(dqy.getAdId())) {
                this.lDQ.dqz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lHY != null && this.lHY.isShowing()) {
                this.lHY.dismiss();
                this.lHY = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lHY != null) {
                            PbFragment.this.lHY.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lHU.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lIo);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lIo);
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
                this.lHY = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lHY.RU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf(int i) {
        by dmT;
        if (this.lDQ != null && this.lDQ.getPbData() != null && (dmT = this.lDQ.getPbData().dmT()) != null) {
            if (i == 1) {
                PraiseData boA = dmT.boA();
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
                        dmT.a(praiseData);
                    } else {
                        dmT.boA().getUser().add(0, metaData);
                        dmT.boA().setNum(dmT.boA().getNum() + 1);
                        dmT.boA().setIsLike(i);
                    }
                }
                if (dmT.boA() != null) {
                    if (dmT.boA().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.au.numFormatOver10000(dmT.boA().getNum());
                    }
                }
            } else if (dmT.boA() != null) {
                dmT.boA().setIsLike(i);
                dmT.boA().setNum(dmT.boA().getNum() - 1);
                ArrayList<MetaData> user = dmT.boA().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dmT.boA().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dmT.boA().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dmT.boA().getNum() + "";
                }
            }
            if (this.lDQ.dql()) {
                this.lHU.dst().notifyDataSetChanged();
            } else {
                this.lHU.t(this.lDQ.getPbData());
            }
        }
    }

    public static PbFragment doX() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lHn = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lDQ.aD(bundle);
        if (this.iSU != null) {
            this.iSU.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lIg.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lHv = System.currentTimeMillis();
        this.lIm = getPageContext();
        final Intent intent = this.lHn.getIntent();
        if (intent != null) {
            this.ivy = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lHD = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lHD)) {
                    this.lHD = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lHD)) {
                this.lHr = true;
            }
            this.lJh = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lJi = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lJj = intent.getStringExtra("key_manga_title");
            this.lIb = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lIc = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lId = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dpz()) {
                this.lHn.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.lIu = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lHM = new bh();
            this.lHM.C(intent);
            this.lIw = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lIw == 0) {
                this.lIw = intent.getIntExtra("key_start_from", 0);
            }
            this.lIx = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.ivy = System.currentTimeMillis();
        }
        this.fCb = this.lHv - this.ivy;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.lHt = 0;
        aC(bundle);
        if (this.lDQ.getPbData() != null) {
            this.lDQ.getPbData().PW(this.source);
        }
        dpa();
        if (intent != null && this.lHU != null) {
            this.lHU.lPa = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lIp == null) {
                    this.lIp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lHU.Qv(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.lIp, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lDQ.getPbData() != null) {
                this.lDQ.Qn(stringExtra);
            }
        }
        this.iSU = new VoiceManager();
        this.iSU.onCreate(getPageContext());
        initData(bundle);
        this.lIf = new com.baidu.tbadk.editortools.pb.g();
        d(this.lIf);
        this.lIg = (com.baidu.tbadk.editortools.pb.e) this.lIf.eN(getActivity());
        this.lIg.a(this.lHn.getPageContext());
        this.lIg.a(this.fwI);
        this.lIg.a(this.fwB);
        this.lIg.setFrom(1);
        this.lIg.a(this.lHn.getPageContext(), bundle);
        this.lIg.bCn().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lIg.bCn().ks(true);
        uM(true);
        this.lIg.a(this.lDQ.dqA(), this.lDQ.dqj(), this.lDQ.dqR());
        registerListener(this.lIC);
        if (!this.lDQ.dqr()) {
            this.lIg.DV(this.lDQ.dqj());
        }
        if (this.lDQ.dqS()) {
            this.lIg.DT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lHU != null) {
            this.lIg.DT(this.lHU.dsd());
        }
        registerListener(this.lIB);
        registerListener(this.lID);
        registerListener(this.lIE);
        registerListener(this.iUA);
        registerListener(this.lIQ);
        registerListener(this.lIA);
        this.lIe = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.nlh);
        this.lIe.dON();
        registerListener(this.lIF);
        registerListener(this.eTG);
        this.lDQ.dqK();
        registerListener(this.lIX);
        registerListener(this.iUI);
        registerListener(this.lIT);
        if (this.lHU != null && this.lHU.dtf() != null && this.lHU.dtg() != null) {
            this.lHq = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lHU.dtf(), this.lHU.dtg(), this.lHU.dsk());
            this.lHq.a(this.lIL);
        }
        if (this.lHp && this.lHU != null && this.lHU.dtg() != null) {
            this.lHU.dtg().setVisibility(8);
        }
        this.lIn = new com.baidu.tbadk.core.view.c();
        this.lIn.toastTime = 1000L;
        registerListener(this.lIP);
        registerListener(this.lIN);
        registerListener(this.lIO);
        registerListener(this.jqg);
        registerListener(this.iUw);
        this.lIG.setSelfListener(true);
        this.lIG.setTag(this.lHn.getUniqueId());
        this.lIG.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lIG);
        registerResponsedEventListener(TipEvent.class, this.iRY);
        this.lIo = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lIo;
        userMuteAddAndDelCustomMessage.setTag(this.lIo);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lIo;
        userMuteCheckCustomMessage.setTag(this.lIo);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lDQ.dqP().a(this.lIM);
        this.kNk = new bb();
        if (this.lIg.bCT() != null) {
            this.kNk.e(this.lIg.bCT().getInputView());
        }
        this.lIg.a(this.fwC);
        this.joK = new ShareSuccessReplyToServerModel();
        a(this.lIy);
        this.kJC = new com.baidu.tbadk.core.util.am(getPageContext());
        this.kJC.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.eTx) {
                        PbFragment.this.lIg.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.eTy && PbFragment.this.lHU != null && PbFragment.this.lHU.drZ() != null && PbFragment.this.lHU.drZ().doV() != null) {
                        PbFragment.this.lHU.drZ().doV().bDr();
                    } else if (i == com.baidu.tbadk.core.util.am.eTz) {
                        PbFragment.this.c(PbFragment.this.lIj);
                    }
                }
            }
        });
        this.lHR = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lHR.w(getUniqueId());
        com.baidu.tieba.t.c.dOe().z(getUniqueId());
        com.baidu.tbadk.core.business.a.bmh().dK("3", "");
        this.iko = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.lHv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lDQ != null) {
            gVar.setForumName(this.lDQ.dod());
            if (this.lDQ.getPbData() != null && this.lDQ.getPbData().getForum() != null) {
                gVar.a(this.lDQ.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lDQ);
        }
    }

    public String doY() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b doZ() {
        return this.lHq;
    }

    private void uM(boolean z) {
        this.lIg.kA(z);
        this.lIg.kB(z);
        this.lIg.kC(z);
    }

    private void dpa() {
        this.fgf = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iSU != null) {
            this.iSU.onStart(getPageContext());
        }
    }

    public az dpb() {
        return this.lHU;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dok() {
        return this.lDQ;
    }

    public void Qd(String str) {
        if (this.lDQ != null && !StringUtils.isNull(str) && this.lHU != null) {
            this.lHU.vB(true);
            this.lDQ.Qd(str);
            this.lHB = true;
            this.lHU.dsR();
            this.lHU.dta();
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
        this.lHt = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.lHt == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.iSU != null) {
            this.iSU.onPause(getPageContext());
        }
        if (this.lHU != null) {
            this.lHU.onPause();
        }
        if (!this.lDQ.dqr()) {
            this.lIg.DU(this.lDQ.dqj());
        }
        if (this.lDQ != null) {
            this.lDQ.dqL();
        }
        com.baidu.tbadk.BdToken.c.biD().biO();
        MessageManager.getInstance().unRegisterListener(this.jhb);
        cRw();
        MessageManager.getInstance().unRegisterListener(this.lIN);
        MessageManager.getInstance().unRegisterListener(this.lIO);
        MessageManager.getInstance().unRegisterListener(this.lIP);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean dpc() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lDQ.getPbData(), this.lDQ.dql(), this.lDQ.dqJ());
        return (a2 == null || a2.boP() == null || a2.boP().getGodUserData() == null || a2.boP().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bIA = false;
        super.onResume();
        if (this.lHF) {
            this.lHF = false;
            dpF();
        }
        if (dpc()) {
            this.lHy = System.currentTimeMillis();
        } else {
            this.lHy = -1L;
        }
        if (this.lHU != null && this.lHU.getView() != null) {
            if (!this.lcU) {
                dpx();
            } else {
                hideLoadingView(this.lHU.getView());
            }
            this.lHU.onResume();
        }
        if (this.lHt == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lHU != null) {
            noNetworkView = this.lHU.drW();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.iSU != null) {
            this.iSU.onResume(getPageContext());
        }
        registerListener(this.jhb);
        this.lIa = false;
        dpE();
        registerListener(this.lIN);
        registerListener(this.lIO);
        registerListener(this.lIP);
        if (this.iTI) {
            dpw();
            this.iTI = false;
        }
        dpM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lHU.vq(z);
        if (this.lHY != null) {
            this.lHY.dismiss();
        }
        if (z && this.lIa) {
            this.lHU.dsz();
            this.lDQ.va(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lHy > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10804").dY("obj_duration", (System.currentTimeMillis() - this.lHy) + ""));
            this.lHy = 0L;
        }
        if (dpb().drZ() != null) {
            dpb().drZ().onStop();
        }
        if (this.lHU.lPc != null && !this.lHU.lPc.dua()) {
            this.lHU.lPc.releaseResources();
        }
        if (this.lDQ != null && this.lDQ.getPbData() != null && this.lDQ.getPbData().getForum() != null && this.lDQ.getPbData().dmT() != null) {
            com.baidu.tbadk.distribute.a.bCa().b(getPageContext().getPageActivity(), "pb", this.lDQ.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lDQ.getPbData().dmT().getId(), 0L));
        }
        if (this.iSU != null) {
            this.iSU.onStop(getPageContext());
        }
        com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lHN);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.t.c.dOe().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13266");
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("fid", this.lDQ.getPbData().getForumId());
            arVar.dY("tid", this.lDQ.dqj());
            arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(arVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.lHw && this.lHU != null) {
            this.lHw = true;
            a(false, (PostData) null);
        }
        if (this.lDQ != null) {
            this.lDQ.cancelLoadData();
            this.lDQ.destory();
            if (this.lDQ.dqO() != null) {
                this.lDQ.dqO().onDestroy();
            }
        }
        if (this.lIg != null) {
            this.lIg.onDestroy();
        }
        if (this.fXb != null) {
            this.fXb.cancelLoadData();
        }
        if (this.fgf != null) {
            this.fgf.dOA();
        }
        if (this.lHU != null) {
            this.lHU.onDestroy();
            if (this.lHU.lPc != null) {
                this.lHU.lPc.releaseResources();
            }
        }
        if (this.lHx != null) {
            this.lHx.bFf();
        }
        if (this.lHq != null) {
            this.lHq.cEv();
        }
        super.onDestroy();
        if (this.iSU != null) {
            this.iSU.onDestory(getPageContext());
        }
        if (this.lHU != null) {
            this.lHU.dsR();
        }
        MessageManager.getInstance().unRegisterListener(this.lIN);
        MessageManager.getInstance().unRegisterListener(this.lIO);
        MessageManager.getInstance().unRegisterListener(this.lIP);
        MessageManager.getInstance().unRegisterListener(this.lIo);
        MessageManager.getInstance().unRegisterListener(this.lIQ);
        MessageManager.getInstance().unRegisterListener(this.iUI);
        MessageManager.getInstance().unRegisterListener(this.jqg);
        MessageManager.getInstance().unRegisterListener(this.lIV);
        MessageManager.getInstance().unRegisterListener(this.lIG);
        this.lIm = null;
        this.lIn = null;
        com.baidu.tieba.recapp.d.a.dFX().dGa();
        if (this.lIp != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lIp);
        }
        if (this.lHG != null) {
            this.lHG.cancelLoadData();
        }
        if (this.lHU != null && this.lHU.lPc != null) {
            this.lHU.lPc.due();
        }
        if (this.joK != null) {
            this.joK.cancelLoadData();
        }
        this.kNk.onDestroy();
        if (this.lDQ != null && this.lDQ.dqQ() != null) {
            this.lDQ.dqQ().onDestroy();
        }
        if (this.kJC != null) {
            this.kJC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dst;
        ArrayList<PostData> doG;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bxf() && this.lHU != null && (dst = this.lHU.dst()) != null && (doG = dst.doG()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = doG.iterator();
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
                        bVar.imE = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eKB == 1 && !TextUtils.isEmpty(id)) {
                    next.eKB = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.imE = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.lDQ == null || this.lDQ.getPbData() == null || this.lDQ.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.lDQ.getPbData().getForum().getFirst_class();
                    str2 = this.lDQ.getPbData().getForum().getSecond_class();
                    str = this.lDQ.getPbData().getForum().getId();
                    str4 = this.lDQ.dqj();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.bxi());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lHU.onChangeSkinType(i);
            if (this.lIg != null && this.lIg.bCn() != null) {
                this.lIg.bCn().onChangeSkinType(i);
            }
            if (this.lHU.drW() != null) {
                this.lHU.drW().onChangeSkinType(getPageContext(), i);
            }
            this.kNk.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.CAM_X0201));
            this.mSkinType = i;
            cCE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lHU = new az(this, this.iVH, this.fos);
        this.iXO = new com.baidu.tieba.g.b(getActivity());
        this.iXO.a(lJg);
        this.iXO.a(this.irM);
        this.lHU.setOnScrollListener(this.mOnScrollListener);
        this.lHU.d(this.lJb);
        this.lHU.setListPullRefreshListener(this.gcq);
        this.lHU.uy(com.baidu.tbadk.core.k.blV().isShowImages());
        this.lHU.setOnImageClickListener(this.fNk);
        this.lHU.b(this.mOnLongClickListener);
        this.lHU.g(this.iQf);
        this.lHU.a(this.lIZ);
        this.lHU.vq(this.mIsLogin);
        if (this.lHn.getIntent() != null) {
            this.lHU.vC(this.lHn.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lHU.drY().setFromForumId(this.lDQ.getFromForumId());
        this.lHU.setEditorTools(this.lIg.bCn());
        this.lIg.DT(this.lHU.dsd());
        this.lHU.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lDQ.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDQ.getPbData().getForum().getId(), PbFragment.this.lDQ.getPbData().getForum().getName(), PbFragment.this.lDQ.getPbData().dmT().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lHU.vD(this.lDQ.dqo());
        this.lHU.Hq(this.lDQ.dqU());
        return this.lHU.getView();
    }

    public void dpd() {
        if (this.lHU != null && this.lDQ != null) {
            if ((this.lDQ.getPbData() != null || this.lDQ.getPbData().dnt() != null) && checkUpIsLogin() && this.lHU.dst() != null && this.lHU.dst().doL() != null) {
                this.lHU.dst().doL().CB(this.lDQ.dqj());
            }
        }
    }

    public void dpe() {
        TiebaStatic.log("c12181");
        if (this.lHU != null && this.lDQ != null) {
            if ((this.lHU == null || this.lHU.dsc()) && this.lDQ.getPbData() != null && this.lDQ.getPbData().dnt() != null) {
                com.baidu.tieba.pb.data.o dnt = this.lDQ.getPbData().dnt();
                if (checkUpIsLogin()) {
                    if ((!dnt.dnO() || dnt.bqs() != 2) && this.lHU.dst() != null && this.lHU.dst().doL() != null) {
                        this.lHU.dst().doL().CB(this.lDQ.dqj());
                    }
                    if (System.currentTimeMillis() - this.lHA > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).wm(false);
                        this.lHA = System.currentTimeMillis();
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
                    if (this.lDQ == null || this.lDQ.getPbData() == null) {
                        return true;
                    }
                    if (dpb().drZ() != null) {
                        dpb().drZ().doR();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.lDQ.getPbData().getForum());
                    pVar.setThreadData(this.lDQ.getPbData().dmT());
                    pVar.g(postData);
                    dpb().drY().d(pVar);
                    dpb().drY().setPostId(postData.getId());
                    a(view, postData.boP().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lIg != null) {
                        this.lHU.vw(this.lIg.bDb());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void dpf() {
        if (this.lHu == null) {
            this.lHu = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lHu.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lDM = PbFragment.this.lDM.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDM);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lDQ.dqj(), PbFragment.this.lDM, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lDM = PbFragment.this.lDM.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDM);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lDQ.dqj(), PbFragment.this.lDM, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lDM = PbFragment.this.lDM.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lDM);
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
        this.lIW.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).dwg(), "", 1);
    }

    private void aC(Bundle bundle) {
        this.lDQ = this.lHn.dok();
        if (this.lDQ.dqN() != null) {
            this.lDQ.dqN().a(this.lGr);
        }
        if (this.lDQ.dqO() != null) {
            this.lDQ.dqO().b(this.lIz);
        }
        if (StringUtils.isNull(this.lDQ.dqj())) {
            this.lHn.finish();
        } else if ("from_tieba_kuang".equals(this.lHD) && this.lHD != null) {
            this.lDQ.Hq(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lHS = com.baidu.tbadk.baseEditMark.a.a(this.lHn);
        if (this.lHS != null) {
            this.lHS.a(this.lIY);
        }
        this.fXb = new ForumManageModel(this.lHn);
        this.fXb.setLoadDataCallBack(this.ikt);
        this.eTC = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lIK.setUniqueId(getUniqueId());
        this.lIK.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lHU.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lIo;
        userMuteCheckCustomMessage.setTag(this.lIo);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c14000").dY("tid", this.lDQ.lLh).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.HE(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lHo ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    private boolean dpg() {
        if (this.lDQ == null || this.lDQ.getPbData() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.lDQ.getPbData().dmT()) || AntiHelper.a(getPageContext(), this.lDQ.getPbData().getAnti());
    }

    public void dph() {
        if (checkUpIsLogin() && this.lDQ != null && this.lDQ.getPbData() != null && this.lDQ.getPbData().getForum() != null && !dpg()) {
            if (this.lDQ.getPbData().dnx()) {
                this.lHU.cQX();
                return;
            }
            if (this.iXo == null) {
                this.iXo = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iXo.Bo(0);
                this.iXo.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qi(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qj(boolean z) {
                        if (z) {
                            if (PbFragment.this.lIg != null && PbFragment.this.lIg.bCn() != null) {
                                PbFragment.this.lIg.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lHU.cQX();
                        }
                    }
                });
            }
            this.iXo.G(this.lDQ.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lDQ.dqj(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpi() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lDQ == null || (pbData = this.lDQ.getPbData()) == null) {
            return null;
        }
        return pbData.dnh().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmT() != null) {
            if (fVar.dmT().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dmT().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dmT().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dpg() && dpj()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lHI);
                this.lHJ = ((View) view.getParent()).getMeasuredHeight();
            }
            if (dpb().drZ() != null && postData != null) {
                String str3 = "";
                if (postData.dPi() != null) {
                    str3 = postData.dPi().toString();
                }
                dpb().drZ().Qb(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.boP().getName_show(), str3));
            }
            if (this.lDQ.getPbData() != null && this.lDQ.getPbData().dnx()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.lHn.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.dpb().getListView().smoothScrollBy((PbFragment.this.lHI[1] + PbFragment.this.lHJ) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dpb().drZ() != null) {
                            PbFragment.this.lIg.bCn().setVisibility(8);
                            PbFragment.this.dpb().drZ().h(str, str2, PbFragment.this.dpb().dsd(), (PbFragment.this.lDQ == null || PbFragment.this.lDQ.getPbData() == null || PbFragment.this.lDQ.getPbData().dmT() == null || !PbFragment.this.lDQ.getPbData().dmT().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doV = PbFragment.this.dpb().drZ().doV();
                            if (doV != null && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                                doV.a(PbFragment.this.lDQ.getPbData().getAnti());
                                doV.setThreadData(PbFragment.this.lDQ.getPbData().dmT());
                            }
                            if (PbFragment.this.kNk.dtu() == null && PbFragment.this.dpb().drZ().doV().bDz() != null) {
                                PbFragment.this.dpb().drZ().doV().bDz().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kNk != null && PbFragment.this.kNk.dtt() != null) {
                                            if (!PbFragment.this.kNk.dtt().dYp()) {
                                                PbFragment.this.kNk.vF(false);
                                            }
                                            PbFragment.this.kNk.dtt().zc(false);
                                        }
                                    }
                                });
                                PbFragment.this.kNk.f(PbFragment.this.dpb().drZ().doV().bDz().getInputView());
                                PbFragment.this.dpb().drZ().doV().a(PbFragment.this.lIl);
                            }
                        }
                        PbFragment.this.dpb().dta();
                    }
                }, 0L);
                return;
            }
            if (this.lIi == null) {
                this.lIi = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lIi.Bo(1);
                this.lIi.a(new AnonymousClass39(str, str2));
            }
            if (this.lDQ != null && this.lDQ.getPbData() != null && this.lDQ.getPbData().getForum() != null) {
                this.lIi.G(this.lDQ.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lDQ.dqj(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lJq;
        final /* synthetic */ String lJr;

        AnonymousClass39(String str, String str2) {
            this.lJq = str;
            this.lJr = str2;
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
                        PbFragment.this.dpb().getListView().smoothScrollBy((PbFragment.this.lHI[1] + PbFragment.this.lHJ) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dpb().drZ() != null) {
                            PbFragment.this.lIg.bCn().setVisibility(8);
                            PbFragment.this.dpb().drZ().h(AnonymousClass39.this.lJq, AnonymousClass39.this.lJr, PbFragment.this.dpb().dsd(), (PbFragment.this.lDQ == null || PbFragment.this.lDQ.getPbData() == null || PbFragment.this.lDQ.getPbData().dmT() == null || !PbFragment.this.lDQ.getPbData().dmT().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doV = PbFragment.this.dpb().drZ().doV();
                            if (doV != null && PbFragment.this.lDQ != null && PbFragment.this.lDQ.getPbData() != null) {
                                doV.a(PbFragment.this.lDQ.getPbData().getAnti());
                                doV.setThreadData(PbFragment.this.lDQ.getPbData().dmT());
                            }
                            if (PbFragment.this.kNk.dtu() == null && PbFragment.this.dpb().drZ().doV().bDz() != null) {
                                PbFragment.this.dpb().drZ().doV().bDz().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kNk != null && PbFragment.this.kNk.dtt() != null) {
                                            if (!PbFragment.this.kNk.dtt().dYp()) {
                                                PbFragment.this.kNk.vF(false);
                                            }
                                            PbFragment.this.kNk.dtt().zc(false);
                                        }
                                    }
                                });
                                PbFragment.this.kNk.f(PbFragment.this.dpb().drZ().doV().bDz().getInputView());
                                PbFragment.this.dpb().drZ().doV().a(PbFragment.this.lIl);
                            }
                        }
                        PbFragment.this.dpb().dta();
                    }
                }, 0L);
            }
        }
    }

    public boolean dpj() {
        if ((this.lDQ.getPbData() != null && this.lDQ.getPbData().dnx()) || this.kJC == null || this.lDQ.getPbData() == null || this.lDQ.getPbData().getAnti() == null) {
            return true;
        }
        return this.kJC.pP(this.lDQ.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Hd(int i) {
        if (this.kJC == null || this.lDQ.getPbData() == null || this.lDQ.getPbData().getAnti() == null) {
            return true;
        }
        return this.kJC.aQ(this.lDQ.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lDQ != null && this.lDQ.getPbData() != null && postData.dPg() != 1) {
            String dqj = this.lDQ.dqj();
            String id = postData.getId();
            int i = 0;
            if (this.lDQ.getPbData() != null) {
                i = this.lDQ.getPbData().dni();
            }
            PbActivity.a Qh = Qh(id);
            if (Qh != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dqj, id, "pb", true, null, false, null, i, postData.duY(), this.lDQ.getPbData().getAnti(), false, postData.boP() != null ? postData.boP().getIconInfo() : null).addBigImageData(Qh.lDY, Qh.eCN, Qh.eCL, Qh.index);
                addBigImageData.setKeyPageStartFrom(this.lDQ.dqU());
                addBigImageData.setFromFrsForumId(this.lDQ.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lDQ.getForumId());
                addBigImageData.setBjhData(this.lDQ.dqt());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dpk() {
        if (this.lDQ.getPbData() == null || this.lDQ.getPbData().dmT() == null) {
            return -1;
        }
        return this.lDQ.getPbData().dmT().bpC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dok() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dok().Qm(postWriteCallBackData.getPostId());
            this.lIt = this.lHU.dsf();
            this.lDQ.dg(this.lIt, this.lHU.dsg());
        }
        this.lHU.dsR();
        this.kNk.dtr();
        if (this.lIg != null) {
            this.lHU.vw(this.lIg.bDb());
        }
        this.lHU.drX();
        this.lHU.vy(true);
        this.lDQ.dqF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(boolean z) {
        if (this.lDQ != null && this.lDQ.lEN != null && this.lDQ.lEN.dmT() != null) {
            by dmT = this.lDQ.lEN.dmT();
            dmT.mRecomAbTag = this.lDQ.drf();
            dmT.mRecomWeight = this.lDQ.drd();
            dmT.mRecomSource = this.lDQ.dre();
            dmT.mRecomExtra = this.lDQ.drg();
            if (dmT.getFid() == 0) {
                dmT.setFid(com.baidu.adp.lib.f.b.toLong(this.lDQ.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmT, "c13563");
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
    public void dpl() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.SQ(this.lDQ.getForumId()) && this.lDQ.getPbData() != null && this.lDQ.getPbData().getForum() != null) {
            if (this.lDQ.getPbData().getForum().isLike() == 1) {
                this.lDQ.dqQ().gn(this.lDQ.getForumId(), this.lDQ.dqj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uO(boolean z) {
        if (this.lDQ == null || this.lDQ.getPbData() == null) {
            return false;
        }
        return ((this.lDQ.getPbData().dni() != 0) || this.lDQ.getPbData().dmT() == null || this.lDQ.getPbData().dmT().boP() == null || TextUtils.equals(this.lDQ.getPbData().dmT().boP().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean uP(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ac acVar;
        if (this.lDQ == null || this.lDQ.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lDQ.getPbData();
        if (pbData.getUserData() == null || !pbData.getUserData().isForumBusinessAccount() || com.baidu.tieba.frs.ax.isOn()) {
            by dmT = pbData.dmT();
            if (dmT != null) {
                if (dmT.bnx() || dmT.bny()) {
                    return false;
                }
                if (dmT.bqM() || dmT.bqN()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dni() != 0) {
                    return pbData.dni() != 3;
                }
                List<bu> dnq = pbData.dnq();
                if (com.baidu.tbadk.core.util.y.getCount(dnq) > 0) {
                    for (bu buVar : dnq) {
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
        if (z || this.lDQ == null || this.lDQ.getPbData() == null) {
            return false;
        }
        return ((this.lDQ.getPbData().getForum() != null && this.lDQ.getPbData().getForum().isBlockBawuDelete) || this.lDQ.getPbData().dni() == 0 || this.lDQ.getPbData().dni() == 3) ? false : true;
    }

    public void dpm() {
        com.baidu.tieba.pb.data.f pbData;
        by dmT;
        boolean z = true;
        if (this.lDQ != null && this.lDQ.getPbData() != null && (dmT = (pbData = this.lDQ.getPbData()).dmT()) != null && dmT.boP() != null) {
            this.lHU.drX();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dmT.boP().getUserId());
            ak akVar = new ak();
            int dni = this.lDQ.getPbData().dni();
            if (dni == 1 || dni == 3) {
                akVar.lNq = true;
                akVar.lNp = true;
                akVar.lNv = dmT.boK() == 1;
                akVar.lNu = dmT.boL() == 1;
            } else {
                akVar.lNq = false;
                akVar.lNp = false;
            }
            if (dni == 1002 && !equals) {
                akVar.lNw = true;
            }
            akVar.lNn = uP(equals);
            akVar.lNr = dpn();
            akVar.lNo = uQ(equals);
            akVar.FT = this.lDQ.dql();
            akVar.lNk = true;
            akVar.lNj = uO(equals);
            akVar.lNi = equals && this.lHU.dsG();
            akVar.lNt = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.lNs = true;
            akVar.isHostOnly = this.lDQ.getHostMode();
            akVar.lNm = true;
            if (dmT.bph() == null) {
                akVar.lNl = true;
            } else {
                akVar.lNl = false;
            }
            if (pbData.dnx()) {
                akVar.lNk = false;
                akVar.lNm = false;
                akVar.lNl = false;
                akVar.lNp = false;
                akVar.lNq = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dnx()) {
                z = false;
            }
            akVar.lNx = z;
            this.lHU.lPc.a(akVar);
        }
    }

    private boolean dpn() {
        if (this.lDQ != null && this.lDQ.dql()) {
            return this.lDQ.getPageData() == null || this.lDQ.getPageData().bnG() != 0;
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
    public PbModel.a dpo() {
        return this.lIW;
    }

    public int dpp() {
        if (dpb() == null || dpb().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dpb().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).Wv == com.baidu.tieba.pb.data.n.lCb) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dpq() {
        if (dpb() == null || dpb().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dpb().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.nlH) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dpw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpr() {
        if (this.lDQ != null && this.lDQ.lEN != null && this.lDQ.lEN.dmT() != null) {
            by dmT = this.lDQ.lEN.dmT();
            dmT.mRecomAbTag = this.lDQ.drf();
            dmT.mRecomWeight = this.lDQ.drd();
            dmT.mRecomSource = this.lDQ.dre();
            dmT.mRecomExtra = this.lDQ.drg();
            dmT.eMG = this.lDQ.dqr();
            if (dmT.getFid() == 0) {
                dmT.setFid(com.baidu.adp.lib.f.b.toLong(this.lDQ.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmT, "c13562");
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
                    PbFragment.this.eTC.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lDQ.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).brv();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lHU.dsA();
        this.lDQ.vc(z);
        if (this.lHS != null) {
            this.lHS.iH(z);
            if (markData != null) {
                this.lHS.a(markData);
            }
        }
        if (this.lDQ.bkY()) {
            dpu();
        } else {
            this.lHU.s(this.lDQ.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GT(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qe(String str) {
        if (this.lDQ != null && this.lDQ.getPbData() != null && this.lDQ.getPbData().dnx()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lDQ.dqj(), str);
            by dmT = this.lDQ.getPbData().dmT();
            if (dmT.bnx()) {
                format = format + "&channelid=33833";
            } else if (dmT.bqL()) {
                format = format + "&channelid=33842";
            } else if (dmT.bny()) {
                format = format + "&channelid=33840";
            }
            Qf(format);
            return;
        }
        this.lHR.QF(str);
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
                if (!this.lDQ.dqr()) {
                    antiData.setBlock_forum_name(this.lDQ.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lDQ.getPbData().getForum().getId());
                    antiData.setUser_name(this.lDQ.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lDQ.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (dpb() != null) {
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
            this.lHU.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.noI) ? bVar.noI : getString(R.string.delete_fail);
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
                this.lHU.a(0, bVar.mSuccess, bVar.noI, z);
            }
            if (bVar.mSuccess) {
                if (bVar.izO == 1) {
                    ArrayList<PostData> dmV = this.lDQ.getPbData().dmV();
                    int size = dmV.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dmV.get(i).getId())) {
                            i++;
                        } else {
                            dmV.remove(i);
                            break;
                        }
                    }
                    this.lDQ.getPbData().dmT().oD(this.lDQ.getPbData().dmT().boG() - 1);
                    this.lHU.s(this.lDQ.getPbData());
                } else if (bVar.izO == 0) {
                    dps();
                } else if (bVar.izO == 2) {
                    ArrayList<PostData> dmV2 = this.lDQ.getPbData().dmV();
                    int size2 = dmV2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dmV2.get(i2).dPd().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dmV2.get(i2).dPd().get(i3).getId())) {
                                i3++;
                            } else {
                                dmV2.get(i2).dPd().remove(i3);
                                dmV2.get(i2).dPf();
                                z2 = true;
                                break;
                            }
                        }
                        dmV2.get(i2).TG(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lHU.s(this.lDQ.getPbData());
                    }
                    a(bVar, this.lHU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.lHU.a(this.fXb.getLoadDataMode(), gVar.mSuccess, gVar.noI, false);
            if (gVar.mSuccess) {
                this.lHV = true;
                if (i == 2 || i == 3) {
                    this.lHW = true;
                    this.lHX = false;
                } else if (i == 4 || i == 5) {
                    this.lHW = false;
                    this.lHX = true;
                }
                if (i == 2) {
                    this.lDQ.getPbData().dmT().oG(1);
                    this.lDQ.setIsGood(1);
                } else if (i == 3) {
                    this.lDQ.getPbData().dmT().oG(0);
                    this.lDQ.setIsGood(0);
                } else if (i == 4) {
                    this.lDQ.getPbData().dmT().oF(1);
                    this.lDQ.Hi(1);
                } else if (i == 5) {
                    this.lDQ.getPbData().dmT().oF(0);
                    this.lDQ.Hi(0);
                }
                this.lHU.c(this.lDQ.getPbData(), this.lDQ.dql());
            }
        }
    }

    private void dps() {
        if (this.lDQ.dqm() || this.lDQ.dqo()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lDQ.dqj());
            PbActivity pbActivity = this.lHn;
            PbActivity pbActivity2 = this.lHn;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lDQ.dqj()));
        if (dpv()) {
            this.lHn.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dox() {
        this.lHn.dox();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dnf;
        boolean z = false;
        if (this.lHU != null) {
            this.lHU.dsR();
        }
        if (this.lDQ != null && this.lDQ.getPbData() != null && !this.lDQ.getPbData().dnx()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lDQ.getPbData().dmT().getId();
            if (this.lDQ.isShareThread() && this.lDQ.getPbData().dmT().eLH != null) {
                historyMessage.threadName = this.lDQ.getPbData().dmT().eLH.showText;
            } else {
                historyMessage.threadName = this.lDQ.getPbData().dmT().getTitle();
            }
            if (this.lDQ.isShareThread() && !doc()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lDQ.getPbData().getForum().getName();
            }
            ArrayList<PostData> dmV = this.lDQ.getPbData().dmV();
            int dsC = this.lHU != null ? this.lHU.dsC() : 0;
            if (dmV != null && dsC >= 0 && dsC < dmV.size()) {
                historyMessage.postID = dmV.get(dsC).getId();
            }
            historyMessage.isHostOnly = this.lDQ.getHostMode();
            historyMessage.isSquence = this.lDQ.dql();
            historyMessage.isShareThread = this.lDQ.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lIg != null) {
            this.lIg.onDestroy();
        }
        if (this.lHs && dpb() != null) {
            dpb().dtk();
        }
        if (this.lDQ != null && (this.lDQ.dqm() || this.lDQ.dqo())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lDQ.dqj());
            if (this.lHV) {
                if (this.lHX) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lDQ.cuT());
                }
                if (this.lHW) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lDQ.getIsGood());
                }
            }
            if (this.lDQ.getPbData() != null && System.currentTimeMillis() - this.lHv >= 40000 && (dnf = this.lDQ.getPbData().dnf()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dnf.getDataList())) {
                intent.putExtra("guess_like_data", dnf);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lIu);
            }
            PbActivity pbActivity = this.lHn;
            PbActivity pbActivity2 = this.lHn;
            pbActivity.setResult(-1, intent);
        }
        if (dpv()) {
            if (this.lDQ != null && this.lHU != null && this.lHU.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lDQ.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dnb() && !this.lHB && pbData.lAL == null) {
                        as drI = as.drI();
                        com.baidu.tieba.pb.data.f dqu = this.lDQ.dqu();
                        Parcelable onSaveInstanceState = this.lHU.getListView().onSaveInstanceState();
                        boolean dql = this.lDQ.dql();
                        boolean hostMode = this.lDQ.getHostMode();
                        if (this.lHU.dsk() != null && this.lHU.dsk().getVisibility() == 0) {
                            z = true;
                        }
                        drI.a(dqu, onSaveInstanceState, dql, hostMode, z);
                        if (this.lIt >= 0 || this.lDQ.dqW() != null) {
                            as.drI().q(this.lDQ.dqW());
                            as.drI().p(this.lDQ.dqX());
                            as.drI().Hs(this.lDQ.dqY());
                        }
                    }
                }
            } else {
                as.drI().reset();
            }
            dox();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lHU == null || !this.lHU.Hy(i)) ? false : true;
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
        PbActivity pbActivity = this.lHn;
        if (i == 0) {
            this.lHU.drX();
            this.lHU.drZ().doR();
            this.lHU.vy(false);
        }
        this.lHU.dsb();
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
                        this.lIg.resetData();
                        this.lIg.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lIg.b(writeData);
                        com.baidu.tbadk.editortools.m sj = this.lIg.bCn().sj(6);
                        if (sj != null && sj.fub != null) {
                            sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lHn;
                        if (i == -1) {
                            this.lIg.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lHU.drZ() != null && this.lHU.drZ().doV() != null) {
                            com.baidu.tbadk.editortools.pb.h doV = this.lHU.drZ().doV();
                            doV.setThreadData(this.lDQ.getPbData().dmT());
                            doV.b(writeData);
                            doV.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m sj2 = doV.bCn().sj(6);
                            if (sj2 != null && sj2.fub != null) {
                                sj2.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lHn;
                            if (i == -1) {
                                doV.bDr();
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
        this.lIg.onActivityResult(i, i2, intent);
        if (this.lHG != null) {
            this.lHG.onActivityResult(i, i2, intent);
        }
        if (dpb().drZ() != null) {
            dpb().drZ().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dpt();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.drI().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lDQ != null) {
                                PbFragment.this.lDQ.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.p.a.dEK().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lDQ != null) {
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
                        com.baidu.tieba.p.a.dEK().F(getPageContext());
                        dpl();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.joK != null && shareItem != null && shareItem.linkUrl != null) {
                            this.joK.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
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
                    this.lHU.uD(false);
                    if (this.lDQ.getPbData() != null && this.lDQ.getPbData().dmT() != null && this.lDQ.getPbData().dmT().bpk() != null) {
                        this.lDQ.getPbData().dmT().bpk().setStatus(2);
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
                        this.lIj = emotionImageData;
                        if (Hd(com.baidu.tbadk.core.util.am.eTz)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lHH != null) {
                        this.lHU.dE(this.lHH);
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
            if (this.lHG == null) {
                this.lHG = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lHn);
                this.lHG.b(this.fwB);
                this.lHG.c(this.fwI);
            }
            this.lHG.a(emotionImageData, dok(), dok().getPbData());
        }
    }

    private void S(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpt() {
        MarkData Hp;
        if (this.lHS != null) {
            if (this.lDQ.getPbData() != null && this.lDQ.getPbData().dnx()) {
                Hp = this.lDQ.Hp(0);
            } else {
                Hp = this.lDQ.Hp(this.lHU.dsD());
            }
            if (Hp != null) {
                if (!Hp.isApp() || (Hp = this.lDQ.Hp(this.lHU.dsD() + 1)) != null) {
                    this.lHU.dsy();
                    this.lHS.a(Hp);
                    if (!this.lHS.bkY()) {
                        this.lHS.bla();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lHS.bkZ();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpu() {
        com.baidu.tieba.pb.data.f pbData = this.lDQ.getPbData();
        this.lDQ.vc(true);
        if (this.lHS != null) {
            pbData.PV(this.lHS.bkX());
        }
        this.lHU.s(pbData);
    }

    private boolean dpv() {
        if (this.lDQ == null) {
            return true;
        }
        if (this.lDQ.getPbData() == null || !this.lDQ.getPbData().dnx()) {
            if (this.lDQ.bkY()) {
                final MarkData dqE = this.lDQ.dqE();
                if (dqE == null || !this.lDQ.getIsFromMark()) {
                    return true;
                }
                final MarkData Hp = this.lDQ.Hp(this.lHU.dsC());
                if (Hp == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dqE);
                    this.lHn.setResult(-1, intent);
                    return true;
                } else if (Hp.getPostId() == null || Hp.getPostId().equals(dqE.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dqE);
                    this.lHn.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.Bq(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lHS != null) {
                                if (PbFragment.this.lHS.bkY()) {
                                    PbFragment.this.lHS.bkZ();
                                    PbFragment.this.lHS.iH(false);
                                }
                                PbFragment.this.lHS.a(Hp);
                                PbFragment.this.lHS.iH(true);
                                PbFragment.this.lHS.bla();
                            }
                            dqE.setPostId(Hp.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqE);
                            PbFragment.this.lHn.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dox();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqE);
                            PbFragment.this.lHn.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dox();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lHU != null && PbFragment.this.lHU.getView() != null) {
                                PbFragment.this.lHU.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dqE);
                                PbFragment.this.lHn.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.dox();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.brv();
                    return false;
                }
            } else if (this.lDQ.getPbData() == null || this.lDQ.getPbData().dmV() == null || this.lDQ.getPbData().dmV().size() <= 0 || !this.lDQ.getIsFromMark()) {
                return true;
            } else {
                this.lHn.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.lHU == null) {
            return null;
        }
        return this.lHU.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bJm() {
        if (this.lHU == null) {
            return 0;
        }
        return this.lHU.dsP();
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
                /* renamed from: cwK */
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
                /* renamed from: dpT */
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
                    ((PlayVoiceBntNew) view).ccz();
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
            /* renamed from: dpU */
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
        this.lHz = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (be.Qw(str) && this.lDQ != null && this.lDQ.dqj() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").al("obj_param1", 1).dY("post_id", this.lDQ.dqj()));
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
            be.dtw().f(getPageContext(), str);
        }
        this.lHz = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
        be.dtw().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lHz = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void az(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.lHU != null && this.lHU.dtf() != null && rect.top <= this.lHU.dtf().getHeight()) {
            rect.top += this.lHU.dtf().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lDQ.getPbData();
            TbRichText bz = bz(str, i);
            if (bz != null && (tbRichTextData = bz.bIC().get(this.lJc)) != null) {
                aVar.postId = String.valueOf(bz.getPostId());
                aVar.lDY = new ArrayList<>();
                aVar.eCN = new ConcurrentHashMap<>();
                if (!tbRichTextData.bII().bIV()) {
                    aVar.lDZ = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lDY.add(c2);
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
                    imageUrlData.mIsReserver = this.lDQ.dqC();
                    imageUrlData.mIsSeeHost = this.lDQ.getHostMode();
                    aVar.eCN.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dmT() != null) {
                            aVar.threadId = pbData.dmT().getId();
                        }
                        aVar.eCL = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lDZ = true;
                int size = pbData.dmV().size();
                this.lJd = false;
                aVar.index = -1;
                int a2 = pbData.dnc() != null ? a(pbData.dnc().dPi(), bz, i, i, aVar.lDY, aVar.eCN) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dmV().get(i2);
                    if (postData.getId() == null || pbData.dnc() == null || pbData.dnc().getId() == null || !postData.getId().equals(pbData.dnc().getId())) {
                        a2 = a(postData.dPi(), bz, a2, i, aVar.lDY, aVar.eCN);
                    }
                }
                if (aVar.lDY.size() > 0) {
                    aVar.lastId = aVar.lDY.get(aVar.lDY.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dmT() != null) {
                        aVar.threadId = pbData.dmT().getId();
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
            this.lJd = true;
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
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lDQ.dqj(), -1L);
                                imageUrlData.mIsReserver = this.lDQ.dqC();
                                imageUrlData.mIsSeeHost = this.lDQ.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lJd) {
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
        PostData dnc;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lDQ.boX())) {
                z = true;
            }
            MarkData o = this.lDQ.o(postData);
            if (this.lDQ.getPbData() != null && this.lDQ.getPbData().dnx() && (dnc = dnc()) != null) {
                o = this.lDQ.o(dnc);
            }
            if (o != null) {
                this.lHU.dsy();
                if (this.lHS != null) {
                    this.lHS.a(o);
                    if (!z) {
                        this.lHS.bla();
                    } else {
                        this.lHS.bkZ();
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
        if (this.lHU != null) {
            if (this.lHU.dqb()) {
                return true;
            }
            this.lHU.dtn();
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
                    this.lIq = ((TbImageView) view).getBdImage();
                    this.lIr = ((TbImageView) view).getUrl();
                    if (this.lIq == null || TextUtils.isEmpty(this.lIr)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lIs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lIs = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lIq = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lIr = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lIs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lIs = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lIq = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lIr = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lIs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lIs = null;
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
                    this.lHU.a(this.lJf, this.lIq.isGif());
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
        this.jZd = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.jZd == null) {
            return true;
        }
        if (this.jZd.dPg() == 1 && dy(view)) {
            this.lHU.a(this.lJf, this.lIq.isGif());
            return true;
        } else if (this.lHS == null) {
            return true;
        } else {
            if (!this.lHS.bkY() || this.jZd.getId() == null || !this.jZd.getId().equals(this.lDQ.boX())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = dok().getPbData() != null && dok().getPbData().dnx();
            if (this.jZd.dPg() == 1) {
                if (!z3) {
                    this.lHU.a(this.lJe, z, false);
                }
                return true;
            }
            if (this.lHZ == null) {
                this.lHZ = new com.baidu.tbadk.core.dialog.k(getContext());
                this.lHZ.a(this.lIR);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = dy(view) && !z3;
                boolean z5 = (!dy(view) || this.lIq == null || this.lIq.isGif()) ? false : true;
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
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.save_to_emotion), this.lHZ));
                }
                if (z5) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.save_to_local), this.lHZ));
                }
                if (!z4 && !z5) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, getString(R.string.copy), this.lHZ);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.jZd);
                    gVar2.eNK.setTag(sparseArray3);
                    arrayList.add(gVar2);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.remove_mark), this.lHZ);
                    } else {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.mark), this.lHZ);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.jZd);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar.eNK.setTag(sparseArray4);
                    arrayList.add(gVar);
                }
                if (this.mIsLogin && !this.lHP) {
                    if (!z8 && z7) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.mute_option), this.lHZ);
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
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.report_text), this.lHZ);
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
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lHZ);
                            gVar6.eNK.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar5 = new com.baidu.tbadk.core.dialog.g(7, getString(R.string.bar_manager), this.lHZ);
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
                        if (this.lDQ.getPbData().dni() == 1002 && !z6) {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.report_text), this.lHZ);
                        } else {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lHZ);
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
                    list = com.baidu.tieba.pb.pb.main.d.a.fs(com.baidu.tieba.pb.pb.main.d.a.v(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.jZd.bqI(), sparseArray2, this.lHZ), this.lHo));
                    this.lHZ.a(com.baidu.tieba.pb.pb.main.d.a.t(this.jZd));
                } else {
                    list = arrayList;
                }
                this.lHZ.k(list, true);
                this.lHY = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.lHZ);
                this.lHY.RU();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13272").dY("tid", this.lDQ.lLh).dY("fid", this.lDQ.getForumId()).dY("uid", this.lDQ.getPbData().dmT().boP().getUserId()).dY("post_id", this.lDQ.bCP()).al("obj_source", z2 ? 2 : 1));
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
        if (this.lDQ == null || this.lDQ.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lDQ.getPbData();
        if (pbData.dnc() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dnc());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dmV = pbData.dmV();
            c(pbData, dmV);
            return c(dmV, str, i);
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
            if (dok() != null) {
                dVar.eEN = dok().dqU();
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
                if (this.lDQ == null && this.lDQ.getPbData() != null) {
                    this.eXx.a(dpQ(), dVar, agreeData, this.lDQ.getPbData().dmT());
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
            if (this.lDQ == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dnh() != null && fVar.dnh().lCq != null && (list = fVar.dnh().lCq) != null && arrayList != null) {
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
            TbRichText dPi = arrayList.get(i2).dPi();
            if (dPi != null && (bIC = dPi.bIC()) != null) {
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
                            this.lJc = i4;
                            return dPi;
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
            this.lDM = str;
            if (this.lHu == null) {
                dpf();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lHu.getItemView(1).setVisibility(8);
            } else {
                this.lHu.getItemView(1).setVisibility(0);
            }
            this.lHu.brx();
            this.lHz = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iSU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpw() {
        hideNetRefreshView(this.lHU.getView());
        dpx();
        if (this.lDQ.dqx()) {
            this.lHU.dsy();
        }
        this.lHU.dsJ();
    }

    private void dpx() {
        showLoadingView(this.lHU.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lHU.dtf().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCE() {
        if (this.iSU != null) {
            this.iSU.stopPlay();
        }
        if (this.lHn != null) {
            this.lHn.cCE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf(int i) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, dpk(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bJr() {
        if (this.fQs == null) {
            this.fQs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpV */
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

    public void cCF() {
        if (this.lHn != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.lHn.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lHn.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cBe() {
        if (this.lDQ == null || this.lDQ.getPbData() == null) {
            return null;
        }
        return this.lDQ.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.lQq)).intValue();
            if (intValue == az.lQr) {
                if (!this.fXb.dQb()) {
                    this.lHU.dsv();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.fXb.TT(com.baidu.tbadk.core.util.au.S(jSONArray));
                    }
                    this.fXb.a(this.lDQ.getPbData().getForum().getId(), this.lDQ.getPbData().getForum().getName(), this.lDQ.getPbData().dmT().getId(), str, intValue3, intValue2, booleanValue, this.lDQ.getPbData().dmT().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.lQs || intValue == az.lQu) {
                if (this.lDQ.dqN() != null) {
                    this.lDQ.dqN().GY(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.lQs) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lIo);
        userMuteAddAndDelCustomMessage.setTag(this.lIo);
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
        this.lIa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpy() {
        ArrayList<PostData> dmV;
        int count;
        if (this.lDQ == null || this.lDQ.getPbData() == null || this.lDQ.getPbData().dmV() == null || (count = com.baidu.tbadk.core.util.y.getCount((dmV = this.lDQ.getPbData().dmV()))) == 0) {
            return "";
        }
        if (this.lDQ.dqC()) {
            Iterator<PostData> it = dmV.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dPg() == 1) {
                    return next.getId();
                }
            }
        }
        int dsC = this.lHU.dsC();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dmV, dsC);
        if (postData == null || postData.boP() == null) {
            return "";
        }
        if (this.lDQ.Qk(postData.boP().getUserId())) {
            return postData.getId();
        }
        for (int i = dsC - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dmV, i);
            if (postData2 == null || postData2.boP() == null || postData2.boP().getUserId() == null) {
                break;
            } else if (this.lDQ.Qk(postData2.boP().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dsC + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dmV, i2);
            if (postData3 == null || postData3.boP() == null || postData3.boP().getUserId() == null) {
                return "";
            }
            if (this.lDQ.Qk(postData3.boP().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aB(Context context, String str) {
        this.lHz = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Qh(String str) {
        String str2;
        if (this.lDQ.getPbData() == null || this.lDQ.getPbData().dmV() == null || this.lDQ.getPbData().dmV().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lDQ.getPbData().dmV().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lDQ.getPbData().dmV().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lDQ.getPbData().dmV().get(i);
        if (postData.dPi() == null || postData.dPi().bIC() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dPi().bIC().iterator();
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

    public boolean dpz() {
        return (!this.lHp && this.lJh == -1 && this.lJi == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null) {
            this.lJk = sVar;
            this.lHp = true;
            this.lHU.dsl();
            this.lHU.Qu(this.lJj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpA() {
        if (this.lJk != null) {
            if (this.lJh == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lJk.getCartoonId(), this.lJh, 0)));
                this.lHn.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpB() {
        if (this.lJk != null) {
            if (this.lJi == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lJk.getCartoonId(), this.lJi, 0)));
                this.lHn.finish();
            }
        }
    }

    public int dpC() {
        return this.lJh;
    }

    public int dpD() {
        return this.lJi;
    }

    private void cRw() {
        if (this.lDQ != null && this.lDQ.getPbData() != null && this.lDQ.getPbData().dmT() != null && this.lDQ.getPbData().dmT().bnv()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dpE() {
        if (this.lDQ != null && this.lDQ.getPbData() != null && this.lDQ.getPbData().dmT() != null && this.lDQ.getPbData().dmT().bnv()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dpF() {
        if (this.bIA) {
            this.lHF = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lDQ.getPbData() != null && this.lDQ.getPbData().dmT() != null && this.lDQ.getPbData().dmT().bov() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lDQ.getPbData().dmT().bov().getThreadId(), this.lDQ.getPbData().dmT().bov().getTaskId(), this.lDQ.getPbData().dmT().bov().getForumId(), this.lDQ.getPbData().dmT().bov().getForumName(), this.lDQ.getPbData().dmT().boK(), this.lDQ.getPbData().dmT().boL())));
            this.lHr = true;
            this.lHn.finish();
        }
    }

    public String dpG() {
        return this.lHD;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dpH() {
        return this.lHQ;
    }

    public void uS(boolean z) {
        this.lHE = z;
    }

    public boolean bmu() {
        if (this.lDQ != null) {
            return this.lDQ.dqm();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Bq(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lIm).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lIm.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lIm).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lIm != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIm.getPageActivity());
            aVar.Bq(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lIm).brv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lHU.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIm.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.Bq(this.lIm.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bq(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lHU.showLoadingDialog();
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
        aVar.b(this.lIm).brv();
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
        if (configuration.orientation != this.jzw) {
            this.jzw = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.lHU != null) {
                this.lHU.onConfigurationChanged(configuration);
            }
            if (this.lHY != null) {
                this.lHY.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dpJ() {
        if (this.lDQ != null) {
            return this.lDQ.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.lDQ.getPbData().dnh().lCq;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dPd().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dPd().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dPd().remove(i2);
                    list.get(i).dPf();
                    z = true;
                    break;
                }
            }
            list.get(i).TG(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.lDQ.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.dnM().getId();
        List<PostData> list = this.lDQ.getPbData().dnh().lCq;
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
                ArrayList<PostData> dnU = pVar.dnU();
                postData.KU(pVar.getTotalCount());
                if (postData.dPd() != null) {
                    postData.dPd().clear();
                    postData.dPd().addAll(dnU);
                }
            }
        }
        if (!this.lDQ.getIsFromMark()) {
            this.lHU.s(this.lDQ.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a dob() {
        return this.lHn.dob();
    }

    public boolean doc() {
        if (this.lDQ == null) {
            return false;
        }
        return this.lDQ.doc();
    }

    public void uT(boolean z) {
        this.lHC = z;
    }

    public boolean dpK() {
        return this.lHC;
    }

    public void dpL() {
        if (this.lHU != null) {
            this.lHU.drX();
            cCF();
        }
    }

    public PostData dnc() {
        return this.lHU.b(this.lDQ.lEN, this.lDQ.dql());
    }

    public void onBackPressed() {
        if (this.lIv != null && !this.lIv.isEmpty()) {
            int size = this.lIv.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lIv.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lIv == null) {
                this.lIv = new ArrayList();
            }
            if (!this.lIv.contains(aVar)) {
                this.lIv.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lIv == null) {
                this.lIv = new ArrayList();
            }
            if (!this.lIv.contains(aVar)) {
                this.lIv.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lIv != null) {
            this.lIv.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpM() {
        if (this.lDQ != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lDQ.dqj())) {
            com.baidu.tbadk.BdToken.c.biD().p(com.baidu.tbadk.BdToken.b.evv, com.baidu.adp.lib.f.b.toLong(this.lDQ.dqj(), 0L));
        }
    }

    public bh dpN() {
        return this.lHM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi(String str) {
        if (this.lDQ != null && this.lDQ.getPbData() != null && this.lDQ.getPbData().dmT() != null && this.lDQ.getPbData().dmT().bnz()) {
            by dmT = this.lDQ.getPbData().dmT();
            int i = 0;
            if (dmT.bnx()) {
                i = 1;
            } else if (dmT.bny()) {
                i = 2;
            } else if (dmT.bqM()) {
                i = 3;
            } else if (dmT.bqN()) {
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
                return com.baidu.tieba.pb.pb.main.d.b.a(PbFragment.this.getContext(), PbFragment.this.dpk(), i2, PbFragment.this.lDQ);
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
    public PbFragment dpO() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dpP() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dpQ() {
        return this.lHn;
    }
}
