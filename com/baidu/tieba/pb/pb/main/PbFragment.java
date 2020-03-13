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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.x;
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
/* loaded from: classes9.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0584a {
    private com.baidu.adp.lib.d.b<ImageView> dMA;
    private com.baidu.adp.lib.d.b<GifView> dMB;
    private com.baidu.adp.lib.d.b<TextView> dPo;
    private com.baidu.adp.lib.d.b<View> dPp;
    private com.baidu.adp.lib.d.b<LinearLayout> dPq;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPr;
    private com.baidu.adp.lib.d.b<TbImageView> djp;
    private LikeModel dkh;
    private ar gQN;
    private VoiceManager goy;
    private com.baidu.tieba.frs.profession.permission.c grZ;
    private com.baidu.tieba.f.b gsB;
    public com.baidu.tbadk.core.util.aj hPK;
    private String iEq;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iHE;
    private View iHF;
    int iHH;
    private ax iHK;
    private com.baidu.tieba.pb.pb.report.a iHM;
    public ap iHT;
    private com.baidu.tbadk.core.dialog.i iHU;
    private com.baidu.tbadk.core.dialog.k iHV;
    private boolean iHW;
    private PbActivity iHn;
    private com.baidu.tieba.pb.pb.main.b.b iHp;
    private boolean iIS;
    private com.baidu.tieba.tbadkCore.data.f iIa;
    private com.baidu.tbadk.editortools.pb.g iIb;
    private com.baidu.tbadk.editortools.pb.e iIc;
    private com.baidu.tieba.frs.profession.permission.c iIe;
    private EmotionImageData iIf;
    private com.baidu.adp.base.e iIi;
    private com.baidu.tbadk.core.view.d iIj;
    private BdUniqueId iIk;
    private Runnable iIl;
    private com.baidu.adp.widget.ImageView.a iIm;
    private String iIn;
    private TbRichTextMemeInfo iIo;
    private List<a> iIr;
    public String iIt;
    private String iJb;
    private com.baidu.tbadk.core.data.p iJc;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a iIY = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        @Override // com.baidu.tieba.f.b.a
        public void bk(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.clq();
            } else {
                com.baidu.tieba.pb.a.b.clp();
            }
        }
    };
    private boolean iHo = false;
    private boolean iHq = false;
    private boolean isPaused = false;
    private boolean iif = false;
    private boolean iHr = true;
    private int iHs = 0;
    private com.baidu.tbadk.core.dialog.b iHt = null;
    private long fVt = -1;
    private long dDR = 0;
    private long iHu = 0;
    private long createTime = 0;
    private long dDJ = 0;
    private boolean iHv = false;
    private com.baidu.tbadk.n.b iHw = null;
    private long iHx = 0;
    private boolean iHy = false;
    private long iHz = 0;
    private int gOq = 1;
    private String dyD = null;
    private boolean iHA = false;
    private boolean isFullScreen = false;
    private String iHB = "";
    private boolean iHC = true;
    private boolean iHD = false;
    private String source = "";
    private int mSkinType = 3;
    int[] iHG = new int[2];
    private int iHI = -1;
    private int iHJ = -1;
    private PbInterviewStatusView.a iHL = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.iHP.qk(!PbFragment.this.iHC);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.iEu != null && PbFragment.this.iEu.ayL()) {
                        PbFragment.this.cmO();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel iEu = null;
    private com.baidu.tbadk.baseEditMark.a iHN = null;
    private ForumManageModel fKL = null;
    private com.baidu.tbadk.coreExtra.model.a dac = null;
    private com.baidu.tieba.pb.data.m iHO = null;
    private ShareSuccessReplyToServerModel gEG = null;
    private an iHP = null;
    private boolean iHQ = false;
    private boolean iHR = false;
    private boolean iHS = false;
    private boolean edZ = false;
    private boolean iHX = false;
    private boolean iHY = false;
    private boolean iHZ = false;
    private boolean iId = false;
    public boolean iIg = false;
    private com.baidu.tbadk.editortools.pb.c dyG = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOS() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b dyH = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOR() {
            if (PbFragment.this.iHT == null || PbFragment.this.iHT.cqy() == null || !PbFragment.this.iHT.cqy().cUf()) {
                return !PbFragment.this.yN(com.baidu.tbadk.core.util.aj.cZX);
            }
            PbFragment.this.showToast(PbFragment.this.iHT.cqy().cUh());
            if (PbFragment.this.iIc != null && (PbFragment.this.iIc.aPh() || PbFragment.this.iIc.aPi())) {
                PbFragment.this.iIc.a(false, PbFragment.this.iHT.cqB());
            }
            PbFragment.this.iHT.qw(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b iIh = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOR() {
            if (PbFragment.this.iHT == null || PbFragment.this.iHT.cqz() == null || !PbFragment.this.iHT.cqz().cUf()) {
                return !PbFragment.this.yN(com.baidu.tbadk.core.util.aj.cZY);
            }
            PbFragment.this.showToast(PbFragment.this.iHT.cqz().cUh());
            if (PbFragment.this.iHP != null && PbFragment.this.iHP.cpj() != null && PbFragment.this.iHP.cpj().cmo() != null && PbFragment.this.iHP.cpj().cmo().aPi()) {
                PbFragment.this.iHP.cpj().cmo().a(PbFragment.this.iHT.cqB());
            }
            PbFragment.this.iHT.qx(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean gpl = false;
    private int iIp = 0;
    private int iIq = -1;
    public int iIs = 0;
    private final a iIu = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.iHP != null && PbFragment.this.iHP.cpj() != null) {
                s cpj = PbFragment.this.iHP.cpj();
                if (cpj.cmm()) {
                    cpj.cml();
                    return true;
                }
            }
            if (PbFragment.this.iHP != null && PbFragment.this.iHP.cqh()) {
                PbFragment.this.iHP.cqi();
                return true;
            }
            return false;
        }
    };
    private final x.a iIv = new x.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void onSuccess(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.iHP.showToast(str);
            }
        }
    };
    private final CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iEu != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.iIc != null) {
                    PbFragment.this.iHP.qp(PbFragment.this.iIc.aPa());
                }
                PbFragment.this.iHP.cpl();
                PbFragment.this.iHP.cpZ();
            }
        }
    };
    CustomMessageListener gpN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.iEu.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.iHP != null && PbFragment.this.iEu != null) {
                    PbFragment.this.iHP.b(PbFragment.this.iEu.getPbData(), PbFragment.this.iEu.cnA(), PbFragment.this.iEu.cnX(), PbFragment.this.iHP.getSkinType());
                }
                if (PbFragment.this.iHP != null && PbFragment.this.iHP.cpC() != null) {
                    PbFragment.this.iHP.cpC().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener iIx = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.iHP != null) {
                    if (booleanValue) {
                        PbFragment.this.iHP.bWt();
                    } else {
                        PbFragment.this.iHP.bWs();
                    }
                }
            }
        }
    };
    private CustomMessageListener iIy = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.iIc != null) {
                    PbFragment.this.iHP.qp(PbFragment.this.iIc.aPa());
                }
                PbFragment.this.iHP.qr(false);
            }
        }
    };
    private CustomMessageListener iIz = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.l) eVar.getData());
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
    private CustomMessageListener iIA = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iHP != null && PbFragment.this.iHP.cpC() != null) {
                PbFragment.this.iHP.cpC().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener htK = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener gpK = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.cnf();
            }
        }
    };
    private View.OnClickListener dzo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.dyD);
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                ar.a aVar = new ar.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.thumbnailUrl = abVar.thumbnailUrl;
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEu.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.iEu.cnO() != null && PbFragment.this.iEu.cnO().getUserIdLong() == abVar.toUserId) {
                        PbFragment.this.iHP.a(abVar.sendCount, PbFragment.this.iEu.getPbData(), PbFragment.this.iEu.cnA(), PbFragment.this.iEu.cnX());
                    }
                    if (pbData.ckx() != null && pbData.ckx().size() >= 1 && pbData.ckx().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.ckx().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEu.cnz(), 0L);
                        if (j == abVar.postId && j2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.ar cLj = pbData.ckx().get(0).cLj();
                            if (cLj == null) {
                                cLj = new com.baidu.tbadk.core.data.ar();
                            }
                            ArrayList<ar.a> aBm = cLj.aBm();
                            if (aBm == null) {
                                aBm = new ArrayList<>();
                            }
                            aBm.add(0, aVar);
                            cLj.setTotal(abVar.sendCount + cLj.getTotal());
                            cLj.w(aBm);
                            pbData.ckx().get(0).a(cLj);
                            PbFragment.this.iHP.cpC().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gFN = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                PbFragment.this.FO((String) customResponsedMessage.getData());
                PbFragment.this.iEu.cnT();
                if (PbFragment.this.iHP.cpC() != null) {
                    PbFragment.this.iHP.o(PbFragment.this.iEu.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a iIC = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cqQ()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a iID = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onSuccess(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.iHP != null) {
                PbFragment.this.iHP.dH(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean iIE = false;
    private PraiseModel iIF = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void xr(String str) {
            PbFragment.this.iIE = false;
            if (PbFragment.this.iIF != null) {
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEu.getPbData();
                if (pbData.ckv().aBZ().getIsLike() == 1) {
                    PbFragment.this.tI(0);
                } else {
                    PbFragment.this.tI(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.ckv()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.iIE = false;
            if (PbFragment.this.iIF != null && str != null) {
                if (AntiHelper.bb(i, str)) {
                    AntiHelper.bn(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a iIG = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void pQ(boolean z) {
            PbFragment.this.pP(z);
            if (PbFragment.this.iHP.cqn() != null && z) {
                PbFragment.this.iHP.qk(false);
            }
            PbFragment.this.iHP.qm(z);
        }
    };
    private CustomMessageListener dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().doi != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().doi, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.ckC().aCo() != null && PbFragment.this.ckC().aCo().getGodUserData() != null) {
                            PbFragment.this.ckC().aCo().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().ckv() != null && PbFragment.this.iEu.getPbData().ckv().aCo() != null) {
                            PbFragment.this.iEu.getPbData().ckv().aCo().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h gnG = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.iHn.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a iIH = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.iHP.bqs();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.yP(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.bMF();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c dqX = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cmx();
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
                        if (PbFragment.this.ct(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.c((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.iHP.cmv() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").cy("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.clr() != null && PbFragment.this.clr().gRi != null) {
                                PbFragment.this.clr().gRi.onClick(view);
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
                if (PbFragment.this.iIc != null) {
                    PbFragment.this.iHP.qp(PbFragment.this.iIc.aPa());
                }
                PbFragment.this.iHP.cpl();
                PbFragment.this.iHP.cpZ();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener iII = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iIk) {
                PbFragment.this.iHP.bqs();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEu.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.ckI().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iIj.showSuccessToast(PbFragment.this.iIi.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.iIi.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.vr(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cnc();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.iIi.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.iIj.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iIJ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iIk) {
                PbFragment.this.iHP.bqs();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iIj.showSuccessToast(PbFragment.this.iIi.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.iIi.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.iIj.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iIK = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iIk) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.iHP.bqs();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.kuS;
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
                    PbFragment.this.iHP.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener iIL = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iHP.cpm() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cmx();
            }
        }
    };
    private CustomMessageListener gpU = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.gpl = true;
                }
            }
        }
    };
    public a.b itg = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bEm();
            com.baidu.tbadk.core.data.ap pageData = PbFragment.this.iEu.getPageData();
            int pageNum = PbFragment.this.iHP.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aBf()) {
                PbFragment.this.iHP.cpZ();
                PbFragment.this.bEl();
                PbFragment.this.iHP.cpG();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.iEu.yR(PbFragment.this.iHP.getPageNum());
                    if (PbFragment.this.iHp != null) {
                        PbFragment.this.iHp.showFloatingView();
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
    public final View.OnClickListener gqD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        /* JADX WARN: Removed duplicated region for block: B:632:0x1c89  */
        /* JADX WARN: Removed duplicated region for block: B:635:0x1cd0  */
        /* JADX WARN: Removed duplicated region for block: B:652:0x1ede  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            com.baidu.tieba.pb.data.e pbData;
            boolean z;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            int i;
            int i2;
            bo boVar;
            String[] strArr;
            boolean v;
            String name;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.iHP.cpV()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.iEu.pV(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.iHP.cpH();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.iHP.iNW.crd() == null || view != PbFragment.this.iHP.iNW.crd().coM()) {
                        if (view == PbFragment.this.iHP.iNW.dFX) {
                            if (PbFragment.this.iHP.qo(PbFragment.this.iEu.cnF())) {
                                PbFragment.this.bEl();
                                return;
                            }
                            PbFragment.this.iHr = false;
                            PbFragment.this.iHq = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.iHn, PbFragment.this.iHP.iNW.dFX);
                            PbFragment.this.iHn.finish();
                        } else if (view != PbFragment.this.iHP.cpE() && (PbFragment.this.iHP.iNW.crd() == null || (view != PbFragment.this.iHP.iNW.crd().coL() && view != PbFragment.this.iHP.iNW.crd().coJ()))) {
                            if (view == PbFragment.this.iHP.cqd()) {
                                if (PbFragment.this.iEu != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEu.getPbData().ckv().aCn().getLink());
                                }
                            } else if (view != PbFragment.this.iHP.iNW.iTZ) {
                                if (view == PbFragment.this.iHP.iNW.iUa) {
                                    if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                        ArrayList<PostData> ckx = PbFragment.this.iEu.getPbData().ckx();
                                        if ((ckx == null || ckx.size() <= 0) && PbFragment.this.iEu.cnA()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").cy("tid", PbFragment.this.iEu.cnz()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", PbFragment.this.iEu.getForumId()));
                                        if (!PbFragment.this.iHP.cqs()) {
                                            PbFragment.this.iHP.cpl();
                                        }
                                        PbFragment.this.cmG();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.iHP.pF(true);
                                        PbFragment.this.iHP.cpl();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.iHP.bWt();
                                            PbFragment.this.bEl();
                                            PbFragment.this.iHP.cpG();
                                            PbFragment.this.iEu.FV(PbFragment.this.cmS());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.iHP.iNW.crd() == null || view != PbFragment.this.iHP.iNW.crd().coI()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.iHP.iNW.crd() != null && view == PbFragment.this.iHP.iNW.crd().coH()) {
                                            PbFragment.this.iHP.iNW.arU();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.iHP.iNW.crd() == null || view != PbFragment.this.iHP.iNW.crd().coF()) {
                                                if ((PbFragment.this.iHP.iNW.crd() == null || view != PbFragment.this.iHP.iNW.crd().coO()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.iHP.iNW.crd() == null || view != PbFragment.this.iHP.iNW.crd().coG()) {
                                                        if (PbFragment.this.iHP.iNW.crd() == null || view != PbFragment.this.iHP.iNW.crd().coP()) {
                                                            if (PbFragment.this.iHP.cqn() == view) {
                                                                if (PbFragment.this.iHP.cqn().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.e pbData2 = PbFragment.this.iEu.getPbData();
                                                                    if (pbData2 != null && pbData2.ckv() != null && pbData2.ckv().aBU() != null) {
                                                                        String aBL = pbData2.ckv().aBU().aBL();
                                                                        if (StringUtils.isNull(aBL)) {
                                                                            aBL = pbData2.ckv().aBU().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").cy("obj_id", aBL));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.eD("c10725", null);
                                                                }
                                                                PbFragment.this.cmZ();
                                                            } else if (PbFragment.this.iHP.iNW.crd() == null || view != PbFragment.this.iHP.iNW.crd().coN()) {
                                                                if (PbFragment.this.iHP.iNW.crd() != null && view == PbFragment.this.iHP.iNW.crd().coK()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.iHP.b(PbFragment.this.iEu.getPbData(), PbFragment.this.iEu.cnA(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.iHP.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.iHP.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.iHP.iNW.arU();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.cy("tid", PbFragment.this.iEu.cnz());
                                                                        anVar.cy("fid", PbFragment.this.iEu.getForumId());
                                                                        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.X("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                                                            PbFragment.this.iHP.cpZ();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cLn() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.khD != null) {
                                                                                    com.baidu.tbadk.core.util.an aGy = postData.khD.aGy();
                                                                                    aGy.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aGy.X("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aGy.X("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aGy);
                                                                                }
                                                                                String cnz = PbFragment.this.iEu.cnz();
                                                                                String id = postData.getId();
                                                                                int i3 = 0;
                                                                                if (PbFragment.this.iEu.getPbData() != null) {
                                                                                    i3 = PbFragment.this.iEu.getPbData().ckH();
                                                                                }
                                                                                PbFragment.this.bEl();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a FT = PbFragment.this.FT(id);
                                                                                    if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && FT != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnz, id, "pb", true, null, true, null, i3, postData.csa(), PbFragment.this.iEu.getPbData().getAnti(), false, postData.aCo().getIconInfo()).addBigImageData(FT.iEz, FT.iEA, FT.iEB, FT.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.iEu.coi());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.iEu.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.iEu.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.iEu.cnH());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a FT2 = PbFragment.this.FT(id);
                                                                                    if (postData != null && PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && FT2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnz, id, "pb", true, null, false, null, i3, postData.csa(), PbFragment.this.iEu.getPbData().getAnti(), false, postData.aCo().getIconInfo()).addBigImageData(FT2.iEz, FT2.iEA, FT2.iEB, FT2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.iEu.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.iEu.cnH());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.iEu.coi());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.iEu.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").X("obj_locate", 3).cy("fid", PbFragment.this.iEu.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.iEu != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.cy("tid", PbFragment.this.iEu.cnz());
                                                                        anVar2.cy("fid", PbFragment.this.iEu.getForumId());
                                                                        anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.X("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (postData2.khD != null) {
                                                                                    com.baidu.tbadk.core.util.an aGy2 = postData2.khD.aGy();
                                                                                    aGy2.delete("obj_locate");
                                                                                    aGy2.X("obj_locate", 8);
                                                                                    TiebaStatic.log(aGy2);
                                                                                }
                                                                                if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                                                                    String cnz2 = PbFragment.this.iEu.cnz();
                                                                                    String id2 = postData2.getId();
                                                                                    int i4 = 0;
                                                                                    if (PbFragment.this.iEu.getPbData() != null) {
                                                                                        i4 = PbFragment.this.iEu.getPbData().ckH();
                                                                                    }
                                                                                    PbActivity.a FT3 = PbFragment.this.FT(id2);
                                                                                    if (FT3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnz2, id2, "pb", true, null, false, null, i4, postData2.csa(), PbFragment.this.iEu.getPbData().getAnti(), false, postData2.aCo().getIconInfo()).addBigImageData(FT3.iEz, FT3.iEA, FT3.iEB, FT3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.iEu.coi());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.iEu.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.iEu.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.iEu.cnH());
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
                                                                    if (PbFragment.this.iEu != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.cy("tid", PbFragment.this.iEu.cnz());
                                                                        anVar3.cy("fid", PbFragment.this.iEu.getForumId());
                                                                        anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.X("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (postData3.khD != null) {
                                                                                    com.baidu.tbadk.core.util.an aGy3 = postData3.khD.aGy();
                                                                                    aGy3.delete("obj_locate");
                                                                                    aGy3.X("obj_locate", 8);
                                                                                    TiebaStatic.log(aGy3);
                                                                                }
                                                                                if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.cmu().cpi() != null && postData3.aCo() != null && postData3.cLb() != 1) {
                                                                                    if (PbFragment.this.cmu().cpj() != null) {
                                                                                        PbFragment.this.cmu().cpj().cmk();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                                                                    lVar.a(PbFragment.this.iEu.getPbData().getForum());
                                                                                    lVar.setThreadData(PbFragment.this.iEu.getPbData().ckv());
                                                                                    lVar.f(postData3);
                                                                                    PbFragment.this.cmu().cpi().d(lVar);
                                                                                    PbFragment.this.cmu().cpi().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.aCo().getUserId(), "");
                                                                                    if (PbFragment.this.iIc != null) {
                                                                                        PbFragment.this.iHP.qp(PbFragment.this.iIc.aPa());
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
                                                                } else if (view != PbFragment.this.iHP.clM()) {
                                                                    if (view == PbFragment.this.iHP.iNW.cre()) {
                                                                        PbFragment.this.iHP.cpN();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (boVar = (bo) view.getTag()) != null && !StringUtils.isNull(boVar.aEu())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.aGG().b(PbFragment.this.getPageContext(), new String[]{boVar.aEu()});
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").cy("tid", PbFragment.this.iEu.iKi));
                                                                                    }
                                                                                    if (PbFragment.this.iHV == null) {
                                                                                        PbFragment.this.iHV = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.iHV.a(PbFragment.this.iIX);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cv(view);
                                                                                    if (!PbFragment.this.cv(view) || PbFragment.this.iIm == null || !PbFragment.this.iIm.isGif()) {
                                                                                    }
                                                                                    boolean z2 = false;
                                                                                    boolean z3 = false;
                                                                                    boolean z4 = false;
                                                                                    boolean z5 = false;
                                                                                    boolean z6 = false;
                                                                                    String str = null;
                                                                                    if (sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                        ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                        z2 = ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                        z4 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                        z6 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_forbid_user_post_id) instanceof String) {
                                                                                        str = (String) sparseArray4.get(R.id.tag_forbid_user_post_id);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cLd() != null && postData4.cLd().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iHV);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar4.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar4);
                                                                                        }
                                                                                        PbFragment.this.hhL = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.iEu.getPbData().ayL()) {
                                                                                        String ayK = PbFragment.this.iEu.getPbData().ayK();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(ayK) && ayK.equals(postData4.getId())) {
                                                                                            z = true;
                                                                                            if (!z) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iHV);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iHV);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.hhL);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z4 && z3) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iHV);
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
                                                                                                    arrayList.add(gVar5);
                                                                                                } else {
                                                                                                    if (PbFragment.this.pL(z2) && TbadkCoreApplication.isLogin()) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHV);
                                                                                                        gVar6.mTextView.setTag(str);
                                                                                                        arrayList.add(gVar6);
                                                                                                    }
                                                                                                }
                                                                                                if (z4) {
                                                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                                                    sparseArray8.put(R.id.tag_should_manage_visible, true);
                                                                                                    sparseArray8.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name, sparseArray4.get(R.id.tag_forbid_user_name));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name_show, sparseArray4.get(R.id.tag_forbid_user_name_show));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_portrait, sparseArray4.get(R.id.tag_forbid_user_portrait));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_post_id, str);
                                                                                                    if (z5) {
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
                                                                                                    if (z6) {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, true);
                                                                                                        sparseArray8.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                        sparseArray8.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                        sparseArray8.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHV);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iHV);
                                                                                                    gVar3.mTextView.setTag(sparseArray8);
                                                                                                } else if (!z6) {
                                                                                                    gVar2 = null;
                                                                                                    gVar3 = null;
                                                                                                } else {
                                                                                                    SparseArray sparseArray9 = new SparseArray();
                                                                                                    sparseArray9.put(R.id.tag_should_manage_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                    sparseArray9.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                    sparseArray9.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                    sparseArray9.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                    if (PbFragment.this.iEu.getPbData().ckH() == 1002 && !z2) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHV);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHV);
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
                                                                                            PbFragment.this.iHV.az(arrayList);
                                                                                            PbFragment.this.iHU = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iHV);
                                                                                            PbFragment.this.iHU.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z = false;
                                                                                    if (!z) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.hhL);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.iHV.az(arrayList);
                                                                                    PbFragment.this.iHU = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iHV);
                                                                                    PbFragment.this.iHU.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().ckv() != null && PbFragment.this.iEu.getPbData().ckv().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.iEu.getPbData().ckv().getActUrl());
                                                                                if (PbFragment.this.iEu.getPbData().ckv().aCY() != 1) {
                                                                                    if (PbFragment.this.iEu.getPbData().ckv().aCY() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str2 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").cy("fid", PbFragment.this.iEu.getPbData().getForumId()).cy("tid", PbFragment.this.iEu.getPbData().getThreadId()).cy("lotterytail", StringUtils.string(str2, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.iEu.getPbData().getThreadId().equals(str2)) {
                                                                                    PbFragment.this.iHP.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.iHP.cpl();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.cmD() == 1 && PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").cy("fid", PbFragment.this.iEu.getPbData().getForumId()).cy("tid", PbFragment.this.iEu.getPbData().getThreadId()).cy("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.cmD() == 1 && PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").cy("fid", PbFragment.this.iEu.getPbData().getForumId()).cy("tid", PbFragment.this.iEu.getPbData().getThreadId()).cy("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.cmU();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.cmV();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().ckN() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData3 = PbFragment.this.iEu.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").cy("fid", pbData3.getForumId()));
                                                                                ba.aGG().b(PbFragment.this.getPageContext(), new String[]{pbData3.ckN().ckX()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().ckN() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData4 = PbFragment.this.iEu.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cy("fid", pbData4.getForumId()));
                                                                                ba.aGG().b(PbFragment.this.getPageContext(), new String[]{pbData4.ckN().ckX()});
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.iIp >= 0) {
                                                                                if (PbFragment.this.iEu != null) {
                                                                                    PbFragment.this.iEu.coj();
                                                                                }
                                                                                if (PbFragment.this.iEu != null && PbFragment.this.iHP.cpC() != null) {
                                                                                    PbFragment.this.iHP.cpC().a(PbFragment.this.iEu.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.iIp = 0;
                                                                                if (PbFragment.this.iEu != null) {
                                                                                    PbFragment.this.iHP.getListView().setSelection(PbFragment.this.iEu.com());
                                                                                    PbFragment.this.iEu.cr(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.cmA();
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
                                                                            if (PbFragment.this.iHP.getListView() != null && PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.iHP.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.iHP.getListView().getChildAt(0);
                                                                                int top2 = childAt == null ? 0 : childAt.getTop();
                                                                                boolean aHL = PbFragment.this.iEu.getPbData().aHL();
                                                                                boolean z7 = PbFragment.this.iHP.cpk() != null && PbFragment.this.iHP.cpk().bin();
                                                                                boolean cpW = PbFragment.this.iHP.cpW();
                                                                                boolean z8 = firstVisiblePosition == 0 && top2 == 0;
                                                                                int i5 = 0;
                                                                                if (aHL && PbFragment.this.iHP.cpk() != null && PbFragment.this.iHP.cpk().bcL() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.iHP.cpk().cqN();
                                                                                    z8 = firstVisiblePosition == 0 && (top2 == equipmentWidth || top2 == PbFragment.this.iHP.cpk().bcL().getHeight() - PbFragment.this.iHP.cpk().cqN());
                                                                                    i5 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.FU("c13568");
                                                                                if ((PbFragment.this.iEu.getPbData().ckv() != null && PbFragment.this.iEu.getPbData().ckv().aCf() <= 0) || (cpW && z8)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.cmA();
                                                                                        if (PbFragment.this.iEu.getPbData().ckv().aCo() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEu.iKi).cy("fid", PbFragment.this.iEu.getPbData().getForumId()).X("obj_locate", 2).cy("uid", PbFragment.this.iEu.getPbData().ckv().aCo().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z9 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (aHL) {
                                                                                        if (PbFragment.this.iHP.iPd != null && PbFragment.this.iHP.iPd.iQh != null && PbFragment.this.iHP.iPd.iQh.getView() != null) {
                                                                                            if (PbFragment.this.iHP.iPd.iQh.getView().getParent() == null) {
                                                                                                z9 = firstVisiblePosition >= PbFragment.this.cmK();
                                                                                            } else {
                                                                                                int i6 = 0;
                                                                                                if (PbFragment.this.iHP.cpk() != null && PbFragment.this.iHP.cpk().bcL() != null) {
                                                                                                    i6 = PbFragment.this.iHP.cpk().bcL().getBottom();
                                                                                                }
                                                                                                z9 = PbFragment.this.iHP.iPd.iQh.getView().getTop() <= i6;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.iHP.cpt() != null) {
                                                                                        z9 = PbFragment.this.iHP.cpt().getVisibility() == 0;
                                                                                        if (!z9 && PbFragment.this.iHP.iPd != null && PbFragment.this.iHP.iPd.iQh != null && PbFragment.this.iHP.iPd.iQh.getView() != null && PbFragment.this.iHP.iPd.iQh.getView().getParent() != null && PbFragment.this.iHP.iNW != null && PbFragment.this.iHP.iNW.mNavigationBar != null) {
                                                                                            z9 = PbFragment.this.iHP.iPd.iQh.getView().getTop() - PbFragment.this.iHP.iNW.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z9 || cpW) {
                                                                                        PbFragment.this.iHI = firstVisiblePosition;
                                                                                        PbFragment.this.iHJ = top2;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top2 < (-equipmentHeight))) {
                                                                                            PbFragment.this.iHP.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                            PbFragment.this.iHP.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.iHP.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.iHI > 0) {
                                                                                        if (PbFragment.this.iHP.getListView().getChildAt(PbFragment.this.iHI) != null) {
                                                                                            PbFragment.this.iHP.getListView().smoothScrollToPosition(PbFragment.this.iHI, PbFragment.this.iHJ, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iHP.getListView().setSelectionFromTop(PbFragment.this.iHI, PbFragment.this.iHJ + equipmentHeight);
                                                                                            PbFragment.this.iHP.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int cmK = PbFragment.this.cmK();
                                                                                        if (PbFragment.this.cmJ() != -1) {
                                                                                            cmK--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (cmK < 0) {
                                                                                            i = PbFragment.this.iHP.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.iHP.getListView().getData()) - 1);
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            i = cmK;
                                                                                            i2 = dimens;
                                                                                        }
                                                                                        if (z7) {
                                                                                            i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!aHL || PbFragment.this.iHP.cpk() == null) {
                                                                                            if (PbFragment.this.iHP.iNW != null && PbFragment.this.iHP.iNW.mNavigationBar != null) {
                                                                                                i2 += PbFragment.this.iHP.iNW.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i2 += PbFragment.this.iHP.cpk().cqM();
                                                                                        }
                                                                                        if (PbFragment.this.iHP.iPd == null || PbFragment.this.iHP.iPd.iQh == null || PbFragment.this.iHP.iPd.iQh.getView() == null || PbFragment.this.iHP.iPd.iQh.getView().getParent() == null) {
                                                                                            PbFragment.this.iHP.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                            PbFragment.this.iHP.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z7) {
                                                                                            PbFragment.this.iHP.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iHP.getListView().smoothScrollBy(PbFragment.this.iHP.iPd.iQh.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.iEu.getPbData().ckv() != null && PbFragment.this.iEu.getPbData().ckv().aCo() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEu.iKi).cy("fid", PbFragment.this.iEu.getPbData().getForumId()).X("obj_locate", 2).cy("uid", PbFragment.this.iEu.getPbData().ckv().aCo().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.iEu.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.iEu.coi() == 3) {
                                                                                    PbFragment.this.iHn.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.iEu.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.cy("tid", PbFragment.this.iEu.cnz());
                                                                                anVar4.cy("fid", PbFragment.this.iEu.getForumId());
                                                                                anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar = (bj) view.getTag();
                                                                                if (PbFragment.this.iEu.coi() == 3 && PbFragment.this.cls() && PbFragment.this.iEu.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.iEu.getPbData().ckO())) {
                                                                                    PbFragment.this.iHn.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar.aCt(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.cy("tid", bjVar.getId());
                                                                                anVar5.s("fid", bjVar.getFid());
                                                                                anVar5.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbFragment.this.iEu != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.cy("tid", PbFragment.this.iEu.cnz());
                                                                                anVar6.cy("fid", PbFragment.this.iEu.getForumId());
                                                                                anVar6.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.X("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData5 = PbFragment.this.iEu.getPbData();
                                                                                if (PbFragment.this.iHO == null) {
                                                                                    PbFragment.this.iHO = new com.baidu.tieba.pb.data.m(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").s("forum_id", j2).aGz();
                                                                                PbFragment.this.registerListener(PbFragment.this.iIN);
                                                                                PbFragment.this.iHO.D(j, j2);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").cy("fid", PbFragment.this.iEu.getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", smartApp.name).s("obj_id", smartApp.swan_app_id.longValue()).cy("obj_source", "PB_card").cy("tid", PbFragment.this.iEu.cnz()).X("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar2 = (bj) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar2.aCt(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 9).X("obj_locate", 9).s("obj_id", bjVar2.getFid()).cy("tid", bjVar2.getId()).X("thread_type", bjVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bj) && PbFragment.this.checkUpIsLogin()) {
                                                                                bj bjVar3 = (bj) view.getTag();
                                                                                if (PbFragment.this.dkh != null) {
                                                                                    PbFragment.this.dkh.eC(bjVar3.aCt(), String.valueOf(bjVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 10).X("obj_locate", 11).s("obj_id", bjVar3.getFid()).cy("tid", bjVar3.getId()).X("thread_type", bjVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEu.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEu.cnz(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.iEu.getPbData().ckv().aCI())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.iHP.cpZ();
                                                                SparseArray<Object> b3 = PbFragment.this.iHP.b(PbFragment.this.iEu.getPbData(), PbFragment.this.iEu.cnA(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEu.getPbData().getForum().getId(), PbFragment.this.iEu.getPbData().getForum().getName(), PbFragment.this.iEu.getPbData().ckv().getId(), String.valueOf(PbFragment.this.iEu.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                com.baidu.tbadk.core.util.am.w(true, false);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 0).X("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 1).X("obj_source", 1));
                                                            }
                                                            PbFragment.this.iHP.iNW.crc();
                                                        }
                                                    } else if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().ckv() != null) {
                                                        PbFragment.this.iHP.iNW.arU();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.FQ(PbFragment.this.iEu.getPbData().ckv().aCE());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.iHP.cpZ();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.iEu.cnR()));
                                                            return;
                                                        }
                                                        PbFragment.this.bEl();
                                                        PbFragment.this.iHP.cpG();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.iEu.getPbData().iBP == null || PbFragment.this.iEu.getPbData().iBP.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.iEu.getPbData().iBP.size()];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int i8 = i7;
                                                                if (i8 >= PbFragment.this.iEu.getPbData().iBP.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i8] = PbFragment.this.iEu.getPbData().iBP.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i7 = i8 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                int i10 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.iEu.getSortType() == 1 && i9 == 1) {
                                                                    i10 = 0;
                                                                } else if (PbFragment.this.iEu.getSortType() == 2 && i9 == 0) {
                                                                    i10 = 1;
                                                                } else if (PbFragment.this.iEu.getSortType() != 3 || i9 == 2) {
                                                                    i10 = (i9 != 2 || PbFragment.this.iEu.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").X("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).X("obj_type", i10));
                                                                if (PbFragment.this.iEu.getPbData().iBP != null && PbFragment.this.iEu.getPbData().iBP.size() > i9) {
                                                                    i9 = PbFragment.this.iEu.getPbData().iBP.get(i9).sort_type.intValue();
                                                                }
                                                                boolean yW = PbFragment.this.iEu.yW(i9);
                                                                view.setTag(Integer.valueOf(PbFragment.this.iEu.cnR()));
                                                                if (yW) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.iHP.qf(true);
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
                                                PbFragment.this.iHP.cpZ();
                                                if (PbFragment.this.clC().getPbData().iBQ != 2) {
                                                    if (PbFragment.this.iEu.getPageData() != null) {
                                                        PbFragment.this.iHP.a(PbFragment.this.iEu.getPageData(), PbFragment.this.itg);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.iEu.getPbData()) != null) {
                                            bj ckv = pbData.ckv();
                                            if (ckv != null && ckv.aCo() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEu.iKi).cy("fid", pbData.getForumId()).X("obj_locate", 4).cy("uid", ckv.aCo().getUserId()));
                                            }
                                            int i9 = 1;
                                            if (ckv != null) {
                                                if (ckv.aBd()) {
                                                    i9 = 2;
                                                } else if (ckv.aBe()) {
                                                    i9 = 3;
                                                } else if (ckv.aEg()) {
                                                    i9 = 4;
                                                } else if (ckv.aEh()) {
                                                    i9 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.cy("tid", PbFragment.this.iEu.cnz());
                                            anVar7.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.cy("fid", PbFragment.this.iEu.getForumId());
                                            if (view.getId() == R.id.share_num_container) {
                                                anVar7.X("obj_locate", 5);
                                            } else {
                                                anVar7.X("obj_locate", 6);
                                            }
                                            anVar7.X("obj_name", i9);
                                            anVar7.X("obj_type", 1);
                                            if (ckv != null) {
                                                if (ckv.aBd()) {
                                                    anVar7.X("obj_type", 10);
                                                } else if (ckv.aBe()) {
                                                    anVar7.X("obj_type", 9);
                                                } else if (ckv.aEh()) {
                                                    anVar7.X("obj_type", 8);
                                                } else if (ckv.aEg()) {
                                                    anVar7.X("obj_type", 7);
                                                } else if (ckv.isShareThread) {
                                                    anVar7.X("obj_type", 6);
                                                } else if (ckv.threadType == 0) {
                                                    anVar7.X("obj_type", 1);
                                                } else if (ckv.threadType == 40) {
                                                    anVar7.X("obj_type", 2);
                                                } else if (ckv.threadType == 49) {
                                                    anVar7.X("obj_type", 3);
                                                } else if (ckv.threadType == 54) {
                                                    anVar7.X("obj_type", 4);
                                                } else {
                                                    anVar7.X("obj_type", 5);
                                                }
                                            }
                                            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                anVar7.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                            }
                                            TiebaStatic.log(anVar7);
                                            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                PbFragment.this.showToast(R.string.neterror);
                                                return;
                                            } else if (pbData != null) {
                                                ArrayList<PostData> ckx2 = PbFragment.this.iEu.getPbData().ckx();
                                                if ((ckx2 != null && ckx2.size() > 0) || !PbFragment.this.iEu.cnA()) {
                                                    PbFragment.this.iHP.cpZ();
                                                    PbFragment.this.bEl();
                                                    if (pbData.ckN() != null && !StringUtils.isNull(pbData.ckN().aAG(), true)) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cy("fid", PbFragment.this.iEu.getPbData().getForumId()));
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                    if (!AntiHelper.d(PbFragment.this.getContext(), ckv)) {
                                                        if (PbFragment.this.iHP != null) {
                                                            PbFragment.this.iHP.cqc();
                                                            PbFragment.this.iHP.t(pbData);
                                                        }
                                                        int i10 = 6;
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.iHP.showLoadingDialog();
                                                            PbFragment.this.iEu.cod().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                        } else {
                                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                                i10 = 2;
                                                            } else if (view.getId() == R.id.share_num_container) {
                                                                i10 = 1;
                                                            }
                                                            PbFragment.this.yP(i10);
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
                                        PbFragment.this.iHP.cpZ();
                                        if (PbFragment.this.iHP.iNW.crd() != null && view == PbFragment.this.iHP.iNW.crd().coI() && !PbFragment.this.iHP.cqs()) {
                                            PbFragment.this.iHP.cpl();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bEl();
                                            PbFragment.this.iHP.cpG();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                v = PbFragment.this.iEu.v(true, PbFragment.this.cmS());
                                            } else {
                                                v = view.getId() == R.id.reply_title ? PbFragment.this.iEu.v(false, PbFragment.this.cmS()) : PbFragment.this.iEu.FV(PbFragment.this.cmS());
                                            }
                                            view.setTag(Boolean.valueOf(v));
                                            if (v) {
                                                PbFragment.this.iHP.pF(true);
                                                PbFragment.this.iHP.bWt();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.iHP.qf(true);
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
                                    PbFragment.this.iHP.cpZ();
                                    if (PbFragment.this.yO(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.iEu.yX(PbFragment.this.iHP.cpL()) != null) {
                                        PbFragment.this.cmN();
                                        if (PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().ckv() != null && PbFragment.this.iEu.getPbData().ckv().aCo() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEu.iKi).cy("fid", PbFragment.this.iEu.getPbData().getForumId()).X("obj_locate", 3).cy("uid", PbFragment.this.iEu.getPbData().ckv().aCo().getUserId()));
                                        }
                                        if (PbFragment.this.iEu.getPbData().ckv() != null && PbFragment.this.iEu.getPbData().ckv().aCo() != null && PbFragment.this.iEu.getPbData().ckv().aCo().getUserId() != null && PbFragment.this.iHN != null) {
                                            int g = PbFragment.this.g(PbFragment.this.iEu.getPbData());
                                            bj ckv2 = PbFragment.this.iEu.getPbData().ckv();
                                            int i11 = 1;
                                            if (ckv2.aBd()) {
                                                i11 = 2;
                                            } else if (ckv2.aBe()) {
                                                i11 = 3;
                                            } else if (ckv2.aEg()) {
                                                i11 = 4;
                                            } else if (ckv2.aEh()) {
                                                i11 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cy("tid", PbFragment.this.iEu.iKi).X("obj_locate", 1).cy("obj_id", PbFragment.this.iEu.getPbData().ckv().aCo().getUserId()).X("obj_type", PbFragment.this.iHN.ayL() ? 0 : 1).X("obj_source", g).X("obj_param1", i11));
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
                                if (PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().ckv() != null && PbFragment.this.iEu.getPbData().ckv().aBb() && PbFragment.this.iEu.getPbData().ckv().aCF() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.iEu.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.iEu.clt()) || PbFragment.this.iEu.getAppealInfo() == null) {
                                        PbFragment.this.iHn.finish();
                                        return;
                                    }
                                    name = PbFragment.this.iEu.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.iEu.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.iHn.finish();
                                    return;
                                }
                                String clt = PbFragment.this.iEu.clt();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.iEu.cnB() && clt != null && clt.equals(name)) {
                                    PbFragment.this.iHn.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.iEu.getPbData() != null) {
                                if ((PbFragment.this.iEu.getPbData().ckH() == 1 || PbFragment.this.iEu.getPbData().ckH() == 3) && !PbFragment.this.fKL.cLP()) {
                                    PbFragment.this.iHP.cpZ();
                                    int i12 = 0;
                                    if (PbFragment.this.iHP.iNW.crd() == null || view != PbFragment.this.iHP.iNW.crd().coJ()) {
                                        if (PbFragment.this.iHP.iNW.crd() == null || view != PbFragment.this.iHP.iNW.crd().coL()) {
                                            if (view == PbFragment.this.iHP.cpE()) {
                                                i12 = 2;
                                            }
                                        } else if (PbFragment.this.iEu.getPbData().ckv().aCk() == 1) {
                                            i12 = 3;
                                        } else {
                                            i12 = 6;
                                        }
                                    } else if (PbFragment.this.iEu.getPbData().ckv().aCj() == 1) {
                                        i12 = 5;
                                    } else {
                                        i12 = 4;
                                    }
                                    ForumData forum = PbFragment.this.iEu.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.iEu.getPbData().ckv().getId();
                                    PbFragment.this.iHP.cpD();
                                    PbFragment.this.fKL.b(id4, name2, id5, i12, PbFragment.this.iHP.cpF());
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
                        PbFragment.this.iHP.cpZ();
                        PbFragment.this.bEl();
                        PbFragment.this.iHP.cpG();
                        PbFragment.this.iHP.showLoadingDialog();
                        if (PbFragment.this.iHP.cpt() != null) {
                            PbFragment.this.iHP.cpt().setVisibility(8);
                        }
                        PbFragment.this.iEu.yR(1);
                        if (PbFragment.this.iHp != null) {
                            PbFragment.this.iHp.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cmB = PbFragment.this.cmB();
                        if (!TextUtils.isEmpty(cmB)) {
                            ba.aGG().b(PbFragment.this.getPageContext(), new String[]{cmB});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.cy("tid", PbFragment.this.iEu.cnz());
                anVar8.cy("fid", PbFragment.this.iEu.getForumId());
                anVar8.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.X("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.iHy) {
                    PbFragment.this.iHy = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.cmu().cpi() != null && postData5.aCo() != null && postData5.cLb() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cmu().cpj() != null) {
                                PbFragment.this.cmu().cpj().cmk();
                            }
                            com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                            lVar2.a(PbFragment.this.iEu.getPbData().getForum());
                            lVar2.setThreadData(PbFragment.this.iEu.getPbData().ckv());
                            lVar2.f(postData5);
                            PbFragment.this.cmu().cpi().d(lVar2);
                            PbFragment.this.cmu().cpi().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.aCo().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iEu.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.iIc != null) {
                                PbFragment.this.iHP.qp(PbFragment.this.iIc.aPa());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iEu.getPbData() != null) {
                    anVar.cy("fid", PbFragment.this.iEu.getPbData().getForumId());
                }
                anVar.cy("tid", PbFragment.this.iEu.cnz());
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bEl();
            PbFragment.this.iHP.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.clC() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.clC().FY(postWriteCallBackData.getPostId());
                    PbFragment.this.iIp = PbFragment.this.iHP.cpp();
                    PbFragment.this.iEu.cr(PbFragment.this.iIp, PbFragment.this.iHP.cpq());
                }
                PbFragment.this.iHP.cpZ();
                PbFragment.this.iHT.cqx();
                if (PbFragment.this.iIc != null) {
                    PbFragment.this.iHP.qp(PbFragment.this.iIc.aPa());
                }
                PbFragment.this.iHP.cph();
                PbFragment.this.iHP.qr(true);
                PbFragment.this.iEu.cnT();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.iEu.getHostMode()) {
                            com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEu.getPbData();
                            if (pbData != null && pbData.ckv() != null && pbData.ckv().aCo() != null && (userId = pbData.ckv().aCo().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.iEu.cnK()) {
                                PbFragment.this.iHP.cpG();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.iEu.cnK()) {
                            PbFragment.this.iHP.cpG();
                        }
                    } else if (floor != null) {
                        PbFragment.this.iHP.o(PbFragment.this.iEu.getPbData());
                    }
                    if (PbFragment.this.iEu.cnE()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").cy("tid", PbFragment.this.iEu.cnz()));
                    }
                    PbFragment.this.cmE();
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.iIc.aPh() || PbFragment.this.iIc.aPi()) {
                    PbFragment.this.iIc.a(false, postWriteCallBackData);
                }
                PbFragment.this.iHT.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.hPK != null) {
                    PbFragment.this.hPK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d iIM = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                    anVar.cy("fid", PbFragment.this.iEu.getPbData().getForumId());
                }
                if (PbFragment.this.iEu != null) {
                    anVar.cy("tid", PbFragment.this.iEu.cnz());
                }
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.iHT != null) {
                    PbFragment.this.iHT.cqw();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.hPK != null) {
                    PbFragment.this.hPK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.iHT != null) {
                if (PbFragment.this.iHP != null && PbFragment.this.iHP.cpj() != null && PbFragment.this.iHP.cpj().cmo() != null && PbFragment.this.iHP.cpj().cmo().aPi()) {
                    PbFragment.this.iHP.cpj().cmo().a(postWriteCallBackData);
                }
                PbFragment.this.iHT.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iIN = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cqv;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.iHn.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.iHP != null && (cqv = PbFragment.this.iHP.cqv()) != null && PbFragment.this.iHP.getListView() != null) {
                            PbFragment.this.iHP.getListView().removeHeaderView(cqv);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a iIO = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mm;
            if (!z || eVar == null || eVar.ckF() != null || com.baidu.tbadk.core.util.v.getCount(eVar.ckx()) >= 1) {
                PbFragment.this.iif = true;
                PbFragment.this.iHP.cpI();
                if (eVar == null || !eVar.ckB()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.iHP.getView());
                }
                PbFragment.this.iHP.bWs();
                if (PbFragment.this.isFullScreen || PbFragment.this.iHP.cqs()) {
                    PbFragment.this.iHP.cqj();
                } else if (!PbFragment.this.iHP.cqg()) {
                    PbFragment.this.iHP.qr(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.edZ = true;
                }
                if (eVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.iHP.getView());
                    PbFragment.this.iHP.cpR();
                }
                if (z && eVar != null) {
                    bj ckv = eVar.ckv();
                    if (ckv == null || !ckv.aEi()) {
                        PbFragment.this.d(PbFragment.this.iIb);
                    } else {
                        cnl();
                    }
                    PbFragment.this.iHP.cpj().setPbData(eVar);
                    PbFragment.this.iHP.bgz();
                    if (ckv != null && ckv.aDv() != null) {
                        PbFragment.this.a(ckv.aDv());
                    }
                    if (PbFragment.this.iIc != null) {
                        PbFragment.this.iHP.qp(PbFragment.this.iIc.aPa());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                    if (eVar.ckx() != null && eVar.ckx().size() >= 1 && eVar.ckx().get(0) != null) {
                        PbFragment.this.iEu.FX(eVar.ckx().get(0).getId());
                    } else if (eVar.ckF() != null) {
                        PbFragment.this.iEu.FX(eVar.ckF().getId());
                    }
                    if (PbFragment.this.iIc != null) {
                        PbFragment.this.iIc.a(eVar.getAnti());
                        PbFragment.this.iIc.a(eVar.getForum(), eVar.getUserData());
                        PbFragment.this.iIc.setThreadData(ckv);
                        PbFragment.this.iIc.a(PbFragment.this.iEu.cnO(), PbFragment.this.iEu.cnz(), PbFragment.this.iEu.cof());
                        if (ckv != null) {
                            PbFragment.this.iIc.gI(ckv.aDG());
                        }
                    }
                    if (PbFragment.this.iHN != null) {
                        PbFragment.this.iHN.fm(eVar.ayL());
                    }
                    if (eVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (eVar.ckT()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.iHP.qq(PbFragment.this.mIsFromCDN);
                    PbFragment.this.iHP.a(eVar, i2, i3, PbFragment.this.iEu.cnA(), i4, PbFragment.this.iEu.getIsFromMark());
                    PbFragment.this.iHP.d(eVar, PbFragment.this.iEu.cnA());
                    PbFragment.this.iHP.qn(PbFragment.this.iEu.getHostMode());
                    AntiData anti = eVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.dyD = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.dyD) && PbFragment.this.iIc != null && PbFragment.this.iIc.aOu() != null && (mm = PbFragment.this.iIc.aOu().mm(6)) != null && !TextUtils.isEmpty(PbFragment.this.dyD)) {
                            ((View) mm).setOnClickListener(PbFragment.this.dzo);
                        }
                    }
                    if (PbFragment.this.iHX) {
                        PbFragment.this.iHX = false;
                        final int cmJ = PbFragment.this.cmJ();
                        if (!eVar.aHL()) {
                            PbFragment.this.iHP.ze(cmJ);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cmJ, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.iHY) {
                        PbFragment.this.iHY = false;
                        final int cmJ2 = PbFragment.this.cmJ();
                        final boolean z2 = cmJ2 != -1;
                        if (!z2) {
                            cmJ2 = PbFragment.this.cmK();
                        }
                        if (PbFragment.this.iHP != null) {
                            if (!eVar.aHL()) {
                                PbFragment.this.iHP.ze(cmJ2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cmJ2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.iHP.setSelectionFromTop(cmJ2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.iHP.setSelectionFromTop(cmJ2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.iHP.qs(true);
                                PbFragment.this.iHP.qr(false);
                            }
                        }
                    } else if (PbFragment.this.iHZ) {
                        PbFragment.this.iHZ = false;
                        PbFragment.this.iHP.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.iHP.cpM();
                    }
                    PbFragment.this.iEu.a(eVar.getForum(), PbFragment.this.iIC);
                    PbFragment.this.iEu.a(PbFragment.this.iID);
                    if (PbFragment.this.hPK != null && ckv != null && ckv.aCo() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(ckv.aCo());
                        PbFragment.this.hPK.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.edZ && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.iEu.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.iEu.getAppealInfo().iBI)) {
                                    PbFragment.this.iHP.a(PbFragment.this.iEu.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.iHP.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.iHP.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.iHP.cqj();
                            PbFragment.this.iHP.cpQ();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.iEu.cnz());
                            jSONObject.put("fid", PbFragment.this.iEu.getForumId());
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
                        PbFragment.this.iHP.Gd("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                            arrayList = PbFragment.this.iEu.getPbData().ckx();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cLb() != 1)) {
                            PbFragment.this.iHP.Gd(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbFragment.this.cnd()) {
                            PbFragment.this.iHP.Ge(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbFragment.this.iHP.Ge(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbFragment.this.iHP.endLoadData();
                }
                if (eVar != null && eVar.iBW && PbFragment.this.dDR == 0) {
                    PbFragment.this.dDR = System.currentTimeMillis() - PbFragment.this.fVt;
                }
                if (!PbFragment.this.clC().cnA() || PbFragment.this.clC().getPbData().getPage().aBl() != 0 || PbFragment.this.clC().coa()) {
                    PbFragment.this.iId = true;
                    return;
                }
                return;
            }
            PbFragment.this.iEu.yR(1);
            if (PbFragment.this.iHp != null) {
                PbFragment.this.iHp.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cnl() {
            if (PbFragment.this.iEu != null) {
                if (PbFragment.this.iIc == null || !PbFragment.this.iIc.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.iIc = (com.baidu.tbadk.editortools.pb.e) dVar.dV(PbFragment.this.getContext());
                    PbFragment.this.iIc.a(PbFragment.this.iHn.getPageContext());
                    PbFragment.this.iIc.a(PbFragment.this.dyN);
                    PbFragment.this.iIc.a(PbFragment.this.dyG);
                    PbFragment.this.iIc.a(PbFragment.this.iHn.getPageContext(), PbFragment.this.iHn.getIntent() == null ? null : PbFragment.this.iHn.getIntent().getExtras());
                    PbFragment.this.iIc.aOu().gB(true);
                    PbFragment.this.iHP.setEditorTools(PbFragment.this.iIc.aOu());
                    if (!PbFragment.this.iEu.cnF()) {
                        PbFragment.this.iIc.vm(PbFragment.this.iEu.cnz());
                    }
                    if (PbFragment.this.iEu.cog()) {
                        PbFragment.this.iIc.vl(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.iHP != null) {
                        PbFragment.this.iIc.vl(PbFragment.this.iHP.cpn());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
            PbFragment.this.iHP.o(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.aRm().aRn()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.fVt : j;
                if (PbFragment.this.dDR == 0) {
                    PbFragment.this.dDR = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.dDJ, PbFragment.this.createTime, PbFragment.this.dDR, z2, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.dDJ = 0L;
                if (iVar != null) {
                    iVar.aRj();
                }
                if (z2) {
                    iVar.dEa = currentTimeMillis;
                    iVar.gT(true);
                }
                if (!z2 && PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().ckv() != null) {
                    int threadType = PbFragment.this.iEu.getPbData().ckv().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iHB, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iHB, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.dEc = currentTimeMillis;
                                iVar2.mL(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.dEc = currentTimeMillis;
                        dVar.mL(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener iIP = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cmF();
            }
        }
    };
    private final a.InterfaceC0374a iIQ = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.iHP.cpI();
            if (z) {
                if (PbFragment.this.iHN != null) {
                    PbFragment.this.iHN.fm(z2);
                }
                PbFragment.this.iEu.pX(z2);
                if (PbFragment.this.iEu.ayL()) {
                    PbFragment.this.cmO();
                } else {
                    PbFragment.this.iHP.o(PbFragment.this.iEu.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.iHN != null) {
                        if (PbFragment.this.iHN.ayO() != null && PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.iEu.getPbData().ckv() != null && PbFragment.this.iEu.getPbData().ckv().aCo() != null) {
                            MarkData ayO = PbFragment.this.iHN.ayO();
                            MetaData aCo = PbFragment.this.iEu.getPbData().ckv().aCo();
                            if (ayO != null && aCo != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aCo.getUserId()) && !aCo.hadConcerned()) {
                                    PbFragment.this.b(aCo);
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
                    PbFragment.this.cmL();
                    return;
                }
                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbFragment.this.yE(PbFragment.this.mLastScrollState) && PbFragment.this.yE(i)) {
                if (PbFragment.this.iHP != null) {
                    PbFragment.this.iHP.cpZ();
                    if (PbFragment.this.iIc != null && !PbFragment.this.iHP.cpm()) {
                        PbFragment.this.iHP.qp(PbFragment.this.iIc.aPa());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.iHP.cpl();
                    }
                }
                if (!PbFragment.this.iHv) {
                    PbFragment.this.iHv = true;
                    if (PbFragment.this.iHP != null) {
                        PbFragment.this.iHP.cqf();
                    }
                }
            }
            if (PbFragment.this.iHP != null) {
                PbFragment.this.iHP.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iHp != null) {
                PbFragment.this.iHp.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iHw == null) {
                PbFragment.this.iHw = new com.baidu.tbadk.n.b();
                PbFragment.this.iHw.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.iHw.aRd();
            } else {
                PbFragment.this.iHw.aRc();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.cKb().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> ckx;
            if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null && PbFragment.this.iHP != null && PbFragment.this.iHP.cpC() != null) {
                PbFragment.this.iHP.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.iHp != null) {
                    PbFragment.this.iHp.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.iEu.cnW() && (ckx = PbFragment.this.iEu.getPbData().ckx()) != null && !ckx.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.iHP.cpC().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEu.getPbData();
                    if (pbData != null) {
                        if (pbData.cky() != null && pbData.cky().hasData()) {
                            headerCount--;
                        }
                        if (pbData.ckz() != null && pbData.ckz().hasData()) {
                            headerCount--;
                        }
                        int size = ckx.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d fKQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.fKL.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.iEu.cnT();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.iVT != 1002 || bVar.eLS) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.iHP.a(1, dVar.mSuccess, dVar.kju, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.fKL.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.iHP.a(PbFragment.this.fKL.getLoadDataMode(), gVar.mSuccess, gVar.kju, false);
                            PbFragment.this.iHP.aM(gVar.kjx);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.iHP.a(PbFragment.this.fKL.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c iIR = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
    };
    private final g.c ebP = new g.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cmT()) {
                PbFragment.this.iHn.finish();
            }
            if (!PbFragment.this.iEu.pW(true)) {
                PbFragment.this.iHP.cpJ();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e gIV = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.iIS && PbFragment.this.cmT()) {
                PbFragment.this.cmV();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.iEu.pV(false)) {
                    PbFragment.this.iHP.cpH();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.iEu.getPbData() != null) {
                    PbFragment.this.iHP.cqe();
                }
                PbFragment.this.iIS = true;
            }
        }
    };
    private int iIT = 0;
    private final TbRichTextView.i dMK = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f cpC;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.iHP.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.cy("tid", PbFragment.this.iEu.cnz());
                anVar.cy("fid", PbFragment.this.iEu.getForumId());
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.X("obj_locate", 3);
                anVar.X("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.iEu.iFn.ckT()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aTU() != null) {
                            ArrayList<TbRichTextImageInfo> aTU = tbRichTextView.getRichText().aTU();
                            int i4 = 0;
                            while (i4 < aTU.size()) {
                                if (aTU.get(i4) != null) {
                                    arrayList.add(aTU.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(aTU.get(i4).getSrc()) || str.equals(aTU.get(i4).aUm()) || str.equals(aTU.get(i4).aUj()) || str.equals(aTU.get(i4).aUl()) || str.equals(aTU.get(i4).aUp()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = aTU.get(i4).getSrc();
                                    imageUrlData.originalUrl = aTU.get(i4).getSrc();
                                    imageUrlData.isLongPic = aTU.get(i4).aUr();
                                    concurrentHashMap.put(aTU.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.iEu.cnQ(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.iEu.getPbData().ckv());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.iEC) {
                        TbRichText bj = PbFragment.this.bj(str, i);
                        if (bj != null && PbFragment.this.iIT >= 0 && PbFragment.this.iIT < bj.aTT().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.f.b(bj.aTT().get(PbFragment.this.iIT));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.iEz.size()) {
                                    break;
                                } else if (!aVar.iEz.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bj.getPostId() != 0 && (cpC = PbFragment.this.iHP.cpC()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = cpC.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bj.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bj.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEu.cof(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iEu.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.iEA.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEB, aVar.lastId, PbFragment.this.iEu.cnQ(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.iEu.getPbData().ckv());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.iEz, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.iEA.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEB, aVar.iEz.get(0), PbFragment.this.iEu.cnQ(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.iEu.getPbData().ckv());
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
                PbFragment.this.iHF = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean iIU = false;
    PostData hhL = null;
    private final b.a iIV = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.hhL != null) {
                if (i == 0) {
                    PbFragment.this.hhL.fv(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.hhL = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.k(PbFragment.this.hhL);
                }
            }
        }
    };
    private final b.a iIW = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iIm != null && !TextUtils.isEmpty(PbFragment.this.iIn)) {
                if (i == 0) {
                    if (PbFragment.this.iIo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iIn));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.iIn;
                        aVar.pkgId = PbFragment.this.iIo.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iIo.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.gQN == null) {
                            PbFragment.this.gQN = new ar(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.gQN.j(PbFragment.this.iIn, PbFragment.this.iIm.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.iIm = null;
                PbFragment.this.iIn = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a5 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01f8  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
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
                if (PbFragment.this.cv(view)) {
                    if (view instanceof TbImageView) {
                        PbFragment.this.iIm = ((TbImageView) view).getBdImage();
                        PbFragment.this.iIn = ((TbImageView) view).getUrl();
                        if (PbFragment.this.iIm == null || TextUtils.isEmpty(PbFragment.this.iIn)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iIo = null;
                        } else {
                            PbFragment.this.iIo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.iIm = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.iIn = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.iIo = null;
                            } else {
                                PbFragment.this.iIo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.iIm = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.iIn = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iIo = null;
                        } else {
                            PbFragment.this.iIo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.iHP.a(PbFragment.this.iIW, PbFragment.this.iIm.isGif());
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
            PbFragment.this.hhL = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.hhL == null) {
                return true;
            }
            if (PbFragment.this.hhL.cLb() != 1 || !PbFragment.this.cv(view)) {
                if (PbFragment.this.iHN != null) {
                    if (!PbFragment.this.iHN.ayL() || PbFragment.this.hhL.getId() == null || !PbFragment.this.hhL.getId().equals(PbFragment.this.iEu.aCx())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.clC().getPbData() != null && PbFragment.this.clC().getPbData().ckT();
                    if (PbFragment.this.hhL.cLb() != 1) {
                        if (PbFragment.this.iHV == null) {
                            PbFragment.this.iHV = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.iHV.a(PbFragment.this.iIX);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = PbFragment.this.cv(view) && !z3;
                            boolean z5 = (!PbFragment.this.cv(view) || PbFragment.this.iIm == null || PbFragment.this.iIm.isGif()) ? false : true;
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
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.iHV));
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.iHV));
                            }
                            if (!z4 && !z5) {
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iHV);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.hhL);
                                gVar3.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar3);
                            }
                            if (!z2 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iHV);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iHV);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.hhL);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z8 && z7) {
                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iHV);
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
                                    gVar4.mTextView.setTag(sparseArray5);
                                    arrayList.add(gVar4);
                                } else {
                                    if ((PbFragment.this.pL(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHV);
                                        gVar5.mTextView.setTag(str);
                                        arrayList.add(gVar5);
                                    }
                                }
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
                                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHV);
                                        gVar6.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iHV);
                                    gVar.mTextView.setTag(sparseArray6);
                                } else {
                                    if (z10) {
                                        SparseArray sparseArray7 = new SparseArray();
                                        sparseArray7.put(R.id.tag_should_manage_visible, false);
                                        sparseArray7.put(R.id.tag_user_mute_visible, false);
                                        sparseArray7.put(R.id.tag_should_delete_visible, true);
                                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                        sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                        sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                        if (PbFragment.this.iEu.getPbData().ckH() == 1002 && !z6) {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHV);
                                        } else {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHV);
                                        }
                                        gVar6.mTextView.setTag(sparseArray7);
                                    }
                                    gVar = null;
                                }
                                if (gVar6 != null) {
                                    arrayList.add(gVar6);
                                }
                                if (gVar != null) {
                                    arrayList.add(gVar);
                                }
                            }
                            PbFragment.this.iHV.az(arrayList);
                            PbFragment.this.iHU = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iHV);
                            PbFragment.this.iHU.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").cy("tid", PbFragment.this.iEu.iKi).cy("fid", PbFragment.this.iEu.getForumId()).cy("uid", PbFragment.this.iEu.getPbData().ckv().aCo().getUserId()).cy("post_id", PbFragment.this.iEu.aOP()).X("obj_source", z2 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.iHP.a(PbFragment.this.iIV, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.iHP.a(PbFragment.this.iIW, PbFragment.this.iIm.isGif());
            return true;
        }
    };
    private k.c iIX = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            int i2;
            if (PbFragment.this.iHU != null) {
                PbFragment.this.iHU.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.iIm != null && !TextUtils.isEmpty(PbFragment.this.iIn)) {
                        if (PbFragment.this.iIo == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iIn));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.iIn;
                            aVar.pkgId = PbFragment.this.iIo.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iIo.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.iIm = null;
                        PbFragment.this.iIn = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.iIm != null && !TextUtils.isEmpty(PbFragment.this.iIn)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.gQN == null) {
                                PbFragment.this.gQN = new ar(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.gQN.j(PbFragment.this.iIn, PbFragment.this.iIm.getImageByte());
                            PbFragment.this.iIm = null;
                            PbFragment.this.iIn = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.hhL != null) {
                        PbFragment.this.hhL.fv(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.hhL = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").X("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cu(view);
                        if (PbFragment.this.iEu.getPbData().ckv() != null && PbFragment.this.iEu.getPbData().ckv().aCo() != null && PbFragment.this.iEu.getPbData().ckv().aCo().getUserId() != null && PbFragment.this.iHN != null) {
                            int g = PbFragment.this.g(PbFragment.this.iEu.getPbData());
                            bj ckv = PbFragment.this.iEu.getPbData().ckv();
                            if (ckv.aBd()) {
                                i2 = 2;
                            } else if (ckv.aBe()) {
                                i2 = 3;
                            } else if (ckv.aEg()) {
                                i2 = 4;
                            } else {
                                i2 = ckv.aEh() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cy("tid", PbFragment.this.iEu.iKi).X("obj_locate", 2).cy("obj_id", PbFragment.this.iEu.getPbData().ckv().aCo().getUserId()).X("obj_type", PbFragment.this.iHN.ayL() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
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
                        PbFragment.this.FQ((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").X("obj_locate", 4));
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
                        PbFragment.this.iHP.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.iHP.cA(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.iHP.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a glY = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.iEu.cnG()) {
                PbFragment.this.cmQ();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener drN = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.gsB.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0499a fRM = new a.InterfaceC0499a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        final int eLv = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (av(i2) && PbFragment.this.iHP != null && PbFragment.this.iHp != null) {
                PbFragment.this.iHp.lC(true);
                if (Math.abs(i2) > this.eLv) {
                    PbFragment.this.iHp.hideFloatingView();
                }
                if (PbFragment.this.cmT()) {
                    PbFragment.this.iHP.cpz();
                    PbFragment.this.iHP.cpA();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (av(i2) && PbFragment.this.iHP != null && PbFragment.this.iHp != null) {
                PbFragment.this.iHP.cqk();
                PbFragment.this.iHp.lC(false);
                PbFragment.this.iHp.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a iGv = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.iHP.Gf(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int iIZ = -1;
    private int iJa = -1;

    /* loaded from: classes9.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes9.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e cmp() {
        return this.iIc;
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (lVar.clg() != null) {
            String id = lVar.clg().getId();
            ArrayList<PostData> ckx = this.iEu.getPbData().ckx();
            int i = 0;
            while (true) {
                if (i >= ckx.size()) {
                    break;
                }
                PostData postData = ckx.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> clk = lVar.clk();
                    postData.Cv(lVar.getTotalCount());
                    if (postData.cKY() != null && clk != null) {
                        Iterator<PostData> it = clk.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aCo() != null && (metaData = postData.getUserMap().get(next.aCo().getUserId())) != null) {
                                next.a(metaData);
                                next.sO(true);
                                next.a(getPageContext(), this.iEu.FW(metaData.getUserId()));
                            }
                        }
                        boolean z2 = clk.size() != postData.cKY().size();
                        postData.cKY().clear();
                        postData.cKY().addAll(clk);
                        z = z2;
                    }
                    if (postData.cKU() != null) {
                        postData.cKV();
                    }
                }
            }
            if (!this.iEu.getIsFromMark() && z) {
                this.iHP.o(this.iEu.getPbData());
            }
            if (z) {
                c(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m ckK = this.iEu.getPbData().ckK();
            if (ckK != null && str.equals(ckK.getAdId())) {
                if (ckK.cKP() != null) {
                    ckK.cKP().legoCard = null;
                }
                this.iEu.getPbData().ckL();
            }
            com.baidu.tieba.tbadkCore.data.m cnM = this.iEu.cnM();
            if (cnM != null && str.equals(cnM.getAdId())) {
                this.iEu.cnN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iHU != null && this.iHU.isShowing()) {
                this.iHU.dismiss();
                this.iHU = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.iHU != null) {
                            PbFragment.this.iHU.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.iHP.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.iIk);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.iIk);
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
                this.iHU = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.iHU.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        bj ckv;
        if (this.iEu != null && this.iEu.getPbData() != null && (ckv = this.iEu.getPbData().ckv()) != null) {
            if (i == 1) {
                PraiseData aBZ = ckv.aBZ();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aBZ == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        ckv.a(praiseData);
                    } else {
                        ckv.aBZ().getUser().add(0, metaData);
                        ckv.aBZ().setNum(ckv.aBZ().getNum() + 1);
                        ckv.aBZ().setIsLike(i);
                    }
                }
                if (ckv.aBZ() != null) {
                    if (ckv.aBZ().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(ckv.aBZ().getNum());
                    }
                }
            } else if (ckv.aBZ() != null) {
                ckv.aBZ().setIsLike(i);
                ckv.aBZ().setNum(ckv.aBZ().getNum() - 1);
                ArrayList<MetaData> user = ckv.aBZ().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            ckv.aBZ().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (ckv.aBZ().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = ckv.aBZ().getNum() + "";
                }
            }
            if (this.iEu.cnA()) {
                this.iHP.cpC().notifyDataSetChanged();
            } else {
                this.iHP.p(this.iEu.getPbData());
            }
        }
    }

    public static PbFragment cmq() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iHn = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iEu.au(bundle);
        if (this.goy != null) {
            this.goy.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.iIc.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iHu = System.currentTimeMillis();
        this.iIi = getPageContext();
        final Intent intent = this.iHn.getIntent();
        if (intent != null) {
            this.fVt = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.iHB = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.iHB)) {
                    this.iHB = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.iHB)) {
                this.iHq = true;
            }
            this.iIZ = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.iJa = intent.getIntExtra("key_manga_next_chapter", -1);
            this.iJb = intent.getStringExtra("key_manga_title");
            this.iHX = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.iHY = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.iHZ = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cmT()) {
                this.iHn.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.iIq = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.iHK = new ax();
            this.iHK.R(intent);
            this.iIs = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.iIs == 0) {
                this.iIs = intent.getIntExtra("key_start_from", 0);
            }
            this.iIt = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.fVt = System.currentTimeMillis();
        }
        this.dDJ = this.iHu - this.fVt;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.iHs = 0;
        at(bundle);
        if (this.iEu.getPbData() != null) {
            this.iEu.getPbData().FK(this.source);
        }
        cmt();
        if (intent != null && this.iHP != null) {
            this.iHP.iNU = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.iIl == null) {
                    this.iIl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.iHP.Gh("@" + intent.getStringExtra("big_pic_type") + HanziToPinyin.Token.SEPARATOR);
                        }
                    };
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.iIl, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.iEu.getPbData() != null) {
                this.iEu.FZ(stringExtra);
            }
        }
        this.goy = new VoiceManager();
        this.goy.onCreate(getPageContext());
        initData(bundle);
        this.iIb = new com.baidu.tbadk.editortools.pb.g();
        d(this.iIb);
        this.iIc = (com.baidu.tbadk.editortools.pb.e) this.iIb.dV(getActivity());
        this.iIc.a(this.iHn.getPageContext());
        this.iIc.a(this.dyN);
        this.iIc.a(this.dyG);
        this.iIc.a(this.iHn.getPageContext(), bundle);
        this.iIc.aOu().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iIc.aOu().gB(true);
        pK(true);
        this.iIc.a(this.iEu.cnO(), this.iEu.cnz(), this.iEu.cof());
        registerListener(this.iIy);
        if (!this.iEu.cnF()) {
            this.iIc.vm(this.iEu.cnz());
        }
        if (this.iEu.cog()) {
            this.iIc.vl(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.iHP != null) {
            this.iIc.vl(this.iHP.cpn());
        }
        registerListener(this.iIx);
        registerListener(this.iIz);
        registerListener(this.iIA);
        registerListener(this.gpN);
        registerListener(this.iIL);
        registerListener(this.iIw);
        this.iIa = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.kgf);
        this.iIa.cKI();
        registerListener(this.iIB);
        registerListener(this.dag);
        this.iEu.cnY();
        registerListener(this.iIP);
        registerListener(this.gpU);
        if (this.iHP != null && this.iHP.cqo() != null && this.iHP.cqp() != null) {
            this.iHp = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.iHP.cqo(), this.iHP.cqp(), this.iHP.cpt());
            this.iHp.a(this.iIG);
        }
        if (this.iHo && this.iHP != null && this.iHP.cqp() != null) {
            this.iHP.cqp().setVisibility(8);
        }
        this.iIj = new com.baidu.tbadk.core.view.d();
        this.iIj.toastTime = 1000L;
        registerListener(this.iIK);
        registerListener(this.iII);
        registerListener(this.iIJ);
        registerListener(this.gFN);
        registerListener(this.gpK);
        registerResponsedEventListener(TipEvent.class, this.gnG);
        this.iIk = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iIk;
        userMuteAddAndDelCustomMessage.setTag(this.iIk);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iIk;
        userMuteCheckCustomMessage.setTag(this.iIk);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iEu.cod().a(this.iIH);
        this.iHT = new ap();
        if (this.iIc.aOT() != null) {
            this.iHT.e(this.iIc.aOT().getInputView());
        }
        this.iIc.a(this.dyH);
        this.gEG = new ShareSuccessReplyToServerModel();
        a(this.iIu);
        this.hPK = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.hPK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.cZX) {
                        PbFragment.this.iIc.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.cZY && PbFragment.this.iHP != null && PbFragment.this.iHP.cpj() != null && PbFragment.this.iHP.cpj().cmo() != null) {
                        PbFragment.this.iHP.cpj().cmo().aPp();
                    } else if (i == com.baidu.tbadk.core.util.aj.cZZ) {
                        PbFragment.this.c(PbFragment.this.iIf);
                    }
                }
            }
        });
        this.iHM = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.iHM.t(getUniqueId());
        com.baidu.tieba.s.c.cKb().w(getUniqueId());
        com.baidu.tbadk.core.business.a.aAa().co("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.iHu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.iEu != null) {
            gVar.setForumName(this.iEu.clt());
            if (this.iEu.getPbData() != null && this.iEu.getPbData().getForum() != null) {
                gVar.a(this.iEu.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.iEu);
        }
    }

    public String cmr() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cms() {
        return this.iHp;
    }

    private void pK(boolean z) {
        this.iIc.gF(z);
        this.iIc.gG(z);
        this.iIc.gH(z);
    }

    private void cmt() {
        this.dkh = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.goy != null) {
            this.goy.onStart(getPageContext());
        }
    }

    public an cmu() {
        return this.iHP;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel clC() {
        return this.iEu;
    }

    public void FP(String str) {
        if (this.iEu != null && !StringUtils.isNull(str) && this.iHP != null) {
            this.iHP.qu(true);
            this.iEu.FP(str);
            this.iHA = true;
            this.iHP.cpZ();
            this.iHP.cqj();
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
        this.iHs = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.iHs == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.goy != null) {
            this.goy.onPause(getPageContext());
        }
        if (this.iHP != null) {
            this.iHP.onPause();
        }
        if (!this.iEu.cnF()) {
            this.iIc.saveDraft(this.iEu.cnz());
        }
        if (this.iEu != null) {
            this.iEu.cnZ();
        }
        com.baidu.tbadk.BdToken.c.axz().axE();
        MessageManager.getInstance().unRegisterListener(this.htK);
        bPX();
        MessageManager.getInstance().unRegisterListener(this.iII);
        MessageManager.getInstance().unRegisterListener(this.iIJ);
        MessageManager.getInstance().unRegisterListener(this.iIK);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cmv() {
        PostData a2 = com.baidu.tieba.pb.data.f.a(this.iEu.getPbData(), this.iEu.cnA(), this.iEu.cnX());
        return (a2 == null || a2.aCo() == null || a2.aCo().getGodUserData() == null || a2.aCo().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.iHD) {
            this.iHD = false;
            cmZ();
        }
        if (cmv()) {
            this.iHx = System.currentTimeMillis();
        } else {
            this.iHx = -1L;
        }
        if (this.iHP != null && this.iHP.getView() != null) {
            if (!this.iif) {
                cmR();
            } else {
                hideLoadingView(this.iHP.getView());
            }
            this.iHP.onResume();
        }
        if (this.iHs == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.iHP != null) {
            noNetworkView = this.iHP.cpg();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.goy != null) {
            this.goy.onResume(getPageContext());
        }
        registerListener(this.htK);
        this.iHW = false;
        cmY();
        registerListener(this.iII);
        registerListener(this.iIJ);
        registerListener(this.iIK);
        if (this.gpl) {
            cmQ();
            this.gpl = false;
        }
        cnf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.iHP.qj(z);
        if (this.iHU != null) {
            this.iHU.dismiss();
        }
        if (z && this.iHW) {
            this.iHP.cpH();
            this.iEu.pV(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iHx > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").cy("obj_duration", (System.currentTimeMillis() - this.iHx) + ""));
            this.iHx = 0L;
        }
        if (cmu().cpj() != null) {
            cmu().cpj().onStop();
        }
        if (this.iHP.iNW != null && !this.iHP.iNW.crf()) {
            this.iHP.iNW.releaseResources();
        }
        if (this.iEu != null && this.iEu.getPbData() != null && this.iEu.getPbData().getForum() != null && this.iEu.getPbData().ckv() != null) {
            com.baidu.tbadk.distribute.a.aOi().a(getPageContext().getPageActivity(), "pb", this.iEu.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iEu.getPbData().ckv().getId(), 0L));
        }
        if (this.goy != null) {
            this.goy.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.cKb().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cKb().x(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("fid", this.iEu.getPbData().getForumId());
            anVar.cy("tid", this.iEu.cnz());
            anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.iHv && this.iHP != null) {
            this.iHv = true;
            this.iHP.cqf();
            a(false, (PostData) null);
        }
        if (this.iEu != null) {
            this.iEu.cancelLoadData();
            this.iEu.destory();
            if (this.iEu.coc() != null) {
                this.iEu.coc().onDestroy();
            }
        }
        if (this.iIc != null) {
            this.iIc.onDestroy();
        }
        if (this.fKL != null) {
            this.fKL.cancelLoadData();
        }
        if (this.dkh != null) {
            this.dkh.cKv();
        }
        if (this.iHP != null) {
            this.iHP.onDestroy();
            if (this.iHP.iNW != null) {
                this.iHP.iNW.releaseResources();
            }
        }
        if (this.iHw != null) {
            this.iHw.aRe();
        }
        if (this.iHp != null) {
            this.iHp.aWJ();
        }
        super.onDestroy();
        if (this.goy != null) {
            this.goy.onDestory(getPageContext());
        }
        if (this.iHP != null) {
            this.iHP.cpZ();
        }
        MessageManager.getInstance().unRegisterListener(this.iII);
        MessageManager.getInstance().unRegisterListener(this.iIJ);
        MessageManager.getInstance().unRegisterListener(this.iIK);
        MessageManager.getInstance().unRegisterListener(this.iIk);
        MessageManager.getInstance().unRegisterListener(this.iIL);
        MessageManager.getInstance().unRegisterListener(this.gpU);
        MessageManager.getInstance().unRegisterListener(this.gFN);
        MessageManager.getInstance().unRegisterListener(this.iIN);
        this.iIi = null;
        this.iIj = null;
        com.baidu.tieba.recapp.d.a.cDl().cDn();
        if (this.iIl != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iIl);
        }
        if (this.iHE != null) {
            this.iHE.cancelLoadData();
        }
        if (this.iHP != null && this.iHP.iNW != null) {
            this.iHP.iNW.cri();
        }
        if (this.gEG != null) {
            this.gEG.cancelLoadData();
        }
        this.iHT.onDestroy();
        if (this.iEu != null && this.iEu.coe() != null) {
            this.iEu.coe().onDestroy();
        }
        if (this.hPK != null) {
            this.hPK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f cpC;
        ArrayList<PostData> cma;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aJe() && this.iHP != null && (cpC = this.iHP.cpC()) != null && (cma = cpC.cma()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cma.iterator();
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
                        bVar.fMG = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.cSL == 1 && !TextUtils.isEmpty(id)) {
                    next.cSL = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.fMG = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.iEu == null || this.iEu.getPbData() == null || this.iEu.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.iEu.getPbData().getForum().getFirst_class();
                    str2 = this.iEu.getPbData().getForum().getSecond_class();
                    str = this.iEu.getPbData().getForum().getId();
                    str4 = this.iEu.cnz();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aJh());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.iHP.onChangeSkinType(i);
            if (this.iIc != null && this.iIc.aOu() != null) {
                this.iIc.aOu().onChangeSkinType(i);
            }
            if (this.iHP.cpg() != null) {
                this.iHP.cpg().onChangeSkinType(getPageContext(), i);
            }
            this.iHT.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iHP = new an(this, this.gqD, this.dqX);
        this.gsB = new com.baidu.tieba.f.b(getActivity());
        this.gsB.a(iIY);
        this.gsB.a(this.fRM);
        this.iHP.setOnScrollListener(this.mOnScrollListener);
        this.iHP.d(this.gIV);
        this.iHP.setListPullRefreshListener(this.ebP);
        this.iHP.pw(com.baidu.tbadk.core.i.azO().isShowImages());
        this.iHP.setOnImageClickListener(this.dMK);
        this.iHP.b(this.mOnLongClickListener);
        this.iHP.g(this.glY);
        this.iHP.a(this.iIR);
        this.iHP.qj(this.mIsLogin);
        if (this.iHn.getIntent() != null) {
            this.iHP.qv(this.iHn.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.iHP.cpi().setFromForumId(this.iEu.getFromForumId());
        this.iHP.setEditorTools(this.iIc.aOu());
        this.iIc.vl(this.iHP.cpn());
        this.iHP.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.iEu.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEu.getPbData().getForum().getId(), PbFragment.this.iEu.getPbData().getForum().getName(), PbFragment.this.iEu.getPbData().ckv().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.iHP.getView();
    }

    public void cmw() {
        if (this.iHP != null && this.iEu != null) {
            if ((this.iEu.getPbData() != null || this.iEu.getPbData().ckQ() != null) && checkUpIsLogin() && this.iHP.cpC() != null && this.iHP.cpC().cmf() != null) {
                this.iHP.cpC().cmf().tY(this.iEu.cnz());
            }
        }
    }

    public void cmx() {
        TiebaStatic.log("c12181");
        if (this.iHP != null && this.iEu != null) {
            if ((this.iHP == null || this.iHP.cpm()) && this.iEu.getPbData() != null && this.iEu.getPbData().ckQ() != null) {
                com.baidu.tieba.pb.data.k ckQ = this.iEu.getPbData().ckQ();
                if (checkUpIsLogin()) {
                    if ((!ckQ.cld() || ckQ.aDK() != 2) && this.iHP.cpC() != null && this.iHP.cpC().cmf() != null) {
                        this.iHP.cpC().cmf().tY(this.iEu.cnz());
                    }
                    if (System.currentTimeMillis() - this.iHz > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).rd(false);
                        this.iHz = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ct(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.kgG && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.azO().isShowImages()) {
                    return FS(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.iEu == null || this.iEu.getPbData() == null) {
                        return true;
                    }
                    if (cmu().cpj() != null) {
                        cmu().cpj().cmk();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(this.iEu.getPbData().getForum());
                    lVar.setThreadData(this.iEu.getPbData().ckv());
                    lVar.f(postData);
                    cmu().cpi().d(lVar);
                    cmu().cpi().setPostId(postData.getId());
                    b(view, postData.aCo().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iIc != null) {
                        this.iHP.qp(this.iIc.aPa());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cmy() {
        if (this.iHt == null) {
            this.iHt = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.iHt.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.iEq = PbFragment.this.iEq.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEq);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iEu.cnz(), PbFragment.this.iEq, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.iEq = PbFragment.this.iEq.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEq);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iEu.cnz(), PbFragment.this.iEq, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.iEq = PbFragment.this.iEq.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEq);
                        bVar.dismiss();
                    }
                }
            }).kb(R.style.dialog_ani_b2t).kc(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.iIO.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).ctf(), "", 1);
    }

    private void at(Bundle bundle) {
        this.iEu = this.iHn.clC();
        if (this.iEu.cob() != null) {
            this.iEu.cob().a(this.iGv);
        }
        if (this.iEu.coc() != null) {
            this.iEu.coc().b(this.iIv);
        }
        if (StringUtils.isNull(this.iEu.cnz())) {
            this.iHn.finish();
        } else if ("from_tieba_kuang".equals(this.iHB) && this.iHB != null) {
            this.iEu.yY(6);
        }
    }

    private void initData(Bundle bundle) {
        this.iHN = com.baidu.tbadk.baseEditMark.a.a(this.iHn);
        if (this.iHN != null) {
            this.iHN.a(this.iIQ);
        }
        this.fKL = new ForumManageModel(this.iHn);
        this.fKL.setLoadDataCallBack(this.fKQ);
        this.dac = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iIF.setUniqueId(getUniqueId());
        this.iIF.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iHP.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iIk;
        userMuteCheckCustomMessage.setTag(this.iIk);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cmz() {
        if (this.iEu == null || this.iEu.getPbData() == null) {
            return false;
        }
        bj ckv = this.iEu.getPbData().ckv();
        this.iEu.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), ckv);
    }

    public void cmA() {
        if (checkUpIsLogin() && this.iEu != null && this.iEu.getPbData() != null && this.iEu.getPbData().getForum() != null && !cmz()) {
            if (this.iEu.getPbData().ckT()) {
                this.iHP.bPy();
                return;
            }
            if (this.grZ == null) {
                this.grZ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.grZ.tP(0);
                this.grZ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lw(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void t(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lx(boolean z) {
                        if (z) {
                            PbFragment.this.iHP.bPy();
                        }
                    }
                });
            }
            this.grZ.C(this.iEu.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iEu.cnz(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmB() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.iEu == null || (pbData = this.iEu.getPbData()) == null) {
            return null;
        }
        return pbData.ckG().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckv() != null) {
            if (eVar.ckv().getThreadType() == 0) {
                return 1;
            }
            if (eVar.ckv().getThreadType() == 54) {
                return 2;
            }
            if (eVar.ckv().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cmz() && cmC()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iHG);
                this.iHH = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.iEu.getPbData() != null && this.iEu.getPbData().ckT()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.iHn.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cmu().getListView().smoothScrollBy((PbFragment.this.iHG[1] + PbFragment.this.iHH) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cmu().cpj() != null) {
                            PbFragment.this.iIc.aOu().setVisibility(8);
                            PbFragment.this.cmu().cpj().g(str, str2, PbFragment.this.cmu().cpn(), (PbFragment.this.iEu == null || PbFragment.this.iEu.getPbData() == null || PbFragment.this.iEu.getPbData().ckv() == null || !PbFragment.this.iEu.getPbData().ckv().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmo = PbFragment.this.cmu().cpj().cmo();
                            if (cmo != null && PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                cmo.a(PbFragment.this.iEu.getPbData().getAnti());
                                cmo.setThreadData(PbFragment.this.iEu.getPbData().ckv());
                            }
                            if (PbFragment.this.iHT.cqA() == null && PbFragment.this.cmu().cpj().cmo().aPx() != null) {
                                PbFragment.this.cmu().cpj().cmo().aPx().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iHT != null && PbFragment.this.iHT.cqz() != null) {
                                            if (!PbFragment.this.iHT.cqz().cUg()) {
                                                PbFragment.this.iHT.qx(false);
                                            }
                                            PbFragment.this.iHT.cqz().tH(false);
                                        }
                                    }
                                });
                                PbFragment.this.iHT.f(PbFragment.this.cmu().cpj().cmo().aPx().getInputView());
                                PbFragment.this.cmu().cpj().cmo().a(PbFragment.this.iIh);
                            }
                        }
                        PbFragment.this.cmu().cqj();
                    }
                }, 0L);
                return;
            }
            if (this.iIe == null) {
                this.iIe = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iIe.tP(1);
                this.iIe.a(new AnonymousClass37(str, str2));
            }
            if (this.iEu != null && this.iEu.getPbData() != null && this.iEu.getPbData().getForum() != null) {
                this.iIe.C(this.iEu.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iEu.cnz(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$37  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass37 implements c.a {
        final /* synthetic */ String iJk;
        final /* synthetic */ String iJl;

        AnonymousClass37(String str, String str2) {
            this.iJk = str;
            this.iJl = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lw(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lx(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        }
                        PbFragment.this.cmu().getListView().smoothScrollBy((PbFragment.this.iHG[1] + PbFragment.this.iHH) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cmu().cpj() != null) {
                            PbFragment.this.iIc.aOu().setVisibility(8);
                            PbFragment.this.cmu().cpj().g(AnonymousClass37.this.iJk, AnonymousClass37.this.iJl, PbFragment.this.cmu().cpn(), (PbFragment.this.iEu == null || PbFragment.this.iEu.getPbData() == null || PbFragment.this.iEu.getPbData().ckv() == null || !PbFragment.this.iEu.getPbData().ckv().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmo = PbFragment.this.cmu().cpj().cmo();
                            if (cmo != null && PbFragment.this.iEu != null && PbFragment.this.iEu.getPbData() != null) {
                                cmo.a(PbFragment.this.iEu.getPbData().getAnti());
                                cmo.setThreadData(PbFragment.this.iEu.getPbData().ckv());
                            }
                            if (PbFragment.this.iHT.cqA() == null && PbFragment.this.cmu().cpj().cmo().aPx() != null) {
                                PbFragment.this.cmu().cpj().cmo().aPx().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iHT != null && PbFragment.this.iHT.cqz() != null) {
                                            if (!PbFragment.this.iHT.cqz().cUg()) {
                                                PbFragment.this.iHT.qx(false);
                                            }
                                            PbFragment.this.iHT.cqz().tH(false);
                                        }
                                    }
                                });
                                PbFragment.this.iHT.f(PbFragment.this.cmu().cpj().cmo().aPx().getInputView());
                                PbFragment.this.cmu().cpj().cmo().a(PbFragment.this.iIh);
                            }
                        }
                        PbFragment.this.cmu().cqj();
                    }
                }, 0L);
            }
        }
    }

    public boolean cmC() {
        if ((this.iEu.getPbData() != null && this.iEu.getPbData().ckT()) || this.hPK == null || this.iEu.getPbData() == null || this.iEu.getPbData().getAnti() == null) {
            return true;
        }
        return this.hPK.ks(this.iEu.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean yN(int i) {
        if (this.hPK == null || this.iEu.getPbData() == null || this.iEu.getPbData().getAnti() == null) {
            return true;
        }
        return this.hPK.ax(this.iEu.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.iEu != null && this.iEu.getPbData() != null && postData.cLb() != 1) {
            String cnz = this.iEu.cnz();
            String id = postData.getId();
            int ckH = this.iEu.getPbData() != null ? this.iEu.getPbData().ckH() : 0;
            PbActivity.a FT = FT(id);
            if (FT != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cnz, id, "pb", true, null, false, null, ckH, postData.csa(), this.iEu.getPbData().getAnti(), false, postData.aCo() != null ? postData.aCo().getIconInfo() : null).addBigImageData(FT.iEz, FT.iEA, FT.iEB, FT.index);
                addBigImageData.setKeyPageStartFrom(this.iEu.coi());
                addBigImageData.setFromFrsForumId(this.iEu.getFromForumId());
                addBigImageData.setKeyFromForumId(this.iEu.getForumId());
                addBigImageData.setBjhData(this.iEu.cnH());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmD() {
        if (this.iEu.getPbData() == null || this.iEu.getPbData().ckv() == null) {
            return -1;
        }
        return this.iEu.getPbData().ckv().aCY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmE() {
        if (this.iEu != null && this.iEu.iFn != null && this.iEu.iFn.ckv() != null) {
            bj ckv = this.iEu.iFn.ckv();
            ckv.mRecomAbTag = this.iEu.cot();
            ckv.mRecomWeight = this.iEu.cor();
            ckv.mRecomSource = this.iEu.cos();
            ckv.mRecomExtra = this.iEu.cou();
            if (ckv.getFid() == 0) {
                ckv.setFid(com.baidu.adp.lib.f.b.toLong(this.iEu.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ckv, "c13563");
            if (a2 != null) {
                a2.X("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmF() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Ix(this.iEu.getForumId()) && this.iEu.getPbData() != null && this.iEu.getPbData().getForum() != null) {
            if (this.iEu.getPbData().getForum().isLike() == 1) {
                this.iEu.coe().ev(this.iEu.getForumId(), this.iEu.cnz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iEu == null || this.iEu.getPbData() == null) {
            return false;
        }
        return ((this.iEu.getPbData().ckH() != 0) || this.iEu.getPbData().ckv() == null || this.iEu.getPbData().ckv().aCo() == null || TextUtils.equals(this.iEu.getPbData().ckv().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean pM(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.w wVar;
        if (this.iEu == null || this.iEu.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.iEu.getPbData();
        bj ckv = pbData.ckv();
        if (ckv != null) {
            if (ckv.aBd() || ckv.aBe()) {
                return false;
            }
            if (ckv.aEg() || ckv.aEh()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.ckH() != 0) {
                return pbData.ckH() != 3;
            }
            List<bf> ckO = pbData.ckO();
            if (com.baidu.tbadk.core.util.v.getCount(ckO) > 0) {
                for (bf bfVar : ckO) {
                    if (bfVar != null && (wVar = bfVar.cQQ) != null && wVar.cOK && !wVar.cOL && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean pN(boolean z) {
        if (z || this.iEu == null || this.iEu.getPbData() == null) {
            return false;
        }
        return ((this.iEu.getPbData().getForum() != null && this.iEu.getPbData().getForum().isBlockBawuDelete) || this.iEu.getPbData().ckH() == 0 || this.iEu.getPbData().ckH() == 3) ? false : true;
    }

    public void cmG() {
        com.baidu.tieba.pb.data.e pbData;
        bj ckv;
        if (this.iEu != null && this.iEu.getPbData() != null && (ckv = (pbData = this.iEu.getPbData()).ckv()) != null && ckv.aCo() != null) {
            this.iHP.cph();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), ckv.aCo().getUserId());
            z zVar = new z();
            int ckH = this.iEu.getPbData().ckH();
            if (ckH == 1 || ckH == 3) {
                zVar.iMn = true;
                zVar.iMm = true;
                zVar.iMs = ckv.aCj() == 1;
                zVar.iMr = ckv.aCk() == 1;
            } else {
                zVar.iMn = false;
                zVar.iMm = false;
            }
            if (ckH == 1002 && !equals) {
                zVar.iMt = true;
            }
            zVar.iMk = pM(equals);
            zVar.iMo = cmH();
            zVar.iMl = pN(equals);
            zVar.hW = this.iEu.cnA();
            zVar.iMh = true;
            zVar.iMg = pL(equals);
            zVar.iMf = equals && this.iHP.cpO();
            zVar.iMq = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.iMp = true;
            zVar.isHostOnly = this.iEu.getHostMode();
            zVar.iMj = true;
            if (ckv.aCF() == null) {
                zVar.iMi = true;
            } else {
                zVar.iMi = false;
            }
            if (pbData.ckT()) {
                zVar.iMh = false;
                zVar.iMj = false;
                zVar.iMi = false;
                zVar.iMm = false;
                zVar.iMn = false;
            }
            this.iHP.iNW.a(zVar);
        }
    }

    private boolean cmH() {
        if (this.iEu != null && this.iEu.cnA()) {
            return this.iEu.getPageData() == null || this.iEu.getPageData().aBl() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(View view) {
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
    public PbModel.a cmI() {
        return this.iIO;
    }

    public int cmJ() {
        if (cmu() == null || cmu().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cmu().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) mVar).Ag == com.baidu.tieba.pb.data.j.iCQ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmK() {
        if (cmu() == null || cmu().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cmu().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.kgF) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cmQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmL() {
        if (this.iEu != null && this.iEu.iFn != null && this.iEu.iFn.ckv() != null) {
            bj ckv = this.iEu.iFn.ckv();
            ckv.mRecomAbTag = this.iEu.cot();
            ckv.mRecomWeight = this.iEu.cor();
            ckv.mRecomSource = this.iEu.cos();
            ckv.mRecomExtra = this.iEu.cou();
            if (ckv.getFid() == 0) {
                ckv.setFid(com.baidu.adp.lib.f.b.toLong(this.iEu.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ckv, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.sR(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sS(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fG(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cy("obj_id", metaData.getUserId()).X("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cy("obj_id", metaData.getUserId()).X("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.dac.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.iEu.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aEC();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.iHP.cpI();
        this.iEu.pX(z);
        if (this.iHN != null) {
            this.iHN.fm(z);
            if (markData != null) {
                this.iHN.a(markData);
            }
        }
        if (this.iEu.ayL()) {
            cmO();
        } else {
            this.iHP.o(this.iEu.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yE(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ(String str) {
        if (this.iEu != null && this.iEu.getPbData() != null && this.iEu.getPbData().ckT()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iEu.cnz(), str);
            bj ckv = this.iEu.getPbData().ckv();
            if (ckv.aBd()) {
                format = format + "&channelid=33833";
            } else if (ckv.aEf()) {
                format = format + "&channelid=33842";
            } else if (ckv.aBe()) {
                format = format + "&channelid=33840";
            }
            FR(format);
            return;
        }
        this.iHM.Gq(str);
    }

    private void FR(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.iEu.cnF()) {
                    antiData.setBlock_forum_name(this.iEu.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.iEu.getPbData().getForum().getId());
                    antiData.setUser_name(this.iEu.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.iEu.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cmu() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            vr(str);
        } else {
            this.iHP.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.kju) ? bVar.kju : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sS(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fG(true);
                aVar.b(getPageContext());
                aVar.aEC();
            } else {
                this.iHP.a(0, bVar.mSuccess, bVar.kju, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fYk == 1) {
                    ArrayList<PostData> ckx = this.iEu.getPbData().ckx();
                    int size = ckx.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(ckx.get(i).getId())) {
                            i++;
                        } else {
                            ckx.remove(i);
                            break;
                        }
                    }
                    this.iEu.getPbData().ckv().jJ(this.iEu.getPbData().ckv().aCf() - 1);
                    this.iHP.o(this.iEu.getPbData());
                } else if (bVar.fYk == 0) {
                    cmM();
                } else if (bVar.fYk == 2) {
                    ArrayList<PostData> ckx2 = this.iEu.getPbData().ckx();
                    int size2 = ckx2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ckx2.get(i2).cKY().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(ckx2.get(i2).cKY().get(i3).getId())) {
                                i3++;
                            } else {
                                ckx2.get(i2).cKY().remove(i3);
                                ckx2.get(i2).cLa();
                                z2 = true;
                                break;
                            }
                        }
                        ckx2.get(i2).Jc(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.iHP.o(this.iEu.getPbData());
                    }
                    a(bVar, this.iHP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.iHP.a(this.fKL.getLoadDataMode(), gVar.mSuccess, gVar.kju, false);
            if (gVar.mSuccess) {
                this.iHQ = true;
                if (i == 2 || i == 3) {
                    this.iHR = true;
                    this.iHS = false;
                } else if (i == 4 || i == 5) {
                    this.iHR = false;
                    this.iHS = true;
                }
                if (i == 2) {
                    this.iEu.getPbData().ckv().jM(1);
                    this.iEu.setIsGood(1);
                } else if (i == 3) {
                    this.iEu.getPbData().ckv().jM(0);
                    this.iEu.setIsGood(0);
                } else if (i == 4) {
                    this.iEu.getPbData().ckv().jL(1);
                    this.iEu.yQ(1);
                } else if (i == 5) {
                    this.iEu.getPbData().ckv().jL(0);
                    this.iEu.yQ(0);
                }
                this.iHP.c(this.iEu.getPbData(), this.iEu.cnA());
            }
        }
    }

    private void cmM() {
        if (this.iEu.cnB() || this.iEu.cnD()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.iEu.cnz());
            PbActivity pbActivity = this.iHn;
            PbActivity pbActivity2 = this.iHn;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.iEu.cnz()));
        if (cmP()) {
            this.iHn.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clP() {
        this.iHn.clP();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData ckE;
        boolean z = false;
        if (this.iHP != null) {
            this.iHP.cpZ();
        }
        if (this.iEu != null && this.iEu.getPbData() != null && !this.iEu.getPbData().ckT()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.iEu.getPbData().ckv().getId();
            if (this.iEu.isShareThread() && this.iEu.getPbData().ckv().cTR != null) {
                historyMessage.threadName = this.iEu.getPbData().ckv().cTR.showText;
            } else {
                historyMessage.threadName = this.iEu.getPbData().ckv().getTitle();
            }
            if (this.iEu.isShareThread() && !cls()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.iEu.getPbData().getForum().getName();
            }
            ArrayList<PostData> ckx = this.iEu.getPbData().ckx();
            int cpK = this.iHP != null ? this.iHP.cpK() : 0;
            if (ckx != null && cpK >= 0 && cpK < ckx.size()) {
                historyMessage.postID = ckx.get(cpK).getId();
            }
            historyMessage.isHostOnly = this.iEu.getHostMode();
            historyMessage.isSquence = this.iEu.cnA();
            historyMessage.isShareThread = this.iEu.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iIc != null) {
            this.iIc.onDestroy();
        }
        if (this.iHr && cmu() != null) {
            cmu().cqt();
        }
        if (this.iEu != null && (this.iEu.cnB() || this.iEu.cnD())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.iEu.cnz());
            if (this.iHQ) {
                if (this.iHS) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.iEu.bxR());
                }
                if (this.iHR) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.iEu.getIsGood());
                }
            }
            if (this.iEu.getPbData() != null && System.currentTimeMillis() - this.iHu >= 40000 && (ckE = this.iEu.getPbData().ckE()) != null && !com.baidu.tbadk.core.util.v.isEmpty(ckE.getDataList())) {
                intent.putExtra("guess_like_data", ckE);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.iIq);
            }
            PbActivity pbActivity = this.iHn;
            PbActivity pbActivity2 = this.iHn;
            pbActivity.setResult(-1, intent);
        }
        if (cmP()) {
            if (this.iEu != null && this.iHP != null && this.iHP.getListView() != null) {
                com.baidu.tieba.pb.data.e pbData = this.iEu.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.ckB() && !this.iHA && pbData.iBR == null) {
                        ah coR = ah.coR();
                        com.baidu.tieba.pb.data.e cnI = this.iEu.cnI();
                        Parcelable onSaveInstanceState = this.iHP.getListView().onSaveInstanceState();
                        boolean cnA = this.iEu.cnA();
                        boolean hostMode = this.iEu.getHostMode();
                        if (this.iHP.cpt() != null && this.iHP.cpt().getVisibility() == 0) {
                            z = true;
                        }
                        coR.a(cnI, onSaveInstanceState, cnA, hostMode, z);
                        if (this.iIp >= 0 || this.iEu.cok() != null) {
                            ah.coR().n(this.iEu.cok());
                            ah.coR().m(this.iEu.col());
                            ah.coR().za(this.iEu.com());
                        }
                    }
                }
            } else {
                ah.coR().reset();
            }
            clP();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.iHP == null || !this.iHP.zg(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yO(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iHn;
        if (i == 0) {
            this.iHP.cph();
            this.iHP.cpj().cmk();
            this.iHP.qr(false);
        }
        this.iHP.cpl();
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
                        this.iIc.resetData();
                        this.iIc.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iIc.b(writeData);
                        com.baidu.tbadk.editortools.l mp = this.iIc.aOu().mp(6);
                        if (mp != null && mp.dwN != null) {
                            mp.dwN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iHn;
                        if (i == -1) {
                            this.iIc.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iHP.cpj() != null && this.iHP.cpj().cmo() != null) {
                            com.baidu.tbadk.editortools.pb.h cmo = this.iHP.cpj().cmo();
                            cmo.setThreadData(this.iEu.getPbData().ckv());
                            cmo.b(writeData);
                            cmo.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mp2 = cmo.aOu().mp(6);
                            if (mp2 != null && mp2.dwN != null) {
                                mp2.dwN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iHn;
                            if (i == -1) {
                                cmo.aPp();
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
        this.iIc.onActivityResult(i, i2, intent);
        if (this.iHE != null) {
            this.iHE.onActivityResult(i, i2, intent);
        }
        if (cmu().cpj() != null) {
            cmu().cpj().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cmN();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ah.coR().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.iEu != null) {
                                PbFragment.this.iEu.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cCb().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.iEu != null) {
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
                        com.baidu.tieba.o.a.cCb().A(getPageContext());
                        cmF();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.gEG != null && shareItem != null && shareItem.linkUrl != null) {
                            this.gEG.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aLL() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55.1
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
                    this.iHP.pB(false);
                    if (this.iEu.getPbData() != null && this.iEu.getPbData().ckv() != null && this.iEu.getPbData().ckv().aCI() != null) {
                        this.iEu.getPbData().ckv().aCI().setStatus(2);
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
                        this.iIf = emotionImageData;
                        if (yN(com.baidu.tbadk.core.util.aj.cZZ)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.iHF != null) {
                        this.iHP.cB(this.iHF);
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
            if (this.iHE == null) {
                this.iHE = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iHn);
                this.iHE.b(this.dyG);
                this.iHE.c(this.dyN);
            }
            this.iHE.a(emotionImageData, clC(), clC().getPbData());
        }
    }

    private void aj(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmN() {
        MarkData yX;
        if (this.iHN != null) {
            if (this.iEu.getPbData() != null && this.iEu.getPbData().ckT()) {
                yX = this.iEu.yX(0);
            } else {
                yX = this.iEu.yX(this.iHP.cpL());
            }
            if (yX != null) {
                if (!yX.isApp() || (yX = this.iEu.yX(this.iHP.cpL() + 1)) != null) {
                    this.iHP.cpG();
                    this.iHN.a(yX);
                    if (!this.iHN.ayL()) {
                        this.iHN.ayN();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iHN.ayM();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmO() {
        com.baidu.tieba.pb.data.e pbData = this.iEu.getPbData();
        this.iEu.pX(true);
        if (this.iHN != null) {
            pbData.FJ(this.iHN.ayK());
        }
        this.iHP.o(pbData);
    }

    private boolean cmP() {
        if (this.iEu == null) {
            return true;
        }
        if (this.iEu.getPbData() == null || !this.iEu.getPbData().ckT()) {
            if (this.iEu.ayL()) {
                final MarkData cnS = this.iEu.cnS();
                if (cnS == null || !this.iEu.getIsFromMark()) {
                    return true;
                }
                final MarkData yX = this.iEu.yX(this.iHP.cpK());
                if (yX == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cnS);
                    this.iHn.setResult(-1, intent);
                    return true;
                } else if (yX.getPostId() == null || yX.getPostId().equals(cnS.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cnS);
                    this.iHn.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.sS(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.iHN != null) {
                                if (PbFragment.this.iHN.ayL()) {
                                    PbFragment.this.iHN.ayM();
                                    PbFragment.this.iHN.fm(false);
                                }
                                PbFragment.this.iHN.a(yX);
                                PbFragment.this.iHN.fm(true);
                                PbFragment.this.iHN.ayN();
                            }
                            cnS.setPostId(yX.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnS);
                            PbFragment.this.iHn.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.clP();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnS);
                            PbFragment.this.iHn.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.clP();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.iHP != null && PbFragment.this.iHP.getView() != null) {
                                PbFragment.this.iHP.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cnS);
                                PbFragment.this.iHn.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.clP();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aEC();
                    return false;
                }
            } else if (this.iEu.getPbData() == null || this.iEu.getPbData().ckx() == null || this.iEu.getPbData().ckx().size() <= 0 || !this.iEu.getIsFromMark()) {
                return true;
            } else {
                this.iHn.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.iHP == null) {
            return null;
        }
        return this.iHP.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUA() {
        if (this.iHP == null) {
            return 0;
        }
        return this.iHP.cpX();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUB() {
        if (this.dMA == null) {
            this.dMA = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUN */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.azO().isShowImages();
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
                        if (com.baidu.tbadk.core.i.azO().isShowImages()) {
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
        return this.dMA;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUC() {
        if (this.dPo == null) {
            this.dPo = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUD() {
        if (this.dMB == null) {
            this.dMB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bHa */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.azO().isShowImages();
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
                    if (com.baidu.tbadk.core.i.azO().isShowImages()) {
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
                    gifView.aPP();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dMB;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUE() {
        if (this.dPp == null) {
            this.dPp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnm */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cw */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cMi();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dPp;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUG() {
        this.dPr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnn */
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
        return this.dPr;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIj() {
        if (this.djp == null) {
            this.djp = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.djp;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iHy = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (as.Gi(str) && this.iEu != null && this.iEu.cnz() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").X("obj_param1", 1).cy("post_id", this.iEu.cnz()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.dvQ = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            as.cqC().c(getPageContext(), str);
        }
        this.iHy = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        as.cqC().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iHy = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.iHP != null && this.iHP.cqo() != null && rect.top <= this.iHP.cqo().getHeight()) {
            rect.top += this.iHP.cqo().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.iEu.getPbData();
            TbRichText bj = bj(str, i);
            if (bj != null && (tbRichTextData = bj.aTT().get(this.iIT)) != null) {
                aVar.postId = String.valueOf(bj.getPostId());
                aVar.iEz = new ArrayList<>();
                aVar.iEA = new ConcurrentHashMap<>();
                if (!tbRichTextData.aTZ().aUk()) {
                    aVar.iEC = false;
                    String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                    aVar.iEz.add(b2);
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
                    imageUrlData.postId = bj.getPostId();
                    imageUrlData.mIsReserver = this.iEu.cnQ();
                    imageUrlData.mIsSeeHost = this.iEu.getHostMode();
                    aVar.iEA.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.ckv() != null) {
                            aVar.threadId = pbData.ckv().getId();
                        }
                        aVar.iEB = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.iEC = true;
                int size = pbData.ckx().size();
                this.iIU = false;
                aVar.index = -1;
                int a2 = pbData.ckC() != null ? a(pbData.ckC().cLd(), bj, i, i, aVar.iEz, aVar.iEA) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.ckx().get(i2);
                    if (postData.getId() == null || pbData.ckC() == null || pbData.ckC().getId() == null || !postData.getId().equals(pbData.ckC().getId())) {
                        a2 = a(postData.cLd(), bj, a2, i, aVar.iEz, aVar.iEA);
                    }
                }
                if (aVar.iEz.size() > 0) {
                    aVar.lastId = aVar.iEz.get(aVar.iEz.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.ckv() != null) {
                        aVar.threadId = pbData.ckv().getId();
                    }
                    aVar.iEB = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTZ() == null) {
            return null;
        }
        return tbRichTextData.aTZ().aUp();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTZ() == null) {
            return 0L;
        }
        return tbRichTextData.aTZ().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTZ() == null) {
            return false;
        }
        return tbRichTextData.aTZ().aUq();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTZ() == null) {
            return false;
        }
        return tbRichTextData.aTZ().aUr();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aTZ;
        String str;
        if (tbRichText == tbRichText2) {
            this.iIU = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aTT().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aTT().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aTZ().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aTZ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aTZ().aUk()) {
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
                        String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                            if (tbRichTextData != null && (aTZ = tbRichTextData.aTZ()) != null) {
                                String aUm = aTZ.aUm();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aTZ.aUn();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = aUm;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iEu.cnz(), -1L);
                                imageUrlData.mIsReserver = this.iEu.cnQ();
                                imageUrlData.mIsSeeHost = this.iEu.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.iIU) {
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

    protected void k(PostData postData) {
        PostData ckC;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.iEu.aCx())) {
                z = true;
            }
            MarkData l = this.iEu.l(postData);
            if (this.iEu.getPbData() != null && this.iEu.getPbData().ckT() && (ckC = ckC()) != null) {
                l = this.iEu.l(ckC);
            }
            if (l != null) {
                this.iHP.cpG();
                if (this.iHN != null) {
                    this.iHN.a(l);
                    if (!z) {
                        this.iHN.ayN();
                    } else {
                        this.iHN.ayM();
                    }
                }
            }
        }
    }

    public boolean cv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bj(String str, int i) {
        TbRichText tbRichText = null;
        if (this.iEu == null || this.iEu.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.iEu.getPbData();
        if (pbData.ckC() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.ckC());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> ckx = pbData.ckx();
            c(pbData, ckx);
            return c(ckx, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.ckG() != null && eVar.ckG().iDe != null && (list = eVar.ckG().iDe) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> aTT;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cLd = arrayList.get(i2).cLd();
            if (cLd != null && (aTT = cLd.aTT()) != null) {
                int size = aTT.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aTT.get(i4) != null && aTT.get(i4).getType() == 8) {
                        i3++;
                        if (aTT.get(i4).aTZ().aUm().equals(str) || aTT.get(i4).aTZ().aUn().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aTT.get(i4).aTZ().getWidth() * equipmentDensity;
                            int height = aTT.get(i4).aTZ().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iIT = i4;
                            return cLd;
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
            this.iEq = str;
            if (this.iHt == null) {
                cmy();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.iHt.getItemView(1).setVisibility(8);
            } else {
                this.iHt.getItemView(1).setVisibility(0);
            }
            this.iHt.aED();
            this.iHy = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.goy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmQ() {
        hideNetRefreshView(this.iHP.getView());
        cmR();
        if (this.iEu.cnL()) {
            this.iHP.cpG();
        }
        this.iHP.cpR();
    }

    private void cmR() {
        showLoadingView(this.iHP.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.iHP.cqo().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEl() {
        if (this.goy != null) {
            this.goy.stopPlay();
        }
        if (this.iHn != null) {
            this.iHn.bEl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cmD(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUF() {
        if (this.dPq == null) {
            this.dPq = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cno */
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
        return this.dPq;
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

    public void bEm() {
        if (this.iHn != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.iHn.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iHn.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bCZ() {
        if (this.iEu == null || this.iEu.getPbData() == null) {
            return null;
        }
        return this.iEu.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(an.iPh)).intValue();
            if (intValue == an.iPi) {
                if (!this.fKL.cLP()) {
                    this.iHP.cpD();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.fKL.Jh(com.baidu.tbadk.core.util.aq.O(jSONArray));
                    }
                    this.fKL.a(this.iEu.getPbData().getForum().getId(), this.iEu.getPbData().getForum().getName(), this.iEu.getPbData().ckv().getId(), str, intValue3, intValue2, booleanValue, this.iEu.getPbData().ckv().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.iPj || intValue == an.iPl) {
                if (this.iEu.cob() != null) {
                    this.iEu.cob().yI(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.iPj) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iIk);
        userMuteAddAndDelCustomMessage.setTag(this.iIk);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean FS(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0584a
    public void pO(boolean z) {
        this.iHW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmS() {
        ArrayList<PostData> ckx;
        int count;
        if (this.iEu == null || this.iEu.getPbData() == null || this.iEu.getPbData().ckx() == null || (count = com.baidu.tbadk.core.util.v.getCount((ckx = this.iEu.getPbData().ckx()))) == 0) {
            return "";
        }
        if (this.iEu.cnQ()) {
            Iterator<PostData> it = ckx.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cLb() == 1) {
                    return next.getId();
                }
            }
        }
        int cpK = this.iHP.cpK();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(ckx, cpK);
        if (postData == null || postData.aCo() == null) {
            return "";
        }
        if (this.iEu.FW(postData.aCo().getUserId())) {
            return postData.getId();
        }
        for (int i = cpK - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(ckx, i);
            if (postData2 == null || postData2.aCo() == null || postData2.aCo().getUserId() == null) {
                break;
            } else if (this.iEu.FW(postData2.aCo().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cpK + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(ckx, i2);
            if (postData3 == null || postData3.aCo() == null || postData3.aCo().getUserId() == null) {
                return "";
            }
            if (this.iEu.FW(postData3.aCo().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        this.iHy = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a FT(String str) {
        String str2;
        if (this.iEu.getPbData() == null || this.iEu.getPbData().ckx() == null || this.iEu.getPbData().ckx().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.iEu.getPbData().ckx().size()) {
                i = 0;
                break;
            } else if (str.equals(this.iEu.getPbData().ckx().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.iEu.getPbData().ckx().get(i);
        if (postData.cLd() == null || postData.cLd().aTT() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cLd().aTT().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aTZ() != null) {
                    str2 = next.aTZ().aUm();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.f.a(postData, aVar);
        return aVar;
    }

    public boolean cmT() {
        return (!this.iHo && this.iIZ == -1 && this.iJa == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null) {
            this.iJc = pVar;
            this.iHo = true;
            this.iHP.cpu();
            this.iHP.Gg(this.iJb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        if (this.iJc != null) {
            if (this.iIZ == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iJc.getCartoonId(), this.iIZ, 0)));
                this.iHn.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmV() {
        if (this.iJc != null) {
            if (this.iJa == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iJc.getCartoonId(), this.iJa, 0)));
                this.iHn.finish();
            }
        }
    }

    public int cmW() {
        return this.iIZ;
    }

    public int cmX() {
        return this.iJa;
    }

    private void bPX() {
        if (this.iEu != null && this.iEu.getPbData() != null && this.iEu.getPbData().ckv() != null && this.iEu.getPbData().ckv().aBb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cmY() {
        if (this.iEu != null && this.iEu.getPbData() != null && this.iEu.getPbData().ckv() != null && this.iEu.getPbData().ckv().aBb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cmZ() {
        if (this.isPaused) {
            this.iHD = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.iEu.getPbData() != null && this.iEu.getPbData().ckv() != null && this.iEu.getPbData().ckv().aBU() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iEu.getPbData().ckv().aBU().getThreadId(), this.iEu.getPbData().ckv().aBU().getTaskId(), this.iEu.getPbData().ckv().aBU().getForumId(), this.iEu.getPbData().ckv().aBU().getForumName(), this.iEu.getPbData().ckv().aCj(), this.iEu.getPbData().ckv().aCk())));
            this.iHq = true;
            this.iHn.finish();
        }
    }

    public String cna() {
        return this.iHB;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cnb() {
        return this.iHL;
    }

    public void pP(boolean z) {
        this.iHC = z;
    }

    public boolean aEc() {
        if (this.iEu != null) {
            return this.iEu.cnB();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sS(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.iIi).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.iIi.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iIi).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vr(String str) {
        if (str == null) {
            str = "";
        }
        if (this.iIi != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iIi.getPageActivity());
            aVar.sS(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iIi).aEC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iHP.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iIi.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.sS(this.iIi.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sS(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.iHP.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iIi).aEC();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.Gi(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.gOq) {
            this.gOq = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.iHP != null) {
                this.iHP.onConfigurationChanged(configuration);
            }
            if (this.iHU != null) {
                this.iHU.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cnd() {
        if (this.iEu != null) {
            return this.iEu.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.iEu.getPbData().ckG().iDe;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cKY().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cKY().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cKY().remove(i2);
                    list.get(i).cLa();
                    z = true;
                    break;
                }
            }
            list.get(i).Jc(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.o(this.iEu.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.l lVar) {
        String id = lVar.clg().getId();
        List<PostData> list = this.iEu.getPbData().ckG().iDe;
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
                ArrayList<PostData> clk = lVar.clk();
                postData.Cv(lVar.getTotalCount());
                if (postData.cKY() != null) {
                    postData.cKY().clear();
                    postData.cKY().addAll(clk);
                }
            }
        }
        if (!this.iEu.getIsFromMark()) {
            this.iHP.o(this.iEu.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a clr() {
        return this.iHn.clr();
    }

    public boolean cls() {
        if (this.iEu == null) {
            return false;
        }
        return this.iEu.cls();
    }

    public void cne() {
        if (this.iHP != null) {
            this.iHP.cph();
            bEm();
        }
    }

    public PostData ckC() {
        return this.iHP.b(this.iEu.iFn, this.iEu.cnA());
    }

    public void onBackPressed() {
        if (this.iIr != null && !this.iIr.isEmpty()) {
            int size = this.iIr.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.iIr.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.iIr == null) {
                this.iIr = new ArrayList();
            }
            if (!this.iIr.contains(aVar)) {
                this.iIr.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.iIr == null) {
                this.iIr = new ArrayList();
            }
            if (!this.iIr.contains(aVar)) {
                this.iIr.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.iIr != null) {
            this.iIr.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnf() {
        if (this.iEu != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.iEu.cnz())) {
            com.baidu.tbadk.BdToken.c.axz().o(com.baidu.tbadk.BdToken.b.cGM, com.baidu.adp.lib.f.b.toLong(this.iEu.cnz(), 0L));
        }
    }

    public ax cng() {
        return this.iHK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FU(String str) {
        if (this.iEu != null && this.iEu.getPbData() != null && this.iEu.getPbData().ckv() != null && this.iEu.getPbData().ckv().aEi()) {
            bj ckv = this.iEu.getPbData().ckv();
            int i = 0;
            if (ckv.aBd()) {
                i = 1;
            } else if (ckv.aBe()) {
                i = 2;
            } else if (ckv.aEg()) {
                i = 3;
            } else if (ckv.aEh()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.X("obj_source", 4);
            anVar.X("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cnh() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cni() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cnj() {
        return this.iHn;
    }
}
