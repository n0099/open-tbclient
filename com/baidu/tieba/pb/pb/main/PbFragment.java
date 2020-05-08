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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0644a {
    private com.baidu.adp.lib.d.b<TbImageView> dJz;
    private LikeModel dKs;
    private com.baidu.adp.lib.d.b<ImageView> emM;
    private com.baidu.adp.lib.d.b<GifView> emN;
    private com.baidu.adp.lib.d.b<TextView> epE;
    private com.baidu.adp.lib.d.b<View> epF;
    private com.baidu.adp.lib.d.b<LinearLayout> epG;
    private com.baidu.adp.lib.d.b<RelativeLayout> epH;
    private VoiceManager gYv;
    private ar hCb;
    private com.baidu.tieba.frs.profession.permission.c hcb;
    private com.baidu.tieba.f.b hcw;
    public com.baidu.tbadk.core.util.aj iBh;
    private String jqc;
    private PbActivity jsZ;
    public ap jtF;
    private com.baidu.tbadk.core.dialog.i jtG;
    private com.baidu.tbadk.core.dialog.k jtH;
    private boolean jtI;
    private com.baidu.tieba.tbadkCore.data.f jtM;
    private com.baidu.tbadk.editortools.pb.g jtN;
    private com.baidu.tbadk.editortools.pb.e jtO;
    private com.baidu.tieba.frs.profession.permission.c jtQ;
    private EmotionImageData jtR;
    private com.baidu.adp.base.e jtU;
    private com.baidu.tbadk.core.view.d jtV;
    private BdUniqueId jtW;
    private Runnable jtX;
    private com.baidu.adp.widget.ImageView.a jtY;
    private String jtZ;
    private com.baidu.tieba.pb.pb.main.b.b jtb;
    private com.baidu.tieba.pb.pb.main.emotion.model.a jtq;
    private View jtr;
    int jtt;
    private ax jtw;
    private com.baidu.tieba.pb.pb.report.a jty;
    private boolean juE;
    private String juO;
    private com.baidu.tbadk.core.data.p juP;
    private TbRichTextMemeInfo jua;
    private List<a> jud;
    public String juf;
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
    private static final b.a juL = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        @Override // com.baidu.tieba.f.b.a
        public void bP(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cwo();
            } else {
                com.baidu.tieba.pb.a.b.cwn();
            }
        }
    };
    private boolean jta = false;
    private boolean jtc = false;
    private boolean aXb = false;
    private boolean iTM = false;
    private boolean jtd = true;
    private int jte = 0;
    private com.baidu.tbadk.core.dialog.b jtf = null;
    private long gBb = -1;
    private long edT = 0;
    private long jtg = 0;
    private long createTime = 0;
    private long edJ = 0;
    private boolean jth = false;
    private com.baidu.tbadk.n.b jti = null;
    private long jtj = 0;
    private boolean jtk = false;
    private long jtl = 0;
    private int hzC = 1;
    private String dYC = null;
    private boolean jtm = false;
    private boolean isFullScreen = false;
    private String jtn = "";
    private boolean jto = true;
    private boolean jtp = false;
    private String source = "";
    private int mSkinType = 3;
    int[] jts = new int[2];
    private int jtu = -1;
    private int jtv = -1;
    private PbInterviewStatusView.a jtx = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.jtB.ru(!PbFragment.this.jto);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.jqg != null && PbFragment.this.jqg.aGX()) {
                        PbFragment.this.cxM();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel jqg = null;
    private com.baidu.tbadk.baseEditMark.a jtz = null;
    private ForumManageModel gqg = null;
    private com.baidu.tbadk.coreExtra.model.a dzH = null;
    private com.baidu.tieba.pb.data.m jtA = null;
    private ShareSuccessReplyToServerModel hpe = null;
    private an jtB = null;
    private boolean jtC = false;
    private boolean jtD = false;
    private boolean jtE = false;
    private boolean eEl = false;
    private boolean jtJ = false;
    private boolean jtK = false;
    private boolean jtL = false;
    private boolean jtP = false;
    public boolean jtS = false;
    private com.baidu.tbadk.editortools.pb.c dYF = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aXl() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b dYG = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXk() {
            if (PbFragment.this.jtF == null || PbFragment.this.jtF.cBw() == null || !PbFragment.this.jtF.cBw().deR()) {
                return !PbFragment.this.zw(com.baidu.tbadk.core.util.aj.dzC);
            }
            PbFragment.this.showToast(PbFragment.this.jtF.cBw().deT());
            if (PbFragment.this.jtO != null && (PbFragment.this.jtO.aXA() || PbFragment.this.jtO.aXB())) {
                PbFragment.this.jtO.a(false, PbFragment.this.jtF.cBz());
            }
            PbFragment.this.jtF.rG(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b jtT = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXk() {
            if (PbFragment.this.jtF == null || PbFragment.this.jtF.cBx() == null || !PbFragment.this.jtF.cBx().deR()) {
                return !PbFragment.this.zw(com.baidu.tbadk.core.util.aj.dzD);
            }
            PbFragment.this.showToast(PbFragment.this.jtF.cBx().deT());
            if (PbFragment.this.jtB != null && PbFragment.this.jtB.cAh() != null && PbFragment.this.jtB.cAh().cxm() != null && PbFragment.this.jtB.cAh().cxm().aXB()) {
                PbFragment.this.jtB.cAh().cxm().a(PbFragment.this.jtF.cBz());
            }
            PbFragment.this.jtF.rH(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean gZh = false;
    private int jub = 0;
    private int juc = -1;
    public int jue = 0;
    private final a jug = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.jtB != null && PbFragment.this.jtB.cAh() != null) {
                s cAh = PbFragment.this.jtB.cAh();
                if (cAh.cxk()) {
                    cAh.cxj();
                    return true;
                }
            }
            if (PbFragment.this.jtB != null && PbFragment.this.jtB.cBf()) {
                PbFragment.this.jtB.cBg();
                return true;
            }
            return false;
        }
    };
    private final x.a juh = new x.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void aS(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.jtB.showToast(str);
            }
        }
    };
    private final CustomMessageListener jui = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jqg != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.jtO != null) {
                    PbFragment.this.jtB.rz(PbFragment.this.jtO.aXt());
                }
                PbFragment.this.jtB.cAj();
                PbFragment.this.jtB.cAX();
            }
        }
    };
    CustomMessageListener gZK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                PbFragment.this.jqg.updateCurrentUserPendant((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                if (PbFragment.this.jtB != null && PbFragment.this.jqg != null) {
                    PbFragment.this.jtB.b(PbFragment.this.jqg.getPbData(), PbFragment.this.jqg.cyy(), PbFragment.this.jqg.cyV(), PbFragment.this.jtB.getSkinType());
                }
                if (PbFragment.this.jtB != null && PbFragment.this.jtB.cAA() != null) {
                    PbFragment.this.jtB.cAA().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener juj = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.jtB != null) {
                    if (booleanValue) {
                        PbFragment.this.jtB.chk();
                    } else {
                        PbFragment.this.jtB.chj();
                    }
                }
            }
        }
    };
    private CustomMessageListener juk = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.jtO != null) {
                    PbFragment.this.jtB.rz(PbFragment.this.jtO.aXt());
                }
                PbFragment.this.jtB.rB(false);
            }
        }
    };
    private CustomMessageListener jul = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener jum = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jtB != null && PbFragment.this.jtB.cAA() != null) {
                PbFragment.this.jtB.cAA().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener ifd = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener gZH = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.aXb) {
                PbFragment.this.cyd();
            }
        }
    };
    private View.OnClickListener dZn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.dYC);
        }
    };
    private CustomMessageListener jun = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                ar.a aVar = new ar.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.thumbnailUrl = abVar.thumbnailUrl;
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqg.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.jqg.cyM() != null && PbFragment.this.jqg.cyM().getUserIdLong() == abVar.toUserId) {
                        PbFragment.this.jtB.a(abVar.sendCount, PbFragment.this.jqg.getPbData(), PbFragment.this.jqg.cyy(), PbFragment.this.jqg.cyV());
                    }
                    if (pbData.cvt() != null && pbData.cvt().size() >= 1 && pbData.cvt().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cvt().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.jqg.cyx(), 0L);
                        if (j == abVar.postId && j2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.ar cWw = pbData.cvt().get(0).cWw();
                            if (cWw == null) {
                                cWw = new com.baidu.tbadk.core.data.ar();
                            }
                            ArrayList<ar.a> aJA = cWw.aJA();
                            if (aJA == null) {
                                aJA = new ArrayList<>();
                            }
                            aJA.add(0, aVar);
                            cWw.setTotal(abVar.sendCount + cWw.getTotal());
                            cWw.w(aJA);
                            pbData.cvt().get(0).a(cWw);
                            PbFragment.this.jtB.cAA().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hqk = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                PbFragment.this.Hy((String) customResponsedMessage.getData());
                PbFragment.this.jqg.cyR();
                if (PbFragment.this.jtB.cAA() != null) {
                    PbFragment.this.jtB.o(PbFragment.this.jqg.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a juo = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cBO()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a jup = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aS(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.jtB != null) {
                PbFragment.this.jtB.dS(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean juq = false;
    private PraiseModel jur = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void yH(String str) {
            PbFragment.this.juq = false;
            if (PbFragment.this.jur != null) {
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqg.getPbData();
                if (pbData.cvr().aKn().getIsLike() == 1) {
                    PbFragment.this.ul(0);
                } else {
                    PbFragment.this.ul(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cvr()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.juq = false;
            if (PbFragment.this.jur != null && str != null) {
                if (AntiHelper.bq(i, str)) {
                    AntiHelper.aW(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a jus = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void ra(boolean z) {
            PbFragment.this.qZ(z);
            if (PbFragment.this.jtB.cBl() != null && z) {
                PbFragment.this.jtB.ru(false);
            }
            PbFragment.this.jtB.rw(z);
        }
    };
    private CustomMessageListener dzL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().dOt != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().dOt, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.cvy().aKC() != null && PbFragment.this.cvy().aKC().getGodUserData() != null) {
                            PbFragment.this.cvy().aKC().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().cvr() != null && PbFragment.this.jqg.getPbData().cvr().aKC() != null) {
                            PbFragment.this.jqg.getPbData().cvr().aKC().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h gXB = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.jsZ.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a jut = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.jtB.bzS();
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
                    com.baidu.tieba.j.a.bXs();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c dRm = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cxv();
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
                        if (PbFragment.this.jtB.cxt() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").cI("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cwp() != null && PbFragment.this.cwp().gHY != null) {
                                PbFragment.this.cwp().gHY.onClick(view);
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
                if (PbFragment.this.jtO != null) {
                    PbFragment.this.jtB.rz(PbFragment.this.jtO.aXt());
                }
                PbFragment.this.jtB.cAj();
                PbFragment.this.jtB.cAX();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener juu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jtW) {
                PbFragment.this.jtB.bzS();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqg.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cvE().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.jtV.showSuccessToast(PbFragment.this.jtU.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.jtU.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.wI(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cya();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.jtU.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.jtV.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener juv = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jtW) {
                PbFragment.this.jtB.bzS();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.jtV.showSuccessToast(PbFragment.this.jtU.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.jtU.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.jtV.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener juw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jtW) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.jtB.bzS();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.lgI;
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
                    PbFragment.this.jtB.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener jux = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jtB.cAk() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cxv();
            }
        }
    };
    private CustomMessageListener gZS = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.gZh = true;
                }
            }
        }
    };
    public a.b jeP = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bOS();
            com.baidu.tbadk.core.data.ap pageData = PbFragment.this.jqg.getPageData();
            int pageNum = PbFragment.this.jtB.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aJt()) {
                PbFragment.this.jtB.cAX();
                PbFragment.this.bOR();
                PbFragment.this.jtB.cAE();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.jqg.zA(PbFragment.this.jtB.getPageNum());
                    if (PbFragment.this.jtb != null) {
                        PbFragment.this.jtb.showFloatingView();
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
    public final View.OnClickListener haG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
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
                    if (view == PbFragment.this.jtB.cAT()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.jqg.rf(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.jtB.cAF();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.jtB.jzK.cCb() == null || view != PbFragment.this.jtB.jzK.cCb().czK()) {
                        if (view == PbFragment.this.jtB.jzK.efZ) {
                            if (PbFragment.this.jtB.ry(PbFragment.this.jqg.cyD())) {
                                PbFragment.this.bOR();
                                return;
                            }
                            PbFragment.this.jtd = false;
                            PbFragment.this.jtc = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.jsZ, PbFragment.this.jtB.jzK.efZ);
                            PbFragment.this.jsZ.finish();
                        } else if (view != PbFragment.this.jtB.cAC() && (PbFragment.this.jtB.jzK.cCb() == null || (view != PbFragment.this.jtB.jzK.cCb().czJ() && view != PbFragment.this.jtB.jzK.cCb().czH()))) {
                            if (view == PbFragment.this.jtB.cBb()) {
                                if (PbFragment.this.jqg != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jqg.getPbData().cvr().aKB().getLink());
                                }
                            } else if (view != PbFragment.this.jtB.jzK.jFO) {
                                if (view == PbFragment.this.jtB.jzK.jFP) {
                                    if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                        ArrayList<PostData> cvt = PbFragment.this.jqg.getPbData().cvt();
                                        if ((cvt == null || cvt.size() <= 0) && PbFragment.this.jqg.cyy()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").cI("tid", PbFragment.this.jqg.cyx()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", PbFragment.this.jqg.getForumId()));
                                        if (!PbFragment.this.jtB.cBq()) {
                                            PbFragment.this.jtB.cAj();
                                        }
                                        PbFragment.this.cxE();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.jtB.qP(true);
                                        PbFragment.this.jtB.cAj();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.jtB.chk();
                                            PbFragment.this.bOR();
                                            PbFragment.this.jtB.cAE();
                                            PbFragment.this.jqg.HF(PbFragment.this.cxQ());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.jtB.jzK.cCb() == null || view != PbFragment.this.jtB.jzK.cCb().czG()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.jtB.jzK.cCb() != null && view == PbFragment.this.jtB.jzK.cCb().czF()) {
                                            PbFragment.this.jtB.jzK.aAi();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.jtB.jzK.cCb() == null || view != PbFragment.this.jtB.jzK.cCb().czD()) {
                                                if ((PbFragment.this.jtB.jzK.cCb() == null || view != PbFragment.this.jtB.jzK.cCb().czM()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.jtB.jzK.cCb() == null || view != PbFragment.this.jtB.jzK.cCb().czE()) {
                                                        if (PbFragment.this.jtB.jzK.cCb() == null || view != PbFragment.this.jtB.jzK.cCb().czN()) {
                                                            if (PbFragment.this.jtB.cBl() == view) {
                                                                if (PbFragment.this.jtB.cBl().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.e pbData2 = PbFragment.this.jqg.getPbData();
                                                                    if (pbData2 != null && pbData2.cvr() != null && pbData2.cvr().aKi() != null) {
                                                                        String aJZ = pbData2.cvr().aKi().aJZ();
                                                                        if (StringUtils.isNull(aJZ)) {
                                                                            aJZ = pbData2.cvr().aKi().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").cI("obj_id", aJZ));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.eQ("c10725", null);
                                                                }
                                                                PbFragment.this.cxX();
                                                            } else if (PbFragment.this.jtB.jzK.cCb() == null || view != PbFragment.this.jtB.jzK.cCb().czL()) {
                                                                if (PbFragment.this.jtB.jzK.cCb() != null && view == PbFragment.this.jtB.jzK.cCb().czI()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.jtB.b(PbFragment.this.jqg.getPbData(), PbFragment.this.jqg.cyy(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.jtB.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.jtB.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.jtB.jzK.aAi();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.cI("tid", PbFragment.this.jqg.cyx());
                                                                        anVar.cI("fid", PbFragment.this.jqg.getForumId());
                                                                        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.af("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                                                            PbFragment.this.jtB.cAX();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cWA() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.kTq != null) {
                                                                                    com.baidu.tbadk.core.util.an aON = postData.kTq.aON();
                                                                                    aON.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aON.af("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aON.af("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aON);
                                                                                }
                                                                                String cyx = PbFragment.this.jqg.cyx();
                                                                                String id = postData.getId();
                                                                                int i3 = 0;
                                                                                if (PbFragment.this.jqg.getPbData() != null) {
                                                                                    i3 = PbFragment.this.jqg.getPbData().cvD();
                                                                                }
                                                                                PbFragment.this.bOR();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a HD = PbFragment.this.HD(id);
                                                                                    if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && HD != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cyx, id, "pb", true, null, true, null, i3, postData.cCY(), PbFragment.this.jqg.getPbData().getAnti(), false, postData.aKC().getIconInfo()).addBigImageData(HD.jql, HD.jqm, HD.jqn, HD.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.jqg.czg());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.jqg.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.jqg.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.jqg.cyF());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a HD2 = PbFragment.this.HD(id);
                                                                                    if (postData != null && PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && HD2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cyx, id, "pb", true, null, false, null, i3, postData.cCY(), PbFragment.this.jqg.getPbData().getAnti(), false, postData.aKC().getIconInfo()).addBigImageData(HD2.jql, HD2.jqm, HD2.jqn, HD2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.jqg.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.jqg.cyF());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.jqg.czg());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.jqg.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").af("obj_locate", 3).cI("fid", PbFragment.this.jqg.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.jqg != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.cI("tid", PbFragment.this.jqg.cyx());
                                                                        anVar2.cI("fid", PbFragment.this.jqg.getForumId());
                                                                        anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.af("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (postData2.kTq != null) {
                                                                                    com.baidu.tbadk.core.util.an aON2 = postData2.kTq.aON();
                                                                                    aON2.delete("obj_locate");
                                                                                    aON2.af("obj_locate", 8);
                                                                                    TiebaStatic.log(aON2);
                                                                                }
                                                                                if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                                                                    String cyx2 = PbFragment.this.jqg.cyx();
                                                                                    String id2 = postData2.getId();
                                                                                    int i4 = 0;
                                                                                    if (PbFragment.this.jqg.getPbData() != null) {
                                                                                        i4 = PbFragment.this.jqg.getPbData().cvD();
                                                                                    }
                                                                                    PbActivity.a HD3 = PbFragment.this.HD(id2);
                                                                                    if (HD3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cyx2, id2, "pb", true, null, false, null, i4, postData2.cCY(), PbFragment.this.jqg.getPbData().getAnti(), false, postData2.aKC().getIconInfo()).addBigImageData(HD3.jql, HD3.jqm, HD3.jqn, HD3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.jqg.czg());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.jqg.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.jqg.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.jqg.cyF());
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
                                                                    if (PbFragment.this.jqg != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.cI("tid", PbFragment.this.jqg.cyx());
                                                                        anVar3.cI("fid", PbFragment.this.jqg.getForumId());
                                                                        anVar3.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.af("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (postData3.kTq != null) {
                                                                                    com.baidu.tbadk.core.util.an aON3 = postData3.kTq.aON();
                                                                                    aON3.delete("obj_locate");
                                                                                    aON3.af("obj_locate", 8);
                                                                                    TiebaStatic.log(aON3);
                                                                                }
                                                                                if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.cxs().cAg() != null && postData3.aKC() != null && postData3.cWo() != 1) {
                                                                                    if (PbFragment.this.cxs().cAh() != null) {
                                                                                        PbFragment.this.cxs().cAh().cxi();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                                                                    lVar.a(PbFragment.this.jqg.getPbData().getForum());
                                                                                    lVar.setThreadData(PbFragment.this.jqg.getPbData().cvr());
                                                                                    lVar.f(postData3);
                                                                                    PbFragment.this.cxs().cAg().d(lVar);
                                                                                    PbFragment.this.cxs().cAg().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.aKC().getUserId(), "");
                                                                                    if (PbFragment.this.jtO != null) {
                                                                                        PbFragment.this.jtB.rz(PbFragment.this.jtO.aXt());
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
                                                                } else if (view != PbFragment.this.jtB.cwK()) {
                                                                    if (view == PbFragment.this.jtB.jzK.cCc()) {
                                                                        PbFragment.this.jtB.cAL();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (boVar = (bo) view.getTag()) != null && !StringUtils.isNull(boVar.aMK())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.aOV().b(PbFragment.this.getPageContext(), new String[]{boVar.aMK()});
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").cI("tid", PbFragment.this.jqg.jvW));
                                                                                    }
                                                                                    if (PbFragment.this.jtH == null) {
                                                                                        PbFragment.this.jtH = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.jtH.a(PbFragment.this.juK);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cD(view);
                                                                                    if (!PbFragment.this.cD(view) || PbFragment.this.jtY == null || !PbFragment.this.jtY.isGif()) {
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
                                                                                        if (postData4.cWq() != null && postData4.cWq().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.jtH);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar4.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar4);
                                                                                        }
                                                                                        PbFragment.this.hTb = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.jqg.getPbData().aGX()) {
                                                                                        String aGW = PbFragment.this.jqg.getPbData().aGW();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(aGW) && aGW.equals(postData4.getId())) {
                                                                                            z = true;
                                                                                            if (!z) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.jtH);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.jtH);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.hTb);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z4 && z3) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.jtH);
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
                                                                                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.jtH);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jtH);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.jtH);
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
                                                                                                    if (PbFragment.this.jqg.getPbData().cvD() == 1002 && !z2) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.jtH);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jtH);
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
                                                                                            PbFragment.this.jtH.aI(arrayList);
                                                                                            PbFragment.this.jtG = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jtH);
                                                                                            PbFragment.this.jtG.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z = false;
                                                                                    if (!z) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.hTb);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.jtH.aI(arrayList);
                                                                                    PbFragment.this.jtG = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jtH);
                                                                                    PbFragment.this.jtG.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().cvr() != null && PbFragment.this.jqg.getPbData().cvr().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.jqg.getPbData().cvr().getActUrl());
                                                                                if (PbFragment.this.jqg.getPbData().cvr().aLm() != 1) {
                                                                                    if (PbFragment.this.jqg.getPbData().cvr().aLm() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str2 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").cI("fid", PbFragment.this.jqg.getPbData().getForumId()).cI("tid", PbFragment.this.jqg.getPbData().getThreadId()).cI("lotterytail", StringUtils.string(str2, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.jqg.getPbData().getThreadId().equals(str2)) {
                                                                                    PbFragment.this.jtB.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.jtB.cAj();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.cxB() == 1 && PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").cI("fid", PbFragment.this.jqg.getPbData().getForumId()).cI("tid", PbFragment.this.jqg.getPbData().getThreadId()).cI("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.cxB() == 1 && PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").cI("fid", PbFragment.this.jqg.getPbData().getForumId()).cI("tid", PbFragment.this.jqg.getPbData().getThreadId()).cI("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.cxS();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.cxT();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().cvJ() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData3 = PbFragment.this.jqg.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").cI("fid", pbData3.getForumId()));
                                                                                ba.aOV().b(PbFragment.this.getPageContext(), new String[]{pbData3.cvJ().cvU()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().cvJ() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData4 = PbFragment.this.jqg.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cI("fid", pbData4.getForumId()));
                                                                                ba.aOV().b(PbFragment.this.getPageContext(), new String[]{pbData4.cvJ().cvU()});
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.jub >= 0) {
                                                                                if (PbFragment.this.jqg != null) {
                                                                                    PbFragment.this.jqg.czh();
                                                                                }
                                                                                if (PbFragment.this.jqg != null && PbFragment.this.jtB.cAA() != null) {
                                                                                    PbFragment.this.jtB.cAA().a(PbFragment.this.jqg.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.jub = 0;
                                                                                if (PbFragment.this.jqg != null) {
                                                                                    PbFragment.this.jtB.getListView().setSelection(PbFragment.this.jqg.czk());
                                                                                    PbFragment.this.jqg.cy(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.cxy();
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
                                                                            if (PbFragment.this.jtB.getListView() != null && PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.jtB.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.jtB.getListView().getChildAt(0);
                                                                                int top2 = childAt == null ? 0 : childAt.getTop();
                                                                                boolean aQe = PbFragment.this.jqg.getPbData().aQe();
                                                                                boolean z7 = PbFragment.this.jtB.cAi() != null && PbFragment.this.jtB.cAi().brI();
                                                                                boolean cAU = PbFragment.this.jtB.cAU();
                                                                                boolean z8 = firstVisiblePosition == 0 && top2 == 0;
                                                                                int i5 = 0;
                                                                                if (aQe && PbFragment.this.jtB.cAi() != null && PbFragment.this.jtB.cAi().blE() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.jtB.cAi().cBL();
                                                                                    z8 = firstVisiblePosition == 0 && (top2 == equipmentWidth || top2 == PbFragment.this.jtB.cAi().blE().getHeight() - PbFragment.this.jtB.cAi().cBL());
                                                                                    i5 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.HE("c13568");
                                                                                if ((PbFragment.this.jqg.getPbData().cvr() != null && PbFragment.this.jqg.getPbData().cvr().aKt() <= 0) || (cAU && z8)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.cxy();
                                                                                        if (PbFragment.this.jqg.getPbData().cvr().aKC() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", PbFragment.this.jqg.jvW).cI("fid", PbFragment.this.jqg.getPbData().getForumId()).af("obj_locate", 2).cI("uid", PbFragment.this.jqg.getPbData().cvr().aKC().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z9 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (aQe) {
                                                                                        if (PbFragment.this.jtB.jAR != null && PbFragment.this.jtB.jAR.jBV != null && PbFragment.this.jtB.jAR.jBV.getView() != null) {
                                                                                            if (PbFragment.this.jtB.jAR.jBV.getView().getParent() == null) {
                                                                                                z9 = firstVisiblePosition >= PbFragment.this.cxI();
                                                                                            } else {
                                                                                                int i6 = 0;
                                                                                                if (PbFragment.this.jtB.cAi() != null && PbFragment.this.jtB.cAi().blE() != null) {
                                                                                                    i6 = PbFragment.this.jtB.cAi().blE().getBottom();
                                                                                                }
                                                                                                z9 = PbFragment.this.jtB.jAR.jBV.getView().getTop() <= i6;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.jtB.cAr() != null) {
                                                                                        z9 = PbFragment.this.jtB.cAr().getVisibility() == 0;
                                                                                        if (!z9 && PbFragment.this.jtB.jAR != null && PbFragment.this.jtB.jAR.jBV != null && PbFragment.this.jtB.jAR.jBV.getView() != null && PbFragment.this.jtB.jAR.jBV.getView().getParent() != null && PbFragment.this.jtB.jzK != null && PbFragment.this.jtB.jzK.mNavigationBar != null) {
                                                                                            z9 = PbFragment.this.jtB.jAR.jBV.getView().getTop() - PbFragment.this.jtB.jzK.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z9 || cAU) {
                                                                                        PbFragment.this.jtu = firstVisiblePosition;
                                                                                        PbFragment.this.jtv = top2;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top2 < (-equipmentHeight))) {
                                                                                            PbFragment.this.jtB.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                            PbFragment.this.jtB.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.jtB.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.jtu > 0) {
                                                                                        if (PbFragment.this.jtB.getListView().getChildAt(PbFragment.this.jtu) != null) {
                                                                                            PbFragment.this.jtB.getListView().smoothScrollToPosition(PbFragment.this.jtu, PbFragment.this.jtv, 200);
                                                                                        } else {
                                                                                            PbFragment.this.jtB.getListView().setSelectionFromTop(PbFragment.this.jtu, PbFragment.this.jtv + equipmentHeight);
                                                                                            PbFragment.this.jtB.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int cxI = PbFragment.this.cxI();
                                                                                        if (PbFragment.this.cxH() != -1) {
                                                                                            cxI--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (cxI < 0) {
                                                                                            i = PbFragment.this.jtB.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.jtB.getListView().getData()) - 1);
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            i = cxI;
                                                                                            i2 = dimens;
                                                                                        }
                                                                                        if (z7) {
                                                                                            i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!aQe || PbFragment.this.jtB.cAi() == null) {
                                                                                            if (PbFragment.this.jtB.jzK != null && PbFragment.this.jtB.jzK.mNavigationBar != null) {
                                                                                                i2 += PbFragment.this.jtB.jzK.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i2 += PbFragment.this.jtB.cAi().cBK();
                                                                                        }
                                                                                        if (PbFragment.this.jtB.jAR == null || PbFragment.this.jtB.jAR.jBV == null || PbFragment.this.jtB.jAR.jBV.getView() == null || PbFragment.this.jtB.jAR.jBV.getView().getParent() == null) {
                                                                                            PbFragment.this.jtB.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                            PbFragment.this.jtB.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z7) {
                                                                                            PbFragment.this.jtB.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                        } else {
                                                                                            PbFragment.this.jtB.getListView().smoothScrollBy(PbFragment.this.jtB.jAR.jBV.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.jqg.getPbData().cvr() != null && PbFragment.this.jqg.getPbData().cvr().aKC() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", PbFragment.this.jqg.jvW).cI("fid", PbFragment.this.jqg.getPbData().getForumId()).af("obj_locate", 2).cI("uid", PbFragment.this.jqg.getPbData().cvr().aKC().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.jqg.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.jqg.czg() == 3) {
                                                                                    PbFragment.this.jsZ.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.jqg.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.cI("tid", PbFragment.this.jqg.cyx());
                                                                                anVar4.cI("fid", PbFragment.this.jqg.getForumId());
                                                                                anVar4.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar = (bj) view.getTag();
                                                                                if (PbFragment.this.jqg.czg() == 3 && PbFragment.this.cwq() && PbFragment.this.jqg.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.jqg.getPbData().cvK())) {
                                                                                    PbFragment.this.jsZ.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar.aKH(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
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
                                                                            if (PbFragment.this.jqg != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.cI("tid", PbFragment.this.jqg.cyx());
                                                                                anVar6.cI("fid", PbFragment.this.jqg.getForumId());
                                                                                anVar6.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.af("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData5 = PbFragment.this.jqg.getPbData();
                                                                                if (PbFragment.this.jtA == null) {
                                                                                    PbFragment.this.jtA = new com.baidu.tieba.pb.data.m(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").t("forum_id", j2).aOO();
                                                                                PbFragment.this.registerListener(PbFragment.this.juz);
                                                                                PbFragment.this.jtA.E(j, j2);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").cI("fid", PbFragment.this.jqg.getForumId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("obj_name", smartApp.name).t("obj_id", smartApp.swan_app_id.longValue()).cI("obj_source", "PB_card").cI("tid", PbFragment.this.jqg.cyx()).af("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar2 = (bj) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar2.aKH(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cI("page_type", PageStayDurationConstants.PageName.PB).af("obj_isad", 1).af("obj_floor", 1).af("obj_adlocate", 9).af("obj_locate", 9).t("obj_id", bjVar2.getFid()).cI("tid", bjVar2.getId()).af("thread_type", bjVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bj) && PbFragment.this.checkUpIsLogin()) {
                                                                                bj bjVar3 = (bj) view.getTag();
                                                                                if (PbFragment.this.dKs != null) {
                                                                                    PbFragment.this.dKs.eP(bjVar3.aKH(), String.valueOf(bjVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cI("page_type", PageStayDurationConstants.PageName.PB).af("obj_isad", 1).af("obj_floor", 1).af("obj_adlocate", 10).af("obj_locate", 11).t("obj_id", bjVar3.getFid()).cI("tid", bjVar3.getId()).af("thread_type", bjVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.jqg.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.jqg.cyx(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.jqg.getPbData().cvr().aKW())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.jtB.cAX();
                                                                SparseArray<Object> b3 = PbFragment.this.jtB.b(PbFragment.this.jqg.getPbData(), PbFragment.this.jqg.cyy(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jqg.getPbData().getForum().getId(), PbFragment.this.jqg.getPbData().getForum().getName(), PbFragment.this.jqg.getPbData().cvr().getId(), String.valueOf(PbFragment.this.jqg.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                            PbFragment.this.jtB.jzK.cCa();
                                                        }
                                                    } else if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().cvr() != null) {
                                                        PbFragment.this.jtB.jzK.aAi();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.HA(PbFragment.this.jqg.getPbData().cvr().aKS());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.jtB.cAX();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.jqg.cyP()));
                                                            return;
                                                        }
                                                        PbFragment.this.bOR();
                                                        PbFragment.this.jtB.cAE();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.jqg.getPbData().jnz == null || PbFragment.this.jqg.getPbData().jnz.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.jqg.getPbData().jnz.size()];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int i8 = i7;
                                                                if (i8 >= PbFragment.this.jqg.getPbData().jnz.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i8] = PbFragment.this.jqg.getPbData().jnz.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i7 = i8 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                int i10 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.jqg.getSortType() == 1 && i9 == 1) {
                                                                    i10 = 0;
                                                                } else if (PbFragment.this.jqg.getSortType() == 2 && i9 == 0) {
                                                                    i10 = 1;
                                                                } else if (PbFragment.this.jqg.getSortType() != 3 || i9 == 2) {
                                                                    i10 = (i9 != 2 || PbFragment.this.jqg.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").af("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).af("obj_type", i10));
                                                                if (PbFragment.this.jqg.getPbData().jnz != null && PbFragment.this.jqg.getPbData().jnz.size() > i9) {
                                                                    i9 = PbFragment.this.jqg.getPbData().jnz.get(i9).sort_type.intValue();
                                                                }
                                                                boolean zF = PbFragment.this.jqg.zF(i9);
                                                                view.setTag(Integer.valueOf(PbFragment.this.jqg.cyP()));
                                                                if (zF) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.jtB.rp(true);
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
                                                PbFragment.this.jtB.cAX();
                                                if (PbFragment.this.cwA().getPbData().jnA != 2) {
                                                    if (PbFragment.this.jqg.getPageData() != null) {
                                                        PbFragment.this.jtB.a(PbFragment.this.jqg.getPageData(), PbFragment.this.jeP);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.jqg.getPbData()) != null) {
                                            bj cvr = pbData.cvr();
                                            if (cvr != null && cvr.aKC() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", PbFragment.this.jqg.jvW).cI("fid", pbData.getForumId()).af("obj_locate", 4).cI("uid", cvr.aKC().getUserId()));
                                            }
                                            int i9 = 1;
                                            if (cvr != null) {
                                                if (cvr.aJr()) {
                                                    i9 = 2;
                                                } else if (cvr.aJs()) {
                                                    i9 = 3;
                                                } else if (cvr.aMw()) {
                                                    i9 = 4;
                                                } else if (cvr.aMx()) {
                                                    i9 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.cI("tid", PbFragment.this.jqg.cyx());
                                            anVar7.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.cI("fid", PbFragment.this.jqg.getForumId());
                                            if (view.getId() == R.id.share_num_container) {
                                                anVar7.af("obj_locate", 5);
                                            } else {
                                                anVar7.af("obj_locate", 6);
                                            }
                                            anVar7.af("obj_name", i9);
                                            anVar7.af("obj_type", 1);
                                            if (cvr != null) {
                                                if (cvr.aJr()) {
                                                    anVar7.af("obj_type", 10);
                                                } else if (cvr.aJs()) {
                                                    anVar7.af("obj_type", 9);
                                                } else if (cvr.aMx()) {
                                                    anVar7.af("obj_type", 8);
                                                } else if (cvr.aMw()) {
                                                    anVar7.af("obj_type", 7);
                                                } else if (cvr.isShareThread) {
                                                    anVar7.af("obj_type", 6);
                                                } else if (cvr.threadType == 0) {
                                                    anVar7.af("obj_type", 1);
                                                } else if (cvr.threadType == 40) {
                                                    anVar7.af("obj_type", 2);
                                                } else if (cvr.threadType == 49) {
                                                    anVar7.af("obj_type", 3);
                                                } else if (cvr.threadType == 54) {
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
                                                ArrayList<PostData> cvt2 = PbFragment.this.jqg.getPbData().cvt();
                                                if ((cvt2 != null && cvt2.size() > 0) || !PbFragment.this.jqg.cyy()) {
                                                    PbFragment.this.jtB.cAX();
                                                    PbFragment.this.bOR();
                                                    if (pbData.cvJ() != null && !StringUtils.isNull(pbData.cvJ().aIU(), true)) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cI("fid", PbFragment.this.jqg.getPbData().getForumId()));
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                    if (!AntiHelper.d(PbFragment.this.getContext(), cvr)) {
                                                        if (PbFragment.this.jtB != null) {
                                                            PbFragment.this.jtB.cBa();
                                                            PbFragment.this.jtB.t(pbData);
                                                        }
                                                        int i10 = 6;
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.jtB.showLoadingDialog();
                                                            PbFragment.this.jqg.czb().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
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
                                        PbFragment.this.jtB.cAX();
                                        if (PbFragment.this.jtB.jzK.cCb() != null && view == PbFragment.this.jtB.jzK.cCb().czG() && !PbFragment.this.jtB.cBq()) {
                                            PbFragment.this.jtB.cAj();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bOR();
                                            PbFragment.this.jtB.cAE();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                w = PbFragment.this.jqg.w(true, PbFragment.this.cxQ());
                                            } else {
                                                w = view.getId() == R.id.reply_title ? PbFragment.this.jqg.w(false, PbFragment.this.cxQ()) : PbFragment.this.jqg.HF(PbFragment.this.cxQ());
                                            }
                                            view.setTag(Boolean.valueOf(w));
                                            if (w) {
                                                PbFragment.this.jtB.qP(true);
                                                PbFragment.this.jtB.chk();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.jtB.rp(true);
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
                                    PbFragment.this.jtB.cAX();
                                    if (PbFragment.this.zx(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.jqg.zG(PbFragment.this.jtB.cAJ()) != null) {
                                        PbFragment.this.cxL();
                                        if (PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().cvr() != null && PbFragment.this.jqg.getPbData().cvr().aKC() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", PbFragment.this.jqg.jvW).cI("fid", PbFragment.this.jqg.getPbData().getForumId()).af("obj_locate", 3).cI("uid", PbFragment.this.jqg.getPbData().cvr().aKC().getUserId()));
                                        }
                                        if (PbFragment.this.jqg.getPbData().cvr() != null && PbFragment.this.jqg.getPbData().cvr().aKC() != null && PbFragment.this.jqg.getPbData().cvr().aKC().getUserId() != null && PbFragment.this.jtz != null) {
                                            int g = PbFragment.this.g(PbFragment.this.jqg.getPbData());
                                            bj cvr2 = PbFragment.this.jqg.getPbData().cvr();
                                            int i11 = 1;
                                            if (cvr2.aJr()) {
                                                i11 = 2;
                                            } else if (cvr2.aJs()) {
                                                i11 = 3;
                                            } else if (cvr2.aMw()) {
                                                i11 = 4;
                                            } else if (cvr2.aMx()) {
                                                i11 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cI("tid", PbFragment.this.jqg.jvW).af("obj_locate", 1).cI("obj_id", PbFragment.this.jqg.getPbData().cvr().aKC().getUserId()).af("obj_type", PbFragment.this.jtz.aGX() ? 0 : 1).af("obj_source", g).af("obj_param1", i11));
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
                                if (PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().cvr() != null && PbFragment.this.jqg.getPbData().cvr().aJp() && PbFragment.this.jqg.getPbData().cvr().aKT() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.jqg.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.jqg.cwr()) || PbFragment.this.jqg.getAppealInfo() == null) {
                                        PbFragment.this.jsZ.finish();
                                        return;
                                    }
                                    name = PbFragment.this.jqg.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.jqg.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.jsZ.finish();
                                    return;
                                }
                                String cwr = PbFragment.this.jqg.cwr();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.jqg.cyz() && cwr != null && cwr.equals(name)) {
                                    PbFragment.this.jsZ.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.jqg.getPbData() != null) {
                                if ((PbFragment.this.jqg.getPbData().cvD() == 1 || PbFragment.this.jqg.getPbData().cvD() == 3) && !PbFragment.this.gqg.cXc()) {
                                    PbFragment.this.jtB.cAX();
                                    int i12 = 0;
                                    if (PbFragment.this.jtB.jzK.cCb() == null || view != PbFragment.this.jtB.jzK.cCb().czH()) {
                                        if (PbFragment.this.jtB.jzK.cCb() == null || view != PbFragment.this.jtB.jzK.cCb().czJ()) {
                                            if (view == PbFragment.this.jtB.cAC()) {
                                                i12 = 2;
                                            }
                                        } else if (PbFragment.this.jqg.getPbData().cvr().aKy() == 1) {
                                            i12 = 3;
                                        } else {
                                            i12 = 6;
                                        }
                                    } else if (PbFragment.this.jqg.getPbData().cvr().aKx() == 1) {
                                        i12 = 5;
                                    } else {
                                        i12 = 4;
                                    }
                                    ForumData forum = PbFragment.this.jqg.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.jqg.getPbData().cvr().getId();
                                    PbFragment.this.jtB.cAB();
                                    PbFragment.this.gqg.b(id4, name2, id5, i12, PbFragment.this.jtB.cAD());
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
                        PbFragment.this.jtB.cAX();
                        PbFragment.this.bOR();
                        PbFragment.this.jtB.cAE();
                        PbFragment.this.jtB.showLoadingDialog();
                        if (PbFragment.this.jtB.cAr() != null) {
                            PbFragment.this.jtB.cAr().setVisibility(8);
                        }
                        PbFragment.this.jqg.zA(1);
                        if (PbFragment.this.jtb != null) {
                            PbFragment.this.jtb.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cxz = PbFragment.this.cxz();
                        if (!TextUtils.isEmpty(cxz)) {
                            ba.aOV().b(PbFragment.this.getPageContext(), new String[]{cxz});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.cI("tid", PbFragment.this.jqg.cyx());
                anVar8.cI("fid", PbFragment.this.jqg.getForumId());
                anVar8.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.af("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.jtk) {
                    PbFragment.this.jtk = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.cxs().cAg() != null && postData5.aKC() != null && postData5.cWo() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cxs().cAh() != null) {
                                PbFragment.this.cxs().cAh().cxi();
                            }
                            com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                            lVar2.a(PbFragment.this.jqg.getPbData().getForum());
                            lVar2.setThreadData(PbFragment.this.jqg.getPbData().cvr());
                            lVar2.f(postData5);
                            PbFragment.this.cxs().cAg().d(lVar2);
                            PbFragment.this.cxs().cAg().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.aKC().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.jqg.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.jtO != null) {
                                PbFragment.this.jtB.rz(PbFragment.this.jtO.aXt());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d dYM = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.jqg.getPbData() != null) {
                    anVar.cI("fid", PbFragment.this.jqg.getPbData().getForumId());
                }
                anVar.cI("tid", PbFragment.this.jqg.cyx());
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bOR();
            PbFragment.this.jtB.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.cwA() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.cwA().HI(postWriteCallBackData.getPostId());
                    PbFragment.this.jub = PbFragment.this.jtB.cAn();
                    PbFragment.this.jqg.cy(PbFragment.this.jub, PbFragment.this.jtB.cAo());
                }
                PbFragment.this.jtB.cAX();
                PbFragment.this.jtF.cBv();
                if (PbFragment.this.jtO != null) {
                    PbFragment.this.jtB.rz(PbFragment.this.jtO.aXt());
                }
                PbFragment.this.jtB.cAf();
                PbFragment.this.jtB.rB(true);
                PbFragment.this.jqg.cyR();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.jqg.getHostMode()) {
                            com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqg.getPbData();
                            if (pbData != null && pbData.cvr() != null && pbData.cvr().aKC() != null && (userId = pbData.cvr().aKC().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.jqg.cyI()) {
                                PbFragment.this.jtB.cAE();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.jqg.cyI()) {
                            PbFragment.this.jtB.cAE();
                        }
                    } else if (floor != null) {
                        PbFragment.this.jtB.o(PbFragment.this.jqg.getPbData());
                    }
                    if (PbFragment.this.jqg.cyC()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").cI("tid", PbFragment.this.jqg.cyx()));
                    }
                    PbFragment.this.cxC();
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.jtO.aXA() || PbFragment.this.jtO.aXB()) {
                    PbFragment.this.jtO.a(false, postWriteCallBackData);
                }
                PbFragment.this.jtF.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.iBh != null) {
                    PbFragment.this.iBh.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d juy = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                    anVar.cI("fid", PbFragment.this.jqg.getPbData().getForumId());
                }
                if (PbFragment.this.jqg != null) {
                    anVar.cI("tid", PbFragment.this.jqg.cyx());
                }
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.jtF != null) {
                    PbFragment.this.jtF.cBu();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.iBh != null) {
                    PbFragment.this.iBh.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.jtF != null) {
                if (PbFragment.this.jtB != null && PbFragment.this.jtB.cAh() != null && PbFragment.this.jtB.cAh().cxm() != null && PbFragment.this.jtB.cAh().cxm().aXB()) {
                    PbFragment.this.jtB.cAh().cxm().a(postWriteCallBackData);
                }
                PbFragment.this.jtF.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a juz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cBt;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.jsZ.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.jtB != null && (cBt = PbFragment.this.jtB.cBt()) != null && PbFragment.this.jtB.getListView() != null) {
                            PbFragment.this.jtB.getListView().removeHeaderView(cBt);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a juA = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mA;
            if (!z || eVar == null || eVar.cvB() != null || com.baidu.tbadk.core.util.v.getCount(eVar.cvt()) >= 1) {
                PbFragment.this.iTM = true;
                PbFragment.this.jtB.cAG();
                if (eVar == null || !eVar.cvx()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.jtB.getView());
                }
                PbFragment.this.jtB.chj();
                if (PbFragment.this.isFullScreen || PbFragment.this.jtB.cBq()) {
                    PbFragment.this.jtB.cBh();
                } else if (!PbFragment.this.jtB.cBe()) {
                    PbFragment.this.jtB.rB(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.eEl = true;
                }
                if (eVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.jtB.getView());
                    PbFragment.this.jtB.cAP();
                }
                if (z && eVar != null) {
                    bj cvr = eVar.cvr();
                    if (cvr == null || !cvr.aMy()) {
                        PbFragment.this.d(PbFragment.this.jtN);
                    } else {
                        cyj();
                    }
                    PbFragment.this.jtB.cAh().setPbData(eVar);
                    PbFragment.this.jtB.bpT();
                    if (cvr != null && cvr.aLK() != null) {
                        PbFragment.this.a(cvr.aLK());
                    }
                    if (PbFragment.this.jtO != null) {
                        PbFragment.this.jtB.rz(PbFragment.this.jtO.aXt());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                    if (eVar.cvt() != null && eVar.cvt().size() >= 1 && eVar.cvt().get(0) != null) {
                        PbFragment.this.jqg.HH(eVar.cvt().get(0).getId());
                    } else if (eVar.cvB() != null) {
                        PbFragment.this.jqg.HH(eVar.cvB().getId());
                    }
                    if (PbFragment.this.jtO != null) {
                        PbFragment.this.jtO.a(eVar.getAnti());
                        PbFragment.this.jtO.a(eVar.getForum(), eVar.getUserData());
                        PbFragment.this.jtO.setThreadData(cvr);
                        PbFragment.this.jtO.a(PbFragment.this.jqg.cyM(), PbFragment.this.jqg.cyx(), PbFragment.this.jqg.czd());
                        if (cvr != null) {
                            PbFragment.this.jtO.hH(cvr.aLW());
                        }
                    }
                    if (PbFragment.this.jtz != null) {
                        PbFragment.this.jtz.gk(eVar.aGX());
                    }
                    if (eVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (eVar.cvP()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.jtB.rA(PbFragment.this.mIsFromCDN);
                    PbFragment.this.jtB.a(eVar, i2, i3, PbFragment.this.jqg.cyy(), i4, PbFragment.this.jqg.getIsFromMark());
                    PbFragment.this.jtB.d(eVar, PbFragment.this.jqg.cyy());
                    PbFragment.this.jtB.rx(PbFragment.this.jqg.getHostMode());
                    AntiData anti = eVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.dYC = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.dYC) && PbFragment.this.jtO != null && PbFragment.this.jtO.aWN() != null && (mA = PbFragment.this.jtO.aWN().mA(6)) != null && !TextUtils.isEmpty(PbFragment.this.dYC)) {
                            ((View) mA).setOnClickListener(PbFragment.this.dZn);
                        }
                    }
                    if (PbFragment.this.jtJ) {
                        PbFragment.this.jtJ = false;
                        final int cxH = PbFragment.this.cxH();
                        if (!eVar.aQe()) {
                            PbFragment.this.jtB.zN(cxH);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cxH, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.jtK) {
                        PbFragment.this.jtK = false;
                        final int cxH2 = PbFragment.this.cxH();
                        final boolean z2 = cxH2 != -1;
                        if (!z2) {
                            cxH2 = PbFragment.this.cxI();
                        }
                        if (PbFragment.this.jtB != null) {
                            if (!eVar.aQe()) {
                                PbFragment.this.jtB.zN(cxH2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cxH2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.jtB.setSelectionFromTop(cxH2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.jtB.setSelectionFromTop(cxH2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.jtB.rC(true);
                                PbFragment.this.jtB.rB(false);
                            }
                        }
                    } else if (PbFragment.this.jtL) {
                        PbFragment.this.jtL = false;
                        PbFragment.this.jtB.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.jtB.cAK();
                    }
                    PbFragment.this.jqg.a(eVar.getForum(), PbFragment.this.juo);
                    PbFragment.this.jqg.a(PbFragment.this.jup);
                    if (PbFragment.this.iBh != null && cvr != null && cvr.aKC() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cvr.aKC());
                        PbFragment.this.iBh.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.eEl && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.jqg.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.jqg.getAppealInfo().jns)) {
                                    PbFragment.this.jtB.a(PbFragment.this.jqg.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.jtB.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.jtB.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.jtB.cBh();
                            PbFragment.this.jtB.cAO();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.jqg.cyx());
                            jSONObject.put("fid", PbFragment.this.jqg.getForumId());
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
                        PbFragment.this.jtB.HN("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                            arrayList = PbFragment.this.jqg.getPbData().cvt();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cWo() != 1)) {
                            PbFragment.this.jtB.HN(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbFragment.this.cyb()) {
                            PbFragment.this.jtB.HO(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbFragment.this.jtB.HO(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbFragment.this.jtB.endLoadData();
                }
                if (eVar != null && eVar.jnG && PbFragment.this.edT == 0) {
                    PbFragment.this.edT = System.currentTimeMillis() - PbFragment.this.gBb;
                }
                if (!PbFragment.this.cwA().cyy() || PbFragment.this.cwA().getPbData().getPage().aJz() != 0 || PbFragment.this.cwA().cyY()) {
                    PbFragment.this.jtP = true;
                    return;
                }
                return;
            }
            PbFragment.this.jqg.zA(1);
            if (PbFragment.this.jtb != null) {
                PbFragment.this.jtb.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cyj() {
            if (PbFragment.this.jqg != null) {
                if (PbFragment.this.jtO == null || !PbFragment.this.jtO.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.jtO = (com.baidu.tbadk.editortools.pb.e) dVar.dw(PbFragment.this.getContext());
                    PbFragment.this.jtO.a(PbFragment.this.jsZ.getPageContext());
                    PbFragment.this.jtO.a(PbFragment.this.dYM);
                    PbFragment.this.jtO.a(PbFragment.this.dYF);
                    PbFragment.this.jtO.a(PbFragment.this.jsZ.getPageContext(), PbFragment.this.jsZ.getIntent() == null ? null : PbFragment.this.jsZ.getIntent().getExtras());
                    PbFragment.this.jtO.aWN().hA(true);
                    PbFragment.this.jtB.setEditorTools(PbFragment.this.jtO.aWN());
                    if (!PbFragment.this.jqg.cyD()) {
                        PbFragment.this.jtO.wD(PbFragment.this.jqg.cyx());
                    }
                    if (PbFragment.this.jqg.cze()) {
                        PbFragment.this.jtO.wB(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.jtB != null) {
                        PbFragment.this.jtO.wB(PbFragment.this.jtB.cAl());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
            PbFragment.this.jtB.o(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.aZy().aZz()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.gBb : j;
                if (PbFragment.this.edT == 0) {
                    PbFragment.this.edT = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.edJ, PbFragment.this.createTime, PbFragment.this.edT, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.edJ = 0L;
                if (iVar != null) {
                    iVar.aZv();
                }
                if (z2) {
                    iVar.eec = currentTimeMillis;
                    iVar.hS(true);
                }
                if (!z2 && PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().cvr() != null) {
                    int threadType = PbFragment.this.jqg.getPbData().cvr().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.jtn, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.jtn, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.eee = currentTimeMillis;
                                iVar2.mY(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.eee = currentTimeMillis;
                        dVar.mY(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener juB = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cxD();
            }
        }
    };
    private final a.InterfaceC0425a juC = new a.InterfaceC0425a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0425a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.jtB.cAG();
            if (z) {
                if (PbFragment.this.jtz != null) {
                    PbFragment.this.jtz.gk(z2);
                }
                PbFragment.this.jqg.rh(z2);
                if (PbFragment.this.jqg.aGX()) {
                    PbFragment.this.cxM();
                } else {
                    PbFragment.this.jtB.o(PbFragment.this.jqg.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.jtz != null) {
                        if (PbFragment.this.jtz.aHa() != null && PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.jqg.getPbData().cvr() != null && PbFragment.this.jqg.getPbData().cvr().aKC() != null) {
                            MarkData aHa = PbFragment.this.jtz.aHa();
                            MetaData aKC = PbFragment.this.jqg.getPbData().cvr().aKC();
                            if (aHa != null && aKC != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aKC.getUserId()) && !aKC.hadConcerned()) {
                                    PbFragment.this.b(aKC);
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
                    PbFragment.this.cxJ();
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
                if (PbFragment.this.jtB != null) {
                    PbFragment.this.jtB.cAX();
                    if (PbFragment.this.jtO != null && !PbFragment.this.jtB.cAk()) {
                        PbFragment.this.jtB.rz(PbFragment.this.jtO.aXt());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.jtB.cAj();
                    }
                }
                if (!PbFragment.this.jth) {
                    PbFragment.this.jth = true;
                    if (PbFragment.this.jtB != null) {
                        PbFragment.this.jtB.cBd();
                    }
                }
            }
            if (PbFragment.this.jtB != null) {
                PbFragment.this.jtB.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.jtb != null) {
                PbFragment.this.jtb.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.jti == null) {
                PbFragment.this.jti = new com.baidu.tbadk.n.b();
                PbFragment.this.jti.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.jti.aZp();
            } else {
                PbFragment.this.jti.aZo();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.cVo().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cvt;
            if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null && PbFragment.this.jtB != null && PbFragment.this.jtB.cAA() != null) {
                PbFragment.this.jtB.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.jtb != null) {
                    PbFragment.this.jtb.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.jqg.cyU() && (cvt = PbFragment.this.jqg.getPbData().cvt()) != null && !cvt.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.jtB.cAA().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.e pbData = PbFragment.this.jqg.getPbData();
                    if (pbData != null) {
                        if (pbData.cvu() != null && pbData.cvu().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cvv() != null && pbData.cvv().hasData()) {
                            headerCount--;
                        }
                        int size = cvt.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d gql = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.gqg.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.jqg.cyR();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.jHG != 1002 || bVar.fqL) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.jtB.a(1, dVar.OL, dVar.kVg, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.gqg.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.jtB.a(PbFragment.this.gqg.getLoadDataMode(), gVar.OL, gVar.kVg, false);
                            PbFragment.this.jtB.aO(gVar.kVj);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.jtB.a(PbFragment.this.gqg.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c juD = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
    };
    private final g.c eBX = new g.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cxR()) {
                PbFragment.this.jsZ.finish();
            }
            if (!PbFragment.this.jqg.rg(true)) {
                PbFragment.this.jtB.cAH();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e juF = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.juE && PbFragment.this.cxR()) {
                PbFragment.this.cxT();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.jqg.rf(false)) {
                    PbFragment.this.jtB.cAF();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.jqg.getPbData() != null) {
                    PbFragment.this.jtB.cBc();
                }
                PbFragment.this.juE = true;
            }
        }
    };
    private int juG = 0;
    private final TbRichTextView.i emX = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f cAA;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.jtB.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.cI("tid", PbFragment.this.jqg.cyx());
                anVar.cI("fid", PbFragment.this.jqg.getForumId());
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.af("obj_locate", 3);
                anVar.af("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.jqg.jqZ.cvP()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bcg() != null) {
                            ArrayList<TbRichTextImageInfo> bcg = tbRichTextView.getRichText().bcg();
                            int i4 = 0;
                            while (i4 < bcg.size()) {
                                if (bcg.get(i4) != null) {
                                    arrayList.add(bcg.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bcg.get(i4).getSrc()) || str.equals(bcg.get(i4).bcy()) || str.equals(bcg.get(i4).bcv()) || str.equals(bcg.get(i4).bcx()) || str.equals(bcg.get(i4).bcB()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bcg.get(i4).getSrc();
                                    imageUrlData.originalUrl = bcg.get(i4).getSrc();
                                    imageUrlData.isLongPic = bcg.get(i4).bcD();
                                    concurrentHashMap.put(bcg.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.jqg.cyO(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.jqg.getPbData().cvr());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.jqo) {
                        TbRichText bt = PbFragment.this.bt(str, i);
                        if (bt != null && PbFragment.this.juG >= 0 && PbFragment.this.juG < bt.bcf().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.f.b(bt.bcf().get(PbFragment.this.juG));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.jql.size()) {
                                    break;
                                } else if (!aVar.jql.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bt.getPostId() != 0 && (cAA = PbFragment.this.jtB.cAA()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = cAA.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bt.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bt.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.jqg.czd(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.jqg.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.jqm.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jqn, aVar.lastId, PbFragment.this.jqg.cyO(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.jqg.getPbData().cvr());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.jql, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.jqm.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jqn, aVar.jql.get(0), PbFragment.this.jqg.cyO(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.jqg.getPbData().cvr());
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
                PbFragment.this.jtr = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean juH = false;
    PostData hTb = null;
    private final b.a juI = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.hTb != null) {
                if (i == 0) {
                    PbFragment.this.hTb.fa(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.hTb = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.k(PbFragment.this.hTb);
                }
            }
        }
    };
    private final b.a juJ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jtY != null && !TextUtils.isEmpty(PbFragment.this.jtZ)) {
                if (i == 0) {
                    if (PbFragment.this.jua == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.jtZ));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.jtZ;
                        aVar.pkgId = PbFragment.this.jua.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.jua.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.hCb == null) {
                            PbFragment.this.hCb = new ar(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.hCb.j(PbFragment.this.jtZ, PbFragment.this.jtY.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.jtY = null;
                PbFragment.this.jtZ = null;
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
                        PbFragment.this.jtY = ((TbImageView) view).getBdImage();
                        PbFragment.this.jtZ = ((TbImageView) view).getUrl();
                        if (PbFragment.this.jtY == null || TextUtils.isEmpty(PbFragment.this.jtZ)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.jua = null;
                        } else {
                            PbFragment.this.jua = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.jtY = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.jtZ = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.jua = null;
                            } else {
                                PbFragment.this.jua = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.jtY = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.jtZ = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.jua = null;
                        } else {
                            PbFragment.this.jua = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.jtB.a(PbFragment.this.juJ, PbFragment.this.jtY.isGif());
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
            PbFragment.this.hTb = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.hTb == null) {
                return true;
            }
            if (PbFragment.this.hTb.cWo() != 1 || !PbFragment.this.cD(view)) {
                if (PbFragment.this.jtz != null) {
                    if (!PbFragment.this.jtz.aGX() || PbFragment.this.hTb.getId() == null || !PbFragment.this.hTb.getId().equals(PbFragment.this.jqg.aKL())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.cwA().getPbData() != null && PbFragment.this.cwA().getPbData().cvP();
                    if (PbFragment.this.hTb.cWo() != 1) {
                        if (PbFragment.this.jtH == null) {
                            PbFragment.this.jtH = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.jtH.a(PbFragment.this.juK);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = PbFragment.this.cD(view) && !z3;
                            boolean z5 = (!PbFragment.this.cD(view) || PbFragment.this.jtY == null || PbFragment.this.jtY.isGif()) ? false : true;
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
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.jtH));
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.jtH));
                            }
                            if (!z4 && !z5) {
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.jtH);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.hTb);
                                gVar3.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar3);
                            }
                            if (!z2 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.jtH);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.jtH);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.hTb);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z8 && z7) {
                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.jtH);
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
                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.jtH);
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
                                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jtH);
                                        gVar6.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.jtH);
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
                                        if (PbFragment.this.jqg.getPbData().cvD() == 1002 && !z6) {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.jtH);
                                        } else {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jtH);
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
                            PbFragment.this.jtH.aI(arrayList);
                            PbFragment.this.jtG = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jtH);
                            PbFragment.this.jtG.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").cI("tid", PbFragment.this.jqg.jvW).cI("fid", PbFragment.this.jqg.getForumId()).cI("uid", PbFragment.this.jqg.getPbData().cvr().aKC().getUserId()).cI("post_id", PbFragment.this.jqg.aXi()).af("obj_source", z2 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.jtB.a(PbFragment.this.juI, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.jtB.a(PbFragment.this.juJ, PbFragment.this.jtY.isGif());
            return true;
        }
    };
    private k.c juK = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            int i2;
            if (PbFragment.this.jtG != null) {
                PbFragment.this.jtG.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.jtY != null && !TextUtils.isEmpty(PbFragment.this.jtZ)) {
                        if (PbFragment.this.jua == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.jtZ));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.jtZ;
                            aVar.pkgId = PbFragment.this.jua.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.jua.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.jtY = null;
                        PbFragment.this.jtZ = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.jtY != null && !TextUtils.isEmpty(PbFragment.this.jtZ)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.hCb == null) {
                                PbFragment.this.hCb = new ar(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.hCb.j(PbFragment.this.jtZ, PbFragment.this.jtY.getImageByte());
                            PbFragment.this.jtY = null;
                            PbFragment.this.jtZ = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.hTb != null) {
                        PbFragment.this.hTb.fa(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.hTb = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").af("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cC(view);
                        if (PbFragment.this.jqg.getPbData().cvr() != null && PbFragment.this.jqg.getPbData().cvr().aKC() != null && PbFragment.this.jqg.getPbData().cvr().aKC().getUserId() != null && PbFragment.this.jtz != null) {
                            int g = PbFragment.this.g(PbFragment.this.jqg.getPbData());
                            bj cvr = PbFragment.this.jqg.getPbData().cvr();
                            if (cvr.aJr()) {
                                i2 = 2;
                            } else if (cvr.aJs()) {
                                i2 = 3;
                            } else if (cvr.aMw()) {
                                i2 = 4;
                            } else {
                                i2 = cvr.aMx() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cI("tid", PbFragment.this.jqg.jvW).af("obj_locate", 2).cI("obj_id", PbFragment.this.jqg.getPbData().cvr().aKC().getUserId()).af("obj_type", PbFragment.this.jtz.aGX() ? 0 : 1).af("obj_source", g).af("obj_param1", i2));
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
                        PbFragment.this.HA((String) tag);
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
                        PbFragment.this.jtB.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.jtB.cI(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.jtB.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a gVS = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.aXb && z && !PbFragment.this.jqg.cyE()) {
                PbFragment.this.cxO();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener dSb = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.hcw.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0557a gxj = new a.InterfaceC0557a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        final int fqp = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void y(int i, int i2) {
            if (af(i2) && PbFragment.this.jtB != null && PbFragment.this.jtb != null) {
                PbFragment.this.jtb.mK(true);
                if (Math.abs(i2) > this.fqp) {
                    PbFragment.this.jtb.hideFloatingView();
                }
                if (PbFragment.this.cxR()) {
                    PbFragment.this.jtB.cAx();
                    PbFragment.this.jtB.cAy();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void z(int i, int i2) {
            if (af(i2) && PbFragment.this.jtB != null && PbFragment.this.jtb != null) {
                PbFragment.this.jtB.cBi();
                PbFragment.this.jtb.mK(false);
                PbFragment.this.jtb.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void A(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a jsh = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void n(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.jtB.HP(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int juM = -1;
    private int juN = -1;

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

    public com.baidu.tbadk.editortools.pb.e cxn() {
        return this.jtO;
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (lVar.cwe() != null) {
            String id = lVar.cwe().getId();
            ArrayList<PostData> cvt = this.jqg.getPbData().cvt();
            int i = 0;
            while (true) {
                if (i >= cvt.size()) {
                    break;
                }
                PostData postData = cvt.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cwi = lVar.cwi();
                    postData.Dh(lVar.getTotalCount());
                    if (postData.cWl() != null && cwi != null) {
                        Iterator<PostData> it = cwi.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aKC() != null && (metaData = postData.getUserMap().get(next.aKC().getUserId())) != null) {
                                next.a(metaData);
                                next.tW(true);
                                next.a(getPageContext(), this.jqg.HG(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cwi.size() != postData.cWl().size();
                        postData.cWl().clear();
                        postData.cWl().addAll(cwi);
                        z = z2;
                    }
                    if (postData.cWh() != null) {
                        postData.cWi();
                    }
                }
            }
            if (!this.jqg.getIsFromMark() && z) {
                this.jtB.o(this.jqg.getPbData());
            }
            if (z) {
                c(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m cvG = this.jqg.getPbData().cvG();
            if (cvG != null && str.equals(cvG.getAdId())) {
                if (cvG.cWc() != null) {
                    cvG.cWc().legoCard = null;
                }
                this.jqg.getPbData().cvH();
            }
            com.baidu.tieba.tbadkCore.data.m cyK = this.jqg.cyK();
            if (cyK != null && str.equals(cyK.getAdId())) {
                this.jqg.cyL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.jtG != null && this.jtG.isShowing()) {
                this.jtG.dismiss();
                this.jtG = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.jtG != null) {
                            PbFragment.this.jtG.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.jtB.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.jtW);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.jtW);
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
                this.jtG = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.jtG.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(int i) {
        bj cvr;
        if (this.jqg != null && this.jqg.getPbData() != null && (cvr = this.jqg.getPbData().cvr()) != null) {
            if (i == 1) {
                PraiseData aKn = cvr.aKn();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aKn == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cvr.a(praiseData);
                    } else {
                        cvr.aKn().getUser().add(0, metaData);
                        cvr.aKn().setNum(cvr.aKn().getNum() + 1);
                        cvr.aKn().setIsLike(i);
                    }
                }
                if (cvr.aKn() != null) {
                    if (cvr.aKn().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(cvr.aKn().getNum());
                    }
                }
            } else if (cvr.aKn() != null) {
                cvr.aKn().setIsLike(i);
                cvr.aKn().setNum(cvr.aKn().getNum() - 1);
                ArrayList<MetaData> user = cvr.aKn().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cvr.aKn().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cvr.aKn().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cvr.aKn().getNum() + "";
                }
            }
            if (this.jqg.cyy()) {
                this.jtB.cAA().notifyDataSetChanged();
            } else {
                this.jtB.p(this.jqg.getPbData());
            }
        }
    }

    public static PbFragment cxo() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.jsZ = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jqg.au(bundle);
        if (this.gYv != null) {
            this.gYv.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.jtO.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.jtg = System.currentTimeMillis();
        this.jtU = getPageContext();
        final Intent intent = this.jsZ.getIntent();
        if (intent != null) {
            this.gBb = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.jtn = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.jtn)) {
                    this.jtn = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.jtn)) {
                this.jtc = true;
            }
            this.juM = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.juN = intent.getIntExtra("key_manga_next_chapter", -1);
            this.juO = intent.getStringExtra("key_manga_title");
            this.jtJ = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.jtK = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.jtL = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cxR()) {
                this.jsZ.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.juc = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.jtw = new ax();
            this.jtw.D(intent);
            this.jue = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.jue == 0) {
                this.jue = intent.getIntExtra("key_start_from", 0);
            }
            this.juf = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.gBb = System.currentTimeMillis();
        }
        this.edJ = this.jtg - this.gBb;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.jte = 0;
        at(bundle);
        if (this.jqg.getPbData() != null) {
            this.jqg.getPbData().Hu(this.source);
        }
        cxr();
        if (intent != null && this.jtB != null) {
            this.jtB.jzI = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.jtX == null) {
                    this.jtX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.jtB.HR(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(this.jtX, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.jqg.getPbData() != null) {
                this.jqg.HJ(stringExtra);
            }
        }
        this.gYv = new VoiceManager();
        this.gYv.onCreate(getPageContext());
        initData(bundle);
        this.jtN = new com.baidu.tbadk.editortools.pb.g();
        d(this.jtN);
        this.jtO = (com.baidu.tbadk.editortools.pb.e) this.jtN.dw(getActivity());
        this.jtO.a(this.jsZ.getPageContext());
        this.jtO.a(this.dYM);
        this.jtO.a(this.dYF);
        this.jtO.a(this.jsZ.getPageContext(), bundle);
        this.jtO.aWN().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.jtO.aWN().hA(true);
        qU(true);
        this.jtO.a(this.jqg.cyM(), this.jqg.cyx(), this.jqg.czd());
        registerListener(this.juk);
        if (!this.jqg.cyD()) {
            this.jtO.wD(this.jqg.cyx());
        }
        if (this.jqg.cze()) {
            this.jtO.wB(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.jtB != null) {
            this.jtO.wB(this.jtB.cAl());
        }
        registerListener(this.juj);
        registerListener(this.jul);
        registerListener(this.jum);
        registerListener(this.gZK);
        registerListener(this.jux);
        registerListener(this.jui);
        this.jtM = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.kRS);
        this.jtM.cVV();
        registerListener(this.jun);
        registerListener(this.dzL);
        this.jqg.cyW();
        registerListener(this.juB);
        registerListener(this.gZS);
        if (this.jtB != null && this.jtB.cBm() != null && this.jtB.cBn() != null) {
            this.jtb = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.jtB.cBm(), this.jtB.cBn(), this.jtB.cAr());
            this.jtb.a(this.jus);
        }
        if (this.jta && this.jtB != null && this.jtB.cBn() != null) {
            this.jtB.cBn().setVisibility(8);
        }
        this.jtV = new com.baidu.tbadk.core.view.d();
        this.jtV.toastTime = 1000L;
        registerListener(this.juw);
        registerListener(this.juu);
        registerListener(this.juv);
        registerListener(this.hqk);
        registerListener(this.gZH);
        registerResponsedEventListener(TipEvent.class, this.gXB);
        this.jtW = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.jtW;
        userMuteAddAndDelCustomMessage.setTag(this.jtW);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.jtW;
        userMuteCheckCustomMessage.setTag(this.jtW);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.jqg.czb().a(this.jut);
        this.jtF = new ap();
        if (this.jtO.aXm() != null) {
            this.jtF.d(this.jtO.aXm().getInputView());
        }
        this.jtO.a(this.dYG);
        this.hpe = new ShareSuccessReplyToServerModel();
        a(this.jug);
        this.iBh = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.iBh.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
            @Override // com.baidu.tbadk.core.util.aj.a
            public void m(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.dzC) {
                        PbFragment.this.jtO.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.dzD && PbFragment.this.jtB != null && PbFragment.this.jtB.cAh() != null && PbFragment.this.jtB.cAh().cxm() != null) {
                        PbFragment.this.jtB.cAh().cxm().aXI();
                    } else if (i == com.baidu.tbadk.core.util.aj.dzE) {
                        PbFragment.this.c(PbFragment.this.jtR);
                    }
                }
            }
        });
        this.jty = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.jty.t(getUniqueId());
        com.baidu.tieba.s.c.cVo().w(getUniqueId());
        com.baidu.tbadk.core.business.a.aIo().cy("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.jtg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.jqg != null) {
            gVar.setForumName(this.jqg.cwr());
            if (this.jqg.getPbData() != null && this.jqg.getPbData().getForum() != null) {
                gVar.a(this.jqg.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.jqg);
        }
    }

    public String cxp() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cxq() {
        return this.jtb;
    }

    private void qU(boolean z) {
        this.jtO.hE(z);
        this.jtO.hF(z);
        this.jtO.hG(z);
    }

    private void cxr() {
        this.dKs = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gYv != null) {
            this.gYv.onStart(getPageContext());
        }
    }

    public an cxs() {
        return this.jtB;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cwA() {
        return this.jqg;
    }

    public void Hz(String str) {
        if (this.jqg != null && !StringUtils.isNull(str) && this.jtB != null) {
            this.jtB.rE(true);
            this.jqg.Hz(str);
            this.jtm = true;
            this.jtB.cAX();
            this.jtB.cBh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.aXb = false;
        } else {
            this.aXb = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.jte = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.jte == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.gYv != null) {
            this.gYv.onPause(getPageContext());
        }
        if (this.jtB != null) {
            this.jtB.onPause();
        }
        if (!this.jqg.cyD()) {
            this.jtO.wC(this.jqg.cyx());
        }
        if (this.jqg != null) {
            this.jqg.cyX();
        }
        com.baidu.tbadk.BdToken.c.aFN().aFS();
        MessageManager.getInstance().unRegisterListener(this.ifd);
        caN();
        MessageManager.getInstance().unRegisterListener(this.juu);
        MessageManager.getInstance().unRegisterListener(this.juv);
        MessageManager.getInstance().unRegisterListener(this.juw);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cxt() {
        PostData a2 = com.baidu.tieba.pb.data.f.a(this.jqg.getPbData(), this.jqg.cyy(), this.jqg.cyV());
        return (a2 == null || a2.aKC() == null || a2.aKC().getGodUserData() == null || a2.aKC().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.aXb = false;
        super.onResume();
        if (this.jtp) {
            this.jtp = false;
            cxX();
        }
        if (cxt()) {
            this.jtj = System.currentTimeMillis();
        } else {
            this.jtj = -1L;
        }
        if (this.jtB != null && this.jtB.getView() != null) {
            if (!this.iTM) {
                cxP();
            } else {
                hideLoadingView(this.jtB.getView());
            }
            this.jtB.onResume();
        }
        if (this.jte == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.jtB != null) {
            noNetworkView = this.jtB.cAe();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.gYv != null) {
            this.gYv.onResume(getPageContext());
        }
        registerListener(this.ifd);
        this.jtI = false;
        cxW();
        registerListener(this.juu);
        registerListener(this.juv);
        registerListener(this.juw);
        if (this.gZh) {
            cxO();
            this.gZh = false;
        }
        cyd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.jtB.rt(z);
        if (this.jtG != null) {
            this.jtG.dismiss();
        }
        if (z && this.jtI) {
            this.jtB.cAF();
            this.jqg.rf(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.jtj > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").cI("obj_duration", (System.currentTimeMillis() - this.jtj) + ""));
            this.jtj = 0L;
        }
        if (cxs().cAh() != null) {
            cxs().cAh().onStop();
        }
        if (this.jtB.jzK != null && !this.jtB.jzK.cCd()) {
            this.jtB.jzK.releaseResources();
        }
        if (this.jqg != null && this.jqg.getPbData() != null && this.jqg.getPbData().getForum() != null && this.jqg.getPbData().cvr() != null) {
            com.baidu.tbadk.distribute.a.aWB().b(getPageContext().getPageActivity(), "pb", this.jqg.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jqg.getPbData().cvr().getId(), 0L));
        }
        if (this.gYv != null) {
            this.gYv.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.cVo().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cVo().x(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cI("fid", this.jqg.getPbData().getForumId());
            anVar.cI("tid", this.jqg.cyx());
            anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.jth && this.jtB != null) {
            this.jth = true;
            this.jtB.cBd();
            a(false, (PostData) null);
        }
        if (this.jqg != null) {
            this.jqg.cancelLoadData();
            this.jqg.destory();
            if (this.jqg.cza() != null) {
                this.jqg.cza().onDestroy();
            }
        }
        if (this.jtO != null) {
            this.jtO.onDestroy();
        }
        if (this.gqg != null) {
            this.gqg.cancelLoadData();
        }
        if (this.dKs != null) {
            this.dKs.cVI();
        }
        if (this.jtB != null) {
            this.jtB.onDestroy();
            if (this.jtB.jzK != null) {
                this.jtB.jzK.releaseResources();
            }
        }
        if (this.jti != null) {
            this.jti.aZq();
        }
        if (this.jtb != null) {
            this.jtb.beR();
        }
        super.onDestroy();
        if (this.gYv != null) {
            this.gYv.onDestory(getPageContext());
        }
        if (this.jtB != null) {
            this.jtB.cAX();
        }
        MessageManager.getInstance().unRegisterListener(this.juu);
        MessageManager.getInstance().unRegisterListener(this.juv);
        MessageManager.getInstance().unRegisterListener(this.juw);
        MessageManager.getInstance().unRegisterListener(this.jtW);
        MessageManager.getInstance().unRegisterListener(this.jux);
        MessageManager.getInstance().unRegisterListener(this.gZS);
        MessageManager.getInstance().unRegisterListener(this.hqk);
        MessageManager.getInstance().unRegisterListener(this.juz);
        this.jtU = null;
        this.jtV = null;
        com.baidu.tieba.recapp.d.a.cNY().cOa();
        if (this.jtX != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jtX);
        }
        if (this.jtq != null) {
            this.jtq.cancelLoadData();
        }
        if (this.jtB != null && this.jtB.jzK != null) {
            this.jtB.jzK.cCg();
        }
        if (this.hpe != null) {
            this.hpe.cancelLoadData();
        }
        this.jtF.onDestroy();
        if (this.jqg != null && this.jqg.czc() != null) {
            this.jqg.czc().onDestroy();
        }
        if (this.iBh != null) {
            this.iBh.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f cAA;
        ArrayList<PostData> cwY;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aRC() && this.jtB != null && (cAA = this.jtB.cAA()) != null && (cwY = cAA.cwY()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cwY.iterator();
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
                        bVar.gsb = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.dsl == 1 && !TextUtils.isEmpty(id)) {
                    next.dsl = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.gsb = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.jqg == null || this.jqg.getPbData() == null || this.jqg.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.jqg.getPbData().getForum().getFirst_class();
                    str2 = this.jqg.getPbData().getForum().getSecond_class();
                    str = this.jqg.getPbData().getForum().getId();
                    str4 = this.jqg.cyx();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aRF());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.jtB.onChangeSkinType(i);
            if (this.jtO != null && this.jtO.aWN() != null) {
                this.jtO.aWN().onChangeSkinType(i);
            }
            if (this.jtB.cAe() != null) {
                this.jtB.cAe().onChangeSkinType(getPageContext(), i);
            }
            this.jtF.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jtB = new an(this, this.haG, this.dRm);
        this.hcw = new com.baidu.tieba.f.b(getActivity());
        this.hcw.a(juL);
        this.hcw.a(this.gxj);
        this.jtB.setOnScrollListener(this.mOnScrollListener);
        this.jtB.d(this.juF);
        this.jtB.setListPullRefreshListener(this.eBX);
        this.jtB.qG(com.baidu.tbadk.core.i.aIc().isShowImages());
        this.jtB.setOnImageClickListener(this.emX);
        this.jtB.b(this.mOnLongClickListener);
        this.jtB.g(this.gVS);
        this.jtB.a(this.juD);
        this.jtB.rt(this.mIsLogin);
        if (this.jsZ.getIntent() != null) {
            this.jtB.rF(this.jsZ.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.jtB.cAg().setFromForumId(this.jqg.getFromForumId());
        this.jtB.setEditorTools(this.jtO.aWN());
        this.jtO.wB(this.jtB.cAl());
        this.jtB.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.jqg.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jqg.getPbData().getForum().getId(), PbFragment.this.jqg.getPbData().getForum().getName(), PbFragment.this.jqg.getPbData().cvr().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.jtB.getView();
    }

    public void cxu() {
        if (this.jtB != null && this.jqg != null) {
            if ((this.jqg.getPbData() != null || this.jqg.getPbData().cvM() != null) && checkUpIsLogin() && this.jtB.cAA() != null && this.jtB.cAA().cxd() != null) {
                this.jtB.cAA().cxd().vo(this.jqg.cyx());
            }
        }
    }

    public void cxv() {
        TiebaStatic.log("c12181");
        if (this.jtB != null && this.jqg != null) {
            if ((this.jtB == null || this.jtB.cAk()) && this.jqg.getPbData() != null && this.jqg.getPbData().cvM() != null) {
                com.baidu.tieba.pb.data.k cvM = this.jqg.getPbData().cvM();
                if (checkUpIsLogin()) {
                    if ((!cvM.cwb() || cvM.aMa() != 2) && this.jtB.cAA() != null && this.jtB.cAA().cxd() != null) {
                        this.jtB.cAA().cxd().vo(this.jqg.cyx());
                    }
                    if (System.currentTimeMillis() - this.jtl > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).sn(false);
                        this.jtl = System.currentTimeMillis();
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
                if (postData.getType() != PostData.kSt && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.aIc().isShowImages()) {
                    return HC(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.jqg == null || this.jqg.getPbData() == null) {
                        return true;
                    }
                    if (cxs().cAh() != null) {
                        cxs().cAh().cxi();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(this.jqg.getPbData().getForum());
                    lVar.setThreadData(this.jqg.getPbData().cvr());
                    lVar.f(postData);
                    cxs().cAg().d(lVar);
                    cxs().cAg().setPostId(postData.getId());
                    b(view, postData.aKC().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.jtO != null) {
                        this.jtB.rz(this.jtO.aXt());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cxw() {
        if (this.jtf == null) {
            this.jtf = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.jtf.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.jqc = PbFragment.this.jqc.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jqc);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.jqg.cyx(), PbFragment.this.jqc, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.jqc = PbFragment.this.jqc.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jqc);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.jqg.cyx(), PbFragment.this.jqc, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.jqc = PbFragment.this.jqc.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jqc);
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
        this.juA.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).cEd(), "", 1);
    }

    private void at(Bundle bundle) {
        this.jqg = this.jsZ.cwA();
        if (this.jqg.cyZ() != null) {
            this.jqg.cyZ().a(this.jsh);
        }
        if (this.jqg.cza() != null) {
            this.jqg.cza().b(this.juh);
        }
        if (StringUtils.isNull(this.jqg.cyx())) {
            this.jsZ.finish();
        } else if ("from_tieba_kuang".equals(this.jtn) && this.jtn != null) {
            this.jqg.zH(6);
        }
    }

    private void initData(Bundle bundle) {
        this.jtz = com.baidu.tbadk.baseEditMark.a.a(this.jsZ);
        if (this.jtz != null) {
            this.jtz.a(this.juC);
        }
        this.gqg = new ForumManageModel(this.jsZ);
        this.gqg.setLoadDataCallBack(this.gql);
        this.dzH = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.jur.setUniqueId(getUniqueId());
        this.jur.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jtB.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.jtW;
        userMuteCheckCustomMessage.setTag(this.jtW);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cxx() {
        if (this.jqg == null || this.jqg.getPbData() == null) {
            return false;
        }
        bj cvr = this.jqg.getPbData().cvr();
        this.jqg.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cvr);
    }

    public void cxy() {
        if (checkUpIsLogin() && this.jqg != null && this.jqg.getPbData() != null && this.jqg.getPbData().getForum() != null && !cxx()) {
            if (this.jqg.getPbData().cvP()) {
                this.jtB.cao();
                return;
            }
            if (this.hcb == null) {
                this.hcb = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hcb.ut(0);
                this.hcb.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void mF(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void u(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void mG(boolean z) {
                        if (z) {
                            PbFragment.this.jtB.cao();
                        }
                    }
                });
            }
            this.hcb.E(this.jqg.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jqg.cyx(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cxz() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.jqg == null || (pbData = this.jqg.getPbData()) == null) {
            return null;
        }
        return pbData.cvC().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvr() != null) {
            if (eVar.cvr().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cvr().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cvr().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cxx() && cxA()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.jts);
                this.jtt = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.jqg.getPbData() != null && this.jqg.getPbData().cvP()) {
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.jsZ.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cxs().getListView().smoothScrollBy((PbFragment.this.jts[1] + PbFragment.this.jtt) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cxs().cAh() != null) {
                            PbFragment.this.jtO.aWN().setVisibility(8);
                            PbFragment.this.cxs().cAh().g(str, str2, PbFragment.this.cxs().cAl(), (PbFragment.this.jqg == null || PbFragment.this.jqg.getPbData() == null || PbFragment.this.jqg.getPbData().cvr() == null || !PbFragment.this.jqg.getPbData().cvr().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cxm = PbFragment.this.cxs().cAh().cxm();
                            if (cxm != null && PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                cxm.a(PbFragment.this.jqg.getPbData().getAnti());
                                cxm.setThreadData(PbFragment.this.jqg.getPbData().cvr());
                            }
                            if (PbFragment.this.jtF.cBy() == null && PbFragment.this.cxs().cAh().cxm().aXQ() != null) {
                                PbFragment.this.cxs().cAh().cxm().aXQ().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jtF != null && PbFragment.this.jtF.cBx() != null) {
                                            if (!PbFragment.this.jtF.cBx().deS()) {
                                                PbFragment.this.jtF.rH(false);
                                            }
                                            PbFragment.this.jtF.cBx().uO(false);
                                        }
                                    }
                                });
                                PbFragment.this.jtF.e(PbFragment.this.cxs().cAh().cxm().aXQ().getInputView());
                                PbFragment.this.cxs().cAh().cxm().a(PbFragment.this.jtT);
                            }
                        }
                        PbFragment.this.cxs().cBh();
                    }
                }, 0L);
                return;
            }
            if (this.jtQ == null) {
                this.jtQ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jtQ.ut(1);
                this.jtQ.a(new AnonymousClass37(str, str2));
            }
            if (this.jqg != null && this.jqg.getPbData() != null && this.jqg.getPbData().getForum() != null) {
                this.jtQ.E(this.jqg.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jqg.cyx(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$37  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass37 implements c.a {
        final /* synthetic */ String juX;
        final /* synthetic */ String juY;

        AnonymousClass37(String str, String str2) {
            this.juX = str;
            this.juY = str2;
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
                        PbFragment.this.cxs().getListView().smoothScrollBy((PbFragment.this.jts[1] + PbFragment.this.jtt) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cxs().cAh() != null) {
                            PbFragment.this.jtO.aWN().setVisibility(8);
                            PbFragment.this.cxs().cAh().g(AnonymousClass37.this.juX, AnonymousClass37.this.juY, PbFragment.this.cxs().cAl(), (PbFragment.this.jqg == null || PbFragment.this.jqg.getPbData() == null || PbFragment.this.jqg.getPbData().cvr() == null || !PbFragment.this.jqg.getPbData().cvr().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cxm = PbFragment.this.cxs().cAh().cxm();
                            if (cxm != null && PbFragment.this.jqg != null && PbFragment.this.jqg.getPbData() != null) {
                                cxm.a(PbFragment.this.jqg.getPbData().getAnti());
                                cxm.setThreadData(PbFragment.this.jqg.getPbData().cvr());
                            }
                            if (PbFragment.this.jtF.cBy() == null && PbFragment.this.cxs().cAh().cxm().aXQ() != null) {
                                PbFragment.this.cxs().cAh().cxm().aXQ().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jtF != null && PbFragment.this.jtF.cBx() != null) {
                                            if (!PbFragment.this.jtF.cBx().deS()) {
                                                PbFragment.this.jtF.rH(false);
                                            }
                                            PbFragment.this.jtF.cBx().uO(false);
                                        }
                                    }
                                });
                                PbFragment.this.jtF.e(PbFragment.this.cxs().cAh().cxm().aXQ().getInputView());
                                PbFragment.this.cxs().cAh().cxm().a(PbFragment.this.jtT);
                            }
                        }
                        PbFragment.this.cxs().cBh();
                    }
                }, 0L);
            }
        }
    }

    public boolean cxA() {
        if ((this.jqg.getPbData() != null && this.jqg.getPbData().cvP()) || this.iBh == null || this.jqg.getPbData() == null || this.jqg.getPbData().getAnti() == null) {
            return true;
        }
        return this.iBh.kz(this.jqg.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean zw(int i) {
        if (this.iBh == null || this.jqg.getPbData() == null || this.jqg.getPbData().getAnti() == null) {
            return true;
        }
        return this.iBh.aA(this.jqg.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.jqg != null && this.jqg.getPbData() != null && postData.cWo() != 1) {
            String cyx = this.jqg.cyx();
            String id = postData.getId();
            int cvD = this.jqg.getPbData() != null ? this.jqg.getPbData().cvD() : 0;
            PbActivity.a HD = HD(id);
            if (HD != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cyx, id, "pb", true, null, false, null, cvD, postData.cCY(), this.jqg.getPbData().getAnti(), false, postData.aKC() != null ? postData.aKC().getIconInfo() : null).addBigImageData(HD.jql, HD.jqm, HD.jqn, HD.index);
                addBigImageData.setKeyPageStartFrom(this.jqg.czg());
                addBigImageData.setFromFrsForumId(this.jqg.getFromForumId());
                addBigImageData.setKeyFromForumId(this.jqg.getForumId());
                addBigImageData.setBjhData(this.jqg.cyF());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cxB() {
        if (this.jqg.getPbData() == null || this.jqg.getPbData().cvr() == null) {
            return -1;
        }
        return this.jqg.getPbData().cvr().aLm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxC() {
        if (this.jqg != null && this.jqg.jqZ != null && this.jqg.jqZ.cvr() != null) {
            bj cvr = this.jqg.jqZ.cvr();
            cvr.mRecomAbTag = this.jqg.czr();
            cvr.mRecomWeight = this.jqg.czp();
            cvr.mRecomSource = this.jqg.czq();
            cvr.mRecomExtra = this.jqg.czs();
            if (cvr.getFid() == 0) {
                cvr.setFid(com.baidu.adp.lib.f.b.toLong(this.jqg.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cvr, "c13563");
            if (a2 != null) {
                a2.af("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxD() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Kd(this.jqg.getForumId()) && this.jqg.getPbData() != null && this.jqg.getPbData().getForum() != null) {
            if (this.jqg.getPbData().getForum().isLike() == 1) {
                this.jqg.czc().eI(this.jqg.getForumId(), this.jqg.cyx());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qV(boolean z) {
        if (this.jqg == null || this.jqg.getPbData() == null) {
            return false;
        }
        return ((this.jqg.getPbData().cvD() != 0) || this.jqg.getPbData().cvr() == null || this.jqg.getPbData().cvr().aKC() == null || TextUtils.equals(this.jqg.getPbData().cvr().aKC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean qW(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.w wVar;
        if (this.jqg == null || this.jqg.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.jqg.getPbData();
        bj cvr = pbData.cvr();
        if (cvr != null) {
            if (cvr.aJr() || cvr.aJs()) {
                return false;
            }
            if (cvr.aMw() || cvr.aMx()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cvD() != 0) {
                return pbData.cvD() != 3;
            }
            List<bf> cvK = pbData.cvK();
            if (com.baidu.tbadk.core.util.v.getCount(cvK) > 0) {
                for (bf bfVar : cvK) {
                    if (bfVar != null && (wVar = bfVar.dqn) != null && wVar.doh && !wVar.doi && (wVar.type == 1 || wVar.type == 2)) {
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
        if (z || this.jqg == null || this.jqg.getPbData() == null) {
            return false;
        }
        return ((this.jqg.getPbData().getForum() != null && this.jqg.getPbData().getForum().isBlockBawuDelete) || this.jqg.getPbData().cvD() == 0 || this.jqg.getPbData().cvD() == 3) ? false : true;
    }

    public void cxE() {
        com.baidu.tieba.pb.data.e pbData;
        bj cvr;
        if (this.jqg != null && this.jqg.getPbData() != null && (cvr = (pbData = this.jqg.getPbData()).cvr()) != null && cvr.aKC() != null) {
            this.jtB.cAf();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cvr.aKC().getUserId());
            z zVar = new z();
            int cvD = this.jqg.getPbData().cvD();
            if (cvD == 1 || cvD == 3) {
                zVar.jyb = true;
                zVar.jya = true;
                zVar.jyg = cvr.aKx() == 1;
                zVar.jyf = cvr.aKy() == 1;
            } else {
                zVar.jyb = false;
                zVar.jya = false;
            }
            if (cvD == 1002 && !equals) {
                zVar.jyh = true;
            }
            zVar.jxY = qW(equals);
            zVar.jyc = cxF();
            zVar.jxZ = qX(equals);
            zVar.DC = this.jqg.cyy();
            zVar.jxV = true;
            zVar.jxU = qV(equals);
            zVar.jxT = equals && this.jtB.cAM();
            zVar.jye = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.jyd = true;
            zVar.isHostOnly = this.jqg.getHostMode();
            zVar.jxX = true;
            if (cvr.aKT() == null) {
                zVar.jxW = true;
            } else {
                zVar.jxW = false;
            }
            if (pbData.cvP()) {
                zVar.jxV = false;
                zVar.jxX = false;
                zVar.jxW = false;
                zVar.jya = false;
                zVar.jyb = false;
            }
            this.jtB.jzK.a(zVar);
        }
    }

    private boolean cxF() {
        if (this.jqg != null && this.jqg.cyy()) {
            return this.jqg.getPageData() == null || this.jqg.getPageData().aJz() != 0;
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
    public PbModel.a cxG() {
        return this.juA;
    }

    public int cxH() {
        if (cxs() == null || cxs().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cxs().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) mVar).Ty == com.baidu.tieba.pb.data.j.joB) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cxI() {
        if (cxs() == null || cxs().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cxs().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.kSs) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cxO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxJ() {
        if (this.jqg != null && this.jqg.jqZ != null && this.jqg.jqZ.cvr() != null) {
            bj cvr = this.jqg.jqZ.cvr();
            cvr.mRecomAbTag = this.jqg.czr();
            cvr.mRecomWeight = this.jqg.czp();
            cvr.mRecomSource = this.jqg.czq();
            cvr.mRecomExtra = this.jqg.czs();
            if (cvr.getFid() == 0) {
                cvr.setFid(com.baidu.adp.lib.f.b.toLong(this.jqg.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cvr, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.uh(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.ui(getResources().getString(R.string.mark_like));
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
                    PbFragment.this.dzH.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.jqg.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aMS();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.jtB.cAG();
        this.jqg.rh(z);
        if (this.jtz != null) {
            this.jtz.gk(z);
            if (markData != null) {
                this.jtz.a(markData);
            }
        }
        if (this.jqg.aGX()) {
            cxM();
        } else {
            this.jtB.o(this.jqg.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zn(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HA(String str) {
        if (this.jqg != null && this.jqg.getPbData() != null && this.jqg.getPbData().cvP()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jqg.cyx(), str);
            bj cvr = this.jqg.getPbData().cvr();
            if (cvr.aJr()) {
                format = format + "&channelid=33833";
            } else if (cvr.aMv()) {
                format = format + "&channelid=33842";
            } else if (cvr.aJs()) {
                format = format + "&channelid=33840";
            }
            HB(format);
            return;
        }
        this.jty.Ia(str);
    }

    private void HB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.jqg.cyD()) {
                    antiData.setBlock_forum_name(this.jqg.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.jqg.getPbData().getForum().getId());
                    antiData.setUser_name(this.jqg.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.jqg.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cxs() != null) {
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
            wI(str);
        } else {
            this.jtB.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.kVg) ? bVar.kVg : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ui(string);
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
                aVar.aMS();
            } else {
                this.jtB.a(0, bVar.OL, bVar.kVg, z);
            }
            if (bVar.OL) {
                if (bVar.gFD == 1) {
                    ArrayList<PostData> cvt = this.jqg.getPbData().cvt();
                    int size = cvt.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cvt.get(i).getId())) {
                            i++;
                        } else {
                            cvt.remove(i);
                            break;
                        }
                    }
                    this.jqg.getPbData().cvr().jQ(this.jqg.getPbData().cvr().aKt() - 1);
                    this.jtB.o(this.jqg.getPbData());
                } else if (bVar.gFD == 0) {
                    cxK();
                } else if (bVar.gFD == 2) {
                    ArrayList<PostData> cvt2 = this.jqg.getPbData().cvt();
                    int size2 = cvt2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cvt2.get(i2).cWl().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cvt2.get(i2).cWl().get(i3).getId())) {
                                i3++;
                            } else {
                                cvt2.get(i2).cWl().remove(i3);
                                cvt2.get(i2).cWn();
                                z2 = true;
                                break;
                            }
                        }
                        cvt2.get(i2).KO(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.jtB.o(this.jqg.getPbData());
                    }
                    a(bVar, this.jtB);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.jtB.a(this.gqg.getLoadDataMode(), gVar.OL, gVar.kVg, false);
            if (gVar.OL) {
                this.jtC = true;
                if (i == 2 || i == 3) {
                    this.jtD = true;
                    this.jtE = false;
                } else if (i == 4 || i == 5) {
                    this.jtD = false;
                    this.jtE = true;
                }
                if (i == 2) {
                    this.jqg.getPbData().cvr().jT(1);
                    this.jqg.setIsGood(1);
                } else if (i == 3) {
                    this.jqg.getPbData().cvr().jT(0);
                    this.jqg.setIsGood(0);
                } else if (i == 4) {
                    this.jqg.getPbData().cvr().jS(1);
                    this.jqg.zz(1);
                } else if (i == 5) {
                    this.jqg.getPbData().cvr().jS(0);
                    this.jqg.zz(0);
                }
                this.jtB.c(this.jqg.getPbData(), this.jqg.cyy());
            }
        }
    }

    private void cxK() {
        if (this.jqg.cyz() || this.jqg.cyB()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.jqg.cyx());
            PbActivity pbActivity = this.jsZ;
            PbActivity pbActivity2 = this.jsZ;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.jqg.cyx()));
        if (cxN()) {
            this.jsZ.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwN() {
        this.jsZ.cwN();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cvA;
        boolean z = false;
        if (this.jtB != null) {
            this.jtB.cAX();
        }
        if (this.jqg != null && this.jqg.getPbData() != null && !this.jqg.getPbData().cvP()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.jqg.getPbData().cvr().getId();
            if (this.jqg.isShareThread() && this.jqg.getPbData().cvr().dtt != null) {
                historyMessage.threadName = this.jqg.getPbData().cvr().dtt.showText;
            } else {
                historyMessage.threadName = this.jqg.getPbData().cvr().getTitle();
            }
            if (this.jqg.isShareThread() && !cwq()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.jqg.getPbData().getForum().getName();
            }
            ArrayList<PostData> cvt = this.jqg.getPbData().cvt();
            int cAI = this.jtB != null ? this.jtB.cAI() : 0;
            if (cvt != null && cAI >= 0 && cAI < cvt.size()) {
                historyMessage.postID = cvt.get(cAI).getId();
            }
            historyMessage.isHostOnly = this.jqg.getHostMode();
            historyMessage.isSquence = this.jqg.cyy();
            historyMessage.isShareThread = this.jqg.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.jtO != null) {
            this.jtO.onDestroy();
        }
        if (this.jtd && cxs() != null) {
            cxs().cBr();
        }
        if (this.jqg != null && (this.jqg.cyz() || this.jqg.cyB())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.jqg.cyx());
            if (this.jtC) {
                if (this.jtE) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.jqg.bHI());
                }
                if (this.jtD) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.jqg.getIsGood());
                }
            }
            if (this.jqg.getPbData() != null && System.currentTimeMillis() - this.jtg >= 40000 && (cvA = this.jqg.getPbData().cvA()) != null && !com.baidu.tbadk.core.util.v.isEmpty(cvA.getDataList())) {
                intent.putExtra("guess_like_data", cvA);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.juc);
            }
            PbActivity pbActivity = this.jsZ;
            PbActivity pbActivity2 = this.jsZ;
            pbActivity.setResult(-1, intent);
        }
        if (cxN()) {
            if (this.jqg != null && this.jtB != null && this.jtB.getListView() != null) {
                com.baidu.tieba.pb.data.e pbData = this.jqg.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cvx() && !this.jtm && pbData.jnB == null) {
                        ah czP = ah.czP();
                        com.baidu.tieba.pb.data.e cyG = this.jqg.cyG();
                        Parcelable onSaveInstanceState = this.jtB.getListView().onSaveInstanceState();
                        boolean cyy = this.jqg.cyy();
                        boolean hostMode = this.jqg.getHostMode();
                        if (this.jtB.cAr() != null && this.jtB.cAr().getVisibility() == 0) {
                            z = true;
                        }
                        czP.a(cyG, onSaveInstanceState, cyy, hostMode, z);
                        if (this.jub >= 0 || this.jqg.czi() != null) {
                            ah.czP().n(this.jqg.czi());
                            ah.czP().m(this.jqg.czj());
                            ah.czP().zJ(this.jqg.czk());
                        }
                    }
                }
            } else {
                ah.czP().reset();
            }
            cwN();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.jtB == null || !this.jtB.zP(i)) ? false : true;
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
        PbActivity pbActivity = this.jsZ;
        if (i == 0) {
            this.jtB.cAf();
            this.jtB.cAh().cxi();
            this.jtB.rB(false);
        }
        this.jtB.cAj();
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
                        this.jtO.resetData();
                        this.jtO.setVoiceModel(pbEditorData.getVoiceModel());
                        this.jtO.b(writeData);
                        com.baidu.tbadk.editortools.l mD = this.jtO.aWN().mD(6);
                        if (mD != null && mD.dWM != null) {
                            mD.dWM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.jsZ;
                        if (i == -1) {
                            this.jtO.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.jtB.cAh() != null && this.jtB.cAh().cxm() != null) {
                            com.baidu.tbadk.editortools.pb.h cxm = this.jtB.cAh().cxm();
                            cxm.setThreadData(this.jqg.getPbData().cvr());
                            cxm.b(writeData);
                            cxm.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mD2 = cxm.aWN().mD(6);
                            if (mD2 != null && mD2.dWM != null) {
                                mD2.dWM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.jsZ;
                            if (i == -1) {
                                cxm.aXI();
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
        this.jtO.onActivityResult(i, i2, intent);
        if (this.jtq != null) {
            this.jtq.onActivityResult(i, i2, intent);
        }
        if (cxs().cAh() != null) {
            cxs().cAh().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cxL();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ah.czP().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.jqg != null) {
                                PbFragment.this.jqg.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cMR().D(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.jqg != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    V(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.cMR().D(getPageContext());
                        cxD();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.hpe != null && shareItem != null && shareItem.linkUrl != null) {
                            this.hpe.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aUk() {
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
                    this.jtB.qL(false);
                    if (this.jqg.getPbData() != null && this.jqg.getPbData().cvr() != null && this.jqg.getPbData().cvr().aKW() != null) {
                        this.jqg.getPbData().cvr().aKW().setStatus(2);
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
                        this.jtR = emotionImageData;
                        if (zw(com.baidu.tbadk.core.util.aj.dzE)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.jtr != null) {
                        this.jtB.cJ(this.jtr);
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
            if (this.jtq == null) {
                this.jtq = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.jsZ);
                this.jtq.b(this.dYF);
                this.jtq.c(this.dYM);
            }
            this.jtq.a(emotionImageData, cwA(), cwA().getPbData());
        }
    }

    private void V(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxL() {
        MarkData zG;
        if (this.jtz != null) {
            if (this.jqg.getPbData() != null && this.jqg.getPbData().cvP()) {
                zG = this.jqg.zG(0);
            } else {
                zG = this.jqg.zG(this.jtB.cAJ());
            }
            if (zG != null) {
                if (!zG.isApp() || (zG = this.jqg.zG(this.jtB.cAJ() + 1)) != null) {
                    this.jtB.cAE();
                    this.jtz.a(zG);
                    if (!this.jtz.aGX()) {
                        this.jtz.aGZ();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.jtz.aGY();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxM() {
        com.baidu.tieba.pb.data.e pbData = this.jqg.getPbData();
        this.jqg.rh(true);
        if (this.jtz != null) {
            pbData.Ht(this.jtz.aGW());
        }
        this.jtB.o(pbData);
    }

    private boolean cxN() {
        if (this.jqg == null) {
            return true;
        }
        if (this.jqg.getPbData() == null || !this.jqg.getPbData().cvP()) {
            if (this.jqg.aGX()) {
                final MarkData cyQ = this.jqg.cyQ();
                if (cyQ == null || !this.jqg.getIsFromMark()) {
                    return true;
                }
                final MarkData zG = this.jqg.zG(this.jtB.cAI());
                if (zG == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cyQ);
                    this.jsZ.setResult(-1, intent);
                    return true;
                } else if (zG.getPostId() == null || zG.getPostId().equals(cyQ.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cyQ);
                    this.jsZ.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.ui(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.jtz != null) {
                                if (PbFragment.this.jtz.aGX()) {
                                    PbFragment.this.jtz.aGY();
                                    PbFragment.this.jtz.gk(false);
                                }
                                PbFragment.this.jtz.a(zG);
                                PbFragment.this.jtz.gk(true);
                                PbFragment.this.jtz.aGZ();
                            }
                            cyQ.setPostId(zG.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cyQ);
                            PbFragment.this.jsZ.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cwN();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cyQ);
                            PbFragment.this.jsZ.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cwN();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.jtB != null && PbFragment.this.jtB.getView() != null) {
                                PbFragment.this.jtB.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cyQ);
                                PbFragment.this.jsZ.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cwN();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aMS();
                    return false;
                }
            } else if (this.jqg.getPbData() == null || this.jqg.getPbData().cvt() == null || this.jqg.getPbData().cvt().size() <= 0 || !this.jqg.getIsFromMark()) {
                return true;
            } else {
                this.jsZ.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.jtB == null) {
            return null;
        }
        return this.jtB.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bcM() {
        if (this.jtB == null) {
            return 0;
        }
        return this.jtB.cAV();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bcN() {
        if (this.emM == null) {
            this.emM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bcZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.aIc().isShowImages();
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
                        if (com.baidu.tbadk.core.i.aIc().isShowImages()) {
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
        return this.emM;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bcO() {
        if (this.epE == null) {
            this.epE = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.epE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bcP() {
        if (this.emN == null) {
            this.emN = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJu */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.aIc().isShowImages();
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
                    if (com.baidu.tbadk.core.i.aIc().isShowImages()) {
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
                    gifView.aYi();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.emN;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bcQ() {
        if (this.epF == null) {
            this.epF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyk */
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
                    ((PlayVoiceBntNew) view).cXw();
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
        return this.epF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bcS() {
        this.epH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyl */
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
        return this.epH;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aQG() {
        if (this.dJz == null) {
            this.dJz = UserIconBox.s(getPageContext().getPageActivity(), 8);
        }
        return this.dJz;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ak(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jtk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
        if (as.HS(str) && this.jqg != null && this.jqg.cyx() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").af("obj_param1", 1).cI("post_id", this.jqg.cyx()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                jVar.mLink = str;
                jVar.type = 3;
                jVar.dVP = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, jVar));
            }
        } else {
            as.cBA().d(getPageContext(), str);
        }
        this.jtk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
        as.cBA().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.jtk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void am(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.jtB != null && this.jtB.cBm() != null && rect.top <= this.jtB.cBm().getHeight()) {
            rect.top += this.jtB.cBm().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.jqg.getPbData();
            TbRichText bt = bt(str, i);
            if (bt != null && (tbRichTextData = bt.bcf().get(this.juG)) != null) {
                aVar.postId = String.valueOf(bt.getPostId());
                aVar.jql = new ArrayList<>();
                aVar.jqm = new ConcurrentHashMap<>();
                if (!tbRichTextData.bcl().bcw()) {
                    aVar.jqo = false;
                    String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                    aVar.jql.add(b2);
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
                    imageUrlData.mIsReserver = this.jqg.cyO();
                    imageUrlData.mIsSeeHost = this.jqg.getHostMode();
                    aVar.jqm.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cvr() != null) {
                            aVar.threadId = pbData.cvr().getId();
                        }
                        aVar.jqn = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.jqo = true;
                int size = pbData.cvt().size();
                this.juH = false;
                aVar.index = -1;
                int a2 = pbData.cvy() != null ? a(pbData.cvy().cWq(), bt, i, i, aVar.jql, aVar.jqm) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cvt().get(i2);
                    if (postData.getId() == null || pbData.cvy() == null || pbData.cvy().getId() == null || !postData.getId().equals(pbData.cvy().getId())) {
                        a2 = a(postData.cWq(), bt, a2, i, aVar.jql, aVar.jqm);
                    }
                }
                if (aVar.jql.size() > 0) {
                    aVar.lastId = aVar.jql.get(aVar.jql.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cvr() != null) {
                        aVar.threadId = pbData.cvr().getId();
                    }
                    aVar.jqn = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcl() == null) {
            return null;
        }
        return tbRichTextData.bcl().bcB();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcl() == null) {
            return 0L;
        }
        return tbRichTextData.bcl().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcl() == null) {
            return false;
        }
        return tbRichTextData.bcl().bcC();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcl() == null) {
            return false;
        }
        return tbRichTextData.bcl().bcD();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bcl;
        String str;
        if (tbRichText == tbRichText2) {
            this.juH = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bcf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bcf().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bcl().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bcl().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bcl().bcw()) {
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
                            if (tbRichTextData != null && (bcl = tbRichTextData.bcl()) != null) {
                                String bcy = bcl.bcy();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bcl.bcz();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bcy;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.jqg.cyx(), -1L);
                                imageUrlData.mIsReserver = this.jqg.cyO();
                                imageUrlData.mIsSeeHost = this.jqg.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.juH) {
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
        PostData cvy;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.jqg.aKL())) {
                z = true;
            }
            MarkData l = this.jqg.l(postData);
            if (this.jqg.getPbData() != null && this.jqg.getPbData().cvP() && (cvy = cvy()) != null) {
                l = this.jqg.l(cvy);
            }
            if (l != null) {
                this.jtB.cAE();
                if (this.jtz != null) {
                    this.jtz.a(l);
                    if (!z) {
                        this.jtz.aGZ();
                    } else {
                        this.jtz.aGY();
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
        if (this.jqg == null || this.jqg.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.jqg.getPbData();
        if (pbData.cvy() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cvy());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cvt = pbData.cvt();
            c(pbData, cvt);
            return c(cvt, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cvC() != null && eVar.cvC().joP != null && (list = eVar.cvC().joP) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bcf;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cWq = arrayList.get(i2).cWq();
            if (cWq != null && (bcf = cWq.bcf()) != null) {
                int size = bcf.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bcf.get(i4) != null && bcf.get(i4).getType() == 8) {
                        i3++;
                        if (bcf.get(i4).bcl().bcy().equals(str) || bcf.get(i4).bcl().bcz().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bcf.get(i4).bcl().getWidth() * equipmentDensity;
                            int height = bcf.get(i4).bcl().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.juG = i4;
                            return cWq;
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
    public void t(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.jqc = str;
            if (this.jtf == null) {
                cxw();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.jtf.getItemView(1).setVisibility(8);
            } else {
                this.jtf.getItemView(1).setVisibility(0);
            }
            this.jtf.aMT();
            this.jtk = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gYv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxO() {
        hideNetRefreshView(this.jtB.getView());
        cxP();
        if (this.jqg.cyJ()) {
            this.jtB.cAE();
        }
        this.jtB.cAP();
    }

    private void cxP() {
        showLoadingView(this.jtB.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.jtB.cBm().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOR() {
        if (this.gYv != null) {
            this.gYv.stopPlay();
        }
        if (this.jsZ != null) {
            this.jsZ.bOR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cxB(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bcR() {
        if (this.epG == null) {
            this.epG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cym */
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
        return this.epG;
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

    public void bOS() {
        if (this.jsZ != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.jsZ.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jsZ.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bNE() {
        if (this.jqg == null || this.jqg.getPbData() == null) {
            return null;
        }
        return this.jqg.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(an.jAV)).intValue();
            if (intValue == an.jAW) {
                if (!this.gqg.cXc()) {
                    this.jtB.cAB();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.gqg.KT(com.baidu.tbadk.core.util.aq.P(jSONArray));
                    }
                    this.gqg.a(this.jqg.getPbData().getForum().getId(), this.jqg.getPbData().getForum().getName(), this.jqg.getPbData().cvr().getId(), str, intValue3, intValue2, booleanValue, this.jqg.getPbData().cvr().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.jAX || intValue == an.jAZ) {
                if (this.jqg.cyZ() != null) {
                    this.jqg.cyZ().zr(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.jAX) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.jtW);
        userMuteAddAndDelCustomMessage.setTag(this.jtW);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean HC(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0644a
    public void qY(boolean z) {
        this.jtI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cxQ() {
        ArrayList<PostData> cvt;
        int count;
        if (this.jqg == null || this.jqg.getPbData() == null || this.jqg.getPbData().cvt() == null || (count = com.baidu.tbadk.core.util.v.getCount((cvt = this.jqg.getPbData().cvt()))) == 0) {
            return "";
        }
        if (this.jqg.cyO()) {
            Iterator<PostData> it = cvt.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cWo() == 1) {
                    return next.getId();
                }
            }
        }
        int cAI = this.jtB.cAI();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cvt, cAI);
        if (postData == null || postData.aKC() == null) {
            return "";
        }
        if (this.jqg.HG(postData.aKC().getUserId())) {
            return postData.getId();
        }
        for (int i = cAI - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(cvt, i);
            if (postData2 == null || postData2.aKC() == null || postData2.aKC().getUserId() == null) {
                break;
            } else if (this.jqg.HG(postData2.aKC().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cAI + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(cvt, i2);
            if (postData3 == null || postData3.aKC() == null || postData3.aKC().getUserId() == null) {
                return "";
            }
            if (this.jqg.HG(postData3.aKC().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ao(Context context, String str) {
        this.jtk = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a HD(String str) {
        String str2;
        if (this.jqg.getPbData() == null || this.jqg.getPbData().cvt() == null || this.jqg.getPbData().cvt().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.jqg.getPbData().cvt().size()) {
                i = 0;
                break;
            } else if (str.equals(this.jqg.getPbData().cvt().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.jqg.getPbData().cvt().get(i);
        if (postData.cWq() == null || postData.cWq().bcf() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cWq().bcf().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bcl() != null) {
                    str2 = next.bcl().bcy();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.f.a(postData, aVar);
        return aVar;
    }

    public boolean cxR() {
        return (!this.jta && this.juM == -1 && this.juN == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null) {
            this.juP = pVar;
            this.jta = true;
            this.jtB.cAs();
            this.jtB.HQ(this.juO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxS() {
        if (this.juP != null) {
            if (this.juM == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.juP.getCartoonId(), this.juM, 0)));
                this.jsZ.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxT() {
        if (this.juP != null) {
            if (this.juN == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.juP.getCartoonId(), this.juN, 0)));
                this.jsZ.finish();
            }
        }
    }

    public int cxU() {
        return this.juM;
    }

    public int cxV() {
        return this.juN;
    }

    private void caN() {
        if (this.jqg != null && this.jqg.getPbData() != null && this.jqg.getPbData().cvr() != null && this.jqg.getPbData().cvr().aJp()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cxW() {
        if (this.jqg != null && this.jqg.getPbData() != null && this.jqg.getPbData().cvr() != null && this.jqg.getPbData().cvr().aJp()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cxX() {
        if (this.aXb) {
            this.jtp = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.jqg.getPbData() != null && this.jqg.getPbData().cvr() != null && this.jqg.getPbData().cvr().aKi() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.jqg.getPbData().cvr().aKi().getThreadId(), this.jqg.getPbData().cvr().aKi().getTaskId(), this.jqg.getPbData().cvr().aKi().getForumId(), this.jqg.getPbData().cvr().aKi().getForumName(), this.jqg.getPbData().cvr().aKx(), this.jqg.getPbData().cvr().aKy())));
            this.jtc = true;
            this.jsZ.finish();
        }
    }

    public String cxY() {
        return this.jtn;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cxZ() {
        return this.jtx;
    }

    public void qZ(boolean z) {
        this.jto = z;
    }

    public boolean aMs() {
        if (this.jqg != null) {
            return this.jqg.cyz();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cya() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ui(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.jtU).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.jtU.getPageActivity(), 2, true, 4);
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
        aVar.b(this.jtU).aMS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI(String str) {
        if (str == null) {
            str = "";
        }
        if (this.jtU != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jtU.getPageActivity());
            aVar.ui(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jtU).aMS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.jtB.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jtU.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.ui(this.jtU.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.ui(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.jtB.showLoadingDialog();
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
        aVar.b(this.jtU).aMS();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.HS(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.hzC) {
            this.hzC = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.jtB != null) {
                this.jtB.onConfigurationChanged(configuration);
            }
            if (this.jtG != null) {
                this.jtG.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cyb() {
        if (this.jqg != null) {
            return this.jqg.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.jqg.getPbData().cvC().joP;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cWl().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cWl().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cWl().remove(i2);
                    list.get(i).cWn();
                    z = true;
                    break;
                }
            }
            list.get(i).KO(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.o(this.jqg.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.l lVar) {
        String id = lVar.cwe().getId();
        List<PostData> list = this.jqg.getPbData().cvC().joP;
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
                ArrayList<PostData> cwi = lVar.cwi();
                postData.Dh(lVar.getTotalCount());
                if (postData.cWl() != null) {
                    postData.cWl().clear();
                    postData.cWl().addAll(cwi);
                }
            }
        }
        if (!this.jqg.getIsFromMark()) {
            this.jtB.o(this.jqg.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cwp() {
        return this.jsZ.cwp();
    }

    public boolean cwq() {
        if (this.jqg == null) {
            return false;
        }
        return this.jqg.cwq();
    }

    public void cyc() {
        if (this.jtB != null) {
            this.jtB.cAf();
            bOS();
        }
    }

    public PostData cvy() {
        return this.jtB.b(this.jqg.jqZ, this.jqg.cyy());
    }

    public void onBackPressed() {
        if (this.jud != null && !this.jud.isEmpty()) {
            int size = this.jud.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.jud.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.jud == null) {
                this.jud = new ArrayList();
            }
            if (!this.jud.contains(aVar)) {
                this.jud.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.jud == null) {
                this.jud = new ArrayList();
            }
            if (!this.jud.contains(aVar)) {
                this.jud.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.jud != null) {
            this.jud.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyd() {
        if (this.jqg != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.jqg.cyx())) {
            com.baidu.tbadk.BdToken.c.aFN().o(com.baidu.tbadk.BdToken.b.dgd, com.baidu.adp.lib.f.b.toLong(this.jqg.cyx(), 0L));
        }
    }

    public ax cye() {
        return this.jtw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HE(String str) {
        if (this.jqg != null && this.jqg.getPbData() != null && this.jqg.getPbData().cvr() != null && this.jqg.getPbData().cvr().aMy()) {
            bj cvr = this.jqg.getPbData().cvr();
            int i = 0;
            if (cvr.aJr()) {
                i = 1;
            } else if (cvr.aJs()) {
                i = 2;
            } else if (cvr.aMw()) {
                i = 3;
            } else if (cvr.aMx()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.af("obj_source", 4);
            anVar.af("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cyf() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cyg() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cyh() {
        return this.jsZ;
    }
}
