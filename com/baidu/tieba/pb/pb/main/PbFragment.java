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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes16.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.pb.videopb.b, a.InterfaceC0726a {
    private bd dKK;
    private com.baidu.adp.lib.d.b<ImageView> eRG;
    private com.baidu.adp.lib.d.b<GifView> eRH;
    private com.baidu.adp.lib.d.b<TextView> eUX;
    private com.baidu.adp.lib.d.b<View> eUY;
    private com.baidu.adp.lib.d.b<LinearLayout> eUZ;
    private com.baidu.adp.lib.d.b<RelativeLayout> eVa;
    private com.baidu.tbadk.core.message.a eeP;
    private com.baidu.tieba.tbadkCore.data.e eez;
    private com.baidu.adp.lib.d.b<TbImageView> elu;
    private LikeModel emT;
    private com.baidu.tieba.callfans.a gXE;
    private VoiceManager hFy;
    private com.baidu.tieba.frs.profession.permission.c hJL;
    private com.baidu.tieba.f.b hKk;
    public com.baidu.tbadk.core.util.al jqz;
    private String kkh;
    private PbActivity knE;
    private com.baidu.tieba.pb.pb.main.b.b knG;
    private com.baidu.tieba.pb.pb.main.emotion.model.a knV;
    private View knW;
    int knY;
    private com.baidu.adp.base.e koA;
    private com.baidu.tbadk.core.view.c koB;
    private BdUniqueId koC;
    private Runnable koD;
    private com.baidu.adp.widget.ImageView.a koE;
    private String koF;
    private TbRichTextMemeInfo koG;
    private List<a> koJ;
    public String koL;
    private com.baidu.tbadk.core.data.be kob;
    private com.baidu.tieba.pb.pb.report.a koe;
    public bb kol;
    private com.baidu.tbadk.core.dialog.i kom;
    private com.baidu.tbadk.core.dialog.k kon;
    private boolean koo;
    private com.baidu.tieba.tbadkCore.data.f kos;
    private com.baidu.tbadk.editortools.pb.g kot;
    private com.baidu.tbadk.editortools.pb.e kou;
    private com.baidu.tieba.frs.profession.permission.c kow;
    private EmotionImageData kox;
    private boolean kpn;
    private String kpw;
    private com.baidu.tbadk.core.data.r kpx;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a kpt = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        @Override // com.baidu.tieba.f.b.a
        public void cg(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cLD();
            } else {
                com.baidu.tieba.pb.a.b.cLC();
            }
        }
    };
    private boolean knF = false;
    private boolean knH = false;
    private boolean bjZ = false;
    private boolean jJI = false;
    private boolean knI = true;
    private int knJ = 0;
    private com.baidu.tbadk.core.dialog.b knK = null;
    private long hio = -1;
    private long eHn = 0;
    private long knL = 0;
    private long createTime = 0;
    private long eHd = 0;
    private boolean knM = false;
    private com.baidu.tbadk.n.b knN = null;
    private long knO = 0;
    private boolean knP = false;
    private long knQ = 0;
    private int iis = 1;
    private String eBU = null;
    private boolean knR = false;
    private boolean isFullScreen = false;
    private String knS = "";
    private boolean knT = true;
    private boolean knU = false;
    private String source = "";
    private int mSkinType = 3;
    int[] knX = new int[2];
    private int knZ = -1;
    private int koa = -1;
    public BdUniqueId koc = BdUniqueId.gen();
    private boolean klG = com.baidu.tbadk.a.d.aRO();
    private PbInterviewStatusView.a kod = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.koh.sM(!PbFragment.this.knT);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.kkl != null && PbFragment.this.kkl.aSj()) {
                        PbFragment.this.cMY();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel kkl = null;
    private com.baidu.tbadk.baseEditMark.a kof = null;
    private ForumManageModel gXC = null;
    private com.baidu.tbadk.coreExtra.model.a eaU = null;
    private com.baidu.tieba.pb.data.q kog = null;
    private ShareSuccessReplyToServerModel hXO = null;
    private az koh = null;
    private boolean koi = false;
    private boolean koj = false;
    private boolean kok = false;
    private boolean fhJ = false;
    private boolean kop = false;
    private boolean koq = false;
    private boolean kor = false;
    private boolean kov = false;
    public boolean koy = false;
    private com.baidu.tbadk.editortools.pb.c eBX = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bjj() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b eBY = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bji() {
            if (PbFragment.this.kol == null || PbFragment.this.kol.cQO() == null || !PbFragment.this.kol.cQO().dub()) {
                return !PbFragment.this.BI(com.baidu.tbadk.core.util.al.eaP);
            }
            PbFragment.this.showToast(PbFragment.this.kol.cQO().dud());
            if (PbFragment.this.kou != null && (PbFragment.this.kou.bjz() || PbFragment.this.kou.bjA())) {
                PbFragment.this.kou.a(false, PbFragment.this.kol.cQR());
            }
            PbFragment.this.kol.sZ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b koz = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bji() {
            if (PbFragment.this.kol == null || PbFragment.this.kol.cQP() == null || !PbFragment.this.kol.cQP().dub()) {
                return !PbFragment.this.BI(com.baidu.tbadk.core.util.al.eaQ);
            }
            PbFragment.this.showToast(PbFragment.this.kol.cQP().dud());
            if (PbFragment.this.koh != null && PbFragment.this.koh.cPy() != null && PbFragment.this.koh.cPy().cMz() != null && PbFragment.this.koh.cPy().cMz().bjA()) {
                PbFragment.this.koh.cPy().cMz().a(PbFragment.this.kol.cQR());
            }
            PbFragment.this.kol.ta(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean hGn = false;
    private int koH = 0;
    private int koI = -1;
    public int koK = 0;
    private final a koM = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.koh != null && PbFragment.this.koh.cPy() != null) {
                v cPy = PbFragment.this.koh.cPy();
                if (cPy.cMx()) {
                    cPy.cMw();
                    return true;
                }
            }
            if (PbFragment.this.koh != null && PbFragment.this.koh.cQw()) {
                PbFragment.this.koh.cQx();
                return true;
            }
            return false;
        }
    };
    private final ai.a koN = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bd(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.koh.showToast(str);
            }
        }
    };
    private final CustomMessageListener koO = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.86
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kkl != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.kou != null) {
                    PbFragment.this.koh.sR(PbFragment.this.kou.bjs());
                }
                PbFragment.this.koh.cPA();
                PbFragment.this.koh.cQo();
            }
        }
    };
    CustomMessageListener hHe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbFragment.this.kkl.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbFragment.this.koh != null && PbFragment.this.kkl != null) {
                    PbFragment.this.koh.b(PbFragment.this.kkl.getPbData(), PbFragment.this.kkl.cNN(), PbFragment.this.kkl.cOk(), PbFragment.this.koh.getSkinType());
                }
                if (PbFragment.this.koh != null && PbFragment.this.koh.cPR() != null) {
                    PbFragment.this.koh.cPR().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener koP = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.koh != null) {
                    if (booleanValue) {
                        PbFragment.this.koh.cvF();
                    } else {
                        PbFragment.this.koh.cvE();
                    }
                }
            }
        }
    };
    private CustomMessageListener koQ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.kou != null) {
                    PbFragment.this.koh.sR(PbFragment.this.kou.bjs());
                }
                PbFragment.this.koh.sT(false);
            }
        }
    };
    private CustomMessageListener koR = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener koS = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.koh != null && PbFragment.this.koh.cPR() != null) {
                PbFragment.this.koh.cPR().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener iRM = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener hHa = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bjZ) {
                PbFragment.this.cNp();
            }
        }
    };
    private View.OnClickListener eCG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.eBU);
        }
    };
    private CustomMessageListener koT = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.af)) {
                com.baidu.tbadk.core.data.af afVar = (com.baidu.tbadk.core.data.af) customResponsedMessage.getData();
                aw.a aVar = new aw.a();
                aVar.giftId = afVar.id;
                aVar.giftName = afVar.name;
                aVar.thumbnailUrl = afVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kkl.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.kkl.cOb() != null && PbFragment.this.kkl.cOb().getUserIdLong() == afVar.toUserId) {
                        PbFragment.this.koh.a(afVar.sendCount, PbFragment.this.kkl.getPbData(), PbFragment.this.kkl.cNN(), PbFragment.this.kkl.cOk());
                    }
                    if (pbData.cKz() != null && pbData.cKz().size() >= 1 && pbData.cKz().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cKz().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.kkl.cNL(), 0L);
                        if (j == afVar.postId && j2 == afVar.threadId) {
                            com.baidu.tbadk.core.data.aw dlq = pbData.cKz().get(0).dlq();
                            if (dlq == null) {
                                dlq = new com.baidu.tbadk.core.data.aw();
                            }
                            ArrayList<aw.a> aVd = dlq.aVd();
                            if (aVd == null) {
                                aVd = new ArrayList<>();
                            }
                            aVd.add(0, aVar);
                            dlq.setTotal(afVar.sendCount + dlq.getTotal());
                            dlq.x(aVd);
                            pbData.cKz().get(0).a(dlq);
                            PbFragment.this.koh.cPR().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener koU = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                PbFragment.this.kkl.getPbData().cKR();
                PbFragment.this.kkl.cOg();
                if (PbFragment.this.koh.cPR() != null) {
                    PbFragment.this.koh.s(PbFragment.this.kkl.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener hYZ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Kz(str);
                PbFragment.this.kkl.cOg();
                if (!TextUtils.isEmpty(str) && PbFragment.this.kkl.getPbData().cKz() != null) {
                    ArrayList<PostData> cKz = PbFragment.this.kkl.getPbData().cKz();
                    Iterator<PostData> it = cKz.iterator();
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
                        cKz.remove(nVar);
                        if (PbFragment.this.koh.cPR() != null && PbFragment.this.koh.cPR().getDataList() != null) {
                            PbFragment.this.koh.cPR().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.koh.getListView() != null && PbFragment.this.koh.getListView().getData() != null) {
                            PbFragment.this.koh.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.koh.cPR() != null) {
                            PbFragment.this.koh.cPR().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.koh.cPR() != null) {
                    PbFragment.this.koh.s(PbFragment.this.kkl.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a koV = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cRh()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a koW = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void bd(List<String> list) {
            if (!com.baidu.tbadk.core.util.x.isEmpty(list) && PbFragment.this.koh != null) {
                PbFragment.this.koh.eu(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean koX = false;
    private PraiseModel koY = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Br(String str) {
            PbFragment.this.koX = false;
            if (PbFragment.this.koY != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kkl.getPbData();
                if (pbData.cKx().aVW().getIsLike() == 1) {
                    PbFragment.this.vP(0);
                } else {
                    PbFragment.this.vP(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cKx()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.koX = false;
            if (PbFragment.this.koY != null && str != null) {
                if (AntiHelper.bB(i, str)) {
                    AntiHelper.aW(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a koZ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void sr(boolean z) {
            PbFragment.this.sq(z);
            if (PbFragment.this.koh.cQC() != null && z) {
                PbFragment.this.koh.sM(false);
            }
            PbFragment.this.koh.sO(z);
        }
    };
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().erH != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().erH, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.cKG().aWl() != null && PbFragment.this.cKG().aWl().getGodUserData() != null) {
                            PbFragment.this.cKG().aWl().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().cKx() != null && PbFragment.this.kkl.getPbData().cKx().aWl() != null) {
                            PbFragment.this.kkl.getPbData().cKx().aWl().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h hEE = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.knE.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a kpa = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.koh.bMt();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.BK(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.ckW();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c euG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cMI();
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
                        if (PbFragment.this.cI(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.koh.cMG() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10630").dn("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cLE() != null && PbFragment.this.cLE().hps != null) {
                                PbFragment.this.cLE().hps.onClick(view);
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
                if (PbFragment.this.kou != null) {
                    PbFragment.this.koh.sR(PbFragment.this.kou.bjs());
                }
                PbFragment.this.koh.cPA();
                PbFragment.this.koh.cQo();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener kpb = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.koC) {
                PbFragment.this.koh.bMt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kkl.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cKN().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.koB.showSuccessToast(PbFragment.this.koA.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.koA.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.zN(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cNm();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.as.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.koA.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.koB.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kpc = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.koC) {
                PbFragment.this.koh.bMt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.koB.showSuccessToast(PbFragment.this.koA.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.as.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.koA.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.koB.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kpd = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.koC) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.koh.bMt();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.mbC;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (com.baidu.tbadk.core.util.as.isEmpty(str)) {
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
                    PbFragment.this.koh.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener kpe = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.koh.cPB() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cMI();
            }
        }
    };
    private CustomMessageListener hHm = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.hGn = true;
                }
            }
        }
    };
    public a.b jUP = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cbV();
            com.baidu.tbadk.core.data.au pageData = PbFragment.this.kkl.getPageData();
            int pageNum = PbFragment.this.koh.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aUW()) {
                PbFragment.this.koh.cQo();
                PbFragment.this.cbU();
                PbFragment.this.koh.cPV();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.kkl.BO(PbFragment.this.koh.getPageNum());
                    if (PbFragment.this.knG != null) {
                        PbFragment.this.knG.showFloatingView();
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
    private k.c kpf = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.kom != null) {
                PbFragment.this.kom.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.koE != null && !TextUtils.isEmpty(PbFragment.this.koF)) {
                        if (PbFragment.this.koG == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.koF));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.koF;
                            aVar.pkgId = PbFragment.this.koG.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.koG.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.koE = null;
                        PbFragment.this.koF = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.koE != null && !TextUtils.isEmpty(PbFragment.this.koF)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.dKK == null) {
                                PbFragment.this.dKK = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.dKK.j(PbFragment.this.koF, PbFragment.this.koE.getImageByte());
                            PbFragment.this.koE = null;
                            PbFragment.this.koF = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.iFI != null) {
                        PbFragment.this.iFI.fs(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.iFI = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11739").ah("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cJ(view);
                        if (PbFragment.this.kkl.getPbData().cKx() != null && PbFragment.this.kkl.getPbData().cKx().aWl() != null && PbFragment.this.kkl.getPbData().cKx().aWl().getUserId() != null && PbFragment.this.kof != null) {
                            int h = PbFragment.this.h(PbFragment.this.kkl.getPbData());
                            bv cKx = PbFragment.this.kkl.getPbData().cKx();
                            if (cKx.aUT()) {
                                i2 = 2;
                            } else if (cKx.aUU()) {
                                i2 = 3;
                            } else if (cKx.aYg()) {
                                i2 = 4;
                            } else {
                                i2 = cKx.aYh() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12526").dn("tid", PbFragment.this.kkl.krf).ah("obj_locate", 2).dn("obj_id", PbFragment.this.kkl.getPbData().cKx().aWl().getUserId()).ah("obj_type", PbFragment.this.kof.aSj() ? 0 : 1).ah("obj_source", h).ah("obj_param1", i2));
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13079"));
                        PbFragment.this.KB((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11739").ah("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.c(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.koh.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null) {
                        boolean booleanValue = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray4.put(R.id.tag_from, 1);
                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                PbFragment.this.c(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.koh.cP(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.koh.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.aYc() != null) {
                            PbFragment.this.d(postData.aYc());
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public SortSwitchButton.a kpg = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean vs(int i) {
            PbFragment.this.koh.cQo();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.kkl == null || PbFragment.this.kkl.isLoading) {
                    return false;
                }
                PbFragment.this.cbU();
                PbFragment.this.koh.cPV();
                if (PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().kho != null && PbFragment.this.kkl.getPbData().kho.size() > i) {
                    int intValue = PbFragment.this.kkl.getPbData().kho.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13699").dn("tid", PbFragment.this.kkl.cNM()).dn("fid", PbFragment.this.kkl.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).ah("obj_type", BM(intValue)));
                    if (PbFragment.this.kkl.BT(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.koh.sH(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int BM(int i) {
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
    public final View.OnClickListener hIl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        /* JADX WARN: Removed duplicated region for block: B:781:0x22c5  */
        /* JADX WARN: Removed duplicated region for block: B:784:0x2309  */
        /* JADX WARN: Removed duplicated region for block: B:801:0x24e2  */
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
            ca caVar;
            SparseArray sparseArray;
            boolean z2;
            String str;
            com.baidu.tbadk.core.dialog.g gVar4;
            String[] strArr;
            com.baidu.tieba.pb.data.f pbData;
            boolean y;
            String name2;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.koh.cQk()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.kkl.sw(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.koh.cPW();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cPa()) {
                        if (PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cPb()) {
                            if (view == PbFragment.this.koh.kuY.eJG) {
                                if (PbFragment.this.koh.sQ(PbFragment.this.kkl.cNS())) {
                                    PbFragment.this.cbU();
                                    return;
                                }
                                PbFragment.this.knI = false;
                                PbFragment.this.knH = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.knE, PbFragment.this.koh.kuY.eJG);
                                PbFragment.this.knE.finish();
                            } else if (view != PbFragment.this.koh.cPT() && (PbFragment.this.koh.kuY.cRu() == null || (view != PbFragment.this.koh.kuY.cRu().cOZ() && view != PbFragment.this.koh.kuY.cRu().cOX()))) {
                                if (view == PbFragment.this.koh.cQs()) {
                                    if (PbFragment.this.kkl != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kkl.getPbData().cKx().aWk().getLink());
                                    }
                                } else if (view != PbFragment.this.koh.kuY.kBm) {
                                    if (view == PbFragment.this.koh.kuY.kBn) {
                                        if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                            ArrayList<PostData> cKz = PbFragment.this.kkl.getPbData().cKz();
                                            if ((cKz == null || cKz.size() <= 0) && PbFragment.this.kkl.cNN()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12378").dn("tid", PbFragment.this.kkl.cNL()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fid", PbFragment.this.kkl.getForumId()));
                                            if (!PbFragment.this.koh.cQH()) {
                                                PbFragment.this.koh.cPA();
                                            }
                                            PbFragment.this.cMQ();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.koh.sf(true);
                                            PbFragment.this.koh.cPA();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.koh.cvF();
                                                PbFragment.this.cbU();
                                                PbFragment.this.koh.cPV();
                                                PbFragment.this.kkl.KG(PbFragment.this.cNc());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cOW()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.koh.kuY.cRu() != null && view == PbFragment.this.koh.kuY.cRu().cOV()) {
                                                PbFragment.this.koh.kuY.aIX();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.BJ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.BL(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cOT()) {
                                                    if (PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cPd()) {
                                                        if (PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cOU()) {
                                                            if (PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cPe()) {
                                                                if (PbFragment.this.koh.cQC() == view) {
                                                                    if (PbFragment.this.koh.cQC().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.kkl.getPbData();
                                                                        if (pbData2 != null && pbData2.cKx() != null && pbData2.cKx().aVR() != null) {
                                                                            String aVH = pbData2.cKx().aVR().aVH();
                                                                            if (StringUtils.isNull(aVH)) {
                                                                                aVH = pbData2.cKx().aVR().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11107").dn("obj_id", aVH));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.fA("c10725", null);
                                                                    }
                                                                    PbFragment.this.cNj();
                                                                } else if (PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cPc()) {
                                                                    if (PbFragment.this.koh.kuY.cRu() != null && view == PbFragment.this.koh.kuY.cRu().cOY()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.koh.b(PbFragment.this.kkl.getPbData(), PbFragment.this.kkl.cNN(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.koh.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.koh.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.koh.kuY.aIX();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13398");
                                                                            apVar.dn("tid", PbFragment.this.kkl.cNL());
                                                                            apVar.dn("fid", PbFragment.this.kkl.getForumId());
                                                                            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            apVar.ah("obj_locate", 4);
                                                                            TiebaStatic.log(apVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                                                                PbFragment.this.koh.cQo();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dlu() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12630"));
                                                                                    }
                                                                                    if (postData.lNY != null) {
                                                                                        com.baidu.tbadk.core.util.ap baN = postData.lNY.baN();
                                                                                        baN.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            baN.ah("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            baN.ah("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(baN);
                                                                                    }
                                                                                    String cNL = PbFragment.this.kkl.cNL();
                                                                                    String id = postData.getId();
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.kkl.getPbData() != null) {
                                                                                        i3 = PbFragment.this.kkl.getPbData().cKM();
                                                                                    }
                                                                                    PbFragment.this.cbU();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a KE = PbFragment.this.KE(id);
                                                                                        if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && KE != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cNL, id, "pb", true, null, true, null, i3, postData.cSs(), PbFragment.this.kkl.getPbData().getAnti(), false, postData.aWl().getIconInfo()).addBigImageData(KE.kkt, KE.dLG, KE.dLE, KE.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.kkl.cOv());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.kkl.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.kkl.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.kkl.cNU());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a KE2 = PbFragment.this.KE(id);
                                                                                        if (postData != null && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && KE2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cNL, id, "pb", true, null, false, null, i3, postData.cSs(), PbFragment.this.kkl.getPbData().getAnti(), false, postData.aWl().getIconInfo()).addBigImageData(KE2.kkt, KE2.dLG, KE2.dLE, KE2.index);
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.kkl.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.kkl.cNU());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.kkl.cOv());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.kkl.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10517").ah("obj_locate", 3).dn("fid", PbFragment.this.kkl.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.kkl != null) {
                                                                            com.baidu.tbadk.core.util.ap apVar2 = new com.baidu.tbadk.core.util.ap("c13398");
                                                                            apVar2.dn("tid", PbFragment.this.kkl.cNL());
                                                                            apVar2.dn("fid", PbFragment.this.kkl.getForumId());
                                                                            apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            apVar2.ah("obj_locate", 5);
                                                                            TiebaStatic.log(apVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData2 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData2.lNY != null) {
                                                                                        com.baidu.tbadk.core.util.ap baN2 = postData2.lNY.baN();
                                                                                        baN2.delete("obj_locate");
                                                                                        baN2.ah("obj_locate", 8);
                                                                                        TiebaStatic.log(baN2);
                                                                                    }
                                                                                    if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                                                                        String cNL2 = PbFragment.this.kkl.cNL();
                                                                                        String id2 = postData2.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.kkl.getPbData() != null) {
                                                                                            i4 = PbFragment.this.kkl.getPbData().cKM();
                                                                                        }
                                                                                        PbActivity.a KE3 = PbFragment.this.KE(id2);
                                                                                        if (KE3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cNL2, id2, "pb", true, null, false, null, i4, postData2.cSs(), PbFragment.this.kkl.getPbData().getAnti(), false, postData2.aWl().getIconInfo()).addBigImageData(KE3.kkt, KE3.dLG, KE3.dLE, KE3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.kkl.cOv());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.kkl.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.kkl.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.kkl.cNU());
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
                                                                        if (PbFragment.this.kkl != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.ap apVar3 = new com.baidu.tbadk.core.util.ap("c13398");
                                                                                apVar3.dn("tid", PbFragment.this.kkl.cNL());
                                                                                apVar3.dn("fid", PbFragment.this.kkl.getForumId());
                                                                                apVar3.dn("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                apVar3.ah("obj_locate", 6);
                                                                                TiebaStatic.log(apVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData3.lNY != null) {
                                                                                        com.baidu.tbadk.core.util.ap baN3 = postData3.lNY.baN();
                                                                                        baN3.delete("obj_locate");
                                                                                        baN3.ah("obj_locate", 8);
                                                                                        TiebaStatic.log(baN3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13700").dn("tid", PbFragment.this.kkl.cNM()).dn("fid", PbFragment.this.kkl.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", postData3.getId()).ah("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.cMF().cPx() != null && postData3.aWl() != null && postData3.dli() != 1) {
                                                                                        if (PbFragment.this.cMF().cPy() != null) {
                                                                                            PbFragment.this.cMF().cPy().cMv();
                                                                                        }
                                                                                        if ((PbFragment.this.klG || com.baidu.tbadk.a.d.aRF()) && postData3.dlf() != null && postData3.dlf().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.aRG()) {
                                                                                                PbFragment.this.a(postData3, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData3, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.kkl.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.kkl.getPbData().cKx());
                                                                                            pVar.g(postData3);
                                                                                            PbFragment.this.cMF().cPx().d(pVar);
                                                                                            PbFragment.this.cMF().cPx().setPostId(postData3.getId());
                                                                                            PbFragment.this.a(view, postData3.aWl().getUserId(), "", postData3);
                                                                                            if (PbFragment.this.kou != null) {
                                                                                                PbFragment.this.koh.sR(PbFragment.this.kou.bjs());
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
                                                                        if (view != PbFragment.this.koh.cLZ()) {
                                                                            if (view == PbFragment.this.koh.kuY.cRv()) {
                                                                                PbFragment.this.koh.cQc();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (caVar = (ca) view.getTag()) != null && !StringUtils.isNull(caVar.aYz())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        com.baidu.tbadk.core.util.bd.baV().b(PbFragment.this.getPageContext(), new String[]{caVar.aYz()});
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11740"));
                                                                                        if (view != null && view.getTag() != null) {
                                                                                            SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                            PostData postData4 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                            if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12006").dn("tid", PbFragment.this.kkl.krf));
                                                                                            }
                                                                                            if (PbFragment.this.kon == null) {
                                                                                                PbFragment.this.kon = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.kon.a(PbFragment.this.kpf);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.cK(view);
                                                                                            if (!PbFragment.this.cK(view) || PbFragment.this.koE == null || !PbFragment.this.koE.isGif()) {
                                                                                            }
                                                                                            boolean z3 = false;
                                                                                            boolean z4 = false;
                                                                                            boolean z5 = false;
                                                                                            boolean z6 = false;
                                                                                            boolean z7 = false;
                                                                                            String str2 = null;
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
                                                                                                str2 = (String) sparseArray5.get(R.id.tag_forbid_user_post_id);
                                                                                            }
                                                                                            if (postData4 != null) {
                                                                                                if (postData4.dlk() != null && postData4.dlk().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kon);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData4);
                                                                                                    gVar5.mTextView.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.iFI = postData4;
                                                                                            }
                                                                                            if (PbFragment.this.kkl.getPbData().aSj()) {
                                                                                                String aSi = PbFragment.this.kkl.getPbData().aSi();
                                                                                                if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(aSi) && aSi.equals(postData4.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kon);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kon);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.iFI);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kon);
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
                                                                                                            gVar.mTextView.setTag(sparseArray8);
                                                                                                            arrayList.add(gVar6);
                                                                                                        } else {
                                                                                                            if (PbFragment.this.sm(z3) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kon);
                                                                                                                gVar7.mTextView.setTag(str2);
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
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_post_id, str2);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kon);
                                                                                                                gVar2.mTextView.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kon);
                                                                                                            gVar3.mTextView.setTag(sparseArray9);
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
                                                                                                            if (PbFragment.this.kkl.getPbData().cKM() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kon);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kon);
                                                                                                            }
                                                                                                            gVar2.mTextView.setTag(sparseArray10);
                                                                                                            gVar3 = null;
                                                                                                        }
                                                                                                        if (gVar2 != null) {
                                                                                                            arrayList.add(gVar2);
                                                                                                        }
                                                                                                        if (gVar3 != null) {
                                                                                                            arrayList.add(gVar3);
                                                                                                        }
                                                                                                    }
                                                                                                    PbFragment.this.kon.aS(arrayList);
                                                                                                    PbFragment.this.kom = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kon);
                                                                                                    PbFragment.this.kom.showDialog();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.iFI);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.kon.aS(arrayList);
                                                                                            PbFragment.this.kom = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kon);
                                                                                            PbFragment.this.kom.showDialog();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().cKx() != null && PbFragment.this.kkl.getPbData().cKx().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.kkl.getPbData().cKx().getActUrl());
                                                                                        if (PbFragment.this.kkl.getPbData().cKx().aWY() != 1) {
                                                                                            if (PbFragment.this.kkl.getPbData().cKx().aWY() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10912").dn("fid", PbFragment.this.kkl.getPbData().getForumId()).dn("tid", PbFragment.this.kkl.getPbData().getThreadId()).dn("lotterytail", StringUtils.string(str3, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.kkl.getPbData().getThreadId().equals(str3)) {
                                                                                            PbFragment.this.koh.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bf.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.aZP().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.koh.cPA();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.cMO() == 1 && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10397").dn("fid", PbFragment.this.kkl.getPbData().getForumId()).dn("tid", PbFragment.this.kkl.getPbData().getThreadId()).dn("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.cMO() == 1 && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10507").dn("fid", PbFragment.this.kkl.getPbData().getForumId()).dn("tid", PbFragment.this.kkl.getPbData().getThreadId()).dn("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.cNe();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.cNf();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().cKT() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.kkl.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11679").dn("fid", pbData3.getForumId()));
                                                                                        com.baidu.tbadk.core.util.bd.baV().b(PbFragment.this.getPageContext(), new String[]{pbData3.cKT().cLf()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().cKT() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.kkl.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11678").dn("fid", pbData4.getForumId()));
                                                                                        com.baidu.tbadk.core.util.bd.baV().b(PbFragment.this.getPageContext(), new String[]{pbData4.cKT().cLf()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.koH >= 0) {
                                                                                        if (PbFragment.this.kkl != null) {
                                                                                            PbFragment.this.kkl.cOw();
                                                                                        }
                                                                                        if (PbFragment.this.kkl != null && PbFragment.this.koh.cPR() != null) {
                                                                                            PbFragment.this.koh.cPR().a(PbFragment.this.kkl.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.koH = 0;
                                                                                        if (PbFragment.this.kkl != null) {
                                                                                            PbFragment.this.koh.getListView().setSelection(PbFragment.this.kkl.cOz());
                                                                                            PbFragment.this.kkl.cM(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.BJ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.BL(8);
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
                                                                                    if (PbFragment.this.koh.getListView() != null && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.koh.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.koh.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean cKX = PbFragment.this.kkl.getPbData().cKX();
                                                                                        boolean z8 = PbFragment.this.koh.cPz() != null && PbFragment.this.koh.cPz().bDD();
                                                                                        boolean cQl = PbFragment.this.koh.cQl();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (cKX && PbFragment.this.koh.cPz() != null && PbFragment.this.koh.cPz().bxk() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.koh.cPz().cRe();
                                                                                            z9 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.koh.cPz().bxk().getHeight() - PbFragment.this.koh.cPz().cRe());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.KF("c13568");
                                                                                        if ((PbFragment.this.kkl.getPbData().cKx() != null && PbFragment.this.kkl.getPbData().cKx().aWc() <= 0) || (cQl && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.cML();
                                                                                                if (PbFragment.this.kkl.getPbData().cKx().aWl() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13402").dn("tid", PbFragment.this.kkl.krf).dn("fid", PbFragment.this.kkl.getPbData().getForumId()).ah("obj_locate", 2).dn("uid", PbFragment.this.kkl.getPbData().cKx().aWl().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (cKX) {
                                                                                                if (PbFragment.this.koh.kwi != null && PbFragment.this.koh.kwi.kxn != null && PbFragment.this.koh.kwi.kxn.getView() != null) {
                                                                                                    if (PbFragment.this.koh.kwi.kxn.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.cMU();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.koh.cPz() != null && PbFragment.this.koh.cPz().bxk() != null) {
                                                                                                            i6 = PbFragment.this.koh.cPz().bxk().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.koh.kwi.kxn.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.koh.cPI() != null) {
                                                                                                z10 = PbFragment.this.koh.cPI().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.koh.kwi != null && PbFragment.this.koh.kwi.kxn != null && PbFragment.this.koh.kwi.kxn.getView() != null && PbFragment.this.koh.kwi.kxn.getView().getParent() != null && PbFragment.this.koh.kuY != null && PbFragment.this.koh.kuY.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.koh.kwi.kxn.getView().getTop() - PbFragment.this.koh.kuY.mNavigationBar.getBottom() < PbFragment.this.koh.kwi.kxn.kux.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || cQl) {
                                                                                                PbFragment.this.knZ = firstVisiblePosition;
                                                                                                PbFragment.this.koa = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.koh.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.koh.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.koh.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.knZ > 0) {
                                                                                                if (PbFragment.this.koh.getListView().getChildAt(PbFragment.this.knZ) != null) {
                                                                                                    PbFragment.this.koh.getListView().smoothScrollToPosition(PbFragment.this.knZ, PbFragment.this.koa, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.koh.getListView().setSelectionFromTop(PbFragment.this.knZ, PbFragment.this.koa + equipmentHeight);
                                                                                                    PbFragment.this.koh.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int cMU = PbFragment.this.cMU();
                                                                                                if (PbFragment.this.cMT() != -1) {
                                                                                                    cMU--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (cMU < 0) {
                                                                                                    i = PbFragment.this.koh.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.x.getCount(PbFragment.this.koh.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = cMU;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!cKX || PbFragment.this.koh.cPz() == null) {
                                                                                                    if (PbFragment.this.koh.kuY != null && PbFragment.this.koh.kuY.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.koh.kuY.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.koh.cPz().cRd();
                                                                                                }
                                                                                                if (PbFragment.this.koh.kwi == null || PbFragment.this.koh.kwi.kxn == null || PbFragment.this.koh.kwi.kxn.getView() == null || PbFragment.this.koh.kwi.kxn.getView().getParent() == null) {
                                                                                                    PbFragment.this.koh.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.koh.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.koh.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.koh.getListView().smoothScrollBy(PbFragment.this.koh.kwi.kxn.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.kkl.getPbData().cKx() != null && PbFragment.this.kkl.getPbData().cKx().aWl() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13402").dn("tid", PbFragment.this.kkl.krf).dn("fid", PbFragment.this.kkl.getPbData().getForumId()).ah("obj_locate", 2).dn("uid", PbFragment.this.kkl.getPbData().cKx().aWl().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().getForum() != null && !com.baidu.tbadk.core.util.as.isEmpty(PbFragment.this.kkl.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.kkl.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.kkl.cLG()) || PbFragment.this.kkl.getAppealInfo() == null) {
                                                                                                PbFragment.this.knE.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.kkl.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.kkl.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.knE.finish();
                                                                                            return;
                                                                                        }
                                                                                        String cLG = PbFragment.this.kkl.cLG();
                                                                                        if (PbFragment.this.kkl.cNO() && cLG != null && cLG.equals(name)) {
                                                                                            PbFragment.this.knE.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.kkl.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ap apVar4 = new com.baidu.tbadk.core.util.ap("c13401");
                                                                                        apVar4.dn("tid", PbFragment.this.kkl.cNL());
                                                                                        apVar4.dn("fid", PbFragment.this.kkl.getForumId());
                                                                                        apVar4.dn("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.kkl.getPbData().cKx() != null) {
                                                                                            apVar4.dn("nid", PbFragment.this.kkl.getPbData().cKx().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(apVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bv) {
                                                                                        bv bvVar = (bv) view.getTag();
                                                                                        if (PbFragment.this.kkl.cOv() == 3 && PbFragment.this.cLF() && PbFragment.this.kkl.getPbData() != null && com.baidu.tbadk.core.util.x.isEmpty(PbFragment.this.kkl.getPbData().cKU())) {
                                                                                            PbFragment.this.knE.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bvVar.aWp(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ap apVar5 = new com.baidu.tbadk.core.util.ap("c13399");
                                                                                        apVar5.dn("tid", bvVar.getId());
                                                                                        apVar5.t("fid", bvVar.getFid());
                                                                                        apVar5.dn("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        apVar5.dn("nid", bvVar.getNid());
                                                                                        TiebaStatic.log(apVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.kkl != null) {
                                                                                        com.baidu.tbadk.core.util.ap apVar6 = new com.baidu.tbadk.core.util.ap("c13398");
                                                                                        apVar6.dn("tid", PbFragment.this.kkl.cNL());
                                                                                        apVar6.dn("fid", PbFragment.this.kkl.getForumId());
                                                                                        apVar6.dn("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        apVar6.ah("obj_locate", 2);
                                                                                        TiebaStatic.log(apVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.kkl.getPbData();
                                                                                        if (PbFragment.this.kog == null) {
                                                                                            PbFragment.this.kog = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.ap("c13446").t("forum_id", j2).baO();
                                                                                        PbFragment.this.registerListener(PbFragment.this.kpi);
                                                                                        PbFragment.this.kog.H(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13274").dn("fid", PbFragment.this.kkl.getForumId()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("obj_name", smartApp.name).t("obj_id", smartApp.swan_app_id.longValue()).dn("obj_source", "PB_card").dn("tid", PbFragment.this.kkl.cNL()).ah("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bv) {
                                                                                        bv bvVar2 = (bv) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bvVar2.aWp(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("common_click").dn("page_type", PageStayDurationConstants.PageName.PB).ah("obj_isad", 1).ah("obj_floor", 1).ah("obj_adlocate", 9).ah("obj_locate", 9).t("obj_id", bvVar2.getFid()).dn("tid", bvVar2.getId()).ah("thread_type", bvVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof bv) && PbFragment.this.checkUpIsLogin()) {
                                                                                        bv bvVar3 = (bv) view.getTag();
                                                                                        if (PbFragment.this.emT != null) {
                                                                                            PbFragment.this.emT.fz(bvVar3.aWp(), String.valueOf(bvVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("common_click").dn("page_type", PageStayDurationConstants.PageName.PB).ah("obj_isad", 1).ah("obj_floor", 1).ah("obj_adlocate", 10).ah("obj_locate", 11).t("obj_id", bvVar3.getFid()).dn("tid", bvVar3.getId()).ah("thread_type", bvVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.kkl.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.kkl.cNL(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.kkl.getPbData().cKx().aWG())));
                                                                        }
                                                                    } else {
                                                                        try {
                                                                            sparseArray = (SparseArray) view.getTag();
                                                                        } catch (ClassCastException e) {
                                                                            e.printStackTrace();
                                                                            sparseArray = null;
                                                                        }
                                                                        PostData postData5 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                        if (postData5 != null) {
                                                                            if (PbFragment.this.kon == null) {
                                                                                PbFragment.this.kon = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.kon.a(PbFragment.this.kpf);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.cLP().getPbData() != null && PbFragment.this.cLP().getPbData().cLa();
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
                                                                                if (postData5.aYc() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData5.aYc().hasAgree && postData5.aXM() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.kon);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData5);
                                                                                    gVar8.mTextView.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kon);
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
                                                                                        gVar9.mTextView.setTag(sparseArray13);
                                                                                        arrayList2.add(gVar9);
                                                                                    } else {
                                                                                        if ((PbFragment.this.sm(z2) && TbadkCoreApplication.isLogin()) && !z11) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kon);
                                                                                            gVar10.mTextView.setTag(str);
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
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kon);
                                                                                            gVar11.mTextView.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kon);
                                                                                        gVar4.mTextView.setTag(sparseArray14);
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
                                                                                            if (PbFragment.this.kkl.getPbData().cKM() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kon);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kon);
                                                                                            }
                                                                                            gVar11.mTextView.setTag(sparseArray15);
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
                                                                                PbFragment.this.kon.aS(arrayList2);
                                                                                PbFragment.this.kom = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kon);
                                                                                PbFragment.this.kom.showDialog();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.koh.cQo();
                                                                    SparseArray<Object> b3 = PbFragment.this.koh.b(PbFragment.this.kkl.getPbData(), PbFragment.this.kkl.cNN(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kkl.getPbData().getForum().getId(), PbFragment.this.kkl.getPbData().getForum().getName(), PbFragment.this.kkl.getPbData().cKx().getId(), String.valueOf(PbFragment.this.kkl.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                    com.baidu.tbadk.core.util.ao.z(true, false);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.SET_NIGHT_MODE).ah("obj_type", 0).ah("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.SET_NIGHT_MODE).ah("obj_type", 1).ah("obj_source", 1));
                                                                }
                                                                PbFragment.this.koh.kuY.cRt();
                                                            }
                                                        } else if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().cKx() != null) {
                                                            PbFragment.this.koh.kuY.aIX();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13062"));
                                                            PbFragment.this.KB(PbFragment.this.kkl.getPbData().cKx().aWC());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.koh.cQo();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.kkl.cOe()));
                                                                return;
                                                            }
                                                            PbFragment.this.cbU();
                                                            PbFragment.this.koh.cPV();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.kkl.getPbData().kho == null || PbFragment.this.kkl.getPbData().kho.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.kkl.getPbData().kho.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.kkl.getPbData().kho.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.kkl.getPbData().kho.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.kkl.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.kkl.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.kkl.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.kkl.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12097").ah("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ah("obj_type", i10));
                                                                    if (PbFragment.this.kkl.getPbData().kho != null && PbFragment.this.kkl.getPbData().kho.size() > i9) {
                                                                        i9 = PbFragment.this.kkl.getPbData().kho.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean BT = PbFragment.this.kkl.BT(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.kkl.cOe()));
                                                                    if (BT) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.koh.sH(true);
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
                                                    PbFragment.this.koh.cQo();
                                                    if (PbFragment.this.cLP().getPbData().khp != 2) {
                                                        if (PbFragment.this.kkl.getPageData() != null) {
                                                            PbFragment.this.koh.a(PbFragment.this.kkl.getPageData(), PbFragment.this.jUP);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.kkl.getPbData()) != null) {
                                                bv cKx = pbData.cKx();
                                                if (cKx != null && cKx.aWl() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13402").dn("tid", PbFragment.this.kkl.krf).dn("fid", pbData.getForumId()).ah("obj_locate", 4).dn("uid", cKx.aWl().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (cKx != null) {
                                                    if (cKx.aUT()) {
                                                        i9 = 2;
                                                    } else if (cKx.aUU()) {
                                                        i9 = 3;
                                                    } else if (cKx.aYg()) {
                                                        i9 = 4;
                                                    } else if (cKx.aYh()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.ap apVar7 = new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                apVar7.dn("tid", PbFragment.this.kkl.cNL());
                                                apVar7.dn("uid", TbadkCoreApplication.getCurrentAccount());
                                                apVar7.dn("fid", PbFragment.this.kkl.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    apVar7.ah("obj_locate", 5);
                                                } else {
                                                    apVar7.ah("obj_locate", 6);
                                                }
                                                apVar7.ah("obj_name", i9);
                                                apVar7.ah("obj_type", 1);
                                                if (cKx != null) {
                                                    if (cKx.aUT()) {
                                                        apVar7.ah("obj_type", 10);
                                                    } else if (cKx.aUU()) {
                                                        apVar7.ah("obj_type", 9);
                                                    } else if (cKx.aYh()) {
                                                        apVar7.ah("obj_type", 8);
                                                    } else if (cKx.aYg()) {
                                                        apVar7.ah("obj_type", 7);
                                                    } else if (cKx.isShareThread) {
                                                        apVar7.ah("obj_type", 6);
                                                    } else if (cKx.threadType == 0) {
                                                        apVar7.ah("obj_type", 1);
                                                    } else if (cKx.threadType == 40) {
                                                        apVar7.ah("obj_type", 2);
                                                    } else if (cKx.threadType == 49) {
                                                        apVar7.ah("obj_type", 3);
                                                    } else if (cKx.threadType == 54) {
                                                        apVar7.ah("obj_type", 4);
                                                    } else {
                                                        apVar7.ah("obj_type", 5);
                                                    }
                                                    apVar7.ah(IntentConfig.CARD_TYPE, cKx.aYk());
                                                    apVar7.dn(IntentConfig.RECOM_SOURCE, cKx.mRecomSource);
                                                    apVar7.dn("ab_tag", cKx.mRecomAbTag);
                                                    apVar7.dn("weight", cKx.mRecomWeight);
                                                    apVar7.dn("extra", cKx.mRecomExtra);
                                                    apVar7.dn("nid", cKx.getNid());
                                                    if (cKx.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.as.isEmpty(cKx.getBaijiahaoData().oriUgcVid)) {
                                                        apVar7.dn("obj_param6", cKx.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    apVar7.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.cNt() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.cNt(), apVar7);
                                                }
                                                TiebaStatic.log(apVar7);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> cKz2 = PbFragment.this.kkl.getPbData().cKz();
                                                    if ((cKz2 != null && cKz2.size() > 0) || !PbFragment.this.kkl.cNN()) {
                                                        PbFragment.this.koh.cQo();
                                                        PbFragment.this.cbU();
                                                        if (pbData.cKT() != null && !StringUtils.isNull(pbData.cKT().aUh(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11678").dn("fid", PbFragment.this.kkl.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), cKx)) {
                                                            if (PbFragment.this.koh != null) {
                                                                PbFragment.this.koh.cQr();
                                                                PbFragment.this.koh.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.koh.showLoadingDialog();
                                                                PbFragment.this.kkl.cOq().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i10 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i10 = 1;
                                                                }
                                                                PbFragment.this.BK(i10);
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
                                            PbFragment.this.koh.cQo();
                                            if (PbFragment.this.koh.kuY.cRu() != null && view == PbFragment.this.koh.kuY.cRu().cOW() && !PbFragment.this.koh.cQH()) {
                                                PbFragment.this.koh.cPA();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cbU();
                                                PbFragment.this.koh.cPV();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    y = PbFragment.this.kkl.y(true, PbFragment.this.cNc());
                                                } else {
                                                    y = view.getId() == R.id.reply_title ? PbFragment.this.kkl.y(false, PbFragment.this.cNc()) : PbFragment.this.kkl.KG(PbFragment.this.cNc());
                                                }
                                                view.setTag(Boolean.valueOf(y));
                                                if (y) {
                                                    PbFragment.this.koh.sf(true);
                                                    PbFragment.this.koh.cvF();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.koh.sH(true);
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
                                        PbFragment.this.koh.cQo();
                                        if (PbFragment.this.BJ(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.kkl.BU(PbFragment.this.koh.cQa()) != null) {
                                            PbFragment.this.cMX();
                                            if (PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().cKx() != null && PbFragment.this.kkl.getPbData().cKx().aWl() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13402").dn("tid", PbFragment.this.kkl.krf).dn("fid", PbFragment.this.kkl.getPbData().getForumId()).ah("obj_locate", 3).dn("uid", PbFragment.this.kkl.getPbData().cKx().aWl().getUserId()));
                                            }
                                            if (PbFragment.this.kkl.getPbData().cKx() != null && PbFragment.this.kkl.getPbData().cKx().aWl() != null && PbFragment.this.kkl.getPbData().cKx().aWl().getUserId() != null && PbFragment.this.kof != null) {
                                                int h = PbFragment.this.h(PbFragment.this.kkl.getPbData());
                                                bv cKx2 = PbFragment.this.kkl.getPbData().cKx();
                                                int i11 = 1;
                                                if (cKx2.aUT()) {
                                                    i11 = 2;
                                                } else if (cKx2.aUU()) {
                                                    i11 = 3;
                                                } else if (cKx2.aYg()) {
                                                    i11 = 4;
                                                } else if (cKx2.aYh()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12526").dn("tid", PbFragment.this.kkl.krf).ah("obj_locate", 1).dn("obj_id", PbFragment.this.kkl.getPbData().cKx().aWl().getUserId()).ah("obj_type", PbFragment.this.kof.aSj() ? 0 : 1).ah("obj_source", h).ah("obj_param1", i11));
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
                                    if (PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().cKx() != null && PbFragment.this.kkl.getPbData().cKx().aUR() && PbFragment.this.kkl.getPbData().cKx().aWD() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11922"));
                                    }
                                    if (PbFragment.this.kkl.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.kkl.cLG()) || PbFragment.this.kkl.getAppealInfo() == null) {
                                            PbFragment.this.knE.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.kkl.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.kkl.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.knE.finish();
                                        return;
                                    }
                                    String cLG2 = PbFragment.this.kkl.cLG();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.kkl.cNO() && cLG2 != null && cLG2.equals(name2)) {
                                        PbFragment.this.knE.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.kkl.getPbData() != null) {
                                    if ((PbFragment.this.kkl.getPbData().cKM() == 1 || PbFragment.this.kkl.getPbData().cKM() == 3) && !PbFragment.this.gXC.dlV()) {
                                        PbFragment.this.koh.cQo();
                                        int i12 = 0;
                                        if (PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cOX()) {
                                            if (PbFragment.this.koh.kuY.cRu() == null || view != PbFragment.this.koh.kuY.cRu().cOZ()) {
                                                if (view == PbFragment.this.koh.cPT()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.kkl.getPbData().cKx().aWh() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.kkl.getPbData().cKx().aWg() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.kkl.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.kkl.getPbData().cKx().getId();
                                        PbFragment.this.koh.cPS();
                                        PbFragment.this.gXC.b(id4, name3, id5, i12, PbFragment.this.koh.cPU());
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
                            PbFragment.this.koh.kuY.cRt();
                            if (PbFragment.this.kkl != null) {
                                PbFragment.this.gXE.setThreadId(PbFragment.this.kkl.cNL());
                            }
                            int i13 = 1;
                            if (PbFragment.this.kkl == null || !PbFragment.this.kkl.isPrivacy()) {
                                PbFragment.this.gXE.bRh();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.cLP() != null && PbFragment.this.cLP().getPbData() != null && PbFragment.this.cLP().getPbData().getThreadId() != null && PbFragment.this.cLP().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.cLP() != null && PbFragment.this.cLP().getPbData() != null) {
                                    PbFragment.this.gXE.j(3, i13, PbFragment.this.cLP().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.cLP() != null && PbFragment.this.cLP().getPbData() != null) {
                                    PbFragment.this.gXE.j(3, 3, PbFragment.this.cLP().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.koh.cQo();
                        PbFragment.this.cbU();
                        PbFragment.this.koh.cPV();
                        PbFragment.this.koh.showLoadingDialog();
                        if (PbFragment.this.koh.cPI() != null) {
                            PbFragment.this.koh.cPI().setVisibility(8);
                        }
                        PbFragment.this.kkl.BO(1);
                        if (PbFragment.this.knG != null) {
                            PbFragment.this.knG.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cMM = PbFragment.this.cMM();
                        if (!TextUtils.isEmpty(cMM)) {
                            com.baidu.tbadk.core.util.bd.baV().b(PbFragment.this.getPageContext(), new String[]{cMM});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ap apVar8 = new com.baidu.tbadk.core.util.ap("c13398");
                apVar8.dn("tid", PbFragment.this.kkl.cNL());
                apVar8.dn("fid", PbFragment.this.kkl.getForumId());
                apVar8.dn("uid", TbadkCoreApplication.getCurrentAccount());
                apVar8.ah("obj_locate", 1);
                TiebaStatic.log(apVar8);
                if (PbFragment.this.knP) {
                    PbFragment.this.knP = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData6 = (PostData) obj;
                        if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.cMF().cPx() != null && postData6.aWl() != null && postData6.dli() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cMF().cPy() != null) {
                                PbFragment.this.cMF().cPy().cMv();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.kkl.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.kkl.getPbData().cKx());
                            pVar2.g(postData6);
                            PbFragment.this.cMF().cPx().d(pVar2);
                            PbFragment.this.cMF().cPx().setPostId(postData6.getId());
                            PbFragment.this.a(view, postData6.aWl().getUserId(), "", postData6);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kkl.getPbData(), postData6, postData6.locate, 8, 1);
                            if (PbFragment.this.kou != null) {
                                PbFragment.this.koh.sR(PbFragment.this.kou.bjs());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ad adVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13268");
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kkl.getPbData() != null) {
                    apVar.dn("fid", PbFragment.this.kkl.getPbData().getForumId());
                }
                apVar.dn("tid", PbFragment.this.kkl.cNL());
                apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(apVar);
            }
            PbFragment.this.cbU();
            PbFragment.this.koh.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.cLP() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.cLP().KJ(postWriteCallBackData.getPostId());
                    PbFragment.this.koH = PbFragment.this.koh.cPE();
                    PbFragment.this.kkl.cM(PbFragment.this.koH, PbFragment.this.koh.cPF());
                }
                PbFragment.this.koh.cQo();
                PbFragment.this.kol.cQN();
                if (PbFragment.this.kou != null) {
                    PbFragment.this.koh.sR(PbFragment.this.kou.bjs());
                }
                PbFragment.this.koh.cPw();
                PbFragment.this.koh.sT(true);
                PbFragment.this.kkl.cOg();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.kkl.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.kkl.getPbData();
                            if (pbData != null && pbData.cKx() != null && pbData.cKx().aWl() != null && (userId = pbData.cKx().aWl().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.kkl.cNX()) {
                                PbFragment.this.koh.cPV();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.kkl.cNX()) {
                            PbFragment.this.koh.cPV();
                        }
                    } else if (floor != null) {
                        PbFragment.this.koh.s(PbFragment.this.kkl.getPbData());
                    }
                    if (PbFragment.this.kkl.cNR()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10369").dn("tid", PbFragment.this.kkl.cNL()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.sl(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.kou.bjz() || PbFragment.this.kou.bjA()) {
                    PbFragment.this.kou.a(false, postWriteCallBackData);
                }
                PbFragment.this.kol.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.jqz != null) {
                    PbFragment.this.jqz.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.as.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.as.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.xl(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.xl(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13746").ah("obj_locate", 1).ah("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).aYL();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13745").ah("obj_locate", 1).ah("obj_type", 2));
            } else if (adVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d kph = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ad adVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13268");
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                    apVar.dn("fid", PbFragment.this.kkl.getPbData().getForumId());
                }
                if (PbFragment.this.kkl != null) {
                    apVar.dn("tid", PbFragment.this.kkl.cNL());
                }
                apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(apVar);
            }
            if (z) {
                if (PbFragment.this.kol != null) {
                    PbFragment.this.kol.cQM();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.jqz != null) {
                    PbFragment.this.jqz.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.as.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.as.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.xl(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.xl(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13746").ah("obj_locate", 1).ah("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).aYL();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13745").ah("obj_locate", 1).ah("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kol != null) {
                if (PbFragment.this.koh != null && PbFragment.this.koh.cPy() != null && PbFragment.this.koh.cPy().cMz() != null && PbFragment.this.koh.cPy().cMz().bjA()) {
                    PbFragment.this.koh.cPy().cMz().a(postWriteCallBackData);
                }
                PbFragment.this.kol.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a kpi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cQK;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.knE.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.koh != null && (cQK = PbFragment.this.koh.cQK()) != null && PbFragment.this.koh.getListView() != null) {
                            PbFragment.this.koh.getListView().removeHeaderView(cQK);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a kpj = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.g nQ;
            if (!z || fVar == null || fVar.cKK() != null || com.baidu.tbadk.core.util.x.getCount(fVar.cKz()) >= 1) {
                PbFragment.this.jJI = true;
                PbFragment.this.koh.cPX();
                if (fVar == null || !fVar.cKF()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.koh.getView());
                }
                PbFragment.this.koh.cvE();
                if (PbFragment.this.isFullScreen || PbFragment.this.koh.cQH()) {
                    PbFragment.this.koh.cQy();
                } else if (!PbFragment.this.koh.cQv()) {
                    PbFragment.this.koh.sT(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.fhJ = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.koh.getView());
                    PbFragment.this.koh.cQg();
                }
                if (z && fVar != null) {
                    bv cKx = fVar.cKx();
                    if (cKx == null || !cKx.aUV()) {
                        PbFragment.this.d(PbFragment.this.kot);
                    } else {
                        cNv();
                    }
                    PbFragment.this.koh.cPy().setPbData(fVar);
                    PbFragment.this.koh.bBY();
                    if (cKx != null && cKx.aXw() != null) {
                        PbFragment.this.a(cKx.aXw());
                    }
                    if (PbFragment.this.kou != null) {
                        PbFragment.this.koh.sR(PbFragment.this.kou.bjs());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.cKz() != null && fVar.cKz().size() >= 1 && fVar.cKz().get(0) != null) {
                        PbFragment.this.kkl.KI(fVar.cKz().get(0).getId());
                    } else if (fVar.cKK() != null) {
                        PbFragment.this.kkl.KI(fVar.cKK().getId());
                    }
                    if (PbFragment.this.kou != null) {
                        PbFragment.this.kou.a(fVar.getAnti());
                        PbFragment.this.kou.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.kou.setThreadData(cKx);
                        PbFragment.this.kou.a(PbFragment.this.kkl.cOb(), PbFragment.this.kkl.cNL(), PbFragment.this.kkl.cOs());
                        if (cKx != null) {
                            PbFragment.this.kou.iQ(cKx.aXI());
                        }
                    }
                    if (PbFragment.this.kof != null) {
                        PbFragment.this.kof.he(fVar.aSj());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.cLa()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.koh.sS(PbFragment.this.mIsFromCDN);
                    PbFragment.this.koh.a(fVar, i2, i3, PbFragment.this.kkl.cNN(), i4, PbFragment.this.kkl.getIsFromMark());
                    PbFragment.this.koh.d(fVar, PbFragment.this.kkl.cNN());
                    PbFragment.this.koh.sP(PbFragment.this.kkl.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.eBU = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.eBU) && PbFragment.this.kou != null && PbFragment.this.kou.biJ() != null && (nQ = PbFragment.this.kou.biJ().nQ(6)) != null && !TextUtils.isEmpty(PbFragment.this.eBU)) {
                            ((View) nQ).setOnClickListener(PbFragment.this.eCG);
                        }
                    }
                    if (PbFragment.this.kop) {
                        PbFragment.this.kop = false;
                        final int cMT = PbFragment.this.cMT();
                        if (!fVar.cKX()) {
                            PbFragment.this.koh.Cb(cMT);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cMT, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.koq) {
                        PbFragment.this.koq = false;
                        final int cMT2 = PbFragment.this.cMT();
                        final boolean z2 = cMT2 != -1;
                        if (!z2) {
                            cMT2 = PbFragment.this.cMU();
                        }
                        if (PbFragment.this.koh != null) {
                            if (!fVar.cKX()) {
                                PbFragment.this.koh.Cb(cMT2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cMT2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.koh.setSelectionFromTop(cMT2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.koh.setSelectionFromTop(cMT2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.koh.sU(true);
                                PbFragment.this.koh.sT(false);
                            }
                        }
                    } else if (PbFragment.this.kor) {
                        PbFragment.this.kor = false;
                        PbFragment.this.koh.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.koh.cQb();
                    }
                    PbFragment.this.kkl.a(fVar.getForum(), PbFragment.this.koV);
                    PbFragment.this.kkl.a(PbFragment.this.koW);
                    if (PbFragment.this.jqz != null && cKx != null && cKx.aWl() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cKx.aWl());
                        PbFragment.this.jqz.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.fhJ && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.kkl.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.kkl.getAppealInfo().khg)) {
                                    PbFragment.this.koh.a(PbFragment.this.kkl.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.koh.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.koh.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.koh.cQy();
                            PbFragment.this.koh.cQf();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.kkl.cNL());
                            jSONObject.put("fid", PbFragment.this.kkl.getForumId());
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
                        PbFragment.this.koh.KO("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                            arrayList = PbFragment.this.kkl.getPbData().cKz();
                        }
                        if (com.baidu.tbadk.core.util.x.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.x.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dli() != 1)) {
                            PbFragment.this.koh.KO(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.cNn()) {
                                PbFragment.this.koh.KP(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.koh.KP(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.koh.s(PbFragment.this.kkl.getPbData());
                        }
                    }
                    PbFragment.this.koh.endLoadData();
                }
                if (fVar != null && fVar.khv && PbFragment.this.eHn == 0) {
                    PbFragment.this.eHn = System.currentTimeMillis() - PbFragment.this.hio;
                }
                if (!PbFragment.this.cLP().cNN() || PbFragment.this.cLP().getPbData().getPage().aVc() != 0 || PbFragment.this.cLP().cOn()) {
                    PbFragment.this.kov = true;
                    return;
                }
                return;
            }
            PbFragment.this.kkl.BO(1);
            if (PbFragment.this.knG != null) {
                PbFragment.this.knG.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cNv() {
            if (PbFragment.this.kkl != null) {
                if (PbFragment.this.kou == null || !PbFragment.this.kou.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.kou = (com.baidu.tbadk.editortools.pb.e) dVar.dT(PbFragment.this.getContext());
                    PbFragment.this.kou.a(PbFragment.this.knE.getPageContext());
                    PbFragment.this.kou.a(PbFragment.this.eCe);
                    PbFragment.this.kou.a(PbFragment.this.eBX);
                    PbFragment.this.kou.a(PbFragment.this.knE.getPageContext(), PbFragment.this.knE.getIntent() == null ? null : PbFragment.this.knE.getIntent().getExtras());
                    PbFragment.this.kou.biJ().iJ(true);
                    PbFragment.this.koh.setEditorTools(PbFragment.this.kou.biJ());
                    if (!PbFragment.this.kkl.cNS()) {
                        PbFragment.this.kou.zI(PbFragment.this.kkl.cNL());
                    }
                    if (PbFragment.this.kkl.cOt()) {
                        PbFragment.this.kou.zG(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.koh != null) {
                        PbFragment.this.kou.zG(PbFragment.this.koh.cPC());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.koh.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.blA().blB()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.hio : j;
                if (PbFragment.this.eHn == 0) {
                    PbFragment.this.eHn = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.eHd, PbFragment.this.createTime, PbFragment.this.eHn, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.eHd = 0L;
                if (iVar != null) {
                    iVar.blx();
                }
                if (z2) {
                    iVar.eHw = currentTimeMillis;
                    iVar.jc(true);
                }
                if (!z2 && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().cKx() != null) {
                    int threadType = PbFragment.this.kkl.getPbData().cKx().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.as.equals(PbFragment.this.knS, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.as.equals(PbFragment.this.knS, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.eHy = currentTimeMillis;
                                iVar2.op(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.eHy = currentTimeMillis;
                        dVar.op(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener kpk = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cMP();
            }
        }
    };
    private final a.InterfaceC0489a kpl = new a.InterfaceC0489a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0489a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.koh.cPX();
            if (z) {
                if (PbFragment.this.kof != null) {
                    PbFragment.this.kof.he(z2);
                }
                PbFragment.this.kkl.sy(z2);
                if (PbFragment.this.kkl.aSj()) {
                    PbFragment.this.cMY();
                } else {
                    PbFragment.this.koh.s(PbFragment.this.kkl.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.kof != null) {
                        if (PbFragment.this.kof.aSm() != null && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.kkl.getPbData().cKx() != null && PbFragment.this.kkl.getPbData().cKx().aWl() != null) {
                            MarkData aSm = PbFragment.this.kof.aSm();
                            MetaData aWl = PbFragment.this.kkl.getPbData().cKx().aWl();
                            if (aSm != null && aWl != null) {
                                if (!com.baidu.tbadk.core.util.as.equals(TbadkCoreApplication.getCurrentAccount(), aWl.getUserId()) && !aWl.hadConcerned()) {
                                    PbFragment.this.b(aWl);
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
                    PbFragment.this.cMV();
                    return;
                }
                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbFragment.this.BA(PbFragment.this.mLastScrollState) && PbFragment.this.BA(i)) {
                if (PbFragment.this.koh != null) {
                    PbFragment.this.koh.cQo();
                    if (PbFragment.this.kou != null && !PbFragment.this.koh.cPB()) {
                        PbFragment.this.koh.sR(PbFragment.this.kou.bjs());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.koh.cPA();
                    }
                }
                if (!PbFragment.this.knM) {
                    PbFragment.this.knM = true;
                    if (PbFragment.this.koh != null) {
                        PbFragment.this.koh.cQu();
                    }
                }
            }
            if (PbFragment.this.koh != null) {
                PbFragment.this.koh.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.knG != null) {
                PbFragment.this.knG.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.knN == null) {
                PbFragment.this.knN = new com.baidu.tbadk.n.b();
                PbFragment.this.knN.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.knN.blr();
            } else {
                PbFragment.this.knN.blq();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dkh().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cKz;
            if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null && PbFragment.this.koh != null && PbFragment.this.koh.cPR() != null) {
                PbFragment.this.koh.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.knG != null) {
                    PbFragment.this.knG.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.kkl.cOj() && (cKz = PbFragment.this.kkl.getPbData().cKz()) != null && !cKz.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.koh.cPR().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.kkl.getPbData();
                    if (pbData != null) {
                        if (pbData.cKA() != null && pbData.cKA().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cKB() != null && pbData.cKB().hasData()) {
                            headerCount--;
                        }
                        int size = cKz.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d gXJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.gXC.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.kkl.cOg();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.kDh != 1002 || bVar.fVs) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.koh.a(1, dVar.Pv, dVar.lPQ, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.gXC.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.koh.a(PbFragment.this.gXC.getLoadDataMode(), gVar.Pv, gVar.lPQ, false);
                            PbFragment.this.koh.aR(gVar.lPT);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.koh.a(PbFragment.this.gXC.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c kpm = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
    };
    private final f.c ffu = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cNd()) {
                PbFragment.this.knE.finish();
            }
            if (!PbFragment.this.kkl.sx(true)) {
                PbFragment.this.koh.cPY();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e kpo = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.kpn && PbFragment.this.cNd()) {
                PbFragment.this.cNf();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.kkl.sw(false)) {
                    PbFragment.this.koh.cPW();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.kkl.getPbData() != null) {
                    PbFragment.this.koh.cQt();
                }
                PbFragment.this.kpn = true;
            }
        }
    };
    private int kpp = 0;
    private final TbRichTextView.i eRR = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
        /* JADX DEBUG: Multi-variable search result rejected for r6v10, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g cPR;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.koh.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13398");
                apVar.dn("tid", PbFragment.this.kkl.cNL());
                apVar.dn("fid", PbFragment.this.kkl.getForumId());
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                apVar.ah("obj_locate", 3);
                apVar.ah("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(apVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.kkl.kli.cLa()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().boK() != null) {
                            ArrayList<TbRichTextImageInfo> boK = tbRichTextView.getRichText().boK();
                            int i4 = 0;
                            while (i4 < boK.size()) {
                                if (boK.get(i4) != null) {
                                    arrayList.add(boK.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(boK.get(i4).getSrc()) || str.equals(boK.get(i4).bpe()) || str.equals(boK.get(i4).bpb()) || str.equals(boK.get(i4).bpd()) || str.equals(boK.get(i4).bph()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = boK.get(i4).getSrc();
                                    imageUrlData.originalUrl = boK.get(i4).getSrc();
                                    imageUrlData.isLongPic = boK.get(i4).bpj();
                                    concurrentHashMap.put(boK.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.s(arrayList).kG(i3).hl(false).hm(PbFragment.this.kkl.cOd()).a(concurrentHashMap).hn(true).ho(false).hp(z).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                            aVar.r(PbFragment.this.kkl.getPbData().cKx());
                        }
                        ImageViewerConfig dI = aVar.dI(PbFragment.this.getPageContext().getPageActivity());
                        dI.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.kku) {
                        TbRichText br = PbFragment.this.br(str, i);
                        if (br != null && PbFragment.this.kpp >= 0 && PbFragment.this.kpp < br.boJ().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(br.boJ().get(PbFragment.this.kpp));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.kkt.size()) {
                                    break;
                                } else if (!aVar2.kkt.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (br.getPostId() != 0 && (cPR = PbFragment.this.koh.cPR()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = cPR.getDataList();
                                if (com.baidu.tbadk.core.util.x.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && br.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (br.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.kkl.cOs(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kkl.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.dLG.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.s(arrayList2).wE(aVar2.forumName).wF(aVar2.forumId).wG(aVar2.threadId).hl(aVar2.dLE).hn(true).wH(aVar2.lastId).hm(PbFragment.this.kkl.cOd()).a(concurrentHashMap2).ho(false).hp(z).wI(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                aVar3.r(PbFragment.this.kkl.getPbData().cKx());
                            }
                            ImageViewerConfig dI2 = aVar3.dI(PbFragment.this.getPageContext().getPageActivity());
                            dI2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.x.getItem(aVar2.kkt, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.dLG.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.s(arrayList3).wE(aVar2.forumName).wF(aVar2.forumId).wG(aVar2.threadId).hl(aVar2.dLE).hn(true).wH(aVar2.kkt.get(0)).hm(PbFragment.this.kkl.cOd()).a(concurrentHashMap3).ho(false).hp(z).wI(aVar2.postId).hq(false);
                    if (PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                        aVar4.r(PbFragment.this.kkl.getPbData().cKx());
                    }
                    ImageViewerConfig dI3 = aVar4.dI(PbFragment.this.getPageContext().getPageActivity());
                    dI3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.knW = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean kpq = false;
    PostData iFI = null;
    private final b.InterfaceC0492b kpr = new b.InterfaceC0492b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iFI != null) {
                if (i == 0) {
                    PbFragment.this.iFI.fs(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.iFI = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.iFI);
                }
            }
        }
    };
    private final b.InterfaceC0492b kps = new b.InterfaceC0492b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.koE != null && !TextUtils.isEmpty(PbFragment.this.koF)) {
                if (i == 0) {
                    if (PbFragment.this.koG == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.koF));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.koF;
                        aVar.pkgId = PbFragment.this.koG.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.koG.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.dKK == null) {
                            PbFragment.this.dKK = new bd(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.dKK.j(PbFragment.this.koF, PbFragment.this.koE.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.koE = null;
                PbFragment.this.koF = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c7 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0214  */
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
            if (PbFragment.this.isAdded()) {
                if (PbFragment.this.koh != null) {
                    if (!PbFragment.this.koh.cNE()) {
                        PbFragment.this.koh.cQL();
                    } else {
                        return true;
                    }
                }
                SparseArray sparseArray2 = null;
                try {
                    sparseArray2 = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray2 == null) {
                    if (PbFragment.this.cK(view)) {
                        if (view instanceof TbImageView) {
                            PbFragment.this.koE = ((TbImageView) view).getBdImage();
                            PbFragment.this.koF = ((TbImageView) view).getUrl();
                            if (PbFragment.this.koE == null || TextUtils.isEmpty(PbFragment.this.koF)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.koG = null;
                            } else {
                                PbFragment.this.koG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else if (view instanceof GifView) {
                            if (((GifView) view).getBdImage() != null) {
                                PbFragment.this.koE = ((GifView) view).getBdImage();
                                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                    PbFragment.this.koF = ((GifView) view).getBdImage().getUrl();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    PbFragment.this.koG = null;
                                } else {
                                    PbFragment.this.koG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                }
                            } else {
                                return true;
                            }
                        } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                            PbFragment.this.koE = ((TbMemeImageView) view).getBdImage();
                            if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                                PbFragment.this.koF = ((TbMemeImageView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.koG = null;
                            } else {
                                PbFragment.this.koG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                            PbFragment.this.koh.a(PbFragment.this.kps, PbFragment.this.koE.isGif());
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
                PbFragment.this.iFI = (PostData) sparseArray2.get(R.id.tag_clip_board);
                if (PbFragment.this.iFI == null) {
                    return true;
                }
                if (PbFragment.this.iFI.dli() != 1 || !PbFragment.this.cK(view)) {
                    if (PbFragment.this.kof != null) {
                        if (!PbFragment.this.kof.aSj() || PbFragment.this.iFI.getId() == null || !PbFragment.this.iFI.getId().equals(PbFragment.this.kkl.aWt())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        boolean z3 = PbFragment.this.cLP().getPbData() != null && PbFragment.this.cLP().getPbData().cLa();
                        if (PbFragment.this.iFI.dli() != 1) {
                            if (PbFragment.this.kon == null) {
                                PbFragment.this.kon = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                PbFragment.this.kon.a(PbFragment.this.kpf);
                            }
                            ArrayList arrayList = new ArrayList();
                            if (view != null && sparseArray2 != null) {
                                boolean z4 = PbFragment.this.cK(view) && !z3;
                                boolean z5 = (!PbFragment.this.cK(view) || PbFragment.this.koE == null || PbFragment.this.koE.isGif()) ? false : true;
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
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.kon));
                                }
                                if (z5) {
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.kon));
                                }
                                if (!z4 && !z5) {
                                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kon);
                                    SparseArray sparseArray3 = new SparseArray();
                                    sparseArray3.put(R.id.tag_clip_board, PbFragment.this.iFI);
                                    gVar3.mTextView.setTag(sparseArray3);
                                    arrayList.add(gVar3);
                                }
                                if (!z2 && !z3) {
                                    if (z) {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kon);
                                    } else {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kon);
                                    }
                                    SparseArray sparseArray4 = new SparseArray();
                                    sparseArray4.put(R.id.tag_clip_board, PbFragment.this.iFI);
                                    sparseArray4.put(R.id.tag_is_subpb, false);
                                    gVar2.mTextView.setTag(sparseArray4);
                                    arrayList.add(gVar2);
                                }
                                if (PbFragment.this.mIsLogin && !PbFragment.this.klG) {
                                    if (!z8 && z7) {
                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kon);
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
                                        if ((PbFragment.this.sm(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kon);
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
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kon);
                                            gVar6.mTextView.setTag(sparseArray6);
                                        } else {
                                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                                        }
                                        gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kon);
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
                                            if (PbFragment.this.kkl.getPbData().cKM() == 1002 && !z6) {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kon);
                                            } else {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kon);
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
                                PbFragment.this.kon.aS(arrayList);
                                PbFragment.this.kom = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kon);
                                PbFragment.this.kom.showDialog();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13272").dn("tid", PbFragment.this.kkl.krf).dn("fid", PbFragment.this.kkl.getForumId()).dn("uid", PbFragment.this.kkl.getPbData().cKx().aWl().getUserId()).dn("post_id", PbFragment.this.kkl.bjg()).ah("obj_source", z2 ? 2 : 1));
                            }
                            return true;
                        }
                        if (!z3) {
                            PbFragment.this.koh.a(PbFragment.this.kpr, z, false);
                        }
                        return true;
                    }
                    return true;
                }
                PbFragment.this.koh.a(PbFragment.this.kps, PbFragment.this.koE.isGif());
                return true;
            }
            return true;
        }
    };
    private final NoNetworkView.a hCK = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bjZ && z && !PbFragment.this.kkl.cNT()) {
                PbFragment.this.cNa();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener eKY = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.hKk.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0623a heG = new a.InterfaceC0623a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        final int fUW = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void D(int i, int i2) {
            if (af(i2) && PbFragment.this.koh != null && PbFragment.this.knG != null) {
                PbFragment.this.knG.nV(true);
                if (Math.abs(i2) > this.fUW) {
                    PbFragment.this.knG.hideFloatingView();
                }
                if (PbFragment.this.cNd()) {
                    PbFragment.this.koh.cPO();
                    PbFragment.this.koh.cPP();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void E(int i, int i2) {
            if (af(i2) && PbFragment.this.koh != null && PbFragment.this.knG != null) {
                PbFragment.this.koh.cQz();
                PbFragment.this.knG.nV(false);
                PbFragment.this.knG.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void bR(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void F(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final q.a kmH = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void n(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.koh.KQ(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int kpu = -1;
    private int kpv = -1;

    /* loaded from: classes16.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes16.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes16.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e cMA() {
        return this.kou;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        MetaData metaData;
        boolean z = true;
        if (pVar.cLt() != null) {
            String id = pVar.cLt().getId();
            ArrayList<PostData> cKz = this.kkl.getPbData().cKz();
            int i = 0;
            while (true) {
                if (i >= cKz.size()) {
                    break;
                }
                PostData postData = cKz.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cLx = pVar.cLx();
                    postData.Fr(pVar.getTotalCount());
                    if (postData.dlf() != null && cLx != null) {
                        Iterator<PostData> it = cLx.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aWl() != null && (metaData = postData.getUserMap().get(next.aWl().getUserId())) != null) {
                                next.a(metaData);
                                next.vn(true);
                                next.a(getPageContext(), this.kkl.KH(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cLx.size() != postData.dlf().size();
                        postData.dlf().clear();
                        postData.dlf().addAll(cLx);
                        z = z2;
                    }
                    if (postData.dlb() != null) {
                        postData.dlc();
                    }
                }
            }
            if (!this.kkl.getIsFromMark() && z) {
                this.koh.s(this.kkl.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kz(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n cKP = this.kkl.getPbData().cKP();
            if (cKP != null && str.equals(cKP.getAdId())) {
                if (cKP.dkW() != null) {
                    cKP.dkW().legoCard = null;
                }
                this.kkl.getPbData().cKQ();
            }
            com.baidu.tieba.tbadkCore.data.n cNZ = this.kkl.cNZ();
            if (cNZ != null && str.equals(cNZ.getAdId())) {
                this.kkl.cOa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kom != null && this.kom.isShowing()) {
                this.kom.dismiss();
                this.kom = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.kom != null) {
                            PbFragment.this.kom.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.koh.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.koC);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.koC);
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
                kVar.aS(arrayList);
                this.kom = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.kom.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(int i) {
        bv cKx;
        if (this.kkl != null && this.kkl.getPbData() != null && (cKx = this.kkl.getPbData().cKx()) != null) {
            if (i == 1) {
                PraiseData aVW = cKx.aVW();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aVW == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cKx.a(praiseData);
                    } else {
                        cKx.aVW().getUser().add(0, metaData);
                        cKx.aVW().setNum(cKx.aVW().getNum() + 1);
                        cKx.aVW().setIsLike(i);
                    }
                }
                if (cKx.aVW() != null) {
                    if (cKx.aVW().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.as.numFormatOver10000(cKx.aVW().getNum());
                    }
                }
            } else if (cKx.aVW() != null) {
                cKx.aVW().setIsLike(i);
                cKx.aVW().setNum(cKx.aVW().getNum() - 1);
                ArrayList<MetaData> user = cKx.aVW().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cKx.aVW().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cKx.aVW().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cKx.aVW().getNum() + "";
                }
            }
            if (this.kkl.cNN()) {
                this.koh.cPR().notifyDataSetChanged();
            } else {
                this.koh.t(this.kkl.getPbData());
            }
        }
    }

    public static PbFragment cMB() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.knE = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kkl.aD(bundle);
        if (this.hFy != null) {
            this.hFy.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.kou.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.knL = System.currentTimeMillis();
        this.koA = getPageContext();
        final Intent intent = this.knE.getIntent();
        if (intent != null) {
            this.hio = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.knS = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.knS)) {
                    this.knS = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.knS)) {
                this.knH = true;
            }
            this.kpu = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.kpv = intent.getIntExtra("key_manga_next_chapter", -1);
            this.kpw = intent.getStringExtra("key_manga_title");
            this.kop = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.koq = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.kor = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cNd()) {
                this.knE.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.as.isEmpty(this.source) ? "" : this.source;
            this.koI = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.kob = new com.baidu.tbadk.core.data.be();
            this.kob.A(intent);
            this.koK = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.koK == 0) {
                this.koK = intent.getIntExtra("key_start_from", 0);
            }
            this.koL = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.hio = System.currentTimeMillis();
        }
        this.eHd = this.knL - this.hio;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.knJ = 0;
        aC(bundle);
        if (this.kkl.getPbData() != null) {
            this.kkl.getPbData().Ks(this.source);
        }
        cME();
        if (intent != null && this.koh != null) {
            this.koh.kuW = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.koD == null) {
                    this.koD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.koh.KS(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(this.koD, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.kkl.getPbData() != null) {
                this.kkl.KK(stringExtra);
            }
        }
        this.hFy = new VoiceManager();
        this.hFy.onCreate(getPageContext());
        initData(bundle);
        this.kot = new com.baidu.tbadk.editortools.pb.g();
        d(this.kot);
        this.kou = (com.baidu.tbadk.editortools.pb.e) this.kot.dT(getActivity());
        this.kou.a(this.knE.getPageContext());
        this.kou.a(this.eCe);
        this.kou.a(this.eBX);
        this.kou.a(this.knE.getPageContext(), bundle);
        this.kou.biJ().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.kou.biJ().iJ(true);
        sk(true);
        this.kou.a(this.kkl.cOb(), this.kkl.cNL(), this.kkl.cOs());
        registerListener(this.koQ);
        if (!this.kkl.cNS()) {
            this.kou.zI(this.kkl.cNL());
        }
        if (this.kkl.cOt()) {
            this.kou.zG(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.koh != null) {
            this.kou.zG(this.koh.cPC());
        }
        registerListener(this.koP);
        registerListener(this.koR);
        registerListener(this.koS);
        registerListener(this.hHe);
        registerListener(this.kpe);
        registerListener(this.koO);
        this.kos = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.lMD);
        this.kos.dkO();
        registerListener(this.koT);
        registerListener(this.eaY);
        this.kkl.cOl();
        registerListener(this.kpk);
        registerListener(this.hHm);
        if (this.koh != null && this.koh.cQD() != null && this.koh.cQE() != null) {
            this.knG = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.koh.cQD(), this.koh.cQE(), this.koh.cPI());
            this.knG.a(this.koZ);
        }
        if (this.knF && this.koh != null && this.koh.cQE() != null) {
            this.koh.cQE().setVisibility(8);
        }
        this.koB = new com.baidu.tbadk.core.view.c();
        this.koB.toastTime = 1000L;
        registerListener(this.kpd);
        registerListener(this.kpb);
        registerListener(this.kpc);
        registerListener(this.hYZ);
        registerListener(this.hHa);
        this.koU.setSelfListener(true);
        this.koU.setTag(this.knE.getUniqueId());
        this.koU.setPriority(-1);
        MessageManager.getInstance().registerListener(this.koU);
        registerResponsedEventListener(TipEvent.class, this.hEE);
        this.koC = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.koC;
        userMuteAddAndDelCustomMessage.setTag(this.koC);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.koC;
        userMuteCheckCustomMessage.setTag(this.koC);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kkl.cOq().a(this.kpa);
        this.kol = new bb();
        if (this.kou.bjk() != null) {
            this.kol.e(this.kou.bjk().getInputView());
        }
        this.kou.a(this.eBY);
        this.hXO = new ShareSuccessReplyToServerModel();
        a(this.koM);
        this.jqz = new com.baidu.tbadk.core.util.al(getPageContext());
        this.jqz.a(new al.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.al.eaP) {
                        PbFragment.this.kou.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.al.eaQ && PbFragment.this.koh != null && PbFragment.this.koh.cPy() != null && PbFragment.this.koh.cPy().cMz() != null) {
                        PbFragment.this.koh.cPy().cMz().bjI();
                    } else if (i == com.baidu.tbadk.core.util.al.eaR) {
                        PbFragment.this.c(PbFragment.this.kox);
                    }
                }
            }
        });
        this.koe = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.koe.x(getUniqueId());
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
        com.baidu.tbadk.core.business.a.aTH().dd("3", "");
        this.gXE = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.knL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.kkl != null) {
            gVar.setForumName(this.kkl.cLG());
            if (this.kkl.getPbData() != null && this.kkl.getPbData().getForum() != null) {
                gVar.a(this.kkl.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.kkl);
        }
    }

    public String cMC() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cMD() {
        return this.knG;
    }

    private void sk(boolean z) {
        this.kou.iN(z);
        this.kou.iO(z);
        this.kou.iP(z);
    }

    private void cME() {
        this.emT = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hFy != null) {
            this.hFy.onStart(getPageContext());
        }
    }

    public az cMF() {
        return this.koh;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cLP() {
        return this.kkl;
    }

    public void KA(String str) {
        if (this.kkl != null && !StringUtils.isNull(str) && this.koh != null) {
            this.koh.sW(true);
            this.kkl.KA(str);
            this.knR = true;
            this.koh.cQo();
            this.koh.cQy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.bjZ = false;
        } else {
            this.bjZ = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.knJ = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.knJ == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.hFy != null) {
            this.hFy.onPause(getPageContext());
        }
        if (this.koh != null) {
            this.koh.onPause();
        }
        if (!this.kkl.cNS()) {
            this.kou.zH(this.kkl.cNL());
        }
        if (this.kkl != null) {
            this.kkl.cOm();
        }
        com.baidu.tbadk.BdToken.c.aQc().aQm();
        MessageManager.getInstance().unRegisterListener(this.iRM);
        coJ();
        MessageManager.getInstance().unRegisterListener(this.kpb);
        MessageManager.getInstance().unRegisterListener(this.kpc);
        MessageManager.getInstance().unRegisterListener(this.kpd);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cMG() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.kkl.getPbData(), this.kkl.cNN(), this.kkl.cOk());
        return (a2 == null || a2.aWl() == null || a2.aWl().getGodUserData() == null || a2.aWl().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bjZ = false;
        super.onResume();
        if (this.knU) {
            this.knU = false;
            cNj();
        }
        if (cMG()) {
            this.knO = System.currentTimeMillis();
        } else {
            this.knO = -1L;
        }
        if (this.koh != null && this.koh.getView() != null) {
            if (!this.jJI) {
                cNb();
            } else {
                hideLoadingView(this.koh.getView());
            }
            this.koh.onResume();
        }
        if (this.knJ == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.koh != null) {
            noNetworkView = this.koh.cPv();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.hFy != null) {
            this.hFy.onResume(getPageContext());
        }
        registerListener(this.iRM);
        this.koo = false;
        cNi();
        registerListener(this.kpb);
        registerListener(this.kpc);
        registerListener(this.kpd);
        if (this.hGn) {
            cNa();
            this.hGn = false;
        }
        cNp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.koh.sL(z);
        if (this.kom != null) {
            this.kom.dismiss();
        }
        if (z && this.koo) {
            this.koh.cPW();
            this.kkl.sw(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.knO > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10804").dn("obj_duration", (System.currentTimeMillis() - this.knO) + ""));
            this.knO = 0L;
        }
        if (cMF().cPy() != null) {
            cMF().cPy().onStop();
        }
        if (this.koh.kuY != null && !this.koh.kuY.cRw()) {
            this.koh.kuY.releaseResources();
        }
        if (this.kkl != null && this.kkl.getPbData() != null && this.kkl.getPbData().getForum() != null && this.kkl.getPbData().cKx() != null) {
            com.baidu.tbadk.distribute.a.biw().b(getPageContext().getPageActivity(), "pb", this.kkl.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kkl.getPbData().cKx().getId(), 0L));
        }
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.koc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13266");
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.dn("fid", this.kkl.getPbData().getForumId());
            apVar.dn("tid", this.kkl.cNL());
            apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(apVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.knM && this.koh != null) {
            this.knM = true;
            this.koh.cQu();
            a(false, (PostData) null);
        }
        if (this.kkl != null) {
            this.kkl.cancelLoadData();
            this.kkl.destory();
            if (this.kkl.cOp() != null) {
                this.kkl.cOp().onDestroy();
            }
        }
        if (this.kou != null) {
            this.kou.onDestroy();
        }
        if (this.gXC != null) {
            this.gXC.cancelLoadData();
        }
        if (this.emT != null) {
            this.emT.dkB();
        }
        if (this.koh != null) {
            this.koh.onDestroy();
            if (this.koh.kuY != null) {
                this.koh.kuY.releaseResources();
            }
        }
        if (this.knN != null) {
            this.knN.bls();
        }
        if (this.knG != null) {
            this.knG.cdJ();
        }
        super.onDestroy();
        if (this.hFy != null) {
            this.hFy.onDestory(getPageContext());
        }
        if (this.koh != null) {
            this.koh.cQo();
        }
        MessageManager.getInstance().unRegisterListener(this.kpb);
        MessageManager.getInstance().unRegisterListener(this.kpc);
        MessageManager.getInstance().unRegisterListener(this.kpd);
        MessageManager.getInstance().unRegisterListener(this.koC);
        MessageManager.getInstance().unRegisterListener(this.kpe);
        MessageManager.getInstance().unRegisterListener(this.hHm);
        MessageManager.getInstance().unRegisterListener(this.hYZ);
        MessageManager.getInstance().unRegisterListener(this.kpi);
        MessageManager.getInstance().unRegisterListener(this.koU);
        this.koA = null;
        this.koB = null;
        com.baidu.tieba.recapp.d.a.dcN().dcP();
        if (this.koD != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.koD);
        }
        if (this.knV != null) {
            this.knV.cancelLoadData();
        }
        if (this.koh != null && this.koh.kuY != null) {
            this.koh.kuY.cRz();
        }
        if (this.hXO != null) {
            this.hXO.cancelLoadData();
        }
        this.kol.onDestroy();
        if (this.kkl != null && this.kkl.cOr() != null) {
            this.kkl.cOr().onDestroy();
        }
        if (this.jqz != null) {
            this.jqz.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g cPR;
        ArrayList<PostData> cMl;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bdM() && this.koh != null && (cPR = this.koh.cPR()) != null && (cMl = cPR.cMl()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cMl.iterator();
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
                        bVar.gZF = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.dTc == 1 && !TextUtils.isEmpty(id)) {
                    next.dTc = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.gZF = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.kkl == null || this.kkl.getPbData() == null || this.kkl.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.kkl.getPbData().getForum().getFirst_class();
                    str2 = this.kkl.getPbData().getForum().getSecond_class();
                    str = this.kkl.getPbData().getForum().getId();
                    str4 = this.kkl.cNL();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.bdP());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.koh.onChangeSkinType(i);
            if (this.kou != null && this.kou.biJ() != null) {
                this.kou.biJ().onChangeSkinType(i);
            }
            if (this.koh.cPv() != null) {
                this.koh.cPv().onChangeSkinType(getPageContext(), i);
            }
            this.kol.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ao.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
            cbU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.koh = new az(this, this.hIl, this.euG);
        this.hKk = new com.baidu.tieba.f.b(getActivity());
        this.hKk.a(kpt);
        this.hKk.a(this.heG);
        this.koh.setOnScrollListener(this.mOnScrollListener);
        this.koh.d(this.kpo);
        this.koh.setListPullRefreshListener(this.ffu);
        this.koh.rW(com.baidu.tbadk.core.k.aTv().isShowImages());
        this.koh.setOnImageClickListener(this.eRR);
        this.koh.b(this.mOnLongClickListener);
        this.koh.g(this.hCK);
        this.koh.a(this.kpm);
        this.koh.sL(this.mIsLogin);
        if (this.knE.getIntent() != null) {
            this.koh.sX(this.knE.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.koh.cPx().setFromForumId(this.kkl.getFromForumId());
        this.koh.setEditorTools(this.kou.biJ());
        this.kou.zG(this.koh.cPC());
        this.koh.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.kkl.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kkl.getPbData().getForum().getId(), PbFragment.this.kkl.getPbData().getForum().getName(), PbFragment.this.kkl.getPbData().cKx().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.koh.sY(this.kkl.cNQ());
        this.koh.BV(this.kkl.cOv());
        return this.koh.getView();
    }

    public void cMH() {
        if (this.koh != null && this.kkl != null) {
            if ((this.kkl.getPbData() != null || this.kkl.getPbData().cKW() != null) && checkUpIsLogin() && this.koh.cPR() != null && this.koh.cPR().cMq() != null) {
                this.koh.cPR().cMq().yq(this.kkl.cNL());
            }
        }
    }

    public void cMI() {
        TiebaStatic.log("c12181");
        if (this.koh != null && this.kkl != null) {
            if ((this.koh == null || this.koh.cPB()) && this.kkl.getPbData() != null && this.kkl.getPbData().cKW() != null) {
                com.baidu.tieba.pb.data.o cKW = this.kkl.getPbData().cKW();
                if (checkUpIsLogin()) {
                    if ((!cKW.cLq() || cKW.aXM() != 2) && this.koh.cPR() != null && this.koh.cPR().cMq() != null) {
                        this.koh.cPR().cMq().yq(this.kkl.cNL());
                    }
                    if (System.currentTimeMillis() - this.knQ > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).tF(false);
                        this.knQ = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cI(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.dRN && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.aTv().isShowImages()) {
                    return KD(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.kkl == null || this.kkl.getPbData() == null) {
                        return true;
                    }
                    if (cMF().cPy() != null) {
                        cMF().cPy().cMv();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.kkl.getPbData().getForum());
                    pVar.setThreadData(this.kkl.getPbData().cKx());
                    pVar.g(postData);
                    cMF().cPx().d(pVar);
                    cMF().cPx().setPostId(postData.getId());
                    a(view, postData.aWl().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.kou != null) {
                        this.koh.sR(this.kou.bjs());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cMJ() {
        if (this.knK == null) {
            this.knK = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.knK.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0492b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.kkh = PbFragment.this.kkh.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kkh);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kkl.cNL(), PbFragment.this.kkh, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.kkh = PbFragment.this.kkh.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kkh);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kkl.cNL(), PbFragment.this.kkh, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.kkh = PbFragment.this.kkh.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kkh);
                        bVar.dismiss();
                    }
                }
            }).ls(b.a.BOTTOM_TO_TOP).lt(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.kpj.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).cTx(), "", 1);
    }

    private void aC(Bundle bundle) {
        this.kkl = this.knE.cLP();
        if (this.kkl.cOo() != null) {
            this.kkl.cOo().a(this.kmH);
        }
        if (this.kkl.cOp() != null) {
            this.kkl.cOp().b(this.koN);
        }
        if (StringUtils.isNull(this.kkl.cNL())) {
            this.knE.finish();
        } else if ("from_tieba_kuang".equals(this.knS) && this.knS != null) {
            this.kkl.BV(6);
        }
    }

    private void initData(Bundle bundle) {
        this.kof = com.baidu.tbadk.baseEditMark.a.a(this.knE);
        if (this.kof != null) {
            this.kof.a(this.kpl);
        }
        this.gXC = new ForumManageModel(this.knE);
        this.gXC.setLoadDataCallBack(this.gXJ);
        this.eaU = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.koY.setUniqueId(getUniqueId());
        this.koY.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.koh.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.koC;
        userMuteCheckCustomMessage.setTag(this.koC);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cMK() {
        if (this.kkl == null || this.kkl.getPbData() == null) {
            return false;
        }
        bv cKx = this.kkl.getPbData().cKx();
        this.kkl.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cKx);
    }

    public void cML() {
        if (checkUpIsLogin() && this.kkl != null && this.kkl.getPbData() != null && this.kkl.getPbData().getForum() != null && !cMK()) {
            if (this.kkl.getPbData().cLa()) {
                this.koh.cok();
                return;
            }
            if (this.hJL == null) {
                this.hJL = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hJL.vY(0);
                this.hJL.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nQ(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nR(boolean z) {
                        if (z) {
                            if (PbFragment.this.kou != null && PbFragment.this.kou.biJ() != null) {
                                PbFragment.this.kou.biJ().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.koh.cok();
                        }
                    }
                });
            }
            this.hJL.B(this.kkl.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kkl.cNL(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cMM() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.kkl == null || (pbData = this.kkl.getPbData()) == null) {
            return null;
        }
        return pbData.cKL().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            if (fVar.cKx().getThreadType() == 0) {
                return 1;
            }
            if (fVar.cKx().getThreadType() == 54) {
                return 2;
            }
            if (fVar.cKx().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !cMK() && cMN()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.knX);
                this.knY = ((View) view.getParent()).getMeasuredHeight();
            }
            if (cMF().cPy() != null && postData != null) {
                String str3 = "";
                if (postData.dlk() != null) {
                    str3 = postData.dlk().toString();
                }
                cMF().cPy().Ky(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.aWl().getName_show(), str3));
            }
            if (this.kkl.getPbData() != null && this.kkl.getPbData().cLa()) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.knE.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cMF().getListView().smoothScrollBy((PbFragment.this.knX[1] + PbFragment.this.knY) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cMF().cPy() != null) {
                            PbFragment.this.kou.biJ().setVisibility(8);
                            PbFragment.this.cMF().cPy().g(str, str2, PbFragment.this.cMF().cPC(), (PbFragment.this.kkl == null || PbFragment.this.kkl.getPbData() == null || PbFragment.this.kkl.getPbData().cKx() == null || !PbFragment.this.kkl.getPbData().cKx().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cMz = PbFragment.this.cMF().cPy().cMz();
                            if (cMz != null && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                cMz.a(PbFragment.this.kkl.getPbData().getAnti());
                                cMz.setThreadData(PbFragment.this.kkl.getPbData().cKx());
                            }
                            if (PbFragment.this.kol.cQQ() == null && PbFragment.this.cMF().cPy().cMz().bjQ() != null) {
                                PbFragment.this.cMF().cPy().cMz().bjQ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kol != null && PbFragment.this.kol.cQP() != null) {
                                            if (!PbFragment.this.kol.cQP().duc()) {
                                                PbFragment.this.kol.ta(false);
                                            }
                                            PbFragment.this.kol.cQP().wj(false);
                                        }
                                    }
                                });
                                PbFragment.this.kol.f(PbFragment.this.cMF().cPy().cMz().bjQ().getInputView());
                                PbFragment.this.cMF().cPy().cMz().a(PbFragment.this.koz);
                            }
                        }
                        PbFragment.this.cMF().cQy();
                    }
                }, 0L);
                return;
            }
            if (this.kow == null) {
                this.kow = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kow.vY(1);
                this.kow.a(new AnonymousClass39(str, str2));
            }
            if (this.kkl != null && this.kkl.getPbData() != null && this.kkl.getPbData().getForum() != null) {
                this.kow.B(this.kkl.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kkl.cNL(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String kpD;
        final /* synthetic */ String kpE;

        AnonymousClass39(String str, String str2) {
            this.kpD = str;
            this.kpE = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nQ(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nR(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        }
                        PbFragment.this.cMF().getListView().smoothScrollBy((PbFragment.this.knX[1] + PbFragment.this.knY) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cMF().cPy() != null) {
                            PbFragment.this.kou.biJ().setVisibility(8);
                            PbFragment.this.cMF().cPy().g(AnonymousClass39.this.kpD, AnonymousClass39.this.kpE, PbFragment.this.cMF().cPC(), (PbFragment.this.kkl == null || PbFragment.this.kkl.getPbData() == null || PbFragment.this.kkl.getPbData().cKx() == null || !PbFragment.this.kkl.getPbData().cKx().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cMz = PbFragment.this.cMF().cPy().cMz();
                            if (cMz != null && PbFragment.this.kkl != null && PbFragment.this.kkl.getPbData() != null) {
                                cMz.a(PbFragment.this.kkl.getPbData().getAnti());
                                cMz.setThreadData(PbFragment.this.kkl.getPbData().cKx());
                            }
                            if (PbFragment.this.kol.cQQ() == null && PbFragment.this.cMF().cPy().cMz().bjQ() != null) {
                                PbFragment.this.cMF().cPy().cMz().bjQ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kol != null && PbFragment.this.kol.cQP() != null) {
                                            if (!PbFragment.this.kol.cQP().duc()) {
                                                PbFragment.this.kol.ta(false);
                                            }
                                            PbFragment.this.kol.cQP().wj(false);
                                        }
                                    }
                                });
                                PbFragment.this.kol.f(PbFragment.this.cMF().cPy().cMz().bjQ().getInputView());
                                PbFragment.this.cMF().cPy().cMz().a(PbFragment.this.koz);
                            }
                        }
                        PbFragment.this.cMF().cQy();
                    }
                }, 0L);
            }
        }
    }

    public boolean cMN() {
        if ((this.kkl.getPbData() != null && this.kkl.getPbData().cLa()) || this.jqz == null || this.kkl.getPbData() == null || this.kkl.getPbData().getAnti() == null) {
            return true;
        }
        return this.jqz.lJ(this.kkl.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean BI(int i) {
        if (this.jqz == null || this.kkl.getPbData() == null || this.kkl.getPbData().getAnti() == null) {
            return true;
        }
        return this.jqz.aG(this.kkl.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.kkl != null && this.kkl.getPbData() != null && postData.dli() != 1) {
            String cNL = this.kkl.cNL();
            String id = postData.getId();
            int i = 0;
            if (this.kkl.getPbData() != null) {
                i = this.kkl.getPbData().cKM();
            }
            PbActivity.a KE = KE(id);
            if (KE != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cNL, id, "pb", true, null, false, null, i, postData.cSs(), this.kkl.getPbData().getAnti(), false, postData.aWl() != null ? postData.aWl().getIconInfo() : null).addBigImageData(KE.kkt, KE.dLG, KE.dLE, KE.index);
                addBigImageData.setKeyPageStartFrom(this.kkl.cOv());
                addBigImageData.setFromFrsForumId(this.kkl.getFromForumId());
                addBigImageData.setKeyFromForumId(this.kkl.getForumId());
                addBigImageData.setBjhData(this.kkl.cNU());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cMO() {
        if (this.kkl.getPbData() == null || this.kkl.getPbData().cKx() == null) {
            return -1;
        }
        return this.kkl.getPbData().cKx().aWY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(boolean z) {
        if (this.kkl != null && this.kkl.kli != null && this.kkl.kli.cKx() != null) {
            bv cKx = this.kkl.kli.cKx();
            cKx.mRecomAbTag = this.kkl.cOG();
            cKx.mRecomWeight = this.kkl.cOE();
            cKx.mRecomSource = this.kkl.cOF();
            cKx.mRecomExtra = this.kkl.cOH();
            if (cKx.getFid() == 0) {
                cKx.setFid(com.baidu.adp.lib.f.b.toLong(this.kkl.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ap a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cKx, "c13563");
            TbPageTag ec = com.baidu.tbadk.pageInfo.c.ec(getContext());
            if (ec != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(ec.locatePage)) {
                a2.dn("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dn("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (ec != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(ec.locatePage)) {
                a2.dn("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dn("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.ah("reply_type", 1);
                if (z) {
                    a2.ah("obj_type", 2);
                } else {
                    a2.ah("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMP() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.MZ(this.kkl.getForumId()) && this.kkl.getPbData() != null && this.kkl.getPbData().getForum() != null) {
            if (this.kkl.getPbData().getForum().isLike() == 1) {
                this.kkl.cOr().fs(this.kkl.getForumId(), this.kkl.cNL());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sm(boolean z) {
        if (this.kkl == null || this.kkl.getPbData() == null) {
            return false;
        }
        return ((this.kkl.getPbData().cKM() != 0) || this.kkl.getPbData().cKx() == null || this.kkl.getPbData().cKx().aWl() == null || TextUtils.equals(this.kkl.getPbData().cKx().aWl().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean sn(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.aa aaVar;
        if (this.kkl == null || this.kkl.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.kkl.getPbData();
        bv cKx = pbData.cKx();
        if (cKx != null) {
            if (cKx.aUT() || cKx.aUU()) {
                return false;
            }
            if (cKx.aYg() || cKx.aYh()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cKM() != 0) {
                return pbData.cKM() != 3;
            }
            List<br> cKU = pbData.cKU();
            if (com.baidu.tbadk.core.util.x.getCount(cKU) > 0) {
                for (br brVar : cKU) {
                    if (brVar != null && (aaVar = brVar.dRa) != null && aaVar.dON && !aaVar.dOO && (aaVar.type == 1 || aaVar.type == 2)) {
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

    private boolean so(boolean z) {
        if (z || this.kkl == null || this.kkl.getPbData() == null) {
            return false;
        }
        return ((this.kkl.getPbData().getForum() != null && this.kkl.getPbData().getForum().isBlockBawuDelete) || this.kkl.getPbData().cKM() == 0 || this.kkl.getPbData().cKM() == 3) ? false : true;
    }

    public void cMQ() {
        com.baidu.tieba.pb.data.f pbData;
        bv cKx;
        boolean z = true;
        if (this.kkl != null && this.kkl.getPbData() != null && (cKx = (pbData = this.kkl.getPbData()).cKx()) != null && cKx.aWl() != null) {
            this.koh.cPw();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cKx.aWl().getUserId());
            ak akVar = new ak();
            int cKM = this.kkl.getPbData().cKM();
            if (cKM == 1 || cKM == 3) {
                akVar.ktm = true;
                akVar.ktl = true;
                akVar.ktr = cKx.aWg() == 1;
                akVar.ktq = cKx.aWh() == 1;
            } else {
                akVar.ktm = false;
                akVar.ktl = false;
            }
            if (cKM == 1002 && !equals) {
                akVar.kts = true;
            }
            akVar.ktj = sn(equals);
            akVar.ktn = cMR();
            akVar.ktk = so(equals);
            akVar.Ef = this.kkl.cNN();
            akVar.ktg = true;
            akVar.ktf = sm(equals);
            akVar.kte = equals && this.koh.cQd();
            akVar.ktp = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.kto = true;
            akVar.isHostOnly = this.kkl.getHostMode();
            akVar.kti = true;
            if (cKx.aWD() == null) {
                akVar.kth = true;
            } else {
                akVar.kth = false;
            }
            if (pbData.cLa()) {
                akVar.ktg = false;
                akVar.kti = false;
                akVar.kth = false;
                akVar.ktl = false;
                akVar.ktm = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cLa()) {
                z = false;
            }
            akVar.ktt = z;
            this.koh.kuY.a(akVar);
        }
    }

    private boolean cMR() {
        if (this.kkl != null && this.kkl.cNN()) {
            return this.kkl.getPageData() == null || this.kkl.getPageData().aVc() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(View view) {
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
    public PbModel.a cMS() {
        return this.kpj;
    }

    public int cMT() {
        if (cMF() == null || cMF().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cMF().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).Uh == com.baidu.tieba.pb.data.n.kiH) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cMU() {
        if (cMF() == null || cMF().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cMF().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.lNd) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cNa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMV() {
        if (this.kkl != null && this.kkl.kli != null && this.kkl.kli.cKx() != null) {
            bv cKx = this.kkl.kli.cKx();
            cKx.mRecomAbTag = this.kkl.cOG();
            cKx.mRecomWeight = this.kkl.cOE();
            cKx.mRecomSource = this.kkl.cOF();
            cKx.mRecomExtra = this.kkl.cOH();
            if (cKx.getFid() == 0) {
                cKx.setFid(com.baidu.adp.lib.f.b.toLong(this.kkl.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ap a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cKx, "c13562");
            TbPageTag ec = com.baidu.tbadk.pageInfo.c.ec(getContext());
            if (ec != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(ec.locatePage)) {
                a2.dn("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dn("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (ec != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(ec.locatePage)) {
                a2.dn("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dn("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
            aVar.xk(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.xl(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.hJ(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12528").dn("obj_id", metaData.getUserId()).ah("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12528").dn("obj_id", metaData.getUserId()).ah("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.eaU.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.kkl.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aYL();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.koh.cPX();
        this.kkl.sy(z);
        if (this.kof != null) {
            this.kof.he(z);
            if (markData != null) {
                this.kof.a(markData);
            }
        }
        if (this.kkl.aSj()) {
            cMY();
        } else {
            this.koh.s(this.kkl.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BA(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KB(String str) {
        if (this.kkl != null && this.kkl.getPbData() != null && this.kkl.getPbData().cLa()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kkl.cNL(), str);
            bv cKx = this.kkl.getPbData().cKx();
            if (cKx.aUT()) {
                format = format + "&channelid=33833";
            } else if (cKx.aYf()) {
                format = format + "&channelid=33842";
            } else if (cKx.aUU()) {
                format = format + "&channelid=33840";
            }
            KC(format);
            return;
        }
        this.koe.Lc(str);
    }

    private void KC(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.kkl.cNS()) {
                    antiData.setBlock_forum_name(this.kkl.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.kkl.getPbData().getForum().getId());
                    antiData.setUser_name(this.kkl.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.kkl.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cMF() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bB(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            zN(str);
        } else {
            this.koh.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.lPQ) ? bVar.lPQ : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.xl(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.hJ(true);
                aVar.b(getPageContext());
                aVar.aYL();
            } else {
                this.koh.a(0, bVar.Pv, bVar.lPQ, z);
            }
            if (bVar.Pv) {
                if (bVar.hmP == 1) {
                    ArrayList<PostData> cKz = this.kkl.getPbData().cKz();
                    int size = cKz.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cKz.get(i).getId())) {
                            i++;
                        } else {
                            cKz.remove(i);
                            break;
                        }
                    }
                    this.kkl.getPbData().cKx().la(this.kkl.getPbData().cKx().aWc() - 1);
                    this.koh.s(this.kkl.getPbData());
                } else if (bVar.hmP == 0) {
                    cMW();
                } else if (bVar.hmP == 2) {
                    ArrayList<PostData> cKz2 = this.kkl.getPbData().cKz();
                    int size2 = cKz2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cKz2.get(i2).dlf().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cKz2.get(i2).dlf().get(i3).getId())) {
                                i3++;
                            } else {
                                cKz2.get(i2).dlf().remove(i3);
                                cKz2.get(i2).dlh();
                                z2 = true;
                                break;
                            }
                        }
                        cKz2.get(i2).NN(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.koh.s(this.kkl.getPbData());
                    }
                    a(bVar, this.koh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.koh.a(this.gXC.getLoadDataMode(), gVar.Pv, gVar.lPQ, false);
            if (gVar.Pv) {
                this.koi = true;
                if (i == 2 || i == 3) {
                    this.koj = true;
                    this.kok = false;
                } else if (i == 4 || i == 5) {
                    this.koj = false;
                    this.kok = true;
                }
                if (i == 2) {
                    this.kkl.getPbData().cKx().ld(1);
                    this.kkl.setIsGood(1);
                } else if (i == 3) {
                    this.kkl.getPbData().cKx().ld(0);
                    this.kkl.setIsGood(0);
                } else if (i == 4) {
                    this.kkl.getPbData().cKx().lc(1);
                    this.kkl.BN(1);
                } else if (i == 5) {
                    this.kkl.getPbData().cKx().lc(0);
                    this.kkl.BN(0);
                }
                this.koh.c(this.kkl.getPbData(), this.kkl.cNN());
            }
        }
    }

    private void cMW() {
        if (this.kkl.cNO() || this.kkl.cNQ()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.kkl.cNL());
            PbActivity pbActivity = this.knE;
            PbActivity pbActivity2 = this.knE;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.kkl.cNL()));
        if (cMZ()) {
            this.knE.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMc() {
        this.knE.cMc();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cKJ;
        boolean z = false;
        if (this.koh != null) {
            this.koh.cQo();
        }
        if (this.kkl != null && this.kkl.getPbData() != null && !this.kkl.getPbData().cLa()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.kkl.getPbData().cKx().getId();
            if (this.kkl.isShareThread() && this.kkl.getPbData().cKx().dUi != null) {
                historyMessage.threadName = this.kkl.getPbData().cKx().dUi.showText;
            } else {
                historyMessage.threadName = this.kkl.getPbData().cKx().getTitle();
            }
            if (this.kkl.isShareThread() && !cLF()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.kkl.getPbData().getForum().getName();
            }
            ArrayList<PostData> cKz = this.kkl.getPbData().cKz();
            int cPZ = this.koh != null ? this.koh.cPZ() : 0;
            if (cKz != null && cPZ >= 0 && cPZ < cKz.size()) {
                historyMessage.postID = cKz.get(cPZ).getId();
            }
            historyMessage.isHostOnly = this.kkl.getHostMode();
            historyMessage.isSquence = this.kkl.cNN();
            historyMessage.isShareThread = this.kkl.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kou != null) {
            this.kou.onDestroy();
        }
        if (this.knI && cMF() != null) {
            cMF().cQI();
        }
        if (this.kkl != null && (this.kkl.cNO() || this.kkl.cNQ())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.kkl.cNL());
            if (this.koi) {
                if (this.kok) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.kkl.bUx());
                }
                if (this.koj) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.kkl.getIsGood());
                }
            }
            if (this.kkl.getPbData() != null && System.currentTimeMillis() - this.knL >= 40000 && (cKJ = this.kkl.getPbData().cKJ()) != null && !com.baidu.tbadk.core.util.x.isEmpty(cKJ.getDataList())) {
                intent.putExtra("guess_like_data", cKJ);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.koI);
            }
            PbActivity pbActivity = this.knE;
            PbActivity pbActivity2 = this.knE;
            pbActivity.setResult(-1, intent);
        }
        if (cMZ()) {
            if (this.kkl != null && this.koh != null && this.koh.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.kkl.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cKF() && !this.knR && pbData.khq == null) {
                        as cPg = as.cPg();
                        com.baidu.tieba.pb.data.f cNV = this.kkl.cNV();
                        Parcelable onSaveInstanceState = this.koh.getListView().onSaveInstanceState();
                        boolean cNN = this.kkl.cNN();
                        boolean hostMode = this.kkl.getHostMode();
                        if (this.koh.cPI() != null && this.koh.cPI().getVisibility() == 0) {
                            z = true;
                        }
                        cPg.a(cNV, onSaveInstanceState, cNN, hostMode, z);
                        if (this.koH >= 0 || this.kkl.cOx() != null) {
                            as.cPg().q(this.kkl.cOx());
                            as.cPg().p(this.kkl.cOy());
                            as.cPg().BX(this.kkl.cOz());
                        }
                    }
                }
            } else {
                as.cPg().reset();
            }
            cMc();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.koh == null || !this.koh.Cd(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BJ(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.knE;
        if (i == 0) {
            this.koh.cPw();
            this.koh.cPy().cMv();
            this.koh.sT(false);
        }
        this.koh.cPA();
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
                        this.kou.resetData();
                        this.kou.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kou.b(writeData);
                        com.baidu.tbadk.editortools.l nT = this.kou.biJ().nT(6);
                        if (nT != null && nT.ezZ != null) {
                            nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.knE;
                        if (i == -1) {
                            this.kou.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.koh.cPy() != null && this.koh.cPy().cMz() != null) {
                            com.baidu.tbadk.editortools.pb.h cMz = this.koh.cPy().cMz();
                            cMz.setThreadData(this.kkl.getPbData().cKx());
                            cMz.b(writeData);
                            cMz.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l nT2 = cMz.biJ().nT(6);
                            if (nT2 != null && nT2.ezZ != null) {
                                nT2.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.knE;
                            if (i == -1) {
                                cMz.bjI();
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
        this.kou.onActivityResult(i, i2, intent);
        if (this.knV != null) {
            this.knV.onActivityResult(i, i2, intent);
        }
        if (cMF().cPy() != null) {
            cMF().cPy().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cMX();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.cPg().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.kkl != null) {
                                PbFragment.this.kkl.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dbG().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.kkl != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    T(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.dbG().F(getPageContext());
                        cMP();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.hXO != null && shareItem != null && shareItem.linkUrl != null) {
                            this.hXO.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bgn() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59.1
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
                    this.koh.sb(false);
                    if (this.kkl.getPbData() != null && this.kkl.getPbData().cKx() != null && this.kkl.getPbData().cKx().aWG() != null) {
                        this.kkl.getPbData().cKx().aWG().setStatus(2);
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
                        this.kox = emotionImageData;
                        if (BI(com.baidu.tbadk.core.util.al.eaR)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.knW != null) {
                        this.koh.cQ(this.knW);
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
            if (this.knV == null) {
                this.knV = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.knE);
                this.knV.b(this.eBX);
                this.knV.c(this.eCe);
            }
            this.knV.a(emotionImageData, cLP(), cLP().getPbData());
        }
    }

    private void T(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMX() {
        MarkData BU;
        if (this.kof != null) {
            if (this.kkl.getPbData() != null && this.kkl.getPbData().cLa()) {
                BU = this.kkl.BU(0);
            } else {
                BU = this.kkl.BU(this.koh.cQa());
            }
            if (BU != null) {
                if (!BU.isApp() || (BU = this.kkl.BU(this.koh.cQa() + 1)) != null) {
                    this.koh.cPV();
                    this.kof.a(BU);
                    if (!this.kof.aSj()) {
                        this.kof.aSl();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.kof.aSk();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMY() {
        com.baidu.tieba.pb.data.f pbData = this.kkl.getPbData();
        this.kkl.sy(true);
        if (this.kof != null) {
            pbData.Kr(this.kof.aSi());
        }
        this.koh.s(pbData);
    }

    private boolean cMZ() {
        if (this.kkl == null) {
            return true;
        }
        if (this.kkl.getPbData() == null || !this.kkl.getPbData().cLa()) {
            if (this.kkl.aSj()) {
                final MarkData cOf = this.kkl.cOf();
                if (cOf == null || !this.kkl.getIsFromMark()) {
                    return true;
                }
                final MarkData BU = this.kkl.BU(this.koh.cPZ());
                if (BU == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cOf);
                    this.knE.setResult(-1, intent);
                    return true;
                } else if (BU.getPostId() == null || BU.getPostId().equals(cOf.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cOf);
                    this.knE.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.xl(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.kof != null) {
                                if (PbFragment.this.kof.aSj()) {
                                    PbFragment.this.kof.aSk();
                                    PbFragment.this.kof.he(false);
                                }
                                PbFragment.this.kof.a(BU);
                                PbFragment.this.kof.he(true);
                                PbFragment.this.kof.aSl();
                            }
                            cOf.setPostId(BU.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cOf);
                            PbFragment.this.knE.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cMc();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cOf);
                            PbFragment.this.knE.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cMc();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.koh != null && PbFragment.this.koh.getView() != null) {
                                PbFragment.this.koh.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cOf);
                                PbFragment.this.knE.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cMc();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aYL();
                    return false;
                }
            } else if (this.kkl.getPbData() == null || this.kkl.getPbData().cKz() == null || this.kkl.getPbData().cKz().size() <= 0 || !this.kkl.getIsFromMark()) {
                return true;
            } else {
                this.knE.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.i
    public BdListView getListView() {
        if (this.koh == null) {
            return null;
        }
        return this.koh.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bpt() {
        if (this.koh == null) {
            return 0;
        }
        return this.koh.cQm();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bpu() {
        if (this.eRG == null) {
            this.eRG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bpG */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aTv().isShowImages();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ao.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.aTv().isShowImages()) {
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
        return this.eRG;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bpv() {
        if (this.eUX == null) {
            this.eUX = TbRichTextView.w(getPageContext().getPageActivity(), 8);
        }
        return this.eUX;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bpw() {
        if (this.eRH == null) {
            this.eRH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bWl */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aTv().isShowImages();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.ao.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.aTv().isShowImages()) {
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
                    gifView.bki();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.eRH;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bpx() {
        if (this.eUY == null) {
            this.eUY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cNw */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cL */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cM */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bFz();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cN */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.eUY;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bpz() {
        this.eVa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cNx */
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
        return this.eVa;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bcF() {
        if (this.elu == null) {
            this.elu = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.elu;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.knP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (be.KT(str) && this.kkl != null && this.kkl.cNL() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11664").ah("obj_param1", 1).dn("post_id", this.kkl.cNL()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.ezd = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            be.cQS().f(getPageContext(), str);
        }
        this.knP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void an(Context context, String str) {
        be.cQS().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.knP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ao(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.koh != null && this.koh.cQD() != null && rect.top <= this.koh.cQD().getHeight()) {
            rect.top += this.koh.cQD().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.kkl.getPbData();
            TbRichText br = br(str, i);
            if (br != null && (tbRichTextData = br.boJ().get(this.kpp)) != null) {
                aVar.postId = String.valueOf(br.getPostId());
                aVar.kkt = new ArrayList<>();
                aVar.dLG = new ConcurrentHashMap<>();
                if (!tbRichTextData.boP().bpc()) {
                    aVar.kku = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.kkt.add(c2);
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
                    imageUrlData.postId = br.getPostId();
                    imageUrlData.mIsReserver = this.kkl.cOd();
                    imageUrlData.mIsSeeHost = this.kkl.getHostMode();
                    aVar.dLG.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cKx() != null) {
                            aVar.threadId = pbData.cKx().getId();
                        }
                        aVar.dLE = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kku = true;
                int size = pbData.cKz().size();
                this.kpq = false;
                aVar.index = -1;
                int a2 = pbData.cKG() != null ? a(pbData.cKG().dlk(), br, i, i, aVar.kkt, aVar.dLG) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cKz().get(i2);
                    if (postData.getId() == null || pbData.cKG() == null || pbData.cKG().getId() == null || !postData.getId().equals(pbData.cKG().getId())) {
                        a2 = a(postData.dlk(), br, a2, i, aVar.kkt, aVar.dLG);
                    }
                }
                if (aVar.kkt.size() > 0) {
                    aVar.lastId = aVar.kkt.get(aVar.kkt.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cKx() != null) {
                        aVar.threadId = pbData.cKx().getId();
                    }
                    aVar.dLE = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.boP() == null) {
            return null;
        }
        return tbRichTextData.boP().bph();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.boP() == null) {
            return 0L;
        }
        return tbRichTextData.boP().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.boP() == null) {
            return false;
        }
        return tbRichTextData.boP().bpi();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.boP() == null) {
            return false;
        }
        return tbRichTextData.boP().bpj();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo boP;
        String str;
        if (tbRichText == tbRichText2) {
            this.kpq = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.boJ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.boJ().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.boP().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.boP().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.boP().bpc()) {
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
                            if (tbRichTextData != null && (boP = tbRichTextData.boP()) != null) {
                                String bpe = boP.bpe();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = boP.bpf();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bpe;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kkl.cNL(), -1L);
                                imageUrlData.mIsReserver = this.kkl.cOd();
                                imageUrlData.mIsSeeHost = this.kkl.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.kpq) {
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
        PostData cKG;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.kkl.aWt())) {
                z = true;
            }
            MarkData o = this.kkl.o(postData);
            if (this.kkl.getPbData() != null && this.kkl.getPbData().cLa() && (cKG = cKG()) != null) {
                o = this.kkl.o(cKG);
            }
            if (o != null) {
                this.koh.cPV();
                if (this.kof != null) {
                    this.kof.a(o);
                    if (!z) {
                        this.kof.aSl();
                    } else {
                        this.kof.aSk();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            a(postData, false);
        }
    }

    public boolean cK(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText br(String str, int i) {
        TbRichText tbRichText = null;
        if (this.kkl == null || this.kkl.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.kkl.getPbData();
        if (pbData.cKG() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cKG());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cKz = pbData.cKz();
            c(pbData, cKz);
            return c(cKz, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eeP == null) {
                this.eeP = new com.baidu.tbadk.core.message.a();
            }
            if (this.eez == null) {
                this.eez = new com.baidu.tieba.tbadkCore.data.e();
                this.eez.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dNB = 5;
            cVar.dNH = 8;
            cVar.dNG = 2;
            if (cLP() != null) {
                cVar.dNF = cLP().cOv();
            }
            cVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dNI = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dNI = 1;
                        i = 0;
                    }
                }
                this.eeP.a(agreeData, i, getUniqueId(), false);
                this.eeP.a(agreeData, this.eez);
                if (this.kkl == null && this.kkl.getPbData() != null) {
                    this.eeP.a(cNt(), cVar, agreeData, this.kkl.getPbData().cKx());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dNI = 1;
            }
            i = 0;
            this.eeP.a(agreeData, i, getUniqueId(), false);
            this.eeP.a(agreeData, this.eez);
            if (this.kkl == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.cKL() != null && fVar.cKL().kiW != null && (list = fVar.cKL().kiW) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> boJ;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dlk = arrayList.get(i2).dlk();
            if (dlk != null && (boJ = dlk.boJ()) != null) {
                int size = boJ.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (boJ.get(i4) != null && boJ.get(i4).getType() == 8) {
                        i3++;
                        if (boJ.get(i4).boP().bpe().equals(str) || boJ.get(i4).boP().bpf().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = boJ.get(i4).boP().getWidth() * equipmentDensity;
                            int height = boJ.get(i4).boP().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.kpp = i4;
                            return dlk;
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

    @Override // com.baidu.tbadk.widget.richText.i
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.kkh = str;
            if (this.knK == null) {
                cMJ();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.knK.getItemView(1).setVisibility(8);
            } else {
                this.knK.getItemView(1).setVisibility(0);
            }
            this.knK.aYN();
            this.knP = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hFy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNa() {
        hideNetRefreshView(this.koh.getView());
        cNb();
        if (this.kkl.cNY()) {
            this.koh.cPV();
        }
        this.koh.cQg();
    }

    private void cNb() {
        showLoadingView(this.koh.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.koh.cQD().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbU() {
        if (this.hFy != null) {
            this.hFy.stopPlay();
        }
        if (this.knE != null) {
            this.knE.cbU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BK(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cMO(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bpy() {
        if (this.eUZ == null) {
            this.eUZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cNy */
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
        return this.eUZ;
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

    public void cbV() {
        if (this.knE != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.knE.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.knE.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cax() {
        if (this.kkl == null || this.kkl.getPbData() == null) {
            return null;
        }
        return this.kkl.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.kwm)).intValue();
            if (intValue == az.kwn) {
                if (!this.gXC.dlV()) {
                    this.koh.cPS();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.gXC.NR(com.baidu.tbadk.core.util.as.P(jSONArray));
                    }
                    this.gXC.a(this.kkl.getPbData().getForum().getId(), this.kkl.getPbData().getForum().getName(), this.kkl.getPbData().cKx().getId(), str, intValue3, intValue2, booleanValue, this.kkl.getPbData().cKx().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.kwo || intValue == az.kwq) {
                if (this.kkl.cOo() != null) {
                    this.kkl.cOo().BE(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.kwo) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.koC);
        userMuteAddAndDelCustomMessage.setTag(this.koC);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean KD(String str) {
        if (!StringUtils.isNull(str) && bf.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0726a
    public void sp(boolean z) {
        this.koo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cNc() {
        ArrayList<PostData> cKz;
        int count;
        if (this.kkl == null || this.kkl.getPbData() == null || this.kkl.getPbData().cKz() == null || (count = com.baidu.tbadk.core.util.x.getCount((cKz = this.kkl.getPbData().cKz()))) == 0) {
            return "";
        }
        if (this.kkl.cOd()) {
            Iterator<PostData> it = cKz.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dli() == 1) {
                    return next.getId();
                }
            }
        }
        int cPZ = this.koh.cPZ();
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(cKz, cPZ);
        if (postData == null || postData.aWl() == null) {
            return "";
        }
        if (this.kkl.KH(postData.aWl().getUserId())) {
            return postData.getId();
        }
        for (int i = cPZ - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.getItem(cKz, i);
            if (postData2 == null || postData2.aWl() == null || postData2.aWl().getUserId() == null) {
                break;
            } else if (this.kkl.KH(postData2.aWl().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cPZ + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.getItem(cKz, i2);
            if (postData3 == null || postData3.aWl() == null || postData3.aWl().getUserId() == null) {
                return "";
            }
            if (this.kkl.KH(postData3.aWl().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
        this.knP = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a KE(String str) {
        String str2;
        if (this.kkl.getPbData() == null || this.kkl.getPbData().cKz() == null || this.kkl.getPbData().cKz().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kkl.getPbData().cKz().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kkl.getPbData().cKz().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kkl.getPbData().cKz().get(i);
        if (postData.dlk() == null || postData.dlk().boJ() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dlk().boJ().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.boP() != null) {
                    str2 = next.boP().bpe();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean cNd() {
        return (!this.knF && this.kpu == -1 && this.kpv == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null) {
            this.kpx = rVar;
            this.knF = true;
            this.koh.cPJ();
            this.koh.KR(this.kpw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNe() {
        if (this.kpx != null) {
            if (this.kpu == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bf.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kpx.getCartoonId(), this.kpu, 0)));
                this.knE.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNf() {
        if (this.kpx != null) {
            if (this.kpv == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bf.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kpx.getCartoonId(), this.kpv, 0)));
                this.knE.finish();
            }
        }
    }

    public int cNg() {
        return this.kpu;
    }

    public int cNh() {
        return this.kpv;
    }

    private void coJ() {
        if (this.kkl != null && this.kkl.getPbData() != null && this.kkl.getPbData().cKx() != null && this.kkl.getPbData().cKx().aUR()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cNi() {
        if (this.kkl != null && this.kkl.getPbData() != null && this.kkl.getPbData().cKx() != null && this.kkl.getPbData().cKx().aUR()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cNj() {
        if (this.bjZ) {
            this.knU = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.kkl.getPbData() != null && this.kkl.getPbData().cKx() != null && this.kkl.getPbData().cKx().aVR() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.kkl.getPbData().cKx().aVR().getThreadId(), this.kkl.getPbData().cKx().aVR().getTaskId(), this.kkl.getPbData().cKx().aVR().getForumId(), this.kkl.getPbData().cKx().aVR().getForumName(), this.kkl.getPbData().cKx().aWg(), this.kkl.getPbData().cKx().aWh())));
            this.knH = true;
            this.knE.finish();
        }
    }

    public String cNk() {
        return this.knS;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cNl() {
        return this.kod;
    }

    public void sq(boolean z) {
        this.knT = z;
    }

    public boolean aTV() {
        if (this.kkl != null) {
            return this.kkl.cNO();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.xl(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.koA).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.koA.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.koA).aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zN(String str) {
        if (str == null) {
            str = "";
        }
        if (this.koA != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.koA.getPageActivity());
            aVar.xl(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.81
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.koA).aYL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.koh.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.koA.getPageActivity());
        if (com.baidu.tbadk.core.util.as.isEmpty(str)) {
            aVar.xl(this.koA.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.xl(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.koh.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.koA).aYL();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.KT(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.iis) {
            this.iis = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.koh != null) {
                this.koh.onConfigurationChanged(configuration);
            }
            if (this.kom != null) {
                this.kom.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cNn() {
        if (this.kkl != null) {
            return this.kkl.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.kkl.getPbData().cKL().kiW;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dlf().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dlf().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dlf().remove(i2);
                    list.get(i).dlh();
                    z = true;
                    break;
                }
            }
            list.get(i).NN(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.kkl.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.cLt().getId();
        List<PostData> list = this.kkl.getPbData().cKL().kiW;
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
                ArrayList<PostData> cLx = pVar.cLx();
                postData.Fr(pVar.getTotalCount());
                if (postData.dlf() != null) {
                    postData.dlf().clear();
                    postData.dlf().addAll(cLx);
                }
            }
        }
        if (!this.kkl.getIsFromMark()) {
            this.koh.s(this.kkl.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cLE() {
        return this.knE.cLE();
    }

    public boolean cLF() {
        if (this.kkl == null) {
            return false;
        }
        return this.kkl.cLF();
    }

    public void cNo() {
        if (this.koh != null) {
            this.koh.cPw();
            cbV();
        }
    }

    public PostData cKG() {
        return this.koh.b(this.kkl.kli, this.kkl.cNN());
    }

    public void onBackPressed() {
        if (this.koJ != null && !this.koJ.isEmpty()) {
            int size = this.koJ.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.koJ.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.koJ == null) {
                this.koJ = new ArrayList();
            }
            if (!this.koJ.contains(aVar)) {
                this.koJ.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.koJ == null) {
                this.koJ = new ArrayList();
            }
            if (!this.koJ.contains(aVar)) {
                this.koJ.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.koJ != null) {
            this.koJ.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.af.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNp() {
        if (this.kkl != null && !com.baidu.tbadk.core.util.as.isEmpty(this.kkl.cNL())) {
            com.baidu.tbadk.BdToken.c.aQc().p(com.baidu.tbadk.BdToken.b.dEx, com.baidu.adp.lib.f.b.toLong(this.kkl.cNL(), 0L));
        }
    }

    public com.baidu.tbadk.core.data.be cNq() {
        return this.kob;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KF(String str) {
        if (this.kkl != null && this.kkl.getPbData() != null && this.kkl.getPbData().cKx() != null && this.kkl.getPbData().cKx().aUV()) {
            bv cKx = this.kkl.getPbData().cKx();
            int i = 0;
            if (cKx.aUT()) {
                i = 1;
            } else if (cKx.aUU()) {
                i = 2;
            } else if (cKx.aYg()) {
                i = 3;
            } else if (cKx.aYh()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap(str);
            apVar.ah("obj_source", 4);
            apVar.ah("obj_type", i);
            TiebaStatic.log(apVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BL(final int i) {
        com.baidu.tbadk.util.ad.a(new com.baidu.tbadk.util.ac<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.84
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: aTq */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(PbFragment.this.getContext(), PbFragment.this.cMO(), i2, PbFragment.this.kkl);
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), i, shareItem, false));
            }
        });
        com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13833");
        apVar.ah("obj_locate", 1);
        if (i == 3) {
            apVar.ah("obj_type", 1);
        } else if (i == 8) {
            apVar.ah("obj_type", 2);
        }
        TiebaStatic.log(apVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cNr() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cNs() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cNt() {
        return this.knE;
    }
}
