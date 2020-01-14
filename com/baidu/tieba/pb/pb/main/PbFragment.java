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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.account.contants.LoginConstants;
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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
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
import com.baidu.tbadk.switchs.FansCallSwitch;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
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
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pb.view.a;
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
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
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
/* loaded from: classes7.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0577a {
    private com.baidu.adp.lib.d.b<ImageView> dIh;
    private com.baidu.adp.lib.d.b<GifView> dIi;
    private com.baidu.adp.lib.d.b<TextView> dKV;
    private com.baidu.adp.lib.d.b<View> dKW;
    private com.baidu.adp.lib.d.b<LinearLayout> dKX;
    private com.baidu.adp.lib.d.b<RelativeLayout> dKY;
    private com.baidu.adp.lib.d.b<TbImageView> deV;
    private LikeModel dfN;
    private au gOz;
    private VoiceManager gmi;
    private com.baidu.tieba.frs.profession.permission.c gpJ;
    private com.baidu.tieba.f.b gql;
    public com.baidu.tbadk.core.util.aj hNy;
    private String iCs;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iFM;
    private View iFN;
    int iFP;
    private ax iFS;
    private com.baidu.tieba.pb.pb.report.a iFU;
    private PbActivity iFv;
    private com.baidu.tieba.pb.pb.main.b.b iFx;
    public String iGB;
    public as iGb;
    private com.baidu.tbadk.core.dialog.i iGc;
    private com.baidu.tbadk.core.dialog.k iGd;
    private boolean iGe;
    private com.baidu.tieba.tbadkCore.data.f iGi;
    private com.baidu.tbadk.editortools.pb.g iGj;
    private com.baidu.tbadk.editortools.pb.e iGk;
    private com.baidu.tieba.frs.profession.permission.c iGm;
    private EmotionImageData iGn;
    private com.baidu.adp.base.e iGq;
    private com.baidu.tbadk.core.view.d iGr;
    private BdUniqueId iGs;
    private Runnable iGt;
    private com.baidu.adp.widget.ImageView.a iGu;
    private String iGv;
    private TbRichTextMemeInfo iGw;
    private List<a> iGz;
    private boolean iHb;
    private String iHk;
    private com.baidu.tbadk.core.data.p iHl;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a iHh = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.f.b.a
        public void bc(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cjP();
            } else {
                com.baidu.tieba.pb.a.b.cjO();
            }
        }
    };
    private boolean iFw = false;
    private boolean iFy = false;
    private boolean isPaused = false;
    private boolean ifS = false;
    private boolean iFz = true;
    private int iFA = 0;
    private com.baidu.tbadk.core.dialog.b iFB = null;
    private long fSK = -1;
    private long dzB = 0;
    private long iFC = 0;
    private long createTime = 0;
    private long dzt = 0;
    private boolean iFD = false;
    private com.baidu.tbadk.n.b iFE = null;
    private long iFF = 0;
    private boolean iFG = false;
    private long iFH = 0;
    private int gMd = 1;
    private String duj = null;
    private boolean iFI = false;
    private boolean isFullScreen = false;
    private String iFJ = "";
    private boolean iFK = true;
    private boolean iFL = false;
    private String source = "";
    private int mSkinType = 3;
    int[] iFO = new int[2];
    private int iFQ = -1;
    private int iFR = -1;
    private PbInterviewStatusView.a iFT = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.iFX.qh(!PbFragment.this.iFK);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.iCx != null && PbFragment.this.iCx.aww()) {
                        PbFragment.this.clr();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel iCx = null;
    private com.baidu.tbadk.baseEditMark.a iFV = null;
    private ForumManageModel fHZ = null;
    private com.baidu.tbadk.coreExtra.model.a cVY = null;
    private com.baidu.tieba.pb.data.n iFW = null;
    private ShareSuccessReplyToServerModel gCs = null;
    private aq iFX = null;
    private boolean iFY = false;
    private boolean iFZ = false;
    private boolean iGa = false;
    private boolean dZH = false;
    private boolean iGf = false;
    private boolean iGg = false;
    private boolean iGh = false;
    private boolean iGl = false;
    public boolean iGo = false;
    private com.baidu.tbadk.editortools.pb.c dum = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aMt() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b dun = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aMs() {
            if (PbFragment.this.iGb == null || PbFragment.this.iGb.cpd() == null || !PbFragment.this.iGb.cpd().cSO()) {
                return !PbFragment.this.yG(com.baidu.tbadk.core.util.aj.cVT);
            }
            PbFragment.this.showToast(PbFragment.this.iGb.cpd().cSQ());
            if (PbFragment.this.iGk != null && (PbFragment.this.iGk.aMI() || PbFragment.this.iGk.aMJ())) {
                PbFragment.this.iGk.a(false, PbFragment.this.iGb.cpg());
            }
            PbFragment.this.iGb.qt(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b iGp = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aMs() {
            if (PbFragment.this.iGb == null || PbFragment.this.iGb.cpe() == null || !PbFragment.this.iGb.cpe().cSO()) {
                return !PbFragment.this.yG(com.baidu.tbadk.core.util.aj.cVU);
            }
            PbFragment.this.showToast(PbFragment.this.iGb.cpe().cSQ());
            if (PbFragment.this.iFX != null && PbFragment.this.iFX.cnP() != null && PbFragment.this.iFX.cnP().ckR() != null && PbFragment.this.iFX.cnP().ckR().aMJ()) {
                PbFragment.this.iFX.cnP().ckR().a(PbFragment.this.iGb.cpg());
            }
            PbFragment.this.iGb.qu(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean gmV = false;
    private int iGx = 0;
    private int iGy = -1;
    public int iGA = 0;
    private final a iGC = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.iFX != null && PbFragment.this.iFX.cnP() != null) {
                t cnP = PbFragment.this.iFX.cnP();
                if (cnP.ckP()) {
                    cnP.ckO();
                    return true;
                }
            }
            if (PbFragment.this.iFX != null && PbFragment.this.iFX.coM()) {
                PbFragment.this.iFX.coN();
                return true;
            }
            return false;
        }
    };
    private final aa.a iGD = new aa.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.aa.a
        public void onSuccess(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.aa.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.iFX.showToast(str);
            }
        }
    };
    private final CustomMessageListener iGE = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iCx != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.iGk != null) {
                    PbFragment.this.iFX.qm(PbFragment.this.iGk.aMB());
                }
                PbFragment.this.iFX.cnR();
                PbFragment.this.iFX.coF();
            }
        }
    };
    CustomMessageListener gnx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.iCx.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.iFX != null && PbFragment.this.iCx != null) {
                    PbFragment.this.iFX.b(PbFragment.this.iCx.getPbData(), PbFragment.this.iCx.cmd(), PbFragment.this.iCx.cmB(), PbFragment.this.iFX.getSkinType());
                }
                if (PbFragment.this.iFX != null && PbFragment.this.iFX.coi() != null) {
                    PbFragment.this.iFX.coi().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener iGF = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.iFX != null) {
                    if (booleanValue) {
                        PbFragment.this.iFX.bUP();
                    } else {
                        PbFragment.this.iFX.bUO();
                    }
                }
            }
        }
    };
    private CustomMessageListener iGG = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.iGk != null) {
                    PbFragment.this.iFX.qm(PbFragment.this.iGk.aMB());
                }
                PbFragment.this.iFX.qo(false);
            }
        }
    };
    private CustomMessageListener iGH = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.f fVar = (com.baidu.tieba.pb.f) customResponsedMessage.getData();
                switch (fVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.m) fVar.getData());
                        return;
                    case 1:
                        PbFragment.this.a((ForumManageModel.b) fVar.getData(), false);
                        return;
                    case 2:
                        if (fVar.getData() == null) {
                            PbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbFragment.this.a(true, (MarkData) fVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener iGI = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iFX != null && PbFragment.this.iFX.coi() != null) {
                PbFragment.this.iFX.coi().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hrx = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener gnu = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.clI();
            }
        }
    };
    private j.a iGJ = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void z(int i, long j) {
            boolean z;
            if (i == 0) {
                PbFragment.this.yI(2);
                ak.cnx().reset();
                PbFragment.this.iCx.cmC();
                boolean z2 = false;
                ArrayList<PostData> ciU = PbFragment.this.iCx.getPbData().ciU();
                if (ciU != null) {
                    Iterator<PostData> it = ciU.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.o(next) && next.cJI().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbFragment.this.iFX.o(PbFragment.this.iCx.getPbData());
                    }
                    PbFragment.this.showToast(R.string.operation_success);
                    return;
                }
                return;
            }
            PbFragment.this.showToast(R.string.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void onError(int i, String str) {
            PbFragment.this.showToast(R.string.operation_failed);
        }
    };
    private View.OnClickListener duU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.duj);
        }
    };
    private CustomMessageListener iGK = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                ar.a aVar = new ar.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.thumbnailUrl = abVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.iCx.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.iCx.cmr() != null && PbFragment.this.iCx.cmr().getUserIdLong() == abVar.toUserId) {
                        PbFragment.this.iFX.a(abVar.sendCount, PbFragment.this.iCx.getPbData(), PbFragment.this.iCx.cmd(), PbFragment.this.iCx.cmB());
                    }
                    if (pbData.ciU() != null && pbData.ciU().size() >= 1 && pbData.ciU().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.ciU().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.iCx.cmc(), 0L);
                        if (j == abVar.postId && j2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.ar cJH = pbData.ciU().get(0).cJH();
                            if (cJH == null) {
                                cJH = new com.baidu.tbadk.core.data.ar();
                            }
                            ArrayList<ar.a> ayT = cJH.ayT();
                            if (ayT == null) {
                                ayT = new ArrayList<>();
                            }
                            ayT.add(0, aVar);
                            cJH.setTotal(abVar.sendCount + cJH.getTotal());
                            cJH.u(ayT);
                            pbData.ciU().get(0).a(cJH);
                            PbFragment.this.iFX.coi().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gDA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                PbFragment.this.Fy((String) customResponsedMessage.getData());
                PbFragment.this.iCx.cmx();
                if (PbFragment.this.iFX.coi() != null) {
                    PbFragment.this.iFX.o(PbFragment.this.iCx.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a iGL = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cpu()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a iGM = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onSuccess(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.iFX != null) {
                PbFragment.this.iFX.dL(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean iGN = false;
    private PraiseModel iGO = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void wW(String str) {
            PbFragment.this.iGN = false;
            if (PbFragment.this.iGO != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.iCx.getPbData();
                if (pbData.ciS().azI().getIsLike() == 1) {
                    PbFragment.this.tC(0);
                } else {
                    PbFragment.this.tC(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.ciS()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.iGN = false;
            if (PbFragment.this.iGO != null && str != null) {
                if (AntiHelper.bc(i, str)) {
                    AntiHelper.bn(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a iGP = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void pN(boolean z) {
            PbFragment.this.pM(z);
            if (PbFragment.this.iFX.coS() != null && z) {
                PbFragment.this.iFX.qh(false);
            }
            PbFragment.this.iFX.qj(z);
        }
    };
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().djO != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().djO, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.ciZ().azX() != null && PbFragment.this.ciZ().azX().getGodUserData() != null) {
                            PbFragment.this.ciZ().azX().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().azX() != null) {
                            PbFragment.this.iCx.getPbData().ciS().azX().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h glq = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.iFv.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a iGQ = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.iFX.boJ();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.yJ(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.bKZ();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c dmA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cla();
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
                        if (PbFragment.this.cu(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.c((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.iFX.ckY() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").cp("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cjQ() != null && PbFragment.this.cjQ().gOU != null) {
                                PbFragment.this.cjQ().gOU.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = null;
                        if (view.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view.getTag();
                        }
                        if (sparseArray != null) {
                            PbFragment.this.c(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (PbFragment.this.iGk != null) {
                    PbFragment.this.iFX.qm(PbFragment.this.iGk.aMB());
                }
                PbFragment.this.iFX.cnR();
                PbFragment.this.iFX.coF();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener iGR = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iGs) {
                PbFragment.this.iFX.boJ();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.iCx.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cjf().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iGr.showSuccessToast(PbFragment.this.iGq.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.iGq.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.uZ(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.clF();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.iGq.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.iGr.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iGS = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iGs) {
                PbFragment.this.iFX.boJ();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iGr.showSuccessToast(PbFragment.this.iGq.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.iGq.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.iGr.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iGT = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iGs) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.iFX.boJ();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.ktH;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
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
                    PbFragment.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbFragment.this.iFX.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener iGU = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iFX.cnS() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cla();
            }
        }
    };
    private CustomMessageListener gnE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.gmV = true;
                }
            }
        }
    };
    public a.b iqX = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bCG();
            com.baidu.tbadk.core.data.ap pageData = PbFragment.this.iCx.getPageData();
            int pageNum = PbFragment.this.iFX.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.ayM()) {
                PbFragment.this.iFX.coF();
                PbFragment.this.yI(2);
                PbFragment.this.bCF();
                PbFragment.this.iFX.com();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.iCx.yL(PbFragment.this.iFX.getPageNum());
                    if (PbFragment.this.iFx != null) {
                        PbFragment.this.iFx.showFloatingView();
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
    public final View.OnClickListener gon = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        /* JADX WARN: Removed duplicated region for block: B:606:0x1d13  */
        /* JADX WARN: Removed duplicated region for block: B:609:0x1d5c  */
        /* JADX WARN: Removed duplicated region for block: B:626:0x1f72  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            String str;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            boolean z3;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            long j;
            String str2;
            int i;
            int i2;
            int i3;
            bo boVar;
            String[] strArr;
            boolean u;
            String name;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.iFX.coB()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.iCx.pS(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.iFX.con();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.iFX.iMo.cpI() == null || view != PbFragment.this.iFX.iMo.cpI().cnr()) {
                        if (view == PbFragment.this.iFX.iMo.dBI) {
                            if (PbFragment.this.iFX.ql(PbFragment.this.iCx.cmi())) {
                                PbFragment.this.bCF();
                                return;
                            }
                            PbFragment.this.iFz = false;
                            PbFragment.this.iFy = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.iFv, PbFragment.this.iFX.iMo.dBI);
                            PbFragment.this.iFv.finish();
                        } else if (view != PbFragment.this.iFX.cok() && (PbFragment.this.iFX.iMo.cpI() == null || (view != PbFragment.this.iFX.iMo.cpI().cnq() && view != PbFragment.this.iFX.iMo.cpI().cno()))) {
                            if (view == PbFragment.this.iFX.coI()) {
                                if (PbFragment.this.iCx != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iCx.getPbData().ciS().azW().getLink());
                                }
                            } else if (view != PbFragment.this.iFX.iMo.iSq) {
                                if (view == PbFragment.this.iFX.iMo.iSr) {
                                    if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                        ArrayList<PostData> ciU = PbFragment.this.iCx.getPbData().ciU();
                                        if ((ciU == null || ciU.size() <= 0) && PbFragment.this.iCx.cmd()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").cp("tid", PbFragment.this.iCx.cmc()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", PbFragment.this.iCx.getForumId()));
                                        if (!PbFragment.this.iFX.coX()) {
                                            PbFragment.this.iFX.cnR();
                                        }
                                        PbFragment.this.clj();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.iFX.pC(true);
                                        PbFragment.this.iFX.cnR();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.iFX.bUP();
                                            PbFragment.this.bCF();
                                            PbFragment.this.iFX.com();
                                            PbFragment.this.iCx.FG(PbFragment.this.clv());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbFragment.this.yI(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.iFX.iMo.cpI() == null || view != PbFragment.this.iFX.iMo.cpI().cnn()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.iFX.iMo.cpI() != null && view == PbFragment.this.iFX.iMo.cpI().cnm()) {
                                            PbFragment.this.iFX.iMo.apF();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.iFX.iMo.cpI() == null || view != PbFragment.this.iFX.iMo.cpI().cnk()) {
                                                if ((PbFragment.this.iFX.iMo.cpI() == null || view != PbFragment.this.iFX.iMo.cpI().cnt()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.iFX.iMo.cpI() == null || view != PbFragment.this.iFX.iMo.cpI().cnl()) {
                                                        if (PbFragment.this.iFX.iMo.cpI() == null || view != PbFragment.this.iFX.iMo.cpI().cnu()) {
                                                            if (PbFragment.this.iFX.coS() == view) {
                                                                if (PbFragment.this.iFX.coS().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.iCx.getPbData();
                                                                    if (pbData != null && pbData.ciS() != null && pbData.ciS().azC() != null) {
                                                                        String azt = pbData.ciS().azC().azt();
                                                                        if (StringUtils.isNull(azt)) {
                                                                            azt = pbData.ciS().azC().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").cp("obj_id", azt));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.eu("c10725", null);
                                                                }
                                                                PbFragment.this.clC();
                                                            } else if (PbFragment.this.iFX.iMo.cpI() == null || view != PbFragment.this.iFX.iMo.cpI().cns()) {
                                                                if (PbFragment.this.iFX.iMo.cpI() != null && view == PbFragment.this.iFX.iMo.cpI().cnp()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.iFX.b(PbFragment.this.iCx.getPbData(), PbFragment.this.iCx.cmd(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.iFX.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.iFX.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.iFX.iMo.apF();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.cp("tid", PbFragment.this.iCx.cmc());
                                                                        anVar.cp("fid", PbFragment.this.iCx.getForumId());
                                                                        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.Z("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                                                            PbFragment.this.iFX.coF();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cJL() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.kgo != null) {
                                                                                    com.baidu.tbadk.core.util.an aEl = postData.kgo.aEl();
                                                                                    aEl.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aEl.Z("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aEl.Z("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aEl);
                                                                                }
                                                                                String cmc = PbFragment.this.iCx.cmc();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbFragment.this.iCx.getPbData() != null) {
                                                                                    i4 = PbFragment.this.iCx.getPbData().cje();
                                                                                }
                                                                                PbFragment.this.bCF();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a FE = PbFragment.this.FE(id);
                                                                                    if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && FE != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cmc, id, "pb", true, null, true, null, i4, postData.cqG(), PbFragment.this.iCx.getPbData().getAnti(), false, postData.azX().getIconInfo()).addBigImageData(FE.iCC, FE.iCD, FE.iCE, FE.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.iCx.cmO());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.iCx.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.iCx.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.iCx.cmk());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a FE2 = PbFragment.this.FE(id);
                                                                                    if (postData != null && PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && FE2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cmc, id, "pb", true, null, false, null, i4, postData.cqG(), PbFragment.this.iCx.getPbData().getAnti(), false, postData.azX().getIconInfo()).addBigImageData(FE2.iCC, FE2.iCD, FE2.iCE, FE2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.iCx.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.iCx.cmk());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.iCx.cmO());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.iCx.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").Z("obj_locate", 3).cp("fid", PbFragment.this.iCx.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.iCx != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.cp("tid", PbFragment.this.iCx.cmc());
                                                                        anVar2.cp("fid", PbFragment.this.iCx.getForumId());
                                                                        anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.Z("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (postData2.kgo != null) {
                                                                                    com.baidu.tbadk.core.util.an aEl2 = postData2.kgo.aEl();
                                                                                    aEl2.delete("obj_locate");
                                                                                    aEl2.Z("obj_locate", 8);
                                                                                    TiebaStatic.log(aEl2);
                                                                                }
                                                                                if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                                                                    String cmc2 = PbFragment.this.iCx.cmc();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbFragment.this.iCx.getPbData() != null) {
                                                                                        i5 = PbFragment.this.iCx.getPbData().cje();
                                                                                    }
                                                                                    PbActivity.a FE3 = PbFragment.this.FE(id2);
                                                                                    if (FE3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cmc2, id2, "pb", true, null, false, null, i5, postData2.cqG(), PbFragment.this.iCx.getPbData().getAnti(), false, postData2.azX().getIconInfo()).addBigImageData(FE3.iCC, FE3.iCD, FE3.iCE, FE3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.iCx.cmO());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.iCx.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.iCx.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.iCx.cmk());
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
                                                                } else if (view.getId() == R.id.pb_post_reply) {
                                                                    if (PbFragment.this.iCx != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.cp("tid", PbFragment.this.iCx.cmc());
                                                                        anVar3.cp("fid", PbFragment.this.iCx.getForumId());
                                                                        anVar3.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.Z("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (postData3.kgo != null) {
                                                                                    com.baidu.tbadk.core.util.an aEl3 = postData3.kgo.aEl();
                                                                                    aEl3.delete("obj_locate");
                                                                                    aEl3.Z("obj_locate", 8);
                                                                                    TiebaStatic.log(aEl3);
                                                                                }
                                                                                if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.ckX().cnO() != null && postData3.azX() != null && postData3.cJz() != 1) {
                                                                                    if (PbFragment.this.ckX().cnP() != null) {
                                                                                        PbFragment.this.ckX().cnP().ckN();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                    mVar.a(PbFragment.this.iCx.getPbData().getForum());
                                                                                    mVar.setThreadData(PbFragment.this.iCx.getPbData().ciS());
                                                                                    mVar.f(postData3);
                                                                                    PbFragment.this.ckX().cnO().d(mVar);
                                                                                    PbFragment.this.ckX().cnO().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.azX().getUserId(), "");
                                                                                    if (PbFragment.this.iGk != null) {
                                                                                        PbFragment.this.iFX.qm(PbFragment.this.iGk.aMB());
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
                                                                } else if (view != PbFragment.this.iFX.ckn()) {
                                                                    if (view == PbFragment.this.iFX.iMo.cpJ()) {
                                                                        PbFragment.this.iFX.cot();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (boVar = (bo) view.getTag()) != null && !StringUtils.isNull(boVar.aCh())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.aEt().b(PbFragment.this.getPageContext(), new String[]{boVar.aCh()});
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right || id3 == R.id.image_more_tip) {
                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                if (view != null && view.getTag() != null) {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").cp("tid", PbFragment.this.iCx.iIx));
                                                                                    }
                                                                                    if (PbFragment.this.iGd == null) {
                                                                                        PbFragment.this.iGd = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.iGd.a(PbFragment.this.iHg);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cw(view);
                                                                                    if (!PbFragment.this.cw(view) || PbFragment.this.iGu == null || !PbFragment.this.iGu.isGif()) {
                                                                                    }
                                                                                    boolean z4 = false;
                                                                                    boolean z5 = false;
                                                                                    boolean z6 = false;
                                                                                    boolean z7 = false;
                                                                                    boolean z8 = false;
                                                                                    if (!(sparseArray4.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                        z = false;
                                                                                    } else {
                                                                                        z = ((Boolean) sparseArray4.get(R.id.tag_should_hide_chudian_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                        ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                        z4 = ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                        z6 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z7 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                        z8 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
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
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbFragment.this.getString(R.string.no_interesting), PbFragment.this.iGd);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cJB() != null && postData4.cJB().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iGd);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbFragment.this.hfx = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.iCx.getPbData().aww()) {
                                                                                        String awv = PbFragment.this.iCx.getPbData().awv();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(awv) && awv.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iGd);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iGd);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.hfx);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z6 && z5) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iGd);
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
                                                                                                    if (!ap.o(PbFragment.this.hfx)) {
                                                                                                        z3 = PbFragment.this.pI(z4) && TbadkCoreApplication.isLogin();
                                                                                                    } else {
                                                                                                        z3 = false;
                                                                                                    }
                                                                                                    if (z3) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iGd);
                                                                                                        gVar7.mTextView.setTag(str);
                                                                                                        arrayList.add(gVar7);
                                                                                                    }
                                                                                                }
                                                                                                if (z6) {
                                                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                                                    sparseArray8.put(R.id.tag_should_manage_visible, true);
                                                                                                    sparseArray8.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name, sparseArray4.get(R.id.tag_forbid_user_name));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name_show, sparseArray4.get(R.id.tag_forbid_user_name_show));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_portrait, sparseArray4.get(R.id.tag_forbid_user_portrait));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_post_id, str);
                                                                                                    if (z7) {
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
                                                                                                    if (z8) {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, true);
                                                                                                        sparseArray8.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                                                                                                        sparseArray8.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                        sparseArray8.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iGd);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iGd);
                                                                                                    gVar3.mTextView.setTag(sparseArray8);
                                                                                                } else if (!z8) {
                                                                                                    gVar2 = null;
                                                                                                    gVar3 = null;
                                                                                                } else {
                                                                                                    SparseArray sparseArray9 = new SparseArray();
                                                                                                    sparseArray9.put(R.id.tag_should_manage_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                    sparseArray9.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                                                                                                    sparseArray9.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                    sparseArray9.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                    if (PbFragment.this.iCx.getPbData().cje() == 1002 && !z4) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iGd);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iGd);
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
                                                                                            PbFragment.this.iGd.az(arrayList);
                                                                                            PbFragment.this.iGc = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iGd);
                                                                                            PbFragment.this.iGc.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.hfx);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.iGd.az(arrayList);
                                                                                    PbFragment.this.iGc = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iGd);
                                                                                    PbFragment.this.iGc.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.iCx.getPbData().ciS().getActUrl());
                                                                                if (PbFragment.this.iCx.getPbData().ciS().aAH() != 1) {
                                                                                    if (PbFragment.this.iCx.getPbData().ciS().aAH() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").cp("fid", PbFragment.this.iCx.getPbData().getForumId()).cp("tid", PbFragment.this.iCx.getPbData().getThreadId()).cp("lotterytail", StringUtils.string(str3, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.iCx.getPbData().getThreadId().equals(str3)) {
                                                                                    PbFragment.this.iFX.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.iFX.cnR();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.clf() == 1 && PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").cp("fid", PbFragment.this.iCx.getPbData().getForumId()).cp("tid", PbFragment.this.iCx.getPbData().getThreadId()).cp("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.clf() == 1 && PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").cp("fid", PbFragment.this.iCx.getPbData().getForumId()).cp("tid", PbFragment.this.iCx.getPbData().getThreadId()).cp("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.clx();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.cly();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().cjl() != null) {
                                                                                com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.iCx.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").cp("fid", pbData2.getForumId()));
                                                                                ba.aEt().b(PbFragment.this.getPageContext(), new String[]{pbData2.cjl().cjw()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().cjl() != null) {
                                                                                com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.iCx.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cp("fid", pbData3.getForumId()));
                                                                                ba.aEt().b(PbFragment.this.getPageContext(), new String[]{pbData3.cjl().cjw()});
                                                                            }
                                                                        } else if (PbFragment.this.iFX.iMo.cpI() != null && view == PbFragment.this.iFX.iMo.cpI().cnv()) {
                                                                            if (PbFragment.this.iCx == null || PbFragment.this.iCx.getPbData() == null || PbFragment.this.iCx.getPbData().ciS() == null) {
                                                                                PbFragment.this.iFX.iMo.apF();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                                                PbFragment.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbFragment.this.iCx.getPbData().ciS().azD() == 0) {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iCx.cmc(), RequestResponseCode.FANS_CALL_JUMP_BACK)));
                                                                                } else {
                                                                                    BdToast.b(PbFragment.this.getPageContext().getContext(), PbFragment.this.getPageContext().getContext().getString(R.string.haved_fans_called)).aCu();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").Z("obj_locate", PbFragment.this.aC(PbFragment.this.iCx.getPbData().ciS())).cp("tid", PbFragment.this.iCx.getPbData().ciS().getTid()).Z("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.iGx >= 0) {
                                                                                if (PbFragment.this.iCx != null) {
                                                                                    PbFragment.this.iCx.cmP();
                                                                                }
                                                                                if (PbFragment.this.iCx != null && PbFragment.this.iFX.coi() != null) {
                                                                                    PbFragment.this.iFX.coi().a(PbFragment.this.iCx.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.iGx = 0;
                                                                                if (PbFragment.this.iCx != null) {
                                                                                    PbFragment.this.iFX.getListView().setSelection(PbFragment.this.iCx.cmS());
                                                                                    PbFragment.this.iCx.cq(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.clc();
                                                                        } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                            SparseArray sparseArray10 = null;
                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                sparseArray10 = (SparseArray) view.getTag();
                                                                            }
                                                                            if (sparseArray10 != null) {
                                                                                PbFragment.this.c(sparseArray10);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                            if (PbFragment.this.iFX.getListView() != null && PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.iFX.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.iFX.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean cjp = PbFragment.this.iCx.getPbData().cjp();
                                                                                boolean z9 = PbFragment.this.iFX.cnQ() != null && PbFragment.this.iFX.cnQ().bgb();
                                                                                boolean coC = PbFragment.this.iFX.coC();
                                                                                boolean z10 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (cjp && PbFragment.this.iFX.cnQ() != null && PbFragment.this.iFX.cnQ().bat() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.iFX.cnQ().cps();
                                                                                    z10 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.iFX.cnQ().bat().getHeight() - PbFragment.this.iFX.cnQ().cps());
                                                                                    i7 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.FF("c13568");
                                                                                if ((PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().azO() <= 0) || (coC && z10)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.clc();
                                                                                        if (PbFragment.this.iCx.getPbData().ciS().azX() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", PbFragment.this.iCx.iIx).cp("fid", PbFragment.this.iCx.getPbData().getForumId()).Z("obj_locate", 2).cp("uid", PbFragment.this.iCx.getPbData().ciS().azX().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z11 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (cjp) {
                                                                                        if (PbFragment.this.iFX.iNu != null && PbFragment.this.iFX.iNu.iOy != null && PbFragment.this.iFX.iNu.iOy.getView() != null) {
                                                                                            if (PbFragment.this.iFX.iNu.iOy.getView().getParent() == null) {
                                                                                                z11 = firstVisiblePosition >= PbFragment.this.cln();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbFragment.this.iFX.cnQ() != null && PbFragment.this.iFX.cnQ().bat() != null) {
                                                                                                    i8 = PbFragment.this.iFX.cnQ().bat().getBottom();
                                                                                                }
                                                                                                z11 = PbFragment.this.iFX.iNu.iOy.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.iFX.cnZ() != null) {
                                                                                        z11 = PbFragment.this.iFX.cnZ().getVisibility() == 0;
                                                                                        if (!z11 && PbFragment.this.iFX.iNu != null && PbFragment.this.iFX.iNu.iOy != null && PbFragment.this.iFX.iNu.iOy.getView() != null && PbFragment.this.iFX.iNu.iOy.getView().getParent() != null && PbFragment.this.iFX.iMo != null && PbFragment.this.iFX.iMo.mNavigationBar != null) {
                                                                                            z11 = PbFragment.this.iFX.iNu.iOy.getView().getTop() - PbFragment.this.iFX.iMo.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z11 || coC) {
                                                                                        PbFragment.this.iFQ = firstVisiblePosition;
                                                                                        PbFragment.this.iFR = top;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                            PbFragment.this.iFX.getListView().setSelectionFromTop(0, i7 - equipmentHeight);
                                                                                            PbFragment.this.iFX.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.iFX.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.iFQ > 0) {
                                                                                        if (PbFragment.this.iFX.getListView().getChildAt(PbFragment.this.iFQ) != null) {
                                                                                            PbFragment.this.iFX.getListView().smoothScrollToPosition(PbFragment.this.iFQ, PbFragment.this.iFR, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iFX.getListView().setSelectionFromTop(PbFragment.this.iFQ, PbFragment.this.iFR + equipmentHeight);
                                                                                            PbFragment.this.iFX.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int cln = PbFragment.this.cln();
                                                                                        if (PbFragment.this.clm() != -1) {
                                                                                            cln--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (cln < 0) {
                                                                                            i2 = PbFragment.this.iFX.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.iFX.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = cln;
                                                                                            i3 = dimens;
                                                                                        }
                                                                                        if (z9) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!cjp || PbFragment.this.iFX.cnQ() == null) {
                                                                                            if (PbFragment.this.iFX.iMo != null && PbFragment.this.iFX.iMo.mNavigationBar != null) {
                                                                                                i3 += PbFragment.this.iFX.iMo.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbFragment.this.iFX.cnQ().cpr();
                                                                                        }
                                                                                        if (PbFragment.this.iFX.iNu == null || PbFragment.this.iFX.iNu.iOy == null || PbFragment.this.iFX.iNu.iOy.getView() == null || PbFragment.this.iFX.iNu.iOy.getView().getParent() == null) {
                                                                                            PbFragment.this.iFX.getListView().setSelectionFromTop(i2, i3 + equipmentHeight);
                                                                                            PbFragment.this.iFX.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z9) {
                                                                                            PbFragment.this.iFX.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iFX.getListView().smoothScrollBy(PbFragment.this.iFX.iNu.iOy.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().azX() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", PbFragment.this.iCx.iIx).cp("fid", PbFragment.this.iCx.getPbData().getForumId()).Z("obj_locate", 2).cp("uid", PbFragment.this.iCx.getPbData().ciS().azX().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.iCx.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.iCx.cmO() == 3) {
                                                                                    PbFragment.this.iFv.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.iCx.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.cp("tid", PbFragment.this.iCx.cmc());
                                                                                anVar4.cp("fid", PbFragment.this.iCx.getForumId());
                                                                                anVar4.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar = (bj) view.getTag();
                                                                                if (PbFragment.this.iCx.cmO() == 3 && PbFragment.this.cjR() && PbFragment.this.iCx.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.iCx.getPbData().cjm())) {
                                                                                    PbFragment.this.iFv.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar.aAc(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.cp("tid", bjVar.getId());
                                                                                anVar5.s("fid", bjVar.getFid());
                                                                                anVar5.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbFragment.this.iCx != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.cp("tid", PbFragment.this.iCx.cmc());
                                                                                anVar6.cp("fid", PbFragment.this.iCx.getForumId());
                                                                                anVar6.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.Z("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.iCx.getPbData();
                                                                                if (PbFragment.this.iFW == null) {
                                                                                    PbFragment.this.iFW = new com.baidu.tieba.pb.data.n(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData4.getThreadId(), 0L);
                                                                                long j3 = com.baidu.adp.lib.f.b.toLong(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").s("forum_id", j3).aEm();
                                                                                PbFragment.this.registerListener(PbFragment.this.iGW);
                                                                                PbFragment.this.iFW.D(j2, j3);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").cp("fid", PbFragment.this.iCx.getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", smartApp.name).s("obj_id", smartApp.swan_app_id.longValue()).cp("obj_source", "PB_card").cp("tid", PbFragment.this.iCx.cmc()).Z("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar2 = (bj) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar2.aAc(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cp("page_type", PageStayDurationConstants.PageName.PB).Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_adlocate", 9).Z("obj_locate", 9).s("obj_id", bjVar2.getFid()).cp("tid", bjVar2.getId()).Z("thread_type", bjVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bj) && PbFragment.this.checkUpIsLogin()) {
                                                                                bj bjVar3 = (bj) view.getTag();
                                                                                if (PbFragment.this.dfN != null) {
                                                                                    PbFragment.this.dfN.et(bjVar3.aAc(), String.valueOf(bjVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cp("page_type", PageStayDurationConstants.PageName.PB).Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_adlocate", 10).Z("obj_locate", 11).s("obj_id", bjVar3.getFid()).cp("tid", bjVar3.getId()).Z("thread_type", bjVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.iCx.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.iCx.cmc(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.iCx.getPbData().ciS().aAr())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.iFX.coF();
                                                                SparseArray<Object> b3 = PbFragment.this.iFX.b(PbFragment.this.iCx.getPbData(), PbFragment.this.iCx.cmd(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iCx.getPbData().getForum().getId(), PbFragment.this.iCx.getPbData().getForum().getName(), PbFragment.this.iCx.getPbData().ciS().getId(), String.valueOf(PbFragment.this.iCx.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                com.baidu.tbadk.core.util.am.s(true, false);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).Z("obj_type", 0).Z("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).Z("obj_type", 1).Z("obj_source", 1));
                                                            }
                                                            PbFragment.this.iFX.iMo.cpH();
                                                        }
                                                    } else if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().ciS() != null) {
                                                        PbFragment.this.iFX.iMo.apF();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.FA(PbFragment.this.iCx.getPbData().ciS().aAn());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.iFX.coF();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.iCx.cmv()));
                                                            return;
                                                        }
                                                        PbFragment.this.yI(2);
                                                        PbFragment.this.bCF();
                                                        PbFragment.this.iFX.com();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.iCx.getPbData().izJ == null || PbFragment.this.iCx.getPbData().izJ.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.iCx.getPbData().izJ.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbFragment.this.iCx.getPbData().izJ.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbFragment.this.iCx.getPbData().izJ.get(i10).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.iCx.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbFragment.this.iCx.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbFragment.this.iCx.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbFragment.this.iCx.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").Z("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).Z("obj_type", i12));
                                                                if (PbFragment.this.iCx.getPbData().izJ != null && PbFragment.this.iCx.getPbData().izJ.size() > i11) {
                                                                    i11 = PbFragment.this.iCx.getPbData().izJ.get(i11).sort_type.intValue();
                                                                }
                                                                boolean yQ = PbFragment.this.iCx.yQ(i11);
                                                                view.setTag(Integer.valueOf(PbFragment.this.iCx.cmv()));
                                                                if (yQ) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.iFX.qc(true);
                                                                }
                                                            }
                                                        });
                                                        iVar.showDialog();
                                                    } else {
                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                        return;
                                                    }
                                                }
                                            } else {
                                                PbFragment.this.iFX.coF();
                                                if (PbFragment.this.ckc().getPbData().izK != 2) {
                                                    if (PbFragment.this.iCx.getPageData() != null) {
                                                        PbFragment.this.iFX.a(PbFragment.this.iCx.getPageData(), PbFragment.this.iqX);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) {
                                            if (PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().azX() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", PbFragment.this.iCx.iIx).cp("fid", PbFragment.this.iCx.getPbData().getForumId()).Z("obj_locate", 4).cp("uid", PbFragment.this.iCx.getPbData().ciS().azX().getUserId()));
                                            }
                                            int i11 = 1;
                                            if (PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().ciS() != null) {
                                                bj ciS = PbFragment.this.iCx.getPbData().ciS();
                                                if (ciS.ayL()) {
                                                    i11 = 2;
                                                } else if (ciS.aBS()) {
                                                    i11 = 3;
                                                } else if (ciS.aBT()) {
                                                    i11 = 4;
                                                } else if (ciS.aBU()) {
                                                    i11 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.cp("tid", PbFragment.this.iCx.cmc());
                                            anVar7.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.cp("fid", PbFragment.this.iCx.getForumId());
                                            anVar7.Z("obj_locate", 6);
                                            anVar7.Z("obj_name", i11);
                                            anVar7.Z("obj_type", 1);
                                            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                anVar7.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                            }
                                            TiebaStatic.log(anVar7);
                                            if (com.baidu.adp.lib.util.l.isNetOk()) {
                                                if (PbFragment.this.iCx.getPbData() != null) {
                                                    ArrayList<PostData> ciU2 = PbFragment.this.iCx.getPbData().ciU();
                                                    if ((ciU2 != null && ciU2.size() > 0) || !PbFragment.this.iCx.cmd()) {
                                                        PbFragment.this.iFX.coF();
                                                        PbFragment.this.bCF();
                                                        PbFragment.this.yI(2);
                                                        if (PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().cjl() != null && !StringUtils.isNull(PbFragment.this.iCx.getPbData().cjl().ayq(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cp("fid", PbFragment.this.iCx.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                        if (ShareSwitch.isOn()) {
                                                            PbFragment.this.yJ(6);
                                                        } else {
                                                            PbFragment.this.iFX.showLoadingDialog();
                                                            PbFragment.this.iCx.cmJ().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
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
                                                PbFragment.this.showToast(R.string.neterror);
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.iFX.coF();
                                        if (PbFragment.this.iFX.iMo.cpI() != null && view == PbFragment.this.iFX.iMo.cpI().cnn() && !PbFragment.this.iFX.coX()) {
                                            PbFragment.this.iFX.cnR();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bCF();
                                            PbFragment.this.iFX.com();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                u = PbFragment.this.iCx.u(true, PbFragment.this.clv());
                                            } else {
                                                u = view.getId() == R.id.reply_title ? PbFragment.this.iCx.u(false, PbFragment.this.clv()) : PbFragment.this.iCx.FG(PbFragment.this.clv());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbFragment.this.iFX.pC(true);
                                                PbFragment.this.iFX.bUP();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.iFX.qc(true);
                                            }
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbFragment.this.yI(2);
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
                                    PbFragment.this.iFX.coF();
                                    if (PbFragment.this.yH(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.iCx.yR(PbFragment.this.iFX.cor()) != null) {
                                        PbFragment.this.clq();
                                        if (PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().azX() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", PbFragment.this.iCx.iIx).cp("fid", PbFragment.this.iCx.getPbData().getForumId()).Z("obj_locate", 3).cp("uid", PbFragment.this.iCx.getPbData().ciS().azX().getUserId()));
                                        }
                                        if (PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().azX() != null && PbFragment.this.iCx.getPbData().ciS().azX().getUserId() != null && PbFragment.this.iFV != null) {
                                            int g = PbFragment.this.g(PbFragment.this.iCx.getPbData());
                                            bj ciS2 = PbFragment.this.iCx.getPbData().ciS();
                                            int i12 = 1;
                                            if (ciS2.ayL()) {
                                                i12 = 2;
                                            } else if (ciS2.aBS()) {
                                                i12 = 3;
                                            } else if (ciS2.aBT()) {
                                                i12 = 4;
                                            } else if (ciS2.aBU()) {
                                                i12 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cp("tid", PbFragment.this.iCx.iIx).Z("obj_locate", 1).cp("obj_id", PbFragment.this.iCx.getPbData().ciS().azX().getUserId()).Z("obj_type", PbFragment.this.iFV.aww() ? 0 : 1).Z("obj_source", g).Z("obj_param1", i12));
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
                                if (PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().aAX() && PbFragment.this.iCx.getPbData().ciS().aAo() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.iCx.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.iCx.cjS()) || PbFragment.this.iCx.getAppealInfo() == null) {
                                        PbFragment.this.iFv.finish();
                                        return;
                                    }
                                    name = PbFragment.this.iCx.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.iCx.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.iFv.finish();
                                    return;
                                }
                                String cjS = PbFragment.this.iCx.cjS();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.iCx.cme() && cjS != null && cjS.equals(name)) {
                                    PbFragment.this.iFv.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.iCx.getPbData() != null) {
                                if ((PbFragment.this.iCx.getPbData().cje() == 1 || PbFragment.this.iCx.getPbData().cje() == 3) && !PbFragment.this.fHZ.cKo()) {
                                    PbFragment.this.iFX.coF();
                                    int i13 = 0;
                                    if (PbFragment.this.iFX.iMo.cpI() == null || view != PbFragment.this.iFX.iMo.cpI().cno()) {
                                        if (PbFragment.this.iFX.iMo.cpI() == null || view != PbFragment.this.iFX.iMo.cpI().cnq()) {
                                            if (view == PbFragment.this.iFX.cok()) {
                                                i13 = 2;
                                            }
                                        } else if (PbFragment.this.iCx.getPbData().ciS().azT() == 1) {
                                            i13 = 3;
                                        } else {
                                            i13 = 6;
                                        }
                                    } else if (PbFragment.this.iCx.getPbData().ciS().azS() == 1) {
                                        i13 = 5;
                                    } else {
                                        i13 = 4;
                                    }
                                    ForumData forum = PbFragment.this.iCx.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.iCx.getPbData().ciS().getId();
                                    PbFragment.this.iFX.coj();
                                    PbFragment.this.fHZ.b(id4, name2, id5, i13, PbFragment.this.iFX.col());
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
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.iFX.coF();
                        PbFragment.this.bCF();
                        PbFragment.this.iFX.com();
                        PbFragment.this.iFX.showLoadingDialog();
                        if (PbFragment.this.iFX.cnZ() != null) {
                            PbFragment.this.iFX.cnZ().setVisibility(8);
                        }
                        PbFragment.this.iCx.yL(1);
                        if (PbFragment.this.iFx != null) {
                            PbFragment.this.iFx.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cld = PbFragment.this.cld();
                        if (!TextUtils.isEmpty(cld)) {
                            ba.aEt().b(PbFragment.this.getPageContext(), new String[]{cld});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.cp("tid", PbFragment.this.iCx.cmc());
                anVar8.cp("fid", PbFragment.this.iCx.getForumId());
                anVar8.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.Z("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.iFG) {
                    PbFragment.this.iFG = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.ckX().cnO() != null && postData5.azX() != null && postData5.cJz() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.ckX().cnP() != null) {
                                PbFragment.this.ckX().cnP().ckN();
                            }
                            com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                            mVar2.a(PbFragment.this.iCx.getPbData().getForum());
                            mVar2.setThreadData(PbFragment.this.iCx.getPbData().ciS());
                            mVar2.f(postData5);
                            PbFragment.this.ckX().cnO().d(mVar2);
                            PbFragment.this.ckX().cnO().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.azX().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iCx.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.iGk != null) {
                                PbFragment.this.iFX.qm(PbFragment.this.iGk.aMB());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.z zVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iCx.getPbData() != null) {
                    anVar.cp("fid", PbFragment.this.iCx.getPbData().getForumId());
                }
                anVar.cp("tid", PbFragment.this.iCx.cmc());
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bCF();
            PbFragment.this.iFX.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.ckc() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.ckc().FJ(postWriteCallBackData.getPostId());
                    PbFragment.this.iGx = PbFragment.this.iFX.cnV();
                    PbFragment.this.iCx.cq(PbFragment.this.iGx, PbFragment.this.iFX.cnW());
                }
                PbFragment.this.iFX.coF();
                PbFragment.this.iGb.cpc();
                if (PbFragment.this.iGk != null) {
                    PbFragment.this.iFX.qm(PbFragment.this.iGk.aMB());
                }
                PbFragment.this.iFX.cnN();
                PbFragment.this.iFX.qo(true);
                PbFragment.this.iCx.cmx();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.iCx.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.iCx.getPbData();
                            if (pbData != null && pbData.ciS() != null && pbData.ciS().azX() != null && (userId = pbData.ciS().azX().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.iCx.cmn()) {
                                PbFragment.this.iFX.com();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.iCx.cmn()) {
                            PbFragment.this.iFX.com();
                        }
                    } else if (floor != null) {
                        PbFragment.this.iFX.o(PbFragment.this.iCx.getPbData());
                    }
                    if (PbFragment.this.iCx.cmh()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").cp("tid", PbFragment.this.iCx.cmc()));
                    }
                    PbFragment.this.clg();
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.iGk.aMI() || PbFragment.this.iGk.aMJ()) {
                    PbFragment.this.iGk.a(false, postWriteCallBackData);
                }
                PbFragment.this.iGb.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.hNy != null) {
                    PbFragment.this.hNy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (zVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d iGV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.z zVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                    anVar.cp("fid", PbFragment.this.iCx.getPbData().getForumId());
                }
                if (PbFragment.this.iCx != null) {
                    anVar.cp("tid", PbFragment.this.iCx.cmc());
                }
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.iGb != null) {
                    PbFragment.this.iGb.cpb();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.hNy != null) {
                    PbFragment.this.hNy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.iGb != null) {
                if (PbFragment.this.iFX != null && PbFragment.this.iFX.cnP() != null && PbFragment.this.iFX.cnP().ckR() != null && PbFragment.this.iFX.cnP().ckR().aMJ()) {
                    PbFragment.this.iFX.cnP().ckR().a(postWriteCallBackData);
                }
                PbFragment.this.iGb.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iGW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cpa;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.iFv.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.iFX != null && (cpa = PbFragment.this.iFX.cpa()) != null && PbFragment.this.iFX.getListView() != null) {
                            PbFragment.this.iFX.getListView().removeHeaderView(cpa);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a iGX = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.g lU;
            if (!z || fVar == null || fVar.cjc() != null || com.baidu.tbadk.core.util.v.getCount(fVar.ciU()) >= 1) {
                PbFragment.this.ifS = true;
                PbFragment.this.iFX.coo();
                if (fVar == null || !fVar.ciY()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.iFX.getView());
                }
                PbFragment.this.iFX.bUO();
                if (PbFragment.this.isFullScreen || PbFragment.this.iFX.coX()) {
                    PbFragment.this.iFX.coO();
                } else if (!PbFragment.this.iFX.coL()) {
                    PbFragment.this.iFX.qo(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.dZH = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.iFX.getView());
                    PbFragment.this.iFX.cox();
                }
                if (z && fVar != null) {
                    bj ciS = fVar.ciS();
                    if (ciS == null || !ciS.aBV()) {
                        PbFragment.this.d(PbFragment.this.iGj);
                    } else {
                        clO();
                    }
                    PbFragment.this.iFX.cnP().setPbData(fVar);
                    PbFragment.this.iFX.bem();
                    if (ciS != null && ciS.aBg() != null) {
                        PbFragment.this.a(ciS.aBg());
                    }
                    if (PbFragment.this.iGk != null) {
                        PbFragment.this.iFX.qm(PbFragment.this.iGk.aMB());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.ciU() != null && fVar.ciU().size() >= 1 && fVar.ciU().get(0) != null) {
                        PbFragment.this.iCx.FI(fVar.ciU().get(0).getId());
                    } else if (fVar.cjc() != null) {
                        PbFragment.this.iCx.FI(fVar.cjc().getId());
                    }
                    if (PbFragment.this.iGk != null) {
                        PbFragment.this.iGk.a(fVar.getAnti());
                        PbFragment.this.iGk.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.iGk.setThreadData(ciS);
                        PbFragment.this.iGk.a(PbFragment.this.iCx.cmr(), PbFragment.this.iCx.cmc(), PbFragment.this.iCx.cmL());
                        if (ciS != null) {
                            PbFragment.this.iGk.gB(ciS.aBr());
                        }
                    }
                    if (PbFragment.this.iFV != null) {
                        PbFragment.this.iFV.ff(fVar.aww());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.cjs()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.iFX.qn(PbFragment.this.mIsFromCDN);
                    PbFragment.this.iFX.a(fVar, i2, i3, PbFragment.this.iCx.cmd(), i4, PbFragment.this.iCx.getIsFromMark());
                    PbFragment.this.iFX.d(fVar, PbFragment.this.iCx.cmd());
                    PbFragment.this.iFX.qk(PbFragment.this.iCx.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.duj = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.duj) && PbFragment.this.iGk != null && PbFragment.this.iGk.aLV() != null && (lU = PbFragment.this.iGk.aLV().lU(6)) != null && !TextUtils.isEmpty(PbFragment.this.duj)) {
                            ((View) lU).setOnClickListener(PbFragment.this.duU);
                        }
                    }
                    if (PbFragment.this.iGf) {
                        PbFragment.this.iGf = false;
                        final int clm = PbFragment.this.clm();
                        if (!fVar.cjp()) {
                            PbFragment.this.iFX.yY(clm);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(clm, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.iGg) {
                        PbFragment.this.iGg = false;
                        final int clm2 = PbFragment.this.clm();
                        final boolean z2 = clm2 != -1;
                        if (!z2) {
                            clm2 = PbFragment.this.cln();
                        }
                        if (PbFragment.this.iFX != null) {
                            if (!fVar.cjp()) {
                                PbFragment.this.iFX.yY(clm2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (clm2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.iFX.setSelectionFromTop(clm2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.iFX.setSelectionFromTop(clm2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.iFX.qp(true);
                                PbFragment.this.iFX.qo(false);
                            }
                        }
                    } else if (PbFragment.this.iGh) {
                        PbFragment.this.iGh = false;
                        PbFragment.this.iFX.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.iFX.cos();
                    }
                    PbFragment.this.iCx.a(fVar.getForum(), PbFragment.this.iGL);
                    PbFragment.this.iCx.a(PbFragment.this.iGM);
                    if (PbFragment.this.hNy != null && ciS != null && ciS.azX() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(ciS.azX());
                        PbFragment.this.hNy.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.dZH && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.iCx.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.iCx.getAppealInfo().izC)) {
                                    PbFragment.this.iFX.a(PbFragment.this.iCx.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.iFX.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.iFX.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.iFX.coO();
                            PbFragment.this.iFX.cow();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.iCx.cmc());
                            jSONObject.put("fid", PbFragment.this.iCx.getForumId());
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
                        PbFragment.this.iFX.FN("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                            arrayList = PbFragment.this.iCx.getPbData().ciU();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cJz() != 1)) {
                            PbFragment.this.iFX.FN(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbFragment.this.clG()) {
                            PbFragment.this.iFX.FO(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbFragment.this.iFX.FO(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbFragment.this.iFX.endLoadData();
                }
                if (fVar != null && fVar.izQ && PbFragment.this.dzB == 0) {
                    PbFragment.this.dzB = System.currentTimeMillis() - PbFragment.this.fSK;
                }
                if (!PbFragment.this.ckc().cmd() || PbFragment.this.ckc().getPbData().getPage().ayS() != 0 || PbFragment.this.ckc().cmF()) {
                    PbFragment.this.iGl = true;
                    return;
                }
                return;
            }
            PbFragment.this.iCx.yL(1);
            if (PbFragment.this.iFx != null) {
                PbFragment.this.iFx.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void clO() {
            if (PbFragment.this.iCx != null) {
                if (PbFragment.this.iGk == null || !PbFragment.this.iGk.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.iGk = (com.baidu.tbadk.editortools.pb.e) dVar.dR(PbFragment.this.getContext());
                    PbFragment.this.iGk.a(PbFragment.this.iFv.getPageContext());
                    PbFragment.this.iGk.a(PbFragment.this.dut);
                    PbFragment.this.iGk.a(PbFragment.this.dum);
                    PbFragment.this.iGk.a(PbFragment.this.iFv.getPageContext(), PbFragment.this.iFv.getIntent() == null ? null : PbFragment.this.iFv.getIntent().getExtras());
                    PbFragment.this.iGk.aLV().gu(true);
                    PbFragment.this.iFX.setEditorTools(PbFragment.this.iGk.aLV());
                    if (!PbFragment.this.iCx.cmi()) {
                        PbFragment.this.iGk.uU(PbFragment.this.iCx.cmc());
                    }
                    if (PbFragment.this.iCx.cmM()) {
                        PbFragment.this.iGk.uT(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.iFX != null) {
                        PbFragment.this.iGk.uT(PbFragment.this.iFX.cnT());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.iFX.o(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.aOT().aOU()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.fSK : j;
                if (PbFragment.this.dzB == 0) {
                    PbFragment.this.dzB = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.dzt, PbFragment.this.createTime, PbFragment.this.dzB, z2, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.dzt = 0L;
                if (iVar != null) {
                    iVar.aOQ();
                }
                if (z2) {
                    iVar.dzK = currentTimeMillis;
                    iVar.gM(true);
                }
                if (!z2 && PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().ciS() != null) {
                    int threadType = PbFragment.this.iCx.getPbData().ciS().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iFJ, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iFJ, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.dzM = currentTimeMillis;
                                iVar2.mu(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.dzM = currentTimeMillis;
                        dVar.mu(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener iGY = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.clh();
            }
        }
    };
    private final a.InterfaceC0364a iGZ = new a.InterfaceC0364a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0364a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.iFX.coo();
            if (z) {
                if (PbFragment.this.iFV != null) {
                    PbFragment.this.iFV.ff(z2);
                }
                PbFragment.this.iCx.pU(z2);
                if (PbFragment.this.iCx.aww()) {
                    PbFragment.this.clr();
                } else {
                    PbFragment.this.iFX.o(PbFragment.this.iCx.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.iFV != null) {
                        if (PbFragment.this.iFV.awz() != null && PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().azX() != null) {
                            MarkData awz = PbFragment.this.iFV.awz();
                            MetaData azX = PbFragment.this.iCx.getPbData().ciS().azX();
                            if (awz != null && azX != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), azX.getUserId()) && !azX.hadConcerned()) {
                                    PbFragment.this.b(azX);
                                } else {
                                    PbFragment.this.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    PbFragment.this.clo();
                    return;
                }
                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbFragment.this.yx(PbFragment.this.mLastScrollState) && PbFragment.this.yx(i)) {
                if (PbFragment.this.iFX != null) {
                    PbFragment.this.iFX.coF();
                    if (PbFragment.this.iGk != null && !PbFragment.this.iFX.cnS()) {
                        PbFragment.this.iFX.qm(PbFragment.this.iGk.aMB());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.iFX.cnR();
                    }
                }
                if (!PbFragment.this.iFD) {
                    PbFragment.this.iFD = true;
                    if (PbFragment.this.iFX != null) {
                        PbFragment.this.iFX.coK();
                    }
                }
            }
            if (PbFragment.this.iFX != null) {
                PbFragment.this.iFX.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iFx != null) {
                PbFragment.this.iFx.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iFE == null) {
                PbFragment.this.iFE = new com.baidu.tbadk.n.b();
                PbFragment.this.iFE.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.iFE.aOK();
            } else {
                PbFragment.this.iFE.aOJ();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.r.c.cIu().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> ciU;
            if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null && PbFragment.this.iFX != null && PbFragment.this.iFX.coi() != null) {
                PbFragment.this.iFX.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.iFx != null) {
                    PbFragment.this.iFx.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.iCx.cmA() && (ciU = PbFragment.this.iCx.getPbData().ciU()) != null && !ciU.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.iFX.coi().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.iCx.getPbData();
                    if (pbData != null) {
                        if (pbData.ciV() != null && pbData.ciV().hasData()) {
                            headerCount--;
                        }
                        if (pbData.ciW() != null && pbData.ciW().hasData()) {
                            headerCount--;
                        }
                        int size = ciU.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d fIe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.fHZ.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.iCx.cmx();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.iUh != 1002 || bVar.eHK) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.iFX.a(1, dVar.mSuccess, dVar.kif, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.fHZ.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.iFX.a(PbFragment.this.fHZ.getLoadDataMode(), gVar.mSuccess, gVar.kif, false);
                            PbFragment.this.iFX.aM(gVar.kii);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.iFX.a(PbFragment.this.fHZ.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c iHa = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
    };
    private final g.c dXx = new g.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.clw()) {
                PbFragment.this.iFv.finish();
            }
            if (!PbFragment.this.iCx.pT(true)) {
                PbFragment.this.iFX.cop();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e gGI = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.iHb && PbFragment.this.clw()) {
                PbFragment.this.cly();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.iCx.pS(false)) {
                    PbFragment.this.iFX.con();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.iCx.getPbData() != null) {
                    PbFragment.this.iFX.coJ();
                }
                PbFragment.this.iHb = true;
            }
        }
    };
    private int iHc = 0;
    private final TbRichTextView.i dIr = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f coi;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.iFX.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.cp("tid", PbFragment.this.iCx.cmc());
                anVar.cp("fid", PbFragment.this.iCx.getForumId());
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.Z("obj_locate", 3);
                anVar.Z("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.iCx.iDs.cjs()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        if (view.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aRA() != null) {
                                ArrayList<TbRichTextImageInfo> aRA = tbRichTextView.getRichText().aRA();
                                int i4 = 0;
                                while (i4 < aRA.size()) {
                                    if (aRA.get(i4) != null) {
                                        arrayList.add(aRA.get(i4).getSrc());
                                        if (i3 == -1 && str != null && str.equals(aRA.get(i4).getSrc())) {
                                            i3 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = aRA.get(i4).getSrc();
                                        imageUrlData.originalUrl = aRA.get(i4).getSrc();
                                        imageUrlData.isLongPic = aRA.get(i4).aRY();
                                        concurrentHashMap.put(aRA.get(i4).getSrc(), imageUrlData);
                                    }
                                    i4++;
                                    i3 = i3;
                                }
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.iCx.cmu(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.iCx.getPbData().ciS());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.iCF) {
                        TbRichText bl = PbFragment.this.bl(str, i);
                        if (bl != null && PbFragment.this.iHc >= 0 && PbFragment.this.iHc < bl.aRz().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.g.b(bl.aRz().get(PbFragment.this.iHc));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.iCC.size()) {
                                    break;
                                } else if (!aVar.iCC.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bl.getPostId() != 0 && (coi = PbFragment.this.iFX.coi()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = coi.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bl.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bl.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.iCx.cmL(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iCx.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.iCD.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iCE, aVar.lastId, PbFragment.this.iCx.cmu(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.iCx.getPbData().ciS());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.iCC, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.iCD.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iCE, aVar.iCC.get(0), PbFragment.this.iCx.cmu(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.iCx.getPbData().ciS());
                    }
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.iFN = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean iHd = false;
    PostData hfx = null;
    private final b.a iHe = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.hfx != null) {
                if (i == 0) {
                    PbFragment.this.hfx.fv(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.hfx = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.k(PbFragment.this.hfx);
                }
            }
        }
    };
    private final b.a iHf = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iGu != null && !TextUtils.isEmpty(PbFragment.this.iGv)) {
                if (i == 0) {
                    if (PbFragment.this.iGw == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iGv));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.iGv;
                        aVar.pkgId = PbFragment.this.iGw.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iGw.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.gOz == null) {
                            PbFragment.this.gOz = new au(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.gOz.j(PbFragment.this.iGv, PbFragment.this.iGu.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.iGu = null;
                PbFragment.this.iGv = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a5 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01f8  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            String str;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            int i;
            SparseArray sparseArray;
            if (!PbFragment.this.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (PbFragment.this.cw(view)) {
                    if (view instanceof TbImageView) {
                        PbFragment.this.iGu = ((TbImageView) view).getBdImage();
                        PbFragment.this.iGv = ((TbImageView) view).getUrl();
                        if (PbFragment.this.iGu == null || TextUtils.isEmpty(PbFragment.this.iGv)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iGw = null;
                        } else {
                            PbFragment.this.iGw = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.iGu = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.iGv = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.iGw = null;
                            } else {
                                PbFragment.this.iGw = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.iGu = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.iGv = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iGw = null;
                        } else {
                            PbFragment.this.iGw = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.iFX.a(PbFragment.this.iHf, PbFragment.this.iGu.isGif());
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
            PbFragment.this.hfx = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.hfx == null) {
                return true;
            }
            if (PbFragment.this.hfx.cJz() != 1 || !PbFragment.this.cw(view)) {
                if (PbFragment.this.iFV != null) {
                    if (!PbFragment.this.iFV.aww() || PbFragment.this.hfx.getId() == null || !PbFragment.this.hfx.getId().equals(PbFragment.this.iCx.aAg())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.ckc().getPbData() != null && PbFragment.this.ckc().getPbData().cjs();
                    if (PbFragment.this.hfx.cJz() != 1) {
                        if (PbFragment.this.iGd == null) {
                            PbFragment.this.iGd = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.iGd.a(PbFragment.this.iHg);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = false;
                            boolean z5 = PbFragment.this.cw(view) && !z3;
                            boolean z6 = (!PbFragment.this.cw(view) || PbFragment.this.iGu == null || PbFragment.this.iGu.isGif()) ? false : true;
                            boolean z7 = false;
                            boolean z8 = false;
                            boolean z9 = false;
                            boolean z10 = false;
                            boolean z11 = false;
                            boolean z12 = false;
                            if (sparseArray2.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean) {
                                z4 = ((Boolean) sparseArray2.get(R.id.tag_should_hide_chudian_visible)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean) {
                                z7 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                z8 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                z9 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                z10 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                z11 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                z12 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                            }
                            if (!(sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                str = null;
                            } else {
                                str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
                            }
                            if (z4) {
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
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbFragment.this.getString(R.string.no_interesting), PbFragment.this.iGd);
                                gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                arrayList.add(gVar3);
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.iGd));
                            }
                            if (z6) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.iGd));
                            }
                            if (!z5 && !z6) {
                                com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iGd);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.hfx);
                                gVar4.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar4);
                            }
                            if (!z7 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iGd);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iGd);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.hfx);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z10 && z9) {
                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iGd);
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
                                    if (!ap.o(PbFragment.this.hfx)) {
                                        z2 = PbFragment.this.pI(z8) && TbadkCoreApplication.isLogin();
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2 && !z3) {
                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iGd);
                                        gVar6.mTextView.setTag(str);
                                        arrayList.add(gVar6);
                                    }
                                }
                                com.baidu.tbadk.core.dialog.g gVar7 = null;
                                if (z10) {
                                    SparseArray sparseArray6 = new SparseArray();
                                    sparseArray6.put(R.id.tag_should_manage_visible, true);
                                    sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                    sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                                    sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                                    sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                                    sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                                    if (z11) {
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
                                    if (z12) {
                                        sparseArray6.put(R.id.tag_should_delete_visible, true);
                                        sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z8));
                                        sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                        sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iGd);
                                        gVar7.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iGd);
                                    gVar.mTextView.setTag(sparseArray6);
                                } else {
                                    if (z12) {
                                        SparseArray sparseArray7 = new SparseArray();
                                        sparseArray7.put(R.id.tag_should_manage_visible, false);
                                        sparseArray7.put(R.id.tag_user_mute_visible, false);
                                        sparseArray7.put(R.id.tag_should_delete_visible, true);
                                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z8));
                                        sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                        sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                        if (PbFragment.this.iCx.getPbData().cje() == 1002 && !z8) {
                                            gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iGd);
                                        } else {
                                            gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iGd);
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
                            PbFragment.this.iGd.az(arrayList);
                            PbFragment.this.iGc = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iGd);
                            PbFragment.this.iGc.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").cp("tid", PbFragment.this.iCx.iIx).cp("fid", PbFragment.this.iCx.getForumId()).cp("uid", PbFragment.this.iCx.getPbData().ciS().azX().getUserId()).cp("post_id", PbFragment.this.iCx.aMq()).Z("obj_source", z7 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.iFX.a(PbFragment.this.iHe, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.iFX.a(PbFragment.this.iHf, PbFragment.this.iGu.isGif());
            return true;
        }
    };
    private k.c iHg = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbFragment.this.iGc != null) {
                PbFragment.this.iGc.dismiss();
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
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.iCx.getPbData();
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    if (pbData != null && pbData.getForum() != null) {
                        str2 = pbData.getForum().getId();
                        str3 = pbData.getForum().getName();
                        str4 = pbData.getThreadId();
                    }
                    com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                    PbFragment.this.a(j, str, str2, str3, str4, i2);
                    return;
                case 1:
                    if (PbFragment.this.iGu != null && !TextUtils.isEmpty(PbFragment.this.iGv)) {
                        if (PbFragment.this.iGw == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iGv));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.iGv;
                            aVar.pkgId = PbFragment.this.iGw.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iGw.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.iGu = null;
                        PbFragment.this.iGv = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.iGu != null && !TextUtils.isEmpty(PbFragment.this.iGv)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.gOz == null) {
                                PbFragment.this.gOz = new au(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.gOz.j(PbFragment.this.iGv, PbFragment.this.iGu.getImageByte());
                            PbFragment.this.iGu = null;
                            PbFragment.this.iGv = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.hfx != null) {
                        PbFragment.this.hfx.fv(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.hfx = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").Z("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cv(view);
                        if (PbFragment.this.iCx.getPbData().ciS() != null && PbFragment.this.iCx.getPbData().ciS().azX() != null && PbFragment.this.iCx.getPbData().ciS().azX().getUserId() != null && PbFragment.this.iFV != null) {
                            int g = PbFragment.this.g(PbFragment.this.iCx.getPbData());
                            bj ciS = PbFragment.this.iCx.getPbData().ciS();
                            int i3 = 1;
                            if (ciS.ayL()) {
                                i3 = 2;
                            } else if (ciS.aBS()) {
                                i3 = 3;
                            } else if (ciS.aBT()) {
                                i3 = 4;
                            } else if (ciS.aBU()) {
                                i3 = 5;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cp("tid", PbFragment.this.iCx.iIx).Z("obj_locate", 2).cp("obj_id", PbFragment.this.iCx.getPbData().ciS().azX().getUserId()).Z("obj_type", PbFragment.this.iFV.aww() ? 0 : 1).Z("obj_source", g).Z("obj_param1", i3));
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13079"));
                        PbFragment.this.FA((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").Z("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.b(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.iFX.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
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
                                PbFragment.this.b(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.iFX.cB(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.iFX.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a gjI = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.iCx.cmj()) {
                PbFragment.this.clt();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener dnp = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.gql.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0492a fPc = new a.InterfaceC0492a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        final int eHn = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void y(int i, int i2) {
            if (aw(i2) && PbFragment.this.iFX != null && PbFragment.this.iFx != null) {
                PbFragment.this.iFx.lz(true);
                if (Math.abs(i2) > this.eHn) {
                    PbFragment.this.iFx.hideFloatingView();
                }
                if (PbFragment.this.clw()) {
                    PbFragment.this.iFX.cof();
                    PbFragment.this.iFX.cog();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void z(int i, int i2) {
            if (aw(i2) && PbFragment.this.iFX != null && PbFragment.this.iFx != null) {
                PbFragment.this.iFX.coP();
                PbFragment.this.iFx.lz(false);
                PbFragment.this.iFx.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void bz(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void A(int i, int i2) {
        }

        private boolean aw(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final o.a iED = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.iFX.FP(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int iHi = -1;
    private int iHj = -1;

    /* loaded from: classes7.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes7.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e ckS() {
        return this.iGk;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        boolean z = true;
        if (mVar.cjF() != null) {
            String id = mVar.cjF().getId();
            ArrayList<PostData> ciU = this.iCx.getPbData().ciU();
            int i = 0;
            while (true) {
                if (i >= ciU.size()) {
                    break;
                }
                PostData postData = ciU.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cjJ = mVar.cjJ();
                    postData.Cp(mVar.getTotalCount());
                    if (postData.cJw() != null && cjJ != null) {
                        Iterator<PostData> it = cjJ.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.azX() != null && (metaData = postData.getUserMap().get(next.azX().getUserId())) != null) {
                                next.a(metaData);
                                next.sK(true);
                                next.a(getPageContext(), this.iCx.FH(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cjJ.size() != postData.cJw().size();
                        postData.cJw().clear();
                        postData.cJw().addAll(cjJ);
                        z = z2;
                    }
                    if (postData.cJs() != null) {
                        postData.cJt();
                    }
                }
            }
            if (!this.iCx.getIsFromMark() && z) {
                this.iFX.o(this.iCx.getPbData());
            }
            if (z) {
                c(mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fy(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m cjh = this.iCx.getPbData().cjh();
            if (cjh != null && str.equals(cjh.getAdId())) {
                if (cjh.cJn() != null) {
                    cjh.cJn().legoCard = null;
                }
                this.iCx.getPbData().cji();
            }
            com.baidu.tieba.tbadkCore.data.m cmp = this.iCx.cmp();
            if (cmp != null && str.equals(cmp.getAdId())) {
                this.iCx.cmq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iGc != null && this.iGc.isShowing()) {
                this.iGc.dismiss();
                this.iGc = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.iGc != null) {
                            PbFragment.this.iGc.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.iFX.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.iGs);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.iGs);
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
                kVar.az(arrayList);
                this.iGc = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.iGc.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC(int i) {
        bj ciS;
        if (this.iCx != null && this.iCx.getPbData() != null && (ciS = this.iCx.getPbData().ciS()) != null) {
            if (i == 1) {
                PraiseData azI = ciS.azI();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (azI == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        ciS.a(praiseData);
                    } else {
                        ciS.azI().getUser().add(0, metaData);
                        ciS.azI().setNum(ciS.azI().getNum() + 1);
                        ciS.azI().setIsLike(i);
                    }
                }
                if (ciS.azI() != null) {
                    if (ciS.azI().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(ciS.azI().getNum());
                    }
                }
            } else if (ciS.azI() != null) {
                ciS.azI().setIsLike(i);
                ciS.azI().setNum(ciS.azI().getNum() - 1);
                ArrayList<MetaData> user = ciS.azI().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            ciS.azI().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (ciS.azI().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = ciS.azI().getNum() + "";
                }
            }
            if (this.iCx.cmd()) {
                this.iFX.coi().notifyDataSetChanged();
            } else {
                this.iFX.p(this.iCx.getPbData());
            }
        }
    }

    public static PbFragment ckT() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iFv = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iCx.au(bundle);
        if (this.gmi != null) {
            this.gmi.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.iGk.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iFC = System.currentTimeMillis();
        this.iGq = getPageContext();
        final Intent intent = this.iFv.getIntent();
        if (intent != null) {
            this.fSK = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.iFJ = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.iFJ)) {
                    this.iFJ = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.iFJ)) {
                this.iFy = true;
            }
            this.iHi = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.iHj = intent.getIntExtra("key_manga_next_chapter", -1);
            this.iHk = intent.getStringExtra("key_manga_title");
            this.iGf = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.iGg = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.iGh = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (clw()) {
                this.iFv.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.iGy = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.iFS = new ax();
            this.iFS.R(intent);
            this.iGA = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.iGA == 0) {
                this.iGA = intent.getIntExtra("key_start_from", 0);
            }
            this.iGB = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.fSK = System.currentTimeMillis();
        }
        this.dzt = this.iFC - this.fSK;
        super.onCreate(bundle);
        this.iFA = 0;
        at(bundle);
        if (this.iCx.getPbData() != null) {
            this.iCx.getPbData().Fu(this.source);
        }
        ckW();
        if (intent != null && this.iFX != null) {
            this.iFX.iMm = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.iGt == null) {
                    this.iGt = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.iFX.FR("@" + intent.getStringExtra("big_pic_type") + HanziToPinyin.Token.SEPARATOR);
                        }
                    };
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.iGt, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.iCx.getPbData() != null) {
                this.iCx.FK(stringExtra);
            }
        }
        this.gmi = new VoiceManager();
        this.gmi.onCreate(getPageContext());
        initData(bundle);
        this.iGj = new com.baidu.tbadk.editortools.pb.g();
        d(this.iGj);
        this.iGk = (com.baidu.tbadk.editortools.pb.e) this.iGj.dR(getActivity());
        this.iGk.a(this.iFv.getPageContext());
        this.iGk.a(this.dut);
        this.iGk.a(this.dum);
        this.iGk.a(this.iFv.getPageContext(), bundle);
        this.iGk.aLV().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iGk.aLV().gu(true);
        pH(true);
        this.iGk.a(this.iCx.cmr(), this.iCx.cmc(), this.iCx.cmL());
        registerListener(this.iGG);
        if (!this.iCx.cmi()) {
            this.iGk.uU(this.iCx.cmc());
        }
        if (this.iCx.cmM()) {
            this.iGk.uT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.iFX != null) {
            this.iGk.uT(this.iFX.cnT());
        }
        registerListener(this.iGF);
        registerListener(this.iGH);
        registerListener(this.iGI);
        registerListener(this.gnx);
        registerListener(this.iGU);
        registerListener(this.iGE);
        this.iGi = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.keS);
        this.iGi.cJb();
        registerListener(this.iGK);
        registerListener(this.cWc);
        this.iCx.cmD();
        registerListener(this.iGY);
        registerListener(this.gnE);
        if (this.iFX != null && this.iFX.coT() != null && this.iFX.coU() != null) {
            this.iFx = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.iFX.coT(), this.iFX.coU(), this.iFX.cnZ());
            this.iFx.a(this.iGP);
        }
        if (this.iFw && this.iFX != null && this.iFX.coU() != null) {
            this.iFX.coU().setVisibility(8);
        }
        this.iGr = new com.baidu.tbadk.core.view.d();
        this.iGr.toastTime = 1000L;
        registerListener(this.iGT);
        registerListener(this.iGR);
        registerListener(this.iGS);
        registerListener(this.gDA);
        registerListener(this.gnu);
        registerResponsedEventListener(TipEvent.class, this.glq);
        this.iGs = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iGs;
        userMuteAddAndDelCustomMessage.setTag(this.iGs);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iGs;
        userMuteCheckCustomMessage.setTag(this.iGs);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iCx.cmJ().a(this.iGQ);
        this.iGb = new as();
        if (this.iGk.aMu() != null) {
            this.iGb.e(this.iGk.aMu().getInputView());
        }
        this.iGk.a(this.dun);
        this.gCs = new ShareSuccessReplyToServerModel();
        a(this.iGC);
        this.hNy = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.hNy.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.aj.a
            public void k(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.cVT) {
                        PbFragment.this.iGk.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.cVU && PbFragment.this.iFX != null && PbFragment.this.iFX.cnP() != null && PbFragment.this.iFX.cnP().ckR() != null) {
                        PbFragment.this.iFX.cnP().ckR().aMQ();
                    } else if (i == com.baidu.tbadk.core.util.aj.cVV) {
                        PbFragment.this.c(PbFragment.this.iGn);
                    }
                }
            }
        });
        this.iFU = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.iFU.t(getUniqueId());
        com.baidu.tieba.r.c.cIu().w(getUniqueId());
        com.baidu.tbadk.core.business.a.axK().cf("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.iFC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.iCx != null) {
            gVar.setForumName(this.iCx.cjS());
            if (this.iCx.getPbData() != null && this.iCx.getPbData().getForum() != null) {
                gVar.a(this.iCx.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.iCx);
        }
    }

    public String ckU() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b ckV() {
        return this.iFx;
    }

    private void pH(boolean z) {
        this.iGk.gy(z);
        this.iGk.gz(z);
        this.iGk.gA(z);
    }

    private void ckW() {
        this.dfN = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    public aq ckX() {
        return this.iFX;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel ckc() {
        return this.iCx;
    }

    public void Fz(String str) {
        if (this.iCx != null && !StringUtils.isNull(str) && this.iFX != null) {
            this.iFX.qr(true);
            this.iCx.Fz(str);
            this.iFI = true;
            this.iFX.coF();
            this.iFX.coO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.isPaused = false;
        } else {
            this.isPaused = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.iFA = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.iFA == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
        if (this.iFX != null) {
            this.iFX.onPause();
        }
        if (!this.iCx.cmi()) {
            this.iGk.saveDraft(this.iCx.cmc());
        }
        if (this.iCx != null) {
            this.iCx.cmE();
        }
        com.baidu.tbadk.BdToken.c.avj().avo();
        MessageManager.getInstance().unRegisterListener(this.hrx);
        bOs();
        MessageManager.getInstance().unRegisterListener(this.iGR);
        MessageManager.getInstance().unRegisterListener(this.iGS);
        MessageManager.getInstance().unRegisterListener(this.iGT);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean ckY() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.iCx.getPbData(), this.iCx.cmd(), this.iCx.cmB());
        return (a2 == null || a2.azX() == null || a2.azX().getGodUserData() == null || a2.azX().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.iFL) {
            this.iFL = false;
            clC();
        }
        if (ckY()) {
            this.iFF = System.currentTimeMillis();
        } else {
            this.iFF = -1L;
        }
        if (this.iFX != null && this.iFX.getView() != null) {
            if (!this.ifS) {
                clu();
            } else {
                hideLoadingView(this.iFX.getView());
            }
            this.iFX.onResume();
        }
        if (this.iFA == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.iFX != null) {
            noNetworkView = this.iFX.cnM();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
        }
        registerListener(this.hrx);
        this.iGe = false;
        clB();
        registerListener(this.iGR);
        registerListener(this.iGS);
        registerListener(this.iGT);
        if (this.gmV) {
            clt();
            this.gmV = false;
        }
        clI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.iFX.qg(z);
        if (this.iGc != null) {
            this.iGc.dismiss();
        }
        if (z && this.iGe) {
            this.iFX.con();
            this.iCx.pS(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iFF > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").cp("obj_duration", (System.currentTimeMillis() - this.iFF) + ""));
            this.iFF = 0L;
        }
        if (ckX().cnP() != null) {
            ckX().cnP().onStop();
        }
        if (this.iFX.iMo != null && !this.iFX.iMo.cpK()) {
            this.iFX.iMo.releaseResources();
        }
        if (this.iCx != null && this.iCx.getPbData() != null && this.iCx.getPbData().getForum() != null && this.iCx.getPbData().ciS() != null) {
            com.baidu.tbadk.distribute.a.aLJ().a(getPageContext().getPageActivity(), "pb", this.iCx.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iCx.getPbData().ciS().getId(), 0L));
        }
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
        com.baidu.tieba.r.c.cIu().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.r.c.cIu().x(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cp("fid", this.iCx.getPbData().getForumId());
            anVar.cp("tid", this.iCx.cmc());
            anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.iFD && this.iFX != null) {
            this.iFD = true;
            this.iFX.coK();
            a(false, (PostData) null);
        }
        if (this.iCx != null) {
            this.iCx.cancelLoadData();
            this.iCx.destory();
            if (this.iCx.cmI() != null) {
                this.iCx.cmI().onDestroy();
            }
        }
        if (this.iGk != null) {
            this.iGk.onDestroy();
        }
        if (this.fHZ != null) {
            this.fHZ.cancelLoadData();
        }
        if (this.dfN != null) {
            this.dfN.cIO();
        }
        if (this.iFX != null) {
            this.iFX.onDestroy();
            if (this.iFX.iMo != null) {
                this.iFX.iMo.releaseResources();
            }
        }
        if (this.iFE != null) {
            this.iFE.aOL();
        }
        if (this.iFx != null) {
            this.iFx.aUq();
        }
        super.onDestroy();
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
        if (this.iFX != null) {
            this.iFX.coF();
        }
        MessageManager.getInstance().unRegisterListener(this.iGR);
        MessageManager.getInstance().unRegisterListener(this.iGS);
        MessageManager.getInstance().unRegisterListener(this.iGT);
        MessageManager.getInstance().unRegisterListener(this.iGs);
        MessageManager.getInstance().unRegisterListener(this.iGU);
        MessageManager.getInstance().unRegisterListener(this.gnE);
        MessageManager.getInstance().unRegisterListener(this.gDA);
        MessageManager.getInstance().unRegisterListener(this.iGW);
        this.iGq = null;
        this.iGr = null;
        com.baidu.tieba.recapp.d.a.cBM().cBO();
        if (this.iGt != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iGt);
        }
        if (this.iFM != null) {
            this.iFM.cancelLoadData();
        }
        if (this.iFX != null && this.iFX.iMo != null) {
            this.iFX.iMo.cpN();
        }
        if (this.gCs != null) {
            this.gCs.cancelLoadData();
        }
        this.iGb.onDestroy();
        if (this.iCx != null && this.iCx.cmK() != null) {
            this.iCx.cmK().onDestroy();
        }
        if (this.hNy != null) {
            this.hNy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f coi;
        ArrayList<PostData> ckC;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aGN() && this.iFX != null && (coi = this.iFX.coi()) != null && (ckC = coi.ckC()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = ckC.iterator();
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
                        bVar.fJU = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.cOH == 1 && !TextUtils.isEmpty(id)) {
                    next.cOH = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.fJU = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.iCx == null || this.iCx.getPbData() == null || this.iCx.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.iCx.getPbData().getForum().getFirst_class();
                    str2 = this.iCx.getPbData().getForum().getSecond_class();
                    str = this.iCx.getPbData().getForum().getId();
                    str4 = this.iCx.cmc();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aGQ());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.iFX.onChangeSkinType(i);
            if (this.iGk != null && this.iGk.aLV() != null) {
                this.iGk.aLV().onChangeSkinType(i);
            }
            if (this.iFX.cnM() != null) {
                this.iFX.cnM().onChangeSkinType(getPageContext(), i);
            }
            this.iGb.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iFX = new aq(this, this.gon, this.dmA);
        this.gql = new com.baidu.tieba.f.b(getActivity());
        this.gql.a(iHh);
        this.gql.a(this.fPc);
        this.iFX.setOnScrollListener(this.mOnScrollListener);
        this.iFX.d(this.gGI);
        this.iFX.setListPullRefreshListener(this.dXx);
        this.iFX.pt(com.baidu.tbadk.core.i.axy().isShowImages());
        this.iFX.setOnImageClickListener(this.dIr);
        this.iFX.b(this.mOnLongClickListener);
        this.iFX.g(this.gjI);
        this.iFX.a(this.iHa);
        this.iFX.qg(this.mIsLogin);
        if (this.iFv.getIntent() != null) {
            this.iFX.qs(this.iFv.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.iFX.cnO().setFromForumId(this.iCx.getFromForumId());
        this.iFX.setEditorTools(this.iGk.aLV());
        this.iGk.uT(this.iFX.cnT());
        this.iFX.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.iCx.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iCx.getPbData().getForum().getId(), PbFragment.this.iCx.getPbData().getForum().getName(), PbFragment.this.iCx.getPbData().ciS().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.iFX.getView();
    }

    public void ckZ() {
        if (this.iFX != null && this.iCx != null) {
            if ((this.iCx.getPbData() != null || this.iCx.getPbData().cjo() != null) && checkUpIsLogin() && this.iFX.coi() != null && this.iFX.coi().ckH() != null) {
                this.iFX.coi().ckH().tH(this.iCx.cmc());
            }
        }
    }

    public void cla() {
        TiebaStatic.log("c12181");
        if (this.iFX != null && this.iCx != null) {
            if ((this.iFX == null || this.iFX.cnS()) && this.iCx.getPbData() != null && this.iCx.getPbData().cjo() != null) {
                com.baidu.tieba.pb.data.l cjo = this.iCx.getPbData().cjo();
                if (checkUpIsLogin()) {
                    if ((!cjo.cjC() || cjo.aBv() != 2) && this.iFX.coi() != null && this.iFX.coi().ckH() != null) {
                        this.iFX.coi().ckH().tH(this.iCx.cmc());
                    }
                    if (System.currentTimeMillis() - this.iFH > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).qY(false);
                        this.iFH = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cu(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.kfs && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.axy().isShowImages()) {
                    return FD(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.iCx == null || this.iCx.getPbData() == null) {
                        return true;
                    }
                    if (ckX().cnP() != null) {
                        ckX().cnP().ckN();
                    }
                    com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                    mVar.a(this.iCx.getPbData().getForum());
                    mVar.setThreadData(this.iCx.getPbData().ciS());
                    mVar.f(postData);
                    ckX().cnO().d(mVar);
                    ckX().cnO().setPostId(postData.getId());
                    b(view, postData.azX().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iGk != null) {
                        this.iFX.qm(this.iGk.aMB());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void clb() {
        if (this.iFB == null) {
            this.iFB = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.iFB.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.iCs = PbFragment.this.iCs.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iCs);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iCx.cmc(), PbFragment.this.iCs, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.iCs = PbFragment.this.iCs.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iCs);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iCx.cmc(), PbFragment.this.iCs, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.iCs = PbFragment.this.iCs.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iCs);
                        bVar.dismiss();
                    }
                }
            }).jK(R.style.dialog_ani_b2t).jL(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.iGX.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).crJ(), "", 1);
    }

    private void at(Bundle bundle) {
        this.iCx = this.iFv.ckc();
        if (this.iCx.cmH() != null) {
            this.iCx.cmH().a(this.iED);
        }
        if (this.iCx.cmG() != null) {
            this.iCx.cmG().a(this.iGJ);
        }
        if (this.iCx.cmI() != null) {
            this.iCx.cmI().b(this.iGD);
        }
        if (StringUtils.isNull(this.iCx.cmc())) {
            this.iFv.finish();
        } else if ("from_tieba_kuang".equals(this.iFJ) && this.iFJ != null) {
            this.iCx.yS(6);
        }
    }

    private void initData(Bundle bundle) {
        this.iFV = com.baidu.tbadk.baseEditMark.a.a(this.iFv);
        if (this.iFV != null) {
            this.iFV.a(this.iGZ);
        }
        this.fHZ = new ForumManageModel(this.iFv);
        this.fHZ.setLoadDataCallBack(this.fIe);
        this.cVY = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iGO.setUniqueId(getUniqueId());
        this.iGO.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iFX.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iGs;
        userMuteCheckCustomMessage.setTag(this.iGs);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void clc() {
        if (checkUpIsLogin() && this.iCx != null && this.iCx.getPbData() != null && this.iCx.getPbData().getForum() != null) {
            if (this.iCx.getPbData().cjs()) {
                this.iFX.bNT();
                return;
            }
            if (this.gpJ == null) {
                this.gpJ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.gpJ.tJ(0);
                this.gpJ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lt(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void s(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lu(boolean z) {
                        if (z) {
                            PbFragment.this.iFX.bNT();
                        }
                    }
                });
            }
            this.gpJ.C(this.iCx.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iCx.cmc(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cld() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.iCx == null || (pbData = this.iCx.getPbData()) == null) {
            return null;
        }
        return pbData.cjd().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.ciS() != null) {
            if (fVar.ciS().getThreadType() == 0) {
                return 1;
            }
            if (fVar.ciS().getThreadType() == 54) {
                return 2;
            }
            if (fVar.ciS().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && cle()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iFO);
                this.iFP = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.iCx.getPbData() != null && this.iCx.getPbData().cjs()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.iFv.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.ckX().getListView().smoothScrollBy((PbFragment.this.iFO[1] + PbFragment.this.iFP) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.ckX().cnP() != null) {
                            PbFragment.this.iGk.aLV().setVisibility(8);
                            PbFragment.this.ckX().cnP().g(str, str2, PbFragment.this.ckX().cnT(), (PbFragment.this.iCx == null || PbFragment.this.iCx.getPbData() == null || PbFragment.this.iCx.getPbData().ciS() == null || !PbFragment.this.iCx.getPbData().ciS().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h ckR = PbFragment.this.ckX().cnP().ckR();
                            if (ckR != null && PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                ckR.a(PbFragment.this.iCx.getPbData().getAnti());
                                ckR.setThreadData(PbFragment.this.iCx.getPbData().ciS());
                            }
                            if (PbFragment.this.iGb.cpf() == null && PbFragment.this.ckX().cnP().ckR().aMY() != null) {
                                PbFragment.this.ckX().cnP().ckR().aMY().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iGb != null && PbFragment.this.iGb.cpe() != null) {
                                            if (!PbFragment.this.iGb.cpe().cSP()) {
                                                PbFragment.this.iGb.qu(false);
                                            }
                                            PbFragment.this.iGb.cpe().tD(false);
                                        }
                                    }
                                });
                                PbFragment.this.iGb.f(PbFragment.this.ckX().cnP().ckR().aMY().getInputView());
                                PbFragment.this.ckX().cnP().ckR().a(PbFragment.this.iGp);
                            }
                        }
                        PbFragment.this.ckX().coO();
                    }
                }, 0L);
                return;
            }
            if (this.iGm == null) {
                this.iGm = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iGm.tJ(1);
                this.iGm.a(new AnonymousClass38(str, str2));
            }
            if (this.iCx != null && this.iCx.getPbData() != null && this.iCx.getPbData().getForum() != null) {
                this.iGm.C(this.iCx.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iCx.cmc(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$38  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass38 implements c.a {
        final /* synthetic */ String iHt;
        final /* synthetic */ String iHu;

        AnonymousClass38(String str, String str2) {
            this.iHt = str;
            this.iHu = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lt(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void s(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lu(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.ckX().getListView().smoothScrollBy((PbFragment.this.iFO[1] + PbFragment.this.iFP) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.ckX().cnP() != null) {
                            PbFragment.this.iGk.aLV().setVisibility(8);
                            PbFragment.this.ckX().cnP().g(AnonymousClass38.this.iHt, AnonymousClass38.this.iHu, PbFragment.this.ckX().cnT(), (PbFragment.this.iCx == null || PbFragment.this.iCx.getPbData() == null || PbFragment.this.iCx.getPbData().ciS() == null || !PbFragment.this.iCx.getPbData().ciS().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h ckR = PbFragment.this.ckX().cnP().ckR();
                            if (ckR != null && PbFragment.this.iCx != null && PbFragment.this.iCx.getPbData() != null) {
                                ckR.a(PbFragment.this.iCx.getPbData().getAnti());
                                ckR.setThreadData(PbFragment.this.iCx.getPbData().ciS());
                            }
                            if (PbFragment.this.iGb.cpf() == null && PbFragment.this.ckX().cnP().ckR().aMY() != null) {
                                PbFragment.this.ckX().cnP().ckR().aMY().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iGb != null && PbFragment.this.iGb.cpe() != null) {
                                            if (!PbFragment.this.iGb.cpe().cSP()) {
                                                PbFragment.this.iGb.qu(false);
                                            }
                                            PbFragment.this.iGb.cpe().tD(false);
                                        }
                                    }
                                });
                                PbFragment.this.iGb.f(PbFragment.this.ckX().cnP().ckR().aMY().getInputView());
                                PbFragment.this.ckX().cnP().ckR().a(PbFragment.this.iGp);
                            }
                        }
                        PbFragment.this.ckX().coO();
                    }
                }, 0L);
            }
        }
    }

    public boolean cle() {
        if ((this.iCx.getPbData() != null && this.iCx.getPbData().cjs()) || this.hNy == null || this.iCx.getPbData() == null || this.iCx.getPbData().getAnti() == null) {
            return true;
        }
        return this.hNy.kb(this.iCx.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean yG(int i) {
        if (this.hNy == null || this.iCx.getPbData() == null || this.iCx.getPbData().getAnti() == null) {
            return true;
        }
        return this.hNy.ax(this.iCx.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.iCx != null && this.iCx.getPbData() != null && postData.cJz() != 1) {
            String cmc = this.iCx.cmc();
            String id = postData.getId();
            int cje = this.iCx.getPbData() != null ? this.iCx.getPbData().cje() : 0;
            PbActivity.a FE = FE(id);
            if (FE != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cmc, id, "pb", true, null, false, null, cje, postData.cqG(), this.iCx.getPbData().getAnti(), false, postData.azX() != null ? postData.azX().getIconInfo() : null).addBigImageData(FE.iCC, FE.iCD, FE.iCE, FE.index);
                addBigImageData.setKeyPageStartFrom(this.iCx.cmO());
                addBigImageData.setFromFrsForumId(this.iCx.getFromForumId());
                addBigImageData.setKeyFromForumId(this.iCx.getForumId());
                addBigImageData.setBjhData(this.iCx.cmk());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int clf() {
        if (this.iCx.getPbData() == null || this.iCx.getPbData().ciS() == null) {
            return -1;
        }
        return this.iCx.getPbData().ciS().aAH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clg() {
        if (this.iCx != null && this.iCx.iDs != null && this.iCx.iDs.ciS() != null) {
            bj ciS = this.iCx.iDs.ciS();
            ciS.mRecomAbTag = this.iCx.cmZ();
            ciS.mRecomWeight = this.iCx.cmX();
            ciS.mRecomSource = this.iCx.cmY();
            ciS.mRecomExtra = this.iCx.cna();
            if (ciS.getFid() == 0) {
                ciS.setFid(com.baidu.adp.lib.f.b.toLong(this.iCx.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ciS, "c13563");
            if (a2 != null) {
                a2.Z("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clh() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Ii(this.iCx.getForumId()) && this.iCx.getPbData() != null && this.iCx.getPbData().getForum() != null) {
            if (this.iCx.getPbData().getForum().isLike() == 1) {
                this.iCx.cmK().em(this.iCx.getForumId(), this.iCx.cmc());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pI(boolean z) {
        if (this.iCx == null || this.iCx.getPbData() == null) {
            return false;
        }
        return ((this.iCx.getPbData().cje() != 0) || this.iCx.getPbData().ciS() == null || this.iCx.getPbData().ciS().azX() == null || TextUtils.equals(this.iCx.getPbData().ciS().azX().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String cli() {
        com.baidu.tieba.pb.data.f pbData;
        if (!FansCallSwitch.getIsOn()) {
            return "";
        }
        PostData ciZ = ciZ();
        if (this.iCx == null || (pbData = this.iCx.getPbData()) == null || pbData.getUserData() == null || pbData.ciS() == null || ciZ == null || ciZ.azX() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !ciZ.azX().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.ciS().azD() == 0) {
            return "";
        }
        if (pbData.ciS().azD() == 0) {
            return getPageContext().getString(R.string.fans_call);
        }
        return getPageContext().getString(R.string.haved_fans_call);
    }

    private boolean pJ(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.w wVar;
        if (this.iCx == null || this.iCx.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.iCx.getPbData();
        bj ciS = pbData.ciS();
        if (ciS != null) {
            if (ciS.ayL() || ciS.aBS()) {
                return false;
            }
            if (ciS.aBT() || ciS.aBU()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cje() != 0) {
                return pbData.cje() != 3;
            }
            List<bf> cjm = pbData.cjm();
            if (com.baidu.tbadk.core.util.v.getCount(cjm) > 0) {
                for (bf bfVar : cjm) {
                    if (bfVar != null && (wVar = bfVar.cML) != null && wVar.cKF && !wVar.cKG && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean pK(boolean z) {
        if (z || this.iCx == null || this.iCx.getPbData() == null) {
            return false;
        }
        return ((this.iCx.getPbData().getForum() != null && this.iCx.getPbData().getForum().isBlockBawuDelete) || this.iCx.getPbData().cje() == 0 || this.iCx.getPbData().cje() == 3) ? false : true;
    }

    public void clj() {
        com.baidu.tieba.pb.data.f pbData;
        bj ciS;
        if (this.iCx != null && this.iCx.getPbData() != null && (ciS = (pbData = this.iCx.getPbData()).ciS()) != null && ciS.azX() != null) {
            this.iFX.cnN();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), ciS.azX().getUserId());
            ac acVar = new ac();
            int cje = this.iCx.getPbData().cje();
            if (cje == 1 || cje == 3) {
                acVar.iKD = true;
                acVar.iKC = true;
                acVar.iKJ = ciS.azS() == 1;
                acVar.iKI = ciS.azT() == 1;
            } else {
                acVar.iKD = false;
                acVar.iKC = false;
            }
            if (cje == 1002 && !equals) {
                acVar.iKK = true;
            }
            acVar.iKA = pJ(equals);
            acVar.iKE = clk();
            acVar.iKB = pK(equals);
            acVar.hS = this.iCx.cmd();
            acVar.iKx = true;
            acVar.iKw = pI(equals);
            acVar.iKG = cli();
            acVar.iKv = equals && this.iFX.cou();
            acVar.iKH = TbadkCoreApplication.getInst().getSkinType() == 1;
            acVar.iKF = true;
            acVar.isHostOnly = this.iCx.getHostMode();
            acVar.iKz = true;
            if (ciS.aAo() == null) {
                acVar.iKy = true;
            } else {
                acVar.iKy = false;
            }
            if (pbData.cjs()) {
                acVar.iKx = false;
                acVar.iKz = false;
                acVar.iKy = false;
                acVar.iKC = false;
                acVar.iKD = false;
            }
            this.iFX.iMo.a(acVar);
        }
    }

    private boolean clk() {
        if (this.iCx != null && this.iCx.cmd()) {
            return this.iCx.getPageData() == null || this.iCx.getPageData().ayS() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            k(postData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cll() {
        return this.iGX;
    }

    public int clm() {
        if (ckX() == null || ckX().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = ckX().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.k) && ((com.baidu.tieba.pb.data.k) mVar).zN == com.baidu.tieba.pb.data.k.iAJ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cln() {
        if (ckX() == null || ckX().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = ckX().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.kfr) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        clt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clo() {
        if (this.iCx != null && this.iCx.iDs != null && this.iCx.iDs.ciS() != null) {
            bj ciS = this.iCx.iDs.ciS();
            ciS.mRecomAbTag = this.iCx.cmZ();
            ciS.mRecomWeight = this.iCx.cmX();
            ciS.mRecomSource = this.iCx.cmY();
            ciS.mRecomExtra = this.iCx.cna();
            if (ciS.getFid() == 0) {
                ciS.setFid(com.baidu.adp.lib.f.b.toLong(this.iCx.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ciS, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.sB(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sC(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fz(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cp("obj_id", metaData.getUserId()).Z("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cp("obj_id", metaData.getUserId()).Z("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.cVY.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.iCx.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aCp();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.iFX.coo();
        this.iCx.pU(z);
        if (this.iFV != null) {
            this.iFV.ff(z);
            if (markData != null) {
                this.iFV.a(markData);
            }
        }
        if (this.iCx.aww()) {
            clr();
        } else {
            this.iFX.o(this.iCx.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yx(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA(String str) {
        if (this.iCx != null && this.iCx.getPbData() != null && this.iCx.getPbData().cjs()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iCx.cmc(), str);
            bj ciS = this.iCx.getPbData().ciS();
            if (ciS.ayL()) {
                format = format + "&channelid=33833";
            } else if (ciS.aBR()) {
                format = format + "&channelid=33842";
            } else if (ciS.aBS()) {
                format = format + "&channelid=33840";
            }
            FB(format);
            return;
        }
        this.iFU.Ga(str);
    }

    private void FB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.iCx.cmi()) {
                    antiData.setBlock_forum_name(this.iCx.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.iCx.getPbData().getForum().getId());
                    antiData.setUser_name(this.iCx.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.iCx.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (ckX() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bc(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            uZ(str);
        } else {
            this.iFX.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.kif) ? bVar.kif : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sC(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fz(true);
                aVar.b(getPageContext());
                aVar.aCp();
            } else {
                this.iFX.a(0, bVar.mSuccess, bVar.kif, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fVU == 1) {
                    ArrayList<PostData> ciU = this.iCx.getPbData().ciU();
                    int size = ciU.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(ciU.get(i).getId())) {
                            i++;
                        } else {
                            ciU.remove(i);
                            break;
                        }
                    }
                    this.iCx.getPbData().ciS().js(this.iCx.getPbData().ciS().azO() - 1);
                    this.iFX.o(this.iCx.getPbData());
                } else if (bVar.fVU == 0) {
                    clp();
                } else if (bVar.fVU == 2) {
                    ArrayList<PostData> ciU2 = this.iCx.getPbData().ciU();
                    int size2 = ciU2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ciU2.get(i2).cJw().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(ciU2.get(i2).cJw().get(i3).getId())) {
                                i3++;
                            } else {
                                ciU2.get(i2).cJw().remove(i3);
                                ciU2.get(i2).cJy();
                                z2 = true;
                                break;
                            }
                        }
                        ciU2.get(i2).IN(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.iFX.o(this.iCx.getPbData());
                    }
                    a(bVar, this.iFX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.iFX.a(this.fHZ.getLoadDataMode(), gVar.mSuccess, gVar.kif, false);
            if (gVar.mSuccess) {
                this.iFY = true;
                if (i == 2 || i == 3) {
                    this.iFZ = true;
                    this.iGa = false;
                } else if (i == 4 || i == 5) {
                    this.iFZ = false;
                    this.iGa = true;
                }
                if (i == 2) {
                    this.iCx.getPbData().ciS().jv(1);
                    this.iCx.setIsGood(1);
                } else if (i == 3) {
                    this.iCx.getPbData().ciS().jv(0);
                    this.iCx.setIsGood(0);
                } else if (i == 4) {
                    this.iCx.getPbData().ciS().ju(1);
                    this.iCx.yK(1);
                } else if (i == 5) {
                    this.iCx.getPbData().ciS().ju(0);
                    this.iCx.yK(0);
                }
                this.iFX.c(this.iCx.getPbData(), this.iCx.cmd());
            }
        }
    }

    private void clp() {
        if (this.iCx.cme() || this.iCx.cmg()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.iCx.cmc());
            PbActivity pbActivity = this.iFv;
            PbActivity pbActivity2 = this.iFv;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.iCx.cmc()));
        if (cls()) {
            this.iFv.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckr() {
        this.iFv.ckr();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cjb;
        boolean z = false;
        if (this.iFX != null) {
            this.iFX.coF();
        }
        if (this.iCx != null && this.iCx.getPbData() != null && !this.iCx.getPbData().cjs()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.iCx.getPbData().ciS().getId();
            if (this.iCx.isShareThread() && this.iCx.getPbData().ciS().cPN != null) {
                historyMessage.threadName = this.iCx.getPbData().ciS().cPN.showText;
            } else {
                historyMessage.threadName = this.iCx.getPbData().ciS().getTitle();
            }
            if (this.iCx.isShareThread() && !cjR()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.iCx.getPbData().getForum().getName();
            }
            ArrayList<PostData> ciU = this.iCx.getPbData().ciU();
            int coq = this.iFX != null ? this.iFX.coq() : 0;
            if (ciU != null && coq >= 0 && coq < ciU.size()) {
                historyMessage.postID = ciU.get(coq).getId();
            }
            historyMessage.isHostOnly = this.iCx.getHostMode();
            historyMessage.isSquence = this.iCx.cmd();
            historyMessage.isShareThread = this.iCx.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iGk != null) {
            this.iGk.onDestroy();
        }
        if (this.iFz && ckX() != null) {
            ckX().coY();
        }
        if (this.iCx != null && (this.iCx.cme() || this.iCx.cmg())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.iCx.cmc());
            if (this.iFY) {
                if (this.iGa) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.iCx.bwl());
                }
                if (this.iFZ) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.iCx.getIsGood());
                }
            }
            if (this.iCx.getPbData() != null && System.currentTimeMillis() - this.iFC >= 40000 && (cjb = this.iCx.getPbData().cjb()) != null && !com.baidu.tbadk.core.util.v.isEmpty(cjb.getDataList())) {
                intent.putExtra("guess_like_data", cjb);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.iGy);
            }
            PbActivity pbActivity = this.iFv;
            PbActivity pbActivity2 = this.iFv;
            pbActivity.setResult(-1, intent);
        }
        if (cls()) {
            if (this.iCx != null && this.iFX != null && this.iFX.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.iCx.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.ciY() && !this.iFI && pbData.izL == null) {
                        ak cnx = ak.cnx();
                        com.baidu.tieba.pb.data.f cml = this.iCx.cml();
                        Parcelable onSaveInstanceState = this.iFX.getListView().onSaveInstanceState();
                        boolean cmd = this.iCx.cmd();
                        boolean hostMode = this.iCx.getHostMode();
                        if (this.iFX.cnZ() != null && this.iFX.cnZ().getVisibility() == 0) {
                            z = true;
                        }
                        cnx.a(cml, onSaveInstanceState, cmd, hostMode, z);
                        if (this.iGx >= 0 || this.iCx.cmQ() != null) {
                            ak.cnx().n(this.iCx.cmQ());
                            ak.cnx().m(this.iCx.cmR());
                            ak.cnx().yU(this.iCx.cmS());
                        }
                    }
                }
            } else {
                ak.cnx().reset();
            }
            ckr();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.iFX == null || !this.iFX.za(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yH(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iFv;
        if (i == 0) {
            this.iFX.cnN();
            this.iFX.cnP().ckN();
            this.iFX.qo(false);
        }
        this.iFX.cnR();
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
                        this.iGk.resetData();
                        this.iGk.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iGk.b(writeData);
                        com.baidu.tbadk.editortools.l lX = this.iGk.aLV().lX(6);
                        if (lX != null && lX.dss != null) {
                            lX.dss.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iFv;
                        if (i == -1) {
                            this.iGk.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iFX.cnP() != null && this.iFX.cnP().ckR() != null) {
                            com.baidu.tbadk.editortools.pb.h ckR = this.iFX.cnP().ckR();
                            ckR.setThreadData(this.iCx.getPbData().ciS());
                            ckR.b(writeData);
                            ckR.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l lX2 = ckR.aLV().lX(6);
                            if (lX2 != null && lX2.dss != null) {
                                lX2.dss.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iFv;
                            if (i == -1) {
                                ckR.aMQ();
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
        this.iGk.onActivityResult(i, i2, intent);
        if (this.iFM != null) {
            this.iFM.onActivityResult(i, i2, intent);
        }
        if (ckX().cnP() != null) {
            ckX().cnP().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    clq();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ak.cnx().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.iCx != null) {
                                PbFragment.this.iCx.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.n.a.cAC().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.iCx != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    aj(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.cAC().A(getPageContext());
                        clh();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.gCs != null && shareItem != null && shareItem.linkUrl != null) {
                            this.gCs.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aJp() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57.1
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
                    this.iFX.py(false);
                    if (this.iCx.getPbData() != null && this.iCx.getPbData().ciS() != null && this.iCx.getPbData().ciS().aAr() != null) {
                        this.iCx.getPbData().ciS().aAr().setStatus(2);
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
                        this.iGn = emotionImageData;
                        if (yG(com.baidu.tbadk.core.util.aj.cVV)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.FANS_CALL_JUMP_BACK /* 25028 */:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.iFX != null && this.iFX.iMo != null) {
                        this.iFX.iMo.apF();
                        this.iFX.iMo.cpF();
                        if (this.iCx != null && this.iCx.getPbData() != null && this.iCx.getPbData().ciS() != null) {
                            this.iCx.getPbData().ciS().jp(1);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.iFN != null) {
                        this.iFX.cC(this.iFN);
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
            if (this.iFM == null) {
                this.iFM = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iFv);
                this.iFM.b(this.dum);
                this.iFM.c(this.dut);
            }
            this.iFM.a(emotionImageData, ckc(), ckc().getPbData());
        }
    }

    private void aj(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clq() {
        MarkData yR;
        if (this.iFV != null) {
            if (this.iCx.getPbData() != null && this.iCx.getPbData().cjs()) {
                yR = this.iCx.yR(0);
            } else {
                yR = this.iCx.yR(this.iFX.cor());
            }
            if (yR != null) {
                if (!yR.isApp() || (yR = this.iCx.yR(this.iFX.cor() + 1)) != null) {
                    this.iFX.com();
                    this.iFV.a(yR);
                    if (!this.iFV.aww()) {
                        this.iFV.awy();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iFV.awx();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clr() {
        com.baidu.tieba.pb.data.f pbData = this.iCx.getPbData();
        this.iCx.pU(true);
        if (this.iFV != null) {
            pbData.Ft(this.iFV.awv());
        }
        this.iFX.o(pbData);
    }

    private boolean cls() {
        if (this.iCx == null) {
            return true;
        }
        if (this.iCx.getPbData() == null || !this.iCx.getPbData().cjs()) {
            if (this.iCx.aww()) {
                final MarkData cmw = this.iCx.cmw();
                if (cmw == null || !this.iCx.getIsFromMark()) {
                    return true;
                }
                final MarkData yR = this.iCx.yR(this.iFX.coq());
                if (yR == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cmw);
                    this.iFv.setResult(-1, intent);
                    return true;
                } else if (yR.getPostId() == null || yR.getPostId().equals(cmw.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cmw);
                    this.iFv.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.sC(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.iFV != null) {
                                if (PbFragment.this.iFV.aww()) {
                                    PbFragment.this.iFV.awx();
                                    PbFragment.this.iFV.ff(false);
                                }
                                PbFragment.this.iFV.a(yR);
                                PbFragment.this.iFV.ff(true);
                                PbFragment.this.iFV.awy();
                            }
                            cmw.setPostId(yR.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cmw);
                            PbFragment.this.iFv.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.ckr();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cmw);
                            PbFragment.this.iFv.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.ckr();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.iFX != null && PbFragment.this.iFX.getView() != null) {
                                PbFragment.this.iFX.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cmw);
                                PbFragment.this.iFv.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.ckr();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aCp();
                    return false;
                }
            } else if (this.iCx.getPbData() == null || this.iCx.getPbData().ciU() == null || this.iCx.getPbData().ciU().size() <= 0 || !this.iCx.getIsFromMark()) {
                return true;
            } else {
                this.iFv.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.iFX == null) {
            return null;
        }
        return this.iFX.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aSg() {
        if (this.iFX == null) {
            return 0;
        }
        return this.iFX.coD();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aSh() {
        if (this.dIh == null) {
            this.dIh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aSt */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.axy().isShowImages();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.i.axy().isShowImages()) {
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
        return this.dIh;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aSi() {
        if (this.dKV == null) {
            this.dKV = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dKV;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aSj() {
        if (this.dIi == null) {
            this.dIi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bFv */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.axy().isShowImages();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.i.axy().isShowImages()) {
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
                    gifView.aNq();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dIi;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aSk() {
        if (this.dKW == null) {
            this.dKW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: clP */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cKK();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cz */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dKW;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aSm() {
        this.dKY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: clQ */
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
        return this.dKY;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aFR() {
        if (this.deV == null) {
            this.deV = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.deV;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iFG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (av.FS(str) && this.iCx != null && this.iCx.cmc() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").Z("obj_param1", 1).cp("post_id", this.iCx.cmc()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.drv = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            av.cph().c(getPageContext(), str);
        }
        this.iFG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        av.cph().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iFG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.iFX != null && this.iFX.coT() != null && rect.top <= this.iFX.coT().getHeight()) {
            rect.top += this.iFX.coT().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.iCx.getPbData();
            TbRichText bl = bl(str, i);
            if (bl != null && (tbRichTextData = bl.aRz().get(this.iHc)) != null) {
                aVar.postId = String.valueOf(bl.getPostId());
                aVar.iCC = new ArrayList<>();
                aVar.iCD = new ConcurrentHashMap<>();
                if (!tbRichTextData.aRF().aRR()) {
                    aVar.iCF = false;
                    String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                    aVar.iCC.add(b2);
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
                    imageUrlData.postId = bl.getPostId();
                    imageUrlData.mIsReserver = this.iCx.cmu();
                    imageUrlData.mIsSeeHost = this.iCx.getHostMode();
                    aVar.iCD.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.ciS() != null) {
                            aVar.threadId = pbData.ciS().getId();
                        }
                        aVar.iCE = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.iCF = true;
                int size = pbData.ciU().size();
                this.iHd = false;
                aVar.index = -1;
                if (pbData.ciZ() != null) {
                    PostData ciZ = pbData.ciZ();
                    TbRichText cJB = ciZ.cJB();
                    if (!ap.o(ciZ)) {
                        i2 = a(cJB, bl, i, i, aVar.iCC, aVar.iCD);
                    } else {
                        i2 = a(ciZ, i, aVar.iCC, aVar.iCD);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.ciU().get(i4);
                    if (postData.getId() == null || pbData.ciZ() == null || pbData.ciZ().getId() == null || !postData.getId().equals(pbData.ciZ().getId())) {
                        TbRichText cJB2 = postData.cJB();
                        if (!ap.o(postData)) {
                            i3 = a(cJB2, bl, i3, i, aVar.iCC, aVar.iCD);
                        } else {
                            i3 = a(postData, i3, aVar.iCC, aVar.iCD);
                        }
                    }
                }
                if (aVar.iCC.size() > 0) {
                    aVar.lastId = aVar.iCC.get(aVar.iCC.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.ciS() != null) {
                        aVar.threadId = pbData.ciS().getId();
                    }
                    aVar.iCE = pbData.getIsNewUrl() == 1;
                }
                aVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRF() == null) {
            return null;
        }
        return tbRichTextData.aRF().aRW();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRF() == null) {
            return 0L;
        }
        return tbRichTextData.aRF().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRF() == null) {
            return false;
        }
        return tbRichTextData.aRF().aRX();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRF() == null) {
            return false;
        }
        return tbRichTextData.aRF().aRY();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aRF;
        String str;
        if (tbRichText == tbRichText2) {
            this.iHd = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aRz().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aRz().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aRF().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aRF().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aRF().aRR()) {
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
                        String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                            if (tbRichTextData != null && (aRF = tbRichTextData.aRF()) != null) {
                                String aRT = aRF.aRT();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aRF.aRU();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = aRT;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iCx.cmc(), -1L);
                                imageUrlData.mIsReserver = this.iCx.cmu();
                                imageUrlData.mIsSeeHost = this.iCx.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.iHd) {
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
        com.baidu.tieba.tbadkCore.data.i cJI;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cJe;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cJe = (cJI = postData.cJI()).cJe()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cJe.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cJe.get(i3);
                if (kVar != null) {
                    String cJi = kVar.cJi();
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(cJi)) {
                        arrayList.add(cJi);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cJi;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cJh();
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iCx.cmc(), -1L);
                        imageUrlData.mIsReserver = this.iCx.cmu();
                        imageUrlData.mIsSeeHost = this.iCx.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cJI.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cJi, imageUrlData);
                        }
                        if (!this.iHd) {
                            i++;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    protected void k(PostData postData) {
        PostData ciZ;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.iCx.aAg())) {
                z = true;
            }
            MarkData l = this.iCx.l(postData);
            if (this.iCx.getPbData() != null && this.iCx.getPbData().cjs() && (ciZ = ciZ()) != null) {
                l = this.iCx.l(ciZ);
            }
            if (l != null) {
                this.iFX.com();
                if (this.iFV != null) {
                    this.iFV.a(l);
                    if (!z) {
                        this.iFV.awy();
                    } else {
                        this.iFV.awx();
                    }
                }
            }
        }
    }

    public boolean cw(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bl(String str, int i) {
        TbRichText tbRichText = null;
        if (this.iCx == null || this.iCx.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.iCx.getPbData();
        if (pbData.ciZ() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.ciZ());
            tbRichText = b(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> ciU = pbData.ciU();
            c(pbData, ciU);
            return b(ciU, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.cjd() != null && fVar.cjd().iAX != null && (list = fVar.cjd().iAX) != null && arrayList != null) {
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

    private long FC(String str) {
        ArrayList<PostData> ciU;
        com.baidu.tieba.pb.data.f pbData = this.iCx.getPbData();
        if (pbData != null && (ciU = pbData.ciU()) != null && !ciU.isEmpty()) {
            Iterator<PostData> it = ciU.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cJI = next.cJI();
                if (cJI != null && cJI.keZ) {
                    Iterator<TbRichTextData> it2 = next.cJB().aRz().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.aRO().getLink().equals(str)) {
                            return cJI.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText b(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> aRz;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cJB = arrayList.get(i2).cJB();
            if (cJB != null && (aRz = cJB.aRz()) != null) {
                int size = aRz.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aRz.get(i4) != null && aRz.get(i4).getType() == 8) {
                        i3++;
                        if (aRz.get(i4).aRF().aRT().equals(str) || aRz.get(i4).aRF().aRU().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aRz.get(i4).aRF().getWidth() * equipmentDensity;
                            int height = aRz.get(i4).aRF().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iHc = i4;
                            return cJB;
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
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.iCs = str;
            if (this.iFB == null) {
                clb();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.iFB.getItemView(1).setVisibility(8);
            } else {
                this.iFB.getItemView(1).setVisibility(0);
            }
            this.iFB.aCq();
            this.iFG = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gmi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clt() {
        hideNetRefreshView(this.iFX.getView());
        clu();
        if (this.iCx.cmo()) {
            this.iFX.com();
        }
        this.iFX.cox();
    }

    private void clu() {
        showLoadingView(this.iFX.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.iFX.coT().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCF() {
        if (this.gmi != null) {
            this.gmi.stopPlay();
        }
        if (this.iFv != null) {
            this.iFv.bCF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yI(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yJ(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, clf(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aSl() {
        if (this.dKX == null) {
            this.dKX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: clR */
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
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.dKX;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void bCG() {
        if (this.iFv.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iFv.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bBu() {
        if (this.iCx == null || this.iCx.getPbData() == null) {
            return null;
        }
        return this.iCx.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(aq.iNy)).intValue();
            if (intValue == aq.iNz) {
                if (!this.fHZ.cKo()) {
                    this.iFX.coj();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.fHZ.IT(com.baidu.tbadk.core.util.aq.O(jSONArray));
                    }
                    this.fHZ.a(this.iCx.getPbData().getForum().getId(), this.iCx.getPbData().getForum().getName(), this.iCx.getPbData().ciS().getId(), str, intValue3, intValue2, booleanValue, this.iCx.getPbData().ciS().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == aq.iNA || intValue == aq.iNC) {
                if (this.iCx.cmH() != null) {
                    this.iCx.cmH().yB(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.iNA) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iGs);
        userMuteAddAndDelCustomMessage.setTag(this.iGs);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean FD(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0577a
    public void pL(boolean z) {
        this.iGe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String clv() {
        ArrayList<PostData> ciU;
        int count;
        if (this.iCx == null || this.iCx.getPbData() == null || this.iCx.getPbData().ciU() == null || (count = com.baidu.tbadk.core.util.v.getCount((ciU = this.iCx.getPbData().ciU()))) == 0) {
            return "";
        }
        if (this.iCx.cmu()) {
            Iterator<PostData> it = ciU.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cJz() == 1) {
                    return next.getId();
                }
            }
        }
        int coq = this.iFX.coq();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(ciU, coq);
        if (postData == null || postData.azX() == null) {
            return "";
        }
        if (this.iCx.FH(postData.azX().getUserId())) {
            return postData.getId();
        }
        for (int i = coq - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(ciU, i);
            if (postData2 == null || postData2.azX() == null || postData2.azX().getUserId() == null) {
                break;
            } else if (this.iCx.FH(postData2.azX().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = coq + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(ciU, i2);
            if (postData3 == null || postData3.azX() == null || postData3.azX().getUserId() == null) {
                return "";
            }
            if (this.iCx.FH(postData3.azX().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.aEt().b(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(FC(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.iCx.getPbData().getForum().getId(), this.iCx.getPbData().getForum().getName(), this.iCx.getPbData().ciS().getTid());
            }
            this.iFG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.sC(getResources().getString(R.string.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.sC(getResources().getString(R.string.make_sure_hide));
        }
        aVar.a(getResources().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbFragment.this.checkUpIsLogin() && PbFragment.this.iCx.cmG() != null) {
                    PbFragment.this.iCx.cmG().et(j);
                }
            }
        });
        aVar.b(getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.fA(false);
        aVar.b(getPageContext());
        aVar.aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a FE(String str) {
        String str2;
        if (this.iCx.getPbData() == null || this.iCx.getPbData().ciU() == null || this.iCx.getPbData().ciU().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.iCx.getPbData().ciU().size()) {
                i = 0;
                break;
            } else if (str.equals(this.iCx.getPbData().ciU().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.iCx.getPbData().ciU().get(i);
        if (postData.cJB() == null || postData.cJB().aRz() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cJB().aRz().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aRF() != null) {
                    str2 = next.aRF().aRT();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean clw() {
        return (!this.iFw && this.iHi == -1 && this.iHj == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null) {
            this.iHl = pVar;
            this.iFw = true;
            this.iFX.coa();
            this.iFX.FQ(this.iHk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clx() {
        if (this.iHl != null) {
            if (this.iHi == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iHl.getCartoonId(), this.iHi, 0)));
                this.iFv.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        if (this.iHl != null) {
            if (this.iHj == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iHl.getCartoonId(), this.iHj, 0)));
                this.iFv.finish();
            }
        }
    }

    public int clz() {
        return this.iHi;
    }

    public int clA() {
        return this.iHj;
    }

    private void bOs() {
        if (this.iCx != null && this.iCx.getPbData() != null && this.iCx.getPbData().ciS() != null && this.iCx.getPbData().ciS().aAX()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void clB() {
        if (this.iCx != null && this.iCx.getPbData() != null && this.iCx.getPbData().ciS() != null && this.iCx.getPbData().ciS().aAX()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void clC() {
        if (this.isPaused) {
            this.iFL = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.iCx.getPbData() != null && this.iCx.getPbData().ciS() != null && this.iCx.getPbData().ciS().azC() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iCx.getPbData().ciS().azC().getThreadId(), this.iCx.getPbData().ciS().azC().getTaskId(), this.iCx.getPbData().ciS().azC().getForumId(), this.iCx.getPbData().ciS().azC().getForumName(), this.iCx.getPbData().ciS().azS(), this.iCx.getPbData().ciS().azT())));
            this.iFy = true;
            this.iFv.finish();
        }
    }

    public String clD() {
        return this.iFJ;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a clE() {
        return this.iFT;
    }

    public void pM(boolean z) {
        this.iFK = z;
    }

    public boolean aBO() {
        if (this.iCx != null) {
            return this.iCx.cme();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sC(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.iGq).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.iGq.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iGq).aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(String str) {
        if (str == null) {
            str = "";
        }
        if (this.iGq != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iGq.getPageActivity());
            aVar.sC(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iGq).aCp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iFX.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iGq.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.sC(this.iGq.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sC(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.iFX.showLoadingDialog();
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
        aVar.b(this.iGq).aCp();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.FS(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.gMd) {
            this.gMd = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.iFX != null) {
                this.iFX.onConfigurationChanged(configuration);
            }
            if (this.iGc != null) {
                this.iGc.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean clG() {
        if (this.iCx != null) {
            return this.iCx.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.iCx.getPbData().cjd().iAX;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cJw().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cJw().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cJw().remove(i2);
                    list.get(i).cJy();
                    z = true;
                    break;
                }
            }
            list.get(i).IN(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.o(this.iCx.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.cjF().getId();
        List<PostData> list = this.iCx.getPbData().cjd().iAX;
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
                ArrayList<PostData> cjJ = mVar.cjJ();
                postData.Cp(mVar.getTotalCount());
                if (postData.cJw() != null) {
                    postData.cJw().clear();
                    postData.cJw().addAll(cjJ);
                }
            }
        }
        if (!this.iCx.getIsFromMark()) {
            this.iFX.o(this.iCx.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cjQ() {
        return this.iFv.cjQ();
    }

    public boolean cjR() {
        if (this.iCx == null) {
            return false;
        }
        return this.iCx.cjR();
    }

    public void clH() {
        if (this.iFX != null) {
            this.iFX.cnN();
            bCG();
        }
    }

    public PostData ciZ() {
        return this.iFX.b(this.iCx.iDs, this.iCx.cmd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aC(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.isLinkThread()) {
                return 3;
            }
            if (bjVar.aBm()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public void onBackPressed() {
        if (this.iGz != null && !this.iGz.isEmpty()) {
            int size = this.iGz.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.iGz.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.iGz == null) {
                this.iGz = new ArrayList();
            }
            if (!this.iGz.contains(aVar)) {
                this.iGz.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.iGz == null) {
                this.iGz = new ArrayList();
            }
            if (!this.iGz.contains(aVar)) {
                this.iGz.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.iGz != null) {
            this.iGz.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clI() {
        if (this.iCx != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.iCx.cmc())) {
            com.baidu.tbadk.BdToken.c.avj().o(com.baidu.tbadk.BdToken.b.cCM, com.baidu.adp.lib.f.b.toLong(this.iCx.cmc(), 0L));
        }
    }

    public ax clJ() {
        return this.iFS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FF(String str) {
        if (this.iCx != null && this.iCx.getPbData() != null && this.iCx.getPbData().ciS() != null && this.iCx.getPbData().ciS().aBV()) {
            bj ciS = this.iCx.getPbData().ciS();
            int i = 0;
            if (ciS.ayL()) {
                i = 1;
            } else if (ciS.aBS()) {
                i = 2;
            } else if (ciS.aBT()) {
                i = 3;
            } else if (ciS.aBU()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.Z("obj_source", 4);
            anVar.Z("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment clK() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment clL() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity clM() {
        return this.iFv;
    }
}
