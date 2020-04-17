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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0623a {
    private com.baidu.adp.lib.d.b<TbImageView> dJv;
    private LikeModel dKo;
    private com.baidu.adp.lib.d.b<ImageView> emH;
    private com.baidu.adp.lib.d.b<GifView> emI;
    private com.baidu.adp.lib.d.b<View> epA;
    private com.baidu.adp.lib.d.b<LinearLayout> epB;
    private com.baidu.adp.lib.d.b<RelativeLayout> epC;
    private com.baidu.adp.lib.d.b<TextView> epz;
    private VoiceManager gYp;
    private ar hBV;
    private com.baidu.tieba.frs.profession.permission.c hbV;
    private com.baidu.tieba.f.b hcq;
    public com.baidu.tbadk.core.util.aj iBb;
    private String jpY;
    private PbActivity jsV;
    private com.baidu.tieba.pb.pb.main.b.b jsX;
    public ap jtB;
    private com.baidu.tbadk.core.dialog.i jtC;
    private com.baidu.tbadk.core.dialog.k jtD;
    private boolean jtE;
    private com.baidu.tieba.tbadkCore.data.f jtI;
    private com.baidu.tbadk.editortools.pb.g jtJ;
    private com.baidu.tbadk.editortools.pb.e jtK;
    private com.baidu.tieba.frs.profession.permission.c jtM;
    private EmotionImageData jtN;
    private com.baidu.adp.base.e jtQ;
    private com.baidu.tbadk.core.view.d jtR;
    private BdUniqueId jtS;
    private Runnable jtT;
    private com.baidu.adp.widget.ImageView.a jtU;
    private String jtV;
    private TbRichTextMemeInfo jtW;
    private List<a> jtZ;
    private com.baidu.tieba.pb.pb.main.emotion.model.a jtm;
    private View jtn;
    int jtp;
    private ax jts;
    private com.baidu.tieba.pb.pb.report.a jtu;
    private boolean juA;
    private String juK;
    private com.baidu.tbadk.core.data.p juL;
    public String jub;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a juH = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        @Override // com.baidu.tieba.f.b.a
        public void bP(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cwr();
            } else {
                com.baidu.tieba.pb.a.b.cwq();
            }
        }
    };
    private boolean jsW = false;
    private boolean jsY = false;
    private boolean aWW = false;
    private boolean iTI = false;
    private boolean jsZ = true;
    private int jta = 0;
    private com.baidu.tbadk.core.dialog.b jtb = null;
    private long gAV = -1;
    private long edO = 0;
    private long jtc = 0;
    private long createTime = 0;
    private long edE = 0;
    private boolean jtd = false;
    private com.baidu.tbadk.n.b jte = null;
    private long jtf = 0;
    private boolean jtg = false;
    private long jth = 0;
    private int hzw = 1;
    private String dYx = null;
    private boolean jti = false;
    private boolean isFullScreen = false;
    private String jtj = "";
    private boolean jtk = true;
    private boolean jtl = false;
    private String source = "";
    private int mSkinType = 3;
    int[] jto = new int[2];
    private int jtq = -1;
    private int jtr = -1;
    private PbInterviewStatusView.a jtt = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.jtx.ru(!PbFragment.this.jtk);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.jqc != null && PbFragment.this.jqc.aGZ()) {
                        PbFragment.this.cxP();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel jqc = null;
    private com.baidu.tbadk.baseEditMark.a jtv = null;
    private ForumManageModel gqa = null;
    private com.baidu.tbadk.coreExtra.model.a dzD = null;
    private com.baidu.tieba.pb.data.m jtw = null;
    private ShareSuccessReplyToServerModel hoY = null;
    private an jtx = null;
    private boolean jty = false;
    private boolean jtz = false;
    private boolean jtA = false;
    private boolean eEg = false;
    private boolean jtF = false;
    private boolean jtG = false;
    private boolean jtH = false;
    private boolean jtL = false;
    public boolean jtO = false;
    private com.baidu.tbadk.editortools.pb.c dYA = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aXn() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b dYB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXm() {
            if (PbFragment.this.jtB == null || PbFragment.this.jtB.cBz() == null || !PbFragment.this.jtB.cBz().deU()) {
                return !PbFragment.this.zw(com.baidu.tbadk.core.util.aj.dzy);
            }
            PbFragment.this.showToast(PbFragment.this.jtB.cBz().deW());
            if (PbFragment.this.jtK != null && (PbFragment.this.jtK.aXC() || PbFragment.this.jtK.aXD())) {
                PbFragment.this.jtK.a(false, PbFragment.this.jtB.cBC());
            }
            PbFragment.this.jtB.rG(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b jtP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXm() {
            if (PbFragment.this.jtB == null || PbFragment.this.jtB.cBA() == null || !PbFragment.this.jtB.cBA().deU()) {
                return !PbFragment.this.zw(com.baidu.tbadk.core.util.aj.dzz);
            }
            PbFragment.this.showToast(PbFragment.this.jtB.cBA().deW());
            if (PbFragment.this.jtx != null && PbFragment.this.jtx.cAk() != null && PbFragment.this.jtx.cAk().cxp() != null && PbFragment.this.jtx.cAk().cxp().aXD()) {
                PbFragment.this.jtx.cAk().cxp().a(PbFragment.this.jtB.cBC());
            }
            PbFragment.this.jtB.rH(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean gZb = false;
    private int jtX = 0;
    private int jtY = -1;
    public int jua = 0;
    private final a juc = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.jtx != null && PbFragment.this.jtx.cAk() != null) {
                s cAk = PbFragment.this.jtx.cAk();
                if (cAk.cxn()) {
                    cAk.cxm();
                    return true;
                }
            }
            if (PbFragment.this.jtx != null && PbFragment.this.jtx.cBi()) {
                PbFragment.this.jtx.cBj();
                return true;
            }
            return false;
        }
    };
    private final x.a jud = new x.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void aS(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.jtx.showToast(str);
            }
        }
    };
    private final CustomMessageListener jue = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jqc != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.jtK != null) {
                    PbFragment.this.jtx.rz(PbFragment.this.jtK.aXv());
                }
                PbFragment.this.jtx.cAm();
                PbFragment.this.jtx.cBa();
            }
        }
    };
    CustomMessageListener gZE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                PbFragment.this.jqc.updateCurrentUserPendant((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                if (PbFragment.this.jtx != null && PbFragment.this.jqc != null) {
                    PbFragment.this.jtx.b(PbFragment.this.jqc.getPbData(), PbFragment.this.jqc.cyB(), PbFragment.this.jqc.cyY(), PbFragment.this.jtx.getSkinType());
                }
                if (PbFragment.this.jtx != null && PbFragment.this.jtx.cAD() != null) {
                    PbFragment.this.jtx.cAD().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener juf = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.jtx != null) {
                    if (booleanValue) {
                        PbFragment.this.jtx.chm();
                    } else {
                        PbFragment.this.jtx.chl();
                    }
                }
            }
        }
    };
    private CustomMessageListener jug = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.jtK != null) {
                    PbFragment.this.jtx.rz(PbFragment.this.jtK.aXv());
                }
                PbFragment.this.jtx.rB(false);
            }
        }
    };
    private CustomMessageListener juh = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener jui = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jtx != null && PbFragment.this.jtx.cAD() != null) {
                PbFragment.this.jtx.cAD().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener ieX = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener gZB = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.aWW) {
                PbFragment.this.cyg();
            }
        }
    };
    private View.OnClickListener dZi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.dYx);
        }
    };
    private CustomMessageListener juj = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                ar.a aVar = new ar.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.thumbnailUrl = abVar.thumbnailUrl;
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqc.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.jqc.cyP() != null && PbFragment.this.jqc.cyP().getUserIdLong() == abVar.toUserId) {
                        PbFragment.this.jtx.a(abVar.sendCount, PbFragment.this.jqc.getPbData(), PbFragment.this.jqc.cyB(), PbFragment.this.jqc.cyY());
                    }
                    if (pbData.cvw() != null && pbData.cvw().size() >= 1 && pbData.cvw().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cvw().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.jqc.cyA(), 0L);
                        if (j == abVar.postId && j2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.ar cWz = pbData.cvw().get(0).cWz();
                            if (cWz == null) {
                                cWz = new com.baidu.tbadk.core.data.ar();
                            }
                            ArrayList<ar.a> aJC = cWz.aJC();
                            if (aJC == null) {
                                aJC = new ArrayList<>();
                            }
                            aJC.add(0, aVar);
                            cWz.setTotal(abVar.sendCount + cWz.getTotal());
                            cWz.w(aJC);
                            pbData.cvw().get(0).a(cWz);
                            PbFragment.this.jtx.cAD().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hqe = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                PbFragment.this.Hv((String) customResponsedMessage.getData());
                PbFragment.this.jqc.cyU();
                if (PbFragment.this.jtx.cAD() != null) {
                    PbFragment.this.jtx.o(PbFragment.this.jqc.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a juk = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cBR()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a jul = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aS(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.jtx != null) {
                PbFragment.this.jtx.dS(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean jum = false;
    private PraiseModel jun = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void yE(String str) {
            PbFragment.this.jum = false;
            if (PbFragment.this.jun != null) {
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqc.getPbData();
                if (pbData.cvu().aKp().getIsLike() == 1) {
                    PbFragment.this.ul(0);
                } else {
                    PbFragment.this.ul(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cvu()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.jum = false;
            if (PbFragment.this.jun != null && str != null) {
                if (AntiHelper.bq(i, str)) {
                    AntiHelper.bi(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a juo = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void ra(boolean z) {
            PbFragment.this.qZ(z);
            if (PbFragment.this.jtx.cBo() != null && z) {
                PbFragment.this.jtx.ru(false);
            }
            PbFragment.this.jtx.rw(z);
        }
    };
    private CustomMessageListener dzH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().dOo != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().dOo, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.cvB().aKE() != null && PbFragment.this.cvB().aKE().getGodUserData() != null) {
                            PbFragment.this.cvB().aKE().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().cvu() != null && PbFragment.this.jqc.getPbData().cvu().aKE() != null) {
                            PbFragment.this.jqc.getPbData().cvu().aKE().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h gXv = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.jsV.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a jup = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.jtx.bzU();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.zy(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.bXu();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c dRh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cxy();
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
                            PbFragment.this.c((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.jtx.cxw() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").cI("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cws() != null && PbFragment.this.cws().gHS != null) {
                                PbFragment.this.cws().gHS.onClick(view);
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
                if (PbFragment.this.jtK != null) {
                    PbFragment.this.jtx.rz(PbFragment.this.jtK.aXv());
                }
                PbFragment.this.jtx.cAm();
                PbFragment.this.jtx.cBa();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener juq = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jtS) {
                PbFragment.this.jtx.bzU();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqc.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cvH().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.jtR.showSuccessToast(PbFragment.this.jtQ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.jtQ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.wF(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cyd();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.jtQ.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.jtR.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener jur = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jtS) {
                PbFragment.this.jtx.bzU();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.jtR.showSuccessToast(PbFragment.this.jtQ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.jtQ.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.jtR.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener jus = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jtS) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.jtx.bzU();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.lgE;
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
                    PbFragment.this.jtx.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener jut = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jtx.cAn() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cxy();
            }
        }
    };
    private CustomMessageListener gZM = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.gZb = true;
                }
            }
        }
    };
    public a.b jeL = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bOU();
            com.baidu.tbadk.core.data.ap pageData = PbFragment.this.jqc.getPageData();
            int pageNum = PbFragment.this.jtx.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aJv()) {
                PbFragment.this.jtx.cBa();
                PbFragment.this.bOT();
                PbFragment.this.jtx.cAH();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.jqc.zA(PbFragment.this.jtx.getPageNum());
                    if (PbFragment.this.jsX != null) {
                        PbFragment.this.jsX.showFloatingView();
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
    public final View.OnClickListener haA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
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
            boolean w;
            String name;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.jtx.cAW()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.jqc.rf(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.jtx.cAI();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.jtx.jzG.cCe() == null || view != PbFragment.this.jtx.jzG.cCe().czN()) {
                        if (view == PbFragment.this.jtx.jzG.efU) {
                            if (PbFragment.this.jtx.ry(PbFragment.this.jqc.cyG())) {
                                PbFragment.this.bOT();
                                return;
                            }
                            PbFragment.this.jsZ = false;
                            PbFragment.this.jsY = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.jsV, PbFragment.this.jtx.jzG.efU);
                            PbFragment.this.jsV.finish();
                        } else if (view != PbFragment.this.jtx.cAF() && (PbFragment.this.jtx.jzG.cCe() == null || (view != PbFragment.this.jtx.jzG.cCe().czM() && view != PbFragment.this.jtx.jzG.cCe().czK()))) {
                            if (view == PbFragment.this.jtx.cBe()) {
                                if (PbFragment.this.jqc != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jqc.getPbData().cvu().aKD().getLink());
                                }
                            } else if (view != PbFragment.this.jtx.jzG.jFK) {
                                if (view == PbFragment.this.jtx.jzG.jFL) {
                                    if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                        ArrayList<PostData> cvw = PbFragment.this.jqc.getPbData().cvw();
                                        if ((cvw == null || cvw.size() <= 0) && PbFragment.this.jqc.cyB()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").cI("tid", PbFragment.this.jqc.cyA()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", PbFragment.this.jqc.getForumId()));
                                        if (!PbFragment.this.jtx.cBt()) {
                                            PbFragment.this.jtx.cAm();
                                        }
                                        PbFragment.this.cxH();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.jtx.qP(true);
                                        PbFragment.this.jtx.cAm();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.jtx.chm();
                                            PbFragment.this.bOT();
                                            PbFragment.this.jtx.cAH();
                                            PbFragment.this.jqc.HC(PbFragment.this.cxT());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.jtx.jzG.cCe() == null || view != PbFragment.this.jtx.jzG.cCe().czJ()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.jtx.jzG.cCe() != null && view == PbFragment.this.jtx.jzG.cCe().czI()) {
                                            PbFragment.this.jtx.jzG.aAi();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.jtx.jzG.cCe() == null || view != PbFragment.this.jtx.jzG.cCe().czG()) {
                                                if ((PbFragment.this.jtx.jzG.cCe() == null || view != PbFragment.this.jtx.jzG.cCe().czP()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.jtx.jzG.cCe() == null || view != PbFragment.this.jtx.jzG.cCe().czH()) {
                                                        if (PbFragment.this.jtx.jzG.cCe() == null || view != PbFragment.this.jtx.jzG.cCe().czQ()) {
                                                            if (PbFragment.this.jtx.cBo() == view) {
                                                                if (PbFragment.this.jtx.cBo().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.e pbData2 = PbFragment.this.jqc.getPbData();
                                                                    if (pbData2 != null && pbData2.cvu() != null && pbData2.cvu().aKk() != null) {
                                                                        String aKb = pbData2.cvu().aKk().aKb();
                                                                        if (StringUtils.isNull(aKb)) {
                                                                            aKb = pbData2.cvu().aKk().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").cI("obj_id", aKb));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.eQ("c10725", null);
                                                                }
                                                                PbFragment.this.cya();
                                                            } else if (PbFragment.this.jtx.jzG.cCe() == null || view != PbFragment.this.jtx.jzG.cCe().czO()) {
                                                                if (PbFragment.this.jtx.jzG.cCe() != null && view == PbFragment.this.jtx.jzG.cCe().czL()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.jtx.b(PbFragment.this.jqc.getPbData(), PbFragment.this.jqc.cyB(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.jtx.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.jtx.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.jtx.jzG.aAi();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.cI("tid", PbFragment.this.jqc.cyA());
                                                                        anVar.cI("fid", PbFragment.this.jqc.getForumId());
                                                                        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.af("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                                                            PbFragment.this.jtx.cBa();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cWD() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.kTm != null) {
                                                                                    com.baidu.tbadk.core.util.an aOQ = postData.kTm.aOQ();
                                                                                    aOQ.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aOQ.af("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aOQ.af("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aOQ);
                                                                                }
                                                                                String cyA = PbFragment.this.jqc.cyA();
                                                                                String id = postData.getId();
                                                                                int i3 = 0;
                                                                                if (PbFragment.this.jqc.getPbData() != null) {
                                                                                    i3 = PbFragment.this.jqc.getPbData().cvG();
                                                                                }
                                                                                PbFragment.this.bOT();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a HA = PbFragment.this.HA(id);
                                                                                    if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && HA != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cyA, id, "pb", true, null, true, null, i3, postData.cDb(), PbFragment.this.jqc.getPbData().getAnti(), false, postData.aKE().getIconInfo()).addBigImageData(HA.jqh, HA.jqi, HA.jqj, HA.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.jqc.czj());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.jqc.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.jqc.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.jqc.cyI());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a HA2 = PbFragment.this.HA(id);
                                                                                    if (postData != null && PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && HA2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cyA, id, "pb", true, null, false, null, i3, postData.cDb(), PbFragment.this.jqc.getPbData().getAnti(), false, postData.aKE().getIconInfo()).addBigImageData(HA2.jqh, HA2.jqi, HA2.jqj, HA2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.jqc.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.jqc.cyI());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.jqc.czj());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.jqc.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").af("obj_locate", 3).cI("fid", PbFragment.this.jqc.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.jqc != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.cI("tid", PbFragment.this.jqc.cyA());
                                                                        anVar2.cI("fid", PbFragment.this.jqc.getForumId());
                                                                        anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.af("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (postData2.kTm != null) {
                                                                                    com.baidu.tbadk.core.util.an aOQ2 = postData2.kTm.aOQ();
                                                                                    aOQ2.delete("obj_locate");
                                                                                    aOQ2.af("obj_locate", 8);
                                                                                    TiebaStatic.log(aOQ2);
                                                                                }
                                                                                if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                                                                    String cyA2 = PbFragment.this.jqc.cyA();
                                                                                    String id2 = postData2.getId();
                                                                                    int i4 = 0;
                                                                                    if (PbFragment.this.jqc.getPbData() != null) {
                                                                                        i4 = PbFragment.this.jqc.getPbData().cvG();
                                                                                    }
                                                                                    PbActivity.a HA3 = PbFragment.this.HA(id2);
                                                                                    if (HA3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cyA2, id2, "pb", true, null, false, null, i4, postData2.cDb(), PbFragment.this.jqc.getPbData().getAnti(), false, postData2.aKE().getIconInfo()).addBigImageData(HA3.jqh, HA3.jqi, HA3.jqj, HA3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.jqc.czj());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.jqc.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.jqc.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.jqc.cyI());
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
                                                                    if (PbFragment.this.jqc != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.cI("tid", PbFragment.this.jqc.cyA());
                                                                        anVar3.cI("fid", PbFragment.this.jqc.getForumId());
                                                                        anVar3.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.af("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (postData3.kTm != null) {
                                                                                    com.baidu.tbadk.core.util.an aOQ3 = postData3.kTm.aOQ();
                                                                                    aOQ3.delete("obj_locate");
                                                                                    aOQ3.af("obj_locate", 8);
                                                                                    TiebaStatic.log(aOQ3);
                                                                                }
                                                                                if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.cxv().cAj() != null && postData3.aKE() != null && postData3.cWr() != 1) {
                                                                                    if (PbFragment.this.cxv().cAk() != null) {
                                                                                        PbFragment.this.cxv().cAk().cxl();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                                                                    lVar.a(PbFragment.this.jqc.getPbData().getForum());
                                                                                    lVar.setThreadData(PbFragment.this.jqc.getPbData().cvu());
                                                                                    lVar.f(postData3);
                                                                                    PbFragment.this.cxv().cAj().d(lVar);
                                                                                    PbFragment.this.cxv().cAj().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.aKE().getUserId(), "");
                                                                                    if (PbFragment.this.jtK != null) {
                                                                                        PbFragment.this.jtx.rz(PbFragment.this.jtK.aXv());
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
                                                                } else if (view != PbFragment.this.jtx.cwN()) {
                                                                    if (view == PbFragment.this.jtx.jzG.cCf()) {
                                                                        PbFragment.this.jtx.cAO();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (boVar = (bo) view.getTag()) != null && !StringUtils.isNull(boVar.aMM())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.aOY().b(PbFragment.this.getPageContext(), new String[]{boVar.aMM()});
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").cI("tid", PbFragment.this.jqc.jvS));
                                                                                    }
                                                                                    if (PbFragment.this.jtD == null) {
                                                                                        PbFragment.this.jtD = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.jtD.a(PbFragment.this.juG);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cD(view);
                                                                                    if (!PbFragment.this.cD(view) || PbFragment.this.jtU == null || !PbFragment.this.jtU.isGif()) {
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
                                                                                        if (postData4.cWt() != null && postData4.cWt().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.jtD);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar4.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar4);
                                                                                        }
                                                                                        PbFragment.this.hSV = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.jqc.getPbData().aGZ()) {
                                                                                        String aGY = PbFragment.this.jqc.getPbData().aGY();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(aGY) && aGY.equals(postData4.getId())) {
                                                                                            z = true;
                                                                                            if (!z) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.jtD);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.jtD);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.hSV);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z4 && z3) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.jtD);
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
                                                                                                    if (PbFragment.this.qV(z2) && TbadkCoreApplication.isLogin()) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.jtD);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jtD);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.jtD);
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
                                                                                                    if (PbFragment.this.jqc.getPbData().cvG() == 1002 && !z2) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.jtD);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jtD);
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
                                                                                            PbFragment.this.jtD.aI(arrayList);
                                                                                            PbFragment.this.jtC = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jtD);
                                                                                            PbFragment.this.jtC.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z = false;
                                                                                    if (!z) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.hSV);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.jtD.aI(arrayList);
                                                                                    PbFragment.this.jtC = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jtD);
                                                                                    PbFragment.this.jtC.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().cvu() != null && PbFragment.this.jqc.getPbData().cvu().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.jqc.getPbData().cvu().getActUrl());
                                                                                if (PbFragment.this.jqc.getPbData().cvu().aLo() != 1) {
                                                                                    if (PbFragment.this.jqc.getPbData().cvu().aLo() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str2 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").cI("fid", PbFragment.this.jqc.getPbData().getForumId()).cI("tid", PbFragment.this.jqc.getPbData().getThreadId()).cI("lotterytail", StringUtils.string(str2, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.jqc.getPbData().getThreadId().equals(str2)) {
                                                                                    PbFragment.this.jtx.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.jtx.cAm();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.cxE() == 1 && PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").cI("fid", PbFragment.this.jqc.getPbData().getForumId()).cI("tid", PbFragment.this.jqc.getPbData().getThreadId()).cI("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.cxE() == 1 && PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").cI("fid", PbFragment.this.jqc.getPbData().getForumId()).cI("tid", PbFragment.this.jqc.getPbData().getThreadId()).cI("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.cxV();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.cxW();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().cvM() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData3 = PbFragment.this.jqc.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").cI("fid", pbData3.getForumId()));
                                                                                ba.aOY().b(PbFragment.this.getPageContext(), new String[]{pbData3.cvM().cvX()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().cvM() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData4 = PbFragment.this.jqc.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cI("fid", pbData4.getForumId()));
                                                                                ba.aOY().b(PbFragment.this.getPageContext(), new String[]{pbData4.cvM().cvX()});
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.jtX >= 0) {
                                                                                if (PbFragment.this.jqc != null) {
                                                                                    PbFragment.this.jqc.czk();
                                                                                }
                                                                                if (PbFragment.this.jqc != null && PbFragment.this.jtx.cAD() != null) {
                                                                                    PbFragment.this.jtx.cAD().a(PbFragment.this.jqc.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.jtX = 0;
                                                                                if (PbFragment.this.jqc != null) {
                                                                                    PbFragment.this.jtx.getListView().setSelection(PbFragment.this.jqc.czn());
                                                                                    PbFragment.this.jqc.cy(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.cxB();
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
                                                                            if (PbFragment.this.jtx.getListView() != null && PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.jtx.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.jtx.getListView().getChildAt(0);
                                                                                int top2 = childAt == null ? 0 : childAt.getTop();
                                                                                boolean aQh = PbFragment.this.jqc.getPbData().aQh();
                                                                                boolean z7 = PbFragment.this.jtx.cAl() != null && PbFragment.this.jtx.cAl().brK();
                                                                                boolean cAX = PbFragment.this.jtx.cAX();
                                                                                boolean z8 = firstVisiblePosition == 0 && top2 == 0;
                                                                                int i5 = 0;
                                                                                if (aQh && PbFragment.this.jtx.cAl() != null && PbFragment.this.jtx.cAl().blG() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.jtx.cAl().cBO();
                                                                                    z8 = firstVisiblePosition == 0 && (top2 == equipmentWidth || top2 == PbFragment.this.jtx.cAl().blG().getHeight() - PbFragment.this.jtx.cAl().cBO());
                                                                                    i5 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.HB("c13568");
                                                                                if ((PbFragment.this.jqc.getPbData().cvu() != null && PbFragment.this.jqc.getPbData().cvu().aKv() <= 0) || (cAX && z8)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.cxB();
                                                                                        if (PbFragment.this.jqc.getPbData().cvu().aKE() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", PbFragment.this.jqc.jvS).cI("fid", PbFragment.this.jqc.getPbData().getForumId()).af("obj_locate", 2).cI("uid", PbFragment.this.jqc.getPbData().cvu().aKE().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z9 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (aQh) {
                                                                                        if (PbFragment.this.jtx.jAN != null && PbFragment.this.jtx.jAN.jBR != null && PbFragment.this.jtx.jAN.jBR.getView() != null) {
                                                                                            if (PbFragment.this.jtx.jAN.jBR.getView().getParent() == null) {
                                                                                                z9 = firstVisiblePosition >= PbFragment.this.cxL();
                                                                                            } else {
                                                                                                int i6 = 0;
                                                                                                if (PbFragment.this.jtx.cAl() != null && PbFragment.this.jtx.cAl().blG() != null) {
                                                                                                    i6 = PbFragment.this.jtx.cAl().blG().getBottom();
                                                                                                }
                                                                                                z9 = PbFragment.this.jtx.jAN.jBR.getView().getTop() <= i6;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.jtx.cAu() != null) {
                                                                                        z9 = PbFragment.this.jtx.cAu().getVisibility() == 0;
                                                                                        if (!z9 && PbFragment.this.jtx.jAN != null && PbFragment.this.jtx.jAN.jBR != null && PbFragment.this.jtx.jAN.jBR.getView() != null && PbFragment.this.jtx.jAN.jBR.getView().getParent() != null && PbFragment.this.jtx.jzG != null && PbFragment.this.jtx.jzG.mNavigationBar != null) {
                                                                                            z9 = PbFragment.this.jtx.jAN.jBR.getView().getTop() - PbFragment.this.jtx.jzG.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z9 || cAX) {
                                                                                        PbFragment.this.jtq = firstVisiblePosition;
                                                                                        PbFragment.this.jtr = top2;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top2 < (-equipmentHeight))) {
                                                                                            PbFragment.this.jtx.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                            PbFragment.this.jtx.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.jtx.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.jtq > 0) {
                                                                                        if (PbFragment.this.jtx.getListView().getChildAt(PbFragment.this.jtq) != null) {
                                                                                            PbFragment.this.jtx.getListView().smoothScrollToPosition(PbFragment.this.jtq, PbFragment.this.jtr, 200);
                                                                                        } else {
                                                                                            PbFragment.this.jtx.getListView().setSelectionFromTop(PbFragment.this.jtq, PbFragment.this.jtr + equipmentHeight);
                                                                                            PbFragment.this.jtx.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int cxL = PbFragment.this.cxL();
                                                                                        if (PbFragment.this.cxK() != -1) {
                                                                                            cxL--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (cxL < 0) {
                                                                                            i = PbFragment.this.jtx.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.jtx.getListView().getData()) - 1);
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            i = cxL;
                                                                                            i2 = dimens;
                                                                                        }
                                                                                        if (z7) {
                                                                                            i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!aQh || PbFragment.this.jtx.cAl() == null) {
                                                                                            if (PbFragment.this.jtx.jzG != null && PbFragment.this.jtx.jzG.mNavigationBar != null) {
                                                                                                i2 += PbFragment.this.jtx.jzG.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i2 += PbFragment.this.jtx.cAl().cBN();
                                                                                        }
                                                                                        if (PbFragment.this.jtx.jAN == null || PbFragment.this.jtx.jAN.jBR == null || PbFragment.this.jtx.jAN.jBR.getView() == null || PbFragment.this.jtx.jAN.jBR.getView().getParent() == null) {
                                                                                            PbFragment.this.jtx.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                            PbFragment.this.jtx.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z7) {
                                                                                            PbFragment.this.jtx.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                        } else {
                                                                                            PbFragment.this.jtx.getListView().smoothScrollBy(PbFragment.this.jtx.jAN.jBR.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.jqc.getPbData().cvu() != null && PbFragment.this.jqc.getPbData().cvu().aKE() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", PbFragment.this.jqc.jvS).cI("fid", PbFragment.this.jqc.getPbData().getForumId()).af("obj_locate", 2).cI("uid", PbFragment.this.jqc.getPbData().cvu().aKE().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.jqc.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.jqc.czj() == 3) {
                                                                                    PbFragment.this.jsV.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.jqc.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.cI("tid", PbFragment.this.jqc.cyA());
                                                                                anVar4.cI("fid", PbFragment.this.jqc.getForumId());
                                                                                anVar4.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar = (bj) view.getTag();
                                                                                if (PbFragment.this.jqc.czj() == 3 && PbFragment.this.cwt() && PbFragment.this.jqc.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.jqc.getPbData().cvN())) {
                                                                                    PbFragment.this.jsV.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar.aKJ(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.cI("tid", bjVar.getId());
                                                                                anVar5.t("fid", bjVar.getFid());
                                                                                anVar5.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbFragment.this.jqc != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.cI("tid", PbFragment.this.jqc.cyA());
                                                                                anVar6.cI("fid", PbFragment.this.jqc.getForumId());
                                                                                anVar6.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.af("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData5 = PbFragment.this.jqc.getPbData();
                                                                                if (PbFragment.this.jtw == null) {
                                                                                    PbFragment.this.jtw = new com.baidu.tieba.pb.data.m(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").t("forum_id", j2).aOR();
                                                                                PbFragment.this.registerListener(PbFragment.this.juv);
                                                                                PbFragment.this.jtw.E(j, j2);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").cI("fid", PbFragment.this.jqc.getForumId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("obj_name", smartApp.name).t("obj_id", smartApp.swan_app_id.longValue()).cI("obj_source", "PB_card").cI("tid", PbFragment.this.jqc.cyA()).af("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar2 = (bj) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar2.aKJ(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cI("page_type", PageStayDurationConstants.PageName.PB).af("obj_isad", 1).af("obj_floor", 1).af("obj_adlocate", 9).af("obj_locate", 9).t("obj_id", bjVar2.getFid()).cI("tid", bjVar2.getId()).af("thread_type", bjVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bj) && PbFragment.this.checkUpIsLogin()) {
                                                                                bj bjVar3 = (bj) view.getTag();
                                                                                if (PbFragment.this.dKo != null) {
                                                                                    PbFragment.this.dKo.eP(bjVar3.aKJ(), String.valueOf(bjVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cI("page_type", PageStayDurationConstants.PageName.PB).af("obj_isad", 1).af("obj_floor", 1).af("obj_adlocate", 10).af("obj_locate", 11).t("obj_id", bjVar3.getFid()).cI("tid", bjVar3.getId()).af("thread_type", bjVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.jqc.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.jqc.cyA(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.jqc.getPbData().cvu().aKY())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.jtx.cBa();
                                                                SparseArray<Object> b3 = PbFragment.this.jtx.b(PbFragment.this.jqc.getPbData(), PbFragment.this.jqc.cyB(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jqc.getPbData().getForum().getId(), PbFragment.this.jqc.getPbData().getForum().getName(), PbFragment.this.jqc.getPbData().cvu().getId(), String.valueOf(PbFragment.this.jqc.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                com.baidu.tbadk.core.util.am.v(true, false);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).af("obj_type", 0).af("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).af("obj_type", 1).af("obj_source", 1));
                                                            }
                                                            PbFragment.this.jtx.jzG.cCd();
                                                        }
                                                    } else if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().cvu() != null) {
                                                        PbFragment.this.jtx.jzG.aAi();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.Hx(PbFragment.this.jqc.getPbData().cvu().aKU());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.jtx.cBa();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.jqc.cyS()));
                                                            return;
                                                        }
                                                        PbFragment.this.bOT();
                                                        PbFragment.this.jtx.cAH();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.jqc.getPbData().jnv == null || PbFragment.this.jqc.getPbData().jnv.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.jqc.getPbData().jnv.size()];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int i8 = i7;
                                                                if (i8 >= PbFragment.this.jqc.getPbData().jnv.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i8] = PbFragment.this.jqc.getPbData().jnv.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i7 = i8 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                int i10 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.jqc.getSortType() == 1 && i9 == 1) {
                                                                    i10 = 0;
                                                                } else if (PbFragment.this.jqc.getSortType() == 2 && i9 == 0) {
                                                                    i10 = 1;
                                                                } else if (PbFragment.this.jqc.getSortType() != 3 || i9 == 2) {
                                                                    i10 = (i9 != 2 || PbFragment.this.jqc.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").af("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).af("obj_type", i10));
                                                                if (PbFragment.this.jqc.getPbData().jnv != null && PbFragment.this.jqc.getPbData().jnv.size() > i9) {
                                                                    i9 = PbFragment.this.jqc.getPbData().jnv.get(i9).sort_type.intValue();
                                                                }
                                                                boolean zF = PbFragment.this.jqc.zF(i9);
                                                                view.setTag(Integer.valueOf(PbFragment.this.jqc.cyS()));
                                                                if (zF) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.jtx.rp(true);
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
                                                PbFragment.this.jtx.cBa();
                                                if (PbFragment.this.cwD().getPbData().jnw != 2) {
                                                    if (PbFragment.this.jqc.getPageData() != null) {
                                                        PbFragment.this.jtx.a(PbFragment.this.jqc.getPageData(), PbFragment.this.jeL);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.jqc.getPbData()) != null) {
                                            bj cvu = pbData.cvu();
                                            if (cvu != null && cvu.aKE() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", PbFragment.this.jqc.jvS).cI("fid", pbData.getForumId()).af("obj_locate", 4).cI("uid", cvu.aKE().getUserId()));
                                            }
                                            int i9 = 1;
                                            if (cvu != null) {
                                                if (cvu.aJt()) {
                                                    i9 = 2;
                                                } else if (cvu.aJu()) {
                                                    i9 = 3;
                                                } else if (cvu.aMy()) {
                                                    i9 = 4;
                                                } else if (cvu.aMz()) {
                                                    i9 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.cI("tid", PbFragment.this.jqc.cyA());
                                            anVar7.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.cI("fid", PbFragment.this.jqc.getForumId());
                                            if (view.getId() == R.id.share_num_container) {
                                                anVar7.af("obj_locate", 5);
                                            } else {
                                                anVar7.af("obj_locate", 6);
                                            }
                                            anVar7.af("obj_name", i9);
                                            anVar7.af("obj_type", 1);
                                            if (cvu != null) {
                                                if (cvu.aJt()) {
                                                    anVar7.af("obj_type", 10);
                                                } else if (cvu.aJu()) {
                                                    anVar7.af("obj_type", 9);
                                                } else if (cvu.aMz()) {
                                                    anVar7.af("obj_type", 8);
                                                } else if (cvu.aMy()) {
                                                    anVar7.af("obj_type", 7);
                                                } else if (cvu.isShareThread) {
                                                    anVar7.af("obj_type", 6);
                                                } else if (cvu.threadType == 0) {
                                                    anVar7.af("obj_type", 1);
                                                } else if (cvu.threadType == 40) {
                                                    anVar7.af("obj_type", 2);
                                                } else if (cvu.threadType == 49) {
                                                    anVar7.af("obj_type", 3);
                                                } else if (cvu.threadType == 54) {
                                                    anVar7.af("obj_type", 4);
                                                } else {
                                                    anVar7.af("obj_type", 5);
                                                }
                                            }
                                            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                anVar7.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                            }
                                            TiebaStatic.log(anVar7);
                                            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                PbFragment.this.showToast(R.string.neterror);
                                                return;
                                            } else if (pbData != null) {
                                                ArrayList<PostData> cvw2 = PbFragment.this.jqc.getPbData().cvw();
                                                if ((cvw2 != null && cvw2.size() > 0) || !PbFragment.this.jqc.cyB()) {
                                                    PbFragment.this.jtx.cBa();
                                                    PbFragment.this.bOT();
                                                    if (pbData.cvM() != null && !StringUtils.isNull(pbData.cvM().aIW(), true)) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cI("fid", PbFragment.this.jqc.getPbData().getForumId()));
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                    if (!AntiHelper.d(PbFragment.this.getContext(), cvu)) {
                                                        if (PbFragment.this.jtx != null) {
                                                            PbFragment.this.jtx.cBd();
                                                            PbFragment.this.jtx.t(pbData);
                                                        }
                                                        int i10 = 6;
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.jtx.showLoadingDialog();
                                                            PbFragment.this.jqc.cze().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                        } else {
                                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                                i10 = 2;
                                                            } else if (view.getId() == R.id.share_num_container) {
                                                                i10 = 1;
                                                            }
                                                            PbFragment.this.zy(i10);
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
                                        PbFragment.this.jtx.cBa();
                                        if (PbFragment.this.jtx.jzG.cCe() != null && view == PbFragment.this.jtx.jzG.cCe().czJ() && !PbFragment.this.jtx.cBt()) {
                                            PbFragment.this.jtx.cAm();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bOT();
                                            PbFragment.this.jtx.cAH();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                w = PbFragment.this.jqc.w(true, PbFragment.this.cxT());
                                            } else {
                                                w = view.getId() == R.id.reply_title ? PbFragment.this.jqc.w(false, PbFragment.this.cxT()) : PbFragment.this.jqc.HC(PbFragment.this.cxT());
                                            }
                                            view.setTag(Boolean.valueOf(w));
                                            if (w) {
                                                PbFragment.this.jtx.qP(true);
                                                PbFragment.this.jtx.chm();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.jtx.rp(true);
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
                                    PbFragment.this.jtx.cBa();
                                    if (PbFragment.this.zx(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.jqc.zG(PbFragment.this.jtx.cAM()) != null) {
                                        PbFragment.this.cxO();
                                        if (PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().cvu() != null && PbFragment.this.jqc.getPbData().cvu().aKE() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", PbFragment.this.jqc.jvS).cI("fid", PbFragment.this.jqc.getPbData().getForumId()).af("obj_locate", 3).cI("uid", PbFragment.this.jqc.getPbData().cvu().aKE().getUserId()));
                                        }
                                        if (PbFragment.this.jqc.getPbData().cvu() != null && PbFragment.this.jqc.getPbData().cvu().aKE() != null && PbFragment.this.jqc.getPbData().cvu().aKE().getUserId() != null && PbFragment.this.jtv != null) {
                                            int g = PbFragment.this.g(PbFragment.this.jqc.getPbData());
                                            bj cvu2 = PbFragment.this.jqc.getPbData().cvu();
                                            int i11 = 1;
                                            if (cvu2.aJt()) {
                                                i11 = 2;
                                            } else if (cvu2.aJu()) {
                                                i11 = 3;
                                            } else if (cvu2.aMy()) {
                                                i11 = 4;
                                            } else if (cvu2.aMz()) {
                                                i11 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cI("tid", PbFragment.this.jqc.jvS).af("obj_locate", 1).cI("obj_id", PbFragment.this.jqc.getPbData().cvu().aKE().getUserId()).af("obj_type", PbFragment.this.jtv.aGZ() ? 0 : 1).af("obj_source", g).af("obj_param1", i11));
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
                                if (PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().cvu() != null && PbFragment.this.jqc.getPbData().cvu().aJr() && PbFragment.this.jqc.getPbData().cvu().aKV() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.jqc.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.jqc.cwu()) || PbFragment.this.jqc.getAppealInfo() == null) {
                                        PbFragment.this.jsV.finish();
                                        return;
                                    }
                                    name = PbFragment.this.jqc.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.jqc.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.jsV.finish();
                                    return;
                                }
                                String cwu = PbFragment.this.jqc.cwu();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.jqc.cyC() && cwu != null && cwu.equals(name)) {
                                    PbFragment.this.jsV.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.jqc.getPbData() != null) {
                                if ((PbFragment.this.jqc.getPbData().cvG() == 1 || PbFragment.this.jqc.getPbData().cvG() == 3) && !PbFragment.this.gqa.cXf()) {
                                    PbFragment.this.jtx.cBa();
                                    int i12 = 0;
                                    if (PbFragment.this.jtx.jzG.cCe() == null || view != PbFragment.this.jtx.jzG.cCe().czK()) {
                                        if (PbFragment.this.jtx.jzG.cCe() == null || view != PbFragment.this.jtx.jzG.cCe().czM()) {
                                            if (view == PbFragment.this.jtx.cAF()) {
                                                i12 = 2;
                                            }
                                        } else if (PbFragment.this.jqc.getPbData().cvu().aKA() == 1) {
                                            i12 = 3;
                                        } else {
                                            i12 = 6;
                                        }
                                    } else if (PbFragment.this.jqc.getPbData().cvu().aKz() == 1) {
                                        i12 = 5;
                                    } else {
                                        i12 = 4;
                                    }
                                    ForumData forum = PbFragment.this.jqc.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.jqc.getPbData().cvu().getId();
                                    PbFragment.this.jtx.cAE();
                                    PbFragment.this.gqa.b(id4, name2, id5, i12, PbFragment.this.jtx.cAG());
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
                        PbFragment.this.jtx.cBa();
                        PbFragment.this.bOT();
                        PbFragment.this.jtx.cAH();
                        PbFragment.this.jtx.showLoadingDialog();
                        if (PbFragment.this.jtx.cAu() != null) {
                            PbFragment.this.jtx.cAu().setVisibility(8);
                        }
                        PbFragment.this.jqc.zA(1);
                        if (PbFragment.this.jsX != null) {
                            PbFragment.this.jsX.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cxC = PbFragment.this.cxC();
                        if (!TextUtils.isEmpty(cxC)) {
                            ba.aOY().b(PbFragment.this.getPageContext(), new String[]{cxC});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.cI("tid", PbFragment.this.jqc.cyA());
                anVar8.cI("fid", PbFragment.this.jqc.getForumId());
                anVar8.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.af("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.jtg) {
                    PbFragment.this.jtg = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.cxv().cAj() != null && postData5.aKE() != null && postData5.cWr() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cxv().cAk() != null) {
                                PbFragment.this.cxv().cAk().cxl();
                            }
                            com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                            lVar2.a(PbFragment.this.jqc.getPbData().getForum());
                            lVar2.setThreadData(PbFragment.this.jqc.getPbData().cvu());
                            lVar2.f(postData5);
                            PbFragment.this.cxv().cAj().d(lVar2);
                            PbFragment.this.cxv().cAj().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.aKE().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.jqc.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.jtK != null) {
                                PbFragment.this.jtx.rz(PbFragment.this.jtK.aXv());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.jqc.getPbData() != null) {
                    anVar.cI("fid", PbFragment.this.jqc.getPbData().getForumId());
                }
                anVar.cI("tid", PbFragment.this.jqc.cyA());
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bOT();
            PbFragment.this.jtx.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.cwD() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.cwD().HF(postWriteCallBackData.getPostId());
                    PbFragment.this.jtX = PbFragment.this.jtx.cAq();
                    PbFragment.this.jqc.cy(PbFragment.this.jtX, PbFragment.this.jtx.cAr());
                }
                PbFragment.this.jtx.cBa();
                PbFragment.this.jtB.cBy();
                if (PbFragment.this.jtK != null) {
                    PbFragment.this.jtx.rz(PbFragment.this.jtK.aXv());
                }
                PbFragment.this.jtx.cAi();
                PbFragment.this.jtx.rB(true);
                PbFragment.this.jqc.cyU();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.jqc.getHostMode()) {
                            com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqc.getPbData();
                            if (pbData != null && pbData.cvu() != null && pbData.cvu().aKE() != null && (userId = pbData.cvu().aKE().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.jqc.cyL()) {
                                PbFragment.this.jtx.cAH();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.jqc.cyL()) {
                            PbFragment.this.jtx.cAH();
                        }
                    } else if (floor != null) {
                        PbFragment.this.jtx.o(PbFragment.this.jqc.getPbData());
                    }
                    if (PbFragment.this.jqc.cyF()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").cI("tid", PbFragment.this.jqc.cyA()));
                    }
                    PbFragment.this.cxF();
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.jtK.aXC() || PbFragment.this.jtK.aXD()) {
                    PbFragment.this.jtK.a(false, postWriteCallBackData);
                }
                PbFragment.this.jtB.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.iBb != null) {
                    PbFragment.this.iBb.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d juu = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                    anVar.cI("fid", PbFragment.this.jqc.getPbData().getForumId());
                }
                if (PbFragment.this.jqc != null) {
                    anVar.cI("tid", PbFragment.this.jqc.cyA());
                }
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.jtB != null) {
                    PbFragment.this.jtB.cBx();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.iBb != null) {
                    PbFragment.this.iBb.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.jtB != null) {
                if (PbFragment.this.jtx != null && PbFragment.this.jtx.cAk() != null && PbFragment.this.jtx.cAk().cxp() != null && PbFragment.this.jtx.cAk().cxp().aXD()) {
                    PbFragment.this.jtx.cAk().cxp().a(postWriteCallBackData);
                }
                PbFragment.this.jtB.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a juv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cBw;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.jsV.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.jtx != null && (cBw = PbFragment.this.jtx.cBw()) != null && PbFragment.this.jtx.getListView() != null) {
                            PbFragment.this.jtx.getListView().removeHeaderView(cBw);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a juw = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mA;
            if (!z || eVar == null || eVar.cvE() != null || com.baidu.tbadk.core.util.v.getCount(eVar.cvw()) >= 1) {
                PbFragment.this.iTI = true;
                PbFragment.this.jtx.cAJ();
                if (eVar == null || !eVar.cvA()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.jtx.getView());
                }
                PbFragment.this.jtx.chl();
                if (PbFragment.this.isFullScreen || PbFragment.this.jtx.cBt()) {
                    PbFragment.this.jtx.cBk();
                } else if (!PbFragment.this.jtx.cBh()) {
                    PbFragment.this.jtx.rB(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.eEg = true;
                }
                if (eVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.jtx.getView());
                    PbFragment.this.jtx.cAS();
                }
                if (z && eVar != null) {
                    bj cvu = eVar.cvu();
                    if (cvu == null || !cvu.aMA()) {
                        PbFragment.this.d(PbFragment.this.jtJ);
                    } else {
                        cym();
                    }
                    PbFragment.this.jtx.cAk().setPbData(eVar);
                    PbFragment.this.jtx.bpV();
                    if (cvu != null && cvu.aLM() != null) {
                        PbFragment.this.a(cvu.aLM());
                    }
                    if (PbFragment.this.jtK != null) {
                        PbFragment.this.jtx.rz(PbFragment.this.jtK.aXv());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                    if (eVar.cvw() != null && eVar.cvw().size() >= 1 && eVar.cvw().get(0) != null) {
                        PbFragment.this.jqc.HE(eVar.cvw().get(0).getId());
                    } else if (eVar.cvE() != null) {
                        PbFragment.this.jqc.HE(eVar.cvE().getId());
                    }
                    if (PbFragment.this.jtK != null) {
                        PbFragment.this.jtK.a(eVar.getAnti());
                        PbFragment.this.jtK.a(eVar.getForum(), eVar.getUserData());
                        PbFragment.this.jtK.setThreadData(cvu);
                        PbFragment.this.jtK.a(PbFragment.this.jqc.cyP(), PbFragment.this.jqc.cyA(), PbFragment.this.jqc.czg());
                        if (cvu != null) {
                            PbFragment.this.jtK.hH(cvu.aLY());
                        }
                    }
                    if (PbFragment.this.jtv != null) {
                        PbFragment.this.jtv.gk(eVar.aGZ());
                    }
                    if (eVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (eVar.cvS()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.jtx.rA(PbFragment.this.mIsFromCDN);
                    PbFragment.this.jtx.a(eVar, i2, i3, PbFragment.this.jqc.cyB(), i4, PbFragment.this.jqc.getIsFromMark());
                    PbFragment.this.jtx.d(eVar, PbFragment.this.jqc.cyB());
                    PbFragment.this.jtx.rx(PbFragment.this.jqc.getHostMode());
                    AntiData anti = eVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.dYx = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.dYx) && PbFragment.this.jtK != null && PbFragment.this.jtK.aWP() != null && (mA = PbFragment.this.jtK.aWP().mA(6)) != null && !TextUtils.isEmpty(PbFragment.this.dYx)) {
                            ((View) mA).setOnClickListener(PbFragment.this.dZi);
                        }
                    }
                    if (PbFragment.this.jtF) {
                        PbFragment.this.jtF = false;
                        final int cxK = PbFragment.this.cxK();
                        if (!eVar.aQh()) {
                            PbFragment.this.jtx.zN(cxK);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cxK, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.jtG) {
                        PbFragment.this.jtG = false;
                        final int cxK2 = PbFragment.this.cxK();
                        final boolean z2 = cxK2 != -1;
                        if (!z2) {
                            cxK2 = PbFragment.this.cxL();
                        }
                        if (PbFragment.this.jtx != null) {
                            if (!eVar.aQh()) {
                                PbFragment.this.jtx.zN(cxK2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cxK2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.jtx.setSelectionFromTop(cxK2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.jtx.setSelectionFromTop(cxK2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.jtx.rC(true);
                                PbFragment.this.jtx.rB(false);
                            }
                        }
                    } else if (PbFragment.this.jtH) {
                        PbFragment.this.jtH = false;
                        PbFragment.this.jtx.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.jtx.cAN();
                    }
                    PbFragment.this.jqc.a(eVar.getForum(), PbFragment.this.juk);
                    PbFragment.this.jqc.a(PbFragment.this.jul);
                    if (PbFragment.this.iBb != null && cvu != null && cvu.aKE() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cvu.aKE());
                        PbFragment.this.iBb.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.eEg && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.jqc.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.jqc.getAppealInfo().jno)) {
                                    PbFragment.this.jtx.a(PbFragment.this.jqc.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.jtx.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.jtx.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.jtx.cBk();
                            PbFragment.this.jtx.cAR();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.jqc.cyA());
                            jSONObject.put("fid", PbFragment.this.jqc.getForumId());
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
                        PbFragment.this.jtx.HK("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                            arrayList = PbFragment.this.jqc.getPbData().cvw();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cWr() != 1)) {
                            PbFragment.this.jtx.HK(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbFragment.this.cye()) {
                            PbFragment.this.jtx.HL(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbFragment.this.jtx.HL(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbFragment.this.jtx.endLoadData();
                }
                if (eVar != null && eVar.jnC && PbFragment.this.edO == 0) {
                    PbFragment.this.edO = System.currentTimeMillis() - PbFragment.this.gAV;
                }
                if (!PbFragment.this.cwD().cyB() || PbFragment.this.cwD().getPbData().getPage().aJB() != 0 || PbFragment.this.cwD().czb()) {
                    PbFragment.this.jtL = true;
                    return;
                }
                return;
            }
            PbFragment.this.jqc.zA(1);
            if (PbFragment.this.jsX != null) {
                PbFragment.this.jsX.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cym() {
            if (PbFragment.this.jqc != null) {
                if (PbFragment.this.jtK == null || !PbFragment.this.jtK.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.jtK = (com.baidu.tbadk.editortools.pb.e) dVar.dI(PbFragment.this.getContext());
                    PbFragment.this.jtK.a(PbFragment.this.jsV.getPageContext());
                    PbFragment.this.jtK.a(PbFragment.this.dYH);
                    PbFragment.this.jtK.a(PbFragment.this.dYA);
                    PbFragment.this.jtK.a(PbFragment.this.jsV.getPageContext(), PbFragment.this.jsV.getIntent() == null ? null : PbFragment.this.jsV.getIntent().getExtras());
                    PbFragment.this.jtK.aWP().hA(true);
                    PbFragment.this.jtx.setEditorTools(PbFragment.this.jtK.aWP());
                    if (!PbFragment.this.jqc.cyG()) {
                        PbFragment.this.jtK.wA(PbFragment.this.jqc.cyA());
                    }
                    if (PbFragment.this.jqc.czh()) {
                        PbFragment.this.jtK.wy(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.jtx != null) {
                        PbFragment.this.jtK.wy(PbFragment.this.jtx.cAo());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
            PbFragment.this.jtx.o(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.aZA().aZB()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.gAV : j;
                if (PbFragment.this.edO == 0) {
                    PbFragment.this.edO = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.edE, PbFragment.this.createTime, PbFragment.this.edO, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.edE = 0L;
                if (iVar != null) {
                    iVar.aZx();
                }
                if (z2) {
                    iVar.edX = currentTimeMillis;
                    iVar.hS(true);
                }
                if (!z2 && PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().cvu() != null) {
                    int threadType = PbFragment.this.jqc.getPbData().cvu().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.jtj, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.jtj, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.edZ = currentTimeMillis;
                                iVar2.mY(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.edZ = currentTimeMillis;
                        dVar.mY(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener jux = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cxG();
            }
        }
    };
    private final a.InterfaceC0404a juy = new a.InterfaceC0404a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0404a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.jtx.cAJ();
            if (z) {
                if (PbFragment.this.jtv != null) {
                    PbFragment.this.jtv.gk(z2);
                }
                PbFragment.this.jqc.rh(z2);
                if (PbFragment.this.jqc.aGZ()) {
                    PbFragment.this.cxP();
                } else {
                    PbFragment.this.jtx.o(PbFragment.this.jqc.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.jtv != null) {
                        if (PbFragment.this.jtv.aHc() != null && PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.jqc.getPbData().cvu() != null && PbFragment.this.jqc.getPbData().cvu().aKE() != null) {
                            MarkData aHc = PbFragment.this.jtv.aHc();
                            MetaData aKE = PbFragment.this.jqc.getPbData().cvu().aKE();
                            if (aHc != null && aKE != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aKE.getUserId()) && !aKE.hadConcerned()) {
                                    PbFragment.this.b(aKE);
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
                    PbFragment.this.cxM();
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
            if (!PbFragment.this.zn(PbFragment.this.mLastScrollState) && PbFragment.this.zn(i)) {
                if (PbFragment.this.jtx != null) {
                    PbFragment.this.jtx.cBa();
                    if (PbFragment.this.jtK != null && !PbFragment.this.jtx.cAn()) {
                        PbFragment.this.jtx.rz(PbFragment.this.jtK.aXv());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.jtx.cAm();
                    }
                }
                if (!PbFragment.this.jtd) {
                    PbFragment.this.jtd = true;
                    if (PbFragment.this.jtx != null) {
                        PbFragment.this.jtx.cBg();
                    }
                }
            }
            if (PbFragment.this.jtx != null) {
                PbFragment.this.jtx.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.jsX != null) {
                PbFragment.this.jsX.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.jte == null) {
                PbFragment.this.jte = new com.baidu.tbadk.n.b();
                PbFragment.this.jte.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.jte.aZr();
            } else {
                PbFragment.this.jte.aZq();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.cVr().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cvw;
            if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null && PbFragment.this.jtx != null && PbFragment.this.jtx.cAD() != null) {
                PbFragment.this.jtx.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.jsX != null) {
                    PbFragment.this.jsX.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.jqc.cyX() && (cvw = PbFragment.this.jqc.getPbData().cvw()) != null && !cvw.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.jtx.cAD().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqc.getPbData();
                    if (pbData != null) {
                        if (pbData.cvx() != null && pbData.cvx().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cvy() != null && pbData.cvy().hasData()) {
                            headerCount--;
                        }
                        int size = cvw.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d gqf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.gqa.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.jqc.cyU();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.jHC != 1002 || bVar.fqG) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.jtx.a(1, dVar.OG, dVar.kVc, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.gqa.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.jtx.a(PbFragment.this.gqa.getLoadDataMode(), gVar.OG, gVar.kVc, false);
                            PbFragment.this.jtx.aO(gVar.kVf);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.jtx.a(PbFragment.this.gqa.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c juz = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
    };
    private final g.c eBS = new g.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cxU()) {
                PbFragment.this.jsV.finish();
            }
            if (!PbFragment.this.jqc.rg(true)) {
                PbFragment.this.jtx.cAK();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e juB = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.juA && PbFragment.this.cxU()) {
                PbFragment.this.cxW();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.jqc.rf(false)) {
                    PbFragment.this.jtx.cAI();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.jqc.getPbData() != null) {
                    PbFragment.this.jtx.cBf();
                }
                PbFragment.this.juA = true;
            }
        }
    };
    private int juC = 0;
    private final TbRichTextView.i emS = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f cAD;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.jtx.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.cI("tid", PbFragment.this.jqc.cyA());
                anVar.cI("fid", PbFragment.this.jqc.getForumId());
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.af("obj_locate", 3);
                anVar.af("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.jqc.jqV.cvS()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bci() != null) {
                            ArrayList<TbRichTextImageInfo> bci = tbRichTextView.getRichText().bci();
                            int i4 = 0;
                            while (i4 < bci.size()) {
                                if (bci.get(i4) != null) {
                                    arrayList.add(bci.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bci.get(i4).getSrc()) || str.equals(bci.get(i4).bcA()) || str.equals(bci.get(i4).bcx()) || str.equals(bci.get(i4).bcz()) || str.equals(bci.get(i4).bcD()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bci.get(i4).getSrc();
                                    imageUrlData.originalUrl = bci.get(i4).getSrc();
                                    imageUrlData.isLongPic = bci.get(i4).bcF();
                                    concurrentHashMap.put(bci.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.jqc.cyR(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.jqc.getPbData().cvu());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.jqk) {
                        TbRichText bt = PbFragment.this.bt(str, i);
                        if (bt != null && PbFragment.this.juC >= 0 && PbFragment.this.juC < bt.bch().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.f.b(bt.bch().get(PbFragment.this.juC));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.jqh.size()) {
                                    break;
                                } else if (!aVar.jqh.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bt.getPostId() != 0 && (cAD = PbFragment.this.jtx.cAD()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = cAD.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bt.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bt.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.jqc.czg(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.jqc.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.jqi.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jqj, aVar.lastId, PbFragment.this.jqc.cyR(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.jqc.getPbData().cvu());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.jqh, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.jqi.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jqj, aVar.jqh.get(0), PbFragment.this.jqc.cyR(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.jqc.getPbData().cvu());
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
                PbFragment.this.jtn = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean juD = false;
    PostData hSV = null;
    private final b.a juE = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.hSV != null) {
                if (i == 0) {
                    PbFragment.this.hSV.fm(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.hSV = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.k(PbFragment.this.hSV);
                }
            }
        }
    };
    private final b.a juF = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jtU != null && !TextUtils.isEmpty(PbFragment.this.jtV)) {
                if (i == 0) {
                    if (PbFragment.this.jtW == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.jtV));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.jtV;
                        aVar.pkgId = PbFragment.this.jtW.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.jtW.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.hBV == null) {
                            PbFragment.this.hBV = new ar(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.hBV.j(PbFragment.this.jtV, PbFragment.this.jtU.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.jtU = null;
                PbFragment.this.jtV = null;
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
                if (PbFragment.this.cD(view)) {
                    if (view instanceof TbImageView) {
                        PbFragment.this.jtU = ((TbImageView) view).getBdImage();
                        PbFragment.this.jtV = ((TbImageView) view).getUrl();
                        if (PbFragment.this.jtU == null || TextUtils.isEmpty(PbFragment.this.jtV)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.jtW = null;
                        } else {
                            PbFragment.this.jtW = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.jtU = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.jtV = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.jtW = null;
                            } else {
                                PbFragment.this.jtW = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.jtU = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.jtV = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.jtW = null;
                        } else {
                            PbFragment.this.jtW = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.jtx.a(PbFragment.this.juF, PbFragment.this.jtU.isGif());
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
            PbFragment.this.hSV = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.hSV == null) {
                return true;
            }
            if (PbFragment.this.hSV.cWr() != 1 || !PbFragment.this.cD(view)) {
                if (PbFragment.this.jtv != null) {
                    if (!PbFragment.this.jtv.aGZ() || PbFragment.this.hSV.getId() == null || !PbFragment.this.hSV.getId().equals(PbFragment.this.jqc.aKN())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.cwD().getPbData() != null && PbFragment.this.cwD().getPbData().cvS();
                    if (PbFragment.this.hSV.cWr() != 1) {
                        if (PbFragment.this.jtD == null) {
                            PbFragment.this.jtD = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.jtD.a(PbFragment.this.juG);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = PbFragment.this.cD(view) && !z3;
                            boolean z5 = (!PbFragment.this.cD(view) || PbFragment.this.jtU == null || PbFragment.this.jtU.isGif()) ? false : true;
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
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.jtD));
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.jtD));
                            }
                            if (!z4 && !z5) {
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.jtD);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.hSV);
                                gVar3.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar3);
                            }
                            if (!z2 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.jtD);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.jtD);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.hSV);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z8 && z7) {
                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.jtD);
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
                                    if ((PbFragment.this.qV(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.jtD);
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
                                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jtD);
                                        gVar6.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.jtD);
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
                                        if (PbFragment.this.jqc.getPbData().cvG() == 1002 && !z6) {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.jtD);
                                        } else {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jtD);
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
                            PbFragment.this.jtD.aI(arrayList);
                            PbFragment.this.jtC = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jtD);
                            PbFragment.this.jtC.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").cI("tid", PbFragment.this.jqc.jvS).cI("fid", PbFragment.this.jqc.getForumId()).cI("uid", PbFragment.this.jqc.getPbData().cvu().aKE().getUserId()).cI("post_id", PbFragment.this.jqc.aXk()).af("obj_source", z2 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.jtx.a(PbFragment.this.juE, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.jtx.a(PbFragment.this.juF, PbFragment.this.jtU.isGif());
            return true;
        }
    };
    private k.c juG = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            int i2;
            if (PbFragment.this.jtC != null) {
                PbFragment.this.jtC.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.jtU != null && !TextUtils.isEmpty(PbFragment.this.jtV)) {
                        if (PbFragment.this.jtW == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.jtV));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.jtV;
                            aVar.pkgId = PbFragment.this.jtW.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.jtW.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.jtU = null;
                        PbFragment.this.jtV = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.jtU != null && !TextUtils.isEmpty(PbFragment.this.jtV)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.hBV == null) {
                                PbFragment.this.hBV = new ar(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.hBV.j(PbFragment.this.jtV, PbFragment.this.jtU.getImageByte());
                            PbFragment.this.jtU = null;
                            PbFragment.this.jtV = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.hSV != null) {
                        PbFragment.this.hSV.fm(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.hSV = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").af("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cC(view);
                        if (PbFragment.this.jqc.getPbData().cvu() != null && PbFragment.this.jqc.getPbData().cvu().aKE() != null && PbFragment.this.jqc.getPbData().cvu().aKE().getUserId() != null && PbFragment.this.jtv != null) {
                            int g = PbFragment.this.g(PbFragment.this.jqc.getPbData());
                            bj cvu = PbFragment.this.jqc.getPbData().cvu();
                            if (cvu.aJt()) {
                                i2 = 2;
                            } else if (cvu.aJu()) {
                                i2 = 3;
                            } else if (cvu.aMy()) {
                                i2 = 4;
                            } else {
                                i2 = cvu.aMz() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cI("tid", PbFragment.this.jqc.jvS).af("obj_locate", 2).cI("obj_id", PbFragment.this.jqc.getPbData().cvu().aKE().getUserId()).af("obj_type", PbFragment.this.jtv.aGZ() ? 0 : 1).af("obj_source", g).af("obj_param1", i2));
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
                        PbFragment.this.Hx((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").af("obj_locate", 4));
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
                        PbFragment.this.jtx.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.jtx.cI(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.jtx.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a gVM = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.aWW && z && !PbFragment.this.jqc.cyH()) {
                PbFragment.this.cxR();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener dRW = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.hcq.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0536a gxd = new a.InterfaceC0536a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        final int fqk = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void y(int i, int i2) {
            if (af(i2) && PbFragment.this.jtx != null && PbFragment.this.jsX != null) {
                PbFragment.this.jsX.mK(true);
                if (Math.abs(i2) > this.fqk) {
                    PbFragment.this.jsX.hideFloatingView();
                }
                if (PbFragment.this.cxU()) {
                    PbFragment.this.jtx.cAA();
                    PbFragment.this.jtx.cAB();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void z(int i, int i2) {
            if (af(i2) && PbFragment.this.jtx != null && PbFragment.this.jsX != null) {
                PbFragment.this.jtx.cBl();
                PbFragment.this.jsX.mK(false);
                PbFragment.this.jsX.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void A(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a jsd = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void n(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.jtx.HM(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int juI = -1;
    private int juJ = -1;

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

    public com.baidu.tbadk.editortools.pb.e cxq() {
        return this.jtK;
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (lVar.cwh() != null) {
            String id = lVar.cwh().getId();
            ArrayList<PostData> cvw = this.jqc.getPbData().cvw();
            int i = 0;
            while (true) {
                if (i >= cvw.size()) {
                    break;
                }
                PostData postData = cvw.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cwl = lVar.cwl();
                    postData.Dh(lVar.getTotalCount());
                    if (postData.cWo() != null && cwl != null) {
                        Iterator<PostData> it = cwl.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aKE() != null && (metaData = postData.getUserMap().get(next.aKE().getUserId())) != null) {
                                next.a(metaData);
                                next.tW(true);
                                next.a(getPageContext(), this.jqc.HD(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cwl.size() != postData.cWo().size();
                        postData.cWo().clear();
                        postData.cWo().addAll(cwl);
                        z = z2;
                    }
                    if (postData.cWk() != null) {
                        postData.cWl();
                    }
                }
            }
            if (!this.jqc.getIsFromMark() && z) {
                this.jtx.o(this.jqc.getPbData());
            }
            if (z) {
                c(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m cvJ = this.jqc.getPbData().cvJ();
            if (cvJ != null && str.equals(cvJ.getAdId())) {
                if (cvJ.cWf() != null) {
                    cvJ.cWf().legoCard = null;
                }
                this.jqc.getPbData().cvK();
            }
            com.baidu.tieba.tbadkCore.data.m cyN = this.jqc.cyN();
            if (cyN != null && str.equals(cyN.getAdId())) {
                this.jqc.cyO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.jtC != null && this.jtC.isShowing()) {
                this.jtC.dismiss();
                this.jtC = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.jtC != null) {
                            PbFragment.this.jtC.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.jtx.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.jtS);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.jtS);
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
                kVar.aI(arrayList);
                this.jtC = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.jtC.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(int i) {
        bj cvu;
        if (this.jqc != null && this.jqc.getPbData() != null && (cvu = this.jqc.getPbData().cvu()) != null) {
            if (i == 1) {
                PraiseData aKp = cvu.aKp();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aKp == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cvu.a(praiseData);
                    } else {
                        cvu.aKp().getUser().add(0, metaData);
                        cvu.aKp().setNum(cvu.aKp().getNum() + 1);
                        cvu.aKp().setIsLike(i);
                    }
                }
                if (cvu.aKp() != null) {
                    if (cvu.aKp().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(cvu.aKp().getNum());
                    }
                }
            } else if (cvu.aKp() != null) {
                cvu.aKp().setIsLike(i);
                cvu.aKp().setNum(cvu.aKp().getNum() - 1);
                ArrayList<MetaData> user = cvu.aKp().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cvu.aKp().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cvu.aKp().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cvu.aKp().getNum() + "";
                }
            }
            if (this.jqc.cyB()) {
                this.jtx.cAD().notifyDataSetChanged();
            } else {
                this.jtx.p(this.jqc.getPbData());
            }
        }
    }

    public static PbFragment cxr() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.jsV = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jqc.au(bundle);
        if (this.gYp != null) {
            this.gYp.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.jtK.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.jtc = System.currentTimeMillis();
        this.jtQ = getPageContext();
        final Intent intent = this.jsV.getIntent();
        if (intent != null) {
            this.gAV = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.jtj = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.jtj)) {
                    this.jtj = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.jtj)) {
                this.jsY = true;
            }
            this.juI = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.juJ = intent.getIntExtra("key_manga_next_chapter", -1);
            this.juK = intent.getStringExtra("key_manga_title");
            this.jtF = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.jtG = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.jtH = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cxU()) {
                this.jsV.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.jtY = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.jts = new ax();
            this.jts.Q(intent);
            this.jua = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.jua == 0) {
                this.jua = intent.getIntExtra("key_start_from", 0);
            }
            this.jub = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.gAV = System.currentTimeMillis();
        }
        this.edE = this.jtc - this.gAV;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.jta = 0;
        at(bundle);
        if (this.jqc.getPbData() != null) {
            this.jqc.getPbData().Hr(this.source);
        }
        cxu();
        if (intent != null && this.jtx != null) {
            this.jtx.jzE = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.jtT == null) {
                    this.jtT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.jtx.HO(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(this.jtT, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.jqc.getPbData() != null) {
                this.jqc.HG(stringExtra);
            }
        }
        this.gYp = new VoiceManager();
        this.gYp.onCreate(getPageContext());
        initData(bundle);
        this.jtJ = new com.baidu.tbadk.editortools.pb.g();
        d(this.jtJ);
        this.jtK = (com.baidu.tbadk.editortools.pb.e) this.jtJ.dI(getActivity());
        this.jtK.a(this.jsV.getPageContext());
        this.jtK.a(this.dYH);
        this.jtK.a(this.dYA);
        this.jtK.a(this.jsV.getPageContext(), bundle);
        this.jtK.aWP().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.jtK.aWP().hA(true);
        qU(true);
        this.jtK.a(this.jqc.cyP(), this.jqc.cyA(), this.jqc.czg());
        registerListener(this.jug);
        if (!this.jqc.cyG()) {
            this.jtK.wA(this.jqc.cyA());
        }
        if (this.jqc.czh()) {
            this.jtK.wy(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.jtx != null) {
            this.jtK.wy(this.jtx.cAo());
        }
        registerListener(this.juf);
        registerListener(this.juh);
        registerListener(this.jui);
        registerListener(this.gZE);
        registerListener(this.jut);
        registerListener(this.jue);
        this.jtI = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.kRO);
        this.jtI.cVY();
        registerListener(this.juj);
        registerListener(this.dzH);
        this.jqc.cyZ();
        registerListener(this.jux);
        registerListener(this.gZM);
        if (this.jtx != null && this.jtx.cBp() != null && this.jtx.cBq() != null) {
            this.jsX = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.jtx.cBp(), this.jtx.cBq(), this.jtx.cAu());
            this.jsX.a(this.juo);
        }
        if (this.jsW && this.jtx != null && this.jtx.cBq() != null) {
            this.jtx.cBq().setVisibility(8);
        }
        this.jtR = new com.baidu.tbadk.core.view.d();
        this.jtR.toastTime = 1000L;
        registerListener(this.jus);
        registerListener(this.juq);
        registerListener(this.jur);
        registerListener(this.hqe);
        registerListener(this.gZB);
        registerResponsedEventListener(TipEvent.class, this.gXv);
        this.jtS = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.jtS;
        userMuteAddAndDelCustomMessage.setTag(this.jtS);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.jtS;
        userMuteCheckCustomMessage.setTag(this.jtS);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.jqc.cze().a(this.jup);
        this.jtB = new ap();
        if (this.jtK.aXo() != null) {
            this.jtB.d(this.jtK.aXo().getInputView());
        }
        this.jtK.a(this.dYB);
        this.hoY = new ShareSuccessReplyToServerModel();
        a(this.juc);
        this.iBb = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.iBb.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
            @Override // com.baidu.tbadk.core.util.aj.a
            public void m(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.dzy) {
                        PbFragment.this.jtK.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.dzz && PbFragment.this.jtx != null && PbFragment.this.jtx.cAk() != null && PbFragment.this.jtx.cAk().cxp() != null) {
                        PbFragment.this.jtx.cAk().cxp().aXK();
                    } else if (i == com.baidu.tbadk.core.util.aj.dzA) {
                        PbFragment.this.c(PbFragment.this.jtN);
                    }
                }
            }
        });
        this.jtu = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.jtu.t(getUniqueId());
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
        com.baidu.tbadk.core.business.a.aIq().cy("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.jtc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.jqc != null) {
            gVar.setForumName(this.jqc.cwu());
            if (this.jqc.getPbData() != null && this.jqc.getPbData().getForum() != null) {
                gVar.a(this.jqc.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.jqc);
        }
    }

    public String cxs() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cxt() {
        return this.jsX;
    }

    private void qU(boolean z) {
        this.jtK.hE(z);
        this.jtK.hF(z);
        this.jtK.hG(z);
    }

    private void cxu() {
        this.dKo = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gYp != null) {
            this.gYp.onStart(getPageContext());
        }
    }

    public an cxv() {
        return this.jtx;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cwD() {
        return this.jqc;
    }

    public void Hw(String str) {
        if (this.jqc != null && !StringUtils.isNull(str) && this.jtx != null) {
            this.jtx.rE(true);
            this.jqc.Hw(str);
            this.jti = true;
            this.jtx.cBa();
            this.jtx.cBk();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.aWW = false;
        } else {
            this.aWW = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.jta = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.jta == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.gYp != null) {
            this.gYp.onPause(getPageContext());
        }
        if (this.jtx != null) {
            this.jtx.onPause();
        }
        if (!this.jqc.cyG()) {
            this.jtK.wz(this.jqc.cyA());
        }
        if (this.jqc != null) {
            this.jqc.cza();
        }
        com.baidu.tbadk.BdToken.c.aFN().aFS();
        MessageManager.getInstance().unRegisterListener(this.ieX);
        caP();
        MessageManager.getInstance().unRegisterListener(this.juq);
        MessageManager.getInstance().unRegisterListener(this.jur);
        MessageManager.getInstance().unRegisterListener(this.jus);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cxw() {
        PostData a2 = com.baidu.tieba.pb.data.f.a(this.jqc.getPbData(), this.jqc.cyB(), this.jqc.cyY());
        return (a2 == null || a2.aKE() == null || a2.aKE().getGodUserData() == null || a2.aKE().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.aWW = false;
        super.onResume();
        if (this.jtl) {
            this.jtl = false;
            cya();
        }
        if (cxw()) {
            this.jtf = System.currentTimeMillis();
        } else {
            this.jtf = -1L;
        }
        if (this.jtx != null && this.jtx.getView() != null) {
            if (!this.iTI) {
                cxS();
            } else {
                hideLoadingView(this.jtx.getView());
            }
            this.jtx.onResume();
        }
        if (this.jta == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.jtx != null) {
            noNetworkView = this.jtx.cAh();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.gYp != null) {
            this.gYp.onResume(getPageContext());
        }
        registerListener(this.ieX);
        this.jtE = false;
        cxZ();
        registerListener(this.juq);
        registerListener(this.jur);
        registerListener(this.jus);
        if (this.gZb) {
            cxR();
            this.gZb = false;
        }
        cyg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.jtx.rt(z);
        if (this.jtC != null) {
            this.jtC.dismiss();
        }
        if (z && this.jtE) {
            this.jtx.cAI();
            this.jqc.rf(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.jtf > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").cI("obj_duration", (System.currentTimeMillis() - this.jtf) + ""));
            this.jtf = 0L;
        }
        if (cxv().cAk() != null) {
            cxv().cAk().onStop();
        }
        if (this.jtx.jzG != null && !this.jtx.jzG.cCg()) {
            this.jtx.jzG.releaseResources();
        }
        if (this.jqc != null && this.jqc.getPbData() != null && this.jqc.getPbData().getForum() != null && this.jqc.getPbData().cvu() != null) {
            com.baidu.tbadk.distribute.a.aWD().a(getPageContext().getPageActivity(), "pb", this.jqc.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jqc.getPbData().cvu().getId(), 0L));
        }
        if (this.gYp != null) {
            this.gYp.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cI("fid", this.jqc.getPbData().getForumId());
            anVar.cI("tid", this.jqc.cyA());
            anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.jtd && this.jtx != null) {
            this.jtd = true;
            this.jtx.cBg();
            a(false, (PostData) null);
        }
        if (this.jqc != null) {
            this.jqc.cancelLoadData();
            this.jqc.destory();
            if (this.jqc.czd() != null) {
                this.jqc.czd().onDestroy();
            }
        }
        if (this.jtK != null) {
            this.jtK.onDestroy();
        }
        if (this.gqa != null) {
            this.gqa.cancelLoadData();
        }
        if (this.dKo != null) {
            this.dKo.cVL();
        }
        if (this.jtx != null) {
            this.jtx.onDestroy();
            if (this.jtx.jzG != null) {
                this.jtx.jzG.releaseResources();
            }
        }
        if (this.jte != null) {
            this.jte.aZs();
        }
        if (this.jsX != null) {
            this.jsX.beT();
        }
        super.onDestroy();
        if (this.gYp != null) {
            this.gYp.onDestory(getPageContext());
        }
        if (this.jtx != null) {
            this.jtx.cBa();
        }
        MessageManager.getInstance().unRegisterListener(this.juq);
        MessageManager.getInstance().unRegisterListener(this.jur);
        MessageManager.getInstance().unRegisterListener(this.jus);
        MessageManager.getInstance().unRegisterListener(this.jtS);
        MessageManager.getInstance().unRegisterListener(this.jut);
        MessageManager.getInstance().unRegisterListener(this.gZM);
        MessageManager.getInstance().unRegisterListener(this.hqe);
        MessageManager.getInstance().unRegisterListener(this.juv);
        this.jtQ = null;
        this.jtR = null;
        com.baidu.tieba.recapp.d.a.cOb().cOd();
        if (this.jtT != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jtT);
        }
        if (this.jtm != null) {
            this.jtm.cancelLoadData();
        }
        if (this.jtx != null && this.jtx.jzG != null) {
            this.jtx.jzG.cCj();
        }
        if (this.hoY != null) {
            this.hoY.cancelLoadData();
        }
        this.jtB.onDestroy();
        if (this.jqc != null && this.jqc.czf() != null) {
            this.jqc.czf().onDestroy();
        }
        if (this.iBb != null) {
            this.iBb.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f cAD;
        ArrayList<PostData> cxb;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aRF() && this.jtx != null && (cAD = this.jtx.cAD()) != null && (cxb = cAD.cxb()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cxb.iterator();
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
                        bVar.grV = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.dsh == 1 && !TextUtils.isEmpty(id)) {
                    next.dsh = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.grV = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.jqc == null || this.jqc.getPbData() == null || this.jqc.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.jqc.getPbData().getForum().getFirst_class();
                    str2 = this.jqc.getPbData().getForum().getSecond_class();
                    str = this.jqc.getPbData().getForum().getId();
                    str4 = this.jqc.cyA();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aRI());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.jtx.onChangeSkinType(i);
            if (this.jtK != null && this.jtK.aWP() != null) {
                this.jtK.aWP().onChangeSkinType(i);
            }
            if (this.jtx.cAh() != null) {
                this.jtx.cAh().onChangeSkinType(getPageContext(), i);
            }
            this.jtB.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jtx = new an(this, this.haA, this.dRh);
        this.hcq = new com.baidu.tieba.f.b(getActivity());
        this.hcq.a(juH);
        this.hcq.a(this.gxd);
        this.jtx.setOnScrollListener(this.mOnScrollListener);
        this.jtx.d(this.juB);
        this.jtx.setListPullRefreshListener(this.eBS);
        this.jtx.qG(com.baidu.tbadk.core.i.aIe().isShowImages());
        this.jtx.setOnImageClickListener(this.emS);
        this.jtx.b(this.mOnLongClickListener);
        this.jtx.g(this.gVM);
        this.jtx.a(this.juz);
        this.jtx.rt(this.mIsLogin);
        if (this.jsV.getIntent() != null) {
            this.jtx.rF(this.jsV.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.jtx.cAj().setFromForumId(this.jqc.getFromForumId());
        this.jtx.setEditorTools(this.jtK.aWP());
        this.jtK.wy(this.jtx.cAo());
        this.jtx.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.jqc.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jqc.getPbData().getForum().getId(), PbFragment.this.jqc.getPbData().getForum().getName(), PbFragment.this.jqc.getPbData().cvu().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.jtx.getView();
    }

    public void cxx() {
        if (this.jtx != null && this.jqc != null) {
            if ((this.jqc.getPbData() != null || this.jqc.getPbData().cvP() != null) && checkUpIsLogin() && this.jtx.cAD() != null && this.jtx.cAD().cxg() != null) {
                this.jtx.cAD().cxg().vl(this.jqc.cyA());
            }
        }
    }

    public void cxy() {
        TiebaStatic.log("c12181");
        if (this.jtx != null && this.jqc != null) {
            if ((this.jtx == null || this.jtx.cAn()) && this.jqc.getPbData() != null && this.jqc.getPbData().cvP() != null) {
                com.baidu.tieba.pb.data.k cvP = this.jqc.getPbData().cvP();
                if (checkUpIsLogin()) {
                    if ((!cvP.cwe() || cvP.aMc() != 2) && this.jtx.cAD() != null && this.jtx.cAD().cxg() != null) {
                        this.jtx.cAD().cxg().vl(this.jqc.cyA());
                    }
                    if (System.currentTimeMillis() - this.jth > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).sn(false);
                        this.jth = System.currentTimeMillis();
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
                if (postData.getType() != PostData.kSp && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.aIe().isShowImages()) {
                    return Hz(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.jqc == null || this.jqc.getPbData() == null) {
                        return true;
                    }
                    if (cxv().cAk() != null) {
                        cxv().cAk().cxl();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(this.jqc.getPbData().getForum());
                    lVar.setThreadData(this.jqc.getPbData().cvu());
                    lVar.f(postData);
                    cxv().cAj().d(lVar);
                    cxv().cAj().setPostId(postData.getId());
                    b(view, postData.aKE().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.jtK != null) {
                        this.jtx.rz(this.jtK.aXv());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cxz() {
        if (this.jtb == null) {
            this.jtb = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.jtb.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.jpY = PbFragment.this.jpY.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jpY);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.jqc.cyA(), PbFragment.this.jpY, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.jpY = PbFragment.this.jpY.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jpY);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.jqc.cyA(), PbFragment.this.jpY, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.jpY = PbFragment.this.jpY.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jpY);
                        bVar.dismiss();
                    }
                }
            }).ki(R.style.dialog_ani_b2t).kj(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.juw.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).cEg(), "", 1);
    }

    private void at(Bundle bundle) {
        this.jqc = this.jsV.cwD();
        if (this.jqc.czc() != null) {
            this.jqc.czc().a(this.jsd);
        }
        if (this.jqc.czd() != null) {
            this.jqc.czd().b(this.jud);
        }
        if (StringUtils.isNull(this.jqc.cyA())) {
            this.jsV.finish();
        } else if ("from_tieba_kuang".equals(this.jtj) && this.jtj != null) {
            this.jqc.zH(6);
        }
    }

    private void initData(Bundle bundle) {
        this.jtv = com.baidu.tbadk.baseEditMark.a.a(this.jsV);
        if (this.jtv != null) {
            this.jtv.a(this.juy);
        }
        this.gqa = new ForumManageModel(this.jsV);
        this.gqa.setLoadDataCallBack(this.gqf);
        this.dzD = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.jun.setUniqueId(getUniqueId());
        this.jun.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jtx.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.jtS;
        userMuteCheckCustomMessage.setTag(this.jtS);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cxA() {
        if (this.jqc == null || this.jqc.getPbData() == null) {
            return false;
        }
        bj cvu = this.jqc.getPbData().cvu();
        this.jqc.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cvu);
    }

    public void cxB() {
        if (checkUpIsLogin() && this.jqc != null && this.jqc.getPbData() != null && this.jqc.getPbData().getForum() != null && !cxA()) {
            if (this.jqc.getPbData().cvS()) {
                this.jtx.caq();
                return;
            }
            if (this.hbV == null) {
                this.hbV = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hbV.ut(0);
                this.hbV.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void mF(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void u(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void mG(boolean z) {
                        if (z) {
                            PbFragment.this.jtx.caq();
                        }
                    }
                });
            }
            this.hbV.E(this.jqc.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jqc.cyA(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cxC() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.jqc == null || (pbData = this.jqc.getPbData()) == null) {
            return null;
        }
        return pbData.cvF().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvu() != null) {
            if (eVar.cvu().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cvu().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cvu().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cxA() && cxD()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.jto);
                this.jtp = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.jqc.getPbData() != null && this.jqc.getPbData().cvS()) {
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.jsV.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cxv().getListView().smoothScrollBy((PbFragment.this.jto[1] + PbFragment.this.jtp) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cxv().cAk() != null) {
                            PbFragment.this.jtK.aWP().setVisibility(8);
                            PbFragment.this.cxv().cAk().g(str, str2, PbFragment.this.cxv().cAo(), (PbFragment.this.jqc == null || PbFragment.this.jqc.getPbData() == null || PbFragment.this.jqc.getPbData().cvu() == null || !PbFragment.this.jqc.getPbData().cvu().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cxp = PbFragment.this.cxv().cAk().cxp();
                            if (cxp != null && PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                cxp.a(PbFragment.this.jqc.getPbData().getAnti());
                                cxp.setThreadData(PbFragment.this.jqc.getPbData().cvu());
                            }
                            if (PbFragment.this.jtB.cBB() == null && PbFragment.this.cxv().cAk().cxp().aXS() != null) {
                                PbFragment.this.cxv().cAk().cxp().aXS().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jtB != null && PbFragment.this.jtB.cBA() != null) {
                                            if (!PbFragment.this.jtB.cBA().deV()) {
                                                PbFragment.this.jtB.rH(false);
                                            }
                                            PbFragment.this.jtB.cBA().uO(false);
                                        }
                                    }
                                });
                                PbFragment.this.jtB.e(PbFragment.this.cxv().cAk().cxp().aXS().getInputView());
                                PbFragment.this.cxv().cAk().cxp().a(PbFragment.this.jtP);
                            }
                        }
                        PbFragment.this.cxv().cBk();
                    }
                }, 0L);
                return;
            }
            if (this.jtM == null) {
                this.jtM = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jtM.ut(1);
                this.jtM.a(new AnonymousClass37(str, str2));
            }
            if (this.jqc != null && this.jqc.getPbData() != null && this.jqc.getPbData().getForum() != null) {
                this.jtM.E(this.jqc.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jqc.cyA(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$37  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass37 implements c.a {
        final /* synthetic */ String juT;
        final /* synthetic */ String juU;

        AnonymousClass37(String str, String str2) {
            this.juT = str;
            this.juU = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mF(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void u(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mG(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        }
                        PbFragment.this.cxv().getListView().smoothScrollBy((PbFragment.this.jto[1] + PbFragment.this.jtp) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cxv().cAk() != null) {
                            PbFragment.this.jtK.aWP().setVisibility(8);
                            PbFragment.this.cxv().cAk().g(AnonymousClass37.this.juT, AnonymousClass37.this.juU, PbFragment.this.cxv().cAo(), (PbFragment.this.jqc == null || PbFragment.this.jqc.getPbData() == null || PbFragment.this.jqc.getPbData().cvu() == null || !PbFragment.this.jqc.getPbData().cvu().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cxp = PbFragment.this.cxv().cAk().cxp();
                            if (cxp != null && PbFragment.this.jqc != null && PbFragment.this.jqc.getPbData() != null) {
                                cxp.a(PbFragment.this.jqc.getPbData().getAnti());
                                cxp.setThreadData(PbFragment.this.jqc.getPbData().cvu());
                            }
                            if (PbFragment.this.jtB.cBB() == null && PbFragment.this.cxv().cAk().cxp().aXS() != null) {
                                PbFragment.this.cxv().cAk().cxp().aXS().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jtB != null && PbFragment.this.jtB.cBA() != null) {
                                            if (!PbFragment.this.jtB.cBA().deV()) {
                                                PbFragment.this.jtB.rH(false);
                                            }
                                            PbFragment.this.jtB.cBA().uO(false);
                                        }
                                    }
                                });
                                PbFragment.this.jtB.e(PbFragment.this.cxv().cAk().cxp().aXS().getInputView());
                                PbFragment.this.cxv().cAk().cxp().a(PbFragment.this.jtP);
                            }
                        }
                        PbFragment.this.cxv().cBk();
                    }
                }, 0L);
            }
        }
    }

    public boolean cxD() {
        if ((this.jqc.getPbData() != null && this.jqc.getPbData().cvS()) || this.iBb == null || this.jqc.getPbData() == null || this.jqc.getPbData().getAnti() == null) {
            return true;
        }
        return this.iBb.kz(this.jqc.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean zw(int i) {
        if (this.iBb == null || this.jqc.getPbData() == null || this.jqc.getPbData().getAnti() == null) {
            return true;
        }
        return this.iBb.aA(this.jqc.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.jqc != null && this.jqc.getPbData() != null && postData.cWr() != 1) {
            String cyA = this.jqc.cyA();
            String id = postData.getId();
            int cvG = this.jqc.getPbData() != null ? this.jqc.getPbData().cvG() : 0;
            PbActivity.a HA = HA(id);
            if (HA != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cyA, id, "pb", true, null, false, null, cvG, postData.cDb(), this.jqc.getPbData().getAnti(), false, postData.aKE() != null ? postData.aKE().getIconInfo() : null).addBigImageData(HA.jqh, HA.jqi, HA.jqj, HA.index);
                addBigImageData.setKeyPageStartFrom(this.jqc.czj());
                addBigImageData.setFromFrsForumId(this.jqc.getFromForumId());
                addBigImageData.setKeyFromForumId(this.jqc.getForumId());
                addBigImageData.setBjhData(this.jqc.cyI());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cxE() {
        if (this.jqc.getPbData() == null || this.jqc.getPbData().cvu() == null) {
            return -1;
        }
        return this.jqc.getPbData().cvu().aLo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxF() {
        if (this.jqc != null && this.jqc.jqV != null && this.jqc.jqV.cvu() != null) {
            bj cvu = this.jqc.jqV.cvu();
            cvu.mRecomAbTag = this.jqc.czu();
            cvu.mRecomWeight = this.jqc.czs();
            cvu.mRecomSource = this.jqc.czt();
            cvu.mRecomExtra = this.jqc.czv();
            if (cvu.getFid() == 0) {
                cvu.setFid(com.baidu.adp.lib.f.b.toLong(this.jqc.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cvu, "c13563");
            if (a2 != null) {
                a2.af("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxG() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Ka(this.jqc.getForumId()) && this.jqc.getPbData() != null && this.jqc.getPbData().getForum() != null) {
            if (this.jqc.getPbData().getForum().isLike() == 1) {
                this.jqc.czf().eI(this.jqc.getForumId(), this.jqc.cyA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qV(boolean z) {
        if (this.jqc == null || this.jqc.getPbData() == null) {
            return false;
        }
        return ((this.jqc.getPbData().cvG() != 0) || this.jqc.getPbData().cvu() == null || this.jqc.getPbData().cvu().aKE() == null || TextUtils.equals(this.jqc.getPbData().cvu().aKE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean qW(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.w wVar;
        if (this.jqc == null || this.jqc.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.jqc.getPbData();
        bj cvu = pbData.cvu();
        if (cvu != null) {
            if (cvu.aJt() || cvu.aJu()) {
                return false;
            }
            if (cvu.aMy() || cvu.aMz()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cvG() != 0) {
                return pbData.cvG() != 3;
            }
            List<bf> cvN = pbData.cvN();
            if (com.baidu.tbadk.core.util.v.getCount(cvN) > 0) {
                for (bf bfVar : cvN) {
                    if (bfVar != null && (wVar = bfVar.dqj) != null && wVar.dod && !wVar.doe && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean qX(boolean z) {
        if (z || this.jqc == null || this.jqc.getPbData() == null) {
            return false;
        }
        return ((this.jqc.getPbData().getForum() != null && this.jqc.getPbData().getForum().isBlockBawuDelete) || this.jqc.getPbData().cvG() == 0 || this.jqc.getPbData().cvG() == 3) ? false : true;
    }

    public void cxH() {
        com.baidu.tieba.pb.data.e pbData;
        bj cvu;
        if (this.jqc != null && this.jqc.getPbData() != null && (cvu = (pbData = this.jqc.getPbData()).cvu()) != null && cvu.aKE() != null) {
            this.jtx.cAi();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cvu.aKE().getUserId());
            z zVar = new z();
            int cvG = this.jqc.getPbData().cvG();
            if (cvG == 1 || cvG == 3) {
                zVar.jxX = true;
                zVar.jxW = true;
                zVar.jyc = cvu.aKz() == 1;
                zVar.jyb = cvu.aKA() == 1;
            } else {
                zVar.jxX = false;
                zVar.jxW = false;
            }
            if (cvG == 1002 && !equals) {
                zVar.jyd = true;
            }
            zVar.jxU = qW(equals);
            zVar.jxY = cxI();
            zVar.jxV = qX(equals);
            zVar.Dy = this.jqc.cyB();
            zVar.jxR = true;
            zVar.jxQ = qV(equals);
            zVar.jxP = equals && this.jtx.cAP();
            zVar.jya = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.jxZ = true;
            zVar.isHostOnly = this.jqc.getHostMode();
            zVar.jxT = true;
            if (cvu.aKV() == null) {
                zVar.jxS = true;
            } else {
                zVar.jxS = false;
            }
            if (pbData.cvS()) {
                zVar.jxR = false;
                zVar.jxT = false;
                zVar.jxS = false;
                zVar.jxW = false;
                zVar.jxX = false;
            }
            this.jtx.jzG.a(zVar);
        }
    }

    private boolean cxI() {
        if (this.jqc != null && this.jqc.cyB()) {
            return this.jqc.getPageData() == null || this.jqc.getPageData().aJB() != 0;
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
            k(postData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cxJ() {
        return this.juw;
    }

    public int cxK() {
        if (cxv() == null || cxv().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cxv().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) mVar).Tv == com.baidu.tieba.pb.data.j.jox) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cxL() {
        if (cxv() == null || cxv().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cxv().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.kSo) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cxR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxM() {
        if (this.jqc != null && this.jqc.jqV != null && this.jqc.jqV.cvu() != null) {
            bj cvu = this.jqc.jqV.cvu();
            cvu.mRecomAbTag = this.jqc.czu();
            cvu.mRecomWeight = this.jqc.czs();
            cvu.mRecomSource = this.jqc.czt();
            cvu.mRecomExtra = this.jqc.czv();
            if (cvu.getFid() == 0) {
                cvu.setFid(com.baidu.adp.lib.f.b.toLong(this.jqc.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cvu, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.ue(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.uf(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.gE(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cI("obj_id", metaData.getUserId()).af("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cI("obj_id", metaData.getUserId()).af("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.dzD.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.jqc.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aMU();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.jtx.cAJ();
        this.jqc.rh(z);
        if (this.jtv != null) {
            this.jtv.gk(z);
            if (markData != null) {
                this.jtv.a(markData);
            }
        }
        if (this.jqc.aGZ()) {
            cxP();
        } else {
            this.jtx.o(this.jqc.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zn(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hx(String str) {
        if (this.jqc != null && this.jqc.getPbData() != null && this.jqc.getPbData().cvS()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jqc.cyA(), str);
            bj cvu = this.jqc.getPbData().cvu();
            if (cvu.aJt()) {
                format = format + "&channelid=33833";
            } else if (cvu.aMx()) {
                format = format + "&channelid=33842";
            } else if (cvu.aJu()) {
                format = format + "&channelid=33840";
            }
            Hy(format);
            return;
        }
        this.jtu.HX(str);
    }

    private void Hy(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.jqc.cyG()) {
                    antiData.setBlock_forum_name(this.jqc.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.jqc.getPbData().getForum().getId());
                    antiData.setUser_name(this.jqc.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.jqc.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cxv() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bq(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            wF(str);
        } else {
            this.jtx.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.kVc) ? bVar.kVc : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.uf(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.gE(true);
                aVar.b(getPageContext());
                aVar.aMU();
            } else {
                this.jtx.a(0, bVar.OG, bVar.kVc, z);
            }
            if (bVar.OG) {
                if (bVar.gFx == 1) {
                    ArrayList<PostData> cvw = this.jqc.getPbData().cvw();
                    int size = cvw.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cvw.get(i).getId())) {
                            i++;
                        } else {
                            cvw.remove(i);
                            break;
                        }
                    }
                    this.jqc.getPbData().cvu().jQ(this.jqc.getPbData().cvu().aKv() - 1);
                    this.jtx.o(this.jqc.getPbData());
                } else if (bVar.gFx == 0) {
                    cxN();
                } else if (bVar.gFx == 2) {
                    ArrayList<PostData> cvw2 = this.jqc.getPbData().cvw();
                    int size2 = cvw2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cvw2.get(i2).cWo().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cvw2.get(i2).cWo().get(i3).getId())) {
                                i3++;
                            } else {
                                cvw2.get(i2).cWo().remove(i3);
                                cvw2.get(i2).cWq();
                                z2 = true;
                                break;
                            }
                        }
                        cvw2.get(i2).KL(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.jtx.o(this.jqc.getPbData());
                    }
                    a(bVar, this.jtx);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.jtx.a(this.gqa.getLoadDataMode(), gVar.OG, gVar.kVc, false);
            if (gVar.OG) {
                this.jty = true;
                if (i == 2 || i == 3) {
                    this.jtz = true;
                    this.jtA = false;
                } else if (i == 4 || i == 5) {
                    this.jtz = false;
                    this.jtA = true;
                }
                if (i == 2) {
                    this.jqc.getPbData().cvu().jT(1);
                    this.jqc.setIsGood(1);
                } else if (i == 3) {
                    this.jqc.getPbData().cvu().jT(0);
                    this.jqc.setIsGood(0);
                } else if (i == 4) {
                    this.jqc.getPbData().cvu().jS(1);
                    this.jqc.zz(1);
                } else if (i == 5) {
                    this.jqc.getPbData().cvu().jS(0);
                    this.jqc.zz(0);
                }
                this.jtx.c(this.jqc.getPbData(), this.jqc.cyB());
            }
        }
    }

    private void cxN() {
        if (this.jqc.cyC() || this.jqc.cyE()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.jqc.cyA());
            PbActivity pbActivity = this.jsV;
            PbActivity pbActivity2 = this.jsV;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.jqc.cyA()));
        if (cxQ()) {
            this.jsV.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwQ() {
        this.jsV.cwQ();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cvD;
        boolean z = false;
        if (this.jtx != null) {
            this.jtx.cBa();
        }
        if (this.jqc != null && this.jqc.getPbData() != null && !this.jqc.getPbData().cvS()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.jqc.getPbData().cvu().getId();
            if (this.jqc.isShareThread() && this.jqc.getPbData().cvu().dto != null) {
                historyMessage.threadName = this.jqc.getPbData().cvu().dto.showText;
            } else {
                historyMessage.threadName = this.jqc.getPbData().cvu().getTitle();
            }
            if (this.jqc.isShareThread() && !cwt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.jqc.getPbData().getForum().getName();
            }
            ArrayList<PostData> cvw = this.jqc.getPbData().cvw();
            int cAL = this.jtx != null ? this.jtx.cAL() : 0;
            if (cvw != null && cAL >= 0 && cAL < cvw.size()) {
                historyMessage.postID = cvw.get(cAL).getId();
            }
            historyMessage.isHostOnly = this.jqc.getHostMode();
            historyMessage.isSquence = this.jqc.cyB();
            historyMessage.isShareThread = this.jqc.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.jtK != null) {
            this.jtK.onDestroy();
        }
        if (this.jsZ && cxv() != null) {
            cxv().cBu();
        }
        if (this.jqc != null && (this.jqc.cyC() || this.jqc.cyE())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.jqc.cyA());
            if (this.jty) {
                if (this.jtA) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.jqc.bHK());
                }
                if (this.jtz) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.jqc.getIsGood());
                }
            }
            if (this.jqc.getPbData() != null && System.currentTimeMillis() - this.jtc >= 40000 && (cvD = this.jqc.getPbData().cvD()) != null && !com.baidu.tbadk.core.util.v.isEmpty(cvD.getDataList())) {
                intent.putExtra("guess_like_data", cvD);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.jtY);
            }
            PbActivity pbActivity = this.jsV;
            PbActivity pbActivity2 = this.jsV;
            pbActivity.setResult(-1, intent);
        }
        if (cxQ()) {
            if (this.jqc != null && this.jtx != null && this.jtx.getListView() != null) {
                com.baidu.tieba.pb.data.e pbData = this.jqc.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cvA() && !this.jti && pbData.jnx == null) {
                        ah czS = ah.czS();
                        com.baidu.tieba.pb.data.e cyJ = this.jqc.cyJ();
                        Parcelable onSaveInstanceState = this.jtx.getListView().onSaveInstanceState();
                        boolean cyB = this.jqc.cyB();
                        boolean hostMode = this.jqc.getHostMode();
                        if (this.jtx.cAu() != null && this.jtx.cAu().getVisibility() == 0) {
                            z = true;
                        }
                        czS.a(cyJ, onSaveInstanceState, cyB, hostMode, z);
                        if (this.jtX >= 0 || this.jqc.czl() != null) {
                            ah.czS().n(this.jqc.czl());
                            ah.czS().m(this.jqc.czm());
                            ah.czS().zJ(this.jqc.czn());
                        }
                    }
                }
            } else {
                ah.czS().reset();
            }
            cwQ();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.jtx == null || !this.jtx.zP(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zx(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.jsV;
        if (i == 0) {
            this.jtx.cAi();
            this.jtx.cAk().cxl();
            this.jtx.rB(false);
        }
        this.jtx.cAm();
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
                        this.jtK.resetData();
                        this.jtK.setVoiceModel(pbEditorData.getVoiceModel());
                        this.jtK.b(writeData);
                        com.baidu.tbadk.editortools.l mD = this.jtK.aWP().mD(6);
                        if (mD != null && mD.dWH != null) {
                            mD.dWH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.jsV;
                        if (i == -1) {
                            this.jtK.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.jtx.cAk() != null && this.jtx.cAk().cxp() != null) {
                            com.baidu.tbadk.editortools.pb.h cxp = this.jtx.cAk().cxp();
                            cxp.setThreadData(this.jqc.getPbData().cvu());
                            cxp.b(writeData);
                            cxp.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mD2 = cxp.aWP().mD(6);
                            if (mD2 != null && mD2.dWH != null) {
                                mD2.dWH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.jsV;
                            if (i == -1) {
                                cxp.aXK();
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
        this.jtK.onActivityResult(i, i2, intent);
        if (this.jtm != null) {
            this.jtm.onActivityResult(i, i2, intent);
        }
        if (cxv().cAk() != null) {
            cxv().cAk().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cxO();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ah.czS().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.jqc != null) {
                                PbFragment.this.jqc.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cMU().D(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.jqc != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    ai(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.cMU().D(getPageContext());
                        cxG();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.hoY != null && shareItem != null && shareItem.linkUrl != null) {
                            this.hoY.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aUm() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55.1
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
                    this.jtx.qL(false);
                    if (this.jqc.getPbData() != null && this.jqc.getPbData().cvu() != null && this.jqc.getPbData().cvu().aKY() != null) {
                        this.jqc.getPbData().cvu().aKY().setStatus(2);
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
                        this.jtN = emotionImageData;
                        if (zw(com.baidu.tbadk.core.util.aj.dzA)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.jtn != null) {
                        this.jtx.cJ(this.jtn);
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
            if (this.jtm == null) {
                this.jtm = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.jsV);
                this.jtm.b(this.dYA);
                this.jtm.c(this.dYH);
            }
            this.jtm.a(emotionImageData, cwD(), cwD().getPbData());
        }
    }

    private void ai(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxO() {
        MarkData zG;
        if (this.jtv != null) {
            if (this.jqc.getPbData() != null && this.jqc.getPbData().cvS()) {
                zG = this.jqc.zG(0);
            } else {
                zG = this.jqc.zG(this.jtx.cAM());
            }
            if (zG != null) {
                if (!zG.isApp() || (zG = this.jqc.zG(this.jtx.cAM() + 1)) != null) {
                    this.jtx.cAH();
                    this.jtv.a(zG);
                    if (!this.jtv.aGZ()) {
                        this.jtv.aHb();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.jtv.aHa();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxP() {
        com.baidu.tieba.pb.data.e pbData = this.jqc.getPbData();
        this.jqc.rh(true);
        if (this.jtv != null) {
            pbData.Hq(this.jtv.aGY());
        }
        this.jtx.o(pbData);
    }

    private boolean cxQ() {
        if (this.jqc == null) {
            return true;
        }
        if (this.jqc.getPbData() == null || !this.jqc.getPbData().cvS()) {
            if (this.jqc.aGZ()) {
                final MarkData cyT = this.jqc.cyT();
                if (cyT == null || !this.jqc.getIsFromMark()) {
                    return true;
                }
                final MarkData zG = this.jqc.zG(this.jtx.cAL());
                if (zG == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cyT);
                    this.jsV.setResult(-1, intent);
                    return true;
                } else if (zG.getPostId() == null || zG.getPostId().equals(cyT.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cyT);
                    this.jsV.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.uf(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.jtv != null) {
                                if (PbFragment.this.jtv.aGZ()) {
                                    PbFragment.this.jtv.aHa();
                                    PbFragment.this.jtv.gk(false);
                                }
                                PbFragment.this.jtv.a(zG);
                                PbFragment.this.jtv.gk(true);
                                PbFragment.this.jtv.aHb();
                            }
                            cyT.setPostId(zG.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cyT);
                            PbFragment.this.jsV.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cwQ();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cyT);
                            PbFragment.this.jsV.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cwQ();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.jtx != null && PbFragment.this.jtx.getView() != null) {
                                PbFragment.this.jtx.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cyT);
                                PbFragment.this.jsV.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cwQ();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aMU();
                    return false;
                }
            } else if (this.jqc.getPbData() == null || this.jqc.getPbData().cvw() == null || this.jqc.getPbData().cvw().size() <= 0 || !this.jqc.getIsFromMark()) {
                return true;
            } else {
                this.jsV.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.jtx == null) {
            return null;
        }
        return this.jtx.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bcO() {
        if (this.jtx == null) {
            return 0;
        }
        return this.jtx.cAY();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bcP() {
        if (this.emH == null) {
            this.emH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bdb */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.aIe().isShowImages();
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
                        if (com.baidu.tbadk.core.i.aIe().isShowImages()) {
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
        return this.emH;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bcQ() {
        if (this.epz == null) {
            this.epz = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.epz;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bcR() {
        if (this.emI == null) {
            this.emI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJw */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.aIe().isShowImages();
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
                    if (com.baidu.tbadk.core.i.aIe().isShowImages()) {
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
                    gifView.aYk();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.emI;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bcS() {
        if (this.epA == null) {
            this.epA = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyn */
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
                    ((PlayVoiceBntNew) view).cXz();
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
        return this.epA;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bcU() {
        this.epC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyo */
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
        return this.epC;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aQJ() {
        if (this.dJv == null) {
            this.dJv = UserIconBox.s(getPageContext().getPageActivity(), 8);
        }
        return this.dJv;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aw(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jtg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
        if (as.HP(str) && this.jqc != null && this.jqc.cyA() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").af("obj_param1", 1).cI("post_id", this.jqc.cyA()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                jVar.mLink = str;
                jVar.type = 3;
                jVar.dVK = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, jVar));
            }
        } else {
            as.cBD().d(getPageContext(), str);
        }
        this.jtg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
        as.cBD().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.jtg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.jtx != null && this.jtx.cBp() != null && rect.top <= this.jtx.cBp().getHeight()) {
            rect.top += this.jtx.cBp().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.jqc.getPbData();
            TbRichText bt = bt(str, i);
            if (bt != null && (tbRichTextData = bt.bch().get(this.juC)) != null) {
                aVar.postId = String.valueOf(bt.getPostId());
                aVar.jqh = new ArrayList<>();
                aVar.jqi = new ConcurrentHashMap<>();
                if (!tbRichTextData.bcn().bcy()) {
                    aVar.jqk = false;
                    String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                    aVar.jqh.add(b2);
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
                    imageUrlData.postId = bt.getPostId();
                    imageUrlData.mIsReserver = this.jqc.cyR();
                    imageUrlData.mIsSeeHost = this.jqc.getHostMode();
                    aVar.jqi.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cvu() != null) {
                            aVar.threadId = pbData.cvu().getId();
                        }
                        aVar.jqj = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.jqk = true;
                int size = pbData.cvw().size();
                this.juD = false;
                aVar.index = -1;
                int a2 = pbData.cvB() != null ? a(pbData.cvB().cWt(), bt, i, i, aVar.jqh, aVar.jqi) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cvw().get(i2);
                    if (postData.getId() == null || pbData.cvB() == null || pbData.cvB().getId() == null || !postData.getId().equals(pbData.cvB().getId())) {
                        a2 = a(postData.cWt(), bt, a2, i, aVar.jqh, aVar.jqi);
                    }
                }
                if (aVar.jqh.size() > 0) {
                    aVar.lastId = aVar.jqh.get(aVar.jqh.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cvu() != null) {
                        aVar.threadId = pbData.cvu().getId();
                    }
                    aVar.jqj = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcn() == null) {
            return null;
        }
        return tbRichTextData.bcn().bcD();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcn() == null) {
            return 0L;
        }
        return tbRichTextData.bcn().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcn() == null) {
            return false;
        }
        return tbRichTextData.bcn().bcE();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcn() == null) {
            return false;
        }
        return tbRichTextData.bcn().bcF();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bcn;
        String str;
        if (tbRichText == tbRichText2) {
            this.juD = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bch().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bch().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bcn().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bcn().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bcn().bcy()) {
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
                            if (tbRichTextData != null && (bcn = tbRichTextData.bcn()) != null) {
                                String bcA = bcn.bcA();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bcn.bcB();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bcA;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.jqc.cyA(), -1L);
                                imageUrlData.mIsReserver = this.jqc.cyR();
                                imageUrlData.mIsSeeHost = this.jqc.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.juD) {
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
        PostData cvB;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.jqc.aKN())) {
                z = true;
            }
            MarkData l = this.jqc.l(postData);
            if (this.jqc.getPbData() != null && this.jqc.getPbData().cvS() && (cvB = cvB()) != null) {
                l = this.jqc.l(cvB);
            }
            if (l != null) {
                this.jtx.cAH();
                if (this.jtv != null) {
                    this.jtv.a(l);
                    if (!z) {
                        this.jtv.aHb();
                    } else {
                        this.jtv.aHa();
                    }
                }
            }
        }
    }

    public boolean cD(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bt(String str, int i) {
        TbRichText tbRichText = null;
        if (this.jqc == null || this.jqc.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.jqc.getPbData();
        if (pbData.cvB() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cvB());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cvw = pbData.cvw();
            c(pbData, cvw);
            return c(cvw, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cvF() != null && eVar.cvF().joL != null && (list = eVar.cvF().joL) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bch;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cWt = arrayList.get(i2).cWt();
            if (cWt != null && (bch = cWt.bch()) != null) {
                int size = bch.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bch.get(i4) != null && bch.get(i4).getType() == 8) {
                        i3++;
                        if (bch.get(i4).bcn().bcA().equals(str) || bch.get(i4).bcn().bcB().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bch.get(i4).bcn().getWidth() * equipmentDensity;
                            int height = bch.get(i4).bcn().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.juC = i4;
                            return cWt;
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
            this.jpY = str;
            if (this.jtb == null) {
                cxz();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.jtb.getItemView(1).setVisibility(8);
            } else {
                this.jtb.getItemView(1).setVisibility(0);
            }
            this.jtb.aMV();
            this.jtg = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gYp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxR() {
        hideNetRefreshView(this.jtx.getView());
        cxS();
        if (this.jqc.cyM()) {
            this.jtx.cAH();
        }
        this.jtx.cAS();
    }

    private void cxS() {
        showLoadingView(this.jtx.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.jtx.cBp().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOT() {
        if (this.gYp != null) {
            this.gYp.stopPlay();
        }
        if (this.jsV != null) {
            this.jsV.bOT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cxE(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bcT() {
        if (this.epB == null) {
            this.epB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyp */
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
        return this.epB;
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

    public void bOU() {
        if (this.jsV != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.jsV.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jsV.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bNG() {
        if (this.jqc == null || this.jqc.getPbData() == null) {
            return null;
        }
        return this.jqc.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(an.jAR)).intValue();
            if (intValue == an.jAS) {
                if (!this.gqa.cXf()) {
                    this.jtx.cAE();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.gqa.KQ(com.baidu.tbadk.core.util.aq.P(jSONArray));
                    }
                    this.gqa.a(this.jqc.getPbData().getForum().getId(), this.jqc.getPbData().getForum().getName(), this.jqc.getPbData().cvu().getId(), str, intValue3, intValue2, booleanValue, this.jqc.getPbData().cvu().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.jAT || intValue == an.jAV) {
                if (this.jqc.czc() != null) {
                    this.jqc.czc().zr(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.jAT) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.jtS);
        userMuteAddAndDelCustomMessage.setTag(this.jtS);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Hz(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0623a
    public void qY(boolean z) {
        this.jtE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cxT() {
        ArrayList<PostData> cvw;
        int count;
        if (this.jqc == null || this.jqc.getPbData() == null || this.jqc.getPbData().cvw() == null || (count = com.baidu.tbadk.core.util.v.getCount((cvw = this.jqc.getPbData().cvw()))) == 0) {
            return "";
        }
        if (this.jqc.cyR()) {
            Iterator<PostData> it = cvw.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cWr() == 1) {
                    return next.getId();
                }
            }
        }
        int cAL = this.jtx.cAL();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cvw, cAL);
        if (postData == null || postData.aKE() == null) {
            return "";
        }
        if (this.jqc.HD(postData.aKE().getUserId())) {
            return postData.getId();
        }
        for (int i = cAL - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(cvw, i);
            if (postData2 == null || postData2.aKE() == null || postData2.aKE().getUserId() == null) {
                break;
            } else if (this.jqc.HD(postData2.aKE().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cAL + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(cvw, i2);
            if (postData3 == null || postData3.aKE() == null || postData3.aKE().getUserId() == null) {
                return "";
            }
            if (this.jqc.HD(postData3.aKE().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aA(Context context, String str) {
        this.jtg = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a HA(String str) {
        String str2;
        if (this.jqc.getPbData() == null || this.jqc.getPbData().cvw() == null || this.jqc.getPbData().cvw().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.jqc.getPbData().cvw().size()) {
                i = 0;
                break;
            } else if (str.equals(this.jqc.getPbData().cvw().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.jqc.getPbData().cvw().get(i);
        if (postData.cWt() == null || postData.cWt().bch() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cWt().bch().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bcn() != null) {
                    str2 = next.bcn().bcA();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.f.a(postData, aVar);
        return aVar;
    }

    public boolean cxU() {
        return (!this.jsW && this.juI == -1 && this.juJ == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null) {
            this.juL = pVar;
            this.jsW = true;
            this.jtx.cAv();
            this.jtx.HN(this.juK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxV() {
        if (this.juL != null) {
            if (this.juI == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.juL.getCartoonId(), this.juI, 0)));
                this.jsV.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxW() {
        if (this.juL != null) {
            if (this.juJ == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.juL.getCartoonId(), this.juJ, 0)));
                this.jsV.finish();
            }
        }
    }

    public int cxX() {
        return this.juI;
    }

    public int cxY() {
        return this.juJ;
    }

    private void caP() {
        if (this.jqc != null && this.jqc.getPbData() != null && this.jqc.getPbData().cvu() != null && this.jqc.getPbData().cvu().aJr()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cxZ() {
        if (this.jqc != null && this.jqc.getPbData() != null && this.jqc.getPbData().cvu() != null && this.jqc.getPbData().cvu().aJr()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cya() {
        if (this.aWW) {
            this.jtl = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.jqc.getPbData() != null && this.jqc.getPbData().cvu() != null && this.jqc.getPbData().cvu().aKk() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.jqc.getPbData().cvu().aKk().getThreadId(), this.jqc.getPbData().cvu().aKk().getTaskId(), this.jqc.getPbData().cvu().aKk().getForumId(), this.jqc.getPbData().cvu().aKk().getForumName(), this.jqc.getPbData().cvu().aKz(), this.jqc.getPbData().cvu().aKA())));
            this.jsY = true;
            this.jsV.finish();
        }
    }

    public String cyb() {
        return this.jtj;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cyc() {
        return this.jtt;
    }

    public void qZ(boolean z) {
        this.jtk = z;
    }

    public boolean aMu() {
        if (this.jqc != null) {
            return this.jqc.cyC();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.uf(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.jtQ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.jtQ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.jtQ).aMU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF(String str) {
        if (str == null) {
            str = "";
        }
        if (this.jtQ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jtQ.getPageActivity());
            aVar.uf(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jtQ).aMU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.jtx.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jtQ.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.uf(this.jtQ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.uf(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.jtx.showLoadingDialog();
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
        aVar.b(this.jtQ).aMU();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.HP(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.hzw) {
            this.hzw = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.jtx != null) {
                this.jtx.onConfigurationChanged(configuration);
            }
            if (this.jtC != null) {
                this.jtC.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cye() {
        if (this.jqc != null) {
            return this.jqc.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.jqc.getPbData().cvF().joL;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cWo().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cWo().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cWo().remove(i2);
                    list.get(i).cWq();
                    z = true;
                    break;
                }
            }
            list.get(i).KL(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.o(this.jqc.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.l lVar) {
        String id = lVar.cwh().getId();
        List<PostData> list = this.jqc.getPbData().cvF().joL;
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
                ArrayList<PostData> cwl = lVar.cwl();
                postData.Dh(lVar.getTotalCount());
                if (postData.cWo() != null) {
                    postData.cWo().clear();
                    postData.cWo().addAll(cwl);
                }
            }
        }
        if (!this.jqc.getIsFromMark()) {
            this.jtx.o(this.jqc.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cws() {
        return this.jsV.cws();
    }

    public boolean cwt() {
        if (this.jqc == null) {
            return false;
        }
        return this.jqc.cwt();
    }

    public void cyf() {
        if (this.jtx != null) {
            this.jtx.cAi();
            bOU();
        }
    }

    public PostData cvB() {
        return this.jtx.b(this.jqc.jqV, this.jqc.cyB());
    }

    public void onBackPressed() {
        if (this.jtZ != null && !this.jtZ.isEmpty()) {
            int size = this.jtZ.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.jtZ.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.jtZ == null) {
                this.jtZ = new ArrayList();
            }
            if (!this.jtZ.contains(aVar)) {
                this.jtZ.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.jtZ == null) {
                this.jtZ = new ArrayList();
            }
            if (!this.jtZ.contains(aVar)) {
                this.jtZ.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.jtZ != null) {
            this.jtZ.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyg() {
        if (this.jqc != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.jqc.cyA())) {
            com.baidu.tbadk.BdToken.c.aFN().o(com.baidu.tbadk.BdToken.b.dfY, com.baidu.adp.lib.f.b.toLong(this.jqc.cyA(), 0L));
        }
    }

    public ax cyh() {
        return this.jts;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB(String str) {
        if (this.jqc != null && this.jqc.getPbData() != null && this.jqc.getPbData().cvu() != null && this.jqc.getPbData().cvu().aMA()) {
            bj cvu = this.jqc.getPbData().cvu();
            int i = 0;
            if (cvu.aJt()) {
                i = 1;
            } else if (cvu.aJu()) {
                i = 2;
            } else if (cvu.aMy()) {
                i = 3;
            } else if (cvu.aMz()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.af("obj_source", 4);
            anVar.af("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cyi() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cyj() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cyk() {
        return this.jsV;
    }
}
