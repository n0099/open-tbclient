package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.support.media.ExifInterface;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes16.dex */
public class az {
    private static final int kLK = UtilHelper.getLightStatusBarHeight();
    public static int kLQ = 3;
    public static int kLR = 0;
    public static int kLS = 3;
    public static int kLT = 4;
    public static int kLU = 5;
    public static int kLV = 6;
    private static a.InterfaceC0806a kMs = new a.InterfaceC0806a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0806a
        public void onRefresh() {
        }
    };
    private EditorTools aay;
    private View boC;
    private RelativeLayout bpu;
    private View bqe;
    private com.baidu.tieba.pb.a.c eFf;
    private View eQZ;
    private f.c esW;
    private NoNetworkView fCm;
    private boolean hSD;
    private View.OnClickListener hVB;
    private List<CustomBlueCheckRadioButton> hma;
    private TextView iTU;
    private PbListView iaL;
    private boolean isLandscape;
    private NavigationBarCoverTip ivI;
    private com.baidu.tieba.NEGFeedBack.e iyZ;
    private com.baidu.tieba.pb.data.f kAA;
    private View.OnClickListener kAq;
    private PbFakeFloorModel kCQ;
    PbFragment.c kEE;
    public int kKB;
    public final com.baidu.tieba.pb.pb.main.view.c kKD;
    public com.baidu.tieba.pb.pb.main.view.b kKE;
    private ViewStub kKF;
    private ViewStub kKG;
    private PbLandscapeListView kKH;
    private PbThreadPostView kKI;
    private com.baidu.tieba.pb.pb.main.a.e kKJ;
    private com.baidu.tieba.pb.pb.main.a.a kKK;
    private com.baidu.tieba.pb.pb.main.a.c kKL;
    private com.baidu.tieba.pb.pb.main.a.d kKM;
    private com.baidu.tieba.pb.pb.main.a.b kKN;
    private LinearLayout kKO;
    private TextView kKP;
    private TextView kKQ;
    private ObservedChangeRelativeLayout kKR;
    private g kKS;
    private View kKY;
    private int kLA;
    private int kLB;
    private PostData kLC;
    private ViewStub kLE;
    private PbInterviewStatusView kLF;
    private FrameLayout kLG;
    private View kLH;
    private View kLI;
    private au kLJ;
    private PbEmotionBar kLO;
    private int kLW;
    private Runnable kLX;
    private v kLY;
    private av kLZ;
    private View kLn;
    private View kLp;
    private View kLq;
    private LinearLayout kLr;
    private HeadImageView kLs;
    private ImageView kLt;
    private ImageView kLu;
    private ImageView kLv;
    private com.baidu.tieba.pb.view.c kLw;
    private TextView kLx;
    private TextView kLy;
    public int kMD;
    private int kMf;
    private PbTopTipView kMg;
    private PopupWindow kMh;
    private TextView kMi;
    private List<String> kMj;
    private com.baidu.tieba.pb.pb.main.emotion.c kMk;
    private com.baidu.tieba.pb.pb.godreply.a kMl;
    private PbLandscapeListView.b kMm;
    private al kMo;
    private String kMp;
    private long kMq;
    private int kMr;
    private boolean kMt;
    private Runnable kMx;
    private PbFragment.b kMz;
    private PbFragment kzt;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private int kKC = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a kKT = null;
    private com.baidu.tbadk.core.dialog.b hVA = null;
    private View kKU = null;
    private EditText kKV = null;
    private com.baidu.tieba.pb.view.d kKW = null;
    private com.baidu.tieba.pb.view.a kKX = null;
    private b.InterfaceC0538b jsL = null;
    private TbRichTextView.i fcy = null;
    private NoNetworkView.a hPZ = null;
    private com.baidu.tbadk.core.dialog.i kKZ = null;
    private com.baidu.tbadk.core.dialog.a kLa = null;
    private Dialog kLb = null;
    private Dialog kLc = null;
    private View kLd = null;
    private LinearLayout kLe = null;
    private CompoundButton.OnCheckedChangeListener hmb = null;
    private TextView kLf = null;
    private TextView kLg = null;
    private String kLh = null;
    private com.baidu.tbadk.core.dialog.i kDD = null;
    private com.baidu.tbadk.core.dialog.i kLi = null;
    private boolean kLj = false;
    private boolean kLk = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView kLl = null;
    private boolean kLm = false;
    private Button kLo = null;
    private boolean kLz = true;
    private com.baidu.tbadk.core.view.a hpW = null;
    private boolean kAi = false;
    private int mSkinType = 3;
    private boolean kLD = false;
    private int kLL = 0;
    private boolean kLM = true;
    public a kLN = new a();
    private int kLP = 0;
    private boolean kMa = false;
    private int kMb = 0;
    private boolean kMc = false;
    private boolean kMd = false;
    private boolean kMe = false;
    private boolean kMn = false;
    private String kMu = null;
    private CustomMessageListener kMv = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.kMu = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.kKS != null) {
                az.this.kKS.notifyDataSetChanged();
            }
        }
    };
    private Handler kMw = new Handler();
    private CustomMessageListener kMy = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.kLz = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean kMA = true;
    View.OnClickListener kMB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.kAA == null || az.this.kAA.cVl() == null || az.this.kAA.cVl().beE() == null || az.this.kAA.cVl().beE().getAlaInfo() == null || az.this.kAA.cVl().beE().getAlaInfo().live_status != 1) {
                if (az.this.kMc) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11923").ai("obj_id", 2));
                }
                if (!az.this.kMc && az.this.kAA != null && az.this.kAA.cVl() != null && az.this.kAA.cVl().beE() != null && az.this.kAA.cVl().beE().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12151").ai("obj_locate", 1));
                }
                if (az.this.kzt.cYi() != null) {
                    az.this.kzt.cYi().kzF.hCj.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c11851");
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
            if (az.this.kAA.cVl().beE().getAlaInfo() == null || !az.this.kAA.cVl().beE().getAlaInfo().isChushou) {
                if (az.this.kAA.cVl().beE().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.kAA.cVl().beE().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.kzt.cYi(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.be.bju().b(az.this.kzt.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.kAA.cVl().beE().getAlaInfo().thirdRoomId + "&livetype=" + az.this.kAA.cVl().beE().getAlaInfo().thirdLiveType});
        }
    };
    private boolean aXX = false;
    String userId = null;
    private final List<TbImageView> kMC = new ArrayList();
    private boolean kME = false;

    /* loaded from: classes16.dex */
    public static class a {
        public int headerCount;
        public au kMS;
        public int kqo;
    }

    public void tq(boolean z) {
        this.kMa = z;
        if (this.kKH != null) {
            this.kMb = this.kKH.getHeaderViewsCount();
        }
    }

    public void dak() {
        if (this.kKH != null) {
            int headerViewsCount = this.kKH.getHeaderViewsCount() - this.kMb;
            final int firstVisiblePosition = (this.kKH.getFirstVisiblePosition() == 0 || this.kKH.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.kKH.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.kKH.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.kLN.kMS = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kLN));
            final au auVar = this.kLN.kMS;
            final int g = g(auVar);
            final int y = ((int) this.kKR.getY()) + this.kKR.getMeasuredHeight();
            final boolean z = this.kLH.getVisibility() == 0;
            boolean z2 = this.kKR.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.kKS.cXb() + this.kKH.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.kKc.getMeasuredHeight() : 0;
                if (z2) {
                    this.kKH.setSelectionFromTop(this.kKS.cXb() + this.kKH.getHeaderViewsCount(), kLK - measuredHeight);
                } else {
                    this.kKH.setSelectionFromTop(this.kKS.cXb() + this.kKH.getHeaderViewsCount(), this.kKD.dch().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.kKH.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.kMc && this.kKJ != null) {
                this.kKH.setSelectionFromTop(this.kKS.cXb() + this.kKH.getHeaderViewsCount(), this.kKJ.dbT());
            } else if (this.mType == 6) {
                this.kKH.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= az.this.bpu.getMeasuredHeight()) {
                            int g2 = az.this.g(auVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (az.this.bqe != null && (layoutParams = az.this.bqe.getLayoutParams()) != null) {
                                if (i == 0 || i > az.this.bpu.getMeasuredHeight() || g2 >= az.this.bpu.getMeasuredHeight()) {
                                    layoutParams.height = az.this.kLW;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bpu.getMeasuredHeight()) {
                                    layoutParams.height = az.this.kLW;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.kKH.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bqe.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bqe != null && az.this.bqe.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bqe.getLayoutParams();
                                            layoutParams2.height = az.this.kLW;
                                            az.this.bqe.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.kKH.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(au auVar) {
        if (auVar == null || auVar.getView() == null) {
            return 0;
        }
        if (auVar.getView().getTop() != 0 || auVar.getView().isShown()) {
            return auVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView dal() {
        return this.fCm;
    }

    public void dam() {
        if (this.aay != null) {
            this.aay.hide();
            if (this.kMk != null) {
                this.kMk.dbV();
            }
        }
    }

    public PbFakeFloorModel dan() {
        return this.kCQ;
    }

    public v dao() {
        return this.kLY;
    }

    public com.baidu.tieba.pb.pb.main.a.e dap() {
        return this.kKJ;
    }

    public void daq() {
        reset();
        dam();
        this.kLY.cXj();
        tC(false);
    }

    private void reset() {
        if (this.kzt != null && this.kzt.cXo() != null && this.aay != null) {
            com.baidu.tbadk.editortools.pb.a.brT().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cXo = this.kzt.cXo();
            cXo.bso();
            cXo.brG();
            if (cXo.getWriteImagesInfo() != null) {
                cXo.getWriteImagesInfo().setMaxImagesAllowed(cXo.isBJH ? 1 : 9);
            }
            cXo.qk(SendView.ALL);
            cXo.ql(SendView.ALL);
            com.baidu.tbadk.editortools.h qb = this.aay.qb(23);
            com.baidu.tbadk.editortools.h qb2 = this.aay.qb(2);
            com.baidu.tbadk.editortools.h qb3 = this.aay.qb(5);
            if (qb2 != null) {
                qb2.display();
            }
            if (qb3 != null) {
                qb3.display();
            }
            if (qb != null) {
                qb.hide();
            }
            this.aay.invalidate();
        }
    }

    public boolean dar() {
        return this.kLz;
    }

    public void tr(boolean z) {
        if (this.kLq != null && this.iTU != null) {
            this.iTU.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kLq.startAnimation(alphaAnimation);
            }
            this.kLp.setVisibility(0);
            this.kLq.setVisibility(0);
            this.kLz = true;
            if (this.kLO != null && !this.kMl.isActive()) {
                this.kLO.setVisibility(0);
                tw(true);
            }
        }
    }

    public void ts(boolean z) {
        if (this.kLq != null && this.iTU != null) {
            this.iTU.setText(das());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kLq.startAnimation(alphaAnimation);
            }
            this.kLp.setVisibility(0);
            this.kLq.setVisibility(0);
            this.kLz = true;
            if (this.kLO != null && !this.kMl.isActive()) {
                this.kLO.setVisibility(0);
                tw(true);
            }
        }
    }

    public String das() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.kMp)) {
            return this.kMp;
        }
        if (this.kzt != null) {
            this.kMp = TbadkCoreApplication.getInst().getResources().getString(ay.dah());
        }
        return this.kMp;
    }

    public PostData dat() {
        int i = 0;
        if (this.kKH == null) {
            return null;
        }
        int dau = dau() - this.kKH.getHeaderViewsCount();
        if (dau < 0) {
            dau = 0;
        }
        if (this.kKS.DV(dau) != null && this.kKS.DV(dau) != PostData.meM) {
            i = dau + 1;
        }
        return this.kKS.getItem(i) instanceof PostData ? (PostData) this.kKS.getItem(i) : null;
    }

    public int dau() {
        int i;
        View childAt;
        if (this.kKH == null) {
            return 0;
        }
        int firstVisiblePosition = this.kKH.getFirstVisiblePosition();
        int lastVisiblePosition = this.kKH.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.kKH.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.kKH.getChildAt(i3 - firstVisiblePosition)) != null) {
                    childAt.getGlobalVisibleRect(rect);
                    iArr[i3 - firstVisiblePosition] = rect.height();
                }
                i2 += iArr[i3 - firstVisiblePosition];
            }
            int i4 = i2 / 2;
            int i5 = 0;
            for (int i6 = 0; i6 < iArr.length; i6++) {
                i5 += iArr[i6];
                if (i5 > i4) {
                    i = i6 + firstVisiblePosition;
                    break;
                }
            }
        }
        i = firstVisiblePosition;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public int dav() {
        return this.kKH.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.kAA != null && this.kAA.cVn() != null && !this.kAA.cVn().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.kAA.cVn().size() && (postData = this.kAA.cVn().get(i)) != null && postData.beE() != null && !StringUtils.isNull(postData.beE().getUserId()); i++) {
                if (this.kAA.cVn().get(i).beE().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.kMl != null && this.kMl.isActive()) {
                        tC(false);
                    }
                    if (this.kLO != null) {
                        this.kLO.tM(true);
                    }
                    this.kMu = postData.beE().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.kzt = null;
        this.bpu = null;
        this.boC = null;
        this.kKH = null;
        this.kKS = null;
        this.iaL = null;
        this.eQZ = null;
        this.hVB = null;
        this.kAq = null;
        this.kLq = null;
        this.iTU = null;
        this.kLE = null;
        this.kMf = 0;
        this.kMq = 0L;
        this.kMq = System.currentTimeMillis();
        this.kzt = pbFragment;
        this.hVB = onClickListener;
        this.eFf = cVar;
        this.kMf = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kzt.getContext()) / 8;
        this.bpu = (RelativeLayout) LayoutInflater.from(this.kzt.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bpu.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.kLn = this.bpu.findViewById(R.id.bottom_shadow);
        this.ivI = (NavigationBarCoverTip) this.bpu.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.boC = this.bpu.findViewById(R.id.statebar_view);
        this.kKR = (ObservedChangeRelativeLayout) this.bpu.findViewById(R.id.title_wrapper);
        this.fCm = (NoNetworkView) this.bpu.findViewById(R.id.view_no_network);
        this.kKH = (PbLandscapeListView) this.bpu.findViewById(R.id.new_pb_list);
        this.kLG = (FrameLayout) this.bpu.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.kzt.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kzt.getActivity(), R.dimen.ds88));
        this.kKH.addHeaderView(this.textView, 0);
        this.kKH.setTextViewAdded(true);
        this.kLW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bqe = new View(this.kzt.getPageContext().getPageActivity());
        this.bqe.setLayoutParams(new AbsListView.LayoutParams(-1, this.kLW));
        this.bqe.setVisibility(4);
        this.kKH.addFooterView(this.bqe);
        this.kKH.setOnTouchListener(this.kzt.eVD);
        this.kKD = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bpu);
        if (this.kzt.cXR()) {
            this.kKF = (ViewStub) this.bpu.findViewById(R.id.manga_view_stub);
            this.kKF.setVisibility(0);
            this.kKE = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.kKE.show();
            this.kKD.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kzt.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.kKD.dch().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0761a() { // from class: com.baidu.tieba.pb.pb.main.az.26
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0761a
            public void cWn() {
                if (az.this.kKH != null) {
                    if (az.this.kKJ != null) {
                        az.this.kKJ.dbS();
                    }
                    az.this.kKH.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0761a
            public void cWo() {
                az.this.kzt.cms();
            }
        }));
        this.kLp = this.bpu.findViewById(R.id.view_comment_top_line);
        this.kLq = this.bpu.findViewById(R.id.pb_editor_tool_comment);
        this.kLA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kLB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kLs = (HeadImageView) this.bpu.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kLs.setVisibility(0);
        this.kLs.setIsRound(true);
        this.kLs.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.kzt.getContext(), R.dimen.tbds1));
        this.kLs.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
        this.kLs.setPlaceHolder(1);
        this.kLs.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kLs.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.iTU = (TextView) this.bpu.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kLr = (LinearLayout) this.bpu.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.kzt.cXz();
                if (az.this.kzt != null && az.this.kzt.cWD() != null && az.this.kzt.cWD().getPbData() != null && az.this.kzt.cWD().getPbData().cVl() != null && az.this.kzt.cWD().getPbData().cVl().beE() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13701").dD("tid", az.this.kzt.cWD().cYC()).dD("fid", az.this.kzt.cWD().getPbData().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", az.this.kzt.cWD().kGK).dD("fid", az.this.kzt.cWD().getPbData().getForumId()).ai("obj_locate", 1).dD("uid", az.this.kzt.cWD().getPbData().cVl().beE().getUserId()));
                }
            }
        });
        this.kLt = (ImageView) this.bpu.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kLt.setOnClickListener(this.hVB);
        boolean booleanExtra = this.kzt.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kLu = (ImageView) this.bpu.findViewById(R.id.pb_editor_tool_collection);
        this.kLu.setOnClickListener(this.hVB);
        if (booleanExtra) {
            this.kLu.setVisibility(8);
        } else {
            this.kLu.setVisibility(0);
        }
        this.kLv = (ImageView) this.bpu.findViewById(R.id.pb_editor_tool_share);
        this.kLv.setOnClickListener(this.hVB);
        this.kLw = new com.baidu.tieba.pb.view.c(this.kLv);
        this.kLw.dfA();
        this.kLx = (TextView) this.bpu.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.kLx.setVisibility(0);
        this.kLE = (ViewStub) this.bpu.findViewById(R.id.interview_status_stub);
        this.kKK = new com.baidu.tieba.pb.pb.main.a.a(this.kzt, cVar);
        this.kKM = new com.baidu.tieba.pb.pb.main.a.d(this.kzt, cVar, this.hVB);
        this.kKS = new g(this.kzt, this.kKH);
        this.kKS.F(this.hVB);
        this.kKS.setTbGestureDetector(this.eFf);
        this.kKS.setOnImageClickListener(this.fcy);
        this.kKS.setOnSwitchChangeListener(this.kzt.kEx);
        this.kAq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            az.this.kzt.c(sparseArray);
                            return;
                        }
                        az.this.cT(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.kzt.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.kKS.S(this.kAq);
        daA();
        daB();
        this.kKM.b(this.kKH);
        this.kKL.b(this.kKH);
        this.kKK.b(this.kKH);
        this.iaL = new PbListView(this.kzt.getPageContext().getPageActivity());
        this.eQZ = this.iaL.getView().findViewById(R.id.pb_more_view);
        if (this.eQZ != null) {
            this.eQZ.setOnClickListener(this.hVB);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.eQZ, R.drawable.pb_foot_more_trans_selector);
        }
        this.iaL.setLineVisible();
        this.iaL.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iaL.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.kKY = this.bpu.findViewById(R.id.viewstub_progress);
        this.kzt.registerListener(this.kMy);
        this.kCQ = new PbFakeFloorModel(this.kzt.getPageContext());
        this.kLY = new v(this.kzt.getPageContext(), this.kCQ, this.bpu);
        this.kLY.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.daq();
            }
        });
        this.kLY.a(this.kzt.kEz);
        this.kCQ.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.kCQ.t(postData);
                az.this.kKS.notifyDataSetChanged();
                az.this.kLY.cXj();
                az.this.aay.bpX();
                az.this.tC(false);
            }
        });
        if (this.kzt.cWD() != null && !StringUtils.isNull(this.kzt.cWD().cZk())) {
            this.kzt.showToast(this.kzt.cWD().cZk());
        }
        this.kLH = this.bpu.findViewById(R.id.pb_expand_blank_view);
        this.kLI = this.bpu.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kLI.getLayoutParams();
        if (this.kzt.cWD() != null && this.kzt.cWD().cYF()) {
            this.kLH.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.kLI.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = kLK;
            this.kLI.setLayoutParams(layoutParams2);
        }
        this.kLJ = new au(this.kzt.getPageContext(), this.bpu.findViewById(R.id.pb_reply_expand_view));
        this.kLJ.w(pbFragment.kDu);
        this.kLJ.kKc.setVisibility(8);
        this.kLJ.U(this.hVB);
        this.kLJ.setOnSwitchChangeListener(this.kzt.kEx);
        this.kzt.registerListener(this.mAccountChangedListener);
        this.kzt.registerListener(this.kMv);
        daw();
        tw(false);
    }

    public void tt(boolean z) {
        this.kLn.setVisibility(z ? 0 : 8);
    }

    public void czd() {
        if (!this.kzt.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").ai("obj_locate", 2).dD("fid", this.mForumId));
        } else if (this.kzt.cXB()) {
            com.baidu.tbadk.editortools.pb.e cXo = this.kzt.cXo();
            if (cXo != null && (cXo.bsl() || cXo.bsm())) {
                this.kzt.cXo().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.aay != null) {
                daG();
            }
            if (this.aay != null) {
                this.kLz = false;
                if (this.aay.qe(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.kzt.getPageContext(), (View) this.aay.qe(2).eKx, false, kMs);
                }
            }
            dbo();
        }
    }

    private void daw() {
        this.kMl = new com.baidu.tieba.pb.pb.godreply.a(this.kzt, this, (ViewStub) this.bpu.findViewById(R.id.more_god_reply_popup));
        this.kMl.A(this.hVB);
        this.kMl.S(this.kAq);
        this.kMl.setOnImageClickListener(this.fcy);
        this.kMl.A(this.hVB);
        this.kMl.setTbGestureDetector(this.eFf);
    }

    public com.baidu.tieba.pb.pb.godreply.a dax() {
        return this.kMl;
    }

    public View day() {
        return this.kLH;
    }

    public void daz() {
        if (this.kKH != null) {
            this.kKL.c(this.kKH);
            this.kKM.c(this.kKH);
            this.kKN.c(this.kKH);
            this.kKK.c(this.kKH);
        }
    }

    private void daA() {
        if (this.kKN == null) {
            this.kKN = new com.baidu.tieba.pb.pb.main.a.b(this.kzt, this.hVB);
        }
    }

    private void daB() {
        if (this.kKL == null) {
            this.kKL = new com.baidu.tieba.pb.pb.main.a.c(this.kzt, this.eFf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daC() {
        if (this.kzt.cXR()) {
            this.kKG = (ViewStub) this.bpu.findViewById(R.id.manga_mention_controller_view_stub);
            this.kKG.setVisibility(0);
            if (this.kKO == null) {
                this.kKO = (LinearLayout) this.bpu.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.kzt.getPageContext(), this.kKO);
            }
            if (this.kKP == null) {
                this.kKP = (TextView) this.kKO.findViewById(R.id.manga_prev_btn);
            }
            if (this.kKQ == null) {
                this.kKQ = (TextView) this.kKO.findViewById(R.id.manga_next_btn);
            }
            this.kKP.setOnClickListener(this.hVB);
            this.kKQ.setOnClickListener(this.hVB);
        }
    }

    private void daD() {
        if (this.kzt.cXR()) {
            if (this.kzt.cXU() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKP, R.color.cp_cont_e, 1);
            }
            if (this.kzt.cXV() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKQ, R.color.cp_cont_e, 1);
            }
        }
    }

    public void daE() {
        if (this.kKO == null) {
            daC();
        }
        this.kKG.setVisibility(8);
        if (this.kMw != null && this.kMx != null) {
            this.kMw.removeCallbacks(this.kMx);
        }
    }

    public void daF() {
        if (this.kMw != null) {
            if (this.kMx != null) {
                this.kMw.removeCallbacks(this.kMx);
            }
            this.kMx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.kKO == null) {
                        az.this.daC();
                    }
                    az.this.kKG.setVisibility(0);
                }
            };
            this.kMw.postDelayed(this.kMx, 2000L);
        }
    }

    public void tu(boolean z) {
        this.kKD.tu(z);
        if (z && this.kLD) {
            this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.kKH.setNextPage(this.iaL);
            this.kKC = 2;
        }
        if (this.kLs != null) {
            this.kLs.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
        this.aay.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.daq();
            }
        });
        this.aay.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.aay.getParent() == null) {
            this.bpu.addView(this.aay, layoutParams);
        }
        this.aay.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.aay.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.az.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.t) {
                    if (((com.baidu.tbadk.coreExtra.data.t) aVar.data).bmP() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.t) aVar.data).bmP() == EmotionGroupType.USER_COLLECT) {
                        if (az.this.mPermissionJudgePolicy == null) {
                            az.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        az.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.kzt.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.kzt.getBaseFragmentActivity())) {
                            az.this.kzt.cXo().c((com.baidu.tbadk.coreExtra.data.t) aVar.data);
                            az.this.kzt.cXo().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dam();
        this.kzt.cXo().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.aay != null && az.this.aay.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.kMk == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.aay.getId());
                            az.this.kMk = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.kzt.getPageContext(), az.this.bpu, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(az.this.kMj)) {
                                az.this.kMk.setData(az.this.kMj);
                            }
                            az.this.kMk.c(az.this.aay);
                        }
                        az.this.kMk.NP(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.kzt.jJC != null && az.this.kzt.jJC.dbE() != null) {
                    if (!az.this.kzt.jJC.dbE().dFx()) {
                        az.this.kzt.jJC.tI(false);
                    }
                    az.this.kzt.jJC.dbE().wY(false);
                }
            }
        });
    }

    public void daG() {
        if (this.kzt != null && this.aay != null) {
            this.aay.display();
            if (this.kzt.cXo() != null) {
                this.kzt.cXo().bsb();
            }
            dbo();
        }
    }

    public void tv(boolean z) {
        if (this.kKH != null && this.textView != null && this.boC != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.boC.setVisibility(0);
                } else {
                    this.boC.setVisibility(8);
                    this.kKH.removeHeaderView(this.textView);
                    this.kKH.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = kLK;
                    this.textView.setLayoutParams(layoutParams);
                }
                daU();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + tE(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            daU();
            dbw();
        }
    }

    public g daH() {
        return this.kKS;
    }

    public void a(PbFragment.c cVar) {
        this.kEE = cVar;
    }

    public void cT(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kzt.getContext());
        kVar.setTitleText(this.kzt.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kKZ.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (az.this.kMz != null) {
                                az.this.kMz.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            az.this.kzt.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kzt.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kzt.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dbv()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.kzt.getString(R.string.forbidden_person), kVar);
            gVar3.mTextView.setTag(sparseArray3);
            arrayList.add(gVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
            if (z) {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kzt.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kzt.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aT(arrayList);
        this.kKZ = new com.baidu.tbadk.core.dialog.i(this.kzt.getPageContext(), kVar);
        this.kKZ.Nv();
    }

    public void a(PbFragment.b bVar) {
        this.kMz = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kzt != null && aVar != null) {
            if (this.iyZ == null && this.kKK != null) {
                this.iyZ = new com.baidu.tieba.NEGFeedBack.e(this.kzt.getPageContext(), this.kKK.dbO());
            }
            AntiData ckT = this.kzt.ckT();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ckT != null && ckT.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckT.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.iyZ.setDefaultReasonArray(new String[]{this.kzt.getString(R.string.delete_thread_reason_1), this.kzt.getString(R.string.delete_thread_reason_2), this.kzt.getString(R.string.delete_thread_reason_3), this.kzt.getString(R.string.delete_thread_reason_4), this.kzt.getString(R.string.delete_thread_reason_5)});
            this.iyZ.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.iyZ.De(str);
            this.iyZ.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    az.this.kzt.a(aVar, jSONArray);
                }
            });
        }
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(kLR, Integer.valueOf(kLS));
        int i3 = R.string.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = R.string.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = R.string.report_thread_confirm;
            } else {
                i3 = R.string.del_thread_confirm;
            }
        }
        this.kLa = new com.baidu.tbadk.core.dialog.a(this.kzt.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kLa.nt(i3);
        } else {
            this.kLa.setOnlyMessageShowCenter(false);
            this.kLa.zz(str2);
        }
        this.kLa.setYesButtonTag(sparseArray);
        this.kLa.a(R.string.dialog_ok, this.kzt);
        this.kLa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kLa.m39if(true);
        this.kLa.b(this.kzt.getPageContext());
        if (z) {
            this.kLa.bhg();
        } else {
            a(this.kLa, i);
        }
    }

    public void aX(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.kLd == null) {
            this.kLd = LayoutInflater.from(this.kzt.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kzt.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kLd);
        if (this.kLc == null) {
            this.kLc = new Dialog(this.kzt.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kLc.setCanceledOnTouchOutside(true);
            this.kLc.setCancelable(true);
            this.kLl = (ScrollView) this.kLd.findViewById(R.id.good_scroll);
            this.kLc.setContentView(this.kLd);
            WindowManager.LayoutParams attributes = this.kLc.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kLc.getWindow().setAttributes(attributes);
            this.hmb = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.kLh = (String) compoundButton.getTag();
                        if (az.this.hma != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.hma) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.kLh != null && !str.equals(az.this.kLh)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kLe = (LinearLayout) this.kLd.findViewById(R.id.good_class_group);
            this.kLg = (TextView) this.kLd.findViewById(R.id.dialog_button_cancel);
            this.kLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.kLc instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.kLc, az.this.kzt.getPageContext());
                    }
                }
            });
            this.kLf = (TextView) this.kLd.findViewById(R.id.dialog_button_ok);
            this.kLf.setOnClickListener(this.hVB);
        }
        this.kLe.removeAllViews();
        this.hma = new ArrayList();
        CustomBlueCheckRadioButton ft = ft("0", this.kzt.getPageContext().getString(R.string.thread_good_class));
        this.hma.add(ft);
        ft.setChecked(true);
        this.kLe.addView(ft);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bcS()) && ajVar.bcT() > 0) {
                    CustomBlueCheckRadioButton ft2 = ft(String.valueOf(ajVar.bcT()), ajVar.bcS());
                    this.hma.add(ft2);
                    View view = new View(this.kzt.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kLe.addView(view);
                    this.kLe.addView(ft2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kLl.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kzt.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kzt.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kzt.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kLl.setLayoutParams(layoutParams2);
            this.kLl.removeAllViews();
            if (this.kLe != null && this.kLe.getParent() == null) {
                this.kLl.addView(this.kLe);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kLc, this.kzt.getPageContext());
    }

    private CustomBlueCheckRadioButton ft(String str, String str2) {
        Activity pageActivity = this.kzt.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hmb);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void daI() {
        this.kzt.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.kzt.hideProgressBar();
        if (z && z2) {
            this.kzt.showToast(this.kzt.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.kzt.showToast(str);
        }
    }

    public void cGw() {
        this.kKY.setVisibility(0);
    }

    public void cGv() {
        this.kKY.setVisibility(8);
    }

    public View daJ() {
        if (this.kLd != null) {
            return this.kLd.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String daK() {
        return this.kLh;
    }

    public View getView() {
        return this.bpu;
    }

    public void daL() {
        if (this.kzt != null && this.kzt.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kzt.getPageContext().getPageActivity(), this.kzt.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.kzt.hideProgressBar();
        if (z) {
            dbe();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dbf();
        } else {
            dbe();
        }
    }

    public void daM() {
        this.iaL.setLineVisible();
        this.iaL.startLoadData();
    }

    public void daN() {
        this.kzt.hideProgressBar();
        endLoadData();
        this.kKH.completePullRefreshPostDelayed(0L);
        daZ();
    }

    public void daO() {
        this.kKH.completePullRefreshPostDelayed(0L);
        daZ();
    }

    private void tw(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.kKM.b(onLongClickListener);
        this.kKS.setOnLongClickListener(onLongClickListener);
        if (this.kMl != null) {
            this.kMl.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0538b interfaceC0538b, boolean z, boolean z2) {
        if (this.kDD != null) {
            this.kDD.dismiss();
            this.kDD = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kzt.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kzt.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kzt.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kzt.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kzt.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aT(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kLi.dismiss();
                interfaceC0538b.a(null, i, view);
            }
        });
        this.kLi = new com.baidu.tbadk.core.dialog.i(this.kzt.getPageContext(), kVar);
        this.kLi.Nv();
    }

    public void a(final b.InterfaceC0538b interfaceC0538b, boolean z) {
        if (this.kLi != null) {
            this.kLi.dismiss();
            this.kLi = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kzt.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kAA != null && this.kAA.cVl() != null && !this.kAA.cVl().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kzt.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kzt.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aT(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kLi.dismiss();
                interfaceC0538b.a(null, i, view);
            }
        });
        this.kLi = new com.baidu.tbadk.core.dialog.i(this.kzt.getPageContext(), kVar);
        this.kLi.Nv();
    }

    public int daP() {
        return Eu(this.kKH.getFirstVisiblePosition());
    }

    private int Eu(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.kKH.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.kKH.getAdapter() == null || !(this.kKH.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.kKH.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int daQ() {
        int lastVisiblePosition = this.kKH.getLastVisiblePosition();
        if (this.kKJ != null) {
            if (lastVisiblePosition == this.kKH.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return Eu(lastVisiblePosition);
    }

    public void Ev(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.kKH != null) {
            if (this.kKD == null || this.kKD.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.kKD.mNavigationBar.getFixedNavHeight();
                if (this.kzt.cXH() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.kLI != null && (layoutParams = (LinearLayout.LayoutParams) this.kLI.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.kLI.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.kKH.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.kKH.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.kKH.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.kKV.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.kKS.a(fVar, false);
        this.kKS.notifyDataSetChanged();
        daZ();
        if (this.kMl != null) {
            this.kMl.cWz();
        }
        ArrayList<PostData> cVn = fVar.cVn();
        if (fVar.getPage().bdu() == 0 || cVn == null || cVn.size() < fVar.getPage().bdt()) {
            if (com.baidu.tbadk.core.util.y.getCount(cVn) == 0 || (com.baidu.tbadk.core.util.y.getCount(cVn) == 1 && cVn.get(0) != null && cVn.get(0).dwF() == 1)) {
                if (this.kLN == null || this.kLN.kMS == null || this.kLN.kMS.getView() == null) {
                    i = 0;
                } else {
                    i = this.kLN.kMS.getView().getTop() < 0 ? this.kLN.kMS.getView().getHeight() : this.kLN.kMS.getView().getBottom();
                }
                if (this.kzt.cYb()) {
                    this.iaL.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.iaL.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bdu() == 0) {
                    this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iaL.bkw();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.kKK != null) {
            this.kKK.e(fVar, this.kAi);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cVy() != null) {
            return fVar.cVy();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.cVn())) {
            Iterator<PostData> it = fVar.cVn().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dwF() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cVu();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.beE() != null && postData.beE().getUserTbVipInfoData() != null && postData.beE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.beE().getGodUserData().setIntro(postData.beE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.beE() == null) {
            return false;
        }
        MetaData beE = postData.beE();
        return (TextUtils.isEmpty(beE.getUserId()) && TextUtils.isEmpty(beE.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cVl() == null || fVar.cVl().beE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData beE = fVar.cVl().beE();
        String userId = beE.getUserId();
        HashMap<String, MetaData> userMap = fVar.cVl().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = beE;
        }
        postData.HP(1);
        postData.setId(fVar.cVl().beV());
        postData.setTitle(fVar.cVl().getTitle());
        postData.setTime(fVar.cVl().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.cVl() != null) {
            if (this.kzt.cWt()) {
                if (fVar.cVk() != null) {
                    this.mForumName = fVar.cVk().getForumName();
                    this.mForumId = fVar.cVk().getForumId();
                }
                if (this.mForumName == null && this.kzt.cWD() != null && this.kzt.cWD().cWu() != null) {
                    this.mForumName = this.kzt.cWD().cWu();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.kKM.setVisibility(8);
            if (fVar.cVL()) {
                this.kMc = true;
                this.kKD.sB(true);
                this.kKD.mNavigationBar.hideBottomLine();
                if (this.kKJ == null) {
                    this.kKJ = new com.baidu.tieba.pb.pb.main.a.e(this.kzt);
                }
                this.kKJ.a(fVar, b, this.kKH, this.kKM, this.kLG, this.kKD, this.mForumName, this.kMq);
                this.kKJ.V(this.kMB);
                daU();
            } else {
                this.kMc = false;
                this.kKD.sB(this.kMc);
                if (this.kKJ != null) {
                    this.kKJ.c(this.kKH);
                }
            }
            if (this.kzt.cXr() != null) {
                this.kzt.cXr().tN(this.kMc);
            }
            if (b != null) {
                this.kLC = b;
                this.kKM.setVisibility(0);
                SparseArray<Object> dbR = this.kKM.dbR();
                dbR.put(R.id.tag_clip_board, b);
                dbR.put(R.id.tag_is_subpb, false);
                this.kKN.a(fVar, this.kKH);
                this.kKL.A(fVar);
                this.kKK.e(fVar, this.kAi);
                this.kKK.z(fVar);
                this.kKM.a(this.mSkinType, this.kAA, b, this.kMB);
                if (this.kLJ != null) {
                    if (fVar.cVO()) {
                        this.kLJ.getView().setVisibility(8);
                    } else {
                        this.kLJ.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kxY);
                        if (fVar.cVl() != null) {
                            nVar.kya = fVar.cVl().bev();
                        }
                        nVar.isNew = !this.kAi;
                        nVar.sortType = fVar.kwI;
                        nVar.kyc = fVar.cVP();
                        nVar.kyd = this.kzt.cYb();
                        nVar.kye = fVar.kwH;
                        this.kLJ.a(nVar);
                    }
                }
                if (fVar != null && fVar.cVl() != null) {
                    ap(fVar.cVl().beA() == 1, fVar.cVl().bez() == 1);
                }
                com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.kKS != null && az.this.kKD != null && az.this.kKD.kQT != null && az.this.kAA != null && az.this.kAA.cVl() != null && !az.this.kAA.cVl().bdk() && !az.this.daY() && az.this.kAA.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(az.this.kAA.getForum().getName())) {
                            if ((az.this.kKS.cXf() == null || !az.this.kKS.cXf().isShown()) && az.this.kKD.kQT != null) {
                                az.this.kKD.kQT.setVisibility(0);
                                if (az.this.kzt != null && az.this.kzt.cWD() != null) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13400");
                                    aqVar.dD("tid", az.this.kzt.cWD().cYB());
                                    aqVar.dD("fid", az.this.kzt.cWD().getForumId());
                                    aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void tx(boolean z) {
        if (z) {
            daR();
        } else {
            cfP();
        }
        this.kLN.kMS = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kLN));
        a(this.kLN.kMS, false);
    }

    public void daR() {
        if (this.kKD != null && !this.kMe) {
            this.kKD.daR();
            this.kMe = true;
        }
    }

    public void cfP() {
        if (this.kKD != null) {
            this.kKD.dcp();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.kKM.a(postData, fVar);
    }

    public void daS() {
        if (this.kKJ != null) {
            this.kKJ.d(this.kKH);
        }
    }

    public boolean daT() {
        return this.aXX;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aJ(bw bwVar) {
        if (bwVar == null || bwVar.beE() == null) {
            return false;
        }
        PostData b = b(this.kAA, false);
        String str = "";
        if (b != null && b.beE() != null) {
            str = b.beE().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.kKD.dcn();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.kKD.Ly(dVar.forumName);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.f.b.toInt(dVar.source, 0)) {
                case 100:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
                    break;
                case 300:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = dVar.kwz;
            this.kzt.showNetRefreshView(this.bpu, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.be.bju().b(az.this.kzt.getPageContext(), new String[]{str2});
                        az.this.kzt.finish();
                        return;
                    }
                    az.this.kzt.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cZX;
        Parcelable cZX2;
        if (fVar != null && this.kKH != null) {
            this.kAA = fVar;
            this.mType = i;
            if (fVar.cVl() != null) {
                this.kLP = fVar.cVl().bel();
                if (fVar.cVl().getAnchorLevel() != 0) {
                    this.aXX = true;
                }
                this.kLk = aJ(fVar.cVl());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.kLD = false;
            this.kAi = z;
            daN();
            if (fVar.kwJ != null && fVar.kwJ.cVU()) {
                if (this.kKI == null) {
                    this.kKI = new PbThreadPostView(this.kzt.getContext());
                    this.kKH.addHeaderView(this.kKI, 1);
                    this.kKI.setData(fVar);
                    this.kKI.setChildOnClickLinstener(this.hVB);
                }
            } else if (this.kKI != null && this.kKH != null) {
                this.kKH.removeHeaderView(this.kKI);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.kMo == null) {
                this.kMo = new al(this.kzt.getPageContext(), this.ivI);
            }
            this.kMo.NF(fVar.cVs());
            if (this.kzt.cXR()) {
                if (this.kKW == null) {
                    this.kKW = new com.baidu.tieba.pb.view.d(this.kzt.getPageContext());
                    this.kKW.createView();
                    this.kKW.setListPullRefreshListener(this.esW);
                }
                this.kKH.setPullRefresh(this.kKW);
                daU();
                if (this.kKW != null) {
                    this.kKW.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bdv() == 0 && z) {
                this.kKH.setPullRefresh(null);
            } else {
                if (this.kKW == null) {
                    this.kKW = new com.baidu.tieba.pb.view.d(this.kzt.getPageContext());
                    this.kKW.createView();
                    this.kKW.setListPullRefreshListener(this.esW);
                }
                this.kKH.setPullRefresh(this.kKW);
                daU();
                if (this.kKW != null) {
                    this.kKW.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bWq();
            }
            daZ();
            this.kKS.sE(this.kAi);
            this.kKS.sF(false);
            this.kKS.sJ(i == 5);
            this.kKS.sK(i == 6);
            this.kKS.sL(z2 && this.kMA && i != 2);
            this.kKS.a(fVar, false);
            this.kKS.notifyDataSetChanged();
            this.kKM.b(b(fVar, z), fVar.cVO());
            if (fVar.cVl() != null && fVar.cVl().bep() != null && this.kKB != -1) {
                fVar.cVl().bep().setIsLike(this.kKB);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.kKH.setNextPage(this.iaL);
                this.kKC = 2;
                bWq();
            } else {
                this.kLD = true;
                if (fVar.getPage().bdu() == 1) {
                    if (this.kKX == null) {
                        this.kKX = new com.baidu.tieba.pb.view.a(this.kzt, this.kzt);
                    }
                    this.kKH.setNextPage(this.kKX);
                } else {
                    this.kKH.setNextPage(this.iaL);
                }
                this.kKC = 3;
            }
            ArrayList<PostData> cVn = fVar.cVn();
            if (fVar.getPage().bdu() == 0 || cVn == null || cVn.size() < fVar.getPage().bdt()) {
                if (com.baidu.tbadk.core.util.y.getCount(cVn) == 0 || (com.baidu.tbadk.core.util.y.getCount(cVn) == 1 && cVn.get(0) != null && cVn.get(0).dwF() == 1)) {
                    if (this.kLN == null || this.kLN.kMS == null || this.kLN.kMS.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.kLN.kMS.getView().getTop() < 0 ? this.kLN.kMS.getView().getHeight() : this.kLN.kMS.getView().getBottom();
                    }
                    if (this.kzt.cYb()) {
                        this.iaL.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.iaL.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.kzt.cXr() != null && !this.kzt.cXr().dcb()) {
                        this.kzt.cXr().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bdu() == 0) {
                        this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iaL.bkw();
                }
                if (fVar.getPage().bdu() == 0 || cVn == null) {
                    dbj();
                }
            } else {
                if (z2) {
                    if (this.kMA) {
                        endLoadData();
                        if (fVar.getPage().bdu() != 0) {
                            this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iaL.setLineVisible();
                        this.iaL.showLoading();
                    }
                } else {
                    this.iaL.setLineVisible();
                    this.iaL.showLoading();
                }
                this.iaL.bkw();
            }
            switch (i) {
                case 2:
                    this.kKH.setSelection(i2 > 1 ? (((this.kKH.getData() == null && fVar.cVn() == null) ? 0 : (this.kKH.getData().size() - fVar.cVn().size()) + this.kKH.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cZX2 = as.cZW().cZX()) != null && !(cZX2 instanceof RecyclerView.SavedState)) {
                        this.kKH.onRestoreInstanceState(cZX2);
                        if (com.baidu.tbadk.core.util.y.getCount(cVn) > 1 && fVar.getPage().bdu() > 0) {
                            this.iaL.endLoadData();
                            this.iaL.setText(this.kzt.getString(R.string.pb_load_more_without_point));
                            this.iaL.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.kMA = false;
                    break;
                case 5:
                    this.kKH.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cZX = as.cZW().cZX()) != null && !(cZX instanceof RecyclerView.SavedState)) {
                        this.kKH.onRestoreInstanceState(cZX);
                        break;
                    } else {
                        this.kKH.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.kKJ != null && this.kKJ.bGj() != null) {
                            if (this.kzt.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.kKH.setSelectionFromTop((this.kKS.cXa() + this.kKH.getHeaderViewsCount()) - 1, this.kKJ.dbT() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.kzt.getPageContext().getPageActivity()));
                            } else {
                                this.kKH.setSelectionFromTop((this.kKS.cXa() + this.kKH.getHeaderViewsCount()) - 1, this.kKJ.dbT());
                            }
                        } else {
                            this.kKH.setSelection(this.kKS.cXa() + this.kKH.getHeaderViewsCount());
                        }
                    } else {
                        this.kKH.setSelection(i2 > 0 ? ((this.kKH.getData() == null && fVar.cVn() == null) ? 0 : (this.kKH.getData().size() - fVar.cVn().size()) + this.kKH.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.iaL.endLoadData();
                    this.iaL.setText(this.kzt.getString(R.string.pb_load_more_without_point));
                    this.iaL.setLineGone();
                    break;
            }
            if (this.kLP == kLQ && isHost()) {
                dbr();
            }
            if (this.kMa) {
                dak();
                this.kMa = false;
                if (i3 == 0) {
                    tq(true);
                }
            }
            if (fVar.kwF == 1 || fVar.kwG == 1) {
                if (this.kMg == null) {
                    this.kMg = new PbTopTipView(this.kzt.getContext());
                }
                if (fVar.kwG == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.kzt.getStType())) {
                    this.kMg.setText(this.kzt.getString(R.string.pb_read_strategy_add_experience));
                    this.kMg.a(this.bpu, this.mSkinType);
                } else if (fVar.kwF == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.kzt.getStType())) {
                    this.kMg.setText(this.kzt.getString(R.string.pb_read_news_add_experience));
                    this.kMg.a(this.bpu, this.mSkinType);
                }
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVl() != null) {
            x(fVar);
            if (fVar.baA()) {
                SvgManager.bjq().a(this.kLu, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bjq().a(this.kLu, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Ew = Ew(fVar.cVl().bev());
            if (this.kLx != null) {
                this.kLx.setText(Ew);
            }
            if (this.kLy != null) {
                this.kLy.setText(Ew);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.cVl()));
        }
    }

    private String Ew(int i) {
        if (i == 0) {
            return this.kzt.getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i;
        }
    }

    private void daU() {
        if (this.kKJ != null) {
            this.kKJ.a(this.kKH, this.textView, this.mType);
        }
    }

    public void ty(boolean z) {
        this.kLj = z;
    }

    public void endLoadData() {
        if (this.iaL != null) {
            this.iaL.setLineGone();
            this.iaL.endLoadData();
        }
        bWq();
    }

    public void bLs() {
        this.kKH.setVisibility(0);
    }

    public void daV() {
        if (this.kKH != null) {
            this.kKH.setVisibility(8);
        }
        if (this.kKH != null) {
            this.kLG.setVisibility(8);
        }
        if (this.kKD != null && this.kKD.kQS != null) {
            this.kKD.kQS.setVisibility(8);
        }
    }

    public void daW() {
        if (this.kKH != null) {
            this.kKH.setVisibility(0);
        }
        if (this.kLG != null) {
            this.kLG.setVisibility(0);
        }
        if (this.kKD != null && this.kKD.kQS != null) {
            this.kKD.kQS.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.kLC != null && this.kLC.beE() != null && this.kKD != null) {
            this.kMd = !this.kMc;
            this.kKD.tP(this.kMd);
            if (this.kzt.cXr() != null) {
                this.kzt.cXr().tO(this.kMd);
            }
            daX();
            if (this.kzt != null && !this.kzt.cWt() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.cVI())) {
                bs bsVar = fVar.cVI().get(0);
                if (bsVar != null) {
                    this.kKD.fu(bsVar.getForumName(), bsVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.kKD.fu(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.kMd) {
                this.kKM.a(fVar, this.kLC, this.kLk);
                if (this.kLI != null) {
                    this.kLI.setVisibility(8);
                }
                if (this.kMm == null) {
                    this.kMm = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.19
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.kzt != null && az.this.kzt.isAdded()) {
                                if (i < 0 && f > az.this.kMf) {
                                    az.this.dbe();
                                    az.this.dbq();
                                }
                                az.this.daO();
                            }
                        }
                    };
                }
                this.kKH.setListViewDragListener(this.kMm);
                return;
            }
            if (this.kLI != null) {
                this.kLI.setVisibility(0);
            }
            this.kKM.a(fVar, this.kLC, this.kLk);
            this.kMm = null;
            this.kKH.setListViewDragListener(null);
        }
    }

    private void daX() {
        this.kKM.a(this.kAA, this.kLC, this.kMd, this.kMc);
    }

    public boolean daY() {
        return this.kAA == null || this.kAA.getForum() == null || "0".equals(this.kAA.getForum().getId()) || "me0407".equals(this.kAA.getForum().getName());
    }

    private boolean daZ() {
        return this.kKK.tK(this.kAi);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cVl() == null) {
            return false;
        }
        if (fVar.cVl().beB() == 1 || fVar.cVl().getThreadType() == 33) {
            return true;
        }
        return !(fVar.cVl().beD() == null || fVar.cVl().beD().bgT() == 0) || fVar.cVl().bez() == 1 || fVar.cVl().beA() == 1 || fVar.cVl().bfs() || fVar.cVl().bfM() || fVar.cVl().bfF() || fVar.cVl().beP() != null || !com.baidu.tbadk.core.util.at.isEmpty(fVar.cVl().getCategory()) || fVar.cVl().beH() || fVar.cVl().beG();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.kKL != null) {
                if (fVar.cVl() != null && fVar.cVl().beS() == 0 && !fVar.cVl().bdk() && !this.kMt) {
                    if (fVar.cVl() != null) {
                        bw cVl = fVar.cVl();
                        cVl.z(true, w(fVar));
                        cVl.nf(3);
                        cVl.zm("2");
                    }
                    if (fVar.cVl().bdm()) {
                        this.kKM.c(this.kKH);
                        this.kKL.c(this.kKH);
                        this.kKL.b(this.kKH);
                        this.kKM.b(this.kKH);
                        this.kKM.E(this.kAA);
                        this.kKL.B(fVar);
                    } else {
                        this.kKM.E(this.kAA);
                        this.kKL.D(fVar);
                    }
                } else if (fVar.cVl().beS() == 1) {
                    if (fVar.cVl() != null) {
                        this.kKL.c(this.kKH);
                        this.kKM.E(this.kAA);
                    }
                } else {
                    this.kKL.c(this.kKH);
                    this.kKM.E(this.kAA);
                }
            }
            if (fVar.cVl() != null) {
                ao(fVar.cVl().beA() == 1, fVar.cVl().bez() == 1);
            }
            this.kAi = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            daZ();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.ab abVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.beE().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cVA()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.beE() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.beE().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.beE().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.beE().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cVA()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> cVI = fVar.cVI();
                if (com.baidu.tbadk.core.util.y.getCount(cVI) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : cVI) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.eau) != null && abVar.dYg && !abVar.dYh && (abVar.type == 1 || abVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bsVar.getForumName(), 12)).append(this.kzt.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.kzt.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dba() {
        return this.eQZ;
    }

    public boolean dbb() {
        if (this.bqe == null || this.bqe.getParent() == null || this.iaL.isLoading()) {
            return false;
        }
        int bottom = this.bqe.getBottom();
        Rect rect = new Rect();
        this.bqe.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void NH(String str) {
        if (this.iaL != null) {
            this.iaL.setText(str);
        }
    }

    public void NI(String str) {
        if (this.iaL != null) {
            int i = 0;
            if (this.kLN != null && this.kLN.kMS != null && this.kLN.kMS.getView() != null) {
                i = this.kLN.kMS.getView().getTop() < 0 ? this.kLN.kMS.getView().getHeight() : this.kLN.kMS.getView().getBottom();
            }
            this.iaL.am(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.kKH;
    }

    public int dbc() {
        return R.id.richText;
    }

    public TextView cWN() {
        return this.kKM.cWN();
    }

    public void d(BdListView.e eVar) {
        this.kKH.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.esW = cVar;
        if (this.kKW != null) {
            this.kKW.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.av avVar, a.b bVar) {
        if (avVar != null) {
            int bds = avVar.bds();
            int bdp = avVar.bdp();
            if (this.kKT != null) {
                this.kKT.bhg();
            } else {
                this.kKT = new com.baidu.tbadk.core.dialog.a(this.kzt.getPageContext().getPageActivity());
                this.kKU = LayoutInflater.from(this.kzt.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.kKT.aX(this.kKU);
                this.kKT.a(R.string.dialog_ok, bVar);
                this.kKT.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.dbe();
                        aVar.dismiss();
                    }
                });
                this.kKT.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.kLX == null) {
                            az.this.kLX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.kzt.HidenSoftKeyPad((InputMethodManager) az.this.kzt.getBaseFragmentActivity().getSystemService("input_method"), az.this.bpu);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mS().postDelayed(az.this.kLX, 150L);
                    }
                });
                this.kKT.b(this.kzt.getPageContext()).bhg();
            }
            this.kKV = (EditText) this.kKU.findViewById(R.id.input_page_number);
            this.kKV.setText("");
            TextView textView = (TextView) this.kKU.findViewById(R.id.current_page_number);
            if (bds <= 0) {
                bds = 1;
            }
            if (bdp <= 0) {
                bdp = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bds), Integer.valueOf(bdp)));
            this.kzt.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.kKV, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.kKH.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.kzt.showToast(str);
    }

    public boolean tz(boolean z) {
        if (this.aay == null || !this.aay.brx()) {
            return false;
        }
        this.aay.bpX();
        return true;
    }

    public void dbd() {
        if (this.kMC != null) {
            while (this.kMC.size() > 0) {
                TbImageView remove = this.kMC.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        dbd();
        this.kKS.DW(1);
        if (this.kKJ != null) {
            this.kKJ.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.kKS.DW(2);
        if (this.kKJ != null) {
            this.kKJ.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.kzt.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kzt.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.kLw != null) {
            this.kLw.onDestroy();
        }
        if (this.kLZ != null) {
            this.kLZ.destroy();
        }
        if (this.kMo != null) {
            this.kMo.onDestory();
        }
        if (this.kMg != null) {
            this.kMg.hide();
        }
        this.kzt.hideProgressBar();
        if (this.fCm != null && this.hPZ != null) {
            this.fCm.b(this.hPZ);
        }
        dbe();
        endLoadData();
        if (this.kLX != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kLX);
        }
        if (this.kLF != null) {
            this.kLF.clearStatus();
        }
        this.kMw = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.kKS.DW(3);
        if (this.boC != null) {
            this.boC.setBackgroundDrawable(null);
        }
        if (this.kKJ != null) {
            this.kKJ.destroy();
        }
        if (this.kKS != null) {
            this.kKS.onDestroy();
        }
        this.kKH.setOnLayoutListener(null);
        if (this.kMk != null) {
            this.kMk.coU();
        }
        if (this.kLO != null) {
            this.kLO.onDestroy();
        }
        if (this.kKM != null) {
            this.kKM.onDestroy();
        }
    }

    public boolean Ex(int i) {
        if (this.kKJ != null) {
            return this.kKJ.Ex(i);
        }
        return false;
    }

    public void dbe() {
        this.kKD.aRN();
        if (this.kKM != null) {
            this.kKM.dbe();
        }
        if (this.kzt != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kzt.getContext(), this.kKV);
        }
        dam();
        if (this.kDD != null) {
            this.kDD.dismiss();
        }
        dbg();
        if (this.kKT != null) {
            this.kKT.dismiss();
        }
        if (this.hVA != null) {
            this.hVA.dismiss();
        }
    }

    public void dbf() {
        this.kKD.aRN();
        if (this.kKM != null) {
            this.kKM.dbe();
        }
        if (this.kDD != null) {
            this.kDD.dismiss();
        }
        dbg();
        if (this.kKT != null) {
            this.kKT.dismiss();
        }
        if (this.hVA != null) {
            this.hVA.dismiss();
        }
    }

    public void eC(List<String> list) {
        this.kMj = list;
        if (this.kMk != null) {
            this.kMk.setData(list);
        }
    }

    public void sD(boolean z) {
        this.kKS.sD(z);
    }

    public void tA(boolean z) {
        this.kLm = z;
    }

    public void dbg() {
        if (this.kLa != null) {
            this.kLa.dismiss();
        }
        if (this.kLb != null) {
            com.baidu.adp.lib.f.g.b(this.kLb, this.kzt.getPageContext());
        }
        if (this.kLc != null) {
            com.baidu.adp.lib.f.g.b(this.kLc, this.kzt.getPageContext());
        }
        if (this.kKZ != null) {
            this.kKZ.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.kAA, this.kAi);
            b(this.kAA, this.kAi, this.mType, i);
            this.kzt.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.kzt.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bpu);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bpu, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kLn, R.drawable.personalize_tab_shadow);
            if (this.kKJ != null) {
                this.kKJ.onChangeSkinType(i);
            }
            if (this.kKN != null) {
                this.kKN.onChangeSkinType(i);
            }
            if (this.kKK != null) {
                this.kKK.onChangeSkinType(i);
            }
            if (this.kKL != null) {
                this.kKL.onChangeSkinType(i);
            }
            if (this.kKM != null) {
                this.kKM.onChangeSkinType(i);
            }
            if (this.iaL != null) {
                this.iaL.changeSkin(i);
                if (this.eQZ != null) {
                    this.kzt.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eQZ);
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(this.eQZ, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.kKT != null) {
                this.kKT.c(this.kzt.getPageContext());
            }
            ty(this.kLj);
            this.kKS.notifyDataSetChanged();
            if (this.kKW != null) {
                this.kKW.changeSkin(i);
            }
            if (this.aay != null) {
                this.aay.onChangeSkinType(i);
            }
            if (this.kKX != null) {
                this.kKX.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.hma)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.hma) {
                    customBlueCheckRadioButton.bkj();
                }
            }
            daD();
            UtilHelper.setStatusBarBackground(this.boC, i);
            UtilHelper.setStatusBarBackground(this.kLI, i);
            if (this.kKO != null) {
                com.baidu.tbadk.r.a.a(this.kzt.getPageContext(), this.kKO);
            }
            if (this.kLY != null) {
                this.kLY.onChangeSkinType(i);
            }
            if (this.kKD != null) {
                if (this.kKJ != null) {
                    this.kKJ.Ey(i);
                } else {
                    this.kKD.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.iTU != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.iTU, R.color.cp_cont_d);
            }
            if (this.kLs != null) {
                this.kLs.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
            }
            if (this.kLr != null) {
                this.kLr.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.kzt.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j)));
            }
            if (this.kLu != null && this.kAA != null) {
                if (this.kAA.baA()) {
                    SvgManager.bjq().a(this.kLu, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.bjq().a(this.kLu, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            x(this.kAA);
            if (this.kLt != null) {
                SvgManager.bjq().a(this.kLt, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kLp != null) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kLp, R.drawable.bottom_shadow);
            }
            if (this.kLx != null) {
                com.baidu.tbadk.core.util.ap.c(this.kLx, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kLx, R.color.cp_cont_a);
            }
            if (this.kLy != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kLy, R.color.cp_cont_b);
            }
            if (this.kMl != null) {
                this.kMl.onChangeSkinType(i);
            }
            if (this.kLO != null) {
                this.kLO.onChangeSkinType();
            }
            if (this.kMi != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kMi, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kLq, R.color.cp_bg_line_h);
            if (this.kKI != null) {
                this.kKI.tl(i);
            }
            if (this.kLw != null) {
                this.kLw.onChangeSkinType();
            }
        }
    }

    public void dbh() {
        if (this.kLw != null) {
            this.kLw.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aY(fVar.cVl())) {
            if (this.kLw != null) {
                this.kLw.setEnable(false);
                this.kLw.onDestroy();
            }
            SvgManager.bjq().a(this.kLv, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kLw == null || !this.kLw.isEnable()) {
            SvgManager.bjq().a(this.kLv, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcy = iVar;
        this.kKS.setOnImageClickListener(this.fcy);
        this.kMl.setOnImageClickListener(this.fcy);
    }

    public void g(NoNetworkView.a aVar) {
        this.hPZ = aVar;
        if (this.fCm != null) {
            this.fCm.a(this.hPZ);
        }
    }

    public void tB(boolean z) {
        this.kKS.setIsFromCDN(z);
    }

    public Button dbi() {
        return this.kLo;
    }

    public void dbj() {
        if (this.kKC != 2) {
            this.kKH.setNextPage(this.iaL);
            this.kKC = 2;
        }
    }

    public void dbk() {
        if (com.baidu.tbadk.n.m.bun().buo()) {
            int lastVisiblePosition = this.kKH.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.kKH.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.eRI = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(R.id.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.n.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.setSubType(1001);
                        perfLog2.eRI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean dbl() {
        return this.aay != null && this.aay.getVisibility() == 0;
    }

    public boolean dbm() {
        return this.aay != null && this.aay.brx();
    }

    public void dbn() {
        if (this.aay != null) {
            this.aay.bpX();
        }
    }

    public void tC(boolean z) {
        if (this.kLq != null) {
            tA(this.kzt.cXo().bse());
            if (this.kLm) {
                tr(z);
            } else {
                ts(z);
            }
        }
    }

    public void dbo() {
        if (this.kLq != null) {
            this.kLp.setVisibility(8);
            this.kLq.setVisibility(8);
            this.kLz = false;
            if (this.kLO != null) {
                this.kLO.setVisibility(8);
                tw(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.hpW == null) {
            this.hpW = new com.baidu.tbadk.core.view.a(this.kzt.getPageContext());
        }
        this.hpW.setDialogVisiable(true);
    }

    public void bWq() {
        if (this.hpW != null) {
            this.hpW.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.kKH.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.kKH.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kKJ != null) {
            this.kKJ.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.kMD = getScrollY();
            this.kLN.kMS = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kLN));
            a(this.kLN.kMS, true);
        }
    }

    public void tD(boolean z) {
        if (this.kKJ != null) {
            this.kKJ.tD(z);
        }
    }

    private boolean b(AbsListView absListView, int i) {
        boolean z = true;
        if (absListView == null) {
            return false;
        }
        boolean z2 = i > 0;
        if (z2 || absListView.getChildCount() <= 0) {
            z = z2;
        } else if (absListView.getChildAt(0).getTop() >= absListView.getListPaddingTop()) {
            z = false;
        }
        return z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.kKJ != null) {
            this.kKJ.onScroll(absListView, i, i2, i3);
        }
        if (this.kKD != null && this.kKM != null) {
            this.kKD.cW(this.kKM.dbP());
        }
        this.kLN.kqo = i;
        this.kLN.headerCount = this.kKH.getHeaderViewsCount();
        this.kLN.kMS = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kLN));
        tt(b(absListView, i));
        a(this.kLN.kMS, false);
        if (this.iaL.bkx() && !this.iaL.esd) {
            if (this.kLN != null && this.kLN.kMS != null && this.kLN.kMS.getView() != null) {
                i4 = this.kLN.kMS.getView().getTop() < 0 ? this.kLN.kMS.getView().getHeight() : this.kLN.kMS.getView().getBottom();
            }
            this.iaL.oO(i4);
            this.iaL.esd = true;
        }
    }

    public void dbp() {
        if (TbadkCoreApplication.isLogin() && this.kAA != null && this.kMd && !this.kMc && !this.kLk && this.kLC != null && this.kLC.beE() != null && !this.kLC.beE().getIsLike() && !this.kLC.beE().hadConcerned() && this.kLZ == null) {
            this.kLZ = new av(this.kzt);
        }
    }

    public void dbq() {
        if (this.kzt != null) {
            if ((this.hSD || this.kMr == 17) && com.baidu.tbadk.a.d.bai()) {
                if (this.kAA != null && this.kAA.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.kAA.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.kzt.getContext()).createNormalCfg(this.kAA.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13853").dD("post_id", this.kAA.getThreadId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("fid", this.kAA.getForum().getId()));
                }
            } else if (this.kMd && !this.kMc && this.kLC != null && this.kLC.beE() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12601").ai("obj_locate", this.kzt.cWt() ? 2 : 1).ai("obj_type", this.kMc ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kzt.getPageContext().getPageActivity(), this.kLC.beE().getUserId(), this.kLC.beE().getUserName(), this.kzt.cWD().cWu(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.kMc && this.kLH != null && this.kKD.dch() != null) {
            int cXb = this.kKS.cXb();
            if (cXb > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (cXb > this.kKH.getFirstVisiblePosition() - this.kKH.getHeaderViewsCount()) {
                    this.kLH.setVisibility(4);
                    return;
                }
                this.kLH.setVisibility(0);
                tt(false);
                this.kKD.mNavigationBar.hideBottomLine();
                if (this.kLH.getParent() != null && ((ViewGroup) this.kLH.getParent()).getHeight() <= this.kLH.getTop()) {
                    this.kLH.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.kKc == null) {
                if (this.kKH.getFirstVisiblePosition() == 0) {
                    this.kLH.setVisibility(4);
                    this.kKD.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.kLM) {
                        this.kLL = top;
                        this.kLM = false;
                    }
                    this.kLL = top < this.kLL ? top : this.kLL;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.kKR.getY() < 0.0f) {
                        measuredHeight = kLK - auVar.kKc.getMeasuredHeight();
                    } else {
                        measuredHeight = this.kKD.dch().getMeasuredHeight() - auVar.kKc.getMeasuredHeight();
                        this.kKD.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.kLL) {
                        this.kLH.setVisibility(0);
                        tt(false);
                    } else if (top < measuredHeight) {
                        this.kLH.setVisibility(0);
                        tt(false);
                    } else {
                        this.kLH.setVisibility(4);
                        this.kKD.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.kLM = true;
                    }
                }
            }
        }
    }

    public void dbr() {
        if (!this.kME) {
            TiebaStatic.log("c10490");
            this.kME = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kzt.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(kLR, Integer.valueOf(kLT));
            aVar.ns(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.kzt.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aX(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.kzt);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kzt.getPageContext()).bhg();
        }
    }

    public void NJ(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kzt.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.kzt.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aX(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(kLR, Integer.valueOf(kLU));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.kzt);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kzt.getPageContext()).bhg();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.beE() != null) {
            MetaData beE = b.beE();
            beE.setGiftNum(beE.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.kKM.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dbs() {
        return this.kLF;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVl() != null && fVar.cVl().bfM() && this.kLF == null) {
            this.kLF = (PbInterviewStatusView) this.kLE.inflate();
            this.kLF.setOnClickListener(this.hVB);
            this.kLF.setCallback(this.kzt.cXZ());
            this.kLF.setData(this.kzt, fVar);
        }
    }

    public RelativeLayout dbt() {
        return this.kKR;
    }

    public View dbu() {
        return this.boC;
    }

    public boolean dbv() {
        return this.kMt;
    }

    public void sI(boolean z) {
        this.kKM.sI(z);
    }

    public void NK(String str) {
        if (this.kKE != null) {
            this.kKE.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int tE(boolean z) {
        if (this.kLF == null || this.kLF.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dbw() {
        if (this.kLF != null && this.kLF.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kLF.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.kLF.setLayoutParams(layoutParams);
        }
    }

    public boolean cXu() {
        return false;
    }

    public void NL(String str) {
        this.iTU.performClick();
        if (!StringUtils.isNull(str) && this.kzt.cXo() != null && this.kzt.cXo().brW() != null && this.kzt.cXo().brW().getInputView() != null) {
            EditText inputView = this.kzt.cXo().brW().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dbe();
            if (configuration.orientation == 2) {
                dbo();
                dam();
            } else {
                daq();
            }
            if (this.kLY != null) {
                this.kLY.cXj();
            }
            this.kzt.cms();
            this.kKR.setVisibility(8);
            this.kKD.tQ(false);
            this.kzt.sX(false);
            if (this.kKJ != null) {
                if (configuration.orientation == 1) {
                    dbt().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.kKH.setIsLandscape(true);
                    this.kKH.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.kKH.setIsLandscape(false);
                    if (this.kMD > 0) {
                        this.kKH.smoothScrollBy(this.kMD, 0);
                    }
                }
                this.kKJ.onConfigurationChanged(configuration);
                this.kLG.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void tF(boolean z) {
        if (this.kKJ != null) {
            this.kKJ.tF(z);
        }
    }

    public boolean dbx() {
        return this.kKJ != null && this.kKJ.dbx();
    }

    public void dby() {
        if (this.kKJ != null) {
            this.kKJ.dby();
        }
    }

    public void sM(boolean z) {
        this.kKS.sM(z);
    }

    public void cU(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.kLq.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.kzt.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.kMi = new TextView(this.kzt.getContext());
            this.kMi.setText(R.string.connection_tips);
            this.kMi.setGravity(17);
            this.kMi.setPadding(com.baidu.adp.lib.util.l.getDimens(this.kzt.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.kzt.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kzt.getContext(), R.dimen.ds60);
            if (this.kMi.getParent() == null) {
                frameLayout.addView(this.kMi, layoutParams);
            }
            this.kMh = new PopupWindow(this.kzt.getContext());
            this.kMh.setContentView(frameLayout);
            this.kMh.setHeight(-2);
            this.kMh.setWidth(-2);
            this.kMh.setFocusable(true);
            this.kMh.setOutsideTouchable(false);
            this.kMh.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.kKH.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.25
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.kMh.showAsDropDown(az.this.kLq, view.getLeft(), -az.this.kLq.getHeight());
                    } else {
                        az.this.kMh.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void tG(boolean z) {
        this.kMn = z;
    }

    public boolean dbz() {
        return this.kMn;
    }

    public PbThreadPostView dbA() {
        return this.kKI;
    }

    private void ao(boolean z, boolean z2) {
        ap(z, z2);
        if (this.kAA != null && this.kAA.cVl() != null && this.kAA.cVl().beS() == 0 && !this.kAA.cVl().bdk()) {
            aq(z, z2);
        } else if (this.kKS != null && this.kKS.cXg() != null) {
            this.kKS.cXg().b(this.kAA, z, z2);
        }
    }

    private void ap(boolean z, boolean z2) {
        this.kKM.d(this.kAA, z, z2);
    }

    private void aq(boolean z, boolean z2) {
        this.kKL.c(this.kAA, z, z2);
    }

    public void tH(boolean z) {
        this.hSD = z;
    }

    public void Ep(int i) {
        this.kMr = i;
    }

    public void dbB() {
        if (this.kKH != null) {
            this.kKH.setForbidDragListener(true);
        }
    }

    public boolean cYt() {
        if (this.kKH == null) {
            return false;
        }
        return this.kKH.cYt();
    }
}
