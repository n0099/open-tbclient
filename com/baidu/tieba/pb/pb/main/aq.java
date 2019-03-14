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
    private TextView ahI;
    private h.c bRG;
    private NavigationBarCoverTip bso;
    private com.baidu.tieba.pb.a.c cbY;
    private View cpF;
    private NoNetworkView eCt;
    private RelativeLayout eCv;
    private List<CustomBlueCheckRadioButton> ekt;
    private View eoO;
    private TextView fPe;
    private View.OnClickListener faY;
    private View fbl;
    private PbListView fff;
    private com.baidu.tieba.NEGFeedBack.e fzD;
    private PbActivity hoW;
    PbActivity.d hob;
    private View.OnClickListener hpv;
    private UserIconBox hqj;
    private UserIconBox hqk;
    private PbFakeFloorModel hrh;
    private com.baidu.tieba.pb.data.d hsp;
    public int hvG;
    public com.baidu.tieba.pb.video.i hvH;
    private long hvI;
    private com.baidu.tieba.pb.video.h hvJ;
    private com.baidu.tieba.c.d hvK;
    public final com.baidu.tieba.pb.pb.main.view.b hvN;
    public com.baidu.tieba.pb.pb.main.view.a hvO;
    private ViewStub hvP;
    private ViewStub hvQ;
    private PbLandscapeListView hvR;
    private View hvS;
    private RelativeLayout hvV;
    private ImageView hvW;
    private ImageView hvX;
    private e hvY;
    private ColumnLayout hvZ;
    private f hwA;
    private View hwG;
    private View hwY;
    private View hwZ;
    private ThreadSkinView hwa;
    private TextView hwb;
    private TextView hwc;
    private ImageView hwd;
    private HeadPendantView hwe;
    private FrameLayout hwf;
    private HeadImageView hwg;
    private View hwh;
    private LinearLayout hwi;
    private PbFirstFloorUserLikeButton hwl;
    private ao hwm;
    private TextView hwn;
    private TextView hwo;
    private TextView hwp;
    private TextView hwq;
    private View hwr;
    private View hws;
    private LinearLayout hwt;
    private TextView hwu;
    private TextView hwv;
    private View hww;
    private View hwx;
    private ObservedChangeLinearLayout hwz;
    private int hxF;
    private Runnable hxG;
    private s hxH;
    private an hxI;
    private int hxO;
    private PbTopTipView hxQ;
    private PopupWindow hxR;
    private TextView hxS;
    private com.baidu.tbadk.core.dialog.a hxT;
    private List<String> hxU;
    private com.baidu.tieba.pb.pb.main.emotion.c hxV;
    private com.baidu.tieba.pb.pb.godreply.a hxW;
    private PbLandscapeListView.b hxX;
    private ac hxZ;
    private ImageView hxa;
    private ImageView hxb;
    private ImageView hxc;
    private MessageRedDotView hxd;
    private int hxf;
    private int hxg;
    private PostData hxh;
    private View hxj;
    private TextView hxk;
    private ViewStub hxl;
    private PbInterviewStatusView hxm;
    private ViewGroup hxn;
    private TextView hxo;
    private FrameLayout hxp;
    private View hxq;
    private View hxr;
    private al hxs;
    private PbEmotionBar hxx;
    private String hya;
    private boolean hyc;
    private com.baidu.tbadk.core.view.userLike.c hyd;
    private com.baidu.tbadk.core.view.userLike.c hye;
    private Runnable hyj;
    private PbActivity.b hyl;
    public int hyq;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private static final int hxt = UtilHelper.getLightStatusBarHeight();
    public static int hxz = 3;
    public static int hxA = 0;
    public static int hxB = 3;
    public static int hxC = 4;
    public static int hxD = 5;
    public static int hxE = 6;
    private static a.InterfaceC0388a hyb = new a.InterfaceC0388a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0388a
        public void onRefresh() {
        }
    };
    private boolean hvL = false;
    private int hvM = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hvT = null;
    private TextView hvU = null;
    public FrsPraiseView hwj = null;
    private ClickableHeaderImageView hwk = null;
    private View hwy = null;
    private com.baidu.tbadk.core.dialog.a hwB = null;
    private com.baidu.tbadk.core.dialog.b faX = null;
    private View hwC = null;
    private EditText hwD = null;
    private com.baidu.tieba.pb.view.c hwE = null;
    private com.baidu.tieba.pb.view.a hwF = null;
    private com.baidu.tbadk.core.dialog.a hwH = null;
    private b.InterfaceC0225b gmF = null;
    private TbRichTextView.h cAB = null;
    private NoNetworkView.a eWD = null;
    private com.baidu.tbadk.core.dialog.g hwI = null;
    private View hwJ = null;
    private com.baidu.tbadk.core.dialog.a hwK = null;
    private Dialog hwL = null;
    private Dialog hwM = null;
    private View hwN = null;
    private LinearLayout hwO = null;
    private CompoundButton.OnCheckedChangeListener eku = null;
    private TextView hwP = null;
    private TextView hwQ = null;
    private String hwR = null;
    private com.baidu.tbadk.core.dialog.g hnc = null;
    private com.baidu.tbadk.core.dialog.g hwS = null;
    private boolean hwT = false;
    private boolean hwU = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hwV = null;
    private boolean hwW = false;
    private Button hwX = null;
    private boolean hxe = true;
    private com.baidu.tbadk.core.view.b esc = null;
    private boolean hpn = false;
    private int mSkinType = 3;
    private boolean hxi = false;
    private int hxu = 0;
    private boolean hxv = true;
    public a hxw = new a();
    private int hxy = 0;
    private boolean hxJ = false;
    private int hxK = 0;
    private boolean hxL = false;
    private boolean hxM = false;
    private boolean hxN = false;
    private int hxP = 0;
    private boolean hxY = false;
    private String hyf = null;
    private CustomMessageListener hyg = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hyf = null;
            }
        }
    };
    private CustomMessageListener dgx = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hwA != null) {
                aq.this.hwA.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hyh = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hvU != null) {
                aq.this.hvU.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hyi = new Handler();
    private CustomMessageListener hyk = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hxe = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hym = true;
    View.OnClickListener hyn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hxL) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").T(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hxL && aq.this.hsp != null && aq.this.hsp.bHZ() != null && aq.this.hsp.bHZ().YR() != null && aq.this.hsp.bHZ().YR().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").T("obj_locate", 1));
            }
            aq.this.hoW.hmX.fAj.onClick(view);
        }
    };
    private boolean hyo = false;
    String userId = null;
    private final List<TbImageView> hyp = new ArrayList();
    private boolean hyr = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int headerCount;
        public int hfp;
        public al hyF;
    }

    public void nJ(boolean z) {
        this.hxJ = z;
        if (this.hvR != null) {
            this.hxK = this.hvR.getHeaderViewsCount();
        }
    }

    public void bMk() {
        if (this.hvR != null) {
            int headerViewsCount = this.hvR.getHeaderViewsCount() - this.hxK;
            final int firstVisiblePosition = (this.hvR.getFirstVisiblePosition() == 0 || this.hvR.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hvR.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hvR.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hxw.hyF = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxw));
            final al alVar = this.hxw.hyF;
            final int h = h(alVar);
            final int y = ((int) this.hwz.getY()) + this.hwz.getMeasuredHeight();
            final boolean z = this.hxq.getVisibility() == 0;
            boolean z2 = this.hwz.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hwA.bKv() + this.hvR.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hvl.getMeasuredHeight() : 0;
                if (z2) {
                    this.hvR.setSelectionFromTop(this.hwA.bKv() + this.hvR.getHeaderViewsCount(), hxt - measuredHeight);
                } else {
                    this.hvR.setSelectionFromTop(this.hwA.bKv() + this.hvR.getHeaderViewsCount(), this.hvN.bNT().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hvR.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hxL) {
                this.hvR.setSelectionFromTop(this.hwA.bKv() + this.hvR.getHeaderViewsCount(), this.hvH.aBC().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hvR.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bKN() {
                        if (h >= 0 && h <= aq.this.eCv.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.eoO.getLayoutParams();
                            if (i == 0 || i > aq.this.eCv.getMeasuredHeight() || h2 >= aq.this.eCv.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hxF;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.eCv.getMeasuredHeight()) {
                                layoutParams.height = aq.this.hxF;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hvR.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.eoO.setLayoutParams(layoutParams);
                        }
                        aq.this.hvR.setOnLayoutListener(null);
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
        return this.eCt;
    }

    public void bMm() {
        if (this.VN != null) {
            this.VN.hide();
            if (this.hxV != null) {
                this.hxV.aAB();
            }
        }
    }

    public PbFakeFloorModel bMn() {
        return this.hrh;
    }

    public s bMo() {
        return this.hxH;
    }

    public void bMp() {
        reset();
        bMm();
        this.hxH.bKE();
        nU(false);
    }

    private void reset() {
        if (this.hoW != null && this.hoW.bJm() != null && this.VN != null) {
            com.baidu.tbadk.editortools.pb.a.amp().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bJm = this.hoW.bJm();
            bJm.amI();
            bJm.amd();
            if (bJm.getWriteImagesInfo() != null) {
                bJm.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bJm.jC(SendView.ALL);
            bJm.jD(SendView.ALL);
            com.baidu.tbadk.editortools.g jt = this.VN.jt(23);
            com.baidu.tbadk.editortools.g jt2 = this.VN.jt(2);
            com.baidu.tbadk.editortools.g jt3 = this.VN.jt(5);
            if (jt2 != null) {
                jt2.qT();
            }
            if (jt3 != null) {
                jt3.qT();
            }
            if (jt != null) {
                jt.hide();
            }
            this.VN.invalidate();
        }
    }

    public boolean bMq() {
        return this.hxe;
    }

    public void nK(boolean z) {
        if (this.hwZ != null && this.fPe != null) {
            this.fPe.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hwZ.startAnimation(alphaAnimation);
            }
            this.hwY.setVisibility(0);
            this.hwZ.setVisibility(0);
            this.hxe = true;
            if (this.hxx != null && !this.hxW.isActive()) {
                this.hxx.setVisibility(0);
                nO(true);
            }
        }
    }

    public void nL(boolean z) {
        if (this.hwZ != null && this.fPe != null) {
            this.fPe.setText(bMr());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hwZ.startAnimation(alphaAnimation);
            }
            this.hwY.setVisibility(0);
            this.hwZ.setVisibility(0);
            this.hxe = true;
            if (this.hxx != null && !this.hxW.isActive()) {
                this.hxx.setVisibility(0);
                nO(true);
            }
        }
    }

    public String bMr() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.hya)) {
            return this.hya;
        }
        if (this.hoW != null) {
            this.hya = this.hoW.getResources().getString(ap.bMj());
        }
        return this.hya;
    }

    public PostData bMs() {
        int i = 0;
        if (this.hvR == null) {
            return null;
        }
        int bMt = bMt() - this.hvR.getHeaderViewsCount();
        if (bMt < 0) {
            bMt = 0;
        }
        if (this.hwA.wh(bMt) != null && this.hwA.wh(bMt) != PostData.iGb) {
            i = bMt + 1;
        }
        return this.hwA.getItem(i) instanceof PostData ? (PostData) this.hwA.getItem(i) : null;
    }

    public int bMt() {
        int i;
        View childAt;
        if (this.hvR == null) {
            return 0;
        }
        int firstVisiblePosition = this.hvR.getFirstVisiblePosition();
        int lastVisiblePosition = this.hvR.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hvR.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hvR.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        return this.hvR.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hsp != null && this.hsp.bIb() != null && !this.hsp.bIb().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hsp.bIb().size() && (postData = this.hsp.bIb().get(i)) != null && postData.YR() != null && !StringUtils.isNull(postData.YR().getUserId()); i++) {
                if (this.hsp.bIb().get(i).YR().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hxW != null && this.hxW.isActive()) {
                        nU(false);
                    }
                    if (this.hxx != null) {
                        this.hxx.oc(true);
                    }
                    this.hyf = postData.YR().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hoW = null;
        this.eCv = null;
        this.fbl = null;
        this.hvI = 0L;
        this.hvR = null;
        this.hvS = null;
        this.hvV = null;
        this.hvZ = null;
        this.hwb = null;
        this.hwc = null;
        this.hwf = null;
        this.hwg = null;
        this.hwh = null;
        this.hwl = null;
        this.hwn = null;
        this.hwo = null;
        this.hwp = null;
        this.hwq = null;
        this.hww = null;
        this.hwx = null;
        this.hwA = null;
        this.fff = null;
        this.cpF = null;
        this.faY = null;
        this.hpv = null;
        this.hwZ = null;
        this.fPe = null;
        this.hxj = null;
        this.hxk = null;
        this.hxl = null;
        this.hxO = 0;
        this.hvI = System.currentTimeMillis();
        this.hoW = pbActivity;
        this.faY = onClickListener;
        this.cbY = cVar;
        this.hxO = com.baidu.adp.lib.util.l.aO(this.hoW) / 2;
        this.eCv = (RelativeLayout) LayoutInflater.from(this.hoW.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.hoW.addContentView(this.eCv, new FrameLayout.LayoutParams(-1, -1));
        this.bso = (NavigationBarCoverTip) this.hoW.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.fbl = this.hoW.findViewById(d.g.statebar_view);
        this.hwz = (ObservedChangeLinearLayout) this.hoW.findViewById(d.g.title_wrapper);
        this.eCt = (NoNetworkView) this.hoW.findViewById(d.g.view_no_network);
        this.hvR = (PbLandscapeListView) this.hoW.findViewById(d.g.new_pb_list);
        this.hxp = (FrameLayout) this.hoW.findViewById(d.g.root_float_header);
        this.ahI = new TextView(this.hoW.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.hoW.getActivity(), d.e.ds88));
        this.hvR.addHeaderView(this.ahI, 0);
        this.hxF = this.hoW.getResources().getDimensionPixelSize(d.e.tbds134);
        this.eoO = new View(this.hoW.getPageContext().getPageActivity());
        this.eoO.setLayoutParams(new AbsListView.LayoutParams(-1, this.hxF));
        this.eoO.setVisibility(4);
        this.hvR.addFooterView(this.eoO);
        this.hvR.setOnTouchListener(this.hoW.ccU);
        this.hvN = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.hoW.bJP()) {
            this.hvP = (ViewStub) this.hoW.findViewById(d.g.manga_view_stub);
            this.hvP.setVisibility(0);
            this.hvO = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.hvO.show();
            this.hvN.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hoW.getActivity(), d.e.ds120);
        }
        this.ahI.setLayoutParams(layoutParams);
        this.hvN.bNT().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0349a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0349a
            public void bIK() {
                if (aq.this.hvR != null) {
                    if (aq.this.hvH != null) {
                        aq.this.hvH.bPm();
                    }
                    aq.this.hvR.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0349a
            public void bIL() {
                aq.this.hoW.bcN();
            }
        }));
        this.hwY = this.hoW.findViewById(d.g.view_comment_top_line);
        this.hwZ = this.hoW.findViewById(d.g.pb_editor_tool_comment);
        this.hxf = com.baidu.adp.lib.util.l.h(this.hoW.getPageContext().getPageActivity(), d.e.tbds120);
        this.hxg = com.baidu.adp.lib.util.l.h(this.hoW.getPageContext().getPageActivity(), d.e.ds242);
        this.fPe = (TextView) this.hoW.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fPe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hoW.bJv();
                if (aq.this.hoW != null && aq.this.hoW.bJa() != null && aq.this.hoW.bJa().getPbData() != null && aq.this.hoW.bJa().getPbData().bHZ() != null && aq.this.hoW.bJa().getPbData().bHZ().YR() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", aq.this.hoW.bJa().hrT).bJ(ImageViewerConfig.FORUM_ID, aq.this.hoW.bJa().getPbData().getForumId()).T("obj_locate", 1).bJ("uid", aq.this.hoW.bJa().getPbData().bHZ().YR().getUserId()));
                }
            }
        });
        this.hxa = (ImageView) this.hoW.findViewById(d.g.pb_editor_tool_comment_icon);
        this.hxa.setOnClickListener(this.faY);
        this.hxb = (ImageView) this.hoW.findViewById(d.g.pb_editor_tool_collection);
        this.hxb.setOnClickListener(this.faY);
        this.hxc = (ImageView) this.hoW.findViewById(d.g.pb_editor_tool_share);
        this.hxc.setOnClickListener(this.faY);
        this.hxd = (MessageRedDotView) this.hoW.findViewById(d.g.pb_editor_tool_comment_red_dot);
        this.hvS = LayoutInflater.from(this.hoW.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.hvV = (RelativeLayout) LayoutInflater.from(this.hoW.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.hvW = (ImageView) this.hvV.findViewById(d.g.pb_thread_type_stamp_top_part);
        this.hvY = new e(this.hoW, this.hvV);
        this.hvY.init();
        this.hvY.a(this.hvY.bJl(), this.faY);
        this.hvZ = (ColumnLayout) this.hvV.findViewById(d.g.pb_head_owner_root);
        this.hwa = (ThreadSkinView) this.hvV.findViewById(d.g.pb_thread_skin);
        this.hvZ.setOnLongClickListener(this.onLongClickListener);
        this.hvZ.setOnTouchListener(this.cbY);
        this.hvZ.setVisibility(8);
        this.hvS.setOnTouchListener(this.cbY);
        this.hxj = this.hvS.findViewById(d.g.pb_head_activity_join_number_container);
        this.hxj.setVisibility(8);
        this.hxk = (TextView) this.hvS.findViewById(d.g.pb_head_activity_join_number);
        this.hwb = (TextView) this.hvZ.findViewById(d.g.pb_head_owner_info_user_name);
        this.hwb.getPaint().setFakeBoldText(true);
        this.hwc = (TextView) this.hvZ.findViewById(d.g.floor_owner);
        this.hwd = (ImageView) this.hvZ.findViewById(d.g.icon_forum_level);
        this.hwf = (FrameLayout) this.hvZ.findViewById(d.g.pb_head_headImage_container);
        this.hwg = (HeadImageView) this.hvZ.findViewById(d.g.pb_head_owner_photo);
        this.hwe = (HeadPendantView) this.hvZ.findViewById(d.g.pb_pendant_head_owner_photo);
        this.hwe.setHasPendantStyle();
        if (this.hwe.getHeadView() != null) {
            this.hwe.getHeadView().setIsRound(true);
            this.hwe.getHeadView().setDrawBorder(false);
        }
        this.hqj = (UserIconBox) this.hvZ.findViewById(d.g.show_icon_vip);
        this.hqk = (UserIconBox) this.hvZ.findViewById(d.g.show_icon_yinji);
        this.hwi = (LinearLayout) this.hvV.findViewById(d.g.pb_head_owner_info_root);
        this.hwl = (PbFirstFloorUserLikeButton) this.hvZ.findViewById(d.g.pb_like_button);
        this.hwn = (TextView) this.hvZ.findViewById(d.g.pb_views);
        this.hwo = (TextView) this.hvZ.findViewById(d.g.pb_item_first_floor_reply_time);
        this.hwp = (TextView) this.hvZ.findViewById(d.g.pb_item_first_floor_location_address);
        this.hwq = (TextView) this.hvZ.findViewById(d.g.point_between_time_and_locate);
        this.hyd = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hye = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hww = this.hvS.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.hwx = this.hvS.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.hvS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hxl = (ViewStub) this.eCv.findViewById(d.g.interview_status_stub);
        this.hwr = this.hvV.findViewById(d.g.blank_view_align_user_item_top);
        this.hws = this.hvV.findViewById(d.g.blank_view_align_user_item_bottom);
        this.hwA = new f(this.hoW, this.hvR);
        this.hwA.x(this.faY);
        this.hwA.setTbGestureDetector(this.cbY);
        this.hwA.setOnImageClickListener(this.cAB);
        this.hpv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hoW.c(sparseArray);
                            return;
                        }
                        aq.this.cs(view);
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        aq.this.hoW.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hwA.J(this.hpv);
        bMz();
        this.hvR.addHeaderView(this.hvV);
        this.hvR.addHeaderView(this.hvT);
        this.hvR.addHeaderView(this.hvS);
        this.fff = new PbListView(this.hoW.getPageContext().getPageActivity());
        this.cpF = this.fff.getView().findViewById(d.g.pb_more_view);
        if (this.cpF != null) {
            this.cpF.setOnClickListener(this.faY);
            com.baidu.tbadk.core.util.al.k(this.cpF, d.f.pb_foot_more_trans_selector);
        }
        this.fff.aey();
        this.fff.hZ(d.f.pb_foot_more_trans_selector);
        this.fff.ib(d.f.pb_foot_more_trans_selector);
        this.hwG = this.hoW.findViewById(d.g.viewstub_progress);
        this.hoW.registerListener(this.hyk);
        this.hwh = com.baidu.tbadk.ala.b.UK().n(this.hoW.getActivity(), 2);
        if (this.hwh != null) {
            this.hwh.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.hoW.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.hwh.getParent() == null) {
                this.hwi.addView(this.hwh, aVar);
            }
        }
        this.hrh = new PbFakeFloorModel(this.hoW.getPageContext());
        this.hxH = new s(this.hoW.getPageContext(), this.hrh, this.eCv);
        this.hxH.a(this.hoW.hnX);
        this.hrh.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hrh.o(postData);
                aq.this.hwA.notifyDataSetChanged();
                aq.this.hxH.bKE();
                aq.this.VN.akp();
                aq.this.nU(false);
            }
        });
        if (this.hoW.bJa() != null && !StringUtils.isNull(this.hoW.bJa().bLy())) {
            this.hoW.showToast(this.hoW.bJa().bLy());
        }
        this.hxq = this.hoW.findViewById(d.g.pb_expand_blank_view);
        this.hxr = this.hoW.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hxr.getLayoutParams();
        if (this.hoW.bJa() != null && this.hoW.bJa().bKU()) {
            this.hxq.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hxr.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hxt;
            this.hxr.setLayoutParams(layoutParams2);
        }
        this.hxs = new al(this.hoW.getPageContext(), this.hoW.findViewById(d.g.pb_reply_expand_view));
        this.hxs.hvl.setVisibility(8);
        this.hxs.L(this.faY);
        this.hoW.registerListener(this.dgx);
        this.hoW.registerListener(this.hyg);
        this.hoW.registerListener(this.hyh);
        bMv();
        nO(false);
    }

    public void bnm() {
        if (!this.hoW.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 2).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.hoW.bJx()) {
            com.baidu.tbadk.editortools.pb.d bJm = this.hoW.bJm();
            if (bJm != null && (bJm.amF() || bJm.amG())) {
                this.hoW.bJm().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.VN != null) {
                bME();
            }
            if (this.VN != null) {
                this.hxe = false;
                if (this.VN.jw(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hoW, (View) this.VN.jw(2).ciu, false, hyb);
                }
            }
            bNj();
        }
    }

    private void bMv() {
        this.hxW = new com.baidu.tieba.pb.pb.godreply.a(this.hoW, this, (ViewStub) this.eCv.findViewById(d.g.more_god_reply_popup));
        this.hxW.t(this.faY);
        this.hxW.J(this.hpv);
        this.hxW.setOnImageClickListener(this.cAB);
        this.hxW.t(this.faY);
        this.hxW.setTbGestureDetector(this.cbY);
    }

    public com.baidu.tieba.pb.pb.godreply.a bMw() {
        return this.hxW;
    }

    public View bMx() {
        return this.hxq;
    }

    public void bMy() {
        if (this.hvR != null) {
            this.hvR.removeHeaderView(this.hvT);
            this.hvR.removeHeaderView(this.hvV);
            this.hvR.removeHeaderView(this.hvS);
        }
    }

    private void bMz() {
        if (this.hvT == null) {
            this.hvT = (RelativeLayout) LayoutInflater.from(this.hoW).inflate(d.h.new_pb_title, (ViewGroup) null);
            this.hvX = (ImageView) this.hvT.findViewById(d.g.pb_thread_type_stamp_title_bottom_part);
            this.hvX.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(d.e.tbds194));
            this.hvX.setImageMatrix(matrix);
            this.hvU = (TextView) this.hvT.findViewById(d.g.tv_pb_title);
            this.hvU.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            this.hvU.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hvU.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.al.j(this.hvU, d.C0277d.cp_cont_b);
            this.hvU.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hvU.setVisibility(8);
            if (this.hvU.getParent() == null) {
                this.hvT.addView(this.hvU);
            }
            this.hvT.setOnTouchListener(this.cbY);
            this.hvT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        if (this.hoW.bJP()) {
            this.hvQ = (ViewStub) this.hoW.findViewById(d.g.manga_mention_controller_view_stub);
            this.hvQ.setVisibility(0);
            if (this.hwt == null) {
                this.hwt = (LinearLayout) this.hoW.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.hoW.getPageContext(), this.hwt);
            }
            if (this.hwu == null) {
                this.hwu = (TextView) this.hwt.findViewById(d.g.manga_prev_btn);
            }
            if (this.hwv == null) {
                this.hwv = (TextView) this.hwt.findViewById(d.g.manga_next_btn);
            }
            this.hwu.setOnClickListener(this.faY);
            this.hwv.setOnClickListener(this.faY);
        }
    }

    private void bMB() {
        if (this.hoW.bJP()) {
            if (this.hoW.bJS() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwu, d.C0277d.cp_cont_e, 1);
            }
            if (this.hoW.bJT() == -1) {
                com.baidu.tbadk.core.util.al.d(this.hwv, d.C0277d.cp_cont_e, 1);
            }
        }
    }

    public void bMC() {
        if (this.hwt == null) {
            bMA();
        }
        this.hvQ.setVisibility(8);
        if (this.hyi != null && this.hyj != null) {
            this.hyi.removeCallbacks(this.hyj);
        }
    }

    public void bMD() {
        if (this.hyi != null) {
            if (this.hyj != null) {
                this.hyi.removeCallbacks(this.hyj);
            }
            this.hyj = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hwt == null) {
                        aq.this.bMA();
                    }
                    aq.this.hvQ.setVisibility(0);
                }
            };
            this.hyi.postDelayed(this.hyj, 2000L);
        }
    }

    public void nM(boolean z) {
        this.hvN.nM(z);
        if (z && this.hxi) {
            this.fff.setText(this.hoW.getResources().getString(d.j.click_load_more));
            this.hvR.setNextPage(this.fff);
            this.hvM = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
        this.VN.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.VN.getParent() == null) {
            this.eCv.addView(this.VN, layoutParams);
        }
        this.VN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.VN.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).agt() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).agt() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.adQ();
                        aq.this.mPermissionJudgePolicy.e(aq.this.hoW, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.Y(aq.this.hoW)) {
                            aq.this.hoW.bJm().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hoW.bJm().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bMm();
        this.hoW.bJm().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.VN != null && aq.this.VN.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hxV == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.VN.getId());
                            aq.this.hxV = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hoW.getPageContext(), aq.this.eCv, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.T(aq.this.hxU)) {
                                aq.this.hxV.setData(aq.this.hxU);
                            }
                            aq.this.hxV.b(aq.this.VN);
                        }
                        aq.this.hxV.Ae(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hoW.hnb != null && aq.this.hoW.hnb.bNz() != null) {
                    if (!aq.this.hoW.hnb.bNz().cob()) {
                        aq.this.hoW.hnb.nZ(false);
                    }
                    aq.this.hoW.hnb.bNz().qV(false);
                }
            }
        });
    }

    public void bME() {
        if (this.hoW != null && this.VN != null) {
            this.VN.qT();
            if (this.hoW.bJm() != null) {
                this.hoW.bJm().amw();
            }
            bNj();
        }
    }

    public void nN(boolean z) {
        if (this.hvR != null && this.ahI != null && this.fbl != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fbl.setVisibility(0);
                } else {
                    this.fbl.setVisibility(8);
                    this.hvR.removeHeaderView(this.ahI);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ahI.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hxt;
                    this.ahI.setLayoutParams(layoutParams);
                }
                bMS();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ahI.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + nW(true);
                this.ahI.setLayoutParams(layoutParams2);
            }
            bMS();
            bNr();
        }
    }

    public f bMF() {
        return this.hwA;
    }

    public void a(PbActivity.d dVar) {
        this.hob = dVar;
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
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hoW);
        iVar.setTitleText(this.hoW.getString(d.j.bar_manager));
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwI.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hyl != null) {
                                aq.this.hyl.m(new Object[]{sparseArray2.get(d.g.tag_manage_user_identity), sparseArray2.get(d.g.tag_forbid_user_name), sparseArray2.get(d.g.tag_forbid_user_post_id), sparseArray2.get(d.g.tag_forbid_user_name_show), sparseArray2.get(d.g.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hoW.a(z, (String) sparseArray2.get(d.g.tag_user_mute_mute_userid), sparseArray2);
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
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hoW.getString(d.j.delete_post), iVar);
            } else {
                fVar2 = new com.baidu.tbadk.core.dialog.f(0, this.hoW.getString(d.j.delete), iVar);
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
            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(1, this.hoW.getString(d.j.forbidden_person), iVar);
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
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hoW.getString(d.j.un_mute), iVar);
            } else {
                fVar = new com.baidu.tbadk.core.dialog.f(2, this.hoW.getString(d.j.mute), iVar);
            }
            fVar.mTextView.setTag(sparseArray4);
            arrayList.add(fVar);
        }
        iVar.P(arrayList);
        if (this.hwI == null) {
            this.hwI = new com.baidu.tbadk.core.dialog.g(this.hoW.getPageContext(), iVar.abk());
        } else {
            this.hwI.setContentView(iVar.abk());
        }
        this.hwI.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hyl = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hoW != null && aVar != null) {
            if (this.fzD == null) {
                this.fzD = new com.baidu.tieba.NEGFeedBack.e(this.hoW.getPageContext(), this.hvS);
            }
            AntiData bbI = this.hoW.bbI();
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
            this.fzD.setDefaultReasonArray(new String[]{this.hoW.getString(d.j.delete_thread_reason_1), this.hoW.getString(d.j.delete_thread_reason_2), this.hoW.getString(d.j.delete_thread_reason_3), this.hoW.getString(d.j.delete_thread_reason_4), this.hoW.getString(d.j.delete_thread_reason_5)});
            this.fzD.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fzD.qi(str);
            this.fzD.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray) {
                    aq.this.hoW.a(aVar, jSONArray);
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
        sparseArray.put(hxA, Integer.valueOf(hxB));
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
        this.hwK = new com.baidu.tbadk.core.dialog.a(this.hoW.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hwK.gD(i3);
        } else {
            this.hwK.dv(false);
            this.hwK.ly(str2);
        }
        this.hwK.ab(sparseArray);
        this.hwK.a(d.j.dialog_ok, this.hoW);
        this.hwK.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwK.dq(true);
        this.hwK.b(this.hoW.getPageContext());
        if (z) {
            this.hwK.aaZ();
        } else {
            a(this.hwK, i);
        }
    }

    public void at(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hwN == null) {
            this.hwN = LayoutInflater.from(this.hoW.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.hoW.getLayoutMode().onModeChanged(this.hwN);
        if (this.hwM == null) {
            this.hwM = new Dialog(this.hoW.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hwM.setCanceledOnTouchOutside(true);
            this.hwM.setCancelable(true);
            this.hwV = (ScrollView) this.hwN.findViewById(d.g.good_scroll);
            this.hwM.setContentView(this.hwN);
            WindowManager.LayoutParams attributes = this.hwM.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.hoW.getPageContext().getPageActivity(), d.e.ds540);
            this.hwM.getWindow().setAttributes(attributes);
            this.eku = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hwR = (String) compoundButton.getTag();
                        if (aq.this.ekt != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.ekt) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hwR != null && !str.equals(aq.this.hwR)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hwO = (LinearLayout) this.hwN.findViewById(d.g.good_class_group);
            this.hwQ = (TextView) this.hwN.findViewById(d.g.dialog_button_cancel);
            this.hwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hwM instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hwM, aq.this.hoW.getPageContext());
                    }
                }
            });
            this.hwP = (TextView) this.hwN.findViewById(d.g.dialog_button_ok);
            this.hwP.setOnClickListener(this.faY);
        }
        this.hwO.removeAllViews();
        this.ekt = new ArrayList();
        CustomBlueCheckRadioButton dz = dz("0", this.hoW.getPageContext().getString(d.j.thread_good_class));
        this.ekt.add(dz);
        dz.setChecked(true);
        this.hwO.addView(dz);
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
                    this.ekt.add(dz2);
                    View view = new View(this.hoW.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.hoW.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.al.l(view, d.C0277d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hwO.addView(view);
                    this.hwO.addView(dz2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hwV.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hoW.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hoW.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hoW.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hwV.setLayoutParams(layoutParams2);
            this.hwV.removeAllViews();
            if (this.hwO != null && this.hwO.getParent() == null) {
                this.hwV.addView(this.hwO);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hwM, this.hoW.getPageContext());
    }

    private CustomBlueCheckRadioButton dz(String str, String str2) {
        Activity pageActivity = this.hoW.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.eku);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bMG() {
        this.hoW.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hoW.hideProgressBar();
        if (z && z2) {
            this.hoW.showToast(this.hoW.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.hoW.showToast(str);
        }
    }

    public void buo() {
        this.hwG.setVisibility(0);
    }

    public void bun() {
        this.hwG.setVisibility(8);
    }

    public View bMH() {
        if (this.hwN != null) {
            return this.hwN.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bMI() {
        return this.hwR;
    }

    public View getView() {
        return this.eCv;
    }

    public void bMJ() {
        com.baidu.adp.lib.util.l.b(this.hoW.getPageContext().getPageActivity(), this.hoW.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hoW.hideProgressBar();
        if (z) {
            bNa();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bNb();
        } else {
            bNa();
        }
    }

    public void bMK() {
        this.fff.aey();
        this.fff.aeC();
    }

    public void bML() {
        this.hoW.hideProgressBar();
        aeD();
        this.hvR.completePullRefreshPostDelayed(0L);
        bMW();
    }

    public void bMM() {
        this.hvR.completePullRefreshPostDelayed(0L);
        bMW();
    }

    private void nO(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hwA.setOnLongClickListener(onLongClickListener);
        if (this.hxW != null) {
            this.hxW.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0225b interfaceC0225b, boolean z, boolean z2) {
        if (this.hnc != null) {
            this.hnc.dismiss();
            this.hnc = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hoW);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hoW.getPageContext().getString(d.j.copy), iVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoW.getPageContext().getString(d.j.report_text), iVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoW.getPageContext().getString(d.j.mark), iVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoW.getPageContext().getString(d.j.remove_mark), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwS.dismiss();
                interfaceC0225b.a(null, i, view);
            }
        });
        this.hwS = new com.baidu.tbadk.core.dialog.g(this.hoW.getPageContext(), iVar.abk());
        this.hwS.showDialog();
    }

    public void a(final b.InterfaceC0225b interfaceC0225b, boolean z) {
        if (this.hwS != null) {
            this.hwS.dismiss();
            this.hwS = null;
        }
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.hoW);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.f(0, this.hoW.getPageContext().getString(d.j.save_to_emotion), iVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, this.hoW.getPageContext().getString(d.j.save_to_local), iVar));
        }
        iVar.P(arrayList);
        iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                aq.this.hwS.dismiss();
                interfaceC0225b.a(null, i, view);
            }
        });
        this.hwS = new com.baidu.tbadk.core.dialog.g(this.hoW.getPageContext(), iVar.abk());
        this.hwS.showDialog();
    }

    public int bMN() {
        return wy(this.hvR.getFirstVisiblePosition());
    }

    private int wy(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hvR.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hvR.getAdapter() == null || !(this.hvR.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hvR.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bMO() {
        int lastVisiblePosition = this.hvR.getLastVisiblePosition();
        if (this.hvH != null) {
            if (lastVisiblePosition == this.hvR.getCount() - 1) {
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
        if (this.hvR != null) {
            if (this.hvN == null || this.hvN.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hvN.mNavigationBar.getFixedNavHeight();
                if (!(this.hoW.bJD() != -1)) {
                    if (this.hxr != null && (layoutParams = (LinearLayout.LayoutParams) this.hxr.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hxr.setLayoutParams(layoutParams);
                    }
                    i--;
                    bNv();
                }
                i2 = fixedNavHeight;
            }
            this.hvR.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hvR.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hvR.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hwD.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hwA.a(dVar, false);
        this.hwA.notifyDataSetChanged();
        bMW();
        if (this.hxW != null) {
            this.hxW.bIW();
        }
        ArrayList<PostData> bIb = dVar.bIb();
        if (dVar.getPage().XK() == 0 || bIb == null || bIb.size() < dVar.getPage().XJ()) {
            if (com.baidu.tbadk.core.util.v.S(bIb) == 0 || (com.baidu.tbadk.core.util.v.S(bIb) == 1 && bIb.get(0) != null && bIb.get(0).cet() == 1)) {
                if (this.hxw == null || this.hxw.hyF == null || this.hxw.hyF.getView() == null) {
                    i = 0;
                } else {
                    i = this.hxw.hyF.getView().getTop() < 0 ? this.hxw.hyF.getView().getHeight() : this.hxw.hyF.getView().getBottom();
                }
                if (this.hoW.bKb()) {
                    this.fff.aa(this.hoW.getResources().getString(d.j.pb_no_host_reply), i);
                } else {
                    this.fff.aa(this.hoW.getResources().getString(d.j.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().XK() == 0) {
                    this.fff.setText(this.hoW.getResources().getString(d.j.list_has_no_more));
                } else {
                    this.fff.setText(this.hoW.getResources().getString(d.j.load_more));
                }
                this.fff.aeH();
            }
        }
        q(dVar);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (this.hwj == null) {
            this.hoW.getLayoutMode().onModeChanged(((ViewStub) this.hvS.findViewById(d.g.praise_layout)).inflate());
            this.hwj = (FrsPraiseView) this.hvS.findViewById(d.g.pb_head_praise_view);
            this.hwj.setIsFromPb(true);
            this.hwy = this.hvS.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.hwj.ij(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hwj != null) {
            boolean bMW = bMW();
            this.hwj.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().XL() == 0 && this.hpn) {
                if (bMW) {
                    this.hwx.setVisibility(0);
                    return;
                } else {
                    this.hwx.setVisibility(8);
                    return;
                }
            }
            this.hwx.setVisibility(8);
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
                if (postData != null && postData.cet() == 1) {
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
        com.baidu.tbadk.data.f cew;
        String portrait;
        if (dVar != null && dVar.bHZ() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hvZ.setVisibility(8);
            if (dVar.bHZ() != null && dVar.bHZ().ZL() && dVar.bHZ().Zi() != null) {
                this.hxL = true;
                this.hvN.oj(this.hxL);
                this.hvN.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1") && com.baidu.adp.lib.util.l.aQ(this.hoW) < this.eCv.getHeight()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eCv.getLayoutParams();
                    layoutParams.height = com.baidu.adp.lib.util.l.aQ(this.hoW);
                    this.eCv.setLayoutParams(layoutParams);
                }
                if (this.hvH == null) {
                    this.hvH = new com.baidu.tieba.pb.video.i(this.hoW, this.hvN, dVar.bHZ().Zi(), this.hvI);
                    this.hvH.a(dVar.bHZ().Zi(), dVar.bHZ(), dVar.getForumId());
                    this.hvH.startPlay();
                } else if (this.hvL) {
                    this.hvH.a(dVar.bHZ().Zi(), dVar.bHZ(), dVar.getForumId());
                    this.hvH.startPlay();
                } else {
                    this.hvH.Aq(dVar.getForumId());
                }
                if (dVar.bIa() != null && dVar.bIa().size() >= 1) {
                    bg bgVar = dVar.bIa().get(0);
                    this.hvH.aE(bgVar);
                    this.hvH.Ar(bgVar.getTitle());
                }
                this.hvH.b(c, dVar.bHZ(), dVar.bIw());
                this.hvL = false;
                this.hvR.removeHeaderView(this.hvH.bPo());
                this.hvR.addHeaderView(this.hvH.bPo(), 0);
                if (this.hvH.aBC() != null && this.hvH.aBC().getParent() == null) {
                    this.hxp.addView(this.hvH.aBC());
                }
                if (this.hvJ == null) {
                    this.hvJ = new com.baidu.tieba.pb.video.h(this.hoW);
                }
                this.hvJ.a(dVar.bHZ().aab(), dVar.bHZ(), dVar.bIt());
                this.hvR.removeHeaderView(this.hvJ.bPb());
                this.hvR.addHeaderView(this.hvJ.bPb(), 1);
                if (dVar.bHZ().aab() != null) {
                    this.hvR.removeHeaderView(this.hvJ.bPc());
                    this.hvR.removeHeaderView(this.hvV);
                    this.hvR.addHeaderView(this.hvJ.bPc(), 2);
                } else {
                    if (this.hvJ.bPc() != null) {
                        this.hvR.removeHeaderView(this.hvJ.bPc());
                    }
                    this.hvR.removeHeaderView(this.hvV);
                    this.hvR.addHeaderView(this.hvV, 2);
                }
                if (this.hvH != null) {
                    this.hvN.of(false);
                    this.hvH.wG(TbadkCoreApplication.getInst().getSkinType());
                }
                bMS();
            } else {
                this.hxL = false;
                this.hvN.oj(this.hxL);
                if (this.hvH != null) {
                    this.hvR.removeHeaderView(this.hvH.bPo());
                }
                if (this.hvJ != null) {
                    this.hvJ.b(this.hvR);
                }
            }
            if (this.hoW.bJp() != null) {
                this.hoW.bJp().od(this.hxL);
            }
            if (this.hvH != null) {
                this.hvH.N(this.hyn);
                bNv();
            }
            if (c != null) {
                this.hxh = c;
                this.hvZ.setVisibility(0);
                if (this.hoW.bIQ()) {
                    if (dVar.bHY() != null) {
                        this.mForumName = dVar.bHY().getForumName();
                        this.mForumId = dVar.bHY().getForumId();
                    }
                    if (this.mForumName == null && this.hoW.bJa() != null && this.hoW.bJa().bIR() != null) {
                        this.mForumName = this.hoW.bJa().bIR();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hvZ.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hvZ.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, c);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.hyc) {
                    this.hvT.setVisibility(0);
                }
                if (!dVar.bHZ().ZL() && this.hvU.getText() != null && this.hvU.getText().length() > 0) {
                    this.hvU.setVisibility(0);
                } else {
                    this.hvU.setVisibility(8);
                }
                p(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> Zc = dVar.bHZ().Zc();
                if (Zc != null && Zc.size() > 0 && !this.hyc) {
                    this.hxk.setText(String.valueOf(Zc.get(0).WY()));
                    this.hxj.setVisibility(0);
                } else {
                    this.hxj.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.k(this.hxj, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.d(this.hxk, d.C0277d.cp_link_tip_d, 1);
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
                            if (this.hqk != null) {
                                this.hqk.setTag(d.g.tag_user_id, c.YR().getUserId());
                                this.hqk.setOnClickListener(this.hoW.hmX.hAf);
                                this.hqk.a(iconInfo, 4, this.hoW.getResources().getDimensionPixelSize(d.e.tbds36), this.hoW.getResources().getDimensionPixelSize(d.e.tbds36), this.hoW.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.hqj != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hqj.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hqj.setOnClickListener(this.hoW.hmX.hAg);
                                this.hqj.a(tShowInfoNew, 3, this.hoW.getResources().getDimensionPixelSize(d.e.tbds36), this.hoW.getResources().getDimensionPixelSize(d.e.tbds36), this.hoW.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.hwb.setText(bN(c.YR().getSealPrefix(), g));
                            this.hwb.setTag(d.g.tag_user_id, c.YR().getUserId());
                            this.hwb.setTag(d.g.tag_user_name, c.YR().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew) || c.YR().isBigV()) {
                                com.baidu.tbadk.core.util.al.d(this.hwb, d.C0277d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.d(this.hwb, d.C0277d.cp_cont_b, 1);
                            }
                            if (c.YR() == null) {
                                MetaData YR = c.YR();
                                if (YR.getIs_bawu() == 1 && "manager".equals(YR.getBawu_type())) {
                                    this.hwc.setText(d.j.bawu_member_bazhu_tip);
                                    this.hwc.setVisibility(0);
                                } else if (YR.getIs_bawu() == 1 && "assist".equals(YR.getBawu_type())) {
                                    this.hwc.setText(d.j.bawu_member_xbazhu_tip);
                                    this.hwc.setVisibility(0);
                                } else {
                                    this.hwc.setVisibility(8);
                                }
                            } else {
                                this.hwc.setVisibility(8);
                            }
                            if (dVar.bHZ().YR() != null && dVar.bHZ().YR().getAlaUserData() != null && this.hwh != null) {
                                if (dVar.bHZ().YR().getAlaUserData().anchor_live != 0) {
                                    this.hwh.setVisibility(8);
                                } else {
                                    this.hwh.setVisibility(0);
                                    if (this.hvK == null) {
                                        this.hvK = new com.baidu.tieba.c.d(this.hoW.getPageContext(), this.hwh);
                                        this.hvK.oM(1);
                                    }
                                    this.hvK.cu(this.hoW.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bsJ = dVar.bHZ().YR().getAlaUserData();
                                    aVar.type = 2;
                                    this.hwh.setTag(aVar);
                                }
                            }
                            this.hwg.setUserId(c.YR().getUserId());
                            this.hwg.setUserName(c.YR().getUserName());
                            this.hwg.setTid(c.getId());
                            this.hwg.setFid(this.hsp == null ? this.hsp.getForumId() : "");
                            this.hwg.setImageDrawable(null);
                            this.hwg.setRadius(com.baidu.adp.lib.util.l.h(this.hoW.getActivity(), d.e.ds40));
                            this.hwg.setTag(c.YR().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hwo.setText(com.baidu.tbadk.core.util.ap.aq(c.getTime()));
                            } else {
                                this.hwo.setText(com.baidu.tbadk.core.util.ap.ao(c.getTime()));
                            }
                            cew = c.cew();
                            if (cew == null && !TextUtils.isEmpty(cew.getName()) && !TextUtils.isEmpty(cew.getName().trim())) {
                                this.hwp.setVisibility(0);
                                this.hwq.setVisibility(0);
                                this.hwp.setText(cew.getName());
                            } else {
                                this.hwp.setVisibility(8);
                                this.hwq.setVisibility(8);
                            }
                            portrait = c.YR().getPortrait();
                            if (c.YR().getPendantData() == null && !StringUtils.isNull(c.YR().getPendantData().Xn())) {
                                this.hwe.b(c.YR());
                                this.hwg.setVisibility(8);
                                this.hwe.setVisibility(0);
                                if (this.hwk != null) {
                                    this.hwk.setVisibility(8);
                                }
                                this.hwb.setOnClickListener(this.hyn);
                                this.hwe.getHeadView().startLoad(portrait, 28, false);
                                this.hwe.getHeadView().setUserId(c.YR().getUserId());
                                this.hwe.getHeadView().setUserName(c.YR().getUserName());
                                this.hwe.getHeadView().setTid(c.getId());
                                this.hwe.getHeadView().setFid(this.hsp != null ? this.hsp.getForumId() : "");
                                this.hwe.getHeadView().setOnClickListener(this.hyn);
                                this.hwe.nm(c.YR().getPendantData().Xn());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hwg, c.YR());
                                this.hwg.setVisibility(0);
                                this.hvZ.setOnClickListener(this.hyn);
                                this.hwb.setOnClickListener(this.hyn);
                                this.hwg.setOnClickListener(this.hyn);
                                this.hwe.setVisibility(8);
                                this.hwg.startLoad(portrait, 28, false);
                            }
                            String name_show = c.YR().getName_show();
                            String userName = c.YR().getUserName();
                            if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                                this.hwb.setText(com.baidu.tieba.pb.c.aP(this.hoW.getPageContext().getPageActivity(), this.hwb.getText().toString()));
                                this.hwb.setGravity(16);
                                this.hwb.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHK());
                                com.baidu.tbadk.core.util.al.d(this.hwb, d.C0277d.cp_other_e, 1);
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo2 = c.YR().getIconInfo();
                        tShowInfoNew = c.YR().getTShowInfoNew();
                        if (this.hqk != null) {
                        }
                        if (this.hqj != null) {
                        }
                        this.hwb.setText(bN(c.YR().getSealPrefix(), g));
                        this.hwb.setTag(d.g.tag_user_id, c.YR().getUserId());
                        this.hwb.setTag(d.g.tag_user_name, c.YR().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hwb, d.C0277d.cp_cont_h, 1);
                        if (c.YR() == null) {
                        }
                        if (dVar.bHZ().YR() != null) {
                            if (dVar.bHZ().YR().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hwg.setUserId(c.YR().getUserId());
                        this.hwg.setUserName(c.YR().getUserName());
                        this.hwg.setTid(c.getId());
                        this.hwg.setFid(this.hsp == null ? this.hsp.getForumId() : "");
                        this.hwg.setImageDrawable(null);
                        this.hwg.setRadius(com.baidu.adp.lib.util.l.h(this.hoW.getActivity(), d.e.ds40));
                        this.hwg.setTag(c.YR().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cew = c.cew();
                        if (cew == null) {
                        }
                        this.hwp.setVisibility(8);
                        this.hwq.setVisibility(8);
                        portrait = c.YR().getPortrait();
                        if (c.YR().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hwg, c.YR());
                        this.hwg.setVisibility(0);
                        this.hvZ.setOnClickListener(this.hyn);
                        this.hwb.setOnClickListener(this.hyn);
                        this.hwg.setOnClickListener(this.hyn);
                        this.hwe.setVisibility(8);
                        this.hwg.startLoad(portrait, 28, false);
                        String name_show2 = c.YR().getName_show();
                        String userName2 = c.YR().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                            this.hwb.setText(com.baidu.tieba.pb.c.aP(this.hoW.getPageContext().getPageActivity(), this.hwb.getText().toString()));
                            this.hwb.setGravity(16);
                            this.hwb.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHK());
                            com.baidu.tbadk.core.util.al.d(this.hwb, d.C0277d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            g = com.baidu.tbadk.core.util.ap.g(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.YR().getIconInfo();
                            tShowInfoNew = c.YR().getTShowInfoNew();
                            if (this.hqk != null) {
                            }
                            if (this.hqj != null) {
                            }
                            this.hwb.setText(bN(c.YR().getSealPrefix(), g));
                            this.hwb.setTag(d.g.tag_user_id, c.YR().getUserId());
                            this.hwb.setTag(d.g.tag_user_name, c.YR().getName_show());
                            if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.d(this.hwb, d.C0277d.cp_cont_h, 1);
                            if (c.YR() == null) {
                            }
                            if (dVar.bHZ().YR() != null) {
                            }
                            this.hwg.setUserId(c.YR().getUserId());
                            this.hwg.setUserName(c.YR().getUserName());
                            this.hwg.setTid(c.getId());
                            this.hwg.setFid(this.hsp == null ? this.hsp.getForumId() : "");
                            this.hwg.setImageDrawable(null);
                            this.hwg.setRadius(com.baidu.adp.lib.util.l.h(this.hoW.getActivity(), d.e.ds40));
                            this.hwg.setTag(c.YR().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            cew = c.cew();
                            if (cew == null) {
                            }
                            this.hwp.setVisibility(8);
                            this.hwq.setVisibility(8);
                            portrait = c.YR().getPortrait();
                            if (c.YR().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hwg, c.YR());
                            this.hwg.setVisibility(0);
                            this.hvZ.setOnClickListener(this.hyn);
                            this.hwb.setOnClickListener(this.hyn);
                            this.hwg.setOnClickListener(this.hyn);
                            this.hwe.setVisibility(8);
                            this.hwg.startLoad(portrait, 28, false);
                            String name_show22 = c.YR().getName_show();
                            String userName22 = c.YR().getUserName();
                            if (com.baidu.tbadk.s.ao.jK()) {
                            }
                        }
                        g = string;
                        ArrayList<IconData> iconInfo222 = c.YR().getIconInfo();
                        tShowInfoNew = c.YR().getTShowInfoNew();
                        if (this.hqk != null) {
                        }
                        if (this.hqj != null) {
                        }
                        this.hwb.setText(bN(c.YR().getSealPrefix(), g));
                        this.hwb.setTag(d.g.tag_user_id, c.YR().getUserId());
                        this.hwb.setTag(d.g.tag_user_name, c.YR().getName_show());
                        if (com.baidu.tbadk.core.util.v.T(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.d(this.hwb, d.C0277d.cp_cont_h, 1);
                        if (c.YR() == null) {
                        }
                        if (dVar.bHZ().YR() != null) {
                        }
                        this.hwg.setUserId(c.YR().getUserId());
                        this.hwg.setUserName(c.YR().getUserName());
                        this.hwg.setTid(c.getId());
                        this.hwg.setFid(this.hsp == null ? this.hsp.getForumId() : "");
                        this.hwg.setImageDrawable(null);
                        this.hwg.setRadius(com.baidu.adp.lib.util.l.h(this.hoW.getActivity(), d.e.ds40));
                        this.hwg.setTag(c.YR().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cew = c.cew();
                        if (cew == null) {
                        }
                        this.hwp.setVisibility(8);
                        this.hwq.setVisibility(8);
                        portrait = c.YR().getPortrait();
                        if (c.YR().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hwg, c.YR());
                        this.hwg.setVisibility(0);
                        this.hvZ.setOnClickListener(this.hyn);
                        this.hwb.setOnClickListener(this.hyn);
                        this.hwg.setOnClickListener(this.hyn);
                        this.hwe.setVisibility(8);
                        this.hwg.startLoad(portrait, 28, false);
                        String name_show222 = c.YR().getName_show();
                        String userName222 = c.YR().getUserName();
                        if (com.baidu.tbadk.s.ao.jK()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hvY.aw(dVar.bHZ());
                }
                if (this.hxs != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hkG);
                    if (dVar != null && dVar.bHZ() != null) {
                        hVar.hkI = dVar.bHZ().YI();
                    }
                    hVar.isNew = !this.hpn;
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
                    hVar.hkL = this.hoW.bKb();
                    this.hxs.a(hVar);
                }
                if (dVar != null && dVar.bHZ() != null) {
                    ab(dVar.bHZ().YN() == 1, dVar.bHZ().YM() == 1);
                }
                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hwA != null && aq.this.hvN != null && aq.this.hvN.hAR != null && aq.this.hsp != null && aq.this.hsp.bHZ() != null && !aq.this.hsp.bHZ().ZL() && !aq.this.bMV() && aq.this.hsp.getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(aq.this.hsp.getForum().getName())) {
                            if (aq.this.hwA.bKz() == null || !aq.this.hwA.bKz().isShown()) {
                                aq.this.hvN.hAR.setVisibility(0);
                                if (aq.this.hoW != null && aq.this.hoW.bJa() != null) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13400");
                                    amVar.bJ("tid", aq.this.hoW.bJa().bKR());
                                    amVar.bJ(ImageViewerConfig.FORUM_ID, aq.this.hoW.bJa().getForumId());
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
        this.hxw.hyF = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxw));
        a(this.hxw.hyF, false);
    }

    public void bMP() {
        if (this.hvN != null && !this.hxN) {
            this.hvN.ok(!StringUtils.isNull(this.hoW.bJA()));
            this.hxN = true;
        }
    }

    public void aWP() {
        if (this.hvN != null) {
            this.hvN.bOa();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.Zm() != null) {
            this.hwa.setData(this.hoW.getPageContext(), dVar.bIb().get(0).Zm(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bHZ().getId(), this.hoW.bJY() ? "FRS" : null));
            this.hvZ.setPadding(this.hvZ.getPaddingLeft(), (int) this.hoW.getResources().getDimension(d.e.ds20), this.hvZ.getPaddingRight(), this.hvZ.getPaddingBottom());
            return;
        }
        this.hwa.setData(null, null, null);
    }

    public void bMQ() {
        if (this.hvH != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").T("obj_type", 1));
            this.hvH.bPm();
            this.hvR.smoothScrollToPosition(0);
        }
    }

    public boolean bMR() {
        return this.hyo;
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
            this.hvN.bNY();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hvN.xQ(cVar.forumName);
            }
            String string = this.hoW.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.hoW.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.hoW.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.hoW.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hjP;
            this.hoW.showNetRefreshView(this.eCv, format, null, this.hoW.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.lo()) {
                        ba.adD().c(aq.this.hoW.getPageContext(), new String[]{str2});
                        aq.this.hoW.finish();
                        return;
                    }
                    aq.this.hoW.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bMb;
        Parcelable bMb2;
        if (dVar != null) {
            this.hsp = dVar;
            this.mType = i;
            if (dVar.bHZ() != null) {
                this.hxy = dVar.bHZ().Yz();
                if (dVar.bHZ().getAnchorLevel() != 0) {
                    this.hyo = true;
                }
                this.hwU = ay(dVar.bHZ());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            t(dVar);
            this.hxi = false;
            this.hpn = z;
            bML();
            b(dVar, z, i);
            r(dVar);
            if (this.hxZ == null) {
                this.hxZ = new ac(this.hoW.getPageContext(), this.bso);
            }
            this.hxZ.zV(dVar.bIe());
            if (this.hoW.bJP()) {
                if (this.hwE == null) {
                    this.hwE = new com.baidu.tieba.pb.view.c(this.hoW.getPageContext());
                    this.hwE.oM();
                    this.hwE.setListPullRefreshListener(this.bRG);
                }
                this.hvR.setPullRefresh(this.hwE);
                bMS();
                if (this.hwE != null) {
                    this.hwE.ic(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().XL() == 0 && z) {
                this.hvR.setPullRefresh(null);
            } else {
                if (this.hwE == null) {
                    this.hwE = new com.baidu.tieba.pb.view.c(this.hoW.getPageContext());
                    this.hwE.oM();
                    this.hwE.setListPullRefreshListener(this.bRG);
                }
                this.hvR.setPullRefresh(this.hwE);
                bMS();
                if (this.hwE != null) {
                    this.hwE.ic(TbadkCoreApplication.getInst().getSkinType());
                }
                aME();
            }
            bMW();
            this.hwA.nd(this.hpn);
            this.hwA.ne(false);
            this.hwA.np(i == 5);
            this.hwA.nq(i == 6);
            this.hwA.nr(z2 && this.hym);
            this.hwA.a(dVar, false);
            this.hwA.notifyDataSetChanged();
            if (this.hoW.bIQ()) {
                this.hxP = 0;
                PostData c = c(dVar, z);
                if (c != null && c.YR() != null) {
                    this.hxP = c.YR().getLevel_id();
                }
                if (this.hxP > 0) {
                    this.hwd.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.hwd, BitmapHelper.getGradeResourceIdInEnterForum(this.hxP));
                } else {
                    this.hwd.setVisibility(8);
                }
            } else {
                this.hwd.setVisibility(8);
            }
            if (dVar.bHZ() != null && dVar.bHZ().YD() != null) {
                if (dVar.bHZ().YD().getNum() < 1) {
                    this.hoW.getResources().getString(d.j.zan);
                } else {
                    String str = dVar.bHZ().YD().getNum() + "";
                }
                if (this.hvG != -1) {
                    dVar.bHZ().YD().setIsLike(this.hvG);
                }
            }
            if (this.hoW.isLogin()) {
                this.hvR.setNextPage(this.fff);
                this.hvM = 2;
                aME();
            } else {
                this.hxi = true;
                if (dVar.getPage().XK() == 1) {
                    if (this.hwF == null) {
                        this.hwF = new com.baidu.tieba.pb.view.a(this.hoW.getPageContext());
                    }
                    this.hvR.setNextPage(this.hwF);
                } else {
                    this.hvR.setNextPage(this.fff);
                }
                this.hvM = 3;
            }
            ArrayList<PostData> bIb = dVar.bIb();
            if (dVar.getPage().XK() == 0 || bIb == null || bIb.size() < dVar.getPage().XJ()) {
                if (com.baidu.tbadk.core.util.v.S(bIb) == 0 || (com.baidu.tbadk.core.util.v.S(bIb) == 1 && bIb.get(0) != null && bIb.get(0).cet() == 1)) {
                    if (this.hxw == null || this.hxw.hyF == null || this.hxw.hyF.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hxw.hyF.getView().getTop() < 0 ? this.hxw.hyF.getView().getHeight() : this.hxw.hyF.getView().getBottom();
                    }
                    if (this.hoW.bKb()) {
                        this.fff.aa(this.hoW.getResources().getString(d.j.pb_no_host_reply), i4);
                    } else {
                        this.fff.aa(this.hoW.getResources().getString(d.j.pb_no_replay), i4);
                    }
                    if (this.hoW.bJp() != null && !this.hoW.bJp().bNN()) {
                        this.hoW.bJp().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().XK() == 0) {
                        this.fff.setText(this.hoW.getResources().getString(d.j.list_has_no_more));
                    } else {
                        this.fff.setText(this.hoW.getResources().getString(d.j.load_more));
                    }
                    this.fff.aeH();
                }
                bNe();
            } else {
                if (z2) {
                    if (this.hym) {
                        aeD();
                        if (dVar.getPage().XK() != 0) {
                            this.fff.setText(this.hoW.getResources().getString(d.j.pb_load_more));
                        }
                    } else {
                        this.fff.aey();
                        this.fff.showLoading();
                    }
                } else {
                    this.fff.aey();
                    this.fff.showLoading();
                }
                this.fff.aeH();
            }
            switch (i) {
                case 2:
                    this.hvR.setSelection(i2 > 1 ? (((this.hvR.getData() == null && dVar.bIb() == null) ? 0 : (this.hvR.getData().size() - dVar.bIb().size()) + this.hvR.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bMb2 = aj.bMa().bMb()) != null) {
                        this.hvR.onRestoreInstanceState(bMb2);
                        if (com.baidu.tbadk.core.util.v.S(bIb) > 1 && dVar.getPage().XK() > 0) {
                            this.fff.aeD();
                            this.fff.setText(this.hoW.getString(d.j.pb_load_more_without_point));
                            this.fff.aez();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hym = false;
                    break;
                case 5:
                    this.hvR.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bMb = aj.bMa().bMb()) != null) {
                        this.hvR.onRestoreInstanceState(bMb);
                        break;
                    } else {
                        this.hvR.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.hvH != null && this.hvH.aBC() != null) {
                            if (this.hoW.isUseStyleImmersiveSticky()) {
                                this.hvR.setSelectionFromTop((this.hwA.bKu() + this.hvR.getHeaderViewsCount()) - 1, this.hvH.aBC().getHeight() - com.baidu.adp.lib.util.l.r(this.hoW.getPageContext().getPageActivity()));
                            } else {
                                this.hvR.setSelectionFromTop((this.hwA.bKu() + this.hvR.getHeaderViewsCount()) - 1, this.hvH.aBC().getHeight());
                            }
                        } else {
                            this.hvR.setSelection(this.hwA.bKu() + this.hvR.getHeaderViewsCount());
                        }
                    } else {
                        this.hvR.setSelection(i2 > 0 ? ((this.hvR.getData() == null && dVar.bIb() == null) ? 0 : (this.hvR.getData().size() - dVar.bIb().size()) + this.hvR.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.fff.aeD();
                    this.fff.setText(this.hoW.getString(d.j.pb_load_more_without_point));
                    this.fff.aez();
                    break;
            }
            if (this.hxy == hxz && isHost()) {
                bNm();
            }
            if (this.hxJ) {
                bMk();
                this.hxJ = false;
                if (i3 == 0) {
                    nJ(true);
                }
            }
            if (this.hvJ != null) {
                this.hvJ.aD(dVar.bHZ());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hkt == 1 || dVar.hku == 1) {
                if (this.hxQ == null) {
                    this.hxQ = new PbTopTipView(this.hoW);
                }
                if (dVar.hku == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hoW.getStType())) {
                    this.hxQ.setText(this.hoW.getString(d.j.pb_read_strategy_add_experience));
                    this.hxQ.show(this.eCv, this.mSkinType);
                } else if (dVar.hkt == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hoW.getStType())) {
                    this.hxQ.setText(this.hoW.getString(d.j.pb_read_news_add_experience));
                    this.hxQ.show(this.eCv, this.mSkinType);
                }
            }
            q(dVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHZ() != null) {
            if (dVar.Vb()) {
                com.baidu.tbadk.core.util.al.c(this.hxb, d.f.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.al.c(this.hxb, d.f.icon_pb_bottom_collect_n);
            }
            String wA = wA(dVar.bHZ().YI());
            this.hxd.M(wA, wA == null);
            this.hxd.setVisibility(0);
        }
    }

    private String wA(int i) {
        if (i == 0) {
            return this.hoW.getString(d.j.pb_comment_red_dot_no_reply);
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
        if (this.hvH != null && this.hvH.aBC() != null) {
            this.hvR.removeHeaderView(this.ahI);
            if (this.mType != 1) {
                this.hvR.removeHeaderView(this.hvH.bPo());
                this.hvR.addHeaderView(this.hvH.bPo(), 0);
                return;
            }
            return;
        }
        if (this.hvH != null) {
            this.hvR.removeHeaderView(this.hvH.bPo());
        }
        this.hvR.removeHeaderView(this.ahI);
        this.hvR.addHeaderView(this.ahI, 0);
    }

    public void nQ(boolean z) {
        this.hwT = z;
    }

    public void aeD() {
        if (this.fff != null) {
            this.fff.aez();
            this.fff.aeD();
        }
        aME();
    }

    public void aOA() {
        this.hvR.setVisibility(0);
    }

    public void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hxh != null && this.hxh.YR() != null && this.hvN != null) {
            this.hxM = !this.hxL;
            this.hvN.of(this.hxM);
            if (this.hoW.bJp() != null) {
                this.hoW.bJp().oe(this.hxM);
            }
            bMT();
            if (this.hoW != null && !this.hoW.bIQ() && !com.baidu.tbadk.core.util.v.T(dVar.bIu())) {
                bc bcVar = dVar.bIu().get(0);
                if (bcVar != null) {
                    this.hvN.dA(bcVar.getForumName(), bcVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hvN.dA(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hxM) {
                if (this.hwU) {
                    this.hwl.setVisibility(8);
                    this.hwn.setVisibility(0);
                    this.hwn.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIv())));
                }
                if (this.hxr != null) {
                    this.hxr.setVisibility(8);
                }
                if (this.hxX == null) {
                    this.hxX = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hxO) {
                                aq.this.bNl();
                            }
                            aq.this.bMM();
                        }
                    };
                }
                this.hvR.setListViewDragListener(this.hxX);
                return;
            }
            if (this.hxr != null) {
                this.hxr.setVisibility(0);
            }
            if (this.hwU) {
                this.hwl.setVisibility(8);
                this.hwn.setVisibility(0);
                this.hwn.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.au(dVar.bIv())));
            } else if (!PbNormalLikeButtonSwitchStatic.apH() || (this.hxh.YR().hadConcerned() && this.hxh.YR().getGodUserData() != null && this.hxh.YR().getGodUserData().getIsFromNetWork())) {
                this.hwl.setVisibility(8);
                this.hwn.setVisibility(8);
            } else {
                this.hwn.setVisibility(8);
            }
            this.hxX = null;
            this.hvR.setListViewDragListener(null);
        }
    }

    private void bMT() {
        String threadId = this.hsp != null ? this.hsp.getThreadId() : "";
        int bMU = bMU();
        if (this.hxM && this.hxh != null && this.hxh.YR() != null) {
            this.hxh.YR().setIsLike(this.hxh.YR().hadConcerned());
        }
        if (this.hwm == null) {
            this.hwm = new ao(this.hoW.getPageContext(), this.hwl, 1);
            this.hwm.i(this.hoW.getUniqueId());
            this.hwm.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void dV(boolean z) {
                    if (aq.this.hoW != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hoW, d.j.attention_success);
                    }
                }
            });
        }
        if (this.hxh != null && this.hxh.YR() != null) {
            this.hxh.YR().setIsLike(this.hxh.YR().hadConcerned());
            this.hwm.a(this.hxh.YR());
            this.hwm.setTid(threadId);
        }
        this.hwm.hvC = this.hxL;
        this.hwm.wx(bMU);
    }

    public int bMU() {
        if (this.hsp == null || this.hsp.bHZ() == null) {
            return 0;
        }
        if (this.hsp.bHZ().aaj()) {
            return (com.baidu.tbadk.core.util.v.T(this.hsp.bIu()) && (this.hsp.bHY() == null || StringUtils.isNull(this.hsp.bHY().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bMV() {
        return this.hsp == null || this.hsp.getForum() == null || "0".equals(this.hsp.getForum().getId()) || "me0407".equals(this.hsp.getForum().getName());
    }

    private boolean bMW() {
        boolean z;
        if (this.hwX != null && this.hwX.getVisibility() == 0) {
            if (this.hww != null) {
                this.hww.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hww != null) {
                this.hww.setVisibility(8);
            }
            z = false;
        }
        if ((this.hwy == null || this.hwy.getVisibility() == 8) && z && this.hpn) {
            this.hwx.setVisibility(0);
        } else {
            this.hwx.setVisibility(8);
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
            return com.baidu.tieba.card.n.a((Context) this.hoW.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hvT != null) {
                if (dVar.bHZ() != null && dVar.bHZ().Zg() == 0 && !dVar.bHZ().ZL() && !this.hyc) {
                    this.hvT.setVisibility(0);
                    if (dVar.bHZ() != null) {
                        bg bHZ = dVar.bHZ();
                        bHZ.k(true, s(dVar));
                        bHZ.setResource(3);
                        bHZ.li("2");
                    }
                    SpannableStringBuilder Zx = dVar.bHZ().Zx();
                    this.hvU.setOnTouchListener(new com.baidu.tieba.view.k(Zx));
                    this.hvU.setText(Zx);
                    this.hvU.setVisibility(0);
                } else if (dVar.bHZ().Zg() == 1) {
                    if (dVar.bHZ() != null) {
                        this.hvT.setVisibility(8);
                        this.hvR.removeHeaderView(this.hvT);
                    }
                } else {
                    this.hvT.setVisibility(8);
                    this.hvR.removeHeaderView(this.hvT);
                    if (dVar.bHZ() != null && dVar.bHZ().ZL()) {
                        this.hvZ.setPadding(this.hvZ.getPaddingLeft(), 0, this.hvZ.getPaddingRight(), this.hvZ.getPaddingBottom());
                        if (this.hwr != null) {
                            ((RelativeLayout.LayoutParams) this.hwr.getLayoutParams()).height = (int) this.hoW.getResources().getDimension(d.e.tbds36);
                            this.hwr.requestLayout();
                        }
                        if (this.hws != null) {
                            ((RelativeLayout.LayoutParams) this.hws.getLayoutParams()).height = (int) this.hoW.getResources().getDimension(d.e.tbds0);
                            this.hws.requestLayout();
                        }
                    } else {
                        this.hvZ.setPadding(this.hvZ.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.hoW.getPageContext().getPageActivity(), d.e.ds48), this.hvZ.getPaddingRight(), this.hvZ.getPaddingBottom());
                    }
                }
            }
            if (dVar.bHZ() != null) {
                aa(dVar.bHZ().YN() == 1, dVar.bHZ().YM() == 1);
            }
            this.hpn = z;
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
                        if (bcVar != null && !StringUtils.isNull(bcVar.getForumName()) && (vVar = bcVar.bAA) != null && vVar.byt && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(bcVar.getForumName(), 12)).append(this.hoW.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.hoW.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.cpF;
    }

    public boolean bMX() {
        if (this.eoO == null || this.eoO.getParent() == null || this.fff.qz()) {
            return false;
        }
        int bottom = this.eoO.getBottom();
        Rect rect = new Rect();
        this.eoO.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void zW(String str) {
        if (this.fff != null) {
            this.fff.setText(str);
        }
    }

    public void zX(String str) {
        if (this.fff != null) {
            int i = 0;
            if (this.hxw != null && this.hxw.hyF != null && this.hxw.hyF.getView() != null) {
                i = this.hxw.hyF.getView().getTop() < 0 ? this.hxw.hyF.getView().getHeight() : this.hxw.hyF.getView().getBottom();
            }
            this.fff.aa(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hvR;
    }

    public int bMY() {
        return d.g.richText;
    }

    public TextView bJl() {
        return this.hvY.bJl();
    }

    public void e(BdListView.e eVar) {
        this.hvR.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.bRG = cVar;
        if (this.hwE != null) {
            this.hwE.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int XI = anVar.XI();
            int XF = anVar.XF();
            if (this.hwB != null) {
                this.hwB.aaZ();
            } else {
                this.hwB = new com.baidu.tbadk.core.dialog.a(this.hoW.getPageContext().getPageActivity());
                this.hwC = LayoutInflater.from(this.hoW.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.hwB.az(this.hwC);
                this.hwB.a(d.j.dialog_ok, bVar);
                this.hwB.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bNa();
                        aVar.dismiss();
                    }
                });
                this.hwB.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hxG == null) {
                            aq.this.hxG = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hoW.HidenSoftKeyPad((InputMethodManager) aq.this.hoW.getSystemService("input_method"), aq.this.eCv);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jH().postDelayed(aq.this.hxG, 150L);
                    }
                });
                this.hwB.b(this.hoW.getPageContext()).aaZ();
            }
            this.hwD = (EditText) this.hwC.findViewById(d.g.input_page_number);
            this.hwD.setText("");
            TextView textView = (TextView) this.hwC.findViewById(d.g.current_page_number);
            if (XI <= 0) {
                XI = 1;
            }
            if (XF <= 0) {
                XF = 1;
            }
            textView.setText(MessageFormat.format(this.hoW.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(XI), Integer.valueOf(XF)));
            this.hoW.ShowSoftKeyPadDelay(this.hwD, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hvR.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hoW.showToast(str);
    }

    public boolean nR(boolean z) {
        if (this.VN == null || !this.VN.alV()) {
            return false;
        }
        this.VN.akp();
        return true;
    }

    public void bMZ() {
        if (this.hyp != null) {
            while (this.hyp.size() > 0) {
                TbImageView remove = this.hyp.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bMZ();
        this.hwA.wi(1);
        if (this.hvH != null) {
            this.hvH.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hwA.wi(2);
        if (this.hvH != null) {
            this.hvH.onResume();
            if (!UtilHelper.isOnePlus6()) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hxI != null) {
            this.hxI.destroy();
        }
        if (this.hxZ != null) {
            this.hxZ.onDestory();
        }
        if (this.hxQ != null) {
            this.hxQ.hide();
        }
        if (this.hvK != null) {
            this.hvK.aSr();
        }
        if (this.hvJ != null) {
            this.hvJ.onDestroy();
        }
        this.hoW.hideProgressBar();
        if (this.eCt != null && this.eWD != null) {
            this.eCt.b(this.eWD);
        }
        bNa();
        aeD();
        if (this.hxG != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hxG);
        }
        if (this.hvZ != null && this.hwk != null) {
            this.hvZ.removeView(this.hwf);
            this.hwk = null;
        }
        if (this.hxm != null) {
            this.hxm.clearStatus();
        }
        this.hyi = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hwA.wi(3);
        if (this.fbl != null) {
            this.fbl.setBackgroundDrawable(null);
        }
        if (this.hvH != null) {
            this.hvH.destroy();
        }
        if (this.hwA != null) {
            this.hwA.onDestroy();
        }
        this.hvR.setOnLayoutListener(null);
        if (this.hxV != null) {
            this.hxV.beY();
        }
        if (this.hxx != null) {
            this.hxx.onDestroy();
        }
    }

    public boolean wB(int i) {
        if (this.hvH != null) {
            return this.hvH.qw(i);
        }
        return false;
    }

    public void bNa() {
        this.hvN.Qk();
        if (this.hvK != null) {
            this.hvK.aSr();
        }
        com.baidu.adp.lib.util.l.b(this.hoW.getPageContext().getPageActivity(), this.hwD);
        bMm();
        if (this.hnc != null) {
            this.hnc.dismiss();
        }
        bNc();
        if (this.hvJ != null) {
            this.hvJ.bPd();
        }
        if (this.hwB != null) {
            this.hwB.dismiss();
        }
        if (this.faX != null) {
            this.faX.dismiss();
        }
    }

    public void bNb() {
        this.hvN.Qk();
        if (this.hvK != null) {
            this.hvK.aSr();
        }
        if (this.hnc != null) {
            this.hnc.dismiss();
        }
        bNc();
        if (this.hvJ != null) {
            this.hvJ.bPd();
        }
        if (this.hwB != null) {
            this.hwB.dismiss();
        }
        if (this.faX != null) {
            this.faX.dismiss();
        }
    }

    public void dD(List<String> list) {
        this.hxU = list;
        if (this.hxV != null) {
            this.hxV.setData(list);
        }
    }

    public void nc(boolean z) {
        this.hwA.nc(z);
    }

    public void nS(boolean z) {
        this.hwW = z;
    }

    public void bNc() {
        if (this.hwK != null) {
            this.hwK.dismiss();
        }
        if (this.hwL != null) {
            com.baidu.adp.lib.g.g.b(this.hwL, this.hoW.getPageContext());
        }
        if (this.hwM != null) {
            com.baidu.adp.lib.g.g.b(this.hwM, this.hoW.getPageContext());
        }
        if (this.hwI != null) {
            this.hwI.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hsp, this.hpn);
            d(this.hsp, this.hpn, this.mType);
            this.hoW.getLayoutMode().setNightMode(i == 1);
            this.hoW.getLayoutMode().onModeChanged(this.eCv);
            this.hoW.getLayoutMode().onModeChanged(this.hvS);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.al.l(this.eCv, d.C0277d.cp_bg_line_d);
            }
            if (this.hvJ != null) {
                this.hvJ.onChangeSkinType(i);
            }
            if (this.hvU != null) {
                com.baidu.tbadk.core.util.al.j(this.hvU, d.C0277d.cp_cont_b);
                this.hvU.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            }
            if (this.fff != null) {
                this.fff.ic(i);
                if (this.cpF != null) {
                    this.hoW.getLayoutMode().onModeChanged(this.cpF);
                    com.baidu.tbadk.core.util.al.k(this.cpF, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.hwB != null) {
                this.hwB.c(this.hoW.getPageContext());
            }
            nQ(this.hwT);
            this.hwA.notifyDataSetChanged();
            if (this.hwE != null) {
                this.hwE.ic(i);
            }
            if (this.VN != null) {
                this.VN.onChangeSkinType(i);
            }
            if (this.hwj != null) {
                this.hwj.ij(i);
            }
            if (this.hwF != null) {
                this.hwF.ic(i);
            }
            if (!com.baidu.tbadk.core.util.v.T(this.ekt)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ekt) {
                    customBlueCheckRadioButton.aeh();
                }
            }
            bMB();
            UtilHelper.setStatusBarBackground(this.fbl, i);
            UtilHelper.setStatusBarBackground(this.hxr, i);
            if (this.hwl != null) {
                this.hwl.onChangeSkinType(i);
            }
            if (this.hwp != null) {
                com.baidu.tbadk.core.util.al.j(this.hwp, d.C0277d.cp_cont_d);
            }
            if (this.hwo != null) {
                com.baidu.tbadk.core.util.al.j(this.hwo, d.C0277d.cp_cont_d);
            }
            if (this.hwq != null) {
                com.baidu.tbadk.core.util.al.j(this.hwq, d.C0277d.cp_cont_d);
            }
            if (this.hwc != null) {
                com.baidu.tbadk.core.util.al.j(this.hwc, d.C0277d.cp_link_tip_a);
            }
            if (this.hwn != null) {
                com.baidu.tbadk.core.util.al.j(this.hwn, d.C0277d.cp_cont_d);
            }
            if (this.hwt != null) {
                com.baidu.tbadk.r.a.a(this.hoW.getPageContext(), this.hwt);
            }
            if (this.hxH != null) {
                this.hxH.onChangeSkinType(i);
            }
            if (this.hvN != null) {
                if (this.hvH != null) {
                    this.hvH.wG(i);
                } else {
                    this.hvN.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fPe != null) {
                com.baidu.tbadk.core.util.al.j(this.fPe, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.k(this.fPe, d.f.bg_comment_input);
            }
            if (this.hxb != null && this.hsp != null) {
                if (this.hsp.Vb()) {
                    com.baidu.tbadk.core.util.al.c(this.hxb, d.f.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.hxb, d.f.icon_pb_bottom_collect_n);
                }
            }
            if (this.hxc != null) {
                com.baidu.tbadk.core.util.al.c(this.hxc, d.f.icon_pb_bottom_share_n);
            }
            if (this.hxa != null) {
                com.baidu.tbadk.core.util.al.c(this.hxa, d.f.icon_pb_bottom_comment_n);
            }
            if (this.hxd != null) {
                this.hxd.onChangeSkinType();
            }
            if (this.hwd != null) {
                com.baidu.tbadk.core.util.al.c(this.hwd, BitmapHelper.getGradeResourceIdInEnterForum(this.hxP));
            }
            if (this.hxW != null) {
                this.hxW.onChangeSkinType(i);
            }
            if (this.hxx != null) {
                this.hxx.onChangeSkinType();
            }
            if (this.hxS != null) {
                com.baidu.tbadk.core.util.al.j(this.hxS, d.C0277d.cp_cont_n);
            }
            com.baidu.tbadk.core.util.al.l(this.hwZ, d.C0277d.cp_bg_line_d);
            if (this.hwc != null) {
                com.baidu.tbadk.core.util.al.k(this.hwc, d.f.bg_user_identity_btn);
                com.baidu.tbadk.core.util.al.j(this.hwc, d.C0277d.cp_bg_line_d);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAB = hVar;
        this.hwA.setOnImageClickListener(this.cAB);
        this.hxW.setOnImageClickListener(this.cAB);
    }

    public void h(NoNetworkView.a aVar) {
        this.eWD = aVar;
        if (this.eCt != null) {
            this.eCt.a(this.eWD);
        }
    }

    public void nT(boolean z) {
        this.hwA.setIsFromCDN(z);
    }

    public Button bNd() {
        return this.hwX;
    }

    public void bNe() {
        if (this.hvM != 2) {
            this.hvR.setNextPage(this.fff);
            this.hvM = 2;
        }
    }

    public void bNf() {
        if (com.baidu.tbadk.o.m.apk().apl()) {
            int lastVisiblePosition = this.hvR.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hvR.getChildAt(i);
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
        return this.VN != null && this.VN.getVisibility() == 0;
    }

    public boolean bNh() {
        return this.VN != null && this.VN.alV();
    }

    public void bNi() {
        if (this.VN != null) {
            this.VN.akp();
        }
    }

    public void nU(boolean z) {
        if (this.hwZ != null) {
            nS(this.hoW.bJm().amz());
            if (this.hwW) {
                nK(z);
            } else {
                nL(z);
            }
        }
    }

    public void bNj() {
        if (this.hwZ != null) {
            this.hwY.setVisibility(8);
            this.hwZ.setVisibility(8);
            this.hxe = false;
            if (this.hxx != null) {
                this.hxx.setVisibility(8);
                nO(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.esc == null) {
            this.esc = new com.baidu.tbadk.core.view.b(this.hoW.getPageContext());
        }
        this.esc.dJ(true);
    }

    public void aME() {
        if (this.esc != null) {
            this.esc.dJ(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hvR.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hvR.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hvH != null) {
            this.hvH.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hyq = getScrollY();
            this.hxw.hyF = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxw));
            a(this.hxw.hyF, true);
        }
    }

    public void nV(boolean z) {
        this.hvH.nV(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hvH != null) {
            this.hvH.b(absListView, i);
        }
        if (this.hvN != null && this.hwA != null) {
            this.hvN.a(this.hwA.bKz());
        }
        this.hxw.hfp = i;
        this.hxw.headerCount = this.hvR.getHeaderViewsCount();
        this.hxw.hyF = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hxw));
        a(this.hxw.hyF, false);
        if (this.fff.aeJ() && !this.fff.bRv) {
            if (this.hxw != null && this.hxw.hyF != null && this.hxw.hyF.getView() != null) {
                i4 = this.hxw.hyF.getView().getTop() < 0 ? this.hxw.hyF.getView().getHeight() : this.hxw.hyF.getView().getBottom();
            }
            this.fff.m19if(i4);
            this.fff.bRv = true;
        }
    }

    public void bNk() {
        if (this.hoW.isLogin() && this.hsp != null && this.hxM && !this.hxL && !this.hwU && this.hxh != null && this.hxh.YR() != null && !this.hxh.YR().getIsLike() && !this.hxh.YR().hadConcerned() && this.hxI == null) {
            this.hxI = new an(this.hoW);
        }
    }

    public void bNl() {
        if (this.hxM && !this.hxL && this.hxh != null && this.hxh.YR() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").T("obj_locate", this.hoW.bIQ() ? 2 : 1).T("obj_type", this.hxL ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hoW.getPageContext().getPageActivity(), this.hxh.YR().getUserId(), this.hxh.YR().getUserName(), this.hoW.bJa().bIR(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hxL && this.hxq != null && this.hvN.bNT() != null) {
            int bKv = this.hwA.bKv();
            if (bKv > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bKv > this.hvR.getFirstVisiblePosition() - this.hvR.getHeaderViewsCount()) {
                    this.hxq.setVisibility(8);
                    return;
                }
                this.hxq.setVisibility(0);
                bNv();
                this.hvN.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.hvl == null) {
                if (this.hvR.getFirstVisiblePosition() == 0) {
                    this.hxq.setVisibility(8);
                    this.hvN.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hxv) {
                        this.hxu = top;
                        this.hxv = false;
                    }
                    this.hxu = top < this.hxu ? top : this.hxu;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hwz.getY() < 0.0f) {
                        measuredHeight = hxt - alVar.hvl.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hvN.bNT().getMeasuredHeight() - alVar.hvl.getMeasuredHeight();
                        this.hvN.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hxu) {
                        this.hxq.setVisibility(0);
                        bNv();
                    } else if (top < measuredHeight) {
                        this.hxq.setVisibility(0);
                        bNv();
                    } else {
                        this.hxq.setVisibility(8);
                        this.hvN.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hxv = true;
                    }
                }
            }
        }
    }

    public void bNm() {
        if (!this.hyr) {
            TiebaStatic.log("c10490");
            this.hyr = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hoW.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hxA, Integer.valueOf(hxC));
            aVar.gC(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hoW.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.az(inflate);
            aVar.ab(sparseArray);
            aVar.a(d.j.grade_button_tips, this.hoW);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hoW.getPageContext()).aaZ();
        }
    }

    public void zY(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hoW.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hoW.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.az(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hxA, Integer.valueOf(hxD));
        aVar.ab(sparseArray);
        aVar.a(d.j.view, this.hoW);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hoW.getPageContext()).aaZ();
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
        return this.hxm;
    }

    private void t(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHZ() != null && dVar.bHZ().ZR() && this.hxm == null) {
            this.hxm = (PbInterviewStatusView) this.hxl.inflate();
            this.hxm.setOnClickListener(this.faY);
            this.hxm.setCallback(this.hoW.bJX());
            this.hxm.setData(this.hoW, dVar);
        }
    }

    public LinearLayout bNo() {
        return this.hwz;
    }

    public View bNp() {
        return this.fbl;
    }

    public boolean bNq() {
        return this.hyc;
    }

    public void nh(boolean z) {
        this.hvY.nh(z);
    }

    public void zZ(String str) {
        if (this.hvO != null) {
            this.hvO.setTitle(str);
        }
    }

    private int nW(boolean z) {
        if (this.hxm == null || this.hxm.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.hoW.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bNr() {
        if (this.hxm != null && this.hxm.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hxm.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hxm.setLayoutParams(layoutParams);
        }
    }

    public boolean bJr() {
        return false;
    }

    public void Aa(String str) {
        this.fPe.performClick();
        if (!StringUtils.isNull(str) && this.hoW.bJm() != null && this.hoW.bJm().ams() != null && this.hoW.bJm().ams().getInputView() != null) {
            EditText inputView = this.hoW.bJm().ams().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bNa();
            if (configuration.orientation == 2) {
                bNj();
                bMm();
            } else {
                bMp();
            }
            if (this.hxH != null) {
                this.hxH.bKE();
            }
            this.hoW.bcN();
            this.hwz.setVisibility(8);
            this.hvN.og(false);
            this.hoW.nn(false);
            if (this.hvH != null) {
                if (configuration.orientation == 1) {
                    bNo().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hvR.setIsLandscape(true);
                    this.hvR.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hvR.setIsLandscape(false);
                    if (this.hyq > 0) {
                        this.hvR.smoothScrollBy(this.hyq, 0);
                    }
                }
                this.hvH.onConfigurationChanged(configuration);
                this.hxp.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void nX(boolean z) {
        this.hvL = z;
    }

    public boolean bNs() {
        return this.hvH != null && this.hvH.bNs();
    }

    public void bNt() {
        if (this.hvH != null) {
            this.hvH.onPause();
        }
    }

    public void s(long j, int i) {
        if (this.hvJ != null) {
            this.hvJ.s(j, i);
        }
        if (this.hvH != null) {
            this.hvH.s(j, i);
        }
    }

    public void ns(boolean z) {
        this.hwA.ns(z);
    }

    public void bNu() {
        if (this.hxn == null) {
            LayoutInflater.from(this.hoW.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.eCv, true);
            this.hxn = (ViewGroup) this.eCv.findViewById(d.g.add_experienced_layout);
            this.hxo = (TextView) this.eCv.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.al.j(this.hxo, d.C0277d.cp_btn_a);
            String string = this.hoW.getResources().getString(d.j.experienced_add_success);
            String string2 = this.hoW.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_h)));
            this.hxo.setText(spannableString);
        }
        this.hxn.setVisibility(0);
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
                        aq.this.hxn.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hxo.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hxo.startAnimation(scaleAnimation);
    }

    public void ct(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hwZ.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hoW);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.hxS = new TextView(this.hoW);
            this.hxS.setText(d.j.connection_tips);
            this.hxS.setGravity(17);
            this.hxS.setPadding(com.baidu.adp.lib.util.l.h(this.hoW, d.e.ds24), 0, com.baidu.adp.lib.util.l.h(this.hoW, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.hoW, d.e.ds60);
            if (this.hxS.getParent() == null) {
                frameLayout.addView(this.hxS, layoutParams);
            }
            this.hxR = new PopupWindow(this.hoW);
            this.hxR.setContentView(frameLayout);
            this.hxR.setHeight(-2);
            this.hxR.setWidth(-2);
            this.hxR.setFocusable(true);
            this.hxR.setOutsideTouchable(false);
            this.hxR.setBackgroundDrawable(new ColorDrawable(this.hoW.getResources().getColor(d.C0277d.transparent)));
            this.hvR.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hxR.showAsDropDown(aq.this.hwZ, view.getLeft(), -aq.this.hwZ.getHeight());
                    } else {
                        aq.this.hxR.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bNv() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.hxT == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.hxT = new com.baidu.tbadk.core.dialog.a(this.hoW);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hoW);
            this.hxT.gF(1);
            this.hxT.az(pbLongPressTipView);
            this.hxT.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hxT.dr(false);
            this.hxT.b(this.hoW.getPageContext()).aaZ();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hxT != null && aq.this.hxT.isShowing()) {
                        aq.this.hxT.dismiss();
                    }
                }
            }, 5000L);
            if (this.hvH != null) {
                this.hvH.bPn();
            }
        }
    }

    public void nY(boolean z) {
        this.hxY = z;
    }

    public boolean bNw() {
        return this.hxY;
    }

    private void aa(boolean z, boolean z2) {
        ab(z, z2);
        ac(z, z2);
        if (this.hwA != null && this.hwA.bKA() != null) {
            this.hwA.bKA().U(z, z2);
        }
    }

    private void ab(boolean z, boolean z2) {
        if (z && z2) {
            this.hvW.setImageResource(d.f.pic_pb_stick_refined_n);
            this.hvW.setVisibility(0);
        } else if (z) {
            this.hvW.setImageResource(d.f.pic_pb_refined_n);
            this.hvW.setVisibility(0);
        } else if (z2) {
            this.hvW.setImageResource(d.f.pic_pb_stick_n);
            this.hvW.setVisibility(0);
        } else {
            this.hvW.setVisibility(8);
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.hvT != null && this.hsp != null && this.hsp.bHZ() != null && this.hsp.bHZ().Zg() == 0 && !this.hsp.bHZ().ZL()) {
            if (z && z2) {
                this.hvX.setImageResource(d.f.pic_pb_stick_refined_n);
                this.hvX.setVisibility(0);
            } else if (z) {
                this.hvX.setImageResource(d.f.pic_pb_refined_n);
                this.hvX.setVisibility(0);
            } else if (z2) {
                this.hvX.setImageResource(d.f.pic_pb_stick_n);
                this.hvX.setVisibility(0);
            } else {
                this.hvX.setVisibility(8);
            }
        }
    }
}
