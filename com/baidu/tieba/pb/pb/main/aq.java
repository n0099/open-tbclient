package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
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
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbLongPressTipView;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
import tbclient.SmartApp;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class aq {
    private static final int hWH = UtilHelper.getLightStatusBarHeight();
    public static int hWN = 3;
    public static int hWO = 0;
    public static int hWP = 3;
    public static int hWQ = 4;
    public static int hWR = 5;
    public static int hWS = 6;
    private static a.InterfaceC0518a hXq = new a.InterfaceC0518a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0518a
        public void onRefresh() {
        }
    };
    private EditorTools Dl;
    private View apC;
    private RelativeLayout aqs;
    private View arb;
    private View cLA;
    private h.c cpS;
    private com.baidu.tieba.pb.a.c czv;
    private List<CustomBlueCheckRadioButton> ePo;
    private PbListView fBV;
    private NavigationBarCoverTip fUt;
    private com.baidu.tieba.NEGFeedBack.e fXn;
    private NoNetworkView fbw;
    private View.OnClickListener fxy;
    private TextView gox;
    private PbActivity hNY;
    PbActivity.d hNd;
    private View.OnClickListener hOy;
    private UserIconBox hPm;
    private UserIconBox hPn;
    private PbFakeFloorModel hQn;
    private com.baidu.tieba.pb.data.d hRx;
    public int hUO;
    public com.baidu.tieba.pb.video.i hUP;
    private long hUQ;
    private com.baidu.tieba.pb.video.h hUR;
    private com.baidu.tieba.c.d hUS;
    public final com.baidu.tieba.pb.pb.main.view.c hUV;
    public com.baidu.tieba.pb.pb.main.view.b hUW;
    private ViewStub hUX;
    private ViewStub hUY;
    private PbLandscapeListView hUZ;
    private ao hVA;
    private TextView hVB;
    private TextView hVC;
    private TextView hVD;
    private TextView hVE;
    private View hVF;
    private View hVG;
    private LinearLayout hVH;
    private TextView hVI;
    private TextView hVJ;
    private View hVK;
    private View hVL;
    private ObservedChangeLinearLayout hVN;
    private f hVO;
    private View hVU;
    private PbThreadPostView hVa;
    private View hVb;
    private RelativeLayout hVc;
    private HeadImageView hVd;
    private TextView hVe;
    private TextView hVf;
    private ImageView hVg;
    private RelativeLayout hVj;
    private ImageView hVk;
    private ImageView hVl;
    private e hVm;
    private ColumnLayout hVn;
    private ThreadSkinView hVo;
    private TextView hVp;
    private TextView hVq;
    private ImageView hVr;
    private HeadPendantView hVs;
    private FrameLayout hVt;
    private HeadImageView hVu;
    private View hVv;
    private LinearLayout hVw;
    private PbFirstFloorUserLikeButton hVz;
    private PbInterviewStatusView hWA;
    private ViewGroup hWB;
    private TextView hWC;
    private FrameLayout hWD;
    private View hWE;
    private View hWF;
    private al hWG;
    private PbEmotionBar hWL;
    private int hWT;
    private Runnable hWU;
    private s hWV;
    private an hWW;
    private View hWm;
    private View hWn;
    private ImageView hWo;
    private ImageView hWp;
    private ImageView hWq;
    private TextView hWr;
    private int hWt;
    private int hWu;
    private PostData hWv;
    private View hWx;
    private TextView hWy;
    private ViewStub hWz;
    private PbActivity.b hXA;
    public int hXE;
    private int hXc;
    private PbTopTipView hXe;
    private PopupWindow hXf;
    private TextView hXg;
    private com.baidu.tbadk.core.dialog.a hXh;
    private List<String> hXi;
    private com.baidu.tieba.pb.pb.main.emotion.c hXj;
    private com.baidu.tieba.pb.pb.godreply.a hXk;
    private PbLandscapeListView.b hXl;
    private ac hXn;
    private String hXo;
    private boolean hXr;
    private com.baidu.tbadk.core.view.userLike.c hXs;
    private com.baidu.tbadk.core.view.userLike.c hXt;
    private Runnable hXy;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private boolean hUT = false;
    private int hUU = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hVh = null;
    private TextView hVi = null;
    public FrsPraiseView hVx = null;
    private ClickableHeaderImageView hVy = null;
    private View hVM = null;
    private com.baidu.tbadk.core.dialog.a hVP = null;
    private com.baidu.tbadk.core.dialog.b fxx = null;
    private View hVQ = null;
    private EditText hVR = null;
    private com.baidu.tieba.pb.view.c hVS = null;
    private com.baidu.tieba.pb.view.a hVT = null;
    private com.baidu.tbadk.core.dialog.a hVV = null;
    private b.a gKD = null;
    private TbRichTextView.h cUE = null;
    private NoNetworkView.a fsT = null;
    private com.baidu.tbadk.core.dialog.i hVW = null;
    private View hVX = null;
    private com.baidu.tbadk.core.dialog.a hVY = null;
    private Dialog hVZ = null;
    private Dialog hWa = null;
    private View hWb = null;
    private LinearLayout hWc = null;
    private CompoundButton.OnCheckedChangeListener ePp = null;
    private TextView hWd = null;
    private TextView hWe = null;
    private String hWf = null;
    private com.baidu.tbadk.core.dialog.i hMc = null;
    private com.baidu.tbadk.core.dialog.i hWg = null;
    private boolean hWh = false;
    private boolean hWi = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hWj = null;
    private boolean hWk = false;
    private Button hWl = null;
    private boolean hWs = true;
    private com.baidu.tbadk.core.view.b eWx = null;
    private boolean hOq = false;
    private int mSkinType = 3;
    private boolean hWw = false;
    private int hWI = 0;
    private boolean hWJ = true;
    public a hWK = new a();
    private int hWM = 0;
    private boolean hWX = false;
    private int hWY = 0;
    private boolean hWZ = false;
    private boolean hXa = false;
    private boolean hXb = false;
    private int hXd = 0;
    private boolean hXm = false;
    private int hXp = R.drawable.bg_user_identity_btn;
    private String hXu = null;
    private CustomMessageListener hXv = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hXu = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hVO != null) {
                aq.this.hVO.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hXw = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hVi != null) {
                aq.this.hVi.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hXx = new Handler();
    private CustomMessageListener hXz = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hWs = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hXB = true;
    View.OnClickListener hXC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hWZ) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").O("obj_id", 2));
            }
            if (!aq.this.hWZ && aq.this.hRx != null && aq.this.hRx.bQz() != null && aq.this.hRx.bQz().aiG() != null && aq.this.hRx.bQz().aiG().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").O("obj_locate", 1));
            }
            aq.this.hNY.hLX.fXW.onClick(view);
        }
    };
    private boolean dOk = false;
    String userId = null;
    private final List<TbImageView> hXD = new ArrayList();
    private boolean hXF = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int hEh;
        public al hXU;
        public int headerCount;
    }

    public void oA(boolean z) {
        this.hWX = z;
        if (this.hUZ != null) {
            this.hWY = this.hUZ.getHeaderViewsCount();
        }
    }

    public void bUV() {
        if (this.hUZ != null) {
            int headerViewsCount = this.hUZ.getHeaderViewsCount() - this.hWY;
            final int firstVisiblePosition = (this.hUZ.getFirstVisiblePosition() == 0 || this.hUZ.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hUZ.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hUZ.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hWK.hXU = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.hWK));
            final al alVar = this.hWK.hXU;
            final int h = h(alVar);
            final int y = ((int) this.hVN.getY()) + this.hVN.getMeasuredHeight();
            final boolean z = this.hWE.getVisibility() == 0;
            boolean z2 = this.hVN.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hVO.bTe() + this.hUZ.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hUt.getMeasuredHeight() : 0;
                if (z2) {
                    this.hUZ.setSelectionFromTop(this.hVO.bTe() + this.hUZ.getHeaderViewsCount(), hWH - measuredHeight);
                } else {
                    this.hUZ.setSelectionFromTop(this.hVO.bTe() + this.hUZ.getHeaderViewsCount(), this.hUV.bWH().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hUZ.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hWZ) {
                this.hUZ.setSelectionFromTop(this.hVO.bTe() + this.hUZ.getHeaderViewsCount(), this.hUP.aJy().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hUZ.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bTw() {
                        if (h >= 0 && h <= aq.this.aqs.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.arb.getLayoutParams();
                            if (i == 0 || i > aq.this.aqs.getMeasuredHeight() || h2 >= aq.this.aqs.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hWT;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.aqs.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hWT;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hUZ.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.arb.setLayoutParams(layoutParams);
                            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (aq.this.arb != null && aq.this.arb.getLayoutParams() != null) {
                                        ViewGroup.LayoutParams layoutParams2 = aq.this.arb.getLayoutParams();
                                        layoutParams2.height = aq.this.hWT;
                                        aq.this.arb.setLayoutParams(layoutParams2);
                                    }
                                }
                            });
                        }
                        aq.this.hUZ.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(al alVar) {
        if (alVar == null || alVar.getView() == null) {
            return 0;
        }
        if (alVar.getView().getTop() != 0 || alVar.getView().isShown()) {
            return alVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView bUW() {
        return this.fbw;
    }

    public void bUX() {
        if (this.Dl != null) {
            this.Dl.hide();
            if (this.hXj != null) {
                this.hXj.beV();
            }
        }
    }

    public PbFakeFloorModel bUY() {
        return this.hQn;
    }

    public s bUZ() {
        return this.hWV;
    }

    public void bVa() {
        reset();
        bUX();
        this.hWV.bTn();
        oL(false);
    }

    private void reset() {
        if (this.hNY != null && this.hNY.bRS() != null && this.Dl != null) {
            com.baidu.tbadk.editortools.pb.a.auv().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bRS = this.hNY.bRS();
            bRS.auO();
            bRS.auj();
            if (bRS.getWriteImagesInfo() != null) {
                bRS.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bRS.jR(SendView.ALL);
            bRS.jS(SendView.ALL);
            com.baidu.tbadk.editortools.g jI = this.Dl.jI(23);
            com.baidu.tbadk.editortools.g jI2 = this.Dl.jI(2);
            com.baidu.tbadk.editortools.g jI3 = this.Dl.jI(5);
            if (jI2 != null) {
                jI2.le();
            }
            if (jI3 != null) {
                jI3.le();
            }
            if (jI != null) {
                jI.hide();
            }
            this.Dl.invalidate();
        }
    }

    public boolean bVb() {
        return this.hWs;
    }

    public void oB(boolean z) {
        if (this.hWn != null && this.gox != null) {
            this.gox.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hWn.startAnimation(alphaAnimation);
            }
            this.hWm.setVisibility(0);
            this.hWn.setVisibility(0);
            this.hWs = true;
            if (this.hWL != null && !this.hXk.isActive()) {
                this.hWL.setVisibility(0);
                oF(true);
            }
        }
    }

    public void oC(boolean z) {
        if (this.hWn != null && this.gox != null) {
            this.gox.setText(bVc());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hWn.startAnimation(alphaAnimation);
            }
            this.hWm.setVisibility(0);
            this.hWn.setVisibility(0);
            this.hWs = true;
            if (this.hWL != null && !this.hXk.isActive()) {
                this.hWL.setVisibility(0);
                oF(true);
            }
        }
    }

    public String bVc() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.hXo)) {
            return this.hXo;
        }
        if (this.hNY != null) {
            this.hXo = this.hNY.getResources().getString(ap.bUU());
        }
        return this.hXo;
    }

    public PostData bVd() {
        int i = 0;
        if (this.hUZ == null) {
            return null;
        }
        int bVe = bVe() - this.hUZ.getHeaderViewsCount();
        if (bVe < 0) {
            bVe = 0;
        }
        if (this.hVO.wx(bVe) != null && this.hVO.wx(bVe) != PostData.jin) {
            i = bVe + 1;
        }
        return this.hVO.getItem(i) instanceof PostData ? (PostData) this.hVO.getItem(i) : null;
    }

    public int bVe() {
        int i;
        View childAt;
        if (this.hUZ == null) {
            return 0;
        }
        int firstVisiblePosition = this.hUZ.getFirstVisiblePosition();
        int lastVisiblePosition = this.hUZ.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hUZ.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hUZ.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bVf() {
        return this.hUZ.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hRx != null && this.hRx.bQB() != null && !this.hRx.bQB().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hRx.bQB().size() && (postData = this.hRx.bQB().get(i)) != null && postData.aiG() != null && !StringUtils.isNull(postData.aiG().getUserId()); i++) {
                if (this.hRx.bQB().get(i).aiG().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hXk != null && this.hXk.isActive()) {
                        oL(false);
                    }
                    if (this.hWL != null) {
                        this.hWL.oT(true);
                    }
                    this.hXu = postData.aiG().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hNY = null;
        this.aqs = null;
        this.apC = null;
        this.hUQ = 0L;
        this.hUZ = null;
        this.hVb = null;
        this.hVj = null;
        this.hVn = null;
        this.hVp = null;
        this.hVq = null;
        this.hVt = null;
        this.hVu = null;
        this.hVv = null;
        this.hVz = null;
        this.hVB = null;
        this.hVC = null;
        this.hVD = null;
        this.hVE = null;
        this.hVK = null;
        this.hVL = null;
        this.hVO = null;
        this.fBV = null;
        this.cLA = null;
        this.fxy = null;
        this.hOy = null;
        this.hWn = null;
        this.gox = null;
        this.hWx = null;
        this.hWy = null;
        this.hWz = null;
        this.hXc = 0;
        this.hUQ = System.currentTimeMillis();
        this.hNY = pbActivity;
        this.fxy = onClickListener;
        this.czv = cVar;
        this.hXc = com.baidu.adp.lib.util.l.getEquipmentWidth(this.hNY) / 2;
        this.aqs = (RelativeLayout) LayoutInflater.from(this.hNY.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.hNY.addContentView(this.aqs, new FrameLayout.LayoutParams(-1, -1));
        this.fUt = (NavigationBarCoverTip) this.hNY.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.apC = this.hNY.findViewById(R.id.statebar_view);
        this.hVN = (ObservedChangeLinearLayout) this.hNY.findViewById(R.id.title_wrapper);
        this.fbw = (NoNetworkView) this.hNY.findViewById(R.id.view_no_network);
        this.hUZ = (PbLandscapeListView) this.hNY.findViewById(R.id.new_pb_list);
        this.hWD = (FrameLayout) this.hNY.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.hNY.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.hNY.getActivity(), R.dimen.ds88));
        this.hUZ.addHeaderView(this.textView, 0);
        this.hWT = this.hNY.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.arb = new View(this.hNY.getPageContext().getPageActivity());
        this.arb.setLayoutParams(new AbsListView.LayoutParams(-1, this.hWT));
        this.arb.setVisibility(4);
        this.hUZ.addFooterView(this.arb);
        this.hUZ.setOnTouchListener(this.hNY.cAp);
        this.hUV = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.hNY.bSw()) {
            this.hUX = (ViewStub) this.hNY.findViewById(R.id.manga_view_stub);
            this.hUX.setVisibility(0);
            this.hUW = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.hUW.show();
            this.hUV.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.hNY.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.hUV.bWH().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0477a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0477a
            public void bRp() {
                if (aq.this.hUZ != null) {
                    if (aq.this.hUP != null) {
                        aq.this.hUP.bYc();
                    }
                    aq.this.hUZ.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0477a
            public void bRq() {
                aq.this.hNY.bkl();
            }
        }));
        this.hWm = this.hNY.findViewById(R.id.view_comment_top_line);
        this.hWn = this.hNY.findViewById(R.id.pb_editor_tool_comment);
        this.hWt = com.baidu.adp.lib.util.l.getDimens(this.hNY.getPageContext().getPageActivity(), R.dimen.tbds120);
        this.hWu = com.baidu.adp.lib.util.l.getDimens(this.hNY.getPageContext().getPageActivity(), R.dimen.ds242);
        this.gox = (TextView) this.hNY.getPageContext().getPageActivity().findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.gox.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hNY.bSc();
                if (aq.this.hNY != null && aq.this.hNY.bRF() != null && aq.this.hNY.bRF().getPbData() != null && aq.this.hNY.bRF().getPbData().bQz() != null && aq.this.hNY.bRF().getPbData().bQz().aiG() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", aq.this.hNY.bRF().hRb).bS("fid", aq.this.hNY.bRF().getPbData().getForumId()).O("obj_locate", 1).bS("uid", aq.this.hNY.bRF().getPbData().bQz().aiG().getUserId()));
                }
            }
        });
        this.hWo = (ImageView) this.hNY.findViewById(R.id.pb_editor_tool_comment_icon);
        this.hWo.setOnClickListener(this.fxy);
        this.hWp = (ImageView) this.hNY.findViewById(R.id.pb_editor_tool_collection);
        this.hWp.setOnClickListener(this.fxy);
        this.hWq = (ImageView) this.hNY.findViewById(R.id.pb_editor_tool_share);
        this.hWq.setOnClickListener(this.fxy);
        this.hWr = (TextView) this.hNY.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.hVb = LayoutInflater.from(this.hNY.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.hVj = (RelativeLayout) LayoutInflater.from(this.hNY.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.hVk = (ImageView) this.hVj.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.hVm = new e(this.hNY, this.hVj);
        this.hVm.init();
        this.hVm.a(this.hVm.bRR(), this.fxy);
        this.hVn = (ColumnLayout) this.hVj.findViewById(R.id.pb_head_owner_root);
        this.hVo = (ThreadSkinView) this.hVj.findViewById(R.id.pb_thread_skin);
        this.hVn.setOnLongClickListener(this.onLongClickListener);
        this.hVn.setOnTouchListener(this.czv);
        this.hVn.setVisibility(8);
        this.hVb.setOnTouchListener(this.czv);
        this.hWx = this.hVb.findViewById(R.id.pb_head_activity_join_number_container);
        this.hWx.setVisibility(8);
        this.hWy = (TextView) this.hVb.findViewById(R.id.pb_head_activity_join_number);
        this.hVp = (TextView) this.hVn.findViewById(R.id.pb_head_owner_info_user_name);
        this.hVp.getPaint().setFakeBoldText(true);
        this.hVq = (TextView) this.hVn.findViewById(R.id.floor_owner);
        this.hVr = (ImageView) this.hVn.findViewById(R.id.icon_forum_level);
        this.hVt = (FrameLayout) this.hVn.findViewById(R.id.pb_head_headImage_container);
        this.hVu = (HeadImageView) this.hVn.findViewById(R.id.pb_head_owner_photo);
        this.hVs = (HeadPendantView) this.hVn.findViewById(R.id.pb_pendant_head_owner_photo);
        this.hVs.setHasPendantStyle();
        if (this.hVs.getHeadView() != null) {
            this.hVs.getHeadView().setIsRound(true);
            this.hVs.getHeadView().setDrawBorder(false);
        }
        this.hPm = (UserIconBox) this.hVn.findViewById(R.id.show_icon_vip);
        this.hPn = (UserIconBox) this.hVn.findViewById(R.id.show_icon_yinji);
        this.hVw = (LinearLayout) this.hVj.findViewById(R.id.pb_head_owner_info_root);
        this.hVz = (PbFirstFloorUserLikeButton) this.hVn.findViewById(R.id.pb_like_button);
        this.hVB = (TextView) this.hVn.findViewById(R.id.pb_views);
        this.hVC = (TextView) this.hVn.findViewById(R.id.pb_item_first_floor_reply_time);
        this.hVD = (TextView) this.hVn.findViewById(R.id.pb_item_first_floor_location_address);
        this.hVE = (TextView) this.hVn.findViewById(R.id.point_between_time_and_locate);
        this.hXs = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hXt = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hVK = this.hVb.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.hVL = this.hVb.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.hVb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hWz = (ViewStub) this.aqs.findViewById(R.id.interview_status_stub);
        this.hVF = this.hVj.findViewById(R.id.blank_view_align_user_item_top);
        this.hVG = this.hVj.findViewById(R.id.blank_view_align_user_item_bottom);
        this.hVO = new f(this.hNY, this.hUZ);
        this.hVO.C(this.fxy);
        this.hVO.setTbGestureDetector(this.czv);
        this.hVO.setOnImageClickListener(this.cUE);
        this.hOy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hNY.b(sparseArray);
                            return;
                        }
                        aq.this.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.hNY.b(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hVO.O(this.hOy);
        bVk();
        bVl();
        this.hUZ.addHeaderView(this.hVj);
        this.hUZ.addHeaderView(this.hVh);
        this.hUZ.addHeaderView(this.hVb);
        this.fBV = new PbListView(this.hNY.getPageContext().getPageActivity());
        this.cLA = this.fBV.getView().findViewById(R.id.pb_more_view);
        if (this.cLA != null) {
            this.cLA.setOnClickListener(this.fxy);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.cLA, R.drawable.pb_foot_more_trans_selector);
        }
        this.fBV.setLineVisible();
        this.fBV.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.fBV.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.hVU = this.hNY.findViewById(R.id.viewstub_progress);
        this.hNY.registerListener(this.hXz);
        this.hVv = com.baidu.tbadk.ala.b.afc().l(this.hNY.getActivity(), 2);
        if (this.hVv != null) {
            this.hVv.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            if (this.hVv.getParent() == null) {
                this.hVw.addView(this.hVv, aVar);
            }
        }
        this.hQn = new PbFakeFloorModel(this.hNY.getPageContext());
        this.hWV = new s(this.hNY.getPageContext(), this.hQn, this.aqs);
        this.hWV.a(this.hNY.hMY);
        this.hQn.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hQn.o(postData);
                aq.this.hVO.notifyDataSetChanged();
                aq.this.hWV.bTn();
                aq.this.Dl.asC();
                aq.this.oL(false);
            }
        });
        if (this.hNY.bRF() != null && !StringUtils.isNull(this.hNY.bRF().bUi())) {
            this.hNY.showToast(this.hNY.bRF().bUi());
        }
        this.hWE = this.hNY.findViewById(R.id.pb_expand_blank_view);
        this.hWF = this.hNY.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hWF.getLayoutParams();
        if (this.hNY.bRF() != null && this.hNY.bRF().bTD()) {
            this.hWE.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hWF.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hWH;
            this.hWF.setLayoutParams(layoutParams2);
        }
        this.hWG = new al(this.hNY.getPageContext(), this.hNY.findViewById(R.id.pb_reply_expand_view));
        this.hWG.hUt.setVisibility(8);
        this.hWG.Q(this.fxy);
        this.hNY.registerListener(this.mAccountChangedListener);
        this.hNY.registerListener(this.hXv);
        this.hNY.registerListener(this.hXw);
        bVg();
        oF(false);
    }

    public void bvz() {
        if (!this.hNY.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").O("obj_locate", 2).bS("fid", this.mForumId));
        } else if (this.hNY.bSe()) {
            com.baidu.tbadk.editortools.pb.d bRS = this.hNY.bRS();
            if (bRS != null && (bRS.auL() || bRS.auM())) {
                this.hNY.bRS().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Dl != null) {
                bVq();
            }
            if (this.Dl != null) {
                this.hWs = false;
                if (this.Dl.jL(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hNY, (View) this.Dl.jL(2).cFe, false, hXq);
                }
            }
            bVW();
        }
    }

    private void bVg() {
        this.hXk = new com.baidu.tieba.pb.pb.godreply.a(this.hNY, this, (ViewStub) this.aqs.findViewById(R.id.more_god_reply_popup));
        this.hXk.w(this.fxy);
        this.hXk.O(this.hOy);
        this.hXk.setOnImageClickListener(this.cUE);
        this.hXk.w(this.fxy);
        this.hXk.setTbGestureDetector(this.czv);
    }

    public com.baidu.tieba.pb.pb.godreply.a bVh() {
        return this.hXk;
    }

    public View bVi() {
        return this.hWE;
    }

    public void bVj() {
        if (this.hUZ != null) {
            this.hUZ.removeHeaderView(this.hVh);
            this.hUZ.removeHeaderView(this.hVj);
            this.hUZ.removeHeaderView(this.hVc);
            this.hUZ.removeHeaderView(this.hVb);
        }
    }

    private void bVk() {
        if (this.hVc == null) {
            this.hVc = (RelativeLayout) LayoutInflater.from(this.hNY).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.hVd = (HeadImageView) this.hVc.findViewById(R.id.iv_pb_video_smart_app_head);
            this.hVd.setIsRound(true);
            this.hVe = (TextView) this.hVc.findViewById(R.id.tv_pb_video_smart_app_title);
            this.hVf = (TextView) this.hVc.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.hVg = (ImageView) this.hVc.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.hVc.setOnClickListener(this.fxy);
        }
    }

    private void bVl() {
        if (this.hVh == null) {
            this.hVh = (RelativeLayout) LayoutInflater.from(this.hNY).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.hVl = (ImageView) this.hVh.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.hVl.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
            this.hVl.setImageMatrix(matrix);
            this.hVi = (TextView) this.hVh.findViewById(R.id.tv_pb_title);
            this.hVi.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.hVi.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hVi.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hVi, (int) R.color.cp_cont_b);
            this.hVi.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hVi.setVisibility(8);
            if (this.hVi.getParent() == null) {
                this.hVh.addView(this.hVi);
            }
            this.hVh.setOnTouchListener(this.czv);
            this.hVh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        if (this.hNY.bSw()) {
            this.hUY = (ViewStub) this.hNY.findViewById(R.id.manga_mention_controller_view_stub);
            this.hUY.setVisibility(0);
            if (this.hVH == null) {
                this.hVH = (LinearLayout) this.hNY.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.s.a.a(this.hNY.getPageContext(), this.hVH);
            }
            if (this.hVI == null) {
                this.hVI = (TextView) this.hVH.findViewById(R.id.manga_prev_btn);
            }
            if (this.hVJ == null) {
                this.hVJ = (TextView) this.hVH.findViewById(R.id.manga_next_btn);
            }
            this.hVI.setOnClickListener(this.fxy);
            this.hVJ.setOnClickListener(this.fxy);
        }
    }

    private void bVn() {
        if (this.hNY.bSw()) {
            if (this.hNY.bSz() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVI, R.color.cp_cont_e, 1);
            }
            if (this.hNY.bSA() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVJ, R.color.cp_cont_e, 1);
            }
        }
    }

    public void bVo() {
        if (this.hVH == null) {
            bVm();
        }
        this.hUY.setVisibility(8);
        if (this.hXx != null && this.hXy != null) {
            this.hXx.removeCallbacks(this.hXy);
        }
    }

    public void bVp() {
        if (this.hXx != null) {
            if (this.hXy != null) {
                this.hXx.removeCallbacks(this.hXy);
            }
            this.hXy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hVH == null) {
                        aq.this.bVm();
                    }
                    aq.this.hUY.setVisibility(0);
                }
            };
            this.hXx.postDelayed(this.hXy, 2000L);
        }
    }

    public void oD(boolean z) {
        this.hUV.oD(z);
        if (z && this.hWw) {
            this.fBV.setText(this.hNY.getResources().getString(R.string.click_load_more));
            this.hUZ.setNextPage(this.fBV);
            this.hUU = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
        this.Dl.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Dl.getParent() == null) {
            this.aqs.addView(this.Dl, layoutParams);
        }
        this.Dl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Dl.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).apm() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).apm() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
                        }
                        aq.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        aq.this.mPermissionJudgePolicy.appendRequestPermission(aq.this.hNY, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.startRequestPermission(aq.this.hNY)) {
                            aq.this.hNY.bRS().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hNY.bRS().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bUX();
        this.hNY.bRS().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.Dl != null && aq.this.Dl.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hXj == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.Dl.getId());
                            aq.this.hXj = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hNY.getPageContext(), aq.this.aqs, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(aq.this.hXi)) {
                                aq.this.hXj.setData(aq.this.hXi);
                            }
                            aq.this.hXj.b(aq.this.Dl);
                        }
                        aq.this.hXj.Ba(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hNY.hMb != null && aq.this.hNY.hMb.bWn() != null) {
                    if (!aq.this.hNY.hMb.bWn().cxB()) {
                        aq.this.hNY.hMb.oQ(false);
                    }
                    aq.this.hNY.hMb.bWn().rL(false);
                }
            }
        });
    }

    public void bVq() {
        if (this.hNY != null && this.Dl != null) {
            this.Dl.le();
            if (this.hNY.bRS() != null) {
                this.hNY.bRS().auC();
            }
            bVW();
        }
    }

    public void oE(boolean z) {
        if (this.hUZ != null && this.textView != null && this.apC != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.apC.setVisibility(0);
                } else {
                    this.apC.setVisibility(8);
                    this.hUZ.removeHeaderView(this.textView);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hWH;
                    this.textView.setLayoutParams(layoutParams);
                }
                bVE();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + oN(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            bVE();
            bWe();
        }
    }

    public f bVr() {
        return this.hVO;
    }

    public void a(PbActivity.d dVar) {
        this.hNd = dVar;
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hNY);
        kVar.setTitleText(this.hNY.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hVW.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hXA != null) {
                                aq.this.hXA.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hNY.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int i = -1;
        if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
        }
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i != 2) {
            int i2 = -1;
            if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            }
            if (i2 == 0) {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hNY.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hNY.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !bWd()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.hNY.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hNY.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hNY.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.at(arrayList);
        if (this.hVW == null) {
            this.hVW = new com.baidu.tbadk.core.dialog.i(this.hNY.getPageContext(), kVar);
        } else {
            this.hVW.a(kVar);
        }
        this.hVW.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hXA = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hNY != null && aVar != null) {
            if (this.fXn == null) {
                this.fXn = new com.baidu.tieba.NEGFeedBack.e(this.hNY.getPageContext(), this.hVb);
            }
            AntiData biZ = this.hNY.biZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (biZ != null && biZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.setFeedBackReasonMap(sparseArray);
            this.fXn.setDefaultReasonArray(new String[]{this.hNY.getString(R.string.delete_thread_reason_1), this.hNY.getString(R.string.delete_thread_reason_2), this.hNY.getString(R.string.delete_thread_reason_3), this.hNY.getString(R.string.delete_thread_reason_4), this.hNY.getString(R.string.delete_thread_reason_5)});
            this.fXn.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fXn.qE(str);
            this.fXn.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void K(JSONArray jSONArray) {
                    aq.this.hNY.a(aVar, jSONArray);
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
        sparseArray.put(hWO, Integer.valueOf(hWP));
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
        this.hVY = new com.baidu.tbadk.core.dialog.a(this.hNY.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hVY.hU(i3);
        } else {
            this.hVY.setOnlyMessageShowCenter(false);
            this.hVY.nn(str2);
        }
        this.hVY.setYesButtonTag(sparseArray);
        this.hVY.a(R.string.dialog_ok, this.hNY);
        this.hVY.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hVY.eg(true);
        this.hVY.b(this.hNY.getPageContext());
        if (z) {
            this.hVY.akO();
        } else {
            a(this.hVY, i);
        }
    }

    public void aB(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hWb == null) {
            this.hWb = LayoutInflater.from(this.hNY.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.hNY.getLayoutMode().onModeChanged(this.hWb);
        if (this.hWa == null) {
            this.hWa = new Dialog(this.hNY.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hWa.setCanceledOnTouchOutside(true);
            this.hWa.setCancelable(true);
            this.hWj = (ScrollView) this.hWb.findViewById(R.id.good_scroll);
            this.hWa.setContentView(this.hWb);
            WindowManager.LayoutParams attributes = this.hWa.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.hNY.getPageContext().getPageActivity(), R.dimen.ds540);
            this.hWa.getWindow().setAttributes(attributes);
            this.ePp = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hWf = (String) compoundButton.getTag();
                        if (aq.this.ePo != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.ePo) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hWf != null && !str.equals(aq.this.hWf)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hWc = (LinearLayout) this.hWb.findViewById(R.id.good_class_group);
            this.hWe = (TextView) this.hWb.findViewById(R.id.dialog_button_cancel);
            this.hWe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hWa instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hWa, aq.this.hNY.getPageContext());
                    }
                }
            });
            this.hWd = (TextView) this.hWb.findViewById(R.id.dialog_button_ok);
            this.hWd.setOnClickListener(this.fxy);
        }
        this.hWc.removeAllViews();
        this.ePo = new ArrayList();
        CustomBlueCheckRadioButton dB = dB("0", this.hNY.getPageContext().getString(R.string.thread_good_class));
        this.ePo.add(dB);
        dB.setChecked(true);
        this.hWc.addView(dB);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.ahi()) && acVar.ahj() > 0) {
                    CustomBlueCheckRadioButton dB2 = dB(String.valueOf(acVar.ahj()), acVar.ahi());
                    this.ePo.add(dB2);
                    View view = new View(this.hNY.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hNY.getPageContext().getPageActivity(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.hWc.addView(view);
                    this.hWc.addView(dB2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hWj.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hNY.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hNY.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hNY.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hWj.setLayoutParams(layoutParams2);
            this.hWj.removeAllViews();
            if (this.hWc != null && this.hWc.getParent() == null) {
                this.hWj.addView(this.hWc);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hWa, this.hNY.getPageContext());
    }

    private CustomBlueCheckRadioButton dB(String str, String str2) {
        Activity pageActivity = this.hNY.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.ePp);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bVs() {
        this.hNY.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hNY.hideProgressBar();
        if (z && z2) {
            this.hNY.showToast(this.hNY.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.hNY.showToast(str);
        }
    }

    public void bCv() {
        this.hVU.setVisibility(0);
    }

    public void bCu() {
        this.hVU.setVisibility(8);
    }

    public View bVt() {
        if (this.hWb != null) {
            return this.hWb.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String bVu() {
        return this.hWf;
    }

    public View getView() {
        return this.aqs;
    }

    public void bVv() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.hNY.getPageContext().getPageActivity(), this.hNY.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hNY.hideProgressBar();
        if (z) {
            bVN();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bVO();
        } else {
            bVN();
        }
    }

    public void bVw() {
        this.fBV.setLineVisible();
        this.fBV.startLoadData();
    }

    public void bVx() {
        this.hNY.hideProgressBar();
        endLoadData();
        this.hUZ.completePullRefreshPostDelayed(0L);
        bVI();
    }

    public void bVy() {
        this.hUZ.completePullRefreshPostDelayed(0L);
        bVI();
    }

    private void oF(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hVO.setOnLongClickListener(onLongClickListener);
        if (this.hXk != null) {
            this.hXk.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.hMc != null) {
            this.hMc.dismiss();
            this.hMc = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hNY);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hNY.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNY.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNY.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNY.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.at(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hWg.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hWg = new com.baidu.tbadk.core.dialog.i(this.hNY.getPageContext(), kVar);
        this.hWg.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.hWg != null) {
            this.hWg.dismiss();
            this.hWg = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hNY);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hNY.getPageContext().getString(R.string.save_to_emotion), kVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNY.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.at(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hWg.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hWg = new com.baidu.tbadk.core.dialog.i(this.hNY.getPageContext(), kVar);
        this.hWg.showDialog();
    }

    public int bVz() {
        return wP(this.hUZ.getFirstVisiblePosition());
    }

    private int wP(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hUZ.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hUZ.getAdapter() == null || !(this.hUZ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hUZ.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bVA() {
        int lastVisiblePosition = this.hUZ.getLastVisiblePosition();
        if (this.hUP != null) {
            if (lastVisiblePosition == this.hUZ.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return wP(lastVisiblePosition);
    }

    public void wQ(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.hUZ != null) {
            if (this.hUV == null || this.hUV.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hUV.mNavigationBar.getFixedNavHeight();
                if (!(this.hNY.bSk() != -1)) {
                    if (this.hWF != null && (layoutParams = (LinearLayout.LayoutParams) this.hWF.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hWF.setLayoutParams(layoutParams);
                    }
                    i--;
                    bWi();
                }
                i2 = fixedNavHeight;
            }
            this.hUZ.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hUZ.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hUZ.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hVR.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hVO.a(dVar, false);
        this.hVO.notifyDataSetChanged();
        bVI();
        if (this.hXk != null) {
            this.hXk.bRB();
        }
        ArrayList<PostData> bQB = dVar.bQB();
        if (dVar.getPage().ahA() == 0 || bQB == null || bQB.size() < dVar.getPage().ahz()) {
            if (com.baidu.tbadk.core.util.v.getCount(bQB) == 0 || (com.baidu.tbadk.core.util.v.getCount(bQB) == 1 && bQB.get(0) != null && bQB.get(0).cop() == 1)) {
                if (this.hWK == null || this.hWK.hXU == null || this.hWK.hXU.getView() == null) {
                    i = 0;
                } else {
                    i = this.hWK.hXU.getView().getTop() < 0 ? this.hWK.hXU.getView().getHeight() : this.hWK.hXU.getView().getBottom();
                }
                if (this.hNY.bSI()) {
                    this.fBV.R(this.hNY.getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.fBV.R(this.hNY.getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().ahA() == 0) {
                    this.fBV.setText(this.hNY.getResources().getString(R.string.list_has_no_more));
                } else {
                    this.fBV.setText(this.hNY.getResources().getString(R.string.load_more));
                }
                this.fBV.anM();
            }
        }
        o(dVar);
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        if (this.hVx == null) {
            this.hNY.getLayoutMode().onModeChanged(((ViewStub) this.hVb.findViewById(R.id.praise_layout)).inflate());
            this.hVx = (FrsPraiseView) this.hVb.findViewById(R.id.pb_head_praise_view);
            this.hVx.setIsFromPb(true);
            this.hVM = this.hVb.findViewById(R.id.new_pb_header_item_line_above_praise);
            this.hVx.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hVx != null) {
            boolean bVI = bVI();
            this.hVx.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().ahB() == 0 && this.hOq) {
                if (bVI) {
                    this.hVL.setVisibility(0);
                    return;
                } else {
                    this.hVL.setVisibility(8);
                    return;
                }
            }
            this.hVL.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bQJ() != null) {
            return dVar.bQJ();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(dVar.bQB())) {
            Iterator<PostData> it = dVar.bQB().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cop() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bQG();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aiG() != null && postData.aiG().getUserTbVipInfoData() != null && postData.aiG().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aiG().getGodUserData().setIntro(postData.aiG().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bQz() == null || dVar.bQz().aiG() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aiG = dVar.bQz().aiG();
        String userId = aiG.getUserId();
        HashMap<String, MetaData> userMap = dVar.bQz().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aiG;
        }
        postData.zR(1);
        postData.setId(dVar.bQz().aiW());
        postData.setTitle(dVar.bQz().getTitle());
        postData.setTime(dVar.bQz().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0643 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x084e  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0857  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x08b1  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.f cos;
        String portrait;
        String charSequence;
        if (dVar != null && dVar.bQz() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hVn.setVisibility(8);
            if (dVar.bQz() != null && dVar.bQz().ajA() && dVar.bQz().aiX() != null) {
                this.hWZ = true;
                this.hUV.pa(this.hWZ);
                this.hUV.mNavigationBar.hideBottomLine();
                if (this.hUP == null) {
                    this.hUP = new com.baidu.tieba.pb.video.i(this.hNY, this.hUV, dVar.bQz().aiX(), this.hUQ);
                    this.hUP.a(dVar.bQz().aiX(), dVar.bQz(), dVar.getForumId());
                    this.hUP.startPlay();
                } else if (this.hUT) {
                    this.hUP.a(dVar.bQz().aiX(), dVar.bQz(), dVar.getForumId());
                    this.hUP.startPlay();
                } else {
                    this.hUP.Bm(dVar.getForumId());
                }
                com.baidu.tieba.pb.c.a.a(this.hNY.getUniqueId(), dVar, c, 1, 1);
                if (dVar.bQA() != null && dVar.bQA().size() >= 1) {
                    bh bhVar = dVar.bQA().get(0);
                    this.hUP.aB(bhVar);
                    this.hUP.Bn(bhVar.getTitle());
                }
                this.hUP.b(c, dVar.bQz(), dVar.bQW());
                this.hUT = false;
                this.hUZ.removeHeaderView(this.hUP.bYe());
                this.hUZ.addHeaderView(this.hUP.bYe(), 0);
                if (this.hUP.aJy() != null && this.hUP.aJy().getParent() == null) {
                    this.hWD.addView(this.hUP.aJy());
                }
                if (this.hUR == null) {
                    this.hUR = new com.baidu.tieba.pb.video.h(this.hNY);
                }
                this.hUR.a(dVar.bQz().ajP(), dVar.bQz(), dVar.bQT());
                this.hUZ.removeHeaderView(this.hUR.bXS());
                this.hUZ.addHeaderView(this.hUR.bXS(), 1);
                if (dVar.bQz().ajP() != null) {
                    this.hUZ.removeHeaderView(this.hUR.bXT());
                    this.hUZ.removeHeaderView(this.hVj);
                    this.hUZ.addHeaderView(this.hUR.bXT(), 2);
                } else {
                    if (this.hUR.bXT() != null) {
                        this.hUZ.removeHeaderView(this.hUR.bXT());
                    }
                    this.hUZ.removeHeaderView(this.hVj);
                    this.hUZ.addHeaderView(this.hVj, 2);
                }
                if (this.hUP != null) {
                    this.hUV.oW(false);
                    this.hUP.wX(TbadkCoreApplication.getInst().getSkinType());
                }
                bVE();
            } else {
                this.hWZ = false;
                this.hUV.pa(this.hWZ);
                if (this.hUP != null) {
                    this.hUZ.removeHeaderView(this.hUP.bYe());
                }
                if (this.hUR != null) {
                    this.hUR.b(this.hUZ);
                }
            }
            if (this.hNY.bRV() != null) {
                this.hNY.bRV().oU(this.hWZ);
            }
            if (this.hUP != null) {
                this.hUP.S(this.hXC);
                bWi();
            }
            if (c != null) {
                this.hWv = c;
                this.hVn.setVisibility(0);
                if (this.hNY.bRv()) {
                    if (dVar.bQy() != null) {
                        this.mForumName = dVar.bQy().getForumName();
                        this.mForumId = dVar.bQy().getForumId();
                    }
                    if (this.mForumName == null && this.hNY.bRF() != null && this.hNY.bRF().bRw() != null) {
                        this.mForumName = this.hNY.bRF().bRw();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hVn.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hVn.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_clip_board, c);
                sparseArray.put(R.id.tag_is_subpb, false);
                if (dVar.bQz().ajA() && dVar.bQz().ajs() != null) {
                    SmartApp ajs = dVar.bQz().ajs();
                    this.hVc.setVisibility(0);
                    this.hUZ.removeHeaderView(this.hVc);
                    this.hUZ.addHeaderView(this.hVc, 1);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(ajs.avatar)) {
                        this.hVd.startLoad(ajs.avatar, 10, false, false);
                    }
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(ajs.name)) {
                        charSequence = ajs.name + HanziToPinyin.Token.SEPARATOR + ((Object) this.hNY.getText(R.string.smart_app_suffix));
                    } else {
                        charSequence = this.hNY.getText(R.string.intelligent_smart_app).toString();
                    }
                    this.hVe.setText(charSequence);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(ajs._abstract)) {
                        this.hVf.setText(ajs._abstract);
                    } else {
                        this.hVf.setText(this.hNY.getText(R.string.smart_app_default_abstract));
                    }
                    this.hVc.setTag(ajs);
                } else {
                    this.hVc.setVisibility(8);
                    this.hUZ.removeHeaderView(this.hVc);
                }
                if (!this.hXr) {
                    this.hVh.setVisibility(0);
                }
                if (!dVar.bQz().ajA() && this.hVi.getText() != null && this.hVi.getText().length() > 0) {
                    this.hVi.setVisibility(0);
                } else {
                    this.hVi.setVisibility(8);
                }
                n(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> aiR = dVar.bQz().aiR();
                if (aiR != null && aiR.size() > 0 && !this.hXr) {
                    this.hWy.setText(String.valueOf(aiR.get(0).agP()));
                    this.hWx.setVisibility(0);
                } else {
                    this.hWx.setVisibility(8);
                }
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hWx, R.drawable.activity_join_num_bg);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hWy, R.color.cp_link_tip_d, 1);
                if (c.aiG() != null) {
                    String string = c.aiG().getName_show() == null ? StringUtils.string(c.aiG().getUserName()) : StringUtils.string(c.aiG().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(c.aiG().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.byteLength(c.aiG().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.byteLength(string) > 12) {
                            cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                            ArrayList<IconData> iconInfo = c.aiG().getIconInfo();
                            tShowInfoNew = c.aiG().getTShowInfoNew();
                            if (this.hPn != null) {
                                this.hPn.setTag(R.id.tag_user_id, c.aiG().getUserId());
                                this.hPn.setOnClickListener(this.hNY.hLX.hZt);
                                this.hPn.a(iconInfo, 4, this.hNY.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNY.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNY.getResources().getDimensionPixelSize(R.dimen.tbds12));
                            }
                            if (this.hPm != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hPm.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hPm.setOnClickListener(this.hNY.hLX.hZu);
                                this.hPm.a(tShowInfoNew, 3, this.hNY.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNY.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNY.getResources().getDimensionPixelSize(R.dimen.ds12), true);
                            }
                            this.hVp.setText(bV(c.aiG().getSealPrefix(), cutChineseAndEnglishWithSuffix));
                            this.hVp.setTag(R.id.tag_user_id, c.aiG().getUserId());
                            this.hVp.setTag(R.id.tag_user_name, c.aiG().getName_show());
                            if (com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || c.aiG().isBigV()) {
                                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVp, R.color.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVp, R.color.cp_cont_b, 1);
                            }
                            if (c.aiG() == null) {
                                MetaData aiG = c.aiG();
                                if (aiG.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aiG.getBawu_type())) {
                                    this.hVq.setText(R.string.bawu_member_bazhu_tip);
                                    this.hVq.setVisibility(0);
                                    this.hXp = R.drawable.author_bazhu_bg;
                                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.hVq, this.hXp);
                                } else if (aiG.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aiG.getBawu_type())) {
                                    this.hVq.setText(R.string.bawu_member_xbazhu_tip);
                                    this.hVq.setVisibility(0);
                                    this.hXp = R.drawable.author_small_bazhu;
                                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.hVq, this.hXp);
                                } else {
                                    this.hVq.setVisibility(8);
                                }
                            } else {
                                this.hVq.setVisibility(8);
                            }
                            if (dVar.bQz().aiG() != null && dVar.bQz().aiG().getAlaUserData() != null && this.hVv != null) {
                                if (dVar.bQz().aiG().getAlaUserData().anchor_live != 0) {
                                    this.hVv.setVisibility(8);
                                } else {
                                    this.hVv.setVisibility(0);
                                    if (this.hUS == null) {
                                        this.hUS = new com.baidu.tieba.c.d(this.hNY.getPageContext(), this.hVv);
                                        this.hUS.pg(1);
                                    }
                                    this.hUS.R(this.hNY.getResources().getString(R.string.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_VIDEO_PB_ALA_TAIL_LIGHT_TIPS));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bTT = dVar.bQz().aiG().getAlaUserData();
                                    aVar.type = 2;
                                    this.hVv.setTag(aVar);
                                }
                            }
                            this.hVu.setUserId(c.aiG().getUserId());
                            this.hVu.setUserName(c.aiG().getUserName());
                            this.hVu.setTid(c.getId());
                            this.hVu.setFid(this.hRx == null ? this.hRx.getForumId() : "");
                            this.hVu.setImageDrawable(null);
                            this.hVu.setRadius(com.baidu.adp.lib.util.l.getDimens(this.hNY.getActivity(), R.dimen.ds40));
                            this.hVu.setTag(c.aiG().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hVC.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(c.getTime()));
                            } else {
                                this.hVC.setText(com.baidu.tbadk.core.util.aq.getFormatTime(c.getTime()));
                            }
                            cos = c.cos();
                            if (cos == null && !TextUtils.isEmpty(cos.getName()) && !TextUtils.isEmpty(cos.getName().trim())) {
                                this.hVD.setVisibility(0);
                                this.hVE.setVisibility(0);
                                this.hVD.setText(cos.getName());
                            } else {
                                this.hVD.setVisibility(8);
                                this.hVE.setVisibility(8);
                            }
                            portrait = c.aiG().getPortrait();
                            if (c.aiG().getPendantData() == null && !StringUtils.isNull(c.aiG().getPendantData().ahf())) {
                                this.hVs.b(c.aiG());
                                this.hVu.setVisibility(8);
                                this.hVs.setVisibility(0);
                                if (this.hVy != null) {
                                    this.hVy.setVisibility(8);
                                }
                                this.hVp.setOnClickListener(this.hXC);
                                this.hVs.getHeadView().startLoad(portrait, 28, false);
                                this.hVs.getHeadView().setUserId(c.aiG().getUserId());
                                this.hVs.getHeadView().setUserName(c.aiG().getUserName());
                                this.hVs.getHeadView().setTid(c.getId());
                                this.hVs.getHeadView().setFid(this.hRx != null ? this.hRx.getForumId() : "");
                                this.hVs.getHeadView().setOnClickListener(this.hXC);
                                this.hVs.ou(c.aiG().getPendantData().ahf());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hVu, c.aiG());
                                this.hVu.setVisibility(0);
                                this.hVn.setOnClickListener(this.hXC);
                                this.hVp.setOnClickListener(this.hXC);
                                this.hVu.setOnClickListener(this.hXC);
                                this.hVs.setVisibility(8);
                                this.hVu.startLoad(portrait, 28, false);
                            }
                            String name_show = c.aiG().getName_show();
                            String userName = c.aiG().getUserName();
                            if (com.baidu.tbadk.t.as.isOn() && name_show != null && !name_show.equals(userName)) {
                                this.hVp.setText(com.baidu.tieba.pb.c.aI(this.hNY.getPageContext().getPageActivity(), this.hVp.getText().toString()));
                                this.hVp.setGravity(16);
                                this.hVp.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bQg());
                                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVp, R.color.cp_other_e, 1);
                            }
                        }
                        cutChineseAndEnglishWithSuffix = string;
                        ArrayList<IconData> iconInfo2 = c.aiG().getIconInfo();
                        tShowInfoNew = c.aiG().getTShowInfoNew();
                        if (this.hPn != null) {
                        }
                        if (this.hPm != null) {
                        }
                        this.hVp.setText(bV(c.aiG().getSealPrefix(), cutChineseAndEnglishWithSuffix));
                        this.hVp.setTag(R.id.tag_user_id, c.aiG().getUserId());
                        this.hVp.setTag(R.id.tag_user_name, c.aiG().getName_show());
                        if (com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.hVp, R.color.cp_cont_h, 1);
                        if (c.aiG() == null) {
                        }
                        if (dVar.bQz().aiG() != null) {
                            if (dVar.bQz().aiG().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hVu.setUserId(c.aiG().getUserId());
                        this.hVu.setUserName(c.aiG().getUserName());
                        this.hVu.setTid(c.getId());
                        this.hVu.setFid(this.hRx == null ? this.hRx.getForumId() : "");
                        this.hVu.setImageDrawable(null);
                        this.hVu.setRadius(com.baidu.adp.lib.util.l.getDimens(this.hNY.getActivity(), R.dimen.ds40));
                        this.hVu.setTag(c.aiG().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cos = c.cos();
                        if (cos == null) {
                        }
                        this.hVD.setVisibility(8);
                        this.hVE.setVisibility(8);
                        portrait = c.aiG().getPortrait();
                        if (c.aiG().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hVu, c.aiG());
                        this.hVu.setVisibility(0);
                        this.hVn.setOnClickListener(this.hXC);
                        this.hVp.setOnClickListener(this.hXC);
                        this.hVu.setOnClickListener(this.hXC);
                        this.hVs.setVisibility(8);
                        this.hVu.startLoad(portrait, 28, false);
                        String name_show2 = c.aiG().getName_show();
                        String userName2 = c.aiG().getUserName();
                        if (com.baidu.tbadk.t.as.isOn()) {
                            this.hVp.setText(com.baidu.tieba.pb.c.aI(this.hNY.getPageContext().getPageActivity(), this.hVp.getText().toString()));
                            this.hVp.setGravity(16);
                            this.hVp.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bQg());
                            com.baidu.tbadk.core.util.am.setViewTextColor(this.hVp, R.color.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.byteLength(string) > 14) {
                            cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                            ArrayList<IconData> iconInfo22 = c.aiG().getIconInfo();
                            tShowInfoNew = c.aiG().getTShowInfoNew();
                            if (this.hPn != null) {
                            }
                            if (this.hPm != null) {
                            }
                            this.hVp.setText(bV(c.aiG().getSealPrefix(), cutChineseAndEnglishWithSuffix));
                            this.hVp.setTag(R.id.tag_user_id, c.aiG().getUserId());
                            this.hVp.setTag(R.id.tag_user_name, c.aiG().getName_show());
                            if (com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.am.setViewTextColor(this.hVp, R.color.cp_cont_h, 1);
                            if (c.aiG() == null) {
                            }
                            if (dVar.bQz().aiG() != null) {
                            }
                            this.hVu.setUserId(c.aiG().getUserId());
                            this.hVu.setUserName(c.aiG().getUserName());
                            this.hVu.setTid(c.getId());
                            this.hVu.setFid(this.hRx == null ? this.hRx.getForumId() : "");
                            this.hVu.setImageDrawable(null);
                            this.hVu.setRadius(com.baidu.adp.lib.util.l.getDimens(this.hNY.getActivity(), R.dimen.ds40));
                            this.hVu.setTag(c.aiG().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            cos = c.cos();
                            if (cos == null) {
                            }
                            this.hVD.setVisibility(8);
                            this.hVE.setVisibility(8);
                            portrait = c.aiG().getPortrait();
                            if (c.aiG().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hVu, c.aiG());
                            this.hVu.setVisibility(0);
                            this.hVn.setOnClickListener(this.hXC);
                            this.hVp.setOnClickListener(this.hXC);
                            this.hVu.setOnClickListener(this.hXC);
                            this.hVs.setVisibility(8);
                            this.hVu.startLoad(portrait, 28, false);
                            String name_show22 = c.aiG().getName_show();
                            String userName22 = c.aiG().getUserName();
                            if (com.baidu.tbadk.t.as.isOn()) {
                            }
                        }
                        cutChineseAndEnglishWithSuffix = string;
                        ArrayList<IconData> iconInfo222 = c.aiG().getIconInfo();
                        tShowInfoNew = c.aiG().getTShowInfoNew();
                        if (this.hPn != null) {
                        }
                        if (this.hPm != null) {
                        }
                        this.hVp.setText(bV(c.aiG().getSealPrefix(), cutChineseAndEnglishWithSuffix));
                        this.hVp.setTag(R.id.tag_user_id, c.aiG().getUserId());
                        this.hVp.setTag(R.id.tag_user_name, c.aiG().getName_show());
                        if (com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.hVp, R.color.cp_cont_h, 1);
                        if (c.aiG() == null) {
                        }
                        if (dVar.bQz().aiG() != null) {
                        }
                        this.hVu.setUserId(c.aiG().getUserId());
                        this.hVu.setUserName(c.aiG().getUserName());
                        this.hVu.setTid(c.getId());
                        this.hVu.setFid(this.hRx == null ? this.hRx.getForumId() : "");
                        this.hVu.setImageDrawable(null);
                        this.hVu.setRadius(com.baidu.adp.lib.util.l.getDimens(this.hNY.getActivity(), R.dimen.ds40));
                        this.hVu.setTag(c.aiG().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cos = c.cos();
                        if (cos == null) {
                        }
                        this.hVD.setVisibility(8);
                        this.hVE.setVisibility(8);
                        portrait = c.aiG().getPortrait();
                        if (c.aiG().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hVu, c.aiG());
                        this.hVu.setVisibility(0);
                        this.hVn.setOnClickListener(this.hXC);
                        this.hVp.setOnClickListener(this.hXC);
                        this.hVu.setOnClickListener(this.hXC);
                        this.hVs.setVisibility(8);
                        this.hVu.startLoad(portrait, 28, false);
                        String name_show222 = c.aiG().getName_show();
                        String userName222 = c.aiG().getUserName();
                        if (com.baidu.tbadk.t.as.isOn()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hVm.at(dVar.bQz());
                }
                if (this.hWG != null) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hJH);
                    if (dVar != null && dVar.bQz() != null) {
                        iVar.hJJ = dVar.bQz().aix();
                    }
                    iVar.isNew = !this.hOq;
                    iVar.sortType = dVar.hJn;
                    if (dVar.hJm != null && dVar.hJm.size() > dVar.hJn) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hJm.size()) {
                                break;
                            } else if (dVar.hJm.get(i4).sort_type.intValue() != dVar.hJn) {
                                i3 = i4 + 1;
                            } else {
                                iVar.hJL = dVar.hJm.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    iVar.hJM = this.hNY.bSI();
                    this.hWG.a(iVar);
                }
                if (dVar != null && dVar.bQz() != null) {
                    ae(dVar.bQz().aiC() == 1, dVar.bQz().aiB() == 1);
                }
                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hVO != null && aq.this.hUV != null && aq.this.hUV.iat != null && aq.this.hRx != null && aq.this.hRx.bQz() != null && !aq.this.hRx.bQz().ajA() && !aq.this.bVH() && aq.this.hRx.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(aq.this.hRx.getForum().getName())) {
                            if (aq.this.hVO.bTi() == null || !aq.this.hVO.bTi().isShown()) {
                                aq.this.hUV.iat.setVisibility(0);
                                if (aq.this.hNY != null && aq.this.hNY.bRF() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.bS("tid", aq.this.hNY.bRF().bTA());
                                    anVar.bS("fid", aq.this.hNY.bRF().getForumId());
                                    anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void oG(boolean z) {
        if (z) {
            bVB();
        } else {
            beI();
        }
        this.hWK.hXU = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.hWK));
        a(this.hWK.hXU, false);
    }

    public void bVB() {
        if (this.hUV != null && !this.hXb) {
            this.hUV.pb(!StringUtils.isNull(this.hNY.bSh()));
            this.hXb = true;
        }
    }

    public void beI() {
        if (this.hUV != null) {
            this.hUV.bWP();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.ajb() != null) {
            this.hVo.setData(this.hNY.getPageContext(), dVar.bQB().get(0).ajb(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bQz().getId(), this.hNY.bSF() ? "FRS" : null));
            this.hVn.setPadding(this.hVn.getPaddingLeft(), (int) this.hNY.getResources().getDimension(R.dimen.ds20), this.hVn.getPaddingRight(), this.hVn.getPaddingBottom());
            return;
        }
        this.hVo.setData(null, null, null);
    }

    public void bVC() {
        if (this.hUP != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11997").O("obj_type", 1));
            this.hUP.bYc();
            this.hUZ.smoothScrollToPosition(0);
        }
    }

    public boolean bVD() {
        return this.dOk;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean av(bh bhVar) {
        if (bhVar == null || bhVar.aiG() == null || bhVar.aiG().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.aiG().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.hUV.bWN();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hUV.yK(cVar.forumName);
            }
            String string = this.hNY.getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.toInt(cVar.source, 0)) {
                case 100:
                    str = this.hNY.getResources().getString(R.string.self);
                    break;
                case 300:
                    str = this.hNY.getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = this.hNY.getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hIG;
            this.hNY.showNetRefreshView(this.aqs, format, null, this.hNY.getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.amQ().b(aq.this.hNY.getPageContext(), new String[]{str2});
                        aq.this.hNY.finish();
                        return;
                    }
                    aq.this.hNY.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bUL;
        Parcelable bUL2;
        if (dVar != null) {
            this.hRx = dVar;
            this.mType = i;
            if (dVar.bQz() != null) {
                this.hWM = dVar.bQz().aio();
                if (dVar.bQz().getAnchorLevel() != 0) {
                    this.dOk = true;
                }
                this.hWi = av(dVar.bQz());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.hWw = false;
            this.hOq = z;
            bVx();
            if (dVar.hJo != null && dVar.hJo.bRa()) {
                if (this.hVa == null) {
                    this.hVa = new PbThreadPostView(this.hNY);
                    this.hUZ.addHeaderView(this.hVa, 1);
                    this.hVa.setData(dVar);
                    this.hVa.setChildOnClickLinstener(this.fxy);
                }
            } else if (this.hVa != null && this.hUZ != null) {
                this.hUZ.removeHeaderView(this.hVa);
            }
            b(dVar, z, i);
            p(dVar);
            if (this.hXn == null) {
                this.hXn = new ac(this.hNY.getPageContext(), this.fUt);
            }
            this.hXn.AR(dVar.bQE());
            if (this.hNY.bSw()) {
                if (this.hVS == null) {
                    this.hVS = new com.baidu.tieba.pb.view.c(this.hNY.getPageContext());
                    this.hVS.createView();
                    this.hVS.setListPullRefreshListener(this.cpS);
                }
                this.hUZ.setPullRefresh(this.hVS);
                bVE();
                if (this.hVS != null) {
                    this.hVS.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().ahB() == 0 && z) {
                this.hUZ.setPullRefresh(null);
            } else {
                if (this.hVS == null) {
                    this.hVS = new com.baidu.tieba.pb.view.c(this.hNY.getPageContext());
                    this.hVS.createView();
                    this.hVS.setListPullRefreshListener(this.cpS);
                }
                this.hUZ.setPullRefresh(this.hVS);
                bVE();
                if (this.hVS != null) {
                    this.hVS.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                aVW();
            }
            bVI();
            this.hVO.nU(this.hOq);
            this.hVO.nV(false);
            this.hVO.og(i == 5);
            this.hVO.oh(i == 6);
            this.hVO.oi(z2 && this.hXB);
            this.hVO.a(dVar, false);
            this.hVO.notifyDataSetChanged();
            if (this.hNY.bRv()) {
                this.hXd = 0;
                PostData c = c(dVar, z);
                if (c != null && c.aiG() != null) {
                    this.hXd = c.aiG().getLevel_id();
                }
                if (this.hXd > 0) {
                    this.hVr.setVisibility(0);
                    com.baidu.tbadk.core.util.am.setImageResource(this.hVr, BitmapHelper.getGradeResourceIdInEnterForum(this.hXd));
                } else {
                    this.hVr.setVisibility(8);
                }
            } else {
                this.hVr.setVisibility(8);
            }
            if (dVar.bQz() != null && dVar.bQz().ais() != null) {
                if (dVar.bQz().ais().getNum() < 1) {
                    this.hNY.getResources().getString(R.string.zan);
                } else {
                    String str = dVar.bQz().ais().getNum() + "";
                }
                if (this.hUO != -1) {
                    dVar.bQz().ais().setIsLike(this.hUO);
                }
            }
            if (this.hNY.isLogin()) {
                this.hUZ.setNextPage(this.fBV);
                this.hUU = 2;
                aVW();
            } else {
                this.hWw = true;
                if (dVar.getPage().ahA() == 1) {
                    if (this.hVT == null) {
                        this.hVT = new com.baidu.tieba.pb.view.a(this.hNY.getPageContext());
                    }
                    this.hUZ.setNextPage(this.hVT);
                } else {
                    this.hUZ.setNextPage(this.fBV);
                }
                this.hUU = 3;
            }
            ArrayList<PostData> bQB = dVar.bQB();
            if (dVar.getPage().ahA() == 0 || bQB == null || bQB.size() < dVar.getPage().ahz()) {
                if (com.baidu.tbadk.core.util.v.getCount(bQB) == 0 || (com.baidu.tbadk.core.util.v.getCount(bQB) == 1 && bQB.get(0) != null && bQB.get(0).cop() == 1)) {
                    if (this.hWK == null || this.hWK.hXU == null || this.hWK.hXU.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hWK.hXU.getView().getTop() < 0 ? this.hWK.hXU.getView().getHeight() : this.hWK.hXU.getView().getBottom();
                    }
                    if (this.hNY.bSI()) {
                        this.fBV.R(this.hNY.getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.fBV.R(this.hNY.getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.hNY.bRV() != null && !this.hNY.bRV().bWB()) {
                        this.hNY.bRV().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().ahA() == 0) {
                        this.fBV.setText(this.hNY.getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.fBV.setText(this.hNY.getResources().getString(R.string.load_more));
                    }
                    this.fBV.anM();
                }
                bVR();
            } else {
                if (z2) {
                    if (this.hXB) {
                        endLoadData();
                        if (dVar.getPage().ahA() != 0) {
                            this.fBV.setText(this.hNY.getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.fBV.setLineVisible();
                        this.fBV.showLoading();
                    }
                } else {
                    this.fBV.setLineVisible();
                    this.fBV.showLoading();
                }
                this.fBV.anM();
            }
            switch (i) {
                case 2:
                    this.hUZ.setSelection(i2 > 1 ? (((this.hUZ.getData() == null && dVar.bQB() == null) ? 0 : (this.hUZ.getData().size() - dVar.bQB().size()) + this.hUZ.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bUL2 = aj.bUK().bUL()) != null) {
                        this.hUZ.onRestoreInstanceState(bUL2);
                        if (com.baidu.tbadk.core.util.v.getCount(bQB) > 1 && dVar.getPage().ahA() > 0) {
                            this.fBV.endLoadData();
                            this.fBV.setText(this.hNY.getString(R.string.pb_load_more_without_point));
                            this.fBV.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hXB = false;
                    break;
                case 5:
                    this.hUZ.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bUL = aj.bUK().bUL()) != null) {
                        this.hUZ.onRestoreInstanceState(bUL);
                        break;
                    } else {
                        this.hUZ.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.hUP != null && this.hUP.aJy() != null) {
                            if (this.hNY.isUseStyleImmersiveSticky()) {
                                this.hUZ.setSelectionFromTop((this.hVO.bTd() + this.hUZ.getHeaderViewsCount()) - 1, this.hUP.aJy().getHeight() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.hNY.getPageContext().getPageActivity()));
                            } else {
                                this.hUZ.setSelectionFromTop((this.hVO.bTd() + this.hUZ.getHeaderViewsCount()) - 1, this.hUP.aJy().getHeight());
                            }
                        } else {
                            this.hUZ.setSelection(this.hVO.bTd() + this.hUZ.getHeaderViewsCount());
                        }
                    } else {
                        this.hUZ.setSelection(i2 > 0 ? ((this.hUZ.getData() == null && dVar.bQB() == null) ? 0 : (this.hUZ.getData().size() - dVar.bQB().size()) + this.hUZ.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.fBV.endLoadData();
                    this.fBV.setText(this.hNY.getString(R.string.pb_load_more_without_point));
                    this.fBV.setLineGone();
                    break;
            }
            if (this.hWM == hWN && isHost()) {
                bVZ();
            }
            if (this.hWX) {
                bUV();
                this.hWX = false;
                if (i3 == 0) {
                    oA(true);
                }
            }
            if (this.hUR != null) {
                this.hUR.aA(dVar.bQz());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hJk == 1 || dVar.hJl == 1) {
                if (this.hXe == null) {
                    this.hXe = new PbTopTipView(this.hNY);
                }
                if (dVar.hJl == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hNY.getStType())) {
                    this.hXe.setText(this.hNY.getString(R.string.pb_read_strategy_add_experience));
                    this.hXe.a(this.aqs, this.mSkinType);
                } else if (dVar.hJk == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hNY.getStType())) {
                    this.hXe.setText(this.hNY.getString(R.string.pb_read_news_add_experience));
                    this.hXe.a(this.aqs, this.mSkinType);
                }
            }
            o(dVar);
        }
    }

    private void o(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQz() != null) {
            if (dVar.afm()) {
                SvgManager.amN().a(this.hWp, R.drawable.icon_mask_pb_bottom_collect_h_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.amN().a(this.hWp, R.drawable.icon_pure_pb_bottom_collect_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.hWr.setText(wR(dVar.bQz().aix()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, dVar.bQz()));
        }
    }

    private String wR(int i) {
        if (i == 0) {
            return this.hNY.getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + "W";
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + "W";
        } else {
            return "" + i;
        }
    }

    private void bVE() {
        if (this.hUP != null && this.hUP.aJy() != null) {
            this.hUZ.removeHeaderView(this.textView);
            if (this.mType != 1) {
                this.hUZ.removeHeaderView(this.hUP.bYe());
                this.hUZ.addHeaderView(this.hUP.bYe(), 0);
                return;
            }
            return;
        }
        if (this.hUP != null) {
            this.hUZ.removeHeaderView(this.hUP.bYe());
        }
        this.hUZ.removeHeaderView(this.textView);
        this.hUZ.addHeaderView(this.textView, 0);
    }

    public void oH(boolean z) {
        this.hWh = z;
    }

    public void endLoadData() {
        if (this.fBV != null) {
            this.fBV.setLineGone();
            this.fBV.endLoadData();
        }
        aVW();
    }

    public void aMq() {
        this.hUZ.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hWv != null && this.hWv.aiG() != null && this.hUV != null) {
            this.hXa = !this.hWZ;
            this.hUV.oW(this.hXa);
            if (this.hNY.bRV() != null) {
                this.hNY.bRV().oV(this.hXa);
            }
            bVF();
            if (this.hNY != null && !this.hNY.bRv() && !com.baidu.tbadk.core.util.v.isEmpty(dVar.bQU())) {
                bd bdVar = dVar.bQU().get(0);
                if (bdVar != null) {
                    this.hUV.dC(bdVar.getForumName(), bdVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hUV.dC(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hXa) {
                if (this.hWi) {
                    this.hVz.setVisibility(8);
                    this.hVB.setVisibility(0);
                    this.hVB.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.numberUniformFormatExtra(dVar.bQV())));
                }
                if (this.hWF != null) {
                    this.hWF.setVisibility(8);
                }
                if (this.hXl == null) {
                    this.hXl = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hXc) {
                                aq.this.bVY();
                            }
                            aq.this.bVy();
                        }
                    };
                }
                this.hUZ.setListViewDragListener(this.hXl);
            } else {
                if (this.hWF != null) {
                    this.hWF.setVisibility(0);
                }
                if (this.hWi) {
                    this.hVz.setVisibility(8);
                    this.hVB.setVisibility(0);
                    this.hVB.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.numberUniformFormatExtra(dVar.bQV())));
                } else if (!com.baidu.tbadk.t.au.axk() || (this.hWv.aiG().hadConcerned() && this.hWv.aiG().getGodUserData() != null && this.hWv.aiG().getGodUserData().getIsFromNetWork())) {
                    this.hVz.setVisibility(8);
                    this.hVB.setVisibility(8);
                } else {
                    this.hVB.setVisibility(8);
                }
                this.hXl = null;
                this.hUZ.setListViewDragListener(null);
            }
            if (dVar.hJt) {
                this.hVz.setVisibility(8);
            }
        }
    }

    private void bVF() {
        String threadId = this.hRx != null ? this.hRx.getThreadId() : "";
        int bVG = bVG();
        if (this.hXa && this.hWv != null && this.hWv.aiG() != null) {
            this.hWv.aiG().setIsLike(this.hWv.aiG().hadConcerned());
        }
        if (this.hVA == null) {
            this.hVA = new ao(this.hNY.getPageContext(), this.hVz, 1);
            this.hVA.j(this.hNY.getUniqueId());
            this.hVA.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void ex(boolean z) {
                    if (aq.this.hNY != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hNY, (int) R.string.attention_success);
                    }
                }
            });
        }
        if (this.hWv != null && this.hWv.aiG() != null) {
            this.hWv.aiG().setIsLike(this.hWv.aiG().hadConcerned());
            this.hVA.a(this.hWv.aiG());
            this.hVA.setTid(threadId);
        }
        this.hVA.hUK = this.hWZ;
        this.hVA.wO(bVG);
    }

    public int bVG() {
        if (this.hRx == null || this.hRx.bQz() == null) {
            return 0;
        }
        if (this.hRx.bQz().ajX()) {
            return (com.baidu.tbadk.core.util.v.isEmpty(this.hRx.bQU()) && (this.hRx.bQy() == null || StringUtils.isNull(this.hRx.bQy().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bVH() {
        return this.hRx == null || this.hRx.getForum() == null || "0".equals(this.hRx.getForum().getId()) || "me0407".equals(this.hRx.getForum().getName());
    }

    private boolean bVI() {
        boolean z;
        if (this.hWl != null && this.hWl.getVisibility() == 0) {
            if (this.hVK != null) {
                this.hVK.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hVK != null) {
                this.hVK.setVisibility(8);
            }
            z = false;
        }
        if ((this.hVM == null || this.hVM.getVisibility() == 8) && z && this.hOq) {
            this.hVL.setVisibility(0);
        } else {
            this.hVL.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bQz() == null) {
            return false;
        }
        if (dVar.bQz().aiD() == 1 || dVar.bQz().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bQz().aiF() == null || dVar.bQz().aiF().akF() == 0) || dVar.bQz().aiB() == 1 || dVar.bQz().aiC() == 1 || dVar.bQz().ajr() || dVar.bQz().ajG() || dVar.bQz().ajz() || dVar.bQz().aiS() != null || !com.baidu.tbadk.core.util.aq.isEmpty(dVar.bQz().getCategory()) || dVar.bQz().aiJ() || dVar.bQz().aiI();
    }

    private SpannableStringBuilder bV(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hNY.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hVh != null) {
                if (dVar.bQz() != null && dVar.bQz().aiV() == 0 && !dVar.bQz().ajA() && !this.hXr) {
                    this.hVh.setVisibility(0);
                    if (dVar.bQz() != null) {
                        bh bQz = dVar.bQz();
                        bQz.q(true, q(dVar));
                        bQz.hH(3);
                        bQz.mY("2");
                    }
                    SpannableStringBuilder ajm = dVar.bQz().ajm();
                    this.hVi.setOnTouchListener(new com.baidu.tieba.view.k(ajm));
                    this.hVi.setText(ajm);
                    this.hVi.setVisibility(0);
                } else if (dVar.bQz().aiV() == 1) {
                    if (dVar.bQz() != null) {
                        this.hVh.setVisibility(8);
                        this.hUZ.removeHeaderView(this.hVh);
                    }
                } else {
                    this.hVh.setVisibility(8);
                    this.hUZ.removeHeaderView(this.hVh);
                    if (dVar.bQz() != null && dVar.bQz().ajA()) {
                        this.hVn.setPadding(this.hVn.getPaddingLeft(), 0, this.hVn.getPaddingRight(), this.hVn.getPaddingBottom());
                        if (this.hVF != null) {
                            ((RelativeLayout.LayoutParams) this.hVF.getLayoutParams()).height = (int) this.hNY.getResources().getDimension(R.dimen.tbds36);
                            this.hVF.requestLayout();
                        }
                        if (this.hVG != null) {
                            ((RelativeLayout.LayoutParams) this.hVG.getLayoutParams()).height = (int) this.hNY.getResources().getDimension(R.dimen.tbds0);
                            this.hVG.requestLayout();
                        }
                    } else {
                        this.hVn.setPadding(this.hVn.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(this.hNY.getPageContext().getPageActivity(), R.dimen.ds48), this.hVn.getPaddingRight(), this.hVn.getPaddingBottom());
                    }
                }
            }
            if (dVar.bQz() != null) {
                ad(dVar.bQz().aiC() == 1, dVar.bQz().aiB() == 1);
            }
            this.hOq = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bVI();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData c;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (dVar != null && (c = c(dVar, z)) != null) {
            String userId = c.aiG().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bQL()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (c.aiG() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, c.aiG().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, c.aiG().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, c.aiG().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, c.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bQL()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bd> bQU = dVar.bQU();
                if (com.baidu.tbadk.core.util.v.getCount(bQU) > 0) {
                    sb = new StringBuilder();
                    for (bd bdVar : bQU) {
                        if (bdVar != null && !StringUtils.isNull(bdVar.getForumName()) && (vVar = bdVar.cbb) != null && vVar.bYU && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bdVar.getForumName(), 12)).append(this.hNY.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.hNY.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View bVJ() {
        return this.cLA;
    }

    public boolean bVK() {
        if (this.arb == null || this.arb.getParent() == null || this.fBV.isLoading()) {
            return false;
        }
        int bottom = this.arb.getBottom();
        Rect rect = new Rect();
        this.arb.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void AS(String str) {
        if (this.fBV != null) {
            this.fBV.setText(str);
        }
    }

    public void AT(String str) {
        if (this.fBV != null) {
            int i = 0;
            if (this.hWK != null && this.hWK.hXU != null && this.hWK.hXU.getView() != null) {
                i = this.hWK.hXU.getView().getTop() < 0 ? this.hWK.hXU.getView().getHeight() : this.hWK.hXU.getView().getBottom();
            }
            this.fBV.R(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hUZ;
    }

    public int bVL() {
        return R.id.richText;
    }

    public TextView bRR() {
        return this.hVm.bRR();
    }

    public void d(BdListView.e eVar) {
        this.hUZ.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.cpS = cVar;
        if (this.hVS != null) {
            this.hVS.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int ahy = anVar.ahy();
            int ahv = anVar.ahv();
            if (this.hVP != null) {
                this.hVP.akO();
            } else {
                this.hVP = new com.baidu.tbadk.core.dialog.a(this.hNY.getPageContext().getPageActivity());
                this.hVQ = LayoutInflater.from(this.hNY.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.hVP.aM(this.hVQ);
                this.hVP.a(R.string.dialog_ok, bVar);
                this.hVP.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bVN();
                        aVar.dismiss();
                    }
                });
                this.hVP.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hWU == null) {
                            aq.this.hWU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hNY.HidenSoftKeyPad((InputMethodManager) aq.this.hNY.getSystemService("input_method"), aq.this.aqs);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fZ().postDelayed(aq.this.hWU, 150L);
                    }
                });
                this.hVP.b(this.hNY.getPageContext()).akO();
            }
            this.hVR = (EditText) this.hVQ.findViewById(R.id.input_page_number);
            this.hVR.setText("");
            TextView textView = (TextView) this.hVQ.findViewById(R.id.current_page_number);
            if (ahy <= 0) {
                ahy = 1;
            }
            if (ahv <= 0) {
                ahv = 1;
            }
            textView.setText(MessageFormat.format(this.hNY.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(ahy), Integer.valueOf(ahv)));
            this.hNY.ShowSoftKeyPadDelay(this.hVR, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hUZ.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hNY.showToast(str);
    }

    public boolean oI(boolean z) {
        if (this.Dl == null || !this.Dl.aub()) {
            return false;
        }
        this.Dl.asC();
        return true;
    }

    public void bVM() {
        if (this.hXD != null) {
            while (this.hXD.size() > 0) {
                TbImageView remove = this.hXD.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bVM();
        this.hVO.wy(1);
        if (this.hUP != null) {
            this.hUP.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.hVO.wy(2);
        if (this.hUP != null) {
            this.hUP.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.hNY) && !TbSingleton.getInstance().isCutoutScreen(this.hNY)) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hWW != null) {
            this.hWW.destroy();
        }
        if (this.hXn != null) {
            this.hXn.onDestory();
        }
        if (this.hXe != null) {
            this.hXe.hide();
        }
        if (this.hUS != null) {
            this.hUS.uP();
        }
        if (this.hUR != null) {
            this.hUR.onDestroy();
        }
        this.hNY.hideProgressBar();
        if (this.fbw != null && this.fsT != null) {
            this.fbw.b(this.fsT);
        }
        bVN();
        endLoadData();
        if (this.hWU != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hWU);
        }
        if (this.hVn != null && this.hVy != null) {
            this.hVn.removeView(this.hVt);
            this.hVy = null;
        }
        if (this.hWA != null) {
            this.hWA.clearStatus();
        }
        this.hXx = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hVO.wy(3);
        if (this.apC != null) {
            this.apC.setBackgroundDrawable(null);
        }
        if (this.hUP != null) {
            this.hUP.destroy();
        }
        if (this.hVO != null) {
            this.hVO.onDestroy();
        }
        this.hUZ.setOnLayoutListener(null);
        if (this.hXj != null) {
            this.hXj.bmv();
        }
        if (this.hWL != null) {
            this.hWL.onDestroy();
        }
    }

    public boolean wS(int i) {
        if (this.hUP != null) {
            return this.hUP.qP(i);
        }
        return false;
    }

    public void bVN() {
        this.hUV.ZF();
        if (this.hUS != null) {
            this.hUS.uP();
        }
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.hNY.getPageContext().getPageActivity(), this.hVR);
        bUX();
        if (this.hMc != null) {
            this.hMc.dismiss();
        }
        bVP();
        if (this.hUR != null) {
            this.hUR.bXU();
        }
        if (this.hVP != null) {
            this.hVP.dismiss();
        }
        if (this.fxx != null) {
            this.fxx.dismiss();
        }
    }

    public void bVO() {
        this.hUV.ZF();
        if (this.hUS != null) {
            this.hUS.uP();
        }
        if (this.hMc != null) {
            this.hMc.dismiss();
        }
        bVP();
        if (this.hUR != null) {
            this.hUR.bXU();
        }
        if (this.hVP != null) {
            this.hVP.dismiss();
        }
        if (this.fxx != null) {
            this.fxx.dismiss();
        }
    }

    public void dW(List<String> list) {
        this.hXi = list;
        if (this.hXj != null) {
            this.hXj.setData(list);
        }
    }

    public void nT(boolean z) {
        this.hVO.nT(z);
    }

    public void oJ(boolean z) {
        this.hWk = z;
    }

    public void bVP() {
        if (this.hVY != null) {
            this.hVY.dismiss();
        }
        if (this.hVZ != null) {
            com.baidu.adp.lib.g.g.b(this.hVZ, this.hNY.getPageContext());
        }
        if (this.hWa != null) {
            com.baidu.adp.lib.g.g.b(this.hWa, this.hNY.getPageContext());
        }
        if (this.hVW != null) {
            this.hVW.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hRx, this.hOq);
            d(this.hRx, this.hOq, this.mType);
            this.hNY.getLayoutMode().setNightMode(i == 1);
            this.hNY.getLayoutMode().onModeChanged(this.aqs);
            this.hNY.getLayoutMode().onModeChanged(this.hVb);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.aqs, R.color.cp_bg_line_d);
            }
            if (this.hUR != null) {
                this.hUR.onChangeSkinType(i);
            }
            if (this.hVc != null) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hVc, R.color.cp_bg_line_c);
            }
            if (this.hVd != null) {
                this.hVd.setIsNight(this.mSkinType == 1);
            }
            if (this.hVe != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVe, (int) R.color.cp_cont_b);
            }
            if (this.hVf != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVf, (int) R.color.cp_cont_j);
            }
            if (this.hVg != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hVg, R.drawable.icon_common_arrow16_right_n);
            }
            if (this.hVi != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVi, (int) R.color.cp_cont_b);
                this.hVi.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            }
            if (this.fBV != null) {
                this.fBV.changeSkin(i);
                if (this.cLA != null) {
                    this.hNY.getLayoutMode().onModeChanged(this.cLA);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.cLA, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.hVP != null) {
                this.hVP.c(this.hNY.getPageContext());
            }
            oH(this.hWh);
            this.hVO.notifyDataSetChanged();
            if (this.hVS != null) {
                this.hVS.changeSkin(i);
            }
            if (this.Dl != null) {
                this.Dl.onChangeSkinType(i);
            }
            if (this.hVx != null) {
                this.hVx.onChangeSkin(i);
            }
            if (this.hVT != null) {
                this.hVT.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.ePo)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ePo) {
                    customBlueCheckRadioButton.anx();
                }
            }
            bVn();
            UtilHelper.setStatusBarBackground(this.apC, i);
            UtilHelper.setStatusBarBackground(this.hWF, i);
            if (this.hVz != null) {
                this.hVz.onChangeSkinType(i);
            }
            if (this.hVD != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVD, (int) R.color.cp_cont_d);
            }
            if (this.hVC != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVC, (int) R.color.cp_cont_d);
            }
            if (this.hVE != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVE, (int) R.color.cp_cont_d);
            }
            if (this.hVB != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVB, (int) R.color.cp_cont_d);
            }
            if (this.hVH != null) {
                com.baidu.tbadk.s.a.a(this.hNY.getPageContext(), this.hVH);
            }
            if (this.hWV != null) {
                this.hWV.onChangeSkinType(i);
            }
            if (this.hUV != null) {
                if (this.hUP != null) {
                    this.hUP.wX(i);
                } else {
                    this.hUV.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.gox != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.gox, (int) R.color.cp_cont_d);
                this.gox.setBackgroundDrawable(com.baidu.tbadk.core.util.am.ab(com.baidu.adp.lib.util.l.getDimens(this.hNY, R.dimen.tbds16), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.hWp != null && this.hRx != null) {
                if (this.hRx.afm()) {
                    SvgManager.amN().a(this.hWp, R.drawable.icon_mask_pb_bottom_collect_h_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.amN().a(this.hWp, R.drawable.icon_pure_pb_bottom_collect_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            if (this.hWq != null) {
                SvgManager.amN().a(this.hWq, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hWo != null) {
                SvgManager.amN().a(this.hWo, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hWr, (int) R.color.cp_cont_b);
            if (this.hVr != null) {
                com.baidu.tbadk.core.util.am.setImageResource(this.hVr, BitmapHelper.getGradeResourceIdInEnterForum(this.hXd));
            }
            if (this.hXk != null) {
                this.hXk.onChangeSkinType(i);
            }
            if (this.hWL != null) {
                this.hWL.onChangeSkinType();
            }
            if (this.hXg != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hXg, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hWn, R.color.cp_bg_line_h);
            if (this.hVq != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hVq, this.hXp);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVq, (int) R.color.cp_cont_a);
            }
            if (this.hVa != null) {
                this.hVa.mE(i);
            }
            this.hNY.getLayoutMode().onModeChanged(this.hWb);
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cUE = hVar;
        this.hVO.setOnImageClickListener(this.cUE);
        this.hXk.setOnImageClickListener(this.cUE);
    }

    public void h(NoNetworkView.a aVar) {
        this.fsT = aVar;
        if (this.fbw != null) {
            this.fbw.a(this.fsT);
        }
    }

    public void oK(boolean z) {
        this.hVO.setIsFromCDN(z);
    }

    public Button bVQ() {
        return this.hWl;
    }

    public void bVR() {
        if (this.hUU != 2) {
            this.hUZ.setNextPage(this.fBV);
            this.hUU = 2;
        }
    }

    public void bVS() {
        if (com.baidu.tbadk.p.m.awN().awO()) {
            int lastVisiblePosition = this.hUZ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hUZ.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.cLY = true;
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
                        com.baidu.tbadk.p.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.setSubType(1001);
                        perfLog2.cLY = true;
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

    public boolean bVT() {
        return this.Dl != null && this.Dl.getVisibility() == 0;
    }

    public boolean bVU() {
        return this.Dl != null && this.Dl.aub();
    }

    public void bVV() {
        if (this.Dl != null) {
            this.Dl.asC();
        }
    }

    public void oL(boolean z) {
        if (this.hWn != null) {
            oJ(this.hNY.bRS().auF());
            if (this.hWk) {
                oB(z);
            } else {
                oC(z);
            }
        }
    }

    public void bVW() {
        if (this.hWn != null) {
            this.hWm.setVisibility(8);
            this.hWn.setVisibility(8);
            this.hWs = false;
            if (this.hWL != null) {
                this.hWL.setVisibility(8);
                oF(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.eWx == null) {
            this.eWx = new com.baidu.tbadk.core.view.b(this.hNY.getPageContext());
        }
        this.eWx.setDialogVisiable(true);
    }

    public void aVW() {
        if (this.eWx != null) {
            this.eWx.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hUZ.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hUZ.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hUP != null) {
            this.hUP.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hXE = getScrollY();
            this.hWK.hXU = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.hWK));
            a(this.hWK.hXU, true);
        }
    }

    public void oM(boolean z) {
        this.hUP.oM(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hUP != null) {
            this.hUP.b(absListView, i);
        }
        if (this.hUV != null && this.hVO != null) {
            this.hUV.cC(this.hVO.bTi());
        }
        this.hWK.hEh = i;
        this.hWK.headerCount = this.hUZ.getHeaderViewsCount();
        this.hWK.hXU = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.hWK));
        a(this.hWK.hXU, false);
        if (this.fBV.anN() && !this.fBV.cpJ) {
            if (this.hWK != null && this.hWK.hXU != null && this.hWK.hXU.getView() != null) {
                i4 = this.hWK.hXU.getView().getTop() < 0 ? this.hWK.hXU.getView().getHeight() : this.hWK.hXU.getView().getBottom();
            }
            this.fBV.iO(i4);
            this.fBV.cpJ = true;
        }
    }

    public void bVX() {
        if (this.hNY.isLogin() && this.hRx != null && this.hXa && !this.hWZ && !this.hWi && this.hWv != null && this.hWv.aiG() != null && !this.hWv.aiG().getIsLike() && !this.hWv.aiG().hadConcerned() && this.hWW == null) {
            this.hWW = new an(this.hNY);
        }
    }

    public void bVY() {
        if (this.hXa && !this.hWZ && this.hWv != null && this.hWv.aiG() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").O("obj_locate", this.hNY.bRv() ? 2 : 1).O("obj_type", this.hWZ ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.hNY.getPageContext().getPageActivity(), this.hWv.aiG().getUserId(), this.hWv.aiG().getUserName(), this.hNY.bRF().bRw(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hWZ && this.hWE != null && this.hUV.bWH() != null) {
            int bTe = this.hVO.bTe();
            if (bTe > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bTe > this.hUZ.getFirstVisiblePosition() - this.hUZ.getHeaderViewsCount()) {
                    this.hWE.setVisibility(8);
                    return;
                }
                this.hWE.setVisibility(0);
                bWi();
                this.hUV.mNavigationBar.hideBottomLine();
                if (this.hWE.getParent() != null && ((ViewGroup) this.hWE.getParent()).getHeight() <= this.hWE.getTop()) {
                    this.hWE.getParent().requestLayout();
                }
            } else if (alVar == null || alVar.getView() == null || alVar.hUt == null) {
                if (this.hUZ.getFirstVisiblePosition() == 0) {
                    this.hWE.setVisibility(8);
                    this.hUV.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hWJ) {
                        this.hWI = top;
                        this.hWJ = false;
                    }
                    this.hWI = top < this.hWI ? top : this.hWI;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hVN.getY() < 0.0f) {
                        measuredHeight = hWH - alVar.hUt.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hUV.bWH().getMeasuredHeight() - alVar.hUt.getMeasuredHeight();
                        this.hUV.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hWI) {
                        this.hWE.setVisibility(0);
                        bWi();
                    } else if (top < measuredHeight) {
                        this.hWE.setVisibility(0);
                        bWi();
                    } else {
                        this.hWE.setVisibility(8);
                        this.hUV.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.hWJ = true;
                    }
                }
            }
        }
    }

    public void bVZ() {
        if (!this.hXF) {
            TiebaStatic.log("c10490");
            this.hXF = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNY.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hWO, Integer.valueOf(hWQ));
            aVar.hT(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hNY.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aM(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.hNY);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hNY.getPageContext()).akO();
        }
    }

    public void AU(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNY.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hNY.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aM(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hWO, Integer.valueOf(hWR));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.hNY);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hNY.getPageContext()).akO();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData c;
        if (i > 0 && (c = c(dVar, z)) != null && c.aiG() != null) {
            MetaData aiG = c.aiG();
            aiG.setGiftNum(aiG.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bWa() {
        return this.hWA;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQz() != null && dVar.bQz().ajG() && this.hWA == null) {
            this.hWA = (PbInterviewStatusView) this.hWz.inflate();
            this.hWA.setOnClickListener(this.fxy);
            this.hWA.setCallback(this.hNY.bSE());
            this.hWA.setData(this.hNY, dVar);
        }
    }

    public LinearLayout bWb() {
        return this.hVN;
    }

    public View bWc() {
        return this.apC;
    }

    public boolean bWd() {
        return this.hXr;
    }

    public void nY(boolean z) {
        this.hVm.nY(z);
    }

    public void AV(String str) {
        if (this.hUW != null) {
            this.hUW.setTitle(str);
        }
    }

    private int oN(boolean z) {
        if (this.hWA == null || this.hWA.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(this.hNY.getPageContext().getPageActivity(), R.dimen.ds72);
    }

    private void bWe() {
        if (this.hWA != null && this.hWA.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hWA.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hWA.setLayoutParams(layoutParams);
        }
    }

    public boolean bRY() {
        return false;
    }

    public void AW(String str) {
        this.gox.performClick();
        if (!StringUtils.isNull(str) && this.hNY.bRS() != null && this.hNY.bRS().auy() != null && this.hNY.bRS().auy().getInputView() != null) {
            EditText inputView = this.hNY.bRS().auy().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bVN();
            if (configuration.orientation == 2) {
                bVW();
                bUX();
            } else {
                bVa();
            }
            if (this.hWV != null) {
                this.hWV.bTn();
            }
            this.hNY.bkl();
            this.hVN.setVisibility(8);
            this.hUV.oX(false);
            this.hNY.oe(false);
            if (this.hUP != null) {
                if (configuration.orientation == 1) {
                    bWb().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hUZ.setIsLandscape(true);
                    this.hUZ.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hUZ.setIsLandscape(false);
                    if (this.hXE > 0) {
                        this.hUZ.smoothScrollBy(this.hXE, 0);
                    }
                }
                this.hUP.onConfigurationChanged(configuration);
                this.hWD.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void oO(boolean z) {
        this.hUT = z;
    }

    public boolean bWf() {
        return this.hUP != null && this.hUP.bWf();
    }

    public void bWg() {
        if (this.hUP != null) {
            this.hUP.onPause();
        }
    }

    public void r(long j, int i) {
        if (this.hUR != null) {
            this.hUR.r(j, i);
        }
        if (this.hUP != null) {
            this.hUP.r(j, i);
        }
    }

    public void oj(boolean z) {
        this.hVO.oj(z);
    }

    public void bWh() {
        if (this.hWB == null) {
            LayoutInflater.from(this.hNY.getActivity()).inflate(R.layout.add_experienced_text, (ViewGroup) this.aqs, true);
            this.hWB = (ViewGroup) this.aqs.findViewById(R.id.add_experienced_layout);
            this.hWC = (TextView) this.aqs.findViewById(R.id.add_experienced);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hWC, (int) R.color.cp_cont_a);
            String string = this.hNY.getResources().getString(R.string.experienced_add_success);
            String string2 = this.hNY.getResources().getString(R.string.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_h)));
            this.hWC.setText(spannableString);
        }
        this.hWB.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.27
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.27.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        aq.this.hWB.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hWC.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hWC.startAnimation(scaleAnimation);
    }

    public void cB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.hWn.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hNY);
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.hXg = new TextView(this.hNY);
            this.hXg.setText(R.string.connection_tips);
            this.hXg.setGravity(17);
            this.hXg.setPadding(com.baidu.adp.lib.util.l.getDimens(this.hNY, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.hNY, R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.hNY, R.dimen.ds60);
            if (this.hXg.getParent() == null) {
                frameLayout.addView(this.hXg, layoutParams);
            }
            this.hXf = new PopupWindow(this.hNY);
            this.hXf.setContentView(frameLayout);
            this.hXf.setHeight(-2);
            this.hXf.setWidth(-2);
            this.hXf.setFocusable(true);
            this.hXf.setOutsideTouchable(false);
            this.hXf.setBackgroundDrawable(new ColorDrawable(this.hNY.getResources().getColor(R.color.transparent)));
            this.hUZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hXf.showAsDropDown(aq.this.hWn, view.getLeft(), -aq.this.hWn.getHeight());
                    } else {
                        aq.this.hXf.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void bWi() {
        if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("show_long_press_tips", false) && this.hXh == null) {
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("show_long_press_tips", true);
            this.hXh = new com.baidu.tbadk.core.dialog.a(this.hNY);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hNY);
            this.hXh.hX(1);
            this.hXh.aM(pbLongPressTipView);
            this.hXh.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hXh.eh(false);
            this.hXh.b(this.hNY.getPageContext()).akO();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hXh != null && aq.this.hXh.isShowing()) {
                        aq.this.hXh.dismiss();
                    }
                }
            }, 5000L);
            if (this.hUP != null) {
                this.hUP.bYd();
            }
        }
    }

    public void oP(boolean z) {
        this.hXm = z;
    }

    public boolean bWj() {
        return this.hXm;
    }

    public PbThreadPostView bWk() {
        return this.hVa;
    }

    private void ad(boolean z, boolean z2) {
        ae(z, z2);
        af(z, z2);
        if (this.hVO != null && this.hVO.bTj() != null) {
            this.hVO.bTj().a(this.hRx, z, z2);
        }
    }

    private void ae(boolean z, boolean z2) {
        if (this.hRx != null && this.hRx.hJu) {
            this.hVk.setImageResource(R.drawable.pic_frs_headlines_n);
            this.hVk.setVisibility(0);
        } else if (z && z2) {
            this.hVk.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hVk.setVisibility(0);
        } else if (z) {
            this.hVk.setImageResource(R.drawable.pic_pb_refined_n);
            this.hVk.setVisibility(0);
        } else if (z2) {
            this.hVk.setImageResource(R.drawable.pic_pb_stick_n);
            this.hVk.setVisibility(0);
        } else {
            this.hVk.setVisibility(8);
        }
    }

    private void af(boolean z, boolean z2) {
        if (this.hVh != null && this.hRx != null && this.hRx.bQz() != null && this.hRx.bQz().aiV() == 0 && !this.hRx.bQz().ajA()) {
            if (this.hRx != null && this.hRx.hJu) {
                this.hVk.setImageResource(R.drawable.pic_frs_headlines_n);
                this.hVk.setVisibility(0);
            } else if (z && z2) {
                this.hVl.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.hVl.setVisibility(0);
            } else if (z) {
                this.hVl.setImageResource(R.drawable.pic_pb_refined_n);
                this.hVl.setVisibility(0);
            } else if (z2) {
                this.hVl.setImageResource(R.drawable.pic_pb_stick_n);
                this.hVl.setVisibility(0);
            } else {
                this.hVl.setVisibility(8);
            }
        }
    }
}
