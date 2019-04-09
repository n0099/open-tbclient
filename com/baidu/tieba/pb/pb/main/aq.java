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
    private EditorTools VO;
    private TextView ahO;
    private h.c bRJ;
    private NavigationBarCoverTip bss;
    private com.baidu.tieba.pb.a.c ccb;
    private View cpI;
    private int dSH;
    private NoNetworkView eCf;
    private RelativeLayout eCh;
    private List<CustomBlueCheckRadioButton> ekg;
    private View eoB;
    private TextView fOS;
    private View.OnClickListener faL;
    private View faY;
    private PbListView feS;
    private com.baidu.tieba.NEGFeedBack.e fzr;
    PbActivity.d hnP;
    private PbActivity hoK;
    private UserIconBox hpX;
    private UserIconBox hpY;
    private View.OnClickListener hpj;
    private PbFakeFloorModel hqV;
    private com.baidu.tieba.pb.data.d hsd;
    public final com.baidu.tieba.pb.pb.main.view.b hvB;
    public com.baidu.tieba.pb.pb.main.view.a hvC;
    private ViewStub hvD;
    private ViewStub hvE;
    private PbLandscapeListView hvF;
    private View hvG;
    private RelativeLayout hvJ;
    private ImageView hvK;
    private ImageView hvL;
    private e hvM;
    private ColumnLayout hvN;
    private ThreadSkinView hvO;
    private TextView hvP;
    private TextView hvQ;
    private ImageView hvR;
    private HeadPendantView hvS;
    private FrameLayout hvT;
    private HeadImageView hvU;
    private View hvV;
    private LinearLayout hvW;
    private PbFirstFloorUserLikeButton hvZ;
    public int hvu;
    public com.baidu.tieba.pb.video.i hvv;
    private long hvw;
    private com.baidu.tieba.pb.video.h hvx;
    private com.baidu.tieba.c.d hvy;
    private View hwM;
    private View hwN;
    private ImageView hwO;
    private ImageView hwP;
    private ImageView hwQ;
    private MessageRedDotView hwR;
    private int hwT;
    private int hwU;
    private PostData hwV;
    private View hwX;
    private TextView hwY;
    private ViewStub hwZ;
    private ao hwa;
    private TextView hwb;
    private TextView hwc;
    private TextView hwd;
    private TextView hwe;
    private View hwf;
    private View hwg;
    private LinearLayout hwh;
    private TextView hwi;
    private TextView hwj;
    private View hwk;
    private View hwl;
    private ObservedChangeLinearLayout hwn;
    private f hwo;
    private View hwu;
    private int hxB;
    private PbTopTipView hxD;
    private PopupWindow hxE;
    private TextView hxF;
    private com.baidu.tbadk.core.dialog.a hxG;
    private List<String> hxH;
    private com.baidu.tieba.pb.pb.main.emotion.c hxI;
    private com.baidu.tieba.pb.pb.godreply.a hxJ;
    private PbLandscapeListView.b hxK;
    private ac hxM;
    private String hxN;
    private boolean hxP;
    private com.baidu.tbadk.core.view.userLike.c hxQ;
    private com.baidu.tbadk.core.view.userLike.c hxR;
    private Runnable hxW;
    private PbActivity.b hxY;
    private PbInterviewStatusView hxa;
    private ViewGroup hxb;
    private TextView hxc;
    private FrameLayout hxd;
    private View hxe;
    private View hxf;
    private al hxg;
    private PbEmotionBar hxl;
    private Runnable hxt;
    private s hxu;
    private an hxv;
    public int hyd;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private static final int hxh = UtilHelper.getLightStatusBarHeight();
    public static int hxn = 3;
    public static int hxo = 0;
    public static int hxp = 3;
    public static int hxq = 4;
    public static int hxr = 5;
    public static int hxs = 6;
    private static a.InterfaceC0388a hxO = new a.InterfaceC0388a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0388a
        public void onRefresh() {
        }
    };
    private boolean hvz = false;
    private int hvA = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hvH = null;
    private TextView hvI = null;
    public FrsPraiseView hvX = null;
    private ClickableHeaderImageView hvY = null;
    private View hwm = null;
    private com.baidu.tbadk.core.dialog.a hwp = null;
    private com.baidu.tbadk.core.dialog.b faK = null;
    private View hwq = null;
    private EditText hwr = null;
    private com.baidu.tieba.pb.view.c hws = null;
    private com.baidu.tieba.pb.view.a hwt = null;
    private com.baidu.tbadk.core.dialog.a hwv = null;
    private b.InterfaceC0225b gmt = null;
    private TbRichTextView.h cAE = null;
    private NoNetworkView.a eWq = null;
    private com.baidu.tbadk.core.dialog.g hww = null;
    private View hwx = null;
    private com.baidu.tbadk.core.dialog.a hwy = null;
    private Dialog hwz = null;
    private Dialog hwA = null;
    private View hwB = null;
    private LinearLayout hwC = null;
    private CompoundButton.OnCheckedChangeListener ekh = null;
    private TextView hwD = null;
    private TextView hwE = null;
    private String hwF = null;
    private com.baidu.tbadk.core.dialog.g hmQ = null;
    private com.baidu.tbadk.core.dialog.g hwG = null;
    private boolean hwH = false;
    private boolean hwI = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hwJ = null;
    private boolean hwK = false;
    private Button hwL = null;
    private boolean hwS = true;
    private com.baidu.tbadk.core.view.b erP = null;
    private boolean hpb = false;
    private int mSkinType = 3;
    private boolean hwW = false;
    private int hxi = 0;
    private boolean hxj = true;
    public a hxk = new a();
    private int hxm = 0;
    private boolean hxw = false;
    private int hxx = 0;
    private boolean hxy = false;
    private boolean hxz = false;
    private boolean hxA = false;
    private int hxC = 0;
    private boolean hxL = false;
    private String hxS = null;
    private CustomMessageListener hxT = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hxS = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hwo != null) {
                aq.this.hwo.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hxU = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hvI != null) {
                aq.this.hvI.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hxV = new Handler();
    private CustomMessageListener hxX = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hwS = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hxZ = true;
    View.OnClickListener hya = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hxy) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").T(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hxy && aq.this.hsd != null && aq.this.hsd.bHW() != null && aq.this.hsd.bHW().YO() != null && aq.this.hsd.bHW().YO().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").T("obj_locate", 1));
            }
            aq.this.hoK.hmL.fzX.onClick(view);
        }
    };
    private boolean hyb = false;
    String userId = null;
    private final List<TbImageView> hyc = new ArrayList();
    private boolean hye = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int headerCount;
        public int hfd;
        public al hys;
    }

    public void nJ(boolean z) {
        this.hxw = z;
        if (this.hvF != null) {
            this.hxx = this.hvF.getHeaderViewsCount();
        }
    }

    public void bMh() {
        if (this.hvF != null) {
            int headerViewsCount = this.hvF.getHeaderViewsCount() - this.hxx;
            final int firstVisiblePosition = (this.hvF.getFirstVisiblePosition() == 0 || this.hvF.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hvF.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hvF.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hxk.hys = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxk));
            final al alVar = this.hxk.hys;
            final int h = h(alVar);
            final int y = ((int) this.hwn.getY()) + this.hwn.getMeasuredHeight();
            final boolean z = this.hxe.getVisibility() == 0;
            boolean z2 = this.hwn.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hwo.bKs() + this.hvF.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.huZ.getMeasuredHeight() : 0;
                if (z2) {
                    this.hvF.setSelectionFromTop(this.hwo.bKs() + this.hvF.getHeaderViewsCount(), hxh - measuredHeight);
                } else {
                    this.hvF.setSelectionFromTop(this.hwo.bKs() + this.hvF.getHeaderViewsCount(), this.hvB.bNQ().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hvF.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hxy) {
                this.hvF.setSelectionFromTop(this.hwo.bKs() + this.hvF.getHeaderViewsCount(), this.hvv.aBz().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hvF.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bKK() {
                        if (h >= 0 && h <= aq.this.eCh.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.eoB.getLayoutParams();
                            if (i == 0 || i > aq.this.eCh.getMeasuredHeight() || h2 >= aq.this.eCh.getMeasuredHeight()) {
                                layoutParams.height = aq.this.dSH;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.eCh.getMeasuredHeight()) {
                                layoutParams.height = aq.this.dSH;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hvF.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.eoB.setLayoutParams(layoutParams);
                        }
                        aq.this.hvF.setOnLayoutListener(null);
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
        return this.eCf;
    }

    public void bMj() {
        if (this.VO != null) {
            this.VO.hide();
            if (this.hxI != null) {
                this.hxI.aAy();
            }
        }
    }

    public PbFakeFloorModel bMk() {
        return this.hqV;
    }

    public s bMl() {
        return this.hxu;
    }

    public void bMm() {
        reset();
        bMj();
        this.hxu.bKB();
        nU(false);
    }

    private void reset() {
        if (this.hoK != null && this.hoK.bJj() != null && this.VO != null) {
            com.baidu.tbadk.editortools.pb.a.amm().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bJj = this.hoK.bJj();
            bJj.amF();
            bJj.ama();
            if (bJj.getWriteImagesInfo() != null) {
                bJj.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bJj.jB(SendView.ALL);
            bJj.jC(SendView.ALL);
            com.baidu.tbadk.editortools.g js = this.VO.js(23);
            com.baidu.tbadk.editortools.g js2 = this.VO.js(2);
            com.baidu.tbadk.editortools.g js3 = this.VO.js(5);
            if (js2 != null) {
                js2.qT();
            }
            if (js3 != null) {
                js3.qT();
            }
            if (js != null) {
                js.hide();
            }
            this.VO.invalidate();
        }
    }

    public boolean bMn() {
        return this.hwS;
    }

    public void nK(boolean z) {
        if (this.hwN != null && this.fOS != null) {
            this.fOS.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hwN.startAnimation(alphaAnimation);
            }
            this.hwM.setVisibility(0);
            this.hwN.setVisibility(0);
            this.hwS = true;
            if (this.hxl != null && !this.hxJ.isActive()) {
                this.hxl.setVisibility(0);
                nO(true);
            }
        }
    }

    public void nL(boolean z) {
        if (this.hwN != null && this.fOS != null) {
            this.fOS.setText(bMo());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hwN.startAnimation(alphaAnimation);
            }
            this.hwM.setVisibility(0);
            this.hwN.setVisibility(0);
            this.hwS = true;
            if (this.hxl != null && !this.hxJ.isActive()) {
                this.hxl.setVisibility(0);
                nO(true);
            }
        }
    }

    public String bMo() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.hxN)) {
            return this.hxN;
        }
        if (this.hoK != null) {
            this.hxN = this.hoK.getResources().getString(ap.bMg());
        }
        return this.hxN;
    }

    public PostData bMp() {
        int i = 0;
        if (this.hvF == null) {
            return null;
        }
        int bMq = bMq() - this.hvF.getHeaderViewsCount();
        if (bMq < 0) {
            bMq = 0;
        }
        if (this.hwo.wd(bMq) != null && this.hwo.wd(bMq) != PostData.iFM) {
            i = bMq + 1;
        }
        return this.hwo.getItem(i) instanceof PostData ? (PostData) this.hwo.getItem(i) : null;
    }

    public int bMq() {
        int i;
        View childAt;
        if (this.hvF == null) {
            return 0;
        }
        int firstVisiblePosition = this.hvF.getFirstVisiblePosition();
        int lastVisiblePosition = this.hvF.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hvF.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hvF.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        return this.hvF.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hsd != null && this.hsd.bHY() != null && !this.hsd.bHY().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hsd.bHY().size() && (postData = this.hsd.bHY().get(i)) != null && postData.YO() != null && !StringUtils.isNull(postData.YO().getUserId()); i++) {
                if (this.hsd.bHY().get(i).YO().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hxJ != null && this.hxJ.isActive()) {
                        nU(false);
                    }
                    if (this.hxl != null) {
                        this.hxl.oc(true);
                    }
                    this.hxS = postData.YO().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hoK = null;
        this.eCh = null;
        this.faY = null;
        this.hvw = 0L;
        this.hvF = null;
        this.hvG = null;
        this.hvJ = null;
        this.hvN = null;
        this.hvP = null;
        this.hvQ = null;
        this.hvT = null;
        this.hvU = null;
        this.hvV = null;
        this.hvZ = null;
        this.hwb = null;
        this.hwc = null;
        this.hwd = null;
        this.hwe = null;
        this.hwk = null;
        this.hwl = null;
        this.hwo = null;
        this.feS = null;
        this.cpI = null;
        this.faL = null;
        this.hpj = null;
        this.hwN = null;
        this.fOS = null;
        this.hwX = null;
        this.hwY = null;
        this.hwZ = null;
        this.hxB = 0;
        this.hvw = System.currentTimeMillis();
        this.hoK = pbActivity;
        this.faL = onClickListener;
        this.ccb = cVar;
        this.hxB = com.baidu.adp.lib.util.l.aO(this.hoK) / 2;
        this.eCh = (RelativeLayout) LayoutInflater.from(this.hoK.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.hoK.addContentView(this.eCh, new FrameLayout.LayoutParams(-1, -1));
        this.bss = (NavigationBarCoverTip) this.hoK.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.faY = this.hoK.findViewById(d.g.statebar_view);
        this.hwn = (ObservedChangeLinearLayout) this.hoK.findViewById(d.g.title_wrapper);
        this.eCf = (NoNetworkView) this.hoK.findViewById(d.g.view_no_network);
        this.hvF = (PbLandscapeListView) this.hoK.findViewById(d.g.new_pb_list);
        this.hxd = (FrameLayout) this.hoK.findViewById(d.g.root_float_header);
        this.ahO = new TextView(this.hoK.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.hoK.getActivity(), d.e.ds88));
        this.hvF.addHeaderView(this.ahO, 0);
        this.dSH = this.hoK.getResources().getDimensionPixelSize(d.e.tbds134);
        this.eoB = new View(this.hoK.getPageContext().getPageActivity());
        this.eoB.setLayoutParams(new AbsListView.LayoutParams(-1, this.dSH));
        this.eoB.setVisibility(4);
        this.hvF.addFooterView(this.eoB);
        this.hvF.setOnTouchListener(this.hoK.ccX);
        this.hvB = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.hoK.bJM()) {
            this.hvD = (ViewStub) this.hoK.findViewById(d.g.manga_view_stub);
            this.hvD.setVisibility(0);
            this.hvC = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.hvC.show();
            this.hvB.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hoK.getActivity(), d.e.ds120);
        }
        this.ahO.setLayoutParams(layoutParams);
        this.hvB.bNQ().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0349a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0349a
            public void bIH() {
                if (aq.this.hvF != null) {
                    if (aq.this.hvv != null) {
                        aq.this.hvv.bPj();
                    }
                    aq.this.hvF.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0349a
            public void bII() {
                aq.this.hoK.bcL();
            }
        }));
        this.hwM = this.hoK.findViewById(d.g.view_comment_top_line);
        this.hwN = this.hoK.findViewById(d.g.pb_editor_tool_comment);
        this.hwT = com.baidu.adp.lib.util.l.h(this.hoK.getPageContext().getPageActivity(), d.e.tbds120);
        this.hwU = com.baidu.adp.lib.util.l.h(this.hoK.getPageContext().getPageActivity(), d.e.ds242);
        this.fOS = (TextView) this.hoK.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hoK.bJs();
                if (aq.this.hoK != null && aq.this.hoK.bIX() != null && aq.this.hoK.bIX().getPbData() != null && aq.this.hoK.bIX().getPbData().bHW() != null && aq.this.hoK.bIX().getPbData().bHW().YO() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", aq.this.hoK.bIX().hrH).bJ(ImageViewerConfig.FORUM_ID, aq.this.hoK.bIX().getPbData().getForumId()).T("obj_locate", 1).bJ("uid", aq.this.hoK.bIX().getPbData().bHW().YO().getUserId()));
                }
            }
        });
        this.hwO = (ImageView) this.hoK.findViewById(d.g.pb_editor_tool_comment_icon);
        this.hwO.setOnClickListener(this.faL);
        this.hwP = (ImageView) this.hoK.findViewById(d.g.pb_editor_tool_collection);
        this.hwP.setOnClickListener(this.faL);
        this.hwQ = (ImageView) this.hoK.findViewById(d.g.pb_editor_tool_share);
        this.hwQ.setOnClickListener(this.faL);
        this.hwR = (MessageRedDotView) this.hoK.findViewById(d.g.pb_editor_tool_comment_red_dot);
        this.hvG = LayoutInflater.from(this.hoK.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.hvJ = (RelativeLayout) LayoutInflater.from(this.hoK.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.hvK = (ImageView) this.hvJ.findViewById(d.g.pb_thread_type_stamp_top_part);
        this.hvM = new e(this.hoK, this.hvJ);
        this.hvM.init();
        this.hvM.a(this.hvM.bJi(), this.faL);
        this.hvN = (ColumnLayout) this.hvJ.findViewById(d.g.pb_head_owner_root);
        this.hvO = (ThreadSkinView) this.hvJ.findViewById(d.g.pb_thread_skin);
        this.hvN.setOnLongClickListener(this.onLongClickListener);
        this.hvN.setOnTouchListener(this.ccb);
        this.hvN.setVisibility(8);
        this.hvG.setOnTouchListener(this.ccb);
        this.hwX = this.hvG.findViewById(d.g.pb_head_activity_join_number_container);
        this.hwX.setVisibility(8);
        this.hwY = (TextView) this.hvG.findViewById(d.g.pb_head_activity_join_number);
        this.hvP = (TextView) this.hvN.findViewById(d.g.pb_head_owner_info_user_name);
        this.hvP.getPaint().setFakeBoldText(true);
        this.hvQ = (TextView) this.hvN.findViewById(d.g.floor_owner);
        this.hvR = (ImageView) this.hvN.findViewById(d.g.icon_forum_level);
        this.hvT = (FrameLayout) this.hvN.findViewById(d.g.pb_head_headImage_container);
        this.hvU = (HeadImageView) this.hvN.findViewById(d.g.pb_head_owner_photo);
        this.hvS = (HeadPendantView) this.hvN.findViewById(d.g.pb_pendant_head_owner_photo);
        this.hvS.setHasPendantStyle();
        if (this.hvS.getHeadView() != null) {
            this.hvS.getHeadView().setIsRound(true);
            this.hvS.getHeadView().setDrawBorder(false);
        }
        this.hpX = (UserIconBox) this.hvN.findViewById(d.g.show_icon_vip);
        this.hpY = (UserIconBox) this.hvN.findViewById(d.g.show_icon_yinji);
        this.hvW = (LinearLayout) this.hvJ.findViewById(d.g.pb_head_owner_info_root);
        this.hvZ = (PbFirstFloorUserLikeButton) this.hvN.findViewById(d.g.pb_like_button);
        this.hwb = (TextView) this.hvN.findViewById(d.g.pb_views);
        this.hwc = (TextView) this.hvN.findViewById(d.g.pb_item_first_floor_reply_time);
        this.hwd = (TextView) this.hvN.findViewById(d.g.pb_item_first_floor_location_address);
        this.hwe = (TextView) this.hvN.findViewById(d.g.point_between_time_and_locate);
        this.hxQ = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hxR = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hwk = this.hvG.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.hwl = this.hvG.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.hvG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hwZ = (ViewStub) this.eCh.findViewById(d.g.interview_status_stub);
        this.hwf = this.hvJ.findViewById(d.g.blank_view_align_user_item_top);
        this.hwg = this.hvJ.findViewById(d.g.blank_view_align_user_item_bottom);
        this.hwo = new f(this.hoK, this.hvF);
        this.hwo.x(this.faL);
        this.hwo.setTbGestureDetector(this.ccb);
        this.hwo.setOnImageClickListener(this.cAE);
        this.hpj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hoK.c(sparseArray);
                            return;
                        }
                        aq.this.cs(view);
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        aq.this.hoK.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hwo.J(this.hpj);
        bMw();
        this.hvF.addHeaderView(this.hvJ);
        this.hvF.addHeaderView(this.hvH);
        this.hvF.addHeaderView(this.hvG);
        this.feS = new PbListView(this.hoK.getPageContext().getPageActivity());
        this.cpI = this.feS.getView().findViewById(d.g.pb_more_view);
        if (this.cpI != null) {
            this.cpI.setOnClickListener(this.faL);
            com.baidu.tbadk.core.util.al.k(this.cpI, d.f.pb_foot_more_trans_selector);
        }
        this.feS.aev();
        this.feS.hY(d.f.pb_foot_more_trans_selector);
        this.feS.ia(d.f.pb_foot_more_trans_selector);
        this.hwu = this.hoK.findViewById(d.g.viewstub_progress);
        this.hoK.registerListener(this.hxX);
        this.hvV = com.baidu.tbadk.ala.b.UH().n(this.hoK.getActivity(), 2);
        if (this.hvV != null) {
            this.hvV.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.hoK.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.hvV.getParent() == null) {
                this.hvW.addView(this.hvV, aVar);
            }
        }
        this.hqV = new PbFakeFloorModel(this.hoK.getPageContext());
        this.hxu = new s(this.hoK.getPageContext(), this.hqV, this.eCh);
        this.hxu.a(this.hoK.hnL);
        this.hqV.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hqV.o(postData);
                aq.this.hwo.notifyDataSetChanged();
                aq.this.hxu.bKB();
                aq.this.VO.akm();
                aq.this.nU(false);
            }
        });
        if (this.hoK.bIX() != null && !StringUtils.isNull(this.hoK.bIX().bLv())) {
            this.hoK.showToast(this.hoK.bIX().bLv());
        }
        this.hxe = this.hoK.findViewById(d.g.pb_expand_blank_view);
        this.hxf = this.hoK.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hxf.getLayoutParams();
        if (this.hoK.bIX() != null && this.hoK.bIX().bKR()) {
            this.hxe.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hxf.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hxh;
            this.hxf.setLayoutParams(layoutParams2);
        }
        this.hxg = new al(this.hoK.getPageContext(), this.hoK.findViewById(d.g.pb_reply_expand_view));
        this.hxg.huZ.setVisibility(8);
        this.hxg.L(this.faL);
        this.hoK.registerListener(this.mAccountChangedListener);
        this.hoK.registerListener(this.hxT);
        this.hoK.registerListener(this.hxU);
        bMs();
        nO(false);
    }

    public void bnj() {
        if (!this.hoK.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 2).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.hoK.bJu()) {
            com.baidu.tbadk.editortools.pb.d bJj = this.hoK.bJj();
            if (bJj != null && (bJj.amC() || bJj.amD())) {
                this.hoK.bJj().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.VO != null) {
                bMB();
            }
            if (this.VO != null) {
                this.hwS = false;
                if (this.VO.jv(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hoK, (View) this.VO.jv(2).cix, false, hxO);
                }
            }
            bNg();
        }
    }

    private void bMs() {
        this.hxJ = new com.baidu.tieba.pb.pb.godreply.a(this.hoK, this, (ViewStub) this.eCh.findViewById(d.g.more_god_reply_popup));
        this.hxJ.t(this.faL);
        this.hxJ.J(this.hpj);
        this.hxJ.setOnImageClickListener(this.cAE);
        this.hxJ.t(this.faL);
        this.hxJ.setTbGestureDetector(this.ccb);
    }

    public com.baidu.tieba.pb.pb.godreply.a bMt() {
        return this.hxJ;
    }

    public View bMu() {
        return this.hxe;
    }

    public void bMv() {
        if (this.hvF != null) {
            this.hvF.removeHeaderView(this.hvH);
            this.hvF.removeHeaderView(this.hvJ);
            this.hvF.removeHeaderView(this.hvG);
        }
    }

    private void bMw() {
        if (this.hvH == null) {
            this.hvH = (RelativeLayout) LayoutInflater.from(this.hoK).inflate(d.h.new_pb_title, (ViewGroup) null);
            this.hvL = (ImageView) this.hvH.findViewById(d.g.pb_thread_type_stamp_title_bottom_part);
            this.hvL.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(d.e.tbds194));
            this.hvL.setImageMatrix(matrix);
            this.hvI = (TextView) this.hvH.findViewById(d.g.tv_pb_title);
            this.hvI.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            this.hvI.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hvI.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.al.j(this.hvI, d.C0277d.cp_cont_b);
            this.hvI.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hvI.setVisibility(8);
            if (this.hvI.getParent() == null) {
                this.hvH.addView(this.hvI);
            }
            this.hvH.setOnTouchListener(this.ccb);
            this.hvH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMx() {
        if (this.hoK.bJM()) {
            this.hvE = (ViewStub) this.hoK.findViewById(d.g.manga_mention_controller_view_stub);
            this.hvE.setVisibility(0);
            if (this.hwh == null) {
                this.hwh = (LinearLayout) this.hoK.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.hoK.getPageContext(), this.hwh);
            }
            if (this.hwi == null) {
                this.hwi = (TextView) this.hwh.findViewById(d.g.manga_prev_btn);
            }
            if (this.hwj == null) {
                this.hwj = (TextView) this.hwh.findViewById(d.g.manga_next_btn);
            }
            this.hwi.setOnClickListener(this.faL);
            this.hwj.setOnClickListener(this.faL);
        }
    }

    private void bMy() {
        if (this.hoK.bJM()) {
            if (this.hoK.bJP() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwi, d.C0277d.cp_cont_e, 1);
            }
            if (this.hoK.bJQ() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwj, d.C0277d.cp_cont_e, 1);
            }
        }
    }

    public void bMz() {
        if (this.hwh == null) {
            bMx();
        }
        this.hvE.setVisibility(8);
        if (this.hxV != null && this.hxW != null) {
            this.hxV.removeCallbacks(this.hxW);
        }
    }

    public void bMA() {
        if (this.hxV != null) {
            if (this.hxW != null) {
                this.hxV.removeCallbacks(this.hxW);
            }
            this.hxW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hwh == null) {
                        aq.this.bMx();
                    }
                    aq.this.hvE.setVisibility(0);
                }
            };
            this.hxV.postDelayed(this.hxW, 2000L);
        }
    }

    public void nM(boolean z) {
        this.hvB.nM(z);
        if (z && this.hwW) {
            this.feS.setText(this.hoK.getResources().getString(d.j.click_load_more));
            this.hvF.setNextPage(this.feS);
            this.hvA = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
        this.VO.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.VO.getParent() == null) {
            this.eCh.addView(this.VO, layoutParams);
        }
        this.VO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.VO.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).agq() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).agq() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.adN();
                        aq.this.mPermissionJudgePolicy.e(aq.this.hoK, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.Y(aq.this.hoK)) {
                            aq.this.hoK.bJj().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hoK.bJj().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bMj();
        this.hoK.bJj().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.VO != null && aq.this.VO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hxI == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.VO.getId());
                            aq.this.hxI = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hoK.getPageContext(), aq.this.eCh, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.T(aq.this.hxH)) {
                                aq.this.hxI.setData(aq.this.hxH);
                            }
                            aq.this.hxI.b(aq.this.VO);
                        }
                        aq.this.hxI.Ad(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hoK.hmP != null && aq.this.hoK.hmP.bNw() != null) {
                    if (!aq.this.hoK.hmP.bNw().cnZ()) {
                        aq.this.hoK.hmP.nZ(false);
                    }
                    aq.this.hoK.hmP.bNw().qV(false);
                }
            }
        });
    }

    public void bMB() {
        if (this.hoK != null && this.VO != null) {
            this.VO.qT();
            if (this.hoK.bJj() != null) {
                this.hoK.bJj().amt();
            }
            bNg();
        }
    }

    public void nN(boolean z) {
        if (this.hvF != null && this.ahO != null && this.faY != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.faY.setVisibility(0);
                } else {
                    this.faY.setVisibility(8);
                    this.hvF.removeHeaderView(this.ahO);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ahO.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hxh;
                    this.ahO.setLayoutParams(layoutParams);
                }
                bMP();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ahO.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + nW(true);
                this.ahO.setLayoutParams(layoutParams2);
            }
            bMP();
            bNo();
        }
    }

    public f bMC() {
        return this.hwo;
    }

    public void a(PbActivity.d dVar) {
        this.hnP = dVar;
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
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hoK);
        iVar.setTitleText(this.hoK.getString(d.j.bar_manager));
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hww.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hxY != null) {
                                aq.this.hxY.m(new Object[]{sparseArray2.get(d.g.tag_manage_user_identity), sparseArray2.get(d.g.tag_forbid_user_name), sparseArray2.get(d.g.tag_forbid_user_post_id), sparseArray2.get(d.g.tag_forbid_user_name_show), sparseArray2.get(d.g.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hoK.a(z, (String) sparseArray2.get(d.g.tag_user_mute_mute_userid), sparseArray2);
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
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hoK.getString(d.j.delete_post), iVar);
            } else {
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hoK.getString(d.j.delete), iVar);
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
            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(1, this.hoK.getString(d.j.forbidden_person), iVar);
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
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hoK.getString(d.j.un_mute), iVar);
            } else {
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hoK.getString(d.j.mute), iVar);
            }
            fVar.mTextView.setTag(sparseArray4);
            arrayList.add(fVar);
        }
        iVar.P(arrayList);
        if (this.hww == null) {
            this.hww = new com.baidu.tbadk.core.dialog.g(this.hoK.getPageContext(), iVar.abh());
        } else {
            this.hww.setContentView(iVar.abh());
        }
        this.hww.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hxY = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hoK != null && aVar != null) {
            if (this.fzr == null) {
                this.fzr = new com.baidu.tieba.NEGFeedBack.e(this.hoK.getPageContext(), this.hvG);
            }
            AntiData bbG = this.hoK.bbG();
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
            this.fzr.setDefaultReasonArray(new String[]{this.hoK.getString(d.j.delete_thread_reason_1), this.hoK.getString(d.j.delete_thread_reason_2), this.hoK.getString(d.j.delete_thread_reason_3), this.hoK.getString(d.j.delete_thread_reason_4), this.hoK.getString(d.j.delete_thread_reason_5)});
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
                    aq.this.hoK.a(aVar, jSONArray);
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
        sparseArray.put(hxo, Integer.valueOf(hxp));
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
        this.hwy = new com.baidu.tbadk.core.dialog.a(this.hoK.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hwy.gC(i3);
        } else {
            this.hwy.dv(false);
            this.hwy.lz(str2);
        }
        this.hwy.Z(sparseArray);
        this.hwy.a(d.j.dialog_ok, this.hoK);
        this.hwy.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwy.dq(true);
        this.hwy.b(this.hoK.getPageContext());
        if (z) {
            this.hwy.aaW();
        } else {
            a(this.hwy, i);
        }
    }

    public void at(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hwB == null) {
            this.hwB = LayoutInflater.from(this.hoK.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.hoK.getLayoutMode().onModeChanged(this.hwB);
        if (this.hwA == null) {
            this.hwA = new Dialog(this.hoK.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hwA.setCanceledOnTouchOutside(true);
            this.hwA.setCancelable(true);
            this.hwJ = (ScrollView) this.hwB.findViewById(d.g.good_scroll);
            this.hwA.setContentView(this.hwB);
            WindowManager.LayoutParams attributes = this.hwA.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.hoK.getPageContext().getPageActivity(), d.e.ds540);
            this.hwA.getWindow().setAttributes(attributes);
            this.ekh = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hwF = (String) compoundButton.getTag();
                        if (aq.this.ekg != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.ekg) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hwF != null && !str.equals(aq.this.hwF)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hwC = (LinearLayout) this.hwB.findViewById(d.g.good_class_group);
            this.hwE = (TextView) this.hwB.findViewById(d.g.dialog_button_cancel);
            this.hwE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hwA instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hwA, aq.this.hoK.getPageContext());
                    }
                }
            });
            this.hwD = (TextView) this.hwB.findViewById(d.g.dialog_button_ok);
            this.hwD.setOnClickListener(this.faL);
        }
        this.hwC.removeAllViews();
        this.ekg = new ArrayList();
        CustomBlueCheckRadioButton dA = dA("0", this.hoK.getPageContext().getString(d.j.thread_good_class));
        this.ekg.add(dA);
        dA.setChecked(true);
        this.hwC.addView(dA);
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
                    this.ekg.add(dA2);
                    View view = new View(this.hoK.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.hoK.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.al.l(view, d.C0277d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hwC.addView(view);
                    this.hwC.addView(dA2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hwJ.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hoK.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hoK.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hoK.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hwJ.setLayoutParams(layoutParams2);
            this.hwJ.removeAllViews();
            if (this.hwC != null && this.hwC.getParent() == null) {
                this.hwJ.addView(this.hwC);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hwA, this.hoK.getPageContext());
    }

    private CustomBlueCheckRadioButton dA(String str, String str2) {
        Activity pageActivity = this.hoK.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.ekh);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bMD() {
        this.hoK.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hoK.hideProgressBar();
        if (z && z2) {
            this.hoK.showToast(this.hoK.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.hoK.showToast(str);
        }
    }

    public void bul() {
        this.hwu.setVisibility(0);
    }

    public void buk() {
        this.hwu.setVisibility(8);
    }

    public View bME() {
        if (this.hwB != null) {
            return this.hwB.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bMF() {
        return this.hwF;
    }

    public View getView() {
        return this.eCh;
    }

    public void bMG() {
        com.baidu.adp.lib.util.l.b(this.hoK.getPageContext().getPageActivity(), this.hoK.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hoK.hideProgressBar();
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
        this.hoK.hideProgressBar();
        aeA();
        this.hvF.completePullRefreshPostDelayed(0L);
        bMT();
    }

    public void bMJ() {
        this.hvF.completePullRefreshPostDelayed(0L);
        bMT();
    }

    private void nO(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hwo.setOnLongClickListener(onLongClickListener);
        if (this.hxJ != null) {
            this.hxJ.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0225b interfaceC0225b, boolean z, boolean z2) {
        if (this.hmQ != null) {
            this.hmQ.dismiss();
            this.hmQ = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hoK);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hoK.getPageContext().getString(d.j.copy), iVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoK.getPageContext().getString(d.j.report_text), iVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoK.getPageContext().getString(d.j.mark), iVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoK.getPageContext().getString(d.j.remove_mark), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwG.dismiss();
                interfaceC0225b.a(null, i, view);
            }
        });
        this.hwG = new com.baidu.tbadk.core.dialog.g(this.hoK.getPageContext(), iVar.abh());
        this.hwG.showDialog();
    }

    public void a(final b.InterfaceC0225b interfaceC0225b, boolean z) {
        if (this.hwG != null) {
            this.hwG.dismiss();
            this.hwG = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hoK);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hoK.getPageContext().getString(d.j.save_to_emotion), iVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoK.getPageContext().getString(d.j.save_to_local), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwG.dismiss();
                interfaceC0225b.a(null, i, view);
            }
        });
        this.hwG = new com.baidu.tbadk.core.dialog.g(this.hoK.getPageContext(), iVar.abh());
        this.hwG.showDialog();
    }

    public int bMK() {
        return wu(this.hvF.getFirstVisiblePosition());
    }

    private int wu(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hvF.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hvF.getAdapter() == null || !(this.hvF.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hvF.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bML() {
        int lastVisiblePosition = this.hvF.getLastVisiblePosition();
        if (this.hvv != null) {
            if (lastVisiblePosition == this.hvF.getCount() - 1) {
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
        if (this.hvF != null) {
            if (this.hvB == null || this.hvB.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hvB.mNavigationBar.getFixedNavHeight();
                if (!(this.hoK.bJA() != -1)) {
                    if (this.hxf != null && (layoutParams = (LinearLayout.LayoutParams) this.hxf.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hxf.setLayoutParams(layoutParams);
                    }
                    i--;
                    bNs();
                }
                i2 = fixedNavHeight;
            }
            this.hvF.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hvF.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hvF.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hwr.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hwo.a(dVar, false);
        this.hwo.notifyDataSetChanged();
        bMT();
        if (this.hxJ != null) {
            this.hxJ.bIT();
        }
        ArrayList<PostData> bHY = dVar.bHY();
        if (dVar.getPage().XH() == 0 || bHY == null || bHY.size() < dVar.getPage().XG()) {
            if (com.baidu.tbadk.core.util.v.S(bHY) == 0 || (com.baidu.tbadk.core.util.v.S(bHY) == 1 && bHY.get(0) != null && bHY.get(0).cep() == 1)) {
                if (this.hxk == null || this.hxk.hys == null || this.hxk.hys.getView() == null) {
                    i = 0;
                } else {
                    i = this.hxk.hys.getView().getTop() < 0 ? this.hxk.hys.getView().getHeight() : this.hxk.hys.getView().getBottom();
                }
                if (this.hoK.bJY()) {
                    this.feS.aa(this.hoK.getResources().getString(d.j.pb_no_host_reply), i);
                } else {
                    this.feS.aa(this.hoK.getResources().getString(d.j.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().XH() == 0) {
                    this.feS.setText(this.hoK.getResources().getString(d.j.list_has_no_more));
                } else {
                    this.feS.setText(this.hoK.getResources().getString(d.j.load_more));
                }
                this.feS.aeE();
            }
        }
        p(dVar);
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.hvX == null) {
            this.hoK.getLayoutMode().onModeChanged(((ViewStub) this.hvG.findViewById(d.g.praise_layout)).inflate());
            this.hvX = (FrsPraiseView) this.hvG.findViewById(d.g.pb_head_praise_view);
            this.hvX.setIsFromPb(true);
            this.hwm = this.hvG.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.hvX.ii(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hvX != null) {
            boolean bMT = bMT();
            this.hvX.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().XI() == 0 && this.hpb) {
                if (bMT) {
                    this.hwl.setVisibility(0);
                    return;
                } else {
                    this.hwl.setVisibility(8);
                    return;
                }
            }
            this.hwl.setVisibility(8);
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
            this.hvN.setVisibility(8);
            if (dVar.bHW() != null && dVar.bHW().ZI() && dVar.bHW().Zf() != null) {
                this.hxy = true;
                this.hvB.oj(this.hxy);
                this.hvB.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1") && com.baidu.adp.lib.util.l.aQ(this.hoK) < this.eCh.getHeight()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eCh.getLayoutParams();
                    layoutParams.height = com.baidu.adp.lib.util.l.aQ(this.hoK);
                    this.eCh.setLayoutParams(layoutParams);
                }
                if (this.hvv == null) {
                    this.hvv = new com.baidu.tieba.pb.video.i(this.hoK, this.hvB, dVar.bHW().Zf(), this.hvw);
                    this.hvv.a(dVar.bHW().Zf(), dVar.bHW(), dVar.getForumId());
                    this.hvv.startPlay();
                } else if (this.hvz) {
                    this.hvv.a(dVar.bHW().Zf(), dVar.bHW(), dVar.getForumId());
                    this.hvv.startPlay();
                } else {
                    this.hvv.Ap(dVar.getForumId());
                }
                if (dVar.bHX() != null && dVar.bHX().size() >= 1) {
                    bg bgVar = dVar.bHX().get(0);
                    this.hvv.aD(bgVar);
                    this.hvv.Aq(bgVar.getTitle());
                }
                this.hvv.b(c, dVar.bHW(), dVar.bIt());
                this.hvz = false;
                this.hvF.removeHeaderView(this.hvv.bPl());
                this.hvF.addHeaderView(this.hvv.bPl(), 0);
                if (this.hvv.aBz() != null && this.hvv.aBz().getParent() == null) {
                    this.hxd.addView(this.hvv.aBz());
                }
                if (this.hvx == null) {
                    this.hvx = new com.baidu.tieba.pb.video.h(this.hoK);
                }
                this.hvx.a(dVar.bHW().ZY(), dVar.bHW(), dVar.bIq());
                this.hvF.removeHeaderView(this.hvx.bOY());
                this.hvF.addHeaderView(this.hvx.bOY(), 1);
                if (dVar.bHW().ZY() != null) {
                    this.hvF.removeHeaderView(this.hvx.bOZ());
                    this.hvF.removeHeaderView(this.hvJ);
                    this.hvF.addHeaderView(this.hvx.bOZ(), 2);
                } else {
                    if (this.hvx.bOZ() != null) {
                        this.hvF.removeHeaderView(this.hvx.bOZ());
                    }
                    this.hvF.removeHeaderView(this.hvJ);
                    this.hvF.addHeaderView(this.hvJ, 2);
                }
                if (this.hvv != null) {
                    this.hvB.of(false);
                    this.hvv.wC(TbadkCoreApplication.getInst().getSkinType());
                }
                bMP();
            } else {
                this.hxy = false;
                this.hvB.oj(this.hxy);
                if (this.hvv != null) {
                    this.hvF.removeHeaderView(this.hvv.bPl());
                }
                if (this.hvx != null) {
                    this.hvx.b(this.hvF);
                }
            }
            if (this.hoK.bJm() != null) {
                this.hoK.bJm().od(this.hxy);
            }
            if (this.hvv != null) {
                this.hvv.N(this.hya);
                bNs();
            }
            if (c != null) {
                this.hwV = c;
                this.hvN.setVisibility(0);
                if (this.hoK.bIN()) {
                    if (dVar.bHV() != null) {
                        this.mForumName = dVar.bHV().getForumName();
                        this.mForumId = dVar.bHV().getForumId();
                    }
                    if (this.mForumName == null && this.hoK.bIX() != null && this.hoK.bIX().bIO() != null) {
                        this.mForumName = this.hoK.bIX().bIO();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hvN.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hvN.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, c);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.hxP) {
                    this.hvH.setVisibility(0);
                }
                if (!dVar.bHW().ZI() && this.hvI.getText() != null && this.hvI.getText().length() > 0) {
                    this.hvI.setVisibility(0);
                } else {
                    this.hvI.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> YZ = dVar.bHW().YZ();
                if (YZ != null && YZ.size() > 0 && !this.hxP) {
                    this.hwY.setText(String.valueOf(YZ.get(0).WV()));
                    this.hwX.setVisibility(0);
                } else {
                    this.hwX.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.k(this.hwX, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.d(this.hwY, d.C0277d.cp_link_tip_d, 1);
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
                            if (this.hpY != null) {
                                this.hpY.setTag(d.g.tag_user_id, c.YO().getUserId());
                                this.hpY.setOnClickListener(this.hoK.hmL.hzS);
                                this.hpY.a(iconInfo, 4, this.hoK.getResources().getDimensionPixelSize(d.e.tbds36), this.hoK.getResources().getDimensionPixelSize(d.e.tbds36), this.hoK.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.hpX != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hpX.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hpX.setOnClickListener(this.hoK.hmL.hzT);
                                this.hpX.a(tShowInfoNew, 3, this.hoK.getResources().getDimensionPixelSize(d.e.tbds36), this.hoK.getResources().getDimensionPixelSize(d.e.tbds36), this.hoK.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.hvP.setText(bN(c.YO().getSealPrefix(), g));
                            this.hvP.setTag(d.g.tag_user_id, c.YO().getUserId());
                            this.hvP.setTag(d.g.tag_user_name, c.YO().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew) || c.YO().isBigV()) {
                                com.baidu.tbadk.core.util.al.d(this.hvP, d.C0277d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.d(this.hvP, d.C0277d.cp_cont_b, 1);
                            }
                            if (c.YO() == null) {
                                MetaData YO = c.YO();
                                if (YO.getIs_bawu() == 1 && "manager".equals(YO.getBawu_type())) {
                                    this.hvQ.setText(d.j.bawu_member_bazhu_tip);
                                    this.hvQ.setVisibility(0);
                                } else if (YO.getIs_bawu() == 1 && "assist".equals(YO.getBawu_type())) {
                                    this.hvQ.setText(d.j.bawu_member_xbazhu_tip);
                                    this.hvQ.setVisibility(0);
                                } else {
                                    this.hvQ.setVisibility(8);
                                }
                            } else {
                                this.hvQ.setVisibility(8);
                            }
                            if (dVar.bHW().YO() != null && dVar.bHW().YO().getAlaUserData() != null && this.hvV != null) {
                                if (dVar.bHW().YO().getAlaUserData().anchor_live != 0) {
                                    this.hvV.setVisibility(8);
                                } else {
                                    this.hvV.setVisibility(0);
                                    if (this.hvy == null) {
                                        this.hvy = new com.baidu.tieba.c.d(this.hoK.getPageContext(), this.hvV);
                                        this.hvy.oI(1);
                                    }
                                    this.hvy.cv(this.hoK.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bsN = dVar.bHW().YO().getAlaUserData();
                                    aVar.type = 2;
                                    this.hvV.setTag(aVar);
                                }
                            }
                            this.hvU.setUserId(c.YO().getUserId());
                            this.hvU.setUserName(c.YO().getUserName());
                            this.hvU.setTid(c.getId());
                            this.hvU.setFid(this.hsd == null ? this.hsd.getForumId() : "");
                            this.hvU.setImageDrawable(null);
                            this.hvU.setRadius(com.baidu.adp.lib.util.l.h(this.hoK.getActivity(), d.e.ds40));
                            this.hvU.setTag(c.YO().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hwc.setText(com.baidu.tbadk.core.util.ap.aq(c.getTime()));
                            } else {
                                this.hwc.setText(com.baidu.tbadk.core.util.ap.ao(c.getTime()));
                            }
                            ces = c.ces();
                            if (ces == null && !TextUtils.isEmpty(ces.getName()) && !TextUtils.isEmpty(ces.getName().trim())) {
                                this.hwd.setVisibility(0);
                                this.hwe.setVisibility(0);
                                this.hwd.setText(ces.getName());
                            } else {
                                this.hwd.setVisibility(8);
                                this.hwe.setVisibility(8);
                            }
                            portrait = c.YO().getPortrait();
                            if (c.YO().getPendantData() == null && !StringUtils.isNull(c.YO().getPendantData().Xk())) {
                                this.hvS.b(c.YO());
                                this.hvU.setVisibility(8);
                                this.hvS.setVisibility(0);
                                if (this.hvY != null) {
                                    this.hvY.setVisibility(8);
                                }
                                this.hvP.setOnClickListener(this.hya);
                                this.hvS.getHeadView().startLoad(portrait, 28, false);
                                this.hvS.getHeadView().setUserId(c.YO().getUserId());
                                this.hvS.getHeadView().setUserName(c.YO().getUserName());
                                this.hvS.getHeadView().setTid(c.getId());
                                this.hvS.getHeadView().setFid(this.hsd != null ? this.hsd.getForumId() : "");
                                this.hvS.getHeadView().setOnClickListener(this.hya);
                                this.hvS.nn(c.YO().getPendantData().Xk());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hvU, c.YO());
                                this.hvU.setVisibility(0);
                                this.hvN.setOnClickListener(this.hya);
                                this.hvP.setOnClickListener(this.hya);
                                this.hvU.setOnClickListener(this.hya);
                                this.hvS.setVisibility(8);
                                this.hvU.startLoad(portrait, 28, false);
                            }
                            String name_show = c.YO().getName_show();
                            String userName = c.YO().getUserName();
                            if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                                this.hvP.setText(com.baidu.tieba.pb.c.aP(this.hoK.getPageContext().getPageActivity(), this.hvP.getText().toString()));
                                this.hvP.setGravity(16);
                                this.hvP.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHH());
                                com.baidu.tbadk.core.util.al.d(this.hvP, d.C0277d.cp_other_e, 1);
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo2 = c.YO().getIconInfo();
                        tShowInfoNew = c.YO().getTShowInfoNew();
                        if (this.hpY != null) {
                        }
                        if (this.hpX != null) {
                        }
                        this.hvP.setText(bN(c.YO().getSealPrefix(), g));
                        this.hvP.setTag(d.g.tag_user_id, c.YO().getUserId());
                        this.hvP.setTag(d.g.tag_user_name, c.YO().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hvP, d.C0277d.cp_cont_h, 1);
                        if (c.YO() == null) {
                        }
                        if (dVar.bHW().YO() != null) {
                            if (dVar.bHW().YO().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hvU.setUserId(c.YO().getUserId());
                        this.hvU.setUserName(c.YO().getUserName());
                        this.hvU.setTid(c.getId());
                        this.hvU.setFid(this.hsd == null ? this.hsd.getForumId() : "");
                        this.hvU.setImageDrawable(null);
                        this.hvU.setRadius(com.baidu.adp.lib.util.l.h(this.hoK.getActivity(), d.e.ds40));
                        this.hvU.setTag(c.YO().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        ces = c.ces();
                        if (ces == null) {
                        }
                        this.hwd.setVisibility(8);
                        this.hwe.setVisibility(8);
                        portrait = c.YO().getPortrait();
                        if (c.YO().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hvU, c.YO());
                        this.hvU.setVisibility(0);
                        this.hvN.setOnClickListener(this.hya);
                        this.hvP.setOnClickListener(this.hya);
                        this.hvU.setOnClickListener(this.hya);
                        this.hvS.setVisibility(8);
                        this.hvU.startLoad(portrait, 28, false);
                        String name_show2 = c.YO().getName_show();
                        String userName2 = c.YO().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                            this.hvP.setText(com.baidu.tieba.pb.c.aP(this.hoK.getPageContext().getPageActivity(), this.hvP.getText().toString()));
                            this.hvP.setGravity(16);
                            this.hvP.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHH());
                            com.baidu.tbadk.core.util.al.d(this.hvP, d.C0277d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            g = com.baidu.tbadk.core.util.ap.g(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.YO().getIconInfo();
                            tShowInfoNew = c.YO().getTShowInfoNew();
                            if (this.hpY != null) {
                            }
                            if (this.hpX != null) {
                            }
                            this.hvP.setText(bN(c.YO().getSealPrefix(), g));
                            this.hvP.setTag(d.g.tag_user_id, c.YO().getUserId());
                            this.hvP.setTag(d.g.tag_user_name, c.YO().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.d(this.hvP, d.C0277d.cp_cont_h, 1);
                            if (c.YO() == null) {
                            }
                            if (dVar.bHW().YO() != null) {
                            }
                            this.hvU.setUserId(c.YO().getUserId());
                            this.hvU.setUserName(c.YO().getUserName());
                            this.hvU.setTid(c.getId());
                            this.hvU.setFid(this.hsd == null ? this.hsd.getForumId() : "");
                            this.hvU.setImageDrawable(null);
                            this.hvU.setRadius(com.baidu.adp.lib.util.l.h(this.hoK.getActivity(), d.e.ds40));
                            this.hvU.setTag(c.YO().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            ces = c.ces();
                            if (ces == null) {
                            }
                            this.hwd.setVisibility(8);
                            this.hwe.setVisibility(8);
                            portrait = c.YO().getPortrait();
                            if (c.YO().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hvU, c.YO());
                            this.hvU.setVisibility(0);
                            this.hvN.setOnClickListener(this.hya);
                            this.hvP.setOnClickListener(this.hya);
                            this.hvU.setOnClickListener(this.hya);
                            this.hvS.setVisibility(8);
                            this.hvU.startLoad(portrait, 28, false);
                            String name_show22 = c.YO().getName_show();
                            String userName22 = c.YO().getUserName();
                            if (com.baidu.tbadk.s.ao.jK()) {
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo222 = c.YO().getIconInfo();
                        tShowInfoNew = c.YO().getTShowInfoNew();
                        if (this.hpY != null) {
                        }
                        if (this.hpX != null) {
                        }
                        this.hvP.setText(bN(c.YO().getSealPrefix(), g));
                        this.hvP.setTag(d.g.tag_user_id, c.YO().getUserId());
                        this.hvP.setTag(d.g.tag_user_name, c.YO().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hvP, d.C0277d.cp_cont_h, 1);
                        if (c.YO() == null) {
                        }
                        if (dVar.bHW().YO() != null) {
                        }
                        this.hvU.setUserId(c.YO().getUserId());
                        this.hvU.setUserName(c.YO().getUserName());
                        this.hvU.setTid(c.getId());
                        this.hvU.setFid(this.hsd == null ? this.hsd.getForumId() : "");
                        this.hvU.setImageDrawable(null);
                        this.hvU.setRadius(com.baidu.adp.lib.util.l.h(this.hoK.getActivity(), d.e.ds40));
                        this.hvU.setTag(c.YO().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        ces = c.ces();
                        if (ces == null) {
                        }
                        this.hwd.setVisibility(8);
                        this.hwe.setVisibility(8);
                        portrait = c.YO().getPortrait();
                        if (c.YO().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hvU, c.YO());
                        this.hvU.setVisibility(0);
                        this.hvN.setOnClickListener(this.hya);
                        this.hvP.setOnClickListener(this.hya);
                        this.hvU.setOnClickListener(this.hya);
                        this.hvS.setVisibility(8);
                        this.hvU.startLoad(portrait, 28, false);
                        String name_show222 = c.YO().getName_show();
                        String userName222 = c.YO().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hvM.av(dVar.bHW());
                }
                if (this.hxg != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hku);
                    if (dVar != null && dVar.bHW() != null) {
                        hVar.hkw = dVar.bHW().YF();
                    }
                    hVar.isNew = !this.hpb;
                    hVar.sortType = dVar.hkk;
                    if (dVar.hkj != null && dVar.hkj.size() > dVar.hkk) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hkj.size()) {
                                break;
                            } else if (dVar.hkj.get(i4).sort_type.intValue() != dVar.hkk) {
                                i3 = i4 + 1;
                            } else {
                                hVar.hky = dVar.hkj.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.hkz = this.hoK.bJY();
                    this.hxg.a(hVar);
                }
                if (dVar != null && dVar.bHW() != null) {
                    Z(dVar.bHW().YK() == 1, dVar.bHW().YJ() == 1);
                }
                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hwo != null && aq.this.hvB != null && aq.this.hvB.hAE != null && aq.this.hsd != null && aq.this.hsd.bHW() != null && !aq.this.hsd.bHW().ZI() && !aq.this.bMS() && aq.this.hsd.getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(aq.this.hsd.getForum().getName())) {
                            if (aq.this.hwo.bKw() == null || !aq.this.hwo.bKw().isShown()) {
                                aq.this.hvB.hAE.setVisibility(0);
                                if (aq.this.hoK != null && aq.this.hoK.bIX() != null) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13400");
                                    amVar.bJ("tid", aq.this.hoK.bIX().bKO());
                                    amVar.bJ(ImageViewerConfig.FORUM_ID, aq.this.hoK.bIX().getForumId());
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
        this.hxk.hys = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxk));
        a(this.hxk.hys, false);
    }

    public void bMM() {
        if (this.hvB != null && !this.hxA) {
            this.hvB.ok(!StringUtils.isNull(this.hoK.bJx()));
            this.hxA = true;
        }
    }

    public void aWN() {
        if (this.hvB != null) {
            this.hvB.bNX();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.Zj() != null) {
            this.hvO.setData(this.hoK.getPageContext(), dVar.bHY().get(0).Zj(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bHW().getId(), this.hoK.bJV() ? "FRS" : null));
            this.hvN.setPadding(this.hvN.getPaddingLeft(), (int) this.hoK.getResources().getDimension(d.e.ds20), this.hvN.getPaddingRight(), this.hvN.getPaddingBottom());
            return;
        }
        this.hvO.setData(null, null, null);
    }

    public void bMN() {
        if (this.hvv != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").T("obj_type", 1));
            this.hvv.bPj();
            this.hvF.smoothScrollToPosition(0);
        }
    }

    public boolean bMO() {
        return this.hyb;
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
            this.hvB.bNV();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hvB.xP(cVar.forumName);
            }
            String string = this.hoK.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.hoK.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.hoK.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.hoK.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hjD;
            this.hoK.showNetRefreshView(this.eCh, format, null, this.hoK.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.lo()) {
                        ba.adA().c(aq.this.hoK.getPageContext(), new String[]{str2});
                        aq.this.hoK.finish();
                        return;
                    }
                    aq.this.hoK.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bLY;
        Parcelable bLY2;
        if (dVar != null) {
            this.hsd = dVar;
            this.mType = i;
            if (dVar.bHW() != null) {
                this.hxm = dVar.bHW().Yw();
                if (dVar.bHW().getAnchorLevel() != 0) {
                    this.hyb = true;
                }
                this.hwI = ax(dVar.bHW());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            s(dVar);
            this.hwW = false;
            this.hpb = z;
            bMI();
            b(dVar, z, i);
            q(dVar);
            if (this.hxM == null) {
                this.hxM = new ac(this.hoK.getPageContext(), this.bss);
            }
            this.hxM.zU(dVar.bIb());
            if (this.hoK.bJM()) {
                if (this.hws == null) {
                    this.hws = new com.baidu.tieba.pb.view.c(this.hoK.getPageContext());
                    this.hws.oM();
                    this.hws.setListPullRefreshListener(this.bRJ);
                }
                this.hvF.setPullRefresh(this.hws);
                bMP();
                if (this.hws != null) {
                    this.hws.ib(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().XI() == 0 && z) {
                this.hvF.setPullRefresh(null);
            } else {
                if (this.hws == null) {
                    this.hws = new com.baidu.tieba.pb.view.c(this.hoK.getPageContext());
                    this.hws.oM();
                    this.hws.setListPullRefreshListener(this.bRJ);
                }
                this.hvF.setPullRefresh(this.hws);
                bMP();
                if (this.hws != null) {
                    this.hws.ib(TbadkCoreApplication.getInst().getSkinType());
                }
                aMt();
            }
            bMT();
            this.hwo.nd(this.hpb);
            this.hwo.ne(false);
            this.hwo.np(i == 5);
            this.hwo.nq(i == 6);
            this.hwo.nr(z2 && this.hxZ);
            this.hwo.a(dVar, false);
            this.hwo.notifyDataSetChanged();
            if (this.hoK.bIN()) {
                this.hxC = 0;
                PostData c = c(dVar, z);
                if (c != null && c.YO() != null) {
                    this.hxC = c.YO().getLevel_id();
                }
                if (this.hxC > 0) {
                    this.hvR.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.hvR, BitmapHelper.getGradeResourceIdInEnterForum(this.hxC));
                } else {
                    this.hvR.setVisibility(8);
                }
            } else {
                this.hvR.setVisibility(8);
            }
            if (dVar.bHW() != null && dVar.bHW().YA() != null) {
                if (dVar.bHW().YA().getNum() < 1) {
                    this.hoK.getResources().getString(d.j.zan);
                } else {
                    String str = dVar.bHW().YA().getNum() + "";
                }
                if (this.hvu != -1) {
                    dVar.bHW().YA().setIsLike(this.hvu);
                }
            }
            if (this.hoK.isLogin()) {
                this.hvF.setNextPage(this.feS);
                this.hvA = 2;
                aMt();
            } else {
                this.hwW = true;
                if (dVar.getPage().XH() == 1) {
                    if (this.hwt == null) {
                        this.hwt = new com.baidu.tieba.pb.view.a(this.hoK.getPageContext());
                    }
                    this.hvF.setNextPage(this.hwt);
                } else {
                    this.hvF.setNextPage(this.feS);
                }
                this.hvA = 3;
            }
            ArrayList<PostData> bHY = dVar.bHY();
            if (dVar.getPage().XH() == 0 || bHY == null || bHY.size() < dVar.getPage().XG()) {
                if (com.baidu.tbadk.core.util.v.S(bHY) == 0 || (com.baidu.tbadk.core.util.v.S(bHY) == 1 && bHY.get(0) != null && bHY.get(0).cep() == 1)) {
                    if (this.hxk == null || this.hxk.hys == null || this.hxk.hys.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hxk.hys.getView().getTop() < 0 ? this.hxk.hys.getView().getHeight() : this.hxk.hys.getView().getBottom();
                    }
                    if (this.hoK.bJY()) {
                        this.feS.aa(this.hoK.getResources().getString(d.j.pb_no_host_reply), i4);
                    } else {
                        this.feS.aa(this.hoK.getResources().getString(d.j.pb_no_replay), i4);
                    }
                    if (this.hoK.bJm() != null && !this.hoK.bJm().bNK()) {
                        this.hoK.bJm().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().XH() == 0) {
                        this.feS.setText(this.hoK.getResources().getString(d.j.list_has_no_more));
                    } else {
                        this.feS.setText(this.hoK.getResources().getString(d.j.load_more));
                    }
                    this.feS.aeE();
                }
                bNb();
            } else {
                if (z2) {
                    if (this.hxZ) {
                        aeA();
                        if (dVar.getPage().XH() != 0) {
                            this.feS.setText(this.hoK.getResources().getString(d.j.pb_load_more));
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
                    this.hvF.setSelection(i2 > 1 ? (((this.hvF.getData() == null && dVar.bHY() == null) ? 0 : (this.hvF.getData().size() - dVar.bHY().size()) + this.hvF.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bLY2 = aj.bLX().bLY()) != null) {
                        this.hvF.onRestoreInstanceState(bLY2);
                        if (com.baidu.tbadk.core.util.v.S(bHY) > 1 && dVar.getPage().XH() > 0) {
                            this.feS.aeA();
                            this.feS.setText(this.hoK.getString(d.j.pb_load_more_without_point));
                            this.feS.aew();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hxZ = false;
                    break;
                case 5:
                    this.hvF.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bLY = aj.bLX().bLY()) != null) {
                        this.hvF.onRestoreInstanceState(bLY);
                        break;
                    } else {
                        this.hvF.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.hvv != null && this.hvv.aBz() != null) {
                            if (this.hoK.isUseStyleImmersiveSticky()) {
                                this.hvF.setSelectionFromTop((this.hwo.bKr() + this.hvF.getHeaderViewsCount()) - 1, this.hvv.aBz().getHeight() - com.baidu.adp.lib.util.l.r(this.hoK.getPageContext().getPageActivity()));
                            } else {
                                this.hvF.setSelectionFromTop((this.hwo.bKr() + this.hvF.getHeaderViewsCount()) - 1, this.hvv.aBz().getHeight());
                            }
                        } else {
                            this.hvF.setSelection(this.hwo.bKr() + this.hvF.getHeaderViewsCount());
                        }
                    } else {
                        this.hvF.setSelection(i2 > 0 ? ((this.hvF.getData() == null && dVar.bHY() == null) ? 0 : (this.hvF.getData().size() - dVar.bHY().size()) + this.hvF.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.feS.aeA();
                    this.feS.setText(this.hoK.getString(d.j.pb_load_more_without_point));
                    this.feS.aew();
                    break;
            }
            if (this.hxm == hxn && isHost()) {
                bNj();
            }
            if (this.hxw) {
                bMh();
                this.hxw = false;
                if (i3 == 0) {
                    nJ(true);
                }
            }
            if (this.hvx != null) {
                this.hvx.aC(dVar.bHW());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hkh == 1 || dVar.hki == 1) {
                if (this.hxD == null) {
                    this.hxD = new PbTopTipView(this.hoK);
                }
                if (dVar.hki == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hoK.getStType())) {
                    this.hxD.setText(this.hoK.getString(d.j.pb_read_strategy_add_experience));
                    this.hxD.show(this.eCh, this.mSkinType);
                } else if (dVar.hkh == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hoK.getStType())) {
                    this.hxD.setText(this.hoK.getString(d.j.pb_read_news_add_experience));
                    this.hxD.show(this.eCh, this.mSkinType);
                }
            }
            p(dVar);
        }
    }

    private void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHW() != null) {
            if (dVar.UY()) {
                com.baidu.tbadk.core.util.al.c(this.hwP, d.f.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.al.c(this.hwP, d.f.icon_pb_bottom_collect_n);
            }
            String ww = ww(dVar.bHW().YF());
            this.hwR.M(ww, ww == null);
            this.hwR.setVisibility(0);
        }
    }

    private String ww(int i) {
        if (i == 0) {
            return this.hoK.getString(d.j.pb_comment_red_dot_no_reply);
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
        if (this.hvv != null && this.hvv.aBz() != null) {
            this.hvF.removeHeaderView(this.ahO);
            if (this.mType != 1) {
                this.hvF.removeHeaderView(this.hvv.bPl());
                this.hvF.addHeaderView(this.hvv.bPl(), 0);
                return;
            }
            return;
        }
        if (this.hvv != null) {
            this.hvF.removeHeaderView(this.hvv.bPl());
        }
        this.hvF.removeHeaderView(this.ahO);
        this.hvF.addHeaderView(this.ahO, 0);
    }

    public void nQ(boolean z) {
        this.hwH = z;
    }

    public void aeA() {
        if (this.feS != null) {
            this.feS.aew();
            this.feS.aeA();
        }
        aMt();
    }

    public void aOs() {
        this.hvF.setVisibility(0);
    }

    public void q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hwV != null && this.hwV.YO() != null && this.hvB != null) {
            this.hxz = !this.hxy;
            this.hvB.of(this.hxz);
            if (this.hoK.bJm() != null) {
                this.hoK.bJm().oe(this.hxz);
            }
            bMQ();
            if (this.hoK != null && !this.hoK.bIN() && !com.baidu.tbadk.core.util.v.T(dVar.bIr())) {
                bc bcVar = dVar.bIr().get(0);
                if (bcVar != null) {
                    this.hvB.dB(bcVar.getForumName(), bcVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hvB.dB(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hxz) {
                if (this.hwI) {
                    this.hvZ.setVisibility(8);
                    this.hwb.setVisibility(0);
                    this.hwb.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIs())));
                }
                if (this.hxf != null) {
                    this.hxf.setVisibility(8);
                }
                if (this.hxK == null) {
                    this.hxK = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hxB) {
                                aq.this.bNi();
                            }
                            aq.this.bMJ();
                        }
                    };
                }
                this.hvF.setListViewDragListener(this.hxK);
                return;
            }
            if (this.hxf != null) {
                this.hxf.setVisibility(0);
            }
            if (this.hwI) {
                this.hvZ.setVisibility(8);
                this.hwb.setVisibility(0);
                this.hwb.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIs())));
            } else if (!PbNormalLikeButtonSwitchStatic.apE() || (this.hwV.YO().hadConcerned() && this.hwV.YO().getGodUserData() != null && this.hwV.YO().getGodUserData().getIsFromNetWork())) {
                this.hvZ.setVisibility(8);
                this.hwb.setVisibility(8);
            } else {
                this.hwb.setVisibility(8);
            }
            this.hxK = null;
            this.hvF.setListViewDragListener(null);
        }
    }

    private void bMQ() {
        String threadId = this.hsd != null ? this.hsd.getThreadId() : "";
        int bMR = bMR();
        if (this.hxz && this.hwV != null && this.hwV.YO() != null) {
            this.hwV.YO().setIsLike(this.hwV.YO().hadConcerned());
        }
        if (this.hwa == null) {
            this.hwa = new ao(this.hoK.getPageContext(), this.hvZ, 1);
            this.hwa.i(this.hoK.getUniqueId());
            this.hwa.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void dV(boolean z) {
                    if (aq.this.hoK != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hoK, d.j.attention_success);
                    }
                }
            });
        }
        if (this.hwV != null && this.hwV.YO() != null) {
            this.hwV.YO().setIsLike(this.hwV.YO().hadConcerned());
            this.hwa.a(this.hwV.YO());
            this.hwa.setTid(threadId);
        }
        this.hwa.hvq = this.hxy;
        this.hwa.wt(bMR);
    }

    public int bMR() {
        if (this.hsd == null || this.hsd.bHW() == null) {
            return 0;
        }
        if (this.hsd.bHW().aag()) {
            return (com.baidu.tbadk.core.util.v.T(this.hsd.bIr()) && (this.hsd.bHV() == null || StringUtils.isNull(this.hsd.bHV().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bMS() {
        return this.hsd == null || this.hsd.getForum() == null || "0".equals(this.hsd.getForum().getId()) || "me0407".equals(this.hsd.getForum().getName());
    }

    private boolean bMT() {
        boolean z;
        if (this.hwL != null && this.hwL.getVisibility() == 0) {
            if (this.hwk != null) {
                this.hwk.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hwk != null) {
                this.hwk.setVisibility(8);
            }
            z = false;
        }
        if ((this.hwm == null || this.hwm.getVisibility() == 8) && z && this.hpb) {
            this.hwl.setVisibility(0);
        } else {
            this.hwl.setVisibility(8);
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
            return com.baidu.tieba.card.n.a((Context) this.hoK.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hvH != null) {
                if (dVar.bHW() != null && dVar.bHW().Zd() == 0 && !dVar.bHW().ZI() && !this.hxP) {
                    this.hvH.setVisibility(0);
                    if (dVar.bHW() != null) {
                        bg bHW = dVar.bHW();
                        bHW.k(true, r(dVar));
                        bHW.setResource(3);
                        bHW.lj("2");
                    }
                    SpannableStringBuilder Zu = dVar.bHW().Zu();
                    this.hvI.setOnTouchListener(new com.baidu.tieba.view.k(Zu));
                    this.hvI.setText(Zu);
                    this.hvI.setVisibility(0);
                } else if (dVar.bHW().Zd() == 1) {
                    if (dVar.bHW() != null) {
                        this.hvH.setVisibility(8);
                        this.hvF.removeHeaderView(this.hvH);
                    }
                } else {
                    this.hvH.setVisibility(8);
                    this.hvF.removeHeaderView(this.hvH);
                    if (dVar.bHW() != null && dVar.bHW().ZI()) {
                        this.hvN.setPadding(this.hvN.getPaddingLeft(), 0, this.hvN.getPaddingRight(), this.hvN.getPaddingBottom());
                        if (this.hwf != null) {
                            ((RelativeLayout.LayoutParams) this.hwf.getLayoutParams()).height = (int) this.hoK.getResources().getDimension(d.e.tbds36);
                            this.hwf.requestLayout();
                        }
                        if (this.hwg != null) {
                            ((RelativeLayout.LayoutParams) this.hwg.getLayoutParams()).height = (int) this.hoK.getResources().getDimension(d.e.tbds0);
                            this.hwg.requestLayout();
                        }
                    } else {
                        this.hvN.setPadding(this.hvN.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.hoK.getPageContext().getPageActivity(), d.e.ds48), this.hvN.getPaddingRight(), this.hvN.getPaddingBottom());
                    }
                }
            }
            if (dVar.bHW() != null) {
                Y(dVar.bHW().YK() == 1, dVar.bHW().YJ() == 1);
            }
            this.hpb = z;
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
                        if (bcVar != null && !StringUtils.isNull(bcVar.getForumName()) && (vVar = bcVar.bAE) != null && vVar.byx && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(bcVar.getForumName(), 12)).append(this.hoK.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.hoK.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.cpI;
    }

    public boolean bMU() {
        if (this.eoB == null || this.eoB.getParent() == null || this.feS.qz()) {
            return false;
        }
        int bottom = this.eoB.getBottom();
        Rect rect = new Rect();
        this.eoB.getWindowVisibleDisplayFrame(rect);
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
            if (this.hxk != null && this.hxk.hys != null && this.hxk.hys.getView() != null) {
                i = this.hxk.hys.getView().getTop() < 0 ? this.hxk.hys.getView().getHeight() : this.hxk.hys.getView().getBottom();
            }
            this.feS.aa(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hvF;
    }

    public int bMV() {
        return d.g.richText;
    }

    public TextView bJi() {
        return this.hvM.bJi();
    }

    public void e(BdListView.e eVar) {
        this.hvF.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.bRJ = cVar;
        if (this.hws != null) {
            this.hws.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int XF = anVar.XF();
            int XC = anVar.XC();
            if (this.hwp != null) {
                this.hwp.aaW();
            } else {
                this.hwp = new com.baidu.tbadk.core.dialog.a(this.hoK.getPageContext().getPageActivity());
                this.hwq = LayoutInflater.from(this.hoK.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.hwp.az(this.hwq);
                this.hwp.a(d.j.dialog_ok, bVar);
                this.hwp.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bMX();
                        aVar.dismiss();
                    }
                });
                this.hwp.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hxt == null) {
                            aq.this.hxt = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hoK.HidenSoftKeyPad((InputMethodManager) aq.this.hoK.getSystemService("input_method"), aq.this.eCh);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jH().postDelayed(aq.this.hxt, 150L);
                    }
                });
                this.hwp.b(this.hoK.getPageContext()).aaW();
            }
            this.hwr = (EditText) this.hwq.findViewById(d.g.input_page_number);
            this.hwr.setText("");
            TextView textView = (TextView) this.hwq.findViewById(d.g.current_page_number);
            if (XF <= 0) {
                XF = 1;
            }
            if (XC <= 0) {
                XC = 1;
            }
            textView.setText(MessageFormat.format(this.hoK.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(XF), Integer.valueOf(XC)));
            this.hoK.ShowSoftKeyPadDelay(this.hwr, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hvF.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hoK.showToast(str);
    }

    public boolean nR(boolean z) {
        if (this.VO == null || !this.VO.alS()) {
            return false;
        }
        this.VO.akm();
        return true;
    }

    public void bMW() {
        if (this.hyc != null) {
            while (this.hyc.size() > 0) {
                TbImageView remove = this.hyc.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bMW();
        this.hwo.we(1);
        if (this.hvv != null) {
            this.hvv.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hwo.we(2);
        if (this.hvv != null) {
            this.hvv.onResume();
            if (!UtilHelper.isOnePlus6()) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hxv != null) {
            this.hxv.destroy();
        }
        if (this.hxM != null) {
            this.hxM.onDestory();
        }
        if (this.hxD != null) {
            this.hxD.hide();
        }
        if (this.hvy != null) {
            this.hvy.aSp();
        }
        if (this.hvx != null) {
            this.hvx.onDestroy();
        }
        this.hoK.hideProgressBar();
        if (this.eCf != null && this.eWq != null) {
            this.eCf.b(this.eWq);
        }
        bMX();
        aeA();
        if (this.hxt != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hxt);
        }
        if (this.hvN != null && this.hvY != null) {
            this.hvN.removeView(this.hvT);
            this.hvY = null;
        }
        if (this.hxa != null) {
            this.hxa.clearStatus();
        }
        this.hxV = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hwo.we(3);
        if (this.faY != null) {
            this.faY.setBackgroundDrawable(null);
        }
        if (this.hvv != null) {
            this.hvv.destroy();
        }
        if (this.hwo != null) {
            this.hwo.onDestroy();
        }
        this.hvF.setOnLayoutListener(null);
        if (this.hxI != null) {
            this.hxI.beW();
        }
        if (this.hxl != null) {
            this.hxl.onDestroy();
        }
    }

    public boolean wx(int i) {
        if (this.hvv != null) {
            return this.hvv.qs(i);
        }
        return false;
    }

    public void bMX() {
        this.hvB.Qi();
        if (this.hvy != null) {
            this.hvy.aSp();
        }
        com.baidu.adp.lib.util.l.b(this.hoK.getPageContext().getPageActivity(), this.hwr);
        bMj();
        if (this.hmQ != null) {
            this.hmQ.dismiss();
        }
        bMZ();
        if (this.hvx != null) {
            this.hvx.bPa();
        }
        if (this.hwp != null) {
            this.hwp.dismiss();
        }
        if (this.faK != null) {
            this.faK.dismiss();
        }
    }

    public void bMY() {
        this.hvB.Qi();
        if (this.hvy != null) {
            this.hvy.aSp();
        }
        if (this.hmQ != null) {
            this.hmQ.dismiss();
        }
        bMZ();
        if (this.hvx != null) {
            this.hvx.bPa();
        }
        if (this.hwp != null) {
            this.hwp.dismiss();
        }
        if (this.faK != null) {
            this.faK.dismiss();
        }
    }

    public void dA(List<String> list) {
        this.hxH = list;
        if (this.hxI != null) {
            this.hxI.setData(list);
        }
    }

    public void nc(boolean z) {
        this.hwo.nc(z);
    }

    public void nS(boolean z) {
        this.hwK = z;
    }

    public void bMZ() {
        if (this.hwy != null) {
            this.hwy.dismiss();
        }
        if (this.hwz != null) {
            com.baidu.adp.lib.g.g.b(this.hwz, this.hoK.getPageContext());
        }
        if (this.hwA != null) {
            com.baidu.adp.lib.g.g.b(this.hwA, this.hoK.getPageContext());
        }
        if (this.hww != null) {
            this.hww.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hsd, this.hpb);
            d(this.hsd, this.hpb, this.mType);
            this.hoK.getLayoutMode().setNightMode(i == 1);
            this.hoK.getLayoutMode().onModeChanged(this.eCh);
            this.hoK.getLayoutMode().onModeChanged(this.hvG);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.al.l(this.eCh, d.C0277d.cp_bg_line_d);
            }
            if (this.hvx != null) {
                this.hvx.onChangeSkinType(i);
            }
            if (this.hvI != null) {
                com.baidu.tbadk.core.util.al.j(this.hvI, d.C0277d.cp_cont_b);
                this.hvI.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            }
            if (this.feS != null) {
                this.feS.ib(i);
                if (this.cpI != null) {
                    this.hoK.getLayoutMode().onModeChanged(this.cpI);
                    com.baidu.tbadk.core.util.al.k(this.cpI, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.hwp != null) {
                this.hwp.c(this.hoK.getPageContext());
            }
            nQ(this.hwH);
            this.hwo.notifyDataSetChanged();
            if (this.hws != null) {
                this.hws.ib(i);
            }
            if (this.VO != null) {
                this.VO.onChangeSkinType(i);
            }
            if (this.hvX != null) {
                this.hvX.ii(i);
            }
            if (this.hwt != null) {
                this.hwt.ib(i);
            }
            if (!com.baidu.tbadk.core.util.v.T(this.ekg)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ekg) {
                    customBlueCheckRadioButton.aee();
                }
            }
            bMy();
            UtilHelper.setStatusBarBackground(this.faY, i);
            UtilHelper.setStatusBarBackground(this.hxf, i);
            if (this.hvZ != null) {
                this.hvZ.onChangeSkinType(i);
            }
            if (this.hwd != null) {
                com.baidu.tbadk.core.util.al.j(this.hwd, d.C0277d.cp_cont_d);
            }
            if (this.hwc != null) {
                com.baidu.tbadk.core.util.al.j(this.hwc, d.C0277d.cp_cont_d);
            }
            if (this.hwe != null) {
                com.baidu.tbadk.core.util.al.j(this.hwe, d.C0277d.cp_cont_d);
            }
            if (this.hvQ != null) {
                com.baidu.tbadk.core.util.al.j(this.hvQ, d.C0277d.cp_link_tip_a);
            }
            if (this.hwb != null) {
                com.baidu.tbadk.core.util.al.j(this.hwb, d.C0277d.cp_cont_d);
            }
            if (this.hwh != null) {
                com.baidu.tbadk.r.a.a(this.hoK.getPageContext(), this.hwh);
            }
            if (this.hxu != null) {
                this.hxu.onChangeSkinType(i);
            }
            if (this.hvB != null) {
                if (this.hvv != null) {
                    this.hvv.wC(i);
                } else {
                    this.hvB.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fOS != null) {
                com.baidu.tbadk.core.util.al.j(this.fOS, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.k(this.fOS, d.f.bg_comment_input);
            }
            if (this.hwP != null && this.hsd != null) {
                if (this.hsd.UY()) {
                    com.baidu.tbadk.core.util.al.c(this.hwP, d.f.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.hwP, d.f.icon_pb_bottom_collect_n);
                }
            }
            if (this.hwQ != null) {
                com.baidu.tbadk.core.util.al.c(this.hwQ, d.f.icon_pb_bottom_share_n);
            }
            if (this.hwO != null) {
                com.baidu.tbadk.core.util.al.c(this.hwO, d.f.icon_pb_bottom_comment_n);
            }
            if (this.hwR != null) {
                this.hwR.onChangeSkinType();
            }
            if (this.hvR != null) {
                com.baidu.tbadk.core.util.al.c(this.hvR, BitmapHelper.getGradeResourceIdInEnterForum(this.hxC));
            }
            if (this.hxJ != null) {
                this.hxJ.onChangeSkinType(i);
            }
            if (this.hxl != null) {
                this.hxl.onChangeSkinType();
            }
            if (this.hxF != null) {
                com.baidu.tbadk.core.util.al.j(this.hxF, d.C0277d.cp_cont_n);
            }
            com.baidu.tbadk.core.util.al.l(this.hwN, d.C0277d.cp_bg_line_d);
            if (this.hvQ != null) {
                com.baidu.tbadk.core.util.al.k(this.hvQ, d.f.bg_user_identity_btn);
                com.baidu.tbadk.core.util.al.j(this.hvQ, d.C0277d.cp_bg_line_d);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
        this.hwo.setOnImageClickListener(this.cAE);
        this.hxJ.setOnImageClickListener(this.cAE);
    }

    public void h(NoNetworkView.a aVar) {
        this.eWq = aVar;
        if (this.eCf != null) {
            this.eCf.a(this.eWq);
        }
    }

    public void nT(boolean z) {
        this.hwo.setIsFromCDN(z);
    }

    public Button bNa() {
        return this.hwL;
    }

    public void bNb() {
        if (this.hvA != 2) {
            this.hvF.setNextPage(this.feS);
            this.hvA = 2;
        }
    }

    public void bNc() {
        if (com.baidu.tbadk.o.m.apg().aph()) {
            int lastVisiblePosition = this.hvF.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hvF.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.o.h perfLog = tbImageView.getPerfLog();
                                perfLog.jW(1001);
                                perfLog.cqp = true;
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
                        perfLog2.cqp = true;
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
        return this.VO != null && this.VO.getVisibility() == 0;
    }

    public boolean bNe() {
        return this.VO != null && this.VO.alS();
    }

    public void bNf() {
        if (this.VO != null) {
            this.VO.akm();
        }
    }

    public void nU(boolean z) {
        if (this.hwN != null) {
            nS(this.hoK.bJj().amw());
            if (this.hwK) {
                nK(z);
            } else {
                nL(z);
            }
        }
    }

    public void bNg() {
        if (this.hwN != null) {
            this.hwM.setVisibility(8);
            this.hwN.setVisibility(8);
            this.hwS = false;
            if (this.hxl != null) {
                this.hxl.setVisibility(8);
                nO(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.erP == null) {
            this.erP = new com.baidu.tbadk.core.view.b(this.hoK.getPageContext());
        }
        this.erP.dJ(true);
    }

    public void aMt() {
        if (this.erP != null) {
            this.erP.dJ(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hvF.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hvF.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hvv != null) {
            this.hvv.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hyd = getScrollY();
            this.hxk.hys = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxk));
            a(this.hxk.hys, true);
        }
    }

    public void nV(boolean z) {
        this.hvv.nV(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hvv != null) {
            this.hvv.b(absListView, i);
        }
        if (this.hvB != null && this.hwo != null) {
            this.hvB.a(this.hwo.bKw());
        }
        this.hxk.hfd = i;
        this.hxk.headerCount = this.hvF.getHeaderViewsCount();
        this.hxk.hys = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxk));
        a(this.hxk.hys, false);
        if (this.feS.aeG() && !this.feS.bRy) {
            if (this.hxk != null && this.hxk.hys != null && this.hxk.hys.getView() != null) {
                i4 = this.hxk.hys.getView().getTop() < 0 ? this.hxk.hys.getView().getHeight() : this.hxk.hys.getView().getBottom();
            }
            this.feS.ie(i4);
            this.feS.bRy = true;
        }
    }

    public void bNh() {
        if (this.hoK.isLogin() && this.hsd != null && this.hxz && !this.hxy && !this.hwI && this.hwV != null && this.hwV.YO() != null && !this.hwV.YO().getIsLike() && !this.hwV.YO().hadConcerned() && this.hxv == null) {
            this.hxv = new an(this.hoK);
        }
    }

    public void bNi() {
        if (this.hxz && !this.hxy && this.hwV != null && this.hwV.YO() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").T("obj_locate", this.hoK.bIN() ? 2 : 1).T("obj_type", this.hxy ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hoK.getPageContext().getPageActivity(), this.hwV.YO().getUserId(), this.hwV.YO().getUserName(), this.hoK.bIX().bIO(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hxy && this.hxe != null && this.hvB.bNQ() != null) {
            int bKs = this.hwo.bKs();
            if (bKs > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bKs > this.hvF.getFirstVisiblePosition() - this.hvF.getHeaderViewsCount()) {
                    this.hxe.setVisibility(8);
                    return;
                }
                this.hxe.setVisibility(0);
                bNs();
                this.hvB.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.huZ == null) {
                if (this.hvF.getFirstVisiblePosition() == 0) {
                    this.hxe.setVisibility(8);
                    this.hvB.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hxj) {
                        this.hxi = top;
                        this.hxj = false;
                    }
                    this.hxi = top < this.hxi ? top : this.hxi;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hwn.getY() < 0.0f) {
                        measuredHeight = hxh - alVar.huZ.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hvB.bNQ().getMeasuredHeight() - alVar.huZ.getMeasuredHeight();
                        this.hvB.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hxi) {
                        this.hxe.setVisibility(0);
                        bNs();
                    } else if (top < measuredHeight) {
                        this.hxe.setVisibility(0);
                        bNs();
                    } else {
                        this.hxe.setVisibility(8);
                        this.hvB.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hxj = true;
                    }
                }
            }
        }
    }

    public void bNj() {
        if (!this.hye) {
            TiebaStatic.log("c10490");
            this.hye = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hoK.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hxo, Integer.valueOf(hxq));
            aVar.gB(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hoK.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.az(inflate);
            aVar.Z(sparseArray);
            aVar.a(d.j.grade_button_tips, this.hoK);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hoK.getPageContext()).aaW();
        }
    }

    public void zX(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hoK.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hoK.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.az(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hxo, Integer.valueOf(hxr));
        aVar.Z(sparseArray);
        aVar.a(d.j.view, this.hoK);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hoK.getPageContext()).aaW();
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
        return this.hxa;
    }

    private void s(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHW() != null && dVar.bHW().ZO() && this.hxa == null) {
            this.hxa = (PbInterviewStatusView) this.hwZ.inflate();
            this.hxa.setOnClickListener(this.faL);
            this.hxa.setCallback(this.hoK.bJU());
            this.hxa.setData(this.hoK, dVar);
        }
    }

    public LinearLayout bNl() {
        return this.hwn;
    }

    public View bNm() {
        return this.faY;
    }

    public boolean bNn() {
        return this.hxP;
    }

    public void nh(boolean z) {
        this.hvM.nh(z);
    }

    public void zY(String str) {
        if (this.hvC != null) {
            this.hvC.setTitle(str);
        }
    }

    private int nW(boolean z) {
        if (this.hxa == null || this.hxa.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.hoK.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bNo() {
        if (this.hxa != null && this.hxa.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hxa.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hxa.setLayoutParams(layoutParams);
        }
    }

    public boolean bJo() {
        return false;
    }

    public void zZ(String str) {
        this.fOS.performClick();
        if (!StringUtils.isNull(str) && this.hoK.bJj() != null && this.hoK.bJj().amp() != null && this.hoK.bJj().amp().getInputView() != null) {
            EditText inputView = this.hoK.bJj().amp().getInputView();
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
            if (this.hxu != null) {
                this.hxu.bKB();
            }
            this.hoK.bcL();
            this.hwn.setVisibility(8);
            this.hvB.og(false);
            this.hoK.nn(false);
            if (this.hvv != null) {
                if (configuration.orientation == 1) {
                    bNl().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hvF.setIsLandscape(true);
                    this.hvF.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hvF.setIsLandscape(false);
                    if (this.hyd > 0) {
                        this.hvF.smoothScrollBy(this.hyd, 0);
                    }
                }
                this.hvv.onConfigurationChanged(configuration);
                this.hxd.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void nX(boolean z) {
        this.hvz = z;
    }

    public boolean bNp() {
        return this.hvv != null && this.hvv.bNp();
    }

    public void bNq() {
        if (this.hvv != null) {
            this.hvv.onPause();
        }
    }

    public void s(long j, int i) {
        if (this.hvx != null) {
            this.hvx.s(j, i);
        }
        if (this.hvv != null) {
            this.hvv.s(j, i);
        }
    }

    public void ns(boolean z) {
        this.hwo.ns(z);
    }

    public void bNr() {
        if (this.hxb == null) {
            LayoutInflater.from(this.hoK.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.eCh, true);
            this.hxb = (ViewGroup) this.eCh.findViewById(d.g.add_experienced_layout);
            this.hxc = (TextView) this.eCh.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.al.j(this.hxc, d.C0277d.cp_btn_a);
            String string = this.hoK.getResources().getString(d.j.experienced_add_success);
            String string2 = this.hoK.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_h)));
            this.hxc.setText(spannableString);
        }
        this.hxb.setVisibility(0);
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
                        aq.this.hxb.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hxc.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hxc.startAnimation(scaleAnimation);
    }

    public void ct(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hwN.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hoK);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.hxF = new TextView(this.hoK);
            this.hxF.setText(d.j.connection_tips);
            this.hxF.setGravity(17);
            this.hxF.setPadding(com.baidu.adp.lib.util.l.h(this.hoK, d.e.ds24), 0, com.baidu.adp.lib.util.l.h(this.hoK, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hoK, d.e.ds60);
            if (this.hxF.getParent() == null) {
                frameLayout.addView(this.hxF, layoutParams);
            }
            this.hxE = new PopupWindow(this.hoK);
            this.hxE.setContentView(frameLayout);
            this.hxE.setHeight(-2);
            this.hxE.setWidth(-2);
            this.hxE.setFocusable(true);
            this.hxE.setOutsideTouchable(false);
            this.hxE.setBackgroundDrawable(new ColorDrawable(this.hoK.getResources().getColor(d.C0277d.transparent)));
            this.hvF.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hxE.showAsDropDown(aq.this.hwN, view.getLeft(), -aq.this.hwN.getHeight());
                    } else {
                        aq.this.hxE.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bNs() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.hxG == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.hxG = new com.baidu.tbadk.core.dialog.a(this.hoK);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hoK);
            this.hxG.gE(1);
            this.hxG.az(pbLongPressTipView);
            this.hxG.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hxG.dr(false);
            this.hxG.b(this.hoK.getPageContext()).aaW();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hxG != null && aq.this.hxG.isShowing()) {
                        aq.this.hxG.dismiss();
                    }
                }
            }, 5000L);
            if (this.hvv != null) {
                this.hvv.bPk();
            }
        }
    }

    public void nY(boolean z) {
        this.hxL = z;
    }

    public boolean bNt() {
        return this.hxL;
    }

    private void Y(boolean z, boolean z2) {
        Z(z, z2);
        aa(z, z2);
        if (this.hwo != null && this.hwo.bKx() != null) {
            this.hwo.bKx().S(z, z2);
        }
    }

    private void Z(boolean z, boolean z2) {
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

    private void aa(boolean z, boolean z2) {
        if (this.hvH != null && this.hsd != null && this.hsd.bHW() != null && this.hsd.bHW().Zd() == 0 && !this.hsd.bHW().ZI()) {
            if (z && z2) {
                this.hvL.setImageResource(d.f.pic_pb_stick_refined_n);
                this.hvL.setVisibility(0);
            } else if (z) {
                this.hvL.setImageResource(d.f.pic_pb_refined_n);
                this.hvL.setVisibility(0);
            } else if (z2) {
                this.hvL.setImageResource(d.f.pic_pb_stick_n);
                this.hvL.setVisibility(0);
            } else {
                this.hvL.setVisibility(8);
            }
        }
    }
}
