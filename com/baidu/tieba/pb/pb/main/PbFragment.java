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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cc;
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
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes21.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0824a {
    private com.baidu.tieba.tbadkCore.data.e ePS;
    private com.baidu.tbadk.core.message.a eQi;
    private com.baidu.adp.lib.d.b<TbImageView> eWZ;
    private LikeModel eYI;
    private bd euQ;
    private com.baidu.adp.lib.d.b<ImageView> fFn;
    private com.baidu.adp.lib.d.b<GifView> fFo;
    private com.baidu.adp.lib.d.b<TextView> fIE;
    private com.baidu.adp.lib.d.b<View> fIF;
    private com.baidu.adp.lib.d.b<LinearLayout> fIG;
    private com.baidu.adp.lib.d.b<RelativeLayout> fIH;
    private com.baidu.tieba.callfans.a hZs;
    private VoiceManager iIc;
    private com.baidu.tieba.g.b iMX;
    private com.baidu.tieba.frs.profession.permission.c iMx;
    public com.baidu.tbadk.core.util.am kwi;
    public bb kzS;
    private String lqd;
    private PbActivity ltC;
    private com.baidu.tieba.pb.pb.main.b.b ltE;
    private com.baidu.tieba.pb.pb.main.emotion.model.a ltU;
    private View ltV;
    int ltX;
    private com.baidu.tbadk.core.view.c luA;
    private BdUniqueId luB;
    private Runnable luC;
    private com.baidu.adp.widget.ImageView.a luD;
    private String luE;
    private TbRichTextMemeInfo luF;
    private List<a> luI;
    public String luK;
    private bg lua;
    private com.baidu.tieba.pb.pb.report.a lue;
    private com.baidu.tbadk.core.dialog.i lul;
    private com.baidu.tbadk.core.dialog.k lum;
    private boolean lun;
    private com.baidu.tieba.tbadkCore.data.f lur;
    private com.baidu.tbadk.editortools.pb.g lus;
    private com.baidu.tbadk.editortools.pb.e lut;
    private com.baidu.tieba.frs.profession.permission.c luv;
    private EmotionImageData luw;
    private com.baidu.adp.base.e luz;
    private boolean lvn;
    private String lvw;
    private com.baidu.tbadk.core.data.s lvx;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a lvt = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.g.b.a
        public void cI(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.diL();
            } else {
                com.baidu.tieba.pb.a.b.diK();
            }
        }
    };
    private boolean ltD = false;
    private boolean ltF = false;
    private boolean bDs = false;
    private boolean kPC = false;
    private boolean ltG = true;
    private int ltH = 0;
    private com.baidu.tbadk.core.dialog.b ltI = null;
    private long ikF = -1;
    private long fuA = 0;
    private long ltJ = 0;
    private long createTime = 0;
    private long fuq = 0;
    private boolean ltK = false;
    private com.baidu.tbadk.n.b ltL = null;
    private long ltM = 0;
    private boolean ltN = false;
    private long ltO = 0;
    private int jlT = 1;
    private String foT = null;
    private boolean ltP = false;
    private boolean isFullScreen = false;
    private boolean ltQ = false;
    private String ltR = "";
    private boolean ltS = true;
    private boolean ltT = false;
    private String source = "";
    private int mSkinType = 3;
    int[] ltW = new int[2];
    private int ltY = -1;
    private int ltZ = -1;
    public BdUniqueId lub = BdUniqueId.gen();
    private boolean luc = false;
    private boolean lrD = com.baidu.tbadk.a.d.bhn();
    private PbInterviewStatusView.a lud = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.luh.uO(!PbFragment.this.ltS);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lqh != null && PbFragment.this.lqh.bhP()) {
                        PbFragment.this.dkf();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lqh = null;
    private com.baidu.tbadk.baseEditMark.a luf = null;
    private ForumManageModel hZq = null;
    private com.baidu.tbadk.coreExtra.model.a eMq = null;
    private com.baidu.tieba.pb.data.q lug = null;
    private ShareSuccessReplyToServerModel jbi = null;
    private az luh = null;
    private boolean lui = false;
    private boolean luj = false;
    private boolean luk = false;
    private boolean fWx = false;
    private boolean luo = false;
    private boolean lup = false;
    private boolean luq = false;
    private boolean luu = false;
    public boolean lux = false;
    private com.baidu.tbadk.editortools.pb.c foW = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bzs() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b foX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bzr() {
            if (PbFragment.this.kzS == null || PbFragment.this.kzS.dob() == null || !PbFragment.this.kzS.dob().dSU()) {
                return !PbFragment.this.Gn(com.baidu.tbadk.core.util.am.eMl);
            }
            PbFragment.this.showToast(PbFragment.this.kzS.dob().dSW());
            if (PbFragment.this.lut != null && (PbFragment.this.lut.bzI() || PbFragment.this.lut.bzJ())) {
                PbFragment.this.lut.a(false, PbFragment.this.kzS.doe());
            }
            PbFragment.this.kzS.vb(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b luy = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bzr() {
            if (PbFragment.this.kzS == null || PbFragment.this.kzS.doc() == null || !PbFragment.this.kzS.doc().dSU()) {
                return !PbFragment.this.Gn(com.baidu.tbadk.core.util.am.eMm);
            }
            PbFragment.this.showToast(PbFragment.this.kzS.doc().dSW());
            if (PbFragment.this.luh != null && PbFragment.this.luh.dmI() != null && PbFragment.this.luh.dmI().djG() != null && PbFragment.this.luh.dmI().djG().bzJ()) {
                PbFragment.this.luh.dmI().djG().a(PbFragment.this.kzS.doe());
            }
            PbFragment.this.kzS.vc(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean iIR = false;
    private int luG = 0;
    private int luH = -1;
    public int luJ = 0;
    private final a luL = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.luh != null && PbFragment.this.luh.dmI() != null) {
                v dmI = PbFragment.this.luh.dmI();
                if (dmI.djE()) {
                    dmI.djD();
                    return true;
                }
            }
            if (PbFragment.this.luh != null && PbFragment.this.luh.dnI()) {
                PbFragment.this.luh.dnJ();
                return true;
            }
            return false;
        }
    };
    private final ai.a luM = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void af(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.luh.showToast(str);
            }
        }
    };
    private final CustomMessageListener luN = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lqh != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lut != null) {
                    PbFragment.this.luh.uT(PbFragment.this.lut.bzB());
                }
                PbFragment.this.luh.dmK();
                PbFragment.this.luh.dnA();
            }
        }
    };
    CustomMessageListener iJI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.lqh.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.luh != null && PbFragment.this.lqh != null) {
                    PbFragment.this.luh.b(PbFragment.this.lqh.getPbData(), PbFragment.this.lqh.dkW(), PbFragment.this.lqh.dlt(), PbFragment.this.luh.getSkinType());
                }
                if (PbFragment.this.luh != null && PbFragment.this.luh.dnc() != null) {
                    PbFragment.this.luh.dnc().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener luO = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.luh != null) {
                    if (booleanValue) {
                        PbFragment.this.luh.cTa();
                    } else {
                        PbFragment.this.luh.cSZ();
                    }
                }
            }
        }
    };
    private CustomMessageListener luP = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lut != null) {
                    PbFragment.this.luh.uT(PbFragment.this.lut.bzB());
                }
                PbFragment.this.luh.uV(false);
            }
        }
    };
    private CustomMessageListener luQ = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener luR = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.luh != null && PbFragment.this.luh.dnc() != null) {
                PbFragment.this.luh.dnc().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jXy = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener iJE = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bDs) {
                PbFragment.this.dkx();
            }
        }
    };
    private View.OnClickListener fpG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.foT);
        }
    };
    private CustomMessageListener luS = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ah)) {
                com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) customResponsedMessage.getData();
                ay.a aVar = new ay.a();
                aVar.giftId = ahVar.id;
                aVar.giftName = ahVar.name;
                aVar.thumbnailUrl = ahVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lqh.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lqh.dlk() != null && PbFragment.this.lqh.dlk().getUserIdLong() == ahVar.toUserId) {
                        PbFragment.this.luh.a(ahVar.sendCount, PbFragment.this.lqh.getPbData(), PbFragment.this.lqh.dkW(), PbFragment.this.lqh.dlt());
                    }
                    if (pbData.dhJ() != null && pbData.dhJ().size() >= 1 && pbData.dhJ().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dhJ().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lqh.dkU(), 0L);
                        if (j == ahVar.postId && j2 == ahVar.threadId) {
                            com.baidu.tbadk.core.data.ay dJY = pbData.dhJ().get(0).dJY();
                            if (dJY == null) {
                                dJY = new com.baidu.tbadk.core.data.ay();
                            }
                            ArrayList<ay.a> bku = dJY.bku();
                            if (bku == null) {
                                bku = new ArrayList<>();
                            }
                            bku.add(0, aVar);
                            dJY.setTotal(ahVar.sendCount + dJY.getTotal());
                            dJY.D(bku);
                            pbData.dhJ().get(0).a(dJY);
                            PbFragment.this.luh.dnc().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener luT = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                PbFragment.this.lqh.getPbData().dib();
                PbFragment.this.lqh.dlp();
                if (PbFragment.this.luh.dnc() != null) {
                    PbFragment.this.luh.s(PbFragment.this.lqh.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jcD = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.OU(str);
                PbFragment.this.lqh.dlp();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lqh.getPbData().dhJ() != null) {
                    ArrayList<PostData> dhJ = PbFragment.this.lqh.getPbData().dhJ();
                    Iterator<PostData> it = dhJ.iterator();
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
                        dhJ.remove(nVar);
                        if (PbFragment.this.luh.dnc() != null && PbFragment.this.luh.dnc().getDataList() != null) {
                            PbFragment.this.luh.dnc().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.luh.getListView() != null && PbFragment.this.luh.getListView().getData() != null) {
                            PbFragment.this.luh.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.luh.dnc() != null) {
                            PbFragment.this.luh.dnc().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.luh.dnc() != null) {
                    PbFragment.this.luh.s(PbFragment.this.lqh.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a luU = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dou()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a luV = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void af(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.luh != null) {
                PbFragment.this.luh.fe(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean luW = false;
    private PraiseModel luX = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Fc(String str) {
            PbFragment.this.luW = false;
            if (PbFragment.this.luX != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lqh.getPbData();
                if (pbData.dhH().bln().getIsLike() == 1) {
                    PbFragment.this.Ar(0);
                } else {
                    PbFragment.this.Ar(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dhH()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.luW = false;
            if (PbFragment.this.luX != null && str != null) {
                if (AntiHelper.bP(i, str)) {
                    AntiHelper.bj(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a luY = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void us(boolean z) {
            PbFragment.this.uq(z);
            if (PbFragment.this.luh.dnO() != null && z) {
                PbFragment.this.luh.uO(false);
            }
            PbFragment.this.luh.uQ(z);
        }
    };
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().fdL != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().fdL, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.dhQ().blC() != null && PbFragment.this.dhQ().blC().getGodUserData() != null) {
                            PbFragment.this.dhQ().blC().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().dhH() != null && PbFragment.this.lqh.getPbData().dhH().blC() != null) {
                            PbFragment.this.lqh.getPbData().dhH().blC().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h iHg = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.ltC.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a luZ = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.luh.cgz();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.Gp(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.k.a.cHK();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c fgS = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.djP();
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
                        if (PbFragment.this.dm(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.luh.djN() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").dR("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.diM() != null && PbFragment.this.diM().iry != null) {
                                PbFragment.this.diM().iry.onClick(view);
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
                if (PbFragment.this.lut != null) {
                    PbFragment.this.luh.uT(PbFragment.this.lut.bzB());
                }
                PbFragment.this.luh.dmK();
                PbFragment.this.luh.dnA();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lva = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.luB) {
                PbFragment.this.luh.cgz();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lqh.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dhX().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.luA.showSuccessToast(PbFragment.this.luz.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.luz.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.Ds(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dkt();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.au.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.luz.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.luA.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lvb = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.luB) {
                PbFragment.this.luh.cgz();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.luA.showSuccessToast(PbFragment.this.luz.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.au.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.luz.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.luA.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lvc = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.luB) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.luh.cgz();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nmH;
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
                    PbFragment.this.luh.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lvd = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.luh.dmL() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.djP();
            }
        }
    };
    private CustomMessageListener iJQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.iIR = true;
                }
            }
        }
    };
    public a.b laQ = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cyo();
            com.baidu.tbadk.core.data.aw pageData = PbFragment.this.lqh.getPageData();
            int pageNum = PbFragment.this.luh.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bkn()) {
                PbFragment.this.luh.dnA();
                PbFragment.this.cyn();
                PbFragment.this.luh.dng();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lqh.Gt(PbFragment.this.luh.getPageNum());
                    if (PbFragment.this.ltE != null) {
                        PbFragment.this.ltE.showFloatingView();
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
    private k.c lve = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lul != null) {
                PbFragment.this.lul.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.luD != null && !TextUtils.isEmpty(PbFragment.this.luE)) {
                        if (PbFragment.this.luF == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.luE));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.luE;
                            aVar.pkgId = PbFragment.this.luF.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.luF.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.luD = null;
                        PbFragment.this.luE = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.luD != null && !TextUtils.isEmpty(PbFragment.this.luE)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.euQ == null) {
                                PbFragment.this.euQ = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.euQ.j(PbFragment.this.luE, PbFragment.this.luD.getImageByte());
                            PbFragment.this.luD = null;
                            PbFragment.this.luE = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.jLA != null) {
                        PbFragment.this.jLA.fS(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.jLA = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").ak("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.dn(view);
                        if (PbFragment.this.lqh.getPbData().dhH() != null && PbFragment.this.lqh.getPbData().dhH().blC() != null && PbFragment.this.lqh.getPbData().dhH().blC().getUserId() != null && PbFragment.this.luf != null) {
                            int h = PbFragment.this.h(PbFragment.this.lqh.getPbData());
                            bx dhH = PbFragment.this.lqh.getPbData().dhH();
                            if (dhH.bkk()) {
                                i2 = 2;
                            } else if (dhH.bkl()) {
                                i2 = 3;
                            } else if (dhH.bnz()) {
                                i2 = 4;
                            } else {
                                i2 = dhH.bnA() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", PbFragment.this.lqh.lxu).ak("obj_locate", 2).dR("obj_id", PbFragment.this.lqh.getPbData().dhH().blC().getUserId()).ak("obj_type", PbFragment.this.luf.bhP() ? 0 : 1).ak("obj_source", h).ak("obj_param1", i2));
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
                        PbFragment.this.OW((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").ak("obj_locate", 4));
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
                        PbFragment.this.luh.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.luh.dt(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.luh.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bnv() != null) {
                            PbFragment.this.d(postData.bnv());
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
    public SortSwitchButton.a lvf = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zU(int i) {
            PbFragment.this.luh.dnA();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lqh == null || PbFragment.this.lqh.isLoading) {
                    return false;
                }
                PbFragment.this.cyn();
                PbFragment.this.luh.dng();
                if (PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().lnk != null && PbFragment.this.lqh.getPbData().lnk.size() > i) {
                    int intValue = PbFragment.this.lqh.getPbData().lnk.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13699").dR("tid", PbFragment.this.lqh.dkV()).dR("fid", PbFragment.this.lqh.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).ak("obj_type", Gr(intValue)));
                    if (PbFragment.this.lqh.Gy(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.luh.uJ(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int Gr(int i) {
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
    public final View.OnClickListener iKO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        /* JADX WARN: Removed duplicated region for block: B:787:0x22e3  */
        /* JADX WARN: Removed duplicated region for block: B:790:0x2327  */
        /* JADX WARN: Removed duplicated region for block: B:807:0x2500  */
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
            cc ccVar;
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
                    if (view == PbFragment.this.luh.dnw()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lqh.uy(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.luh.dnh();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dmj()) {
                        if (PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dmk()) {
                            if (view == PbFragment.this.luh.lBp.fwY) {
                                if (PbFragment.this.luh.uS(PbFragment.this.lqh.dlb())) {
                                    PbFragment.this.cyn();
                                    return;
                                }
                                PbFragment.this.ltG = false;
                                PbFragment.this.ltF = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.ltC, PbFragment.this.luh.lBp.fwY);
                                PbFragment.this.ltC.finish();
                            } else if (view != PbFragment.this.luh.dne() && (PbFragment.this.luh.lBp.doH() == null || (view != PbFragment.this.luh.lBp.doH().dmi() && view != PbFragment.this.luh.lBp.doH().dmg()))) {
                                if (view == PbFragment.this.luh.dnE()) {
                                    if (PbFragment.this.lqh != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lqh.getPbData().dhH().blB().getLink());
                                    }
                                } else if (view != PbFragment.this.luh.lBp.lHF) {
                                    if (view == PbFragment.this.luh.lBp.lHG) {
                                        if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                                            ArrayList<PostData> dhJ = PbFragment.this.lqh.getPbData().dhJ();
                                            if ((dhJ == null || dhJ.size() <= 0) && PbFragment.this.lqh.dkW()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12378").dR("tid", PbFragment.this.lqh.dkU()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", PbFragment.this.lqh.getForumId()));
                                            if (!PbFragment.this.luh.dnT()) {
                                                PbFragment.this.luh.dmK();
                                            }
                                            PbFragment.this.djX();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.luh.uf(true);
                                            PbFragment.this.luh.dmK();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.luh.cTa();
                                                PbFragment.this.cyn();
                                                PbFragment.this.luh.dng();
                                                PbFragment.this.lqh.Pb(PbFragment.this.dkj());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dmf()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.luh.lBp.doH() != null && view == PbFragment.this.luh.lBp.doH().dme()) {
                                                PbFragment.this.luh.lBp.aYV();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.Go(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.Gq(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dmc()) {
                                                    if (PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dmm()) {
                                                        if (PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dmd()) {
                                                            if (PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dmn()) {
                                                                if (PbFragment.this.luh.dnO() == view) {
                                                                    if (PbFragment.this.luh.dnO().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lqh.getPbData();
                                                                        if (pbData2 != null && pbData2.dhH() != null && pbData2.dhH().bli() != null) {
                                                                            String bkY = pbData2.dhH().bli().bkY();
                                                                            if (StringUtils.isNull(bkY)) {
                                                                                bkY = pbData2.dhH().bli().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11107").dR("obj_id", bkY));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gq("c10725", null);
                                                                    }
                                                                    PbFragment.this.dkq();
                                                                } else if (PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dml()) {
                                                                    if (PbFragment.this.luh.lBp.doH() != null && view == PbFragment.this.luh.lBp.doH().dmh()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.luh.b(PbFragment.this.lqh.getPbData(), PbFragment.this.lqh.dkW(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.luh.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.luh.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.luh.lBp.aYV();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar.dR("tid", PbFragment.this.lqh.dkU());
                                                                            arVar.dR("fid", PbFragment.this.lqh.getForumId());
                                                                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar.ak("obj_locate", 4);
                                                                            TiebaStatic.log(arVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                                                                                PbFragment.this.luh.dnA();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dKc() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12630"));
                                                                                    }
                                                                                    if (postData.mYE != null) {
                                                                                        com.baidu.tbadk.core.util.ar bqx = postData.mYE.bqx();
                                                                                        bqx.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bqx.ak("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bqx.ak("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bqx);
                                                                                    }
                                                                                    String dkU = PbFragment.this.lqh.dkU();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lqh.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lqh.getPbData().dhW();
                                                                                    }
                                                                                    PbFragment.this.cyn();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a OZ = PbFragment.this.OZ(id);
                                                                                        if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && OZ != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dkU, id, "pb", true, null, true, null, i3, postData.dpH(), PbFragment.this.lqh.getPbData().getAnti(), false, postData.blC().getIconInfo()).addBigImageData(OZ.lqp, OZ.evM, OZ.evK, OZ.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lqh.dlE());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lqh.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lqh.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lqh.dld());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a OZ2 = PbFragment.this.OZ(id);
                                                                                        if (postData != null && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && OZ2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dkU, id, "pb", true, null, false, str2, i3, postData.dpH(), PbFragment.this.lqh.getPbData().getAnti(), false, postData.blC().getIconInfo()).addBigImageData(OZ2.lqp, OZ2.evM, OZ2.evK, OZ2.index);
                                                                                            if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lqh.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lqh.dld());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lqh.dlE());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lqh.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ak("obj_locate", 3).dR("fid", PbFragment.this.lqh.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lqh != null) {
                                                                            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar2.dR("tid", PbFragment.this.lqh.dkU());
                                                                            arVar2.dR("fid", PbFragment.this.lqh.getForumId());
                                                                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar2.ak("obj_locate", 5);
                                                                            TiebaStatic.log(arVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.mYE != null) {
                                                                                        com.baidu.tbadk.core.util.ar bqx2 = postData3.mYE.bqx();
                                                                                        bqx2.delete("obj_locate");
                                                                                        bqx2.ak("obj_locate", 8);
                                                                                        TiebaStatic.log(bqx2);
                                                                                    }
                                                                                    if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                                                                                        String dkU2 = PbFragment.this.lqh.dkU();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lqh.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lqh.getPbData().dhW();
                                                                                        }
                                                                                        PbActivity.a OZ3 = PbFragment.this.OZ(id2);
                                                                                        if (OZ3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dkU2, id2, "pb", true, null, false, null, i4, postData3.dpH(), PbFragment.this.lqh.getPbData().getAnti(), false, postData3.blC().getIconInfo()).addBigImageData(OZ3.lqp, OZ3.evM, OZ3.evK, OZ3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lqh.dlE());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lqh.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lqh.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lqh.dld());
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
                                                                        if (PbFragment.this.lqh != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                arVar3.dR("tid", PbFragment.this.lqh.dkU());
                                                                                arVar3.dR("fid", PbFragment.this.lqh.getForumId());
                                                                                arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                arVar3.ak("obj_locate", 6);
                                                                                TiebaStatic.log(arVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.mYE != null) {
                                                                                        com.baidu.tbadk.core.util.ar bqx3 = postData4.mYE.bqx();
                                                                                        bqx3.delete("obj_locate");
                                                                                        bqx3.ak("obj_locate", 8);
                                                                                        TiebaStatic.log(bqx3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", PbFragment.this.lqh.dkV()).dR("fid", PbFragment.this.lqh.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).ak("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.djM().dmH() != null && postData4.blC() != null && postData4.dJQ() != 1) {
                                                                                        if (PbFragment.this.djM().dmI() != null) {
                                                                                            PbFragment.this.djM().dmI().djC();
                                                                                        }
                                                                                        if ((PbFragment.this.lrD || com.baidu.tbadk.a.d.bhd()) && postData4.dJN() != null && postData4.dJN().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.bhe()) {
                                                                                                PbFragment.this.a(postData4, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData4, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.lqh.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.lqh.getPbData().dhH());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.djM().dmH().d(pVar);
                                                                                            PbFragment.this.djM().dmH().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.blC().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lut != null) {
                                                                                                PbFragment.this.luh.uT(PbFragment.this.lut.bzB());
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
                                                                        if (view != PbFragment.this.luh.djf()) {
                                                                            if (view == PbFragment.this.luh.lBp.doI()) {
                                                                                PbFragment.this.luh.dnn();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (ccVar = (cc) view.getTag()) != null && !StringUtils.isNull(ccVar.bnU())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        bf.bqF().b(PbFragment.this.getPageContext(), new String[]{ccVar.bnU()});
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12006").dR("tid", PbFragment.this.lqh.lxu));
                                                                                            }
                                                                                            if (PbFragment.this.lum == null) {
                                                                                                PbFragment.this.lum = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lum.a(PbFragment.this.lve);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.m42do(view);
                                                                                            if (!PbFragment.this.m42do(view) || PbFragment.this.luD == null || !PbFragment.this.luD.isGif()) {
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
                                                                                                if (postData5.dJS() != null && postData5.dJS().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lum);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar5.eGH.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.jLA = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lqh.getPbData().bhP()) {
                                                                                                String bhO = PbFragment.this.lqh.getPbData().bhO();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bhO) && bhO.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lum);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lum);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.jLA);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.eGH.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lum);
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
                                                                                                            gVar.eGH.setTag(sparseArray8);
                                                                                                            arrayList.add(gVar6);
                                                                                                        } else {
                                                                                                            if (PbFragment.this.um(z3) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lum);
                                                                                                                gVar7.eGH.setTag(str3);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lum);
                                                                                                                gVar2.eGH.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lum);
                                                                                                            gVar3.eGH.setTag(sparseArray9);
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
                                                                                                            if (PbFragment.this.lqh.getPbData().dhW() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lum);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lum);
                                                                                                            }
                                                                                                            gVar2.eGH.setTag(sparseArray10);
                                                                                                            gVar3 = null;
                                                                                                        }
                                                                                                        if (gVar2 != null) {
                                                                                                            arrayList.add(gVar2);
                                                                                                        }
                                                                                                        if (gVar3 != null) {
                                                                                                            arrayList.add(gVar3);
                                                                                                        }
                                                                                                    }
                                                                                                    PbFragment.this.lum.br(arrayList);
                                                                                                    PbFragment.this.lul = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lum);
                                                                                                    PbFragment.this.lul.PA();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.jLA);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.eGH.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lum.br(arrayList);
                                                                                            PbFragment.this.lul = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lum);
                                                                                            PbFragment.this.lul.PA();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().dhH() != null && PbFragment.this.lqh.getPbData().dhH().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lqh.getPbData().dhH().getActUrl());
                                                                                        if (PbFragment.this.lqh.getPbData().dhH().bmp() != 1) {
                                                                                            if (PbFragment.this.lqh.getPbData().dhH().bmp() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10912").dR("fid", PbFragment.this.lqh.getPbData().getForumId()).dR("tid", PbFragment.this.lqh.getPbData().getThreadId()).dR("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lqh.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.luh.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bh.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.bpu().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.luh.dmK();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.djV() == 1 && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10397").dR("fid", PbFragment.this.lqh.getPbData().getForumId()).dR("tid", PbFragment.this.lqh.getPbData().getThreadId()).dR("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.djV() == 1 && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10507").dR("fid", PbFragment.this.lqh.getPbData().getForumId()).dR("tid", PbFragment.this.lqh.getPbData().getThreadId()).dR("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dkl();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dkm();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().did() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lqh.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11679").dR("fid", pbData3.getForumId()));
                                                                                        bf.bqF().b(PbFragment.this.getPageContext(), new String[]{pbData3.did().dip()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().did() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lqh.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dR("fid", pbData4.getForumId()));
                                                                                        bf.bqF().b(PbFragment.this.getPageContext(), new String[]{pbData4.did().dip()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.luG >= 0) {
                                                                                        if (PbFragment.this.lqh != null) {
                                                                                            PbFragment.this.lqh.dlF();
                                                                                        }
                                                                                        if (PbFragment.this.lqh != null && PbFragment.this.luh.dnc() != null) {
                                                                                            PbFragment.this.luh.dnc().a(PbFragment.this.lqh.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.luG = 0;
                                                                                        if (PbFragment.this.lqh != null) {
                                                                                            PbFragment.this.luh.getListView().setSelection(PbFragment.this.lqh.dlI());
                                                                                            PbFragment.this.lqh.db(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.Go(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.Gq(8);
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
                                                                                    if (PbFragment.this.luh.getListView() != null && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.luh.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.luh.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dih = PbFragment.this.lqh.getPbData().dih();
                                                                                        boolean z8 = PbFragment.this.luh.dmJ() != null && PbFragment.this.luh.dmJ().bWv();
                                                                                        boolean dnx = PbFragment.this.luh.dnx();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (dih && PbFragment.this.luh.dmJ() != null && PbFragment.this.luh.dmJ().bOH() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.luh.dmJ().dor();
                                                                                            z9 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.luh.dmJ().bOH().getHeight() - PbFragment.this.luh.dmJ().dor());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.Pa("c13568");
                                                                                        if ((PbFragment.this.lqh.getPbData().dhH() != null && PbFragment.this.lqh.getPbData().dhH().blt() <= 0) || (dnx && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.djS();
                                                                                                if (PbFragment.this.lqh.getPbData().dhH().blC() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lqh.lxu).dR("fid", PbFragment.this.lqh.getPbData().getForumId()).ak("obj_locate", 2).dR("uid", PbFragment.this.lqh.getPbData().dhH().blC().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dih) {
                                                                                                if (PbFragment.this.luh.lCz != null && PbFragment.this.luh.lCz.lDE != null && PbFragment.this.luh.lCz.lDE.getView() != null) {
                                                                                                    if (PbFragment.this.luh.lCz.lDE.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dkb();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.luh.dmJ() != null && PbFragment.this.luh.dmJ().bOH() != null) {
                                                                                                            i6 = PbFragment.this.luh.dmJ().bOH().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.luh.lCz.lDE.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.luh.dmT() != null) {
                                                                                                z10 = PbFragment.this.luh.dmT().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.luh.lCz != null && PbFragment.this.luh.lCz.lDE != null && PbFragment.this.luh.lCz.lDE.getView() != null && PbFragment.this.luh.lCz.lDE.getView().getParent() != null && PbFragment.this.luh.lBp != null && PbFragment.this.luh.lBp.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.luh.lCz.lDE.getView().getTop() - PbFragment.this.luh.lBp.mNavigationBar.getBottom() < PbFragment.this.luh.lCz.lDE.lAO.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || dnx) {
                                                                                                PbFragment.this.ltY = firstVisiblePosition;
                                                                                                PbFragment.this.ltZ = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.luh.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.luh.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.luh.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.ltY > 0) {
                                                                                                if (PbFragment.this.luh.getListView().getChildAt(PbFragment.this.ltY) != null) {
                                                                                                    PbFragment.this.luh.getListView().smoothScrollToPosition(PbFragment.this.ltY, PbFragment.this.ltZ, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.luh.getListView().setSelectionFromTop(PbFragment.this.ltY, PbFragment.this.ltZ + equipmentHeight);
                                                                                                    PbFragment.this.luh.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dkb = PbFragment.this.dkb();
                                                                                                if (PbFragment.this.dka() != -1) {
                                                                                                    dkb--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dkb < 0) {
                                                                                                    i = PbFragment.this.luh.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.luh.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = dkb;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!dih || PbFragment.this.luh.dmJ() == null) {
                                                                                                    if (PbFragment.this.luh.lBp != null && PbFragment.this.luh.lBp.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.luh.lBp.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.luh.dmJ().doq();
                                                                                                }
                                                                                                if (PbFragment.this.luh.lCz == null || PbFragment.this.luh.lCz.lDE == null || PbFragment.this.luh.lCz.lDE.getView() == null || PbFragment.this.luh.lCz.lDE.getView().getParent() == null) {
                                                                                                    PbFragment.this.luh.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.luh.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.luh.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.luh.getListView().smoothScrollBy(PbFragment.this.luh.lCz.lDE.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lqh.getPbData().dhH() != null && PbFragment.this.lqh.getPbData().dhH().blC() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lqh.lxu).dR("fid", PbFragment.this.lqh.getPbData().getForumId()).ak("obj_locate", 2).dR("uid", PbFragment.this.lqh.getPbData().dhH().blC().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(PbFragment.this.lqh.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lqh.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lqh.diO()) || PbFragment.this.lqh.getAppealInfo() == null) {
                                                                                                PbFragment.this.ltC.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lqh.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lqh.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.ltC.finish();
                                                                                            return;
                                                                                        }
                                                                                        String diO = PbFragment.this.lqh.diO();
                                                                                        if (PbFragment.this.lqh.dkX() && diO != null && diO.equals(name)) {
                                                                                            PbFragment.this.ltC.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lqh.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c13401");
                                                                                        arVar4.dR("tid", PbFragment.this.lqh.dkU());
                                                                                        arVar4.dR("fid", PbFragment.this.lqh.getForumId());
                                                                                        arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lqh.getPbData().dhH() != null) {
                                                                                            arVar4.dR("nid", PbFragment.this.lqh.getPbData().dhH().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(arVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bx) {
                                                                                        bx bxVar = (bx) view.getTag();
                                                                                        if (PbFragment.this.lqh.dlE() == 3 && PbFragment.this.diN() && PbFragment.this.lqh.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.lqh.getPbData().die())) {
                                                                                            PbFragment.this.ltC.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bxVar.blG(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar5 = new com.baidu.tbadk.core.util.ar("c13399");
                                                                                        arVar5.dR("tid", bxVar.getId());
                                                                                        arVar5.w("fid", bxVar.getFid());
                                                                                        arVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar5.dR("nid", bxVar.getNid());
                                                                                        TiebaStatic.log(arVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.lqh != null) {
                                                                                        com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                        arVar6.dR("tid", PbFragment.this.lqh.dkU());
                                                                                        arVar6.dR("fid", PbFragment.this.lqh.getForumId());
                                                                                        arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar6.ak("obj_locate", 2);
                                                                                        TiebaStatic.log(arVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lqh.getPbData();
                                                                                        if (PbFragment.this.lug == null) {
                                                                                            PbFragment.this.lug = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.ar("c13446").w("forum_id", j2).bqy();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lvi);
                                                                                        PbFragment.this.lug.G(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13274").dR("fid", PbFragment.this.lqh.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", smartApp.name).w("obj_id", smartApp.swan_app_id.longValue()).dR("obj_source", "PB_card").dR("tid", PbFragment.this.lqh.dkU()).ak("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bx) {
                                                                                        bx bxVar2 = (bx) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bxVar2.blG(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).ak("obj_isad", 1).ak("obj_floor", 1).ak("obj_adlocate", 9).ak("obj_locate", 9).w("obj_id", bxVar2.getFid()).dR("tid", bxVar2.getId()).ak("thread_type", bxVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof bx) && PbFragment.this.checkUpIsLogin()) {
                                                                                        bx bxVar3 = (bx) view.getTag();
                                                                                        if (PbFragment.this.eYI != null) {
                                                                                            PbFragment.this.eYI.gp(bxVar3.blG(), String.valueOf(bxVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).ak("obj_isad", 1).ak("obj_floor", 1).ak("obj_adlocate", 10).ak("obj_locate", 11).w("obj_id", bxVar3.getFid()).dR("tid", bxVar3.getId()).ak("thread_type", bxVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lqh.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lqh.dkU(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lqh.getPbData().dhH().blX())));
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
                                                                            if (PbFragment.this.lum == null) {
                                                                                PbFragment.this.lum = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lum.a(PbFragment.this.lve);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.diV().getPbData() != null && PbFragment.this.diV().getPbData().dik();
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
                                                                                if (postData6.bnv() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bnv().hasAgree && postData6.bnf() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lum);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar8.eGH.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lum);
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
                                                                                        gVar9.eGH.setTag(sparseArray13);
                                                                                        arrayList2.add(gVar9);
                                                                                    } else {
                                                                                        if ((PbFragment.this.um(z2) && TbadkCoreApplication.isLogin()) && !z11) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lum);
                                                                                            gVar10.eGH.setTag(str);
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
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lum);
                                                                                            gVar11.eGH.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lum);
                                                                                        gVar4.eGH.setTag(sparseArray14);
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
                                                                                            if (PbFragment.this.lqh.getPbData().dhW() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lum);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lum);
                                                                                            }
                                                                                            gVar11.eGH.setTag(sparseArray15);
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
                                                                                PbFragment.this.lum.br(arrayList2);
                                                                                PbFragment.this.lul = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lum);
                                                                                PbFragment.this.lul.PA();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.luh.dnA();
                                                                    SparseArray<Object> b3 = PbFragment.this.luh.b(PbFragment.this.lqh.getPbData(), PbFragment.this.lqh.dkW(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lqh.getPbData().getForum().getId(), PbFragment.this.lqh.getPbData().getForum().getName(), PbFragment.this.lqh.getPbData().dhH().getId(), String.valueOf(PbFragment.this.lqh.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ak("obj_type", 0).ak("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ak("obj_type", 1).ak("obj_source", 1));
                                                                }
                                                                PbFragment.this.luh.lBp.doG();
                                                            }
                                                        } else if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().dhH() != null) {
                                                            PbFragment.this.luh.lBp.aYV();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13062"));
                                                            PbFragment.this.OW(PbFragment.this.lqh.getPbData().dhH().blT());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.luh.dnA();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lqh.dln()));
                                                                return;
                                                            }
                                                            PbFragment.this.cyn();
                                                            PbFragment.this.luh.dng();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lqh.getPbData().lnk == null || PbFragment.this.lqh.getPbData().lnk.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lqh.getPbData().lnk.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.lqh.getPbData().lnk.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.lqh.getPbData().lnk.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lqh.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.lqh.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.lqh.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.lqh.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12097").ak("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ak("obj_type", i10));
                                                                    if (PbFragment.this.lqh.getPbData().lnk != null && PbFragment.this.lqh.getPbData().lnk.size() > i9) {
                                                                        i9 = PbFragment.this.lqh.getPbData().lnk.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean Gy = PbFragment.this.lqh.Gy(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lqh.dln()));
                                                                    if (Gy) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.luh.uJ(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.PA();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.luh.dnA();
                                                    if (PbFragment.this.diV().getPbData().lnl != 2) {
                                                        if (PbFragment.this.lqh.getPageData() != null) {
                                                            PbFragment.this.luh.a(PbFragment.this.lqh.getPageData(), PbFragment.this.laQ);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lqh.getPbData()) != null) {
                                                bx dhH = pbData.dhH();
                                                if (dhH != null && dhH.blC() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lqh.lxu).dR("fid", pbData.getForumId()).ak("obj_locate", 4).dR("uid", dhH.blC().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (dhH != null) {
                                                    if (dhH.bkk()) {
                                                        i9 = 2;
                                                    } else if (dhH.bkl()) {
                                                        i9 = 3;
                                                    } else if (dhH.bnz()) {
                                                        i9 = 4;
                                                    } else if (dhH.bnA()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.ar arVar7 = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                arVar7.dR("tid", PbFragment.this.lqh.dkU());
                                                arVar7.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                arVar7.dR("fid", PbFragment.this.lqh.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    arVar7.ak("obj_locate", 5);
                                                } else {
                                                    arVar7.ak("obj_locate", 6);
                                                }
                                                arVar7.ak("obj_name", i9);
                                                arVar7.ak("obj_type", 1);
                                                if (dhH != null) {
                                                    if (dhH.bkk()) {
                                                        arVar7.ak("obj_type", 10);
                                                    } else if (dhH.bkl()) {
                                                        arVar7.ak("obj_type", 9);
                                                    } else if (dhH.bnA()) {
                                                        arVar7.ak("obj_type", 8);
                                                    } else if (dhH.bnz()) {
                                                        arVar7.ak("obj_type", 7);
                                                    } else if (dhH.isShareThread) {
                                                        arVar7.ak("obj_type", 6);
                                                    } else if (dhH.threadType == 0) {
                                                        arVar7.ak("obj_type", 1);
                                                    } else if (dhH.threadType == 40) {
                                                        arVar7.ak("obj_type", 2);
                                                    } else if (dhH.threadType == 49) {
                                                        arVar7.ak("obj_type", 3);
                                                    } else if (dhH.threadType == 54) {
                                                        arVar7.ak("obj_type", 4);
                                                    } else {
                                                        arVar7.ak("obj_type", 5);
                                                    }
                                                    arVar7.ak(IntentConfig.CARD_TYPE, dhH.bnD());
                                                    arVar7.dR(IntentConfig.RECOM_SOURCE, dhH.mRecomSource);
                                                    arVar7.dR("ab_tag", dhH.mRecomAbTag);
                                                    arVar7.dR("weight", dhH.mRecomWeight);
                                                    arVar7.dR("extra", dhH.mRecomExtra);
                                                    arVar7.dR("nid", dhH.getNid());
                                                    if (dhH.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(dhH.getBaijiahaoData().oriUgcVid)) {
                                                        arVar7.dR("obj_param6", dhH.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    arVar7.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.dkB() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.dkB(), arVar7);
                                                }
                                                TiebaStatic.log(arVar7);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dhJ2 = PbFragment.this.lqh.getPbData().dhJ();
                                                    if ((dhJ2 != null && dhJ2.size() > 0) || !PbFragment.this.lqh.dkW()) {
                                                        PbFragment.this.luh.dnA();
                                                        PbFragment.this.cyn();
                                                        if (pbData.did() != null && !StringUtils.isNull(pbData.did().bjy(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dR("fid", PbFragment.this.lqh.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dhH)) {
                                                            if (PbFragment.this.luh != null) {
                                                                PbFragment.this.luh.dnD();
                                                                PbFragment.this.luh.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.luh.showLoadingDialog();
                                                                PbFragment.this.lqh.dlz().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i10 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i10 = 1;
                                                                }
                                                                PbFragment.this.Gp(i10);
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
                                            PbFragment.this.luh.dnA();
                                            if (PbFragment.this.luh.lBp.doH() != null && view == PbFragment.this.luh.lBp.doH().dmf() && !PbFragment.this.luh.dnT()) {
                                                PbFragment.this.luh.dmK();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cyn();
                                                PbFragment.this.luh.dng();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    C = PbFragment.this.lqh.C(true, PbFragment.this.dkj());
                                                } else {
                                                    C = view.getId() == R.id.reply_title ? PbFragment.this.lqh.C(false, PbFragment.this.dkj()) : PbFragment.this.lqh.Pb(PbFragment.this.dkj());
                                                }
                                                view.setTag(Boolean.valueOf(C));
                                                if (C) {
                                                    PbFragment.this.luh.uf(true);
                                                    PbFragment.this.luh.cTa();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.luh.uJ(true);
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
                                        PbFragment.this.luh.dnA();
                                        if (PbFragment.this.Go(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lqh.Gz(PbFragment.this.luh.dnl()) != null) {
                                            PbFragment.this.dke();
                                            if (PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().dhH() != null && PbFragment.this.lqh.getPbData().dhH().blC() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lqh.lxu).dR("fid", PbFragment.this.lqh.getPbData().getForumId()).ak("obj_locate", 3).dR("uid", PbFragment.this.lqh.getPbData().dhH().blC().getUserId()));
                                            }
                                            if (PbFragment.this.lqh.getPbData().dhH() != null && PbFragment.this.lqh.getPbData().dhH().blC() != null && PbFragment.this.lqh.getPbData().dhH().blC().getUserId() != null && PbFragment.this.luf != null) {
                                                int h = PbFragment.this.h(PbFragment.this.lqh.getPbData());
                                                bx dhH2 = PbFragment.this.lqh.getPbData().dhH();
                                                int i11 = 1;
                                                if (dhH2.bkk()) {
                                                    i11 = 2;
                                                } else if (dhH2.bkl()) {
                                                    i11 = 3;
                                                } else if (dhH2.bnz()) {
                                                    i11 = 4;
                                                } else if (dhH2.bnA()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", PbFragment.this.lqh.lxu).ak("obj_locate", 1).dR("obj_id", PbFragment.this.lqh.getPbData().dhH().blC().getUserId()).ak("obj_type", PbFragment.this.luf.bhP() ? 0 : 1).ak("obj_source", h).ak("obj_param1", i11));
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
                                    if (PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().dhH() != null && PbFragment.this.lqh.getPbData().dhH().bki() && PbFragment.this.lqh.getPbData().dhH().blU() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11922"));
                                    }
                                    if (PbFragment.this.lqh.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lqh.diO()) || PbFragment.this.lqh.getAppealInfo() == null) {
                                            PbFragment.this.ltC.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lqh.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lqh.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.ltC.finish();
                                        return;
                                    }
                                    String diO2 = PbFragment.this.lqh.diO();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lqh.dkX() && diO2 != null && diO2.equals(name2)) {
                                        PbFragment.this.ltC.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lqh.getPbData() != null) {
                                    if ((PbFragment.this.lqh.getPbData().dhW() == 1 || PbFragment.this.lqh.getPbData().dhW() == 3) && !PbFragment.this.hZq.dKJ()) {
                                        PbFragment.this.luh.dnA();
                                        int i12 = 0;
                                        if (PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dmg()) {
                                            if (PbFragment.this.luh.lBp.doH() == null || view != PbFragment.this.luh.lBp.doH().dmi()) {
                                                if (view == PbFragment.this.luh.dne()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.lqh.getPbData().dhH().bly() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.lqh.getPbData().dhH().blx() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.lqh.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.lqh.getPbData().dhH().getId();
                                        PbFragment.this.luh.dnd();
                                        PbFragment.this.hZq.b(id4, name3, id5, i12, PbFragment.this.luh.dnf());
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
                            PbFragment.this.luh.lBp.doG();
                            if (PbFragment.this.lqh != null) {
                                PbFragment.this.hZs.setThreadId(PbFragment.this.lqh.dkU());
                            }
                            int i13 = 1;
                            if (PbFragment.this.lqh == null || !PbFragment.this.lqh.isPrivacy()) {
                                PbFragment.this.hZs.cnp();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.diV() != null && PbFragment.this.diV().getPbData() != null && PbFragment.this.diV().getPbData().getThreadId() != null && PbFragment.this.diV().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.diV() != null && PbFragment.this.diV().getPbData() != null) {
                                    PbFragment.this.hZs.k(3, i13, PbFragment.this.diV().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.diV() != null && PbFragment.this.diV().getPbData() != null) {
                                    PbFragment.this.hZs.k(3, 3, PbFragment.this.diV().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.luh.dnA();
                        PbFragment.this.cyn();
                        PbFragment.this.luh.dng();
                        PbFragment.this.luh.showLoadingDialog();
                        if (PbFragment.this.luh.dmT() != null) {
                            PbFragment.this.luh.dmT().setVisibility(8);
                        }
                        PbFragment.this.lqh.Gt(1);
                        if (PbFragment.this.ltE != null) {
                            PbFragment.this.ltE.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String djT = PbFragment.this.djT();
                        if (!TextUtils.isEmpty(djT)) {
                            bf.bqF().b(PbFragment.this.getPageContext(), new String[]{djT});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar8 = new com.baidu.tbadk.core.util.ar("c13398");
                arVar8.dR("tid", PbFragment.this.lqh.dkU());
                arVar8.dR("fid", PbFragment.this.lqh.getForumId());
                arVar8.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar8.ak("obj_locate", 1);
                TiebaStatic.log(arVar8);
                if (PbFragment.this.ltN) {
                    PbFragment.this.ltN = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.djM().dmH() != null && postData7.blC() != null && postData7.dJQ() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.djM().dmI() != null) {
                                PbFragment.this.djM().dmI().djC();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.lqh.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.lqh.getPbData().dhH());
                            pVar2.g(postData7);
                            PbFragment.this.djM().dmH().d(pVar2);
                            PbFragment.this.djM().dmH().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.blC().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lqh.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lut != null) {
                                PbFragment.this.luh.uT(PbFragment.this.lut.bzB());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lvg = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lqh != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lqh.lxu)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lqh.getPbData() != null) {
                    arVar.dR("fid", PbFragment.this.lqh.getPbData().getForumId());
                }
                arVar.dR("tid", PbFragment.this.lqh.dkU());
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            PbFragment.this.cyn();
            PbFragment.this.luh.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.lqh.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lqh.getPbData();
                            if (pbData != null && pbData.dhH() != null && pbData.dhH().blC() != null && (userId = pbData.dhH().blC().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lqh.dlg()) {
                                PbFragment.this.luh.dng();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lqh.dlg()) {
                            PbFragment.this.luh.dng();
                        }
                    } else if (floor != null) {
                        PbFragment.this.luh.s(PbFragment.this.lqh.getPbData());
                    }
                    if (PbFragment.this.lqh.dla()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10369").dR("tid", PbFragment.this.lqh.dkU()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.ul(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lut.bzI() || PbFragment.this.lut.bzJ()) {
                    PbFragment.this.lut.a(false, postWriteCallBackData);
                }
                PbFragment.this.kzS.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kwi != null) {
                    PbFragment.this.kwi.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AJ(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AJ(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").ak("obj_locate", 1).ak("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bog();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").ak("obj_locate", 1).ak("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d lvh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                    arVar.dR("fid", PbFragment.this.lqh.getPbData().getForumId());
                }
                if (PbFragment.this.lqh != null) {
                    arVar.dR("tid", PbFragment.this.lqh.dkU());
                }
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (PbFragment.this.kzS != null) {
                    PbFragment.this.kzS.dnZ();
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
                if (PbFragment.this.kwi != null) {
                    PbFragment.this.kwi.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AJ(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AJ(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").ak("obj_locate", 1).ak("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bog();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").ak("obj_locate", 1).ak("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kzS != null) {
                if (PbFragment.this.luh != null && PbFragment.this.luh.dmI() != null && PbFragment.this.luh.dmI().djG() != null && PbFragment.this.luh.dmI().djG().bzJ()) {
                    PbFragment.this.luh.dmI().djG().a(postWriteCallBackData);
                }
                PbFragment.this.kzS.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lvi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dnW;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.ltC.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.luh != null && (dnW = PbFragment.this.luh.dnW()) != null && PbFragment.this.luh.getListView() != null) {
                            PbFragment.this.luh.getListView().removeHeaderView(dnW);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lvj = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h rF;
            if (!z || fVar == null || fVar.dhU() != null || com.baidu.tbadk.core.util.y.getCount(fVar.dhJ()) >= 1) {
                PbFragment.this.kPC = true;
                PbFragment.this.luh.dni();
                if (fVar == null || !fVar.dhP()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.luh.getView());
                }
                PbFragment.this.luh.cSZ();
                if (PbFragment.this.isFullScreen || PbFragment.this.luh.dnT()) {
                    PbFragment.this.luh.dnK();
                } else if (!PbFragment.this.luh.dnH()) {
                    PbFragment.this.luh.uV(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.fWx = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.luh.getView());
                    PbFragment.this.luh.dnr();
                }
                if (z && fVar != null) {
                    bx dhH = fVar.dhH();
                    if (dhH == null || !dhH.bkm()) {
                        PbFragment.this.d(PbFragment.this.lus);
                    } else {
                        dkD();
                    }
                    PbFragment.this.luh.dmI().setPbData(fVar);
                    PbFragment.this.luh.bUJ();
                    if (dhH != null && dhH.bmP() != null) {
                        PbFragment.this.a(dhH.bmP());
                    }
                    if (PbFragment.this.lut != null) {
                        PbFragment.this.luh.uT(PbFragment.this.lut.bzB());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dhJ() != null && fVar.dhJ().size() >= 1 && fVar.dhJ().get(0) != null) {
                        PbFragment.this.lqh.Pd(fVar.dhJ().get(0).getId());
                    } else if (fVar.dhU() != null) {
                        PbFragment.this.lqh.Pd(fVar.dhU().getId());
                    }
                    if (PbFragment.this.lut != null) {
                        PbFragment.this.lut.a(fVar.getAnti());
                        PbFragment.this.lut.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lut.setThreadData(dhH);
                        PbFragment.this.lut.a(PbFragment.this.lqh.dlk(), PbFragment.this.lqh.dkU(), PbFragment.this.lqh.dlB());
                        if (dhH != null) {
                            PbFragment.this.lut.km(dhH.bnb());
                        }
                    }
                    if (PbFragment.this.luf != null) {
                        PbFragment.this.luf.is(fVar.bhP());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.dik()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.luh.uU(PbFragment.this.mIsFromCDN);
                    PbFragment.this.luh.a(fVar, i2, i3, PbFragment.this.lqh.dkW(), i4, PbFragment.this.lqh.getIsFromMark());
                    PbFragment.this.luh.d(fVar, PbFragment.this.lqh.dkW());
                    PbFragment.this.luh.uR(PbFragment.this.lqh.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.foT = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.foT) && PbFragment.this.lut != null && PbFragment.this.lut.byN() != null && (rF = PbFragment.this.lut.byN().rF(6)) != null && !TextUtils.isEmpty(PbFragment.this.foT)) {
                            ((View) rF).setOnClickListener(PbFragment.this.fpG);
                        }
                    }
                    if (PbFragment.this.luo) {
                        PbFragment.this.luo = false;
                        final int dka = PbFragment.this.dka();
                        if (!fVar.dih()) {
                            PbFragment.this.luh.GG(dka);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dka, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lup) {
                        PbFragment.this.lup = false;
                        final int dka2 = PbFragment.this.dka();
                        final boolean z2 = dka2 != -1;
                        if (!z2) {
                            dka2 = PbFragment.this.dkb();
                        }
                        if (PbFragment.this.luh != null) {
                            if (!fVar.dih()) {
                                PbFragment.this.luh.GG(dka2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dka2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.luh.setSelectionFromTop(dka2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.luh.setSelectionFromTop(dka2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.luh.uW(true);
                                PbFragment.this.luh.uV(false);
                            }
                        }
                    } else if (PbFragment.this.luq) {
                        PbFragment.this.luq = false;
                        PbFragment.this.luh.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.luh.dnm();
                    }
                    PbFragment.this.lqh.a(fVar.getForum(), PbFragment.this.luU);
                    PbFragment.this.lqh.a(PbFragment.this.luV);
                    if (PbFragment.this.kwi != null && dhH != null && dhH.blC() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dhH.blC());
                        PbFragment.this.kwi.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.fWx && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lqh.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lqh.getAppealInfo().lnb)) {
                                    PbFragment.this.luh.a(PbFragment.this.lqh.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.luh.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.luh.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.luh.dnK();
                            PbFragment.this.luh.dnq();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lqh.dkU());
                            jSONObject.put("fid", PbFragment.this.lqh.getForumId());
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
                        PbFragment.this.luh.Pj("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                            arrayList = PbFragment.this.lqh.getPbData().dhJ();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dJQ() != 1)) {
                            PbFragment.this.luh.Pj(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dku()) {
                                PbFragment.this.luh.Pk(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.luh.Pk(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.luh.s(PbFragment.this.lqh.getPbData());
                        }
                    }
                    PbFragment.this.luh.endLoadData();
                }
                if (fVar != null && fVar.lnr && PbFragment.this.fuA == 0) {
                    PbFragment.this.fuA = System.currentTimeMillis() - PbFragment.this.ikF;
                }
                if (!PbFragment.this.diV().dkW() || PbFragment.this.diV().getPbData().getPage().bkt() != 0 || PbFragment.this.diV().dlw()) {
                    PbFragment.this.luu = true;
                    return;
                }
                return;
            }
            PbFragment.this.lqh.Gt(1);
            if (PbFragment.this.ltE != null) {
                PbFragment.this.ltE.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dkD() {
            if (PbFragment.this.lqh != null) {
                if (PbFragment.this.lut == null || !PbFragment.this.lut.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lut = (com.baidu.tbadk.editortools.pb.e) dVar.ei(PbFragment.this.getContext());
                    PbFragment.this.lut.a(PbFragment.this.ltC.getPageContext());
                    PbFragment.this.lut.a(PbFragment.this.fpd);
                    PbFragment.this.lut.a(PbFragment.this.foW);
                    PbFragment.this.lut.a(PbFragment.this.ltC.getPageContext(), PbFragment.this.ltC.getIntent() == null ? null : PbFragment.this.ltC.getIntent().getExtras());
                    PbFragment.this.lut.byN().kc(true);
                    PbFragment.this.luh.setEditorTools(PbFragment.this.lut.byN());
                    if (!PbFragment.this.lqh.dlb()) {
                        PbFragment.this.lut.Dn(PbFragment.this.lqh.dkU());
                    }
                    if (PbFragment.this.lqh.dlC()) {
                        PbFragment.this.lut.Dl(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.luh != null) {
                        PbFragment.this.lut.Dl(PbFragment.this.luh.dmM());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.luh.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.bBK().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.ikF : j;
                if (PbFragment.this.fuA == 0) {
                    PbFragment.this.fuA = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.fuq, PbFragment.this.createTime, PbFragment.this.fuA, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fuq = 0L;
                if (iVar != null) {
                    iVar.bBH();
                }
                if (z2) {
                    iVar.fuJ = currentTimeMillis;
                    iVar.ky(true);
                }
                if (!z2 && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().dhH() != null) {
                    int threadType = PbFragment.this.lqh.getPbData().dhH().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.au.equals(PbFragment.this.ltR, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.au.equals(PbFragment.this.ltR, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.fuL = currentTimeMillis;
                                iVar2.si(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.fuL = currentTimeMillis;
                        dVar.si(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener lvk = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.djW();
            }
        }
    };
    private final a.InterfaceC0571a lvl = new a.InterfaceC0571a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0571a
        public void d(boolean z, boolean z2, String str) {
            PbFragment.this.luh.dni();
            if (z) {
                if (PbFragment.this.luf != null) {
                    PbFragment.this.luf.is(z2);
                }
                PbFragment.this.lqh.uA(z2);
                if (PbFragment.this.lqh.bhP()) {
                    PbFragment.this.dkf();
                } else {
                    PbFragment.this.luh.s(PbFragment.this.lqh.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.luf != null) {
                        if (PbFragment.this.luf.bhS() != null && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.lqh.getPbData().dhH() != null && PbFragment.this.lqh.getPbData().dhH().blC() != null) {
                            MarkData bhS = PbFragment.this.luf.bhS();
                            MetaData blC = PbFragment.this.lqh.getPbData().dhH().blC();
                            if (bhS != null && blC != null) {
                                if (!com.baidu.tbadk.core.util.au.equals(TbadkCoreApplication.getCurrentAccount(), blC.getUserId()) && !blC.hadConcerned()) {
                                    PbFragment.this.b(blC);
                                } else {
                                    PbFragment.this.showToast(R.string.add_mark_on_pb);
                                    if (com.baidu.tbadk.coreExtra.c.a.w(PbFragment.this.getContext(), 0)) {
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
                    PbFragment.this.dkc();
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
            if (!PbFragment.this.Ge(PbFragment.this.mLastScrollState) && PbFragment.this.Ge(i)) {
                if (PbFragment.this.luh != null) {
                    PbFragment.this.luh.dnA();
                    if (PbFragment.this.lut != null && !PbFragment.this.luh.dmL()) {
                        PbFragment.this.luh.uT(PbFragment.this.lut.bzB());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.luh.dmK();
                    }
                }
                if (!PbFragment.this.ltK) {
                    PbFragment.this.ltK = true;
                    if (PbFragment.this.luh != null) {
                        PbFragment.this.luh.dnG();
                    }
                }
            }
            if (PbFragment.this.luh != null) {
                PbFragment.this.luh.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.ltE != null) {
                PbFragment.this.ltE.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.ltL == null) {
                PbFragment.this.ltL = new com.baidu.tbadk.n.b();
                PbFragment.this.ltL.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.ltL.bBB();
            } else {
                PbFragment.this.ltL.bBA();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.t.c.dIO().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dhJ;
            if (PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null && PbFragment.this.luh != null && PbFragment.this.luh.dnc() != null) {
                PbFragment.this.luh.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.ltE != null) {
                    PbFragment.this.ltE.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lqh.dls() && (dhJ = PbFragment.this.lqh.getPbData().dhJ()) != null && !dhJ.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.luh.dnc().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lqh.getPbData();
                    if (pbData != null) {
                        if (pbData.dhK() != null && pbData.dhK().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dhL() != null && pbData.dhL().hasData()) {
                            headerCount--;
                        }
                        int size = dhJ.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d hZx = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.hZq.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.lqh.dlp();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.lJC != 1002 || bVar.gQe) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.luh.a(1, dVar.QR, dVar.naF, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.hZq.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.luh.a(PbFragment.this.hZq.getLoadDataMode(), gVar.QR, gVar.naF, false);
                            PbFragment.this.luh.bd(gVar.naI);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.luh.a(PbFragment.this.hZq.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lvm = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c fUg = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dkk()) {
                PbFragment.this.ltC.finish();
            }
            if (!PbFragment.this.lqh.uz(true)) {
                PbFragment.this.luh.dnj();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lvo = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lvn && PbFragment.this.dkk()) {
                PbFragment.this.dkm();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.luc && PbFragment.this.luh != null && PbFragment.this.luh.dnY() && PbFragment.this.lqh != null) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13999");
                    arVar.dR("tid", PbFragment.this.lqh.dkU());
                    arVar.dR("fid", PbFragment.this.lqh.getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    PbFragment.this.luc = true;
                }
                if (PbFragment.this.lqh.uy(false)) {
                    PbFragment.this.luh.dnh();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lqh.getPbData() != null) {
                    PbFragment.this.luh.dnF();
                }
                PbFragment.this.lvn = true;
            }
        }
    };
    private int lvp = 0;
    private final TbRichTextView.i fFy = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dnc;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.luh.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                arVar.dR("tid", PbFragment.this.lqh.dkU());
                arVar.dR("fid", PbFragment.this.lqh.getForumId());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.ak("obj_locate", 3);
                arVar.ak("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(arVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lqh.lre.dik()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bFc() != null) {
                            ArrayList<TbRichTextImageInfo> bFc = tbRichTextView.getRichText().bFc();
                            int i4 = 0;
                            while (i4 < bFc.size()) {
                                if (bFc.get(i4) != null) {
                                    arrayList.add(bFc.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bFc.get(i4).getSrc()) || str.equals(bFc.get(i4).bFx()) || str.equals(bFc.get(i4).bFu()) || str.equals(bFc.get(i4).bFw()) || str.equals(bFc.get(i4).bFA()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bFc.get(i4).getSrc();
                                    imageUrlData.originalUrl = bFc.get(i4).getSrc();
                                    imageUrlData.isLongPic = bFc.get(i4).bFC();
                                    concurrentHashMap.put(bFc.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).nL(i3).iy(false).iz(PbFragment.this.lqh.dlm()).a(concurrentHashMap).iA(true).iB(false).iC(PbFragment.this.dku()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lqh != null) {
                            aVar.Ae(PbFragment.this.lqh.getFromForumId());
                            if (PbFragment.this.lqh.getPbData() != null) {
                                aVar.s(PbFragment.this.lqh.getPbData().dhH());
                            }
                        }
                        ImageViewerConfig dU = aVar.dU(PbFragment.this.getPageContext().getPageActivity());
                        dU.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.lqq) {
                        TbRichText by = PbFragment.this.by(str, i);
                        if (by != null && PbFragment.this.lvp >= 0 && PbFragment.this.lvp < by.bFb().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(by.bFb().get(PbFragment.this.lvp));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lqp.size()) {
                                    break;
                                } else if (!aVar2.lqp.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (by.getPostId() != 0 && (dnc = PbFragment.this.luh.dnc()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = dnc.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && by.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (by.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lqh.dlB(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lqh.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.evM.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.x(arrayList2).zZ(aVar2.forumName).Aa(aVar2.forumId).Ab(aVar2.threadId).iy(aVar2.evK).iA(true).Ac(aVar2.lastId).iz(PbFragment.this.lqh.dlm()).a(concurrentHashMap2).iB(false).iC(PbFragment.this.dku()).Ad(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lqh != null) {
                                aVar3.Ae(PbFragment.this.lqh.getFromForumId());
                                if (PbFragment.this.lqh.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lqh.getPbData().dhH());
                                }
                            }
                            ImageViewerConfig dU2 = aVar3.dU(PbFragment.this.getPageContext().getPageActivity());
                            dU2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.lqp, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.evM.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).zZ(aVar2.forumName).Aa(aVar2.forumId).Ab(aVar2.threadId).iy(aVar2.evK).iA(true).Ac(aVar2.lqp.get(0)).iz(PbFragment.this.lqh.dlm()).a(concurrentHashMap3).iB(false).iC(PbFragment.this.dku()).Ad(aVar2.postId).iD(false);
                    if (PbFragment.this.lqh != null) {
                        aVar4.Ae(PbFragment.this.lqh.getFromForumId());
                        if (PbFragment.this.lqh.getPbData() != null) {
                            aVar4.s(PbFragment.this.lqh.getPbData().dhH());
                        }
                    }
                    ImageViewerConfig dU3 = aVar4.dU(PbFragment.this.getPageContext().getPageActivity());
                    dU3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.ltV = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lvq = false;
    PostData jLA = null;
    private final b.InterfaceC0574b lvr = new b.InterfaceC0574b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jLA != null) {
                if (i == 0) {
                    PbFragment.this.jLA.fS(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.jLA = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.jLA);
                }
            }
        }
    };
    private final b.InterfaceC0574b lvs = new b.InterfaceC0574b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.luD != null && !TextUtils.isEmpty(PbFragment.this.luE)) {
                if (i == 0) {
                    if (PbFragment.this.luF == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.luE));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.luE;
                        aVar.pkgId = PbFragment.this.luF.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.luF.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.euQ == null) {
                            PbFragment.this.euQ = new bd(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.euQ.j(PbFragment.this.luE, PbFragment.this.luD.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.luD = null;
                PbFragment.this.luE = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
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
                if (PbFragment.this.luh != null) {
                    if (!PbFragment.this.luh.dkM()) {
                        PbFragment.this.luh.dnX();
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
                    if (PbFragment.this.m42do(view)) {
                        if (view instanceof TbImageView) {
                            PbFragment.this.luD = ((TbImageView) view).getBdImage();
                            PbFragment.this.luE = ((TbImageView) view).getUrl();
                            if (PbFragment.this.luD == null || TextUtils.isEmpty(PbFragment.this.luE)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.luF = null;
                            } else {
                                PbFragment.this.luF = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else if (view instanceof GifView) {
                            if (((GifView) view).getBdImage() != null) {
                                PbFragment.this.luD = ((GifView) view).getBdImage();
                                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                    PbFragment.this.luE = ((GifView) view).getBdImage().getUrl();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    PbFragment.this.luF = null;
                                } else {
                                    PbFragment.this.luF = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                }
                            } else {
                                return true;
                            }
                        } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                            PbFragment.this.luD = ((TbMemeImageView) view).getBdImage();
                            if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                                PbFragment.this.luE = ((TbMemeImageView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.luF = null;
                            } else {
                                PbFragment.this.luF = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                            PbFragment.this.luh.a(PbFragment.this.lvs, PbFragment.this.luD.isGif());
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
                PbFragment.this.jLA = (PostData) sparseArray2.get(R.id.tag_clip_board);
                if (PbFragment.this.jLA == null) {
                    return true;
                }
                if (PbFragment.this.jLA.dJQ() != 1 || !PbFragment.this.m42do(view)) {
                    if (PbFragment.this.luf != null) {
                        if (!PbFragment.this.luf.bhP() || PbFragment.this.jLA.getId() == null || !PbFragment.this.jLA.getId().equals(PbFragment.this.lqh.blK())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        boolean z3 = PbFragment.this.diV().getPbData() != null && PbFragment.this.diV().getPbData().dik();
                        if (PbFragment.this.jLA.dJQ() != 1) {
                            if (PbFragment.this.lum == null) {
                                PbFragment.this.lum = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                PbFragment.this.lum.a(PbFragment.this.lve);
                            }
                            ArrayList arrayList = new ArrayList();
                            if (view != null && sparseArray2 != null) {
                                boolean z4 = PbFragment.this.m42do(view) && !z3;
                                boolean z5 = (!PbFragment.this.m42do(view) || PbFragment.this.luD == null || PbFragment.this.luD.isGif()) ? false : true;
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
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.lum));
                                }
                                if (z5) {
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.lum));
                                }
                                if (!z4 && !z5) {
                                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lum);
                                    SparseArray sparseArray3 = new SparseArray();
                                    sparseArray3.put(R.id.tag_clip_board, PbFragment.this.jLA);
                                    gVar3.eGH.setTag(sparseArray3);
                                    arrayList.add(gVar3);
                                }
                                if (!z2 && !z3) {
                                    if (z) {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lum);
                                    } else {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lum);
                                    }
                                    SparseArray sparseArray4 = new SparseArray();
                                    sparseArray4.put(R.id.tag_clip_board, PbFragment.this.jLA);
                                    sparseArray4.put(R.id.tag_is_subpb, false);
                                    gVar2.eGH.setTag(sparseArray4);
                                    arrayList.add(gVar2);
                                }
                                if (PbFragment.this.mIsLogin && !PbFragment.this.lrD) {
                                    if (!z8 && z7) {
                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lum);
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
                                        gVar4.eGH.setTag(sparseArray5);
                                        arrayList.add(gVar4);
                                    } else {
                                        if ((PbFragment.this.um(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lum);
                                            gVar5.eGH.setTag(str);
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
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lum);
                                            gVar6.eGH.setTag(sparseArray6);
                                        } else {
                                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                                        }
                                        gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lum);
                                        gVar.eGH.setTag(sparseArray6);
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
                                            if (PbFragment.this.lqh.getPbData().dhW() == 1002 && !z6) {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lum);
                                            } else {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lum);
                                            }
                                            gVar6.eGH.setTag(sparseArray7);
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
                                PbFragment.this.lum.br(arrayList);
                                PbFragment.this.lul = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lum);
                                PbFragment.this.lul.PA();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13272").dR("tid", PbFragment.this.lqh.lxu).dR("fid", PbFragment.this.lqh.getForumId()).dR("uid", PbFragment.this.lqh.getPbData().dhH().blC().getUserId()).dR("post_id", PbFragment.this.lqh.bzp()).ak("obj_source", z2 ? 2 : 1));
                            }
                            return true;
                        }
                        if (!z3) {
                            PbFragment.this.luh.a(PbFragment.this.lvr, z, false);
                        }
                        return true;
                    }
                    return true;
                }
                PbFragment.this.luh.a(PbFragment.this.lvs, PbFragment.this.luD.isGif());
                return true;
            }
            return true;
        }
    };
    private final NoNetworkView.a iFn = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bDs && z && !PbFragment.this.lqh.dlc()) {
                PbFragment.this.dkh();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener fyo = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.iMX.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0740a igS = new a.InterfaceC0740a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int gPK = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void H(int i, int i2) {
            if (ax(i2) && PbFragment.this.luh != null && PbFragment.this.ltE != null) {
                PbFragment.this.ltE.pQ(true);
                if (Math.abs(i2) > this.gPK) {
                    PbFragment.this.ltE.hideFloatingView();
                }
                if (PbFragment.this.dkk()) {
                    PbFragment.this.luh.dmZ();
                    PbFragment.this.luh.dna();
                }
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void I(int i, int i2) {
            if (ax(i2) && PbFragment.this.luh != null && PbFragment.this.ltE != null) {
                PbFragment.this.luh.dnL();
                PbFragment.this.ltE.pQ(false);
                PbFragment.this.ltE.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void J(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final q.a lsF = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.luh.Pl(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lvu = -1;
    private int lvv = -1;

    /* loaded from: classes21.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes21.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e djH() {
        return this.lut;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.dix() != null) {
            String id = pVar.dix().getId();
            ArrayList<PostData> dhJ = this.lqh.getPbData().dhJ();
            int i = 0;
            while (true) {
                if (i >= dhJ.size()) {
                    z = true;
                    break;
                }
                PostData postData = dhJ.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> diF = pVar.diF();
                    postData.Ke(pVar.getTotalCount());
                    if (postData.dJN() == null || diF == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = diF.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.blC() != null && (metaData = postData.getUserMap().get(next.blC().getUserId())) != null) {
                                next.a(metaData);
                                next.xy(true);
                                next.a(getPageContext(), this.lqh.Pc(metaData.getUserId()));
                            }
                        }
                        z = diF.size() != postData.dJN().size();
                        if (postData.dJN() != null && postData.dJN().size() < 2) {
                            postData.dJN().clear();
                            postData.dJN().addAll(diF);
                        }
                    }
                    if (postData.dJJ() != null) {
                        postData.dJK();
                    }
                }
            }
            if (!this.lqh.getIsFromMark() && z) {
                this.luh.s(this.lqh.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OU(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n dhZ = this.lqh.getPbData().dhZ();
            if (dhZ != null && str.equals(dhZ.getAdId())) {
                if (dhZ.dJE() != null) {
                    dhZ.dJE().legoCard = null;
                }
                this.lqh.getPbData().dia();
            }
            com.baidu.tieba.tbadkCore.data.n dli = this.lqh.dli();
            if (dli != null && str.equals(dli.getAdId())) {
                this.lqh.dlj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lul != null && this.lul.isShowing()) {
                this.lul.dismiss();
                this.lul = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lul != null) {
                            PbFragment.this.lul.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.luh.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.luB);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.luB);
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
                kVar.br(arrayList);
                this.lul = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lul.PA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ar(int i) {
        bx dhH;
        if (this.lqh != null && this.lqh.getPbData() != null && (dhH = this.lqh.getPbData().dhH()) != null) {
            if (i == 1) {
                PraiseData bln = dhH.bln();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bln == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        dhH.a(praiseData);
                    } else {
                        dhH.bln().getUser().add(0, metaData);
                        dhH.bln().setNum(dhH.bln().getNum() + 1);
                        dhH.bln().setIsLike(i);
                    }
                }
                if (dhH.bln() != null) {
                    if (dhH.bln().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.au.numFormatOver10000(dhH.bln().getNum());
                    }
                }
            } else if (dhH.bln() != null) {
                dhH.bln().setIsLike(i);
                dhH.bln().setNum(dhH.bln().getNum() - 1);
                ArrayList<MetaData> user = dhH.bln().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dhH.bln().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dhH.bln().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dhH.bln().getNum() + "";
                }
            }
            if (this.lqh.dkW()) {
                this.luh.dnc().notifyDataSetChanged();
            } else {
                this.luh.t(this.lqh.getPbData());
            }
        }
    }

    public static PbFragment djI() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ltC = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lqh.aC(bundle);
        if (this.iIc != null) {
            this.iIc.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lut.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.ltJ = System.currentTimeMillis();
        this.luz = getPageContext();
        final Intent intent = this.ltC.getIntent();
        if (intent != null) {
            this.ikF = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.ltR = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.ltR)) {
                    this.ltR = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.ltR)) {
                this.ltF = true;
            }
            this.lvu = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lvv = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lvw = intent.getStringExtra("key_manga_title");
            this.luo = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lup = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.luq = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dkk()) {
                this.ltC.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.luH = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lua = new bg();
            this.lua.C(intent);
            this.luJ = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.luJ == 0) {
                this.luJ = intent.getIntExtra("key_start_from", 0);
            }
            this.luK = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.ikF = System.currentTimeMillis();
        }
        this.fuq = this.ltJ - this.ikF;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.ltH = 0;
        aB(bundle);
        if (this.lqh.getPbData() != null) {
            this.lqh.getPbData().OO(this.source);
        }
        djL();
        if (intent != null && this.luh != null) {
            this.luh.lBn = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.luC == null) {
                    this.luC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.luh.Pn(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.luC, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lqh.getPbData() != null) {
                this.lqh.Pf(stringExtra);
            }
        }
        this.iIc = new VoiceManager();
        this.iIc.onCreate(getPageContext());
        initData(bundle);
        this.lus = new com.baidu.tbadk.editortools.pb.g();
        d(this.lus);
        this.lut = (com.baidu.tbadk.editortools.pb.e) this.lus.ei(getActivity());
        this.lut.a(this.ltC.getPageContext());
        this.lut.a(this.fpd);
        this.lut.a(this.foW);
        this.lut.setFrom(1);
        this.lut.a(this.ltC.getPageContext(), bundle);
        this.lut.byN().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lut.byN().kc(true);
        uk(true);
        this.lut.a(this.lqh.dlk(), this.lqh.dkU(), this.lqh.dlB());
        registerListener(this.luP);
        if (!this.lqh.dlb()) {
            this.lut.Dn(this.lqh.dkU());
        }
        if (this.lqh.dlC()) {
            this.lut.Dl(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.luh != null) {
            this.lut.Dl(this.luh.dmM());
        }
        registerListener(this.luO);
        registerListener(this.luQ);
        registerListener(this.luR);
        registerListener(this.iJI);
        registerListener(this.lvd);
        registerListener(this.luN);
        this.lur = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.mXj);
        this.lur.dJw();
        registerListener(this.luS);
        registerListener(this.eMu);
        this.lqh.dlu();
        registerListener(this.lvk);
        registerListener(this.iJQ);
        registerListener(this.lvg);
        if (this.luh != null && this.luh.dnP() != null && this.luh.dnQ() != null) {
            this.ltE = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.luh.dnP(), this.luh.dnQ(), this.luh.dmT());
            this.ltE.a(this.luY);
        }
        if (this.ltD && this.luh != null && this.luh.dnQ() != null) {
            this.luh.dnQ().setVisibility(8);
        }
        this.luA = new com.baidu.tbadk.core.view.c();
        this.luA.toastTime = 1000L;
        registerListener(this.lvc);
        registerListener(this.lva);
        registerListener(this.lvb);
        registerListener(this.jcD);
        registerListener(this.iJE);
        this.luT.setSelfListener(true);
        this.luT.setTag(this.ltC.getUniqueId());
        this.luT.setPriority(-1);
        MessageManager.getInstance().registerListener(this.luT);
        registerResponsedEventListener(TipEvent.class, this.iHg);
        this.luB = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.luB;
        userMuteAddAndDelCustomMessage.setTag(this.luB);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.luB;
        userMuteCheckCustomMessage.setTag(this.luB);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lqh.dlz().a(this.luZ);
        this.kzS = new bb();
        if (this.lut.bzt() != null) {
            this.kzS.e(this.lut.bzt().getInputView());
        }
        this.lut.a(this.foX);
        this.jbi = new ShareSuccessReplyToServerModel();
        a(this.luL);
        this.kwi = new com.baidu.tbadk.core.util.am(getPageContext());
        this.kwi.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.eMl) {
                        PbFragment.this.lut.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.eMm && PbFragment.this.luh != null && PbFragment.this.luh.dmI() != null && PbFragment.this.luh.dmI().djG() != null) {
                        PbFragment.this.luh.dmI().djG().bzR();
                    } else if (i == com.baidu.tbadk.core.util.am.eMn) {
                        PbFragment.this.c(PbFragment.this.luw);
                    }
                }
            }
        });
        this.lue = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lue.w(getUniqueId());
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
        com.baidu.tbadk.core.business.a.biX().dD("3", "");
        this.hZs = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.ltJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lqh != null) {
            gVar.setForumName(this.lqh.diO());
            if (this.lqh.getPbData() != null && this.lqh.getPbData().getForum() != null) {
                gVar.a(this.lqh.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lqh);
        }
    }

    public String djJ() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b djK() {
        return this.ltE;
    }

    private void uk(boolean z) {
        this.lut.kj(z);
        this.lut.kk(z);
        this.lut.kl(z);
    }

    private void djL() {
        this.eYI = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iIc != null) {
            this.iIc.onStart(getPageContext());
        }
    }

    public az djM() {
        return this.luh;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel diV() {
        return this.lqh;
    }

    public void OV(String str) {
        if (this.lqh != null && !StringUtils.isNull(str) && this.luh != null) {
            this.luh.uY(true);
            this.lqh.OV(str);
            this.ltP = true;
            this.luh.dnA();
            this.luh.dnK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.bDs = false;
        } else {
            this.bDs = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.ltH = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.ltH == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.iIc != null) {
            this.iIc.onPause(getPageContext());
        }
        if (this.luh != null) {
            this.luh.onPause();
        }
        if (!this.lqh.dlb()) {
            this.lut.Dm(this.lqh.dkU());
        }
        if (this.lqh != null) {
            this.lqh.dlv();
        }
        com.baidu.tbadk.BdToken.c.bfy().bfJ();
        MessageManager.getInstance().unRegisterListener(this.jXy);
        cMi();
        MessageManager.getInstance().unRegisterListener(this.lva);
        MessageManager.getInstance().unRegisterListener(this.lvb);
        MessageManager.getInstance().unRegisterListener(this.lvc);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean djN() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lqh.getPbData(), this.lqh.dkW(), this.lqh.dlt());
        return (a2 == null || a2.blC() == null || a2.blC().getGodUserData() == null || a2.blC().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bDs = false;
        super.onResume();
        if (this.ltT) {
            this.ltT = false;
            dkq();
        }
        if (djN()) {
            this.ltM = System.currentTimeMillis();
        } else {
            this.ltM = -1L;
        }
        if (this.luh != null && this.luh.getView() != null) {
            if (!this.kPC) {
                dki();
            } else {
                hideLoadingView(this.luh.getView());
            }
            this.luh.onResume();
        }
        if (this.ltH == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.luh != null) {
            noNetworkView = this.luh.dmF();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.iIc != null) {
            this.iIc.onResume(getPageContext());
        }
        registerListener(this.jXy);
        this.lun = false;
        dkp();
        registerListener(this.lva);
        registerListener(this.lvb);
        registerListener(this.lvc);
        if (this.iIR) {
            dkh();
            this.iIR = false;
        }
        dkx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.luh.uN(z);
        if (this.lul != null) {
            this.lul.dismiss();
        }
        if (z && this.lun) {
            this.luh.dnh();
            this.lqh.uy(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ltM > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10804").dR("obj_duration", (System.currentTimeMillis() - this.ltM) + ""));
            this.ltM = 0L;
        }
        if (djM().dmI() != null) {
            djM().dmI().onStop();
        }
        if (this.luh.lBp != null && !this.luh.lBp.doJ()) {
            this.luh.lBp.releaseResources();
        }
        if (this.lqh != null && this.lqh.getPbData() != null && this.lqh.getPbData().getForum() != null && this.lqh.getPbData().dhH() != null) {
            com.baidu.tbadk.distribute.a.byA().b(getPageContext().getPageActivity(), "pb", this.lqh.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lqh.getPbData().dhH().getId(), 0L));
        }
        if (this.iIc != null) {
            this.iIc.onStop(getPageContext());
        }
        com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lub);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13266");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("fid", this.lqh.getPbData().getForumId());
            arVar.dR("tid", this.lqh.dkU());
            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(arVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.ltK && this.luh != null) {
            this.ltK = true;
            this.luh.dnG();
            a(false, (PostData) null);
        }
        if (this.lqh != null) {
            this.lqh.cancelLoadData();
            this.lqh.destory();
            if (this.lqh.dly() != null) {
                this.lqh.dly().onDestroy();
            }
        }
        if (this.lut != null) {
            this.lut.onDestroy();
        }
        if (this.hZq != null) {
            this.hZq.cancelLoadData();
        }
        if (this.eYI != null) {
            this.eYI.dJj();
        }
        if (this.luh != null) {
            this.luh.onDestroy();
            if (this.luh.lBp != null) {
                this.luh.lBp.releaseResources();
            }
        }
        if (this.ltL != null) {
            this.ltL.bBC();
        }
        if (this.ltE != null) {
            this.ltE.cAf();
        }
        super.onDestroy();
        if (this.iIc != null) {
            this.iIc.onDestory(getPageContext());
        }
        if (this.luh != null) {
            this.luh.dnA();
        }
        MessageManager.getInstance().unRegisterListener(this.lva);
        MessageManager.getInstance().unRegisterListener(this.lvb);
        MessageManager.getInstance().unRegisterListener(this.lvc);
        MessageManager.getInstance().unRegisterListener(this.luB);
        MessageManager.getInstance().unRegisterListener(this.lvd);
        MessageManager.getInstance().unRegisterListener(this.iJQ);
        MessageManager.getInstance().unRegisterListener(this.jcD);
        MessageManager.getInstance().unRegisterListener(this.lvi);
        MessageManager.getInstance().unRegisterListener(this.luT);
        this.luz = null;
        this.luA = null;
        com.baidu.tieba.recapp.d.a.dAG().dAJ();
        if (this.luC != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.luC);
        }
        if (this.ltU != null) {
            this.ltU.cancelLoadData();
        }
        if (this.luh != null && this.luh.lBp != null) {
            this.luh.lBp.doN();
        }
        if (this.jbi != null) {
            this.jbi.cancelLoadData();
        }
        this.kzS.onDestroy();
        if (this.lqh != null && this.lqh.dlA() != null) {
            this.lqh.dlA().onDestroy();
        }
        if (this.kwi != null) {
            this.kwi.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dnc;
        ArrayList<PostData> djr;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.btF() && this.luh != null && (dnc = this.luh.dnc()) != null && (djr = dnc.djr()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = djr.iterator();
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
                        bVar.ibH = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eDz == 1 && !TextUtils.isEmpty(id)) {
                    next.eDz = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.ibH = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.lqh == null || this.lqh.getPbData() == null || this.lqh.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.lqh.getPbData().getForum().getFirst_class();
                    str2 = this.lqh.getPbData().getForum().getSecond_class();
                    str = this.lqh.getPbData().getForum().getId();
                    str4 = this.lqh.dkU();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.btI());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.luh.onChangeSkinType(i);
            if (this.lut != null && this.lut.byN() != null) {
                this.lut.byN().onChangeSkinType(i);
            }
            if (this.luh.dmF() != null) {
                this.luh.dmF().onChangeSkinType(getPageContext(), i);
            }
            this.kzS.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.CAM_X0201));
            this.mSkinType = i;
            cyn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.luh = new az(this, this.iKO, this.fgS);
        this.iMX = new com.baidu.tieba.g.b(getActivity());
        this.iMX.a(lvt);
        this.iMX.a(this.igS);
        this.luh.setOnScrollListener(this.mOnScrollListener);
        this.luh.d(this.lvo);
        this.luh.setListPullRefreshListener(this.fUg);
        this.luh.tW(com.baidu.tbadk.core.k.biL().isShowImages());
        this.luh.setOnImageClickListener(this.fFy);
        this.luh.b(this.mOnLongClickListener);
        this.luh.g(this.iFn);
        this.luh.a(this.lvm);
        this.luh.uN(this.mIsLogin);
        if (this.ltC.getIntent() != null) {
            this.luh.uZ(this.ltC.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.luh.dmH().setFromForumId(this.lqh.getFromForumId());
        this.luh.setEditorTools(this.lut.byN());
        this.lut.Dl(this.luh.dmM());
        this.luh.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lqh.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lqh.getPbData().getForum().getId(), PbFragment.this.lqh.getPbData().getForum().getName(), PbFragment.this.lqh.getPbData().dhH().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.luh.va(this.lqh.dkZ());
        this.luh.GA(this.lqh.dlE());
        return this.luh.getView();
    }

    public void djO() {
        if (this.luh != null && this.lqh != null) {
            if ((this.lqh.getPbData() != null || this.lqh.getPbData().dig() != null) && checkUpIsLogin() && this.luh.dnc() != null && this.luh.dnc().djw() != null) {
                this.luh.dnc().djw().BT(this.lqh.dkU());
            }
        }
    }

    public void djP() {
        TiebaStatic.log("c12181");
        if (this.luh != null && this.lqh != null) {
            if ((this.luh == null || this.luh.dmL()) && this.lqh.getPbData() != null && this.lqh.getPbData().dig() != null) {
                com.baidu.tieba.pb.data.o dig = this.lqh.getPbData().dig();
                if (checkUpIsLogin()) {
                    if ((!dig.diz() || dig.bnf() != 2) && this.luh.dnc() != null && this.luh.dnc().djw() != null) {
                        this.luh.dnc().djw().BT(this.lqh.dkU());
                    }
                    if (System.currentTimeMillis() - this.ltO > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).vI(false);
                        this.ltO = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dm(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.eCj && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.biL().isShowImages()) {
                    return OY(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.lqh == null || this.lqh.getPbData() == null) {
                        return true;
                    }
                    if (djM().dmI() != null) {
                        djM().dmI().djC();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.lqh.getPbData().getForum());
                    pVar.setThreadData(this.lqh.getPbData().dhH());
                    pVar.g(postData);
                    djM().dmH().d(pVar);
                    djM().dmH().setPostId(postData.getId());
                    a(view, postData.blC().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lut != null) {
                        this.luh.uT(this.lut.bzB());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void djQ() {
        if (this.ltI == null) {
            this.ltI = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.ltI.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0574b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lqd = PbFragment.this.lqd.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lqd);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lqh.dkU(), PbFragment.this.lqd, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lqd = PbFragment.this.lqd.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lqd);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lqh.dkU(), PbFragment.this.lqd, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lqd = PbFragment.this.lqd.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lqd);
                        bVar.dismiss();
                    }
                }
            }).oy(b.a.BOTTOM_TO_TOP).oz(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.lvj.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).dqN(), "", 1);
    }

    private void aB(Bundle bundle) {
        this.lqh = this.ltC.diV();
        if (this.lqh.dlx() != null) {
            this.lqh.dlx().a(this.lsF);
        }
        if (this.lqh.dly() != null) {
            this.lqh.dly().b(this.luM);
        }
        if (StringUtils.isNull(this.lqh.dkU())) {
            this.ltC.finish();
        } else if ("from_tieba_kuang".equals(this.ltR) && this.ltR != null) {
            this.lqh.GA(6);
        }
    }

    private void initData(Bundle bundle) {
        this.luf = com.baidu.tbadk.baseEditMark.a.a(this.ltC);
        if (this.luf != null) {
            this.luf.a(this.lvl);
        }
        this.hZq = new ForumManageModel(this.ltC);
        this.hZq.setLoadDataCallBack(this.hZx);
        this.eMq = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.luX.setUniqueId(getUniqueId());
        this.luX.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.luh.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.luB;
        userMuteCheckCustomMessage.setTag(this.luB);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean djR() {
        if (this.lqh == null || this.lqh.getPbData() == null) {
            return false;
        }
        bx dhH = this.lqh.getPbData().dhH();
        this.lqh.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dhH);
    }

    public void djS() {
        if (checkUpIsLogin() && this.lqh != null && this.lqh.getPbData() != null && this.lqh.getPbData().getForum() != null && !djR()) {
            if (this.lqh.getPbData().dik()) {
                this.luh.cLJ();
                return;
            }
            if (this.iMx == null) {
                this.iMx = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iMx.AA(0);
                this.iMx.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pL(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pM(boolean z) {
                        if (z) {
                            if (PbFragment.this.lut != null && PbFragment.this.lut.byN() != null) {
                                PbFragment.this.lut.byN().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.luh.cLJ();
                        }
                    }
                });
            }
            this.iMx.G(this.lqh.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lqh.dkU(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String djT() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lqh == null || (pbData = this.lqh.getPbData()) == null) {
            return null;
        }
        return pbData.dhV().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dhH() != null) {
            if (fVar.dhH().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dhH().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dhH().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !djR() && djU()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.ltW);
                this.ltX = ((View) view.getParent()).getMeasuredHeight();
            }
            if (djM().dmI() != null && postData != null) {
                String str3 = "";
                if (postData.dJS() != null) {
                    str3 = postData.dJS().toString();
                }
                djM().dmI().OT(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.blC().getName_show(), str3));
            }
            if (this.lqh.getPbData() != null && this.lqh.getPbData().dik()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.ltC.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.djM().getListView().smoothScrollBy((PbFragment.this.ltW[1] + PbFragment.this.ltX) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.djM().dmI() != null) {
                            PbFragment.this.lut.byN().setVisibility(8);
                            PbFragment.this.djM().dmI().h(str, str2, PbFragment.this.djM().dmM(), (PbFragment.this.lqh == null || PbFragment.this.lqh.getPbData() == null || PbFragment.this.lqh.getPbData().dhH() == null || !PbFragment.this.lqh.getPbData().dhH().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h djG = PbFragment.this.djM().dmI().djG();
                            if (djG != null && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                                djG.a(PbFragment.this.lqh.getPbData().getAnti());
                                djG.setThreadData(PbFragment.this.lqh.getPbData().dhH());
                            }
                            if (PbFragment.this.kzS.dod() == null && PbFragment.this.djM().dmI().djG().bzZ() != null) {
                                PbFragment.this.djM().dmI().djG().bzZ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kzS != null && PbFragment.this.kzS.doc() != null) {
                                            if (!PbFragment.this.kzS.doc().dSV()) {
                                                PbFragment.this.kzS.vc(false);
                                            }
                                            PbFragment.this.kzS.doc().yx(false);
                                        }
                                    }
                                });
                                PbFragment.this.kzS.f(PbFragment.this.djM().dmI().djG().bzZ().getInputView());
                                PbFragment.this.djM().dmI().djG().a(PbFragment.this.luy);
                            }
                        }
                        PbFragment.this.djM().dnK();
                    }
                }, 0L);
                return;
            }
            if (this.luv == null) {
                this.luv = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.luv.AA(1);
                this.luv.a(new AnonymousClass39(str, str2));
            }
            if (this.lqh != null && this.lqh.getPbData() != null && this.lqh.getPbData().getForum() != null) {
                this.luv.G(this.lqh.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lqh.dkU(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes21.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lvD;
        final /* synthetic */ String lvE;

        AnonymousClass39(String str, String str2) {
            this.lvD = str;
            this.lvE = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pL(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pM(boolean z) {
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
                        PbFragment.this.djM().getListView().smoothScrollBy((PbFragment.this.ltW[1] + PbFragment.this.ltX) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.djM().dmI() != null) {
                            PbFragment.this.lut.byN().setVisibility(8);
                            PbFragment.this.djM().dmI().h(AnonymousClass39.this.lvD, AnonymousClass39.this.lvE, PbFragment.this.djM().dmM(), (PbFragment.this.lqh == null || PbFragment.this.lqh.getPbData() == null || PbFragment.this.lqh.getPbData().dhH() == null || !PbFragment.this.lqh.getPbData().dhH().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h djG = PbFragment.this.djM().dmI().djG();
                            if (djG != null && PbFragment.this.lqh != null && PbFragment.this.lqh.getPbData() != null) {
                                djG.a(PbFragment.this.lqh.getPbData().getAnti());
                                djG.setThreadData(PbFragment.this.lqh.getPbData().dhH());
                            }
                            if (PbFragment.this.kzS.dod() == null && PbFragment.this.djM().dmI().djG().bzZ() != null) {
                                PbFragment.this.djM().dmI().djG().bzZ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kzS != null && PbFragment.this.kzS.doc() != null) {
                                            if (!PbFragment.this.kzS.doc().dSV()) {
                                                PbFragment.this.kzS.vc(false);
                                            }
                                            PbFragment.this.kzS.doc().yx(false);
                                        }
                                    }
                                });
                                PbFragment.this.kzS.f(PbFragment.this.djM().dmI().djG().bzZ().getInputView());
                                PbFragment.this.djM().dmI().djG().a(PbFragment.this.luy);
                            }
                        }
                        PbFragment.this.djM().dnK();
                    }
                }, 0L);
            }
        }
    }

    public boolean djU() {
        if ((this.lqh.getPbData() != null && this.lqh.getPbData().dik()) || this.kwi == null || this.lqh.getPbData() == null || this.lqh.getPbData().getAnti() == null) {
            return true;
        }
        return this.kwi.pp(this.lqh.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Gn(int i) {
        if (this.kwi == null || this.lqh.getPbData() == null || this.lqh.getPbData().getAnti() == null) {
            return true;
        }
        return this.kwi.aO(this.lqh.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lqh != null && this.lqh.getPbData() != null && postData.dJQ() != 1) {
            String dkU = this.lqh.dkU();
            String id = postData.getId();
            int i = 0;
            if (this.lqh.getPbData() != null) {
                i = this.lqh.getPbData().dhW();
            }
            PbActivity.a OZ = OZ(id);
            if (OZ != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dkU, id, "pb", true, null, false, null, i, postData.dpH(), this.lqh.getPbData().getAnti(), false, postData.blC() != null ? postData.blC().getIconInfo() : null).addBigImageData(OZ.lqp, OZ.evM, OZ.evK, OZ.index);
                addBigImageData.setKeyPageStartFrom(this.lqh.dlE());
                addBigImageData.setFromFrsForumId(this.lqh.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lqh.getForumId());
                addBigImageData.setBjhData(this.lqh.dld());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int djV() {
        if (this.lqh.getPbData() == null || this.lqh.getPbData().dhH() == null) {
            return -1;
        }
        return this.lqh.getPbData().dhH().bmp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && diV() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            diV().Pe(postWriteCallBackData.getPostId());
            this.luG = this.luh.dmO();
            this.lqh.db(this.luG, this.luh.dmP());
        }
        this.luh.dnA();
        this.kzS.doa();
        if (this.lut != null) {
            this.luh.uT(this.lut.bzB());
        }
        this.luh.dmG();
        this.luh.uV(true);
        this.lqh.dlp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(boolean z) {
        if (this.lqh != null && this.lqh.lre != null && this.lqh.lre.dhH() != null) {
            bx dhH = this.lqh.lre.dhH();
            dhH.mRecomAbTag = this.lqh.dlP();
            dhH.mRecomWeight = this.lqh.dlN();
            dhH.mRecomSource = this.lqh.dlO();
            dhH.mRecomExtra = this.lqh.dlQ();
            if (dhH.getFid() == 0) {
                dhH.setFid(com.baidu.adp.lib.f.b.toLong(this.lqh.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dhH, "c13563");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (eu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (eu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.ak("reply_type", 1);
                if (z) {
                    a2.ak("obj_type", 2);
                } else {
                    a2.ak("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djW() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.RC(this.lqh.getForumId()) && this.lqh.getPbData() != null && this.lqh.getPbData().getForum() != null) {
            if (this.lqh.getPbData().getForum().isLike() == 1) {
                this.lqh.dlA().gi(this.lqh.getForumId(), this.lqh.dkU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean um(boolean z) {
        if (this.lqh == null || this.lqh.getPbData() == null) {
            return false;
        }
        return ((this.lqh.getPbData().dhW() != 0) || this.lqh.getPbData().dhH() == null || this.lqh.getPbData().dhH().blC() == null || TextUtils.equals(this.lqh.getPbData().dhH().blC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean un(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ac acVar;
        if (this.lqh == null || this.lqh.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lqh.getPbData();
        bx dhH = pbData.dhH();
        if (dhH != null) {
            if (dhH.bkk() || dhH.bkl()) {
                return false;
            }
            if (dhH.bnz() || dhH.bnA()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.dhW() != 0) {
                return pbData.dhW() != 3;
            }
            List<bt> die = pbData.die();
            if (com.baidu.tbadk.core.util.y.getCount(die) > 0) {
                for (bt btVar : die) {
                    if (btVar != null && (acVar = btVar.eBt) != null && acVar.ezg && !acVar.ezh && (acVar.type == 1 || acVar.type == 2)) {
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

    private boolean uo(boolean z) {
        if (z || this.lqh == null || this.lqh.getPbData() == null) {
            return false;
        }
        return ((this.lqh.getPbData().getForum() != null && this.lqh.getPbData().getForum().isBlockBawuDelete) || this.lqh.getPbData().dhW() == 0 || this.lqh.getPbData().dhW() == 3) ? false : true;
    }

    public void djX() {
        com.baidu.tieba.pb.data.f pbData;
        bx dhH;
        boolean z = true;
        if (this.lqh != null && this.lqh.getPbData() != null && (dhH = (pbData = this.lqh.getPbData()).dhH()) != null && dhH.blC() != null) {
            this.luh.dmG();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dhH.blC().getUserId());
            ak akVar = new ak();
            int dhW = this.lqh.getPbData().dhW();
            if (dhW == 1 || dhW == 3) {
                akVar.lzD = true;
                akVar.lzC = true;
                akVar.lzI = dhH.blx() == 1;
                akVar.lzH = dhH.bly() == 1;
            } else {
                akVar.lzD = false;
                akVar.lzC = false;
            }
            if (dhW == 1002 && !equals) {
                akVar.lzJ = true;
            }
            akVar.lzA = un(equals);
            akVar.lzE = djY();
            akVar.lzB = uo(equals);
            akVar.Fc = this.lqh.dkW();
            akVar.lzx = true;
            akVar.lzw = um(equals);
            akVar.lzv = equals && this.luh.dno();
            akVar.lzG = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.lzF = true;
            akVar.isHostOnly = this.lqh.getHostMode();
            akVar.lzz = true;
            if (dhH.blU() == null) {
                akVar.lzy = true;
            } else {
                akVar.lzy = false;
            }
            if (pbData.dik()) {
                akVar.lzx = false;
                akVar.lzz = false;
                akVar.lzy = false;
                akVar.lzC = false;
                akVar.lzD = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dik()) {
                z = false;
            }
            akVar.lzK = z;
            this.luh.lBp.a(akVar);
        }
    }

    private boolean djY() {
        if (this.lqh != null && this.lqh.dkW()) {
            return this.lqh.getPageData() == null || this.lqh.getPageData().bkt() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(View view) {
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
    public PbModel.a djZ() {
        return this.lvj;
    }

    public int dka() {
        if (djM() == null || djM().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = djM().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).Vx == com.baidu.tieba.pb.data.n.loF) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dkb() {
        if (djM() == null || djM().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = djM().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.mXJ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dkh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkc() {
        if (this.lqh != null && this.lqh.lre != null && this.lqh.lre.dhH() != null) {
            bx dhH = this.lqh.lre.dhH();
            dhH.mRecomAbTag = this.lqh.dlP();
            dhH.mRecomWeight = this.lqh.dlN();
            dhH.mRecomSource = this.lqh.dlO();
            dhH.mRecomExtra = this.lqh.dlQ();
            if (dhH.getFid() == 0) {
                dhH.setFid(com.baidu.adp.lib.f.b.toLong(this.lqh.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dhH, "c13562");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (eu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (eu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
            aVar.AI(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.AJ(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.iW(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12528").dR("obj_id", metaData.getUserId()).ak("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12528").dR("obj_id", metaData.getUserId()).ak("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.eMq.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lqh.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bog();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.luh.dni();
        this.lqh.uA(z);
        if (this.luf != null) {
            this.luf.is(z);
            if (markData != null) {
                this.luf.a(markData);
            }
        }
        if (this.lqh.bhP()) {
            dkf();
        } else {
            this.luh.s(this.lqh.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ge(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OW(String str) {
        if (this.lqh != null && this.lqh.getPbData() != null && this.lqh.getPbData().dik()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lqh.dkU(), str);
            bx dhH = this.lqh.getPbData().dhH();
            if (dhH.bkk()) {
                format = format + "&channelid=33833";
            } else if (dhH.bny()) {
                format = format + "&channelid=33842";
            } else if (dhH.bkl()) {
                format = format + "&channelid=33840";
            }
            OX(format);
            return;
        }
        this.lue.Px(str);
    }

    private void OX(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.lqh.dlb()) {
                    antiData.setBlock_forum_name(this.lqh.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lqh.getPbData().getForum().getId());
                    antiData.setUser_name(this.lqh.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lqh.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (djM() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
                } else {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            Ds(str);
        } else {
            this.luh.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.naF) ? bVar.naF : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.AJ(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.iW(true);
                aVar.b(getPageContext());
                aVar.bog();
            } else {
                this.luh.a(0, bVar.QR, bVar.naF, z);
            }
            if (bVar.QR) {
                if (bVar.ioW == 1) {
                    ArrayList<PostData> dhJ = this.lqh.getPbData().dhJ();
                    int size = dhJ.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dhJ.get(i).getId())) {
                            i++;
                        } else {
                            dhJ.remove(i);
                            break;
                        }
                    }
                    this.lqh.getPbData().dhH().of(this.lqh.getPbData().dhH().blt() - 1);
                    this.luh.s(this.lqh.getPbData());
                } else if (bVar.ioW == 0) {
                    dkd();
                } else if (bVar.ioW == 2) {
                    ArrayList<PostData> dhJ2 = this.lqh.getPbData().dhJ();
                    int size2 = dhJ2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dhJ2.get(i2).dJN().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dhJ2.get(i2).dJN().get(i3).getId())) {
                                i3++;
                            } else {
                                dhJ2.get(i2).dJN().remove(i3);
                                dhJ2.get(i2).dJP();
                                z2 = true;
                                break;
                            }
                        }
                        dhJ2.get(i2).Ss(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.luh.s(this.lqh.getPbData());
                    }
                    a(bVar, this.luh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.luh.a(this.hZq.getLoadDataMode(), gVar.QR, gVar.naF, false);
            if (gVar.QR) {
                this.lui = true;
                if (i == 2 || i == 3) {
                    this.luj = true;
                    this.luk = false;
                } else if (i == 4 || i == 5) {
                    this.luj = false;
                    this.luk = true;
                }
                if (i == 2) {
                    this.lqh.getPbData().dhH().oi(1);
                    this.lqh.setIsGood(1);
                } else if (i == 3) {
                    this.lqh.getPbData().dhH().oi(0);
                    this.lqh.setIsGood(0);
                } else if (i == 4) {
                    this.lqh.getPbData().dhH().oh(1);
                    this.lqh.Gs(1);
                } else if (i == 5) {
                    this.lqh.getPbData().dhH().oh(0);
                    this.lqh.Gs(0);
                }
                this.luh.c(this.lqh.getPbData(), this.lqh.dkW());
            }
        }
    }

    private void dkd() {
        if (this.lqh.dkX() || this.lqh.dkZ()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lqh.dkU());
            PbActivity pbActivity = this.ltC;
            PbActivity pbActivity2 = this.ltC;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lqh.dkU()));
        if (dkg()) {
            this.ltC.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dji() {
        this.ltC.dji();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dhT;
        boolean z = false;
        if (this.luh != null) {
            this.luh.dnA();
        }
        if (this.lqh != null && this.lqh.getPbData() != null && !this.lqh.getPbData().dik()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lqh.getPbData().dhH().getId();
            if (this.lqh.isShareThread() && this.lqh.getPbData().dhH().eEF != null) {
                historyMessage.threadName = this.lqh.getPbData().dhH().eEF.showText;
            } else {
                historyMessage.threadName = this.lqh.getPbData().dhH().getTitle();
            }
            if (this.lqh.isShareThread() && !diN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lqh.getPbData().getForum().getName();
            }
            ArrayList<PostData> dhJ = this.lqh.getPbData().dhJ();
            int dnk = this.luh != null ? this.luh.dnk() : 0;
            if (dhJ != null && dnk >= 0 && dnk < dhJ.size()) {
                historyMessage.postID = dhJ.get(dnk).getId();
            }
            historyMessage.isHostOnly = this.lqh.getHostMode();
            historyMessage.isSquence = this.lqh.dkW();
            historyMessage.isShareThread = this.lqh.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lut != null) {
            this.lut.onDestroy();
        }
        if (this.ltG && djM() != null) {
            djM().dnU();
        }
        if (this.lqh != null && (this.lqh.dkX() || this.lqh.dkZ())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lqh.dkU());
            if (this.lui) {
                if (this.luk) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lqh.cqF());
                }
                if (this.luj) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lqh.getIsGood());
                }
            }
            if (this.lqh.getPbData() != null && System.currentTimeMillis() - this.ltJ >= 40000 && (dhT = this.lqh.getPbData().dhT()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dhT.getDataList())) {
                intent.putExtra("guess_like_data", dhT);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.luH);
            }
            PbActivity pbActivity = this.ltC;
            PbActivity pbActivity2 = this.ltC;
            pbActivity.setResult(-1, intent);
        }
        if (dkg()) {
            if (this.lqh != null && this.luh != null && this.luh.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lqh.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dhP() && !this.ltP && pbData.lnm == null) {
                        as dmr = as.dmr();
                        com.baidu.tieba.pb.data.f dle = this.lqh.dle();
                        Parcelable onSaveInstanceState = this.luh.getListView().onSaveInstanceState();
                        boolean dkW = this.lqh.dkW();
                        boolean hostMode = this.lqh.getHostMode();
                        if (this.luh.dmT() != null && this.luh.dmT().getVisibility() == 0) {
                            z = true;
                        }
                        dmr.a(dle, onSaveInstanceState, dkW, hostMode, z);
                        if (this.luG >= 0 || this.lqh.dlG() != null) {
                            as.dmr().q(this.lqh.dlG());
                            as.dmr().p(this.lqh.dlH());
                            as.dmr().GC(this.lqh.dlI());
                        }
                    }
                }
            } else {
                as.dmr().reset();
            }
            dji();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.luh == null || !this.luh.GI(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Go(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.ltC;
        if (i == 0) {
            this.luh.dmG();
            this.luh.dmI().djC();
            this.luh.uV(false);
        }
        this.luh.dmK();
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
                        this.lut.resetData();
                        this.lut.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lut.b(writeData);
                        com.baidu.tbadk.editortools.m rI = this.lut.byN().rI(6);
                        if (rI != null && rI.fmx != null) {
                            rI.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.ltC;
                        if (i == -1) {
                            this.lut.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.luh.dmI() != null && this.luh.dmI().djG() != null) {
                            com.baidu.tbadk.editortools.pb.h djG = this.luh.dmI().djG();
                            djG.setThreadData(this.lqh.getPbData().dhH());
                            djG.b(writeData);
                            djG.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m rI2 = djG.byN().rI(6);
                            if (rI2 != null && rI2.fmx != null) {
                                rI2.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.ltC;
                            if (i == -1) {
                                djG.bzR();
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
        this.lut.onActivityResult(i, i2, intent);
        if (this.ltU != null) {
            this.ltU.onActivityResult(i, i2, intent);
        }
        if (djM().dmI() != null) {
            djM().dmI().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dke();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.dmr().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lqh != null) {
                                PbFragment.this.lqh.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.p.a.dzt().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lqh != null) {
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
                        arVar.dR("tid", intent.getStringExtra("tid"));
                        arVar.dR("post_id", intent.getStringExtra("pid"));
                        arVar.ak("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(arVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.p.a.dzt().F(getPageContext());
                        djW();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.jbi != null && shareItem != null && shareItem.linkUrl != null) {
                            this.jbi.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bwm() {
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
                    this.luh.ub(false);
                    if (this.lqh.getPbData() != null && this.lqh.getPbData().dhH() != null && this.lqh.getPbData().dhH().blX() != null) {
                        this.lqh.getPbData().dhH().blX().setStatus(2);
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
                        this.luw = emotionImageData;
                        if (Gn(com.baidu.tbadk.core.util.am.eMn)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.ltV != null) {
                        this.luh.du(this.ltV);
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
            if (this.ltU == null) {
                this.ltU = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.ltC);
                this.ltU.b(this.foW);
                this.ltU.c(this.fpd);
            }
            this.ltU.a(emotionImageData, diV(), diV().getPbData());
        }
    }

    private void S(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dke() {
        MarkData Gz;
        if (this.luf != null) {
            if (this.lqh.getPbData() != null && this.lqh.getPbData().dik()) {
                Gz = this.lqh.Gz(0);
            } else {
                Gz = this.lqh.Gz(this.luh.dnl());
            }
            if (Gz != null) {
                if (!Gz.isApp() || (Gz = this.lqh.Gz(this.luh.dnl() + 1)) != null) {
                    this.luh.dng();
                    this.luf.a(Gz);
                    if (!this.luf.bhP()) {
                        this.luf.bhR();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.luf.bhQ();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkf() {
        com.baidu.tieba.pb.data.f pbData = this.lqh.getPbData();
        this.lqh.uA(true);
        if (this.luf != null) {
            pbData.ON(this.luf.bhO());
        }
        this.luh.s(pbData);
    }

    private boolean dkg() {
        if (this.lqh == null) {
            return true;
        }
        if (this.lqh.getPbData() == null || !this.lqh.getPbData().dik()) {
            if (this.lqh.bhP()) {
                final MarkData dlo = this.lqh.dlo();
                if (dlo == null || !this.lqh.getIsFromMark()) {
                    return true;
                }
                final MarkData Gz = this.lqh.Gz(this.luh.dnk());
                if (Gz == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dlo);
                    this.ltC.setResult(-1, intent);
                    return true;
                } else if (Gz.getPostId() == null || Gz.getPostId().equals(dlo.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dlo);
                    this.ltC.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.AJ(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.luf != null) {
                                if (PbFragment.this.luf.bhP()) {
                                    PbFragment.this.luf.bhQ();
                                    PbFragment.this.luf.is(false);
                                }
                                PbFragment.this.luf.a(Gz);
                                PbFragment.this.luf.is(true);
                                PbFragment.this.luf.bhR();
                            }
                            dlo.setPostId(Gz.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dlo);
                            PbFragment.this.ltC.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dji();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dlo);
                            PbFragment.this.ltC.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dji();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.luh != null && PbFragment.this.luh.getView() != null) {
                                PbFragment.this.luh.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dlo);
                                PbFragment.this.ltC.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.dji();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bog();
                    return false;
                }
            } else if (this.lqh.getPbData() == null || this.lqh.getPbData().dhJ() == null || this.lqh.getPbData().dhJ().size() <= 0 || !this.lqh.getIsFromMark()) {
                return true;
            } else {
                this.ltC.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.luh == null) {
            return null;
        }
        return this.luh.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bFM() {
        if (this.luh == null) {
            return 0;
        }
        return this.luh.dny();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bFN() {
        if (this.fFn == null) {
            this.fFn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bFZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.biL().isShowImages();
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
                        if (com.baidu.tbadk.core.k.biL().isShowImages()) {
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
        return this.fFn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bFO() {
        if (this.fIE == null) {
            this.fIE = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fIE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bFP() {
        if (this.fFo == null) {
            this.fFo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: csv */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.biL().isShowImages();
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
                    if (com.baidu.tbadk.core.k.biL().isShowImages()) {
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
                    gifView.bAr();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fFo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bFQ() {
        if (this.fIF == null) {
            this.fIF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dkE */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dp */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dq */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bYE();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dr */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fIF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bFS() {
        this.fIH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dkF */
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
        return this.fIH;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bsr() {
        if (this.eWZ == null) {
            this.eWZ = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eWZ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void au(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ltN = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void f(Context context, String str, boolean z) {
        if (be.Po(str) && this.lqh != null && this.lqh.dkU() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").ak("obj_param1", 1).dR("post_id", this.lqh.dkU()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.flv = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            be.dof().f(getPageContext(), str);
        }
        this.ltN = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void av(Context context, String str) {
        be.dof().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.ltN = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aw(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.luh != null && this.luh.dnP() != null && rect.top <= this.luh.dnP().getHeight()) {
            rect.top += this.luh.dnP().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lqh.getPbData();
            TbRichText by = by(str, i);
            if (by != null && (tbRichTextData = by.bFb().get(this.lvp)) != null) {
                aVar.postId = String.valueOf(by.getPostId());
                aVar.lqp = new ArrayList<>();
                aVar.evM = new ConcurrentHashMap<>();
                if (!tbRichTextData.bFh().bFv()) {
                    aVar.lqq = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lqp.add(c2);
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
                    imageUrlData.postId = by.getPostId();
                    imageUrlData.mIsReserver = this.lqh.dlm();
                    imageUrlData.mIsSeeHost = this.lqh.getHostMode();
                    aVar.evM.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dhH() != null) {
                            aVar.threadId = pbData.dhH().getId();
                        }
                        aVar.evK = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lqq = true;
                int size = pbData.dhJ().size();
                this.lvq = false;
                aVar.index = -1;
                int a2 = pbData.dhQ() != null ? a(pbData.dhQ().dJS(), by, i, i, aVar.lqp, aVar.evM) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dhJ().get(i2);
                    if (postData.getId() == null || pbData.dhQ() == null || pbData.dhQ().getId() == null || !postData.getId().equals(pbData.dhQ().getId())) {
                        a2 = a(postData.dJS(), by, a2, i, aVar.lqp, aVar.evM);
                    }
                }
                if (aVar.lqp.size() > 0) {
                    aVar.lastId = aVar.lqp.get(aVar.lqp.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dhH() != null) {
                        aVar.threadId = pbData.dhH().getId();
                    }
                    aVar.evK = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFh() == null) {
            return null;
        }
        return tbRichTextData.bFh().bFA();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFh() == null) {
            return 0L;
        }
        return tbRichTextData.bFh().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFh() == null) {
            return false;
        }
        return tbRichTextData.bFh().bFB();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFh() == null) {
            return false;
        }
        return tbRichTextData.bFh().bFC();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bFh;
        String str;
        if (tbRichText == tbRichText2) {
            this.lvq = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bFb().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bFb().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bFh().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bFh().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bFh().bFv()) {
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
                            if (tbRichTextData != null && (bFh = tbRichTextData.bFh()) != null) {
                                String bFx = bFh.bFx();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bFh.bFy();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bFx;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lqh.dkU(), -1L);
                                imageUrlData.mIsReserver = this.lqh.dlm();
                                imageUrlData.mIsSeeHost = this.lqh.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lvq) {
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
        PostData dhQ;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lqh.blK())) {
                z = true;
            }
            MarkData o = this.lqh.o(postData);
            if (this.lqh.getPbData() != null && this.lqh.getPbData().dik() && (dhQ = dhQ()) != null) {
                o = this.lqh.o(dhQ);
            }
            if (o != null) {
                this.luh.dng();
                if (this.luf != null) {
                    this.luf.a(o);
                    if (!z) {
                        this.luf.bhR();
                    } else {
                        this.luf.bhQ();
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

    /* renamed from: do  reason: not valid java name */
    public boolean m42do(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText by(String str, int i) {
        TbRichText tbRichText = null;
        if (this.lqh == null || this.lqh.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lqh.getPbData();
        if (pbData.dhQ() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dhQ());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dhJ = pbData.dhJ();
            c(pbData, dhJ);
            return c(dhJ, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eQi == null) {
                this.eQi = new com.baidu.tbadk.core.message.a();
            }
            if (this.ePS == null) {
                this.ePS = new com.baidu.tieba.tbadkCore.data.e();
                this.ePS.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.exI = 5;
            dVar.exO = 8;
            dVar.exN = 2;
            if (diV() != null) {
                dVar.exM = diV().dlE();
            }
            dVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.exP = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.exP = 1;
                        i = 0;
                    }
                }
                this.eQi.a(agreeData, i, getUniqueId(), false);
                this.eQi.a(agreeData, this.ePS);
                if (this.lqh == null && this.lqh.getPbData() != null) {
                    this.eQi.a(dkB(), dVar, agreeData, this.lqh.getPbData().dhH());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.exP = 1;
            }
            i = 0;
            this.eQi.a(agreeData, i, getUniqueId(), false);
            this.eQi.a(agreeData, this.ePS);
            if (this.lqh == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dhV() != null && fVar.dhV().loU != null && (list = fVar.dhV().loU) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bFb;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dJS = arrayList.get(i2).dJS();
            if (dJS != null && (bFb = dJS.bFb()) != null) {
                int size = bFb.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bFb.get(i4) != null && bFb.get(i4).getType() == 8) {
                        i3++;
                        if (bFb.get(i4).bFh().bFx().equals(str) || bFb.get(i4).bFh().bFy().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bFb.get(i4).bFh().getWidth() * equipmentDensity;
                            int height = bFb.get(i4).bFh().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lvp = i4;
                            return dJS;
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
            this.lqd = str;
            if (this.ltI == null) {
                djQ();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.ltI.getItemView(1).setVisibility(8);
            } else {
                this.ltI.getItemView(1).setVisibility(0);
            }
            this.ltI.boi();
            this.ltN = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iIc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkh() {
        hideNetRefreshView(this.luh.getView());
        dki();
        if (this.lqh.dlh()) {
            this.luh.dng();
        }
        this.luh.dnr();
    }

    private void dki() {
        showLoadingView(this.luh.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.luh.dnP().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyn() {
        if (this.iIc != null) {
            this.iIc.stopPlay();
        }
        if (this.ltC != null) {
            this.ltC.cyn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, djV(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bFR() {
        if (this.fIG == null) {
            this.fIG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dkG */
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
        return this.fIG;
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

    public void cyo() {
        if (this.ltC != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.ltC.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.ltC.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cwP() {
        if (this.lqh == null || this.lqh.getPbData() == null) {
            return null;
        }
        return this.lqh.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.lCD)).intValue();
            if (intValue == az.lCE) {
                if (!this.hZq.dKJ()) {
                    this.luh.dnd();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.hZq.SE(com.baidu.tbadk.core.util.au.R(jSONArray));
                    }
                    this.hZq.a(this.lqh.getPbData().getForum().getId(), this.lqh.getPbData().getForum().getName(), this.lqh.getPbData().dhH().getId(), str, intValue3, intValue2, booleanValue, this.lqh.getPbData().dhH().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.lCF || intValue == az.lCH) {
                if (this.lqh.dlx() != null) {
                    this.lqh.dlx().Gj(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.lCF) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.luB);
        userMuteAddAndDelCustomMessage.setTag(this.luB);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean OY(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0824a
    public void up(boolean z) {
        this.lun = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dkj() {
        ArrayList<PostData> dhJ;
        int count;
        if (this.lqh == null || this.lqh.getPbData() == null || this.lqh.getPbData().dhJ() == null || (count = com.baidu.tbadk.core.util.y.getCount((dhJ = this.lqh.getPbData().dhJ()))) == 0) {
            return "";
        }
        if (this.lqh.dlm()) {
            Iterator<PostData> it = dhJ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dJQ() == 1) {
                    return next.getId();
                }
            }
        }
        int dnk = this.luh.dnk();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dhJ, dnk);
        if (postData == null || postData.blC() == null) {
            return "";
        }
        if (this.lqh.Pc(postData.blC().getUserId())) {
            return postData.getId();
        }
        for (int i = dnk - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dhJ, i);
            if (postData2 == null || postData2.blC() == null || postData2.blC().getUserId() == null) {
                break;
            } else if (this.lqh.Pc(postData2.blC().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dnk + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dhJ, i2);
            if (postData3 == null || postData3.blC() == null || postData3.blC().getUserId() == null) {
                return "";
            }
            if (this.lqh.Pc(postData3.blC().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
        this.ltN = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a OZ(String str) {
        String str2;
        if (this.lqh.getPbData() == null || this.lqh.getPbData().dhJ() == null || this.lqh.getPbData().dhJ().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lqh.getPbData().dhJ().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lqh.getPbData().dhJ().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lqh.getPbData().dhJ().get(i);
        if (postData.dJS() == null || postData.dJS().bFb() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dJS().bFb().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bFh() != null) {
                    str2 = next.bFh().bFx();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dkk() {
        return (!this.ltD && this.lvu == -1 && this.lvv == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null) {
            this.lvx = sVar;
            this.ltD = true;
            this.luh.dmU();
            this.luh.Pm(this.lvw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkl() {
        if (this.lvx != null) {
            if (this.lvu == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lvx.getCartoonId(), this.lvu, 0)));
                this.ltC.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkm() {
        if (this.lvx != null) {
            if (this.lvv == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lvx.getCartoonId(), this.lvv, 0)));
                this.ltC.finish();
            }
        }
    }

    public int dkn() {
        return this.lvu;
    }

    public int dko() {
        return this.lvv;
    }

    private void cMi() {
        if (this.lqh != null && this.lqh.getPbData() != null && this.lqh.getPbData().dhH() != null && this.lqh.getPbData().dhH().bki()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dkp() {
        if (this.lqh != null && this.lqh.getPbData() != null && this.lqh.getPbData().dhH() != null && this.lqh.getPbData().dhH().bki()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dkq() {
        if (this.bDs) {
            this.ltT = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lqh.getPbData() != null && this.lqh.getPbData().dhH() != null && this.lqh.getPbData().dhH().bli() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lqh.getPbData().dhH().bli().getThreadId(), this.lqh.getPbData().dhH().bli().getTaskId(), this.lqh.getPbData().dhH().bli().getForumId(), this.lqh.getPbData().dhH().bli().getForumName(), this.lqh.getPbData().dhH().blx(), this.lqh.getPbData().dhH().bly())));
            this.ltF = true;
            this.ltC.finish();
        }
    }

    public String dkr() {
        return this.ltR;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dks() {
        return this.lud;
    }

    public void uq(boolean z) {
        this.ltS = z;
    }

    public boolean bjk() {
        if (this.lqh != null) {
            return this.lqh.dkX();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.AJ(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.luz).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.luz.getPageActivity(), 2, true, 4);
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
        aVar.b(this.luz).bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds(String str) {
        if (str == null) {
            str = "";
        }
        if (this.luz != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.luz.getPageActivity());
            aVar.AJ(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.luz).bog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.luh.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.luz.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.AJ(this.luz.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.AJ(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.luh.showLoadingDialog();
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
        aVar.b(this.luz).bog();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.Po(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.jlT) {
            this.jlT = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.luh != null) {
                this.luh.onConfigurationChanged(configuration);
            }
            if (this.lul != null) {
                this.lul.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dku() {
        if (this.lqh != null) {
            return this.lqh.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.lqh.getPbData().dhV().loU;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dJN().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dJN().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dJN().remove(i2);
                    list.get(i).dJP();
                    z = true;
                    break;
                }
            }
            list.get(i).Ss(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.lqh.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.dix().getId();
        List<PostData> list = this.lqh.getPbData().dhV().loU;
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
                ArrayList<PostData> diF = pVar.diF();
                postData.Ke(pVar.getTotalCount());
                if (postData.dJN() != null) {
                    postData.dJN().clear();
                    postData.dJN().addAll(diF);
                }
            }
        }
        if (!this.lqh.getIsFromMark()) {
            this.luh.s(this.lqh.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a diM() {
        return this.ltC.diM();
    }

    public boolean diN() {
        if (this.lqh == null) {
            return false;
        }
        return this.lqh.diN();
    }

    public void ur(boolean z) {
        this.ltQ = z;
    }

    public boolean dkv() {
        return this.ltQ;
    }

    public void dkw() {
        if (this.luh != null) {
            this.luh.dmG();
            cyo();
        }
    }

    public PostData dhQ() {
        return this.luh.b(this.lqh.lre, this.lqh.dkW());
    }

    public void onBackPressed() {
        if (this.luI != null && !this.luI.isEmpty()) {
            int size = this.luI.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.luI.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.luI == null) {
                this.luI = new ArrayList();
            }
            if (!this.luI.contains(aVar)) {
                this.luI.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.luI == null) {
                this.luI = new ArrayList();
            }
            if (!this.luI.contains(aVar)) {
                this.luI.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.luI != null) {
            this.luI.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkx() {
        if (this.lqh != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lqh.dkU())) {
            com.baidu.tbadk.BdToken.c.bfy().p(com.baidu.tbadk.BdToken.b.eow, com.baidu.adp.lib.f.b.toLong(this.lqh.dkU(), 0L));
        }
    }

    public bg dky() {
        return this.lua;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pa(String str) {
        if (this.lqh != null && this.lqh.getPbData() != null && this.lqh.getPbData().dhH() != null && this.lqh.getPbData().dhH().bkm()) {
            bx dhH = this.lqh.getPbData().dhH();
            int i = 0;
            if (dhH.bkk()) {
                i = 1;
            } else if (dhH.bkl()) {
                i = 2;
            } else if (dhH.bnz()) {
                i = 3;
            } else if (dhH.bnA()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(str);
            arVar.ak("obj_source", 4);
            arVar.ak("obj_type", i);
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(final int i) {
        com.baidu.tbadk.util.ad.a(new com.baidu.tbadk.util.ac<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: biG */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(PbFragment.this.getContext(), PbFragment.this.djV(), i2, PbFragment.this.lqh);
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
        arVar.ak("obj_locate", 1);
        if (i == 3) {
            arVar.ak("obj_type", 1);
        } else if (i == 8) {
            arVar.ak("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dkz() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dkA() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dkB() {
        return this.ltC;
    }
}
