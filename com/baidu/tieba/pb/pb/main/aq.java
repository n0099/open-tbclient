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
import com.xiaomi.mipush.sdk.Constants;
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
    private EditorTools VM;
    private TextView ahH;
    private h.c bRF;
    private NavigationBarCoverTip bsn;
    private com.baidu.tieba.pb.a.c cbY;
    private View cpF;
    private NoNetworkView eCx;
    private RelativeLayout eCz;
    private List<CustomBlueCheckRadioButton> ekx;
    private View eoS;
    private TextView fPf;
    private View.OnClickListener faZ;
    private View fbm;
    private PbListView ffg;
    private com.baidu.tieba.NEGFeedBack.e fzE;
    PbActivity.d hoi;
    private View.OnClickListener hpC;
    private PbActivity hpd;
    private UserIconBox hqq;
    private UserIconBox hqr;
    private PbFakeFloorModel hro;
    private com.baidu.tieba.pb.data.d hsw;
    public int hvN;
    private com.baidu.tieba.pb.video.i hvO;
    private long hvP;
    private com.baidu.tieba.pb.video.h hvQ;
    private com.baidu.tieba.c.d hvR;
    public final com.baidu.tieba.pb.pb.main.view.b hvU;
    public com.baidu.tieba.pb.pb.main.view.a hvV;
    private ViewStub hvW;
    private ViewStub hvX;
    private PbLandscapeListView hvY;
    private View hvZ;
    private LinearLayout hwA;
    private TextView hwB;
    private TextView hwC;
    private View hwD;
    private View hwE;
    private ObservedChangeLinearLayout hwG;
    private f hwH;
    private View hwN;
    private RelativeLayout hwc;
    private ImageView hwd;
    private ImageView hwe;
    private e hwf;
    private ColumnLayout hwg;
    private ThreadSkinView hwh;
    private TextView hwi;
    private TextView hwj;
    private ImageView hwk;
    private HeadPendantView hwl;
    private FrameLayout hwm;
    private HeadImageView hwn;
    private View hwo;
    private LinearLayout hwp;
    private PbFirstFloorUserLikeButton hws;
    private ao hwt;
    private TextView hwu;
    private TextView hwv;
    private TextView hww;
    private TextView hwx;
    private View hwy;
    private View hwz;
    private PbEmotionBar hxD;
    private int hxL;
    private Runnable hxM;
    private s hxN;
    private an hxO;
    private int hxU;
    private PbTopTipView hxW;
    private PopupWindow hxX;
    private TextView hxY;
    private com.baidu.tbadk.core.dialog.a hxZ;
    private View hxf;
    private ImageView hxg;
    private ImageView hxh;
    private ImageView hxi;
    private MessageRedDotView hxj;
    private int hxl;
    private int hxm;
    private PostData hxn;
    private View hxp;
    private TextView hxq;
    private ViewStub hxr;
    private PbInterviewStatusView hxs;
    private ViewGroup hxt;
    private TextView hxu;
    private FrameLayout hxv;
    private View hxw;
    private View hxx;
    private al hxy;
    private List<String> hya;
    private com.baidu.tieba.pb.pb.main.emotion.c hyb;
    private com.baidu.tieba.pb.pb.godreply.a hyc;
    private PbLandscapeListView.b hyd;
    private ac hyf;
    private String hyg;
    private boolean hyi;
    private com.baidu.tbadk.core.view.userLike.c hyj;
    private com.baidu.tbadk.core.view.userLike.c hyk;
    private Runnable hyp;
    private PbActivity.b hyr;
    public int hyw;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private static final int hxz = UtilHelper.getLightStatusBarHeight();
    public static int hxF = 3;
    public static int hxG = 0;
    public static int hxH = 3;
    public static int hxI = 4;
    public static int hxJ = 5;
    public static int hxK = 6;
    private static a.InterfaceC0307a hyh = new a.InterfaceC0307a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0307a
        public void onRefresh() {
        }
    };
    private boolean hvS = false;
    private int hvT = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hwa = null;
    private TextView hwb = null;
    public FrsPraiseView hwq = null;
    private ClickableHeaderImageView hwr = null;
    private View hwF = null;
    private com.baidu.tbadk.core.dialog.a hwI = null;
    private com.baidu.tbadk.core.dialog.b faY = null;
    private View hwJ = null;
    private EditText hwK = null;
    private com.baidu.tieba.pb.view.c hwL = null;
    private com.baidu.tieba.pb.view.a hwM = null;
    private com.baidu.tbadk.core.dialog.a hwO = null;
    private b.InterfaceC0191b gmG = null;
    private TbRichTextView.h cAE = null;
    private NoNetworkView.a eWE = null;
    private com.baidu.tbadk.core.dialog.g hwP = null;
    private View hwQ = null;
    private com.baidu.tbadk.core.dialog.a hwR = null;
    private Dialog hwS = null;
    private Dialog hwT = null;
    private View hwU = null;
    private LinearLayout hwV = null;
    private CompoundButton.OnCheckedChangeListener eky = null;
    private TextView hwW = null;
    private TextView hwX = null;
    private String hwY = null;
    private com.baidu.tbadk.core.dialog.g hnj = null;
    private com.baidu.tbadk.core.dialog.g hwZ = null;
    private boolean hxa = false;
    private boolean hxb = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hxc = null;
    private boolean hxd = false;
    private Button hxe = null;
    private boolean hxk = true;
    private com.baidu.tbadk.core.view.b esg = null;
    private boolean hpu = false;
    private int mSkinType = 3;
    private boolean hxo = false;
    private int hxA = 0;
    private boolean hxB = true;
    private a hxC = new a();
    private int hxE = 0;
    private boolean hxP = false;
    private int hxQ = 0;
    private boolean hxR = false;
    private boolean hxS = false;
    private boolean hxT = false;
    private int hxV = 0;
    private boolean hye = false;
    private String hyl = null;
    private CustomMessageListener hym = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hyl = null;
            }
        }
    };
    private CustomMessageListener dgB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hwH != null) {
                aq.this.hwH.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hyn = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hwb != null) {
                aq.this.hwb.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hyo = new Handler();
    private CustomMessageListener hyq = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hxk = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hys = true;
    View.OnClickListener hyt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hxR) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").T(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hxR && aq.this.hsw != null && aq.this.hsw.bIa() != null && aq.this.hsw.bIa().YR() != null && aq.this.hsw.bIa().YR().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").T("obj_locate", 1));
            }
            aq.this.hpd.hne.fAk.onClick(view);
        }
    };
    private boolean hyu = false;
    String userId = null;
    private final List<TbImageView> hyv = new ArrayList();
    private boolean hyx = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int headerCount;
        public int hfq;
        public al hyL;
    }

    public void nJ(boolean z) {
        this.hxP = z;
        if (this.hvY != null) {
            this.hxQ = this.hvY.getHeaderViewsCount();
        }
    }

    public void bMl() {
        if (this.hvY != null) {
            int headerViewsCount = this.hvY.getHeaderViewsCount() - this.hxQ;
            final int firstVisiblePosition = (this.hvY.getFirstVisiblePosition() == 0 || this.hvY.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hvY.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hvY.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hxC.hyL = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxC));
            final al alVar = this.hxC.hyL;
            final int h = h(alVar);
            final int y = ((int) this.hwG.getY()) + this.hwG.getMeasuredHeight();
            final boolean z = this.hxw.getVisibility() == 0;
            boolean z2 = this.hwG.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hwH.bKw() + this.hvY.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hvs.getMeasuredHeight() : 0;
                if (z2) {
                    this.hvY.setSelectionFromTop(this.hwH.bKw() + this.hvY.getHeaderViewsCount(), hxz - measuredHeight);
                } else {
                    this.hvY.setSelectionFromTop(this.hwH.bKw() + this.hvY.getHeaderViewsCount(), this.hvU.bNT().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hvY.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hxR) {
                this.hvY.setSelectionFromTop(this.hwH.bKw() + this.hvY.getHeaderViewsCount(), this.hvO.aBD().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hvY.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bKO() {
                        if (h >= 0 && h <= aq.this.eCz.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.eoS.getLayoutParams();
                            if (i == 0 || i > aq.this.eCz.getMeasuredHeight() || h2 >= aq.this.eCz.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hxL;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.eCz.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hxL;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hvY.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.eoS.setLayoutParams(layoutParams);
                        }
                        aq.this.hvY.setOnLayoutListener(null);
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

    public NoNetworkView bMm() {
        return this.eCx;
    }

    public void bMn() {
        if (this.VM != null) {
            this.VM.hide();
            if (this.hyb != null) {
                this.hyb.aAC();
            }
        }
    }

    public PbFakeFloorModel bMo() {
        return this.hro;
    }

    public s bMp() {
        return this.hxN;
    }

    public void bMq() {
        reset();
        bMn();
        this.hxN.bKF();
        nU(false);
    }

    private void reset() {
        if (this.hpd != null && this.hpd.bJn() != null && this.VM != null) {
            com.baidu.tbadk.editortools.pb.a.amq().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bJn = this.hpd.bJn();
            bJn.amJ();
            bJn.ame();
            if (bJn.getWriteImagesInfo() != null) {
                bJn.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bJn.jC(SendView.ALL);
            bJn.jD(SendView.ALL);
            com.baidu.tbadk.editortools.g jt = this.VM.jt(23);
            com.baidu.tbadk.editortools.g jt2 = this.VM.jt(2);
            com.baidu.tbadk.editortools.g jt3 = this.VM.jt(5);
            if (jt2 != null) {
                jt2.qT();
            }
            if (jt3 != null) {
                jt3.qT();
            }
            if (jt != null) {
                jt.hide();
            }
            this.VM.invalidate();
        }
    }

    public boolean bMr() {
        return this.hxk;
    }

    public void nK(boolean z) {
        if (this.hxf != null && this.fPf != null) {
            this.fPf.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hxf.startAnimation(alphaAnimation);
            }
            this.hxf.setVisibility(0);
            this.hxk = true;
            if (this.hxD != null && !this.hyc.isActive()) {
                this.hxD.setVisibility(0);
                nO(true);
            }
        }
    }

    public void nL(boolean z) {
        if (this.hxf != null && this.fPf != null) {
            this.fPf.setText(bMs());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hxf.startAnimation(alphaAnimation);
            }
            this.hxf.setVisibility(0);
            this.hxk = true;
            if (this.hxD != null && !this.hyc.isActive()) {
                this.hxD.setVisibility(0);
                nO(true);
            }
        }
    }

    public String bMs() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.hyg)) {
            return this.hyg;
        }
        if (this.hpd != null) {
            this.hyg = this.hpd.getResources().getString(ap.bMk());
        }
        return this.hyg;
    }

    public PostData bMt() {
        int i = 0;
        if (this.hvY == null) {
            return null;
        }
        int bMu = bMu() - this.hvY.getHeaderViewsCount();
        if (bMu < 0) {
            bMu = 0;
        }
        if (this.hwH.wh(bMu) != null && this.hwH.wh(bMu) != PostData.iGj) {
            i = bMu + 1;
        }
        return this.hwH.getItem(i) instanceof PostData ? (PostData) this.hwH.getItem(i) : null;
    }

    public int bMu() {
        int i;
        View childAt;
        if (this.hvY == null) {
            return 0;
        }
        int firstVisiblePosition = this.hvY.getFirstVisiblePosition();
        int lastVisiblePosition = this.hvY.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hvY.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hvY.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bMv() {
        return this.hvY.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hsw != null && this.hsw.bIc() != null && !this.hsw.bIc().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hsw.bIc().size() && (postData = this.hsw.bIc().get(i)) != null && postData.YR() != null && !StringUtils.isNull(postData.YR().getUserId()); i++) {
                if (this.hsw.bIc().get(i).YR().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hyc != null && this.hyc.isActive()) {
                        nU(false);
                    }
                    if (this.hxD != null) {
                        this.hxD.oc(true);
                    }
                    this.hyl = postData.YR().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hpd = null;
        this.eCz = null;
        this.fbm = null;
        this.hvP = 0L;
        this.hvY = null;
        this.hvZ = null;
        this.hwc = null;
        this.hwg = null;
        this.hwi = null;
        this.hwj = null;
        this.hwm = null;
        this.hwn = null;
        this.hwo = null;
        this.hws = null;
        this.hwu = null;
        this.hwv = null;
        this.hww = null;
        this.hwx = null;
        this.hwD = null;
        this.hwE = null;
        this.hwH = null;
        this.ffg = null;
        this.cpF = null;
        this.faZ = null;
        this.hpC = null;
        this.hxf = null;
        this.fPf = null;
        this.hxp = null;
        this.hxq = null;
        this.hxr = null;
        this.hxU = 0;
        this.hvP = System.currentTimeMillis();
        this.hpd = pbActivity;
        this.faZ = onClickListener;
        this.cbY = cVar;
        this.hxU = com.baidu.adp.lib.util.l.aO(this.hpd) / 2;
        this.eCz = (RelativeLayout) LayoutInflater.from(this.hpd.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.hpd.addContentView(this.eCz, new FrameLayout.LayoutParams(-1, -1));
        this.bsn = (NavigationBarCoverTip) this.hpd.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.fbm = this.hpd.findViewById(d.g.statebar_view);
        this.hwG = (ObservedChangeLinearLayout) this.hpd.findViewById(d.g.title_wrapper);
        this.eCx = (NoNetworkView) this.hpd.findViewById(d.g.view_no_network);
        this.hvY = (PbLandscapeListView) this.hpd.findViewById(d.g.new_pb_list);
        this.hxv = (FrameLayout) this.hpd.findViewById(d.g.root_float_header);
        this.ahH = new TextView(this.hpd.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.hpd.getActivity(), d.e.ds88));
        this.hvY.addHeaderView(this.ahH, 0);
        this.hxL = this.hpd.getResources().getDimensionPixelSize(d.e.tbds134);
        this.eoS = new View(this.hpd.getPageContext().getPageActivity());
        this.eoS.setLayoutParams(new AbsListView.LayoutParams(-1, this.hxL));
        this.eoS.setVisibility(4);
        this.hvY.addFooterView(this.eoS);
        this.hvY.setOnTouchListener(this.hpd.ccU);
        this.hvU = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.hpd.bJQ()) {
            this.hvW = (ViewStub) this.hpd.findViewById(d.g.manga_view_stub);
            this.hvW.setVisibility(0);
            this.hvV = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.hvV.show();
            this.hvU.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hpd.getActivity(), d.e.ds120);
        }
        this.ahH.setLayoutParams(layoutParams);
        this.hvU.bNT().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0277a() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0277a
            public void bIL() {
                if (aq.this.hvY != null) {
                    if (aq.this.hvO != null) {
                        aq.this.hvO.bPk();
                    }
                    aq.this.hvY.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0277a
            public void bIM() {
                aq.this.hpd.bcO();
            }
        }));
        this.hxf = this.hpd.findViewById(d.g.pb_editor_tool_comment);
        this.hxl = com.baidu.adp.lib.util.l.h(this.hpd.getPageContext().getPageActivity(), d.e.tbds120);
        this.hxm = com.baidu.adp.lib.util.l.h(this.hpd.getPageContext().getPageActivity(), d.e.ds242);
        this.fPf = (TextView) this.hpd.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hpd.bJw();
                if (aq.this.hpd != null && aq.this.hpd.bJb() != null && aq.this.hpd.bJb().getPbData() != null && aq.this.hpd.bJb().getPbData().bIa() != null && aq.this.hpd.bJb().getPbData().bIa().YR() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", aq.this.hpd.bJb().hsa).bJ(ImageViewerConfig.FORUM_ID, aq.this.hpd.bJb().getPbData().getForumId()).T("obj_locate", 1).bJ("uid", aq.this.hpd.bJb().getPbData().bIa().YR().getUserId()));
                }
            }
        });
        this.hxg = (ImageView) this.hpd.findViewById(d.g.pb_editor_tool_comment_icon);
        this.hxg.setOnClickListener(this.faZ);
        this.hxh = (ImageView) this.hpd.findViewById(d.g.pb_editor_tool_collection);
        this.hxh.setOnClickListener(this.faZ);
        this.hxi = (ImageView) this.hpd.findViewById(d.g.pb_editor_tool_share);
        this.hxi.setOnClickListener(this.faZ);
        this.hxj = (MessageRedDotView) this.hpd.findViewById(d.g.pb_editor_tool_comment_red_dot);
        this.hvZ = LayoutInflater.from(this.hpd.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.hwc = (RelativeLayout) LayoutInflater.from(this.hpd.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.hwd = (ImageView) this.hwc.findViewById(d.g.pb_thread_type_stamp_top_part);
        this.hwf = new e(this.hpd, this.hwc);
        this.hwf.init();
        this.hwf.a(this.hwf.bJm(), this.faZ);
        this.hwg = (ColumnLayout) this.hwc.findViewById(d.g.pb_head_owner_root);
        this.hwh = (ThreadSkinView) this.hwc.findViewById(d.g.pb_thread_skin);
        this.hwg.setOnLongClickListener(this.onLongClickListener);
        this.hwg.setOnTouchListener(this.cbY);
        this.hwg.setVisibility(8);
        this.hvZ.setOnTouchListener(this.cbY);
        this.hxp = this.hvZ.findViewById(d.g.pb_head_activity_join_number_container);
        this.hxp.setVisibility(8);
        this.hxq = (TextView) this.hvZ.findViewById(d.g.pb_head_activity_join_number);
        this.hwi = (TextView) this.hwg.findViewById(d.g.pb_head_owner_info_user_name);
        this.hwi.getPaint().setFakeBoldText(true);
        this.hwj = (TextView) this.hwg.findViewById(d.g.floor_owner);
        this.hwk = (ImageView) this.hwg.findViewById(d.g.icon_forum_level);
        this.hwm = (FrameLayout) this.hwg.findViewById(d.g.pb_head_headImage_container);
        this.hwn = (HeadImageView) this.hwg.findViewById(d.g.pb_head_owner_photo);
        this.hwl = (HeadPendantView) this.hwg.findViewById(d.g.pb_pendant_head_owner_photo);
        this.hwl.setHasPendantStyle();
        if (this.hwl.getHeadView() != null) {
            this.hwl.getHeadView().setIsRound(true);
            this.hwl.getHeadView().setDrawBorder(false);
        }
        this.hqq = (UserIconBox) this.hwg.findViewById(d.g.show_icon_vip);
        this.hqr = (UserIconBox) this.hwg.findViewById(d.g.show_icon_yinji);
        this.hwp = (LinearLayout) this.hwc.findViewById(d.g.pb_head_owner_info_root);
        this.hws = (PbFirstFloorUserLikeButton) this.hwg.findViewById(d.g.pb_like_button);
        this.hwu = (TextView) this.hwg.findViewById(d.g.pb_views);
        this.hwv = (TextView) this.hwg.findViewById(d.g.pb_item_first_floor_reply_time);
        this.hww = (TextView) this.hwg.findViewById(d.g.pb_item_first_floor_location_address);
        this.hwx = (TextView) this.hwg.findViewById(d.g.point_between_time_and_locate);
        this.hyj = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hyk = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hwD = this.hvZ.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.hwE = this.hvZ.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.hvZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hxr = (ViewStub) this.eCz.findViewById(d.g.interview_status_stub);
        this.hwy = this.hwc.findViewById(d.g.blank_view_align_user_item_top);
        this.hwz = this.hwc.findViewById(d.g.blank_view_align_user_item_bottom);
        this.hwH = new f(this.hpd, this.hvY);
        this.hwH.x(this.faZ);
        this.hwH.setTbGestureDetector(this.cbY);
        this.hwH.setOnImageClickListener(this.cAE);
        this.hpC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.35
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
                            aq.this.hpd.c(sparseArray);
                            return;
                        }
                        aq.this.cs(view);
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        aq.this.hpd.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hwH.J(this.hpC);
        bMA();
        this.hvY.addHeaderView(this.hwc);
        this.hvY.addHeaderView(this.hwa);
        this.hvY.addHeaderView(this.hvZ);
        this.ffg = new PbListView(this.hpd.getPageContext().getPageActivity());
        this.cpF = this.ffg.getView().findViewById(d.g.pb_more_view);
        if (this.cpF != null) {
            this.cpF.setOnClickListener(this.faZ);
            com.baidu.tbadk.core.util.al.k(this.cpF, d.f.pb_foot_more_trans_selector);
        }
        this.ffg.aey();
        this.ffg.hZ(d.f.pb_foot_more_trans_selector);
        this.ffg.ib(d.f.pb_foot_more_trans_selector);
        this.hwN = this.hpd.findViewById(d.g.viewstub_progress);
        this.hpd.registerListener(this.hyq);
        this.hwo = com.baidu.tbadk.ala.b.UK().n(this.hpd.getActivity(), 2);
        if (this.hwo != null) {
            this.hwo.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.hpd.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.hwo.getParent() == null) {
                this.hwp.addView(this.hwo, aVar);
            }
        }
        this.hro = new PbFakeFloorModel(this.hpd.getPageContext());
        this.hxN = new s(this.hpd.getPageContext(), this.hro, this.eCz);
        this.hxN.a(this.hpd.hoe);
        this.hro.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.36
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hro.o(postData);
                aq.this.hwH.notifyDataSetChanged();
                aq.this.hxN.bKF();
                aq.this.VM.akq();
                aq.this.nU(false);
            }
        });
        if (this.hpd.bJb() != null && !StringUtils.isNull(this.hpd.bJb().bLz())) {
            this.hpd.showToast(this.hpd.bJb().bLz());
        }
        this.hxw = this.hpd.findViewById(d.g.pb_expand_blank_view);
        this.hxx = this.hpd.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hxx.getLayoutParams();
        if (this.hpd.bJb() != null && this.hpd.bJb().bKV()) {
            this.hxw.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hxx.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hxz;
            this.hxx.setLayoutParams(layoutParams2);
        }
        this.hxy = new al(this.hpd.getPageContext(), this.hpd.findViewById(d.g.pb_reply_expand_view));
        this.hxy.hvs.setVisibility(8);
        this.hxy.L(this.faZ);
        this.hpd.registerListener(this.dgB);
        this.hpd.registerListener(this.hym);
        this.hpd.registerListener(this.hyn);
        bMw();
        nO(false);
    }

    public void bnn() {
        if (!this.hpd.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 2).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.hpd.bJy()) {
            com.baidu.tbadk.editortools.pb.d bJn = this.hpd.bJn();
            if (bJn != null && (bJn.amG() || bJn.amH())) {
                this.hpd.bJn().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.VM != null) {
                bMF();
            }
            if (this.VM != null) {
                this.hxk = false;
                if (this.VM.jw(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hpd, (View) this.VM.jw(2).ciu, false, hyh);
                }
            }
            bNj();
        }
    }

    private void bMw() {
        this.hyc = new com.baidu.tieba.pb.pb.godreply.a(this.hpd, this, (ViewStub) this.eCz.findViewById(d.g.more_god_reply_popup));
        this.hyc.t(this.faZ);
        this.hyc.J(this.hpC);
        this.hyc.setOnImageClickListener(this.cAE);
        this.hyc.t(this.faZ);
        this.hyc.setTbGestureDetector(this.cbY);
    }

    public com.baidu.tieba.pb.pb.godreply.a bMx() {
        return this.hyc;
    }

    public View bMy() {
        return this.hxw;
    }

    public void bMz() {
        if (this.hvY != null) {
            this.hvY.removeHeaderView(this.hwa);
            this.hvY.removeHeaderView(this.hwc);
            this.hvY.removeHeaderView(this.hvZ);
        }
    }

    private void bMA() {
        if (this.hwa == null) {
            this.hwa = (RelativeLayout) LayoutInflater.from(this.hpd).inflate(d.h.new_pb_title, (ViewGroup) null);
            this.hwe = (ImageView) this.hwa.findViewById(d.g.pb_thread_type_stamp_title_bottom_part);
            this.hwe.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(d.e.tbds194));
            this.hwe.setImageMatrix(matrix);
            this.hwb = (TextView) this.hwa.findViewById(d.g.tv_pb_title);
            this.hwb.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_link_tip_c));
            this.hwb.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hwb.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.al.j(this.hwb, d.C0236d.cp_cont_b);
            this.hwb.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hwb.setVisibility(8);
            if (this.hwb.getParent() == null) {
                this.hwa.addView(this.hwb);
            }
            this.hwa.setOnTouchListener(this.cbY);
            this.hwa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMB() {
        if (this.hpd.bJQ()) {
            this.hvX = (ViewStub) this.hpd.findViewById(d.g.manga_mention_controller_view_stub);
            this.hvX.setVisibility(0);
            if (this.hwA == null) {
                this.hwA = (LinearLayout) this.hpd.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.hpd.getPageContext(), this.hwA);
            }
            if (this.hwB == null) {
                this.hwB = (TextView) this.hwA.findViewById(d.g.manga_prev_btn);
            }
            if (this.hwC == null) {
                this.hwC = (TextView) this.hwA.findViewById(d.g.manga_next_btn);
            }
            this.hwB.setOnClickListener(this.faZ);
            this.hwC.setOnClickListener(this.faZ);
        }
    }

    private void bMC() {
        if (this.hpd.bJQ()) {
            if (this.hpd.bJT() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwB, d.C0236d.cp_cont_e, 1);
            }
            if (this.hpd.bJU() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwC, d.C0236d.cp_cont_e, 1);
            }
        }
    }

    public void bMD() {
        if (this.hwA == null) {
            bMB();
        }
        this.hvX.setVisibility(8);
        if (this.hyo != null && this.hyp != null) {
            this.hyo.removeCallbacks(this.hyp);
        }
    }

    public void bME() {
        if (this.hyo != null) {
            if (this.hyp != null) {
                this.hyo.removeCallbacks(this.hyp);
            }
            this.hyp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hwA == null) {
                        aq.this.bMB();
                    }
                    aq.this.hvX.setVisibility(0);
                }
            };
            this.hyo.postDelayed(this.hyp, 2000L);
        }
    }

    public void nM(boolean z) {
        this.hvU.nM(z);
        if (z && this.hxo) {
            this.ffg.setText(this.hpd.getResources().getString(d.j.click_load_more));
            this.hvY.setNextPage(this.ffg);
            this.hvT = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.VM = editorTools;
        this.VM.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.VM.getParent() == null) {
            this.eCz.addView(this.VM, layoutParams);
        }
        this.VM.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.VM.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).agt() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).agt() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.adQ();
                        aq.this.mPermissionJudgePolicy.e(aq.this.hpd, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.Y(aq.this.hpd)) {
                            aq.this.hpd.bJn().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hpd.bJn().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bMn();
        this.hpd.bJn().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.VM != null && aq.this.VM.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hyb == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.VM.getId());
                            aq.this.hyb = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hpd.getPageContext(), aq.this.eCz, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.T(aq.this.hya)) {
                                aq.this.hyb.setData(aq.this.hya);
                            }
                            aq.this.hyb.b(aq.this.VM);
                        }
                        aq.this.hyb.Ag(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hpd.hni != null && aq.this.hpd.hni.bNz() != null) {
                    if (!aq.this.hpd.hni.bNz().cnY()) {
                        aq.this.hpd.hni.nZ(false);
                    }
                    aq.this.hpd.hni.bNz().qV(false);
                }
            }
        });
    }

    public void bMF() {
        if (this.hpd != null && this.VM != null) {
            this.VM.qT();
            if (this.hpd.bJn() != null) {
                this.hpd.bJn().amx();
            }
            bNj();
        }
    }

    public void nN(boolean z) {
        if (this.hvY != null && this.ahH != null && this.fbm != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fbm.setVisibility(0);
                } else {
                    this.fbm.setVisibility(8);
                    this.hvY.removeHeaderView(this.ahH);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ahH.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hxz;
                    this.ahH.setLayoutParams(layoutParams);
                }
                bMT();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ahH.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + nW(true);
                this.ahH.setLayoutParams(layoutParams2);
            }
            bMT();
            bNr();
        }
    }

    public f bMG() {
        return this.hwH;
    }

    public void a(PbActivity.d dVar) {
        this.hoi = dVar;
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
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hpd);
        iVar.setTitleText(this.hpd.getString(d.j.bar_manager));
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwP.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hyr != null) {
                                aq.this.hyr.m(new Object[]{sparseArray2.get(d.g.tag_manage_user_identity), sparseArray2.get(d.g.tag_forbid_user_name), sparseArray2.get(d.g.tag_forbid_user_post_id), sparseArray2.get(d.g.tag_forbid_user_name_show), sparseArray2.get(d.g.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hpd.a(z, (String) sparseArray2.get(d.g.tag_user_mute_mute_userid), sparseArray2);
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
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hpd.getString(d.j.delete_post), iVar);
            } else {
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hpd.getString(d.j.delete), iVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
            sparseArray2.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
            sparseArray2.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
            sparseArray2.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            fVar2.mTextView.setTag(sparseArray2);
            arrayList.add(fVar2);
        }
        if ((!"".equals(sparseArray.get(d.g.tag_forbid_user_name)) || !"".equals(sparseArray.get(d.g.tag_forbid_user_name_show))) && !bNq()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray3.put(d.g.tag_forbid_user_name_show, sparseArray.get(d.g.tag_forbid_user_name_show));
            sparseArray3.put(d.g.tag_forbid_user_portrait, sparseArray.get(d.g.tag_forbid_user_portrait));
            sparseArray3.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray3.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(1, this.hpd.getString(d.j.forbidden_person), iVar);
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
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hpd.getString(d.j.un_mute), iVar);
            } else {
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hpd.getString(d.j.mute), iVar);
            }
            fVar.mTextView.setTag(sparseArray4);
            arrayList.add(fVar);
        }
        iVar.P(arrayList);
        if (this.hwP == null) {
            this.hwP = new com.baidu.tbadk.core.dialog.g(this.hpd.getPageContext(), iVar.abk());
        } else {
            this.hwP.setContentView(iVar.abk());
        }
        this.hwP.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hyr = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hpd != null && aVar != null) {
            if (this.fzE == null) {
                this.fzE = new com.baidu.tieba.NEGFeedBack.e(this.hpd.getPageContext(), this.hvZ);
            }
            AntiData bbJ = this.hpd.bbJ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bbJ != null && bbJ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbJ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.b(sparseArray);
            this.fzE.setDefaultReasonArray(new String[]{this.hpd.getString(d.j.delete_thread_reason_1), this.hpd.getString(d.j.delete_thread_reason_2), this.hpd.getString(d.j.delete_thread_reason_3), this.hpd.getString(d.j.delete_thread_reason_4), this.hpd.getString(d.j.delete_thread_reason_5)});
            this.fzE.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fzE.qk(str);
            this.fzE.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray) {
                    aq.this.hpd.a(aVar, jSONArray);
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
        sparseArray.put(hxG, Integer.valueOf(hxH));
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
        this.hwR = new com.baidu.tbadk.core.dialog.a(this.hpd.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hwR.gD(i3);
        } else {
            this.hwR.dv(false);
            this.hwR.ly(str2);
        }
        this.hwR.ab(sparseArray);
        this.hwR.a(d.j.dialog_ok, this.hpd);
        this.hwR.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwR.dq(true);
        this.hwR.b(this.hpd.getPageContext());
        if (z) {
            this.hwR.aaZ();
        } else {
            a(this.hwR, i);
        }
    }

    public void at(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hwU == null) {
            this.hwU = LayoutInflater.from(this.hpd.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.hpd.getLayoutMode().onModeChanged(this.hwU);
        if (this.hwT == null) {
            this.hwT = new Dialog(this.hpd.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hwT.setCanceledOnTouchOutside(true);
            this.hwT.setCancelable(true);
            this.hxc = (ScrollView) this.hwU.findViewById(d.g.good_scroll);
            this.hwT.setContentView(this.hwU);
            WindowManager.LayoutParams attributes = this.hwT.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.hpd.getPageContext().getPageActivity(), d.e.ds540);
            this.hwT.getWindow().setAttributes(attributes);
            this.eky = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hwY = (String) compoundButton.getTag();
                        if (aq.this.ekx != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.ekx) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hwY != null && !str.equals(aq.this.hwY)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hwV = (LinearLayout) this.hwU.findViewById(d.g.good_class_group);
            this.hwX = (TextView) this.hwU.findViewById(d.g.dialog_button_cancel);
            this.hwX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hwT instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hwT, aq.this.hpd.getPageContext());
                    }
                }
            });
            this.hwW = (TextView) this.hwU.findViewById(d.g.dialog_button_ok);
            this.hwW.setOnClickListener(this.faZ);
        }
        this.hwV.removeAllViews();
        this.ekx = new ArrayList();
        CustomBlueCheckRadioButton dz = dz("0", this.hpd.getPageContext().getString(d.j.thread_good_class));
        this.ekx.add(dz);
        dz.setChecked(true);
        this.hwV.addView(dz);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.Xr()) && acVar.Xs() > 0) {
                    CustomBlueCheckRadioButton dz2 = dz(String.valueOf(acVar.Xs()), acVar.Xr());
                    this.ekx.add(dz2);
                    View view = new View(this.hpd.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.hpd.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.al.l(view, d.C0236d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hwV.addView(view);
                    this.hwV.addView(dz2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hxc.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hpd.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hpd.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hpd.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hxc.setLayoutParams(layoutParams2);
            this.hxc.removeAllViews();
            if (this.hwV != null && this.hwV.getParent() == null) {
                this.hxc.addView(this.hwV);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hwT, this.hpd.getPageContext());
    }

    private CustomBlueCheckRadioButton dz(String str, String str2) {
        Activity pageActivity = this.hpd.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.eky);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bMH() {
        this.hpd.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hpd.hideProgressBar();
        if (z && z2) {
            this.hpd.showToast(this.hpd.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.hpd.showToast(str);
        }
    }

    public void bup() {
        this.hwN.setVisibility(0);
    }

    public void buo() {
        this.hwN.setVisibility(8);
    }

    public View bMI() {
        if (this.hwU != null) {
            return this.hwU.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bMJ() {
        return this.hwY;
    }

    public View getView() {
        return this.eCz;
    }

    public void bMK() {
        com.baidu.adp.lib.util.l.b(this.hpd.getPageContext().getPageActivity(), this.hpd.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hpd.hideProgressBar();
        if (z) {
            bNa();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bNb();
        } else {
            bNa();
        }
    }

    public void bML() {
        this.ffg.aey();
        this.ffg.aeC();
    }

    public void bMM() {
        this.hpd.hideProgressBar();
        aeD();
        this.hvY.completePullRefreshPostDelayed(0L);
        bMX();
    }

    public void bMN() {
        this.hvY.completePullRefreshPostDelayed(0L);
        bMX();
    }

    private void nO(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hwH.setOnLongClickListener(onLongClickListener);
        if (this.hyc != null) {
            this.hyc.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0191b interfaceC0191b, boolean z, boolean z2) {
        if (this.hnj != null) {
            this.hnj.dismiss();
            this.hnj = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hpd);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hpd.getPageContext().getString(d.j.copy), iVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hpd.getPageContext().getString(d.j.report_text), iVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hpd.getPageContext().getString(d.j.mark), iVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hpd.getPageContext().getString(d.j.remove_mark), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwZ.dismiss();
                interfaceC0191b.a(null, i, view);
            }
        });
        this.hwZ = new com.baidu.tbadk.core.dialog.g(this.hpd.getPageContext(), iVar.abk());
        this.hwZ.showDialog();
    }

    public void a(final b.InterfaceC0191b interfaceC0191b, boolean z) {
        if (this.hwZ != null) {
            this.hwZ.dismiss();
            this.hwZ = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hpd);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hpd.getPageContext().getString(d.j.save_to_emotion), iVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hpd.getPageContext().getString(d.j.save_to_local), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwZ.dismiss();
                interfaceC0191b.a(null, i, view);
            }
        });
        this.hwZ = new com.baidu.tbadk.core.dialog.g(this.hpd.getPageContext(), iVar.abk());
        this.hwZ.showDialog();
    }

    public int bMO() {
        return wy(this.hvY.getFirstVisiblePosition());
    }

    private int wy(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hvY.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hvY.getAdapter() == null || !(this.hvY.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hvY.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bMP() {
        int lastVisiblePosition = this.hvY.getLastVisiblePosition();
        if (this.hvO != null) {
            if (lastVisiblePosition == this.hvY.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return wy(lastVisiblePosition);
    }

    public void wz(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.hvY != null) {
            if (this.hvU == null || this.hvU.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hvU.mNavigationBar.getFixedNavHeight();
                if (!(this.hpd.bJE() != -1)) {
                    if (this.hxx != null && (layoutParams = (LinearLayout.LayoutParams) this.hxx.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hxx.setLayoutParams(layoutParams);
                    }
                    i--;
                    bNv();
                }
                i2 = fixedNavHeight;
            }
            this.hvY.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hvY.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hvY.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hwK.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hwH.a(dVar, false);
        this.hwH.notifyDataSetChanged();
        bMX();
        if (this.hyc != null) {
            this.hyc.bIX();
        }
        ArrayList<PostData> bIc = dVar.bIc();
        if (dVar.getPage().XK() == 0 || bIc == null || bIc.size() < dVar.getPage().XJ()) {
            if (com.baidu.tbadk.core.util.v.S(bIc) == 0 || (com.baidu.tbadk.core.util.v.S(bIc) == 1 && bIc.get(0) != null && bIc.get(0).cer() == 1)) {
                if (this.hxC == null || this.hxC.hyL == null || this.hxC.hyL.getView() == null) {
                    i = 0;
                } else {
                    i = this.hxC.hyL.getView().getTop() < 0 ? this.hxC.hyL.getView().getHeight() : this.hxC.hyL.getView().getBottom();
                }
                if (this.hpd.bKc()) {
                    this.ffg.aa(this.hpd.getResources().getString(d.j.pb_no_host_reply), i);
                } else {
                    this.ffg.aa(this.hpd.getResources().getString(d.j.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().XK() == 0) {
                    this.ffg.setText(this.hpd.getResources().getString(d.j.list_has_no_more));
                } else {
                    this.ffg.setText(this.hpd.getResources().getString(d.j.load_more));
                }
                this.ffg.aeH();
            }
        }
        q(dVar);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (this.hwq == null) {
            this.hpd.getLayoutMode().onModeChanged(((ViewStub) this.hvZ.findViewById(d.g.praise_layout)).inflate());
            this.hwq = (FrsPraiseView) this.hvZ.findViewById(d.g.pb_head_praise_view);
            this.hwq.setIsFromPb(true);
            this.hwF = this.hvZ.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.hwq.ij(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hwq != null) {
            boolean bMX = bMX();
            this.hwq.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().XL() == 0 && this.hpu) {
                if (bMX) {
                    this.hwE.setVisibility(0);
                    return;
                } else {
                    this.hwE.setVisibility(8);
                    return;
                }
            }
            this.hwE.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bIk() != null) {
            return dVar.bIk();
        }
        if (!com.baidu.tbadk.core.util.v.T(dVar.bIc())) {
            Iterator<PostData> it = dVar.bIc().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cer() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bIh();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.YR() != null && postData.YR().getUserTbVipInfoData() != null && postData.YR().getUserTbVipInfoData().getvipIntro() != null) {
            postData.YR().getGodUserData().setIntro(postData.YR().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bIa() == null || dVar.bIa().YR() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData YR = dVar.bIa().YR();
        String userId = YR.getUserId();
        HashMap<String, MetaData> userMap = dVar.bIa().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = YR;
        }
        postData.zu(1);
        postData.setId(dVar.bIa().Zh());
        postData.setTitle(dVar.bIa().getTitle());
        postData.setTime(dVar.bIa().getCreateTime());
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
    /* JADX WARN: Removed duplicated region for block: B:141:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x05e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x07b8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0811  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x034a  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        String g;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.f ceu;
        String portrait;
        if (dVar != null && dVar.bIa() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hwg.setVisibility(8);
            if (dVar.bIa() != null && dVar.bIa().ZL() && dVar.bIa().Zi() != null) {
                this.hxR = true;
                this.hvU.oj(this.hxR);
                this.hvU.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1") && com.baidu.adp.lib.util.l.aQ(this.hpd) < this.eCz.getHeight()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eCz.getLayoutParams();
                    layoutParams.height = com.baidu.adp.lib.util.l.aQ(this.hpd);
                    this.eCz.setLayoutParams(layoutParams);
                }
                if (this.hvO == null) {
                    this.hvO = new com.baidu.tieba.pb.video.i(this.hpd, this.hvU, dVar.bIa().Zi(), this.hvP);
                    this.hvO.a(dVar.bIa().Zi(), dVar.bIa(), dVar.getForumId());
                    this.hvO.startPlay();
                } else if (this.hvS) {
                    this.hvO.a(dVar.bIa().Zi(), dVar.bIa(), dVar.getForumId());
                    this.hvO.startPlay();
                } else {
                    this.hvO.As(dVar.getForumId());
                }
                if (dVar.bIb() != null && dVar.bIb().size() >= 1) {
                    bg bgVar = dVar.bIb().get(0);
                    this.hvO.aE(bgVar);
                    this.hvO.At(bgVar.getTitle());
                }
                this.hvO.b(c, dVar.bIa(), dVar.bIx());
                this.hvS = false;
                this.hvY.removeHeaderView(this.hvO.bPm());
                this.hvY.addHeaderView(this.hvO.bPm(), 0);
                if (this.hvO.aBD() != null && this.hvO.aBD().getParent() == null) {
                    this.hxv.addView(this.hvO.aBD());
                }
                if (this.hvQ == null) {
                    this.hvQ = new com.baidu.tieba.pb.video.h(this.hpd);
                }
                this.hvQ.a(dVar.bIa().aab(), dVar.bIa(), dVar.bIu());
                this.hvY.removeHeaderView(this.hvQ.bPb());
                this.hvY.addHeaderView(this.hvQ.bPb(), 1);
                if (dVar.bIa().aab() != null) {
                    this.hvY.removeHeaderView(this.hvQ.bPc());
                    this.hvY.removeHeaderView(this.hwc);
                    this.hvY.addHeaderView(this.hvQ.bPc(), 2);
                } else {
                    if (this.hvQ.bPc() != null) {
                        this.hvY.removeHeaderView(this.hvQ.bPc());
                    }
                    this.hvY.removeHeaderView(this.hwc);
                    this.hvY.addHeaderView(this.hwc, 2);
                }
                if (this.hvO != null) {
                    this.hvU.of(false);
                    this.hvO.wG(TbadkCoreApplication.getInst().getSkinType());
                }
                bMT();
            } else {
                this.hxR = false;
                this.hvU.oj(this.hxR);
                if (this.hvO != null) {
                    this.hvY.removeHeaderView(this.hvO.bPm());
                }
                if (this.hvQ != null) {
                    this.hvQ.b(this.hvY);
                }
            }
            if (this.hpd.bJq() != null) {
                this.hpd.bJq().od(this.hxR);
            }
            if (this.hvO != null) {
                this.hvO.N(this.hyt);
                bNv();
            }
            if (c != null) {
                this.hxn = c;
                this.hwg.setVisibility(0);
                if (this.hpd.bIR()) {
                    if (dVar.bHZ() != null) {
                        this.mForumName = dVar.bHZ().getForumName();
                        this.mForumId = dVar.bHZ().getForumId();
                    }
                    if (this.mForumName == null && this.hpd.bJb() != null && this.hpd.bJb().bIS() != null) {
                        this.mForumName = this.hpd.bJb().bIS();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hwg.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hwg.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, c);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.hyi) {
                    this.hwa.setVisibility(0);
                }
                if (!dVar.bIa().ZL() && this.hwb.getText() != null && this.hwb.getText().length() > 0) {
                    this.hwb.setVisibility(0);
                } else {
                    this.hwb.setVisibility(8);
                }
                p(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> Zc = dVar.bIa().Zc();
                if (Zc != null && Zc.size() > 0 && !this.hyi) {
                    this.hxq.setText(String.valueOf(Zc.get(0).WY()));
                    this.hxp.setVisibility(0);
                } else {
                    this.hxp.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.k(this.hxp, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.d(this.hxq, d.C0236d.cp_link_tip_d, 1);
                if (c.YR() != null) {
                    String string = c.YR().getName_show() == null ? StringUtils.string(c.YR().getUserName()) : StringUtils.string(c.YR().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(c.YR().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bz(c.YR().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bz(string) > 12) {
                            g = com.baidu.tbadk.core.util.ap.g(string, 12, "...");
                            ArrayList<IconData> iconInfo = c.YR().getIconInfo();
                            tShowInfoNew = c.YR().getTShowInfoNew();
                            if (this.hqr != null) {
                                this.hqr.setTag(d.g.tag_user_id, c.YR().getUserId());
                                this.hqr.setOnClickListener(this.hpd.hne.hAl);
                                this.hqr.a(iconInfo, 4, this.hpd.getResources().getDimensionPixelSize(d.e.tbds36), this.hpd.getResources().getDimensionPixelSize(d.e.tbds36), this.hpd.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.hqq != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hqq.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hqq.setOnClickListener(this.hpd.hne.hAm);
                                this.hqq.a(tShowInfoNew, 3, this.hpd.getResources().getDimensionPixelSize(d.e.tbds36), this.hpd.getResources().getDimensionPixelSize(d.e.tbds36), this.hpd.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.hwi.setText(bN(c.YR().getSealPrefix(), g));
                            this.hwi.setTag(d.g.tag_user_id, c.YR().getUserId());
                            this.hwi.setTag(d.g.tag_user_name, c.YR().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew) || c.YR().isBigV()) {
                                com.baidu.tbadk.core.util.al.d(this.hwi, d.C0236d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.d(this.hwi, d.C0236d.cp_cont_b, 1);
                            }
                            if (c.YR() == null) {
                                MetaData YR = c.YR();
                                if (YR.getIs_bawu() == 1 && "manager".equals(YR.getBawu_type())) {
                                    this.hwj.setText(d.j.bawu_member_bazhu_tip);
                                    this.hwj.setVisibility(0);
                                } else if (YR.getIs_bawu() == 1 && "assist".equals(YR.getBawu_type())) {
                                    this.hwj.setText(d.j.bawu_member_xbazhu_tip);
                                    this.hwj.setVisibility(0);
                                } else {
                                    this.hwj.setVisibility(8);
                                }
                            } else {
                                this.hwj.setVisibility(8);
                            }
                            if (dVar.bIa().YR() != null && dVar.bIa().YR().getAlaUserData() != null && this.hwo != null) {
                                if (dVar.bIa().YR().getAlaUserData().anchor_live != 0) {
                                    this.hwo.setVisibility(8);
                                } else {
                                    this.hwo.setVisibility(0);
                                    if (this.hvR == null) {
                                        this.hvR = new com.baidu.tieba.c.d(this.hpd.getPageContext(), this.hwo);
                                        this.hvR.oM(1);
                                    }
                                    this.hvR.cu(this.hpd.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bsI = dVar.bIa().YR().getAlaUserData();
                                    aVar.type = 2;
                                    this.hwo.setTag(aVar);
                                }
                            }
                            this.hwn.setUserId(c.YR().getUserId());
                            this.hwn.setUserName(c.YR().getUserName());
                            this.hwn.setTid(c.getId());
                            this.hwn.setFid(this.hsw == null ? this.hsw.getForumId() : "");
                            this.hwn.setImageDrawable(null);
                            this.hwn.setRadius(com.baidu.adp.lib.util.l.h(this.hpd.getActivity(), d.e.ds40));
                            this.hwn.setTag(c.YR().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hwv.setText(com.baidu.tbadk.core.util.ap.aq(c.getTime()));
                            } else {
                                this.hwv.setText(com.baidu.tbadk.core.util.ap.ao(c.getTime()));
                            }
                            ceu = c.ceu();
                            if (ceu == null && !TextUtils.isEmpty(ceu.getName()) && !TextUtils.isEmpty(ceu.getName().trim())) {
                                final String name = ceu.getName();
                                final String lat = ceu.getLat();
                                final String lng = ceu.getLng();
                                this.hww.setVisibility(0);
                                this.hwx.setVisibility(0);
                                this.hww.setText(ceu.getName());
                                this.hww.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kY()) {
                                                aq.this.hpd.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ar(aq.this.hpd.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, aq.this.hpd.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.hww.setVisibility(8);
                                this.hwx.setVisibility(8);
                            }
                            portrait = c.YR().getPortrait();
                            if (c.YR().getPendantData() == null && !StringUtils.isNull(c.YR().getPendantData().Xn())) {
                                this.hwl.b(c.YR());
                                this.hwn.setVisibility(8);
                                this.hwl.setVisibility(0);
                                if (this.hwr != null) {
                                    this.hwr.setVisibility(8);
                                }
                                this.hwi.setOnClickListener(this.hyt);
                                this.hwl.getHeadView().startLoad(portrait, 28, false);
                                this.hwl.getHeadView().setUserId(c.YR().getUserId());
                                this.hwl.getHeadView().setUserName(c.YR().getUserName());
                                this.hwl.getHeadView().setTid(c.getId());
                                this.hwl.getHeadView().setFid(this.hsw != null ? this.hsw.getForumId() : "");
                                this.hwl.getHeadView().setOnClickListener(this.hyt);
                                this.hwl.nm(c.YR().getPendantData().Xn());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hwn, c.YR());
                                this.hwn.setVisibility(0);
                                this.hwg.setOnClickListener(this.hyt);
                                this.hwi.setOnClickListener(this.hyt);
                                this.hwn.setOnClickListener(this.hyt);
                                this.hwl.setVisibility(8);
                                this.hwn.startLoad(portrait, 28, false);
                            }
                            String name_show = c.YR().getName_show();
                            String userName = c.YR().getUserName();
                            if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                                this.hwi.setText(com.baidu.tieba.pb.c.aQ(this.hpd.getPageContext().getPageActivity(), this.hwi.getText().toString()));
                                this.hwi.setGravity(16);
                                this.hwi.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHL());
                                com.baidu.tbadk.core.util.al.d(this.hwi, d.C0236d.cp_other_e, 1);
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo2 = c.YR().getIconInfo();
                        tShowInfoNew = c.YR().getTShowInfoNew();
                        if (this.hqr != null) {
                        }
                        if (this.hqq != null) {
                        }
                        this.hwi.setText(bN(c.YR().getSealPrefix(), g));
                        this.hwi.setTag(d.g.tag_user_id, c.YR().getUserId());
                        this.hwi.setTag(d.g.tag_user_name, c.YR().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hwi, d.C0236d.cp_cont_h, 1);
                        if (c.YR() == null) {
                        }
                        if (dVar.bIa().YR() != null) {
                            if (dVar.bIa().YR().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hwn.setUserId(c.YR().getUserId());
                        this.hwn.setUserName(c.YR().getUserName());
                        this.hwn.setTid(c.getId());
                        this.hwn.setFid(this.hsw == null ? this.hsw.getForumId() : "");
                        this.hwn.setImageDrawable(null);
                        this.hwn.setRadius(com.baidu.adp.lib.util.l.h(this.hpd.getActivity(), d.e.ds40));
                        this.hwn.setTag(c.YR().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        ceu = c.ceu();
                        if (ceu == null) {
                        }
                        this.hww.setVisibility(8);
                        this.hwx.setVisibility(8);
                        portrait = c.YR().getPortrait();
                        if (c.YR().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hwn, c.YR());
                        this.hwn.setVisibility(0);
                        this.hwg.setOnClickListener(this.hyt);
                        this.hwi.setOnClickListener(this.hyt);
                        this.hwn.setOnClickListener(this.hyt);
                        this.hwl.setVisibility(8);
                        this.hwn.startLoad(portrait, 28, false);
                        String name_show2 = c.YR().getName_show();
                        String userName2 = c.YR().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                            this.hwi.setText(com.baidu.tieba.pb.c.aQ(this.hpd.getPageContext().getPageActivity(), this.hwi.getText().toString()));
                            this.hwi.setGravity(16);
                            this.hwi.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHL());
                            com.baidu.tbadk.core.util.al.d(this.hwi, d.C0236d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            g = com.baidu.tbadk.core.util.ap.g(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.YR().getIconInfo();
                            tShowInfoNew = c.YR().getTShowInfoNew();
                            if (this.hqr != null) {
                            }
                            if (this.hqq != null) {
                            }
                            this.hwi.setText(bN(c.YR().getSealPrefix(), g));
                            this.hwi.setTag(d.g.tag_user_id, c.YR().getUserId());
                            this.hwi.setTag(d.g.tag_user_name, c.YR().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.d(this.hwi, d.C0236d.cp_cont_h, 1);
                            if (c.YR() == null) {
                            }
                            if (dVar.bIa().YR() != null) {
                            }
                            this.hwn.setUserId(c.YR().getUserId());
                            this.hwn.setUserName(c.YR().getUserName());
                            this.hwn.setTid(c.getId());
                            this.hwn.setFid(this.hsw == null ? this.hsw.getForumId() : "");
                            this.hwn.setImageDrawable(null);
                            this.hwn.setRadius(com.baidu.adp.lib.util.l.h(this.hpd.getActivity(), d.e.ds40));
                            this.hwn.setTag(c.YR().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            ceu = c.ceu();
                            if (ceu == null) {
                            }
                            this.hww.setVisibility(8);
                            this.hwx.setVisibility(8);
                            portrait = c.YR().getPortrait();
                            if (c.YR().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hwn, c.YR());
                            this.hwn.setVisibility(0);
                            this.hwg.setOnClickListener(this.hyt);
                            this.hwi.setOnClickListener(this.hyt);
                            this.hwn.setOnClickListener(this.hyt);
                            this.hwl.setVisibility(8);
                            this.hwn.startLoad(portrait, 28, false);
                            String name_show22 = c.YR().getName_show();
                            String userName22 = c.YR().getUserName();
                            if (com.baidu.tbadk.s.ao.jK()) {
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo222 = c.YR().getIconInfo();
                        tShowInfoNew = c.YR().getTShowInfoNew();
                        if (this.hqr != null) {
                        }
                        if (this.hqq != null) {
                        }
                        this.hwi.setText(bN(c.YR().getSealPrefix(), g));
                        this.hwi.setTag(d.g.tag_user_id, c.YR().getUserId());
                        this.hwi.setTag(d.g.tag_user_name, c.YR().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hwi, d.C0236d.cp_cont_h, 1);
                        if (c.YR() == null) {
                        }
                        if (dVar.bIa().YR() != null) {
                        }
                        this.hwn.setUserId(c.YR().getUserId());
                        this.hwn.setUserName(c.YR().getUserName());
                        this.hwn.setTid(c.getId());
                        this.hwn.setFid(this.hsw == null ? this.hsw.getForumId() : "");
                        this.hwn.setImageDrawable(null);
                        this.hwn.setRadius(com.baidu.adp.lib.util.l.h(this.hpd.getActivity(), d.e.ds40));
                        this.hwn.setTag(c.YR().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        ceu = c.ceu();
                        if (ceu == null) {
                        }
                        this.hww.setVisibility(8);
                        this.hwx.setVisibility(8);
                        portrait = c.YR().getPortrait();
                        if (c.YR().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hwn, c.YR());
                        this.hwn.setVisibility(0);
                        this.hwg.setOnClickListener(this.hyt);
                        this.hwi.setOnClickListener(this.hyt);
                        this.hwn.setOnClickListener(this.hyt);
                        this.hwl.setVisibility(8);
                        this.hwn.startLoad(portrait, 28, false);
                        String name_show222 = c.YR().getName_show();
                        String userName222 = c.YR().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hwf.aw(dVar.bIa());
                }
                if (this.hxy != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hkH);
                    if (dVar != null && dVar.bIa() != null) {
                        hVar.hkJ = dVar.bIa().YI();
                    }
                    hVar.isNew = !this.hpu;
                    hVar.sortType = dVar.hkx;
                    if (dVar.hkw != null && dVar.hkw.size() > dVar.hkx) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hkw.size()) {
                                break;
                            } else if (dVar.hkw.get(i4).sort_type.intValue() != dVar.hkx) {
                                i3 = i4 + 1;
                            } else {
                                hVar.hkL = dVar.hkw.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.hkM = this.hpd.bKc();
                    this.hxy.a(hVar);
                }
                if (dVar != null && dVar.bIa() != null) {
                    ab(dVar.bIa().YN() == 1, dVar.bIa().YM() == 1);
                }
                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hwH != null && aq.this.hvU != null && aq.this.hvU.hAX != null && aq.this.hsw != null && aq.this.hsw.bIa() != null && !aq.this.hsw.bIa().ZL() && !aq.this.bMW() && aq.this.hsw.getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(aq.this.hsw.getForum().getName())) {
                            if (aq.this.hwH.bKA() == null || !aq.this.hwH.bKA().isShown()) {
                                aq.this.hvU.hAX.setVisibility(0);
                                if (aq.this.hpd != null && aq.this.hpd.bJb() != null) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13400");
                                    amVar.bJ("tid", aq.this.hpd.bJb().bKS());
                                    amVar.bJ(ImageViewerConfig.FORUM_ID, aq.this.hpd.bJb().getForumId());
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
            bMQ();
        } else {
            aWQ();
        }
        this.hxC.hyL = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxC));
        a(this.hxC.hyL, false);
    }

    public void bMQ() {
        if (this.hvU != null && !this.hxT) {
            this.hvU.ok(!StringUtils.isNull(this.hpd.bJB()));
            this.hxT = true;
        }
    }

    public void aWQ() {
        if (this.hvU != null) {
            this.hvU.bOa();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.Zm() != null) {
            this.hwh.setData(this.hpd.getPageContext(), dVar.bIc().get(0).Zm(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bIa().getId(), this.hpd.bJZ() ? "FRS" : null));
            this.hwg.setPadding(this.hwg.getPaddingLeft(), (int) this.hpd.getResources().getDimension(d.e.ds20), this.hwg.getPaddingRight(), this.hwg.getPaddingBottom());
            return;
        }
        this.hwh.setData(null, null, null);
    }

    public void bMR() {
        if (this.hvO != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").T("obj_type", 1));
            this.hvO.bPk();
            this.hvY.smoothScrollToPosition(0);
        }
    }

    public boolean bMS() {
        return this.hyu;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean ay(bg bgVar) {
        if (bgVar == null || bgVar.YR() == null || bgVar.YR().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.YR().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.hvU.bNY();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hvU.xS(cVar.forumName);
            }
            String string = this.hpd.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.hpd.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.hpd.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.hpd.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hjQ;
            this.hpd.showNetRefreshView(this.eCz, format, null, this.hpd.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.lo()) {
                        ba.adD().c(aq.this.hpd.getPageContext(), new String[]{str2});
                        aq.this.hpd.finish();
                        return;
                    }
                    aq.this.hpd.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bMc;
        Parcelable bMc2;
        if (dVar != null) {
            this.hsw = dVar;
            this.mType = i;
            if (dVar.bIa() != null) {
                this.hxE = dVar.bIa().Yz();
                if (dVar.bIa().getAnchorLevel() != 0) {
                    this.hyu = true;
                }
                this.hxb = ay(dVar.bIa());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            t(dVar);
            this.hxo = false;
            this.hpu = z;
            bMM();
            b(dVar, z, i);
            r(dVar);
            if (this.hyf == null) {
                this.hyf = new ac(this.hpd.getPageContext(), this.bsn);
            }
            this.hyf.zX(dVar.bIf());
            if (this.hpd.bJQ()) {
                if (this.hwL == null) {
                    this.hwL = new com.baidu.tieba.pb.view.c(this.hpd.getPageContext());
                    this.hwL.oM();
                    this.hwL.setListPullRefreshListener(this.bRF);
                }
                this.hvY.setPullRefresh(this.hwL);
                bMT();
                if (this.hwL != null) {
                    this.hwL.ic(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().XL() == 0 && z) {
                this.hvY.setPullRefresh(null);
            } else {
                if (this.hwL == null) {
                    this.hwL = new com.baidu.tieba.pb.view.c(this.hpd.getPageContext());
                    this.hwL.oM();
                    this.hwL.setListPullRefreshListener(this.bRF);
                }
                this.hvY.setPullRefresh(this.hwL);
                bMT();
                if (this.hwL != null) {
                    this.hwL.ic(TbadkCoreApplication.getInst().getSkinType());
                }
                aMF();
            }
            bMX();
            this.hwH.nd(this.hpu);
            this.hwH.ne(false);
            this.hwH.np(i == 5);
            this.hwH.nq(i == 6);
            this.hwH.nr(z2 && this.hys);
            this.hwH.a(dVar, false);
            this.hwH.notifyDataSetChanged();
            if (this.hpd.bIR()) {
                this.hxV = 0;
                PostData c = c(dVar, z);
                if (c != null && c.YR() != null) {
                    this.hxV = c.YR().getLevel_id();
                }
                if (this.hxV > 0) {
                    this.hwk.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.hwk, BitmapHelper.getGradeResourceIdInEnterForum(this.hxV));
                } else {
                    this.hwk.setVisibility(8);
                }
            } else {
                this.hwk.setVisibility(8);
            }
            if (dVar.bIa() != null && dVar.bIa().YD() != null) {
                if (dVar.bIa().YD().getNum() < 1) {
                    this.hpd.getResources().getString(d.j.zan);
                } else {
                    String str = dVar.bIa().YD().getNum() + "";
                }
                if (this.hvN != -1) {
                    dVar.bIa().YD().setIsLike(this.hvN);
                }
            }
            if (this.hpd.isLogin()) {
                this.hvY.setNextPage(this.ffg);
                this.hvT = 2;
                aMF();
            } else {
                this.hxo = true;
                if (dVar.getPage().XK() == 1) {
                    if (this.hwM == null) {
                        this.hwM = new com.baidu.tieba.pb.view.a(this.hpd.getPageContext());
                    }
                    this.hvY.setNextPage(this.hwM);
                } else {
                    this.hvY.setNextPage(this.ffg);
                }
                this.hvT = 3;
            }
            ArrayList<PostData> bIc = dVar.bIc();
            if (dVar.getPage().XK() == 0 || bIc == null || bIc.size() < dVar.getPage().XJ()) {
                if (com.baidu.tbadk.core.util.v.S(bIc) == 0 || (com.baidu.tbadk.core.util.v.S(bIc) == 1 && bIc.get(0) != null && bIc.get(0).cer() == 1)) {
                    if (this.hxC == null || this.hxC.hyL == null || this.hxC.hyL.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hxC.hyL.getView().getTop() < 0 ? this.hxC.hyL.getView().getHeight() : this.hxC.hyL.getView().getBottom();
                    }
                    if (this.hpd.bKc()) {
                        this.ffg.aa(this.hpd.getResources().getString(d.j.pb_no_host_reply), i4);
                    } else {
                        this.ffg.aa(this.hpd.getResources().getString(d.j.pb_no_replay), i4);
                    }
                    if (this.hpd.bJq() != null && !this.hpd.bJq().bNN()) {
                        this.hpd.bJq().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().XK() == 0) {
                        this.ffg.setText(this.hpd.getResources().getString(d.j.list_has_no_more));
                    } else {
                        this.ffg.setText(this.hpd.getResources().getString(d.j.load_more));
                    }
                    this.ffg.aeH();
                }
                bNe();
            } else {
                if (z2) {
                    if (this.hys) {
                        aeD();
                        if (dVar.getPage().XK() != 0) {
                            this.ffg.setText(this.hpd.getResources().getString(d.j.pb_load_more));
                        }
                    } else {
                        this.ffg.aey();
                        this.ffg.showLoading();
                    }
                } else {
                    this.ffg.aey();
                    this.ffg.showLoading();
                }
                this.ffg.aeH();
            }
            switch (i) {
                case 2:
                    this.hvY.setSelection(i2 > 1 ? (((this.hvY.getData() == null && dVar.bIc() == null) ? 0 : (this.hvY.getData().size() - dVar.bIc().size()) + this.hvY.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bMc2 = aj.bMb().bMc()) != null) {
                        this.hvY.onRestoreInstanceState(bMc2);
                        if (com.baidu.tbadk.core.util.v.S(bIc) > 1 && dVar.getPage().XK() > 0) {
                            this.ffg.aeD();
                            this.ffg.setText(this.hpd.getString(d.j.pb_load_more_without_point));
                            this.ffg.aez();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hys = false;
                    break;
                case 5:
                    this.hvY.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bMc = aj.bMb().bMc()) != null) {
                        this.hvY.onRestoreInstanceState(bMc);
                        break;
                    } else {
                        this.hvY.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.hvO != null && this.hvO.aBD() != null) {
                            if (this.hpd.isUseStyleImmersiveSticky()) {
                                this.hvY.setSelectionFromTop((this.hwH.bKv() + this.hvY.getHeaderViewsCount()) - 1, this.hvO.aBD().getHeight() - com.baidu.adp.lib.util.l.r(this.hpd.getPageContext().getPageActivity()));
                            } else {
                                this.hvY.setSelectionFromTop((this.hwH.bKv() + this.hvY.getHeaderViewsCount()) - 1, this.hvO.aBD().getHeight());
                            }
                        } else {
                            this.hvY.setSelection(this.hwH.bKv() + this.hvY.getHeaderViewsCount());
                        }
                    } else {
                        this.hvY.setSelection(i2 > 0 ? ((this.hvY.getData() == null && dVar.bIc() == null) ? 0 : (this.hvY.getData().size() - dVar.bIc().size()) + this.hvY.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.ffg.aeD();
                    this.ffg.setText(this.hpd.getString(d.j.pb_load_more_without_point));
                    this.ffg.aez();
                    break;
            }
            if (this.hxE == hxF && isHost()) {
                bNm();
            }
            if (this.hxP) {
                bMl();
                this.hxP = false;
                if (i3 == 0) {
                    nJ(true);
                }
            }
            if (this.hvQ != null) {
                this.hvQ.aD(dVar.bIa());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hku == 1 || dVar.hkv == 1) {
                if (this.hxW == null) {
                    this.hxW = new PbTopTipView(this.hpd);
                }
                if (dVar.hkv == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hpd.getStType())) {
                    this.hxW.setText(this.hpd.getString(d.j.pb_read_strategy_add_experience));
                    this.hxW.show(this.eCz, this.mSkinType);
                } else if (dVar.hku == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hpd.getStType())) {
                    this.hxW.setText(this.hpd.getString(d.j.pb_read_news_add_experience));
                    this.hxW.show(this.eCz, this.mSkinType);
                }
            }
            q(dVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bIa() != null) {
            if (dVar.Vb()) {
                com.baidu.tbadk.core.util.al.c(this.hxh, d.f.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.al.c(this.hxh, d.f.icon_pb_bottom_collect_n);
            }
            String wA = wA(dVar.bIa().YI());
            this.hxj.M(wA, wA == null);
            this.hxj.setVisibility(0);
        }
    }

    private String wA(int i) {
        if (i == 0) {
            return this.hpd.getString(d.j.pb_comment_red_dot_no_reply);
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

    private void bMT() {
        if (this.hvO != null && this.hvO.aBD() != null) {
            this.hvY.removeHeaderView(this.ahH);
            if (this.mType != 1) {
                this.hvY.removeHeaderView(this.hvO.bPm());
                this.hvY.addHeaderView(this.hvO.bPm(), 0);
                return;
            }
            return;
        }
        if (this.hvO != null) {
            this.hvY.removeHeaderView(this.hvO.bPm());
        }
        this.hvY.removeHeaderView(this.ahH);
        this.hvY.addHeaderView(this.ahH, 0);
    }

    public void nQ(boolean z) {
        this.hxa = z;
    }

    public void aeD() {
        if (this.ffg != null) {
            this.ffg.aez();
            this.ffg.aeD();
        }
        aMF();
    }

    public void aOB() {
        this.hvY.setVisibility(0);
    }

    public void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hxn != null && this.hxn.YR() != null && this.hvU != null) {
            this.hxS = !this.hxR;
            this.hvU.of(this.hxS);
            if (this.hpd.bJq() != null) {
                this.hpd.bJq().oe(this.hxS);
            }
            bMU();
            if (dVar.getForum() != null) {
                this.hvU.dA(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hxS) {
                if (this.hxb) {
                    this.hws.setVisibility(8);
                    this.hwu.setVisibility(0);
                    this.hwu.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIw())));
                }
                if (this.hxx != null) {
                    this.hxx.setVisibility(8);
                }
                if (this.hyd == null) {
                    this.hyd = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hxU) {
                                aq.this.bNl();
                            }
                            aq.this.bMN();
                        }
                    };
                }
                this.hvY.setListViewDragListener(this.hyd);
                return;
            }
            if (this.hxx != null) {
                this.hxx.setVisibility(0);
            }
            if (this.hxb) {
                this.hws.setVisibility(8);
                this.hwu.setVisibility(0);
                this.hwu.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIw())));
            } else if (!PbNormalLikeButtonSwitchStatic.apI() || (this.hxn.YR().hadConcerned() && this.hxn.YR().getGodUserData() != null && this.hxn.YR().getGodUserData().getIsFromNetWork())) {
                this.hws.setVisibility(8);
                this.hwu.setVisibility(8);
            } else {
                this.hwu.setVisibility(8);
            }
            this.hyd = null;
            this.hvY.setListViewDragListener(null);
        }
    }

    private void bMU() {
        String threadId = this.hsw != null ? this.hsw.getThreadId() : "";
        int bMV = bMV();
        if (this.hxS && this.hxn != null && this.hxn.YR() != null) {
            this.hxn.YR().setIsLike(this.hxn.YR().hadConcerned());
        }
        if (this.hwt == null) {
            this.hwt = new ao(this.hpd.getPageContext(), this.hws, 1);
            this.hwt.i(this.hpd.getUniqueId());
            this.hwt.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void dV(boolean z) {
                    if (aq.this.hpd != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hpd, d.j.attention_success);
                    }
                }
            });
        }
        if (this.hxn != null && this.hxn.YR() != null) {
            this.hxn.YR().setIsLike(this.hxn.YR().hadConcerned());
            this.hwt.a(this.hxn.YR());
            this.hwt.setTid(threadId);
        }
        this.hwt.hvJ = this.hxR;
        this.hwt.wx(bMV);
    }

    public int bMV() {
        if (this.hsw == null || this.hsw.bIa() == null) {
            return 0;
        }
        if (this.hsw.bIa().aaj()) {
            return (com.baidu.tbadk.core.util.v.T(this.hsw.bIv()) && (this.hsw.bHZ() == null || StringUtils.isNull(this.hsw.bHZ().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bMW() {
        return this.hsw == null || this.hsw.getForum() == null || "0".equals(this.hsw.getForum().getId()) || "me0407".equals(this.hsw.getForum().getName());
    }

    private boolean bMX() {
        boolean z;
        if (this.hxe != null && this.hxe.getVisibility() == 0) {
            if (this.hwD != null) {
                this.hwD.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hwD != null) {
                this.hwD.setVisibility(8);
            }
            z = false;
        }
        if ((this.hwF == null || this.hwF.getVisibility() == 8) && z && this.hpu) {
            this.hwE.setVisibility(0);
        } else {
            this.hwE.setVisibility(8);
        }
        return z;
    }

    private boolean s(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bIa() == null) {
            return false;
        }
        if (dVar.bIa().YO() == 1 || dVar.bIa().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bIa().YQ() == null || dVar.bIa().YQ().aaO() == 0) || dVar.bIa().YM() == 1 || dVar.bIa().YN() == 1 || dVar.bIa().ZC() || dVar.bIa().ZR() || dVar.bIa().ZK() || dVar.bIa().Zd() != null || !com.baidu.tbadk.core.util.ap.isEmpty(dVar.bIa().getCategory()) || dVar.bIa().YU() || dVar.bIa().YT();
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hpd.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hwa != null) {
                if (dVar.bIa() != null && dVar.bIa().Zg() == 0 && !dVar.bIa().ZL() && !this.hyi) {
                    this.hwa.setVisibility(0);
                    if (dVar.bIa() != null) {
                        bg bIa = dVar.bIa();
                        bIa.k(true, s(dVar));
                        bIa.setResource(3);
                        bIa.li("2");
                    }
                    SpannableStringBuilder Zx = dVar.bIa().Zx();
                    this.hwb.setOnTouchListener(new com.baidu.tieba.view.k(Zx));
                    this.hwb.setText(Zx);
                    this.hwb.setVisibility(0);
                } else if (dVar.bIa().Zg() == 1) {
                    if (dVar.bIa() != null) {
                        this.hwa.setVisibility(8);
                        this.hvY.removeHeaderView(this.hwa);
                    }
                } else {
                    this.hwa.setVisibility(8);
                    this.hvY.removeHeaderView(this.hwa);
                    if (dVar.bIa() != null && dVar.bIa().ZL()) {
                        this.hwg.setPadding(this.hwg.getPaddingLeft(), 0, this.hwg.getPaddingRight(), this.hwg.getPaddingBottom());
                        if (this.hwy != null) {
                            ((RelativeLayout.LayoutParams) this.hwy.getLayoutParams()).height = (int) this.hpd.getResources().getDimension(d.e.tbds36);
                            this.hwy.requestLayout();
                        }
                        if (this.hwz != null) {
                            ((RelativeLayout.LayoutParams) this.hwz.getLayoutParams()).height = (int) this.hpd.getResources().getDimension(d.e.tbds0);
                            this.hwz.requestLayout();
                        }
                    } else {
                        this.hwg.setPadding(this.hwg.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.hpd.getPageContext().getPageActivity(), d.e.ds48), this.hwg.getPaddingRight(), this.hwg.getPaddingBottom());
                    }
                }
            }
            if (dVar.bIa() != null) {
                aa(dVar.bIa().YN() == 1, dVar.bIa().YM() == 1);
            }
            this.hpu = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bMX();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData c;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (dVar != null && (c = c(dVar, z)) != null) {
            String userId = c.YR().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, c.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.bIm()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (c.YR() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, c.YR().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_name_show, c.YR().getName_show());
                    sparseArray.put(d.g.tag_forbid_user_portrait, c.YR().getPortrait());
                    sparseArray.put(d.g.tag_forbid_user_post_id, c.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, c.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.bIm()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bc> bIv = dVar.bIv();
                if (com.baidu.tbadk.core.util.v.S(bIv) > 0) {
                    sb = new StringBuilder();
                    for (bc bcVar : bIv) {
                        if (bcVar != null && !StringUtils.isNull(bcVar.getForumName()) && (vVar = bcVar.bAy) != null && vVar.byr && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(bcVar.getForumName(), 12)).append(this.hpd.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.hpd.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.cpF;
    }

    public void zY(String str) {
        if (this.ffg != null) {
            this.ffg.setText(str);
        }
    }

    public void zZ(String str) {
        if (this.ffg != null) {
            int i = 0;
            if (this.hxC != null && this.hxC.hyL != null && this.hxC.hyL.getView() != null) {
                i = this.hxC.hyL.getView().getTop() < 0 ? this.hxC.hyL.getView().getHeight() : this.hxC.hyL.getView().getBottom();
            }
            this.ffg.aa(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hvY;
    }

    public int bMY() {
        return d.g.richText;
    }

    public TextView bJm() {
        return this.hwf.bJm();
    }

    public void e(BdListView.e eVar) {
        this.hvY.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.bRF = cVar;
        if (this.hwL != null) {
            this.hwL.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int XI = anVar.XI();
            int XF = anVar.XF();
            if (this.hwI != null) {
                this.hwI.aaZ();
            } else {
                this.hwI = new com.baidu.tbadk.core.dialog.a(this.hpd.getPageContext().getPageActivity());
                this.hwJ = LayoutInflater.from(this.hpd.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.hwI.az(this.hwJ);
                this.hwI.a(d.j.dialog_ok, bVar);
                this.hwI.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bNa();
                        aVar.dismiss();
                    }
                });
                this.hwI.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hxM == null) {
                            aq.this.hxM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hpd.HidenSoftKeyPad((InputMethodManager) aq.this.hpd.getSystemService("input_method"), aq.this.eCz);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jH().postDelayed(aq.this.hxM, 150L);
                    }
                });
                this.hwI.b(this.hpd.getPageContext()).aaZ();
            }
            this.hwK = (EditText) this.hwJ.findViewById(d.g.input_page_number);
            this.hwK.setText("");
            TextView textView = (TextView) this.hwJ.findViewById(d.g.current_page_number);
            if (XI <= 0) {
                XI = 1;
            }
            if (XF <= 0) {
                XF = 1;
            }
            textView.setText(MessageFormat.format(this.hpd.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(XI), Integer.valueOf(XF)));
            this.hpd.ShowSoftKeyPadDelay(this.hwK, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hvY.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hpd.showToast(str);
    }

    public boolean nR(boolean z) {
        if (this.VM == null || !this.VM.alW()) {
            return false;
        }
        this.VM.akq();
        return true;
    }

    public void bMZ() {
        if (this.hyv != null) {
            while (this.hyv.size() > 0) {
                TbImageView remove = this.hyv.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bMZ();
        this.hwH.wi(1);
        if (this.hvO != null) {
            this.hvO.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hwH.wi(2);
        if (this.hvO != null) {
            this.hvO.onResume();
            if (!UtilHelper.isOnePlus6()) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hxO != null) {
            this.hxO.destroy();
        }
        if (this.hyf != null) {
            this.hyf.onDestory();
        }
        if (this.hxW != null) {
            this.hxW.hide();
        }
        if (this.hvR != null) {
            this.hvR.aSs();
        }
        if (this.hvQ != null) {
            this.hvQ.onDestroy();
        }
        this.hpd.hideProgressBar();
        if (this.eCx != null && this.eWE != null) {
            this.eCx.b(this.eWE);
        }
        bNa();
        aeD();
        if (this.hxM != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hxM);
        }
        if (this.hwg != null && this.hwr != null) {
            this.hwg.removeView(this.hwm);
            this.hwr = null;
        }
        if (this.hxs != null) {
            this.hxs.clearStatus();
        }
        this.hyo = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hwH.wi(3);
        if (this.fbm != null) {
            this.fbm.setBackgroundDrawable(null);
        }
        if (this.hvO != null) {
            this.hvO.destroy();
        }
        if (this.hwH != null) {
            this.hwH.onDestroy();
        }
        this.hvY.setOnLayoutListener(null);
        if (this.hyb != null) {
            this.hyb.beZ();
        }
        if (this.hxD != null) {
            this.hxD.onDestroy();
        }
    }

    public boolean wB(int i) {
        if (this.hvO != null) {
            return this.hvO.qw(i);
        }
        return false;
    }

    public void bNa() {
        this.hvU.Qk();
        if (this.hvR != null) {
            this.hvR.aSs();
        }
        com.baidu.adp.lib.util.l.b(this.hpd.getPageContext().getPageActivity(), this.hwK);
        bMn();
        if (this.hnj != null) {
            this.hnj.dismiss();
        }
        bNc();
        if (this.hvQ != null) {
            this.hvQ.bPd();
        }
        if (this.hwI != null) {
            this.hwI.dismiss();
        }
        if (this.faY != null) {
            this.faY.dismiss();
        }
    }

    public void bNb() {
        this.hvU.Qk();
        if (this.hvR != null) {
            this.hvR.aSs();
        }
        if (this.hnj != null) {
            this.hnj.dismiss();
        }
        bNc();
        if (this.hvQ != null) {
            this.hvQ.bPd();
        }
        if (this.hwI != null) {
            this.hwI.dismiss();
        }
        if (this.faY != null) {
            this.faY.dismiss();
        }
    }

    public void dD(List<String> list) {
        this.hya = list;
        if (this.hyb != null) {
            this.hyb.setData(list);
        }
    }

    public void nc(boolean z) {
        this.hwH.nc(z);
    }

    public void nS(boolean z) {
        this.hxd = z;
    }

    public void bNc() {
        if (this.hwR != null) {
            this.hwR.dismiss();
        }
        if (this.hwS != null) {
            com.baidu.adp.lib.g.g.b(this.hwS, this.hpd.getPageContext());
        }
        if (this.hwT != null) {
            com.baidu.adp.lib.g.g.b(this.hwT, this.hpd.getPageContext());
        }
        if (this.hwP != null) {
            this.hwP.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hsw, this.hpu);
            d(this.hsw, this.hpu, this.mType);
            this.hpd.getLayoutMode().setNightMode(i == 1);
            this.hpd.getLayoutMode().onModeChanged(this.eCz);
            this.hpd.getLayoutMode().onModeChanged(this.hvZ);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.al.l(this.eCz, d.C0236d.cp_bg_line_d);
            }
            if (this.hvQ != null) {
                this.hvQ.onChangeSkinType(i);
            }
            if (this.hwb != null) {
                com.baidu.tbadk.core.util.al.j(this.hwb, d.C0236d.cp_cont_b);
                this.hwb.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_link_tip_c));
            }
            if (this.ffg != null) {
                this.ffg.ic(i);
                if (this.cpF != null) {
                    this.hpd.getLayoutMode().onModeChanged(this.cpF);
                    com.baidu.tbadk.core.util.al.k(this.cpF, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.hwI != null) {
                this.hwI.c(this.hpd.getPageContext());
            }
            nQ(this.hxa);
            this.hwH.notifyDataSetChanged();
            if (this.hwL != null) {
                this.hwL.ic(i);
            }
            if (this.VM != null) {
                this.VM.onChangeSkinType(i);
            }
            if (this.hwq != null) {
                this.hwq.ij(i);
            }
            if (this.hwM != null) {
                this.hwM.ic(i);
            }
            if (!com.baidu.tbadk.core.util.v.T(this.ekx)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ekx) {
                    customBlueCheckRadioButton.aeh();
                }
            }
            bMC();
            UtilHelper.setStatusBarBackground(this.fbm, i);
            UtilHelper.setStatusBarBackground(this.hxx, i);
            if (this.hws != null) {
                this.hws.onChangeSkinType(i);
            }
            if (this.hww != null) {
                com.baidu.tbadk.core.util.al.j(this.hww, d.C0236d.cp_cont_d);
            }
            if (this.hwv != null) {
                com.baidu.tbadk.core.util.al.j(this.hwv, d.C0236d.cp_cont_d);
            }
            if (this.hwx != null) {
                com.baidu.tbadk.core.util.al.j(this.hwx, d.C0236d.cp_cont_d);
            }
            if (this.hwj != null) {
                com.baidu.tbadk.core.util.al.j(this.hwj, d.C0236d.cp_link_tip_a);
            }
            if (this.hwu != null) {
                com.baidu.tbadk.core.util.al.j(this.hwu, d.C0236d.cp_cont_d);
            }
            if (this.hwA != null) {
                com.baidu.tbadk.r.a.a(this.hpd.getPageContext(), this.hwA);
            }
            if (this.hxN != null) {
                this.hxN.onChangeSkinType(i);
            }
            if (this.hvU != null) {
                if (this.hvO != null) {
                    this.hvO.wG(i);
                } else {
                    this.hvU.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fPf != null) {
                com.baidu.tbadk.core.util.al.j(this.fPf, d.C0236d.cp_cont_d);
                com.baidu.tbadk.core.util.al.k(this.fPf, d.f.bg_comment_input);
            }
            if (this.hxh != null && this.hsw != null) {
                if (this.hsw.Vb()) {
                    com.baidu.tbadk.core.util.al.c(this.hxh, d.f.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.hxh, d.f.icon_pb_bottom_collect_n);
                }
            }
            if (this.hxi != null) {
                com.baidu.tbadk.core.util.al.c(this.hxi, d.f.icon_pb_bottom_share_n);
            }
            if (this.hxg != null) {
                com.baidu.tbadk.core.util.al.c(this.hxg, d.f.icon_pb_bottom_comment_n);
            }
            if (this.hxj != null) {
                this.hxj.onChangeSkinType();
            }
            if (this.hwk != null) {
                com.baidu.tbadk.core.util.al.c(this.hwk, BitmapHelper.getGradeResourceIdInEnterForum(this.hxV));
            }
            if (this.hyc != null) {
                this.hyc.onChangeSkinType(i);
            }
            if (this.hxD != null) {
                this.hxD.onChangeSkinType();
            }
            if (this.hxY != null) {
                com.baidu.tbadk.core.util.al.j(this.hxY, d.C0236d.cp_cont_n);
            }
            com.baidu.tbadk.core.util.al.l(this.hxf, d.C0236d.cp_bg_line_d);
            if (this.hwj != null) {
                com.baidu.tbadk.core.util.al.k(this.hwj, d.f.bg_user_identity_btn);
                com.baidu.tbadk.core.util.al.j(this.hwj, d.C0236d.cp_bg_line_d);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
        this.hwH.setOnImageClickListener(this.cAE);
        this.hyc.setOnImageClickListener(this.cAE);
    }

    public void h(NoNetworkView.a aVar) {
        this.eWE = aVar;
        if (this.eCx != null) {
            this.eCx.a(this.eWE);
        }
    }

    public void nT(boolean z) {
        this.hwH.setIsFromCDN(z);
    }

    public Button bNd() {
        return this.hxe;
    }

    public void bNe() {
        if (this.hvT != 2) {
            this.hvY.setNextPage(this.ffg);
            this.hvT = 2;
        }
    }

    public void bNf() {
        if (com.baidu.tbadk.o.m.apl().apm()) {
            int lastVisiblePosition = this.hvY.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hvY.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.o.h perfLog = tbImageView.getPerfLog();
                                perfLog.jX(1001);
                                perfLog.cqm = true;
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
                        perfLog2.jX(1001);
                        perfLog2.cqm = true;
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

    public boolean bNg() {
        return this.VM != null && this.VM.getVisibility() == 0;
    }

    public boolean bNh() {
        return this.VM != null && this.VM.alW();
    }

    public void bNi() {
        if (this.VM != null) {
            this.VM.akq();
        }
    }

    public void nU(boolean z) {
        if (this.hxf != null) {
            nS(this.hpd.bJn().amA());
            if (this.hxd) {
                nK(z);
            } else {
                nL(z);
            }
        }
    }

    public void bNj() {
        if (this.hxf != null) {
            this.hxf.setVisibility(8);
            this.hxk = false;
            if (this.hxD != null) {
                this.hxD.setVisibility(8);
                nO(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.esg == null) {
            this.esg = new com.baidu.tbadk.core.view.b(this.hpd.getPageContext());
        }
        this.esg.dJ(true);
    }

    public void aMF() {
        if (this.esg != null) {
            this.esg.dJ(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hvY.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hvY.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hvO != null) {
            this.hvO.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hyw = getScrollY();
            this.hxC.hyL = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxC));
            a(this.hxC.hyL, true);
        }
    }

    public void nV(boolean z) {
        this.hvO.nV(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hvO != null) {
            this.hvO.b(absListView, i);
        }
        if (this.hvU != null && this.hwH != null) {
            this.hvU.a(this.hwH.bKA());
        }
        this.hxC.hfq = i;
        this.hxC.headerCount = this.hvY.getHeaderViewsCount();
        this.hxC.hyL = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxC));
        a(this.hxC.hyL, false);
        if (this.ffg.aeJ() && !this.ffg.bRu) {
            if (this.hxC != null && this.hxC.hyL != null && this.hxC.hyL.getView() != null) {
                i4 = this.hxC.hyL.getView().getTop() < 0 ? this.hxC.hyL.getView().getHeight() : this.hxC.hyL.getView().getBottom();
            }
            this.ffg.m18if(i4);
            this.ffg.bRu = true;
        }
    }

    public void bNk() {
        if (this.hpd.isLogin() && this.hsw != null && this.hxS && !this.hxR && !this.hxb && this.hxn != null && this.hxn.YR() != null && !this.hxn.YR().getIsLike() && !this.hxn.YR().hadConcerned() && this.hxO == null) {
            this.hxO = new an(this.hpd);
        }
    }

    public void bNl() {
        if (this.hxS && !this.hxR && this.hxn != null && this.hxn.YR() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").T("obj_locate", this.hpd.bIR() ? 2 : 1).T("obj_type", this.hxR ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hpd.getPageContext().getPageActivity(), this.hxn.YR().getUserId(), this.hxn.YR().getUserName(), this.hpd.bJb().bIS(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hxR && this.hxw != null && this.hvU.bNT() != null) {
            int bKw = this.hwH.bKw();
            if (bKw > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bKw > this.hvY.getFirstVisiblePosition() - this.hvY.getHeaderViewsCount()) {
                    this.hxw.setVisibility(8);
                    return;
                }
                this.hxw.setVisibility(0);
                bNv();
                this.hvU.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.hvs == null) {
                if (this.hvY.getFirstVisiblePosition() == 0) {
                    this.hxw.setVisibility(8);
                    this.hvU.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hxB) {
                        this.hxA = top;
                        this.hxB = false;
                    }
                    this.hxA = top < this.hxA ? top : this.hxA;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hwG.getY() < 0.0f) {
                        measuredHeight = hxz - alVar.hvs.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hvU.bNT().getMeasuredHeight() - alVar.hvs.getMeasuredHeight();
                        this.hvU.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hxA) {
                        this.hxw.setVisibility(0);
                        bNv();
                    } else if (top < measuredHeight) {
                        this.hxw.setVisibility(0);
                        bNv();
                    } else {
                        this.hxw.setVisibility(8);
                        this.hvU.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hxB = true;
                    }
                }
            }
        }
    }

    public void bNm() {
        if (!this.hyx) {
            TiebaStatic.log("c10490");
            this.hyx = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hpd.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hxG, Integer.valueOf(hxI));
            aVar.gC(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hpd.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.az(inflate);
            aVar.ab(sparseArray);
            aVar.a(d.j.grade_button_tips, this.hpd);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hpd.getPageContext()).aaZ();
        }
    }

    public void Aa(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hpd.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hpd.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.az(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hxG, Integer.valueOf(hxJ));
        aVar.ab(sparseArray);
        aVar.a(d.j.view, this.hpd);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hpd.getPageContext()).aaZ();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData c;
        if (i > 0 && (c = c(dVar, z)) != null && c.YR() != null) {
            MetaData YR = c.YR();
            YR.setGiftNum(YR.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        r(dVar);
    }

    public PbInterviewStatusView bNn() {
        return this.hxs;
    }

    private void t(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bIa() != null && dVar.bIa().ZR() && this.hxs == null) {
            this.hxs = (PbInterviewStatusView) this.hxr.inflate();
            this.hxs.setOnClickListener(this.faZ);
            this.hxs.setCallback(this.hpd.bJY());
            this.hxs.setData(this.hpd, dVar);
        }
    }

    public LinearLayout bNo() {
        return this.hwG;
    }

    public View bNp() {
        return this.fbm;
    }

    public boolean bNq() {
        return this.hyi;
    }

    public void nh(boolean z) {
        this.hwf.nh(z);
    }

    public void Ab(String str) {
        if (this.hvV != null) {
            this.hvV.setTitle(str);
        }
    }

    private int nW(boolean z) {
        if (this.hxs == null || this.hxs.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.hpd.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bNr() {
        if (this.hxs != null && this.hxs.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hxs.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hxs.setLayoutParams(layoutParams);
        }
    }

    public boolean bJs() {
        return false;
    }

    public void Ac(String str) {
        this.fPf.performClick();
        if (!StringUtils.isNull(str) && this.hpd.bJn() != null && this.hpd.bJn().amt() != null && this.hpd.bJn().amt().getInputView() != null) {
            EditText inputView = this.hpd.bJn().amt().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bNa();
            if (configuration.orientation == 2) {
                bNj();
                bMn();
            } else {
                bMq();
            }
            if (this.hxN != null) {
                this.hxN.bKF();
            }
            this.hpd.bcO();
            this.hwG.setVisibility(8);
            this.hvU.og(false);
            this.hpd.nn(false);
            if (this.hvO != null) {
                if (configuration.orientation == 1) {
                    bNo().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hvY.setIsLandscape(true);
                    this.hvY.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hvY.setIsLandscape(false);
                    if (this.hyw > 0) {
                        this.hvY.smoothScrollBy(this.hyw, 0);
                    }
                }
                this.hvO.onConfigurationChanged(configuration);
                this.hxv.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void nX(boolean z) {
        this.hvS = z;
    }

    public boolean bNs() {
        return this.hvO != null && this.hvO.bNs();
    }

    public void bNt() {
        if (this.hvO != null) {
            this.hvO.onPause();
        }
    }

    public void s(long j, int i) {
        if (this.hvQ != null) {
            this.hvQ.s(j, i);
        }
        if (this.hvO != null) {
            this.hvO.s(j, i);
        }
    }

    public void ns(boolean z) {
        this.hwH.ns(z);
    }

    public void bNu() {
        if (this.hxt == null) {
            LayoutInflater.from(this.hpd.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.eCz, true);
            this.hxt = (ViewGroup) this.eCz.findViewById(d.g.add_experienced_layout);
            this.hxu = (TextView) this.eCz.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.al.j(this.hxu, d.C0236d.cp_btn_a);
            String string = this.hpd.getResources().getString(d.j.experienced_add_success);
            String string2 = this.hpd.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_h)));
            this.hxu.setText(spannableString);
        }
        this.hxt.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.28
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.28.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        aq.this.hxt.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hxu.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hxu.startAnimation(scaleAnimation);
    }

    public void ct(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hxf.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hpd);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.hxY = new TextView(this.hpd);
            this.hxY.setText(d.j.connection_tips);
            this.hxY.setGravity(17);
            this.hxY.setPadding(com.baidu.adp.lib.util.l.h(this.hpd, d.e.ds24), 0, com.baidu.adp.lib.util.l.h(this.hpd, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hpd, d.e.ds60);
            if (this.hxY.getParent() == null) {
                frameLayout.addView(this.hxY, layoutParams);
            }
            this.hxX = new PopupWindow(this.hpd);
            this.hxX.setContentView(frameLayout);
            this.hxX.setHeight(-2);
            this.hxX.setWidth(-2);
            this.hxX.setFocusable(true);
            this.hxX.setOutsideTouchable(false);
            this.hxX.setBackgroundDrawable(new ColorDrawable(this.hpd.getResources().getColor(d.C0236d.transparent)));
            this.hvY.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hxX.showAsDropDown(aq.this.hxf, view.getLeft(), -aq.this.hxf.getHeight());
                    } else {
                        aq.this.hxX.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bNv() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.hxZ == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.hxZ = new com.baidu.tbadk.core.dialog.a(this.hpd);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hpd);
            this.hxZ.gF(1);
            this.hxZ.az(pbLongPressTipView);
            this.hxZ.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hxZ.dr(false);
            this.hxZ.b(this.hpd.getPageContext()).aaZ();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.31
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hxZ != null && aq.this.hxZ.isShowing()) {
                        aq.this.hxZ.dismiss();
                    }
                }
            }, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.hvO != null) {
                this.hvO.bPl();
            }
        }
    }

    public void nY(boolean z) {
        this.hye = z;
    }

    public boolean bNw() {
        return this.hye;
    }

    private void aa(boolean z, boolean z2) {
        ab(z, z2);
        ac(z, z2);
        if (this.hwH != null && this.hwH.bKB() != null) {
            this.hwH.bKB().U(z, z2);
        }
    }

    private void ab(boolean z, boolean z2) {
        if (z && z2) {
            this.hwd.setImageResource(d.f.pic_pb_stick_refined_n);
            this.hwd.setVisibility(0);
        } else if (z) {
            this.hwd.setImageResource(d.f.pic_pb_refined_n);
            this.hwd.setVisibility(0);
        } else if (z2) {
            this.hwd.setImageResource(d.f.pic_pb_stick_n);
            this.hwd.setVisibility(0);
        } else {
            this.hwd.setVisibility(8);
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.hwa != null && this.hsw != null && this.hsw.bIa() != null && this.hsw.bIa().Zg() == 0 && !this.hsw.bIa().ZL()) {
            if (z && z2) {
                this.hwe.setImageResource(d.f.pic_pb_stick_refined_n);
                this.hwe.setVisibility(0);
            } else if (z) {
                this.hwe.setImageResource(d.f.pic_pb_refined_n);
                this.hwe.setVisibility(0);
            } else if (z2) {
                this.hwe.setImageResource(d.f.pic_pb_stick_n);
                this.hwe.setVisibility(0);
            } else {
                this.hwe.setVisibility(8);
            }
        }
    }
}
