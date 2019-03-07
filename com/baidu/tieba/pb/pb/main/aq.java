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
    PbActivity.d hoh;
    private View.OnClickListener hpB;
    private PbActivity hpc;
    private UserIconBox hqp;
    private UserIconBox hqq;
    private PbFakeFloorModel hrn;
    private com.baidu.tieba.pb.data.d hsv;
    public int hvM;
    private com.baidu.tieba.pb.video.i hvN;
    private long hvO;
    private com.baidu.tieba.pb.video.h hvP;
    private com.baidu.tieba.c.d hvQ;
    public final com.baidu.tieba.pb.pb.main.view.b hvT;
    public com.baidu.tieba.pb.pb.main.view.a hvU;
    private ViewStub hvV;
    private ViewStub hvW;
    private PbLandscapeListView hvX;
    private View hvY;
    private TextView hwA;
    private TextView hwB;
    private View hwC;
    private View hwD;
    private ObservedChangeLinearLayout hwF;
    private f hwG;
    private View hwM;
    private RelativeLayout hwb;
    private ImageView hwc;
    private ImageView hwd;
    private e hwe;
    private ColumnLayout hwf;
    private ThreadSkinView hwg;
    private TextView hwh;
    private TextView hwi;
    private ImageView hwj;
    private HeadPendantView hwk;
    private FrameLayout hwl;
    private HeadImageView hwm;
    private View hwn;
    private LinearLayout hwo;
    private PbFirstFloorUserLikeButton hwr;
    private ao hws;
    private TextView hwt;
    private TextView hwu;
    private TextView hwv;
    private TextView hww;
    private View hwx;
    private View hwy;
    private LinearLayout hwz;
    private PbEmotionBar hxC;
    private int hxK;
    private Runnable hxL;
    private s hxM;
    private an hxN;
    private int hxT;
    private PbTopTipView hxV;
    private PopupWindow hxW;
    private TextView hxX;
    private com.baidu.tbadk.core.dialog.a hxY;
    private List<String> hxZ;
    private View hxe;
    private ImageView hxf;
    private ImageView hxg;
    private ImageView hxh;
    private MessageRedDotView hxi;
    private int hxk;
    private int hxl;
    private PostData hxm;
    private View hxo;
    private TextView hxp;
    private ViewStub hxq;
    private PbInterviewStatusView hxr;
    private ViewGroup hxs;
    private TextView hxt;
    private FrameLayout hxu;
    private View hxv;
    private View hxw;
    private al hxx;
    private com.baidu.tieba.pb.pb.main.emotion.c hya;
    private com.baidu.tieba.pb.pb.godreply.a hyb;
    private PbLandscapeListView.b hyc;
    private ac hye;
    private String hyf;
    private boolean hyh;
    private com.baidu.tbadk.core.view.userLike.c hyi;
    private com.baidu.tbadk.core.view.userLike.c hyj;
    private Runnable hyo;
    private PbActivity.b hyq;
    public int hyv;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private static final int hxy = UtilHelper.getLightStatusBarHeight();
    public static int hxE = 3;
    public static int hxF = 0;
    public static int hxG = 3;
    public static int hxH = 4;
    public static int hxI = 5;
    public static int hxJ = 6;
    private static a.InterfaceC0307a hyg = new a.InterfaceC0307a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0307a
        public void onRefresh() {
        }
    };
    private boolean hvR = false;
    private int hvS = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hvZ = null;
    private TextView hwa = null;
    public FrsPraiseView hwp = null;
    private ClickableHeaderImageView hwq = null;
    private View hwE = null;
    private com.baidu.tbadk.core.dialog.a hwH = null;
    private com.baidu.tbadk.core.dialog.b faY = null;
    private View hwI = null;
    private EditText hwJ = null;
    private com.baidu.tieba.pb.view.c hwK = null;
    private com.baidu.tieba.pb.view.a hwL = null;
    private com.baidu.tbadk.core.dialog.a hwN = null;
    private b.InterfaceC0191b gmF = null;
    private TbRichTextView.h cAE = null;
    private NoNetworkView.a eWE = null;
    private com.baidu.tbadk.core.dialog.g hwO = null;
    private View hwP = null;
    private com.baidu.tbadk.core.dialog.a hwQ = null;
    private Dialog hwR = null;
    private Dialog hwS = null;
    private View hwT = null;
    private LinearLayout hwU = null;
    private CompoundButton.OnCheckedChangeListener eky = null;
    private TextView hwV = null;
    private TextView hwW = null;
    private String hwX = null;
    private com.baidu.tbadk.core.dialog.g hni = null;
    private com.baidu.tbadk.core.dialog.g hwY = null;
    private boolean hwZ = false;
    private boolean hxa = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hxb = null;
    private boolean hxc = false;
    private Button hxd = null;
    private boolean hxj = true;
    private com.baidu.tbadk.core.view.b esg = null;
    private boolean hpt = false;
    private int mSkinType = 3;
    private boolean hxn = false;
    private int hxz = 0;
    private boolean hxA = true;
    private a hxB = new a();
    private int hxD = 0;
    private boolean hxO = false;
    private int hxP = 0;
    private boolean hxQ = false;
    private boolean hxR = false;
    private boolean hxS = false;
    private int hxU = 0;
    private boolean hyd = false;
    private String hyk = null;
    private CustomMessageListener hyl = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hyk = null;
            }
        }
    };
    private CustomMessageListener dgB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hwG != null) {
                aq.this.hwG.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hym = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hwa != null) {
                aq.this.hwa.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hyn = new Handler();
    private CustomMessageListener hyp = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hxj = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hyr = true;
    View.OnClickListener hys = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hxQ) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").T(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hxQ && aq.this.hsv != null && aq.this.hsv.bHZ() != null && aq.this.hsv.bHZ().YR() != null && aq.this.hsv.bHZ().YR().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").T("obj_locate", 1));
            }
            aq.this.hpc.hnd.fAk.onClick(view);
        }
    };
    private boolean hyt = false;
    String userId = null;
    private final List<TbImageView> hyu = new ArrayList();
    private boolean hyw = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int headerCount;
        public int hfp;
        public al hyK;
    }

    public void nJ(boolean z) {
        this.hxO = z;
        if (this.hvX != null) {
            this.hxP = this.hvX.getHeaderViewsCount();
        }
    }

    public void bMk() {
        if (this.hvX != null) {
            int headerViewsCount = this.hvX.getHeaderViewsCount() - this.hxP;
            final int firstVisiblePosition = (this.hvX.getFirstVisiblePosition() == 0 || this.hvX.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hvX.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hvX.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hxB.hyK = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxB));
            final al alVar = this.hxB.hyK;
            final int h = h(alVar);
            final int y = ((int) this.hwF.getY()) + this.hwF.getMeasuredHeight();
            final boolean z = this.hxv.getVisibility() == 0;
            boolean z2 = this.hwF.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hwG.bKv() + this.hvX.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hvr.getMeasuredHeight() : 0;
                if (z2) {
                    this.hvX.setSelectionFromTop(this.hwG.bKv() + this.hvX.getHeaderViewsCount(), hxy - measuredHeight);
                } else {
                    this.hvX.setSelectionFromTop(this.hwG.bKv() + this.hvX.getHeaderViewsCount(), this.hvT.bNS().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hvX.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hxQ) {
                this.hvX.setSelectionFromTop(this.hwG.bKv() + this.hvX.getHeaderViewsCount(), this.hvN.aBC().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hvX.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bKN() {
                        if (h >= 0 && h <= aq.this.eCz.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.eoS.getLayoutParams();
                            if (i == 0 || i > aq.this.eCz.getMeasuredHeight() || h2 >= aq.this.eCz.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hxK;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.eCz.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hxK;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hvX.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.eoS.setLayoutParams(layoutParams);
                        }
                        aq.this.hvX.setOnLayoutListener(null);
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

    public NoNetworkView bMl() {
        return this.eCx;
    }

    public void bMm() {
        if (this.VM != null) {
            this.VM.hide();
            if (this.hya != null) {
                this.hya.aAB();
            }
        }
    }

    public PbFakeFloorModel bMn() {
        return this.hrn;
    }

    public s bMo() {
        return this.hxM;
    }

    public void bMp() {
        reset();
        bMm();
        this.hxM.bKE();
        nU(false);
    }

    private void reset() {
        if (this.hpc != null && this.hpc.bJm() != null && this.VM != null) {
            com.baidu.tbadk.editortools.pb.a.amq().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bJm = this.hpc.bJm();
            bJm.amJ();
            bJm.ame();
            if (bJm.getWriteImagesInfo() != null) {
                bJm.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bJm.jC(SendView.ALL);
            bJm.jD(SendView.ALL);
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

    public boolean bMq() {
        return this.hxj;
    }

    public void nK(boolean z) {
        if (this.hxe != null && this.fPf != null) {
            this.fPf.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hxe.startAnimation(alphaAnimation);
            }
            this.hxe.setVisibility(0);
            this.hxj = true;
            if (this.hxC != null && !this.hyb.isActive()) {
                this.hxC.setVisibility(0);
                nO(true);
            }
        }
    }

    public void nL(boolean z) {
        if (this.hxe != null && this.fPf != null) {
            this.fPf.setText(bMr());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hxe.startAnimation(alphaAnimation);
            }
            this.hxe.setVisibility(0);
            this.hxj = true;
            if (this.hxC != null && !this.hyb.isActive()) {
                this.hxC.setVisibility(0);
                nO(true);
            }
        }
    }

    public String bMr() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.hyf)) {
            return this.hyf;
        }
        if (this.hpc != null) {
            this.hyf = this.hpc.getResources().getString(ap.bMj());
        }
        return this.hyf;
    }

    public PostData bMs() {
        int i = 0;
        if (this.hvX == null) {
            return null;
        }
        int bMt = bMt() - this.hvX.getHeaderViewsCount();
        if (bMt < 0) {
            bMt = 0;
        }
        if (this.hwG.wh(bMt) != null && this.hwG.wh(bMt) != PostData.iGi) {
            i = bMt + 1;
        }
        return this.hwG.getItem(i) instanceof PostData ? (PostData) this.hwG.getItem(i) : null;
    }

    public int bMt() {
        int i;
        View childAt;
        if (this.hvX == null) {
            return 0;
        }
        int firstVisiblePosition = this.hvX.getFirstVisiblePosition();
        int lastVisiblePosition = this.hvX.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hvX.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hvX.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bMu() {
        return this.hvX.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hsv != null && this.hsv.bIb() != null && !this.hsv.bIb().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hsv.bIb().size() && (postData = this.hsv.bIb().get(i)) != null && postData.YR() != null && !StringUtils.isNull(postData.YR().getUserId()); i++) {
                if (this.hsv.bIb().get(i).YR().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hyb != null && this.hyb.isActive()) {
                        nU(false);
                    }
                    if (this.hxC != null) {
                        this.hxC.oc(true);
                    }
                    this.hyk = postData.YR().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hpc = null;
        this.eCz = null;
        this.fbm = null;
        this.hvO = 0L;
        this.hvX = null;
        this.hvY = null;
        this.hwb = null;
        this.hwf = null;
        this.hwh = null;
        this.hwi = null;
        this.hwl = null;
        this.hwm = null;
        this.hwn = null;
        this.hwr = null;
        this.hwt = null;
        this.hwu = null;
        this.hwv = null;
        this.hww = null;
        this.hwC = null;
        this.hwD = null;
        this.hwG = null;
        this.ffg = null;
        this.cpF = null;
        this.faZ = null;
        this.hpB = null;
        this.hxe = null;
        this.fPf = null;
        this.hxo = null;
        this.hxp = null;
        this.hxq = null;
        this.hxT = 0;
        this.hvO = System.currentTimeMillis();
        this.hpc = pbActivity;
        this.faZ = onClickListener;
        this.cbY = cVar;
        this.hxT = com.baidu.adp.lib.util.l.aO(this.hpc) / 2;
        this.eCz = (RelativeLayout) LayoutInflater.from(this.hpc.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.hpc.addContentView(this.eCz, new FrameLayout.LayoutParams(-1, -1));
        this.bsn = (NavigationBarCoverTip) this.hpc.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.fbm = this.hpc.findViewById(d.g.statebar_view);
        this.hwF = (ObservedChangeLinearLayout) this.hpc.findViewById(d.g.title_wrapper);
        this.eCx = (NoNetworkView) this.hpc.findViewById(d.g.view_no_network);
        this.hvX = (PbLandscapeListView) this.hpc.findViewById(d.g.new_pb_list);
        this.hxu = (FrameLayout) this.hpc.findViewById(d.g.root_float_header);
        this.ahH = new TextView(this.hpc.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.hpc.getActivity(), d.e.ds88));
        this.hvX.addHeaderView(this.ahH, 0);
        this.hxK = this.hpc.getResources().getDimensionPixelSize(d.e.tbds134);
        this.eoS = new View(this.hpc.getPageContext().getPageActivity());
        this.eoS.setLayoutParams(new AbsListView.LayoutParams(-1, this.hxK));
        this.eoS.setVisibility(4);
        this.hvX.addFooterView(this.eoS);
        this.hvX.setOnTouchListener(this.hpc.ccU);
        this.hvT = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.hpc.bJP()) {
            this.hvV = (ViewStub) this.hpc.findViewById(d.g.manga_view_stub);
            this.hvV.setVisibility(0);
            this.hvU = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.hvU.show();
            this.hvT.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hpc.getActivity(), d.e.ds120);
        }
        this.ahH.setLayoutParams(layoutParams);
        this.hvT.bNS().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0277a() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0277a
            public void bIK() {
                if (aq.this.hvX != null) {
                    if (aq.this.hvN != null) {
                        aq.this.hvN.bPj();
                    }
                    aq.this.hvX.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0277a
            public void bIL() {
                aq.this.hpc.bcN();
            }
        }));
        this.hxe = this.hpc.findViewById(d.g.pb_editor_tool_comment);
        this.hxk = com.baidu.adp.lib.util.l.h(this.hpc.getPageContext().getPageActivity(), d.e.tbds120);
        this.hxl = com.baidu.adp.lib.util.l.h(this.hpc.getPageContext().getPageActivity(), d.e.ds242);
        this.fPf = (TextView) this.hpc.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hpc.bJv();
                if (aq.this.hpc != null && aq.this.hpc.bJa() != null && aq.this.hpc.bJa().getPbData() != null && aq.this.hpc.bJa().getPbData().bHZ() != null && aq.this.hpc.bJa().getPbData().bHZ().YR() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", aq.this.hpc.bJa().hrZ).bJ(ImageViewerConfig.FORUM_ID, aq.this.hpc.bJa().getPbData().getForumId()).T("obj_locate", 1).bJ("uid", aq.this.hpc.bJa().getPbData().bHZ().YR().getUserId()));
                }
            }
        });
        this.hxf = (ImageView) this.hpc.findViewById(d.g.pb_editor_tool_comment_icon);
        this.hxf.setOnClickListener(this.faZ);
        this.hxg = (ImageView) this.hpc.findViewById(d.g.pb_editor_tool_collection);
        this.hxg.setOnClickListener(this.faZ);
        this.hxh = (ImageView) this.hpc.findViewById(d.g.pb_editor_tool_share);
        this.hxh.setOnClickListener(this.faZ);
        this.hxi = (MessageRedDotView) this.hpc.findViewById(d.g.pb_editor_tool_comment_red_dot);
        this.hvY = LayoutInflater.from(this.hpc.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.hwb = (RelativeLayout) LayoutInflater.from(this.hpc.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.hwc = (ImageView) this.hwb.findViewById(d.g.pb_thread_type_stamp_top_part);
        this.hwe = new e(this.hpc, this.hwb);
        this.hwe.init();
        this.hwe.a(this.hwe.bJl(), this.faZ);
        this.hwf = (ColumnLayout) this.hwb.findViewById(d.g.pb_head_owner_root);
        this.hwg = (ThreadSkinView) this.hwb.findViewById(d.g.pb_thread_skin);
        this.hwf.setOnLongClickListener(this.onLongClickListener);
        this.hwf.setOnTouchListener(this.cbY);
        this.hwf.setVisibility(8);
        this.hvY.setOnTouchListener(this.cbY);
        this.hxo = this.hvY.findViewById(d.g.pb_head_activity_join_number_container);
        this.hxo.setVisibility(8);
        this.hxp = (TextView) this.hvY.findViewById(d.g.pb_head_activity_join_number);
        this.hwh = (TextView) this.hwf.findViewById(d.g.pb_head_owner_info_user_name);
        this.hwh.getPaint().setFakeBoldText(true);
        this.hwi = (TextView) this.hwf.findViewById(d.g.floor_owner);
        this.hwj = (ImageView) this.hwf.findViewById(d.g.icon_forum_level);
        this.hwl = (FrameLayout) this.hwf.findViewById(d.g.pb_head_headImage_container);
        this.hwm = (HeadImageView) this.hwf.findViewById(d.g.pb_head_owner_photo);
        this.hwk = (HeadPendantView) this.hwf.findViewById(d.g.pb_pendant_head_owner_photo);
        this.hwk.setHasPendantStyle();
        if (this.hwk.getHeadView() != null) {
            this.hwk.getHeadView().setIsRound(true);
            this.hwk.getHeadView().setDrawBorder(false);
        }
        this.hqp = (UserIconBox) this.hwf.findViewById(d.g.show_icon_vip);
        this.hqq = (UserIconBox) this.hwf.findViewById(d.g.show_icon_yinji);
        this.hwo = (LinearLayout) this.hwb.findViewById(d.g.pb_head_owner_info_root);
        this.hwr = (PbFirstFloorUserLikeButton) this.hwf.findViewById(d.g.pb_like_button);
        this.hwt = (TextView) this.hwf.findViewById(d.g.pb_views);
        this.hwu = (TextView) this.hwf.findViewById(d.g.pb_item_first_floor_reply_time);
        this.hwv = (TextView) this.hwf.findViewById(d.g.pb_item_first_floor_location_address);
        this.hww = (TextView) this.hwf.findViewById(d.g.point_between_time_and_locate);
        this.hyi = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hyj = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hwC = this.hvY.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.hwD = this.hvY.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.hvY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hxq = (ViewStub) this.eCz.findViewById(d.g.interview_status_stub);
        this.hwx = this.hwb.findViewById(d.g.blank_view_align_user_item_top);
        this.hwy = this.hwb.findViewById(d.g.blank_view_align_user_item_bottom);
        this.hwG = new f(this.hpc, this.hvX);
        this.hwG.x(this.faZ);
        this.hwG.setTbGestureDetector(this.cbY);
        this.hwG.setOnImageClickListener(this.cAE);
        this.hpB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.35
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
                            aq.this.hpc.c(sparseArray);
                            return;
                        }
                        aq.this.cs(view);
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        aq.this.hpc.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hwG.J(this.hpB);
        bMz();
        this.hvX.addHeaderView(this.hwb);
        this.hvX.addHeaderView(this.hvZ);
        this.hvX.addHeaderView(this.hvY);
        this.ffg = new PbListView(this.hpc.getPageContext().getPageActivity());
        this.cpF = this.ffg.getView().findViewById(d.g.pb_more_view);
        if (this.cpF != null) {
            this.cpF.setOnClickListener(this.faZ);
            com.baidu.tbadk.core.util.al.k(this.cpF, d.f.pb_foot_more_trans_selector);
        }
        this.ffg.aey();
        this.ffg.hZ(d.f.pb_foot_more_trans_selector);
        this.ffg.ib(d.f.pb_foot_more_trans_selector);
        this.hwM = this.hpc.findViewById(d.g.viewstub_progress);
        this.hpc.registerListener(this.hyp);
        this.hwn = com.baidu.tbadk.ala.b.UK().n(this.hpc.getActivity(), 2);
        if (this.hwn != null) {
            this.hwn.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.hpc.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.hwn.getParent() == null) {
                this.hwo.addView(this.hwn, aVar);
            }
        }
        this.hrn = new PbFakeFloorModel(this.hpc.getPageContext());
        this.hxM = new s(this.hpc.getPageContext(), this.hrn, this.eCz);
        this.hxM.a(this.hpc.hod);
        this.hrn.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.36
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hrn.o(postData);
                aq.this.hwG.notifyDataSetChanged();
                aq.this.hxM.bKE();
                aq.this.VM.akq();
                aq.this.nU(false);
            }
        });
        if (this.hpc.bJa() != null && !StringUtils.isNull(this.hpc.bJa().bLy())) {
            this.hpc.showToast(this.hpc.bJa().bLy());
        }
        this.hxv = this.hpc.findViewById(d.g.pb_expand_blank_view);
        this.hxw = this.hpc.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hxw.getLayoutParams();
        if (this.hpc.bJa() != null && this.hpc.bJa().bKU()) {
            this.hxv.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hxw.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hxy;
            this.hxw.setLayoutParams(layoutParams2);
        }
        this.hxx = new al(this.hpc.getPageContext(), this.hpc.findViewById(d.g.pb_reply_expand_view));
        this.hxx.hvr.setVisibility(8);
        this.hxx.L(this.faZ);
        this.hpc.registerListener(this.dgB);
        this.hpc.registerListener(this.hyl);
        this.hpc.registerListener(this.hym);
        bMv();
        nO(false);
    }

    public void bnm() {
        if (!this.hpc.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 2).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.hpc.bJx()) {
            com.baidu.tbadk.editortools.pb.d bJm = this.hpc.bJm();
            if (bJm != null && (bJm.amG() || bJm.amH())) {
                this.hpc.bJm().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.VM != null) {
                bME();
            }
            if (this.VM != null) {
                this.hxj = false;
                if (this.VM.jw(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hpc, (View) this.VM.jw(2).ciu, false, hyg);
                }
            }
            bNi();
        }
    }

    private void bMv() {
        this.hyb = new com.baidu.tieba.pb.pb.godreply.a(this.hpc, this, (ViewStub) this.eCz.findViewById(d.g.more_god_reply_popup));
        this.hyb.t(this.faZ);
        this.hyb.J(this.hpB);
        this.hyb.setOnImageClickListener(this.cAE);
        this.hyb.t(this.faZ);
        this.hyb.setTbGestureDetector(this.cbY);
    }

    public com.baidu.tieba.pb.pb.godreply.a bMw() {
        return this.hyb;
    }

    public View bMx() {
        return this.hxv;
    }

    public void bMy() {
        if (this.hvX != null) {
            this.hvX.removeHeaderView(this.hvZ);
            this.hvX.removeHeaderView(this.hwb);
            this.hvX.removeHeaderView(this.hvY);
        }
    }

    private void bMz() {
        if (this.hvZ == null) {
            this.hvZ = (RelativeLayout) LayoutInflater.from(this.hpc).inflate(d.h.new_pb_title, (ViewGroup) null);
            this.hwd = (ImageView) this.hvZ.findViewById(d.g.pb_thread_type_stamp_title_bottom_part);
            this.hwd.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(d.e.tbds194));
            this.hwd.setImageMatrix(matrix);
            this.hwa = (TextView) this.hvZ.findViewById(d.g.tv_pb_title);
            this.hwa.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_link_tip_c));
            this.hwa.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hwa.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.al.j(this.hwa, d.C0236d.cp_cont_b);
            this.hwa.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hwa.setVisibility(8);
            if (this.hwa.getParent() == null) {
                this.hvZ.addView(this.hwa);
            }
            this.hvZ.setOnTouchListener(this.cbY);
            this.hvZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        if (this.hpc.bJP()) {
            this.hvW = (ViewStub) this.hpc.findViewById(d.g.manga_mention_controller_view_stub);
            this.hvW.setVisibility(0);
            if (this.hwz == null) {
                this.hwz = (LinearLayout) this.hpc.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.hpc.getPageContext(), this.hwz);
            }
            if (this.hwA == null) {
                this.hwA = (TextView) this.hwz.findViewById(d.g.manga_prev_btn);
            }
            if (this.hwB == null) {
                this.hwB = (TextView) this.hwz.findViewById(d.g.manga_next_btn);
            }
            this.hwA.setOnClickListener(this.faZ);
            this.hwB.setOnClickListener(this.faZ);
        }
    }

    private void bMB() {
        if (this.hpc.bJP()) {
            if (this.hpc.bJS() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwA, d.C0236d.cp_cont_e, 1);
            }
            if (this.hpc.bJT() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwB, d.C0236d.cp_cont_e, 1);
            }
        }
    }

    public void bMC() {
        if (this.hwz == null) {
            bMA();
        }
        this.hvW.setVisibility(8);
        if (this.hyn != null && this.hyo != null) {
            this.hyn.removeCallbacks(this.hyo);
        }
    }

    public void bMD() {
        if (this.hyn != null) {
            if (this.hyo != null) {
                this.hyn.removeCallbacks(this.hyo);
            }
            this.hyo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hwz == null) {
                        aq.this.bMA();
                    }
                    aq.this.hvW.setVisibility(0);
                }
            };
            this.hyn.postDelayed(this.hyo, 2000L);
        }
    }

    public void nM(boolean z) {
        this.hvT.nM(z);
        if (z && this.hxn) {
            this.ffg.setText(this.hpc.getResources().getString(d.j.click_load_more));
            this.hvX.setNextPage(this.ffg);
            this.hvS = 2;
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
                        aq.this.mPermissionJudgePolicy.e(aq.this.hpc, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.Y(aq.this.hpc)) {
                            aq.this.hpc.bJm().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hpc.bJm().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bMm();
        this.hpc.bJm().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.VM != null && aq.this.VM.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hya == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.VM.getId());
                            aq.this.hya = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hpc.getPageContext(), aq.this.eCz, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.T(aq.this.hxZ)) {
                                aq.this.hya.setData(aq.this.hxZ);
                            }
                            aq.this.hya.b(aq.this.VM);
                        }
                        aq.this.hya.Af(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hpc.hnh != null && aq.this.hpc.hnh.bNy() != null) {
                    if (!aq.this.hpc.hnh.bNy().cnO()) {
                        aq.this.hpc.hnh.nZ(false);
                    }
                    aq.this.hpc.hnh.bNy().qV(false);
                }
            }
        });
    }

    public void bME() {
        if (this.hpc != null && this.VM != null) {
            this.VM.qT();
            if (this.hpc.bJm() != null) {
                this.hpc.bJm().amx();
            }
            bNi();
        }
    }

    public void nN(boolean z) {
        if (this.hvX != null && this.ahH != null && this.fbm != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fbm.setVisibility(0);
                } else {
                    this.fbm.setVisibility(8);
                    this.hvX.removeHeaderView(this.ahH);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ahH.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hxy;
                    this.ahH.setLayoutParams(layoutParams);
                }
                bMS();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ahH.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + nW(true);
                this.ahH.setLayoutParams(layoutParams2);
            }
            bMS();
            bNq();
        }
    }

    public f bMF() {
        return this.hwG;
    }

    public void a(PbActivity.d dVar) {
        this.hoh = dVar;
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
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hpc);
        iVar.setTitleText(this.hpc.getString(d.j.bar_manager));
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwO.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hyq != null) {
                                aq.this.hyq.m(new Object[]{sparseArray2.get(d.g.tag_manage_user_identity), sparseArray2.get(d.g.tag_forbid_user_name), sparseArray2.get(d.g.tag_forbid_user_post_id), sparseArray2.get(d.g.tag_forbid_user_name_show), sparseArray2.get(d.g.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hpc.a(z, (String) sparseArray2.get(d.g.tag_user_mute_mute_userid), sparseArray2);
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
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hpc.getString(d.j.delete_post), iVar);
            } else {
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hpc.getString(d.j.delete), iVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
            sparseArray2.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
            sparseArray2.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
            sparseArray2.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            fVar2.mTextView.setTag(sparseArray2);
            arrayList.add(fVar2);
        }
        if ((!"".equals(sparseArray.get(d.g.tag_forbid_user_name)) || !"".equals(sparseArray.get(d.g.tag_forbid_user_name_show))) && !bNp()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray3.put(d.g.tag_forbid_user_name_show, sparseArray.get(d.g.tag_forbid_user_name_show));
            sparseArray3.put(d.g.tag_forbid_user_portrait, sparseArray.get(d.g.tag_forbid_user_portrait));
            sparseArray3.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray3.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(1, this.hpc.getString(d.j.forbidden_person), iVar);
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
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hpc.getString(d.j.un_mute), iVar);
            } else {
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hpc.getString(d.j.mute), iVar);
            }
            fVar.mTextView.setTag(sparseArray4);
            arrayList.add(fVar);
        }
        iVar.P(arrayList);
        if (this.hwO == null) {
            this.hwO = new com.baidu.tbadk.core.dialog.g(this.hpc.getPageContext(), iVar.abk());
        } else {
            this.hwO.setContentView(iVar.abk());
        }
        this.hwO.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hyq = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hpc != null && aVar != null) {
            if (this.fzE == null) {
                this.fzE = new com.baidu.tieba.NEGFeedBack.e(this.hpc.getPageContext(), this.hvY);
            }
            AntiData bbI = this.hpc.bbI();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bbI != null && bbI.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbI.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.b(sparseArray);
            this.fzE.setDefaultReasonArray(new String[]{this.hpc.getString(d.j.delete_thread_reason_1), this.hpc.getString(d.j.delete_thread_reason_2), this.hpc.getString(d.j.delete_thread_reason_3), this.hpc.getString(d.j.delete_thread_reason_4), this.hpc.getString(d.j.delete_thread_reason_5)});
            this.fzE.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fzE.qj(str);
            this.fzE.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray) {
                    aq.this.hpc.a(aVar, jSONArray);
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
        sparseArray.put(hxF, Integer.valueOf(hxG));
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
        this.hwQ = new com.baidu.tbadk.core.dialog.a(this.hpc.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hwQ.gD(i3);
        } else {
            this.hwQ.dv(false);
            this.hwQ.ly(str2);
        }
        this.hwQ.ab(sparseArray);
        this.hwQ.a(d.j.dialog_ok, this.hpc);
        this.hwQ.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwQ.dq(true);
        this.hwQ.b(this.hpc.getPageContext());
        if (z) {
            this.hwQ.aaZ();
        } else {
            a(this.hwQ, i);
        }
    }

    public void at(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hwT == null) {
            this.hwT = LayoutInflater.from(this.hpc.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.hpc.getLayoutMode().onModeChanged(this.hwT);
        if (this.hwS == null) {
            this.hwS = new Dialog(this.hpc.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hwS.setCanceledOnTouchOutside(true);
            this.hwS.setCancelable(true);
            this.hxb = (ScrollView) this.hwT.findViewById(d.g.good_scroll);
            this.hwS.setContentView(this.hwT);
            WindowManager.LayoutParams attributes = this.hwS.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.hpc.getPageContext().getPageActivity(), d.e.ds540);
            this.hwS.getWindow().setAttributes(attributes);
            this.eky = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hwX = (String) compoundButton.getTag();
                        if (aq.this.ekx != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.ekx) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hwX != null && !str.equals(aq.this.hwX)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hwU = (LinearLayout) this.hwT.findViewById(d.g.good_class_group);
            this.hwW = (TextView) this.hwT.findViewById(d.g.dialog_button_cancel);
            this.hwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hwS instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hwS, aq.this.hpc.getPageContext());
                    }
                }
            });
            this.hwV = (TextView) this.hwT.findViewById(d.g.dialog_button_ok);
            this.hwV.setOnClickListener(this.faZ);
        }
        this.hwU.removeAllViews();
        this.ekx = new ArrayList();
        CustomBlueCheckRadioButton dz = dz("0", this.hpc.getPageContext().getString(d.j.thread_good_class));
        this.ekx.add(dz);
        dz.setChecked(true);
        this.hwU.addView(dz);
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
                    View view = new View(this.hpc.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.hpc.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.al.l(view, d.C0236d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hwU.addView(view);
                    this.hwU.addView(dz2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hxb.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hpc.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hpc.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hpc.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hxb.setLayoutParams(layoutParams2);
            this.hxb.removeAllViews();
            if (this.hwU != null && this.hwU.getParent() == null) {
                this.hxb.addView(this.hwU);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hwS, this.hpc.getPageContext());
    }

    private CustomBlueCheckRadioButton dz(String str, String str2) {
        Activity pageActivity = this.hpc.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.eky);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bMG() {
        this.hpc.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hpc.hideProgressBar();
        if (z && z2) {
            this.hpc.showToast(this.hpc.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.hpc.showToast(str);
        }
    }

    public void buo() {
        this.hwM.setVisibility(0);
    }

    public void bun() {
        this.hwM.setVisibility(8);
    }

    public View bMH() {
        if (this.hwT != null) {
            return this.hwT.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bMI() {
        return this.hwX;
    }

    public View getView() {
        return this.eCz;
    }

    public void bMJ() {
        com.baidu.adp.lib.util.l.b(this.hpc.getPageContext().getPageActivity(), this.hpc.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hpc.hideProgressBar();
        if (z) {
            bMZ();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bNa();
        } else {
            bMZ();
        }
    }

    public void bMK() {
        this.ffg.aey();
        this.ffg.aeC();
    }

    public void bML() {
        this.hpc.hideProgressBar();
        aeD();
        this.hvX.completePullRefreshPostDelayed(0L);
        bMW();
    }

    public void bMM() {
        this.hvX.completePullRefreshPostDelayed(0L);
        bMW();
    }

    private void nO(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hwG.setOnLongClickListener(onLongClickListener);
        if (this.hyb != null) {
            this.hyb.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0191b interfaceC0191b, boolean z, boolean z2) {
        if (this.hni != null) {
            this.hni.dismiss();
            this.hni = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hpc);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hpc.getPageContext().getString(d.j.copy), iVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hpc.getPageContext().getString(d.j.report_text), iVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hpc.getPageContext().getString(d.j.mark), iVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hpc.getPageContext().getString(d.j.remove_mark), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwY.dismiss();
                interfaceC0191b.a(null, i, view);
            }
        });
        this.hwY = new com.baidu.tbadk.core.dialog.g(this.hpc.getPageContext(), iVar.abk());
        this.hwY.showDialog();
    }

    public void a(final b.InterfaceC0191b interfaceC0191b, boolean z) {
        if (this.hwY != null) {
            this.hwY.dismiss();
            this.hwY = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hpc);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hpc.getPageContext().getString(d.j.save_to_emotion), iVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hpc.getPageContext().getString(d.j.save_to_local), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwY.dismiss();
                interfaceC0191b.a(null, i, view);
            }
        });
        this.hwY = new com.baidu.tbadk.core.dialog.g(this.hpc.getPageContext(), iVar.abk());
        this.hwY.showDialog();
    }

    public int bMN() {
        return wy(this.hvX.getFirstVisiblePosition());
    }

    private int wy(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hvX.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hvX.getAdapter() == null || !(this.hvX.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hvX.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bMO() {
        int lastVisiblePosition = this.hvX.getLastVisiblePosition();
        if (this.hvN != null) {
            if (lastVisiblePosition == this.hvX.getCount() - 1) {
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
        if (this.hvX != null) {
            if (this.hvT == null || this.hvT.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hvT.mNavigationBar.getFixedNavHeight();
                if (!(this.hpc.bJD() != -1)) {
                    if (this.hxw != null && (layoutParams = (LinearLayout.LayoutParams) this.hxw.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hxw.setLayoutParams(layoutParams);
                    }
                    i--;
                    bNu();
                }
                i2 = fixedNavHeight;
            }
            this.hvX.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hvX.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hvX.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hwJ.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hwG.a(dVar, false);
        this.hwG.notifyDataSetChanged();
        bMW();
        if (this.hyb != null) {
            this.hyb.bIW();
        }
        ArrayList<PostData> bIb = dVar.bIb();
        if (dVar.getPage().XK() == 0 || bIb == null || bIb.size() < dVar.getPage().XJ()) {
            if (com.baidu.tbadk.core.util.v.S(bIb) == 0 || (com.baidu.tbadk.core.util.v.S(bIb) == 1 && bIb.get(0) != null && bIb.get(0).ceq() == 1)) {
                if (this.hxB == null || this.hxB.hyK == null || this.hxB.hyK.getView() == null) {
                    i = 0;
                } else {
                    i = this.hxB.hyK.getView().getTop() < 0 ? this.hxB.hyK.getView().getHeight() : this.hxB.hyK.getView().getBottom();
                }
                if (this.hpc.bKb()) {
                    this.ffg.aa(this.hpc.getResources().getString(d.j.pb_no_host_reply), i);
                } else {
                    this.ffg.aa(this.hpc.getResources().getString(d.j.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().XK() == 0) {
                    this.ffg.setText(this.hpc.getResources().getString(d.j.list_has_no_more));
                } else {
                    this.ffg.setText(this.hpc.getResources().getString(d.j.load_more));
                }
                this.ffg.aeH();
            }
        }
        q(dVar);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (this.hwp == null) {
            this.hpc.getLayoutMode().onModeChanged(((ViewStub) this.hvY.findViewById(d.g.praise_layout)).inflate());
            this.hwp = (FrsPraiseView) this.hvY.findViewById(d.g.pb_head_praise_view);
            this.hwp.setIsFromPb(true);
            this.hwE = this.hvY.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.hwp.ij(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hwp != null) {
            boolean bMW = bMW();
            this.hwp.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().XL() == 0 && this.hpt) {
                if (bMW) {
                    this.hwD.setVisibility(0);
                    return;
                } else {
                    this.hwD.setVisibility(8);
                    return;
                }
            }
            this.hwD.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bIj() != null) {
            return dVar.bIj();
        }
        if (!com.baidu.tbadk.core.util.v.T(dVar.bIb())) {
            Iterator<PostData> it = dVar.bIb().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.ceq() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bIg();
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
        if (dVar == null || dVar.bHZ() == null || dVar.bHZ().YR() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData YR = dVar.bHZ().YR();
        String userId = YR.getUserId();
        HashMap<String, MetaData> userMap = dVar.bHZ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = YR;
        }
        postData.zu(1);
        postData.setId(dVar.bHZ().Zh());
        postData.setTitle(dVar.bHZ().getTitle());
        postData.setTime(dVar.bHZ().getCreateTime());
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
        com.baidu.tbadk.data.f cet;
        String portrait;
        if (dVar != null && dVar.bHZ() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hwf.setVisibility(8);
            if (dVar.bHZ() != null && dVar.bHZ().ZL() && dVar.bHZ().Zi() != null) {
                this.hxQ = true;
                this.hvT.oj(this.hxQ);
                this.hvT.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1") && com.baidu.adp.lib.util.l.aQ(this.hpc) < this.eCz.getHeight()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eCz.getLayoutParams();
                    layoutParams.height = com.baidu.adp.lib.util.l.aQ(this.hpc);
                    this.eCz.setLayoutParams(layoutParams);
                }
                if (this.hvN == null) {
                    this.hvN = new com.baidu.tieba.pb.video.i(this.hpc, this.hvT, dVar.bHZ().Zi(), this.hvO);
                    this.hvN.a(dVar.bHZ().Zi(), dVar.bHZ(), dVar.getForumId());
                    this.hvN.startPlay();
                } else if (this.hvR) {
                    this.hvN.a(dVar.bHZ().Zi(), dVar.bHZ(), dVar.getForumId());
                    this.hvN.startPlay();
                } else {
                    this.hvN.Ar(dVar.getForumId());
                }
                if (dVar.bIa() != null && dVar.bIa().size() >= 1) {
                    bg bgVar = dVar.bIa().get(0);
                    this.hvN.aE(bgVar);
                    this.hvN.As(bgVar.getTitle());
                }
                this.hvN.b(c, dVar.bHZ(), dVar.bIw());
                this.hvR = false;
                this.hvX.removeHeaderView(this.hvN.bPl());
                this.hvX.addHeaderView(this.hvN.bPl(), 0);
                if (this.hvN.aBC() != null && this.hvN.aBC().getParent() == null) {
                    this.hxu.addView(this.hvN.aBC());
                }
                if (this.hvP == null) {
                    this.hvP = new com.baidu.tieba.pb.video.h(this.hpc);
                }
                this.hvP.a(dVar.bHZ().aab(), dVar.bHZ(), dVar.bIt());
                this.hvX.removeHeaderView(this.hvP.bPa());
                this.hvX.addHeaderView(this.hvP.bPa(), 1);
                if (dVar.bHZ().aab() != null) {
                    this.hvX.removeHeaderView(this.hvP.bPb());
                    this.hvX.removeHeaderView(this.hwb);
                    this.hvX.addHeaderView(this.hvP.bPb(), 2);
                } else {
                    if (this.hvP.bPb() != null) {
                        this.hvX.removeHeaderView(this.hvP.bPb());
                    }
                    this.hvX.removeHeaderView(this.hwb);
                    this.hvX.addHeaderView(this.hwb, 2);
                }
                if (this.hvN != null) {
                    this.hvT.of(false);
                    this.hvN.wG(TbadkCoreApplication.getInst().getSkinType());
                }
                bMS();
            } else {
                this.hxQ = false;
                this.hvT.oj(this.hxQ);
                if (this.hvN != null) {
                    this.hvX.removeHeaderView(this.hvN.bPl());
                }
                if (this.hvP != null) {
                    this.hvP.b(this.hvX);
                }
            }
            if (this.hpc.bJp() != null) {
                this.hpc.bJp().od(this.hxQ);
            }
            if (this.hvN != null) {
                this.hvN.N(this.hys);
                bNu();
            }
            if (c != null) {
                this.hxm = c;
                this.hwf.setVisibility(0);
                if (this.hpc.bIQ()) {
                    if (dVar.bHY() != null) {
                        this.mForumName = dVar.bHY().getForumName();
                        this.mForumId = dVar.bHY().getForumId();
                    }
                    if (this.mForumName == null && this.hpc.bJa() != null && this.hpc.bJa().bIR() != null) {
                        this.mForumName = this.hpc.bJa().bIR();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hwf.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hwf.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, c);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.hyh) {
                    this.hvZ.setVisibility(0);
                }
                if (!dVar.bHZ().ZL() && this.hwa.getText() != null && this.hwa.getText().length() > 0) {
                    this.hwa.setVisibility(0);
                } else {
                    this.hwa.setVisibility(8);
                }
                p(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> Zc = dVar.bHZ().Zc();
                if (Zc != null && Zc.size() > 0 && !this.hyh) {
                    this.hxp.setText(String.valueOf(Zc.get(0).WY()));
                    this.hxo.setVisibility(0);
                } else {
                    this.hxo.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.k(this.hxo, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.d(this.hxp, d.C0236d.cp_link_tip_d, 1);
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
                            if (this.hqq != null) {
                                this.hqq.setTag(d.g.tag_user_id, c.YR().getUserId());
                                this.hqq.setOnClickListener(this.hpc.hnd.hAk);
                                this.hqq.a(iconInfo, 4, this.hpc.getResources().getDimensionPixelSize(d.e.tbds36), this.hpc.getResources().getDimensionPixelSize(d.e.tbds36), this.hpc.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.hqp != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hqp.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hqp.setOnClickListener(this.hpc.hnd.hAl);
                                this.hqp.a(tShowInfoNew, 3, this.hpc.getResources().getDimensionPixelSize(d.e.tbds36), this.hpc.getResources().getDimensionPixelSize(d.e.tbds36), this.hpc.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.hwh.setText(bN(c.YR().getSealPrefix(), g));
                            this.hwh.setTag(d.g.tag_user_id, c.YR().getUserId());
                            this.hwh.setTag(d.g.tag_user_name, c.YR().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew) || c.YR().isBigV()) {
                                com.baidu.tbadk.core.util.al.d(this.hwh, d.C0236d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.d(this.hwh, d.C0236d.cp_cont_b, 1);
                            }
                            if (c.YR() == null) {
                                MetaData YR = c.YR();
                                if (YR.getIs_bawu() == 1 && "manager".equals(YR.getBawu_type())) {
                                    this.hwi.setText(d.j.bawu_member_bazhu_tip);
                                    this.hwi.setVisibility(0);
                                } else if (YR.getIs_bawu() == 1 && "assist".equals(YR.getBawu_type())) {
                                    this.hwi.setText(d.j.bawu_member_xbazhu_tip);
                                    this.hwi.setVisibility(0);
                                } else {
                                    this.hwi.setVisibility(8);
                                }
                            } else {
                                this.hwi.setVisibility(8);
                            }
                            if (dVar.bHZ().YR() != null && dVar.bHZ().YR().getAlaUserData() != null && this.hwn != null) {
                                if (dVar.bHZ().YR().getAlaUserData().anchor_live != 0) {
                                    this.hwn.setVisibility(8);
                                } else {
                                    this.hwn.setVisibility(0);
                                    if (this.hvQ == null) {
                                        this.hvQ = new com.baidu.tieba.c.d(this.hpc.getPageContext(), this.hwn);
                                        this.hvQ.oM(1);
                                    }
                                    this.hvQ.cu(this.hpc.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bsI = dVar.bHZ().YR().getAlaUserData();
                                    aVar.type = 2;
                                    this.hwn.setTag(aVar);
                                }
                            }
                            this.hwm.setUserId(c.YR().getUserId());
                            this.hwm.setUserName(c.YR().getUserName());
                            this.hwm.setTid(c.getId());
                            this.hwm.setFid(this.hsv == null ? this.hsv.getForumId() : "");
                            this.hwm.setImageDrawable(null);
                            this.hwm.setRadius(com.baidu.adp.lib.util.l.h(this.hpc.getActivity(), d.e.ds40));
                            this.hwm.setTag(c.YR().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hwu.setText(com.baidu.tbadk.core.util.ap.aq(c.getTime()));
                            } else {
                                this.hwu.setText(com.baidu.tbadk.core.util.ap.ao(c.getTime()));
                            }
                            cet = c.cet();
                            if (cet == null && !TextUtils.isEmpty(cet.getName()) && !TextUtils.isEmpty(cet.getName().trim())) {
                                final String name = cet.getName();
                                final String lat = cet.getLat();
                                final String lng = cet.getLng();
                                this.hwv.setVisibility(0);
                                this.hww.setVisibility(0);
                                this.hwv.setText(cet.getName());
                                this.hwv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kY()) {
                                                aq.this.hpc.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ar(aq.this.hpc.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, aq.this.hpc.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.hwv.setVisibility(8);
                                this.hww.setVisibility(8);
                            }
                            portrait = c.YR().getPortrait();
                            if (c.YR().getPendantData() == null && !StringUtils.isNull(c.YR().getPendantData().Xn())) {
                                this.hwk.b(c.YR());
                                this.hwm.setVisibility(8);
                                this.hwk.setVisibility(0);
                                if (this.hwq != null) {
                                    this.hwq.setVisibility(8);
                                }
                                this.hwh.setOnClickListener(this.hys);
                                this.hwk.getHeadView().startLoad(portrait, 28, false);
                                this.hwk.getHeadView().setUserId(c.YR().getUserId());
                                this.hwk.getHeadView().setUserName(c.YR().getUserName());
                                this.hwk.getHeadView().setTid(c.getId());
                                this.hwk.getHeadView().setFid(this.hsv != null ? this.hsv.getForumId() : "");
                                this.hwk.getHeadView().setOnClickListener(this.hys);
                                this.hwk.nm(c.YR().getPendantData().Xn());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hwm, c.YR());
                                this.hwm.setVisibility(0);
                                this.hwf.setOnClickListener(this.hys);
                                this.hwh.setOnClickListener(this.hys);
                                this.hwm.setOnClickListener(this.hys);
                                this.hwk.setVisibility(8);
                                this.hwm.startLoad(portrait, 28, false);
                            }
                            String name_show = c.YR().getName_show();
                            String userName = c.YR().getUserName();
                            if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                                this.hwh.setText(com.baidu.tieba.pb.c.aQ(this.hpc.getPageContext().getPageActivity(), this.hwh.getText().toString()));
                                this.hwh.setGravity(16);
                                this.hwh.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHK());
                                com.baidu.tbadk.core.util.al.d(this.hwh, d.C0236d.cp_other_e, 1);
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo2 = c.YR().getIconInfo();
                        tShowInfoNew = c.YR().getTShowInfoNew();
                        if (this.hqq != null) {
                        }
                        if (this.hqp != null) {
                        }
                        this.hwh.setText(bN(c.YR().getSealPrefix(), g));
                        this.hwh.setTag(d.g.tag_user_id, c.YR().getUserId());
                        this.hwh.setTag(d.g.tag_user_name, c.YR().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hwh, d.C0236d.cp_cont_h, 1);
                        if (c.YR() == null) {
                        }
                        if (dVar.bHZ().YR() != null) {
                            if (dVar.bHZ().YR().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hwm.setUserId(c.YR().getUserId());
                        this.hwm.setUserName(c.YR().getUserName());
                        this.hwm.setTid(c.getId());
                        this.hwm.setFid(this.hsv == null ? this.hsv.getForumId() : "");
                        this.hwm.setImageDrawable(null);
                        this.hwm.setRadius(com.baidu.adp.lib.util.l.h(this.hpc.getActivity(), d.e.ds40));
                        this.hwm.setTag(c.YR().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cet = c.cet();
                        if (cet == null) {
                        }
                        this.hwv.setVisibility(8);
                        this.hww.setVisibility(8);
                        portrait = c.YR().getPortrait();
                        if (c.YR().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hwm, c.YR());
                        this.hwm.setVisibility(0);
                        this.hwf.setOnClickListener(this.hys);
                        this.hwh.setOnClickListener(this.hys);
                        this.hwm.setOnClickListener(this.hys);
                        this.hwk.setVisibility(8);
                        this.hwm.startLoad(portrait, 28, false);
                        String name_show2 = c.YR().getName_show();
                        String userName2 = c.YR().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                            this.hwh.setText(com.baidu.tieba.pb.c.aQ(this.hpc.getPageContext().getPageActivity(), this.hwh.getText().toString()));
                            this.hwh.setGravity(16);
                            this.hwh.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHK());
                            com.baidu.tbadk.core.util.al.d(this.hwh, d.C0236d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            g = com.baidu.tbadk.core.util.ap.g(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.YR().getIconInfo();
                            tShowInfoNew = c.YR().getTShowInfoNew();
                            if (this.hqq != null) {
                            }
                            if (this.hqp != null) {
                            }
                            this.hwh.setText(bN(c.YR().getSealPrefix(), g));
                            this.hwh.setTag(d.g.tag_user_id, c.YR().getUserId());
                            this.hwh.setTag(d.g.tag_user_name, c.YR().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.d(this.hwh, d.C0236d.cp_cont_h, 1);
                            if (c.YR() == null) {
                            }
                            if (dVar.bHZ().YR() != null) {
                            }
                            this.hwm.setUserId(c.YR().getUserId());
                            this.hwm.setUserName(c.YR().getUserName());
                            this.hwm.setTid(c.getId());
                            this.hwm.setFid(this.hsv == null ? this.hsv.getForumId() : "");
                            this.hwm.setImageDrawable(null);
                            this.hwm.setRadius(com.baidu.adp.lib.util.l.h(this.hpc.getActivity(), d.e.ds40));
                            this.hwm.setTag(c.YR().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            cet = c.cet();
                            if (cet == null) {
                            }
                            this.hwv.setVisibility(8);
                            this.hww.setVisibility(8);
                            portrait = c.YR().getPortrait();
                            if (c.YR().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hwm, c.YR());
                            this.hwm.setVisibility(0);
                            this.hwf.setOnClickListener(this.hys);
                            this.hwh.setOnClickListener(this.hys);
                            this.hwm.setOnClickListener(this.hys);
                            this.hwk.setVisibility(8);
                            this.hwm.startLoad(portrait, 28, false);
                            String name_show22 = c.YR().getName_show();
                            String userName22 = c.YR().getUserName();
                            if (com.baidu.tbadk.s.ao.jK()) {
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo222 = c.YR().getIconInfo();
                        tShowInfoNew = c.YR().getTShowInfoNew();
                        if (this.hqq != null) {
                        }
                        if (this.hqp != null) {
                        }
                        this.hwh.setText(bN(c.YR().getSealPrefix(), g));
                        this.hwh.setTag(d.g.tag_user_id, c.YR().getUserId());
                        this.hwh.setTag(d.g.tag_user_name, c.YR().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hwh, d.C0236d.cp_cont_h, 1);
                        if (c.YR() == null) {
                        }
                        if (dVar.bHZ().YR() != null) {
                        }
                        this.hwm.setUserId(c.YR().getUserId());
                        this.hwm.setUserName(c.YR().getUserName());
                        this.hwm.setTid(c.getId());
                        this.hwm.setFid(this.hsv == null ? this.hsv.getForumId() : "");
                        this.hwm.setImageDrawable(null);
                        this.hwm.setRadius(com.baidu.adp.lib.util.l.h(this.hpc.getActivity(), d.e.ds40));
                        this.hwm.setTag(c.YR().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cet = c.cet();
                        if (cet == null) {
                        }
                        this.hwv.setVisibility(8);
                        this.hww.setVisibility(8);
                        portrait = c.YR().getPortrait();
                        if (c.YR().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hwm, c.YR());
                        this.hwm.setVisibility(0);
                        this.hwf.setOnClickListener(this.hys);
                        this.hwh.setOnClickListener(this.hys);
                        this.hwm.setOnClickListener(this.hys);
                        this.hwk.setVisibility(8);
                        this.hwm.startLoad(portrait, 28, false);
                        String name_show222 = c.YR().getName_show();
                        String userName222 = c.YR().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hwe.aw(dVar.bHZ());
                }
                if (this.hxx != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hkG);
                    if (dVar != null && dVar.bHZ() != null) {
                        hVar.hkI = dVar.bHZ().YI();
                    }
                    hVar.isNew = !this.hpt;
                    hVar.sortType = dVar.hkw;
                    if (dVar.hkv != null && dVar.hkv.size() > dVar.hkw) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hkv.size()) {
                                break;
                            } else if (dVar.hkv.get(i4).sort_type.intValue() != dVar.hkw) {
                                i3 = i4 + 1;
                            } else {
                                hVar.hkK = dVar.hkv.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.hkL = this.hpc.bKb();
                    this.hxx.a(hVar);
                }
                if (dVar != null && dVar.bHZ() != null) {
                    ab(dVar.bHZ().YN() == 1, dVar.bHZ().YM() == 1);
                }
                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hwG != null && aq.this.hvT != null && aq.this.hvT.hAW != null && aq.this.hsv != null && aq.this.hsv.bHZ() != null && !aq.this.hsv.bHZ().ZL() && !aq.this.bMV() && aq.this.hsv.getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(aq.this.hsv.getForum().getName())) {
                            if (aq.this.hwG.bKz() == null || !aq.this.hwG.bKz().isShown()) {
                                aq.this.hvT.hAW.setVisibility(0);
                                if (aq.this.hpc != null && aq.this.hpc.bJa() != null) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13400");
                                    amVar.bJ("tid", aq.this.hpc.bJa().bKR());
                                    amVar.bJ(ImageViewerConfig.FORUM_ID, aq.this.hpc.bJa().getForumId());
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
            bMP();
        } else {
            aWP();
        }
        this.hxB.hyK = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxB));
        a(this.hxB.hyK, false);
    }

    public void bMP() {
        if (this.hvT != null && !this.hxS) {
            this.hvT.ok(!StringUtils.isNull(this.hpc.bJA()));
            this.hxS = true;
        }
    }

    public void aWP() {
        if (this.hvT != null) {
            this.hvT.bNZ();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.Zm() != null) {
            this.hwg.setData(this.hpc.getPageContext(), dVar.bIb().get(0).Zm(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bHZ().getId(), this.hpc.bJY() ? "FRS" : null));
            this.hwf.setPadding(this.hwf.getPaddingLeft(), (int) this.hpc.getResources().getDimension(d.e.ds20), this.hwf.getPaddingRight(), this.hwf.getPaddingBottom());
            return;
        }
        this.hwg.setData(null, null, null);
    }

    public void bMQ() {
        if (this.hvN != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").T("obj_type", 1));
            this.hvN.bPj();
            this.hvX.smoothScrollToPosition(0);
        }
    }

    public boolean bMR() {
        return this.hyt;
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
            this.hvT.bNX();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hvT.xR(cVar.forumName);
            }
            String string = this.hpc.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.hpc.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.hpc.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.hpc.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hjP;
            this.hpc.showNetRefreshView(this.eCz, format, null, this.hpc.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.lo()) {
                        ba.adD().c(aq.this.hpc.getPageContext(), new String[]{str2});
                        aq.this.hpc.finish();
                        return;
                    }
                    aq.this.hpc.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bMb;
        Parcelable bMb2;
        if (dVar != null) {
            this.hsv = dVar;
            this.mType = i;
            if (dVar.bHZ() != null) {
                this.hxD = dVar.bHZ().Yz();
                if (dVar.bHZ().getAnchorLevel() != 0) {
                    this.hyt = true;
                }
                this.hxa = ay(dVar.bHZ());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            t(dVar);
            this.hxn = false;
            this.hpt = z;
            bML();
            b(dVar, z, i);
            r(dVar);
            if (this.hye == null) {
                this.hye = new ac(this.hpc.getPageContext(), this.bsn);
            }
            this.hye.zW(dVar.bIe());
            if (this.hpc.bJP()) {
                if (this.hwK == null) {
                    this.hwK = new com.baidu.tieba.pb.view.c(this.hpc.getPageContext());
                    this.hwK.oM();
                    this.hwK.setListPullRefreshListener(this.bRF);
                }
                this.hvX.setPullRefresh(this.hwK);
                bMS();
                if (this.hwK != null) {
                    this.hwK.ic(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().XL() == 0 && z) {
                this.hvX.setPullRefresh(null);
            } else {
                if (this.hwK == null) {
                    this.hwK = new com.baidu.tieba.pb.view.c(this.hpc.getPageContext());
                    this.hwK.oM();
                    this.hwK.setListPullRefreshListener(this.bRF);
                }
                this.hvX.setPullRefresh(this.hwK);
                bMS();
                if (this.hwK != null) {
                    this.hwK.ic(TbadkCoreApplication.getInst().getSkinType());
                }
                aME();
            }
            bMW();
            this.hwG.nd(this.hpt);
            this.hwG.ne(false);
            this.hwG.np(i == 5);
            this.hwG.nq(i == 6);
            this.hwG.nr(z2 && this.hyr);
            this.hwG.a(dVar, false);
            this.hwG.notifyDataSetChanged();
            if (this.hpc.bIQ()) {
                this.hxU = 0;
                PostData c = c(dVar, z);
                if (c != null && c.YR() != null) {
                    this.hxU = c.YR().getLevel_id();
                }
                if (this.hxU > 0) {
                    this.hwj.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.hwj, BitmapHelper.getGradeResourceIdInEnterForum(this.hxU));
                } else {
                    this.hwj.setVisibility(8);
                }
            } else {
                this.hwj.setVisibility(8);
            }
            if (dVar.bHZ() != null && dVar.bHZ().YD() != null) {
                if (dVar.bHZ().YD().getNum() < 1) {
                    this.hpc.getResources().getString(d.j.zan);
                } else {
                    String str = dVar.bHZ().YD().getNum() + "";
                }
                if (this.hvM != -1) {
                    dVar.bHZ().YD().setIsLike(this.hvM);
                }
            }
            if (this.hpc.isLogin()) {
                this.hvX.setNextPage(this.ffg);
                this.hvS = 2;
                aME();
            } else {
                this.hxn = true;
                if (dVar.getPage().XK() == 1) {
                    if (this.hwL == null) {
                        this.hwL = new com.baidu.tieba.pb.view.a(this.hpc.getPageContext());
                    }
                    this.hvX.setNextPage(this.hwL);
                } else {
                    this.hvX.setNextPage(this.ffg);
                }
                this.hvS = 3;
            }
            ArrayList<PostData> bIb = dVar.bIb();
            if (dVar.getPage().XK() == 0 || bIb == null || bIb.size() < dVar.getPage().XJ()) {
                if (com.baidu.tbadk.core.util.v.S(bIb) == 0 || (com.baidu.tbadk.core.util.v.S(bIb) == 1 && bIb.get(0) != null && bIb.get(0).ceq() == 1)) {
                    if (this.hxB == null || this.hxB.hyK == null || this.hxB.hyK.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hxB.hyK.getView().getTop() < 0 ? this.hxB.hyK.getView().getHeight() : this.hxB.hyK.getView().getBottom();
                    }
                    if (this.hpc.bKb()) {
                        this.ffg.aa(this.hpc.getResources().getString(d.j.pb_no_host_reply), i4);
                    } else {
                        this.ffg.aa(this.hpc.getResources().getString(d.j.pb_no_replay), i4);
                    }
                    if (this.hpc.bJp() != null && !this.hpc.bJp().bNM()) {
                        this.hpc.bJp().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().XK() == 0) {
                        this.ffg.setText(this.hpc.getResources().getString(d.j.list_has_no_more));
                    } else {
                        this.ffg.setText(this.hpc.getResources().getString(d.j.load_more));
                    }
                    this.ffg.aeH();
                }
                bNd();
            } else {
                if (z2) {
                    if (this.hyr) {
                        aeD();
                        if (dVar.getPage().XK() != 0) {
                            this.ffg.setText(this.hpc.getResources().getString(d.j.pb_load_more));
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
                    this.hvX.setSelection(i2 > 1 ? (((this.hvX.getData() == null && dVar.bIb() == null) ? 0 : (this.hvX.getData().size() - dVar.bIb().size()) + this.hvX.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bMb2 = aj.bMa().bMb()) != null) {
                        this.hvX.onRestoreInstanceState(bMb2);
                        if (com.baidu.tbadk.core.util.v.S(bIb) > 1 && dVar.getPage().XK() > 0) {
                            this.ffg.aeD();
                            this.ffg.setText(this.hpc.getString(d.j.pb_load_more_without_point));
                            this.ffg.aez();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hyr = false;
                    break;
                case 5:
                    this.hvX.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bMb = aj.bMa().bMb()) != null) {
                        this.hvX.onRestoreInstanceState(bMb);
                        break;
                    } else {
                        this.hvX.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.hvN != null && this.hvN.aBC() != null) {
                            if (this.hpc.isUseStyleImmersiveSticky()) {
                                this.hvX.setSelectionFromTop((this.hwG.bKu() + this.hvX.getHeaderViewsCount()) - 1, this.hvN.aBC().getHeight() - com.baidu.adp.lib.util.l.r(this.hpc.getPageContext().getPageActivity()));
                            } else {
                                this.hvX.setSelectionFromTop((this.hwG.bKu() + this.hvX.getHeaderViewsCount()) - 1, this.hvN.aBC().getHeight());
                            }
                        } else {
                            this.hvX.setSelection(this.hwG.bKu() + this.hvX.getHeaderViewsCount());
                        }
                    } else {
                        this.hvX.setSelection(i2 > 0 ? ((this.hvX.getData() == null && dVar.bIb() == null) ? 0 : (this.hvX.getData().size() - dVar.bIb().size()) + this.hvX.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.ffg.aeD();
                    this.ffg.setText(this.hpc.getString(d.j.pb_load_more_without_point));
                    this.ffg.aez();
                    break;
            }
            if (this.hxD == hxE && isHost()) {
                bNl();
            }
            if (this.hxO) {
                bMk();
                this.hxO = false;
                if (i3 == 0) {
                    nJ(true);
                }
            }
            if (this.hvP != null) {
                this.hvP.aD(dVar.bHZ());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hkt == 1 || dVar.hku == 1) {
                if (this.hxV == null) {
                    this.hxV = new PbTopTipView(this.hpc);
                }
                if (dVar.hku == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hpc.getStType())) {
                    this.hxV.setText(this.hpc.getString(d.j.pb_read_strategy_add_experience));
                    this.hxV.show(this.eCz, this.mSkinType);
                } else if (dVar.hkt == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hpc.getStType())) {
                    this.hxV.setText(this.hpc.getString(d.j.pb_read_news_add_experience));
                    this.hxV.show(this.eCz, this.mSkinType);
                }
            }
            q(dVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHZ() != null) {
            if (dVar.Vb()) {
                com.baidu.tbadk.core.util.al.c(this.hxg, d.f.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.al.c(this.hxg, d.f.icon_pb_bottom_collect_n);
            }
            String wA = wA(dVar.bHZ().YI());
            this.hxi.M(wA, wA == null);
            this.hxi.setVisibility(0);
        }
    }

    private String wA(int i) {
        if (i == 0) {
            return this.hpc.getString(d.j.pb_comment_red_dot_no_reply);
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

    private void bMS() {
        if (this.hvN != null && this.hvN.aBC() != null) {
            this.hvX.removeHeaderView(this.ahH);
            if (this.mType != 1) {
                this.hvX.removeHeaderView(this.hvN.bPl());
                this.hvX.addHeaderView(this.hvN.bPl(), 0);
                return;
            }
            return;
        }
        if (this.hvN != null) {
            this.hvX.removeHeaderView(this.hvN.bPl());
        }
        this.hvX.removeHeaderView(this.ahH);
        this.hvX.addHeaderView(this.ahH, 0);
    }

    public void nQ(boolean z) {
        this.hwZ = z;
    }

    public void aeD() {
        if (this.ffg != null) {
            this.ffg.aez();
            this.ffg.aeD();
        }
        aME();
    }

    public void aOA() {
        this.hvX.setVisibility(0);
    }

    public void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hxm != null && this.hxm.YR() != null && this.hvT != null) {
            this.hxR = !this.hxQ;
            this.hvT.of(this.hxR);
            if (this.hpc.bJp() != null) {
                this.hpc.bJp().oe(this.hxR);
            }
            bMT();
            if (dVar.getForum() != null) {
                this.hvT.dA(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hxR) {
                if (this.hxa) {
                    this.hwr.setVisibility(8);
                    this.hwt.setVisibility(0);
                    this.hwt.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIv())));
                }
                if (this.hxw != null) {
                    this.hxw.setVisibility(8);
                }
                if (this.hyc == null) {
                    this.hyc = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hxT) {
                                aq.this.bNk();
                            }
                            aq.this.bMM();
                        }
                    };
                }
                this.hvX.setListViewDragListener(this.hyc);
                return;
            }
            if (this.hxw != null) {
                this.hxw.setVisibility(0);
            }
            if (this.hxa) {
                this.hwr.setVisibility(8);
                this.hwt.setVisibility(0);
                this.hwt.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIv())));
            } else if (!PbNormalLikeButtonSwitchStatic.apI() || (this.hxm.YR().hadConcerned() && this.hxm.YR().getGodUserData() != null && this.hxm.YR().getGodUserData().getIsFromNetWork())) {
                this.hwr.setVisibility(8);
                this.hwt.setVisibility(8);
            } else {
                this.hwt.setVisibility(8);
            }
            this.hyc = null;
            this.hvX.setListViewDragListener(null);
        }
    }

    private void bMT() {
        String threadId = this.hsv != null ? this.hsv.getThreadId() : "";
        int bMU = bMU();
        if (this.hxR && this.hxm != null && this.hxm.YR() != null) {
            this.hxm.YR().setIsLike(this.hxm.YR().hadConcerned());
        }
        if (this.hws == null) {
            this.hws = new ao(this.hpc.getPageContext(), this.hwr, 1);
            this.hws.i(this.hpc.getUniqueId());
            this.hws.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void dV(boolean z) {
                    if (aq.this.hpc != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hpc, d.j.attention_success);
                    }
                }
            });
        }
        if (this.hxm != null && this.hxm.YR() != null) {
            this.hxm.YR().setIsLike(this.hxm.YR().hadConcerned());
            this.hws.a(this.hxm.YR());
            this.hws.setTid(threadId);
        }
        this.hws.hvI = this.hxQ;
        this.hws.wx(bMU);
    }

    public int bMU() {
        if (this.hsv == null || this.hsv.bHZ() == null) {
            return 0;
        }
        if (this.hsv.bHZ().aaj()) {
            return (com.baidu.tbadk.core.util.v.T(this.hsv.bIu()) && (this.hsv.bHY() == null || StringUtils.isNull(this.hsv.bHY().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bMV() {
        return this.hsv == null || this.hsv.getForum() == null || "0".equals(this.hsv.getForum().getId()) || "me0407".equals(this.hsv.getForum().getName());
    }

    private boolean bMW() {
        boolean z;
        if (this.hxd != null && this.hxd.getVisibility() == 0) {
            if (this.hwC != null) {
                this.hwC.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hwC != null) {
                this.hwC.setVisibility(8);
            }
            z = false;
        }
        if ((this.hwE == null || this.hwE.getVisibility() == 8) && z && this.hpt) {
            this.hwD.setVisibility(0);
        } else {
            this.hwD.setVisibility(8);
        }
        return z;
    }

    private boolean s(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bHZ() == null) {
            return false;
        }
        if (dVar.bHZ().YO() == 1 || dVar.bHZ().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bHZ().YQ() == null || dVar.bHZ().YQ().aaO() == 0) || dVar.bHZ().YM() == 1 || dVar.bHZ().YN() == 1 || dVar.bHZ().ZC() || dVar.bHZ().ZR() || dVar.bHZ().ZK() || dVar.bHZ().Zd() != null || !com.baidu.tbadk.core.util.ap.isEmpty(dVar.bHZ().getCategory()) || dVar.bHZ().YU() || dVar.bHZ().YT();
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hpc.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hvZ != null) {
                if (dVar.bHZ() != null && dVar.bHZ().Zg() == 0 && !dVar.bHZ().ZL() && !this.hyh) {
                    this.hvZ.setVisibility(0);
                    if (dVar.bHZ() != null) {
                        bg bHZ = dVar.bHZ();
                        bHZ.k(true, s(dVar));
                        bHZ.setResource(3);
                        bHZ.li("2");
                    }
                    SpannableStringBuilder Zx = dVar.bHZ().Zx();
                    this.hwa.setOnTouchListener(new com.baidu.tieba.view.k(Zx));
                    this.hwa.setText(Zx);
                    this.hwa.setVisibility(0);
                } else if (dVar.bHZ().Zg() == 1) {
                    if (dVar.bHZ() != null) {
                        this.hvZ.setVisibility(8);
                        this.hvX.removeHeaderView(this.hvZ);
                    }
                } else {
                    this.hvZ.setVisibility(8);
                    this.hvX.removeHeaderView(this.hvZ);
                    if (dVar.bHZ() != null && dVar.bHZ().ZL()) {
                        this.hwf.setPadding(this.hwf.getPaddingLeft(), 0, this.hwf.getPaddingRight(), this.hwf.getPaddingBottom());
                        if (this.hwx != null) {
                            ((RelativeLayout.LayoutParams) this.hwx.getLayoutParams()).height = (int) this.hpc.getResources().getDimension(d.e.tbds36);
                            this.hwx.requestLayout();
                        }
                        if (this.hwy != null) {
                            ((RelativeLayout.LayoutParams) this.hwy.getLayoutParams()).height = (int) this.hpc.getResources().getDimension(d.e.tbds0);
                            this.hwy.requestLayout();
                        }
                    } else {
                        this.hwf.setPadding(this.hwf.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.hpc.getPageContext().getPageActivity(), d.e.ds48), this.hwf.getPaddingRight(), this.hwf.getPaddingBottom());
                    }
                }
            }
            if (dVar.bHZ() != null) {
                aa(dVar.bHZ().YN() == 1, dVar.bHZ().YM() == 1);
            }
            this.hpt = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bMW();
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
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.bIl()));
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
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.bIl()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bc> bIu = dVar.bIu();
                if (com.baidu.tbadk.core.util.v.S(bIu) > 0) {
                    sb = new StringBuilder();
                    for (bc bcVar : bIu) {
                        if (bcVar != null && !StringUtils.isNull(bcVar.getForumName()) && (vVar = bcVar.bAy) != null && vVar.byr && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(bcVar.getForumName(), 12)).append(this.hpc.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.hpc.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.cpF;
    }

    public void zX(String str) {
        if (this.ffg != null) {
            this.ffg.setText(str);
        }
    }

    public void zY(String str) {
        if (this.ffg != null) {
            int i = 0;
            if (this.hxB != null && this.hxB.hyK != null && this.hxB.hyK.getView() != null) {
                i = this.hxB.hyK.getView().getTop() < 0 ? this.hxB.hyK.getView().getHeight() : this.hxB.hyK.getView().getBottom();
            }
            this.ffg.aa(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hvX;
    }

    public int bMX() {
        return d.g.richText;
    }

    public TextView bJl() {
        return this.hwe.bJl();
    }

    public void e(BdListView.e eVar) {
        this.hvX.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.bRF = cVar;
        if (this.hwK != null) {
            this.hwK.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int XI = anVar.XI();
            int XF = anVar.XF();
            if (this.hwH != null) {
                this.hwH.aaZ();
            } else {
                this.hwH = new com.baidu.tbadk.core.dialog.a(this.hpc.getPageContext().getPageActivity());
                this.hwI = LayoutInflater.from(this.hpc.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.hwH.az(this.hwI);
                this.hwH.a(d.j.dialog_ok, bVar);
                this.hwH.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bMZ();
                        aVar.dismiss();
                    }
                });
                this.hwH.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hxL == null) {
                            aq.this.hxL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hpc.HidenSoftKeyPad((InputMethodManager) aq.this.hpc.getSystemService("input_method"), aq.this.eCz);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jH().postDelayed(aq.this.hxL, 150L);
                    }
                });
                this.hwH.b(this.hpc.getPageContext()).aaZ();
            }
            this.hwJ = (EditText) this.hwI.findViewById(d.g.input_page_number);
            this.hwJ.setText("");
            TextView textView = (TextView) this.hwI.findViewById(d.g.current_page_number);
            if (XI <= 0) {
                XI = 1;
            }
            if (XF <= 0) {
                XF = 1;
            }
            textView.setText(MessageFormat.format(this.hpc.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(XI), Integer.valueOf(XF)));
            this.hpc.ShowSoftKeyPadDelay(this.hwJ, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hvX.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hpc.showToast(str);
    }

    public boolean nR(boolean z) {
        if (this.VM == null || !this.VM.alW()) {
            return false;
        }
        this.VM.akq();
        return true;
    }

    public void bMY() {
        if (this.hyu != null) {
            while (this.hyu.size() > 0) {
                TbImageView remove = this.hyu.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bMY();
        this.hwG.wi(1);
        if (this.hvN != null) {
            this.hvN.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hwG.wi(2);
        if (this.hvN != null) {
            this.hvN.onResume();
            if (!UtilHelper.isOnePlus6()) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hxN != null) {
            this.hxN.destroy();
        }
        if (this.hye != null) {
            this.hye.onDestory();
        }
        if (this.hxV != null) {
            this.hxV.hide();
        }
        if (this.hvQ != null) {
            this.hvQ.aSr();
        }
        if (this.hvP != null) {
            this.hvP.onDestroy();
        }
        this.hpc.hideProgressBar();
        if (this.eCx != null && this.eWE != null) {
            this.eCx.b(this.eWE);
        }
        bMZ();
        aeD();
        if (this.hxL != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hxL);
        }
        if (this.hwf != null && this.hwq != null) {
            this.hwf.removeView(this.hwl);
            this.hwq = null;
        }
        if (this.hxr != null) {
            this.hxr.clearStatus();
        }
        this.hyn = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hwG.wi(3);
        if (this.fbm != null) {
            this.fbm.setBackgroundDrawable(null);
        }
        if (this.hvN != null) {
            this.hvN.destroy();
        }
        if (this.hwG != null) {
            this.hwG.onDestroy();
        }
        this.hvX.setOnLayoutListener(null);
        if (this.hya != null) {
            this.hya.beY();
        }
        if (this.hxC != null) {
            this.hxC.onDestroy();
        }
    }

    public boolean wB(int i) {
        if (this.hvN != null) {
            return this.hvN.qw(i);
        }
        return false;
    }

    public void bMZ() {
        this.hvT.Qk();
        if (this.hvQ != null) {
            this.hvQ.aSr();
        }
        com.baidu.adp.lib.util.l.b(this.hpc.getPageContext().getPageActivity(), this.hwJ);
        bMm();
        if (this.hni != null) {
            this.hni.dismiss();
        }
        bNb();
        if (this.hvP != null) {
            this.hvP.bPc();
        }
        if (this.hwH != null) {
            this.hwH.dismiss();
        }
        if (this.faY != null) {
            this.faY.dismiss();
        }
    }

    public void bNa() {
        this.hvT.Qk();
        if (this.hvQ != null) {
            this.hvQ.aSr();
        }
        if (this.hni != null) {
            this.hni.dismiss();
        }
        bNb();
        if (this.hvP != null) {
            this.hvP.bPc();
        }
        if (this.hwH != null) {
            this.hwH.dismiss();
        }
        if (this.faY != null) {
            this.faY.dismiss();
        }
    }

    public void dD(List<String> list) {
        this.hxZ = list;
        if (this.hya != null) {
            this.hya.setData(list);
        }
    }

    public void nc(boolean z) {
        this.hwG.nc(z);
    }

    public void nS(boolean z) {
        this.hxc = z;
    }

    public void bNb() {
        if (this.hwQ != null) {
            this.hwQ.dismiss();
        }
        if (this.hwR != null) {
            com.baidu.adp.lib.g.g.b(this.hwR, this.hpc.getPageContext());
        }
        if (this.hwS != null) {
            com.baidu.adp.lib.g.g.b(this.hwS, this.hpc.getPageContext());
        }
        if (this.hwO != null) {
            this.hwO.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hsv, this.hpt);
            d(this.hsv, this.hpt, this.mType);
            this.hpc.getLayoutMode().setNightMode(i == 1);
            this.hpc.getLayoutMode().onModeChanged(this.eCz);
            this.hpc.getLayoutMode().onModeChanged(this.hvY);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.al.l(this.eCz, d.C0236d.cp_bg_line_d);
            }
            if (this.hvP != null) {
                this.hvP.onChangeSkinType(i);
            }
            if (this.hwa != null) {
                com.baidu.tbadk.core.util.al.j(this.hwa, d.C0236d.cp_cont_b);
                this.hwa.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_link_tip_c));
            }
            if (this.ffg != null) {
                this.ffg.ic(i);
                if (this.cpF != null) {
                    this.hpc.getLayoutMode().onModeChanged(this.cpF);
                    com.baidu.tbadk.core.util.al.k(this.cpF, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.hwH != null) {
                this.hwH.c(this.hpc.getPageContext());
            }
            nQ(this.hwZ);
            this.hwG.notifyDataSetChanged();
            if (this.hwK != null) {
                this.hwK.ic(i);
            }
            if (this.VM != null) {
                this.VM.onChangeSkinType(i);
            }
            if (this.hwp != null) {
                this.hwp.ij(i);
            }
            if (this.hwL != null) {
                this.hwL.ic(i);
            }
            if (!com.baidu.tbadk.core.util.v.T(this.ekx)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ekx) {
                    customBlueCheckRadioButton.aeh();
                }
            }
            bMB();
            UtilHelper.setStatusBarBackground(this.fbm, i);
            UtilHelper.setStatusBarBackground(this.hxw, i);
            if (this.hwr != null) {
                this.hwr.onChangeSkinType(i);
            }
            if (this.hwv != null) {
                com.baidu.tbadk.core.util.al.j(this.hwv, d.C0236d.cp_cont_d);
            }
            if (this.hwu != null) {
                com.baidu.tbadk.core.util.al.j(this.hwu, d.C0236d.cp_cont_d);
            }
            if (this.hww != null) {
                com.baidu.tbadk.core.util.al.j(this.hww, d.C0236d.cp_cont_d);
            }
            if (this.hwi != null) {
                com.baidu.tbadk.core.util.al.j(this.hwi, d.C0236d.cp_link_tip_a);
            }
            if (this.hwt != null) {
                com.baidu.tbadk.core.util.al.j(this.hwt, d.C0236d.cp_cont_d);
            }
            if (this.hwz != null) {
                com.baidu.tbadk.r.a.a(this.hpc.getPageContext(), this.hwz);
            }
            if (this.hxM != null) {
                this.hxM.onChangeSkinType(i);
            }
            if (this.hvT != null) {
                if (this.hvN != null) {
                    this.hvN.wG(i);
                } else {
                    this.hvT.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fPf != null) {
                com.baidu.tbadk.core.util.al.j(this.fPf, d.C0236d.cp_cont_d);
                com.baidu.tbadk.core.util.al.k(this.fPf, d.f.bg_comment_input);
            }
            if (this.hxg != null && this.hsv != null) {
                if (this.hsv.Vb()) {
                    com.baidu.tbadk.core.util.al.c(this.hxg, d.f.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.hxg, d.f.icon_pb_bottom_collect_n);
                }
            }
            if (this.hxh != null) {
                com.baidu.tbadk.core.util.al.c(this.hxh, d.f.icon_pb_bottom_share_n);
            }
            if (this.hxf != null) {
                com.baidu.tbadk.core.util.al.c(this.hxf, d.f.icon_pb_bottom_comment_n);
            }
            if (this.hxi != null) {
                this.hxi.onChangeSkinType();
            }
            if (this.hwj != null) {
                com.baidu.tbadk.core.util.al.c(this.hwj, BitmapHelper.getGradeResourceIdInEnterForum(this.hxU));
            }
            if (this.hyb != null) {
                this.hyb.onChangeSkinType(i);
            }
            if (this.hxC != null) {
                this.hxC.onChangeSkinType();
            }
            if (this.hxX != null) {
                com.baidu.tbadk.core.util.al.j(this.hxX, d.C0236d.cp_cont_n);
            }
            com.baidu.tbadk.core.util.al.l(this.hxe, d.C0236d.cp_bg_line_d);
            if (this.hwi != null) {
                com.baidu.tbadk.core.util.al.k(this.hwi, d.f.bg_user_identity_btn);
                com.baidu.tbadk.core.util.al.j(this.hwi, d.C0236d.cp_bg_line_d);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
        this.hwG.setOnImageClickListener(this.cAE);
        this.hyb.setOnImageClickListener(this.cAE);
    }

    public void h(NoNetworkView.a aVar) {
        this.eWE = aVar;
        if (this.eCx != null) {
            this.eCx.a(this.eWE);
        }
    }

    public void nT(boolean z) {
        this.hwG.setIsFromCDN(z);
    }

    public Button bNc() {
        return this.hxd;
    }

    public void bNd() {
        if (this.hvS != 2) {
            this.hvX.setNextPage(this.ffg);
            this.hvS = 2;
        }
    }

    public void bNe() {
        if (com.baidu.tbadk.o.m.apl().apm()) {
            int lastVisiblePosition = this.hvX.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hvX.getChildAt(i);
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

    public boolean bNf() {
        return this.VM != null && this.VM.getVisibility() == 0;
    }

    public boolean bNg() {
        return this.VM != null && this.VM.alW();
    }

    public void bNh() {
        if (this.VM != null) {
            this.VM.akq();
        }
    }

    public void nU(boolean z) {
        if (this.hxe != null) {
            nS(this.hpc.bJm().amA());
            if (this.hxc) {
                nK(z);
            } else {
                nL(z);
            }
        }
    }

    public void bNi() {
        if (this.hxe != null) {
            this.hxe.setVisibility(8);
            this.hxj = false;
            if (this.hxC != null) {
                this.hxC.setVisibility(8);
                nO(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.esg == null) {
            this.esg = new com.baidu.tbadk.core.view.b(this.hpc.getPageContext());
        }
        this.esg.dJ(true);
    }

    public void aME() {
        if (this.esg != null) {
            this.esg.dJ(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hvX.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hvX.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hvN != null) {
            this.hvN.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hyv = getScrollY();
            this.hxB.hyK = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxB));
            a(this.hxB.hyK, true);
        }
    }

    public void nV(boolean z) {
        this.hvN.nV(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hvN != null) {
            this.hvN.b(absListView, i);
        }
        if (this.hvT != null && this.hwG != null) {
            this.hvT.a(this.hwG.bKz());
        }
        this.hxB.hfp = i;
        this.hxB.headerCount = this.hvX.getHeaderViewsCount();
        this.hxB.hyK = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxB));
        a(this.hxB.hyK, false);
        if (this.ffg.aeJ() && !this.ffg.bRu) {
            if (this.hxB != null && this.hxB.hyK != null && this.hxB.hyK.getView() != null) {
                i4 = this.hxB.hyK.getView().getTop() < 0 ? this.hxB.hyK.getView().getHeight() : this.hxB.hyK.getView().getBottom();
            }
            this.ffg.m18if(i4);
            this.ffg.bRu = true;
        }
    }

    public void bNj() {
        if (this.hpc.isLogin() && this.hsv != null && this.hxR && !this.hxQ && !this.hxa && this.hxm != null && this.hxm.YR() != null && !this.hxm.YR().getIsLike() && !this.hxm.YR().hadConcerned() && this.hxN == null) {
            this.hxN = new an(this.hpc);
        }
    }

    public void bNk() {
        if (this.hxR && !this.hxQ && this.hxm != null && this.hxm.YR() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").T("obj_locate", this.hpc.bIQ() ? 2 : 1).T("obj_type", this.hxQ ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hpc.getPageContext().getPageActivity(), this.hxm.YR().getUserId(), this.hxm.YR().getUserName(), this.hpc.bJa().bIR(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hxQ && this.hxv != null && this.hvT.bNS() != null) {
            int bKv = this.hwG.bKv();
            if (bKv > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bKv > this.hvX.getFirstVisiblePosition() - this.hvX.getHeaderViewsCount()) {
                    this.hxv.setVisibility(8);
                    return;
                }
                this.hxv.setVisibility(0);
                bNu();
                this.hvT.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.hvr == null) {
                if (this.hvX.getFirstVisiblePosition() == 0) {
                    this.hxv.setVisibility(8);
                    this.hvT.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hxA) {
                        this.hxz = top;
                        this.hxA = false;
                    }
                    this.hxz = top < this.hxz ? top : this.hxz;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hwF.getY() < 0.0f) {
                        measuredHeight = hxy - alVar.hvr.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hvT.bNS().getMeasuredHeight() - alVar.hvr.getMeasuredHeight();
                        this.hvT.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hxz) {
                        this.hxv.setVisibility(0);
                        bNu();
                    } else if (top < measuredHeight) {
                        this.hxv.setVisibility(0);
                        bNu();
                    } else {
                        this.hxv.setVisibility(8);
                        this.hvT.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hxA = true;
                    }
                }
            }
        }
    }

    public void bNl() {
        if (!this.hyw) {
            TiebaStatic.log("c10490");
            this.hyw = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hpc.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hxF, Integer.valueOf(hxH));
            aVar.gC(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hpc.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.az(inflate);
            aVar.ab(sparseArray);
            aVar.a(d.j.grade_button_tips, this.hpc);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hpc.getPageContext()).aaZ();
        }
    }

    public void zZ(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hpc.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hpc.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.az(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hxF, Integer.valueOf(hxI));
        aVar.ab(sparseArray);
        aVar.a(d.j.view, this.hpc);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hpc.getPageContext()).aaZ();
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

    public PbInterviewStatusView bNm() {
        return this.hxr;
    }

    private void t(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHZ() != null && dVar.bHZ().ZR() && this.hxr == null) {
            this.hxr = (PbInterviewStatusView) this.hxq.inflate();
            this.hxr.setOnClickListener(this.faZ);
            this.hxr.setCallback(this.hpc.bJX());
            this.hxr.setData(this.hpc, dVar);
        }
    }

    public LinearLayout bNn() {
        return this.hwF;
    }

    public View bNo() {
        return this.fbm;
    }

    public boolean bNp() {
        return this.hyh;
    }

    public void nh(boolean z) {
        this.hwe.nh(z);
    }

    public void Aa(String str) {
        if (this.hvU != null) {
            this.hvU.setTitle(str);
        }
    }

    private int nW(boolean z) {
        if (this.hxr == null || this.hxr.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.hpc.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bNq() {
        if (this.hxr != null && this.hxr.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hxr.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hxr.setLayoutParams(layoutParams);
        }
    }

    public boolean bJr() {
        return false;
    }

    public void Ab(String str) {
        this.fPf.performClick();
        if (!StringUtils.isNull(str) && this.hpc.bJm() != null && this.hpc.bJm().amt() != null && this.hpc.bJm().amt().getInputView() != null) {
            EditText inputView = this.hpc.bJm().amt().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bMZ();
            if (configuration.orientation == 2) {
                bNi();
                bMm();
            } else {
                bMp();
            }
            if (this.hxM != null) {
                this.hxM.bKE();
            }
            this.hpc.bcN();
            this.hwF.setVisibility(8);
            this.hvT.og(false);
            this.hpc.nn(false);
            if (this.hvN != null) {
                if (configuration.orientation == 1) {
                    bNn().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hvX.setIsLandscape(true);
                    this.hvX.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hvX.setIsLandscape(false);
                    if (this.hyv > 0) {
                        this.hvX.smoothScrollBy(this.hyv, 0);
                    }
                }
                this.hvN.onConfigurationChanged(configuration);
                this.hxu.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void nX(boolean z) {
        this.hvR = z;
    }

    public boolean bNr() {
        return this.hvN != null && this.hvN.bNr();
    }

    public void bNs() {
        if (this.hvN != null) {
            this.hvN.onPause();
        }
    }

    public void s(long j, int i) {
        if (this.hvP != null) {
            this.hvP.s(j, i);
        }
        if (this.hvN != null) {
            this.hvN.s(j, i);
        }
    }

    public void ns(boolean z) {
        this.hwG.ns(z);
    }

    public void bNt() {
        if (this.hxs == null) {
            LayoutInflater.from(this.hpc.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.eCz, true);
            this.hxs = (ViewGroup) this.eCz.findViewById(d.g.add_experienced_layout);
            this.hxt = (TextView) this.eCz.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.al.j(this.hxt, d.C0236d.cp_btn_a);
            String string = this.hpc.getResources().getString(d.j.experienced_add_success);
            String string2 = this.hpc.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_h)));
            this.hxt.setText(spannableString);
        }
        this.hxs.setVisibility(0);
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
                        aq.this.hxs.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hxt.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hxt.startAnimation(scaleAnimation);
    }

    public void ct(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hxe.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hpc);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.hxX = new TextView(this.hpc);
            this.hxX.setText(d.j.connection_tips);
            this.hxX.setGravity(17);
            this.hxX.setPadding(com.baidu.adp.lib.util.l.h(this.hpc, d.e.ds24), 0, com.baidu.adp.lib.util.l.h(this.hpc, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hpc, d.e.ds60);
            if (this.hxX.getParent() == null) {
                frameLayout.addView(this.hxX, layoutParams);
            }
            this.hxW = new PopupWindow(this.hpc);
            this.hxW.setContentView(frameLayout);
            this.hxW.setHeight(-2);
            this.hxW.setWidth(-2);
            this.hxW.setFocusable(true);
            this.hxW.setOutsideTouchable(false);
            this.hxW.setBackgroundDrawable(new ColorDrawable(this.hpc.getResources().getColor(d.C0236d.transparent)));
            this.hvX.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hxW.showAsDropDown(aq.this.hxe, view.getLeft(), -aq.this.hxe.getHeight());
                    } else {
                        aq.this.hxW.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bNu() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.hxY == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.hxY = new com.baidu.tbadk.core.dialog.a(this.hpc);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hpc);
            this.hxY.gF(1);
            this.hxY.az(pbLongPressTipView);
            this.hxY.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hxY.dr(false);
            this.hxY.b(this.hpc.getPageContext()).aaZ();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.31
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hxY != null && aq.this.hxY.isShowing()) {
                        aq.this.hxY.dismiss();
                    }
                }
            }, TbConfig.NOTIFY_SOUND_INTERVAL);
            if (this.hvN != null) {
                this.hvN.bPk();
            }
        }
    }

    public void nY(boolean z) {
        this.hyd = z;
    }

    public boolean bNv() {
        return this.hyd;
    }

    private void aa(boolean z, boolean z2) {
        ab(z, z2);
        ac(z, z2);
        if (this.hwG != null && this.hwG.bKA() != null) {
            this.hwG.bKA().U(z, z2);
        }
    }

    private void ab(boolean z, boolean z2) {
        if (z && z2) {
            this.hwc.setImageResource(d.f.pic_pb_stick_refined_n);
            this.hwc.setVisibility(0);
        } else if (z) {
            this.hwc.setImageResource(d.f.pic_pb_refined_n);
            this.hwc.setVisibility(0);
        } else if (z2) {
            this.hwc.setImageResource(d.f.pic_pb_stick_n);
            this.hwc.setVisibility(0);
        } else {
            this.hwc.setVisibility(8);
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.hvZ != null && this.hsv != null && this.hsv.bHZ() != null && this.hsv.bHZ().Zg() == 0 && !this.hsv.bHZ().ZL()) {
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
    }
}
