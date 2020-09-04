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
    private static final int kLR = UtilHelper.getLightStatusBarHeight();
    public static int kLX = 3;
    public static int kLY = 0;
    public static int kLZ = 3;
    public static int kMa = 4;
    public static int kMb = 5;
    public static int kMc = 6;
    private static a.InterfaceC0806a kMz = new a.InterfaceC0806a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0806a
        public void onRefresh() {
        }
    };
    private EditorTools aaA;
    private View boF;
    private RelativeLayout bpx;
    private View bqh;
    private com.baidu.tieba.pb.a.c eFj;
    private View eRd;
    private f.c eta;
    private NoNetworkView fCq;
    private boolean hSJ;
    private View.OnClickListener hVH;
    private List<CustomBlueCheckRadioButton> hme;
    private TextView iUa;
    private PbListView iaR;
    private boolean isLandscape;
    private NavigationBarCoverTip ivO;
    private com.baidu.tieba.NEGFeedBack.e izf;
    private com.baidu.tieba.pb.data.f kAH;
    private View.OnClickListener kAx;
    private PbFakeFloorModel kCX;
    PbFragment.c kEL;
    public int kKI;
    public final com.baidu.tieba.pb.pb.main.view.c kKK;
    public com.baidu.tieba.pb.pb.main.view.b kKL;
    private ViewStub kKM;
    private ViewStub kKN;
    private PbLandscapeListView kKO;
    private PbThreadPostView kKP;
    private com.baidu.tieba.pb.pb.main.a.e kKQ;
    private com.baidu.tieba.pb.pb.main.a.a kKR;
    private com.baidu.tieba.pb.pb.main.a.c kKS;
    private com.baidu.tieba.pb.pb.main.a.d kKT;
    private com.baidu.tieba.pb.pb.main.a.b kKU;
    private LinearLayout kKV;
    private TextView kKW;
    private TextView kKX;
    private ObservedChangeRelativeLayout kKY;
    private g kKZ;
    private ImageView kLA;
    private ImageView kLB;
    private ImageView kLC;
    private com.baidu.tieba.pb.view.c kLD;
    private TextView kLE;
    private TextView kLF;
    private int kLH;
    private int kLI;
    private PostData kLJ;
    private ViewStub kLL;
    private PbInterviewStatusView kLM;
    private FrameLayout kLN;
    private View kLO;
    private View kLP;
    private au kLQ;
    private PbEmotionBar kLV;
    private View kLf;
    private View kLu;
    private View kLw;
    private View kLx;
    private LinearLayout kLy;
    private HeadImageView kLz;
    private boolean kMA;
    private Runnable kME;
    private PbFragment.b kMG;
    public int kMK;
    private int kMd;
    private Runnable kMe;
    private v kMf;
    private av kMg;
    private int kMm;
    private PbTopTipView kMn;
    private PopupWindow kMo;
    private TextView kMp;
    private List<String> kMq;
    private com.baidu.tieba.pb.pb.main.emotion.c kMr;
    private com.baidu.tieba.pb.pb.godreply.a kMs;
    private PbLandscapeListView.b kMt;
    private al kMv;
    private String kMw;
    private long kMx;
    private int kMy;
    private PbFragment kzA;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private int kKJ = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a kLa = null;
    private com.baidu.tbadk.core.dialog.b hVG = null;
    private View kLb = null;
    private EditText kLc = null;
    private com.baidu.tieba.pb.view.d kLd = null;
    private com.baidu.tieba.pb.view.a kLe = null;
    private b.InterfaceC0538b jsR = null;
    private TbRichTextView.i fcC = null;
    private NoNetworkView.a hQf = null;
    private com.baidu.tbadk.core.dialog.i kLg = null;
    private com.baidu.tbadk.core.dialog.a kLh = null;
    private Dialog kLi = null;
    private Dialog kLj = null;
    private View kLk = null;
    private LinearLayout kLl = null;
    private CompoundButton.OnCheckedChangeListener hmf = null;
    private TextView kLm = null;
    private TextView kLn = null;
    private String kLo = null;
    private com.baidu.tbadk.core.dialog.i kDK = null;
    private com.baidu.tbadk.core.dialog.i kLp = null;
    private boolean kLq = false;
    private boolean kLr = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView kLs = null;
    private boolean kLt = false;
    private Button kLv = null;
    private boolean kLG = true;
    private com.baidu.tbadk.core.view.a hqa = null;
    private boolean kAp = false;
    private int mSkinType = 3;
    private boolean kLK = false;
    private int kLS = 0;
    private boolean kLT = true;
    public a kLU = new a();
    private int kLW = 0;
    private boolean kMh = false;
    private int kMi = 0;
    private boolean kMj = false;
    private boolean kMk = false;
    private boolean kMl = false;
    private boolean kMu = false;
    private String kMB = null;
    private CustomMessageListener kMC = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.kMB = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.kKZ != null) {
                az.this.kKZ.notifyDataSetChanged();
            }
        }
    };
    private Handler kMD = new Handler();
    private CustomMessageListener kMF = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.kLG = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean kMH = true;
    View.OnClickListener kMI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.kAH == null || az.this.kAH.cVm() == null || az.this.kAH.cVm().beE() == null || az.this.kAH.cVm().beE().getAlaInfo() == null || az.this.kAH.cVm().beE().getAlaInfo().live_status != 1) {
                if (az.this.kMj) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11923").ai("obj_id", 2));
                }
                if (!az.this.kMj && az.this.kAH != null && az.this.kAH.cVm() != null && az.this.kAH.cVm().beE() != null && az.this.kAH.cVm().beE().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12151").ai("obj_locate", 1));
                }
                if (az.this.kzA.cYj() != null) {
                    az.this.kzA.cYj().kzM.hCp.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c11851");
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
            if (az.this.kAH.cVm().beE().getAlaInfo() == null || !az.this.kAH.cVm().beE().getAlaInfo().isChushou) {
                if (az.this.kAH.cVm().beE().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.kAH.cVm().beE().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.kzA.cYj(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.be.bju().b(az.this.kzA.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.kAH.cVm().beE().getAlaInfo().thirdRoomId + "&livetype=" + az.this.kAH.cVm().beE().getAlaInfo().thirdLiveType});
        }
    };
    private boolean aXZ = false;
    String userId = null;
    private final List<TbImageView> kMJ = new ArrayList();
    private boolean kML = false;

    /* loaded from: classes16.dex */
    public static class a {
        public int headerCount;
        public au kMZ;
        public int kqv;
    }

    public void ts(boolean z) {
        this.kMh = z;
        if (this.kKO != null) {
            this.kMi = this.kKO.getHeaderViewsCount();
        }
    }

    public void dal() {
        if (this.kKO != null) {
            int headerViewsCount = this.kKO.getHeaderViewsCount() - this.kMi;
            final int firstVisiblePosition = (this.kKO.getFirstVisiblePosition() == 0 || this.kKO.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.kKO.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.kKO.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.kLU.kMZ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kLU));
            final au auVar = this.kLU.kMZ;
            final int g = g(auVar);
            final int y = ((int) this.kKY.getY()) + this.kKY.getMeasuredHeight();
            final boolean z = this.kLO.getVisibility() == 0;
            boolean z2 = this.kKY.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.kKZ.cXc() + this.kKO.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.kKj.getMeasuredHeight() : 0;
                if (z2) {
                    this.kKO.setSelectionFromTop(this.kKZ.cXc() + this.kKO.getHeaderViewsCount(), kLR - measuredHeight);
                } else {
                    this.kKO.setSelectionFromTop(this.kKZ.cXc() + this.kKO.getHeaderViewsCount(), this.kKK.dci().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.kKO.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.kMj && this.kKQ != null) {
                this.kKO.setSelectionFromTop(this.kKZ.cXc() + this.kKO.getHeaderViewsCount(), this.kKQ.dbU());
            } else if (this.mType == 6) {
                this.kKO.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= az.this.bpx.getMeasuredHeight()) {
                            int g2 = az.this.g(auVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (az.this.bqh != null && (layoutParams = az.this.bqh.getLayoutParams()) != null) {
                                if (i == 0 || i > az.this.bpx.getMeasuredHeight() || g2 >= az.this.bpx.getMeasuredHeight()) {
                                    layoutParams.height = az.this.kMd;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bpx.getMeasuredHeight()) {
                                    layoutParams.height = az.this.kMd;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.kKO.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bqh.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bqh != null && az.this.bqh.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bqh.getLayoutParams();
                                            layoutParams2.height = az.this.kMd;
                                            az.this.bqh.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.kKO.setOnLayoutListener(null);
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

    public NoNetworkView dam() {
        return this.fCq;
    }

    public void dan() {
        if (this.aaA != null) {
            this.aaA.hide();
            if (this.kMr != null) {
                this.kMr.dbW();
            }
        }
    }

    public PbFakeFloorModel dao() {
        return this.kCX;
    }

    public v dap() {
        return this.kMf;
    }

    public com.baidu.tieba.pb.pb.main.a.e daq() {
        return this.kKQ;
    }

    public void dar() {
        reset();
        dan();
        this.kMf.cXk();
        tE(false);
    }

    private void reset() {
        if (this.kzA != null && this.kzA.cXp() != null && this.aaA != null) {
            com.baidu.tbadk.editortools.pb.a.brU().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cXp = this.kzA.cXp();
            cXp.bsp();
            cXp.brH();
            if (cXp.getWriteImagesInfo() != null) {
                cXp.getWriteImagesInfo().setMaxImagesAllowed(cXp.isBJH ? 1 : 9);
            }
            cXp.qk(SendView.ALL);
            cXp.ql(SendView.ALL);
            com.baidu.tbadk.editortools.h qb = this.aaA.qb(23);
            com.baidu.tbadk.editortools.h qb2 = this.aaA.qb(2);
            com.baidu.tbadk.editortools.h qb3 = this.aaA.qb(5);
            if (qb2 != null) {
                qb2.display();
            }
            if (qb3 != null) {
                qb3.display();
            }
            if (qb != null) {
                qb.hide();
            }
            this.aaA.invalidate();
        }
    }

    public boolean das() {
        return this.kLG;
    }

    public void tt(boolean z) {
        if (this.kLx != null && this.iUa != null) {
            this.iUa.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kLx.startAnimation(alphaAnimation);
            }
            this.kLw.setVisibility(0);
            this.kLx.setVisibility(0);
            this.kLG = true;
            if (this.kLV != null && !this.kMs.isActive()) {
                this.kLV.setVisibility(0);
                ty(true);
            }
        }
    }

    public void tu(boolean z) {
        if (this.kLx != null && this.iUa != null) {
            this.iUa.setText(dat());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kLx.startAnimation(alphaAnimation);
            }
            this.kLw.setVisibility(0);
            this.kLx.setVisibility(0);
            this.kLG = true;
            if (this.kLV != null && !this.kMs.isActive()) {
                this.kLV.setVisibility(0);
                ty(true);
            }
        }
    }

    public String dat() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.kMw)) {
            return this.kMw;
        }
        if (this.kzA != null) {
            this.kMw = TbadkCoreApplication.getInst().getResources().getString(ay.dai());
        }
        return this.kMw;
    }

    public PostData dau() {
        int i = 0;
        if (this.kKO == null) {
            return null;
        }
        int dav = dav() - this.kKO.getHeaderViewsCount();
        if (dav < 0) {
            dav = 0;
        }
        if (this.kKZ.DV(dav) != null && this.kKZ.DV(dav) != PostData.mfb) {
            i = dav + 1;
        }
        return this.kKZ.getItem(i) instanceof PostData ? (PostData) this.kKZ.getItem(i) : null;
    }

    public int dav() {
        int i;
        View childAt;
        if (this.kKO == null) {
            return 0;
        }
        int firstVisiblePosition = this.kKO.getFirstVisiblePosition();
        int lastVisiblePosition = this.kKO.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.kKO.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.kKO.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int daw() {
        return this.kKO.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.kAH != null && this.kAH.cVo() != null && !this.kAH.cVo().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.kAH.cVo().size() && (postData = this.kAH.cVo().get(i)) != null && postData.beE() != null && !StringUtils.isNull(postData.beE().getUserId()); i++) {
                if (this.kAH.cVo().get(i).beE().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.kMs != null && this.kMs.isActive()) {
                        tE(false);
                    }
                    if (this.kLV != null) {
                        this.kLV.tO(true);
                    }
                    this.kMB = postData.beE().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.kzA = null;
        this.bpx = null;
        this.boF = null;
        this.kKO = null;
        this.kKZ = null;
        this.iaR = null;
        this.eRd = null;
        this.hVH = null;
        this.kAx = null;
        this.kLx = null;
        this.iUa = null;
        this.kLL = null;
        this.kMm = 0;
        this.kMx = 0L;
        this.kMx = System.currentTimeMillis();
        this.kzA = pbFragment;
        this.hVH = onClickListener;
        this.eFj = cVar;
        this.kMm = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kzA.getContext()) / 8;
        this.bpx = (RelativeLayout) LayoutInflater.from(this.kzA.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bpx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.kLu = this.bpx.findViewById(R.id.bottom_shadow);
        this.ivO = (NavigationBarCoverTip) this.bpx.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.boF = this.bpx.findViewById(R.id.statebar_view);
        this.kKY = (ObservedChangeRelativeLayout) this.bpx.findViewById(R.id.title_wrapper);
        this.fCq = (NoNetworkView) this.bpx.findViewById(R.id.view_no_network);
        this.kKO = (PbLandscapeListView) this.bpx.findViewById(R.id.new_pb_list);
        this.kLN = (FrameLayout) this.bpx.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.kzA.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kzA.getActivity(), R.dimen.ds88));
        this.kKO.addHeaderView(this.textView, 0);
        this.kKO.setTextViewAdded(true);
        this.kMd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bqh = new View(this.kzA.getPageContext().getPageActivity());
        this.bqh.setLayoutParams(new AbsListView.LayoutParams(-1, this.kMd));
        this.bqh.setVisibility(4);
        this.kKO.addFooterView(this.bqh);
        this.kKO.setOnTouchListener(this.kzA.eVH);
        this.kKK = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bpx);
        if (this.kzA.cXS()) {
            this.kKM = (ViewStub) this.bpx.findViewById(R.id.manga_view_stub);
            this.kKM.setVisibility(0);
            this.kKL = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.kKL.show();
            this.kKK.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kzA.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.kKK.dci().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0761a() { // from class: com.baidu.tieba.pb.pb.main.az.26
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0761a
            public void cWo() {
                if (az.this.kKO != null) {
                    if (az.this.kKQ != null) {
                        az.this.kKQ.dbT();
                    }
                    az.this.kKO.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0761a
            public void cWp() {
                az.this.kzA.cmt();
            }
        }));
        this.kLw = this.bpx.findViewById(R.id.view_comment_top_line);
        this.kLx = this.bpx.findViewById(R.id.pb_editor_tool_comment);
        this.kLH = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kLI = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kLz = (HeadImageView) this.bpx.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kLz.setVisibility(0);
        this.kLz.setIsRound(true);
        this.kLz.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.kzA.getContext(), R.dimen.tbds1));
        this.kLz.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
        this.kLz.setPlaceHolder(1);
        this.kLz.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kLz.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.iUa = (TextView) this.bpx.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kLy = (LinearLayout) this.bpx.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.kzA.cXA();
                if (az.this.kzA != null && az.this.kzA.cWE() != null && az.this.kzA.cWE().getPbData() != null && az.this.kzA.cWE().getPbData().cVm() != null && az.this.kzA.cWE().getPbData().cVm().beE() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13701").dD("tid", az.this.kzA.cWE().cYD()).dD("fid", az.this.kzA.cWE().getPbData().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", az.this.kzA.cWE().kGR).dD("fid", az.this.kzA.cWE().getPbData().getForumId()).ai("obj_locate", 1).dD("uid", az.this.kzA.cWE().getPbData().cVm().beE().getUserId()));
                }
            }
        });
        this.kLA = (ImageView) this.bpx.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kLA.setOnClickListener(this.hVH);
        boolean booleanExtra = this.kzA.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kLB = (ImageView) this.bpx.findViewById(R.id.pb_editor_tool_collection);
        this.kLB.setOnClickListener(this.hVH);
        if (booleanExtra) {
            this.kLB.setVisibility(8);
        } else {
            this.kLB.setVisibility(0);
        }
        this.kLC = (ImageView) this.bpx.findViewById(R.id.pb_editor_tool_share);
        this.kLC.setOnClickListener(this.hVH);
        this.kLD = new com.baidu.tieba.pb.view.c(this.kLC);
        this.kLD.dfB();
        this.kLE = (TextView) this.bpx.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.kLE.setVisibility(0);
        this.kLL = (ViewStub) this.bpx.findViewById(R.id.interview_status_stub);
        this.kKR = new com.baidu.tieba.pb.pb.main.a.a(this.kzA, cVar);
        this.kKT = new com.baidu.tieba.pb.pb.main.a.d(this.kzA, cVar, this.hVH);
        this.kKZ = new g(this.kzA, this.kKO);
        this.kKZ.F(this.hVH);
        this.kKZ.setTbGestureDetector(this.eFj);
        this.kKZ.setOnImageClickListener(this.fcC);
        this.kKZ.setOnSwitchChangeListener(this.kzA.kEE);
        this.kAx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
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
                            az.this.kzA.c(sparseArray);
                            return;
                        }
                        az.this.cT(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.kzA.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.kKZ.S(this.kAx);
        daB();
        daC();
        this.kKT.b(this.kKO);
        this.kKS.b(this.kKO);
        this.kKR.b(this.kKO);
        this.iaR = new PbListView(this.kzA.getPageContext().getPageActivity());
        this.eRd = this.iaR.getView().findViewById(R.id.pb_more_view);
        if (this.eRd != null) {
            this.eRd.setOnClickListener(this.hVH);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.eRd, R.drawable.pb_foot_more_trans_selector);
        }
        this.iaR.setLineVisible();
        this.iaR.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iaR.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.kLf = this.bpx.findViewById(R.id.viewstub_progress);
        this.kzA.registerListener(this.kMF);
        this.kCX = new PbFakeFloorModel(this.kzA.getPageContext());
        this.kMf = new v(this.kzA.getPageContext(), this.kCX, this.bpx);
        this.kMf.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dar();
            }
        });
        this.kMf.a(this.kzA.kEG);
        this.kCX.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.kCX.t(postData);
                az.this.kKZ.notifyDataSetChanged();
                az.this.kMf.cXk();
                az.this.aaA.bpY();
                az.this.tE(false);
            }
        });
        if (this.kzA.cWE() != null && !StringUtils.isNull(this.kzA.cWE().cZl())) {
            this.kzA.showToast(this.kzA.cWE().cZl());
        }
        this.kLO = this.bpx.findViewById(R.id.pb_expand_blank_view);
        this.kLP = this.bpx.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kLP.getLayoutParams();
        if (this.kzA.cWE() != null && this.kzA.cWE().cYG()) {
            this.kLO.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.kLP.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = kLR;
            this.kLP.setLayoutParams(layoutParams2);
        }
        this.kLQ = new au(this.kzA.getPageContext(), this.bpx.findViewById(R.id.pb_reply_expand_view));
        this.kLQ.w(pbFragment.kDB);
        this.kLQ.kKj.setVisibility(8);
        this.kLQ.U(this.hVH);
        this.kLQ.setOnSwitchChangeListener(this.kzA.kEE);
        this.kzA.registerListener(this.mAccountChangedListener);
        this.kzA.registerListener(this.kMC);
        dax();
        ty(false);
    }

    public void tv(boolean z) {
        this.kLu.setVisibility(z ? 0 : 8);
    }

    public void cze() {
        if (!this.kzA.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").ai("obj_locate", 2).dD("fid", this.mForumId));
        } else if (this.kzA.cXC()) {
            com.baidu.tbadk.editortools.pb.e cXp = this.kzA.cXp();
            if (cXp != null && (cXp.bsm() || cXp.bsn())) {
                this.kzA.cXp().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.aaA != null) {
                daH();
            }
            if (this.aaA != null) {
                this.kLG = false;
                if (this.aaA.qe(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.kzA.getPageContext(), (View) this.aaA.qe(2).eKB, false, kMz);
                }
            }
            dbp();
        }
    }

    private void dax() {
        this.kMs = new com.baidu.tieba.pb.pb.godreply.a(this.kzA, this, (ViewStub) this.bpx.findViewById(R.id.more_god_reply_popup));
        this.kMs.A(this.hVH);
        this.kMs.S(this.kAx);
        this.kMs.setOnImageClickListener(this.fcC);
        this.kMs.A(this.hVH);
        this.kMs.setTbGestureDetector(this.eFj);
    }

    public com.baidu.tieba.pb.pb.godreply.a day() {
        return this.kMs;
    }

    public View daz() {
        return this.kLO;
    }

    public void daA() {
        if (this.kKO != null) {
            this.kKS.c(this.kKO);
            this.kKT.c(this.kKO);
            this.kKU.c(this.kKO);
            this.kKR.c(this.kKO);
        }
    }

    private void daB() {
        if (this.kKU == null) {
            this.kKU = new com.baidu.tieba.pb.pb.main.a.b(this.kzA, this.hVH);
        }
    }

    private void daC() {
        if (this.kKS == null) {
            this.kKS = new com.baidu.tieba.pb.pb.main.a.c(this.kzA, this.eFj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daD() {
        if (this.kzA.cXS()) {
            this.kKN = (ViewStub) this.bpx.findViewById(R.id.manga_mention_controller_view_stub);
            this.kKN.setVisibility(0);
            if (this.kKV == null) {
                this.kKV = (LinearLayout) this.bpx.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.kzA.getPageContext(), this.kKV);
            }
            if (this.kKW == null) {
                this.kKW = (TextView) this.kKV.findViewById(R.id.manga_prev_btn);
            }
            if (this.kKX == null) {
                this.kKX = (TextView) this.kKV.findViewById(R.id.manga_next_btn);
            }
            this.kKW.setOnClickListener(this.hVH);
            this.kKX.setOnClickListener(this.hVH);
        }
    }

    private void daE() {
        if (this.kzA.cXS()) {
            if (this.kzA.cXV() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKW, R.color.cp_cont_e, 1);
            }
            if (this.kzA.cXW() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKX, R.color.cp_cont_e, 1);
            }
        }
    }

    public void daF() {
        if (this.kKV == null) {
            daD();
        }
        this.kKN.setVisibility(8);
        if (this.kMD != null && this.kME != null) {
            this.kMD.removeCallbacks(this.kME);
        }
    }

    public void daG() {
        if (this.kMD != null) {
            if (this.kME != null) {
                this.kMD.removeCallbacks(this.kME);
            }
            this.kME = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.kKV == null) {
                        az.this.daD();
                    }
                    az.this.kKN.setVisibility(0);
                }
            };
            this.kMD.postDelayed(this.kME, 2000L);
        }
    }

    public void tw(boolean z) {
        this.kKK.tw(z);
        if (z && this.kLK) {
            this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.kKO.setNextPage(this.iaR);
            this.kKJ = 2;
        }
        if (this.kLz != null) {
            this.kLz.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
        this.aaA.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dar();
            }
        });
        this.aaA.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.aaA.getParent() == null) {
            this.bpx.addView(this.aaA, layoutParams);
        }
        this.aaA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.aaA.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.az.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.t) {
                    if (((com.baidu.tbadk.coreExtra.data.t) aVar.data).bmP() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.t) aVar.data).bmP() == EmotionGroupType.USER_COLLECT) {
                        if (az.this.mPermissionJudgePolicy == null) {
                            az.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        az.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.kzA.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.kzA.getBaseFragmentActivity())) {
                            az.this.kzA.cXp().c((com.baidu.tbadk.coreExtra.data.t) aVar.data);
                            az.this.kzA.cXp().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dan();
        this.kzA.cXp().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.aaA != null && az.this.aaA.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.kMr == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.aaA.getId());
                            az.this.kMr = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.kzA.getPageContext(), az.this.bpx, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(az.this.kMq)) {
                                az.this.kMr.setData(az.this.kMq);
                            }
                            az.this.kMr.c(az.this.aaA);
                        }
                        az.this.kMr.NQ(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.kzA.jJI != null && az.this.kzA.jJI.dbF() != null) {
                    if (!az.this.kzA.jJI.dbF().dFG()) {
                        az.this.kzA.jJI.tK(false);
                    }
                    az.this.kzA.jJI.dbF().xa(false);
                }
            }
        });
    }

    public void daH() {
        if (this.kzA != null && this.aaA != null) {
            this.aaA.display();
            if (this.kzA.cXp() != null) {
                this.kzA.cXp().bsc();
            }
            dbp();
        }
    }

    public void tx(boolean z) {
        if (this.kKO != null && this.textView != null && this.boF != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.boF.setVisibility(0);
                } else {
                    this.boF.setVisibility(8);
                    this.kKO.removeHeaderView(this.textView);
                    this.kKO.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = kLR;
                    this.textView.setLayoutParams(layoutParams);
                }
                daV();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + tG(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            daV();
            dbx();
        }
    }

    public g daI() {
        return this.kKZ;
    }

    public void a(PbFragment.c cVar) {
        this.kEL = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kzA.getContext());
        kVar.setTitleText(this.kzA.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kLg.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (az.this.kMG != null) {
                                az.this.kMG.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            az.this.kzA.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kzA.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kzA.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dbw()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.kzA.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kzA.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kzA.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aT(arrayList);
        this.kLg = new com.baidu.tbadk.core.dialog.i(this.kzA.getPageContext(), kVar);
        this.kLg.Nv();
    }

    public void a(PbFragment.b bVar) {
        this.kMG = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kzA != null && aVar != null) {
            if (this.izf == null && this.kKR != null) {
                this.izf = new com.baidu.tieba.NEGFeedBack.e(this.kzA.getPageContext(), this.kKR.dbP());
            }
            AntiData ckU = this.kzA.ckU();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ckU != null && ckU.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckU.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.izf.setDefaultReasonArray(new String[]{this.kzA.getString(R.string.delete_thread_reason_1), this.kzA.getString(R.string.delete_thread_reason_2), this.kzA.getString(R.string.delete_thread_reason_3), this.kzA.getString(R.string.delete_thread_reason_4), this.kzA.getString(R.string.delete_thread_reason_5)});
            this.izf.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.izf.Df(str);
            this.izf.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    az.this.kzA.a(aVar, jSONArray);
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
        sparseArray.put(kLY, Integer.valueOf(kLZ));
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
        this.kLh = new com.baidu.tbadk.core.dialog.a(this.kzA.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kLh.nt(i3);
        } else {
            this.kLh.setOnlyMessageShowCenter(false);
            this.kLh.zA(str2);
        }
        this.kLh.setYesButtonTag(sparseArray);
        this.kLh.a(R.string.dialog_ok, this.kzA);
        this.kLh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kLh.ig(true);
        this.kLh.b(this.kzA.getPageContext());
        if (z) {
            this.kLh.bhg();
        } else {
            a(this.kLh, i);
        }
    }

    public void aX(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.kLk == null) {
            this.kLk = LayoutInflater.from(this.kzA.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kzA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kLk);
        if (this.kLj == null) {
            this.kLj = new Dialog(this.kzA.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kLj.setCanceledOnTouchOutside(true);
            this.kLj.setCancelable(true);
            this.kLs = (ScrollView) this.kLk.findViewById(R.id.good_scroll);
            this.kLj.setContentView(this.kLk);
            WindowManager.LayoutParams attributes = this.kLj.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kLj.getWindow().setAttributes(attributes);
            this.hmf = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.kLo = (String) compoundButton.getTag();
                        if (az.this.hme != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.hme) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.kLo != null && !str.equals(az.this.kLo)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kLl = (LinearLayout) this.kLk.findViewById(R.id.good_class_group);
            this.kLn = (TextView) this.kLk.findViewById(R.id.dialog_button_cancel);
            this.kLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.kLj instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.kLj, az.this.kzA.getPageContext());
                    }
                }
            });
            this.kLm = (TextView) this.kLk.findViewById(R.id.dialog_button_ok);
            this.kLm.setOnClickListener(this.hVH);
        }
        this.kLl.removeAllViews();
        this.hme = new ArrayList();
        CustomBlueCheckRadioButton fu = fu("0", this.kzA.getPageContext().getString(R.string.thread_good_class));
        this.hme.add(fu);
        fu.setChecked(true);
        this.kLl.addView(fu);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bcS()) && ajVar.bcT() > 0) {
                    CustomBlueCheckRadioButton fu2 = fu(String.valueOf(ajVar.bcT()), ajVar.bcS());
                    this.hme.add(fu2);
                    View view = new View(this.kzA.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kLl.addView(view);
                    this.kLl.addView(fu2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kLs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kzA.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kzA.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kzA.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kLs.setLayoutParams(layoutParams2);
            this.kLs.removeAllViews();
            if (this.kLl != null && this.kLl.getParent() == null) {
                this.kLs.addView(this.kLl);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kLj, this.kzA.getPageContext());
    }

    private CustomBlueCheckRadioButton fu(String str, String str2) {
        Activity pageActivity = this.kzA.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hmf);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void daJ() {
        this.kzA.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.kzA.hideProgressBar();
        if (z && z2) {
            this.kzA.showToast(this.kzA.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.kzA.showToast(str);
        }
    }

    public void cGx() {
        this.kLf.setVisibility(0);
    }

    public void cGw() {
        this.kLf.setVisibility(8);
    }

    public View daK() {
        if (this.kLk != null) {
            return this.kLk.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String daL() {
        return this.kLo;
    }

    public View getView() {
        return this.bpx;
    }

    public void daM() {
        if (this.kzA != null && this.kzA.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kzA.getPageContext().getPageActivity(), this.kzA.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.kzA.hideProgressBar();
        if (z) {
            dbf();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dbg();
        } else {
            dbf();
        }
    }

    public void daN() {
        this.iaR.setLineVisible();
        this.iaR.startLoadData();
    }

    public void daO() {
        this.kzA.hideProgressBar();
        endLoadData();
        this.kKO.completePullRefreshPostDelayed(0L);
        dba();
    }

    public void daP() {
        this.kKO.completePullRefreshPostDelayed(0L);
        dba();
    }

    private void ty(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.kKT.b(onLongClickListener);
        this.kKZ.setOnLongClickListener(onLongClickListener);
        if (this.kMs != null) {
            this.kMs.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0538b interfaceC0538b, boolean z, boolean z2) {
        if (this.kDK != null) {
            this.kDK.dismiss();
            this.kDK = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kzA.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kzA.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kzA.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kzA.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kzA.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aT(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kLp.dismiss();
                interfaceC0538b.a(null, i, view);
            }
        });
        this.kLp = new com.baidu.tbadk.core.dialog.i(this.kzA.getPageContext(), kVar);
        this.kLp.Nv();
    }

    public void a(final b.InterfaceC0538b interfaceC0538b, boolean z) {
        if (this.kLp != null) {
            this.kLp.dismiss();
            this.kLp = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kzA.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kAH != null && this.kAH.cVm() != null && !this.kAH.cVm().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kzA.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kzA.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aT(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kLp.dismiss();
                interfaceC0538b.a(null, i, view);
            }
        });
        this.kLp = new com.baidu.tbadk.core.dialog.i(this.kzA.getPageContext(), kVar);
        this.kLp.Nv();
    }

    public int daQ() {
        return Eu(this.kKO.getFirstVisiblePosition());
    }

    private int Eu(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.kKO.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.kKO.getAdapter() == null || !(this.kKO.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.kKO.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int daR() {
        int lastVisiblePosition = this.kKO.getLastVisiblePosition();
        if (this.kKQ != null) {
            if (lastVisiblePosition == this.kKO.getCount() - 1) {
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
        if (this.kKO != null) {
            if (this.kKK == null || this.kKK.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.kKK.mNavigationBar.getFixedNavHeight();
                if (this.kzA.cXI() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.kLP != null && (layoutParams = (LinearLayout.LayoutParams) this.kLP.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.kLP.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.kKO.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.kKO.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.kKO.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.kLc.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.kKZ.a(fVar, false);
        this.kKZ.notifyDataSetChanged();
        dba();
        if (this.kMs != null) {
            this.kMs.cWA();
        }
        ArrayList<PostData> cVo = fVar.cVo();
        if (fVar.getPage().bdu() == 0 || cVo == null || cVo.size() < fVar.getPage().bdt()) {
            if (com.baidu.tbadk.core.util.y.getCount(cVo) == 0 || (com.baidu.tbadk.core.util.y.getCount(cVo) == 1 && cVo.get(0) != null && cVo.get(0).dwK() == 1)) {
                if (this.kLU == null || this.kLU.kMZ == null || this.kLU.kMZ.getView() == null) {
                    i = 0;
                } else {
                    i = this.kLU.kMZ.getView().getTop() < 0 ? this.kLU.kMZ.getView().getHeight() : this.kLU.kMZ.getView().getBottom();
                }
                if (this.kzA.cYc()) {
                    this.iaR.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.iaR.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bdu() == 0) {
                    this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iaR.bkw();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.kKR != null) {
            this.kKR.e(fVar, this.kAp);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cVz() != null) {
            return fVar.cVz();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.cVo())) {
            Iterator<PostData> it = fVar.cVo().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dwK() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cVv();
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
        if (fVar == null || fVar.cVm() == null || fVar.cVm().beE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData beE = fVar.cVm().beE();
        String userId = beE.getUserId();
        HashMap<String, MetaData> userMap = fVar.cVm().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = beE;
        }
        postData.HP(1);
        postData.setId(fVar.cVm().beV());
        postData.setTitle(fVar.cVm().getTitle());
        postData.setTime(fVar.cVm().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.cVm() != null) {
            if (this.kzA.cWu()) {
                if (fVar.cVl() != null) {
                    this.mForumName = fVar.cVl().getForumName();
                    this.mForumId = fVar.cVl().getForumId();
                }
                if (this.mForumName == null && this.kzA.cWE() != null && this.kzA.cWE().cWv() != null) {
                    this.mForumName = this.kzA.cWE().cWv();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.kKT.setVisibility(8);
            if (fVar.cVM()) {
                this.kMj = true;
                this.kKK.sD(true);
                this.kKK.mNavigationBar.hideBottomLine();
                if (this.kKQ == null) {
                    this.kKQ = new com.baidu.tieba.pb.pb.main.a.e(this.kzA);
                }
                this.kKQ.a(fVar, b, this.kKO, this.kKT, this.kLN, this.kKK, this.mForumName, this.kMx);
                this.kKQ.V(this.kMI);
                daV();
            } else {
                this.kMj = false;
                this.kKK.sD(this.kMj);
                if (this.kKQ != null) {
                    this.kKQ.c(this.kKO);
                }
            }
            if (this.kzA.cXs() != null) {
                this.kzA.cXs().tP(this.kMj);
            }
            if (b != null) {
                this.kLJ = b;
                this.kKT.setVisibility(0);
                SparseArray<Object> dbS = this.kKT.dbS();
                dbS.put(R.id.tag_clip_board, b);
                dbS.put(R.id.tag_is_subpb, false);
                this.kKU.a(fVar, this.kKO);
                this.kKS.A(fVar);
                this.kKR.e(fVar, this.kAp);
                this.kKR.z(fVar);
                this.kKT.a(this.mSkinType, this.kAH, b, this.kMI);
                if (this.kLQ != null) {
                    if (fVar.cVP()) {
                        this.kLQ.getView().setVisibility(8);
                    } else {
                        this.kLQ.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kyf);
                        if (fVar.cVm() != null) {
                            nVar.kyh = fVar.cVm().bev();
                        }
                        nVar.isNew = !this.kAp;
                        nVar.sortType = fVar.kwP;
                        nVar.kyj = fVar.cVQ();
                        nVar.kyk = this.kzA.cYc();
                        nVar.kyl = fVar.kwO;
                        this.kLQ.a(nVar);
                    }
                }
                if (fVar != null && fVar.cVm() != null) {
                    ap(fVar.cVm().beA() == 1, fVar.cVm().bez() == 1);
                }
                com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.kKZ != null && az.this.kKK != null && az.this.kKK.kRa != null && az.this.kAH != null && az.this.kAH.cVm() != null && !az.this.kAH.cVm().bdk() && !az.this.daZ() && az.this.kAH.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(az.this.kAH.getForum().getName())) {
                            if ((az.this.kKZ.cXg() == null || !az.this.kKZ.cXg().isShown()) && az.this.kKK.kRa != null) {
                                az.this.kKK.kRa.setVisibility(0);
                                if (az.this.kzA != null && az.this.kzA.cWE() != null) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13400");
                                    aqVar.dD("tid", az.this.kzA.cWE().cYC());
                                    aqVar.dD("fid", az.this.kzA.cWE().getForumId());
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

    public void tz(boolean z) {
        if (z) {
            daS();
        } else {
            cfQ();
        }
        this.kLU.kMZ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kLU));
        a(this.kLU.kMZ, false);
    }

    public void daS() {
        if (this.kKK != null && !this.kMl) {
            this.kKK.daS();
            this.kMl = true;
        }
    }

    public void cfQ() {
        if (this.kKK != null) {
            this.kKK.dcq();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.kKT.a(postData, fVar);
    }

    public void daT() {
        if (this.kKQ != null) {
            this.kKQ.d(this.kKO);
        }
    }

    public boolean daU() {
        return this.aXZ;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aJ(bw bwVar) {
        if (bwVar == null || bwVar.beE() == null) {
            return false;
        }
        PostData b = b(this.kAH, false);
        String str = "";
        if (b != null && b.beE() != null) {
            str = b.beE().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.kKK.dco();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.kKK.Lz(dVar.forumName);
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
            final String str2 = dVar.kwG;
            this.kzA.showNetRefreshView(this.bpx, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.be.bju().b(az.this.kzA.getPageContext(), new String[]{str2});
                        az.this.kzA.finish();
                        return;
                    }
                    az.this.kzA.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cZY;
        Parcelable cZY2;
        if (fVar != null && this.kKO != null) {
            this.kAH = fVar;
            this.mType = i;
            if (fVar.cVm() != null) {
                this.kLW = fVar.cVm().bel();
                if (fVar.cVm().getAnchorLevel() != 0) {
                    this.aXZ = true;
                }
                this.kLr = aJ(fVar.cVm());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.kLK = false;
            this.kAp = z;
            daO();
            if (fVar.kwQ != null && fVar.kwQ.cVV()) {
                if (this.kKP == null) {
                    this.kKP = new PbThreadPostView(this.kzA.getContext());
                    this.kKO.addHeaderView(this.kKP, 1);
                    this.kKP.setData(fVar);
                    this.kKP.setChildOnClickLinstener(this.hVH);
                }
            } else if (this.kKP != null && this.kKO != null) {
                this.kKO.removeHeaderView(this.kKP);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.kMv == null) {
                this.kMv = new al(this.kzA.getPageContext(), this.ivO);
            }
            this.kMv.NG(fVar.cVt());
            if (this.kzA.cXS()) {
                if (this.kLd == null) {
                    this.kLd = new com.baidu.tieba.pb.view.d(this.kzA.getPageContext());
                    this.kLd.createView();
                    this.kLd.setListPullRefreshListener(this.eta);
                }
                this.kKO.setPullRefresh(this.kLd);
                daV();
                if (this.kLd != null) {
                    this.kLd.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bdv() == 0 && z) {
                this.kKO.setPullRefresh(null);
            } else {
                if (this.kLd == null) {
                    this.kLd = new com.baidu.tieba.pb.view.d(this.kzA.getPageContext());
                    this.kLd.createView();
                    this.kLd.setListPullRefreshListener(this.eta);
                }
                this.kKO.setPullRefresh(this.kLd);
                daV();
                if (this.kLd != null) {
                    this.kLd.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bWr();
            }
            dba();
            this.kKZ.sG(this.kAp);
            this.kKZ.sH(false);
            this.kKZ.sL(i == 5);
            this.kKZ.sM(i == 6);
            this.kKZ.sN(z2 && this.kMH && i != 2);
            this.kKZ.a(fVar, false);
            this.kKZ.notifyDataSetChanged();
            this.kKT.b(b(fVar, z), fVar.cVP());
            if (fVar.cVm() != null && fVar.cVm().bep() != null && this.kKI != -1) {
                fVar.cVm().bep().setIsLike(this.kKI);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.kKO.setNextPage(this.iaR);
                this.kKJ = 2;
                bWr();
            } else {
                this.kLK = true;
                if (fVar.getPage().bdu() == 1) {
                    if (this.kLe == null) {
                        this.kLe = new com.baidu.tieba.pb.view.a(this.kzA, this.kzA);
                    }
                    this.kKO.setNextPage(this.kLe);
                } else {
                    this.kKO.setNextPage(this.iaR);
                }
                this.kKJ = 3;
            }
            ArrayList<PostData> cVo = fVar.cVo();
            if (fVar.getPage().bdu() == 0 || cVo == null || cVo.size() < fVar.getPage().bdt()) {
                if (com.baidu.tbadk.core.util.y.getCount(cVo) == 0 || (com.baidu.tbadk.core.util.y.getCount(cVo) == 1 && cVo.get(0) != null && cVo.get(0).dwK() == 1)) {
                    if (this.kLU == null || this.kLU.kMZ == null || this.kLU.kMZ.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.kLU.kMZ.getView().getTop() < 0 ? this.kLU.kMZ.getView().getHeight() : this.kLU.kMZ.getView().getBottom();
                    }
                    if (this.kzA.cYc()) {
                        this.iaR.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.iaR.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.kzA.cXs() != null && !this.kzA.cXs().dcc()) {
                        this.kzA.cXs().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bdu() == 0) {
                        this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iaR.bkw();
                }
                if (fVar.getPage().bdu() == 0 || cVo == null) {
                    dbk();
                }
            } else {
                if (z2) {
                    if (this.kMH) {
                        endLoadData();
                        if (fVar.getPage().bdu() != 0) {
                            this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iaR.setLineVisible();
                        this.iaR.showLoading();
                    }
                } else {
                    this.iaR.setLineVisible();
                    this.iaR.showLoading();
                }
                this.iaR.bkw();
            }
            switch (i) {
                case 2:
                    this.kKO.setSelection(i2 > 1 ? (((this.kKO.getData() == null && fVar.cVo() == null) ? 0 : (this.kKO.getData().size() - fVar.cVo().size()) + this.kKO.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cZY2 = as.cZX().cZY()) != null && !(cZY2 instanceof RecyclerView.SavedState)) {
                        this.kKO.onRestoreInstanceState(cZY2);
                        if (com.baidu.tbadk.core.util.y.getCount(cVo) > 1 && fVar.getPage().bdu() > 0) {
                            this.iaR.endLoadData();
                            this.iaR.setText(this.kzA.getString(R.string.pb_load_more_without_point));
                            this.iaR.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.kMH = false;
                    break;
                case 5:
                    this.kKO.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cZY = as.cZX().cZY()) != null && !(cZY instanceof RecyclerView.SavedState)) {
                        this.kKO.onRestoreInstanceState(cZY);
                        break;
                    } else {
                        this.kKO.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.kKQ != null && this.kKQ.bGk() != null) {
                            if (this.kzA.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.kKO.setSelectionFromTop((this.kKZ.cXb() + this.kKO.getHeaderViewsCount()) - 1, this.kKQ.dbU() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.kzA.getPageContext().getPageActivity()));
                            } else {
                                this.kKO.setSelectionFromTop((this.kKZ.cXb() + this.kKO.getHeaderViewsCount()) - 1, this.kKQ.dbU());
                            }
                        } else {
                            this.kKO.setSelection(this.kKZ.cXb() + this.kKO.getHeaderViewsCount());
                        }
                    } else {
                        this.kKO.setSelection(i2 > 0 ? ((this.kKO.getData() == null && fVar.cVo() == null) ? 0 : (this.kKO.getData().size() - fVar.cVo().size()) + this.kKO.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.iaR.endLoadData();
                    this.iaR.setText(this.kzA.getString(R.string.pb_load_more_without_point));
                    this.iaR.setLineGone();
                    break;
            }
            if (this.kLW == kLX && isHost()) {
                dbs();
            }
            if (this.kMh) {
                dal();
                this.kMh = false;
                if (i3 == 0) {
                    ts(true);
                }
            }
            if (fVar.kwM == 1 || fVar.kwN == 1) {
                if (this.kMn == null) {
                    this.kMn = new PbTopTipView(this.kzA.getContext());
                }
                if (fVar.kwN == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.kzA.getStType())) {
                    this.kMn.setText(this.kzA.getString(R.string.pb_read_strategy_add_experience));
                    this.kMn.a(this.bpx, this.mSkinType);
                } else if (fVar.kwM == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.kzA.getStType())) {
                    this.kMn.setText(this.kzA.getString(R.string.pb_read_news_add_experience));
                    this.kMn.a(this.bpx, this.mSkinType);
                }
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVm() != null) {
            x(fVar);
            if (fVar.baA()) {
                SvgManager.bjq().a(this.kLB, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bjq().a(this.kLB, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Ew = Ew(fVar.cVm().bev());
            if (this.kLE != null) {
                this.kLE.setText(Ew);
            }
            if (this.kLF != null) {
                this.kLF.setText(Ew);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.cVm()));
        }
    }

    private String Ew(int i) {
        if (i == 0) {
            return this.kzA.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void daV() {
        if (this.kKQ != null) {
            this.kKQ.a(this.kKO, this.textView, this.mType);
        }
    }

    public void tA(boolean z) {
        this.kLq = z;
    }

    public void endLoadData() {
        if (this.iaR != null) {
            this.iaR.setLineGone();
            this.iaR.endLoadData();
        }
        bWr();
    }

    public void bLt() {
        this.kKO.setVisibility(0);
    }

    public void daW() {
        if (this.kKO != null) {
            this.kKO.setVisibility(8);
        }
        if (this.kKO != null) {
            this.kLN.setVisibility(8);
        }
        if (this.kKK != null && this.kKK.kQZ != null) {
            this.kKK.kQZ.setVisibility(8);
        }
    }

    public void daX() {
        if (this.kKO != null) {
            this.kKO.setVisibility(0);
        }
        if (this.kLN != null) {
            this.kLN.setVisibility(0);
        }
        if (this.kKK != null && this.kKK.kQZ != null) {
            this.kKK.kQZ.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.kLJ != null && this.kLJ.beE() != null && this.kKK != null) {
            this.kMk = !this.kMj;
            this.kKK.tR(this.kMk);
            if (this.kzA.cXs() != null) {
                this.kzA.cXs().tQ(this.kMk);
            }
            daY();
            if (this.kzA != null && !this.kzA.cWu() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.cVJ())) {
                bs bsVar = fVar.cVJ().get(0);
                if (bsVar != null) {
                    this.kKK.fv(bsVar.getForumName(), bsVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.kKK.fv(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.kMk) {
                this.kKT.a(fVar, this.kLJ, this.kLr);
                if (this.kLP != null) {
                    this.kLP.setVisibility(8);
                }
                if (this.kMt == null) {
                    this.kMt = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.19
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.kzA != null && az.this.kzA.isAdded()) {
                                if (i < 0 && f > az.this.kMm) {
                                    az.this.dbf();
                                    az.this.dbr();
                                }
                                az.this.daP();
                            }
                        }
                    };
                }
                this.kKO.setListViewDragListener(this.kMt);
                return;
            }
            if (this.kLP != null) {
                this.kLP.setVisibility(0);
            }
            this.kKT.a(fVar, this.kLJ, this.kLr);
            this.kMt = null;
            this.kKO.setListViewDragListener(null);
        }
    }

    private void daY() {
        this.kKT.a(this.kAH, this.kLJ, this.kMk, this.kMj);
    }

    public boolean daZ() {
        return this.kAH == null || this.kAH.getForum() == null || "0".equals(this.kAH.getForum().getId()) || "me0407".equals(this.kAH.getForum().getName());
    }

    private boolean dba() {
        return this.kKR.tM(this.kAp);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cVm() == null) {
            return false;
        }
        if (fVar.cVm().beB() == 1 || fVar.cVm().getThreadType() == 33) {
            return true;
        }
        return !(fVar.cVm().beD() == null || fVar.cVm().beD().bgT() == 0) || fVar.cVm().bez() == 1 || fVar.cVm().beA() == 1 || fVar.cVm().bfs() || fVar.cVm().bfM() || fVar.cVm().bfF() || fVar.cVm().beP() != null || !com.baidu.tbadk.core.util.at.isEmpty(fVar.cVm().getCategory()) || fVar.cVm().beH() || fVar.cVm().beG();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.kKS != null) {
                if (fVar.cVm() != null && fVar.cVm().beS() == 0 && !fVar.cVm().bdk() && !this.kMA) {
                    if (fVar.cVm() != null) {
                        bw cVm = fVar.cVm();
                        cVm.z(true, w(fVar));
                        cVm.nf(3);
                        cVm.zn("2");
                    }
                    if (fVar.cVm().bdm()) {
                        this.kKT.c(this.kKO);
                        this.kKS.c(this.kKO);
                        this.kKS.b(this.kKO);
                        this.kKT.b(this.kKO);
                        this.kKT.E(this.kAH);
                        this.kKS.B(fVar);
                    } else {
                        this.kKT.E(this.kAH);
                        this.kKS.D(fVar);
                    }
                } else if (fVar.cVm().beS() == 1) {
                    if (fVar.cVm() != null) {
                        this.kKS.c(this.kKO);
                        this.kKT.E(this.kAH);
                    }
                } else {
                    this.kKS.c(this.kKO);
                    this.kKT.E(this.kAH);
                }
            }
            if (fVar.cVm() != null) {
                ao(fVar.cVm().beA() == 1, fVar.cVm().bez() == 1);
            }
            this.kAp = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dba();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cVB()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cVB()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> cVJ = fVar.cVJ();
                if (com.baidu.tbadk.core.util.y.getCount(cVJ) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : cVJ) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.eay) != null && abVar.dYk && !abVar.dYl && (abVar.type == 1 || abVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bsVar.getForumName(), 12)).append(this.kzA.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.kzA.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dbb() {
        return this.eRd;
    }

    public boolean dbc() {
        if (this.bqh == null || this.bqh.getParent() == null || this.iaR.isLoading()) {
            return false;
        }
        int bottom = this.bqh.getBottom();
        Rect rect = new Rect();
        this.bqh.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void NI(String str) {
        if (this.iaR != null) {
            this.iaR.setText(str);
        }
    }

    public void NJ(String str) {
        if (this.iaR != null) {
            int i = 0;
            if (this.kLU != null && this.kLU.kMZ != null && this.kLU.kMZ.getView() != null) {
                i = this.kLU.kMZ.getView().getTop() < 0 ? this.kLU.kMZ.getView().getHeight() : this.kLU.kMZ.getView().getBottom();
            }
            this.iaR.am(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.kKO;
    }

    public int dbd() {
        return R.id.richText;
    }

    public TextView cWO() {
        return this.kKT.cWO();
    }

    public void d(BdListView.e eVar) {
        this.kKO.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.eta = cVar;
        if (this.kLd != null) {
            this.kLd.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.av avVar, a.b bVar) {
        if (avVar != null) {
            int bds = avVar.bds();
            int bdp = avVar.bdp();
            if (this.kLa != null) {
                this.kLa.bhg();
            } else {
                this.kLa = new com.baidu.tbadk.core.dialog.a(this.kzA.getPageContext().getPageActivity());
                this.kLb = LayoutInflater.from(this.kzA.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.kLa.aX(this.kLb);
                this.kLa.a(R.string.dialog_ok, bVar);
                this.kLa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.dbf();
                        aVar.dismiss();
                    }
                });
                this.kLa.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.kMe == null) {
                            az.this.kMe = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.kzA.HidenSoftKeyPad((InputMethodManager) az.this.kzA.getBaseFragmentActivity().getSystemService("input_method"), az.this.bpx);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mS().postDelayed(az.this.kMe, 150L);
                    }
                });
                this.kLa.b(this.kzA.getPageContext()).bhg();
            }
            this.kLc = (EditText) this.kLb.findViewById(R.id.input_page_number);
            this.kLc.setText("");
            TextView textView = (TextView) this.kLb.findViewById(R.id.current_page_number);
            if (bds <= 0) {
                bds = 1;
            }
            if (bdp <= 0) {
                bdp = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bds), Integer.valueOf(bdp)));
            this.kzA.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.kLc, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.kKO.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.kzA.showToast(str);
    }

    public boolean tB(boolean z) {
        if (this.aaA == null || !this.aaA.bry()) {
            return false;
        }
        this.aaA.bpY();
        return true;
    }

    public void dbe() {
        if (this.kMJ != null) {
            while (this.kMJ.size() > 0) {
                TbImageView remove = this.kMJ.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        dbe();
        this.kKZ.DW(1);
        if (this.kKQ != null) {
            this.kKQ.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.kKZ.DW(2);
        if (this.kKQ != null) {
            this.kKQ.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.kzA.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kzA.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.kLD != null) {
            this.kLD.onDestroy();
        }
        if (this.kMg != null) {
            this.kMg.destroy();
        }
        if (this.kMv != null) {
            this.kMv.onDestory();
        }
        if (this.kMn != null) {
            this.kMn.hide();
        }
        this.kzA.hideProgressBar();
        if (this.fCq != null && this.hQf != null) {
            this.fCq.b(this.hQf);
        }
        dbf();
        endLoadData();
        if (this.kMe != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kMe);
        }
        if (this.kLM != null) {
            this.kLM.clearStatus();
        }
        this.kMD = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.kKZ.DW(3);
        if (this.boF != null) {
            this.boF.setBackgroundDrawable(null);
        }
        if (this.kKQ != null) {
            this.kKQ.destroy();
        }
        if (this.kKZ != null) {
            this.kKZ.onDestroy();
        }
        this.kKO.setOnLayoutListener(null);
        if (this.kMr != null) {
            this.kMr.coV();
        }
        if (this.kLV != null) {
            this.kLV.onDestroy();
        }
        if (this.kKT != null) {
            this.kKT.onDestroy();
        }
    }

    public boolean Ex(int i) {
        if (this.kKQ != null) {
            return this.kKQ.Ex(i);
        }
        return false;
    }

    public void dbf() {
        this.kKK.aRN();
        if (this.kKT != null) {
            this.kKT.dbf();
        }
        if (this.kzA != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kzA.getContext(), this.kLc);
        }
        dan();
        if (this.kDK != null) {
            this.kDK.dismiss();
        }
        dbh();
        if (this.kLa != null) {
            this.kLa.dismiss();
        }
        if (this.hVG != null) {
            this.hVG.dismiss();
        }
    }

    public void dbg() {
        this.kKK.aRN();
        if (this.kKT != null) {
            this.kKT.dbf();
        }
        if (this.kDK != null) {
            this.kDK.dismiss();
        }
        dbh();
        if (this.kLa != null) {
            this.kLa.dismiss();
        }
        if (this.hVG != null) {
            this.hVG.dismiss();
        }
    }

    public void eC(List<String> list) {
        this.kMq = list;
        if (this.kMr != null) {
            this.kMr.setData(list);
        }
    }

    public void sF(boolean z) {
        this.kKZ.sF(z);
    }

    public void tC(boolean z) {
        this.kLt = z;
    }

    public void dbh() {
        if (this.kLh != null) {
            this.kLh.dismiss();
        }
        if (this.kLi != null) {
            com.baidu.adp.lib.f.g.b(this.kLi, this.kzA.getPageContext());
        }
        if (this.kLj != null) {
            com.baidu.adp.lib.f.g.b(this.kLj, this.kzA.getPageContext());
        }
        if (this.kLg != null) {
            this.kLg.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.kAH, this.kAp);
            b(this.kAH, this.kAp, this.mType, i);
            this.kzA.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.kzA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bpx);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bpx, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kLu, R.drawable.personalize_tab_shadow);
            if (this.kKQ != null) {
                this.kKQ.onChangeSkinType(i);
            }
            if (this.kKU != null) {
                this.kKU.onChangeSkinType(i);
            }
            if (this.kKR != null) {
                this.kKR.onChangeSkinType(i);
            }
            if (this.kKS != null) {
                this.kKS.onChangeSkinType(i);
            }
            if (this.kKT != null) {
                this.kKT.onChangeSkinType(i);
            }
            if (this.iaR != null) {
                this.iaR.changeSkin(i);
                if (this.eRd != null) {
                    this.kzA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eRd);
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(this.eRd, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.kLa != null) {
                this.kLa.c(this.kzA.getPageContext());
            }
            tA(this.kLq);
            this.kKZ.notifyDataSetChanged();
            if (this.kLd != null) {
                this.kLd.changeSkin(i);
            }
            if (this.aaA != null) {
                this.aaA.onChangeSkinType(i);
            }
            if (this.kLe != null) {
                this.kLe.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.hme)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.hme) {
                    customBlueCheckRadioButton.bkj();
                }
            }
            daE();
            UtilHelper.setStatusBarBackground(this.boF, i);
            UtilHelper.setStatusBarBackground(this.kLP, i);
            if (this.kKV != null) {
                com.baidu.tbadk.r.a.a(this.kzA.getPageContext(), this.kKV);
            }
            if (this.kMf != null) {
                this.kMf.onChangeSkinType(i);
            }
            if (this.kKK != null) {
                if (this.kKQ != null) {
                    this.kKQ.Ey(i);
                } else {
                    this.kKK.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.iUa != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.iUa, R.color.cp_cont_d);
            }
            if (this.kLz != null) {
                this.kLz.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
            }
            if (this.kLy != null) {
                this.kLy.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.kzA.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j)));
            }
            if (this.kLB != null && this.kAH != null) {
                if (this.kAH.baA()) {
                    SvgManager.bjq().a(this.kLB, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.bjq().a(this.kLB, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            x(this.kAH);
            if (this.kLA != null) {
                SvgManager.bjq().a(this.kLA, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kLw != null) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kLw, R.drawable.bottom_shadow);
            }
            if (this.kLE != null) {
                com.baidu.tbadk.core.util.ap.c(this.kLE, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kLE, R.color.cp_cont_a);
            }
            if (this.kLF != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kLF, R.color.cp_cont_b);
            }
            if (this.kMs != null) {
                this.kMs.onChangeSkinType(i);
            }
            if (this.kLV != null) {
                this.kLV.onChangeSkinType();
            }
            if (this.kMp != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kMp, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kLx, R.color.cp_bg_line_h);
            if (this.kKP != null) {
                this.kKP.tl(i);
            }
            if (this.kLD != null) {
                this.kLD.onChangeSkinType();
            }
        }
    }

    public void dbi() {
        if (this.kLD != null) {
            this.kLD.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aY(fVar.cVm())) {
            if (this.kLD != null) {
                this.kLD.setEnable(false);
                this.kLD.onDestroy();
            }
            SvgManager.bjq().a(this.kLC, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kLD == null || !this.kLD.isEnable()) {
            SvgManager.bjq().a(this.kLC, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcC = iVar;
        this.kKZ.setOnImageClickListener(this.fcC);
        this.kMs.setOnImageClickListener(this.fcC);
    }

    public void g(NoNetworkView.a aVar) {
        this.hQf = aVar;
        if (this.fCq != null) {
            this.fCq.a(this.hQf);
        }
    }

    public void tD(boolean z) {
        this.kKZ.setIsFromCDN(z);
    }

    public Button dbj() {
        return this.kLv;
    }

    public void dbk() {
        if (this.kKJ != 2) {
            this.kKO.setNextPage(this.iaR);
            this.kKJ = 2;
        }
    }

    public void dbl() {
        if (com.baidu.tbadk.n.m.buo().bup()) {
            int lastVisiblePosition = this.kKO.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.kKO.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.eRM = true;
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
                        perfLog2.eRM = true;
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

    public boolean dbm() {
        return this.aaA != null && this.aaA.getVisibility() == 0;
    }

    public boolean dbn() {
        return this.aaA != null && this.aaA.bry();
    }

    public void dbo() {
        if (this.aaA != null) {
            this.aaA.bpY();
        }
    }

    public void tE(boolean z) {
        if (this.kLx != null) {
            tC(this.kzA.cXp().bsf());
            if (this.kLt) {
                tt(z);
            } else {
                tu(z);
            }
        }
    }

    public void dbp() {
        if (this.kLx != null) {
            this.kLw.setVisibility(8);
            this.kLx.setVisibility(8);
            this.kLG = false;
            if (this.kLV != null) {
                this.kLV.setVisibility(8);
                ty(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.hqa == null) {
            this.hqa = new com.baidu.tbadk.core.view.a(this.kzA.getPageContext());
        }
        this.hqa.setDialogVisiable(true);
    }

    public void bWr() {
        if (this.hqa != null) {
            this.hqa.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.kKO.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.kKO.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kKQ != null) {
            this.kKQ.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.kMK = getScrollY();
            this.kLU.kMZ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kLU));
            a(this.kLU.kMZ, true);
        }
    }

    public void tF(boolean z) {
        if (this.kKQ != null) {
            this.kKQ.tF(z);
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
        if (this.kKQ != null) {
            this.kKQ.onScroll(absListView, i, i2, i3);
        }
        if (this.kKK != null && this.kKT != null) {
            this.kKK.cW(this.kKT.dbQ());
        }
        this.kLU.kqv = i;
        this.kLU.headerCount = this.kKO.getHeaderViewsCount();
        this.kLU.kMZ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kLU));
        tv(b(absListView, i));
        a(this.kLU.kMZ, false);
        if (this.iaR.bkx() && !this.iaR.esh) {
            if (this.kLU != null && this.kLU.kMZ != null && this.kLU.kMZ.getView() != null) {
                i4 = this.kLU.kMZ.getView().getTop() < 0 ? this.kLU.kMZ.getView().getHeight() : this.kLU.kMZ.getView().getBottom();
            }
            this.iaR.oO(i4);
            this.iaR.esh = true;
        }
    }

    public void dbq() {
        if (TbadkCoreApplication.isLogin() && this.kAH != null && this.kMk && !this.kMj && !this.kLr && this.kLJ != null && this.kLJ.beE() != null && !this.kLJ.beE().getIsLike() && !this.kLJ.beE().hadConcerned() && this.kMg == null) {
            this.kMg = new av(this.kzA);
        }
    }

    public void dbr() {
        if (this.kzA != null) {
            if ((this.hSJ || this.kMy == 17) && com.baidu.tbadk.a.d.bai()) {
                if (this.kAH != null && this.kAH.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.kAH.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.kzA.getContext()).createNormalCfg(this.kAH.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13853").dD("post_id", this.kAH.getThreadId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("fid", this.kAH.getForum().getId()));
                }
            } else if (this.kMk && !this.kMj && this.kLJ != null && this.kLJ.beE() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12601").ai("obj_locate", this.kzA.cWu() ? 2 : 1).ai("obj_type", this.kMj ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kzA.getPageContext().getPageActivity(), this.kLJ.beE().getUserId(), this.kLJ.beE().getUserName(), this.kzA.cWE().cWv(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.kMj && this.kLO != null && this.kKK.dci() != null) {
            int cXc = this.kKZ.cXc();
            if (cXc > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (cXc > this.kKO.getFirstVisiblePosition() - this.kKO.getHeaderViewsCount()) {
                    this.kLO.setVisibility(4);
                    return;
                }
                this.kLO.setVisibility(0);
                tv(false);
                this.kKK.mNavigationBar.hideBottomLine();
                if (this.kLO.getParent() != null && ((ViewGroup) this.kLO.getParent()).getHeight() <= this.kLO.getTop()) {
                    this.kLO.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.kKj == null) {
                if (this.kKO.getFirstVisiblePosition() == 0) {
                    this.kLO.setVisibility(4);
                    this.kKK.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.kLT) {
                        this.kLS = top;
                        this.kLT = false;
                    }
                    this.kLS = top < this.kLS ? top : this.kLS;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.kKY.getY() < 0.0f) {
                        measuredHeight = kLR - auVar.kKj.getMeasuredHeight();
                    } else {
                        measuredHeight = this.kKK.dci().getMeasuredHeight() - auVar.kKj.getMeasuredHeight();
                        this.kKK.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.kLS) {
                        this.kLO.setVisibility(0);
                        tv(false);
                    } else if (top < measuredHeight) {
                        this.kLO.setVisibility(0);
                        tv(false);
                    } else {
                        this.kLO.setVisibility(4);
                        this.kKK.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.kLT = true;
                    }
                }
            }
        }
    }

    public void dbs() {
        if (!this.kML) {
            TiebaStatic.log("c10490");
            this.kML = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kzA.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(kLY, Integer.valueOf(kMa));
            aVar.ns(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.kzA.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aX(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.kzA);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kzA.getPageContext()).bhg();
        }
    }

    public void NK(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kzA.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.kzA.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aX(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(kLY, Integer.valueOf(kMb));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.kzA);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kzA.getPageContext()).bhg();
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
        this.kKT.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dbt() {
        return this.kLM;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVm() != null && fVar.cVm().bfM() && this.kLM == null) {
            this.kLM = (PbInterviewStatusView) this.kLL.inflate();
            this.kLM.setOnClickListener(this.hVH);
            this.kLM.setCallback(this.kzA.cYa());
            this.kLM.setData(this.kzA, fVar);
        }
    }

    public RelativeLayout dbu() {
        return this.kKY;
    }

    public View dbv() {
        return this.boF;
    }

    public boolean dbw() {
        return this.kMA;
    }

    public void sK(boolean z) {
        this.kKT.sK(z);
    }

    public void NL(String str) {
        if (this.kKL != null) {
            this.kKL.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int tG(boolean z) {
        if (this.kLM == null || this.kLM.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dbx() {
        if (this.kLM != null && this.kLM.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kLM.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.kLM.setLayoutParams(layoutParams);
        }
    }

    public boolean cXv() {
        return false;
    }

    public void NM(String str) {
        this.iUa.performClick();
        if (!StringUtils.isNull(str) && this.kzA.cXp() != null && this.kzA.cXp().brX() != null && this.kzA.cXp().brX().getInputView() != null) {
            EditText inputView = this.kzA.cXp().brX().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dbf();
            if (configuration.orientation == 2) {
                dbp();
                dan();
            } else {
                dar();
            }
            if (this.kMf != null) {
                this.kMf.cXk();
            }
            this.kzA.cmt();
            this.kKY.setVisibility(8);
            this.kKK.tS(false);
            this.kzA.sZ(false);
            if (this.kKQ != null) {
                if (configuration.orientation == 1) {
                    dbu().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.kKO.setIsLandscape(true);
                    this.kKO.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.kKO.setIsLandscape(false);
                    if (this.kMK > 0) {
                        this.kKO.smoothScrollBy(this.kMK, 0);
                    }
                }
                this.kKQ.onConfigurationChanged(configuration);
                this.kLN.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void tH(boolean z) {
        if (this.kKQ != null) {
            this.kKQ.tH(z);
        }
    }

    public boolean dby() {
        return this.kKQ != null && this.kKQ.dby();
    }

    public void dbz() {
        if (this.kKQ != null) {
            this.kKQ.dbz();
        }
    }

    public void sO(boolean z) {
        this.kKZ.sO(z);
    }

    public void cU(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.kLx.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.kzA.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.kMp = new TextView(this.kzA.getContext());
            this.kMp.setText(R.string.connection_tips);
            this.kMp.setGravity(17);
            this.kMp.setPadding(com.baidu.adp.lib.util.l.getDimens(this.kzA.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.kzA.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kzA.getContext(), R.dimen.ds60);
            if (this.kMp.getParent() == null) {
                frameLayout.addView(this.kMp, layoutParams);
            }
            this.kMo = new PopupWindow(this.kzA.getContext());
            this.kMo.setContentView(frameLayout);
            this.kMo.setHeight(-2);
            this.kMo.setWidth(-2);
            this.kMo.setFocusable(true);
            this.kMo.setOutsideTouchable(false);
            this.kMo.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.kKO.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.25
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.kMo.showAsDropDown(az.this.kLx, view.getLeft(), -az.this.kLx.getHeight());
                    } else {
                        az.this.kMo.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void tI(boolean z) {
        this.kMu = z;
    }

    public boolean dbA() {
        return this.kMu;
    }

    public PbThreadPostView dbB() {
        return this.kKP;
    }

    private void ao(boolean z, boolean z2) {
        ap(z, z2);
        if (this.kAH != null && this.kAH.cVm() != null && this.kAH.cVm().beS() == 0 && !this.kAH.cVm().bdk()) {
            aq(z, z2);
        } else if (this.kKZ != null && this.kKZ.cXh() != null) {
            this.kKZ.cXh().b(this.kAH, z, z2);
        }
    }

    private void ap(boolean z, boolean z2) {
        this.kKT.d(this.kAH, z, z2);
    }

    private void aq(boolean z, boolean z2) {
        this.kKS.c(this.kAH, z, z2);
    }

    public void tJ(boolean z) {
        this.hSJ = z;
    }

    public void Ep(int i) {
        this.kMy = i;
    }

    public void dbC() {
        if (this.kKO != null) {
            this.kKO.setForbidDragListener(true);
        }
    }

    public boolean cYu() {
        if (this.kKO == null) {
            return false;
        }
        return this.kKO.cYu();
    }
}
