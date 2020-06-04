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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bp;
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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
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
/* loaded from: classes9.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0698a {
    private com.baidu.adp.lib.d.b<TbImageView> dXO;
    private LikeModel dYI;
    private com.baidu.adp.lib.d.b<ImageView> eBC;
    private com.baidu.adp.lib.d.b<GifView> eBD;
    private com.baidu.adp.lib.d.b<TextView> eEq;
    private com.baidu.adp.lib.d.b<View> eEr;
    private com.baidu.adp.lib.d.b<LinearLayout> eEs;
    private com.baidu.adp.lib.d.b<RelativeLayout> eEt;
    private az hRB;
    private VoiceManager hns;
    private com.baidu.tieba.frs.profession.permission.c hra;
    private com.baidu.tieba.f.b hrv;
    public com.baidu.tbadk.core.util.aj iQC;
    private String jHR;
    private com.baidu.tieba.pb.pb.report.a jLC;
    public ax jLJ;
    private com.baidu.tbadk.core.dialog.i jLK;
    private com.baidu.tbadk.core.dialog.k jLL;
    private boolean jLM;
    private com.baidu.tieba.tbadkCore.data.f jLQ;
    private com.baidu.tbadk.editortools.pb.g jLR;
    private com.baidu.tbadk.editortools.pb.e jLS;
    private com.baidu.tieba.frs.profession.permission.c jLU;
    private EmotionImageData jLV;
    private com.baidu.adp.base.e jLY;
    private com.baidu.tbadk.core.view.c jLZ;
    private PbActivity jLc;
    private com.baidu.tieba.pb.pb.main.b.b jLe;
    private com.baidu.tieba.pb.pb.main.emotion.model.a jLt;
    private View jLu;
    int jLw;
    private com.baidu.tbadk.core.data.ay jLz;
    private boolean jMJ;
    private String jMT;
    private com.baidu.tbadk.core.data.o jMU;
    private BdUniqueId jMa;
    private Runnable jMb;
    private com.baidu.adp.widget.ImageView.a jMc;
    private String jMd;
    private TbRichTextMemeInfo jMe;
    private List<a> jMh;
    public String jMj;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a jMQ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.f.b.a
        public void bZ(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cDC();
            } else {
                com.baidu.tieba.pb.a.b.cDB();
            }
        }
    };
    private boolean jLd = false;
    private boolean jLf = false;
    private boolean beu = false;
    private boolean jjV = false;
    private boolean jLg = true;
    private int jLh = 0;
    private com.baidu.tbadk.core.dialog.b jLi = null;
    private long gPV = -1;
    private long esg = 0;
    private long jLj = 0;
    private long createTime = 0;
    private long erW = 0;
    private boolean jLk = false;
    private com.baidu.tbadk.n.b jLl = null;
    private long jLm = 0;
    private boolean jLn = false;
    private long jLo = 0;
    private int hPc = 1;
    private String emL = null;
    private boolean jLp = false;
    private boolean isFullScreen = false;
    private String jLq = "";
    private boolean jLr = true;
    private boolean jLs = false;
    private String source = "";
    private int mSkinType = 3;
    int[] jLv = new int[2];
    private int jLx = -1;
    private int jLy = -1;
    public BdUniqueId jLA = BdUniqueId.gen();
    private PbInterviewStatusView.a jLB = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.jLF.rT(!PbFragment.this.jLr);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.jHV != null && PbFragment.this.jHV.aML()) {
                        PbFragment.this.cEX();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel jHV = null;
    private com.baidu.tbadk.baseEditMark.a jLD = null;
    private ForumManageModel gFg = null;
    private com.baidu.tbadk.coreExtra.model.a dNL = null;
    private com.baidu.tieba.pb.data.o jLE = null;
    private ShareSuccessReplyToServerModel hEF = null;
    private av jLF = null;
    private boolean jLG = false;
    private boolean jLH = false;
    private boolean jLI = false;
    private boolean eSR = false;
    private boolean jLN = false;
    private boolean jLO = false;
    private boolean jLP = false;
    private boolean jLT = false;
    public boolean jLW = false;
    private com.baidu.tbadk.editortools.pb.c emO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bdv() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b emP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bdu() {
            if (PbFragment.this.jLJ == null || PbFragment.this.jLJ.cIJ() == null || !PbFragment.this.jLJ.cIJ().dmx()) {
                return !PbFragment.this.Ah(com.baidu.tbadk.core.util.aj.dNG);
            }
            PbFragment.this.showToast(PbFragment.this.jLJ.cIJ().dmz());
            if (PbFragment.this.jLS != null && (PbFragment.this.jLS.bdK() || PbFragment.this.jLS.bdL())) {
                PbFragment.this.jLS.a(false, PbFragment.this.jLJ.cIM());
            }
            PbFragment.this.jLJ.sf(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b jLX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bdu() {
            if (PbFragment.this.jLJ == null || PbFragment.this.jLJ.cIK() == null || !PbFragment.this.jLJ.cIK().dmx()) {
                return !PbFragment.this.Ah(com.baidu.tbadk.core.util.aj.dNH);
            }
            PbFragment.this.showToast(PbFragment.this.jLJ.cIK().dmz());
            if (PbFragment.this.jLF != null && PbFragment.this.jLF.cHu() != null && PbFragment.this.jLF.cHu().cEy() != null && PbFragment.this.jLF.cHu().cEy().bdL()) {
                PbFragment.this.jLF.cHu().cEy().a(PbFragment.this.jLJ.cIM());
            }
            PbFragment.this.jLJ.sg(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean hoe = false;
    private int jMf = 0;
    private int jMg = -1;
    public int jMi = 0;
    private final a jMk = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.jLF != null && PbFragment.this.jLF.cHu() != null) {
                t cHu = PbFragment.this.jLF.cHu();
                if (cHu.cEw()) {
                    cHu.cEv();
                    return true;
                }
            }
            if (PbFragment.this.jLF != null && PbFragment.this.jLF.cIs()) {
                PbFragment.this.jLF.cIt();
                return true;
            }
            return false;
        }
    };
    private final ae.a jMl = new ae.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void aN(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.jLF.showToast(str);
            }
        }
    };
    private final CustomMessageListener jMm = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jHV != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.jLS != null) {
                    PbFragment.this.jLF.rY(PbFragment.this.jLS.bdD());
                }
                PbFragment.this.jLF.cHw();
                PbFragment.this.jLF.cIk();
            }
        }
    };
    CustomMessageListener hoJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbFragment.this.jHV.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbFragment.this.jLF != null && PbFragment.this.jHV != null) {
                    PbFragment.this.jLF.b(PbFragment.this.jHV.getPbData(), PbFragment.this.jHV.cFL(), PbFragment.this.jHV.cGi(), PbFragment.this.jLF.getSkinType());
                }
                if (PbFragment.this.jLF != null && PbFragment.this.jLF.cHN() != null) {
                    PbFragment.this.jLF.cHN().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener jMn = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.jLF != null) {
                    if (booleanValue) {
                        PbFragment.this.jLF.cnR();
                    } else {
                        PbFragment.this.jLF.cnQ();
                    }
                }
            }
        }
    };
    private CustomMessageListener jMo = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.jLS != null) {
                    PbFragment.this.jLF.rY(PbFragment.this.jLS.bdD());
                }
                PbFragment.this.jLF.sa(false);
            }
        }
    };
    private CustomMessageListener jMp = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.n) eVar.getData());
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
    private CustomMessageListener jMq = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jLF != null && PbFragment.this.jLF.cHN() != null) {
                PbFragment.this.jLF.cHN().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener iuz = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener hoG = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.beu) {
                PbFragment.this.cFo();
            }
        }
    };
    private View.OnClickListener eny = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.emL);
        }
    };
    private CustomMessageListener jMr = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                aq.a aVar = new aq.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jHV.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.jHV.cFZ() != null && PbFragment.this.jHV.cFZ().getUserIdLong() == aaVar.toUserId) {
                        PbFragment.this.jLF.a(aaVar.sendCount, PbFragment.this.jHV.getPbData(), PbFragment.this.jHV.cFL(), PbFragment.this.jHV.cGi());
                    }
                    if (pbData.cCA() != null && pbData.cCA().size() >= 1 && pbData.cCA().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cCA().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.jHV.cFJ(), 0L);
                        if (j == aaVar.postId && j2 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.aq ddR = pbData.cCA().get(0).ddR();
                            if (ddR == null) {
                                ddR = new com.baidu.tbadk.core.data.aq();
                            }
                            ArrayList<aq.a> aPv = ddR.aPv();
                            if (aPv == null) {
                                aPv = new ArrayList<>();
                            }
                            aPv.add(0, aVar);
                            ddR.setTotal(aaVar.sendCount + ddR.getTotal());
                            ddR.w(aPv);
                            pbData.cCA().get(0).a(ddR);
                            PbFragment.this.jLF.cHN().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hFL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                PbFragment.this.Jk((String) customResponsedMessage.getData());
                PbFragment.this.jHV.cGe();
                if (PbFragment.this.jLF.cHN() != null) {
                    PbFragment.this.jLF.r(PbFragment.this.jHV.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a jMs = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cJc()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a jMt = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aN(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.jLF != null) {
                PbFragment.this.jLF.ea(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean jMu = false;
    private PraiseModel jMv = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void An(String str) {
            PbFragment.this.jMu = false;
            if (PbFragment.this.jMv != null) {
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jHV.getPbData();
                if (pbData.cCy().aQi().getIsLike() == 1) {
                    PbFragment.this.uS(0);
                } else {
                    PbFragment.this.uS(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cCy()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.jMu = false;
            if (PbFragment.this.jMv != null && str != null) {
                if (AntiHelper.bv(i, str)) {
                    AntiHelper.aX(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a jMw = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void rz(boolean z) {
            PbFragment.this.ry(z);
            if (PbFragment.this.jLF.cIy() != null && z) {
                PbFragment.this.jLF.rT(false);
            }
            PbFragment.this.jLF.rV(z);
        }
    };
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().ecK != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().ecK, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.cCH().aQx() != null && PbFragment.this.cCH().aQx().getGodUserData() != null) {
                            PbFragment.this.cCH().aQx().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().cCy() != null && PbFragment.this.jHV.getPbData().cCy().aQx() != null) {
                            PbFragment.this.jHV.getPbData().cCy().aQx().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h hmy = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.jLc.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a jMx = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.jLF.bGh();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.Aj(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.cdZ();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c efF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cEH();
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
                        if (PbFragment.this.cB(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.jLF.cEF() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").dh("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cDD() != null && PbFragment.this.cDD().gWU != null) {
                                PbFragment.this.cDD().gWU.onClick(view);
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
                if (PbFragment.this.jLS != null) {
                    PbFragment.this.jLF.rY(PbFragment.this.jLS.bdD());
                }
                PbFragment.this.jLF.cHw();
                PbFragment.this.jLF.cIk();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener jMy = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jMa) {
                PbFragment.this.jLF.bGh();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jHV.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cCO().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.jLZ.showSuccessToast(PbFragment.this.jLY.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.jLY.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.yo(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cFl();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.jLY.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.jLZ.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener jMz = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jMa) {
                PbFragment.this.jLF.bGh();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.jLZ.showSuccessToast(PbFragment.this.jLY.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.jLY.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.jLZ.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener jMA = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jMa) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.jLF.bGh();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.lAC;
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
                    PbFragment.this.jLF.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener jMB = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jLF.cHx() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cEH();
            }
        }
    };
    private CustomMessageListener hoR = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.hoe = true;
                }
            }
        }
    };
    public a.b juY = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bVq();
            com.baidu.tbadk.core.data.ao pageData = PbFragment.this.jHV.getPageData();
            int pageNum = PbFragment.this.jLF.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aPo()) {
                PbFragment.this.jLF.cIk();
                PbFragment.this.bVp();
                PbFragment.this.jLF.cHR();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.jHV.An(PbFragment.this.jLF.getPageNum());
                    if (PbFragment.this.jLe != null) {
                        PbFragment.this.jLe.showFloatingView();
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
    public final View.OnClickListener hpF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        /* JADX WARN: Removed duplicated region for block: B:648:0x1d64  */
        /* JADX WARN: Removed duplicated region for block: B:651:0x1dab  */
        /* JADX WARN: Removed duplicated region for block: B:668:0x1fb9  */
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
            bp bpVar;
            String[] strArr;
            boolean w;
            String name;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.jLF.cIg()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.jHV.rE(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.jLF.cHS();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.jLF.jSj.cJp() == null || view != PbFragment.this.jLF.jSj.cJp().cGX()) {
                        if (view == PbFragment.this.jLF.jSj.eun) {
                            if (PbFragment.this.jLF.rX(PbFragment.this.jHV.cFQ())) {
                                PbFragment.this.bVp();
                                return;
                            }
                            PbFragment.this.jLg = false;
                            PbFragment.this.jLf = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.jLc, PbFragment.this.jLF.jSj.eun);
                            PbFragment.this.jLc.finish();
                        } else if (view != PbFragment.this.jLF.cHP() && (PbFragment.this.jLF.jSj.cJp() == null || (view != PbFragment.this.jLF.jSj.cJp().cGW() && view != PbFragment.this.jLF.jSj.cJp().cGU()))) {
                            if (view == PbFragment.this.jLF.cIo()) {
                                if (PbFragment.this.jHV != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jHV.getPbData().cCy().aQw().getLink());
                                }
                            } else if (view != PbFragment.this.jLF.jSj.jYB) {
                                if (view == PbFragment.this.jLF.jSj.jYC) {
                                    if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                        ArrayList<PostData> cCA = PbFragment.this.jHV.getPbData().cCA();
                                        if ((cCA == null || cCA.size() <= 0) && PbFragment.this.jHV.cFL()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").dh("tid", PbFragment.this.jHV.cFJ()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", PbFragment.this.jHV.getForumId()));
                                        if (!PbFragment.this.jLF.cID()) {
                                            PbFragment.this.jLF.cHw();
                                        }
                                        PbFragment.this.cEP();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.jLF.rn(true);
                                        PbFragment.this.jLF.cHw();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.jLF.cnR();
                                            PbFragment.this.bVp();
                                            PbFragment.this.jLF.cHR();
                                            PbFragment.this.jHV.Jr(PbFragment.this.cFb());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.jLF.jSj.cJp() == null || view != PbFragment.this.jLF.jSj.cJp().cGT()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.jLF.jSj.cJp() != null && view == PbFragment.this.jLF.jSj.cJp().cGS()) {
                                            PbFragment.this.jLF.jSj.aEa();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.jLF.jSj.cJp() == null || view != PbFragment.this.jLF.jSj.cJp().cGQ()) {
                                                if ((PbFragment.this.jLF.jSj.cJp() == null || view != PbFragment.this.jLF.jSj.cJp().cGZ()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.jLF.jSj.cJp() == null || view != PbFragment.this.jLF.jSj.cJp().cGR()) {
                                                        if (PbFragment.this.jLF.jSj.cJp() == null || view != PbFragment.this.jLF.jSj.cJp().cHa()) {
                                                            if (PbFragment.this.jLF.cIy() == view) {
                                                                if (PbFragment.this.jLF.cIy().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.e pbData2 = PbFragment.this.jHV.getPbData();
                                                                    if (pbData2 != null && pbData2.cCy() != null && pbData2.cCy().aQd() != null) {
                                                                        String aPU = pbData2.cCy().aQd().aPU();
                                                                        if (StringUtils.isNull(aPU)) {
                                                                            aPU = pbData2.cCy().aQd().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").dh("obj_id", aPU));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.fr("c10725", null);
                                                                }
                                                                PbFragment.this.cFi();
                                                            } else if (PbFragment.this.jLF.jSj.cJp() == null || view != PbFragment.this.jLF.jSj.cJp().cGY()) {
                                                                if (PbFragment.this.jLF.jSj.cJp() != null && view == PbFragment.this.jLF.jSj.cJp().cGV()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.jLF.b(PbFragment.this.jHV.getPbData(), PbFragment.this.jHV.cFL(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.jLF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.jLF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.jLF.jSj.aEa();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.dh("tid", PbFragment.this.jHV.cFJ());
                                                                        anVar.dh("fid", PbFragment.this.jHV.getForumId());
                                                                        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.ag("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                                                            PbFragment.this.jLF.cIk();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.ddV() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.lmQ != null) {
                                                                                    com.baidu.tbadk.core.util.an aUS = postData.lmQ.aUS();
                                                                                    aUS.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aUS.ag("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aUS.ag("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aUS);
                                                                                }
                                                                                String cFJ = PbFragment.this.jHV.cFJ();
                                                                                String id = postData.getId();
                                                                                int i3 = 0;
                                                                                if (PbFragment.this.jHV.getPbData() != null) {
                                                                                    i3 = PbFragment.this.jHV.getPbData().cCN();
                                                                                }
                                                                                PbFragment.this.bVp();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a Jp = PbFragment.this.Jp(id);
                                                                                    if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && Jp != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cFJ, id, "pb", true, null, true, null, i3, postData.cKn(), PbFragment.this.jHV.getPbData().getAnti(), false, postData.aQx().getIconInfo()).addBigImageData(Jp.jId, Jp.jIe, Jp.jIf, Jp.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.jHV.cGt());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.jHV.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.jHV.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.jHV.cFS());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a Jp2 = PbFragment.this.Jp(id);
                                                                                    if (postData != null && PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && Jp2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cFJ, id, "pb", true, null, false, null, i3, postData.cKn(), PbFragment.this.jHV.getPbData().getAnti(), false, postData.aQx().getIconInfo()).addBigImageData(Jp2.jId, Jp2.jIe, Jp2.jIf, Jp2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.jHV.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.jHV.cFS());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.jHV.cGt());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.jHV.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").ag("obj_locate", 3).dh("fid", PbFragment.this.jHV.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.jHV != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.dh("tid", PbFragment.this.jHV.cFJ());
                                                                        anVar2.dh("fid", PbFragment.this.jHV.getForumId());
                                                                        anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.ag("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (postData2.lmQ != null) {
                                                                                    com.baidu.tbadk.core.util.an aUS2 = postData2.lmQ.aUS();
                                                                                    aUS2.delete("obj_locate");
                                                                                    aUS2.ag("obj_locate", 8);
                                                                                    TiebaStatic.log(aUS2);
                                                                                }
                                                                                if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                                                                    String cFJ2 = PbFragment.this.jHV.cFJ();
                                                                                    String id2 = postData2.getId();
                                                                                    int i4 = 0;
                                                                                    if (PbFragment.this.jHV.getPbData() != null) {
                                                                                        i4 = PbFragment.this.jHV.getPbData().cCN();
                                                                                    }
                                                                                    PbActivity.a Jp3 = PbFragment.this.Jp(id2);
                                                                                    if (Jp3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cFJ2, id2, "pb", true, null, false, null, i4, postData2.cKn(), PbFragment.this.jHV.getPbData().getAnti(), false, postData2.aQx().getIconInfo()).addBigImageData(Jp3.jId, Jp3.jIe, Jp3.jIf, Jp3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.jHV.cGt());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.jHV.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.jHV.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.jHV.cFS());
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
                                                                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img) {
                                                                    if (PbFragment.this.jHV != null) {
                                                                        if (view.getId() == R.id.pb_post_reply) {
                                                                            com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                            anVar3.dh("tid", PbFragment.this.jHV.cFJ());
                                                                            anVar3.dh("fid", PbFragment.this.jHV.getForumId());
                                                                            anVar3.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            anVar3.ag("obj_locate", 6);
                                                                            TiebaStatic.log(anVar3);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (view.getId() == R.id.pb_post_reply && postData3.lmQ != null) {
                                                                                    com.baidu.tbadk.core.util.an aUS3 = postData3.lmQ.aUS();
                                                                                    aUS3.delete("obj_locate");
                                                                                    aUS3.ag("obj_locate", 8);
                                                                                    TiebaStatic.log(aUS3);
                                                                                } else if (view.getId() == R.id.post_info_commont_img) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13700").dh("tid", PbFragment.this.jHV.cFK()).dh("fid", PbFragment.this.jHV.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", postData3.getId()).ag("obj_type", 3));
                                                                                }
                                                                                if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.cEE().cHt() != null && postData3.aQx() != null && postData3.ddJ() != 1) {
                                                                                    if (PbFragment.this.cEE().cHu() != null) {
                                                                                        PbFragment.this.cEE().cHu().cEu();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                                                                                    nVar.a(PbFragment.this.jHV.getPbData().getForum());
                                                                                    nVar.setThreadData(PbFragment.this.jHV.getPbData().cCy());
                                                                                    nVar.g(postData3);
                                                                                    PbFragment.this.cEE().cHt().d(nVar);
                                                                                    PbFragment.this.cEE().cHt().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.aQx().getUserId(), "");
                                                                                    if (PbFragment.this.jLS != null) {
                                                                                        PbFragment.this.jLF.rY(PbFragment.this.jLS.bdD());
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
                                                                } else if (view != PbFragment.this.jLF.cDY()) {
                                                                    if (view == PbFragment.this.jLF.jSj.cJq()) {
                                                                        PbFragment.this.jLF.cHY();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (bpVar = (bp) view.getTag()) != null && !StringUtils.isNull(bpVar.aSL())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                com.baidu.tbadk.core.util.ba.aVa().b(PbFragment.this.getPageContext(), new String[]{bpVar.aSL()});
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                if (view != null && view.getTag() != null) {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").dh("tid", PbFragment.this.jHV.jOs));
                                                                                    }
                                                                                    if (PbFragment.this.jLL == null) {
                                                                                        PbFragment.this.jLL = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.jLL.a(PbFragment.this.jMP);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cD(view);
                                                                                    if (!PbFragment.this.cD(view) || PbFragment.this.jMc == null || !PbFragment.this.jMc.isGif()) {
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
                                                                                        if (postData4.ddL() != null && postData4.ddL().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.jLL);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar4.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar4);
                                                                                        }
                                                                                        PbFragment.this.iiy = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.jHV.getPbData().aML()) {
                                                                                        String aMK = PbFragment.this.jHV.getPbData().aMK();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(aMK) && aMK.equals(postData4.getId())) {
                                                                                            z = true;
                                                                                            if (!z) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.jLL);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.jLL);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.iiy);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z4 && z3) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.jLL);
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
                                                                                                    if (PbFragment.this.ru(z2) && TbadkCoreApplication.isLogin()) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.jLL);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jLL);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.jLL);
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
                                                                                                    if (PbFragment.this.jHV.getPbData().cCN() == 1002 && !z2) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.jLL);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jLL);
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
                                                                                            PbFragment.this.jLL.aD(arrayList);
                                                                                            PbFragment.this.jLK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jLL);
                                                                                            PbFragment.this.jLK.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z = false;
                                                                                    if (!z) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.iiy);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.jLL.aD(arrayList);
                                                                                    PbFragment.this.jLK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jLL);
                                                                                    PbFragment.this.jLK.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().cCy() != null && PbFragment.this.jHV.getPbData().cCy().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.jHV.getPbData().cCy().getActUrl());
                                                                                if (PbFragment.this.jHV.getPbData().cCy().aRl() != 1) {
                                                                                    if (PbFragment.this.jHV.getPbData().cCy().aRl() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str2 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").dh("fid", PbFragment.this.jHV.getPbData().getForumId()).dh("tid", PbFragment.this.jHV.getPbData().getThreadId()).dh("lotterytail", StringUtils.string(str2, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.jHV.getPbData().getThreadId().equals(str2)) {
                                                                                    PbFragment.this.jLF.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.jLF.cHw();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.cEN() == 1 && PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").dh("fid", PbFragment.this.jHV.getPbData().getForumId()).dh("tid", PbFragment.this.jHV.getPbData().getThreadId()).dh("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.cEN() == 1 && PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").dh("fid", PbFragment.this.jHV.getPbData().getForumId()).dh("tid", PbFragment.this.jHV.getPbData().getThreadId()).dh("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.cFd();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.cFe();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().cCT() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData3 = PbFragment.this.jHV.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").dh("fid", pbData3.getForumId()));
                                                                                com.baidu.tbadk.core.util.ba.aVa().b(PbFragment.this.getPageContext(), new String[]{pbData3.cCT().cDe()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().cCT() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData4 = PbFragment.this.jHV.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").dh("fid", pbData4.getForumId()));
                                                                                com.baidu.tbadk.core.util.ba.aVa().b(PbFragment.this.getPageContext(), new String[]{pbData4.cCT().cDe()});
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.jMf >= 0) {
                                                                                if (PbFragment.this.jHV != null) {
                                                                                    PbFragment.this.jHV.cGu();
                                                                                }
                                                                                if (PbFragment.this.jHV != null && PbFragment.this.jLF.cHN() != null) {
                                                                                    PbFragment.this.jLF.cHN().a(PbFragment.this.jHV.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.jMf = 0;
                                                                                if (PbFragment.this.jHV != null) {
                                                                                    PbFragment.this.jLF.getListView().setSelection(PbFragment.this.jHV.cGx());
                                                                                    PbFragment.this.jHV.cD(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.cEK();
                                                                        } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                            SparseArray sparseArray10 = null;
                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                sparseArray10 = (SparseArray) view.getTag();
                                                                            }
                                                                            if (sparseArray10 != null) {
                                                                                PbFragment.this.d(sparseArray10);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                            if (PbFragment.this.jLF.getListView() != null && PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.jLF.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.jLF.getListView().getChildAt(0);
                                                                                int top2 = childAt == null ? 0 : childAt.getTop();
                                                                                boolean aWj = PbFragment.this.jHV.getPbData().aWj();
                                                                                boolean z7 = PbFragment.this.jLF.cHv() != null && PbFragment.this.jLF.cHv().bxE();
                                                                                boolean cIh = PbFragment.this.jLF.cIh();
                                                                                boolean z8 = firstVisiblePosition == 0 && top2 == 0;
                                                                                int i5 = 0;
                                                                                if (aWj && PbFragment.this.jLF.cHv() != null && PbFragment.this.jLF.cHv().bre() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.jLF.cHv().cIZ();
                                                                                    z8 = firstVisiblePosition == 0 && (top2 == equipmentWidth || top2 == PbFragment.this.jLF.cHv().bre().getHeight() - PbFragment.this.jLF.cHv().cIZ());
                                                                                    i5 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.Jq("c13568");
                                                                                if ((PbFragment.this.jHV.getPbData().cCy() != null && PbFragment.this.jHV.getPbData().cCy().aQo() <= 0) || (cIh && z8)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.cEK();
                                                                                        if (PbFragment.this.jHV.getPbData().cCy().aQx() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", PbFragment.this.jHV.jOs).dh("fid", PbFragment.this.jHV.getPbData().getForumId()).ag("obj_locate", 2).dh("uid", PbFragment.this.jHV.getPbData().cCy().aQx().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z9 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (aWj) {
                                                                                        if (PbFragment.this.jLF.jTt != null && PbFragment.this.jLF.jTt.jUx != null && PbFragment.this.jLF.jTt.jUx.getView() != null) {
                                                                                            if (PbFragment.this.jLF.jTt.jUx.getView().getParent() == null) {
                                                                                                z9 = firstVisiblePosition >= PbFragment.this.cET();
                                                                                            } else {
                                                                                                int i6 = 0;
                                                                                                if (PbFragment.this.jLF.cHv() != null && PbFragment.this.jLF.cHv().bre() != null) {
                                                                                                    i6 = PbFragment.this.jLF.cHv().bre().getBottom();
                                                                                                }
                                                                                                z9 = PbFragment.this.jLF.jTt.jUx.getView().getTop() <= i6;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.jLF.cHE() != null) {
                                                                                        z9 = PbFragment.this.jLF.cHE().getVisibility() == 0;
                                                                                        if (!z9 && PbFragment.this.jLF.jTt != null && PbFragment.this.jLF.jTt.jUx != null && PbFragment.this.jLF.jTt.jUx.getView() != null && PbFragment.this.jLF.jTt.jUx.getView().getParent() != null && PbFragment.this.jLF.jSj != null && PbFragment.this.jLF.jSj.mNavigationBar != null) {
                                                                                            z9 = PbFragment.this.jLF.jTt.jUx.getView().getTop() - PbFragment.this.jLF.jSj.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z9 || cIh) {
                                                                                        PbFragment.this.jLx = firstVisiblePosition;
                                                                                        PbFragment.this.jLy = top2;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top2 < (-equipmentHeight))) {
                                                                                            PbFragment.this.jLF.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                            PbFragment.this.jLF.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.jLF.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.jLx > 0) {
                                                                                        if (PbFragment.this.jLF.getListView().getChildAt(PbFragment.this.jLx) != null) {
                                                                                            PbFragment.this.jLF.getListView().smoothScrollToPosition(PbFragment.this.jLx, PbFragment.this.jLy, 200);
                                                                                        } else {
                                                                                            PbFragment.this.jLF.getListView().setSelectionFromTop(PbFragment.this.jLx, PbFragment.this.jLy + equipmentHeight);
                                                                                            PbFragment.this.jLF.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int cET = PbFragment.this.cET();
                                                                                        if (PbFragment.this.cES() != -1) {
                                                                                            cET--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (cET < 0) {
                                                                                            i = PbFragment.this.jLF.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.jLF.getListView().getData()) - 1);
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            i = cET;
                                                                                            i2 = dimens;
                                                                                        }
                                                                                        if (z7) {
                                                                                            i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!aWj || PbFragment.this.jLF.cHv() == null) {
                                                                                            if (PbFragment.this.jLF.jSj != null && PbFragment.this.jLF.jSj.mNavigationBar != null) {
                                                                                                i2 += PbFragment.this.jLF.jSj.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i2 += PbFragment.this.jLF.cHv().cIY();
                                                                                        }
                                                                                        if (PbFragment.this.jLF.jTt == null || PbFragment.this.jLF.jTt.jUx == null || PbFragment.this.jLF.jTt.jUx.getView() == null || PbFragment.this.jLF.jTt.jUx.getView().getParent() == null) {
                                                                                            PbFragment.this.jLF.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                            PbFragment.this.jLF.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z7) {
                                                                                            PbFragment.this.jLF.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                        } else {
                                                                                            PbFragment.this.jLF.getListView().smoothScrollBy(PbFragment.this.jLF.jTt.jUx.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.jHV.getPbData().cCy() != null && PbFragment.this.jHV.getPbData().cCy().aQx() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", PbFragment.this.jHV.jOs).dh("fid", PbFragment.this.jHV.getPbData().getForumId()).ag("obj_locate", 2).dh("uid", PbFragment.this.jHV.getPbData().cCy().aQx().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.jHV.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.jHV.cGt() == 3) {
                                                                                    PbFragment.this.jLc.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.jHV.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.dh("tid", PbFragment.this.jHV.cFJ());
                                                                                anVar4.dh("fid", PbFragment.this.jHV.getForumId());
                                                                                anVar4.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                if (PbFragment.this.jHV.getPbData().cCy() != null) {
                                                                                    anVar4.dh("nid", PbFragment.this.jHV.getPbData().cCy().getNid());
                                                                                }
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                            if (view.getTag() instanceof bk) {
                                                                                bk bkVar = (bk) view.getTag();
                                                                                if (PbFragment.this.jHV.cGt() == 3 && PbFragment.this.cDE() && PbFragment.this.jHV.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.jHV.getPbData().cCU())) {
                                                                                    PbFragment.this.jLc.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bkVar.aQC(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.dh("tid", bkVar.getId());
                                                                                anVar5.s("fid", bkVar.getFid());
                                                                                anVar5.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar5.dh("nid", bkVar.getNid());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbFragment.this.jHV != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.dh("tid", PbFragment.this.jHV.cFJ());
                                                                                anVar6.dh("fid", PbFragment.this.jHV.getForumId());
                                                                                anVar6.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.ag("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData5 = PbFragment.this.jHV.getPbData();
                                                                                if (PbFragment.this.jLE == null) {
                                                                                    PbFragment.this.jLE = new com.baidu.tieba.pb.data.o(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").s("forum_id", j2).aUT();
                                                                                PbFragment.this.registerListener(PbFragment.this.jME);
                                                                                PbFragment.this.jLE.F(j, j2);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").dh("fid", PbFragment.this.jHV.getForumId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("obj_name", smartApp.name).s("obj_id", smartApp.swan_app_id.longValue()).dh("obj_source", "PB_card").dh("tid", PbFragment.this.jHV.cFJ()).ag("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bk) {
                                                                                bk bkVar2 = (bk) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bkVar2.aQC(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").dh("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 9).ag("obj_locate", 9).s("obj_id", bkVar2.getFid()).dh("tid", bkVar2.getId()).ag("thread_type", bkVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bk) && PbFragment.this.checkUpIsLogin()) {
                                                                                bk bkVar3 = (bk) view.getTag();
                                                                                if (PbFragment.this.dYI != null) {
                                                                                    PbFragment.this.dYI.fq(bkVar3.aQC(), String.valueOf(bkVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").dh("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 10).ag("obj_locate", 11).s("obj_id", bkVar3.getFid()).dh("tid", bkVar3.getId()).ag("thread_type", bkVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.jHV.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.jHV.cFJ(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.jHV.getPbData().cCy().aQT())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.jLF.cIk();
                                                                SparseArray<Object> b3 = PbFragment.this.jLF.b(PbFragment.this.jHV.getPbData(), PbFragment.this.jHV.cFL(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jHV.getPbData().getForum().getId(), PbFragment.this.jHV.getPbData().getForum().getName(), PbFragment.this.jHV.getPbData().cCy().getId(), String.valueOf(PbFragment.this.jHV.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                com.baidu.tbadk.core.util.am.y(true, false);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 0).ag("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 1).ag("obj_source", 1));
                                                            }
                                                            PbFragment.this.jLF.jSj.cJo();
                                                        }
                                                    } else if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().cCy() != null) {
                                                        PbFragment.this.jLF.jSj.aEa();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.Jm(PbFragment.this.jHV.getPbData().cCy().aQP());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.jLF.cIk();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.jHV.cGc()));
                                                            return;
                                                        }
                                                        PbFragment.this.bVp();
                                                        PbFragment.this.jLF.cHR();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.jHV.getPbData().jFb == null || PbFragment.this.jHV.getPbData().jFb.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.jHV.getPbData().jFb.size()];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int i8 = i7;
                                                                if (i8 >= PbFragment.this.jHV.getPbData().jFb.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i8] = PbFragment.this.jHV.getPbData().jFb.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i7 = i8 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                int i10 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.jHV.getSortType() == 1 && i9 == 1) {
                                                                    i10 = 0;
                                                                } else if (PbFragment.this.jHV.getSortType() == 2 && i9 == 0) {
                                                                    i10 = 1;
                                                                } else if (PbFragment.this.jHV.getSortType() != 3 || i9 == 2) {
                                                                    i10 = (i9 != 2 || PbFragment.this.jHV.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").ag("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ag("obj_type", i10));
                                                                if (PbFragment.this.jHV.getPbData().jFb != null && PbFragment.this.jHV.getPbData().jFb.size() > i9) {
                                                                    i9 = PbFragment.this.jHV.getPbData().jFb.get(i9).sort_type.intValue();
                                                                }
                                                                boolean As = PbFragment.this.jHV.As(i9);
                                                                view.setTag(Integer.valueOf(PbFragment.this.jHV.cGc()));
                                                                if (As) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.jLF.rO(true);
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
                                                PbFragment.this.jLF.cIk();
                                                if (PbFragment.this.cDO().getPbData().jFc != 2) {
                                                    if (PbFragment.this.jHV.getPageData() != null) {
                                                        PbFragment.this.jLF.a(PbFragment.this.jHV.getPageData(), PbFragment.this.juY);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.jHV.getPbData()) != null) {
                                            bk cCy = pbData.cCy();
                                            if (cCy != null && cCy.aQx() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", PbFragment.this.jHV.jOs).dh("fid", pbData.getForumId()).ag("obj_locate", 4).dh("uid", cCy.aQx().getUserId()));
                                            }
                                            int i9 = 1;
                                            if (cCy != null) {
                                                if (cCy.aPm()) {
                                                    i9 = 2;
                                                } else if (cCy.aPn()) {
                                                    i9 = 3;
                                                } else if (cCy.aSv()) {
                                                    i9 = 4;
                                                } else if (cCy.aSw()) {
                                                    i9 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.dh("tid", PbFragment.this.jHV.cFJ());
                                            anVar7.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.dh("fid", PbFragment.this.jHV.getForumId());
                                            if (view.getId() == R.id.share_num_container) {
                                                anVar7.ag("obj_locate", 5);
                                            } else {
                                                anVar7.ag("obj_locate", 6);
                                            }
                                            anVar7.ag("obj_name", i9);
                                            anVar7.ag("obj_type", 1);
                                            if (cCy != null) {
                                                if (cCy.aPm()) {
                                                    anVar7.ag("obj_type", 10);
                                                } else if (cCy.aPn()) {
                                                    anVar7.ag("obj_type", 9);
                                                } else if (cCy.aSw()) {
                                                    anVar7.ag("obj_type", 8);
                                                } else if (cCy.aSv()) {
                                                    anVar7.ag("obj_type", 7);
                                                } else if (cCy.isShareThread) {
                                                    anVar7.ag("obj_type", 6);
                                                } else if (cCy.threadType == 0) {
                                                    anVar7.ag("obj_type", 1);
                                                } else if (cCy.threadType == 40) {
                                                    anVar7.ag("obj_type", 2);
                                                } else if (cCy.threadType == 49) {
                                                    anVar7.ag("obj_type", 3);
                                                } else if (cCy.threadType == 54) {
                                                    anVar7.ag("obj_type", 4);
                                                } else {
                                                    anVar7.ag("obj_type", 5);
                                                }
                                                anVar7.ag(IntentConfig.CARD_TYPE, cCy.aSA());
                                                anVar7.dh(IntentConfig.RECOM_SOURCE, cCy.mRecomSource);
                                                anVar7.dh("ab_tag", cCy.mRecomAbTag);
                                                anVar7.dh("weight", cCy.mRecomWeight);
                                                anVar7.dh("extra", cCy.mRecomExtra);
                                                anVar7.dh("nid", cCy.getNid());
                                                if (cCy.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.aq.isEmpty(cCy.getBaijiahaoData().oriUgcVid)) {
                                                    anVar7.dh("obj_param6", cCy.getBaijiahaoData().oriUgcVid);
                                                }
                                            }
                                            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                anVar7.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                            }
                                            if (PbFragment.this.cFs() != null) {
                                                com.baidu.tbadk.pageInfo.c.b(PbFragment.this.cFs(), anVar7);
                                            }
                                            TiebaStatic.log(anVar7);
                                            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                PbFragment.this.showToast(R.string.neterror);
                                                return;
                                            } else if (pbData != null) {
                                                ArrayList<PostData> cCA2 = PbFragment.this.jHV.getPbData().cCA();
                                                if ((cCA2 != null && cCA2.size() > 0) || !PbFragment.this.jHV.cFL()) {
                                                    PbFragment.this.jLF.cIk();
                                                    PbFragment.this.bVp();
                                                    if (pbData.cCT() != null && !StringUtils.isNull(pbData.cCT().aOP(), true)) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").dh("fid", PbFragment.this.jHV.getPbData().getForumId()));
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                    if (!AntiHelper.d(PbFragment.this.getContext(), cCy)) {
                                                        if (PbFragment.this.jLF != null) {
                                                            PbFragment.this.jLF.cIn();
                                                            PbFragment.this.jLF.w(pbData);
                                                        }
                                                        int i10 = 6;
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.jLF.showLoadingDialog();
                                                            PbFragment.this.jHV.cGo().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                        } else {
                                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                                i10 = 2;
                                                            } else if (view.getId() == R.id.share_num_container) {
                                                                i10 = 1;
                                                            }
                                                            PbFragment.this.Aj(i10);
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
                                        PbFragment.this.jLF.cIk();
                                        if (PbFragment.this.jLF.jSj.cJp() != null && view == PbFragment.this.jLF.jSj.cJp().cGT() && !PbFragment.this.jLF.cID()) {
                                            PbFragment.this.jLF.cHw();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bVp();
                                            PbFragment.this.jLF.cHR();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                w = PbFragment.this.jHV.w(true, PbFragment.this.cFb());
                                            } else {
                                                w = view.getId() == R.id.reply_title ? PbFragment.this.jHV.w(false, PbFragment.this.cFb()) : PbFragment.this.jHV.Jr(PbFragment.this.cFb());
                                            }
                                            view.setTag(Boolean.valueOf(w));
                                            if (w) {
                                                PbFragment.this.jLF.rn(true);
                                                PbFragment.this.jLF.cnR();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.jLF.rO(true);
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
                                    PbFragment.this.jLF.cIk();
                                    if (PbFragment.this.Ai(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.jHV.At(PbFragment.this.jLF.cHW()) != null) {
                                        PbFragment.this.cEW();
                                        if (PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().cCy() != null && PbFragment.this.jHV.getPbData().cCy().aQx() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", PbFragment.this.jHV.jOs).dh("fid", PbFragment.this.jHV.getPbData().getForumId()).ag("obj_locate", 3).dh("uid", PbFragment.this.jHV.getPbData().cCy().aQx().getUserId()));
                                        }
                                        if (PbFragment.this.jHV.getPbData().cCy() != null && PbFragment.this.jHV.getPbData().cCy().aQx() != null && PbFragment.this.jHV.getPbData().cCy().aQx().getUserId() != null && PbFragment.this.jLD != null) {
                                            int h = PbFragment.this.h(PbFragment.this.jHV.getPbData());
                                            bk cCy2 = PbFragment.this.jHV.getPbData().cCy();
                                            int i11 = 1;
                                            if (cCy2.aPm()) {
                                                i11 = 2;
                                            } else if (cCy2.aPn()) {
                                                i11 = 3;
                                            } else if (cCy2.aSv()) {
                                                i11 = 4;
                                            } else if (cCy2.aSw()) {
                                                i11 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").dh("tid", PbFragment.this.jHV.jOs).ag("obj_locate", 1).dh("obj_id", PbFragment.this.jHV.getPbData().cCy().aQx().getUserId()).ag("obj_type", PbFragment.this.jLD.aML() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i11));
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
                                if (PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().cCy() != null && PbFragment.this.jHV.getPbData().cCy().aPk() && PbFragment.this.jHV.getPbData().cCy().aQQ() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.jHV.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.jHV.cDF()) || PbFragment.this.jHV.getAppealInfo() == null) {
                                        PbFragment.this.jLc.finish();
                                        return;
                                    }
                                    name = PbFragment.this.jHV.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.jHV.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.jLc.finish();
                                    return;
                                }
                                String cDF = PbFragment.this.jHV.cDF();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.jHV.cFM() && cDF != null && cDF.equals(name)) {
                                    PbFragment.this.jLc.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.jHV.getPbData() != null) {
                                if ((PbFragment.this.jHV.getPbData().cCN() == 1 || PbFragment.this.jHV.getPbData().cCN() == 3) && !PbFragment.this.gFg.dez()) {
                                    PbFragment.this.jLF.cIk();
                                    int i12 = 0;
                                    if (PbFragment.this.jLF.jSj.cJp() == null || view != PbFragment.this.jLF.jSj.cJp().cGU()) {
                                        if (PbFragment.this.jLF.jSj.cJp() == null || view != PbFragment.this.jLF.jSj.cJp().cGW()) {
                                            if (view == PbFragment.this.jLF.cHP()) {
                                                i12 = 2;
                                            }
                                        } else if (PbFragment.this.jHV.getPbData().cCy().aQt() == 1) {
                                            i12 = 3;
                                        } else {
                                            i12 = 6;
                                        }
                                    } else if (PbFragment.this.jHV.getPbData().cCy().aQs() == 1) {
                                        i12 = 5;
                                    } else {
                                        i12 = 4;
                                    }
                                    ForumData forum = PbFragment.this.jHV.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.jHV.getPbData().cCy().getId();
                                    PbFragment.this.jLF.cHO();
                                    PbFragment.this.gFg.b(id4, name2, id5, i12, PbFragment.this.jLF.cHQ());
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
                        PbFragment.this.jLF.cIk();
                        PbFragment.this.bVp();
                        PbFragment.this.jLF.cHR();
                        PbFragment.this.jLF.showLoadingDialog();
                        if (PbFragment.this.jLF.cHE() != null) {
                            PbFragment.this.jLF.cHE().setVisibility(8);
                        }
                        PbFragment.this.jHV.An(1);
                        if (PbFragment.this.jLe != null) {
                            PbFragment.this.jLe.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cEL = PbFragment.this.cEL();
                        if (!TextUtils.isEmpty(cEL)) {
                            com.baidu.tbadk.core.util.ba.aVa().b(PbFragment.this.getPageContext(), new String[]{cEL});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.dh("tid", PbFragment.this.jHV.cFJ());
                anVar8.dh("fid", PbFragment.this.jHV.getForumId());
                anVar8.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.ag("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.jLn) {
                    PbFragment.this.jLn = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.cEE().cHt() != null && postData5.aQx() != null && postData5.ddJ() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cEE().cHu() != null) {
                                PbFragment.this.cEE().cHu().cEu();
                            }
                            com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                            nVar2.a(PbFragment.this.jHV.getPbData().getForum());
                            nVar2.setThreadData(PbFragment.this.jHV.getPbData().cCy());
                            nVar2.g(postData5);
                            PbFragment.this.cEE().cHt().d(nVar2);
                            PbFragment.this.cEE().cHt().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.aQx().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.jHV.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.jLS != null) {
                                PbFragment.this.jLF.rY(PbFragment.this.jLS.bdD());
                            }
                        }
                    }
                }
            }
        }
    };
    public SortSwitchButton.a jMC = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean uv(int i) {
            PbFragment.this.jLF.cIk();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.jHV == null || PbFragment.this.jHV.isLoading) {
                    return false;
                }
                PbFragment.this.bVp();
                PbFragment.this.jLF.cHR();
                if (PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().jFb != null && PbFragment.this.jHV.getPbData().jFb.size() > i) {
                    int intValue = PbFragment.this.jHV.getPbData().jFb.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13699").dh("tid", PbFragment.this.jHV.cFK()).dh("fid", PbFragment.this.jHV.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", Ak(intValue)));
                    if (PbFragment.this.jHV.As(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.jLF.rO(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int Ak(int i) {
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
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ab abVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.jHV.getPbData() != null) {
                    anVar.dh("fid", PbFragment.this.jHV.getPbData().getForumId());
                }
                anVar.dh("tid", PbFragment.this.jHV.cFJ());
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bVp();
            PbFragment.this.jLF.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.cDO() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.cDO().Ju(postWriteCallBackData.getPostId());
                    PbFragment.this.jMf = PbFragment.this.jLF.cHA();
                    PbFragment.this.jHV.cD(PbFragment.this.jMf, PbFragment.this.jLF.cHB());
                }
                PbFragment.this.jLF.cIk();
                PbFragment.this.jLJ.cII();
                if (PbFragment.this.jLS != null) {
                    PbFragment.this.jLF.rY(PbFragment.this.jLS.bdD());
                }
                PbFragment.this.jLF.cHs();
                PbFragment.this.jLF.sa(true);
                PbFragment.this.jHV.cGe();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.jHV.getHostMode()) {
                            com.baidu.tieba.pb.data.e pbData = PbFragment.this.jHV.getPbData();
                            if (pbData != null && pbData.cCy() != null && pbData.cCy().aQx() != null && (userId = pbData.cCy().aQx().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.jHV.cFV()) {
                                PbFragment.this.jLF.cHR();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.jHV.cFV()) {
                            PbFragment.this.jLF.cHR();
                        }
                    } else if (floor != null) {
                        PbFragment.this.jLF.r(PbFragment.this.jHV.getPbData());
                    }
                    if (PbFragment.this.jHV.cFP()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").dh("tid", PbFragment.this.jHV.cFJ()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.rt(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.jLS.bdK() || PbFragment.this.jLS.bdL()) {
                    PbFragment.this.jLS.a(false, postWriteCallBackData);
                }
                PbFragment.this.jLJ.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.iQC != null) {
                    PbFragment.this.iQC.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (abVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d jMD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ab abVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                    anVar.dh("fid", PbFragment.this.jHV.getPbData().getForumId());
                }
                if (PbFragment.this.jHV != null) {
                    anVar.dh("tid", PbFragment.this.jHV.cFJ());
                }
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.jLJ != null) {
                    PbFragment.this.jLJ.cIH();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.iQC != null) {
                    PbFragment.this.iQC.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.jLJ != null) {
                if (PbFragment.this.jLF != null && PbFragment.this.jLF.cHu() != null && PbFragment.this.jLF.cHu().cEy() != null && PbFragment.this.jLF.cHu().cEy().bdL()) {
                    PbFragment.this.jLF.cHu().cEy().a(postWriteCallBackData);
                }
                PbFragment.this.jLJ.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jME = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cIG;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.jLc.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.jLF != null && (cIG = PbFragment.this.jLF.cIG()) != null && PbFragment.this.jLF.getListView() != null) {
                            PbFragment.this.jLF.getListView().removeHeaderView(cIG);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a jMF = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g ne;
            if (!z || eVar == null || eVar.cCL() != null || com.baidu.tbadk.core.util.v.getCount(eVar.cCA()) >= 1) {
                PbFragment.this.jjV = true;
                PbFragment.this.jLF.cHT();
                if (eVar == null || !eVar.cCG()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.jLF.getView());
                }
                PbFragment.this.jLF.cnQ();
                if (PbFragment.this.isFullScreen || PbFragment.this.jLF.cID()) {
                    PbFragment.this.jLF.cIu();
                } else if (!PbFragment.this.jLF.cIr()) {
                    PbFragment.this.jLF.sa(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.eSR = true;
                }
                if (eVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.jLF.getView());
                    PbFragment.this.jLF.cIc();
                }
                if (z && eVar != null) {
                    bk cCy = eVar.cCy();
                    if (cCy == null || !cCy.aSx()) {
                        PbFragment.this.d(PbFragment.this.jLR);
                    } else {
                        cFu();
                    }
                    PbFragment.this.jLF.cHu().setPbData(eVar);
                    PbFragment.this.jLF.bvO();
                    if (cCy != null && cCy.aRJ() != null) {
                        PbFragment.this.a(cCy.aRJ());
                    }
                    if (PbFragment.this.jLS != null) {
                        PbFragment.this.jLF.rY(PbFragment.this.jLS.bdD());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                    if (eVar.cCA() != null && eVar.cCA().size() >= 1 && eVar.cCA().get(0) != null) {
                        PbFragment.this.jHV.Jt(eVar.cCA().get(0).getId());
                    } else if (eVar.cCL() != null) {
                        PbFragment.this.jHV.Jt(eVar.cCL().getId());
                    }
                    if (PbFragment.this.jLS != null) {
                        PbFragment.this.jLS.a(eVar.getAnti());
                        PbFragment.this.jLS.a(eVar.getForum(), eVar.getUserData());
                        PbFragment.this.jLS.setThreadData(cCy);
                        PbFragment.this.jLS.a(PbFragment.this.jHV.cFZ(), PbFragment.this.jHV.cFJ(), PbFragment.this.jHV.cGq());
                        if (cCy != null) {
                            PbFragment.this.jLS.id(cCy.aRV());
                        }
                    }
                    if (PbFragment.this.jLD != null) {
                        PbFragment.this.jLD.gC(eVar.aML());
                    }
                    if (eVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (eVar.cCZ()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.jLF.rZ(PbFragment.this.mIsFromCDN);
                    PbFragment.this.jLF.a(eVar, i2, i3, PbFragment.this.jHV.cFL(), i4, PbFragment.this.jHV.getIsFromMark());
                    PbFragment.this.jLF.d(eVar, PbFragment.this.jHV.cFL());
                    PbFragment.this.jLF.rW(PbFragment.this.jHV.getHostMode());
                    AntiData anti = eVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.emL = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.emL) && PbFragment.this.jLS != null && PbFragment.this.jLS.bcX() != null && (ne = PbFragment.this.jLS.bcX().ne(6)) != null && !TextUtils.isEmpty(PbFragment.this.emL)) {
                            ((View) ne).setOnClickListener(PbFragment.this.eny);
                        }
                    }
                    if (PbFragment.this.jLN) {
                        PbFragment.this.jLN = false;
                        final int cES = PbFragment.this.cES();
                        if (!eVar.aWj()) {
                            PbFragment.this.jLF.AA(cES);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cES, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.jLO) {
                        PbFragment.this.jLO = false;
                        final int cES2 = PbFragment.this.cES();
                        final boolean z2 = cES2 != -1;
                        if (!z2) {
                            cES2 = PbFragment.this.cET();
                        }
                        if (PbFragment.this.jLF != null) {
                            if (!eVar.aWj()) {
                                PbFragment.this.jLF.AA(cES2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cES2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.jLF.setSelectionFromTop(cES2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.jLF.setSelectionFromTop(cES2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.jLF.sb(true);
                                PbFragment.this.jLF.sa(false);
                            }
                        }
                    } else if (PbFragment.this.jLP) {
                        PbFragment.this.jLP = false;
                        PbFragment.this.jLF.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.jLF.cHX();
                    }
                    PbFragment.this.jHV.a(eVar.getForum(), PbFragment.this.jMs);
                    PbFragment.this.jHV.a(PbFragment.this.jMt);
                    if (PbFragment.this.iQC != null && cCy != null && cCy.aQx() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cCy.aQx());
                        PbFragment.this.iQC.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.eSR && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.jHV.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.jHV.getAppealInfo().jEU)) {
                                    PbFragment.this.jLF.a(PbFragment.this.jHV.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.jLF.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.jLF.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.jLF.cIu();
                            PbFragment.this.jLF.cIb();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.jHV.cFJ());
                            jSONObject.put("fid", PbFragment.this.jHV.getForumId());
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
                        PbFragment.this.jLF.Jz("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                            arrayList = PbFragment.this.jHV.getPbData().cCA();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).ddJ() != 1)) {
                            PbFragment.this.jLF.Jz(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.cFm()) {
                                PbFragment.this.jLF.JA(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.jLF.JA(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.jLF.r(PbFragment.this.jHV.getPbData());
                        }
                    }
                    PbFragment.this.jLF.endLoadData();
                }
                if (eVar != null && eVar.jFi && PbFragment.this.esg == 0) {
                    PbFragment.this.esg = System.currentTimeMillis() - PbFragment.this.gPV;
                }
                if (!PbFragment.this.cDO().cFL() || PbFragment.this.cDO().getPbData().getPage().aPu() != 0 || PbFragment.this.cDO().cGl()) {
                    PbFragment.this.jLT = true;
                    return;
                }
                return;
            }
            PbFragment.this.jHV.An(1);
            if (PbFragment.this.jLe != null) {
                PbFragment.this.jLe.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cFu() {
            if (PbFragment.this.jHV != null) {
                if (PbFragment.this.jLS == null || !PbFragment.this.jLS.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.jLS = (com.baidu.tbadk.editortools.pb.e) dVar.dN(PbFragment.this.getContext());
                    PbFragment.this.jLS.a(PbFragment.this.jLc.getPageContext());
                    PbFragment.this.jLS.a(PbFragment.this.emV);
                    PbFragment.this.jLS.a(PbFragment.this.emO);
                    PbFragment.this.jLS.a(PbFragment.this.jLc.getPageContext(), PbFragment.this.jLc.getIntent() == null ? null : PbFragment.this.jLc.getIntent().getExtras());
                    PbFragment.this.jLS.bcX().hW(true);
                    PbFragment.this.jLF.setEditorTools(PbFragment.this.jLS.bcX());
                    if (!PbFragment.this.jHV.cFQ()) {
                        PbFragment.this.jLS.yj(PbFragment.this.jHV.cFJ());
                    }
                    if (PbFragment.this.jHV.cGr()) {
                        PbFragment.this.jLS.yh(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.jLF != null) {
                        PbFragment.this.jLS.yh(PbFragment.this.jLF.cHy());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
            PbFragment.this.jLF.r(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.bfJ().bfK()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.gPV : j;
                if (PbFragment.this.esg == 0) {
                    PbFragment.this.esg = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.erW, PbFragment.this.createTime, PbFragment.this.esg, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.erW = 0L;
                if (iVar != null) {
                    iVar.bfG();
                }
                if (z2) {
                    iVar.esp = currentTimeMillis;
                    iVar.io(true);
                }
                if (!z2 && PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().cCy() != null) {
                    int threadType = PbFragment.this.jHV.getPbData().cCy().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.jLq, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.jLq, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.esr = currentTimeMillis;
                                iVar2.nC(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.esr = currentTimeMillis;
                        dVar.nC(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener jMG = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cEO();
            }
        }
    };
    private final a.InterfaceC0471a jMH = new a.InterfaceC0471a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0471a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.jLF.cHT();
            if (z) {
                if (PbFragment.this.jLD != null) {
                    PbFragment.this.jLD.gC(z2);
                }
                PbFragment.this.jHV.rG(z2);
                if (PbFragment.this.jHV.aML()) {
                    PbFragment.this.cEX();
                } else {
                    PbFragment.this.jLF.r(PbFragment.this.jHV.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.jLD != null) {
                        if (PbFragment.this.jLD.aMO() != null && PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.jHV.getPbData().cCy() != null && PbFragment.this.jHV.getPbData().cCy().aQx() != null) {
                            MarkData aMO = PbFragment.this.jLD.aMO();
                            MetaData aQx = PbFragment.this.jHV.getPbData().cCy().aQx();
                            if (aMO != null && aQx != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aQx.getUserId()) && !aQx.hadConcerned()) {
                                    PbFragment.this.b(aQx);
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
                    PbFragment.this.cEU();
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
            if (!PbFragment.this.zZ(PbFragment.this.mLastScrollState) && PbFragment.this.zZ(i)) {
                if (PbFragment.this.jLF != null) {
                    PbFragment.this.jLF.cIk();
                    if (PbFragment.this.jLS != null && !PbFragment.this.jLF.cHx()) {
                        PbFragment.this.jLF.rY(PbFragment.this.jLS.bdD());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.jLF.cHw();
                    }
                }
                if (!PbFragment.this.jLk) {
                    PbFragment.this.jLk = true;
                    if (PbFragment.this.jLF != null) {
                        PbFragment.this.jLF.cIq();
                    }
                }
            }
            if (PbFragment.this.jLF != null) {
                PbFragment.this.jLF.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.jLe != null) {
                PbFragment.this.jLe.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.jLl == null) {
                PbFragment.this.jLl = new com.baidu.tbadk.n.b();
                PbFragment.this.jLl.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.jLl.bfA();
            } else {
                PbFragment.this.jLl.bfz();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dcI().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cCA;
            if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null && PbFragment.this.jLF != null && PbFragment.this.jLF.cHN() != null) {
                PbFragment.this.jLF.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.jLe != null) {
                    PbFragment.this.jLe.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.jHV.cGh() && (cCA = PbFragment.this.jHV.getPbData().cCA()) != null && !cCA.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.jLF.cHN().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.e pbData = PbFragment.this.jHV.getPbData();
                    if (pbData != null) {
                        if (pbData.cCB() != null && pbData.cCB().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cCC() != null && pbData.cCC().hasData()) {
                            headerCount--;
                        }
                        int size = cCA.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d gFl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.gFg.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.jHV.cGe();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.kaw != 1002 || bVar.fEQ) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.jLF.a(1, dVar.OU, dVar.loP, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.gFg.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.jLF.a(PbFragment.this.gFg.getLoadDataMode(), gVar.OU, gVar.loP, false);
                            PbFragment.this.jLF.aP(gVar.loS);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.jLF.a(PbFragment.this.gFg.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c jMI = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
    };
    private final f.c eQH = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cFc()) {
                PbFragment.this.jLc.finish();
            }
            if (!PbFragment.this.jHV.rF(true)) {
                PbFragment.this.jLF.cHU();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e jMK = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.jMJ && PbFragment.this.cFc()) {
                PbFragment.this.cFe();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.jHV.rE(false)) {
                    PbFragment.this.jLF.cHS();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.jHV.getPbData() != null) {
                    PbFragment.this.jLF.cIp();
                }
                PbFragment.this.jMJ = true;
            }
        }
    };
    private int jML = 0;
    private final TbRichTextView.i eBN = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g cHN;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.jLF.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.dh("tid", PbFragment.this.jHV.cFJ());
                anVar.dh("fid", PbFragment.this.jHV.getForumId());
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.ag("obj_locate", 3);
                anVar.ag("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.jHV.jIU.cCZ()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bit() != null) {
                            ArrayList<TbRichTextImageInfo> bit = tbRichTextView.getRichText().bit();
                            int i4 = 0;
                            while (i4 < bit.size()) {
                                if (bit.get(i4) != null) {
                                    arrayList.add(bit.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bit.get(i4).getSrc()) || str.equals(bit.get(i4).biL()) || str.equals(bit.get(i4).biI()) || str.equals(bit.get(i4).biK()) || str.equals(bit.get(i4).biO()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bit.get(i4).getSrc();
                                    imageUrlData.originalUrl = bit.get(i4).getSrc();
                                    imageUrlData.isLongPic = bit.get(i4).biQ();
                                    concurrentHashMap.put(bit.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.jHV.cGb(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.jHV.getPbData().cCy());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.jIg) {
                        TbRichText bu = PbFragment.this.bu(str, i);
                        if (bu != null && PbFragment.this.jML >= 0 && PbFragment.this.jML < bu.bis().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.f.b(bu.bis().get(PbFragment.this.jML));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.jId.size()) {
                                    break;
                                } else if (!aVar.jId.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bu.getPostId() != 0 && (cHN = PbFragment.this.jLF.cHN()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.o> dataList = cHN.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.o> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.o next = it.next();
                                        if ((next instanceof PostData) && bu.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bu.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.jHV.cGq(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.jHV.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.jIe.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jIf, aVar.lastId, PbFragment.this.jHV.cGb(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.jHV.getPbData().cCy());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.jId, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.jIe.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jIf, aVar.jId.get(0), PbFragment.this.jHV.cGb(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.jHV.getPbData().cCy());
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
                PbFragment.this.jLu = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean jMM = false;
    PostData iiy = null;
    private final b.a jMN = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iiy != null) {
                if (i == 0) {
                    PbFragment.this.iiy.fp(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.iiy = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.iiy);
                }
            }
        }
    };
    private final b.a jMO = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jMc != null && !TextUtils.isEmpty(PbFragment.this.jMd)) {
                if (i == 0) {
                    if (PbFragment.this.jMe == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.jMd));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.jMd;
                        aVar.pkgId = PbFragment.this.jMe.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.jMe.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.hRB == null) {
                            PbFragment.this.hRB = new az(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.hRB.j(PbFragment.this.jMd, PbFragment.this.jMc.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.jMc = null;
                PbFragment.this.jMd = null;
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
                if (PbFragment.this.cD(view)) {
                    if (view instanceof TbImageView) {
                        PbFragment.this.jMc = ((TbImageView) view).getBdImage();
                        PbFragment.this.jMd = ((TbImageView) view).getUrl();
                        if (PbFragment.this.jMc == null || TextUtils.isEmpty(PbFragment.this.jMd)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.jMe = null;
                        } else {
                            PbFragment.this.jMe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.jMc = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.jMd = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.jMe = null;
                            } else {
                                PbFragment.this.jMe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.jMc = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.jMd = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.jMe = null;
                        } else {
                            PbFragment.this.jMe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.jLF.a(PbFragment.this.jMO, PbFragment.this.jMc.isGif());
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
            PbFragment.this.iiy = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.iiy == null) {
                return true;
            }
            if (PbFragment.this.iiy.ddJ() != 1 || !PbFragment.this.cD(view)) {
                if (PbFragment.this.jLD != null) {
                    if (!PbFragment.this.jLD.aML() || PbFragment.this.iiy.getId() == null || !PbFragment.this.iiy.getId().equals(PbFragment.this.jHV.aQG())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.cDO().getPbData() != null && PbFragment.this.cDO().getPbData().cCZ();
                    if (PbFragment.this.iiy.ddJ() != 1) {
                        if (PbFragment.this.jLL == null) {
                            PbFragment.this.jLL = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.jLL.a(PbFragment.this.jMP);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = PbFragment.this.cD(view) && !z3;
                            boolean z5 = (!PbFragment.this.cD(view) || PbFragment.this.jMc == null || PbFragment.this.jMc.isGif()) ? false : true;
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
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.jLL));
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.jLL));
                            }
                            if (!z4 && !z5) {
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.jLL);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.iiy);
                                gVar3.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar3);
                            }
                            if (!z2 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.jLL);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.jLL);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.iiy);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z8 && z7) {
                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.jLL);
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
                                    if ((PbFragment.this.ru(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.jLL);
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
                                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jLL);
                                        gVar6.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.jLL);
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
                                        if (PbFragment.this.jHV.getPbData().cCN() == 1002 && !z6) {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.jLL);
                                        } else {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jLL);
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
                            PbFragment.this.jLL.aD(arrayList);
                            PbFragment.this.jLK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jLL);
                            PbFragment.this.jLK.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").dh("tid", PbFragment.this.jHV.jOs).dh("fid", PbFragment.this.jHV.getForumId()).dh("uid", PbFragment.this.jHV.getPbData().cCy().aQx().getUserId()).dh("post_id", PbFragment.this.jHV.bds()).ag("obj_source", z2 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.jLF.a(PbFragment.this.jMN, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.jLF.a(PbFragment.this.jMO, PbFragment.this.jMc.isGif());
            return true;
        }
    };
    private k.c jMP = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            int i2;
            if (PbFragment.this.jLK != null) {
                PbFragment.this.jLK.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.jMc != null && !TextUtils.isEmpty(PbFragment.this.jMd)) {
                        if (PbFragment.this.jMe == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.jMd));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.jMd;
                            aVar.pkgId = PbFragment.this.jMe.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.jMe.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.jMc = null;
                        PbFragment.this.jMd = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.jMc != null && !TextUtils.isEmpty(PbFragment.this.jMd)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.hRB == null) {
                                PbFragment.this.hRB = new az(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.hRB.j(PbFragment.this.jMd, PbFragment.this.jMc.getImageByte());
                            PbFragment.this.jMc = null;
                            PbFragment.this.jMd = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.iiy != null) {
                        PbFragment.this.iiy.fp(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.iiy = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").ag("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cC(view);
                        if (PbFragment.this.jHV.getPbData().cCy() != null && PbFragment.this.jHV.getPbData().cCy().aQx() != null && PbFragment.this.jHV.getPbData().cCy().aQx().getUserId() != null && PbFragment.this.jLD != null) {
                            int h = PbFragment.this.h(PbFragment.this.jHV.getPbData());
                            bk cCy = PbFragment.this.jHV.getPbData().cCy();
                            if (cCy.aPm()) {
                                i2 = 2;
                            } else if (cCy.aPn()) {
                                i2 = 3;
                            } else if (cCy.aSv()) {
                                i2 = 4;
                            } else {
                                i2 = cCy.aSw() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").dh("tid", PbFragment.this.jHV.jOs).ag("obj_locate", 2).dh("obj_id", PbFragment.this.jHV.getPbData().cCy().aQx().getUserId()).ag("obj_type", PbFragment.this.jLD.aML() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
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
                        PbFragment.this.Jm((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").ag("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.c(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.jLF.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                PbFragment.this.c(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.jLF.cI(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.jLF.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a hkP = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.beu && z && !PbFragment.this.jHV.cFR()) {
                PbFragment.this.cEZ();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.hrv.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0607a gMe = new a.InterfaceC0607a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        final int fEu = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            if (ad(i2) && PbFragment.this.jLF != null && PbFragment.this.jLe != null) {
                PbFragment.this.jLe.nf(true);
                if (Math.abs(i2) > this.fEu) {
                    PbFragment.this.jLe.hideFloatingView();
                }
                if (PbFragment.this.cFc()) {
                    PbFragment.this.jLF.cHK();
                    PbFragment.this.jLF.cHL();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            if (ad(i2) && PbFragment.this.jLF != null && PbFragment.this.jLe != null) {
                PbFragment.this.jLF.cIv();
                PbFragment.this.jLe.nf(false);
                PbFragment.this.jLe.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final o.a jKj = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void n(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.jLF.JB(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int jMR = -1;
    private int jMS = -1;

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

    public com.baidu.tbadk.editortools.pb.e cEz() {
        return this.jLS;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        MetaData metaData;
        boolean z = true;
        if (nVar.cDs() != null) {
            String id = nVar.cDs().getId();
            ArrayList<PostData> cCA = this.jHV.getPbData().cCA();
            int i = 0;
            while (true) {
                if (i >= cCA.size()) {
                    break;
                }
                PostData postData = cCA.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cDw = nVar.cDw();
                    postData.DT(nVar.getTotalCount());
                    if (postData.ddG() != null && cDw != null) {
                        Iterator<PostData> it = cDw.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aQx() != null && (metaData = postData.getUserMap().get(next.aQx().getUserId())) != null) {
                                next.a(metaData);
                                next.uu(true);
                                next.a(getPageContext(), this.jHV.Js(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cDw.size() != postData.ddG().size();
                        postData.ddG().clear();
                        postData.ddG().addAll(cDw);
                        z = z2;
                    }
                    if (postData.ddC() != null) {
                        postData.ddD();
                    }
                }
            }
            if (!this.jHV.getIsFromMark() && z) {
                this.jLF.r(this.jHV.getPbData());
            }
            if (z) {
                c(nVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n cCQ = this.jHV.getPbData().cCQ();
            if (cCQ != null && str.equals(cCQ.getAdId())) {
                if (cCQ.ddx() != null) {
                    cCQ.ddx().legoCard = null;
                }
                this.jHV.getPbData().cCR();
            }
            com.baidu.tieba.tbadkCore.data.n cFX = this.jHV.cFX();
            if (cFX != null && str.equals(cFX.getAdId())) {
                this.jHV.cFY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.jLK != null && this.jLK.isShowing()) {
                this.jLK.dismiss();
                this.jLK = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.jLK != null) {
                            PbFragment.this.jLK.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.jLF.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.jMa);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.jMa);
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
                kVar.aD(arrayList);
                this.jLK = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.jLK.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        bk cCy;
        if (this.jHV != null && this.jHV.getPbData() != null && (cCy = this.jHV.getPbData().cCy()) != null) {
            if (i == 1) {
                PraiseData aQi = cCy.aQi();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aQi == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cCy.a(praiseData);
                    } else {
                        cCy.aQi().getUser().add(0, metaData);
                        cCy.aQi().setNum(cCy.aQi().getNum() + 1);
                        cCy.aQi().setIsLike(i);
                    }
                }
                if (cCy.aQi() != null) {
                    if (cCy.aQi().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(cCy.aQi().getNum());
                    }
                }
            } else if (cCy.aQi() != null) {
                cCy.aQi().setIsLike(i);
                cCy.aQi().setNum(cCy.aQi().getNum() - 1);
                ArrayList<MetaData> user = cCy.aQi().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cCy.aQi().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cCy.aQi().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cCy.aQi().getNum() + "";
                }
            }
            if (this.jHV.cFL()) {
                this.jLF.cHN().notifyDataSetChanged();
            } else {
                this.jLF.s(this.jHV.getPbData());
            }
        }
    }

    public static PbFragment cEA() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.jLc = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jHV.aA(bundle);
        if (this.hns != null) {
            this.hns.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.jLS.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.jLj = System.currentTimeMillis();
        this.jLY = getPageContext();
        final Intent intent = this.jLc.getIntent();
        if (intent != null) {
            this.gPV = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.jLq = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.jLq)) {
                    this.jLq = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.jLq)) {
                this.jLf = true;
            }
            this.jMR = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.jMS = intent.getIntExtra("key_manga_next_chapter", -1);
            this.jMT = intent.getStringExtra("key_manga_title");
            this.jLN = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.jLO = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.jLP = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cFc()) {
                this.jLc.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.jMg = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.jLz = new com.baidu.tbadk.core.data.ay();
            this.jLz.A(intent);
            this.jMi = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.jMi == 0) {
                this.jMi = intent.getIntExtra("key_start_from", 0);
            }
            this.jMj = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.gPV = System.currentTimeMillis();
        }
        this.erW = this.jLj - this.gPV;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.jLh = 0;
        az(bundle);
        if (this.jHV.getPbData() != null) {
            this.jHV.getPbData().Je(this.source);
        }
        cED();
        if (intent != null && this.jLF != null) {
            this.jLF.jSh = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.jMb == null) {
                    this.jMb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.jLF.JD(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(this.jMb, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.jHV.getPbData() != null) {
                this.jHV.Jv(stringExtra);
            }
        }
        this.hns = new VoiceManager();
        this.hns.onCreate(getPageContext());
        initData(bundle);
        this.jLR = new com.baidu.tbadk.editortools.pb.g();
        d(this.jLR);
        this.jLS = (com.baidu.tbadk.editortools.pb.e) this.jLR.dN(getActivity());
        this.jLS.a(this.jLc.getPageContext());
        this.jLS.a(this.emV);
        this.jLS.a(this.emO);
        this.jLS.a(this.jLc.getPageContext(), bundle);
        this.jLS.bcX().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.jLS.bcX().hW(true);
        rs(true);
        this.jLS.a(this.jHV.cFZ(), this.jHV.cFJ(), this.jHV.cGq());
        registerListener(this.jMo);
        if (!this.jHV.cFQ()) {
            this.jLS.yj(this.jHV.cFJ());
        }
        if (this.jHV.cGr()) {
            this.jLS.yh(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.jLF != null) {
            this.jLS.yh(this.jLF.cHy());
        }
        registerListener(this.jMn);
        registerListener(this.jMp);
        registerListener(this.jMq);
        registerListener(this.hoJ);
        registerListener(this.jMB);
        registerListener(this.jMm);
        this.jLQ = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.llr);
        this.jLQ.ddp();
        registerListener(this.jMr);
        registerListener(this.dNP);
        this.jHV.cGj();
        registerListener(this.jMG);
        registerListener(this.hoR);
        if (this.jLF != null && this.jLF.cIz() != null && this.jLF.cIA() != null) {
            this.jLe = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.jLF.cIz(), this.jLF.cIA(), this.jLF.cHE());
            this.jLe.a(this.jMw);
        }
        if (this.jLd && this.jLF != null && this.jLF.cIA() != null) {
            this.jLF.cIA().setVisibility(8);
        }
        this.jLZ = new com.baidu.tbadk.core.view.c();
        this.jLZ.toastTime = 1000L;
        registerListener(this.jMA);
        registerListener(this.jMy);
        registerListener(this.jMz);
        registerListener(this.hFL);
        registerListener(this.hoG);
        registerResponsedEventListener(TipEvent.class, this.hmy);
        this.jMa = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.jMa;
        userMuteAddAndDelCustomMessage.setTag(this.jMa);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.jMa;
        userMuteCheckCustomMessage.setTag(this.jMa);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.jHV.cGo().a(this.jMx);
        this.jLJ = new ax();
        if (this.jLS.bdw() != null) {
            this.jLJ.e(this.jLS.bdw().getInputView());
        }
        this.jLS.a(this.emP);
        this.hEF = new ShareSuccessReplyToServerModel();
        a(this.jMk);
        this.iQC = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.iQC.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
            @Override // com.baidu.tbadk.core.util.aj.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.dNG) {
                        PbFragment.this.jLS.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.dNH && PbFragment.this.jLF != null && PbFragment.this.jLF.cHu() != null && PbFragment.this.jLF.cHu().cEy() != null) {
                        PbFragment.this.jLF.cHu().cEy().bdS();
                    } else if (i == com.baidu.tbadk.core.util.aj.dNI) {
                        PbFragment.this.c(PbFragment.this.jLV);
                    }
                }
            }
        });
        this.jLC = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.jLC.w(getUniqueId());
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
        com.baidu.tbadk.core.business.a.aOc().cX("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.jLj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.jHV != null) {
            gVar.setForumName(this.jHV.cDF());
            if (this.jHV.getPbData() != null && this.jHV.getPbData().getForum() != null) {
                gVar.a(this.jHV.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.jHV);
        }
    }

    public String cEB() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cEC() {
        return this.jLe;
    }

    private void rs(boolean z) {
        this.jLS.ia(z);
        this.jLS.ib(z);
        this.jLS.ic(z);
    }

    private void cED() {
        this.dYI = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hns != null) {
            this.hns.onStart(getPageContext());
        }
    }

    public av cEE() {
        return this.jLF;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cDO() {
        return this.jHV;
    }

    public void Jl(String str) {
        if (this.jHV != null && !StringUtils.isNull(str) && this.jLF != null) {
            this.jLF.sd(true);
            this.jHV.Jl(str);
            this.jLp = true;
            this.jLF.cIk();
            this.jLF.cIu();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.beu = false;
        } else {
            this.beu = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.jLh = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.jLh == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.hns != null) {
            this.hns.onPause(getPageContext());
        }
        if (this.jLF != null) {
            this.jLF.onPause();
        }
        if (!this.jHV.cFQ()) {
            this.jLS.yi(this.jHV.cFJ());
        }
        if (this.jHV != null) {
            this.jHV.cGk();
        }
        com.baidu.tbadk.BdToken.c.aLi().aLn();
        MessageManager.getInstance().unRegisterListener(this.iuz);
        chw();
        MessageManager.getInstance().unRegisterListener(this.jMy);
        MessageManager.getInstance().unRegisterListener(this.jMz);
        MessageManager.getInstance().unRegisterListener(this.jMA);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cEF() {
        PostData a2 = com.baidu.tieba.pb.data.f.a(this.jHV.getPbData(), this.jHV.cFL(), this.jHV.cGi());
        return (a2 == null || a2.aQx() == null || a2.aQx().getGodUserData() == null || a2.aQx().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.beu = false;
        super.onResume();
        if (this.jLs) {
            this.jLs = false;
            cFi();
        }
        if (cEF()) {
            this.jLm = System.currentTimeMillis();
        } else {
            this.jLm = -1L;
        }
        if (this.jLF != null && this.jLF.getView() != null) {
            if (!this.jjV) {
                cFa();
            } else {
                hideLoadingView(this.jLF.getView());
            }
            this.jLF.onResume();
        }
        if (this.jLh == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.jLF != null) {
            noNetworkView = this.jLF.cHr();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.hns != null) {
            this.hns.onResume(getPageContext());
        }
        registerListener(this.iuz);
        this.jLM = false;
        cFh();
        registerListener(this.jMy);
        registerListener(this.jMz);
        registerListener(this.jMA);
        if (this.hoe) {
            cEZ();
            this.hoe = false;
        }
        cFo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.jLF.rS(z);
        if (this.jLK != null) {
            this.jLK.dismiss();
        }
        if (z && this.jLM) {
            this.jLF.cHS();
            this.jHV.rE(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.jLm > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").dh("obj_duration", (System.currentTimeMillis() - this.jLm) + ""));
            this.jLm = 0L;
        }
        if (cEE().cHu() != null) {
            cEE().cHu().onStop();
        }
        if (this.jLF.jSj != null && !this.jLF.jSj.cJr()) {
            this.jLF.jSj.releaseResources();
        }
        if (this.jHV != null && this.jHV.getPbData() != null && this.jHV.getPbData().getForum() != null && this.jHV.getPbData().cCy() != null) {
            com.baidu.tbadk.distribute.a.bcL().b(getPageContext().getPageActivity(), "pb", this.jHV.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jHV.getPbData().cCy().getId(), 0L));
        }
        if (this.hns != null) {
            this.hns.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        MessageManager.getInstance().unRegisterListener(this.jLA);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("fid", this.jHV.getPbData().getForumId());
            anVar.dh("tid", this.jHV.cFJ());
            anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.jLk && this.jLF != null) {
            this.jLk = true;
            this.jLF.cIq();
            a(false, (PostData) null);
        }
        if (this.jHV != null) {
            this.jHV.cancelLoadData();
            this.jHV.destory();
            if (this.jHV.cGn() != null) {
                this.jHV.cGn().onDestroy();
            }
        }
        if (this.jLS != null) {
            this.jLS.onDestroy();
        }
        if (this.gFg != null) {
            this.gFg.cancelLoadData();
        }
        if (this.dYI != null) {
            this.dYI.ddc();
        }
        if (this.jLF != null) {
            this.jLF.onDestroy();
            if (this.jLF.jSj != null) {
                this.jLF.jSj.releaseResources();
            }
        }
        if (this.jLl != null) {
            this.jLl.bfB();
        }
        if (this.jLe != null) {
            this.jLe.blf();
        }
        super.onDestroy();
        if (this.hns != null) {
            this.hns.onDestory(getPageContext());
        }
        if (this.jLF != null) {
            this.jLF.cIk();
        }
        MessageManager.getInstance().unRegisterListener(this.jMy);
        MessageManager.getInstance().unRegisterListener(this.jMz);
        MessageManager.getInstance().unRegisterListener(this.jMA);
        MessageManager.getInstance().unRegisterListener(this.jMa);
        MessageManager.getInstance().unRegisterListener(this.jMB);
        MessageManager.getInstance().unRegisterListener(this.hoR);
        MessageManager.getInstance().unRegisterListener(this.hFL);
        MessageManager.getInstance().unRegisterListener(this.jME);
        this.jLY = null;
        this.jLZ = null;
        com.baidu.tieba.recapp.d.a.cVp().cVr();
        if (this.jMb != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jMb);
        }
        if (this.jLt != null) {
            this.jLt.cancelLoadData();
        }
        if (this.jLF != null && this.jLF.jSj != null) {
            this.jLF.jSj.cJu();
        }
        if (this.hEF != null) {
            this.hEF.cancelLoadData();
        }
        this.jLJ.onDestroy();
        if (this.jHV != null && this.jHV.cGp() != null) {
            this.jHV.cGp().onDestroy();
        }
        if (this.iQC != null) {
            this.iQC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g cHN;
        ArrayList<PostData> cEk;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aXK() && this.jLF != null && (cHN = this.jLF.cHN()) != null && (cEk = cHN.cEk()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cEk.iterator();
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
                        bVar.gHb = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.dGg == 1 && !TextUtils.isEmpty(id)) {
                    next.dGg = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.gHb = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.jHV == null || this.jHV.getPbData() == null || this.jHV.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.jHV.getPbData().getForum().getFirst_class();
                    str2 = this.jHV.getPbData().getForum().getSecond_class();
                    str = this.jHV.getPbData().getForum().getId();
                    str4 = this.jHV.cFJ();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aXN());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.jLF.onChangeSkinType(i);
            if (this.jLS != null && this.jLS.bcX() != null) {
                this.jLS.bcX().onChangeSkinType(i);
            }
            if (this.jLF.cHr() != null) {
                this.jLF.cHr().onChangeSkinType(getPageContext(), i);
            }
            this.jLJ.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jLF = new av(this, this.hpF, this.efF);
        this.hrv = new com.baidu.tieba.f.b(getActivity());
        this.hrv.a(jMQ);
        this.hrv.a(this.gMe);
        this.jLF.setOnScrollListener(this.mOnScrollListener);
        this.jLF.d(this.jMK);
        this.jLF.setListPullRefreshListener(this.eQH);
        this.jLF.re(com.baidu.tbadk.core.k.aNQ().isShowImages());
        this.jLF.setOnImageClickListener(this.eBN);
        this.jLF.b(this.mOnLongClickListener);
        this.jLF.g(this.hkP);
        this.jLF.a(this.jMI);
        this.jLF.rS(this.mIsLogin);
        if (this.jLc.getIntent() != null) {
            this.jLF.se(this.jLc.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.jLF.cHt().setFromForumId(this.jHV.getFromForumId());
        this.jLF.setEditorTools(this.jLS.bcX());
        this.jLS.yh(this.jLF.cHy());
        this.jLF.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.jHV.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jHV.getPbData().getForum().getId(), PbFragment.this.jHV.getPbData().getForum().getName(), PbFragment.this.jHV.getPbData().cCy().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.jLF.getView();
    }

    public void cEG() {
        if (this.jLF != null && this.jHV != null) {
            if ((this.jHV.getPbData() != null || this.jHV.getPbData().cCW() != null) && checkUpIsLogin() && this.jLF.cHN() != null && this.jLF.cHN().cEp() != null) {
                this.jLF.cHN().cEp().wU(this.jHV.cFJ());
            }
        }
    }

    public void cEH() {
        TiebaStatic.log("c12181");
        if (this.jLF != null && this.jHV != null) {
            if ((this.jLF == null || this.jLF.cHx()) && this.jHV.getPbData() != null && this.jHV.getPbData().cCW() != null) {
                com.baidu.tieba.pb.data.m cCW = this.jHV.getPbData().cCW();
                if (checkUpIsLogin()) {
                    if ((!cCW.cDp() || cCW.aRZ() != 2) && this.jLF.cHN() != null && this.jLF.cHN().cEp() != null) {
                        this.jLF.cHN().cEp().wU(this.jHV.cFJ());
                    }
                    if (System.currentTimeMillis() - this.jLo > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).sL(false);
                        this.jLo = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cB(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.llT && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.aNQ().isShowImages()) {
                    return Jo(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.jHV == null || this.jHV.getPbData() == null) {
                        return true;
                    }
                    if (cEE().cHu() != null) {
                        cEE().cHu().cEu();
                    }
                    com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                    nVar.a(this.jHV.getPbData().getForum());
                    nVar.setThreadData(this.jHV.getPbData().cCy());
                    nVar.g(postData);
                    cEE().cHt().d(nVar);
                    cEE().cHt().setPostId(postData.getId());
                    b(view, postData.aQx().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.jLS != null) {
                        this.jLF.rY(this.jLS.bdD());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cEI() {
        if (this.jLi == null) {
            this.jLi = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.jLi.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.jHR = PbFragment.this.jHR.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jHR);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.jHV.cFJ(), PbFragment.this.jHR, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.jHR = PbFragment.this.jHR.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jHR);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.jHV.cFJ(), PbFragment.this.jHR, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.jHR = PbFragment.this.jHR.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jHR);
                        bVar.dismiss();
                    }
                }
            }).kK(R.style.dialog_ani_b2t).kL(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.jMF.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).cLr(), "", 1);
    }

    private void az(Bundle bundle) {
        this.jHV = this.jLc.cDO();
        if (this.jHV.cGm() != null) {
            this.jHV.cGm().a(this.jKj);
        }
        if (this.jHV.cGn() != null) {
            this.jHV.cGn().b(this.jMl);
        }
        if (StringUtils.isNull(this.jHV.cFJ())) {
            this.jLc.finish();
        } else if ("from_tieba_kuang".equals(this.jLq) && this.jLq != null) {
            this.jHV.Au(6);
        }
    }

    private void initData(Bundle bundle) {
        this.jLD = com.baidu.tbadk.baseEditMark.a.a(this.jLc);
        if (this.jLD != null) {
            this.jLD.a(this.jMH);
        }
        this.gFg = new ForumManageModel(this.jLc);
        this.gFg.setLoadDataCallBack(this.gFl);
        this.dNL = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.jMv.setUniqueId(getUniqueId());
        this.jMv.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jLF.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.jMa;
        userMuteCheckCustomMessage.setTag(this.jMa);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cEJ() {
        if (this.jHV == null || this.jHV.getPbData() == null) {
            return false;
        }
        bk cCy = this.jHV.getPbData().cCy();
        this.jHV.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cCy);
    }

    public void cEK() {
        if (checkUpIsLogin() && this.jHV != null && this.jHV.getPbData() != null && this.jHV.getPbData().getForum() != null && !cEJ()) {
            if (this.jHV.getPbData().cCZ()) {
                this.jLF.cgX();
                return;
            }
            if (this.hra == null) {
                this.hra = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hra.vb(0);
                this.hra.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void na(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void x(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nb(boolean z) {
                        if (z) {
                            PbFragment.this.jLF.cgX();
                        }
                    }
                });
            }
            this.hra.D(this.jHV.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jHV.cFJ(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cEL() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.jHV == null || (pbData = this.jHV.getPbData()) == null) {
            return null;
        }
        return pbData.cCM().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCy() != null) {
            if (eVar.cCy().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cCy().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cCy().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cEJ() && cEM()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.jLv);
                this.jLw = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.jHV.getPbData() != null && this.jHV.getPbData().cCZ()) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.jLc.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cEE().getListView().smoothScrollBy((PbFragment.this.jLv[1] + PbFragment.this.jLw) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cEE().cHu() != null) {
                            PbFragment.this.jLS.bcX().setVisibility(8);
                            PbFragment.this.cEE().cHu().g(str, str2, PbFragment.this.cEE().cHy(), (PbFragment.this.jHV == null || PbFragment.this.jHV.getPbData() == null || PbFragment.this.jHV.getPbData().cCy() == null || !PbFragment.this.jHV.getPbData().cCy().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cEy = PbFragment.this.cEE().cHu().cEy();
                            if (cEy != null && PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                cEy.a(PbFragment.this.jHV.getPbData().getAnti());
                                cEy.setThreadData(PbFragment.this.jHV.getPbData().cCy());
                            }
                            if (PbFragment.this.jLJ.cIL() == null && PbFragment.this.cEE().cHu().cEy().bea() != null) {
                                PbFragment.this.cEE().cHu().cEy().bea().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jLJ != null && PbFragment.this.jLJ.cIK() != null) {
                                            if (!PbFragment.this.jLJ.cIK().dmy()) {
                                                PbFragment.this.jLJ.sg(false);
                                            }
                                            PbFragment.this.jLJ.cIK().vn(false);
                                        }
                                    }
                                });
                                PbFragment.this.jLJ.f(PbFragment.this.cEE().cHu().cEy().bea().getInputView());
                                PbFragment.this.cEE().cHu().cEy().a(PbFragment.this.jLX);
                            }
                        }
                        PbFragment.this.cEE().cIu();
                    }
                }, 0L);
                return;
            }
            if (this.jLU == null) {
                this.jLU = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jLU.vb(1);
                this.jLU.a(new AnonymousClass38(str, str2));
            }
            if (this.jHV != null && this.jHV.getPbData() != null && this.jHV.getPbData().getForum() != null) {
                this.jLU.D(this.jHV.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jHV.cFJ(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$38  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass38 implements c.a {
        final /* synthetic */ String jNc;
        final /* synthetic */ String jNd;

        AnonymousClass38(String str, String str2) {
            this.jNc = str;
            this.jNd = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void na(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void x(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nb(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        }
                        PbFragment.this.cEE().getListView().smoothScrollBy((PbFragment.this.jLv[1] + PbFragment.this.jLw) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cEE().cHu() != null) {
                            PbFragment.this.jLS.bcX().setVisibility(8);
                            PbFragment.this.cEE().cHu().g(AnonymousClass38.this.jNc, AnonymousClass38.this.jNd, PbFragment.this.cEE().cHy(), (PbFragment.this.jHV == null || PbFragment.this.jHV.getPbData() == null || PbFragment.this.jHV.getPbData().cCy() == null || !PbFragment.this.jHV.getPbData().cCy().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cEy = PbFragment.this.cEE().cHu().cEy();
                            if (cEy != null && PbFragment.this.jHV != null && PbFragment.this.jHV.getPbData() != null) {
                                cEy.a(PbFragment.this.jHV.getPbData().getAnti());
                                cEy.setThreadData(PbFragment.this.jHV.getPbData().cCy());
                            }
                            if (PbFragment.this.jLJ.cIL() == null && PbFragment.this.cEE().cHu().cEy().bea() != null) {
                                PbFragment.this.cEE().cHu().cEy().bea().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jLJ != null && PbFragment.this.jLJ.cIK() != null) {
                                            if (!PbFragment.this.jLJ.cIK().dmy()) {
                                                PbFragment.this.jLJ.sg(false);
                                            }
                                            PbFragment.this.jLJ.cIK().vn(false);
                                        }
                                    }
                                });
                                PbFragment.this.jLJ.f(PbFragment.this.cEE().cHu().cEy().bea().getInputView());
                                PbFragment.this.cEE().cHu().cEy().a(PbFragment.this.jLX);
                            }
                        }
                        PbFragment.this.cEE().cIu();
                    }
                }, 0L);
            }
        }
    }

    public boolean cEM() {
        if ((this.jHV.getPbData() != null && this.jHV.getPbData().cCZ()) || this.iQC == null || this.jHV.getPbData() == null || this.jHV.getPbData().getAnti() == null) {
            return true;
        }
        return this.iQC.lb(this.jHV.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Ah(int i) {
        if (this.iQC == null || this.jHV.getPbData() == null || this.jHV.getPbData().getAnti() == null) {
            return true;
        }
        return this.iQC.aD(this.jHV.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.jHV != null && this.jHV.getPbData() != null && postData.ddJ() != 1) {
            String cFJ = this.jHV.cFJ();
            String id = postData.getId();
            int cCN = this.jHV.getPbData() != null ? this.jHV.getPbData().cCN() : 0;
            PbActivity.a Jp = Jp(id);
            if (Jp != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cFJ, id, "pb", true, null, false, null, cCN, postData.cKn(), this.jHV.getPbData().getAnti(), false, postData.aQx() != null ? postData.aQx().getIconInfo() : null).addBigImageData(Jp.jId, Jp.jIe, Jp.jIf, Jp.index);
                addBigImageData.setKeyPageStartFrom(this.jHV.cGt());
                addBigImageData.setFromFrsForumId(this.jHV.getFromForumId());
                addBigImageData.setKeyFromForumId(this.jHV.getForumId());
                addBigImageData.setBjhData(this.jHV.cFS());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cEN() {
        if (this.jHV.getPbData() == null || this.jHV.getPbData().cCy() == null) {
            return -1;
        }
        return this.jHV.getPbData().cCy().aRl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(boolean z) {
        if (this.jHV != null && this.jHV.jIU != null && this.jHV.jIU.cCy() != null) {
            bk cCy = this.jHV.jIU.cCy();
            cCy.mRecomAbTag = this.jHV.cGE();
            cCy.mRecomWeight = this.jHV.cGC();
            cCy.mRecomSource = this.jHV.cGD();
            cCy.mRecomExtra = this.jHV.cGF();
            if (cCy.getFid() == 0) {
                cCy.setFid(com.baidu.adp.lib.f.b.toLong(this.jHV.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cCy, "c13563");
            if (a2 != null) {
                a2.ag("reply_type", 1);
                if (z) {
                    a2.ag("obj_type", 2);
                } else {
                    a2.ag("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEO() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.LQ(this.jHV.getForumId()) && this.jHV.getPbData() != null && this.jHV.getPbData().getForum() != null) {
            if (this.jHV.getPbData().getForum().isLike() == 1) {
                this.jHV.cGp().fj(this.jHV.getForumId(), this.jHV.cFJ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ru(boolean z) {
        if (this.jHV == null || this.jHV.getPbData() == null) {
            return false;
        }
        return ((this.jHV.getPbData().cCN() != 0) || this.jHV.getPbData().cCy() == null || this.jHV.getPbData().cCy().aQx() == null || TextUtils.equals(this.jHV.getPbData().cCy().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean rv(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.v vVar;
        if (this.jHV == null || this.jHV.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.jHV.getPbData();
        bk cCy = pbData.cCy();
        if (cCy != null) {
            if (cCy.aPm() || cCy.aPn()) {
                return false;
            }
            if (cCy.aSv() || cCy.aSw()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cCN() != 0) {
                return pbData.cCN() != 3;
            }
            List<bg> cCU = pbData.cCU();
            if (com.baidu.tbadk.core.util.v.getCount(cCU) > 0) {
                for (bg bgVar : cCU) {
                    if (bgVar != null && (vVar = bgVar.dEk) != null && vVar.dCh && !vVar.dCi && (vVar.type == 1 || vVar.type == 2)) {
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

    private boolean rw(boolean z) {
        if (z || this.jHV == null || this.jHV.getPbData() == null) {
            return false;
        }
        return ((this.jHV.getPbData().getForum() != null && this.jHV.getPbData().getForum().isBlockBawuDelete) || this.jHV.getPbData().cCN() == 0 || this.jHV.getPbData().cCN() == 3) ? false : true;
    }

    public void cEP() {
        com.baidu.tieba.pb.data.e pbData;
        bk cCy;
        if (this.jHV != null && this.jHV.getPbData() != null && (cCy = (pbData = this.jHV.getPbData()).cCy()) != null && cCy.aQx() != null) {
            this.jLF.cHs();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cCy.aQx().getUserId());
            ag agVar = new ag();
            int cCN = this.jHV.getPbData().cCN();
            if (cCN == 1 || cCN == 3) {
                agVar.jQw = true;
                agVar.jQv = true;
                agVar.jQB = cCy.aQs() == 1;
                agVar.jQA = cCy.aQt() == 1;
            } else {
                agVar.jQw = false;
                agVar.jQv = false;
            }
            if (cCN == 1002 && !equals) {
                agVar.jQC = true;
            }
            agVar.jQt = rv(equals);
            agVar.jQx = cEQ();
            agVar.jQu = rw(equals);
            agVar.DC = this.jHV.cFL();
            agVar.jQq = true;
            agVar.jQp = ru(equals);
            agVar.jQo = equals && this.jLF.cHZ();
            agVar.jQz = TbadkCoreApplication.getInst().getSkinType() == 1;
            agVar.jQy = true;
            agVar.isHostOnly = this.jHV.getHostMode();
            agVar.jQs = true;
            if (cCy.aQQ() == null) {
                agVar.jQr = true;
            } else {
                agVar.jQr = false;
            }
            if (pbData.cCZ()) {
                agVar.jQq = false;
                agVar.jQs = false;
                agVar.jQr = false;
                agVar.jQv = false;
                agVar.jQw = false;
            }
            this.jLF.jSj.a(agVar);
        }
    }

    private boolean cEQ() {
        if (this.jHV != null && this.jHV.cFL()) {
            return this.jHV.getPageData() == null || this.jHV.getPageData().aPu() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
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
    public PbModel.a cER() {
        return this.jMF;
    }

    public int cES() {
        if (cEE() == null || cEE().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cEE().getListView();
        List<com.baidu.adp.widget.ListView.o> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.o oVar = data.get(i);
            if ((oVar instanceof com.baidu.tieba.pb.data.l) && ((com.baidu.tieba.pb.data.l) oVar).TK == com.baidu.tieba.pb.data.l.jGp) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cET() {
        if (cEE() == null || cEE().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cEE().getListView();
        List<com.baidu.adp.widget.ListView.o> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.o oVar = data.get(i);
            if ((oVar instanceof PostData) && oVar.getType() == PostData.llS) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cEZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEU() {
        if (this.jHV != null && this.jHV.jIU != null && this.jHV.jIU.cCy() != null) {
            bk cCy = this.jHV.jIU.cCy();
            cCy.mRecomAbTag = this.jHV.cGE();
            cCy.mRecomWeight = this.jHV.cGC();
            cCy.mRecomSource = this.jHV.cGD();
            cCy.mRecomExtra = this.jHV.cGF();
            if (cCy.getFid() == 0) {
                cCy.setFid(com.baidu.adp.lib.f.b.toLong(this.jHV.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cCy, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.vN(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.vO(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.gW(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").dh("obj_id", metaData.getUserId()).ag("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").dh("obj_id", metaData.getUserId()).ag("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.dNL.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.jHV.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aST();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.jLF.cHT();
        this.jHV.rG(z);
        if (this.jLD != null) {
            this.jLD.gC(z);
            if (markData != null) {
                this.jLD.a(markData);
            }
        }
        if (this.jHV.aML()) {
            cEX();
        } else {
            this.jLF.r(this.jHV.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zZ(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jm(String str) {
        if (this.jHV != null && this.jHV.getPbData() != null && this.jHV.getPbData().cCZ()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jHV.cFJ(), str);
            bk cCy = this.jHV.getPbData().cCy();
            if (cCy.aPm()) {
                format = format + "&channelid=33833";
            } else if (cCy.aSu()) {
                format = format + "&channelid=33842";
            } else if (cCy.aPn()) {
                format = format + "&channelid=33840";
            }
            Jn(format);
            return;
        }
        this.jLC.JN(str);
    }

    private void Jn(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.jHV.cFQ()) {
                    antiData.setBlock_forum_name(this.jHV.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.jHV.getPbData().getForum().getId());
                    antiData.setUser_name(this.jHV.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.jHV.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cEE() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bv(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            yo(str);
        } else {
            this.jLF.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.loP) ? bVar.loP : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.vO(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.gW(true);
                aVar.b(getPageContext());
                aVar.aST();
            } else {
                this.jLF.a(0, bVar.OU, bVar.loP, z);
            }
            if (bVar.OU) {
                if (bVar.gUw == 1) {
                    ArrayList<PostData> cCA = this.jHV.getPbData().cCA();
                    int size = cCA.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cCA.get(i).getId())) {
                            i++;
                        } else {
                            cCA.remove(i);
                            break;
                        }
                    }
                    this.jHV.getPbData().cCy().ks(this.jHV.getPbData().cCy().aQo() - 1);
                    this.jLF.r(this.jHV.getPbData());
                } else if (bVar.gUw == 0) {
                    cEV();
                } else if (bVar.gUw == 2) {
                    ArrayList<PostData> cCA2 = this.jHV.getPbData().cCA();
                    int size2 = cCA2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cCA2.get(i2).ddG().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cCA2.get(i2).ddG().get(i3).getId())) {
                                i3++;
                            } else {
                                cCA2.get(i2).ddG().remove(i3);
                                cCA2.get(i2).ddI();
                                z2 = true;
                                break;
                            }
                        }
                        cCA2.get(i2).MC(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.jLF.r(this.jHV.getPbData());
                    }
                    a(bVar, this.jLF);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.jLF.a(this.gFg.getLoadDataMode(), gVar.OU, gVar.loP, false);
            if (gVar.OU) {
                this.jLG = true;
                if (i == 2 || i == 3) {
                    this.jLH = true;
                    this.jLI = false;
                } else if (i == 4 || i == 5) {
                    this.jLH = false;
                    this.jLI = true;
                }
                if (i == 2) {
                    this.jHV.getPbData().cCy().kv(1);
                    this.jHV.setIsGood(1);
                } else if (i == 3) {
                    this.jHV.getPbData().cCy().kv(0);
                    this.jHV.setIsGood(0);
                } else if (i == 4) {
                    this.jHV.getPbData().cCy().ku(1);
                    this.jHV.Am(1);
                } else if (i == 5) {
                    this.jHV.getPbData().cCy().ku(0);
                    this.jHV.Am(0);
                }
                this.jLF.c(this.jHV.getPbData(), this.jHV.cFL());
            }
        }
    }

    private void cEV() {
        if (this.jHV.cFM() || this.jHV.cFO()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.jHV.cFJ());
            PbActivity pbActivity = this.jLc;
            PbActivity pbActivity2 = this.jLc;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.jHV.cFJ()));
        if (cEY()) {
            this.jLc.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEb() {
        this.jLc.cEb();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cCK;
        boolean z = false;
        if (this.jLF != null) {
            this.jLF.cIk();
        }
        if (this.jHV != null && this.jHV.getPbData() != null && !this.jHV.getPbData().cCZ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.jHV.getPbData().cCy().getId();
            if (this.jHV.isShareThread() && this.jHV.getPbData().cCy().dHm != null) {
                historyMessage.threadName = this.jHV.getPbData().cCy().dHm.showText;
            } else {
                historyMessage.threadName = this.jHV.getPbData().cCy().getTitle();
            }
            if (this.jHV.isShareThread() && !cDE()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.jHV.getPbData().getForum().getName();
            }
            ArrayList<PostData> cCA = this.jHV.getPbData().cCA();
            int cHV = this.jLF != null ? this.jLF.cHV() : 0;
            if (cCA != null && cHV >= 0 && cHV < cCA.size()) {
                historyMessage.postID = cCA.get(cHV).getId();
            }
            historyMessage.isHostOnly = this.jHV.getHostMode();
            historyMessage.isSquence = this.jHV.cFL();
            historyMessage.isShareThread = this.jHV.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.jLS != null) {
            this.jLS.onDestroy();
        }
        if (this.jLg && cEE() != null) {
            cEE().cIE();
        }
        if (this.jHV != null && (this.jHV.cFM() || this.jHV.cFO())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.jHV.cFJ());
            if (this.jLG) {
                if (this.jLI) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.jHV.bOe());
                }
                if (this.jLH) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.jHV.getIsGood());
                }
            }
            if (this.jHV.getPbData() != null && System.currentTimeMillis() - this.jLj >= 40000 && (cCK = this.jHV.getPbData().cCK()) != null && !com.baidu.tbadk.core.util.v.isEmpty(cCK.getDataList())) {
                intent.putExtra("guess_like_data", cCK);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.jMg);
            }
            PbActivity pbActivity = this.jLc;
            PbActivity pbActivity2 = this.jLc;
            pbActivity.setResult(-1, intent);
        }
        if (cEY()) {
            if (this.jHV != null && this.jLF != null && this.jLF.getListView() != null) {
                com.baidu.tieba.pb.data.e pbData = this.jHV.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cCG() && !this.jLp && pbData.jFd == null) {
                        ao cHc = ao.cHc();
                        com.baidu.tieba.pb.data.e cFT = this.jHV.cFT();
                        Parcelable onSaveInstanceState = this.jLF.getListView().onSaveInstanceState();
                        boolean cFL = this.jHV.cFL();
                        boolean hostMode = this.jHV.getHostMode();
                        if (this.jLF.cHE() != null && this.jLF.cHE().getVisibility() == 0) {
                            z = true;
                        }
                        cHc.a(cFT, onSaveInstanceState, cFL, hostMode, z);
                        if (this.jMf >= 0 || this.jHV.cGv() != null) {
                            ao.cHc().q(this.jHV.cGv());
                            ao.cHc().p(this.jHV.cGw());
                            ao.cHc().Aw(this.jHV.cGx());
                        }
                    }
                }
            } else {
                ao.cHc().reset();
            }
            cEb();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.jLF == null || !this.jLF.AC(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ai(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.jLc;
        if (i == 0) {
            this.jLF.cHs();
            this.jLF.cHu().cEu();
            this.jLF.sa(false);
        }
        this.jLF.cHw();
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
                        this.jLS.resetData();
                        this.jLS.setVoiceModel(pbEditorData.getVoiceModel());
                        this.jLS.b(writeData);
                        com.baidu.tbadk.editortools.l nh = this.jLS.bcX().nh(6);
                        if (nh != null && nh.ekV != null) {
                            nh.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.jLc;
                        if (i == -1) {
                            this.jLS.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.jLF.cHu() != null && this.jLF.cHu().cEy() != null) {
                            com.baidu.tbadk.editortools.pb.h cEy = this.jLF.cHu().cEy();
                            cEy.setThreadData(this.jHV.getPbData().cCy());
                            cEy.b(writeData);
                            cEy.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l nh2 = cEy.bcX().nh(6);
                            if (nh2 != null && nh2.ekV != null) {
                                nh2.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.jLc;
                            if (i == -1) {
                                cEy.bdS();
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
        this.jLS.onActivityResult(i, i2, intent);
        if (this.jLt != null) {
            this.jLt.onActivityResult(i, i2, intent);
        }
        if (cEE().cHu() != null) {
            cEE().cHu().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cEW();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ao.cHc().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.jHV != null) {
                                PbFragment.this.jHV.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cUi().D(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.jHV != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    S(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.cUi().D(getPageContext());
                        cEO();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.hEF != null && shareItem != null && shareItem.linkUrl != null) {
                            this.hEF.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bas() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57.1
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
                    this.jLF.rj(false);
                    if (this.jHV.getPbData() != null && this.jHV.getPbData().cCy() != null && this.jHV.getPbData().cCy().aQT() != null) {
                        this.jHV.getPbData().cCy().aQT().setStatus(2);
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
                        this.jLV = emotionImageData;
                        if (Ah(com.baidu.tbadk.core.util.aj.dNI)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.jLu != null) {
                        this.jLF.cJ(this.jLu);
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
            if (this.jLt == null) {
                this.jLt = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.jLc);
                this.jLt.b(this.emO);
                this.jLt.c(this.emV);
            }
            this.jLt.a(emotionImageData, cDO(), cDO().getPbData());
        }
    }

    private void S(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEW() {
        MarkData At;
        if (this.jLD != null) {
            if (this.jHV.getPbData() != null && this.jHV.getPbData().cCZ()) {
                At = this.jHV.At(0);
            } else {
                At = this.jHV.At(this.jLF.cHW());
            }
            if (At != null) {
                if (!At.isApp() || (At = this.jHV.At(this.jLF.cHW() + 1)) != null) {
                    this.jLF.cHR();
                    this.jLD.a(At);
                    if (!this.jLD.aML()) {
                        this.jLD.aMN();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.jLD.aMM();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEX() {
        com.baidu.tieba.pb.data.e pbData = this.jHV.getPbData();
        this.jHV.rG(true);
        if (this.jLD != null) {
            pbData.Jd(this.jLD.aMK());
        }
        this.jLF.r(pbData);
    }

    private boolean cEY() {
        if (this.jHV == null) {
            return true;
        }
        if (this.jHV.getPbData() == null || !this.jHV.getPbData().cCZ()) {
            if (this.jHV.aML()) {
                final MarkData cGd = this.jHV.cGd();
                if (cGd == null || !this.jHV.getIsFromMark()) {
                    return true;
                }
                final MarkData At = this.jHV.At(this.jLF.cHV());
                if (At == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cGd);
                    this.jLc.setResult(-1, intent);
                    return true;
                } else if (At.getPostId() == null || At.getPostId().equals(cGd.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cGd);
                    this.jLc.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.vO(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.jLD != null) {
                                if (PbFragment.this.jLD.aML()) {
                                    PbFragment.this.jLD.aMM();
                                    PbFragment.this.jLD.gC(false);
                                }
                                PbFragment.this.jLD.a(At);
                                PbFragment.this.jLD.gC(true);
                                PbFragment.this.jLD.aMN();
                            }
                            cGd.setPostId(At.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cGd);
                            PbFragment.this.jLc.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cEb();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cGd);
                            PbFragment.this.jLc.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cEb();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.jLF != null && PbFragment.this.jLF.getView() != null) {
                                PbFragment.this.jLF.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cGd);
                                PbFragment.this.jLc.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cEb();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aST();
                    return false;
                }
            } else if (this.jHV.getPbData() == null || this.jHV.getPbData().cCA() == null || this.jHV.getPbData().cCA().size() <= 0 || !this.jHV.getIsFromMark()) {
                return true;
            } else {
                this.jLc.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.jLF == null) {
            return null;
        }
        return this.jLF.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int biZ() {
        if (this.jLF == null) {
            return 0;
        }
        return this.jLF.cIi();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bja() {
        if (this.eBC == null) {
            this.eBC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bjm */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aNQ().isShowImages();
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
                        if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
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
        return this.eBC;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bjb() {
        if (this.eEq == null) {
            this.eEq = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.eEq;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bjc() {
        if (this.eBD == null) {
            this.eBD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bPQ */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aNQ().isShowImages();
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
                    if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
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
                    gifView.bes();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.eBD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bjd() {
        if (this.eEr == null) {
            this.eEr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFv */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cE */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cF */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).dfa();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cG */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.eEr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bjf() {
        this.eEt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFw */
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
        return this.eEt;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aWP() {
        if (this.dXO == null) {
            this.dXO = UserIconBox.s(getPageContext().getPageActivity(), 8);
        }
        return this.dXO;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jLn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void f(Context context, String str, boolean z) {
        if (ba.JE(str) && this.jHV != null && this.jHV.cFJ() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").ag("obj_param1", 1).dh("post_id", this.jHV.cFJ()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.ejY = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            ba.cIN().d(getPageContext(), str);
        }
        this.jLn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void am(Context context, String str) {
        ba.cIN().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.jLn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void an(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.jLF != null && this.jLF.cIz() != null && rect.top <= this.jLF.cIz().getHeight()) {
            rect.top += this.jLF.cIz().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.jHV.getPbData();
            TbRichText bu = bu(str, i);
            if (bu != null && (tbRichTextData = bu.bis().get(this.jML)) != null) {
                aVar.postId = String.valueOf(bu.getPostId());
                aVar.jId = new ArrayList<>();
                aVar.jIe = new ConcurrentHashMap<>();
                if (!tbRichTextData.biy().biJ()) {
                    aVar.jIg = false;
                    String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                    aVar.jId.add(b2);
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
                    imageUrlData.postId = bu.getPostId();
                    imageUrlData.mIsReserver = this.jHV.cGb();
                    imageUrlData.mIsSeeHost = this.jHV.getHostMode();
                    aVar.jIe.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cCy() != null) {
                            aVar.threadId = pbData.cCy().getId();
                        }
                        aVar.jIf = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.jIg = true;
                int size = pbData.cCA().size();
                this.jMM = false;
                aVar.index = -1;
                int a2 = pbData.cCH() != null ? a(pbData.cCH().ddL(), bu, i, i, aVar.jId, aVar.jIe) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cCA().get(i2);
                    if (postData.getId() == null || pbData.cCH() == null || pbData.cCH().getId() == null || !postData.getId().equals(pbData.cCH().getId())) {
                        a2 = a(postData.ddL(), bu, a2, i, aVar.jId, aVar.jIe);
                    }
                }
                if (aVar.jId.size() > 0) {
                    aVar.lastId = aVar.jId.get(aVar.jId.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cCy() != null) {
                        aVar.threadId = pbData.cCy().getId();
                    }
                    aVar.jIf = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biy() == null) {
            return null;
        }
        return tbRichTextData.biy().biO();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biy() == null) {
            return 0L;
        }
        return tbRichTextData.biy().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biy() == null) {
            return false;
        }
        return tbRichTextData.biy().biP();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biy() == null) {
            return false;
        }
        return tbRichTextData.biy().biQ();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo biy;
        String str;
        if (tbRichText == tbRichText2) {
            this.jMM = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bis().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bis().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.biy().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.biy().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.biy().biJ()) {
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
                            if (tbRichTextData != null && (biy = tbRichTextData.biy()) != null) {
                                String biL = biy.biL();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = biy.biM();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = biL;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.jHV.cFJ(), -1L);
                                imageUrlData.mIsReserver = this.jHV.cGb();
                                imageUrlData.mIsSeeHost = this.jHV.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.jMM) {
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
        PostData cCH;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.jHV.aQG())) {
                z = true;
            }
            MarkData o = this.jHV.o(postData);
            if (this.jHV.getPbData() != null && this.jHV.getPbData().cCZ() && (cCH = cCH()) != null) {
                o = this.jHV.o(cCH);
            }
            if (o != null) {
                this.jLF.cHR();
                if (this.jLD != null) {
                    this.jLD.a(o);
                    if (!z) {
                        this.jLD.aMN();
                    } else {
                        this.jLD.aMM();
                    }
                }
            }
        }
    }

    public boolean cD(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bu(String str, int i) {
        TbRichText tbRichText = null;
        if (this.jHV == null || this.jHV.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.jHV.getPbData();
        if (pbData.cCH() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cCH());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cCA = pbData.cCA();
            c(pbData, cCA);
            return c(cCA, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cCM() != null && eVar.cCM().jGE != null && (list = eVar.cCM().jGE) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bis;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText ddL = arrayList.get(i2).ddL();
            if (ddL != null && (bis = ddL.bis()) != null) {
                int size = bis.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bis.get(i4) != null && bis.get(i4).getType() == 8) {
                        i3++;
                        if (bis.get(i4).biy().biL().equals(str) || bis.get(i4).biy().biM().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bis.get(i4).biy().getWidth() * equipmentDensity;
                            int height = bis.get(i4).biy().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.jML = i4;
                            return ddL;
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
    public void s(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.jHR = str;
            if (this.jLi == null) {
                cEI();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.jLi.getItemView(1).setVisibility(8);
            } else {
                this.jLi.getItemView(1).setVisibility(0);
            }
            this.jLi.aSU();
            this.jLn = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hns;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEZ() {
        hideNetRefreshView(this.jLF.getView());
        cFa();
        if (this.jHV.cFW()) {
            this.jLF.cHR();
        }
        this.jLF.cIc();
    }

    private void cFa() {
        showLoadingView(this.jLF.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.jLF.cIz().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVp() {
        if (this.hns != null) {
            this.hns.stopPlay();
        }
        if (this.jLc != null) {
            this.jLc.bVp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aj(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cEN(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bje() {
        if (this.eEs == null) {
            this.eEs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFx */
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
        return this.eEs;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.r onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void bVq() {
        if (this.jLc != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.jLc.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jLc.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bUc() {
        if (this.jHV == null || this.jHV.getPbData() == null) {
            return null;
        }
        return this.jHV.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(av.jTx)).intValue();
            if (intValue == av.jTy) {
                if (!this.gFg.dez()) {
                    this.jLF.cHO();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.gFg.MH(com.baidu.tbadk.core.util.aq.O(jSONArray));
                    }
                    this.gFg.a(this.jHV.getPbData().getForum().getId(), this.jHV.getPbData().getForum().getName(), this.jHV.getPbData().cCy().getId(), str, intValue3, intValue2, booleanValue, this.jHV.getPbData().cCy().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == av.jTz || intValue == av.jTB) {
                if (this.jHV.cGm() != null) {
                    this.jHV.cGm().Ad(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == av.jTz) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.jMa);
        userMuteAddAndDelCustomMessage.setTag(this.jMa);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Jo(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0698a
    public void rx(boolean z) {
        this.jLM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cFb() {
        ArrayList<PostData> cCA;
        int count;
        if (this.jHV == null || this.jHV.getPbData() == null || this.jHV.getPbData().cCA() == null || (count = com.baidu.tbadk.core.util.v.getCount((cCA = this.jHV.getPbData().cCA()))) == 0) {
            return "";
        }
        if (this.jHV.cGb()) {
            Iterator<PostData> it = cCA.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.ddJ() == 1) {
                    return next.getId();
                }
            }
        }
        int cHV = this.jLF.cHV();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cCA, cHV);
        if (postData == null || postData.aQx() == null) {
            return "";
        }
        if (this.jHV.Js(postData.aQx().getUserId())) {
            return postData.getId();
        }
        for (int i = cHV - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(cCA, i);
            if (postData2 == null || postData2.aQx() == null || postData2.aQx().getUserId() == null) {
                break;
            } else if (this.jHV.Js(postData2.aQx().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cHV + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(cCA, i2);
            if (postData3 == null || postData3.aQx() == null || postData3.aQx().getUserId() == null) {
                return "";
            }
            if (this.jHV.Js(postData3.aQx().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ap(Context context, String str) {
        this.jLn = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Jp(String str) {
        String str2;
        if (this.jHV.getPbData() == null || this.jHV.getPbData().cCA() == null || this.jHV.getPbData().cCA().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.jHV.getPbData().cCA().size()) {
                i = 0;
                break;
            } else if (str.equals(this.jHV.getPbData().cCA().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.jHV.getPbData().cCA().get(i);
        if (postData.ddL() == null || postData.ddL().bis() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.ddL().bis().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.biy() != null) {
                    str2 = next.biy().biL();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.f.a(postData, aVar);
        return aVar;
    }

    public boolean cFc() {
        return (!this.jLd && this.jMR == -1 && this.jMS == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.jMU = oVar;
            this.jLd = true;
            this.jLF.cHF();
            this.jLF.JC(this.jMT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFd() {
        if (this.jMU != null) {
            if (this.jMR == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.jMU.getCartoonId(), this.jMR, 0)));
                this.jLc.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFe() {
        if (this.jMU != null) {
            if (this.jMS == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.jMU.getCartoonId(), this.jMS, 0)));
                this.jLc.finish();
            }
        }
    }

    public int cFf() {
        return this.jMR;
    }

    public int cFg() {
        return this.jMS;
    }

    private void chw() {
        if (this.jHV != null && this.jHV.getPbData() != null && this.jHV.getPbData().cCy() != null && this.jHV.getPbData().cCy().aPk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cFh() {
        if (this.jHV != null && this.jHV.getPbData() != null && this.jHV.getPbData().cCy() != null && this.jHV.getPbData().cCy().aPk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cFi() {
        if (this.beu) {
            this.jLs = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.jHV.getPbData() != null && this.jHV.getPbData().cCy() != null && this.jHV.getPbData().cCy().aQd() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.jHV.getPbData().cCy().aQd().getThreadId(), this.jHV.getPbData().cCy().aQd().getTaskId(), this.jHV.getPbData().cCy().aQd().getForumId(), this.jHV.getPbData().cCy().aQd().getForumName(), this.jHV.getPbData().cCy().aQs(), this.jHV.getPbData().cCy().aQt())));
            this.jLf = true;
            this.jLc.finish();
        }
    }

    public String cFj() {
        return this.jLq;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cFk() {
        return this.jLB;
    }

    public void ry(boolean z) {
        this.jLr = z;
    }

    public boolean aSr() {
        if (this.jHV != null) {
            return this.jHV.cFM();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.vO(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.jLY).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.jLY.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jLY).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(String str) {
        if (str == null) {
            str = "";
        }
        if (this.jLY != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLY.getPageActivity());
            aVar.vO(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jLY).aST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.jLF.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLY.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.vO(this.jLY.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.vO(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.jLF.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jLY).aST();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ba.JE(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.hPc) {
            this.hPc = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.jLF != null) {
                this.jLF.onConfigurationChanged(configuration);
            }
            if (this.jLK != null) {
                this.jLK.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cFm() {
        if (this.jHV != null) {
            return this.jHV.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, av avVar) {
        boolean z;
        List<PostData> list = this.jHV.getPbData().cCM().jGE;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).ddG().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).ddG().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).ddG().remove(i2);
                    list.get(i).ddI();
                    z = true;
                    break;
                }
            }
            list.get(i).MC(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            avVar.r(this.jHV.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.n nVar) {
        String id = nVar.cDs().getId();
        List<PostData> list = this.jHV.getPbData().cCM().jGE;
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
                ArrayList<PostData> cDw = nVar.cDw();
                postData.DT(nVar.getTotalCount());
                if (postData.ddG() != null) {
                    postData.ddG().clear();
                    postData.ddG().addAll(cDw);
                }
            }
        }
        if (!this.jHV.getIsFromMark()) {
            this.jLF.r(this.jHV.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cDD() {
        return this.jLc.cDD();
    }

    public boolean cDE() {
        if (this.jHV == null) {
            return false;
        }
        return this.jHV.cDE();
    }

    public void cFn() {
        if (this.jLF != null) {
            this.jLF.cHs();
            bVq();
        }
    }

    public PostData cCH() {
        return this.jLF.b(this.jHV.jIU, this.jHV.cFL());
    }

    public void onBackPressed() {
        if (this.jMh != null && !this.jMh.isEmpty()) {
            int size = this.jMh.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.jMh.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.jMh == null) {
                this.jMh = new ArrayList();
            }
            if (!this.jMh.contains(aVar)) {
                this.jMh.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.jMh == null) {
                this.jMh = new ArrayList();
            }
            if (!this.jMh.contains(aVar)) {
                this.jMh.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.jMh != null) {
            this.jMh.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.r rVar) {
        com.baidu.tbadk.core.util.ad.a(rVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(rVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFo() {
        if (this.jHV != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.jHV.cFJ())) {
            com.baidu.tbadk.BdToken.c.aLi().o(com.baidu.tbadk.BdToken.b.dtS, com.baidu.adp.lib.f.b.toLong(this.jHV.cFJ(), 0L));
        }
    }

    public com.baidu.tbadk.core.data.ay cFp() {
        return this.jLz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jq(String str) {
        if (this.jHV != null && this.jHV.getPbData() != null && this.jHV.getPbData().cCy() != null && this.jHV.getPbData().cCy().aSx()) {
            bk cCy = this.jHV.getPbData().cCy();
            int i = 0;
            if (cCy.aPm()) {
                i = 1;
            } else if (cCy.aPn()) {
                i = 2;
            } else if (cCy.aSv()) {
                i = 3;
            } else if (cCy.aSw()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.ag("obj_source", 4);
            anVar.ag("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cFq() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cFr() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cFs() {
        return this.jLc;
    }
}
