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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.MessageRedDotView;
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
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbLongPressTipView;
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
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class aq {
    private EditorTools VN;
    private TextView ahN;
    private h.c bRI;
    private NavigationBarCoverTip bsr;
    private com.baidu.tieba.pb.a.c cca;
    private View cpH;
    private int dSG;
    private NoNetworkView eCe;
    private RelativeLayout eCg;
    private List<CustomBlueCheckRadioButton> ekf;
    private View eoA;
    private TextView fOS;
    private View.OnClickListener faL;
    private View faY;
    private PbListView feS;
    private com.baidu.tieba.NEGFeedBack.e fzr;
    PbActivity.d hnO;
    private PbActivity hoJ;
    private UserIconBox hpW;
    private UserIconBox hpX;
    private View.OnClickListener hpi;
    private PbFakeFloorModel hqU;
    private com.baidu.tieba.pb.data.d hsc;
    public final com.baidu.tieba.pb.pb.main.view.b hvA;
    public com.baidu.tieba.pb.pb.main.view.a hvB;
    private ViewStub hvC;
    private ViewStub hvD;
    private PbLandscapeListView hvE;
    private View hvF;
    private RelativeLayout hvI;
    private ImageView hvJ;
    private ImageView hvK;
    private e hvL;
    private ColumnLayout hvM;
    private ThreadSkinView hvN;
    private TextView hvO;
    private TextView hvP;
    private ImageView hvQ;
    private HeadPendantView hvR;
    private FrameLayout hvS;
    private HeadImageView hvT;
    private View hvU;
    private LinearLayout hvV;
    private PbFirstFloorUserLikeButton hvY;
    private ao hvZ;
    public int hvt;
    public com.baidu.tieba.pb.video.i hvu;
    private long hvv;
    private com.baidu.tieba.pb.video.h hvw;
    private com.baidu.tieba.c.d hvx;
    private View hwL;
    private View hwM;
    private ImageView hwN;
    private ImageView hwO;
    private ImageView hwP;
    private MessageRedDotView hwQ;
    private int hwS;
    private int hwT;
    private PostData hwU;
    private View hwW;
    private TextView hwX;
    private ViewStub hwY;
    private PbInterviewStatusView hwZ;
    private TextView hwa;
    private TextView hwb;
    private TextView hwc;
    private TextView hwd;
    private View hwe;
    private View hwf;
    private LinearLayout hwg;
    private TextView hwh;
    private TextView hwi;
    private View hwj;
    private View hwk;
    private ObservedChangeLinearLayout hwm;
    private f hwn;
    private View hwt;
    private int hxA;
    private PbTopTipView hxC;
    private PopupWindow hxD;
    private TextView hxE;
    private com.baidu.tbadk.core.dialog.a hxF;
    private List<String> hxG;
    private com.baidu.tieba.pb.pb.main.emotion.c hxH;
    private com.baidu.tieba.pb.pb.godreply.a hxI;
    private PbLandscapeListView.b hxJ;
    private ac hxL;
    private String hxM;
    private boolean hxO;
    private com.baidu.tbadk.core.view.userLike.c hxP;
    private com.baidu.tbadk.core.view.userLike.c hxQ;
    private Runnable hxV;
    private PbActivity.b hxX;
    private ViewGroup hxa;
    private TextView hxb;
    private FrameLayout hxc;
    private View hxd;
    private View hxe;
    private al hxf;
    private PbEmotionBar hxk;
    private Runnable hxs;
    private s hxt;
    private an hxu;
    public int hyc;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private static final int hxg = UtilHelper.getLightStatusBarHeight();
    public static int hxm = 3;
    public static int hxn = 0;
    public static int hxo = 3;
    public static int hxp = 4;
    public static int hxq = 5;
    public static int hxr = 6;
    private static a.InterfaceC0388a hxN = new a.InterfaceC0388a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0388a
        public void onRefresh() {
        }
    };
    private boolean hvy = false;
    private int hvz = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hvG = null;
    private TextView hvH = null;
    public FrsPraiseView hvW = null;
    private ClickableHeaderImageView hvX = null;
    private View hwl = null;
    private com.baidu.tbadk.core.dialog.a hwo = null;
    private com.baidu.tbadk.core.dialog.b faK = null;
    private View hwp = null;
    private EditText hwq = null;
    private com.baidu.tieba.pb.view.c hwr = null;
    private com.baidu.tieba.pb.view.a hws = null;
    private com.baidu.tbadk.core.dialog.a hwu = null;
    private b.InterfaceC0225b gms = null;
    private TbRichTextView.h cAD = null;
    private NoNetworkView.a eWp = null;
    private com.baidu.tbadk.core.dialog.g hwv = null;
    private View hww = null;
    private com.baidu.tbadk.core.dialog.a hwx = null;
    private Dialog hwy = null;
    private Dialog hwz = null;
    private View hwA = null;
    private LinearLayout hwB = null;
    private CompoundButton.OnCheckedChangeListener ekg = null;
    private TextView hwC = null;
    private TextView hwD = null;
    private String hwE = null;
    private com.baidu.tbadk.core.dialog.g hmP = null;
    private com.baidu.tbadk.core.dialog.g hwF = null;
    private boolean hwG = false;
    private boolean hwH = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hwI = null;
    private boolean hwJ = false;
    private Button hwK = null;
    private boolean hwR = true;
    private com.baidu.tbadk.core.view.b erO = null;
    private boolean hpa = false;
    private int mSkinType = 3;
    private boolean hwV = false;
    private int hxh = 0;
    private boolean hxi = true;
    public a hxj = new a();
    private int hxl = 0;
    private boolean hxv = false;
    private int hxw = 0;
    private boolean hxx = false;
    private boolean hxy = false;
    private boolean hxz = false;
    private int hxB = 0;
    private boolean hxK = false;
    private String hxR = null;
    private CustomMessageListener hxS = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hxR = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hwn != null) {
                aq.this.hwn.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hxT = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hvH != null) {
                aq.this.hvH.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hxU = new Handler();
    private CustomMessageListener hxW = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hwR = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hxY = true;
    View.OnClickListener hxZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hxx) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").T(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hxx && aq.this.hsc != null && aq.this.hsc.bHW() != null && aq.this.hsc.bHW().YO() != null && aq.this.hsc.bHW().YO().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").T("obj_locate", 1));
            }
            aq.this.hoJ.hmK.fzX.onClick(view);
        }
    };
    private boolean hya = false;
    String userId = null;
    private final List<TbImageView> hyb = new ArrayList();
    private boolean hyd = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int headerCount;
        public int hfc;
        public al hyr;
    }

    public void nJ(boolean z) {
        this.hxv = z;
        if (this.hvE != null) {
            this.hxw = this.hvE.getHeaderViewsCount();
        }
    }

    public void bMh() {
        if (this.hvE != null) {
            int headerViewsCount = this.hvE.getHeaderViewsCount() - this.hxw;
            final int firstVisiblePosition = (this.hvE.getFirstVisiblePosition() == 0 || this.hvE.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hvE.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hvE.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hxj.hyr = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxj));
            final al alVar = this.hxj.hyr;
            final int h = h(alVar);
            final int y = ((int) this.hwm.getY()) + this.hwm.getMeasuredHeight();
            final boolean z = this.hxd.getVisibility() == 0;
            boolean z2 = this.hwm.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hwn.bKs() + this.hvE.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.huY.getMeasuredHeight() : 0;
                if (z2) {
                    this.hvE.setSelectionFromTop(this.hwn.bKs() + this.hvE.getHeaderViewsCount(), hxg - measuredHeight);
                } else {
                    this.hvE.setSelectionFromTop(this.hwn.bKs() + this.hvE.getHeaderViewsCount(), this.hvA.bNQ().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hvE.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hxx) {
                this.hvE.setSelectionFromTop(this.hwn.bKs() + this.hvE.getHeaderViewsCount(), this.hvu.aBz().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hvE.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bKK() {
                        if (h >= 0 && h <= aq.this.eCg.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.eoA.getLayoutParams();
                            if (i == 0 || i > aq.this.eCg.getMeasuredHeight() || h2 >= aq.this.eCg.getMeasuredHeight()) {
                                layoutParams.height = aq.this.dSG;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.eCg.getMeasuredHeight()) {
                                layoutParams.height = aq.this.dSG;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hvE.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.eoA.setLayoutParams(layoutParams);
                        }
                        aq.this.hvE.setOnLayoutListener(null);
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

    public NoNetworkView bMi() {
        return this.eCe;
    }

    public void bMj() {
        if (this.VN != null) {
            this.VN.hide();
            if (this.hxH != null) {
                this.hxH.aAy();
            }
        }
    }

    public PbFakeFloorModel bMk() {
        return this.hqU;
    }

    public s bMl() {
        return this.hxt;
    }

    public void bMm() {
        reset();
        bMj();
        this.hxt.bKB();
        nU(false);
    }

    private void reset() {
        if (this.hoJ != null && this.hoJ.bJj() != null && this.VN != null) {
            com.baidu.tbadk.editortools.pb.a.amm().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bJj = this.hoJ.bJj();
            bJj.amF();
            bJj.ama();
            if (bJj.getWriteImagesInfo() != null) {
                bJj.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bJj.jB(SendView.ALL);
            bJj.jC(SendView.ALL);
            com.baidu.tbadk.editortools.g js = this.VN.js(23);
            com.baidu.tbadk.editortools.g js2 = this.VN.js(2);
            com.baidu.tbadk.editortools.g js3 = this.VN.js(5);
            if (js2 != null) {
                js2.qT();
            }
            if (js3 != null) {
                js3.qT();
            }
            if (js != null) {
                js.hide();
            }
            this.VN.invalidate();
        }
    }

    public boolean bMn() {
        return this.hwR;
    }

    public void nK(boolean z) {
        if (this.hwM != null && this.fOS != null) {
            this.fOS.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hwM.startAnimation(alphaAnimation);
            }
            this.hwL.setVisibility(0);
            this.hwM.setVisibility(0);
            this.hwR = true;
            if (this.hxk != null && !this.hxI.isActive()) {
                this.hxk.setVisibility(0);
                nO(true);
            }
        }
    }

    public void nL(boolean z) {
        if (this.hwM != null && this.fOS != null) {
            this.fOS.setText(bMo());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hwM.startAnimation(alphaAnimation);
            }
            this.hwL.setVisibility(0);
            this.hwM.setVisibility(0);
            this.hwR = true;
            if (this.hxk != null && !this.hxI.isActive()) {
                this.hxk.setVisibility(0);
                nO(true);
            }
        }
    }

    public String bMo() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.hxM)) {
            return this.hxM;
        }
        if (this.hoJ != null) {
            this.hxM = this.hoJ.getResources().getString(ap.bMg());
        }
        return this.hxM;
    }

    public PostData bMp() {
        int i = 0;
        if (this.hvE == null) {
            return null;
        }
        int bMq = bMq() - this.hvE.getHeaderViewsCount();
        if (bMq < 0) {
            bMq = 0;
        }
        if (this.hwn.wd(bMq) != null && this.hwn.wd(bMq) != PostData.iFL) {
            i = bMq + 1;
        }
        return this.hwn.getItem(i) instanceof PostData ? (PostData) this.hwn.getItem(i) : null;
    }

    public int bMq() {
        int i;
        View childAt;
        if (this.hvE == null) {
            return 0;
        }
        int firstVisiblePosition = this.hvE.getFirstVisiblePosition();
        int lastVisiblePosition = this.hvE.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hvE.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hvE.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bMr() {
        return this.hvE.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hsc != null && this.hsc.bHY() != null && !this.hsc.bHY().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hsc.bHY().size() && (postData = this.hsc.bHY().get(i)) != null && postData.YO() != null && !StringUtils.isNull(postData.YO().getUserId()); i++) {
                if (this.hsc.bHY().get(i).YO().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hxI != null && this.hxI.isActive()) {
                        nU(false);
                    }
                    if (this.hxk != null) {
                        this.hxk.oc(true);
                    }
                    this.hxR = postData.YO().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hoJ = null;
        this.eCg = null;
        this.faY = null;
        this.hvv = 0L;
        this.hvE = null;
        this.hvF = null;
        this.hvI = null;
        this.hvM = null;
        this.hvO = null;
        this.hvP = null;
        this.hvS = null;
        this.hvT = null;
        this.hvU = null;
        this.hvY = null;
        this.hwa = null;
        this.hwb = null;
        this.hwc = null;
        this.hwd = null;
        this.hwj = null;
        this.hwk = null;
        this.hwn = null;
        this.feS = null;
        this.cpH = null;
        this.faL = null;
        this.hpi = null;
        this.hwM = null;
        this.fOS = null;
        this.hwW = null;
        this.hwX = null;
        this.hwY = null;
        this.hxA = 0;
        this.hvv = System.currentTimeMillis();
        this.hoJ = pbActivity;
        this.faL = onClickListener;
        this.cca = cVar;
        this.hxA = com.baidu.adp.lib.util.l.aO(this.hoJ) / 2;
        this.eCg = (RelativeLayout) LayoutInflater.from(this.hoJ.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.hoJ.addContentView(this.eCg, new FrameLayout.LayoutParams(-1, -1));
        this.bsr = (NavigationBarCoverTip) this.hoJ.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.faY = this.hoJ.findViewById(d.g.statebar_view);
        this.hwm = (ObservedChangeLinearLayout) this.hoJ.findViewById(d.g.title_wrapper);
        this.eCe = (NoNetworkView) this.hoJ.findViewById(d.g.view_no_network);
        this.hvE = (PbLandscapeListView) this.hoJ.findViewById(d.g.new_pb_list);
        this.hxc = (FrameLayout) this.hoJ.findViewById(d.g.root_float_header);
        this.ahN = new TextView(this.hoJ.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.hoJ.getActivity(), d.e.ds88));
        this.hvE.addHeaderView(this.ahN, 0);
        this.dSG = this.hoJ.getResources().getDimensionPixelSize(d.e.tbds134);
        this.eoA = new View(this.hoJ.getPageContext().getPageActivity());
        this.eoA.setLayoutParams(new AbsListView.LayoutParams(-1, this.dSG));
        this.eoA.setVisibility(4);
        this.hvE.addFooterView(this.eoA);
        this.hvE.setOnTouchListener(this.hoJ.ccW);
        this.hvA = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.hoJ.bJM()) {
            this.hvC = (ViewStub) this.hoJ.findViewById(d.g.manga_view_stub);
            this.hvC.setVisibility(0);
            this.hvB = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.hvB.show();
            this.hvA.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hoJ.getActivity(), d.e.ds120);
        }
        this.ahN.setLayoutParams(layoutParams);
        this.hvA.bNQ().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0349a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0349a
            public void bIH() {
                if (aq.this.hvE != null) {
                    if (aq.this.hvu != null) {
                        aq.this.hvu.bPj();
                    }
                    aq.this.hvE.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0349a
            public void bII() {
                aq.this.hoJ.bcL();
            }
        }));
        this.hwL = this.hoJ.findViewById(d.g.view_comment_top_line);
        this.hwM = this.hoJ.findViewById(d.g.pb_editor_tool_comment);
        this.hwS = com.baidu.adp.lib.util.l.h(this.hoJ.getPageContext().getPageActivity(), d.e.tbds120);
        this.hwT = com.baidu.adp.lib.util.l.h(this.hoJ.getPageContext().getPageActivity(), d.e.ds242);
        this.fOS = (TextView) this.hoJ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hoJ.bJs();
                if (aq.this.hoJ != null && aq.this.hoJ.bIX() != null && aq.this.hoJ.bIX().getPbData() != null && aq.this.hoJ.bIX().getPbData().bHW() != null && aq.this.hoJ.bIX().getPbData().bHW().YO() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", aq.this.hoJ.bIX().hrG).bJ(ImageViewerConfig.FORUM_ID, aq.this.hoJ.bIX().getPbData().getForumId()).T("obj_locate", 1).bJ("uid", aq.this.hoJ.bIX().getPbData().bHW().YO().getUserId()));
                }
            }
        });
        this.hwN = (ImageView) this.hoJ.findViewById(d.g.pb_editor_tool_comment_icon);
        this.hwN.setOnClickListener(this.faL);
        this.hwO = (ImageView) this.hoJ.findViewById(d.g.pb_editor_tool_collection);
        this.hwO.setOnClickListener(this.faL);
        this.hwP = (ImageView) this.hoJ.findViewById(d.g.pb_editor_tool_share);
        this.hwP.setOnClickListener(this.faL);
        this.hwQ = (MessageRedDotView) this.hoJ.findViewById(d.g.pb_editor_tool_comment_red_dot);
        this.hvF = LayoutInflater.from(this.hoJ.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.hvI = (RelativeLayout) LayoutInflater.from(this.hoJ.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.hvJ = (ImageView) this.hvI.findViewById(d.g.pb_thread_type_stamp_top_part);
        this.hvL = new e(this.hoJ, this.hvI);
        this.hvL.init();
        this.hvL.a(this.hvL.bJi(), this.faL);
        this.hvM = (ColumnLayout) this.hvI.findViewById(d.g.pb_head_owner_root);
        this.hvN = (ThreadSkinView) this.hvI.findViewById(d.g.pb_thread_skin);
        this.hvM.setOnLongClickListener(this.onLongClickListener);
        this.hvM.setOnTouchListener(this.cca);
        this.hvM.setVisibility(8);
        this.hvF.setOnTouchListener(this.cca);
        this.hwW = this.hvF.findViewById(d.g.pb_head_activity_join_number_container);
        this.hwW.setVisibility(8);
        this.hwX = (TextView) this.hvF.findViewById(d.g.pb_head_activity_join_number);
        this.hvO = (TextView) this.hvM.findViewById(d.g.pb_head_owner_info_user_name);
        this.hvO.getPaint().setFakeBoldText(true);
        this.hvP = (TextView) this.hvM.findViewById(d.g.floor_owner);
        this.hvQ = (ImageView) this.hvM.findViewById(d.g.icon_forum_level);
        this.hvS = (FrameLayout) this.hvM.findViewById(d.g.pb_head_headImage_container);
        this.hvT = (HeadImageView) this.hvM.findViewById(d.g.pb_head_owner_photo);
        this.hvR = (HeadPendantView) this.hvM.findViewById(d.g.pb_pendant_head_owner_photo);
        this.hvR.setHasPendantStyle();
        if (this.hvR.getHeadView() != null) {
            this.hvR.getHeadView().setIsRound(true);
            this.hvR.getHeadView().setDrawBorder(false);
        }
        this.hpW = (UserIconBox) this.hvM.findViewById(d.g.show_icon_vip);
        this.hpX = (UserIconBox) this.hvM.findViewById(d.g.show_icon_yinji);
        this.hvV = (LinearLayout) this.hvI.findViewById(d.g.pb_head_owner_info_root);
        this.hvY = (PbFirstFloorUserLikeButton) this.hvM.findViewById(d.g.pb_like_button);
        this.hwa = (TextView) this.hvM.findViewById(d.g.pb_views);
        this.hwb = (TextView) this.hvM.findViewById(d.g.pb_item_first_floor_reply_time);
        this.hwc = (TextView) this.hvM.findViewById(d.g.pb_item_first_floor_location_address);
        this.hwd = (TextView) this.hvM.findViewById(d.g.point_between_time_and_locate);
        this.hxP = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hxQ = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hwj = this.hvF.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.hwk = this.hvF.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.hvF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hwY = (ViewStub) this.eCg.findViewById(d.g.interview_status_stub);
        this.hwe = this.hvI.findViewById(d.g.blank_view_align_user_item_top);
        this.hwf = this.hvI.findViewById(d.g.blank_view_align_user_item_bottom);
        this.hwn = new f(this.hoJ, this.hvE);
        this.hwn.x(this.faL);
        this.hwn.setTbGestureDetector(this.cca);
        this.hwn.setOnImageClickListener(this.cAD);
        this.hpi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            aq.this.hoJ.c(sparseArray);
                            return;
                        }
                        aq.this.cs(view);
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        aq.this.hoJ.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hwn.J(this.hpi);
        bMw();
        this.hvE.addHeaderView(this.hvI);
        this.hvE.addHeaderView(this.hvG);
        this.hvE.addHeaderView(this.hvF);
        this.feS = new PbListView(this.hoJ.getPageContext().getPageActivity());
        this.cpH = this.feS.getView().findViewById(d.g.pb_more_view);
        if (this.cpH != null) {
            this.cpH.setOnClickListener(this.faL);
            com.baidu.tbadk.core.util.al.k(this.cpH, d.f.pb_foot_more_trans_selector);
        }
        this.feS.aev();
        this.feS.hY(d.f.pb_foot_more_trans_selector);
        this.feS.ia(d.f.pb_foot_more_trans_selector);
        this.hwt = this.hoJ.findViewById(d.g.viewstub_progress);
        this.hoJ.registerListener(this.hxW);
        this.hvU = com.baidu.tbadk.ala.b.UH().n(this.hoJ.getActivity(), 2);
        if (this.hvU != null) {
            this.hvU.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.hoJ.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.hvU.getParent() == null) {
                this.hvV.addView(this.hvU, aVar);
            }
        }
        this.hqU = new PbFakeFloorModel(this.hoJ.getPageContext());
        this.hxt = new s(this.hoJ.getPageContext(), this.hqU, this.eCg);
        this.hxt.a(this.hoJ.hnK);
        this.hqU.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hqU.o(postData);
                aq.this.hwn.notifyDataSetChanged();
                aq.this.hxt.bKB();
                aq.this.VN.akm();
                aq.this.nU(false);
            }
        });
        if (this.hoJ.bIX() != null && !StringUtils.isNull(this.hoJ.bIX().bLv())) {
            this.hoJ.showToast(this.hoJ.bIX().bLv());
        }
        this.hxd = this.hoJ.findViewById(d.g.pb_expand_blank_view);
        this.hxe = this.hoJ.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hxe.getLayoutParams();
        if (this.hoJ.bIX() != null && this.hoJ.bIX().bKR()) {
            this.hxd.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hxe.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hxg;
            this.hxe.setLayoutParams(layoutParams2);
        }
        this.hxf = new al(this.hoJ.getPageContext(), this.hoJ.findViewById(d.g.pb_reply_expand_view));
        this.hxf.huY.setVisibility(8);
        this.hxf.L(this.faL);
        this.hoJ.registerListener(this.mAccountChangedListener);
        this.hoJ.registerListener(this.hxS);
        this.hoJ.registerListener(this.hxT);
        bMs();
        nO(false);
    }

    public void bnj() {
        if (!this.hoJ.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 2).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.hoJ.bJu()) {
            com.baidu.tbadk.editortools.pb.d bJj = this.hoJ.bJj();
            if (bJj != null && (bJj.amC() || bJj.amD())) {
                this.hoJ.bJj().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.VN != null) {
                bMB();
            }
            if (this.VN != null) {
                this.hwR = false;
                if (this.VN.jv(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hoJ, (View) this.VN.jv(2).ciw, false, hxN);
                }
            }
            bNg();
        }
    }

    private void bMs() {
        this.hxI = new com.baidu.tieba.pb.pb.godreply.a(this.hoJ, this, (ViewStub) this.eCg.findViewById(d.g.more_god_reply_popup));
        this.hxI.t(this.faL);
        this.hxI.J(this.hpi);
        this.hxI.setOnImageClickListener(this.cAD);
        this.hxI.t(this.faL);
        this.hxI.setTbGestureDetector(this.cca);
    }

    public com.baidu.tieba.pb.pb.godreply.a bMt() {
        return this.hxI;
    }

    public View bMu() {
        return this.hxd;
    }

    public void bMv() {
        if (this.hvE != null) {
            this.hvE.removeHeaderView(this.hvG);
            this.hvE.removeHeaderView(this.hvI);
            this.hvE.removeHeaderView(this.hvF);
        }
    }

    private void bMw() {
        if (this.hvG == null) {
            this.hvG = (RelativeLayout) LayoutInflater.from(this.hoJ).inflate(d.h.new_pb_title, (ViewGroup) null);
            this.hvK = (ImageView) this.hvG.findViewById(d.g.pb_thread_type_stamp_title_bottom_part);
            this.hvK.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(d.e.tbds194));
            this.hvK.setImageMatrix(matrix);
            this.hvH = (TextView) this.hvG.findViewById(d.g.tv_pb_title);
            this.hvH.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            this.hvH.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hvH.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.al.j(this.hvH, d.C0277d.cp_cont_b);
            this.hvH.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hvH.setVisibility(8);
            if (this.hvH.getParent() == null) {
                this.hvG.addView(this.hvH);
            }
            this.hvG.setOnTouchListener(this.cca);
            this.hvG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMx() {
        if (this.hoJ.bJM()) {
            this.hvD = (ViewStub) this.hoJ.findViewById(d.g.manga_mention_controller_view_stub);
            this.hvD.setVisibility(0);
            if (this.hwg == null) {
                this.hwg = (LinearLayout) this.hoJ.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.hoJ.getPageContext(), this.hwg);
            }
            if (this.hwh == null) {
                this.hwh = (TextView) this.hwg.findViewById(d.g.manga_prev_btn);
            }
            if (this.hwi == null) {
                this.hwi = (TextView) this.hwg.findViewById(d.g.manga_next_btn);
            }
            this.hwh.setOnClickListener(this.faL);
            this.hwi.setOnClickListener(this.faL);
        }
    }

    private void bMy() {
        if (this.hoJ.bJM()) {
            if (this.hoJ.bJP() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwh, d.C0277d.cp_cont_e, 1);
            }
            if (this.hoJ.bJQ() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwi, d.C0277d.cp_cont_e, 1);
            }
        }
    }

    public void bMz() {
        if (this.hwg == null) {
            bMx();
        }
        this.hvD.setVisibility(8);
        if (this.hxU != null && this.hxV != null) {
            this.hxU.removeCallbacks(this.hxV);
        }
    }

    public void bMA() {
        if (this.hxU != null) {
            if (this.hxV != null) {
                this.hxU.removeCallbacks(this.hxV);
            }
            this.hxV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hwg == null) {
                        aq.this.bMx();
                    }
                    aq.this.hvD.setVisibility(0);
                }
            };
            this.hxU.postDelayed(this.hxV, 2000L);
        }
    }

    public void nM(boolean z) {
        this.hvA.nM(z);
        if (z && this.hwV) {
            this.feS.setText(this.hoJ.getResources().getString(d.j.click_load_more));
            this.hvE.setNextPage(this.feS);
            this.hvz = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
        this.VN.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.VN.getParent() == null) {
            this.eCg.addView(this.VN, layoutParams);
        }
        this.VN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.VN.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).agq() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).agq() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.adN();
                        aq.this.mPermissionJudgePolicy.e(aq.this.hoJ, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.Y(aq.this.hoJ)) {
                            aq.this.hoJ.bJj().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hoJ.bJj().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bMj();
        this.hoJ.bJj().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.VN != null && aq.this.VN.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hxH == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.VN.getId());
                            aq.this.hxH = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hoJ.getPageContext(), aq.this.eCg, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.T(aq.this.hxG)) {
                                aq.this.hxH.setData(aq.this.hxG);
                            }
                            aq.this.hxH.b(aq.this.VN);
                        }
                        aq.this.hxH.Ad(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hoJ.hmO != null && aq.this.hoJ.hmO.bNw() != null) {
                    if (!aq.this.hoJ.hmO.bNw().cnZ()) {
                        aq.this.hoJ.hmO.nZ(false);
                    }
                    aq.this.hoJ.hmO.bNw().qV(false);
                }
            }
        });
    }

    public void bMB() {
        if (this.hoJ != null && this.VN != null) {
            this.VN.qT();
            if (this.hoJ.bJj() != null) {
                this.hoJ.bJj().amt();
            }
            bNg();
        }
    }

    public void nN(boolean z) {
        if (this.hvE != null && this.ahN != null && this.faY != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.faY.setVisibility(0);
                } else {
                    this.faY.setVisibility(8);
                    this.hvE.removeHeaderView(this.ahN);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ahN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hxg;
                    this.ahN.setLayoutParams(layoutParams);
                }
                bMP();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ahN.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + nW(true);
                this.ahN.setLayoutParams(layoutParams2);
            }
            bMP();
            bNo();
        }
    }

    public f bMC() {
        return this.hwn;
    }

    public void a(PbActivity.d dVar) {
        this.hnO = dVar;
    }

    public void cs(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.f fVar;
        com.baidu.tbadk.core.dialog.f fVar2;
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hoJ);
        iVar.setTitleText(this.hoJ.getString(d.j.bar_manager));
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwv.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hxX != null) {
                                aq.this.hxX.m(new Object[]{sparseArray2.get(d.g.tag_manage_user_identity), sparseArray2.get(d.g.tag_forbid_user_name), sparseArray2.get(d.g.tag_forbid_user_post_id), sparseArray2.get(d.g.tag_forbid_user_name_show), sparseArray2.get(d.g.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hoJ.a(z, (String) sparseArray2.get(d.g.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(d.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(d.g.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : -1) == 0) {
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hoJ.getString(d.j.delete_post), iVar);
            } else {
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hoJ.getString(d.j.delete), iVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
            sparseArray2.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
            sparseArray2.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
            sparseArray2.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            fVar2.mTextView.setTag(sparseArray2);
            arrayList.add(fVar2);
        }
        if ((!"".equals(sparseArray.get(d.g.tag_forbid_user_name)) || !"".equals(sparseArray.get(d.g.tag_forbid_user_name_show))) && !bNn()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray3.put(d.g.tag_forbid_user_name_show, sparseArray.get(d.g.tag_forbid_user_name_show));
            sparseArray3.put(d.g.tag_forbid_user_portrait, sparseArray.get(d.g.tag_forbid_user_portrait));
            sparseArray3.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray3.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(1, this.hoJ.getString(d.j.forbidden_person), iVar);
            fVar3.mTextView.setTag(sparseArray3);
            arrayList.add(fVar3);
        }
        if ((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
            sparseArray4.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
            sparseArray4.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
            sparseArray4.put(d.g.tag_user_mute_mute_nameshow, sparseArray.get(d.g.tag_user_mute_mute_nameshow));
            sparseArray4.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray4.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            sparseArray4.put(d.g.tag_user_mute_msg, sparseArray.get(d.g.tag_user_mute_msg));
            if (z) {
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hoJ.getString(d.j.un_mute), iVar);
            } else {
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hoJ.getString(d.j.mute), iVar);
            }
            fVar.mTextView.setTag(sparseArray4);
            arrayList.add(fVar);
        }
        iVar.P(arrayList);
        if (this.hwv == null) {
            this.hwv = new com.baidu.tbadk.core.dialog.g(this.hoJ.getPageContext(), iVar.abh());
        } else {
            this.hwv.setContentView(iVar.abh());
        }
        this.hwv.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hxX = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hoJ != null && aVar != null) {
            if (this.fzr == null) {
                this.fzr = new com.baidu.tieba.NEGFeedBack.e(this.hoJ.getPageContext(), this.hvF);
            }
            AntiData bbG = this.hoJ.bbG();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bbG != null && bbG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbG.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.b(sparseArray);
            this.fzr.setDefaultReasonArray(new String[]{this.hoJ.getString(d.j.delete_thread_reason_1), this.hoJ.getString(d.j.delete_thread_reason_2), this.hoJ.getString(d.j.delete_thread_reason_3), this.hoJ.getString(d.j.delete_thread_reason_4), this.hoJ.getString(d.j.delete_thread_reason_5)});
            this.fzr.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fzr.qj(str);
            this.fzr.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray) {
                    aq.this.hoJ.a(aVar, jSONArray);
                }
            });
        }
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(hxn, Integer.valueOf(hxo));
        int i3 = d.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.j.report_thread_confirm;
            } else {
                i3 = d.j.del_thread_confirm;
            }
        }
        this.hwx = new com.baidu.tbadk.core.dialog.a(this.hoJ.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hwx.gC(i3);
        } else {
            this.hwx.dv(false);
            this.hwx.lz(str2);
        }
        this.hwx.Z(sparseArray);
        this.hwx.a(d.j.dialog_ok, this.hoJ);
        this.hwx.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwx.dq(true);
        this.hwx.b(this.hoJ.getPageContext());
        if (z) {
            this.hwx.aaW();
        } else {
            a(this.hwx, i);
        }
    }

    public void at(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hwA == null) {
            this.hwA = LayoutInflater.from(this.hoJ.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.hoJ.getLayoutMode().onModeChanged(this.hwA);
        if (this.hwz == null) {
            this.hwz = new Dialog(this.hoJ.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hwz.setCanceledOnTouchOutside(true);
            this.hwz.setCancelable(true);
            this.hwI = (ScrollView) this.hwA.findViewById(d.g.good_scroll);
            this.hwz.setContentView(this.hwA);
            WindowManager.LayoutParams attributes = this.hwz.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.hoJ.getPageContext().getPageActivity(), d.e.ds540);
            this.hwz.getWindow().setAttributes(attributes);
            this.ekg = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hwE = (String) compoundButton.getTag();
                        if (aq.this.ekf != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.ekf) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hwE != null && !str.equals(aq.this.hwE)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hwB = (LinearLayout) this.hwA.findViewById(d.g.good_class_group);
            this.hwD = (TextView) this.hwA.findViewById(d.g.dialog_button_cancel);
            this.hwD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hwz instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hwz, aq.this.hoJ.getPageContext());
                    }
                }
            });
            this.hwC = (TextView) this.hwA.findViewById(d.g.dialog_button_ok);
            this.hwC.setOnClickListener(this.faL);
        }
        this.hwB.removeAllViews();
        this.ekf = new ArrayList();
        CustomBlueCheckRadioButton dA = dA("0", this.hoJ.getPageContext().getString(d.j.thread_good_class));
        this.ekf.add(dA);
        dA.setChecked(true);
        this.hwB.addView(dA);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.Xo()) && acVar.Xp() > 0) {
                    CustomBlueCheckRadioButton dA2 = dA(String.valueOf(acVar.Xp()), acVar.Xo());
                    this.ekf.add(dA2);
                    View view = new View(this.hoJ.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.hoJ.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.al.l(view, d.C0277d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hwB.addView(view);
                    this.hwB.addView(dA2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hwI.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hoJ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hoJ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hoJ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hwI.setLayoutParams(layoutParams2);
            this.hwI.removeAllViews();
            if (this.hwB != null && this.hwB.getParent() == null) {
                this.hwI.addView(this.hwB);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hwz, this.hoJ.getPageContext());
    }

    private CustomBlueCheckRadioButton dA(String str, String str2) {
        Activity pageActivity = this.hoJ.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.ekg);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bMD() {
        this.hoJ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hoJ.hideProgressBar();
        if (z && z2) {
            this.hoJ.showToast(this.hoJ.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.hoJ.showToast(str);
        }
    }

    public void bul() {
        this.hwt.setVisibility(0);
    }

    public void buk() {
        this.hwt.setVisibility(8);
    }

    public View bME() {
        if (this.hwA != null) {
            return this.hwA.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bMF() {
        return this.hwE;
    }

    public View getView() {
        return this.eCg;
    }

    public void bMG() {
        com.baidu.adp.lib.util.l.b(this.hoJ.getPageContext().getPageActivity(), this.hoJ.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hoJ.hideProgressBar();
        if (z) {
            bMX();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bMY();
        } else {
            bMX();
        }
    }

    public void bMH() {
        this.feS.aev();
        this.feS.aez();
    }

    public void bMI() {
        this.hoJ.hideProgressBar();
        aeA();
        this.hvE.completePullRefreshPostDelayed(0L);
        bMT();
    }

    public void bMJ() {
        this.hvE.completePullRefreshPostDelayed(0L);
        bMT();
    }

    private void nO(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hwn.setOnLongClickListener(onLongClickListener);
        if (this.hxI != null) {
            this.hxI.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0225b interfaceC0225b, boolean z, boolean z2) {
        if (this.hmP != null) {
            this.hmP.dismiss();
            this.hmP = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hoJ);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hoJ.getPageContext().getString(d.j.copy), iVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoJ.getPageContext().getString(d.j.report_text), iVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoJ.getPageContext().getString(d.j.mark), iVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoJ.getPageContext().getString(d.j.remove_mark), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwF.dismiss();
                interfaceC0225b.a(null, i, view);
            }
        });
        this.hwF = new com.baidu.tbadk.core.dialog.g(this.hoJ.getPageContext(), iVar.abh());
        this.hwF.showDialog();
    }

    public void a(final b.InterfaceC0225b interfaceC0225b, boolean z) {
        if (this.hwF != null) {
            this.hwF.dismiss();
            this.hwF = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hoJ);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hoJ.getPageContext().getString(d.j.save_to_emotion), iVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoJ.getPageContext().getString(d.j.save_to_local), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwF.dismiss();
                interfaceC0225b.a(null, i, view);
            }
        });
        this.hwF = new com.baidu.tbadk.core.dialog.g(this.hoJ.getPageContext(), iVar.abh());
        this.hwF.showDialog();
    }

    public int bMK() {
        return wu(this.hvE.getFirstVisiblePosition());
    }

    private int wu(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hvE.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hvE.getAdapter() == null || !(this.hvE.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hvE.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bML() {
        int lastVisiblePosition = this.hvE.getLastVisiblePosition();
        if (this.hvu != null) {
            if (lastVisiblePosition == this.hvE.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return wu(lastVisiblePosition);
    }

    public void wv(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.hvE != null) {
            if (this.hvA == null || this.hvA.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hvA.mNavigationBar.getFixedNavHeight();
                if (!(this.hoJ.bJA() != -1)) {
                    if (this.hxe != null && (layoutParams = (LinearLayout.LayoutParams) this.hxe.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hxe.setLayoutParams(layoutParams);
                    }
                    i--;
                    bNs();
                }
                i2 = fixedNavHeight;
            }
            this.hvE.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hvE.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hvE.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hwq.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hwn.a(dVar, false);
        this.hwn.notifyDataSetChanged();
        bMT();
        if (this.hxI != null) {
            this.hxI.bIT();
        }
        ArrayList<PostData> bHY = dVar.bHY();
        if (dVar.getPage().XH() == 0 || bHY == null || bHY.size() < dVar.getPage().XG()) {
            if (com.baidu.tbadk.core.util.v.S(bHY) == 0 || (com.baidu.tbadk.core.util.v.S(bHY) == 1 && bHY.get(0) != null && bHY.get(0).cep() == 1)) {
                if (this.hxj == null || this.hxj.hyr == null || this.hxj.hyr.getView() == null) {
                    i = 0;
                } else {
                    i = this.hxj.hyr.getView().getTop() < 0 ? this.hxj.hyr.getView().getHeight() : this.hxj.hyr.getView().getBottom();
                }
                if (this.hoJ.bJY()) {
                    this.feS.aa(this.hoJ.getResources().getString(d.j.pb_no_host_reply), i);
                } else {
                    this.feS.aa(this.hoJ.getResources().getString(d.j.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().XH() == 0) {
                    this.feS.setText(this.hoJ.getResources().getString(d.j.list_has_no_more));
                } else {
                    this.feS.setText(this.hoJ.getResources().getString(d.j.load_more));
                }
                this.feS.aeE();
            }
        }
        p(dVar);
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.hvW == null) {
            this.hoJ.getLayoutMode().onModeChanged(((ViewStub) this.hvF.findViewById(d.g.praise_layout)).inflate());
            this.hvW = (FrsPraiseView) this.hvF.findViewById(d.g.pb_head_praise_view);
            this.hvW.setIsFromPb(true);
            this.hwl = this.hvF.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.hvW.ii(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hvW != null) {
            boolean bMT = bMT();
            this.hvW.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().XI() == 0 && this.hpa) {
                if (bMT) {
                    this.hwk.setVisibility(0);
                    return;
                } else {
                    this.hwk.setVisibility(8);
                    return;
                }
            }
            this.hwk.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bIg() != null) {
            return dVar.bIg();
        }
        if (!com.baidu.tbadk.core.util.v.T(dVar.bHY())) {
            Iterator<PostData> it = dVar.bHY().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cep() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bId();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.YO() != null && postData.YO().getUserTbVipInfoData() != null && postData.YO().getUserTbVipInfoData().getvipIntro() != null) {
            postData.YO().getGodUserData().setIntro(postData.YO().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bHW() == null || dVar.bHW().YO() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData YO = dVar.bHW().YO();
        String userId = YO.getUserId();
        HashMap<String, MetaData> userMap = dVar.bHW().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = YO;
        }
        postData.zq(1);
        postData.setId(dVar.bHW().Ze());
        postData.setTitle(dVar.bHW().getTitle());
        postData.setTime(dVar.bHW().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x05cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x07f6  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x07fb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x034a  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        String g;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.f ces;
        String portrait;
        if (dVar != null && dVar.bHW() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hvM.setVisibility(8);
            if (dVar.bHW() != null && dVar.bHW().ZI() && dVar.bHW().Zf() != null) {
                this.hxx = true;
                this.hvA.oj(this.hxx);
                this.hvA.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1") && com.baidu.adp.lib.util.l.aQ(this.hoJ) < this.eCg.getHeight()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eCg.getLayoutParams();
                    layoutParams.height = com.baidu.adp.lib.util.l.aQ(this.hoJ);
                    this.eCg.setLayoutParams(layoutParams);
                }
                if (this.hvu == null) {
                    this.hvu = new com.baidu.tieba.pb.video.i(this.hoJ, this.hvA, dVar.bHW().Zf(), this.hvv);
                    this.hvu.a(dVar.bHW().Zf(), dVar.bHW(), dVar.getForumId());
                    this.hvu.startPlay();
                } else if (this.hvy) {
                    this.hvu.a(dVar.bHW().Zf(), dVar.bHW(), dVar.getForumId());
                    this.hvu.startPlay();
                } else {
                    this.hvu.Ap(dVar.getForumId());
                }
                if (dVar.bHX() != null && dVar.bHX().size() >= 1) {
                    bg bgVar = dVar.bHX().get(0);
                    this.hvu.aD(bgVar);
                    this.hvu.Aq(bgVar.getTitle());
                }
                this.hvu.b(c, dVar.bHW(), dVar.bIt());
                this.hvy = false;
                this.hvE.removeHeaderView(this.hvu.bPl());
                this.hvE.addHeaderView(this.hvu.bPl(), 0);
                if (this.hvu.aBz() != null && this.hvu.aBz().getParent() == null) {
                    this.hxc.addView(this.hvu.aBz());
                }
                if (this.hvw == null) {
                    this.hvw = new com.baidu.tieba.pb.video.h(this.hoJ);
                }
                this.hvw.a(dVar.bHW().ZY(), dVar.bHW(), dVar.bIq());
                this.hvE.removeHeaderView(this.hvw.bOY());
                this.hvE.addHeaderView(this.hvw.bOY(), 1);
                if (dVar.bHW().ZY() != null) {
                    this.hvE.removeHeaderView(this.hvw.bOZ());
                    this.hvE.removeHeaderView(this.hvI);
                    this.hvE.addHeaderView(this.hvw.bOZ(), 2);
                } else {
                    if (this.hvw.bOZ() != null) {
                        this.hvE.removeHeaderView(this.hvw.bOZ());
                    }
                    this.hvE.removeHeaderView(this.hvI);
                    this.hvE.addHeaderView(this.hvI, 2);
                }
                if (this.hvu != null) {
                    this.hvA.of(false);
                    this.hvu.wC(TbadkCoreApplication.getInst().getSkinType());
                }
                bMP();
            } else {
                this.hxx = false;
                this.hvA.oj(this.hxx);
                if (this.hvu != null) {
                    this.hvE.removeHeaderView(this.hvu.bPl());
                }
                if (this.hvw != null) {
                    this.hvw.b(this.hvE);
                }
            }
            if (this.hoJ.bJm() != null) {
                this.hoJ.bJm().od(this.hxx);
            }
            if (this.hvu != null) {
                this.hvu.N(this.hxZ);
                bNs();
            }
            if (c != null) {
                this.hwU = c;
                this.hvM.setVisibility(0);
                if (this.hoJ.bIN()) {
                    if (dVar.bHV() != null) {
                        this.mForumName = dVar.bHV().getForumName();
                        this.mForumId = dVar.bHV().getForumId();
                    }
                    if (this.mForumName == null && this.hoJ.bIX() != null && this.hoJ.bIX().bIO() != null) {
                        this.mForumName = this.hoJ.bIX().bIO();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hvM.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hvM.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, c);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.hxO) {
                    this.hvG.setVisibility(0);
                }
                if (!dVar.bHW().ZI() && this.hvH.getText() != null && this.hvH.getText().length() > 0) {
                    this.hvH.setVisibility(0);
                } else {
                    this.hvH.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> YZ = dVar.bHW().YZ();
                if (YZ != null && YZ.size() > 0 && !this.hxO) {
                    this.hwX.setText(String.valueOf(YZ.get(0).WV()));
                    this.hwW.setVisibility(0);
                } else {
                    this.hwW.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.k(this.hwW, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.d(this.hwX, d.C0277d.cp_link_tip_d, 1);
                if (c.YO() != null) {
                    String string = c.YO().getName_show() == null ? StringUtils.string(c.YO().getUserName()) : StringUtils.string(c.YO().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(c.YO().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bz(c.YO().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bz(string) > 12) {
                            g = com.baidu.tbadk.core.util.ap.g(string, 12, "...");
                            ArrayList<IconData> iconInfo = c.YO().getIconInfo();
                            tShowInfoNew = c.YO().getTShowInfoNew();
                            if (this.hpX != null) {
                                this.hpX.setTag(d.g.tag_user_id, c.YO().getUserId());
                                this.hpX.setOnClickListener(this.hoJ.hmK.hzR);
                                this.hpX.a(iconInfo, 4, this.hoJ.getResources().getDimensionPixelSize(d.e.tbds36), this.hoJ.getResources().getDimensionPixelSize(d.e.tbds36), this.hoJ.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.hpW != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hpW.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hpW.setOnClickListener(this.hoJ.hmK.hzS);
                                this.hpW.a(tShowInfoNew, 3, this.hoJ.getResources().getDimensionPixelSize(d.e.tbds36), this.hoJ.getResources().getDimensionPixelSize(d.e.tbds36), this.hoJ.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.hvO.setText(bN(c.YO().getSealPrefix(), g));
                            this.hvO.setTag(d.g.tag_user_id, c.YO().getUserId());
                            this.hvO.setTag(d.g.tag_user_name, c.YO().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew) || c.YO().isBigV()) {
                                com.baidu.tbadk.core.util.al.d(this.hvO, d.C0277d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.d(this.hvO, d.C0277d.cp_cont_b, 1);
                            }
                            if (c.YO() == null) {
                                MetaData YO = c.YO();
                                if (YO.getIs_bawu() == 1 && "manager".equals(YO.getBawu_type())) {
                                    this.hvP.setText(d.j.bawu_member_bazhu_tip);
                                    this.hvP.setVisibility(0);
                                } else if (YO.getIs_bawu() == 1 && "assist".equals(YO.getBawu_type())) {
                                    this.hvP.setText(d.j.bawu_member_xbazhu_tip);
                                    this.hvP.setVisibility(0);
                                } else {
                                    this.hvP.setVisibility(8);
                                }
                            } else {
                                this.hvP.setVisibility(8);
                            }
                            if (dVar.bHW().YO() != null && dVar.bHW().YO().getAlaUserData() != null && this.hvU != null) {
                                if (dVar.bHW().YO().getAlaUserData().anchor_live != 0) {
                                    this.hvU.setVisibility(8);
                                } else {
                                    this.hvU.setVisibility(0);
                                    if (this.hvx == null) {
                                        this.hvx = new com.baidu.tieba.c.d(this.hoJ.getPageContext(), this.hvU);
                                        this.hvx.oI(1);
                                    }
                                    this.hvx.cv(this.hoJ.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bsM = dVar.bHW().YO().getAlaUserData();
                                    aVar.type = 2;
                                    this.hvU.setTag(aVar);
                                }
                            }
                            this.hvT.setUserId(c.YO().getUserId());
                            this.hvT.setUserName(c.YO().getUserName());
                            this.hvT.setTid(c.getId());
                            this.hvT.setFid(this.hsc == null ? this.hsc.getForumId() : "");
                            this.hvT.setImageDrawable(null);
                            this.hvT.setRadius(com.baidu.adp.lib.util.l.h(this.hoJ.getActivity(), d.e.ds40));
                            this.hvT.setTag(c.YO().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hwb.setText(com.baidu.tbadk.core.util.ap.aq(c.getTime()));
                            } else {
                                this.hwb.setText(com.baidu.tbadk.core.util.ap.ao(c.getTime()));
                            }
                            ces = c.ces();
                            if (ces == null && !TextUtils.isEmpty(ces.getName()) && !TextUtils.isEmpty(ces.getName().trim())) {
                                this.hwc.setVisibility(0);
                                this.hwd.setVisibility(0);
                                this.hwc.setText(ces.getName());
                            } else {
                                this.hwc.setVisibility(8);
                                this.hwd.setVisibility(8);
                            }
                            portrait = c.YO().getPortrait();
                            if (c.YO().getPendantData() == null && !StringUtils.isNull(c.YO().getPendantData().Xk())) {
                                this.hvR.b(c.YO());
                                this.hvT.setVisibility(8);
                                this.hvR.setVisibility(0);
                                if (this.hvX != null) {
                                    this.hvX.setVisibility(8);
                                }
                                this.hvO.setOnClickListener(this.hxZ);
                                this.hvR.getHeadView().startLoad(portrait, 28, false);
                                this.hvR.getHeadView().setUserId(c.YO().getUserId());
                                this.hvR.getHeadView().setUserName(c.YO().getUserName());
                                this.hvR.getHeadView().setTid(c.getId());
                                this.hvR.getHeadView().setFid(this.hsc != null ? this.hsc.getForumId() : "");
                                this.hvR.getHeadView().setOnClickListener(this.hxZ);
                                this.hvR.nn(c.YO().getPendantData().Xk());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hvT, c.YO());
                                this.hvT.setVisibility(0);
                                this.hvM.setOnClickListener(this.hxZ);
                                this.hvO.setOnClickListener(this.hxZ);
                                this.hvT.setOnClickListener(this.hxZ);
                                this.hvR.setVisibility(8);
                                this.hvT.startLoad(portrait, 28, false);
                            }
                            String name_show = c.YO().getName_show();
                            String userName = c.YO().getUserName();
                            if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                                this.hvO.setText(com.baidu.tieba.pb.c.aP(this.hoJ.getPageContext().getPageActivity(), this.hvO.getText().toString()));
                                this.hvO.setGravity(16);
                                this.hvO.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHH());
                                com.baidu.tbadk.core.util.al.d(this.hvO, d.C0277d.cp_other_e, 1);
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo2 = c.YO().getIconInfo();
                        tShowInfoNew = c.YO().getTShowInfoNew();
                        if (this.hpX != null) {
                        }
                        if (this.hpW != null) {
                        }
                        this.hvO.setText(bN(c.YO().getSealPrefix(), g));
                        this.hvO.setTag(d.g.tag_user_id, c.YO().getUserId());
                        this.hvO.setTag(d.g.tag_user_name, c.YO().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hvO, d.C0277d.cp_cont_h, 1);
                        if (c.YO() == null) {
                        }
                        if (dVar.bHW().YO() != null) {
                            if (dVar.bHW().YO().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hvT.setUserId(c.YO().getUserId());
                        this.hvT.setUserName(c.YO().getUserName());
                        this.hvT.setTid(c.getId());
                        this.hvT.setFid(this.hsc == null ? this.hsc.getForumId() : "");
                        this.hvT.setImageDrawable(null);
                        this.hvT.setRadius(com.baidu.adp.lib.util.l.h(this.hoJ.getActivity(), d.e.ds40));
                        this.hvT.setTag(c.YO().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        ces = c.ces();
                        if (ces == null) {
                        }
                        this.hwc.setVisibility(8);
                        this.hwd.setVisibility(8);
                        portrait = c.YO().getPortrait();
                        if (c.YO().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hvT, c.YO());
                        this.hvT.setVisibility(0);
                        this.hvM.setOnClickListener(this.hxZ);
                        this.hvO.setOnClickListener(this.hxZ);
                        this.hvT.setOnClickListener(this.hxZ);
                        this.hvR.setVisibility(8);
                        this.hvT.startLoad(portrait, 28, false);
                        String name_show2 = c.YO().getName_show();
                        String userName2 = c.YO().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                            this.hvO.setText(com.baidu.tieba.pb.c.aP(this.hoJ.getPageContext().getPageActivity(), this.hvO.getText().toString()));
                            this.hvO.setGravity(16);
                            this.hvO.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHH());
                            com.baidu.tbadk.core.util.al.d(this.hvO, d.C0277d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            g = com.baidu.tbadk.core.util.ap.g(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.YO().getIconInfo();
                            tShowInfoNew = c.YO().getTShowInfoNew();
                            if (this.hpX != null) {
                            }
                            if (this.hpW != null) {
                            }
                            this.hvO.setText(bN(c.YO().getSealPrefix(), g));
                            this.hvO.setTag(d.g.tag_user_id, c.YO().getUserId());
                            this.hvO.setTag(d.g.tag_user_name, c.YO().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.d(this.hvO, d.C0277d.cp_cont_h, 1);
                            if (c.YO() == null) {
                            }
                            if (dVar.bHW().YO() != null) {
                            }
                            this.hvT.setUserId(c.YO().getUserId());
                            this.hvT.setUserName(c.YO().getUserName());
                            this.hvT.setTid(c.getId());
                            this.hvT.setFid(this.hsc == null ? this.hsc.getForumId() : "");
                            this.hvT.setImageDrawable(null);
                            this.hvT.setRadius(com.baidu.adp.lib.util.l.h(this.hoJ.getActivity(), d.e.ds40));
                            this.hvT.setTag(c.YO().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            ces = c.ces();
                            if (ces == null) {
                            }
                            this.hwc.setVisibility(8);
                            this.hwd.setVisibility(8);
                            portrait = c.YO().getPortrait();
                            if (c.YO().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hvT, c.YO());
                            this.hvT.setVisibility(0);
                            this.hvM.setOnClickListener(this.hxZ);
                            this.hvO.setOnClickListener(this.hxZ);
                            this.hvT.setOnClickListener(this.hxZ);
                            this.hvR.setVisibility(8);
                            this.hvT.startLoad(portrait, 28, false);
                            String name_show22 = c.YO().getName_show();
                            String userName22 = c.YO().getUserName();
                            if (com.baidu.tbadk.s.ao.jK()) {
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo222 = c.YO().getIconInfo();
                        tShowInfoNew = c.YO().getTShowInfoNew();
                        if (this.hpX != null) {
                        }
                        if (this.hpW != null) {
                        }
                        this.hvO.setText(bN(c.YO().getSealPrefix(), g));
                        this.hvO.setTag(d.g.tag_user_id, c.YO().getUserId());
                        this.hvO.setTag(d.g.tag_user_name, c.YO().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hvO, d.C0277d.cp_cont_h, 1);
                        if (c.YO() == null) {
                        }
                        if (dVar.bHW().YO() != null) {
                        }
                        this.hvT.setUserId(c.YO().getUserId());
                        this.hvT.setUserName(c.YO().getUserName());
                        this.hvT.setTid(c.getId());
                        this.hvT.setFid(this.hsc == null ? this.hsc.getForumId() : "");
                        this.hvT.setImageDrawable(null);
                        this.hvT.setRadius(com.baidu.adp.lib.util.l.h(this.hoJ.getActivity(), d.e.ds40));
                        this.hvT.setTag(c.YO().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        ces = c.ces();
                        if (ces == null) {
                        }
                        this.hwc.setVisibility(8);
                        this.hwd.setVisibility(8);
                        portrait = c.YO().getPortrait();
                        if (c.YO().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hvT, c.YO());
                        this.hvT.setVisibility(0);
                        this.hvM.setOnClickListener(this.hxZ);
                        this.hvO.setOnClickListener(this.hxZ);
                        this.hvT.setOnClickListener(this.hxZ);
                        this.hvR.setVisibility(8);
                        this.hvT.startLoad(portrait, 28, false);
                        String name_show222 = c.YO().getName_show();
                        String userName222 = c.YO().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hvL.av(dVar.bHW());
                }
                if (this.hxf != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hkt);
                    if (dVar != null && dVar.bHW() != null) {
                        hVar.hkv = dVar.bHW().YF();
                    }
                    hVar.isNew = !this.hpa;
                    hVar.sortType = dVar.hkj;
                    if (dVar.hki != null && dVar.hki.size() > dVar.hkj) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hki.size()) {
                                break;
                            } else if (dVar.hki.get(i4).sort_type.intValue() != dVar.hkj) {
                                i3 = i4 + 1;
                            } else {
                                hVar.hkx = dVar.hki.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.hky = this.hoJ.bJY();
                    this.hxf.a(hVar);
                }
                if (dVar != null && dVar.bHW() != null) {
                    Z(dVar.bHW().YK() == 1, dVar.bHW().YJ() == 1);
                }
                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hwn != null && aq.this.hvA != null && aq.this.hvA.hAD != null && aq.this.hsc != null && aq.this.hsc.bHW() != null && !aq.this.hsc.bHW().ZI() && !aq.this.bMS() && aq.this.hsc.getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(aq.this.hsc.getForum().getName())) {
                            if (aq.this.hwn.bKw() == null || !aq.this.hwn.bKw().isShown()) {
                                aq.this.hvA.hAD.setVisibility(0);
                                if (aq.this.hoJ != null && aq.this.hoJ.bIX() != null) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13400");
                                    amVar.bJ("tid", aq.this.hoJ.bIX().bKO());
                                    amVar.bJ(ImageViewerConfig.FORUM_ID, aq.this.hoJ.bIX().getForumId());
                                    amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(amVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void nP(boolean z) {
        if (z) {
            bMM();
        } else {
            aWN();
        }
        this.hxj.hyr = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxj));
        a(this.hxj.hyr, false);
    }

    public void bMM() {
        if (this.hvA != null && !this.hxz) {
            this.hvA.ok(!StringUtils.isNull(this.hoJ.bJx()));
            this.hxz = true;
        }
    }

    public void aWN() {
        if (this.hvA != null) {
            this.hvA.bNX();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.Zj() != null) {
            this.hvN.setData(this.hoJ.getPageContext(), dVar.bHY().get(0).Zj(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bHW().getId(), this.hoJ.bJV() ? "FRS" : null));
            this.hvM.setPadding(this.hvM.getPaddingLeft(), (int) this.hoJ.getResources().getDimension(d.e.ds20), this.hvM.getPaddingRight(), this.hvM.getPaddingBottom());
            return;
        }
        this.hvN.setData(null, null, null);
    }

    public void bMN() {
        if (this.hvu != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").T("obj_type", 1));
            this.hvu.bPj();
            this.hvE.smoothScrollToPosition(0);
        }
    }

    public boolean bMO() {
        return this.hya;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean ax(bg bgVar) {
        if (bgVar == null || bgVar.YO() == null || bgVar.YO().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.YO().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.hvA.bNV();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hvA.xP(cVar.forumName);
            }
            String string = this.hoJ.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.hoJ.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.hoJ.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.hoJ.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hjC;
            this.hoJ.showNetRefreshView(this.eCg, format, null, this.hoJ.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.lo()) {
                        ba.adA().c(aq.this.hoJ.getPageContext(), new String[]{str2});
                        aq.this.hoJ.finish();
                        return;
                    }
                    aq.this.hoJ.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bLY;
        Parcelable bLY2;
        if (dVar != null) {
            this.hsc = dVar;
            this.mType = i;
            if (dVar.bHW() != null) {
                this.hxl = dVar.bHW().Yw();
                if (dVar.bHW().getAnchorLevel() != 0) {
                    this.hya = true;
                }
                this.hwH = ax(dVar.bHW());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            s(dVar);
            this.hwV = false;
            this.hpa = z;
            bMI();
            b(dVar, z, i);
            q(dVar);
            if (this.hxL == null) {
                this.hxL = new ac(this.hoJ.getPageContext(), this.bsr);
            }
            this.hxL.zU(dVar.bIb());
            if (this.hoJ.bJM()) {
                if (this.hwr == null) {
                    this.hwr = new com.baidu.tieba.pb.view.c(this.hoJ.getPageContext());
                    this.hwr.oM();
                    this.hwr.setListPullRefreshListener(this.bRI);
                }
                this.hvE.setPullRefresh(this.hwr);
                bMP();
                if (this.hwr != null) {
                    this.hwr.ib(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().XI() == 0 && z) {
                this.hvE.setPullRefresh(null);
            } else {
                if (this.hwr == null) {
                    this.hwr = new com.baidu.tieba.pb.view.c(this.hoJ.getPageContext());
                    this.hwr.oM();
                    this.hwr.setListPullRefreshListener(this.bRI);
                }
                this.hvE.setPullRefresh(this.hwr);
                bMP();
                if (this.hwr != null) {
                    this.hwr.ib(TbadkCoreApplication.getInst().getSkinType());
                }
                aMt();
            }
            bMT();
            this.hwn.nd(this.hpa);
            this.hwn.ne(false);
            this.hwn.np(i == 5);
            this.hwn.nq(i == 6);
            this.hwn.nr(z2 && this.hxY);
            this.hwn.a(dVar, false);
            this.hwn.notifyDataSetChanged();
            if (this.hoJ.bIN()) {
                this.hxB = 0;
                PostData c = c(dVar, z);
                if (c != null && c.YO() != null) {
                    this.hxB = c.YO().getLevel_id();
                }
                if (this.hxB > 0) {
                    this.hvQ.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.hvQ, BitmapHelper.getGradeResourceIdInEnterForum(this.hxB));
                } else {
                    this.hvQ.setVisibility(8);
                }
            } else {
                this.hvQ.setVisibility(8);
            }
            if (dVar.bHW() != null && dVar.bHW().YA() != null) {
                if (dVar.bHW().YA().getNum() < 1) {
                    this.hoJ.getResources().getString(d.j.zan);
                } else {
                    String str = dVar.bHW().YA().getNum() + "";
                }
                if (this.hvt != -1) {
                    dVar.bHW().YA().setIsLike(this.hvt);
                }
            }
            if (this.hoJ.isLogin()) {
                this.hvE.setNextPage(this.feS);
                this.hvz = 2;
                aMt();
            } else {
                this.hwV = true;
                if (dVar.getPage().XH() == 1) {
                    if (this.hws == null) {
                        this.hws = new com.baidu.tieba.pb.view.a(this.hoJ.getPageContext());
                    }
                    this.hvE.setNextPage(this.hws);
                } else {
                    this.hvE.setNextPage(this.feS);
                }
                this.hvz = 3;
            }
            ArrayList<PostData> bHY = dVar.bHY();
            if (dVar.getPage().XH() == 0 || bHY == null || bHY.size() < dVar.getPage().XG()) {
                if (com.baidu.tbadk.core.util.v.S(bHY) == 0 || (com.baidu.tbadk.core.util.v.S(bHY) == 1 && bHY.get(0) != null && bHY.get(0).cep() == 1)) {
                    if (this.hxj == null || this.hxj.hyr == null || this.hxj.hyr.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hxj.hyr.getView().getTop() < 0 ? this.hxj.hyr.getView().getHeight() : this.hxj.hyr.getView().getBottom();
                    }
                    if (this.hoJ.bJY()) {
                        this.feS.aa(this.hoJ.getResources().getString(d.j.pb_no_host_reply), i4);
                    } else {
                        this.feS.aa(this.hoJ.getResources().getString(d.j.pb_no_replay), i4);
                    }
                    if (this.hoJ.bJm() != null && !this.hoJ.bJm().bNK()) {
                        this.hoJ.bJm().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().XH() == 0) {
                        this.feS.setText(this.hoJ.getResources().getString(d.j.list_has_no_more));
                    } else {
                        this.feS.setText(this.hoJ.getResources().getString(d.j.load_more));
                    }
                    this.feS.aeE();
                }
                bNb();
            } else {
                if (z2) {
                    if (this.hxY) {
                        aeA();
                        if (dVar.getPage().XH() != 0) {
                            this.feS.setText(this.hoJ.getResources().getString(d.j.pb_load_more));
                        }
                    } else {
                        this.feS.aev();
                        this.feS.showLoading();
                    }
                } else {
                    this.feS.aev();
                    this.feS.showLoading();
                }
                this.feS.aeE();
            }
            switch (i) {
                case 2:
                    this.hvE.setSelection(i2 > 1 ? (((this.hvE.getData() == null && dVar.bHY() == null) ? 0 : (this.hvE.getData().size() - dVar.bHY().size()) + this.hvE.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bLY2 = aj.bLX().bLY()) != null) {
                        this.hvE.onRestoreInstanceState(bLY2);
                        if (com.baidu.tbadk.core.util.v.S(bHY) > 1 && dVar.getPage().XH() > 0) {
                            this.feS.aeA();
                            this.feS.setText(this.hoJ.getString(d.j.pb_load_more_without_point));
                            this.feS.aew();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hxY = false;
                    break;
                case 5:
                    this.hvE.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bLY = aj.bLX().bLY()) != null) {
                        this.hvE.onRestoreInstanceState(bLY);
                        break;
                    } else {
                        this.hvE.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.hvu != null && this.hvu.aBz() != null) {
                            if (this.hoJ.isUseStyleImmersiveSticky()) {
                                this.hvE.setSelectionFromTop((this.hwn.bKr() + this.hvE.getHeaderViewsCount()) - 1, this.hvu.aBz().getHeight() - com.baidu.adp.lib.util.l.r(this.hoJ.getPageContext().getPageActivity()));
                            } else {
                                this.hvE.setSelectionFromTop((this.hwn.bKr() + this.hvE.getHeaderViewsCount()) - 1, this.hvu.aBz().getHeight());
                            }
                        } else {
                            this.hvE.setSelection(this.hwn.bKr() + this.hvE.getHeaderViewsCount());
                        }
                    } else {
                        this.hvE.setSelection(i2 > 0 ? ((this.hvE.getData() == null && dVar.bHY() == null) ? 0 : (this.hvE.getData().size() - dVar.bHY().size()) + this.hvE.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.feS.aeA();
                    this.feS.setText(this.hoJ.getString(d.j.pb_load_more_without_point));
                    this.feS.aew();
                    break;
            }
            if (this.hxl == hxm && isHost()) {
                bNj();
            }
            if (this.hxv) {
                bMh();
                this.hxv = false;
                if (i3 == 0) {
                    nJ(true);
                }
            }
            if (this.hvw != null) {
                this.hvw.aC(dVar.bHW());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hkg == 1 || dVar.hkh == 1) {
                if (this.hxC == null) {
                    this.hxC = new PbTopTipView(this.hoJ);
                }
                if (dVar.hkh == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hoJ.getStType())) {
                    this.hxC.setText(this.hoJ.getString(d.j.pb_read_strategy_add_experience));
                    this.hxC.show(this.eCg, this.mSkinType);
                } else if (dVar.hkg == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hoJ.getStType())) {
                    this.hxC.setText(this.hoJ.getString(d.j.pb_read_news_add_experience));
                    this.hxC.show(this.eCg, this.mSkinType);
                }
            }
            p(dVar);
        }
    }

    private void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHW() != null) {
            if (dVar.UY()) {
                com.baidu.tbadk.core.util.al.c(this.hwO, d.f.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.al.c(this.hwO, d.f.icon_pb_bottom_collect_n);
            }
            String ww = ww(dVar.bHW().YF());
            this.hwQ.M(ww, ww == null);
            this.hwQ.setVisibility(0);
        }
    }

    private String ww(int i) {
        if (i == 0) {
            return this.hoJ.getString(d.j.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return null;
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

    private void bMP() {
        if (this.hvu != null && this.hvu.aBz() != null) {
            this.hvE.removeHeaderView(this.ahN);
            if (this.mType != 1) {
                this.hvE.removeHeaderView(this.hvu.bPl());
                this.hvE.addHeaderView(this.hvu.bPl(), 0);
                return;
            }
            return;
        }
        if (this.hvu != null) {
            this.hvE.removeHeaderView(this.hvu.bPl());
        }
        this.hvE.removeHeaderView(this.ahN);
        this.hvE.addHeaderView(this.ahN, 0);
    }

    public void nQ(boolean z) {
        this.hwG = z;
    }

    public void aeA() {
        if (this.feS != null) {
            this.feS.aew();
            this.feS.aeA();
        }
        aMt();
    }

    public void aOs() {
        this.hvE.setVisibility(0);
    }

    public void q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hwU != null && this.hwU.YO() != null && this.hvA != null) {
            this.hxy = !this.hxx;
            this.hvA.of(this.hxy);
            if (this.hoJ.bJm() != null) {
                this.hoJ.bJm().oe(this.hxy);
            }
            bMQ();
            if (this.hoJ != null && !this.hoJ.bIN() && !com.baidu.tbadk.core.util.v.T(dVar.bIr())) {
                bc bcVar = dVar.bIr().get(0);
                if (bcVar != null) {
                    this.hvA.dB(bcVar.getForumName(), bcVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hvA.dB(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hxy) {
                if (this.hwH) {
                    this.hvY.setVisibility(8);
                    this.hwa.setVisibility(0);
                    this.hwa.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIs())));
                }
                if (this.hxe != null) {
                    this.hxe.setVisibility(8);
                }
                if (this.hxJ == null) {
                    this.hxJ = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hxA) {
                                aq.this.bNi();
                            }
                            aq.this.bMJ();
                        }
                    };
                }
                this.hvE.setListViewDragListener(this.hxJ);
                return;
            }
            if (this.hxe != null) {
                this.hxe.setVisibility(0);
            }
            if (this.hwH) {
                this.hvY.setVisibility(8);
                this.hwa.setVisibility(0);
                this.hwa.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIs())));
            } else if (!PbNormalLikeButtonSwitchStatic.apE() || (this.hwU.YO().hadConcerned() && this.hwU.YO().getGodUserData() != null && this.hwU.YO().getGodUserData().getIsFromNetWork())) {
                this.hvY.setVisibility(8);
                this.hwa.setVisibility(8);
            } else {
                this.hwa.setVisibility(8);
            }
            this.hxJ = null;
            this.hvE.setListViewDragListener(null);
        }
    }

    private void bMQ() {
        String threadId = this.hsc != null ? this.hsc.getThreadId() : "";
        int bMR = bMR();
        if (this.hxy && this.hwU != null && this.hwU.YO() != null) {
            this.hwU.YO().setIsLike(this.hwU.YO().hadConcerned());
        }
        if (this.hvZ == null) {
            this.hvZ = new ao(this.hoJ.getPageContext(), this.hvY, 1);
            this.hvZ.i(this.hoJ.getUniqueId());
            this.hvZ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void dV(boolean z) {
                    if (aq.this.hoJ != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hoJ, d.j.attention_success);
                    }
                }
            });
        }
        if (this.hwU != null && this.hwU.YO() != null) {
            this.hwU.YO().setIsLike(this.hwU.YO().hadConcerned());
            this.hvZ.a(this.hwU.YO());
            this.hvZ.setTid(threadId);
        }
        this.hvZ.hvp = this.hxx;
        this.hvZ.wt(bMR);
    }

    public int bMR() {
        if (this.hsc == null || this.hsc.bHW() == null) {
            return 0;
        }
        if (this.hsc.bHW().aag()) {
            return (com.baidu.tbadk.core.util.v.T(this.hsc.bIr()) && (this.hsc.bHV() == null || StringUtils.isNull(this.hsc.bHV().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bMS() {
        return this.hsc == null || this.hsc.getForum() == null || "0".equals(this.hsc.getForum().getId()) || "me0407".equals(this.hsc.getForum().getName());
    }

    private boolean bMT() {
        boolean z;
        if (this.hwK != null && this.hwK.getVisibility() == 0) {
            if (this.hwj != null) {
                this.hwj.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hwj != null) {
                this.hwj.setVisibility(8);
            }
            z = false;
        }
        if ((this.hwl == null || this.hwl.getVisibility() == 8) && z && this.hpa) {
            this.hwk.setVisibility(0);
        } else {
            this.hwk.setVisibility(8);
        }
        return z;
    }

    private boolean r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bHW() == null) {
            return false;
        }
        if (dVar.bHW().YL() == 1 || dVar.bHW().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bHW().YN() == null || dVar.bHW().YN().aaL() == 0) || dVar.bHW().YJ() == 1 || dVar.bHW().YK() == 1 || dVar.bHW().Zz() || dVar.bHW().ZO() || dVar.bHW().ZH() || dVar.bHW().Za() != null || !com.baidu.tbadk.core.util.ap.isEmpty(dVar.bHW().getCategory()) || dVar.bHW().YR() || dVar.bHW().YQ();
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hoJ.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hvG != null) {
                if (dVar.bHW() != null && dVar.bHW().Zd() == 0 && !dVar.bHW().ZI() && !this.hxO) {
                    this.hvG.setVisibility(0);
                    if (dVar.bHW() != null) {
                        bg bHW = dVar.bHW();
                        bHW.k(true, r(dVar));
                        bHW.setResource(3);
                        bHW.lj("2");
                    }
                    SpannableStringBuilder Zu = dVar.bHW().Zu();
                    this.hvH.setOnTouchListener(new com.baidu.tieba.view.k(Zu));
                    this.hvH.setText(Zu);
                    this.hvH.setVisibility(0);
                } else if (dVar.bHW().Zd() == 1) {
                    if (dVar.bHW() != null) {
                        this.hvG.setVisibility(8);
                        this.hvE.removeHeaderView(this.hvG);
                    }
                } else {
                    this.hvG.setVisibility(8);
                    this.hvE.removeHeaderView(this.hvG);
                    if (dVar.bHW() != null && dVar.bHW().ZI()) {
                        this.hvM.setPadding(this.hvM.getPaddingLeft(), 0, this.hvM.getPaddingRight(), this.hvM.getPaddingBottom());
                        if (this.hwe != null) {
                            ((RelativeLayout.LayoutParams) this.hwe.getLayoutParams()).height = (int) this.hoJ.getResources().getDimension(d.e.tbds36);
                            this.hwe.requestLayout();
                        }
                        if (this.hwf != null) {
                            ((RelativeLayout.LayoutParams) this.hwf.getLayoutParams()).height = (int) this.hoJ.getResources().getDimension(d.e.tbds0);
                            this.hwf.requestLayout();
                        }
                    } else {
                        this.hvM.setPadding(this.hvM.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.hoJ.getPageContext().getPageActivity(), d.e.ds48), this.hvM.getPaddingRight(), this.hvM.getPaddingBottom());
                    }
                }
            }
            if (dVar.bHW() != null) {
                Y(dVar.bHW().YK() == 1, dVar.bHW().YJ() == 1);
            }
            this.hpa = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bMT();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData c;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (dVar != null && (c = c(dVar, z)) != null) {
            String userId = c.YO().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, c.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.bIi()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (c.YO() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, c.YO().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_name_show, c.YO().getName_show());
                    sparseArray.put(d.g.tag_forbid_user_portrait, c.YO().getPortrait());
                    sparseArray.put(d.g.tag_forbid_user_post_id, c.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, c.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.bIi()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bc> bIr = dVar.bIr();
                if (com.baidu.tbadk.core.util.v.S(bIr) > 0) {
                    sb = new StringBuilder();
                    for (bc bcVar : bIr) {
                        if (bcVar != null && !StringUtils.isNull(bcVar.getForumName()) && (vVar = bcVar.bAD) != null && vVar.byw && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(bcVar.getForumName(), 12)).append(this.hoJ.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.hoJ.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.cpH;
    }

    public boolean bMU() {
        if (this.eoA == null || this.eoA.getParent() == null || this.feS.qz()) {
            return false;
        }
        int bottom = this.eoA.getBottom();
        Rect rect = new Rect();
        this.eoA.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void zV(String str) {
        if (this.feS != null) {
            this.feS.setText(str);
        }
    }

    public void zW(String str) {
        if (this.feS != null) {
            int i = 0;
            if (this.hxj != null && this.hxj.hyr != null && this.hxj.hyr.getView() != null) {
                i = this.hxj.hyr.getView().getTop() < 0 ? this.hxj.hyr.getView().getHeight() : this.hxj.hyr.getView().getBottom();
            }
            this.feS.aa(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hvE;
    }

    public int bMV() {
        return d.g.richText;
    }

    public TextView bJi() {
        return this.hvL.bJi();
    }

    public void e(BdListView.e eVar) {
        this.hvE.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.bRI = cVar;
        if (this.hwr != null) {
            this.hwr.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int XF = anVar.XF();
            int XC = anVar.XC();
            if (this.hwo != null) {
                this.hwo.aaW();
            } else {
                this.hwo = new com.baidu.tbadk.core.dialog.a(this.hoJ.getPageContext().getPageActivity());
                this.hwp = LayoutInflater.from(this.hoJ.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.hwo.az(this.hwp);
                this.hwo.a(d.j.dialog_ok, bVar);
                this.hwo.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bMX();
                        aVar.dismiss();
                    }
                });
                this.hwo.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hxs == null) {
                            aq.this.hxs = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hoJ.HidenSoftKeyPad((InputMethodManager) aq.this.hoJ.getSystemService("input_method"), aq.this.eCg);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jH().postDelayed(aq.this.hxs, 150L);
                    }
                });
                this.hwo.b(this.hoJ.getPageContext()).aaW();
            }
            this.hwq = (EditText) this.hwp.findViewById(d.g.input_page_number);
            this.hwq.setText("");
            TextView textView = (TextView) this.hwp.findViewById(d.g.current_page_number);
            if (XF <= 0) {
                XF = 1;
            }
            if (XC <= 0) {
                XC = 1;
            }
            textView.setText(MessageFormat.format(this.hoJ.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(XF), Integer.valueOf(XC)));
            this.hoJ.ShowSoftKeyPadDelay(this.hwq, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hvE.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hoJ.showToast(str);
    }

    public boolean nR(boolean z) {
        if (this.VN == null || !this.VN.alS()) {
            return false;
        }
        this.VN.akm();
        return true;
    }

    public void bMW() {
        if (this.hyb != null) {
            while (this.hyb.size() > 0) {
                TbImageView remove = this.hyb.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bMW();
        this.hwn.we(1);
        if (this.hvu != null) {
            this.hvu.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hwn.we(2);
        if (this.hvu != null) {
            this.hvu.onResume();
            if (!UtilHelper.isOnePlus6()) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hxu != null) {
            this.hxu.destroy();
        }
        if (this.hxL != null) {
            this.hxL.onDestory();
        }
        if (this.hxC != null) {
            this.hxC.hide();
        }
        if (this.hvx != null) {
            this.hvx.aSp();
        }
        if (this.hvw != null) {
            this.hvw.onDestroy();
        }
        this.hoJ.hideProgressBar();
        if (this.eCe != null && this.eWp != null) {
            this.eCe.b(this.eWp);
        }
        bMX();
        aeA();
        if (this.hxs != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hxs);
        }
        if (this.hvM != null && this.hvX != null) {
            this.hvM.removeView(this.hvS);
            this.hvX = null;
        }
        if (this.hwZ != null) {
            this.hwZ.clearStatus();
        }
        this.hxU = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hwn.we(3);
        if (this.faY != null) {
            this.faY.setBackgroundDrawable(null);
        }
        if (this.hvu != null) {
            this.hvu.destroy();
        }
        if (this.hwn != null) {
            this.hwn.onDestroy();
        }
        this.hvE.setOnLayoutListener(null);
        if (this.hxH != null) {
            this.hxH.beW();
        }
        if (this.hxk != null) {
            this.hxk.onDestroy();
        }
    }

    public boolean wx(int i) {
        if (this.hvu != null) {
            return this.hvu.qs(i);
        }
        return false;
    }

    public void bMX() {
        this.hvA.Qi();
        if (this.hvx != null) {
            this.hvx.aSp();
        }
        com.baidu.adp.lib.util.l.b(this.hoJ.getPageContext().getPageActivity(), this.hwq);
        bMj();
        if (this.hmP != null) {
            this.hmP.dismiss();
        }
        bMZ();
        if (this.hvw != null) {
            this.hvw.bPa();
        }
        if (this.hwo != null) {
            this.hwo.dismiss();
        }
        if (this.faK != null) {
            this.faK.dismiss();
        }
    }

    public void bMY() {
        this.hvA.Qi();
        if (this.hvx != null) {
            this.hvx.aSp();
        }
        if (this.hmP != null) {
            this.hmP.dismiss();
        }
        bMZ();
        if (this.hvw != null) {
            this.hvw.bPa();
        }
        if (this.hwo != null) {
            this.hwo.dismiss();
        }
        if (this.faK != null) {
            this.faK.dismiss();
        }
    }

    public void dA(List<String> list) {
        this.hxG = list;
        if (this.hxH != null) {
            this.hxH.setData(list);
        }
    }

    public void nc(boolean z) {
        this.hwn.nc(z);
    }

    public void nS(boolean z) {
        this.hwJ = z;
    }

    public void bMZ() {
        if (this.hwx != null) {
            this.hwx.dismiss();
        }
        if (this.hwy != null) {
            com.baidu.adp.lib.g.g.b(this.hwy, this.hoJ.getPageContext());
        }
        if (this.hwz != null) {
            com.baidu.adp.lib.g.g.b(this.hwz, this.hoJ.getPageContext());
        }
        if (this.hwv != null) {
            this.hwv.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hsc, this.hpa);
            d(this.hsc, this.hpa, this.mType);
            this.hoJ.getLayoutMode().setNightMode(i == 1);
            this.hoJ.getLayoutMode().onModeChanged(this.eCg);
            this.hoJ.getLayoutMode().onModeChanged(this.hvF);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.al.l(this.eCg, d.C0277d.cp_bg_line_d);
            }
            if (this.hvw != null) {
                this.hvw.onChangeSkinType(i);
            }
            if (this.hvH != null) {
                com.baidu.tbadk.core.util.al.j(this.hvH, d.C0277d.cp_cont_b);
                this.hvH.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            }
            if (this.feS != null) {
                this.feS.ib(i);
                if (this.cpH != null) {
                    this.hoJ.getLayoutMode().onModeChanged(this.cpH);
                    com.baidu.tbadk.core.util.al.k(this.cpH, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.hwo != null) {
                this.hwo.c(this.hoJ.getPageContext());
            }
            nQ(this.hwG);
            this.hwn.notifyDataSetChanged();
            if (this.hwr != null) {
                this.hwr.ib(i);
            }
            if (this.VN != null) {
                this.VN.onChangeSkinType(i);
            }
            if (this.hvW != null) {
                this.hvW.ii(i);
            }
            if (this.hws != null) {
                this.hws.ib(i);
            }
            if (!com.baidu.tbadk.core.util.v.T(this.ekf)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ekf) {
                    customBlueCheckRadioButton.aee();
                }
            }
            bMy();
            UtilHelper.setStatusBarBackground(this.faY, i);
            UtilHelper.setStatusBarBackground(this.hxe, i);
            if (this.hvY != null) {
                this.hvY.onChangeSkinType(i);
            }
            if (this.hwc != null) {
                com.baidu.tbadk.core.util.al.j(this.hwc, d.C0277d.cp_cont_d);
            }
            if (this.hwb != null) {
                com.baidu.tbadk.core.util.al.j(this.hwb, d.C0277d.cp_cont_d);
            }
            if (this.hwd != null) {
                com.baidu.tbadk.core.util.al.j(this.hwd, d.C0277d.cp_cont_d);
            }
            if (this.hvP != null) {
                com.baidu.tbadk.core.util.al.j(this.hvP, d.C0277d.cp_link_tip_a);
            }
            if (this.hwa != null) {
                com.baidu.tbadk.core.util.al.j(this.hwa, d.C0277d.cp_cont_d);
            }
            if (this.hwg != null) {
                com.baidu.tbadk.r.a.a(this.hoJ.getPageContext(), this.hwg);
            }
            if (this.hxt != null) {
                this.hxt.onChangeSkinType(i);
            }
            if (this.hvA != null) {
                if (this.hvu != null) {
                    this.hvu.wC(i);
                } else {
                    this.hvA.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fOS != null) {
                com.baidu.tbadk.core.util.al.j(this.fOS, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.k(this.fOS, d.f.bg_comment_input);
            }
            if (this.hwO != null && this.hsc != null) {
                if (this.hsc.UY()) {
                    com.baidu.tbadk.core.util.al.c(this.hwO, d.f.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.hwO, d.f.icon_pb_bottom_collect_n);
                }
            }
            if (this.hwP != null) {
                com.baidu.tbadk.core.util.al.c(this.hwP, d.f.icon_pb_bottom_share_n);
            }
            if (this.hwN != null) {
                com.baidu.tbadk.core.util.al.c(this.hwN, d.f.icon_pb_bottom_comment_n);
            }
            if (this.hwQ != null) {
                this.hwQ.onChangeSkinType();
            }
            if (this.hvQ != null) {
                com.baidu.tbadk.core.util.al.c(this.hvQ, BitmapHelper.getGradeResourceIdInEnterForum(this.hxB));
            }
            if (this.hxI != null) {
                this.hxI.onChangeSkinType(i);
            }
            if (this.hxk != null) {
                this.hxk.onChangeSkinType();
            }
            if (this.hxE != null) {
                com.baidu.tbadk.core.util.al.j(this.hxE, d.C0277d.cp_cont_n);
            }
            com.baidu.tbadk.core.util.al.l(this.hwM, d.C0277d.cp_bg_line_d);
            if (this.hvP != null) {
                com.baidu.tbadk.core.util.al.k(this.hvP, d.f.bg_user_identity_btn);
                com.baidu.tbadk.core.util.al.j(this.hvP, d.C0277d.cp_bg_line_d);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAD = hVar;
        this.hwn.setOnImageClickListener(this.cAD);
        this.hxI.setOnImageClickListener(this.cAD);
    }

    public void h(NoNetworkView.a aVar) {
        this.eWp = aVar;
        if (this.eCe != null) {
            this.eCe.a(this.eWp);
        }
    }

    public void nT(boolean z) {
        this.hwn.setIsFromCDN(z);
    }

    public Button bNa() {
        return this.hwK;
    }

    public void bNb() {
        if (this.hvz != 2) {
            this.hvE.setNextPage(this.feS);
            this.hvz = 2;
        }
    }

    public void bNc() {
        if (com.baidu.tbadk.o.m.apg().aph()) {
            int lastVisiblePosition = this.hvE.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hvE.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.o.h perfLog = tbImageView.getPerfLog();
                                perfLog.jW(1001);
                                perfLog.cqo = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.o.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.jW(1001);
                        perfLog2.cqo = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean bNd() {
        return this.VN != null && this.VN.getVisibility() == 0;
    }

    public boolean bNe() {
        return this.VN != null && this.VN.alS();
    }

    public void bNf() {
        if (this.VN != null) {
            this.VN.akm();
        }
    }

    public void nU(boolean z) {
        if (this.hwM != null) {
            nS(this.hoJ.bJj().amw());
            if (this.hwJ) {
                nK(z);
            } else {
                nL(z);
            }
        }
    }

    public void bNg() {
        if (this.hwM != null) {
            this.hwL.setVisibility(8);
            this.hwM.setVisibility(8);
            this.hwR = false;
            if (this.hxk != null) {
                this.hxk.setVisibility(8);
                nO(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.erO == null) {
            this.erO = new com.baidu.tbadk.core.view.b(this.hoJ.getPageContext());
        }
        this.erO.dJ(true);
    }

    public void aMt() {
        if (this.erO != null) {
            this.erO.dJ(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hvE.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hvE.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hvu != null) {
            this.hvu.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hyc = getScrollY();
            this.hxj.hyr = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxj));
            a(this.hxj.hyr, true);
        }
    }

    public void nV(boolean z) {
        this.hvu.nV(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hvu != null) {
            this.hvu.b(absListView, i);
        }
        if (this.hvA != null && this.hwn != null) {
            this.hvA.a(this.hwn.bKw());
        }
        this.hxj.hfc = i;
        this.hxj.headerCount = this.hvE.getHeaderViewsCount();
        this.hxj.hyr = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxj));
        a(this.hxj.hyr, false);
        if (this.feS.aeG() && !this.feS.bRx) {
            if (this.hxj != null && this.hxj.hyr != null && this.hxj.hyr.getView() != null) {
                i4 = this.hxj.hyr.getView().getTop() < 0 ? this.hxj.hyr.getView().getHeight() : this.hxj.hyr.getView().getBottom();
            }
            this.feS.ie(i4);
            this.feS.bRx = true;
        }
    }

    public void bNh() {
        if (this.hoJ.isLogin() && this.hsc != null && this.hxy && !this.hxx && !this.hwH && this.hwU != null && this.hwU.YO() != null && !this.hwU.YO().getIsLike() && !this.hwU.YO().hadConcerned() && this.hxu == null) {
            this.hxu = new an(this.hoJ);
        }
    }

    public void bNi() {
        if (this.hxy && !this.hxx && this.hwU != null && this.hwU.YO() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").T("obj_locate", this.hoJ.bIN() ? 2 : 1).T("obj_type", this.hxx ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hoJ.getPageContext().getPageActivity(), this.hwU.YO().getUserId(), this.hwU.YO().getUserName(), this.hoJ.bIX().bIO(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hxx && this.hxd != null && this.hvA.bNQ() != null) {
            int bKs = this.hwn.bKs();
            if (bKs > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bKs > this.hvE.getFirstVisiblePosition() - this.hvE.getHeaderViewsCount()) {
                    this.hxd.setVisibility(8);
                    return;
                }
                this.hxd.setVisibility(0);
                bNs();
                this.hvA.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.huY == null) {
                if (this.hvE.getFirstVisiblePosition() == 0) {
                    this.hxd.setVisibility(8);
                    this.hvA.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hxi) {
                        this.hxh = top;
                        this.hxi = false;
                    }
                    this.hxh = top < this.hxh ? top : this.hxh;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hwm.getY() < 0.0f) {
                        measuredHeight = hxg - alVar.huY.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hvA.bNQ().getMeasuredHeight() - alVar.huY.getMeasuredHeight();
                        this.hvA.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hxh) {
                        this.hxd.setVisibility(0);
                        bNs();
                    } else if (top < measuredHeight) {
                        this.hxd.setVisibility(0);
                        bNs();
                    } else {
                        this.hxd.setVisibility(8);
                        this.hvA.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hxi = true;
                    }
                }
            }
        }
    }

    public void bNj() {
        if (!this.hyd) {
            TiebaStatic.log("c10490");
            this.hyd = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hoJ.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hxn, Integer.valueOf(hxp));
            aVar.gB(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hoJ.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.az(inflate);
            aVar.Z(sparseArray);
            aVar.a(d.j.grade_button_tips, this.hoJ);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hoJ.getPageContext()).aaW();
        }
    }

    public void zX(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hoJ.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hoJ.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.az(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hxn, Integer.valueOf(hxq));
        aVar.Z(sparseArray);
        aVar.a(d.j.view, this.hoJ);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hoJ.getPageContext()).aaW();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData c;
        if (i > 0 && (c = c(dVar, z)) != null && c.YO() != null) {
            MetaData YO = c.YO();
            YO.setGiftNum(YO.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        q(dVar);
    }

    public PbInterviewStatusView bNk() {
        return this.hwZ;
    }

    private void s(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHW() != null && dVar.bHW().ZO() && this.hwZ == null) {
            this.hwZ = (PbInterviewStatusView) this.hwY.inflate();
            this.hwZ.setOnClickListener(this.faL);
            this.hwZ.setCallback(this.hoJ.bJU());
            this.hwZ.setData(this.hoJ, dVar);
        }
    }

    public LinearLayout bNl() {
        return this.hwm;
    }

    public View bNm() {
        return this.faY;
    }

    public boolean bNn() {
        return this.hxO;
    }

    public void nh(boolean z) {
        this.hvL.nh(z);
    }

    public void zY(String str) {
        if (this.hvB != null) {
            this.hvB.setTitle(str);
        }
    }

    private int nW(boolean z) {
        if (this.hwZ == null || this.hwZ.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.hoJ.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bNo() {
        if (this.hwZ != null && this.hwZ.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hwZ.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hwZ.setLayoutParams(layoutParams);
        }
    }

    public boolean bJo() {
        return false;
    }

    public void zZ(String str) {
        this.fOS.performClick();
        if (!StringUtils.isNull(str) && this.hoJ.bJj() != null && this.hoJ.bJj().amp() != null && this.hoJ.bJj().amp().getInputView() != null) {
            EditText inputView = this.hoJ.bJj().amp().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bMX();
            if (configuration.orientation == 2) {
                bNg();
                bMj();
            } else {
                bMm();
            }
            if (this.hxt != null) {
                this.hxt.bKB();
            }
            this.hoJ.bcL();
            this.hwm.setVisibility(8);
            this.hvA.og(false);
            this.hoJ.nn(false);
            if (this.hvu != null) {
                if (configuration.orientation == 1) {
                    bNl().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hvE.setIsLandscape(true);
                    this.hvE.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hvE.setIsLandscape(false);
                    if (this.hyc > 0) {
                        this.hvE.smoothScrollBy(this.hyc, 0);
                    }
                }
                this.hvu.onConfigurationChanged(configuration);
                this.hxc.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void nX(boolean z) {
        this.hvy = z;
    }

    public boolean bNp() {
        return this.hvu != null && this.hvu.bNp();
    }

    public void bNq() {
        if (this.hvu != null) {
            this.hvu.onPause();
        }
    }

    public void s(long j, int i) {
        if (this.hvw != null) {
            this.hvw.s(j, i);
        }
        if (this.hvu != null) {
            this.hvu.s(j, i);
        }
    }

    public void ns(boolean z) {
        this.hwn.ns(z);
    }

    public void bNr() {
        if (this.hxa == null) {
            LayoutInflater.from(this.hoJ.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.eCg, true);
            this.hxa = (ViewGroup) this.eCg.findViewById(d.g.add_experienced_layout);
            this.hxb = (TextView) this.eCg.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.al.j(this.hxb, d.C0277d.cp_btn_a);
            String string = this.hoJ.getResources().getString(d.j.experienced_add_success);
            String string2 = this.hoJ.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_h)));
            this.hxb.setText(spannableString);
        }
        this.hxa.setVisibility(0);
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
                        aq.this.hxa.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hxb.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hxb.startAnimation(scaleAnimation);
    }

    public void ct(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hwM.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hoJ);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.hxE = new TextView(this.hoJ);
            this.hxE.setText(d.j.connection_tips);
            this.hxE.setGravity(17);
            this.hxE.setPadding(com.baidu.adp.lib.util.l.h(this.hoJ, d.e.ds24), 0, com.baidu.adp.lib.util.l.h(this.hoJ, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hoJ, d.e.ds60);
            if (this.hxE.getParent() == null) {
                frameLayout.addView(this.hxE, layoutParams);
            }
            this.hxD = new PopupWindow(this.hoJ);
            this.hxD.setContentView(frameLayout);
            this.hxD.setHeight(-2);
            this.hxD.setWidth(-2);
            this.hxD.setFocusable(true);
            this.hxD.setOutsideTouchable(false);
            this.hxD.setBackgroundDrawable(new ColorDrawable(this.hoJ.getResources().getColor(d.C0277d.transparent)));
            this.hvE.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hxD.showAsDropDown(aq.this.hwM, view.getLeft(), -aq.this.hwM.getHeight());
                    } else {
                        aq.this.hxD.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bNs() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.hxF == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.hxF = new com.baidu.tbadk.core.dialog.a(this.hoJ);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hoJ);
            this.hxF.gE(1);
            this.hxF.az(pbLongPressTipView);
            this.hxF.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hxF.dr(false);
            this.hxF.b(this.hoJ.getPageContext()).aaW();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hxF != null && aq.this.hxF.isShowing()) {
                        aq.this.hxF.dismiss();
                    }
                }
            }, 5000L);
            if (this.hvu != null) {
                this.hvu.bPk();
            }
        }
    }

    public void nY(boolean z) {
        this.hxK = z;
    }

    public boolean bNt() {
        return this.hxK;
    }

    private void Y(boolean z, boolean z2) {
        Z(z, z2);
        aa(z, z2);
        if (this.hwn != null && this.hwn.bKx() != null) {
            this.hwn.bKx().S(z, z2);
        }
    }

    private void Z(boolean z, boolean z2) {
        if (z && z2) {
            this.hvJ.setImageResource(d.f.pic_pb_stick_refined_n);
            this.hvJ.setVisibility(0);
        } else if (z) {
            this.hvJ.setImageResource(d.f.pic_pb_refined_n);
            this.hvJ.setVisibility(0);
        } else if (z2) {
            this.hvJ.setImageResource(d.f.pic_pb_stick_n);
            this.hvJ.setVisibility(0);
        } else {
            this.hvJ.setVisibility(8);
        }
    }

    private void aa(boolean z, boolean z2) {
        if (this.hvG != null && this.hsc != null && this.hsc.bHW() != null && this.hsc.bHW().Zd() == 0 && !this.hsc.bHW().ZI()) {
            if (z && z2) {
                this.hvK.setImageResource(d.f.pic_pb_stick_refined_n);
                this.hvK.setVisibility(0);
            } else if (z) {
                this.hvK.setImageResource(d.f.pic_pb_refined_n);
                this.hvK.setVisibility(0);
            } else if (z2) {
                this.hvK.setImageResource(d.f.pic_pb_stick_n);
                this.hvK.setVisibility(0);
            } else {
                this.hvK.setVisibility(8);
            }
        }
    }
}
