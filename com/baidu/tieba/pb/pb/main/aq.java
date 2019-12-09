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
    private static final int hVQ = UtilHelper.getLightStatusBarHeight();
    public static int hVW = 3;
    public static int hVX = 0;
    public static int hVY = 3;
    public static int hVZ = 4;
    public static int hWa = 5;
    public static int hWb = 6;
    private static a.InterfaceC0513a hWz = new a.InterfaceC0513a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0513a
        public void onRefresh() {
        }
    };
    private EditorTools CJ;
    private View apj;
    private View aqJ;
    private RelativeLayout aqa;
    private View cKJ;
    private h.c cpa;
    private com.baidu.tieba.pb.a.c cyE;
    private List<CustomBlueCheckRadioButton> eOx;
    private PbListView fBe;
    private NavigationBarCoverTip fTC;
    private com.baidu.tieba.NEGFeedBack.e fWw;
    private NoNetworkView faF;
    private View.OnClickListener fwH;
    private TextView gnG;
    PbActivity.d hMm;
    private View.OnClickListener hNH;
    private PbActivity hNh;
    private UserIconBox hOv;
    private UserIconBox hOw;
    private PbFakeFloorModel hPw;
    private com.baidu.tieba.pb.data.d hQG;
    public int hTX;
    public com.baidu.tieba.pb.video.i hTY;
    private long hTZ;
    private ImageView hUA;
    private HeadPendantView hUB;
    private FrameLayout hUC;
    private HeadImageView hUD;
    private View hUE;
    private LinearLayout hUF;
    private PbFirstFloorUserLikeButton hUI;
    private ao hUJ;
    private TextView hUK;
    private TextView hUL;
    private TextView hUM;
    private TextView hUN;
    private View hUO;
    private View hUP;
    private LinearLayout hUQ;
    private TextView hUR;
    private TextView hUS;
    private View hUT;
    private View hUU;
    private ObservedChangeLinearLayout hUW;
    private f hUX;
    private com.baidu.tieba.pb.video.h hUa;
    private com.baidu.tieba.c.d hUb;
    public final com.baidu.tieba.pb.pb.main.view.c hUe;
    public com.baidu.tieba.pb.pb.main.view.b hUf;
    private ViewStub hUg;
    private ViewStub hUh;
    private PbLandscapeListView hUi;
    private PbThreadPostView hUj;
    private View hUk;
    private RelativeLayout hUl;
    private HeadImageView hUm;
    private TextView hUn;
    private TextView hUo;
    private ImageView hUp;
    private RelativeLayout hUs;
    private ImageView hUt;
    private ImageView hUu;
    private e hUv;
    private ColumnLayout hUw;
    private ThreadSkinView hUx;
    private TextView hUy;
    private TextView hUz;
    private TextView hVA;
    private int hVC;
    private int hVD;
    private PostData hVE;
    private View hVG;
    private TextView hVH;
    private ViewStub hVI;
    private PbInterviewStatusView hVJ;
    private ViewGroup hVK;
    private TextView hVL;
    private FrameLayout hVM;
    private View hVN;
    private View hVO;
    private al hVP;
    private PbEmotionBar hVU;
    private View hVd;
    private View hVv;
    private View hVw;
    private ImageView hVx;
    private ImageView hVy;
    private ImageView hVz;
    private boolean hWA;
    private com.baidu.tbadk.core.view.userLike.c hWB;
    private com.baidu.tbadk.core.view.userLike.c hWC;
    private Runnable hWH;
    private PbActivity.b hWJ;
    public int hWN;
    private int hWc;
    private Runnable hWd;
    private s hWe;
    private an hWf;
    private int hWl;
    private PbTopTipView hWn;
    private PopupWindow hWo;
    private TextView hWp;
    private com.baidu.tbadk.core.dialog.a hWq;
    private List<String> hWr;
    private com.baidu.tieba.pb.pb.main.emotion.c hWs;
    private com.baidu.tieba.pb.pb.godreply.a hWt;
    private PbLandscapeListView.b hWu;
    private ac hWw;
    private String hWx;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private boolean hUc = false;
    private int hUd = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hUq = null;
    private TextView hUr = null;
    public FrsPraiseView hUG = null;
    private ClickableHeaderImageView hUH = null;
    private View hUV = null;
    private com.baidu.tbadk.core.dialog.a hUY = null;
    private com.baidu.tbadk.core.dialog.b fwG = null;
    private View hUZ = null;
    private EditText hVa = null;
    private com.baidu.tieba.pb.view.c hVb = null;
    private com.baidu.tieba.pb.view.a hVc = null;
    private com.baidu.tbadk.core.dialog.a hVe = null;
    private b.a gJM = null;
    private TbRichTextView.h cTN = null;
    private NoNetworkView.a fsc = null;
    private com.baidu.tbadk.core.dialog.i hVf = null;
    private View hVg = null;
    private com.baidu.tbadk.core.dialog.a hVh = null;
    private Dialog hVi = null;
    private Dialog hVj = null;
    private View hVk = null;
    private LinearLayout hVl = null;
    private CompoundButton.OnCheckedChangeListener eOy = null;
    private TextView hVm = null;
    private TextView hVn = null;
    private String hVo = null;
    private com.baidu.tbadk.core.dialog.i hLl = null;
    private com.baidu.tbadk.core.dialog.i hVp = null;
    private boolean hVq = false;
    private boolean hVr = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hVs = null;
    private boolean hVt = false;
    private Button hVu = null;
    private boolean hVB = true;
    private com.baidu.tbadk.core.view.b eVG = null;
    private boolean hNz = false;
    private int mSkinType = 3;
    private boolean hVF = false;
    private int hVR = 0;
    private boolean hVS = true;
    public a hVT = new a();
    private int hVV = 0;
    private boolean hWg = false;
    private int hWh = 0;
    private boolean hWi = false;
    private boolean hWj = false;
    private boolean hWk = false;
    private int hWm = 0;
    private boolean hWv = false;
    private int hWy = R.drawable.bg_user_identity_btn;
    private String hWD = null;
    private CustomMessageListener hWE = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hWD = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hUX != null) {
                aq.this.hUX.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hWF = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hUr != null) {
                aq.this.hUr.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hWG = new Handler();
    private CustomMessageListener hWI = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hVB = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hWK = true;
    View.OnClickListener hWL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hWi) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").O("obj_id", 2));
            }
            if (!aq.this.hWi && aq.this.hQG != null && aq.this.hQG.bQx() != null && aq.this.hQG.bQx().aiE() != null && aq.this.hQG.bQx().aiE().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").O("obj_locate", 1));
            }
            aq.this.hNh.hLg.fXf.onClick(view);
        }
    };
    private boolean dNt = false;
    String userId = null;
    private final List<TbImageView> hWM = new ArrayList();
    private boolean hWO = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int hDq;
        public al hXd;
        public int headerCount;
    }

    public void oA(boolean z) {
        this.hWg = z;
        if (this.hUi != null) {
            this.hWh = this.hUi.getHeaderViewsCount();
        }
    }

    public void bUT() {
        if (this.hUi != null) {
            int headerViewsCount = this.hUi.getHeaderViewsCount() - this.hWh;
            final int firstVisiblePosition = (this.hUi.getFirstVisiblePosition() == 0 || this.hUi.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hUi.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hUi.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hVT.hXd = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.hVT));
            final al alVar = this.hVT.hXd;
            final int h = h(alVar);
            final int y = ((int) this.hUW.getY()) + this.hUW.getMeasuredHeight();
            final boolean z = this.hVN.getVisibility() == 0;
            boolean z2 = this.hUW.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hUX.bTc() + this.hUi.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hTC.getMeasuredHeight() : 0;
                if (z2) {
                    this.hUi.setSelectionFromTop(this.hUX.bTc() + this.hUi.getHeaderViewsCount(), hVQ - measuredHeight);
                } else {
                    this.hUi.setSelectionFromTop(this.hUX.bTc() + this.hUi.getHeaderViewsCount(), this.hUe.bWF().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hUi.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hWi) {
                this.hUi.setSelectionFromTop(this.hUX.bTc() + this.hUi.getHeaderViewsCount(), this.hTY.aJw().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hUi.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bTu() {
                        if (h >= 0 && h <= aq.this.aqa.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.aqJ.getLayoutParams();
                            if (i == 0 || i > aq.this.aqa.getMeasuredHeight() || h2 >= aq.this.aqa.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hWc;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.aqa.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hWc;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hUi.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.aqJ.setLayoutParams(layoutParams);
                            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (aq.this.aqJ != null && aq.this.aqJ.getLayoutParams() != null) {
                                        ViewGroup.LayoutParams layoutParams2 = aq.this.aqJ.getLayoutParams();
                                        layoutParams2.height = aq.this.hWc;
                                        aq.this.aqJ.setLayoutParams(layoutParams2);
                                    }
                                }
                            });
                        }
                        aq.this.hUi.setOnLayoutListener(null);
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

    public NoNetworkView bUU() {
        return this.faF;
    }

    public void bUV() {
        if (this.CJ != null) {
            this.CJ.hide();
            if (this.hWs != null) {
                this.hWs.beT();
            }
        }
    }

    public PbFakeFloorModel bUW() {
        return this.hPw;
    }

    public s bUX() {
        return this.hWe;
    }

    public void bUY() {
        reset();
        bUV();
        this.hWe.bTl();
        oL(false);
    }

    private void reset() {
        if (this.hNh != null && this.hNh.bRQ() != null && this.CJ != null) {
            com.baidu.tbadk.editortools.pb.a.aut().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bRQ = this.hNh.bRQ();
            bRQ.auM();
            bRQ.auh();
            if (bRQ.getWriteImagesInfo() != null) {
                bRQ.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bRQ.jQ(SendView.ALL);
            bRQ.jR(SendView.ALL);
            com.baidu.tbadk.editortools.g jH = this.CJ.jH(23);
            com.baidu.tbadk.editortools.g jH2 = this.CJ.jH(2);
            com.baidu.tbadk.editortools.g jH3 = this.CJ.jH(5);
            if (jH2 != null) {
                jH2.le();
            }
            if (jH3 != null) {
                jH3.le();
            }
            if (jH != null) {
                jH.hide();
            }
            this.CJ.invalidate();
        }
    }

    public boolean bUZ() {
        return this.hVB;
    }

    public void oB(boolean z) {
        if (this.hVw != null && this.gnG != null) {
            this.gnG.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hVw.startAnimation(alphaAnimation);
            }
            this.hVv.setVisibility(0);
            this.hVw.setVisibility(0);
            this.hVB = true;
            if (this.hVU != null && !this.hWt.isActive()) {
                this.hVU.setVisibility(0);
                oF(true);
            }
        }
    }

    public void oC(boolean z) {
        if (this.hVw != null && this.gnG != null) {
            this.gnG.setText(bVa());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hVw.startAnimation(alphaAnimation);
            }
            this.hVv.setVisibility(0);
            this.hVw.setVisibility(0);
            this.hVB = true;
            if (this.hVU != null && !this.hWt.isActive()) {
                this.hVU.setVisibility(0);
                oF(true);
            }
        }
    }

    public String bVa() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.hWx)) {
            return this.hWx;
        }
        if (this.hNh != null) {
            this.hWx = this.hNh.getResources().getString(ap.bUS());
        }
        return this.hWx;
    }

    public PostData bVb() {
        int i = 0;
        if (this.hUi == null) {
            return null;
        }
        int bVc = bVc() - this.hUi.getHeaderViewsCount();
        if (bVc < 0) {
            bVc = 0;
        }
        if (this.hUX.ww(bVc) != null && this.hUX.ww(bVc) != PostData.jhv) {
            i = bVc + 1;
        }
        return this.hUX.getItem(i) instanceof PostData ? (PostData) this.hUX.getItem(i) : null;
    }

    public int bVc() {
        int i;
        View childAt;
        if (this.hUi == null) {
            return 0;
        }
        int firstVisiblePosition = this.hUi.getFirstVisiblePosition();
        int lastVisiblePosition = this.hUi.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hUi.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hUi.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bVd() {
        return this.hUi.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hQG != null && this.hQG.bQz() != null && !this.hQG.bQz().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hQG.bQz().size() && (postData = this.hQG.bQz().get(i)) != null && postData.aiE() != null && !StringUtils.isNull(postData.aiE().getUserId()); i++) {
                if (this.hQG.bQz().get(i).aiE().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hWt != null && this.hWt.isActive()) {
                        oL(false);
                    }
                    if (this.hVU != null) {
                        this.hVU.oT(true);
                    }
                    this.hWD = postData.aiE().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hNh = null;
        this.aqa = null;
        this.apj = null;
        this.hTZ = 0L;
        this.hUi = null;
        this.hUk = null;
        this.hUs = null;
        this.hUw = null;
        this.hUy = null;
        this.hUz = null;
        this.hUC = null;
        this.hUD = null;
        this.hUE = null;
        this.hUI = null;
        this.hUK = null;
        this.hUL = null;
        this.hUM = null;
        this.hUN = null;
        this.hUT = null;
        this.hUU = null;
        this.hUX = null;
        this.fBe = null;
        this.cKJ = null;
        this.fwH = null;
        this.hNH = null;
        this.hVw = null;
        this.gnG = null;
        this.hVG = null;
        this.hVH = null;
        this.hVI = null;
        this.hWl = 0;
        this.hTZ = System.currentTimeMillis();
        this.hNh = pbActivity;
        this.fwH = onClickListener;
        this.cyE = cVar;
        this.hWl = com.baidu.adp.lib.util.l.getEquipmentWidth(this.hNh) / 2;
        this.aqa = (RelativeLayout) LayoutInflater.from(this.hNh.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.hNh.addContentView(this.aqa, new FrameLayout.LayoutParams(-1, -1));
        this.fTC = (NavigationBarCoverTip) this.hNh.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.apj = this.hNh.findViewById(R.id.statebar_view);
        this.hUW = (ObservedChangeLinearLayout) this.hNh.findViewById(R.id.title_wrapper);
        this.faF = (NoNetworkView) this.hNh.findViewById(R.id.view_no_network);
        this.hUi = (PbLandscapeListView) this.hNh.findViewById(R.id.new_pb_list);
        this.hVM = (FrameLayout) this.hNh.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.hNh.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.hNh.getActivity(), R.dimen.ds88));
        this.hUi.addHeaderView(this.textView, 0);
        this.hWc = this.hNh.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aqJ = new View(this.hNh.getPageContext().getPageActivity());
        this.aqJ.setLayoutParams(new AbsListView.LayoutParams(-1, this.hWc));
        this.aqJ.setVisibility(4);
        this.hUi.addFooterView(this.aqJ);
        this.hUi.setOnTouchListener(this.hNh.czy);
        this.hUe = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.hNh.bSu()) {
            this.hUg = (ViewStub) this.hNh.findViewById(R.id.manga_view_stub);
            this.hUg.setVisibility(0);
            this.hUf = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.hUf.show();
            this.hUe.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.hNh.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.hUe.bWF().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0472a
            public void bRn() {
                if (aq.this.hUi != null) {
                    if (aq.this.hTY != null) {
                        aq.this.hTY.bYa();
                    }
                    aq.this.hUi.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0472a
            public void bRo() {
                aq.this.hNh.bkj();
            }
        }));
        this.hVv = this.hNh.findViewById(R.id.view_comment_top_line);
        this.hVw = this.hNh.findViewById(R.id.pb_editor_tool_comment);
        this.hVC = com.baidu.adp.lib.util.l.getDimens(this.hNh.getPageContext().getPageActivity(), R.dimen.tbds120);
        this.hVD = com.baidu.adp.lib.util.l.getDimens(this.hNh.getPageContext().getPageActivity(), R.dimen.ds242);
        this.gnG = (TextView) this.hNh.getPageContext().getPageActivity().findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.gnG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hNh.bSa();
                if (aq.this.hNh != null && aq.this.hNh.bRD() != null && aq.this.hNh.bRD().getPbData() != null && aq.this.hNh.bRD().getPbData().bQx() != null && aq.this.hNh.bRD().getPbData().bQx().aiE() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", aq.this.hNh.bRD().hQk).bS("fid", aq.this.hNh.bRD().getPbData().getForumId()).O("obj_locate", 1).bS("uid", aq.this.hNh.bRD().getPbData().bQx().aiE().getUserId()));
                }
            }
        });
        this.hVx = (ImageView) this.hNh.findViewById(R.id.pb_editor_tool_comment_icon);
        this.hVx.setOnClickListener(this.fwH);
        this.hVy = (ImageView) this.hNh.findViewById(R.id.pb_editor_tool_collection);
        this.hVy.setOnClickListener(this.fwH);
        this.hVz = (ImageView) this.hNh.findViewById(R.id.pb_editor_tool_share);
        this.hVz.setOnClickListener(this.fwH);
        this.hVA = (TextView) this.hNh.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.hUk = LayoutInflater.from(this.hNh.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.hUs = (RelativeLayout) LayoutInflater.from(this.hNh.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.hUt = (ImageView) this.hUs.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.hUv = new e(this.hNh, this.hUs);
        this.hUv.init();
        this.hUv.a(this.hUv.bRP(), this.fwH);
        this.hUw = (ColumnLayout) this.hUs.findViewById(R.id.pb_head_owner_root);
        this.hUx = (ThreadSkinView) this.hUs.findViewById(R.id.pb_thread_skin);
        this.hUw.setOnLongClickListener(this.onLongClickListener);
        this.hUw.setOnTouchListener(this.cyE);
        this.hUw.setVisibility(8);
        this.hUk.setOnTouchListener(this.cyE);
        this.hVG = this.hUk.findViewById(R.id.pb_head_activity_join_number_container);
        this.hVG.setVisibility(8);
        this.hVH = (TextView) this.hUk.findViewById(R.id.pb_head_activity_join_number);
        this.hUy = (TextView) this.hUw.findViewById(R.id.pb_head_owner_info_user_name);
        this.hUy.getPaint().setFakeBoldText(true);
        this.hUz = (TextView) this.hUw.findViewById(R.id.floor_owner);
        this.hUA = (ImageView) this.hUw.findViewById(R.id.icon_forum_level);
        this.hUC = (FrameLayout) this.hUw.findViewById(R.id.pb_head_headImage_container);
        this.hUD = (HeadImageView) this.hUw.findViewById(R.id.pb_head_owner_photo);
        this.hUB = (HeadPendantView) this.hUw.findViewById(R.id.pb_pendant_head_owner_photo);
        this.hUB.setHasPendantStyle();
        if (this.hUB.getHeadView() != null) {
            this.hUB.getHeadView().setIsRound(true);
            this.hUB.getHeadView().setDrawBorder(false);
        }
        this.hOv = (UserIconBox) this.hUw.findViewById(R.id.show_icon_vip);
        this.hOw = (UserIconBox) this.hUw.findViewById(R.id.show_icon_yinji);
        this.hUF = (LinearLayout) this.hUs.findViewById(R.id.pb_head_owner_info_root);
        this.hUI = (PbFirstFloorUserLikeButton) this.hUw.findViewById(R.id.pb_like_button);
        this.hUK = (TextView) this.hUw.findViewById(R.id.pb_views);
        this.hUL = (TextView) this.hUw.findViewById(R.id.pb_item_first_floor_reply_time);
        this.hUM = (TextView) this.hUw.findViewById(R.id.pb_item_first_floor_location_address);
        this.hUN = (TextView) this.hUw.findViewById(R.id.point_between_time_and_locate);
        this.hWB = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hWC = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hUT = this.hUk.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.hUU = this.hUk.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.hUk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hVI = (ViewStub) this.aqa.findViewById(R.id.interview_status_stub);
        this.hUO = this.hUs.findViewById(R.id.blank_view_align_user_item_top);
        this.hUP = this.hUs.findViewById(R.id.blank_view_align_user_item_bottom);
        this.hUX = new f(this.hNh, this.hUi);
        this.hUX.C(this.fwH);
        this.hUX.setTbGestureDetector(this.cyE);
        this.hUX.setOnImageClickListener(this.cTN);
        this.hNH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hNh.b(sparseArray);
                            return;
                        }
                        aq.this.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.hNh.b(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hUX.O(this.hNH);
        bVi();
        bVj();
        this.hUi.addHeaderView(this.hUs);
        this.hUi.addHeaderView(this.hUq);
        this.hUi.addHeaderView(this.hUk);
        this.fBe = new PbListView(this.hNh.getPageContext().getPageActivity());
        this.cKJ = this.fBe.getView().findViewById(R.id.pb_more_view);
        if (this.cKJ != null) {
            this.cKJ.setOnClickListener(this.fwH);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.cKJ, R.drawable.pb_foot_more_trans_selector);
        }
        this.fBe.setLineVisible();
        this.fBe.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.fBe.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.hVd = this.hNh.findViewById(R.id.viewstub_progress);
        this.hNh.registerListener(this.hWI);
        this.hUE = com.baidu.tbadk.ala.b.afa().l(this.hNh.getActivity(), 2);
        if (this.hUE != null) {
            this.hUE.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            if (this.hUE.getParent() == null) {
                this.hUF.addView(this.hUE, aVar);
            }
        }
        this.hPw = new PbFakeFloorModel(this.hNh.getPageContext());
        this.hWe = new s(this.hNh.getPageContext(), this.hPw, this.aqa);
        this.hWe.a(this.hNh.hMh);
        this.hPw.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hPw.o(postData);
                aq.this.hUX.notifyDataSetChanged();
                aq.this.hWe.bTl();
                aq.this.CJ.asA();
                aq.this.oL(false);
            }
        });
        if (this.hNh.bRD() != null && !StringUtils.isNull(this.hNh.bRD().bUg())) {
            this.hNh.showToast(this.hNh.bRD().bUg());
        }
        this.hVN = this.hNh.findViewById(R.id.pb_expand_blank_view);
        this.hVO = this.hNh.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hVO.getLayoutParams();
        if (this.hNh.bRD() != null && this.hNh.bRD().bTB()) {
            this.hVN.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hVO.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hVQ;
            this.hVO.setLayoutParams(layoutParams2);
        }
        this.hVP = new al(this.hNh.getPageContext(), this.hNh.findViewById(R.id.pb_reply_expand_view));
        this.hVP.hTC.setVisibility(8);
        this.hVP.Q(this.fwH);
        this.hNh.registerListener(this.mAccountChangedListener);
        this.hNh.registerListener(this.hWE);
        this.hNh.registerListener(this.hWF);
        bVe();
        oF(false);
    }

    public void bvx() {
        if (!this.hNh.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").O("obj_locate", 2).bS("fid", this.mForumId));
        } else if (this.hNh.bSc()) {
            com.baidu.tbadk.editortools.pb.d bRQ = this.hNh.bRQ();
            if (bRQ != null && (bRQ.auJ() || bRQ.auK())) {
                this.hNh.bRQ().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.CJ != null) {
                bVo();
            }
            if (this.CJ != null) {
                this.hVB = false;
                if (this.CJ.jK(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hNh, (View) this.CJ.jK(2).cEn, false, hWz);
                }
            }
            bVU();
        }
    }

    private void bVe() {
        this.hWt = new com.baidu.tieba.pb.pb.godreply.a(this.hNh, this, (ViewStub) this.aqa.findViewById(R.id.more_god_reply_popup));
        this.hWt.w(this.fwH);
        this.hWt.O(this.hNH);
        this.hWt.setOnImageClickListener(this.cTN);
        this.hWt.w(this.fwH);
        this.hWt.setTbGestureDetector(this.cyE);
    }

    public com.baidu.tieba.pb.pb.godreply.a bVf() {
        return this.hWt;
    }

    public View bVg() {
        return this.hVN;
    }

    public void bVh() {
        if (this.hUi != null) {
            this.hUi.removeHeaderView(this.hUq);
            this.hUi.removeHeaderView(this.hUs);
            this.hUi.removeHeaderView(this.hUl);
            this.hUi.removeHeaderView(this.hUk);
        }
    }

    private void bVi() {
        if (this.hUl == null) {
            this.hUl = (RelativeLayout) LayoutInflater.from(this.hNh).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.hUm = (HeadImageView) this.hUl.findViewById(R.id.iv_pb_video_smart_app_head);
            this.hUm.setIsRound(true);
            this.hUn = (TextView) this.hUl.findViewById(R.id.tv_pb_video_smart_app_title);
            this.hUo = (TextView) this.hUl.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.hUp = (ImageView) this.hUl.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.hUl.setOnClickListener(this.fwH);
        }
    }

    private void bVj() {
        if (this.hUq == null) {
            this.hUq = (RelativeLayout) LayoutInflater.from(this.hNh).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.hUu = (ImageView) this.hUq.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.hUu.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
            this.hUu.setImageMatrix(matrix);
            this.hUr = (TextView) this.hUq.findViewById(R.id.tv_pb_title);
            this.hUr.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.hUr.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hUr.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hUr, (int) R.color.cp_cont_b);
            this.hUr.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hUr.setVisibility(8);
            if (this.hUr.getParent() == null) {
                this.hUq.addView(this.hUr);
            }
            this.hUq.setOnTouchListener(this.cyE);
            this.hUq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVk() {
        if (this.hNh.bSu()) {
            this.hUh = (ViewStub) this.hNh.findViewById(R.id.manga_mention_controller_view_stub);
            this.hUh.setVisibility(0);
            if (this.hUQ == null) {
                this.hUQ = (LinearLayout) this.hNh.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.s.a.a(this.hNh.getPageContext(), this.hUQ);
            }
            if (this.hUR == null) {
                this.hUR = (TextView) this.hUQ.findViewById(R.id.manga_prev_btn);
            }
            if (this.hUS == null) {
                this.hUS = (TextView) this.hUQ.findViewById(R.id.manga_next_btn);
            }
            this.hUR.setOnClickListener(this.fwH);
            this.hUS.setOnClickListener(this.fwH);
        }
    }

    private void bVl() {
        if (this.hNh.bSu()) {
            if (this.hNh.bSx() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUR, R.color.cp_cont_e, 1);
            }
            if (this.hNh.bSy() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUS, R.color.cp_cont_e, 1);
            }
        }
    }

    public void bVm() {
        if (this.hUQ == null) {
            bVk();
        }
        this.hUh.setVisibility(8);
        if (this.hWG != null && this.hWH != null) {
            this.hWG.removeCallbacks(this.hWH);
        }
    }

    public void bVn() {
        if (this.hWG != null) {
            if (this.hWH != null) {
                this.hWG.removeCallbacks(this.hWH);
            }
            this.hWH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hUQ == null) {
                        aq.this.bVk();
                    }
                    aq.this.hUh.setVisibility(0);
                }
            };
            this.hWG.postDelayed(this.hWH, 2000L);
        }
    }

    public void oD(boolean z) {
        this.hUe.oD(z);
        if (z && this.hVF) {
            this.fBe.setText(this.hNh.getResources().getString(R.string.click_load_more));
            this.hUi.setNextPage(this.fBe);
            this.hUd = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
        this.CJ.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.CJ.getParent() == null) {
            this.aqa.addView(this.CJ, layoutParams);
        }
        this.CJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.CJ.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).apk() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).apk() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
                        }
                        aq.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        aq.this.mPermissionJudgePolicy.appendRequestPermission(aq.this.hNh, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.startRequestPermission(aq.this.hNh)) {
                            aq.this.hNh.bRQ().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hNh.bRQ().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bUV();
        this.hNh.bRQ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.CJ != null && aq.this.CJ.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hWs == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.CJ.getId());
                            aq.this.hWs = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hNh.getPageContext(), aq.this.aqa, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(aq.this.hWr)) {
                                aq.this.hWs.setData(aq.this.hWr);
                            }
                            aq.this.hWs.b(aq.this.CJ);
                        }
                        aq.this.hWs.Ba(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hNh.hLk != null && aq.this.hNh.hLk.bWl() != null) {
                    if (!aq.this.hNh.hLk.bWl().cxz()) {
                        aq.this.hNh.hLk.oQ(false);
                    }
                    aq.this.hNh.hLk.bWl().rL(false);
                }
            }
        });
    }

    public void bVo() {
        if (this.hNh != null && this.CJ != null) {
            this.CJ.le();
            if (this.hNh.bRQ() != null) {
                this.hNh.bRQ().auA();
            }
            bVU();
        }
    }

    public void oE(boolean z) {
        if (this.hUi != null && this.textView != null && this.apj != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.apj.setVisibility(0);
                } else {
                    this.apj.setVisibility(8);
                    this.hUi.removeHeaderView(this.textView);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hVQ;
                    this.textView.setLayoutParams(layoutParams);
                }
                bVC();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + oN(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            bVC();
            bWc();
        }
    }

    public f bVp() {
        return this.hUX;
    }

    public void a(PbActivity.d dVar) {
        this.hMm = dVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hNh);
        kVar.setTitleText(this.hNh.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hVf.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hWJ != null) {
                                aq.this.hWJ.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hNh.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hNh.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hNh.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !bWb()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.hNh.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hNh.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hNh.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.at(arrayList);
        if (this.hVf == null) {
            this.hVf = new com.baidu.tbadk.core.dialog.i(this.hNh.getPageContext(), kVar);
        } else {
            this.hVf.a(kVar);
        }
        this.hVf.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hWJ = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hNh != null && aVar != null) {
            if (this.fWw == null) {
                this.fWw = new com.baidu.tieba.NEGFeedBack.e(this.hNh.getPageContext(), this.hUk);
            }
            AntiData biX = this.hNh.biX();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (biX != null && biX.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biX.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.setFeedBackReasonMap(sparseArray);
            this.fWw.setDefaultReasonArray(new String[]{this.hNh.getString(R.string.delete_thread_reason_1), this.hNh.getString(R.string.delete_thread_reason_2), this.hNh.getString(R.string.delete_thread_reason_3), this.hNh.getString(R.string.delete_thread_reason_4), this.hNh.getString(R.string.delete_thread_reason_5)});
            this.fWw.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fWw.qE(str);
            this.fWw.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void K(JSONArray jSONArray) {
                    aq.this.hNh.a(aVar, jSONArray);
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
        sparseArray.put(hVX, Integer.valueOf(hVY));
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
        this.hVh = new com.baidu.tbadk.core.dialog.a(this.hNh.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hVh.hT(i3);
        } else {
            this.hVh.setOnlyMessageShowCenter(false);
            this.hVh.nn(str2);
        }
        this.hVh.setYesButtonTag(sparseArray);
        this.hVh.a(R.string.dialog_ok, this.hNh);
        this.hVh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hVh.eg(true);
        this.hVh.b(this.hNh.getPageContext());
        if (z) {
            this.hVh.akM();
        } else {
            a(this.hVh, i);
        }
    }

    public void aB(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hVk == null) {
            this.hVk = LayoutInflater.from(this.hNh.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.hNh.getLayoutMode().onModeChanged(this.hVk);
        if (this.hVj == null) {
            this.hVj = new Dialog(this.hNh.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hVj.setCanceledOnTouchOutside(true);
            this.hVj.setCancelable(true);
            this.hVs = (ScrollView) this.hVk.findViewById(R.id.good_scroll);
            this.hVj.setContentView(this.hVk);
            WindowManager.LayoutParams attributes = this.hVj.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.hNh.getPageContext().getPageActivity(), R.dimen.ds540);
            this.hVj.getWindow().setAttributes(attributes);
            this.eOy = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hVo = (String) compoundButton.getTag();
                        if (aq.this.eOx != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.eOx) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hVo != null && !str.equals(aq.this.hVo)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hVl = (LinearLayout) this.hVk.findViewById(R.id.good_class_group);
            this.hVn = (TextView) this.hVk.findViewById(R.id.dialog_button_cancel);
            this.hVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hVj instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hVj, aq.this.hNh.getPageContext());
                    }
                }
            });
            this.hVm = (TextView) this.hVk.findViewById(R.id.dialog_button_ok);
            this.hVm.setOnClickListener(this.fwH);
        }
        this.hVl.removeAllViews();
        this.eOx = new ArrayList();
        CustomBlueCheckRadioButton dB = dB("0", this.hNh.getPageContext().getString(R.string.thread_good_class));
        this.eOx.add(dB);
        dB.setChecked(true);
        this.hVl.addView(dB);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.ahg()) && acVar.ahh() > 0) {
                    CustomBlueCheckRadioButton dB2 = dB(String.valueOf(acVar.ahh()), acVar.ahg());
                    this.eOx.add(dB2);
                    View view = new View(this.hNh.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hNh.getPageContext().getPageActivity(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.hVl.addView(view);
                    this.hVl.addView(dB2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hVs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hNh.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hNh.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hNh.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hVs.setLayoutParams(layoutParams2);
            this.hVs.removeAllViews();
            if (this.hVl != null && this.hVl.getParent() == null) {
                this.hVs.addView(this.hVl);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hVj, this.hNh.getPageContext());
    }

    private CustomBlueCheckRadioButton dB(String str, String str2) {
        Activity pageActivity = this.hNh.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.eOy);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bVq() {
        this.hNh.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hNh.hideProgressBar();
        if (z && z2) {
            this.hNh.showToast(this.hNh.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.hNh.showToast(str);
        }
    }

    public void bCt() {
        this.hVd.setVisibility(0);
    }

    public void bCs() {
        this.hVd.setVisibility(8);
    }

    public View bVr() {
        if (this.hVk != null) {
            return this.hVk.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String bVs() {
        return this.hVo;
    }

    public View getView() {
        return this.aqa;
    }

    public void bVt() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.hNh.getPageContext().getPageActivity(), this.hNh.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hNh.hideProgressBar();
        if (z) {
            bVL();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bVM();
        } else {
            bVL();
        }
    }

    public void bVu() {
        this.fBe.setLineVisible();
        this.fBe.startLoadData();
    }

    public void bVv() {
        this.hNh.hideProgressBar();
        endLoadData();
        this.hUi.completePullRefreshPostDelayed(0L);
        bVG();
    }

    public void bVw() {
        this.hUi.completePullRefreshPostDelayed(0L);
        bVG();
    }

    private void oF(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hUX.setOnLongClickListener(onLongClickListener);
        if (this.hWt != null) {
            this.hWt.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.hLl != null) {
            this.hLl.dismiss();
            this.hLl = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hNh);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hNh.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNh.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNh.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNh.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.at(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hVp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hVp = new com.baidu.tbadk.core.dialog.i(this.hNh.getPageContext(), kVar);
        this.hVp.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.hVp != null) {
            this.hVp.dismiss();
            this.hVp = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hNh);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hNh.getPageContext().getString(R.string.save_to_emotion), kVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNh.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.at(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hVp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hVp = new com.baidu.tbadk.core.dialog.i(this.hNh.getPageContext(), kVar);
        this.hVp.showDialog();
    }

    public int bVx() {
        return wO(this.hUi.getFirstVisiblePosition());
    }

    private int wO(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hUi.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hUi.getAdapter() == null || !(this.hUi.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hUi.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bVy() {
        int lastVisiblePosition = this.hUi.getLastVisiblePosition();
        if (this.hTY != null) {
            if (lastVisiblePosition == this.hUi.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return wO(lastVisiblePosition);
    }

    public void wP(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.hUi != null) {
            if (this.hUe == null || this.hUe.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hUe.mNavigationBar.getFixedNavHeight();
                if (!(this.hNh.bSi() != -1)) {
                    if (this.hVO != null && (layoutParams = (LinearLayout.LayoutParams) this.hVO.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hVO.setLayoutParams(layoutParams);
                    }
                    i--;
                    bWg();
                }
                i2 = fixedNavHeight;
            }
            this.hUi.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hUi.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hUi.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hVa.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hUX.a(dVar, false);
        this.hUX.notifyDataSetChanged();
        bVG();
        if (this.hWt != null) {
            this.hWt.bRz();
        }
        ArrayList<PostData> bQz = dVar.bQz();
        if (dVar.getPage().ahy() == 0 || bQz == null || bQz.size() < dVar.getPage().ahx()) {
            if (com.baidu.tbadk.core.util.v.getCount(bQz) == 0 || (com.baidu.tbadk.core.util.v.getCount(bQz) == 1 && bQz.get(0) != null && bQz.get(0).con() == 1)) {
                if (this.hVT == null || this.hVT.hXd == null || this.hVT.hXd.getView() == null) {
                    i = 0;
                } else {
                    i = this.hVT.hXd.getView().getTop() < 0 ? this.hVT.hXd.getView().getHeight() : this.hVT.hXd.getView().getBottom();
                }
                if (this.hNh.bSG()) {
                    this.fBe.R(this.hNh.getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.fBe.R(this.hNh.getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().ahy() == 0) {
                    this.fBe.setText(this.hNh.getResources().getString(R.string.list_has_no_more));
                } else {
                    this.fBe.setText(this.hNh.getResources().getString(R.string.load_more));
                }
                this.fBe.anK();
            }
        }
        o(dVar);
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        if (this.hUG == null) {
            this.hNh.getLayoutMode().onModeChanged(((ViewStub) this.hUk.findViewById(R.id.praise_layout)).inflate());
            this.hUG = (FrsPraiseView) this.hUk.findViewById(R.id.pb_head_praise_view);
            this.hUG.setIsFromPb(true);
            this.hUV = this.hUk.findViewById(R.id.new_pb_header_item_line_above_praise);
            this.hUG.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hUG != null) {
            boolean bVG = bVG();
            this.hUG.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().ahz() == 0 && this.hNz) {
                if (bVG) {
                    this.hUU.setVisibility(0);
                    return;
                } else {
                    this.hUU.setVisibility(8);
                    return;
                }
            }
            this.hUU.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bQH() != null) {
            return dVar.bQH();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(dVar.bQz())) {
            Iterator<PostData> it = dVar.bQz().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.con() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bQE();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aiE() != null && postData.aiE().getUserTbVipInfoData() != null && postData.aiE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aiE().getGodUserData().setIntro(postData.aiE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bQx() == null || dVar.bQx().aiE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aiE = dVar.bQx().aiE();
        String userId = aiE.getUserId();
        HashMap<String, MetaData> userMap = dVar.bQx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aiE;
        }
        postData.zQ(1);
        postData.setId(dVar.bQx().aiU());
        postData.setTitle(dVar.bQx().getTitle());
        postData.setTime(dVar.bQx().getCreateTime());
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
        com.baidu.tbadk.data.f coq;
        String portrait;
        String charSequence;
        if (dVar != null && dVar.bQx() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hUw.setVisibility(8);
            if (dVar.bQx() != null && dVar.bQx().ajy() && dVar.bQx().aiV() != null) {
                this.hWi = true;
                this.hUe.pa(this.hWi);
                this.hUe.mNavigationBar.hideBottomLine();
                if (this.hTY == null) {
                    this.hTY = new com.baidu.tieba.pb.video.i(this.hNh, this.hUe, dVar.bQx().aiV(), this.hTZ);
                    this.hTY.a(dVar.bQx().aiV(), dVar.bQx(), dVar.getForumId());
                    this.hTY.startPlay();
                } else if (this.hUc) {
                    this.hTY.a(dVar.bQx().aiV(), dVar.bQx(), dVar.getForumId());
                    this.hTY.startPlay();
                } else {
                    this.hTY.Bm(dVar.getForumId());
                }
                com.baidu.tieba.pb.c.a.a(this.hNh.getUniqueId(), dVar, c, 1, 1);
                if (dVar.bQy() != null && dVar.bQy().size() >= 1) {
                    bh bhVar = dVar.bQy().get(0);
                    this.hTY.aB(bhVar);
                    this.hTY.Bn(bhVar.getTitle());
                }
                this.hTY.b(c, dVar.bQx(), dVar.bQU());
                this.hUc = false;
                this.hUi.removeHeaderView(this.hTY.bYc());
                this.hUi.addHeaderView(this.hTY.bYc(), 0);
                if (this.hTY.aJw() != null && this.hTY.aJw().getParent() == null) {
                    this.hVM.addView(this.hTY.aJw());
                }
                if (this.hUa == null) {
                    this.hUa = new com.baidu.tieba.pb.video.h(this.hNh);
                }
                this.hUa.a(dVar.bQx().ajN(), dVar.bQx(), dVar.bQR());
                this.hUi.removeHeaderView(this.hUa.bXQ());
                this.hUi.addHeaderView(this.hUa.bXQ(), 1);
                if (dVar.bQx().ajN() != null) {
                    this.hUi.removeHeaderView(this.hUa.bXR());
                    this.hUi.removeHeaderView(this.hUs);
                    this.hUi.addHeaderView(this.hUa.bXR(), 2);
                } else {
                    if (this.hUa.bXR() != null) {
                        this.hUi.removeHeaderView(this.hUa.bXR());
                    }
                    this.hUi.removeHeaderView(this.hUs);
                    this.hUi.addHeaderView(this.hUs, 2);
                }
                if (this.hTY != null) {
                    this.hUe.oW(false);
                    this.hTY.wW(TbadkCoreApplication.getInst().getSkinType());
                }
                bVC();
            } else {
                this.hWi = false;
                this.hUe.pa(this.hWi);
                if (this.hTY != null) {
                    this.hUi.removeHeaderView(this.hTY.bYc());
                }
                if (this.hUa != null) {
                    this.hUa.b(this.hUi);
                }
            }
            if (this.hNh.bRT() != null) {
                this.hNh.bRT().oU(this.hWi);
            }
            if (this.hTY != null) {
                this.hTY.S(this.hWL);
                bWg();
            }
            if (c != null) {
                this.hVE = c;
                this.hUw.setVisibility(0);
                if (this.hNh.bRt()) {
                    if (dVar.bQw() != null) {
                        this.mForumName = dVar.bQw().getForumName();
                        this.mForumId = dVar.bQw().getForumId();
                    }
                    if (this.mForumName == null && this.hNh.bRD() != null && this.hNh.bRD().bRu() != null) {
                        this.mForumName = this.hNh.bRD().bRu();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hUw.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hUw.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_clip_board, c);
                sparseArray.put(R.id.tag_is_subpb, false);
                if (dVar.bQx().ajy() && dVar.bQx().ajq() != null) {
                    SmartApp ajq = dVar.bQx().ajq();
                    this.hUl.setVisibility(0);
                    this.hUi.removeHeaderView(this.hUl);
                    this.hUi.addHeaderView(this.hUl, 1);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(ajq.avatar)) {
                        this.hUm.startLoad(ajq.avatar, 10, false, false);
                    }
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(ajq.name)) {
                        charSequence = ajq.name + HanziToPinyin.Token.SEPARATOR + ((Object) this.hNh.getText(R.string.smart_app_suffix));
                    } else {
                        charSequence = this.hNh.getText(R.string.intelligent_smart_app).toString();
                    }
                    this.hUn.setText(charSequence);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(ajq._abstract)) {
                        this.hUo.setText(ajq._abstract);
                    } else {
                        this.hUo.setText(this.hNh.getText(R.string.smart_app_default_abstract));
                    }
                    this.hUl.setTag(ajq);
                } else {
                    this.hUl.setVisibility(8);
                    this.hUi.removeHeaderView(this.hUl);
                }
                if (!this.hWA) {
                    this.hUq.setVisibility(0);
                }
                if (!dVar.bQx().ajy() && this.hUr.getText() != null && this.hUr.getText().length() > 0) {
                    this.hUr.setVisibility(0);
                } else {
                    this.hUr.setVisibility(8);
                }
                n(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> aiP = dVar.bQx().aiP();
                if (aiP != null && aiP.size() > 0 && !this.hWA) {
                    this.hVH.setText(String.valueOf(aiP.get(0).agN()));
                    this.hVG.setVisibility(0);
                } else {
                    this.hVG.setVisibility(8);
                }
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hVG, R.drawable.activity_join_num_bg);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hVH, R.color.cp_link_tip_d, 1);
                if (c.aiE() != null) {
                    String string = c.aiE().getName_show() == null ? StringUtils.string(c.aiE().getUserName()) : StringUtils.string(c.aiE().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(c.aiE().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.byteLength(c.aiE().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.byteLength(string) > 12) {
                            cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                            ArrayList<IconData> iconInfo = c.aiE().getIconInfo();
                            tShowInfoNew = c.aiE().getTShowInfoNew();
                            if (this.hOw != null) {
                                this.hOw.setTag(R.id.tag_user_id, c.aiE().getUserId());
                                this.hOw.setOnClickListener(this.hNh.hLg.hYC);
                                this.hOw.a(iconInfo, 4, this.hNh.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNh.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNh.getResources().getDimensionPixelSize(R.dimen.tbds12));
                            }
                            if (this.hOv != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hOv.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hOv.setOnClickListener(this.hNh.hLg.hYD);
                                this.hOv.a(tShowInfoNew, 3, this.hNh.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNh.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNh.getResources().getDimensionPixelSize(R.dimen.ds12), true);
                            }
                            this.hUy.setText(bV(c.aiE().getSealPrefix(), cutChineseAndEnglishWithSuffix));
                            this.hUy.setTag(R.id.tag_user_id, c.aiE().getUserId());
                            this.hUy.setTag(R.id.tag_user_name, c.aiE().getName_show());
                            if (com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || c.aiE().isBigV()) {
                                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUy, R.color.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUy, R.color.cp_cont_b, 1);
                            }
                            if (c.aiE() == null) {
                                MetaData aiE = c.aiE();
                                if (aiE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aiE.getBawu_type())) {
                                    this.hUz.setText(R.string.bawu_member_bazhu_tip);
                                    this.hUz.setVisibility(0);
                                    this.hWy = R.drawable.author_bazhu_bg;
                                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.hUz, this.hWy);
                                } else if (aiE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aiE.getBawu_type())) {
                                    this.hUz.setText(R.string.bawu_member_xbazhu_tip);
                                    this.hUz.setVisibility(0);
                                    this.hWy = R.drawable.author_small_bazhu;
                                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.hUz, this.hWy);
                                } else {
                                    this.hUz.setVisibility(8);
                                }
                            } else {
                                this.hUz.setVisibility(8);
                            }
                            if (dVar.bQx().aiE() != null && dVar.bQx().aiE().getAlaUserData() != null && this.hUE != null) {
                                if (dVar.bQx().aiE().getAlaUserData().anchor_live != 0) {
                                    this.hUE.setVisibility(8);
                                } else {
                                    this.hUE.setVisibility(0);
                                    if (this.hUb == null) {
                                        this.hUb = new com.baidu.tieba.c.d(this.hNh.getPageContext(), this.hUE);
                                        this.hUb.pf(1);
                                    }
                                    this.hUb.R(this.hNh.getResources().getString(R.string.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_VIDEO_PB_ALA_TAIL_LIGHT_TIPS));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bTc = dVar.bQx().aiE().getAlaUserData();
                                    aVar.type = 2;
                                    this.hUE.setTag(aVar);
                                }
                            }
                            this.hUD.setUserId(c.aiE().getUserId());
                            this.hUD.setUserName(c.aiE().getUserName());
                            this.hUD.setTid(c.getId());
                            this.hUD.setFid(this.hQG == null ? this.hQG.getForumId() : "");
                            this.hUD.setImageDrawable(null);
                            this.hUD.setRadius(com.baidu.adp.lib.util.l.getDimens(this.hNh.getActivity(), R.dimen.ds40));
                            this.hUD.setTag(c.aiE().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hUL.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(c.getTime()));
                            } else {
                                this.hUL.setText(com.baidu.tbadk.core.util.aq.getFormatTime(c.getTime()));
                            }
                            coq = c.coq();
                            if (coq == null && !TextUtils.isEmpty(coq.getName()) && !TextUtils.isEmpty(coq.getName().trim())) {
                                this.hUM.setVisibility(0);
                                this.hUN.setVisibility(0);
                                this.hUM.setText(coq.getName());
                            } else {
                                this.hUM.setVisibility(8);
                                this.hUN.setVisibility(8);
                            }
                            portrait = c.aiE().getPortrait();
                            if (c.aiE().getPendantData() == null && !StringUtils.isNull(c.aiE().getPendantData().ahd())) {
                                this.hUB.b(c.aiE());
                                this.hUD.setVisibility(8);
                                this.hUB.setVisibility(0);
                                if (this.hUH != null) {
                                    this.hUH.setVisibility(8);
                                }
                                this.hUy.setOnClickListener(this.hWL);
                                this.hUB.getHeadView().startLoad(portrait, 28, false);
                                this.hUB.getHeadView().setUserId(c.aiE().getUserId());
                                this.hUB.getHeadView().setUserName(c.aiE().getUserName());
                                this.hUB.getHeadView().setTid(c.getId());
                                this.hUB.getHeadView().setFid(this.hQG != null ? this.hQG.getForumId() : "");
                                this.hUB.getHeadView().setOnClickListener(this.hWL);
                                this.hUB.ou(c.aiE().getPendantData().ahd());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hUD, c.aiE());
                                this.hUD.setVisibility(0);
                                this.hUw.setOnClickListener(this.hWL);
                                this.hUy.setOnClickListener(this.hWL);
                                this.hUD.setOnClickListener(this.hWL);
                                this.hUB.setVisibility(8);
                                this.hUD.startLoad(portrait, 28, false);
                            }
                            String name_show = c.aiE().getName_show();
                            String userName = c.aiE().getUserName();
                            if (com.baidu.tbadk.t.as.isOn() && name_show != null && !name_show.equals(userName)) {
                                this.hUy.setText(com.baidu.tieba.pb.c.aI(this.hNh.getPageContext().getPageActivity(), this.hUy.getText().toString()));
                                this.hUy.setGravity(16);
                                this.hUy.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bQe());
                                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUy, R.color.cp_other_e, 1);
                            }
                        }
                        cutChineseAndEnglishWithSuffix = string;
                        ArrayList<IconData> iconInfo2 = c.aiE().getIconInfo();
                        tShowInfoNew = c.aiE().getTShowInfoNew();
                        if (this.hOw != null) {
                        }
                        if (this.hOv != null) {
                        }
                        this.hUy.setText(bV(c.aiE().getSealPrefix(), cutChineseAndEnglishWithSuffix));
                        this.hUy.setTag(R.id.tag_user_id, c.aiE().getUserId());
                        this.hUy.setTag(R.id.tag_user_name, c.aiE().getName_show());
                        if (com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.hUy, R.color.cp_cont_h, 1);
                        if (c.aiE() == null) {
                        }
                        if (dVar.bQx().aiE() != null) {
                            if (dVar.bQx().aiE().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hUD.setUserId(c.aiE().getUserId());
                        this.hUD.setUserName(c.aiE().getUserName());
                        this.hUD.setTid(c.getId());
                        this.hUD.setFid(this.hQG == null ? this.hQG.getForumId() : "");
                        this.hUD.setImageDrawable(null);
                        this.hUD.setRadius(com.baidu.adp.lib.util.l.getDimens(this.hNh.getActivity(), R.dimen.ds40));
                        this.hUD.setTag(c.aiE().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        coq = c.coq();
                        if (coq == null) {
                        }
                        this.hUM.setVisibility(8);
                        this.hUN.setVisibility(8);
                        portrait = c.aiE().getPortrait();
                        if (c.aiE().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hUD, c.aiE());
                        this.hUD.setVisibility(0);
                        this.hUw.setOnClickListener(this.hWL);
                        this.hUy.setOnClickListener(this.hWL);
                        this.hUD.setOnClickListener(this.hWL);
                        this.hUB.setVisibility(8);
                        this.hUD.startLoad(portrait, 28, false);
                        String name_show2 = c.aiE().getName_show();
                        String userName2 = c.aiE().getUserName();
                        if (com.baidu.tbadk.t.as.isOn()) {
                            this.hUy.setText(com.baidu.tieba.pb.c.aI(this.hNh.getPageContext().getPageActivity(), this.hUy.getText().toString()));
                            this.hUy.setGravity(16);
                            this.hUy.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bQe());
                            com.baidu.tbadk.core.util.am.setViewTextColor(this.hUy, R.color.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.byteLength(string) > 14) {
                            cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                            ArrayList<IconData> iconInfo22 = c.aiE().getIconInfo();
                            tShowInfoNew = c.aiE().getTShowInfoNew();
                            if (this.hOw != null) {
                            }
                            if (this.hOv != null) {
                            }
                            this.hUy.setText(bV(c.aiE().getSealPrefix(), cutChineseAndEnglishWithSuffix));
                            this.hUy.setTag(R.id.tag_user_id, c.aiE().getUserId());
                            this.hUy.setTag(R.id.tag_user_name, c.aiE().getName_show());
                            if (com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.am.setViewTextColor(this.hUy, R.color.cp_cont_h, 1);
                            if (c.aiE() == null) {
                            }
                            if (dVar.bQx().aiE() != null) {
                            }
                            this.hUD.setUserId(c.aiE().getUserId());
                            this.hUD.setUserName(c.aiE().getUserName());
                            this.hUD.setTid(c.getId());
                            this.hUD.setFid(this.hQG == null ? this.hQG.getForumId() : "");
                            this.hUD.setImageDrawable(null);
                            this.hUD.setRadius(com.baidu.adp.lib.util.l.getDimens(this.hNh.getActivity(), R.dimen.ds40));
                            this.hUD.setTag(c.aiE().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            coq = c.coq();
                            if (coq == null) {
                            }
                            this.hUM.setVisibility(8);
                            this.hUN.setVisibility(8);
                            portrait = c.aiE().getPortrait();
                            if (c.aiE().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hUD, c.aiE());
                            this.hUD.setVisibility(0);
                            this.hUw.setOnClickListener(this.hWL);
                            this.hUy.setOnClickListener(this.hWL);
                            this.hUD.setOnClickListener(this.hWL);
                            this.hUB.setVisibility(8);
                            this.hUD.startLoad(portrait, 28, false);
                            String name_show22 = c.aiE().getName_show();
                            String userName22 = c.aiE().getUserName();
                            if (com.baidu.tbadk.t.as.isOn()) {
                            }
                        }
                        cutChineseAndEnglishWithSuffix = string;
                        ArrayList<IconData> iconInfo222 = c.aiE().getIconInfo();
                        tShowInfoNew = c.aiE().getTShowInfoNew();
                        if (this.hOw != null) {
                        }
                        if (this.hOv != null) {
                        }
                        this.hUy.setText(bV(c.aiE().getSealPrefix(), cutChineseAndEnglishWithSuffix));
                        this.hUy.setTag(R.id.tag_user_id, c.aiE().getUserId());
                        this.hUy.setTag(R.id.tag_user_name, c.aiE().getName_show());
                        if (com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.hUy, R.color.cp_cont_h, 1);
                        if (c.aiE() == null) {
                        }
                        if (dVar.bQx().aiE() != null) {
                        }
                        this.hUD.setUserId(c.aiE().getUserId());
                        this.hUD.setUserName(c.aiE().getUserName());
                        this.hUD.setTid(c.getId());
                        this.hUD.setFid(this.hQG == null ? this.hQG.getForumId() : "");
                        this.hUD.setImageDrawable(null);
                        this.hUD.setRadius(com.baidu.adp.lib.util.l.getDimens(this.hNh.getActivity(), R.dimen.ds40));
                        this.hUD.setTag(c.aiE().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        coq = c.coq();
                        if (coq == null) {
                        }
                        this.hUM.setVisibility(8);
                        this.hUN.setVisibility(8);
                        portrait = c.aiE().getPortrait();
                        if (c.aiE().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hUD, c.aiE());
                        this.hUD.setVisibility(0);
                        this.hUw.setOnClickListener(this.hWL);
                        this.hUy.setOnClickListener(this.hWL);
                        this.hUD.setOnClickListener(this.hWL);
                        this.hUB.setVisibility(8);
                        this.hUD.startLoad(portrait, 28, false);
                        String name_show222 = c.aiE().getName_show();
                        String userName222 = c.aiE().getUserName();
                        if (com.baidu.tbadk.t.as.isOn()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hUv.at(dVar.bQx());
                }
                if (this.hVP != null) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hIQ);
                    if (dVar != null && dVar.bQx() != null) {
                        iVar.hIS = dVar.bQx().aiv();
                    }
                    iVar.isNew = !this.hNz;
                    iVar.sortType = dVar.hIw;
                    if (dVar.hIv != null && dVar.hIv.size() > dVar.hIw) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hIv.size()) {
                                break;
                            } else if (dVar.hIv.get(i4).sort_type.intValue() != dVar.hIw) {
                                i3 = i4 + 1;
                            } else {
                                iVar.hIU = dVar.hIv.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    iVar.hIV = this.hNh.bSG();
                    this.hVP.a(iVar);
                }
                if (dVar != null && dVar.bQx() != null) {
                    ae(dVar.bQx().aiA() == 1, dVar.bQx().aiz() == 1);
                }
                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hUX != null && aq.this.hUe != null && aq.this.hUe.hZC != null && aq.this.hQG != null && aq.this.hQG.bQx() != null && !aq.this.hQG.bQx().ajy() && !aq.this.bVF() && aq.this.hQG.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(aq.this.hQG.getForum().getName())) {
                            if (aq.this.hUX.bTg() == null || !aq.this.hUX.bTg().isShown()) {
                                aq.this.hUe.hZC.setVisibility(0);
                                if (aq.this.hNh != null && aq.this.hNh.bRD() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.bS("tid", aq.this.hNh.bRD().bTy());
                                    anVar.bS("fid", aq.this.hNh.bRD().getForumId());
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
            bVz();
        } else {
            beG();
        }
        this.hVT.hXd = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.hVT));
        a(this.hVT.hXd, false);
    }

    public void bVz() {
        if (this.hUe != null && !this.hWk) {
            this.hUe.pb(!StringUtils.isNull(this.hNh.bSf()));
            this.hWk = true;
        }
    }

    public void beG() {
        if (this.hUe != null) {
            this.hUe.bWN();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.aiZ() != null) {
            this.hUx.setData(this.hNh.getPageContext(), dVar.bQz().get(0).aiZ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bQx().getId(), this.hNh.bSD() ? "FRS" : null));
            this.hUw.setPadding(this.hUw.getPaddingLeft(), (int) this.hNh.getResources().getDimension(R.dimen.ds20), this.hUw.getPaddingRight(), this.hUw.getPaddingBottom());
            return;
        }
        this.hUx.setData(null, null, null);
    }

    public void bVA() {
        if (this.hTY != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11997").O("obj_type", 1));
            this.hTY.bYa();
            this.hUi.smoothScrollToPosition(0);
        }
    }

    public boolean bVB() {
        return this.dNt;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean av(bh bhVar) {
        if (bhVar == null || bhVar.aiE() == null || bhVar.aiE().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.aiE().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.hUe.bWL();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hUe.yK(cVar.forumName);
            }
            String string = this.hNh.getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.toInt(cVar.source, 0)) {
                case 100:
                    str = this.hNh.getResources().getString(R.string.self);
                    break;
                case 300:
                    str = this.hNh.getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = this.hNh.getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hHP;
            this.hNh.showNetRefreshView(this.aqa, format, null, this.hNh.getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.amO().b(aq.this.hNh.getPageContext(), new String[]{str2});
                        aq.this.hNh.finish();
                        return;
                    }
                    aq.this.hNh.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bUJ;
        Parcelable bUJ2;
        if (dVar != null) {
            this.hQG = dVar;
            this.mType = i;
            if (dVar.bQx() != null) {
                this.hVV = dVar.bQx().aim();
                if (dVar.bQx().getAnchorLevel() != 0) {
                    this.dNt = true;
                }
                this.hVr = av(dVar.bQx());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.hVF = false;
            this.hNz = z;
            bVv();
            if (dVar.hIx != null && dVar.hIx.bQY()) {
                if (this.hUj == null) {
                    this.hUj = new PbThreadPostView(this.hNh);
                    this.hUi.addHeaderView(this.hUj, 1);
                    this.hUj.setData(dVar);
                    this.hUj.setChildOnClickLinstener(this.fwH);
                }
            } else if (this.hUj != null && this.hUi != null) {
                this.hUi.removeHeaderView(this.hUj);
            }
            b(dVar, z, i);
            p(dVar);
            if (this.hWw == null) {
                this.hWw = new ac(this.hNh.getPageContext(), this.fTC);
            }
            this.hWw.AR(dVar.bQC());
            if (this.hNh.bSu()) {
                if (this.hVb == null) {
                    this.hVb = new com.baidu.tieba.pb.view.c(this.hNh.getPageContext());
                    this.hVb.createView();
                    this.hVb.setListPullRefreshListener(this.cpa);
                }
                this.hUi.setPullRefresh(this.hVb);
                bVC();
                if (this.hVb != null) {
                    this.hVb.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().ahz() == 0 && z) {
                this.hUi.setPullRefresh(null);
            } else {
                if (this.hVb == null) {
                    this.hVb = new com.baidu.tieba.pb.view.c(this.hNh.getPageContext());
                    this.hVb.createView();
                    this.hVb.setListPullRefreshListener(this.cpa);
                }
                this.hUi.setPullRefresh(this.hVb);
                bVC();
                if (this.hVb != null) {
                    this.hVb.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                aVU();
            }
            bVG();
            this.hUX.nU(this.hNz);
            this.hUX.nV(false);
            this.hUX.og(i == 5);
            this.hUX.oh(i == 6);
            this.hUX.oi(z2 && this.hWK);
            this.hUX.a(dVar, false);
            this.hUX.notifyDataSetChanged();
            if (this.hNh.bRt()) {
                this.hWm = 0;
                PostData c = c(dVar, z);
                if (c != null && c.aiE() != null) {
                    this.hWm = c.aiE().getLevel_id();
                }
                if (this.hWm > 0) {
                    this.hUA.setVisibility(0);
                    com.baidu.tbadk.core.util.am.setImageResource(this.hUA, BitmapHelper.getGradeResourceIdInEnterForum(this.hWm));
                } else {
                    this.hUA.setVisibility(8);
                }
            } else {
                this.hUA.setVisibility(8);
            }
            if (dVar.bQx() != null && dVar.bQx().aiq() != null) {
                if (dVar.bQx().aiq().getNum() < 1) {
                    this.hNh.getResources().getString(R.string.zan);
                } else {
                    String str = dVar.bQx().aiq().getNum() + "";
                }
                if (this.hTX != -1) {
                    dVar.bQx().aiq().setIsLike(this.hTX);
                }
            }
            if (this.hNh.isLogin()) {
                this.hUi.setNextPage(this.fBe);
                this.hUd = 2;
                aVU();
            } else {
                this.hVF = true;
                if (dVar.getPage().ahy() == 1) {
                    if (this.hVc == null) {
                        this.hVc = new com.baidu.tieba.pb.view.a(this.hNh.getPageContext());
                    }
                    this.hUi.setNextPage(this.hVc);
                } else {
                    this.hUi.setNextPage(this.fBe);
                }
                this.hUd = 3;
            }
            ArrayList<PostData> bQz = dVar.bQz();
            if (dVar.getPage().ahy() == 0 || bQz == null || bQz.size() < dVar.getPage().ahx()) {
                if (com.baidu.tbadk.core.util.v.getCount(bQz) == 0 || (com.baidu.tbadk.core.util.v.getCount(bQz) == 1 && bQz.get(0) != null && bQz.get(0).con() == 1)) {
                    if (this.hVT == null || this.hVT.hXd == null || this.hVT.hXd.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hVT.hXd.getView().getTop() < 0 ? this.hVT.hXd.getView().getHeight() : this.hVT.hXd.getView().getBottom();
                    }
                    if (this.hNh.bSG()) {
                        this.fBe.R(this.hNh.getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.fBe.R(this.hNh.getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.hNh.bRT() != null && !this.hNh.bRT().bWz()) {
                        this.hNh.bRT().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().ahy() == 0) {
                        this.fBe.setText(this.hNh.getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.fBe.setText(this.hNh.getResources().getString(R.string.load_more));
                    }
                    this.fBe.anK();
                }
                bVP();
            } else {
                if (z2) {
                    if (this.hWK) {
                        endLoadData();
                        if (dVar.getPage().ahy() != 0) {
                            this.fBe.setText(this.hNh.getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.fBe.setLineVisible();
                        this.fBe.showLoading();
                    }
                } else {
                    this.fBe.setLineVisible();
                    this.fBe.showLoading();
                }
                this.fBe.anK();
            }
            switch (i) {
                case 2:
                    this.hUi.setSelection(i2 > 1 ? (((this.hUi.getData() == null && dVar.bQz() == null) ? 0 : (this.hUi.getData().size() - dVar.bQz().size()) + this.hUi.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bUJ2 = aj.bUI().bUJ()) != null) {
                        this.hUi.onRestoreInstanceState(bUJ2);
                        if (com.baidu.tbadk.core.util.v.getCount(bQz) > 1 && dVar.getPage().ahy() > 0) {
                            this.fBe.endLoadData();
                            this.fBe.setText(this.hNh.getString(R.string.pb_load_more_without_point));
                            this.fBe.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hWK = false;
                    break;
                case 5:
                    this.hUi.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bUJ = aj.bUI().bUJ()) != null) {
                        this.hUi.onRestoreInstanceState(bUJ);
                        break;
                    } else {
                        this.hUi.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.hTY != null && this.hTY.aJw() != null) {
                            if (this.hNh.isUseStyleImmersiveSticky()) {
                                this.hUi.setSelectionFromTop((this.hUX.bTb() + this.hUi.getHeaderViewsCount()) - 1, this.hTY.aJw().getHeight() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.hNh.getPageContext().getPageActivity()));
                            } else {
                                this.hUi.setSelectionFromTop((this.hUX.bTb() + this.hUi.getHeaderViewsCount()) - 1, this.hTY.aJw().getHeight());
                            }
                        } else {
                            this.hUi.setSelection(this.hUX.bTb() + this.hUi.getHeaderViewsCount());
                        }
                    } else {
                        this.hUi.setSelection(i2 > 0 ? ((this.hUi.getData() == null && dVar.bQz() == null) ? 0 : (this.hUi.getData().size() - dVar.bQz().size()) + this.hUi.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.fBe.endLoadData();
                    this.fBe.setText(this.hNh.getString(R.string.pb_load_more_without_point));
                    this.fBe.setLineGone();
                    break;
            }
            if (this.hVV == hVW && isHost()) {
                bVX();
            }
            if (this.hWg) {
                bUT();
                this.hWg = false;
                if (i3 == 0) {
                    oA(true);
                }
            }
            if (this.hUa != null) {
                this.hUa.aA(dVar.bQx());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hIt == 1 || dVar.hIu == 1) {
                if (this.hWn == null) {
                    this.hWn = new PbTopTipView(this.hNh);
                }
                if (dVar.hIu == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hNh.getStType())) {
                    this.hWn.setText(this.hNh.getString(R.string.pb_read_strategy_add_experience));
                    this.hWn.a(this.aqa, this.mSkinType);
                } else if (dVar.hIt == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hNh.getStType())) {
                    this.hWn.setText(this.hNh.getString(R.string.pb_read_news_add_experience));
                    this.hWn.a(this.aqa, this.mSkinType);
                }
            }
            o(dVar);
        }
    }

    private void o(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQx() != null) {
            if (dVar.afk()) {
                SvgManager.amL().a(this.hVy, R.drawable.icon_mask_pb_bottom_collect_h_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.amL().a(this.hVy, R.drawable.icon_pure_pb_bottom_collect_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.hVA.setText(wQ(dVar.bQx().aiv()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, dVar.bQx()));
        }
    }

    private String wQ(int i) {
        if (i == 0) {
            return this.hNh.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void bVC() {
        if (this.hTY != null && this.hTY.aJw() != null) {
            this.hUi.removeHeaderView(this.textView);
            if (this.mType != 1) {
                this.hUi.removeHeaderView(this.hTY.bYc());
                this.hUi.addHeaderView(this.hTY.bYc(), 0);
                return;
            }
            return;
        }
        if (this.hTY != null) {
            this.hUi.removeHeaderView(this.hTY.bYc());
        }
        this.hUi.removeHeaderView(this.textView);
        this.hUi.addHeaderView(this.textView, 0);
    }

    public void oH(boolean z) {
        this.hVq = z;
    }

    public void endLoadData() {
        if (this.fBe != null) {
            this.fBe.setLineGone();
            this.fBe.endLoadData();
        }
        aVU();
    }

    public void aMo() {
        this.hUi.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hVE != null && this.hVE.aiE() != null && this.hUe != null) {
            this.hWj = !this.hWi;
            this.hUe.oW(this.hWj);
            if (this.hNh.bRT() != null) {
                this.hNh.bRT().oV(this.hWj);
            }
            bVD();
            if (this.hNh != null && !this.hNh.bRt() && !com.baidu.tbadk.core.util.v.isEmpty(dVar.bQS())) {
                bd bdVar = dVar.bQS().get(0);
                if (bdVar != null) {
                    this.hUe.dC(bdVar.getForumName(), bdVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hUe.dC(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hWj) {
                if (this.hVr) {
                    this.hUI.setVisibility(8);
                    this.hUK.setVisibility(0);
                    this.hUK.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.numberUniformFormatExtra(dVar.bQT())));
                }
                if (this.hVO != null) {
                    this.hVO.setVisibility(8);
                }
                if (this.hWu == null) {
                    this.hWu = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hWl) {
                                aq.this.bVW();
                            }
                            aq.this.bVw();
                        }
                    };
                }
                this.hUi.setListViewDragListener(this.hWu);
            } else {
                if (this.hVO != null) {
                    this.hVO.setVisibility(0);
                }
                if (this.hVr) {
                    this.hUI.setVisibility(8);
                    this.hUK.setVisibility(0);
                    this.hUK.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.numberUniformFormatExtra(dVar.bQT())));
                } else if (!com.baidu.tbadk.t.au.axi() || (this.hVE.aiE().hadConcerned() && this.hVE.aiE().getGodUserData() != null && this.hVE.aiE().getGodUserData().getIsFromNetWork())) {
                    this.hUI.setVisibility(8);
                    this.hUK.setVisibility(8);
                } else {
                    this.hUK.setVisibility(8);
                }
                this.hWu = null;
                this.hUi.setListViewDragListener(null);
            }
            if (dVar.hIC) {
                this.hUI.setVisibility(8);
            }
        }
    }

    private void bVD() {
        String threadId = this.hQG != null ? this.hQG.getThreadId() : "";
        int bVE = bVE();
        if (this.hWj && this.hVE != null && this.hVE.aiE() != null) {
            this.hVE.aiE().setIsLike(this.hVE.aiE().hadConcerned());
        }
        if (this.hUJ == null) {
            this.hUJ = new ao(this.hNh.getPageContext(), this.hUI, 1);
            this.hUJ.j(this.hNh.getUniqueId());
            this.hUJ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void ex(boolean z) {
                    if (aq.this.hNh != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hNh, (int) R.string.attention_success);
                    }
                }
            });
        }
        if (this.hVE != null && this.hVE.aiE() != null) {
            this.hVE.aiE().setIsLike(this.hVE.aiE().hadConcerned());
            this.hUJ.a(this.hVE.aiE());
            this.hUJ.setTid(threadId);
        }
        this.hUJ.hTT = this.hWi;
        this.hUJ.wN(bVE);
    }

    public int bVE() {
        if (this.hQG == null || this.hQG.bQx() == null) {
            return 0;
        }
        if (this.hQG.bQx().ajV()) {
            return (com.baidu.tbadk.core.util.v.isEmpty(this.hQG.bQS()) && (this.hQG.bQw() == null || StringUtils.isNull(this.hQG.bQw().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bVF() {
        return this.hQG == null || this.hQG.getForum() == null || "0".equals(this.hQG.getForum().getId()) || "me0407".equals(this.hQG.getForum().getName());
    }

    private boolean bVG() {
        boolean z;
        if (this.hVu != null && this.hVu.getVisibility() == 0) {
            if (this.hUT != null) {
                this.hUT.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hUT != null) {
                this.hUT.setVisibility(8);
            }
            z = false;
        }
        if ((this.hUV == null || this.hUV.getVisibility() == 8) && z && this.hNz) {
            this.hUU.setVisibility(0);
        } else {
            this.hUU.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bQx() == null) {
            return false;
        }
        if (dVar.bQx().aiB() == 1 || dVar.bQx().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bQx().aiD() == null || dVar.bQx().aiD().akD() == 0) || dVar.bQx().aiz() == 1 || dVar.bQx().aiA() == 1 || dVar.bQx().ajp() || dVar.bQx().ajE() || dVar.bQx().ajx() || dVar.bQx().aiQ() != null || !com.baidu.tbadk.core.util.aq.isEmpty(dVar.bQx().getCategory()) || dVar.bQx().aiH() || dVar.bQx().aiG();
    }

    private SpannableStringBuilder bV(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hNh.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hUq != null) {
                if (dVar.bQx() != null && dVar.bQx().aiT() == 0 && !dVar.bQx().ajy() && !this.hWA) {
                    this.hUq.setVisibility(0);
                    if (dVar.bQx() != null) {
                        bh bQx = dVar.bQx();
                        bQx.q(true, q(dVar));
                        bQx.hG(3);
                        bQx.mY("2");
                    }
                    SpannableStringBuilder ajk = dVar.bQx().ajk();
                    this.hUr.setOnTouchListener(new com.baidu.tieba.view.k(ajk));
                    this.hUr.setText(ajk);
                    this.hUr.setVisibility(0);
                } else if (dVar.bQx().aiT() == 1) {
                    if (dVar.bQx() != null) {
                        this.hUq.setVisibility(8);
                        this.hUi.removeHeaderView(this.hUq);
                    }
                } else {
                    this.hUq.setVisibility(8);
                    this.hUi.removeHeaderView(this.hUq);
                    if (dVar.bQx() != null && dVar.bQx().ajy()) {
                        this.hUw.setPadding(this.hUw.getPaddingLeft(), 0, this.hUw.getPaddingRight(), this.hUw.getPaddingBottom());
                        if (this.hUO != null) {
                            ((RelativeLayout.LayoutParams) this.hUO.getLayoutParams()).height = (int) this.hNh.getResources().getDimension(R.dimen.tbds36);
                            this.hUO.requestLayout();
                        }
                        if (this.hUP != null) {
                            ((RelativeLayout.LayoutParams) this.hUP.getLayoutParams()).height = (int) this.hNh.getResources().getDimension(R.dimen.tbds0);
                            this.hUP.requestLayout();
                        }
                    } else {
                        this.hUw.setPadding(this.hUw.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(this.hNh.getPageContext().getPageActivity(), R.dimen.ds48), this.hUw.getPaddingRight(), this.hUw.getPaddingBottom());
                    }
                }
            }
            if (dVar.bQx() != null) {
                ad(dVar.bQx().aiA() == 1, dVar.bQx().aiz() == 1);
            }
            this.hNz = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bVG();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData c;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (dVar != null && (c = c(dVar, z)) != null) {
            String userId = c.aiE().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bQJ()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (c.aiE() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, c.aiE().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, c.aiE().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, c.aiE().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, c.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bQJ()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bd> bQS = dVar.bQS();
                if (com.baidu.tbadk.core.util.v.getCount(bQS) > 0) {
                    sb = new StringBuilder();
                    for (bd bdVar : bQS) {
                        if (bdVar != null && !StringUtils.isNull(bdVar.getForumName()) && (vVar = bdVar.cak) != null && vVar.bYd && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bdVar.getForumName(), 12)).append(this.hNh.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.hNh.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View bVH() {
        return this.cKJ;
    }

    public boolean bVI() {
        if (this.aqJ == null || this.aqJ.getParent() == null || this.fBe.isLoading()) {
            return false;
        }
        int bottom = this.aqJ.getBottom();
        Rect rect = new Rect();
        this.aqJ.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void AS(String str) {
        if (this.fBe != null) {
            this.fBe.setText(str);
        }
    }

    public void AT(String str) {
        if (this.fBe != null) {
            int i = 0;
            if (this.hVT != null && this.hVT.hXd != null && this.hVT.hXd.getView() != null) {
                i = this.hVT.hXd.getView().getTop() < 0 ? this.hVT.hXd.getView().getHeight() : this.hVT.hXd.getView().getBottom();
            }
            this.fBe.R(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hUi;
    }

    public int bVJ() {
        return R.id.richText;
    }

    public TextView bRP() {
        return this.hUv.bRP();
    }

    public void d(BdListView.e eVar) {
        this.hUi.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.cpa = cVar;
        if (this.hVb != null) {
            this.hVb.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int ahw = anVar.ahw();
            int aht = anVar.aht();
            if (this.hUY != null) {
                this.hUY.akM();
            } else {
                this.hUY = new com.baidu.tbadk.core.dialog.a(this.hNh.getPageContext().getPageActivity());
                this.hUZ = LayoutInflater.from(this.hNh.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.hUY.aM(this.hUZ);
                this.hUY.a(R.string.dialog_ok, bVar);
                this.hUY.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bVL();
                        aVar.dismiss();
                    }
                });
                this.hUY.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hWd == null) {
                            aq.this.hWd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hNh.HidenSoftKeyPad((InputMethodManager) aq.this.hNh.getSystemService("input_method"), aq.this.aqa);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fZ().postDelayed(aq.this.hWd, 150L);
                    }
                });
                this.hUY.b(this.hNh.getPageContext()).akM();
            }
            this.hVa = (EditText) this.hUZ.findViewById(R.id.input_page_number);
            this.hVa.setText("");
            TextView textView = (TextView) this.hUZ.findViewById(R.id.current_page_number);
            if (ahw <= 0) {
                ahw = 1;
            }
            if (aht <= 0) {
                aht = 1;
            }
            textView.setText(MessageFormat.format(this.hNh.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(ahw), Integer.valueOf(aht)));
            this.hNh.ShowSoftKeyPadDelay(this.hVa, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hUi.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hNh.showToast(str);
    }

    public boolean oI(boolean z) {
        if (this.CJ == null || !this.CJ.atZ()) {
            return false;
        }
        this.CJ.asA();
        return true;
    }

    public void bVK() {
        if (this.hWM != null) {
            while (this.hWM.size() > 0) {
                TbImageView remove = this.hWM.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bVK();
        this.hUX.wx(1);
        if (this.hTY != null) {
            this.hTY.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.hUX.wx(2);
        if (this.hTY != null) {
            this.hTY.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.hNh) && !TbSingleton.getInstance().isCutoutScreen(this.hNh)) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hWf != null) {
            this.hWf.destroy();
        }
        if (this.hWw != null) {
            this.hWw.onDestory();
        }
        if (this.hWn != null) {
            this.hWn.hide();
        }
        if (this.hUb != null) {
            this.hUb.uQ();
        }
        if (this.hUa != null) {
            this.hUa.onDestroy();
        }
        this.hNh.hideProgressBar();
        if (this.faF != null && this.fsc != null) {
            this.faF.b(this.fsc);
        }
        bVL();
        endLoadData();
        if (this.hWd != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hWd);
        }
        if (this.hUw != null && this.hUH != null) {
            this.hUw.removeView(this.hUC);
            this.hUH = null;
        }
        if (this.hVJ != null) {
            this.hVJ.clearStatus();
        }
        this.hWG = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hUX.wx(3);
        if (this.apj != null) {
            this.apj.setBackgroundDrawable(null);
        }
        if (this.hTY != null) {
            this.hTY.destroy();
        }
        if (this.hUX != null) {
            this.hUX.onDestroy();
        }
        this.hUi.setOnLayoutListener(null);
        if (this.hWs != null) {
            this.hWs.bmt();
        }
        if (this.hVU != null) {
            this.hVU.onDestroy();
        }
    }

    public boolean wR(int i) {
        if (this.hTY != null) {
            return this.hTY.qO(i);
        }
        return false;
    }

    public void bVL() {
        this.hUe.ZD();
        if (this.hUb != null) {
            this.hUb.uQ();
        }
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.hNh.getPageContext().getPageActivity(), this.hVa);
        bUV();
        if (this.hLl != null) {
            this.hLl.dismiss();
        }
        bVN();
        if (this.hUa != null) {
            this.hUa.bXS();
        }
        if (this.hUY != null) {
            this.hUY.dismiss();
        }
        if (this.fwG != null) {
            this.fwG.dismiss();
        }
    }

    public void bVM() {
        this.hUe.ZD();
        if (this.hUb != null) {
            this.hUb.uQ();
        }
        if (this.hLl != null) {
            this.hLl.dismiss();
        }
        bVN();
        if (this.hUa != null) {
            this.hUa.bXS();
        }
        if (this.hUY != null) {
            this.hUY.dismiss();
        }
        if (this.fwG != null) {
            this.fwG.dismiss();
        }
    }

    public void dW(List<String> list) {
        this.hWr = list;
        if (this.hWs != null) {
            this.hWs.setData(list);
        }
    }

    public void nT(boolean z) {
        this.hUX.nT(z);
    }

    public void oJ(boolean z) {
        this.hVt = z;
    }

    public void bVN() {
        if (this.hVh != null) {
            this.hVh.dismiss();
        }
        if (this.hVi != null) {
            com.baidu.adp.lib.g.g.b(this.hVi, this.hNh.getPageContext());
        }
        if (this.hVj != null) {
            com.baidu.adp.lib.g.g.b(this.hVj, this.hNh.getPageContext());
        }
        if (this.hVf != null) {
            this.hVf.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hQG, this.hNz);
            d(this.hQG, this.hNz, this.mType);
            this.hNh.getLayoutMode().setNightMode(i == 1);
            this.hNh.getLayoutMode().onModeChanged(this.aqa);
            this.hNh.getLayoutMode().onModeChanged(this.hUk);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.aqa, R.color.cp_bg_line_d);
            }
            if (this.hUa != null) {
                this.hUa.onChangeSkinType(i);
            }
            if (this.hUl != null) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hUl, R.color.cp_bg_line_c);
            }
            if (this.hUm != null) {
                this.hUm.setIsNight(this.mSkinType == 1);
            }
            if (this.hUn != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUn, (int) R.color.cp_cont_b);
            }
            if (this.hUo != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUo, (int) R.color.cp_cont_j);
            }
            if (this.hUp != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hUp, R.drawable.icon_common_arrow16_right_n);
            }
            if (this.hUr != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUr, (int) R.color.cp_cont_b);
                this.hUr.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            }
            if (this.fBe != null) {
                this.fBe.changeSkin(i);
                if (this.cKJ != null) {
                    this.hNh.getLayoutMode().onModeChanged(this.cKJ);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.cKJ, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.hUY != null) {
                this.hUY.c(this.hNh.getPageContext());
            }
            oH(this.hVq);
            this.hUX.notifyDataSetChanged();
            if (this.hVb != null) {
                this.hVb.changeSkin(i);
            }
            if (this.CJ != null) {
                this.CJ.onChangeSkinType(i);
            }
            if (this.hUG != null) {
                this.hUG.onChangeSkin(i);
            }
            if (this.hVc != null) {
                this.hVc.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.eOx)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.eOx) {
                    customBlueCheckRadioButton.anv();
                }
            }
            bVl();
            UtilHelper.setStatusBarBackground(this.apj, i);
            UtilHelper.setStatusBarBackground(this.hVO, i);
            if (this.hUI != null) {
                this.hUI.onChangeSkinType(i);
            }
            if (this.hUM != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUM, (int) R.color.cp_cont_d);
            }
            if (this.hUL != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUL, (int) R.color.cp_cont_d);
            }
            if (this.hUN != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUN, (int) R.color.cp_cont_d);
            }
            if (this.hUK != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUK, (int) R.color.cp_cont_d);
            }
            if (this.hUQ != null) {
                com.baidu.tbadk.s.a.a(this.hNh.getPageContext(), this.hUQ);
            }
            if (this.hWe != null) {
                this.hWe.onChangeSkinType(i);
            }
            if (this.hUe != null) {
                if (this.hTY != null) {
                    this.hTY.wW(i);
                } else {
                    this.hUe.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.gnG != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.gnG, (int) R.color.cp_cont_d);
                this.gnG.setBackgroundDrawable(com.baidu.tbadk.core.util.am.Z(com.baidu.adp.lib.util.l.getDimens(this.hNh, R.dimen.tbds16), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.hVy != null && this.hQG != null) {
                if (this.hQG.afk()) {
                    SvgManager.amL().a(this.hVy, R.drawable.icon_mask_pb_bottom_collect_h_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.amL().a(this.hVy, R.drawable.icon_pure_pb_bottom_collect_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            if (this.hVz != null) {
                SvgManager.amL().a(this.hVz, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hVx != null) {
                SvgManager.amL().a(this.hVx, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hVA, (int) R.color.cp_cont_b);
            if (this.hUA != null) {
                com.baidu.tbadk.core.util.am.setImageResource(this.hUA, BitmapHelper.getGradeResourceIdInEnterForum(this.hWm));
            }
            if (this.hWt != null) {
                this.hWt.onChangeSkinType(i);
            }
            if (this.hVU != null) {
                this.hVU.onChangeSkinType();
            }
            if (this.hWp != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hWp, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hVw, R.color.cp_bg_line_h);
            if (this.hUz != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hUz, this.hWy);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUz, (int) R.color.cp_cont_a);
            }
            if (this.hUj != null) {
                this.hUj.mD(i);
            }
            this.hNh.getLayoutMode().onModeChanged(this.hVk);
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cTN = hVar;
        this.hUX.setOnImageClickListener(this.cTN);
        this.hWt.setOnImageClickListener(this.cTN);
    }

    public void h(NoNetworkView.a aVar) {
        this.fsc = aVar;
        if (this.faF != null) {
            this.faF.a(this.fsc);
        }
    }

    public void oK(boolean z) {
        this.hUX.setIsFromCDN(z);
    }

    public Button bVO() {
        return this.hVu;
    }

    public void bVP() {
        if (this.hUd != 2) {
            this.hUi.setNextPage(this.fBe);
            this.hUd = 2;
        }
    }

    public void bVQ() {
        if (com.baidu.tbadk.p.m.awL().awM()) {
            int lastVisiblePosition = this.hUi.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hUi.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.cLh = true;
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
                        perfLog2.cLh = true;
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

    public boolean bVR() {
        return this.CJ != null && this.CJ.getVisibility() == 0;
    }

    public boolean bVS() {
        return this.CJ != null && this.CJ.atZ();
    }

    public void bVT() {
        if (this.CJ != null) {
            this.CJ.asA();
        }
    }

    public void oL(boolean z) {
        if (this.hVw != null) {
            oJ(this.hNh.bRQ().auD());
            if (this.hVt) {
                oB(z);
            } else {
                oC(z);
            }
        }
    }

    public void bVU() {
        if (this.hVw != null) {
            this.hVv.setVisibility(8);
            this.hVw.setVisibility(8);
            this.hVB = false;
            if (this.hVU != null) {
                this.hVU.setVisibility(8);
                oF(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.eVG == null) {
            this.eVG = new com.baidu.tbadk.core.view.b(this.hNh.getPageContext());
        }
        this.eVG.setDialogVisiable(true);
    }

    public void aVU() {
        if (this.eVG != null) {
            this.eVG.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hUi.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hUi.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hTY != null) {
            this.hTY.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hWN = getScrollY();
            this.hVT.hXd = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.hVT));
            a(this.hVT.hXd, true);
        }
    }

    public void oM(boolean z) {
        this.hTY.oM(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hTY != null) {
            this.hTY.b(absListView, i);
        }
        if (this.hUe != null && this.hUX != null) {
            this.hUe.cC(this.hUX.bTg());
        }
        this.hVT.hDq = i;
        this.hVT.headerCount = this.hUi.getHeaderViewsCount();
        this.hVT.hXd = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.hVT));
        a(this.hVT.hXd, false);
        if (this.fBe.anL() && !this.fBe.coR) {
            if (this.hVT != null && this.hVT.hXd != null && this.hVT.hXd.getView() != null) {
                i4 = this.hVT.hXd.getView().getTop() < 0 ? this.hVT.hXd.getView().getHeight() : this.hVT.hXd.getView().getBottom();
            }
            this.fBe.iN(i4);
            this.fBe.coR = true;
        }
    }

    public void bVV() {
        if (this.hNh.isLogin() && this.hQG != null && this.hWj && !this.hWi && !this.hVr && this.hVE != null && this.hVE.aiE() != null && !this.hVE.aiE().getIsLike() && !this.hVE.aiE().hadConcerned() && this.hWf == null) {
            this.hWf = new an(this.hNh);
        }
    }

    public void bVW() {
        if (this.hWj && !this.hWi && this.hVE != null && this.hVE.aiE() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").O("obj_locate", this.hNh.bRt() ? 2 : 1).O("obj_type", this.hWi ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.hNh.getPageContext().getPageActivity(), this.hVE.aiE().getUserId(), this.hVE.aiE().getUserName(), this.hNh.bRD().bRu(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hWi && this.hVN != null && this.hUe.bWF() != null) {
            int bTc = this.hUX.bTc();
            if (bTc > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bTc > this.hUi.getFirstVisiblePosition() - this.hUi.getHeaderViewsCount()) {
                    this.hVN.setVisibility(8);
                    return;
                }
                this.hVN.setVisibility(0);
                bWg();
                this.hUe.mNavigationBar.hideBottomLine();
                if (this.hVN.getParent() != null && ((ViewGroup) this.hVN.getParent()).getHeight() <= this.hVN.getTop()) {
                    this.hVN.getParent().requestLayout();
                }
            } else if (alVar == null || alVar.getView() == null || alVar.hTC == null) {
                if (this.hUi.getFirstVisiblePosition() == 0) {
                    this.hVN.setVisibility(8);
                    this.hUe.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hVS) {
                        this.hVR = top;
                        this.hVS = false;
                    }
                    this.hVR = top < this.hVR ? top : this.hVR;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hUW.getY() < 0.0f) {
                        measuredHeight = hVQ - alVar.hTC.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hUe.bWF().getMeasuredHeight() - alVar.hTC.getMeasuredHeight();
                        this.hUe.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hVR) {
                        this.hVN.setVisibility(0);
                        bWg();
                    } else if (top < measuredHeight) {
                        this.hVN.setVisibility(0);
                        bWg();
                    } else {
                        this.hVN.setVisibility(8);
                        this.hUe.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.hVS = true;
                    }
                }
            }
        }
    }

    public void bVX() {
        if (!this.hWO) {
            TiebaStatic.log("c10490");
            this.hWO = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNh.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hVX, Integer.valueOf(hVZ));
            aVar.hS(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hNh.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aM(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.hNh);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hNh.getPageContext()).akM();
        }
    }

    public void AU(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNh.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hNh.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aM(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hVX, Integer.valueOf(hWa));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.hNh);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hNh.getPageContext()).akM();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData c;
        if (i > 0 && (c = c(dVar, z)) != null && c.aiE() != null) {
            MetaData aiE = c.aiE();
            aiE.setGiftNum(aiE.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bVY() {
        return this.hVJ;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQx() != null && dVar.bQx().ajE() && this.hVJ == null) {
            this.hVJ = (PbInterviewStatusView) this.hVI.inflate();
            this.hVJ.setOnClickListener(this.fwH);
            this.hVJ.setCallback(this.hNh.bSC());
            this.hVJ.setData(this.hNh, dVar);
        }
    }

    public LinearLayout bVZ() {
        return this.hUW;
    }

    public View bWa() {
        return this.apj;
    }

    public boolean bWb() {
        return this.hWA;
    }

    public void nY(boolean z) {
        this.hUv.nY(z);
    }

    public void AV(String str) {
        if (this.hUf != null) {
            this.hUf.setTitle(str);
        }
    }

    private int oN(boolean z) {
        if (this.hVJ == null || this.hVJ.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(this.hNh.getPageContext().getPageActivity(), R.dimen.ds72);
    }

    private void bWc() {
        if (this.hVJ != null && this.hVJ.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hVJ.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hVJ.setLayoutParams(layoutParams);
        }
    }

    public boolean bRW() {
        return false;
    }

    public void AW(String str) {
        this.gnG.performClick();
        if (!StringUtils.isNull(str) && this.hNh.bRQ() != null && this.hNh.bRQ().auw() != null && this.hNh.bRQ().auw().getInputView() != null) {
            EditText inputView = this.hNh.bRQ().auw().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bVL();
            if (configuration.orientation == 2) {
                bVU();
                bUV();
            } else {
                bUY();
            }
            if (this.hWe != null) {
                this.hWe.bTl();
            }
            this.hNh.bkj();
            this.hUW.setVisibility(8);
            this.hUe.oX(false);
            this.hNh.oe(false);
            if (this.hTY != null) {
                if (configuration.orientation == 1) {
                    bVZ().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hUi.setIsLandscape(true);
                    this.hUi.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hUi.setIsLandscape(false);
                    if (this.hWN > 0) {
                        this.hUi.smoothScrollBy(this.hWN, 0);
                    }
                }
                this.hTY.onConfigurationChanged(configuration);
                this.hVM.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void oO(boolean z) {
        this.hUc = z;
    }

    public boolean bWd() {
        return this.hTY != null && this.hTY.bWd();
    }

    public void bWe() {
        if (this.hTY != null) {
            this.hTY.onPause();
        }
    }

    public void r(long j, int i) {
        if (this.hUa != null) {
            this.hUa.r(j, i);
        }
        if (this.hTY != null) {
            this.hTY.r(j, i);
        }
    }

    public void oj(boolean z) {
        this.hUX.oj(z);
    }

    public void bWf() {
        if (this.hVK == null) {
            LayoutInflater.from(this.hNh.getActivity()).inflate(R.layout.add_experienced_text, (ViewGroup) this.aqa, true);
            this.hVK = (ViewGroup) this.aqa.findViewById(R.id.add_experienced_layout);
            this.hVL = (TextView) this.aqa.findViewById(R.id.add_experienced);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hVL, (int) R.color.cp_cont_a);
            String string = this.hNh.getResources().getString(R.string.experienced_add_success);
            String string2 = this.hNh.getResources().getString(R.string.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_h)));
            this.hVL.setText(spannableString);
        }
        this.hVK.setVisibility(0);
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
                        aq.this.hVK.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hVL.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hVL.startAnimation(scaleAnimation);
    }

    public void cB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.hVw.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hNh);
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.hWp = new TextView(this.hNh);
            this.hWp.setText(R.string.connection_tips);
            this.hWp.setGravity(17);
            this.hWp.setPadding(com.baidu.adp.lib.util.l.getDimens(this.hNh, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.hNh, R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.hNh, R.dimen.ds60);
            if (this.hWp.getParent() == null) {
                frameLayout.addView(this.hWp, layoutParams);
            }
            this.hWo = new PopupWindow(this.hNh);
            this.hWo.setContentView(frameLayout);
            this.hWo.setHeight(-2);
            this.hWo.setWidth(-2);
            this.hWo.setFocusable(true);
            this.hWo.setOutsideTouchable(false);
            this.hWo.setBackgroundDrawable(new ColorDrawable(this.hNh.getResources().getColor(R.color.transparent)));
            this.hUi.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hWo.showAsDropDown(aq.this.hVw, view.getLeft(), -aq.this.hVw.getHeight());
                    } else {
                        aq.this.hWo.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void bWg() {
        if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("show_long_press_tips", false) && this.hWq == null) {
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("show_long_press_tips", true);
            this.hWq = new com.baidu.tbadk.core.dialog.a(this.hNh);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hNh);
            this.hWq.hW(1);
            this.hWq.aM(pbLongPressTipView);
            this.hWq.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hWq.eh(false);
            this.hWq.b(this.hNh.getPageContext()).akM();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hWq != null && aq.this.hWq.isShowing()) {
                        aq.this.hWq.dismiss();
                    }
                }
            }, 5000L);
            if (this.hTY != null) {
                this.hTY.bYb();
            }
        }
    }

    public void oP(boolean z) {
        this.hWv = z;
    }

    public boolean bWh() {
        return this.hWv;
    }

    public PbThreadPostView bWi() {
        return this.hUj;
    }

    private void ad(boolean z, boolean z2) {
        ae(z, z2);
        af(z, z2);
        if (this.hUX != null && this.hUX.bTh() != null) {
            this.hUX.bTh().a(this.hQG, z, z2);
        }
    }

    private void ae(boolean z, boolean z2) {
        if (this.hQG != null && this.hQG.hID) {
            this.hUt.setImageResource(R.drawable.pic_frs_headlines_n);
            this.hUt.setVisibility(0);
        } else if (z && z2) {
            this.hUt.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hUt.setVisibility(0);
        } else if (z) {
            this.hUt.setImageResource(R.drawable.pic_pb_refined_n);
            this.hUt.setVisibility(0);
        } else if (z2) {
            this.hUt.setImageResource(R.drawable.pic_pb_stick_n);
            this.hUt.setVisibility(0);
        } else {
            this.hUt.setVisibility(8);
        }
    }

    private void af(boolean z, boolean z2) {
        if (this.hUq != null && this.hQG != null && this.hQG.bQx() != null && this.hQG.bQx().aiT() == 0 && !this.hQG.bQx().ajy()) {
            if (this.hQG != null && this.hQG.hID) {
                this.hUt.setImageResource(R.drawable.pic_frs_headlines_n);
                this.hUt.setVisibility(0);
            } else if (z && z2) {
                this.hUu.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.hUu.setVisibility(0);
            } else if (z) {
                this.hUu.setImageResource(R.drawable.pic_pb_refined_n);
                this.hUu.setVisibility(0);
            } else if (z2) {
                this.hUu.setImageResource(R.drawable.pic_pb_stick_n);
                this.hUu.setVisibility(0);
            } else {
                this.hUu.setVisibility(8);
            }
        }
    }
}
