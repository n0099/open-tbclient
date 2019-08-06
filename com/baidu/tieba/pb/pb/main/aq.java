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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
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
    private EditorTools TU;
    private h.c caJ;
    private com.baidu.tieba.pb.a.c clA;
    private View czl;
    private List<CustomBlueCheckRadioButton> eEY;
    private NoNetworkView eXf;
    private int ehK;
    private RelativeLayout evb;
    private View eve;
    private PbListView fAR;
    private NavigationBarCoverTip fTi;
    private com.baidu.tieba.NEGFeedBack.e fWb;
    private View fwK;
    private View.OnClickListener fwx;
    private TextView gnh;
    PbActivity.d hMC;
    private View.OnClickListener hNW;
    private PbActivity hNx;
    private UserIconBox hOK;
    private UserIconBox hOL;
    private PbFakeFloorModel hPL;
    private com.baidu.tieba.pb.data.d hQT;
    private TextView hUA;
    private ImageView hUB;
    private RelativeLayout hUE;
    private ImageView hUF;
    private ImageView hUG;
    private e hUH;
    private ColumnLayout hUI;
    private ThreadSkinView hUJ;
    private TextView hUK;
    private TextView hUL;
    private ImageView hUM;
    private HeadPendantView hUN;
    private FrameLayout hUO;
    private HeadImageView hUP;
    private View hUQ;
    private LinearLayout hUR;
    private PbFirstFloorUserLikeButton hUU;
    private ao hUV;
    private TextView hUW;
    private TextView hUX;
    private TextView hUY;
    private TextView hUZ;
    public int hUj;
    public com.baidu.tieba.pb.video.i hUk;
    private long hUl;
    private com.baidu.tieba.pb.video.h hUm;
    private com.baidu.tieba.c.d hUn;
    public final com.baidu.tieba.pb.pb.main.view.c hUq;
    public com.baidu.tieba.pb.pb.main.view.b hUr;
    private ViewStub hUs;
    private ViewStub hUt;
    private PbLandscapeListView hUu;
    private PbThreadPostView hUv;
    private View hUw;
    private RelativeLayout hUx;
    private HeadImageView hUy;
    private TextView hUz;
    private View hVH;
    private View hVI;
    private ImageView hVJ;
    private ImageView hVK;
    private ImageView hVL;
    private TextView hVM;
    private int hVO;
    private int hVP;
    private PostData hVQ;
    private View hVS;
    private TextView hVT;
    private ViewStub hVU;
    private PbInterviewStatusView hVV;
    private ViewGroup hVW;
    private TextView hVX;
    private FrameLayout hVY;
    private View hVZ;
    private View hVa;
    private View hVb;
    private LinearLayout hVc;
    private TextView hVd;
    private TextView hVe;
    private View hVf;
    private View hVg;
    private ObservedChangeLinearLayout hVi;
    private f hVj;
    private View hVp;
    private TextView hWA;
    private com.baidu.tbadk.core.dialog.a hWB;
    private List<String> hWC;
    private com.baidu.tieba.pb.pb.main.emotion.c hWD;
    private com.baidu.tieba.pb.pb.godreply.a hWE;
    private PbLandscapeListView.b hWF;
    private ac hWH;
    private String hWI;
    private boolean hWL;
    private com.baidu.tbadk.core.view.userLike.c hWM;
    private com.baidu.tbadk.core.view.userLike.c hWN;
    private Runnable hWS;
    private PbActivity.b hWU;
    public int hWZ;
    private View hWa;
    private al hWb;
    private PbEmotionBar hWg;
    private Runnable hWo;
    private s hWp;
    private an hWq;
    private int hWw;
    private PbTopTipView hWy;
    private PopupWindow hWz;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int hWc = UtilHelper.getLightStatusBarHeight();
    public static int hWi = 3;
    public static int hWj = 0;
    public static int hWk = 3;
    public static int hWl = 4;
    public static int hWm = 5;
    public static int hWn = 6;
    private static a.InterfaceC0412a hWK = new a.InterfaceC0412a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0412a
        public void onRefresh() {
        }
    };
    private boolean hUo = false;
    private int hUp = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hUC = null;
    private TextView hUD = null;
    public FrsPraiseView hUS = null;
    private ClickableHeaderImageView hUT = null;
    private View hVh = null;
    private com.baidu.tbadk.core.dialog.a hVk = null;
    private com.baidu.tbadk.core.dialog.b fww = null;
    private View hVl = null;
    private EditText hVm = null;
    private com.baidu.tieba.pb.view.c hVn = null;
    private com.baidu.tieba.pb.view.a hVo = null;
    private com.baidu.tbadk.core.dialog.a hVq = null;
    private b.a gKL = null;
    private TbRichTextView.h cKo = null;
    private NoNetworkView.a frT = null;
    private com.baidu.tbadk.core.dialog.i hVr = null;
    private View hVs = null;
    private com.baidu.tbadk.core.dialog.a hVt = null;
    private Dialog hVu = null;
    private Dialog hVv = null;
    private View hVw = null;
    private LinearLayout hVx = null;
    private CompoundButton.OnCheckedChangeListener eEZ = null;
    private TextView hVy = null;
    private TextView hVz = null;
    private String hVA = null;
    private com.baidu.tbadk.core.dialog.i hLC = null;
    private com.baidu.tbadk.core.dialog.i hVB = null;
    private boolean hVC = false;
    private boolean hVD = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hVE = null;
    private boolean hVF = false;
    private Button hVG = null;
    private boolean hVN = true;
    private com.baidu.tbadk.core.view.b eMz = null;
    private boolean hNO = false;
    private int mSkinType = 3;
    private boolean hVR = false;
    private int hWd = 0;
    private boolean hWe = true;
    public a hWf = new a();
    private int hWh = 0;
    private boolean hWr = false;
    private int hWs = 0;
    private boolean hWt = false;
    private boolean hWu = false;
    private boolean hWv = false;
    private int hWx = 0;
    private boolean hWG = false;
    private int hWJ = R.drawable.bg_user_identity_btn;
    private String hWO = null;
    private CustomMessageListener hWP = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hWO = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hVj != null) {
                aq.this.hVj.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hWQ = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hUD != null) {
                aq.this.hUD.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hWR = new Handler();
    private CustomMessageListener hWT = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hVN = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hWV = true;
    View.OnClickListener hWW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hWt) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").P(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hWt && aq.this.hQT != null && aq.this.hQT.bSL() != null && aq.this.hQT.bSL().aey() != null && aq.this.hQT.bSL().aey().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").P("obj_locate", 1));
            }
            aq.this.hNx.hLx.fWK.onClick(view);
        }
    };
    private boolean hWX = false;
    String userId = null;
    private final List<TbImageView> hWY = new ArrayList();
    private boolean hXa = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int hDD;
        public al hXp;
        public int headerCount;
    }

    public void oN(boolean z) {
        this.hWr = z;
        if (this.hUu != null) {
            this.hWs = this.hUu.getHeaderViewsCount();
        }
    }

    public void bXg() {
        if (this.hUu != null) {
            int headerViewsCount = this.hUu.getHeaderViewsCount() - this.hWs;
            final int firstVisiblePosition = (this.hUu.getFirstVisiblePosition() == 0 || this.hUu.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hUu.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hUu.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hWf.hXp = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hWf));
            final al alVar = this.hWf.hXp;
            final int h = h(alVar);
            final int y = ((int) this.hVi.getY()) + this.hVi.getMeasuredHeight();
            final boolean z = this.hVZ.getVisibility() == 0;
            boolean z2 = this.hVi.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hVj.bVp() + this.hUu.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hTO.getMeasuredHeight() : 0;
                if (z2) {
                    this.hUu.setSelectionFromTop(this.hVj.bVp() + this.hUu.getHeaderViewsCount(), hWc - measuredHeight);
                } else {
                    this.hUu.setSelectionFromTop(this.hVj.bVp() + this.hUu.getHeaderViewsCount(), this.hUq.bYS().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hUu.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hWt) {
                this.hUu.setSelectionFromTop(this.hVj.bVp() + this.hUu.getHeaderViewsCount(), this.hUk.aJu().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hUu.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bVH() {
                        if (h >= 0 && h <= aq.this.evb.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.eve.getLayoutParams();
                            if (i == 0 || i > aq.this.evb.getMeasuredHeight() || h2 >= aq.this.evb.getMeasuredHeight()) {
                                layoutParams.height = aq.this.ehK;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.evb.getMeasuredHeight()) {
                                layoutParams.height = aq.this.ehK;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hUu.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.eve.setLayoutParams(layoutParams);
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (aq.this.eve != null && aq.this.eve.getLayoutParams() != null) {
                                        ViewGroup.LayoutParams layoutParams2 = aq.this.eve.getLayoutParams();
                                        layoutParams2.height = aq.this.ehK;
                                        aq.this.eve.setLayoutParams(layoutParams2);
                                    }
                                }
                            });
                        }
                        aq.this.hUu.setOnLayoutListener(null);
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

    public NoNetworkView bXh() {
        return this.eXf;
    }

    public void bXi() {
        if (this.TU != null) {
            this.TU.hide();
            if (this.hWD != null) {
                this.hWD.aIm();
            }
        }
    }

    public PbFakeFloorModel bXj() {
        return this.hPL;
    }

    public s bXk() {
        return this.hWp;
    }

    public void bXl() {
        reset();
        bXi();
        this.hWp.bVy();
        oY(false);
    }

    private void reset() {
        if (this.hNx != null && this.hNx.bUe() != null && this.TU != null) {
            com.baidu.tbadk.editortools.pb.a.asx().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bUe = this.hNx.bUe();
            bUe.asQ();
            bUe.asl();
            if (bUe.getWriteImagesInfo() != null) {
                bUe.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bUe.kw(SendView.ALL);
            bUe.kx(SendView.ALL);
            com.baidu.tbadk.editortools.g kn = this.TU.kn(23);
            com.baidu.tbadk.editortools.g kn2 = this.TU.kn(2);
            com.baidu.tbadk.editortools.g kn3 = this.TU.kn(5);
            if (kn2 != null) {
                kn2.qk();
            }
            if (kn3 != null) {
                kn3.qk();
            }
            if (kn != null) {
                kn.hide();
            }
            this.TU.invalidate();
        }
    }

    public boolean bXm() {
        return this.hVN;
    }

    public void oO(boolean z) {
        if (this.hVI != null && this.gnh != null) {
            this.gnh.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hVI.startAnimation(alphaAnimation);
            }
            this.hVH.setVisibility(0);
            this.hVI.setVisibility(0);
            this.hVN = true;
            if (this.hWg != null && !this.hWE.isActive()) {
                this.hWg.setVisibility(0);
                oS(true);
            }
        }
    }

    public void oP(boolean z) {
        if (this.hVI != null && this.gnh != null) {
            this.gnh.setText(bXn());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hVI.startAnimation(alphaAnimation);
            }
            this.hVH.setVisibility(0);
            this.hVI.setVisibility(0);
            this.hVN = true;
            if (this.hWg != null && !this.hWE.isActive()) {
                this.hWg.setVisibility(0);
                oS(true);
            }
        }
    }

    public String bXn() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.hWI)) {
            return this.hWI;
        }
        if (this.hNx != null) {
            this.hWI = this.hNx.getResources().getString(ap.bXf());
        }
        return this.hWI;
    }

    public PostData bXo() {
        int i = 0;
        if (this.hUu == null) {
            return null;
        }
        int bXp = bXp() - this.hUu.getHeaderViewsCount();
        if (bXp < 0) {
            bXp = 0;
        }
        if (this.hVj.xP(bXp) != null && this.hVj.xP(bXp) != PostData.jgd) {
            i = bXp + 1;
        }
        return this.hVj.getItem(i) instanceof PostData ? (PostData) this.hVj.getItem(i) : null;
    }

    public int bXp() {
        int i;
        View childAt;
        if (this.hUu == null) {
            return 0;
        }
        int firstVisiblePosition = this.hUu.getFirstVisiblePosition();
        int lastVisiblePosition = this.hUu.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hUu.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hUu.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bXq() {
        return this.hUu.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hQT != null && this.hQT.bSN() != null && !this.hQT.bSN().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hQT.bSN().size() && (postData = this.hQT.bSN().get(i)) != null && postData.aey() != null && !StringUtils.isNull(postData.aey().getUserId()); i++) {
                if (this.hQT.bSN().get(i).aey().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hWE != null && this.hWE.isActive()) {
                        oY(false);
                    }
                    if (this.hWg != null) {
                        this.hWg.pg(true);
                    }
                    this.hWO = postData.aey().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hNx = null;
        this.evb = null;
        this.fwK = null;
        this.hUl = 0L;
        this.hUu = null;
        this.hUw = null;
        this.hUE = null;
        this.hUI = null;
        this.hUK = null;
        this.hUL = null;
        this.hUO = null;
        this.hUP = null;
        this.hUQ = null;
        this.hUU = null;
        this.hUW = null;
        this.hUX = null;
        this.hUY = null;
        this.hUZ = null;
        this.hVf = null;
        this.hVg = null;
        this.hVj = null;
        this.fAR = null;
        this.czl = null;
        this.fwx = null;
        this.hNW = null;
        this.hVI = null;
        this.gnh = null;
        this.hVS = null;
        this.hVT = null;
        this.hVU = null;
        this.hWw = 0;
        this.hUl = System.currentTimeMillis();
        this.hNx = pbActivity;
        this.fwx = onClickListener;
        this.clA = cVar;
        this.hWw = com.baidu.adp.lib.util.l.af(this.hNx) / 2;
        this.evb = (RelativeLayout) LayoutInflater.from(this.hNx.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.hNx.addContentView(this.evb, new FrameLayout.LayoutParams(-1, -1));
        this.fTi = (NavigationBarCoverTip) this.hNx.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.fwK = this.hNx.findViewById(R.id.statebar_view);
        this.hVi = (ObservedChangeLinearLayout) this.hNx.findViewById(R.id.title_wrapper);
        this.eXf = (NoNetworkView) this.hNx.findViewById(R.id.view_no_network);
        this.hUu = (PbLandscapeListView) this.hNx.findViewById(R.id.new_pb_list);
        this.hVY = (FrameLayout) this.hNx.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.hNx.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.hNx.getActivity(), R.dimen.ds88));
        this.hUu.addHeaderView(this.textView, 0);
        this.ehK = this.hNx.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.eve = new View(this.hNx.getPageContext().getPageActivity());
        this.eve.setLayoutParams(new AbsListView.LayoutParams(-1, this.ehK));
        this.eve.setVisibility(4);
        this.hUu.addFooterView(this.eve);
        this.hUu.setOnTouchListener(this.hNx.cmw);
        this.hUq = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.hNx.bUI()) {
            this.hUs = (ViewStub) this.hNx.findViewById(R.id.manga_view_stub);
            this.hUs.setVisibility(0);
            this.hUr = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.hUr.show();
            this.hUq.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hNx.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.hUq.bYS().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0372a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0372a
            public void bTB() {
                if (aq.this.hUu != null) {
                    if (aq.this.hUk != null) {
                        aq.this.hUk.cam();
                    }
                    aq.this.hUu.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0372a
            public void bTC() {
                aq.this.hNx.bmu();
            }
        }));
        this.hVH = this.hNx.findViewById(R.id.view_comment_top_line);
        this.hVI = this.hNx.findViewById(R.id.pb_editor_tool_comment);
        this.hVO = com.baidu.adp.lib.util.l.g(this.hNx.getPageContext().getPageActivity(), R.dimen.tbds120);
        this.hVP = com.baidu.adp.lib.util.l.g(this.hNx.getPageContext().getPageActivity(), R.dimen.ds242);
        this.gnh = (TextView) this.hNx.getPageContext().getPageActivity().findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.gnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hNx.bUo();
                if (aq.this.hNx != null && aq.this.hNx.bTR() != null && aq.this.hNx.bTR().getPbData() != null && aq.this.hNx.bTR().getPbData().bSL() != null && aq.this.hNx.bTR().getPbData().bSL().aey() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", aq.this.hNx.bTR().hQx).bT("fid", aq.this.hNx.bTR().getPbData().getForumId()).P("obj_locate", 1).bT("uid", aq.this.hNx.bTR().getPbData().bSL().aey().getUserId()));
                }
            }
        });
        this.hVJ = (ImageView) this.hNx.findViewById(R.id.pb_editor_tool_comment_icon);
        this.hVJ.setOnClickListener(this.fwx);
        this.hVK = (ImageView) this.hNx.findViewById(R.id.pb_editor_tool_collection);
        this.hVK.setOnClickListener(this.fwx);
        this.hVL = (ImageView) this.hNx.findViewById(R.id.pb_editor_tool_share);
        this.hVL.setOnClickListener(this.fwx);
        this.hVM = (TextView) this.hNx.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.hUw = LayoutInflater.from(this.hNx.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.hUE = (RelativeLayout) LayoutInflater.from(this.hNx.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.hUF = (ImageView) this.hUE.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.hUH = new e(this.hNx, this.hUE);
        this.hUH.init();
        this.hUH.a(this.hUH.bUd(), this.fwx);
        this.hUI = (ColumnLayout) this.hUE.findViewById(R.id.pb_head_owner_root);
        this.hUJ = (ThreadSkinView) this.hUE.findViewById(R.id.pb_thread_skin);
        this.hUI.setOnLongClickListener(this.onLongClickListener);
        this.hUI.setOnTouchListener(this.clA);
        this.hUI.setVisibility(8);
        this.hUw.setOnTouchListener(this.clA);
        this.hVS = this.hUw.findViewById(R.id.pb_head_activity_join_number_container);
        this.hVS.setVisibility(8);
        this.hVT = (TextView) this.hUw.findViewById(R.id.pb_head_activity_join_number);
        this.hUK = (TextView) this.hUI.findViewById(R.id.pb_head_owner_info_user_name);
        this.hUK.getPaint().setFakeBoldText(true);
        this.hUL = (TextView) this.hUI.findViewById(R.id.floor_owner);
        this.hUM = (ImageView) this.hUI.findViewById(R.id.icon_forum_level);
        this.hUO = (FrameLayout) this.hUI.findViewById(R.id.pb_head_headImage_container);
        this.hUP = (HeadImageView) this.hUI.findViewById(R.id.pb_head_owner_photo);
        this.hUN = (HeadPendantView) this.hUI.findViewById(R.id.pb_pendant_head_owner_photo);
        this.hUN.setHasPendantStyle();
        if (this.hUN.getHeadView() != null) {
            this.hUN.getHeadView().setIsRound(true);
            this.hUN.getHeadView().setDrawBorder(false);
        }
        this.hOK = (UserIconBox) this.hUI.findViewById(R.id.show_icon_vip);
        this.hOL = (UserIconBox) this.hUI.findViewById(R.id.show_icon_yinji);
        this.hUR = (LinearLayout) this.hUE.findViewById(R.id.pb_head_owner_info_root);
        this.hUU = (PbFirstFloorUserLikeButton) this.hUI.findViewById(R.id.pb_like_button);
        this.hUW = (TextView) this.hUI.findViewById(R.id.pb_views);
        this.hUX = (TextView) this.hUI.findViewById(R.id.pb_item_first_floor_reply_time);
        this.hUY = (TextView) this.hUI.findViewById(R.id.pb_item_first_floor_location_address);
        this.hUZ = (TextView) this.hUI.findViewById(R.id.point_between_time_and_locate);
        this.hWM = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hWN = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hVf = this.hUw.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.hVg = this.hUw.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.hUw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hVU = (ViewStub) this.evb.findViewById(R.id.interview_status_stub);
        this.hVa = this.hUE.findViewById(R.id.blank_view_align_user_item_top);
        this.hVb = this.hUE.findViewById(R.id.blank_view_align_user_item_bottom);
        this.hVj = new f(this.hNx, this.hUu);
        this.hVj.B(this.fwx);
        this.hVj.setTbGestureDetector(this.clA);
        this.hVj.setOnImageClickListener(this.cKo);
        this.hNW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hNx.c(sparseArray);
                            return;
                        }
                        aq.this.cE(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.hNx.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hVj.N(this.hNW);
        bXv();
        bXw();
        this.hUu.addHeaderView(this.hUE);
        this.hUu.addHeaderView(this.hUC);
        this.hUu.addHeaderView(this.hUw);
        this.fAR = new PbListView(this.hNx.getPageContext().getPageActivity());
        this.czl = this.fAR.getView().findViewById(R.id.pb_more_view);
        if (this.czl != null) {
            this.czl.setOnClickListener(this.fwx);
            com.baidu.tbadk.core.util.am.k(this.czl, R.drawable.pb_foot_more_trans_selector);
        }
        this.fAR.akB();
        this.fAR.iS(R.drawable.pb_foot_more_trans_selector);
        this.fAR.iU(R.drawable.pb_foot_more_trans_selector);
        this.hVp = this.hNx.findViewById(R.id.viewstub_progress);
        this.hNx.registerListener(this.hWT);
        this.hUQ = com.baidu.tbadk.ala.b.aak().n(this.hNx.getActivity(), 2);
        if (this.hUQ != null) {
            this.hUQ.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            if (this.hUQ.getParent() == null) {
                this.hUR.addView(this.hUQ, aVar);
            }
        }
        this.hPL = new PbFakeFloorModel(this.hNx.getPageContext());
        this.hWp = new s(this.hNx.getPageContext(), this.hPL, this.evb);
        this.hWp.a(this.hNx.hMx);
        this.hPL.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hPL.o(postData);
                aq.this.hVj.notifyDataSetChanged();
                aq.this.hWp.bVy();
                aq.this.TU.aqw();
                aq.this.oY(false);
            }
        });
        if (this.hNx.bTR() != null && !StringUtils.isNull(this.hNx.bTR().bWt())) {
            this.hNx.showToast(this.hNx.bTR().bWt());
        }
        this.hVZ = this.hNx.findViewById(R.id.pb_expand_blank_view);
        this.hWa = this.hNx.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hWa.getLayoutParams();
        if (this.hNx.bTR() != null && this.hNx.bTR().bVO()) {
            this.hVZ.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hWa.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hWc;
            this.hWa.setLayoutParams(layoutParams2);
        }
        this.hWb = new al(this.hNx.getPageContext(), this.hNx.findViewById(R.id.pb_reply_expand_view));
        this.hWb.hTO.setVisibility(8);
        this.hWb.P(this.fwx);
        this.hNx.registerListener(this.mAccountChangedListener);
        this.hNx.registerListener(this.hWP);
        this.hNx.registerListener(this.hWQ);
        bXr();
        oS(false);
    }

    public void bxH() {
        if (!this.hNx.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").P("obj_locate", 2).bT("fid", this.mForumId));
        } else if (this.hNx.bUq()) {
            com.baidu.tbadk.editortools.pb.d bUe = this.hNx.bUe();
            if (bUe != null && (bUe.asN() || bUe.asO())) {
                this.hNx.bUe().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.TU != null) {
                bXB();
            }
            if (this.TU != null) {
                this.hVN = false;
                if (this.TU.kq(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hNx, (View) this.TU.kq(2).csa, false, hWK);
                }
            }
            bYh();
        }
    }

    private void bXr() {
        this.hWE = new com.baidu.tieba.pb.pb.godreply.a(this.hNx, this, (ViewStub) this.evb.findViewById(R.id.more_god_reply_popup));
        this.hWE.v(this.fwx);
        this.hWE.N(this.hNW);
        this.hWE.setOnImageClickListener(this.cKo);
        this.hWE.v(this.fwx);
        this.hWE.setTbGestureDetector(this.clA);
    }

    public com.baidu.tieba.pb.pb.godreply.a bXs() {
        return this.hWE;
    }

    public View bXt() {
        return this.hVZ;
    }

    public void bXu() {
        if (this.hUu != null) {
            this.hUu.removeHeaderView(this.hUC);
            this.hUu.removeHeaderView(this.hUE);
            this.hUu.removeHeaderView(this.hUx);
            this.hUu.removeHeaderView(this.hUw);
        }
    }

    private void bXv() {
        if (this.hUx == null) {
            this.hUx = (RelativeLayout) LayoutInflater.from(this.hNx).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.hUy = (HeadImageView) this.hUx.findViewById(R.id.iv_pb_video_smart_app_head);
            this.hUy.setIsRound(true);
            this.hUz = (TextView) this.hUx.findViewById(R.id.tv_pb_video_smart_app_title);
            this.hUA = (TextView) this.hUx.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.hUB = (ImageView) this.hUx.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.hUx.setOnClickListener(this.fwx);
        }
    }

    private void bXw() {
        if (this.hUC == null) {
            this.hUC = (RelativeLayout) LayoutInflater.from(this.hNx).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.hUG = (ImageView) this.hUC.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.hUG.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
            this.hUG.setImageMatrix(matrix);
            this.hUD = (TextView) this.hUC.findViewById(R.id.tv_pb_title);
            this.hUD.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.hUD.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hUD.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.j(this.hUD, R.color.cp_cont_b);
            this.hUD.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hUD.setVisibility(8);
            if (this.hUD.getParent() == null) {
                this.hUC.addView(this.hUD);
            }
            this.hUC.setOnTouchListener(this.clA);
            this.hUC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXx() {
        if (this.hNx.bUI()) {
            this.hUt = (ViewStub) this.hNx.findViewById(R.id.manga_mention_controller_view_stub);
            this.hUt.setVisibility(0);
            if (this.hVc == null) {
                this.hVc = (LinearLayout) this.hNx.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.s.a.a(this.hNx.getPageContext(), this.hVc);
            }
            if (this.hVd == null) {
                this.hVd = (TextView) this.hVc.findViewById(R.id.manga_prev_btn);
            }
            if (this.hVe == null) {
                this.hVe = (TextView) this.hVc.findViewById(R.id.manga_next_btn);
            }
            this.hVd.setOnClickListener(this.fwx);
            this.hVe.setOnClickListener(this.fwx);
        }
    }

    private void bXy() {
        if (this.hNx.bUI()) {
            if (this.hNx.bUL() == -1) {
                com.baidu.tbadk.core.util.am.f(this.hVd, R.color.cp_cont_e, 1);
            }
            if (this.hNx.bUM() == -1) {
                com.baidu.tbadk.core.util.am.f(this.hVe, R.color.cp_cont_e, 1);
            }
        }
    }

    public void bXz() {
        if (this.hVc == null) {
            bXx();
        }
        this.hUt.setVisibility(8);
        if (this.hWR != null && this.hWS != null) {
            this.hWR.removeCallbacks(this.hWS);
        }
    }

    public void bXA() {
        if (this.hWR != null) {
            if (this.hWS != null) {
                this.hWR.removeCallbacks(this.hWS);
            }
            this.hWS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hVc == null) {
                        aq.this.bXx();
                    }
                    aq.this.hUt.setVisibility(0);
                }
            };
            this.hWR.postDelayed(this.hWS, 2000L);
        }
    }

    public void oQ(boolean z) {
        this.hUq.oQ(z);
        if (z && this.hVR) {
            this.fAR.setText(this.hNx.getResources().getString(R.string.click_load_more));
            this.hUu.setNextPage(this.fAR);
            this.hUp = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
        this.TU.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.TU.getParent() == null) {
            this.evb.addView(this.TU, layoutParams);
        }
        this.TU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.TU.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).amw() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).amw() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.ajS();
                        aq.this.mPermissionJudgePolicy.e(aq.this.hNx, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.ad(aq.this.hNx)) {
                            aq.this.hNx.bUe().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hNx.bUe().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bXi();
        this.hNx.bUe().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.TU != null && aq.this.TU.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hWD == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.TU.getId());
                            aq.this.hWD = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hNx.getPageContext(), aq.this.evb, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.aa(aq.this.hWC)) {
                                aq.this.hWD.setData(aq.this.hWC);
                            }
                            aq.this.hWD.b(aq.this.TU);
                        }
                        aq.this.hWD.Ci(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hNx.hLB != null && aq.this.hNx.hLB.bYy() != null) {
                    if (!aq.this.hNx.hLB.bYy().czC()) {
                        aq.this.hNx.hLB.pd(false);
                    }
                    aq.this.hNx.hLB.bYy().sb(false);
                }
            }
        });
    }

    public void bXB() {
        if (this.hNx != null && this.TU != null) {
            this.TU.qk();
            if (this.hNx.bUe() != null) {
                this.hNx.bUe().asE();
            }
            bYh();
        }
    }

    public void oR(boolean z) {
        if (this.hUu != null && this.textView != null && this.fwK != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fwK.setVisibility(0);
                } else {
                    this.fwK.setVisibility(8);
                    this.hUu.removeHeaderView(this.textView);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hWc;
                    this.textView.setLayoutParams(layoutParams);
                }
                bXP();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + pa(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            bXP();
            bYp();
        }
    }

    public f bXC() {
        return this.hVj;
    }

    public void a(PbActivity.d dVar) {
        this.hMC = dVar;
    }

    public void cE(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hNx);
        kVar.setTitleText(this.hNx.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hVr.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hWU != null) {
                                aq.this.hWU.m(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hNx.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hNx.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hNx.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !bYo()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.hNx.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hNx.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hNx.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.W(arrayList);
        if (this.hVr == null) {
            this.hVr = new com.baidu.tbadk.core.dialog.i(this.hNx.getPageContext(), kVar.ahd());
        } else {
            this.hVr.setContentView(kVar.ahd());
        }
        this.hVr.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hWU = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hNx != null && aVar != null) {
            if (this.fWb == null) {
                this.fWb = new com.baidu.tieba.NEGFeedBack.e(this.hNx.getPageContext(), this.hUw);
            }
            AntiData bli = this.hNx.bli();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bli != null && bli.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bli.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.b(sparseArray);
            this.fWb.setDefaultReasonArray(new String[]{this.hNx.getString(R.string.delete_thread_reason_1), this.hNx.getString(R.string.delete_thread_reason_2), this.hNx.getString(R.string.delete_thread_reason_3), this.hNx.getString(R.string.delete_thread_reason_4), this.hNx.getString(R.string.delete_thread_reason_5)});
            this.fWb.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fWb.rJ(str);
            this.fWb.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    aq.this.hNx.a(aVar, jSONArray);
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
        sparseArray.put(hWj, Integer.valueOf(hWk));
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
        this.hVt = new com.baidu.tbadk.core.dialog.a(this.hNx.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hVt.hu(i3);
        } else {
            this.hVt.dV(false);
            this.hVt.mO(str2);
        }
        this.hVt.ab(sparseArray);
        this.hVt.a(R.string.dialog_ok, this.hNx);
        this.hVt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hVt.dQ(true);
        this.hVt.b(this.hNx.getPageContext());
        if (z) {
            this.hVt.agK();
        } else {
            a(this.hVt, i);
        }
    }

    public void ax(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hVw == null) {
            this.hVw = LayoutInflater.from(this.hNx.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.hNx.getLayoutMode().onModeChanged(this.hVw);
        if (this.hVv == null) {
            this.hVv = new Dialog(this.hNx.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hVv.setCanceledOnTouchOutside(true);
            this.hVv.setCancelable(true);
            this.hVE = (ScrollView) this.hVw.findViewById(R.id.good_scroll);
            this.hVv.setContentView(this.hVw);
            WindowManager.LayoutParams attributes = this.hVv.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.g(this.hNx.getPageContext().getPageActivity(), R.dimen.ds540);
            this.hVv.getWindow().setAttributes(attributes);
            this.eEZ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hVA = (String) compoundButton.getTag();
                        if (aq.this.eEY != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.eEY) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hVA != null && !str.equals(aq.this.hVA)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hVx = (LinearLayout) this.hVw.findViewById(R.id.good_class_group);
            this.hVz = (TextView) this.hVw.findViewById(R.id.dialog_button_cancel);
            this.hVz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hVv instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hVv, aq.this.hNx.getPageContext());
                    }
                }
            });
            this.hVy = (TextView) this.hVw.findViewById(R.id.dialog_button_ok);
            this.hVy.setOnClickListener(this.fwx);
        }
        this.hVx.removeAllViews();
        this.eEY = new ArrayList();
        CustomBlueCheckRadioButton dN = dN("0", this.hNx.getPageContext().getString(R.string.thread_good_class));
        this.eEY.add(dN);
        dN.setChecked(true);
        this.hVx.addView(dN);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.acY()) && acVar.acZ() > 0) {
                    CustomBlueCheckRadioButton dN2 = dN(String.valueOf(acVar.acZ()), acVar.acY());
                    this.eEY.add(dN2);
                    View view = new View(this.hNx.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.hNx.getPageContext().getPageActivity(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.l(view, R.color.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hVx.addView(view);
                    this.hVx.addView(dN2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hVE.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hNx.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hNx.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hNx.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hVE.setLayoutParams(layoutParams2);
            this.hVE.removeAllViews();
            if (this.hVx != null && this.hVx.getParent() == null) {
                this.hVE.addView(this.hVx);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hVv, this.hNx.getPageContext());
    }

    private CustomBlueCheckRadioButton dN(String str, String str2) {
        Activity pageActivity = this.hNx.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.eEZ);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bXD() {
        this.hNx.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hNx.hideProgressBar();
        if (z && z2) {
            this.hNx.showToast(this.hNx.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.hNx.showToast(str);
        }
    }

    public void bEW() {
        this.hVp.setVisibility(0);
    }

    public void bEV() {
        this.hVp.setVisibility(8);
    }

    public View bXE() {
        if (this.hVw != null) {
            return this.hVw.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String bXF() {
        return this.hVA;
    }

    public View getView() {
        return this.evb;
    }

    public void bXG() {
        com.baidu.adp.lib.util.l.b(this.hNx.getPageContext().getPageActivity(), this.hNx.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hNx.hideProgressBar();
        if (z) {
            bXY();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bXZ();
        } else {
            bXY();
        }
    }

    public void bXH() {
        this.fAR.akB();
        this.fAR.akF();
    }

    public void bXI() {
        this.hNx.hideProgressBar();
        akG();
        this.hUu.completePullRefreshPostDelayed(0L);
        bXT();
    }

    public void bXJ() {
        this.hUu.completePullRefreshPostDelayed(0L);
        bXT();
    }

    private void oS(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hVj.setOnLongClickListener(onLongClickListener);
        if (this.hWE != null) {
            this.hWE.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.hLC != null) {
            this.hLC.dismiss();
            this.hLC = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hNx);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hNx.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNx.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNx.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNx.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hVB.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hVB = new com.baidu.tbadk.core.dialog.i(this.hNx.getPageContext(), kVar.ahd());
        this.hVB.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.hVB != null) {
            this.hVB.dismiss();
            this.hVB = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hNx);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hNx.getPageContext().getString(R.string.save_to_emotion), kVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hNx.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hVB.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hVB = new com.baidu.tbadk.core.dialog.i(this.hNx.getPageContext(), kVar.ahd());
        this.hVB.showDialog();
    }

    public int bXK() {
        return yg(this.hUu.getFirstVisiblePosition());
    }

    private int yg(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hUu.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int od = (this.hUu.getAdapter() == null || !(this.hUu.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hUu.getAdapter().od();
            return i > od ? i - od : 0;
        }
        return i;
    }

    public int bXL() {
        int lastVisiblePosition = this.hUu.getLastVisiblePosition();
        if (this.hUk != null) {
            if (lastVisiblePosition == this.hUu.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return yg(lastVisiblePosition);
    }

    public void yh(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.hUu != null) {
            if (this.hUq == null || this.hUq.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hUq.mNavigationBar.getFixedNavHeight();
                if (!(this.hNx.bUw() != -1)) {
                    if (this.hWa != null && (layoutParams = (LinearLayout.LayoutParams) this.hWa.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hWa.setLayoutParams(layoutParams);
                    }
                    i--;
                    bYt();
                }
                i2 = fixedNavHeight;
            }
            this.hUu.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hUu.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hUu.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hVm.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hVj.a(dVar, false);
        this.hVj.notifyDataSetChanged();
        bXT();
        if (this.hWE != null) {
            this.hWE.bTN();
        }
        ArrayList<PostData> bSN = dVar.bSN();
        if (dVar.getPage().ads() == 0 || bSN == null || bSN.size() < dVar.getPage().adr()) {
            if (com.baidu.tbadk.core.util.v.Z(bSN) == 0 || (com.baidu.tbadk.core.util.v.Z(bSN) == 1 && bSN.get(0) != null && bSN.get(0).cpL() == 1)) {
                if (this.hWf == null || this.hWf.hXp == null || this.hWf.hXp.getView() == null) {
                    i = 0;
                } else {
                    i = this.hWf.hXp.getView().getTop() < 0 ? this.hWf.hXp.getView().getHeight() : this.hWf.hXp.getView().getBottom();
                }
                if (this.hNx.bUU()) {
                    this.fAR.W(this.hNx.getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.fAR.W(this.hNx.getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().ads() == 0) {
                    this.fAR.setText(this.hNx.getResources().getString(R.string.list_has_no_more));
                } else {
                    this.fAR.setText(this.hNx.getResources().getString(R.string.load_more));
                }
                this.fAR.akK();
            }
        }
        o(dVar);
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        if (this.hUS == null) {
            this.hNx.getLayoutMode().onModeChanged(((ViewStub) this.hUw.findViewById(R.id.praise_layout)).inflate());
            this.hUS = (FrsPraiseView) this.hUw.findViewById(R.id.pb_head_praise_view);
            this.hUS.setIsFromPb(true);
            this.hVh = this.hUw.findViewById(R.id.new_pb_header_item_line_above_praise);
            this.hUS.jd(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hUS != null) {
            boolean bXT = bXT();
            this.hUS.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().adt() == 0 && this.hNO) {
                if (bXT) {
                    this.hVg.setVisibility(0);
                    return;
                } else {
                    this.hVg.setVisibility(8);
                    return;
                }
            }
            this.hVg.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bSV() != null) {
            return dVar.bSV();
        }
        if (!com.baidu.tbadk.core.util.v.aa(dVar.bSN())) {
            Iterator<PostData> it = dVar.bSN().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cpL() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bSS();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aey() != null && postData.aey().getUserTbVipInfoData() != null && postData.aey().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aey().getGodUserData().setIntro(postData.aey().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bSL() == null || dVar.bSL().aey() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aey = dVar.bSL().aey();
        String userId = aey.getUserId();
        HashMap<String, MetaData> userMap = dVar.bSL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aey;
        }
        postData.Bg(1);
        postData.setId(dVar.bSL().aeO());
        postData.setTitle(dVar.bSL().getTitle());
        postData.setTime(dVar.bSL().getCreateTime());
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
        String j;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.f cpO;
        String portrait;
        String charSequence;
        if (dVar != null && dVar.bSL() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hUI.setVisibility(8);
            if (dVar.bSL() != null && dVar.bSL().afs() && dVar.bSL().aeP() != null) {
                this.hWt = true;
                this.hUq.pn(this.hWt);
                this.hUq.mNavigationBar.hideBottomLine();
                if (this.hUk == null) {
                    this.hUk = new com.baidu.tieba.pb.video.i(this.hNx, this.hUq, dVar.bSL().aeP(), this.hUl);
                    this.hUk.a(dVar.bSL().aeP(), dVar.bSL(), dVar.getForumId());
                    this.hUk.startPlay();
                } else if (this.hUo) {
                    this.hUk.a(dVar.bSL().aeP(), dVar.bSL(), dVar.getForumId());
                    this.hUk.startPlay();
                } else {
                    this.hUk.Cu(dVar.getForumId());
                }
                com.baidu.tieba.pb.c.a.a(this.hNx.getUniqueId(), dVar, c, 1, 1);
                if (dVar.bSM() != null && dVar.bSM().size() >= 1) {
                    bh bhVar = dVar.bSM().get(0);
                    this.hUk.aC(bhVar);
                    this.hUk.Cv(bhVar.getTitle());
                }
                this.hUk.b(c, dVar.bSL(), dVar.bTi());
                this.hUo = false;
                this.hUu.removeHeaderView(this.hUk.cao());
                this.hUu.addHeaderView(this.hUk.cao(), 0);
                if (this.hUk.aJu() != null && this.hUk.aJu().getParent() == null) {
                    this.hVY.addView(this.hUk.aJu());
                }
                if (this.hUm == null) {
                    this.hUm = new com.baidu.tieba.pb.video.h(this.hNx);
                }
                this.hUm.a(dVar.bSL().afI(), dVar.bSL(), dVar.bTf());
                this.hUu.removeHeaderView(this.hUm.cab());
                this.hUu.addHeaderView(this.hUm.cab(), 1);
                if (dVar.bSL().afI() != null) {
                    this.hUu.removeHeaderView(this.hUm.cac());
                    this.hUu.removeHeaderView(this.hUE);
                    this.hUu.addHeaderView(this.hUm.cac(), 2);
                } else {
                    if (this.hUm.cac() != null) {
                        this.hUu.removeHeaderView(this.hUm.cac());
                    }
                    this.hUu.removeHeaderView(this.hUE);
                    this.hUu.addHeaderView(this.hUE, 2);
                }
                if (this.hUk != null) {
                    this.hUq.pj(false);
                    this.hUk.yo(TbadkCoreApplication.getInst().getSkinType());
                }
                bXP();
            } else {
                this.hWt = false;
                this.hUq.pn(this.hWt);
                if (this.hUk != null) {
                    this.hUu.removeHeaderView(this.hUk.cao());
                }
                if (this.hUm != null) {
                    this.hUm.b(this.hUu);
                }
            }
            if (this.hNx.bUh() != null) {
                this.hNx.bUh().ph(this.hWt);
            }
            if (this.hUk != null) {
                this.hUk.R(this.hWW);
                bYt();
            }
            if (c != null) {
                this.hVQ = c;
                this.hUI.setVisibility(0);
                if (this.hNx.bTH()) {
                    if (dVar.bSK() != null) {
                        this.mForumName = dVar.bSK().getForumName();
                        this.mForumId = dVar.bSK().getForumId();
                    }
                    if (this.mForumName == null && this.hNx.bTR() != null && this.hNx.bTR().bTI() != null) {
                        this.mForumName = this.hNx.bTR().bTI();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hUI.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hUI.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_clip_board, c);
                sparseArray.put(R.id.tag_is_subpb, false);
                if (dVar.bSL().afs() && dVar.bSL().afk() != null) {
                    SmartApp afk = dVar.bSL().afk();
                    this.hUx.setVisibility(0);
                    this.hUu.removeHeaderView(this.hUx);
                    this.hUu.addHeaderView(this.hUx, 1);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(afk.avatar)) {
                        this.hUy.startLoad(afk.avatar, 10, false, false);
                    }
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(afk.name)) {
                        charSequence = afk.name + " " + ((Object) this.hNx.getText(R.string.smart_app_suffix));
                    } else {
                        charSequence = this.hNx.getText(R.string.intelligent_smart_app).toString();
                    }
                    this.hUz.setText(charSequence);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(afk._abstract)) {
                        this.hUA.setText(afk._abstract);
                    } else {
                        this.hUA.setText(this.hNx.getText(R.string.smart_app_default_abstract));
                    }
                    this.hUx.setTag(afk);
                } else {
                    this.hUx.setVisibility(8);
                    this.hUu.removeHeaderView(this.hUx);
                }
                if (!this.hWL) {
                    this.hUC.setVisibility(0);
                }
                if (!dVar.bSL().afs() && this.hUD.getText() != null && this.hUD.getText().length() > 0) {
                    this.hUD.setVisibility(0);
                } else {
                    this.hUD.setVisibility(8);
                }
                n(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> aeJ = dVar.bSL().aeJ();
                if (aeJ != null && aeJ.size() > 0 && !this.hWL) {
                    this.hVT.setText(String.valueOf(aeJ.get(0).acF()));
                    this.hVS.setVisibility(0);
                } else {
                    this.hVS.setVisibility(8);
                }
                com.baidu.tbadk.core.util.am.k(this.hVS, R.drawable.activity_join_num_bg);
                com.baidu.tbadk.core.util.am.f(this.hVT, R.color.cp_link_tip_d, 1);
                if (c.aey() != null) {
                    String string = c.aey().getName_show() == null ? StringUtils.string(c.aey().getUserName()) : StringUtils.string(c.aey().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(c.aey().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bk(c.aey().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bk(string) > 12) {
                            j = com.baidu.tbadk.core.util.aq.j(string, 12, "...");
                            ArrayList<IconData> iconInfo = c.aey().getIconInfo();
                            tShowInfoNew = c.aey().getTShowInfoNew();
                            if (this.hOL != null) {
                                this.hOL.setTag(R.id.tag_user_id, c.aey().getUserId());
                                this.hOL.setOnClickListener(this.hNx.hLx.hYP);
                                this.hOL.a(iconInfo, 4, this.hNx.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNx.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNx.getResources().getDimensionPixelSize(R.dimen.tbds12));
                            }
                            if (this.hOK != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hOK.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hOK.setOnClickListener(this.hNx.hLx.hYQ);
                                this.hOK.a(tShowInfoNew, 3, this.hNx.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNx.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hNx.getResources().getDimensionPixelSize(R.dimen.ds12), true);
                            }
                            this.hUK.setText(bY(c.aey().getSealPrefix(), j));
                            this.hUK.setTag(R.id.tag_user_id, c.aey().getUserId());
                            this.hUK.setTag(R.id.tag_user_name, c.aey().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || c.aey().isBigV()) {
                                com.baidu.tbadk.core.util.am.f(this.hUK, R.color.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.am.f(this.hUK, R.color.cp_cont_b, 1);
                            }
                            if (c.aey() == null) {
                                MetaData aey = c.aey();
                                if (aey.getIs_bawu() == 1 && "manager".equals(aey.getBawu_type())) {
                                    this.hUL.setText(R.string.bawu_member_bazhu_tip);
                                    this.hUL.setVisibility(0);
                                    this.hWJ = R.drawable.author_bazhu_bg;
                                    com.baidu.tbadk.core.util.am.k(this.hUL, this.hWJ);
                                } else if (aey.getIs_bawu() == 1 && "assist".equals(aey.getBawu_type())) {
                                    this.hUL.setText(R.string.bawu_member_xbazhu_tip);
                                    this.hUL.setVisibility(0);
                                    this.hWJ = R.drawable.author_small_bazhu;
                                    com.baidu.tbadk.core.util.am.k(this.hUL, this.hWJ);
                                } else {
                                    this.hUL.setVisibility(8);
                                }
                            } else {
                                this.hUL.setVisibility(8);
                            }
                            if (dVar.bSL().aey() != null && dVar.bSL().aey().getAlaUserData() != null && this.hUQ != null) {
                                if (dVar.bSL().aey().getAlaUserData().anchor_live != 0) {
                                    this.hUQ.setVisibility(8);
                                } else {
                                    this.hUQ.setVisibility(0);
                                    if (this.hUn == null) {
                                        this.hUn = new com.baidu.tieba.c.d(this.hNx.getPageContext(), this.hUQ);
                                        this.hUn.qe(1);
                                    }
                                    this.hUn.cI(this.hNx.getResources().getString(R.string.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bAN = dVar.bSL().aey().getAlaUserData();
                                    aVar.type = 2;
                                    this.hUQ.setTag(aVar);
                                }
                            }
                            this.hUP.setUserId(c.aey().getUserId());
                            this.hUP.setUserName(c.aey().getUserName());
                            this.hUP.setTid(c.getId());
                            this.hUP.setFid(this.hQT == null ? this.hQT.getForumId() : "");
                            this.hUP.setImageDrawable(null);
                            this.hUP.setRadius(com.baidu.adp.lib.util.l.g(this.hNx.getActivity(), R.dimen.ds40));
                            this.hUP.setTag(c.aey().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hUX.setText(com.baidu.tbadk.core.util.aq.aF(c.getTime()));
                            } else {
                                this.hUX.setText(com.baidu.tbadk.core.util.aq.aD(c.getTime()));
                            }
                            cpO = c.cpO();
                            if (cpO == null && !TextUtils.isEmpty(cpO.getName()) && !TextUtils.isEmpty(cpO.getName().trim())) {
                                this.hUY.setVisibility(0);
                                this.hUZ.setVisibility(0);
                                this.hUY.setText(cpO.getName());
                            } else {
                                this.hUY.setVisibility(8);
                                this.hUZ.setVisibility(8);
                            }
                            portrait = c.aey().getPortrait();
                            if (c.aey().getPendantData() == null && !StringUtils.isNull(c.aey().getPendantData().acV())) {
                                this.hUN.b(c.aey());
                                this.hUP.setVisibility(8);
                                this.hUN.setVisibility(0);
                                if (this.hUT != null) {
                                    this.hUT.setVisibility(8);
                                }
                                this.hUK.setOnClickListener(this.hWW);
                                this.hUN.getHeadView().startLoad(portrait, 28, false);
                                this.hUN.getHeadView().setUserId(c.aey().getUserId());
                                this.hUN.getHeadView().setUserName(c.aey().getUserName());
                                this.hUN.getHeadView().setTid(c.getId());
                                this.hUN.getHeadView().setFid(this.hQT != null ? this.hQT.getForumId() : "");
                                this.hUN.getHeadView().setOnClickListener(this.hWW);
                                this.hUN.oN(c.aey().getPendantData().acV());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hUP, c.aey());
                                this.hUP.setVisibility(0);
                                this.hUI.setOnClickListener(this.hWW);
                                this.hUK.setOnClickListener(this.hWW);
                                this.hUP.setOnClickListener(this.hWW);
                                this.hUN.setVisibility(8);
                                this.hUP.startLoad(portrait, 28, false);
                            }
                            String name_show = c.aey().getName_show();
                            String userName = c.aey().getUserName();
                            if (com.baidu.tbadk.t.as.iN() && name_show != null && !name_show.equals(userName)) {
                                this.hUK.setText(com.baidu.tieba.pb.c.aE(this.hNx.getPageContext().getPageActivity(), this.hUK.getText().toString()));
                                this.hUK.setGravity(16);
                                this.hUK.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bSu());
                                com.baidu.tbadk.core.util.am.f(this.hUK, R.color.cp_other_e, 1);
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo2 = c.aey().getIconInfo();
                        tShowInfoNew = c.aey().getTShowInfoNew();
                        if (this.hOL != null) {
                        }
                        if (this.hOK != null) {
                        }
                        this.hUK.setText(bY(c.aey().getSealPrefix(), j));
                        this.hUK.setTag(R.id.tag_user_id, c.aey().getUserId());
                        this.hUK.setTag(R.id.tag_user_name, c.aey().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.f(this.hUK, R.color.cp_cont_h, 1);
                        if (c.aey() == null) {
                        }
                        if (dVar.bSL().aey() != null) {
                            if (dVar.bSL().aey().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hUP.setUserId(c.aey().getUserId());
                        this.hUP.setUserName(c.aey().getUserName());
                        this.hUP.setTid(c.getId());
                        this.hUP.setFid(this.hQT == null ? this.hQT.getForumId() : "");
                        this.hUP.setImageDrawable(null);
                        this.hUP.setRadius(com.baidu.adp.lib.util.l.g(this.hNx.getActivity(), R.dimen.ds40));
                        this.hUP.setTag(c.aey().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cpO = c.cpO();
                        if (cpO == null) {
                        }
                        this.hUY.setVisibility(8);
                        this.hUZ.setVisibility(8);
                        portrait = c.aey().getPortrait();
                        if (c.aey().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hUP, c.aey());
                        this.hUP.setVisibility(0);
                        this.hUI.setOnClickListener(this.hWW);
                        this.hUK.setOnClickListener(this.hWW);
                        this.hUP.setOnClickListener(this.hWW);
                        this.hUN.setVisibility(8);
                        this.hUP.startLoad(portrait, 28, false);
                        String name_show2 = c.aey().getName_show();
                        String userName2 = c.aey().getUserName();
                        if (com.baidu.tbadk.t.as.iN()) {
                            this.hUK.setText(com.baidu.tieba.pb.c.aE(this.hNx.getPageContext().getPageActivity(), this.hUK.getText().toString()));
                            this.hUK.setGravity(16);
                            this.hUK.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bSu());
                            com.baidu.tbadk.core.util.am.f(this.hUK, R.color.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bk(string) > 14) {
                            j = com.baidu.tbadk.core.util.aq.j(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.aey().getIconInfo();
                            tShowInfoNew = c.aey().getTShowInfoNew();
                            if (this.hOL != null) {
                            }
                            if (this.hOK != null) {
                            }
                            this.hUK.setText(bY(c.aey().getSealPrefix(), j));
                            this.hUK.setTag(R.id.tag_user_id, c.aey().getUserId());
                            this.hUK.setTag(R.id.tag_user_name, c.aey().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.am.f(this.hUK, R.color.cp_cont_h, 1);
                            if (c.aey() == null) {
                            }
                            if (dVar.bSL().aey() != null) {
                            }
                            this.hUP.setUserId(c.aey().getUserId());
                            this.hUP.setUserName(c.aey().getUserName());
                            this.hUP.setTid(c.getId());
                            this.hUP.setFid(this.hQT == null ? this.hQT.getForumId() : "");
                            this.hUP.setImageDrawable(null);
                            this.hUP.setRadius(com.baidu.adp.lib.util.l.g(this.hNx.getActivity(), R.dimen.ds40));
                            this.hUP.setTag(c.aey().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            cpO = c.cpO();
                            if (cpO == null) {
                            }
                            this.hUY.setVisibility(8);
                            this.hUZ.setVisibility(8);
                            portrait = c.aey().getPortrait();
                            if (c.aey().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hUP, c.aey());
                            this.hUP.setVisibility(0);
                            this.hUI.setOnClickListener(this.hWW);
                            this.hUK.setOnClickListener(this.hWW);
                            this.hUP.setOnClickListener(this.hWW);
                            this.hUN.setVisibility(8);
                            this.hUP.startLoad(portrait, 28, false);
                            String name_show22 = c.aey().getName_show();
                            String userName22 = c.aey().getUserName();
                            if (com.baidu.tbadk.t.as.iN()) {
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo222 = c.aey().getIconInfo();
                        tShowInfoNew = c.aey().getTShowInfoNew();
                        if (this.hOL != null) {
                        }
                        if (this.hOK != null) {
                        }
                        this.hUK.setText(bY(c.aey().getSealPrefix(), j));
                        this.hUK.setTag(R.id.tag_user_id, c.aey().getUserId());
                        this.hUK.setTag(R.id.tag_user_name, c.aey().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.f(this.hUK, R.color.cp_cont_h, 1);
                        if (c.aey() == null) {
                        }
                        if (dVar.bSL().aey() != null) {
                        }
                        this.hUP.setUserId(c.aey().getUserId());
                        this.hUP.setUserName(c.aey().getUserName());
                        this.hUP.setTid(c.getId());
                        this.hUP.setFid(this.hQT == null ? this.hQT.getForumId() : "");
                        this.hUP.setImageDrawable(null);
                        this.hUP.setRadius(com.baidu.adp.lib.util.l.g(this.hNx.getActivity(), R.dimen.ds40));
                        this.hUP.setTag(c.aey().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cpO = c.cpO();
                        if (cpO == null) {
                        }
                        this.hUY.setVisibility(8);
                        this.hUZ.setVisibility(8);
                        portrait = c.aey().getPortrait();
                        if (c.aey().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hUP, c.aey());
                        this.hUP.setVisibility(0);
                        this.hUI.setOnClickListener(this.hWW);
                        this.hUK.setOnClickListener(this.hWW);
                        this.hUP.setOnClickListener(this.hWW);
                        this.hUN.setVisibility(8);
                        this.hUP.startLoad(portrait, 28, false);
                        String name_show222 = c.aey().getName_show();
                        String userName222 = c.aey().getUserName();
                        if (com.baidu.tbadk.t.as.iN()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hUH.au(dVar.bSL());
                }
                if (this.hWb != null) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hJe);
                    if (dVar != null && dVar.bSL() != null) {
                        iVar.hJg = dVar.bSL().aep();
                    }
                    iVar.isNew = !this.hNO;
                    iVar.sortType = dVar.hIM;
                    if (dVar.hIL != null && dVar.hIL.size() > dVar.hIM) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hIL.size()) {
                                break;
                            } else if (dVar.hIL.get(i4).sort_type.intValue() != dVar.hIM) {
                                i3 = i4 + 1;
                            } else {
                                iVar.hJi = dVar.hIL.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    iVar.hJj = this.hNx.bUU();
                    this.hWb.a(iVar);
                }
                if (dVar != null && dVar.bSL() != null) {
                    ad(dVar.bSL().aeu() == 1, dVar.bSL().aet() == 1);
                }
                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hVj != null && aq.this.hUq != null && aq.this.hUq.hZP != null && aq.this.hQT != null && aq.this.hQT.bSL() != null && !aq.this.hQT.bSL().afs() && !aq.this.bXS() && aq.this.hQT.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(aq.this.hQT.getForum().getName())) {
                            if (aq.this.hVj.bVt() == null || !aq.this.hVj.bVt().isShown()) {
                                aq.this.hUq.hZP.setVisibility(0);
                                if (aq.this.hNx != null && aq.this.hNx.bTR() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.bT("tid", aq.this.hNx.bTR().bVL());
                                    anVar.bT("fid", aq.this.hNx.bTR().getForumId());
                                    anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void oT(boolean z) {
        if (z) {
            bXM();
        } else {
            bgj();
        }
        this.hWf.hXp = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hWf));
        a(this.hWf.hXp, false);
    }

    public void bXM() {
        if (this.hUq != null && !this.hWv) {
            this.hUq.po(!StringUtils.isNull(this.hNx.bUt()));
            this.hWv = true;
        }
    }

    public void bgj() {
        if (this.hUq != null) {
            this.hUq.bYZ();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.aeT() != null) {
            this.hUJ.setData(this.hNx.getPageContext(), dVar.bSN().get(0).aeT(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bSL().getId(), this.hNx.bUR() ? "FRS" : null));
            this.hUI.setPadding(this.hUI.getPaddingLeft(), (int) this.hNx.getResources().getDimension(R.dimen.ds20), this.hUI.getPaddingRight(), this.hUI.getPaddingBottom());
            return;
        }
        this.hUJ.setData(null, null, null);
    }

    public void bXN() {
        if (this.hUk != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11997").P("obj_type", 1));
            this.hUk.cam();
            this.hUu.smoothScrollToPosition(0);
        }
    }

    public boolean bXO() {
        return this.hWX;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aw(bh bhVar) {
        if (bhVar == null || bhVar.aey() == null || bhVar.aey().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.aey().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.hUq.bYX();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hUq.zT(cVar.forumName);
            }
            String string = this.hNx.getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.f(cVar.source, 0)) {
                case 100:
                    str = this.hNx.getResources().getString(R.string.self);
                    break;
                case 300:
                    str = this.hNx.getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = this.hNx.getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hIf;
            this.hNx.showNetRefreshView(this.evb, format, null, this.hNx.getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.kt()) {
                        bb.ajE().c(aq.this.hNx.getPageContext(), new String[]{str2});
                        aq.this.hNx.finish();
                        return;
                    }
                    aq.this.hNx.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bWW;
        Parcelable bWW2;
        if (dVar != null) {
            this.hQT = dVar;
            this.mType = i;
            if (dVar.bSL() != null) {
                this.hWh = dVar.bSL().aeg();
                if (dVar.bSL().getAnchorLevel() != 0) {
                    this.hWX = true;
                }
                this.hVD = aw(dVar.bSL());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.hVR = false;
            this.hNO = z;
            bXI();
            if (dVar.hIN != null && dVar.hIN.bTm()) {
                if (this.hUv == null) {
                    this.hUv = new PbThreadPostView(this.hNx);
                    this.hUu.addHeaderView(this.hUv, 1);
                    this.hUv.setData(dVar);
                    this.hUv.setChildOnClickLinstener(this.fwx);
                }
            } else if (this.hUv != null && this.hUu != null) {
                this.hUu.removeHeaderView(this.hUv);
            }
            b(dVar, z, i);
            p(dVar);
            if (this.hWH == null) {
                this.hWH = new ac(this.hNx.getPageContext(), this.fTi);
            }
            this.hWH.BZ(dVar.bSQ());
            if (this.hNx.bUI()) {
                if (this.hVn == null) {
                    this.hVn = new com.baidu.tieba.pb.view.c(this.hNx.getPageContext());
                    this.hVn.nZ();
                    this.hVn.setListPullRefreshListener(this.caJ);
                }
                this.hUu.setPullRefresh(this.hVn);
                bXP();
                if (this.hVn != null) {
                    this.hVn.iV(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().adt() == 0 && z) {
                this.hUu.setPullRefresh(null);
            } else {
                if (this.hVn == null) {
                    this.hVn = new com.baidu.tieba.pb.view.c(this.hNx.getPageContext());
                    this.hVn.nZ();
                    this.hVn.setListPullRefreshListener(this.caJ);
                }
                this.hUu.setPullRefresh(this.hVn);
                bXP();
                if (this.hVn != null) {
                    this.hVn.iV(TbadkCoreApplication.getInst().getSkinType());
                }
                aUB();
            }
            bXT();
            this.hVj.oh(this.hNO);
            this.hVj.oi(false);
            this.hVj.ot(i == 5);
            this.hVj.ou(i == 6);
            this.hVj.ov(z2 && this.hWV);
            this.hVj.a(dVar, false);
            this.hVj.notifyDataSetChanged();
            if (this.hNx.bTH()) {
                this.hWx = 0;
                PostData c = c(dVar, z);
                if (c != null && c.aey() != null) {
                    this.hWx = c.aey().getLevel_id();
                }
                if (this.hWx > 0) {
                    this.hUM.setVisibility(0);
                    com.baidu.tbadk.core.util.am.c(this.hUM, BitmapHelper.getGradeResourceIdInEnterForum(this.hWx));
                } else {
                    this.hUM.setVisibility(8);
                }
            } else {
                this.hUM.setVisibility(8);
            }
            if (dVar.bSL() != null && dVar.bSL().aek() != null) {
                if (dVar.bSL().aek().getNum() < 1) {
                    this.hNx.getResources().getString(R.string.zan);
                } else {
                    String str = dVar.bSL().aek().getNum() + "";
                }
                if (this.hUj != -1) {
                    dVar.bSL().aek().setIsLike(this.hUj);
                }
            }
            if (this.hNx.isLogin()) {
                this.hUu.setNextPage(this.fAR);
                this.hUp = 2;
                aUB();
            } else {
                this.hVR = true;
                if (dVar.getPage().ads() == 1) {
                    if (this.hVo == null) {
                        this.hVo = new com.baidu.tieba.pb.view.a(this.hNx.getPageContext());
                    }
                    this.hUu.setNextPage(this.hVo);
                } else {
                    this.hUu.setNextPage(this.fAR);
                }
                this.hUp = 3;
            }
            ArrayList<PostData> bSN = dVar.bSN();
            if (dVar.getPage().ads() == 0 || bSN == null || bSN.size() < dVar.getPage().adr()) {
                if (com.baidu.tbadk.core.util.v.Z(bSN) == 0 || (com.baidu.tbadk.core.util.v.Z(bSN) == 1 && bSN.get(0) != null && bSN.get(0).cpL() == 1)) {
                    if (this.hWf == null || this.hWf.hXp == null || this.hWf.hXp.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hWf.hXp.getView().getTop() < 0 ? this.hWf.hXp.getView().getHeight() : this.hWf.hXp.getView().getBottom();
                    }
                    if (this.hNx.bUU()) {
                        this.fAR.W(this.hNx.getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.fAR.W(this.hNx.getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.hNx.bUh() != null && !this.hNx.bUh().bYM()) {
                        this.hNx.bUh().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().ads() == 0) {
                        this.fAR.setText(this.hNx.getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.fAR.setText(this.hNx.getResources().getString(R.string.load_more));
                    }
                    this.fAR.akK();
                }
                bYc();
            } else {
                if (z2) {
                    if (this.hWV) {
                        akG();
                        if (dVar.getPage().ads() != 0) {
                            this.fAR.setText(this.hNx.getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.fAR.akB();
                        this.fAR.showLoading();
                    }
                } else {
                    this.fAR.akB();
                    this.fAR.showLoading();
                }
                this.fAR.akK();
            }
            switch (i) {
                case 2:
                    this.hUu.setSelection(i2 > 1 ? (((this.hUu.getData() == null && dVar.bSN() == null) ? 0 : (this.hUu.getData().size() - dVar.bSN().size()) + this.hUu.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bWW2 = aj.bWV().bWW()) != null) {
                        this.hUu.onRestoreInstanceState(bWW2);
                        if (com.baidu.tbadk.core.util.v.Z(bSN) > 1 && dVar.getPage().ads() > 0) {
                            this.fAR.akG();
                            this.fAR.setText(this.hNx.getString(R.string.pb_load_more_without_point));
                            this.fAR.akC();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hWV = false;
                    break;
                case 5:
                    this.hUu.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bWW = aj.bWV().bWW()) != null) {
                        this.hUu.onRestoreInstanceState(bWW);
                        break;
                    } else {
                        this.hUu.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.hUk != null && this.hUk.aJu() != null) {
                            if (this.hNx.isUseStyleImmersiveSticky()) {
                                this.hUu.setSelectionFromTop((this.hVj.bVo() + this.hUu.getHeaderViewsCount()) - 1, this.hUk.aJu().getHeight() - com.baidu.adp.lib.util.l.u(this.hNx.getPageContext().getPageActivity()));
                            } else {
                                this.hUu.setSelectionFromTop((this.hVj.bVo() + this.hUu.getHeaderViewsCount()) - 1, this.hUk.aJu().getHeight());
                            }
                        } else {
                            this.hUu.setSelection(this.hVj.bVo() + this.hUu.getHeaderViewsCount());
                        }
                    } else {
                        this.hUu.setSelection(i2 > 0 ? ((this.hUu.getData() == null && dVar.bSN() == null) ? 0 : (this.hUu.getData().size() - dVar.bSN().size()) + this.hUu.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.fAR.akG();
                    this.fAR.setText(this.hNx.getString(R.string.pb_load_more_without_point));
                    this.fAR.akC();
                    break;
            }
            if (this.hWh == hWi && isHost()) {
                bYk();
            }
            if (this.hWr) {
                bXg();
                this.hWr = false;
                if (i3 == 0) {
                    oN(true);
                }
            }
            if (this.hUm != null) {
                this.hUm.aB(dVar.bSL());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hIJ == 1 || dVar.hIK == 1) {
                if (this.hWy == null) {
                    this.hWy = new PbTopTipView(this.hNx);
                }
                if (dVar.hIK == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hNx.getStType())) {
                    this.hWy.setText(this.hNx.getString(R.string.pb_read_strategy_add_experience));
                    this.hWy.show(this.evb, this.mSkinType);
                } else if (dVar.hIJ == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hNx.getStType())) {
                    this.hWy.setText(this.hNx.getString(R.string.pb_read_news_add_experience));
                    this.hWy.show(this.evb, this.mSkinType);
                }
            }
            o(dVar);
        }
    }

    private void o(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bSL() != null) {
            if (dVar.aaB()) {
                com.baidu.tbadk.core.util.am.c(this.hVK, (int) R.drawable.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.am.c(this.hVK, (int) R.drawable.icon_pb_bottom_collect_n);
            }
            this.hVM.setText(yi(dVar.bSL().aep()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, dVar.bSL()));
        }
    }

    private String yi(int i) {
        if (i == 0) {
            return this.hNx.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void bXP() {
        if (this.hUk != null && this.hUk.aJu() != null) {
            this.hUu.removeHeaderView(this.textView);
            if (this.mType != 1) {
                this.hUu.removeHeaderView(this.hUk.cao());
                this.hUu.addHeaderView(this.hUk.cao(), 0);
                return;
            }
            return;
        }
        if (this.hUk != null) {
            this.hUu.removeHeaderView(this.hUk.cao());
        }
        this.hUu.removeHeaderView(this.textView);
        this.hUu.addHeaderView(this.textView, 0);
    }

    public void oU(boolean z) {
        this.hVC = z;
    }

    public void akG() {
        if (this.fAR != null) {
            this.fAR.akC();
            this.fAR.akG();
        }
        aUB();
    }

    public void aVR() {
        this.hUu.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hVQ != null && this.hVQ.aey() != null && this.hUq != null) {
            this.hWu = !this.hWt;
            this.hUq.pj(this.hWu);
            if (this.hNx.bUh() != null) {
                this.hNx.bUh().pi(this.hWu);
            }
            bXQ();
            if (this.hNx != null && !this.hNx.bTH() && !com.baidu.tbadk.core.util.v.aa(dVar.bTg())) {
                bd bdVar = dVar.bTg().get(0);
                if (bdVar != null) {
                    this.hUq.dO(bdVar.getForumName(), bdVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hUq.dO(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hWu) {
                if (this.hVD) {
                    this.hUU.setVisibility(8);
                    this.hUW.setVisibility(0);
                    this.hUW.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.aJ(dVar.bTh())));
                }
                if (this.hWa != null) {
                    this.hWa.setVisibility(8);
                }
                if (this.hWF == null) {
                    this.hWF = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hWw) {
                                aq.this.bYj();
                            }
                            aq.this.bXJ();
                        }
                    };
                }
                this.hUu.setListViewDragListener(this.hWF);
            } else {
                if (this.hWa != null) {
                    this.hWa.setVisibility(0);
                }
                if (this.hVD) {
                    this.hUU.setVisibility(8);
                    this.hUW.setVisibility(0);
                    this.hUW.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.aJ(dVar.bTh())));
                } else if (!com.baidu.tbadk.t.au.avT() || (this.hVQ.aey().hadConcerned() && this.hVQ.aey().getGodUserData() != null && this.hVQ.aey().getGodUserData().getIsFromNetWork())) {
                    this.hUU.setVisibility(8);
                    this.hUW.setVisibility(8);
                } else {
                    this.hUW.setVisibility(8);
                }
                this.hWF = null;
                this.hUu.setListViewDragListener(null);
            }
            if (dVar.hIS) {
                this.hUU.setVisibility(8);
            }
        }
    }

    private void bXQ() {
        String threadId = this.hQT != null ? this.hQT.getThreadId() : "";
        int bXR = bXR();
        if (this.hWu && this.hVQ != null && this.hVQ.aey() != null) {
            this.hVQ.aey().setIsLike(this.hVQ.aey().hadConcerned());
        }
        if (this.hUV == null) {
            this.hUV = new ao(this.hNx.getPageContext(), this.hUU, 1);
            this.hUV.j(this.hNx.getUniqueId());
            this.hUV.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void ew(boolean z) {
                    if (aq.this.hNx != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hNx, (int) R.string.attention_success);
                    }
                }
            });
        }
        if (this.hVQ != null && this.hVQ.aey() != null) {
            this.hVQ.aey().setIsLike(this.hVQ.aey().hadConcerned());
            this.hUV.a(this.hVQ.aey());
            this.hUV.setTid(threadId);
        }
        this.hUV.hUf = this.hWt;
        this.hUV.yf(bXR);
    }

    public int bXR() {
        if (this.hQT == null || this.hQT.bSL() == null) {
            return 0;
        }
        if (this.hQT.bSL().afQ()) {
            return (com.baidu.tbadk.core.util.v.aa(this.hQT.bTg()) && (this.hQT.bSK() == null || StringUtils.isNull(this.hQT.bSK().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bXS() {
        return this.hQT == null || this.hQT.getForum() == null || "0".equals(this.hQT.getForum().getId()) || "me0407".equals(this.hQT.getForum().getName());
    }

    private boolean bXT() {
        boolean z;
        if (this.hVG != null && this.hVG.getVisibility() == 0) {
            if (this.hVf != null) {
                this.hVf.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hVf != null) {
                this.hVf.setVisibility(8);
            }
            z = false;
        }
        if ((this.hVh == null || this.hVh.getVisibility() == 8) && z && this.hNO) {
            this.hVg.setVisibility(0);
        } else {
            this.hVg.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bSL() == null) {
            return false;
        }
        if (dVar.bSL().aev() == 1 || dVar.bSL().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bSL().aex() == null || dVar.bSL().aex().agz() == 0) || dVar.bSL().aet() == 1 || dVar.bSL().aeu() == 1 || dVar.bSL().afj() || dVar.bSL().afy() || dVar.bSL().afr() || dVar.bSL().aeK() != null || !com.baidu.tbadk.core.util.aq.isEmpty(dVar.bSL().getCategory()) || dVar.bSL().aeB() || dVar.bSL().aeA();
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hNx.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hUC != null) {
                if (dVar.bSL() != null && dVar.bSL().aeN() == 0 && !dVar.bSL().afs() && !this.hWL) {
                    this.hUC.setVisibility(0);
                    if (dVar.bSL() != null) {
                        bh bSL = dVar.bSL();
                        bSL.m(true, q(dVar));
                        bSL.hh(3);
                        bSL.my("2");
                    }
                    SpannableStringBuilder afe = dVar.bSL().afe();
                    this.hUD.setOnTouchListener(new com.baidu.tieba.view.k(afe));
                    this.hUD.setText(afe);
                    this.hUD.setVisibility(0);
                } else if (dVar.bSL().aeN() == 1) {
                    if (dVar.bSL() != null) {
                        this.hUC.setVisibility(8);
                        this.hUu.removeHeaderView(this.hUC);
                    }
                } else {
                    this.hUC.setVisibility(8);
                    this.hUu.removeHeaderView(this.hUC);
                    if (dVar.bSL() != null && dVar.bSL().afs()) {
                        this.hUI.setPadding(this.hUI.getPaddingLeft(), 0, this.hUI.getPaddingRight(), this.hUI.getPaddingBottom());
                        if (this.hVa != null) {
                            ((RelativeLayout.LayoutParams) this.hVa.getLayoutParams()).height = (int) this.hNx.getResources().getDimension(R.dimen.tbds36);
                            this.hVa.requestLayout();
                        }
                        if (this.hVb != null) {
                            ((RelativeLayout.LayoutParams) this.hVb.getLayoutParams()).height = (int) this.hNx.getResources().getDimension(R.dimen.tbds0);
                            this.hVb.requestLayout();
                        }
                    } else {
                        this.hUI.setPadding(this.hUI.getPaddingLeft(), com.baidu.adp.lib.util.l.g(this.hNx.getPageContext().getPageActivity(), R.dimen.ds48), this.hUI.getPaddingRight(), this.hUI.getPaddingBottom());
                    }
                }
            }
            if (dVar.bSL() != null) {
                ac(dVar.bSL().aeu() == 1, dVar.bSL().aet() == 1);
            }
            this.hNO = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bXT();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData c;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (dVar != null && (c = c(dVar, z)) != null) {
            String userId = c.aey().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bSX()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (c.aey() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, c.aey().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, c.aey().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, c.aey().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, c.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bSX()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bd> bTg = dVar.bTg();
                if (com.baidu.tbadk.core.util.v.Z(bTg) > 0) {
                    sb = new StringBuilder();
                    for (bd bdVar : bTg) {
                        if (bdVar != null && !StringUtils.isNull(bdVar.getForumName()) && (vVar = bdVar.bIW) != null && vVar.bGL && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.i(bdVar.getForumName(), 12)).append(this.hNx.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.hNx.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View bXU() {
        return this.czl;
    }

    public boolean bXV() {
        if (this.eve == null || this.eve.getParent() == null || this.fAR.pP()) {
            return false;
        }
        int bottom = this.eve.getBottom();
        Rect rect = new Rect();
        this.eve.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Ca(String str) {
        if (this.fAR != null) {
            this.fAR.setText(str);
        }
    }

    public void Cb(String str) {
        if (this.fAR != null) {
            int i = 0;
            if (this.hWf != null && this.hWf.hXp != null && this.hWf.hXp.getView() != null) {
                i = this.hWf.hXp.getView().getTop() < 0 ? this.hWf.hXp.getView().getHeight() : this.hWf.hXp.getView().getBottom();
            }
            this.fAR.W(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hUu;
    }

    public int bXW() {
        return R.id.richText;
    }

    public TextView bUd() {
        return this.hUH.bUd();
    }

    public void e(BdListView.e eVar) {
        this.hUu.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.caJ = cVar;
        if (this.hVn != null) {
            this.hVn.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int adq = anVar.adq();
            int adn = anVar.adn();
            if (this.hVk != null) {
                this.hVk.agK();
            } else {
                this.hVk = new com.baidu.tbadk.core.dialog.a(this.hNx.getPageContext().getPageActivity());
                this.hVl = LayoutInflater.from(this.hNx.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.hVk.aH(this.hVl);
                this.hVk.a(R.string.dialog_ok, bVar);
                this.hVk.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bXY();
                        aVar.dismiss();
                    }
                });
                this.hVk.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hWo == null) {
                            aq.this.hWo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hNx.HidenSoftKeyPad((InputMethodManager) aq.this.hNx.getSystemService("input_method"), aq.this.evb);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.iK().postDelayed(aq.this.hWo, 150L);
                    }
                });
                this.hVk.b(this.hNx.getPageContext()).agK();
            }
            this.hVm = (EditText) this.hVl.findViewById(R.id.input_page_number);
            this.hVm.setText("");
            TextView textView = (TextView) this.hVl.findViewById(R.id.current_page_number);
            if (adq <= 0) {
                adq = 1;
            }
            if (adn <= 0) {
                adn = 1;
            }
            textView.setText(MessageFormat.format(this.hNx.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(adq), Integer.valueOf(adn)));
            this.hNx.ShowSoftKeyPadDelay(this.hVm, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hUu.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hNx.showToast(str);
    }

    public boolean oV(boolean z) {
        if (this.TU == null || !this.TU.asd()) {
            return false;
        }
        this.TU.aqw();
        return true;
    }

    public void bXX() {
        if (this.hWY != null) {
            while (this.hWY.size() > 0) {
                TbImageView remove = this.hWY.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bXX();
        this.hVj.xQ(1);
        if (this.hUk != null) {
            this.hUk.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hVj.xQ(2);
        if (this.hUk != null) {
            this.hUk.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.hNx) && !TbSingleton.getInstance().isCutoutScreen(this.hNx)) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hWq != null) {
            this.hWq.destroy();
        }
        if (this.hWH != null) {
            this.hWH.onDestory();
        }
        if (this.hWy != null) {
            this.hWy.hide();
        }
        if (this.hUn != null) {
            this.hUn.bbB();
        }
        if (this.hUm != null) {
            this.hUm.onDestroy();
        }
        this.hNx.hideProgressBar();
        if (this.eXf != null && this.frT != null) {
            this.eXf.b(this.frT);
        }
        bXY();
        akG();
        if (this.hWo != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hWo);
        }
        if (this.hUI != null && this.hUT != null) {
            this.hUI.removeView(this.hUO);
            this.hUT = null;
        }
        if (this.hVV != null) {
            this.hVV.clearStatus();
        }
        this.hWR = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hVj.xQ(3);
        if (this.fwK != null) {
            this.fwK.setBackgroundDrawable(null);
        }
        if (this.hUk != null) {
            this.hUk.destroy();
        }
        if (this.hVj != null) {
            this.hVj.onDestroy();
        }
        this.hUu.setOnLayoutListener(null);
        if (this.hWD != null) {
            this.hWD.boF();
        }
        if (this.hWg != null) {
            this.hWg.onDestroy();
        }
    }

    public boolean yj(int i) {
        if (this.hUk != null) {
            return this.hUk.rT(i);
        }
        return false;
    }

    public void bXY() {
        this.hUq.UM();
        if (this.hUn != null) {
            this.hUn.bbB();
        }
        com.baidu.adp.lib.util.l.b(this.hNx.getPageContext().getPageActivity(), this.hVm);
        bXi();
        if (this.hLC != null) {
            this.hLC.dismiss();
        }
        bYa();
        if (this.hUm != null) {
            this.hUm.cad();
        }
        if (this.hVk != null) {
            this.hVk.dismiss();
        }
        if (this.fww != null) {
            this.fww.dismiss();
        }
    }

    public void bXZ() {
        this.hUq.UM();
        if (this.hUn != null) {
            this.hUn.bbB();
        }
        if (this.hLC != null) {
            this.hLC.dismiss();
        }
        bYa();
        if (this.hUm != null) {
            this.hUm.cad();
        }
        if (this.hVk != null) {
            this.hVk.dismiss();
        }
        if (this.fww != null) {
            this.fww.dismiss();
        }
    }

    public void dJ(List<String> list) {
        this.hWC = list;
        if (this.hWD != null) {
            this.hWD.setData(list);
        }
    }

    public void og(boolean z) {
        this.hVj.og(z);
    }

    public void oW(boolean z) {
        this.hVF = z;
    }

    public void bYa() {
        if (this.hVt != null) {
            this.hVt.dismiss();
        }
        if (this.hVu != null) {
            com.baidu.adp.lib.g.g.b(this.hVu, this.hNx.getPageContext());
        }
        if (this.hVv != null) {
            com.baidu.adp.lib.g.g.b(this.hVv, this.hNx.getPageContext());
        }
        if (this.hVr != null) {
            this.hVr.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hQT, this.hNO);
            d(this.hQT, this.hNO, this.mType);
            this.hNx.getLayoutMode().setNightMode(i == 1);
            this.hNx.getLayoutMode().onModeChanged(this.evb);
            this.hNx.getLayoutMode().onModeChanged(this.hUw);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.am.l(this.evb, R.color.cp_bg_line_d);
            }
            if (this.hUm != null) {
                this.hUm.onChangeSkinType(i);
            }
            if (this.hUx != null) {
                com.baidu.tbadk.core.util.am.l(this.hUx, R.color.cp_bg_line_c);
            }
            if (this.hUy != null) {
                this.hUy.setIsNight(this.mSkinType == 1);
            }
            if (this.hUz != null) {
                com.baidu.tbadk.core.util.am.j(this.hUz, R.color.cp_cont_b);
            }
            if (this.hUA != null) {
                com.baidu.tbadk.core.util.am.j(this.hUA, R.color.cp_cont_j);
            }
            if (this.hUB != null) {
                com.baidu.tbadk.core.util.am.k(this.hUB, R.drawable.icon_common_arrow16_right_n);
            }
            if (this.hUD != null) {
                com.baidu.tbadk.core.util.am.j(this.hUD, R.color.cp_cont_b);
                this.hUD.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            }
            if (this.fAR != null) {
                this.fAR.iV(i);
                if (this.czl != null) {
                    this.hNx.getLayoutMode().onModeChanged(this.czl);
                    com.baidu.tbadk.core.util.am.k(this.czl, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.hVk != null) {
                this.hVk.c(this.hNx.getPageContext());
            }
            oU(this.hVC);
            this.hVj.notifyDataSetChanged();
            if (this.hVn != null) {
                this.hVn.iV(i);
            }
            if (this.TU != null) {
                this.TU.onChangeSkinType(i);
            }
            if (this.hUS != null) {
                this.hUS.jd(i);
            }
            if (this.hVo != null) {
                this.hVo.iV(i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.eEY)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.eEY) {
                    customBlueCheckRadioButton.akj();
                }
            }
            bXy();
            UtilHelper.setStatusBarBackground(this.fwK, i);
            UtilHelper.setStatusBarBackground(this.hWa, i);
            if (this.hUU != null) {
                this.hUU.onChangeSkinType(i);
            }
            if (this.hUY != null) {
                com.baidu.tbadk.core.util.am.j(this.hUY, R.color.cp_cont_d);
            }
            if (this.hUX != null) {
                com.baidu.tbadk.core.util.am.j(this.hUX, R.color.cp_cont_d);
            }
            if (this.hUZ != null) {
                com.baidu.tbadk.core.util.am.j(this.hUZ, R.color.cp_cont_d);
            }
            if (this.hUW != null) {
                com.baidu.tbadk.core.util.am.j(this.hUW, R.color.cp_cont_d);
            }
            if (this.hVc != null) {
                com.baidu.tbadk.s.a.a(this.hNx.getPageContext(), this.hVc);
            }
            if (this.hWp != null) {
                this.hWp.onChangeSkinType(i);
            }
            if (this.hUq != null) {
                if (this.hUk != null) {
                    this.hUk.yo(i);
                } else {
                    this.hUq.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.gnh != null) {
                com.baidu.tbadk.core.util.am.j(this.gnh, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.k(this.gnh, R.drawable.bg_comment_input);
            }
            if (this.hVK != null && this.hQT != null) {
                if (this.hQT.aaB()) {
                    com.baidu.tbadk.core.util.am.c(this.hVK, (int) R.drawable.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.am.c(this.hVK, (int) R.drawable.icon_pb_bottom_collect_n);
                }
            }
            if (this.hVL != null) {
                com.baidu.tbadk.core.util.am.c(this.hVL, (int) R.drawable.icon_pb_bottom_share_n);
            }
            if (this.hVJ != null) {
                com.baidu.tbadk.core.util.am.c(this.hVJ, (int) R.drawable.icon_pb_bottom_comment_n);
            }
            com.baidu.tbadk.core.util.am.j(this.hVM, R.color.cp_cont_b);
            if (this.hUM != null) {
                com.baidu.tbadk.core.util.am.c(this.hUM, BitmapHelper.getGradeResourceIdInEnterForum(this.hWx));
            }
            if (this.hWE != null) {
                this.hWE.onChangeSkinType(i);
            }
            if (this.hWg != null) {
                this.hWg.onChangeSkinType();
            }
            if (this.hWA != null) {
                com.baidu.tbadk.core.util.am.j(this.hWA, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.l(this.hVI, R.color.cp_bg_line_d);
            if (this.hUL != null) {
                com.baidu.tbadk.core.util.am.k(this.hUL, this.hWJ);
                com.baidu.tbadk.core.util.am.j(this.hUL, R.color.cp_btn_a);
            }
            if (this.hUv != null) {
                this.hUv.nA(i);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKo = hVar;
        this.hVj.setOnImageClickListener(this.cKo);
        this.hWE.setOnImageClickListener(this.cKo);
    }

    public void h(NoNetworkView.a aVar) {
        this.frT = aVar;
        if (this.eXf != null) {
            this.eXf.a(this.frT);
        }
    }

    public void oX(boolean z) {
        this.hVj.setIsFromCDN(z);
    }

    public Button bYb() {
        return this.hVG;
    }

    public void bYc() {
        if (this.hUp != 2) {
            this.hUu.setNextPage(this.fAR);
            this.hUp = 2;
        }
    }

    public void bYd() {
        if (com.baidu.tbadk.p.m.avv().avw()) {
            int lastVisiblePosition = this.hUu.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hUu.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog = tbImageView.getPerfLog();
                                perfLog.kR(1001);
                                perfLog.czT = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(R.id.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.p.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.kR(1001);
                        perfLog2.czT = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean bYe() {
        return this.TU != null && this.TU.getVisibility() == 0;
    }

    public boolean bYf() {
        return this.TU != null && this.TU.asd();
    }

    public void bYg() {
        if (this.TU != null) {
            this.TU.aqw();
        }
    }

    public void oY(boolean z) {
        if (this.hVI != null) {
            oW(this.hNx.bUe().asH());
            if (this.hVF) {
                oO(z);
            } else {
                oP(z);
            }
        }
    }

    public void bYh() {
        if (this.hVI != null) {
            this.hVH.setVisibility(8);
            this.hVI.setVisibility(8);
            this.hVN = false;
            if (this.hWg != null) {
                this.hWg.setVisibility(8);
                oS(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.eMz == null) {
            this.eMz = new com.baidu.tbadk.core.view.b(this.hNx.getPageContext());
        }
        this.eMz.ej(true);
    }

    public void aUB() {
        if (this.eMz != null) {
            this.eMz.ej(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hUu.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hUu.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hUk != null) {
            this.hUk.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hWZ = getScrollY();
            this.hWf.hXp = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hWf));
            a(this.hWf.hXp, true);
        }
    }

    public void oZ(boolean z) {
        this.hUk.oZ(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hUk != null) {
            this.hUk.b(absListView, i);
        }
        if (this.hUq != null && this.hVj != null) {
            this.hUq.cG(this.hVj.bVt());
        }
        this.hWf.hDD = i;
        this.hWf.headerCount = this.hUu.getHeaderViewsCount();
        this.hWf.hXp = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hWf));
        a(this.hWf.hXp, false);
        if (this.fAR.akM() && !this.fAR.cay) {
            if (this.hWf != null && this.hWf.hXp != null && this.hWf.hXp.getView() != null) {
                i4 = this.hWf.hXp.getView().getTop() < 0 ? this.hWf.hXp.getView().getHeight() : this.hWf.hXp.getView().getBottom();
            }
            this.fAR.iY(i4);
            this.fAR.cay = true;
        }
    }

    public void bYi() {
        if (this.hNx.isLogin() && this.hQT != null && this.hWu && !this.hWt && !this.hVD && this.hVQ != null && this.hVQ.aey() != null && !this.hVQ.aey().getIsLike() && !this.hVQ.aey().hadConcerned() && this.hWq == null) {
            this.hWq = new an(this.hNx);
        }
    }

    public void bYj() {
        if (this.hWu && !this.hWt && this.hVQ != null && this.hVQ.aey() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").P("obj_locate", this.hNx.bTH() ? 2 : 1).P("obj_type", this.hWt ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hNx.getPageContext().getPageActivity(), this.hVQ.aey().getUserId(), this.hVQ.aey().getUserName(), this.hNx.bTR().bTI(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hWt && this.hVZ != null && this.hUq.bYS() != null) {
            int bVp = this.hVj.bVp();
            if (bVp > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bVp > this.hUu.getFirstVisiblePosition() - this.hUu.getHeaderViewsCount()) {
                    this.hVZ.setVisibility(8);
                    return;
                }
                this.hVZ.setVisibility(0);
                bYt();
                this.hUq.mNavigationBar.hideBottomLine();
                if (this.hVZ.getParent() != null && ((ViewGroup) this.hVZ.getParent()).getHeight() <= this.hVZ.getTop()) {
                    this.hVZ.getParent().requestLayout();
                }
            } else if (alVar == null || alVar.getView() == null || alVar.hTO == null) {
                if (this.hUu.getFirstVisiblePosition() == 0) {
                    this.hVZ.setVisibility(8);
                    this.hUq.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hWe) {
                        this.hWd = top;
                        this.hWe = false;
                    }
                    this.hWd = top < this.hWd ? top : this.hWd;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hVi.getY() < 0.0f) {
                        measuredHeight = hWc - alVar.hTO.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hUq.bYS().getMeasuredHeight() - alVar.hTO.getMeasuredHeight();
                        this.hUq.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hWd) {
                        this.hVZ.setVisibility(0);
                        bYt();
                    } else if (top < measuredHeight) {
                        this.hVZ.setVisibility(0);
                        bYt();
                    } else {
                        this.hVZ.setVisibility(8);
                        this.hUq.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hWe = true;
                    }
                }
            }
        }
    }

    public void bYk() {
        if (!this.hXa) {
            TiebaStatic.log("c10490");
            this.hXa = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNx.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hWj, Integer.valueOf(hWl));
            aVar.ht(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hNx.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aH(inflate);
            aVar.ab(sparseArray);
            aVar.a(R.string.grade_button_tips, this.hNx);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hNx.getPageContext()).agK();
        }
    }

    public void Cc(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNx.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hNx.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aH(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hWj, Integer.valueOf(hWm));
        aVar.ab(sparseArray);
        aVar.a(R.string.view, this.hNx);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hNx.getPageContext()).agK();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData c;
        if (i > 0 && (c = c(dVar, z)) != null && c.aey() != null) {
            MetaData aey = c.aey();
            aey.setGiftNum(aey.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bYl() {
        return this.hVV;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bSL() != null && dVar.bSL().afy() && this.hVV == null) {
            this.hVV = (PbInterviewStatusView) this.hVU.inflate();
            this.hVV.setOnClickListener(this.fwx);
            this.hVV.setCallback(this.hNx.bUQ());
            this.hVV.setData(this.hNx, dVar);
        }
    }

    public LinearLayout bYm() {
        return this.hVi;
    }

    public View bYn() {
        return this.fwK;
    }

    public boolean bYo() {
        return this.hWL;
    }

    public void ol(boolean z) {
        this.hUH.ol(z);
    }

    public void Cd(String str) {
        if (this.hUr != null) {
            this.hUr.setTitle(str);
        }
    }

    private int pa(boolean z) {
        if (this.hVV == null || this.hVV.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.g(this.hNx.getPageContext().getPageActivity(), R.dimen.ds72);
    }

    private void bYp() {
        if (this.hVV != null && this.hVV.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hVV.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hVV.setLayoutParams(layoutParams);
        }
    }

    public boolean bUk() {
        return false;
    }

    public void Ce(String str) {
        this.gnh.performClick();
        if (!StringUtils.isNull(str) && this.hNx.bUe() != null && this.hNx.bUe().asA() != null && this.hNx.bUe().asA().getInputView() != null) {
            EditText inputView = this.hNx.bUe().asA().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bXY();
            if (configuration.orientation == 2) {
                bYh();
                bXi();
            } else {
                bXl();
            }
            if (this.hWp != null) {
                this.hWp.bVy();
            }
            this.hNx.bmu();
            this.hVi.setVisibility(8);
            this.hUq.pk(false);
            this.hNx.or(false);
            if (this.hUk != null) {
                if (configuration.orientation == 1) {
                    bYm().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hUu.setIsLandscape(true);
                    this.hUu.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hUu.setIsLandscape(false);
                    if (this.hWZ > 0) {
                        this.hUu.smoothScrollBy(this.hWZ, 0);
                    }
                }
                this.hUk.onConfigurationChanged(configuration);
                this.hVY.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void pb(boolean z) {
        this.hUo = z;
    }

    public boolean bYq() {
        return this.hUk != null && this.hUk.bYq();
    }

    public void bYr() {
        if (this.hUk != null) {
            this.hUk.onPause();
        }
    }

    public void q(long j, int i) {
        if (this.hUm != null) {
            this.hUm.q(j, i);
        }
        if (this.hUk != null) {
            this.hUk.q(j, i);
        }
    }

    public void ow(boolean z) {
        this.hVj.ow(z);
    }

    public void bYs() {
        if (this.hVW == null) {
            LayoutInflater.from(this.hNx.getActivity()).inflate(R.layout.add_experienced_text, (ViewGroup) this.evb, true);
            this.hVW = (ViewGroup) this.evb.findViewById(R.id.add_experienced_layout);
            this.hVX = (TextView) this.evb.findViewById(R.id.add_experienced);
            com.baidu.tbadk.core.util.am.j(this.hVX, R.color.cp_btn_a);
            String string = this.hNx.getResources().getString(R.string.experienced_add_success);
            String string2 = this.hNx.getResources().getString(R.string.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_h)));
            this.hVX.setText(spannableString);
        }
        this.hVW.setVisibility(0);
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
                        aq.this.hVW.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hVX.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hVX.startAnimation(scaleAnimation);
    }

    public void cF(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hVI.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hNx);
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.hWA = new TextView(this.hNx);
            this.hWA.setText(R.string.connection_tips);
            this.hWA.setGravity(17);
            this.hWA.setPadding(com.baidu.adp.lib.util.l.g(this.hNx, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(this.hNx, R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hNx, R.dimen.ds60);
            if (this.hWA.getParent() == null) {
                frameLayout.addView(this.hWA, layoutParams);
            }
            this.hWz = new PopupWindow(this.hNx);
            this.hWz.setContentView(frameLayout);
            this.hWz.setHeight(-2);
            this.hWz.setWidth(-2);
            this.hWz.setFocusable(true);
            this.hWz.setOutsideTouchable(false);
            this.hWz.setBackgroundDrawable(new ColorDrawable(this.hNx.getResources().getColor(R.color.transparent)));
            this.hUu.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hWz.showAsDropDown(aq.this.hVI, view.getLeft(), -aq.this.hVI.getHeight());
                    } else {
                        aq.this.hWz.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bYt() {
        if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("show_long_press_tips", false) && this.hWB == null) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_long_press_tips", true);
            this.hWB = new com.baidu.tbadk.core.dialog.a(this.hNx);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hNx);
            this.hWB.hx(1);
            this.hWB.aH(pbLongPressTipView);
            this.hWB.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hWB.dR(false);
            this.hWB.b(this.hNx.getPageContext()).agK();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hWB != null && aq.this.hWB.isShowing()) {
                        aq.this.hWB.dismiss();
                    }
                }
            }, 5000L);
            if (this.hUk != null) {
                this.hUk.can();
            }
        }
    }

    public void pc(boolean z) {
        this.hWG = z;
    }

    public boolean bYu() {
        return this.hWG;
    }

    public PbThreadPostView bYv() {
        return this.hUv;
    }

    private void ac(boolean z, boolean z2) {
        ad(z, z2);
        ae(z, z2);
        if (this.hVj != null && this.hVj.bVu() != null) {
            this.hVj.bVu().W(z, z2);
        }
    }

    private void ad(boolean z, boolean z2) {
        if (z && z2) {
            this.hUF.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hUF.setVisibility(0);
        } else if (z) {
            this.hUF.setImageResource(R.drawable.pic_pb_refined_n);
            this.hUF.setVisibility(0);
        } else if (z2) {
            this.hUF.setImageResource(R.drawable.pic_pb_stick_n);
            this.hUF.setVisibility(0);
        } else {
            this.hUF.setVisibility(8);
        }
    }

    private void ae(boolean z, boolean z2) {
        if (this.hUC != null && this.hQT != null && this.hQT.bSL() != null && this.hQT.bSL().aeN() == 0 && !this.hQT.bSL().afs()) {
            if (z && z2) {
                this.hUG.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.hUG.setVisibility(0);
            } else if (z) {
                this.hUG.setImageResource(R.drawable.pic_pb_refined_n);
                this.hUG.setVisibility(0);
            } else if (z2) {
                this.hUG.setImageResource(R.drawable.pic_pb_stick_n);
                this.hUG.setVisibility(0);
            } else {
                this.hUG.setVisibility(8);
            }
        }
    }
}
