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
    private com.baidu.adp.lib.d.b<ImageView> dMm;
    private com.baidu.adp.lib.d.b<GifView> dMn;
    private com.baidu.adp.lib.d.b<TextView> dPa;
    private com.baidu.adp.lib.d.b<View> dPb;
    private com.baidu.adp.lib.d.b<LinearLayout> dPc;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPd;
    private LikeModel djT;
    private com.baidu.adp.lib.d.b<TbImageView> djb;
    private ar gQz;
    private VoiceManager goj;
    private com.baidu.tieba.frs.profession.permission.c grK;
    private com.baidu.tieba.f.b gsm;
    public com.baidu.tbadk.core.util.aj hPw;
    private String iEc;
    private PbActivity iGZ;
    public ap iHF;
    private com.baidu.tbadk.core.dialog.i iHG;
    private com.baidu.tbadk.core.dialog.k iHH;
    private boolean iHI;
    private com.baidu.tieba.tbadkCore.data.f iHM;
    private com.baidu.tbadk.editortools.pb.g iHN;
    private com.baidu.tbadk.editortools.pb.e iHO;
    private com.baidu.tieba.frs.profession.permission.c iHQ;
    private EmotionImageData iHR;
    private com.baidu.adp.base.e iHU;
    private com.baidu.tbadk.core.view.d iHV;
    private BdUniqueId iHW;
    private Runnable iHX;
    private com.baidu.adp.widget.ImageView.a iHY;
    private String iHZ;
    private com.baidu.tieba.pb.pb.main.b.b iHb;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iHq;
    private View iHr;
    int iHt;
    private ax iHw;
    private com.baidu.tieba.pb.pb.report.a iHy;
    private boolean iIE;
    private String iIN;
    private com.baidu.tbadk.core.data.p iIO;
    private TbRichTextMemeInfo iIa;
    private List<a> iId;
    public String iIf;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
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
    private static final b.a iIK = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        @Override // com.baidu.tieba.f.b.a
        public void bk(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cln();
            } else {
                com.baidu.tieba.pb.a.b.clm();
            }
        }
    };
    private boolean iHa = false;
    private boolean iHc = false;
    private boolean isPaused = false;
    private boolean ihR = false;
    private boolean iHd = true;
    private int iHe = 0;
    private com.baidu.tbadk.core.dialog.b iHf = null;
    private long fVe = -1;
    private long dDD = 0;
    private long iHg = 0;
    private long createTime = 0;
    private long dDv = 0;
    private boolean iHh = false;
    private com.baidu.tbadk.n.b iHi = null;
    private long iHj = 0;
    private boolean iHk = false;
    private long iHl = 0;
    private int gOc = 1;
    private String dyp = null;
    private boolean iHm = false;
    private boolean isFullScreen = false;
    private String iHn = "";
    private boolean iHo = true;
    private boolean iHp = false;
    private String source = "";
    private int mSkinType = 3;
    int[] iHs = new int[2];
    private int iHu = -1;
    private int iHv = -1;
    private PbInterviewStatusView.a iHx = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.iHB.qk(!PbFragment.this.iHo);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.iEg != null && PbFragment.this.iEg.ayJ()) {
                        PbFragment.this.cmL();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel iEg = null;
    private com.baidu.tbadk.baseEditMark.a iHz = null;
    private ForumManageModel fKw = null;
    private com.baidu.tbadk.coreExtra.model.a daa = null;
    private com.baidu.tieba.pb.data.m iHA = null;
    private ShareSuccessReplyToServerModel gEs = null;
    private an iHB = null;
    private boolean iHC = false;
    private boolean iHD = false;
    private boolean iHE = false;
    private boolean edL = false;
    private boolean iHJ = false;
    private boolean iHK = false;
    private boolean iHL = false;
    private boolean iHP = false;
    public boolean iHS = false;
    private com.baidu.tbadk.editortools.pb.c dys = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOP() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b dyt = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOO() {
            if (PbFragment.this.iHF == null || PbFragment.this.iHF.cqv() == null || !PbFragment.this.iHF.cqv().cUc()) {
                return !PbFragment.this.yN(com.baidu.tbadk.core.util.aj.cZV);
            }
            PbFragment.this.showToast(PbFragment.this.iHF.cqv().cUe());
            if (PbFragment.this.iHO != null && (PbFragment.this.iHO.aPe() || PbFragment.this.iHO.aPf())) {
                PbFragment.this.iHO.a(false, PbFragment.this.iHF.cqy());
            }
            PbFragment.this.iHF.qw(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b iHT = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOO() {
            if (PbFragment.this.iHF == null || PbFragment.this.iHF.cqw() == null || !PbFragment.this.iHF.cqw().cUc()) {
                return !PbFragment.this.yN(com.baidu.tbadk.core.util.aj.cZW);
            }
            PbFragment.this.showToast(PbFragment.this.iHF.cqw().cUe());
            if (PbFragment.this.iHB != null && PbFragment.this.iHB.cpg() != null && PbFragment.this.iHB.cpg().cml() != null && PbFragment.this.iHB.cpg().cml().aPf()) {
                PbFragment.this.iHB.cpg().cml().a(PbFragment.this.iHF.cqy());
            }
            PbFragment.this.iHF.qx(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean goW = false;
    private int iIb = 0;
    private int iIc = -1;
    public int iIe = 0;
    private final a iIg = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.iHB != null && PbFragment.this.iHB.cpg() != null) {
                s cpg = PbFragment.this.iHB.cpg();
                if (cpg.cmj()) {
                    cpg.cmi();
                    return true;
                }
            }
            if (PbFragment.this.iHB != null && PbFragment.this.iHB.cqe()) {
                PbFragment.this.iHB.cqf();
                return true;
            }
            return false;
        }
    };
    private final x.a iIh = new x.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void onSuccess(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.iHB.showToast(str);
            }
        }
    };
    private final CustomMessageListener iIi = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iEg != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.iHO != null) {
                    PbFragment.this.iHB.qp(PbFragment.this.iHO.aOX());
                }
                PbFragment.this.iHB.cpi();
                PbFragment.this.iHB.cpW();
            }
        }
    };
    CustomMessageListener gpy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.iEg.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.iHB != null && PbFragment.this.iEg != null) {
                    PbFragment.this.iHB.b(PbFragment.this.iEg.getPbData(), PbFragment.this.iEg.cnx(), PbFragment.this.iEg.cnU(), PbFragment.this.iHB.getSkinType());
                }
                if (PbFragment.this.iHB != null && PbFragment.this.iHB.cpz() != null) {
                    PbFragment.this.iHB.cpz().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener iIj = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.iHB != null) {
                    if (booleanValue) {
                        PbFragment.this.iHB.bWq();
                    } else {
                        PbFragment.this.iHB.bWp();
                    }
                }
            }
        }
    };
    private CustomMessageListener iIk = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.iHO != null) {
                    PbFragment.this.iHB.qp(PbFragment.this.iHO.aOX());
                }
                PbFragment.this.iHB.qr(false);
            }
        }
    };
    private CustomMessageListener iIl = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener iIm = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iHB != null && PbFragment.this.iHB.cpz() != null) {
                PbFragment.this.iHB.cpz().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener htw = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener gpv = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.cnc();
            }
        }
    };
    private View.OnClickListener dza = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.dyp);
        }
    };
    private CustomMessageListener iIn = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                ar.a aVar = new ar.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.thumbnailUrl = abVar.thumbnailUrl;
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEg.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.iEg.cnL() != null && PbFragment.this.iEg.cnL().getUserIdLong() == abVar.toUserId) {
                        PbFragment.this.iHB.a(abVar.sendCount, PbFragment.this.iEg.getPbData(), PbFragment.this.iEg.cnx(), PbFragment.this.iEg.cnU());
                    }
                    if (pbData.cku() != null && pbData.cku().size() >= 1 && pbData.cku().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cku().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEg.cnw(), 0L);
                        if (j == abVar.postId && j2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.ar cLg = pbData.cku().get(0).cLg();
                            if (cLg == null) {
                                cLg = new com.baidu.tbadk.core.data.ar();
                            }
                            ArrayList<ar.a> aBk = cLg.aBk();
                            if (aBk == null) {
                                aBk = new ArrayList<>();
                            }
                            aBk.add(0, aVar);
                            cLg.setTotal(abVar.sendCount + cLg.getTotal());
                            cLg.w(aBk);
                            pbData.cku().get(0).a(cLg);
                            PbFragment.this.iHB.cpz().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gFz = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                PbFragment.this.FN((String) customResponsedMessage.getData());
                PbFragment.this.iEg.cnQ();
                if (PbFragment.this.iHB.cpz() != null) {
                    PbFragment.this.iHB.o(PbFragment.this.iEg.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a iIo = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cqN()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a iIp = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onSuccess(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.iHB != null) {
                PbFragment.this.iHB.dH(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean iIq = false;
    private PraiseModel iIr = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void xq(String str) {
            PbFragment.this.iIq = false;
            if (PbFragment.this.iIr != null) {
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEg.getPbData();
                if (pbData.cks().aBX().getIsLike() == 1) {
                    PbFragment.this.tI(0);
                } else {
                    PbFragment.this.tI(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cks()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.iIq = false;
            if (PbFragment.this.iIr != null && str != null) {
                if (AntiHelper.bb(i, str)) {
                    AntiHelper.bn(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a iIs = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void pQ(boolean z) {
            PbFragment.this.pP(z);
            if (PbFragment.this.iHB.cqk() != null && z) {
                PbFragment.this.iHB.qk(false);
            }
            PbFragment.this.iHB.qm(z);
        }
    };
    private CustomMessageListener dae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().dnT != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().dnT, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.ckz().aCm() != null && PbFragment.this.ckz().aCm().getGodUserData() != null) {
                            PbFragment.this.ckz().aCm().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().cks() != null && PbFragment.this.iEg.getPbData().cks().aCm() != null) {
                            PbFragment.this.iEg.getPbData().cks().aCm().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h gnr = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.iGZ.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a iIt = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.iHB.bqp();
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
                    com.baidu.tieba.j.a.bMC();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c dqJ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cmu();
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
                        if (PbFragment.this.iHB.cms() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").cy("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.clo() != null && PbFragment.this.clo().gQU != null) {
                                PbFragment.this.clo().gQU.onClick(view);
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
                if (PbFragment.this.iHO != null) {
                    PbFragment.this.iHB.qp(PbFragment.this.iHO.aOX());
                }
                PbFragment.this.iHB.cpi();
                PbFragment.this.iHB.cpW();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener iIu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iHW) {
                PbFragment.this.iHB.bqp();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEg.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.ckF().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iHV.showSuccessToast(PbFragment.this.iHU.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.iHU.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.vq(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cmZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.iHU.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.iHV.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iIv = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iHW) {
                PbFragment.this.iHB.bqp();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iHV.showSuccessToast(PbFragment.this.iHU.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.iHU.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.iHV.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iHW) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.iHB.bqp();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.kuE;
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
                    PbFragment.this.iHB.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener iIx = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iHB.cpj() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cmu();
            }
        }
    };
    private CustomMessageListener gpF = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.goW = true;
                }
            }
        }
    };
    public a.b isS = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bEj();
            com.baidu.tbadk.core.data.ap pageData = PbFragment.this.iEg.getPageData();
            int pageNum = PbFragment.this.iHB.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aBd()) {
                PbFragment.this.iHB.cpW();
                PbFragment.this.bEi();
                PbFragment.this.iHB.cpD();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.iEg.yR(PbFragment.this.iHB.getPageNum());
                    if (PbFragment.this.iHb != null) {
                        PbFragment.this.iHb.showFloatingView();
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
    public final View.OnClickListener gqo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
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
                    if (view == PbFragment.this.iHB.cpS()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.iEg.pV(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.iHB.cpE();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.iHB.iNI.cra() == null || view != PbFragment.this.iHB.iNI.cra().coJ()) {
                        if (view == PbFragment.this.iHB.iNI.dFJ) {
                            if (PbFragment.this.iHB.qo(PbFragment.this.iEg.cnC())) {
                                PbFragment.this.bEi();
                                return;
                            }
                            PbFragment.this.iHd = false;
                            PbFragment.this.iHc = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.iGZ, PbFragment.this.iHB.iNI.dFJ);
                            PbFragment.this.iGZ.finish();
                        } else if (view != PbFragment.this.iHB.cpB() && (PbFragment.this.iHB.iNI.cra() == null || (view != PbFragment.this.iHB.iNI.cra().coI() && view != PbFragment.this.iHB.iNI.cra().coG()))) {
                            if (view == PbFragment.this.iHB.cqa()) {
                                if (PbFragment.this.iEg != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEg.getPbData().cks().aCl().getLink());
                                }
                            } else if (view != PbFragment.this.iHB.iNI.iTL) {
                                if (view == PbFragment.this.iHB.iNI.iTM) {
                                    if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                        ArrayList<PostData> cku = PbFragment.this.iEg.getPbData().cku();
                                        if ((cku == null || cku.size() <= 0) && PbFragment.this.iEg.cnx()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").cy("tid", PbFragment.this.iEg.cnw()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", PbFragment.this.iEg.getForumId()));
                                        if (!PbFragment.this.iHB.cqp()) {
                                            PbFragment.this.iHB.cpi();
                                        }
                                        PbFragment.this.cmD();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.iHB.pF(true);
                                        PbFragment.this.iHB.cpi();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.iHB.bWq();
                                            PbFragment.this.bEi();
                                            PbFragment.this.iHB.cpD();
                                            PbFragment.this.iEg.FU(PbFragment.this.cmP());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.iHB.iNI.cra() == null || view != PbFragment.this.iHB.iNI.cra().coF()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.iHB.iNI.cra() != null && view == PbFragment.this.iHB.iNI.cra().coE()) {
                                            PbFragment.this.iHB.iNI.arS();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.iHB.iNI.cra() == null || view != PbFragment.this.iHB.iNI.cra().coC()) {
                                                if ((PbFragment.this.iHB.iNI.cra() == null || view != PbFragment.this.iHB.iNI.cra().coL()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.iHB.iNI.cra() == null || view != PbFragment.this.iHB.iNI.cra().coD()) {
                                                        if (PbFragment.this.iHB.iNI.cra() == null || view != PbFragment.this.iHB.iNI.cra().coM()) {
                                                            if (PbFragment.this.iHB.cqk() == view) {
                                                                if (PbFragment.this.iHB.cqk().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.e pbData2 = PbFragment.this.iEg.getPbData();
                                                                    if (pbData2 != null && pbData2.cks() != null && pbData2.cks().aBS() != null) {
                                                                        String aBJ = pbData2.cks().aBS().aBJ();
                                                                        if (StringUtils.isNull(aBJ)) {
                                                                            aBJ = pbData2.cks().aBS().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").cy("obj_id", aBJ));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.eD("c10725", null);
                                                                }
                                                                PbFragment.this.cmW();
                                                            } else if (PbFragment.this.iHB.iNI.cra() == null || view != PbFragment.this.iHB.iNI.cra().coK()) {
                                                                if (PbFragment.this.iHB.iNI.cra() != null && view == PbFragment.this.iHB.iNI.cra().coH()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.iHB.b(PbFragment.this.iEg.getPbData(), PbFragment.this.iEg.cnx(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.iHB.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.iHB.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.iHB.iNI.arS();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.cy("tid", PbFragment.this.iEg.cnw());
                                                                        anVar.cy("fid", PbFragment.this.iEg.getForumId());
                                                                        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.X("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                                                            PbFragment.this.iHB.cpW();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cLk() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.khp != null) {
                                                                                    com.baidu.tbadk.core.util.an aGw = postData.khp.aGw();
                                                                                    aGw.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aGw.X("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aGw.X("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aGw);
                                                                                }
                                                                                String cnw = PbFragment.this.iEg.cnw();
                                                                                String id = postData.getId();
                                                                                int i3 = 0;
                                                                                if (PbFragment.this.iEg.getPbData() != null) {
                                                                                    i3 = PbFragment.this.iEg.getPbData().ckE();
                                                                                }
                                                                                PbFragment.this.bEi();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a FS = PbFragment.this.FS(id);
                                                                                    if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && FS != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnw, id, "pb", true, null, true, null, i3, postData.crX(), PbFragment.this.iEg.getPbData().getAnti(), false, postData.aCm().getIconInfo()).addBigImageData(FS.iEl, FS.iEm, FS.iEn, FS.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.iEg.cof());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.iEg.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.iEg.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.iEg.cnE());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a FS2 = PbFragment.this.FS(id);
                                                                                    if (postData != null && PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && FS2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnw, id, "pb", true, null, false, null, i3, postData.crX(), PbFragment.this.iEg.getPbData().getAnti(), false, postData.aCm().getIconInfo()).addBigImageData(FS2.iEl, FS2.iEm, FS2.iEn, FS2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.iEg.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.iEg.cnE());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.iEg.cof());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.iEg.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").X("obj_locate", 3).cy("fid", PbFragment.this.iEg.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.iEg != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.cy("tid", PbFragment.this.iEg.cnw());
                                                                        anVar2.cy("fid", PbFragment.this.iEg.getForumId());
                                                                        anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.X("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (postData2.khp != null) {
                                                                                    com.baidu.tbadk.core.util.an aGw2 = postData2.khp.aGw();
                                                                                    aGw2.delete("obj_locate");
                                                                                    aGw2.X("obj_locate", 8);
                                                                                    TiebaStatic.log(aGw2);
                                                                                }
                                                                                if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                                                                    String cnw2 = PbFragment.this.iEg.cnw();
                                                                                    String id2 = postData2.getId();
                                                                                    int i4 = 0;
                                                                                    if (PbFragment.this.iEg.getPbData() != null) {
                                                                                        i4 = PbFragment.this.iEg.getPbData().ckE();
                                                                                    }
                                                                                    PbActivity.a FS3 = PbFragment.this.FS(id2);
                                                                                    if (FS3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnw2, id2, "pb", true, null, false, null, i4, postData2.crX(), PbFragment.this.iEg.getPbData().getAnti(), false, postData2.aCm().getIconInfo()).addBigImageData(FS3.iEl, FS3.iEm, FS3.iEn, FS3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.iEg.cof());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.iEg.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.iEg.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.iEg.cnE());
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
                                                                    if (PbFragment.this.iEg != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.cy("tid", PbFragment.this.iEg.cnw());
                                                                        anVar3.cy("fid", PbFragment.this.iEg.getForumId());
                                                                        anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.X("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (postData3.khp != null) {
                                                                                    com.baidu.tbadk.core.util.an aGw3 = postData3.khp.aGw();
                                                                                    aGw3.delete("obj_locate");
                                                                                    aGw3.X("obj_locate", 8);
                                                                                    TiebaStatic.log(aGw3);
                                                                                }
                                                                                if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.cmr().cpf() != null && postData3.aCm() != null && postData3.cKY() != 1) {
                                                                                    if (PbFragment.this.cmr().cpg() != null) {
                                                                                        PbFragment.this.cmr().cpg().cmh();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                                                                    lVar.a(PbFragment.this.iEg.getPbData().getForum());
                                                                                    lVar.setThreadData(PbFragment.this.iEg.getPbData().cks());
                                                                                    lVar.f(postData3);
                                                                                    PbFragment.this.cmr().cpf().d(lVar);
                                                                                    PbFragment.this.cmr().cpf().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.aCm().getUserId(), "");
                                                                                    if (PbFragment.this.iHO != null) {
                                                                                        PbFragment.this.iHB.qp(PbFragment.this.iHO.aOX());
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
                                                                } else if (view != PbFragment.this.iHB.clJ()) {
                                                                    if (view == PbFragment.this.iHB.iNI.crb()) {
                                                                        PbFragment.this.iHB.cpK();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (boVar = (bo) view.getTag()) != null && !StringUtils.isNull(boVar.aEs())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.aGE().b(PbFragment.this.getPageContext(), new String[]{boVar.aEs()});
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").cy("tid", PbFragment.this.iEg.iJU));
                                                                                    }
                                                                                    if (PbFragment.this.iHH == null) {
                                                                                        PbFragment.this.iHH = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.iHH.a(PbFragment.this.iIJ);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cv(view);
                                                                                    if (!PbFragment.this.cv(view) || PbFragment.this.iHY == null || !PbFragment.this.iHY.isGif()) {
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
                                                                                        if (postData4.cLa() != null && postData4.cLa().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iHH);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar4.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar4);
                                                                                        }
                                                                                        PbFragment.this.hhx = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.iEg.getPbData().ayJ()) {
                                                                                        String ayI = PbFragment.this.iEg.getPbData().ayI();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(ayI) && ayI.equals(postData4.getId())) {
                                                                                            z = true;
                                                                                            if (!z) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iHH);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iHH);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.hhx);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z4 && z3) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iHH);
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
                                                                                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHH);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHH);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iHH);
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
                                                                                                    if (PbFragment.this.iEg.getPbData().ckE() == 1002 && !z2) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHH);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHH);
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
                                                                                            PbFragment.this.iHH.az(arrayList);
                                                                                            PbFragment.this.iHG = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iHH);
                                                                                            PbFragment.this.iHG.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z = false;
                                                                                    if (!z) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.hhx);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.iHH.az(arrayList);
                                                                                    PbFragment.this.iHG = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iHH);
                                                                                    PbFragment.this.iHG.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().cks() != null && PbFragment.this.iEg.getPbData().cks().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.iEg.getPbData().cks().getActUrl());
                                                                                if (PbFragment.this.iEg.getPbData().cks().aCW() != 1) {
                                                                                    if (PbFragment.this.iEg.getPbData().cks().aCW() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str2 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").cy("fid", PbFragment.this.iEg.getPbData().getForumId()).cy("tid", PbFragment.this.iEg.getPbData().getThreadId()).cy("lotterytail", StringUtils.string(str2, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.iEg.getPbData().getThreadId().equals(str2)) {
                                                                                    PbFragment.this.iHB.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.iHB.cpi();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.cmA() == 1 && PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").cy("fid", PbFragment.this.iEg.getPbData().getForumId()).cy("tid", PbFragment.this.iEg.getPbData().getThreadId()).cy("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.cmA() == 1 && PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").cy("fid", PbFragment.this.iEg.getPbData().getForumId()).cy("tid", PbFragment.this.iEg.getPbData().getThreadId()).cy("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.cmR();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.cmS();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().ckK() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData3 = PbFragment.this.iEg.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").cy("fid", pbData3.getForumId()));
                                                                                ba.aGE().b(PbFragment.this.getPageContext(), new String[]{pbData3.ckK().ckU()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().ckK() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData4 = PbFragment.this.iEg.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cy("fid", pbData4.getForumId()));
                                                                                ba.aGE().b(PbFragment.this.getPageContext(), new String[]{pbData4.ckK().ckU()});
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.iIb >= 0) {
                                                                                if (PbFragment.this.iEg != null) {
                                                                                    PbFragment.this.iEg.cog();
                                                                                }
                                                                                if (PbFragment.this.iEg != null && PbFragment.this.iHB.cpz() != null) {
                                                                                    PbFragment.this.iHB.cpz().a(PbFragment.this.iEg.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.iIb = 0;
                                                                                if (PbFragment.this.iEg != null) {
                                                                                    PbFragment.this.iHB.getListView().setSelection(PbFragment.this.iEg.coj());
                                                                                    PbFragment.this.iEg.cr(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.cmx();
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
                                                                            if (PbFragment.this.iHB.getListView() != null && PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.iHB.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.iHB.getListView().getChildAt(0);
                                                                                int top2 = childAt == null ? 0 : childAt.getTop();
                                                                                boolean aHI = PbFragment.this.iEg.getPbData().aHI();
                                                                                boolean z7 = PbFragment.this.iHB.cph() != null && PbFragment.this.iHB.cph().bik();
                                                                                boolean cpT = PbFragment.this.iHB.cpT();
                                                                                boolean z8 = firstVisiblePosition == 0 && top2 == 0;
                                                                                int i5 = 0;
                                                                                if (aHI && PbFragment.this.iHB.cph() != null && PbFragment.this.iHB.cph().bcI() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.iHB.cph().cqK();
                                                                                    z8 = firstVisiblePosition == 0 && (top2 == equipmentWidth || top2 == PbFragment.this.iHB.cph().bcI().getHeight() - PbFragment.this.iHB.cph().cqK());
                                                                                    i5 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.FT("c13568");
                                                                                if ((PbFragment.this.iEg.getPbData().cks() != null && PbFragment.this.iEg.getPbData().cks().aCd() <= 0) || (cpT && z8)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.cmx();
                                                                                        if (PbFragment.this.iEg.getPbData().cks().aCm() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEg.iJU).cy("fid", PbFragment.this.iEg.getPbData().getForumId()).X("obj_locate", 2).cy("uid", PbFragment.this.iEg.getPbData().cks().aCm().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z9 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (aHI) {
                                                                                        if (PbFragment.this.iHB.iOP != null && PbFragment.this.iHB.iOP.iPT != null && PbFragment.this.iHB.iOP.iPT.getView() != null) {
                                                                                            if (PbFragment.this.iHB.iOP.iPT.getView().getParent() == null) {
                                                                                                z9 = firstVisiblePosition >= PbFragment.this.cmH();
                                                                                            } else {
                                                                                                int i6 = 0;
                                                                                                if (PbFragment.this.iHB.cph() != null && PbFragment.this.iHB.cph().bcI() != null) {
                                                                                                    i6 = PbFragment.this.iHB.cph().bcI().getBottom();
                                                                                                }
                                                                                                z9 = PbFragment.this.iHB.iOP.iPT.getView().getTop() <= i6;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.iHB.cpq() != null) {
                                                                                        z9 = PbFragment.this.iHB.cpq().getVisibility() == 0;
                                                                                        if (!z9 && PbFragment.this.iHB.iOP != null && PbFragment.this.iHB.iOP.iPT != null && PbFragment.this.iHB.iOP.iPT.getView() != null && PbFragment.this.iHB.iOP.iPT.getView().getParent() != null && PbFragment.this.iHB.iNI != null && PbFragment.this.iHB.iNI.mNavigationBar != null) {
                                                                                            z9 = PbFragment.this.iHB.iOP.iPT.getView().getTop() - PbFragment.this.iHB.iNI.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z9 || cpT) {
                                                                                        PbFragment.this.iHu = firstVisiblePosition;
                                                                                        PbFragment.this.iHv = top2;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top2 < (-equipmentHeight))) {
                                                                                            PbFragment.this.iHB.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                            PbFragment.this.iHB.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.iHB.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.iHu > 0) {
                                                                                        if (PbFragment.this.iHB.getListView().getChildAt(PbFragment.this.iHu) != null) {
                                                                                            PbFragment.this.iHB.getListView().smoothScrollToPosition(PbFragment.this.iHu, PbFragment.this.iHv, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iHB.getListView().setSelectionFromTop(PbFragment.this.iHu, PbFragment.this.iHv + equipmentHeight);
                                                                                            PbFragment.this.iHB.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int cmH = PbFragment.this.cmH();
                                                                                        if (PbFragment.this.cmG() != -1) {
                                                                                            cmH--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (cmH < 0) {
                                                                                            i = PbFragment.this.iHB.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.iHB.getListView().getData()) - 1);
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            i = cmH;
                                                                                            i2 = dimens;
                                                                                        }
                                                                                        if (z7) {
                                                                                            i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!aHI || PbFragment.this.iHB.cph() == null) {
                                                                                            if (PbFragment.this.iHB.iNI != null && PbFragment.this.iHB.iNI.mNavigationBar != null) {
                                                                                                i2 += PbFragment.this.iHB.iNI.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i2 += PbFragment.this.iHB.cph().cqJ();
                                                                                        }
                                                                                        if (PbFragment.this.iHB.iOP == null || PbFragment.this.iHB.iOP.iPT == null || PbFragment.this.iHB.iOP.iPT.getView() == null || PbFragment.this.iHB.iOP.iPT.getView().getParent() == null) {
                                                                                            PbFragment.this.iHB.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                            PbFragment.this.iHB.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z7) {
                                                                                            PbFragment.this.iHB.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iHB.getListView().smoothScrollBy(PbFragment.this.iHB.iOP.iPT.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.iEg.getPbData().cks() != null && PbFragment.this.iEg.getPbData().cks().aCm() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEg.iJU).cy("fid", PbFragment.this.iEg.getPbData().getForumId()).X("obj_locate", 2).cy("uid", PbFragment.this.iEg.getPbData().cks().aCm().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.iEg.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.iEg.cof() == 3) {
                                                                                    PbFragment.this.iGZ.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.iEg.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.cy("tid", PbFragment.this.iEg.cnw());
                                                                                anVar4.cy("fid", PbFragment.this.iEg.getForumId());
                                                                                anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar = (bj) view.getTag();
                                                                                if (PbFragment.this.iEg.cof() == 3 && PbFragment.this.clp() && PbFragment.this.iEg.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.iEg.getPbData().ckL())) {
                                                                                    PbFragment.this.iGZ.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar.aCr(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
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
                                                                            if (PbFragment.this.iEg != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.cy("tid", PbFragment.this.iEg.cnw());
                                                                                anVar6.cy("fid", PbFragment.this.iEg.getForumId());
                                                                                anVar6.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.X("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData5 = PbFragment.this.iEg.getPbData();
                                                                                if (PbFragment.this.iHA == null) {
                                                                                    PbFragment.this.iHA = new com.baidu.tieba.pb.data.m(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").s("forum_id", j2).aGx();
                                                                                PbFragment.this.registerListener(PbFragment.this.iIz);
                                                                                PbFragment.this.iHA.D(j, j2);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").cy("fid", PbFragment.this.iEg.getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", smartApp.name).s("obj_id", smartApp.swan_app_id.longValue()).cy("obj_source", "PB_card").cy("tid", PbFragment.this.iEg.cnw()).X("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar2 = (bj) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar2.aCr(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 9).X("obj_locate", 9).s("obj_id", bjVar2.getFid()).cy("tid", bjVar2.getId()).X("thread_type", bjVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bj) && PbFragment.this.checkUpIsLogin()) {
                                                                                bj bjVar3 = (bj) view.getTag();
                                                                                if (PbFragment.this.djT != null) {
                                                                                    PbFragment.this.djT.eC(bjVar3.aCr(), String.valueOf(bjVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 10).X("obj_locate", 11).s("obj_id", bjVar3.getFid()).cy("tid", bjVar3.getId()).X("thread_type", bjVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEg.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEg.cnw(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.iEg.getPbData().cks().aCG())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.iHB.cpW();
                                                                SparseArray<Object> b3 = PbFragment.this.iHB.b(PbFragment.this.iEg.getPbData(), PbFragment.this.iEg.cnx(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEg.getPbData().getForum().getId(), PbFragment.this.iEg.getPbData().getForum().getName(), PbFragment.this.iEg.getPbData().cks().getId(), String.valueOf(PbFragment.this.iEg.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 0).X("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 1).X("obj_source", 1));
                                                            }
                                                            PbFragment.this.iHB.iNI.cqZ();
                                                        }
                                                    } else if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().cks() != null) {
                                                        PbFragment.this.iHB.iNI.arS();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.FP(PbFragment.this.iEg.getPbData().cks().aCC());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.iHB.cpW();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.iEg.cnO()));
                                                            return;
                                                        }
                                                        PbFragment.this.bEi();
                                                        PbFragment.this.iHB.cpD();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.iEg.getPbData().iBB == null || PbFragment.this.iEg.getPbData().iBB.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.iEg.getPbData().iBB.size()];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int i8 = i7;
                                                                if (i8 >= PbFragment.this.iEg.getPbData().iBB.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i8] = PbFragment.this.iEg.getPbData().iBB.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i7 = i8 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                int i10 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.iEg.getSortType() == 1 && i9 == 1) {
                                                                    i10 = 0;
                                                                } else if (PbFragment.this.iEg.getSortType() == 2 && i9 == 0) {
                                                                    i10 = 1;
                                                                } else if (PbFragment.this.iEg.getSortType() != 3 || i9 == 2) {
                                                                    i10 = (i9 != 2 || PbFragment.this.iEg.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").X("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).X("obj_type", i10));
                                                                if (PbFragment.this.iEg.getPbData().iBB != null && PbFragment.this.iEg.getPbData().iBB.size() > i9) {
                                                                    i9 = PbFragment.this.iEg.getPbData().iBB.get(i9).sort_type.intValue();
                                                                }
                                                                boolean yW = PbFragment.this.iEg.yW(i9);
                                                                view.setTag(Integer.valueOf(PbFragment.this.iEg.cnO()));
                                                                if (yW) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.iHB.qf(true);
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
                                                PbFragment.this.iHB.cpW();
                                                if (PbFragment.this.clz().getPbData().iBC != 2) {
                                                    if (PbFragment.this.iEg.getPageData() != null) {
                                                        PbFragment.this.iHB.a(PbFragment.this.iEg.getPageData(), PbFragment.this.isS);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.iEg.getPbData()) != null) {
                                            bj cks = pbData.cks();
                                            if (cks != null && cks.aCm() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEg.iJU).cy("fid", pbData.getForumId()).X("obj_locate", 4).cy("uid", cks.aCm().getUserId()));
                                            }
                                            int i9 = 1;
                                            if (cks != null) {
                                                if (cks.aBb()) {
                                                    i9 = 2;
                                                } else if (cks.aBc()) {
                                                    i9 = 3;
                                                } else if (cks.aEe()) {
                                                    i9 = 4;
                                                } else if (cks.aEf()) {
                                                    i9 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.cy("tid", PbFragment.this.iEg.cnw());
                                            anVar7.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.cy("fid", PbFragment.this.iEg.getForumId());
                                            if (view.getId() == R.id.share_num_container) {
                                                anVar7.X("obj_locate", 5);
                                            } else {
                                                anVar7.X("obj_locate", 6);
                                            }
                                            anVar7.X("obj_name", i9);
                                            anVar7.X("obj_type", 1);
                                            if (cks != null) {
                                                if (cks.aBb()) {
                                                    anVar7.X("obj_type", 10);
                                                } else if (cks.aBc()) {
                                                    anVar7.X("obj_type", 9);
                                                } else if (cks.aEf()) {
                                                    anVar7.X("obj_type", 8);
                                                } else if (cks.aEe()) {
                                                    anVar7.X("obj_type", 7);
                                                } else if (cks.isShareThread) {
                                                    anVar7.X("obj_type", 6);
                                                } else if (cks.threadType == 0) {
                                                    anVar7.X("obj_type", 1);
                                                } else if (cks.threadType == 40) {
                                                    anVar7.X("obj_type", 2);
                                                } else if (cks.threadType == 49) {
                                                    anVar7.X("obj_type", 3);
                                                } else if (cks.threadType == 54) {
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
                                                ArrayList<PostData> cku2 = PbFragment.this.iEg.getPbData().cku();
                                                if ((cku2 != null && cku2.size() > 0) || !PbFragment.this.iEg.cnx()) {
                                                    PbFragment.this.iHB.cpW();
                                                    PbFragment.this.bEi();
                                                    if (pbData.ckK() != null && !StringUtils.isNull(pbData.ckK().aAE(), true)) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cy("fid", PbFragment.this.iEg.getPbData().getForumId()));
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                    if (!AntiHelper.d(PbFragment.this.getContext(), cks)) {
                                                        if (PbFragment.this.iHB != null) {
                                                            PbFragment.this.iHB.cpZ();
                                                            PbFragment.this.iHB.t(pbData);
                                                        }
                                                        int i10 = 6;
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.iHB.showLoadingDialog();
                                                            PbFragment.this.iEg.coa().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
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
                                        PbFragment.this.iHB.cpW();
                                        if (PbFragment.this.iHB.iNI.cra() != null && view == PbFragment.this.iHB.iNI.cra().coF() && !PbFragment.this.iHB.cqp()) {
                                            PbFragment.this.iHB.cpi();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bEi();
                                            PbFragment.this.iHB.cpD();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                v = PbFragment.this.iEg.v(true, PbFragment.this.cmP());
                                            } else {
                                                v = view.getId() == R.id.reply_title ? PbFragment.this.iEg.v(false, PbFragment.this.cmP()) : PbFragment.this.iEg.FU(PbFragment.this.cmP());
                                            }
                                            view.setTag(Boolean.valueOf(v));
                                            if (v) {
                                                PbFragment.this.iHB.pF(true);
                                                PbFragment.this.iHB.bWq();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.iHB.qf(true);
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
                                    PbFragment.this.iHB.cpW();
                                    if (PbFragment.this.yO(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.iEg.yX(PbFragment.this.iHB.cpI()) != null) {
                                        PbFragment.this.cmK();
                                        if (PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().cks() != null && PbFragment.this.iEg.getPbData().cks().aCm() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEg.iJU).cy("fid", PbFragment.this.iEg.getPbData().getForumId()).X("obj_locate", 3).cy("uid", PbFragment.this.iEg.getPbData().cks().aCm().getUserId()));
                                        }
                                        if (PbFragment.this.iEg.getPbData().cks() != null && PbFragment.this.iEg.getPbData().cks().aCm() != null && PbFragment.this.iEg.getPbData().cks().aCm().getUserId() != null && PbFragment.this.iHz != null) {
                                            int g = PbFragment.this.g(PbFragment.this.iEg.getPbData());
                                            bj cks2 = PbFragment.this.iEg.getPbData().cks();
                                            int i11 = 1;
                                            if (cks2.aBb()) {
                                                i11 = 2;
                                            } else if (cks2.aBc()) {
                                                i11 = 3;
                                            } else if (cks2.aEe()) {
                                                i11 = 4;
                                            } else if (cks2.aEf()) {
                                                i11 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cy("tid", PbFragment.this.iEg.iJU).X("obj_locate", 1).cy("obj_id", PbFragment.this.iEg.getPbData().cks().aCm().getUserId()).X("obj_type", PbFragment.this.iHz.ayJ() ? 0 : 1).X("obj_source", g).X("obj_param1", i11));
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
                                if (PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().cks() != null && PbFragment.this.iEg.getPbData().cks().aAZ() && PbFragment.this.iEg.getPbData().cks().aCD() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.iEg.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.iEg.clq()) || PbFragment.this.iEg.getAppealInfo() == null) {
                                        PbFragment.this.iGZ.finish();
                                        return;
                                    }
                                    name = PbFragment.this.iEg.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.iEg.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.iGZ.finish();
                                    return;
                                }
                                String clq = PbFragment.this.iEg.clq();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.iEg.cny() && clq != null && clq.equals(name)) {
                                    PbFragment.this.iGZ.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.iEg.getPbData() != null) {
                                if ((PbFragment.this.iEg.getPbData().ckE() == 1 || PbFragment.this.iEg.getPbData().ckE() == 3) && !PbFragment.this.fKw.cLM()) {
                                    PbFragment.this.iHB.cpW();
                                    int i12 = 0;
                                    if (PbFragment.this.iHB.iNI.cra() == null || view != PbFragment.this.iHB.iNI.cra().coG()) {
                                        if (PbFragment.this.iHB.iNI.cra() == null || view != PbFragment.this.iHB.iNI.cra().coI()) {
                                            if (view == PbFragment.this.iHB.cpB()) {
                                                i12 = 2;
                                            }
                                        } else if (PbFragment.this.iEg.getPbData().cks().aCi() == 1) {
                                            i12 = 3;
                                        } else {
                                            i12 = 6;
                                        }
                                    } else if (PbFragment.this.iEg.getPbData().cks().aCh() == 1) {
                                        i12 = 5;
                                    } else {
                                        i12 = 4;
                                    }
                                    ForumData forum = PbFragment.this.iEg.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.iEg.getPbData().cks().getId();
                                    PbFragment.this.iHB.cpA();
                                    PbFragment.this.fKw.b(id4, name2, id5, i12, PbFragment.this.iHB.cpC());
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
                        PbFragment.this.iHB.cpW();
                        PbFragment.this.bEi();
                        PbFragment.this.iHB.cpD();
                        PbFragment.this.iHB.showLoadingDialog();
                        if (PbFragment.this.iHB.cpq() != null) {
                            PbFragment.this.iHB.cpq().setVisibility(8);
                        }
                        PbFragment.this.iEg.yR(1);
                        if (PbFragment.this.iHb != null) {
                            PbFragment.this.iHb.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cmy = PbFragment.this.cmy();
                        if (!TextUtils.isEmpty(cmy)) {
                            ba.aGE().b(PbFragment.this.getPageContext(), new String[]{cmy});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.cy("tid", PbFragment.this.iEg.cnw());
                anVar8.cy("fid", PbFragment.this.iEg.getForumId());
                anVar8.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.X("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.iHk) {
                    PbFragment.this.iHk = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.cmr().cpf() != null && postData5.aCm() != null && postData5.cKY() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cmr().cpg() != null) {
                                PbFragment.this.cmr().cpg().cmh();
                            }
                            com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                            lVar2.a(PbFragment.this.iEg.getPbData().getForum());
                            lVar2.setThreadData(PbFragment.this.iEg.getPbData().cks());
                            lVar2.f(postData5);
                            PbFragment.this.cmr().cpf().d(lVar2);
                            PbFragment.this.cmr().cpf().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.aCm().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iEg.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.iHO != null) {
                                PbFragment.this.iHB.qp(PbFragment.this.iHO.aOX());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iEg.getPbData() != null) {
                    anVar.cy("fid", PbFragment.this.iEg.getPbData().getForumId());
                }
                anVar.cy("tid", PbFragment.this.iEg.cnw());
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bEi();
            PbFragment.this.iHB.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.clz() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.clz().FX(postWriteCallBackData.getPostId());
                    PbFragment.this.iIb = PbFragment.this.iHB.cpm();
                    PbFragment.this.iEg.cr(PbFragment.this.iIb, PbFragment.this.iHB.cpn());
                }
                PbFragment.this.iHB.cpW();
                PbFragment.this.iHF.cqu();
                if (PbFragment.this.iHO != null) {
                    PbFragment.this.iHB.qp(PbFragment.this.iHO.aOX());
                }
                PbFragment.this.iHB.cpe();
                PbFragment.this.iHB.qr(true);
                PbFragment.this.iEg.cnQ();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.iEg.getHostMode()) {
                            com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEg.getPbData();
                            if (pbData != null && pbData.cks() != null && pbData.cks().aCm() != null && (userId = pbData.cks().aCm().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.iEg.cnH()) {
                                PbFragment.this.iHB.cpD();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.iEg.cnH()) {
                            PbFragment.this.iHB.cpD();
                        }
                    } else if (floor != null) {
                        PbFragment.this.iHB.o(PbFragment.this.iEg.getPbData());
                    }
                    if (PbFragment.this.iEg.cnB()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").cy("tid", PbFragment.this.iEg.cnw()));
                    }
                    PbFragment.this.cmB();
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.iHO.aPe() || PbFragment.this.iHO.aPf()) {
                    PbFragment.this.iHO.a(false, postWriteCallBackData);
                }
                PbFragment.this.iHF.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.hPw != null) {
                    PbFragment.this.hPw.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d iIy = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                    anVar.cy("fid", PbFragment.this.iEg.getPbData().getForumId());
                }
                if (PbFragment.this.iEg != null) {
                    anVar.cy("tid", PbFragment.this.iEg.cnw());
                }
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.iHF != null) {
                    PbFragment.this.iHF.cqt();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.hPw != null) {
                    PbFragment.this.hPw.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.iHF != null) {
                if (PbFragment.this.iHB != null && PbFragment.this.iHB.cpg() != null && PbFragment.this.iHB.cpg().cml() != null && PbFragment.this.iHB.cpg().cml().aPf()) {
                    PbFragment.this.iHB.cpg().cml().a(postWriteCallBackData);
                }
                PbFragment.this.iHF.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iIz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cqs;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.iGZ.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.iHB != null && (cqs = PbFragment.this.iHB.cqs()) != null && PbFragment.this.iHB.getListView() != null) {
                            PbFragment.this.iHB.getListView().removeHeaderView(cqs);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a iIA = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mm;
            if (!z || eVar == null || eVar.ckC() != null || com.baidu.tbadk.core.util.v.getCount(eVar.cku()) >= 1) {
                PbFragment.this.ihR = true;
                PbFragment.this.iHB.cpF();
                if (eVar == null || !eVar.cky()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.iHB.getView());
                }
                PbFragment.this.iHB.bWp();
                if (PbFragment.this.isFullScreen || PbFragment.this.iHB.cqp()) {
                    PbFragment.this.iHB.cqg();
                } else if (!PbFragment.this.iHB.cqd()) {
                    PbFragment.this.iHB.qr(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.edL = true;
                }
                if (eVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.iHB.getView());
                    PbFragment.this.iHB.cpO();
                }
                if (z && eVar != null) {
                    bj cks = eVar.cks();
                    if (cks == null || !cks.aEg()) {
                        PbFragment.this.d(PbFragment.this.iHN);
                    } else {
                        cni();
                    }
                    PbFragment.this.iHB.cpg().setPbData(eVar);
                    PbFragment.this.iHB.bgw();
                    if (cks != null && cks.aDt() != null) {
                        PbFragment.this.a(cks.aDt());
                    }
                    if (PbFragment.this.iHO != null) {
                        PbFragment.this.iHB.qp(PbFragment.this.iHO.aOX());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                    if (eVar.cku() != null && eVar.cku().size() >= 1 && eVar.cku().get(0) != null) {
                        PbFragment.this.iEg.FW(eVar.cku().get(0).getId());
                    } else if (eVar.ckC() != null) {
                        PbFragment.this.iEg.FW(eVar.ckC().getId());
                    }
                    if (PbFragment.this.iHO != null) {
                        PbFragment.this.iHO.a(eVar.getAnti());
                        PbFragment.this.iHO.a(eVar.getForum(), eVar.getUserData());
                        PbFragment.this.iHO.setThreadData(cks);
                        PbFragment.this.iHO.a(PbFragment.this.iEg.cnL(), PbFragment.this.iEg.cnw(), PbFragment.this.iEg.coc());
                        if (cks != null) {
                            PbFragment.this.iHO.gI(cks.aDE());
                        }
                    }
                    if (PbFragment.this.iHz != null) {
                        PbFragment.this.iHz.fm(eVar.ayJ());
                    }
                    if (eVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (eVar.ckQ()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.iHB.qq(PbFragment.this.mIsFromCDN);
                    PbFragment.this.iHB.a(eVar, i2, i3, PbFragment.this.iEg.cnx(), i4, PbFragment.this.iEg.getIsFromMark());
                    PbFragment.this.iHB.d(eVar, PbFragment.this.iEg.cnx());
                    PbFragment.this.iHB.qn(PbFragment.this.iEg.getHostMode());
                    AntiData anti = eVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.dyp = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.dyp) && PbFragment.this.iHO != null && PbFragment.this.iHO.aOr() != null && (mm = PbFragment.this.iHO.aOr().mm(6)) != null && !TextUtils.isEmpty(PbFragment.this.dyp)) {
                            ((View) mm).setOnClickListener(PbFragment.this.dza);
                        }
                    }
                    if (PbFragment.this.iHJ) {
                        PbFragment.this.iHJ = false;
                        final int cmG = PbFragment.this.cmG();
                        if (!eVar.aHI()) {
                            PbFragment.this.iHB.ze(cmG);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cmG, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.iHK) {
                        PbFragment.this.iHK = false;
                        final int cmG2 = PbFragment.this.cmG();
                        final boolean z2 = cmG2 != -1;
                        if (!z2) {
                            cmG2 = PbFragment.this.cmH();
                        }
                        if (PbFragment.this.iHB != null) {
                            if (!eVar.aHI()) {
                                PbFragment.this.iHB.ze(cmG2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cmG2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.iHB.setSelectionFromTop(cmG2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.iHB.setSelectionFromTop(cmG2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.iHB.qs(true);
                                PbFragment.this.iHB.qr(false);
                            }
                        }
                    } else if (PbFragment.this.iHL) {
                        PbFragment.this.iHL = false;
                        PbFragment.this.iHB.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.iHB.cpJ();
                    }
                    PbFragment.this.iEg.a(eVar.getForum(), PbFragment.this.iIo);
                    PbFragment.this.iEg.a(PbFragment.this.iIp);
                    if (PbFragment.this.hPw != null && cks != null && cks.aCm() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cks.aCm());
                        PbFragment.this.hPw.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.edL && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.iEg.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.iEg.getAppealInfo().iBu)) {
                                    PbFragment.this.iHB.a(PbFragment.this.iEg.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.iHB.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.iHB.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.iHB.cqg();
                            PbFragment.this.iHB.cpN();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.iEg.cnw());
                            jSONObject.put("fid", PbFragment.this.iEg.getForumId());
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
                        PbFragment.this.iHB.Gc("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                            arrayList = PbFragment.this.iEg.getPbData().cku();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cKY() != 1)) {
                            PbFragment.this.iHB.Gc(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbFragment.this.cna()) {
                            PbFragment.this.iHB.Gd(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbFragment.this.iHB.Gd(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbFragment.this.iHB.endLoadData();
                }
                if (eVar != null && eVar.iBI && PbFragment.this.dDD == 0) {
                    PbFragment.this.dDD = System.currentTimeMillis() - PbFragment.this.fVe;
                }
                if (!PbFragment.this.clz().cnx() || PbFragment.this.clz().getPbData().getPage().aBj() != 0 || PbFragment.this.clz().cnX()) {
                    PbFragment.this.iHP = true;
                    return;
                }
                return;
            }
            PbFragment.this.iEg.yR(1);
            if (PbFragment.this.iHb != null) {
                PbFragment.this.iHb.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cni() {
            if (PbFragment.this.iEg != null) {
                if (PbFragment.this.iHO == null || !PbFragment.this.iHO.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.iHO = (com.baidu.tbadk.editortools.pb.e) dVar.dV(PbFragment.this.getContext());
                    PbFragment.this.iHO.a(PbFragment.this.iGZ.getPageContext());
                    PbFragment.this.iHO.a(PbFragment.this.dyz);
                    PbFragment.this.iHO.a(PbFragment.this.dys);
                    PbFragment.this.iHO.a(PbFragment.this.iGZ.getPageContext(), PbFragment.this.iGZ.getIntent() == null ? null : PbFragment.this.iGZ.getIntent().getExtras());
                    PbFragment.this.iHO.aOr().gB(true);
                    PbFragment.this.iHB.setEditorTools(PbFragment.this.iHO.aOr());
                    if (!PbFragment.this.iEg.cnC()) {
                        PbFragment.this.iHO.vl(PbFragment.this.iEg.cnw());
                    }
                    if (PbFragment.this.iEg.cod()) {
                        PbFragment.this.iHO.vk(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.iHB != null) {
                        PbFragment.this.iHO.vk(PbFragment.this.iHB.cpk());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
            PbFragment.this.iHB.o(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.aRj().aRk()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.fVe : j;
                if (PbFragment.this.dDD == 0) {
                    PbFragment.this.dDD = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.dDv, PbFragment.this.createTime, PbFragment.this.dDD, z2, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.dDv = 0L;
                if (iVar != null) {
                    iVar.aRg();
                }
                if (z2) {
                    iVar.dDM = currentTimeMillis;
                    iVar.gT(true);
                }
                if (!z2 && PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().cks() != null) {
                    int threadType = PbFragment.this.iEg.getPbData().cks().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iHn, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iHn, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.dDO = currentTimeMillis;
                                iVar2.mL(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.dDO = currentTimeMillis;
                        dVar.mL(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cmC();
            }
        }
    };
    private final a.InterfaceC0374a iIC = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.iHB.cpF();
            if (z) {
                if (PbFragment.this.iHz != null) {
                    PbFragment.this.iHz.fm(z2);
                }
                PbFragment.this.iEg.pX(z2);
                if (PbFragment.this.iEg.ayJ()) {
                    PbFragment.this.cmL();
                } else {
                    PbFragment.this.iHB.o(PbFragment.this.iEg.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.iHz != null) {
                        if (PbFragment.this.iHz.ayM() != null && PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.iEg.getPbData().cks() != null && PbFragment.this.iEg.getPbData().cks().aCm() != null) {
                            MarkData ayM = PbFragment.this.iHz.ayM();
                            MetaData aCm = PbFragment.this.iEg.getPbData().cks().aCm();
                            if (ayM != null && aCm != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aCm.getUserId()) && !aCm.hadConcerned()) {
                                    PbFragment.this.b(aCm);
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
                    PbFragment.this.cmI();
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
                if (PbFragment.this.iHB != null) {
                    PbFragment.this.iHB.cpW();
                    if (PbFragment.this.iHO != null && !PbFragment.this.iHB.cpj()) {
                        PbFragment.this.iHB.qp(PbFragment.this.iHO.aOX());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.iHB.cpi();
                    }
                }
                if (!PbFragment.this.iHh) {
                    PbFragment.this.iHh = true;
                    if (PbFragment.this.iHB != null) {
                        PbFragment.this.iHB.cqc();
                    }
                }
            }
            if (PbFragment.this.iHB != null) {
                PbFragment.this.iHB.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iHb != null) {
                PbFragment.this.iHb.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iHi == null) {
                PbFragment.this.iHi = new com.baidu.tbadk.n.b();
                PbFragment.this.iHi.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.iHi.aRa();
            } else {
                PbFragment.this.iHi.aQZ();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.cJY().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cku;
            if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null && PbFragment.this.iHB != null && PbFragment.this.iHB.cpz() != null) {
                PbFragment.this.iHB.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.iHb != null) {
                    PbFragment.this.iHb.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.iEg.cnT() && (cku = PbFragment.this.iEg.getPbData().cku()) != null && !cku.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.iHB.cpz().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEg.getPbData();
                    if (pbData != null) {
                        if (pbData.ckv() != null && pbData.ckv().hasData()) {
                            headerCount--;
                        }
                        if (pbData.ckw() != null && pbData.ckw().hasData()) {
                            headerCount--;
                        }
                        int size = cku.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d fKB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.fKw.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.iEg.cnQ();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.iVF != 1002 || bVar.eLE) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.iHB.a(1, dVar.mSuccess, dVar.kjg, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.fKw.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.iHB.a(PbFragment.this.fKw.getLoadDataMode(), gVar.mSuccess, gVar.kjg, false);
                            PbFragment.this.iHB.aM(gVar.kjj);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.iHB.a(PbFragment.this.fKw.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c iID = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
    };
    private final g.c ebB = new g.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cmQ()) {
                PbFragment.this.iGZ.finish();
            }
            if (!PbFragment.this.iEg.pW(true)) {
                PbFragment.this.iHB.cpG();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e gIH = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.iIE && PbFragment.this.cmQ()) {
                PbFragment.this.cmS();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.iEg.pV(false)) {
                    PbFragment.this.iHB.cpE();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.iEg.getPbData() != null) {
                    PbFragment.this.iHB.cqb();
                }
                PbFragment.this.iIE = true;
            }
        }
    };
    private int iIF = 0;
    private final TbRichTextView.i dMw = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f cpz;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.iHB.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.cy("tid", PbFragment.this.iEg.cnw());
                anVar.cy("fid", PbFragment.this.iEg.getForumId());
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.X("obj_locate", 3);
                anVar.X("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.iEg.iEZ.ckQ()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aTR() != null) {
                            ArrayList<TbRichTextImageInfo> aTR = tbRichTextView.getRichText().aTR();
                            int i4 = 0;
                            while (i4 < aTR.size()) {
                                if (aTR.get(i4) != null) {
                                    arrayList.add(aTR.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(aTR.get(i4).getSrc()) || str.equals(aTR.get(i4).aUj()) || str.equals(aTR.get(i4).aUg()) || str.equals(aTR.get(i4).aUi()) || str.equals(aTR.get(i4).aUm()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = aTR.get(i4).getSrc();
                                    imageUrlData.originalUrl = aTR.get(i4).getSrc();
                                    imageUrlData.isLongPic = aTR.get(i4).aUo();
                                    concurrentHashMap.put(aTR.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.iEg.cnN(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.iEg.getPbData().cks());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.iEo) {
                        TbRichText bj = PbFragment.this.bj(str, i);
                        if (bj != null && PbFragment.this.iIF >= 0 && PbFragment.this.iIF < bj.aTQ().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.f.b(bj.aTQ().get(PbFragment.this.iIF));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.iEl.size()) {
                                    break;
                                } else if (!aVar.iEl.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bj.getPostId() != 0 && (cpz = PbFragment.this.iHB.cpz()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = cpz.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bj.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bj.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEg.coc(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iEg.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.iEm.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEn, aVar.lastId, PbFragment.this.iEg.cnN(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.iEg.getPbData().cks());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.iEl, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.iEm.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEn, aVar.iEl.get(0), PbFragment.this.iEg.cnN(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.iEg.getPbData().cks());
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
                PbFragment.this.iHr = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean iIG = false;
    PostData hhx = null;
    private final b.a iIH = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.hhx != null) {
                if (i == 0) {
                    PbFragment.this.hhx.fv(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.hhx = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.k(PbFragment.this.hhx);
                }
            }
        }
    };
    private final b.a iII = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iHY != null && !TextUtils.isEmpty(PbFragment.this.iHZ)) {
                if (i == 0) {
                    if (PbFragment.this.iIa == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iHZ));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.iHZ;
                        aVar.pkgId = PbFragment.this.iIa.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iIa.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.gQz == null) {
                            PbFragment.this.gQz = new ar(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.gQz.j(PbFragment.this.iHZ, PbFragment.this.iHY.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.iHY = null;
                PbFragment.this.iHZ = null;
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
                        PbFragment.this.iHY = ((TbImageView) view).getBdImage();
                        PbFragment.this.iHZ = ((TbImageView) view).getUrl();
                        if (PbFragment.this.iHY == null || TextUtils.isEmpty(PbFragment.this.iHZ)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iIa = null;
                        } else {
                            PbFragment.this.iIa = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.iHY = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.iHZ = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.iIa = null;
                            } else {
                                PbFragment.this.iIa = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.iHY = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.iHZ = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iIa = null;
                        } else {
                            PbFragment.this.iIa = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.iHB.a(PbFragment.this.iII, PbFragment.this.iHY.isGif());
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
            PbFragment.this.hhx = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.hhx == null) {
                return true;
            }
            if (PbFragment.this.hhx.cKY() != 1 || !PbFragment.this.cv(view)) {
                if (PbFragment.this.iHz != null) {
                    if (!PbFragment.this.iHz.ayJ() || PbFragment.this.hhx.getId() == null || !PbFragment.this.hhx.getId().equals(PbFragment.this.iEg.aCv())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.clz().getPbData() != null && PbFragment.this.clz().getPbData().ckQ();
                    if (PbFragment.this.hhx.cKY() != 1) {
                        if (PbFragment.this.iHH == null) {
                            PbFragment.this.iHH = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.iHH.a(PbFragment.this.iIJ);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = PbFragment.this.cv(view) && !z3;
                            boolean z5 = (!PbFragment.this.cv(view) || PbFragment.this.iHY == null || PbFragment.this.iHY.isGif()) ? false : true;
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
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.iHH));
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.iHH));
                            }
                            if (!z4 && !z5) {
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iHH);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.hhx);
                                gVar3.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar3);
                            }
                            if (!z2 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iHH);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iHH);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.hhx);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z8 && z7) {
                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iHH);
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
                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHH);
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
                                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHH);
                                        gVar6.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iHH);
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
                                        if (PbFragment.this.iEg.getPbData().ckE() == 1002 && !z6) {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHH);
                                        } else {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHH);
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
                            PbFragment.this.iHH.az(arrayList);
                            PbFragment.this.iHG = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iHH);
                            PbFragment.this.iHG.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").cy("tid", PbFragment.this.iEg.iJU).cy("fid", PbFragment.this.iEg.getForumId()).cy("uid", PbFragment.this.iEg.getPbData().cks().aCm().getUserId()).cy("post_id", PbFragment.this.iEg.aOM()).X("obj_source", z2 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.iHB.a(PbFragment.this.iIH, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.iHB.a(PbFragment.this.iII, PbFragment.this.iHY.isGif());
            return true;
        }
    };
    private k.c iIJ = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            int i2;
            if (PbFragment.this.iHG != null) {
                PbFragment.this.iHG.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.iHY != null && !TextUtils.isEmpty(PbFragment.this.iHZ)) {
                        if (PbFragment.this.iIa == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iHZ));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.iHZ;
                            aVar.pkgId = PbFragment.this.iIa.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iIa.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.iHY = null;
                        PbFragment.this.iHZ = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.iHY != null && !TextUtils.isEmpty(PbFragment.this.iHZ)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.gQz == null) {
                                PbFragment.this.gQz = new ar(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.gQz.j(PbFragment.this.iHZ, PbFragment.this.iHY.getImageByte());
                            PbFragment.this.iHY = null;
                            PbFragment.this.iHZ = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.hhx != null) {
                        PbFragment.this.hhx.fv(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.hhx = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").X("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cu(view);
                        if (PbFragment.this.iEg.getPbData().cks() != null && PbFragment.this.iEg.getPbData().cks().aCm() != null && PbFragment.this.iEg.getPbData().cks().aCm().getUserId() != null && PbFragment.this.iHz != null) {
                            int g = PbFragment.this.g(PbFragment.this.iEg.getPbData());
                            bj cks = PbFragment.this.iEg.getPbData().cks();
                            if (cks.aBb()) {
                                i2 = 2;
                            } else if (cks.aBc()) {
                                i2 = 3;
                            } else if (cks.aEe()) {
                                i2 = 4;
                            } else {
                                i2 = cks.aEf() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cy("tid", PbFragment.this.iEg.iJU).X("obj_locate", 2).cy("obj_id", PbFragment.this.iEg.getPbData().cks().aCm().getUserId()).X("obj_type", PbFragment.this.iHz.ayJ() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
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
                        PbFragment.this.FP((String) tag);
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
                        PbFragment.this.iHB.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.iHB.cA(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.iHB.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a glJ = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.iEg.cnD()) {
                PbFragment.this.cmN();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener drz = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.gsm.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0499a fRx = new a.InterfaceC0499a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        final int eLh = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (av(i2) && PbFragment.this.iHB != null && PbFragment.this.iHb != null) {
                PbFragment.this.iHb.lC(true);
                if (Math.abs(i2) > this.eLh) {
                    PbFragment.this.iHb.hideFloatingView();
                }
                if (PbFragment.this.cmQ()) {
                    PbFragment.this.iHB.cpw();
                    PbFragment.this.iHB.cpx();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (av(i2) && PbFragment.this.iHB != null && PbFragment.this.iHb != null) {
                PbFragment.this.iHB.cqh();
                PbFragment.this.iHb.lC(false);
                PbFragment.this.iHb.showFloatingView();
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
    private final n.a iGh = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.iHB.Ge(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int iIL = -1;
    private int iIM = -1;

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

    public com.baidu.tbadk.editortools.pb.e cmm() {
        return this.iHO;
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (lVar.cld() != null) {
            String id = lVar.cld().getId();
            ArrayList<PostData> cku = this.iEg.getPbData().cku();
            int i = 0;
            while (true) {
                if (i >= cku.size()) {
                    break;
                }
                PostData postData = cku.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> clh = lVar.clh();
                    postData.Cv(lVar.getTotalCount());
                    if (postData.cKV() != null && clh != null) {
                        Iterator<PostData> it = clh.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aCm() != null && (metaData = postData.getUserMap().get(next.aCm().getUserId())) != null) {
                                next.a(metaData);
                                next.sO(true);
                                next.a(getPageContext(), this.iEg.FV(metaData.getUserId()));
                            }
                        }
                        boolean z2 = clh.size() != postData.cKV().size();
                        postData.cKV().clear();
                        postData.cKV().addAll(clh);
                        z = z2;
                    }
                    if (postData.cKR() != null) {
                        postData.cKS();
                    }
                }
            }
            if (!this.iEg.getIsFromMark() && z) {
                this.iHB.o(this.iEg.getPbData());
            }
            if (z) {
                c(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FN(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m ckH = this.iEg.getPbData().ckH();
            if (ckH != null && str.equals(ckH.getAdId())) {
                if (ckH.cKM() != null) {
                    ckH.cKM().legoCard = null;
                }
                this.iEg.getPbData().ckI();
            }
            com.baidu.tieba.tbadkCore.data.m cnJ = this.iEg.cnJ();
            if (cnJ != null && str.equals(cnJ.getAdId())) {
                this.iEg.cnK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iHG != null && this.iHG.isShowing()) {
                this.iHG.dismiss();
                this.iHG = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.iHG != null) {
                            PbFragment.this.iHG.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.iHB.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.iHW);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.iHW);
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
                this.iHG = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.iHG.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        bj cks;
        if (this.iEg != null && this.iEg.getPbData() != null && (cks = this.iEg.getPbData().cks()) != null) {
            if (i == 1) {
                PraiseData aBX = cks.aBX();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aBX == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cks.a(praiseData);
                    } else {
                        cks.aBX().getUser().add(0, metaData);
                        cks.aBX().setNum(cks.aBX().getNum() + 1);
                        cks.aBX().setIsLike(i);
                    }
                }
                if (cks.aBX() != null) {
                    if (cks.aBX().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(cks.aBX().getNum());
                    }
                }
            } else if (cks.aBX() != null) {
                cks.aBX().setIsLike(i);
                cks.aBX().setNum(cks.aBX().getNum() - 1);
                ArrayList<MetaData> user = cks.aBX().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cks.aBX().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cks.aBX().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cks.aBX().getNum() + "";
                }
            }
            if (this.iEg.cnx()) {
                this.iHB.cpz().notifyDataSetChanged();
            } else {
                this.iHB.p(this.iEg.getPbData());
            }
        }
    }

    public static PbFragment cmn() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iGZ = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iEg.au(bundle);
        if (this.goj != null) {
            this.goj.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.iHO.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iHg = System.currentTimeMillis();
        this.iHU = getPageContext();
        final Intent intent = this.iGZ.getIntent();
        if (intent != null) {
            this.fVe = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.iHn = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.iHn)) {
                    this.iHn = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.iHn)) {
                this.iHc = true;
            }
            this.iIL = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.iIM = intent.getIntExtra("key_manga_next_chapter", -1);
            this.iIN = intent.getStringExtra("key_manga_title");
            this.iHJ = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.iHK = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.iHL = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cmQ()) {
                this.iGZ.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.iIc = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.iHw = new ax();
            this.iHw.R(intent);
            this.iIe = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.iIe == 0) {
                this.iIe = intent.getIntExtra("key_start_from", 0);
            }
            this.iIf = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.fVe = System.currentTimeMillis();
        }
        this.dDv = this.iHg - this.fVe;
        super.onCreate(bundle);
        this.iHe = 0;
        at(bundle);
        if (this.iEg.getPbData() != null) {
            this.iEg.getPbData().FJ(this.source);
        }
        cmq();
        if (intent != null && this.iHB != null) {
            this.iHB.iNG = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.iHX == null) {
                    this.iHX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.iHB.Gg("@" + intent.getStringExtra("big_pic_type") + HanziToPinyin.Token.SEPARATOR);
                        }
                    };
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.iHX, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.iEg.getPbData() != null) {
                this.iEg.FY(stringExtra);
            }
        }
        this.goj = new VoiceManager();
        this.goj.onCreate(getPageContext());
        initData(bundle);
        this.iHN = new com.baidu.tbadk.editortools.pb.g();
        d(this.iHN);
        this.iHO = (com.baidu.tbadk.editortools.pb.e) this.iHN.dV(getActivity());
        this.iHO.a(this.iGZ.getPageContext());
        this.iHO.a(this.dyz);
        this.iHO.a(this.dys);
        this.iHO.a(this.iGZ.getPageContext(), bundle);
        this.iHO.aOr().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iHO.aOr().gB(true);
        pK(true);
        this.iHO.a(this.iEg.cnL(), this.iEg.cnw(), this.iEg.coc());
        registerListener(this.iIk);
        if (!this.iEg.cnC()) {
            this.iHO.vl(this.iEg.cnw());
        }
        if (this.iEg.cod()) {
            this.iHO.vk(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.iHB != null) {
            this.iHO.vk(this.iHB.cpk());
        }
        registerListener(this.iIj);
        registerListener(this.iIl);
        registerListener(this.iIm);
        registerListener(this.gpy);
        registerListener(this.iIx);
        registerListener(this.iIi);
        this.iHM = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.kfR);
        this.iHM.cKF();
        registerListener(this.iIn);
        registerListener(this.dae);
        this.iEg.cnV();
        registerListener(this.iIB);
        registerListener(this.gpF);
        if (this.iHB != null && this.iHB.cql() != null && this.iHB.cqm() != null) {
            this.iHb = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.iHB.cql(), this.iHB.cqm(), this.iHB.cpq());
            this.iHb.a(this.iIs);
        }
        if (this.iHa && this.iHB != null && this.iHB.cqm() != null) {
            this.iHB.cqm().setVisibility(8);
        }
        this.iHV = new com.baidu.tbadk.core.view.d();
        this.iHV.toastTime = 1000L;
        registerListener(this.iIw);
        registerListener(this.iIu);
        registerListener(this.iIv);
        registerListener(this.gFz);
        registerListener(this.gpv);
        registerResponsedEventListener(TipEvent.class, this.gnr);
        this.iHW = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iHW;
        userMuteAddAndDelCustomMessage.setTag(this.iHW);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iHW;
        userMuteCheckCustomMessage.setTag(this.iHW);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iEg.coa().a(this.iIt);
        this.iHF = new ap();
        if (this.iHO.aOQ() != null) {
            this.iHF.e(this.iHO.aOQ().getInputView());
        }
        this.iHO.a(this.dyt);
        this.gEs = new ShareSuccessReplyToServerModel();
        a(this.iIg);
        this.hPw = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.hPw.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.cZV) {
                        PbFragment.this.iHO.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.cZW && PbFragment.this.iHB != null && PbFragment.this.iHB.cpg() != null && PbFragment.this.iHB.cpg().cml() != null) {
                        PbFragment.this.iHB.cpg().cml().aPm();
                    } else if (i == com.baidu.tbadk.core.util.aj.cZX) {
                        PbFragment.this.c(PbFragment.this.iHR);
                    }
                }
            }
        });
        this.iHy = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.iHy.t(getUniqueId());
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
        com.baidu.tbadk.core.business.a.azY().co("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.iHg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.iEg != null) {
            gVar.setForumName(this.iEg.clq());
            if (this.iEg.getPbData() != null && this.iEg.getPbData().getForum() != null) {
                gVar.a(this.iEg.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.iEg);
        }
    }

    public String cmo() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cmp() {
        return this.iHb;
    }

    private void pK(boolean z) {
        this.iHO.gF(z);
        this.iHO.gG(z);
        this.iHO.gH(z);
    }

    private void cmq() {
        this.djT = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.goj != null) {
            this.goj.onStart(getPageContext());
        }
    }

    public an cmr() {
        return this.iHB;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel clz() {
        return this.iEg;
    }

    public void FO(String str) {
        if (this.iEg != null && !StringUtils.isNull(str) && this.iHB != null) {
            this.iHB.qu(true);
            this.iEg.FO(str);
            this.iHm = true;
            this.iHB.cpW();
            this.iHB.cqg();
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
        this.iHe = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.iHe == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.goj != null) {
            this.goj.onPause(getPageContext());
        }
        if (this.iHB != null) {
            this.iHB.onPause();
        }
        if (!this.iEg.cnC()) {
            this.iHO.saveDraft(this.iEg.cnw());
        }
        if (this.iEg != null) {
            this.iEg.cnW();
        }
        com.baidu.tbadk.BdToken.c.axx().axC();
        MessageManager.getInstance().unRegisterListener(this.htw);
        bPU();
        MessageManager.getInstance().unRegisterListener(this.iIu);
        MessageManager.getInstance().unRegisterListener(this.iIv);
        MessageManager.getInstance().unRegisterListener(this.iIw);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cms() {
        PostData a2 = com.baidu.tieba.pb.data.f.a(this.iEg.getPbData(), this.iEg.cnx(), this.iEg.cnU());
        return (a2 == null || a2.aCm() == null || a2.aCm().getGodUserData() == null || a2.aCm().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.iHp) {
            this.iHp = false;
            cmW();
        }
        if (cms()) {
            this.iHj = System.currentTimeMillis();
        } else {
            this.iHj = -1L;
        }
        if (this.iHB != null && this.iHB.getView() != null) {
            if (!this.ihR) {
                cmO();
            } else {
                hideLoadingView(this.iHB.getView());
            }
            this.iHB.onResume();
        }
        if (this.iHe == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.iHB != null) {
            noNetworkView = this.iHB.cpd();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.goj != null) {
            this.goj.onResume(getPageContext());
        }
        registerListener(this.htw);
        this.iHI = false;
        cmV();
        registerListener(this.iIu);
        registerListener(this.iIv);
        registerListener(this.iIw);
        if (this.goW) {
            cmN();
            this.goW = false;
        }
        cnc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.iHB.qj(z);
        if (this.iHG != null) {
            this.iHG.dismiss();
        }
        if (z && this.iHI) {
            this.iHB.cpE();
            this.iEg.pV(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iHj > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").cy("obj_duration", (System.currentTimeMillis() - this.iHj) + ""));
            this.iHj = 0L;
        }
        if (cmr().cpg() != null) {
            cmr().cpg().onStop();
        }
        if (this.iHB.iNI != null && !this.iHB.iNI.crc()) {
            this.iHB.iNI.releaseResources();
        }
        if (this.iEg != null && this.iEg.getPbData() != null && this.iEg.getPbData().getForum() != null && this.iEg.getPbData().cks() != null) {
            com.baidu.tbadk.distribute.a.aOf().a(getPageContext().getPageActivity(), "pb", this.iEg.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iEg.getPbData().cks().getId(), 0L));
        }
        if (this.goj != null) {
            this.goj.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.cJY().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("fid", this.iEg.getPbData().getForumId());
            anVar.cy("tid", this.iEg.cnw());
            anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.iHh && this.iHB != null) {
            this.iHh = true;
            this.iHB.cqc();
            a(false, (PostData) null);
        }
        if (this.iEg != null) {
            this.iEg.cancelLoadData();
            this.iEg.destory();
            if (this.iEg.cnZ() != null) {
                this.iEg.cnZ().onDestroy();
            }
        }
        if (this.iHO != null) {
            this.iHO.onDestroy();
        }
        if (this.fKw != null) {
            this.fKw.cancelLoadData();
        }
        if (this.djT != null) {
            this.djT.cKs();
        }
        if (this.iHB != null) {
            this.iHB.onDestroy();
            if (this.iHB.iNI != null) {
                this.iHB.iNI.releaseResources();
            }
        }
        if (this.iHi != null) {
            this.iHi.aRb();
        }
        if (this.iHb != null) {
            this.iHb.aWG();
        }
        super.onDestroy();
        if (this.goj != null) {
            this.goj.onDestory(getPageContext());
        }
        if (this.iHB != null) {
            this.iHB.cpW();
        }
        MessageManager.getInstance().unRegisterListener(this.iIu);
        MessageManager.getInstance().unRegisterListener(this.iIv);
        MessageManager.getInstance().unRegisterListener(this.iIw);
        MessageManager.getInstance().unRegisterListener(this.iHW);
        MessageManager.getInstance().unRegisterListener(this.iIx);
        MessageManager.getInstance().unRegisterListener(this.gpF);
        MessageManager.getInstance().unRegisterListener(this.gFz);
        MessageManager.getInstance().unRegisterListener(this.iIz);
        this.iHU = null;
        this.iHV = null;
        com.baidu.tieba.recapp.d.a.cDi().cDk();
        if (this.iHX != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iHX);
        }
        if (this.iHq != null) {
            this.iHq.cancelLoadData();
        }
        if (this.iHB != null && this.iHB.iNI != null) {
            this.iHB.iNI.crf();
        }
        if (this.gEs != null) {
            this.gEs.cancelLoadData();
        }
        this.iHF.onDestroy();
        if (this.iEg != null && this.iEg.cob() != null) {
            this.iEg.cob().onDestroy();
        }
        if (this.hPw != null) {
            this.hPw.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f cpz;
        ArrayList<PostData> clX;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aJb() && this.iHB != null && (cpz = this.iHB.cpz()) != null && (clX = cpz.clX()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = clX.iterator();
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
                        bVar.fMr = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.cSJ == 1 && !TextUtils.isEmpty(id)) {
                    next.cSJ = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.fMr = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.iEg == null || this.iEg.getPbData() == null || this.iEg.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.iEg.getPbData().getForum().getFirst_class();
                    str2 = this.iEg.getPbData().getForum().getSecond_class();
                    str = this.iEg.getPbData().getForum().getId();
                    str4 = this.iEg.cnw();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aJe());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.iHB.onChangeSkinType(i);
            if (this.iHO != null && this.iHO.aOr() != null) {
                this.iHO.aOr().onChangeSkinType(i);
            }
            if (this.iHB.cpd() != null) {
                this.iHB.cpd().onChangeSkinType(getPageContext(), i);
            }
            this.iHF.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iHB = new an(this, this.gqo, this.dqJ);
        this.gsm = new com.baidu.tieba.f.b(getActivity());
        this.gsm.a(iIK);
        this.gsm.a(this.fRx);
        this.iHB.setOnScrollListener(this.mOnScrollListener);
        this.iHB.d(this.gIH);
        this.iHB.setListPullRefreshListener(this.ebB);
        this.iHB.pw(com.baidu.tbadk.core.i.azM().isShowImages());
        this.iHB.setOnImageClickListener(this.dMw);
        this.iHB.b(this.mOnLongClickListener);
        this.iHB.g(this.glJ);
        this.iHB.a(this.iID);
        this.iHB.qj(this.mIsLogin);
        if (this.iGZ.getIntent() != null) {
            this.iHB.qv(this.iGZ.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.iHB.cpf().setFromForumId(this.iEg.getFromForumId());
        this.iHB.setEditorTools(this.iHO.aOr());
        this.iHO.vk(this.iHB.cpk());
        this.iHB.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.iEg.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEg.getPbData().getForum().getId(), PbFragment.this.iEg.getPbData().getForum().getName(), PbFragment.this.iEg.getPbData().cks().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.iHB.getView();
    }

    public void cmt() {
        if (this.iHB != null && this.iEg != null) {
            if ((this.iEg.getPbData() != null || this.iEg.getPbData().ckN() != null) && checkUpIsLogin() && this.iHB.cpz() != null && this.iHB.cpz().cmc() != null) {
                this.iHB.cpz().cmc().tX(this.iEg.cnw());
            }
        }
    }

    public void cmu() {
        TiebaStatic.log("c12181");
        if (this.iHB != null && this.iEg != null) {
            if ((this.iHB == null || this.iHB.cpj()) && this.iEg.getPbData() != null && this.iEg.getPbData().ckN() != null) {
                com.baidu.tieba.pb.data.k ckN = this.iEg.getPbData().ckN();
                if (checkUpIsLogin()) {
                    if ((!ckN.cla() || ckN.aDI() != 2) && this.iHB.cpz() != null && this.iHB.cpz().cmc() != null) {
                        this.iHB.cpz().cmc().tX(this.iEg.cnw());
                    }
                    if (System.currentTimeMillis() - this.iHl > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).rd(false);
                        this.iHl = System.currentTimeMillis();
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
                if (postData.getType() != PostData.kgs && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.azM().isShowImages()) {
                    return FR(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.iEg == null || this.iEg.getPbData() == null) {
                        return true;
                    }
                    if (cmr().cpg() != null) {
                        cmr().cpg().cmh();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(this.iEg.getPbData().getForum());
                    lVar.setThreadData(this.iEg.getPbData().cks());
                    lVar.f(postData);
                    cmr().cpf().d(lVar);
                    cmr().cpf().setPostId(postData.getId());
                    b(view, postData.aCm().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iHO != null) {
                        this.iHB.qp(this.iHO.aOX());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cmv() {
        if (this.iHf == null) {
            this.iHf = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.iHf.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.iEc = PbFragment.this.iEc.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEc);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iEg.cnw(), PbFragment.this.iEc, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.iEc = PbFragment.this.iEc.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEc);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iEg.cnw(), PbFragment.this.iEc, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.iEc = PbFragment.this.iEc.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEc);
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
        this.iIA.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).ctc(), "", 1);
    }

    private void at(Bundle bundle) {
        this.iEg = this.iGZ.clz();
        if (this.iEg.cnY() != null) {
            this.iEg.cnY().a(this.iGh);
        }
        if (this.iEg.cnZ() != null) {
            this.iEg.cnZ().b(this.iIh);
        }
        if (StringUtils.isNull(this.iEg.cnw())) {
            this.iGZ.finish();
        } else if ("from_tieba_kuang".equals(this.iHn) && this.iHn != null) {
            this.iEg.yY(6);
        }
    }

    private void initData(Bundle bundle) {
        this.iHz = com.baidu.tbadk.baseEditMark.a.a(this.iGZ);
        if (this.iHz != null) {
            this.iHz.a(this.iIC);
        }
        this.fKw = new ForumManageModel(this.iGZ);
        this.fKw.setLoadDataCallBack(this.fKB);
        this.daa = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iIr.setUniqueId(getUniqueId());
        this.iIr.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iHB.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iHW;
        userMuteCheckCustomMessage.setTag(this.iHW);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cmw() {
        if (this.iEg == null || this.iEg.getPbData() == null) {
            return false;
        }
        bj cks = this.iEg.getPbData().cks();
        this.iEg.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cks);
    }

    public void cmx() {
        if (checkUpIsLogin() && this.iEg != null && this.iEg.getPbData() != null && this.iEg.getPbData().getForum() != null && !cmw()) {
            if (this.iEg.getPbData().ckQ()) {
                this.iHB.bPv();
                return;
            }
            if (this.grK == null) {
                this.grK = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.grK.tP(0);
                this.grK.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lw(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void t(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lx(boolean z) {
                        if (z) {
                            PbFragment.this.iHB.bPv();
                        }
                    }
                });
            }
            this.grK.C(this.iEg.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iEg.cnw(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmy() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.iEg == null || (pbData = this.iEg.getPbData()) == null) {
            return null;
        }
        return pbData.ckD().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cks() != null) {
            if (eVar.cks().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cks().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cks().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cmw() && cmz()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iHs);
                this.iHt = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.iEg.getPbData() != null && this.iEg.getPbData().ckQ()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.iGZ.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cmr().getListView().smoothScrollBy((PbFragment.this.iHs[1] + PbFragment.this.iHt) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cmr().cpg() != null) {
                            PbFragment.this.iHO.aOr().setVisibility(8);
                            PbFragment.this.cmr().cpg().g(str, str2, PbFragment.this.cmr().cpk(), (PbFragment.this.iEg == null || PbFragment.this.iEg.getPbData() == null || PbFragment.this.iEg.getPbData().cks() == null || !PbFragment.this.iEg.getPbData().cks().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cml = PbFragment.this.cmr().cpg().cml();
                            if (cml != null && PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                cml.a(PbFragment.this.iEg.getPbData().getAnti());
                                cml.setThreadData(PbFragment.this.iEg.getPbData().cks());
                            }
                            if (PbFragment.this.iHF.cqx() == null && PbFragment.this.cmr().cpg().cml().aPu() != null) {
                                PbFragment.this.cmr().cpg().cml().aPu().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iHF != null && PbFragment.this.iHF.cqw() != null) {
                                            if (!PbFragment.this.iHF.cqw().cUd()) {
                                                PbFragment.this.iHF.qx(false);
                                            }
                                            PbFragment.this.iHF.cqw().tH(false);
                                        }
                                    }
                                });
                                PbFragment.this.iHF.f(PbFragment.this.cmr().cpg().cml().aPu().getInputView());
                                PbFragment.this.cmr().cpg().cml().a(PbFragment.this.iHT);
                            }
                        }
                        PbFragment.this.cmr().cqg();
                    }
                }, 0L);
                return;
            }
            if (this.iHQ == null) {
                this.iHQ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iHQ.tP(1);
                this.iHQ.a(new AnonymousClass37(str, str2));
            }
            if (this.iEg != null && this.iEg.getPbData() != null && this.iEg.getPbData().getForum() != null) {
                this.iHQ.C(this.iEg.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iEg.cnw(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$37  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass37 implements c.a {
        final /* synthetic */ String iIW;
        final /* synthetic */ String iIX;

        AnonymousClass37(String str, String str2) {
            this.iIW = str;
            this.iIX = str2;
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
                        PbFragment.this.cmr().getListView().smoothScrollBy((PbFragment.this.iHs[1] + PbFragment.this.iHt) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cmr().cpg() != null) {
                            PbFragment.this.iHO.aOr().setVisibility(8);
                            PbFragment.this.cmr().cpg().g(AnonymousClass37.this.iIW, AnonymousClass37.this.iIX, PbFragment.this.cmr().cpk(), (PbFragment.this.iEg == null || PbFragment.this.iEg.getPbData() == null || PbFragment.this.iEg.getPbData().cks() == null || !PbFragment.this.iEg.getPbData().cks().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cml = PbFragment.this.cmr().cpg().cml();
                            if (cml != null && PbFragment.this.iEg != null && PbFragment.this.iEg.getPbData() != null) {
                                cml.a(PbFragment.this.iEg.getPbData().getAnti());
                                cml.setThreadData(PbFragment.this.iEg.getPbData().cks());
                            }
                            if (PbFragment.this.iHF.cqx() == null && PbFragment.this.cmr().cpg().cml().aPu() != null) {
                                PbFragment.this.cmr().cpg().cml().aPu().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iHF != null && PbFragment.this.iHF.cqw() != null) {
                                            if (!PbFragment.this.iHF.cqw().cUd()) {
                                                PbFragment.this.iHF.qx(false);
                                            }
                                            PbFragment.this.iHF.cqw().tH(false);
                                        }
                                    }
                                });
                                PbFragment.this.iHF.f(PbFragment.this.cmr().cpg().cml().aPu().getInputView());
                                PbFragment.this.cmr().cpg().cml().a(PbFragment.this.iHT);
                            }
                        }
                        PbFragment.this.cmr().cqg();
                    }
                }, 0L);
            }
        }
    }

    public boolean cmz() {
        if ((this.iEg.getPbData() != null && this.iEg.getPbData().ckQ()) || this.hPw == null || this.iEg.getPbData() == null || this.iEg.getPbData().getAnti() == null) {
            return true;
        }
        return this.hPw.ks(this.iEg.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean yN(int i) {
        if (this.hPw == null || this.iEg.getPbData() == null || this.iEg.getPbData().getAnti() == null) {
            return true;
        }
        return this.hPw.ax(this.iEg.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.iEg != null && this.iEg.getPbData() != null && postData.cKY() != 1) {
            String cnw = this.iEg.cnw();
            String id = postData.getId();
            int ckE = this.iEg.getPbData() != null ? this.iEg.getPbData().ckE() : 0;
            PbActivity.a FS = FS(id);
            if (FS != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cnw, id, "pb", true, null, false, null, ckE, postData.crX(), this.iEg.getPbData().getAnti(), false, postData.aCm() != null ? postData.aCm().getIconInfo() : null).addBigImageData(FS.iEl, FS.iEm, FS.iEn, FS.index);
                addBigImageData.setKeyPageStartFrom(this.iEg.cof());
                addBigImageData.setFromFrsForumId(this.iEg.getFromForumId());
                addBigImageData.setKeyFromForumId(this.iEg.getForumId());
                addBigImageData.setBjhData(this.iEg.cnE());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmA() {
        if (this.iEg.getPbData() == null || this.iEg.getPbData().cks() == null) {
            return -1;
        }
        return this.iEg.getPbData().cks().aCW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmB() {
        if (this.iEg != null && this.iEg.iEZ != null && this.iEg.iEZ.cks() != null) {
            bj cks = this.iEg.iEZ.cks();
            cks.mRecomAbTag = this.iEg.coq();
            cks.mRecomWeight = this.iEg.coo();
            cks.mRecomSource = this.iEg.cop();
            cks.mRecomExtra = this.iEg.cor();
            if (cks.getFid() == 0) {
                cks.setFid(com.baidu.adp.lib.f.b.toLong(this.iEg.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cks, "c13563");
            if (a2 != null) {
                a2.X("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmC() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Iw(this.iEg.getForumId()) && this.iEg.getPbData() != null && this.iEg.getPbData().getForum() != null) {
            if (this.iEg.getPbData().getForum().isLike() == 1) {
                this.iEg.cob().ev(this.iEg.getForumId(), this.iEg.cnw());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iEg == null || this.iEg.getPbData() == null) {
            return false;
        }
        return ((this.iEg.getPbData().ckE() != 0) || this.iEg.getPbData().cks() == null || this.iEg.getPbData().cks().aCm() == null || TextUtils.equals(this.iEg.getPbData().cks().aCm().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean pM(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.w wVar;
        if (this.iEg == null || this.iEg.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.iEg.getPbData();
        bj cks = pbData.cks();
        if (cks != null) {
            if (cks.aBb() || cks.aBc()) {
                return false;
            }
            if (cks.aEe() || cks.aEf()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.ckE() != 0) {
                return pbData.ckE() != 3;
            }
            List<bf> ckL = pbData.ckL();
            if (com.baidu.tbadk.core.util.v.getCount(ckL) > 0) {
                for (bf bfVar : ckL) {
                    if (bfVar != null && (wVar = bfVar.cQO) != null && wVar.cOI && !wVar.cOJ && (wVar.type == 1 || wVar.type == 2)) {
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
        if (z || this.iEg == null || this.iEg.getPbData() == null) {
            return false;
        }
        return ((this.iEg.getPbData().getForum() != null && this.iEg.getPbData().getForum().isBlockBawuDelete) || this.iEg.getPbData().ckE() == 0 || this.iEg.getPbData().ckE() == 3) ? false : true;
    }

    public void cmD() {
        com.baidu.tieba.pb.data.e pbData;
        bj cks;
        if (this.iEg != null && this.iEg.getPbData() != null && (cks = (pbData = this.iEg.getPbData()).cks()) != null && cks.aCm() != null) {
            this.iHB.cpe();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cks.aCm().getUserId());
            z zVar = new z();
            int ckE = this.iEg.getPbData().ckE();
            if (ckE == 1 || ckE == 3) {
                zVar.iLZ = true;
                zVar.iLY = true;
                zVar.iMe = cks.aCh() == 1;
                zVar.iMd = cks.aCi() == 1;
            } else {
                zVar.iLZ = false;
                zVar.iLY = false;
            }
            if (ckE == 1002 && !equals) {
                zVar.iMf = true;
            }
            zVar.iLW = pM(equals);
            zVar.iMa = cmE();
            zVar.iLX = pN(equals);
            zVar.hW = this.iEg.cnx();
            zVar.iLT = true;
            zVar.iLS = pL(equals);
            zVar.iLR = equals && this.iHB.cpL();
            zVar.iMc = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.iMb = true;
            zVar.isHostOnly = this.iEg.getHostMode();
            zVar.iLV = true;
            if (cks.aCD() == null) {
                zVar.iLU = true;
            } else {
                zVar.iLU = false;
            }
            if (pbData.ckQ()) {
                zVar.iLT = false;
                zVar.iLV = false;
                zVar.iLU = false;
                zVar.iLY = false;
                zVar.iLZ = false;
            }
            this.iHB.iNI.a(zVar);
        }
    }

    private boolean cmE() {
        if (this.iEg != null && this.iEg.cnx()) {
            return this.iEg.getPageData() == null || this.iEg.getPageData().aBj() != 0;
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
    public PbModel.a cmF() {
        return this.iIA;
    }

    public int cmG() {
        if (cmr() == null || cmr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cmr().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) mVar).Ag == com.baidu.tieba.pb.data.j.iCC) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmH() {
        if (cmr() == null || cmr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cmr().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.kgr) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cmN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmI() {
        if (this.iEg != null && this.iEg.iEZ != null && this.iEg.iEZ.cks() != null) {
            bj cks = this.iEg.iEZ.cks();
            cks.mRecomAbTag = this.iEg.coq();
            cks.mRecomWeight = this.iEg.coo();
            cks.mRecomSource = this.iEg.cop();
            cks.mRecomExtra = this.iEg.cor();
            if (cks.getFid() == 0) {
                cks.setFid(com.baidu.adp.lib.f.b.toLong(this.iEg.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cks, "c13562");
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
                    PbFragment.this.daa.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.iEg.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aEA();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.iHB.cpF();
        this.iEg.pX(z);
        if (this.iHz != null) {
            this.iHz.fm(z);
            if (markData != null) {
                this.iHz.a(markData);
            }
        }
        if (this.iEg.ayJ()) {
            cmL();
        } else {
            this.iHB.o(this.iEg.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yE(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(String str) {
        if (this.iEg != null && this.iEg.getPbData() != null && this.iEg.getPbData().ckQ()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iEg.cnw(), str);
            bj cks = this.iEg.getPbData().cks();
            if (cks.aBb()) {
                format = format + "&channelid=33833";
            } else if (cks.aEd()) {
                format = format + "&channelid=33842";
            } else if (cks.aBc()) {
                format = format + "&channelid=33840";
            }
            FQ(format);
            return;
        }
        this.iHy.Gp(str);
    }

    private void FQ(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.iEg.cnC()) {
                    antiData.setBlock_forum_name(this.iEg.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.iEg.getPbData().getForum().getId());
                    antiData.setUser_name(this.iEg.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.iEg.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cmr() != null) {
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
            vq(str);
        } else {
            this.iHB.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.kjg) ? bVar.kjg : getString(R.string.delete_fail);
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
                aVar.aEA();
            } else {
                this.iHB.a(0, bVar.mSuccess, bVar.kjg, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fXV == 1) {
                    ArrayList<PostData> cku = this.iEg.getPbData().cku();
                    int size = cku.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cku.get(i).getId())) {
                            i++;
                        } else {
                            cku.remove(i);
                            break;
                        }
                    }
                    this.iEg.getPbData().cks().jJ(this.iEg.getPbData().cks().aCd() - 1);
                    this.iHB.o(this.iEg.getPbData());
                } else if (bVar.fXV == 0) {
                    cmJ();
                } else if (bVar.fXV == 2) {
                    ArrayList<PostData> cku2 = this.iEg.getPbData().cku();
                    int size2 = cku2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cku2.get(i2).cKV().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cku2.get(i2).cKV().get(i3).getId())) {
                                i3++;
                            } else {
                                cku2.get(i2).cKV().remove(i3);
                                cku2.get(i2).cKX();
                                z2 = true;
                                break;
                            }
                        }
                        cku2.get(i2).Jb(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.iHB.o(this.iEg.getPbData());
                    }
                    a(bVar, this.iHB);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.iHB.a(this.fKw.getLoadDataMode(), gVar.mSuccess, gVar.kjg, false);
            if (gVar.mSuccess) {
                this.iHC = true;
                if (i == 2 || i == 3) {
                    this.iHD = true;
                    this.iHE = false;
                } else if (i == 4 || i == 5) {
                    this.iHD = false;
                    this.iHE = true;
                }
                if (i == 2) {
                    this.iEg.getPbData().cks().jM(1);
                    this.iEg.setIsGood(1);
                } else if (i == 3) {
                    this.iEg.getPbData().cks().jM(0);
                    this.iEg.setIsGood(0);
                } else if (i == 4) {
                    this.iEg.getPbData().cks().jL(1);
                    this.iEg.yQ(1);
                } else if (i == 5) {
                    this.iEg.getPbData().cks().jL(0);
                    this.iEg.yQ(0);
                }
                this.iHB.c(this.iEg.getPbData(), this.iEg.cnx());
            }
        }
    }

    private void cmJ() {
        if (this.iEg.cny() || this.iEg.cnA()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.iEg.cnw());
            PbActivity pbActivity = this.iGZ;
            PbActivity pbActivity2 = this.iGZ;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.iEg.cnw()));
        if (cmM()) {
            this.iGZ.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clM() {
        this.iGZ.clM();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData ckB;
        boolean z = false;
        if (this.iHB != null) {
            this.iHB.cpW();
        }
        if (this.iEg != null && this.iEg.getPbData() != null && !this.iEg.getPbData().ckQ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.iEg.getPbData().cks().getId();
            if (this.iEg.isShareThread() && this.iEg.getPbData().cks().cTP != null) {
                historyMessage.threadName = this.iEg.getPbData().cks().cTP.showText;
            } else {
                historyMessage.threadName = this.iEg.getPbData().cks().getTitle();
            }
            if (this.iEg.isShareThread() && !clp()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.iEg.getPbData().getForum().getName();
            }
            ArrayList<PostData> cku = this.iEg.getPbData().cku();
            int cpH = this.iHB != null ? this.iHB.cpH() : 0;
            if (cku != null && cpH >= 0 && cpH < cku.size()) {
                historyMessage.postID = cku.get(cpH).getId();
            }
            historyMessage.isHostOnly = this.iEg.getHostMode();
            historyMessage.isSquence = this.iEg.cnx();
            historyMessage.isShareThread = this.iEg.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iHO != null) {
            this.iHO.onDestroy();
        }
        if (this.iHd && cmr() != null) {
            cmr().cqq();
        }
        if (this.iEg != null && (this.iEg.cny() || this.iEg.cnA())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.iEg.cnw());
            if (this.iHC) {
                if (this.iHE) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.iEg.bxO());
                }
                if (this.iHD) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.iEg.getIsGood());
                }
            }
            if (this.iEg.getPbData() != null && System.currentTimeMillis() - this.iHg >= 40000 && (ckB = this.iEg.getPbData().ckB()) != null && !com.baidu.tbadk.core.util.v.isEmpty(ckB.getDataList())) {
                intent.putExtra("guess_like_data", ckB);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.iIc);
            }
            PbActivity pbActivity = this.iGZ;
            PbActivity pbActivity2 = this.iGZ;
            pbActivity.setResult(-1, intent);
        }
        if (cmM()) {
            if (this.iEg != null && this.iHB != null && this.iHB.getListView() != null) {
                com.baidu.tieba.pb.data.e pbData = this.iEg.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cky() && !this.iHm && pbData.iBD == null) {
                        ah coO = ah.coO();
                        com.baidu.tieba.pb.data.e cnF = this.iEg.cnF();
                        Parcelable onSaveInstanceState = this.iHB.getListView().onSaveInstanceState();
                        boolean cnx = this.iEg.cnx();
                        boolean hostMode = this.iEg.getHostMode();
                        if (this.iHB.cpq() != null && this.iHB.cpq().getVisibility() == 0) {
                            z = true;
                        }
                        coO.a(cnF, onSaveInstanceState, cnx, hostMode, z);
                        if (this.iIb >= 0 || this.iEg.coh() != null) {
                            ah.coO().n(this.iEg.coh());
                            ah.coO().m(this.iEg.coi());
                            ah.coO().za(this.iEg.coj());
                        }
                    }
                }
            } else {
                ah.coO().reset();
            }
            clM();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.iHB == null || !this.iHB.zg(i)) ? false : true;
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
        PbActivity pbActivity = this.iGZ;
        if (i == 0) {
            this.iHB.cpe();
            this.iHB.cpg().cmh();
            this.iHB.qr(false);
        }
        this.iHB.cpi();
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
                        this.iHO.resetData();
                        this.iHO.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iHO.b(writeData);
                        com.baidu.tbadk.editortools.l mp = this.iHO.aOr().mp(6);
                        if (mp != null && mp.dwz != null) {
                            mp.dwz.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iGZ;
                        if (i == -1) {
                            this.iHO.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iHB.cpg() != null && this.iHB.cpg().cml() != null) {
                            com.baidu.tbadk.editortools.pb.h cml = this.iHB.cpg().cml();
                            cml.setThreadData(this.iEg.getPbData().cks());
                            cml.b(writeData);
                            cml.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mp2 = cml.aOr().mp(6);
                            if (mp2 != null && mp2.dwz != null) {
                                mp2.dwz.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iGZ;
                            if (i == -1) {
                                cml.aPm();
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
        this.iHO.onActivityResult(i, i2, intent);
        if (this.iHq != null) {
            this.iHq.onActivityResult(i, i2, intent);
        }
        if (cmr().cpg() != null) {
            cmr().cpg().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cmK();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ah.coO().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.iEg != null) {
                                PbFragment.this.iEg.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cBY().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.iEg != null) {
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
                        com.baidu.tieba.o.a.cBY().A(getPageContext());
                        cmC();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.gEs != null && shareItem != null && shareItem.linkUrl != null) {
                            this.gEs.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aLI() {
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
                    this.iHB.pB(false);
                    if (this.iEg.getPbData() != null && this.iEg.getPbData().cks() != null && this.iEg.getPbData().cks().aCG() != null) {
                        this.iEg.getPbData().cks().aCG().setStatus(2);
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
                        this.iHR = emotionImageData;
                        if (yN(com.baidu.tbadk.core.util.aj.cZX)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.iHr != null) {
                        this.iHB.cB(this.iHr);
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
            if (this.iHq == null) {
                this.iHq = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iGZ);
                this.iHq.b(this.dys);
                this.iHq.c(this.dyz);
            }
            this.iHq.a(emotionImageData, clz(), clz().getPbData());
        }
    }

    private void aj(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmK() {
        MarkData yX;
        if (this.iHz != null) {
            if (this.iEg.getPbData() != null && this.iEg.getPbData().ckQ()) {
                yX = this.iEg.yX(0);
            } else {
                yX = this.iEg.yX(this.iHB.cpI());
            }
            if (yX != null) {
                if (!yX.isApp() || (yX = this.iEg.yX(this.iHB.cpI() + 1)) != null) {
                    this.iHB.cpD();
                    this.iHz.a(yX);
                    if (!this.iHz.ayJ()) {
                        this.iHz.ayL();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iHz.ayK();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmL() {
        com.baidu.tieba.pb.data.e pbData = this.iEg.getPbData();
        this.iEg.pX(true);
        if (this.iHz != null) {
            pbData.FI(this.iHz.ayI());
        }
        this.iHB.o(pbData);
    }

    private boolean cmM() {
        if (this.iEg == null) {
            return true;
        }
        if (this.iEg.getPbData() == null || !this.iEg.getPbData().ckQ()) {
            if (this.iEg.ayJ()) {
                final MarkData cnP = this.iEg.cnP();
                if (cnP == null || !this.iEg.getIsFromMark()) {
                    return true;
                }
                final MarkData yX = this.iEg.yX(this.iHB.cpH());
                if (yX == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cnP);
                    this.iGZ.setResult(-1, intent);
                    return true;
                } else if (yX.getPostId() == null || yX.getPostId().equals(cnP.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cnP);
                    this.iGZ.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.sS(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.iHz != null) {
                                if (PbFragment.this.iHz.ayJ()) {
                                    PbFragment.this.iHz.ayK();
                                    PbFragment.this.iHz.fm(false);
                                }
                                PbFragment.this.iHz.a(yX);
                                PbFragment.this.iHz.fm(true);
                                PbFragment.this.iHz.ayL();
                            }
                            cnP.setPostId(yX.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnP);
                            PbFragment.this.iGZ.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.clM();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnP);
                            PbFragment.this.iGZ.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.clM();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.iHB != null && PbFragment.this.iHB.getView() != null) {
                                PbFragment.this.iHB.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cnP);
                                PbFragment.this.iGZ.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.clM();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aEA();
                    return false;
                }
            } else if (this.iEg.getPbData() == null || this.iEg.getPbData().cku() == null || this.iEg.getPbData().cku().size() <= 0 || !this.iEg.getIsFromMark()) {
                return true;
            } else {
                this.iGZ.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.iHB == null) {
            return null;
        }
        return this.iHB.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUx() {
        if (this.iHB == null) {
            return 0;
        }
        return this.iHB.cpU();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUy() {
        if (this.dMm == null) {
            this.dMm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUK */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.azM().isShowImages();
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
                        if (com.baidu.tbadk.core.i.azM().isShowImages()) {
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
        return this.dMm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUz() {
        if (this.dPa == null) {
            this.dPa = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPa;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUA() {
        if (this.dMn == null) {
            this.dMn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bGX */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.azM().isShowImages();
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
                    if (com.baidu.tbadk.core.i.azM().isShowImages()) {
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
                    gifView.aPM();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dMn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUB() {
        if (this.dPb == null) {
            this.dPb = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnj */
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
                    ((PlayVoiceBntNew) view).cMf();
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
        return this.dPb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUD() {
        this.dPd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnk */
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
        return this.dPd;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIg() {
        if (this.djb == null) {
            this.djb = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.djb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iHk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (as.Gh(str) && this.iEg != null && this.iEg.cnw() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").X("obj_param1", 1).cy("post_id", this.iEg.cnw()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.dvC = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            as.cqz().c(getPageContext(), str);
        }
        this.iHk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        as.cqz().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iHk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.iHB != null && this.iHB.cql() != null && rect.top <= this.iHB.cql().getHeight()) {
            rect.top += this.iHB.cql().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.iEg.getPbData();
            TbRichText bj = bj(str, i);
            if (bj != null && (tbRichTextData = bj.aTQ().get(this.iIF)) != null) {
                aVar.postId = String.valueOf(bj.getPostId());
                aVar.iEl = new ArrayList<>();
                aVar.iEm = new ConcurrentHashMap<>();
                if (!tbRichTextData.aTW().aUh()) {
                    aVar.iEo = false;
                    String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                    aVar.iEl.add(b2);
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
                    imageUrlData.mIsReserver = this.iEg.cnN();
                    imageUrlData.mIsSeeHost = this.iEg.getHostMode();
                    aVar.iEm.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cks() != null) {
                            aVar.threadId = pbData.cks().getId();
                        }
                        aVar.iEn = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.iEo = true;
                int size = pbData.cku().size();
                this.iIG = false;
                aVar.index = -1;
                int a2 = pbData.ckz() != null ? a(pbData.ckz().cLa(), bj, i, i, aVar.iEl, aVar.iEm) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cku().get(i2);
                    if (postData.getId() == null || pbData.ckz() == null || pbData.ckz().getId() == null || !postData.getId().equals(pbData.ckz().getId())) {
                        a2 = a(postData.cLa(), bj, a2, i, aVar.iEl, aVar.iEm);
                    }
                }
                if (aVar.iEl.size() > 0) {
                    aVar.lastId = aVar.iEl.get(aVar.iEl.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cks() != null) {
                        aVar.threadId = pbData.cks().getId();
                    }
                    aVar.iEn = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTW() == null) {
            return null;
        }
        return tbRichTextData.aTW().aUm();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTW() == null) {
            return 0L;
        }
        return tbRichTextData.aTW().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTW() == null) {
            return false;
        }
        return tbRichTextData.aTW().aUn();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTW() == null) {
            return false;
        }
        return tbRichTextData.aTW().aUo();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aTW;
        String str;
        if (tbRichText == tbRichText2) {
            this.iIG = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aTQ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aTQ().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aTW().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aTW().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aTW().aUh()) {
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
                            if (tbRichTextData != null && (aTW = tbRichTextData.aTW()) != null) {
                                String aUj = aTW.aUj();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aTW.aUk();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = aUj;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iEg.cnw(), -1L);
                                imageUrlData.mIsReserver = this.iEg.cnN();
                                imageUrlData.mIsSeeHost = this.iEg.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.iIG) {
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
        PostData ckz;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.iEg.aCv())) {
                z = true;
            }
            MarkData l = this.iEg.l(postData);
            if (this.iEg.getPbData() != null && this.iEg.getPbData().ckQ() && (ckz = ckz()) != null) {
                l = this.iEg.l(ckz);
            }
            if (l != null) {
                this.iHB.cpD();
                if (this.iHz != null) {
                    this.iHz.a(l);
                    if (!z) {
                        this.iHz.ayL();
                    } else {
                        this.iHz.ayK();
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
        if (this.iEg == null || this.iEg.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.iEg.getPbData();
        if (pbData.ckz() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.ckz());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cku = pbData.cku();
            c(pbData, cku);
            return c(cku, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.ckD() != null && eVar.ckD().iCQ != null && (list = eVar.ckD().iCQ) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> aTQ;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cLa = arrayList.get(i2).cLa();
            if (cLa != null && (aTQ = cLa.aTQ()) != null) {
                int size = aTQ.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aTQ.get(i4) != null && aTQ.get(i4).getType() == 8) {
                        i3++;
                        if (aTQ.get(i4).aTW().aUj().equals(str) || aTQ.get(i4).aTW().aUk().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aTQ.get(i4).aTW().getWidth() * equipmentDensity;
                            int height = aTQ.get(i4).aTW().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iIF = i4;
                            return cLa;
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
            this.iEc = str;
            if (this.iHf == null) {
                cmv();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.iHf.getItemView(1).setVisibility(8);
            } else {
                this.iHf.getItemView(1).setVisibility(0);
            }
            this.iHf.aEB();
            this.iHk = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.goj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmN() {
        hideNetRefreshView(this.iHB.getView());
        cmO();
        if (this.iEg.cnI()) {
            this.iHB.cpD();
        }
        this.iHB.cpO();
    }

    private void cmO() {
        showLoadingView(this.iHB.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.iHB.cql().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEi() {
        if (this.goj != null) {
            this.goj.stopPlay();
        }
        if (this.iGZ != null) {
            this.iGZ.bEi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cmA(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUC() {
        if (this.dPc == null) {
            this.dPc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnl */
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
        return this.dPc;
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

    public void bEj() {
        if (this.iGZ != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.iGZ.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iGZ.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bCW() {
        if (this.iEg == null || this.iEg.getPbData() == null) {
            return null;
        }
        return this.iEg.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(an.iOT)).intValue();
            if (intValue == an.iOU) {
                if (!this.fKw.cLM()) {
                    this.iHB.cpA();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.fKw.Jg(com.baidu.tbadk.core.util.aq.O(jSONArray));
                    }
                    this.fKw.a(this.iEg.getPbData().getForum().getId(), this.iEg.getPbData().getForum().getName(), this.iEg.getPbData().cks().getId(), str, intValue3, intValue2, booleanValue, this.iEg.getPbData().cks().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.iOV || intValue == an.iOX) {
                if (this.iEg.cnY() != null) {
                    this.iEg.cnY().yI(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.iOV) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iHW);
        userMuteAddAndDelCustomMessage.setTag(this.iHW);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean FR(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString("bubble_link", "");
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
        this.iHI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmP() {
        ArrayList<PostData> cku;
        int count;
        if (this.iEg == null || this.iEg.getPbData() == null || this.iEg.getPbData().cku() == null || (count = com.baidu.tbadk.core.util.v.getCount((cku = this.iEg.getPbData().cku()))) == 0) {
            return "";
        }
        if (this.iEg.cnN()) {
            Iterator<PostData> it = cku.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cKY() == 1) {
                    return next.getId();
                }
            }
        }
        int cpH = this.iHB.cpH();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cku, cpH);
        if (postData == null || postData.aCm() == null) {
            return "";
        }
        if (this.iEg.FV(postData.aCm().getUserId())) {
            return postData.getId();
        }
        for (int i = cpH - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(cku, i);
            if (postData2 == null || postData2.aCm() == null || postData2.aCm().getUserId() == null) {
                break;
            } else if (this.iEg.FV(postData2.aCm().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cpH + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(cku, i2);
            if (postData3 == null || postData3.aCm() == null || postData3.aCm().getUserId() == null) {
                return "";
            }
            if (this.iEg.FV(postData3.aCm().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        this.iHk = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a FS(String str) {
        String str2;
        if (this.iEg.getPbData() == null || this.iEg.getPbData().cku() == null || this.iEg.getPbData().cku().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.iEg.getPbData().cku().size()) {
                i = 0;
                break;
            } else if (str.equals(this.iEg.getPbData().cku().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.iEg.getPbData().cku().get(i);
        if (postData.cLa() == null || postData.cLa().aTQ() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cLa().aTQ().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aTW() != null) {
                    str2 = next.aTW().aUj();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.f.a(postData, aVar);
        return aVar;
    }

    public boolean cmQ() {
        return (!this.iHa && this.iIL == -1 && this.iIM == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null) {
            this.iIO = pVar;
            this.iHa = true;
            this.iHB.cpr();
            this.iHB.Gf(this.iIN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmR() {
        if (this.iIO != null) {
            if (this.iIL == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iIO.getCartoonId(), this.iIL, 0)));
                this.iGZ.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmS() {
        if (this.iIO != null) {
            if (this.iIM == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iIO.getCartoonId(), this.iIM, 0)));
                this.iGZ.finish();
            }
        }
    }

    public int cmT() {
        return this.iIL;
    }

    public int cmU() {
        return this.iIM;
    }

    private void bPU() {
        if (this.iEg != null && this.iEg.getPbData() != null && this.iEg.getPbData().cks() != null && this.iEg.getPbData().cks().aAZ()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cmV() {
        if (this.iEg != null && this.iEg.getPbData() != null && this.iEg.getPbData().cks() != null && this.iEg.getPbData().cks().aAZ()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cmW() {
        if (this.isPaused) {
            this.iHp = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.iEg.getPbData() != null && this.iEg.getPbData().cks() != null && this.iEg.getPbData().cks().aBS() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iEg.getPbData().cks().aBS().getThreadId(), this.iEg.getPbData().cks().aBS().getTaskId(), this.iEg.getPbData().cks().aBS().getForumId(), this.iEg.getPbData().cks().aBS().getForumName(), this.iEg.getPbData().cks().aCh(), this.iEg.getPbData().cks().aCi())));
            this.iHc = true;
            this.iGZ.finish();
        }
    }

    public String cmX() {
        return this.iHn;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cmY() {
        return this.iHx;
    }

    public void pP(boolean z) {
        this.iHo = z;
    }

    public boolean aEa() {
        if (this.iEg != null) {
            return this.iEg.cny();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sS(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.iHU).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.iHU.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iHU).aEA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(String str) {
        if (str == null) {
            str = "";
        }
        if (this.iHU != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iHU.getPageActivity());
            aVar.sS(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iHU).aEA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iHB.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iHU.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.sS(this.iHU.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sS(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.iHB.showLoadingDialog();
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
        aVar.b(this.iHU).aEA();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.Gh(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.gOc) {
            this.gOc = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.iHB != null) {
                this.iHB.onConfigurationChanged(configuration);
            }
            if (this.iHG != null) {
                this.iHG.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cna() {
        if (this.iEg != null) {
            return this.iEg.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.iEg.getPbData().ckD().iCQ;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cKV().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cKV().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cKV().remove(i2);
                    list.get(i).cKX();
                    z = true;
                    break;
                }
            }
            list.get(i).Jb(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.o(this.iEg.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.l lVar) {
        String id = lVar.cld().getId();
        List<PostData> list = this.iEg.getPbData().ckD().iCQ;
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
                ArrayList<PostData> clh = lVar.clh();
                postData.Cv(lVar.getTotalCount());
                if (postData.cKV() != null) {
                    postData.cKV().clear();
                    postData.cKV().addAll(clh);
                }
            }
        }
        if (!this.iEg.getIsFromMark()) {
            this.iHB.o(this.iEg.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a clo() {
        return this.iGZ.clo();
    }

    public boolean clp() {
        if (this.iEg == null) {
            return false;
        }
        return this.iEg.clp();
    }

    public void cnb() {
        if (this.iHB != null) {
            this.iHB.cpe();
            bEj();
        }
    }

    public PostData ckz() {
        return this.iHB.b(this.iEg.iEZ, this.iEg.cnx());
    }

    public void onBackPressed() {
        if (this.iId != null && !this.iId.isEmpty()) {
            int size = this.iId.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.iId.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.iId == null) {
                this.iId = new ArrayList();
            }
            if (!this.iId.contains(aVar)) {
                this.iId.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.iId == null) {
                this.iId = new ArrayList();
            }
            if (!this.iId.contains(aVar)) {
                this.iId.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.iId != null) {
            this.iId.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnc() {
        if (this.iEg != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.iEg.cnw())) {
            com.baidu.tbadk.BdToken.c.axx().o(com.baidu.tbadk.BdToken.b.cGK, com.baidu.adp.lib.f.b.toLong(this.iEg.cnw(), 0L));
        }
    }

    public ax cnd() {
        return this.iHw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT(String str) {
        if (this.iEg != null && this.iEg.getPbData() != null && this.iEg.getPbData().cks() != null && this.iEg.getPbData().cks().aEg()) {
            bj cks = this.iEg.getPbData().cks();
            int i = 0;
            if (cks.aBb()) {
                i = 1;
            } else if (cks.aBc()) {
                i = 2;
            } else if (cks.aEe()) {
                i = 3;
            } else if (cks.aEf()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.X("obj_source", 4);
            anVar.X("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cne() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cnf() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cng() {
        return this.iGZ;
    }
}
