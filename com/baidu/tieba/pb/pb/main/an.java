package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
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
import android.widget.ListAdapter;
import android.widget.RadioButton;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.d;
import com.baidu.tieba.pb.pb.main.emotion.view.c;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class an {
    private static final int eRb = UtilHelper.getLightStatusBarHeight();
    public static int eRh = 2;
    public static int eRi = 3;
    public static int eRj = 0;
    public static int eRk = 3;
    public static int eRl = 4;
    public static int eRm = 5;
    public static int eRn = 6;
    private com.baidu.tbadk.editortools.i Jp;
    private View aIu;
    private com.baidu.tieba.pb.a.c aRw;
    private k.b anf;
    private TextView axP;
    private TextView bIg;
    private NoNetworkView bJn;
    private View bRj;
    private RelativeLayout ccS;
    private View ceZ;
    private View.OnClickListener cry;
    private PbListView cuy;
    private View.OnClickListener eGI;
    private PbActivity eHK;
    PbActivity.c eJq;
    private PbFakeFloorModel eLN;
    private UserIconBox eLp;
    private UserIconBox eLq;
    private com.baidu.tieba.pb.data.f eMm;
    private View ePA;
    private TextView ePB;
    private ImageView ePC;
    private HeadPendantView ePD;
    private FrameLayout ePE;
    private HeadImageView ePF;
    private View ePG;
    private FloatingLayout ePH;
    private PbFirstFloorUserLikeButton ePM;
    private al ePN;
    private TextView ePO;
    private TextView ePP;
    private View ePQ;
    private LinearLayout ePR;
    private TextView ePS;
    private TextView ePT;
    private View ePU;
    private View ePV;
    private ObservedChangeLinearLayout ePX;
    private g ePY;
    public int ePd;
    private com.baidu.tieba.pb.video.i ePf;
    private com.baidu.tieba.pb.video.h ePg;
    private com.baidu.tieba.d.a ePh;
    public final com.baidu.tieba.pb.pb.main.view.c ePk;
    public com.baidu.tieba.pb.pb.main.view.b ePl;
    private ViewStub ePm;
    private ViewStub ePn;
    private PbLandscapeListView ePo;
    private List<com.baidu.tieba.pb.pb.main.view.a> ePp;
    private View ePq;
    private LinearLayout ePu;
    private e ePv;
    private ColumnLayout ePw;
    private ThreadSkinView ePx;
    private TextView ePy;
    private TextView ePz;
    private View eQE;
    private TextView eQF;
    private ImageView eQG;
    private ImageView eQH;
    private TextView eQJ;
    private boolean eQL;
    private int eQM;
    private int eQN;
    private int eQO;
    private PostData eQP;
    private View eQR;
    private TextView eQS;
    private ViewStub eQT;
    private PbInterviewStatusView eQU;
    private ViewGroup eQV;
    private TextView eQW;
    private FrameLayout eQX;
    private View eQY;
    private View eQZ;
    private View eQe;
    private View eRD;
    private TextView eRE;
    private LinearLayout eRF;
    private boolean eRG;
    private d eRH;
    private com.baidu.tbadk.core.view.userLike.c eRI;
    private com.baidu.tbadk.core.view.userLike.c eRJ;
    private Runnable eRM;
    private PbActivity.a eRO;
    private boolean eRQ;
    private boolean eRR;
    private int eRV;
    private ah eRa;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eRf;
    private int eRo;
    private Runnable eRp;
    private Runnable eRq;
    private q eRr;
    private com.baidu.tieba.d.a eRs;
    private boolean isLandscape;
    private int mType;
    private int ePe = 1;
    private boolean ePi = false;
    private int ePj = 0;
    private final Handler mHandler = new Handler();
    private View ePr = null;
    private LinearLayout ePs = null;
    private TextView ePt = null;
    private TextView ePI = null;
    private TextView ePJ = null;
    public FrsPraiseView ePK = null;
    private ClickableHeaderImageView ePL = null;
    private View ePW = null;
    private com.baidu.tbadk.core.dialog.a ePZ = null;
    private com.baidu.tbadk.core.dialog.b crx = null;
    private View eQa = null;
    private EditText eQb = null;
    private com.baidu.tieba.pb.view.i eQc = null;
    private com.baidu.tieba.pb.view.b eQd = null;
    private b.InterfaceC0046b dBs = null;
    private TbRichTextView.e aRv = null;
    private NoNetworkView.a bJq = null;
    private Dialog eQf = null;
    private View eQg = null;
    private com.baidu.tbadk.core.dialog.a eQh = null;
    private Dialog eQi = null;
    private View eQj = null;
    private int eQk = 0;
    private RadioGroup buq = null;
    private RadioButton eQl = null;
    private RadioButton eQm = null;
    private RadioButton eQn = null;
    private Button eQo = null;
    private Button eQp = null;
    private TextView eQq = null;
    private Dialog eQr = null;
    private View eQs = null;
    private LinearLayout eQt = null;
    private CompoundButton.OnCheckedChangeListener eQu = null;
    private TextView eQv = null;
    private TextView eQw = null;
    private String eQx = null;
    private com.baidu.tbadk.core.dialog.b eQy = null;
    private com.baidu.tbadk.core.dialog.b eQz = null;
    private boolean eQA = false;
    private boolean eQB = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eQC = null;
    private boolean dSZ = false;
    private Button eQD = null;
    public ImageView eQI = null;
    private boolean eQK = true;
    private com.baidu.tbadk.core.view.a bpr = null;
    private boolean eGE = false;
    private int mSkinType = 3;
    private boolean eQQ = false;
    private boolean mIsFromCDN = true;
    private int eRc = 0;
    private boolean eRd = true;
    private a eRe = new a();
    private int eRg = 0;
    private boolean eRt = false;
    private int eRu = 0;
    private boolean eRv = false;
    private boolean eRw = false;
    private a.InterfaceC0121a eRx = new a.InterfaceC0121a() { // from class: com.baidu.tieba.pb.pb.main.an.9
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0121a
        public void la() {
        }
    };
    private boolean ctQ = false;
    private boolean eRy = false;
    private LinearLayout eRz = null;
    private TextView eRA = null;
    private int eRB = 0;
    private boolean eRC = false;
    private boolean eRK = false;
    private int rank = 0;
    private CustomMessageListener dNI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.ePY != null) {
                an.this.ePY.notifyDataSetChanged();
            }
        }
    };
    private Handler eRL = new Handler();
    private CustomMessageListener eRN = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.eQK = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eRP = true;
    private boolean eRS = false;
    private boolean Zq = false;
    String userId = null;
    private final List<TbImageView> eRT = new ArrayList();
    private ViewTreeObserver.OnGlobalLayoutListener eRU = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.pb.main.an.22
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            an.this.aSU();
        }
    };
    private boolean eRW = false;

    public void jE(boolean z) {
        this.eRt = z;
        if (this.ePo != null) {
            this.eRu = this.ePo.getHeaderViewsCount();
        }
    }

    public void aSK() {
        if (this.ePo != null) {
            int headerViewsCount = this.ePo.getHeaderViewsCount() - this.eRu;
            final int firstVisiblePosition = (this.ePo.getFirstVisiblePosition() == 0 || this.ePo.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.ePo.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.ePo.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.eRe.eSj = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eRe));
            final ah ahVar = this.eRe.eSj;
            final int d = d(ahVar);
            final int y = ((int) this.ePX.getY()) + this.ePX.getMeasuredHeight();
            final boolean z = this.eQY.getVisibility() == 0;
            boolean z2 = this.ePX.getY() < 0.0f;
            if ((z && ahVar != null) || firstVisiblePosition >= this.ePY.aRn() + this.ePo.getHeaderViewsCount()) {
                int measuredHeight = ahVar != null ? ahVar.eOK.getMeasuredHeight() : 0;
                if (z2) {
                    this.ePo.setSelectionFromTop(this.ePY.aRn() + this.ePo.getHeaderViewsCount(), eRb - measuredHeight);
                } else {
                    this.ePo.setSelectionFromTop(this.ePY.aRn() + this.ePo.getHeaderViewsCount(), this.ePk.aUC().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.ePo.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.eRv) {
                this.ePo.setSelectionFromTop(this.ePY.aRn() + this.ePo.getHeaderViewsCount(), this.ePf.aWf().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.ePo.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aRz() {
                        if (d >= 0 && d <= an.this.ccS.getMeasuredHeight()) {
                            int d2 = an.this.d(ahVar);
                            int i = d2 - d;
                            if (z && i != 0 && d <= y) {
                                i = d2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = an.this.bRj.getLayoutParams();
                            if (i == 0 || i > an.this.ccS.getMeasuredHeight() || d2 >= an.this.ccS.getMeasuredHeight()) {
                                layoutParams.height = an.this.eRo;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.ccS.getMeasuredHeight()) {
                                layoutParams.height = an.this.eRo;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                an.this.ePo.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            an.this.bRj.setLayoutParams(layoutParams);
                        }
                        an.this.ePo.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(ah ahVar) {
        if (ahVar == null || ahVar.getView() == null) {
            return 0;
        }
        if (ahVar.getView().getTop() != 0 || ahVar.getView().isShown()) {
            return ahVar.getView().getBottom();
        }
        return 0;
    }

    public d aSL() {
        return this.eRH;
    }

    public NoNetworkView aSM() {
        return this.bJn;
    }

    public void aSN() {
        if (this.Jp != null) {
            this.Jp.hide();
        }
    }

    public PbFakeFloorModel aSO() {
        return this.eLN;
    }

    public q aSP() {
        return this.eRr;
    }

    public void aSQ() {
        reset();
        aSN();
        this.eRr.aRt();
        hu(false);
    }

    private void reset() {
        if (this.eHK != null && this.eHK.aQi() != null && this.Jp != null) {
            com.baidu.tbadk.editortools.pb.a.Dr().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aQi = this.eHK.aQi();
            aQi.DL();
            if (aQi.getWriteImagesInfo() != null) {
                aQi.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aQi.eN(10);
            aQi.eL(SendView.ALL);
            aQi.eM(SendView.ALL);
            com.baidu.tbadk.editortools.l eC = this.Jp.eC(23);
            com.baidu.tbadk.editortools.l eC2 = this.Jp.eC(2);
            com.baidu.tbadk.editortools.l eC3 = this.Jp.eC(5);
            if (eC2 != null) {
                eC2.lK();
            }
            if (eC3 != null) {
                eC3.lK();
            }
            if (eC != null) {
                eC.hide();
            }
            this.Jp.invalidate();
        }
    }

    public boolean aSR() {
        return this.eQK;
    }

    public void hv(boolean z) {
        if (this.eQE != null && this.eQF != null) {
            this.eQF.setText(d.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eQE.startAnimation(alphaAnimation);
            }
            this.eQE.setVisibility(0);
            this.eQK = true;
            if (this.eRf != null) {
                this.eRf.setVisibility(0);
                jI(true);
            }
        }
    }

    public void hw(boolean z) {
        if (this.eQE != null && this.eQF != null) {
            this.eQF.setText(d.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eQE.startAnimation(alphaAnimation);
            }
            this.eQE.setVisibility(0);
            this.eQK = true;
            if (this.eRf != null) {
                this.eRf.setVisibility(0);
                jI(true);
            }
        }
    }

    public PostData aSS() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.ePo == null) {
            return null;
        }
        int firstVisiblePosition = this.ePo.getFirstVisiblePosition();
        int lastVisiblePosition = this.ePo.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.ePo.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.ePo.getChildAt(i4 - firstVisiblePosition)) != null) {
                    childAt.getGlobalVisibleRect(rect);
                    iArr[i4 - firstVisiblePosition] = rect.height();
                }
                i3 += iArr[i4 - firstVisiblePosition];
            }
            int i5 = i3 / 2;
            int i6 = 0;
            for (int i7 = 0; i7 < iArr.length; i7++) {
                i6 += iArr[i7];
                if (i6 > i5) {
                    i = i7 + firstVisiblePosition;
                    break;
                }
            }
        }
        i = firstVisiblePosition;
        int headerViewsCount = i - this.ePo.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.ePY.pn(headerViewsCount) != null && this.ePY.pn(headerViewsCount) != PostData.gjc) {
            i2 = headerViewsCount + 1;
        }
        return this.ePY.getItem(i2) instanceof PostData ? (PostData) this.ePY.getItem(i2) : null;
    }

    public an(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.eHK = null;
        this.ccS = null;
        this.ceZ = null;
        this.ePo = null;
        this.ePq = null;
        this.ePu = null;
        this.ePw = null;
        this.ePy = null;
        this.ePA = null;
        this.ePB = null;
        this.ePE = null;
        this.ePF = null;
        this.ePG = null;
        this.ePM = null;
        this.ePO = null;
        this.ePP = null;
        this.bIg = null;
        this.ePQ = null;
        this.ePU = null;
        this.ePV = null;
        this.ePY = null;
        this.cuy = null;
        this.aIu = null;
        this.cry = null;
        this.eGI = null;
        this.eQE = null;
        this.eQF = null;
        this.eQG = null;
        this.eQH = null;
        this.eQJ = null;
        this.eQR = null;
        this.eQS = null;
        this.eQT = null;
        this.eHK = pbActivity;
        this.cry = onClickListener;
        this.aRw = cVar;
        this.ccS = (RelativeLayout) LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(d.j.new_pb_activity, (ViewGroup) null);
        this.ccS.getViewTreeObserver().addOnGlobalLayoutListener(this.eRU);
        this.eHK.addContentView(this.ccS, new FrameLayout.LayoutParams(-1, -1));
        this.ceZ = this.eHK.findViewById(d.h.statebar_view);
        this.ePX = (ObservedChangeLinearLayout) this.eHK.findViewById(d.h.title_wrapper);
        this.bJn = (NoNetworkView) this.eHK.findViewById(d.h.view_no_network);
        this.ePo = (PbLandscapeListView) this.eHK.findViewById(d.h.new_pb_list);
        this.eQX = (FrameLayout) this.eHK.findViewById(d.h.root_float_header);
        this.axP = new TextView(this.eHK.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds98));
        this.ePo.addHeaderView(this.axP, 0);
        this.eRo = this.eHK.getResources().getDimensionPixelSize(d.f.ds100);
        this.bRj = new View(this.eHK.getPageContext().getPageActivity());
        this.bRj.setLayoutParams(new AbsListView.LayoutParams(-1, this.eRo));
        this.bRj.setVisibility(4);
        this.ePo.addFooterView(this.bRj);
        this.ePo.setOnTouchListener(this.eHK.aMx);
        this.ePk = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        this.eRs = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.ePk.eVJ);
        this.eRs.hY(1);
        if (this.eHK.aQK()) {
            this.ePm = (ViewStub) this.eHK.findViewById(d.h.manga_view_stub);
            this.ePm.setVisibility(0);
            this.ePl = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.ePl.show();
            this.ePk.mNavigationBar.setVisibility(8);
            layoutParams.height -= eRb;
        }
        this.axP.setLayoutParams(layoutParams);
        this.ePk.aUC().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.main.an.15
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0109a
            public void ahY() {
                if (an.this.ePo != null) {
                    if (an.this.ePf != null) {
                        an.this.ePf.aWg();
                    }
                    an.this.ePo.smoothScrollToPosition(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0109a
            public void ahX() {
                an.this.eHK.aho();
            }
        }));
        this.eQE = this.eHK.findViewById(d.h.pb_editor_tool_comment);
        this.eQM = com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds90);
        this.eQN = com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds156);
        this.eQO = this.eQM;
        this.eQF = (TextView) this.eHK.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_text);
        this.eQH = (ImageView) this.eHK.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_more_img);
        this.eQG = (ImageView) this.eHK.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_emotion_img);
        this.eQJ = (TextView) this.eHK.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_praise_icon);
        this.eQJ.setVisibility(8);
        this.eQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!an.this.eHK.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ad("fid", an.this.mForumId));
                } else if (an.this.eMm == null || !com.baidu.tieba.pb.f.Y(an.this.eMm.aPi())) {
                    if (an.this.Jp != null) {
                        an.this.aTb();
                    }
                    if (an.this.Jp != null) {
                        an.this.eQK = false;
                        com.baidu.tieba.tbadkCore.b.a.a(an.this.eHK, (View) an.this.Jp.eE(2).aBn, false, an.this.eRx);
                    }
                    an.this.aTA();
                }
            }
        });
        this.eQG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (an.this.eHK.checkUpIsLogin()) {
                    if (an.this.eMm == null || !com.baidu.tieba.pb.f.Y(an.this.eMm.aPi())) {
                        if (an.this.Jp != null) {
                            an.this.aTb();
                            an.this.Jp.K((View) an.this.Jp.eC(5));
                        }
                        if (an.this.Jp != null) {
                            an.this.eQK = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eHK, (View) an.this.Jp.eE(2).aBn, false, an.this.eRx);
                        }
                        an.this.aTA();
                    }
                }
            }
        });
        this.eQH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (an.this.eHK.checkUpIsLogin()) {
                    if (an.this.eMm == null || !com.baidu.tieba.pb.f.Y(an.this.eMm.aPi())) {
                        if (an.this.Jp != null) {
                            an.this.aTb();
                            an.this.Jp.K((View) an.this.Jp.eC(2));
                        }
                        if (an.this.Jp != null) {
                            an.this.eQK = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eHK, (View) an.this.Jp.eE(2).aBn, false, an.this.eRx);
                        }
                        an.this.aTA();
                    }
                }
            }
        });
        this.eQJ.setOnClickListener(this.cry);
        this.eQJ.setOnTouchListener(this.eHK);
        this.ePq = LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_item, (ViewGroup) null);
        this.ePu = (LinearLayout) LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_user_item, (ViewGroup) null);
        this.ePv = new e(this.eHK, this.ePu);
        this.ePv.init();
        this.ePv.a(this.ePv.aQh(), this.cry);
        this.ePw = (ColumnLayout) this.ePu.findViewById(d.h.pb_head_owner_root);
        this.ePx = (ThreadSkinView) this.ePu.findViewById(d.h.pb_thread_skin);
        this.ePw.setOnLongClickListener(this.onLongClickListener);
        this.ePw.setOnTouchListener(this.aRw);
        this.ePw.setVisibility(8);
        this.ePq.setOnTouchListener(this.aRw);
        this.eQR = this.ePq.findViewById(d.h.pb_head_activity_join_number_container);
        this.eQR.setVisibility(8);
        this.eQS = (TextView) this.ePq.findViewById(d.h.pb_head_activity_join_number);
        this.ePy = (TextView) this.ePw.findViewById(d.h.pb_head_owner_info_user_name);
        this.ePz = (TextView) this.ePu.findViewById(d.h.pb_head_owner_info_user_intro);
        this.ePA = this.ePu.findViewById(d.h.line_right_user_intro);
        this.ePB = (TextView) this.ePw.findViewById(d.h.floor_owner);
        this.ePC = (ImageView) this.ePw.findViewById(d.h.icon_forum_level);
        this.ePE = (FrameLayout) this.ePw.findViewById(d.h.pb_head_headImage_container);
        this.ePF = (HeadImageView) this.ePw.findViewById(d.h.pb_head_owner_photo);
        this.ePD = (HeadPendantView) this.ePw.findViewById(d.h.pb_pendant_head_owner_photo);
        this.ePD.wB();
        if (this.ePD.getHeadView() != null) {
            this.ePD.getHeadView().setIsRound(true);
            this.ePD.getHeadView().setDrawBorder(false);
        }
        if (this.ePD.getPendantView() != null) {
            this.ePD.getPendantView().setIsRound(true);
            this.ePD.getPendantView().setDrawBorder(false);
        }
        this.eLp = (UserIconBox) this.ePw.findViewById(d.h.show_icon_vip);
        this.eLq = (UserIconBox) this.ePw.findViewById(d.h.show_icon_yinji);
        this.ePH = (FloatingLayout) this.ePu.findViewById(d.h.pb_head_owner_info_root);
        this.ePM = (PbFirstFloorUserLikeButton) this.ePw.findViewById(d.h.pb_like_button);
        this.ePN = new al(pbActivity.getPageContext(), this.ePM, 1);
        this.ePN.i(this.eHK.getUniqueId());
        this.ePN.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.29
            @Override // com.baidu.tbadk.core.view.userLike.c.a
            public void aR(boolean z) {
                int i;
                if (an.this.eHK != null && z && (i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0)) < 2) {
                    am.z(an.this.eHK.getPageContext());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                }
            }
        });
        this.ePO = (TextView) this.ePw.findViewById(d.h.pb_views);
        this.ePP = (TextView) this.ePw.findViewById(d.h.pb_item_first_floor_reply_time);
        this.bIg = (TextView) this.ePw.findViewById(d.h.pb_item_first_floor_location_address);
        this.ePQ = this.ePw.findViewById(d.h.line_between_time_and_locate);
        this.eRI = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eRJ = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.ePU = this.ePq.findViewById(d.h.new_pb_header_item_line_above_livepost);
        this.ePV = this.ePq.findViewById(d.h.new_pb_header_item_line_below_livepost);
        this.ePq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.30
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.eQT = (ViewStub) this.ccS.findViewById(d.h.interview_status_stub);
        this.ePY = new g(this.eHK, this.ePo);
        this.ePY.p(this.cry);
        this.ePY.setTbGestureDetector(this.aRw);
        this.ePY.setOnImageClickListener(this.aRv);
        this.eGI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.WT() || !com.baidu.tieba.c.a.a(an.this.eHK.getBaseContext(), an.this.eHK.aQn().getThreadID(), (String) sparseArray.get(d.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.h.tag_from, 1);
                                an.this.eHK.c(sparseArray);
                                return;
                            }
                            an.this.bn(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.h.tag_from, 0);
                        sparseArray.put(d.h.tag_check_mute_from, 1);
                        an.this.eHK.c(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.ePY.A(this.eGI);
        aSW();
        this.ePo.addHeaderView(this.ePs);
        this.ePo.addHeaderView(this.ePu);
        this.ePo.addHeaderView(this.ePq);
        this.cuy = new PbListView(this.eHK.getPageContext().getPageActivity());
        this.aIu = this.cuy.getView().findViewById(d.h.pb_more_view);
        if (this.aIu != null) {
            this.aIu.setOnClickListener(this.cry);
            com.baidu.tbadk.core.util.aj.j(this.aIu, d.g.pb_foot_more_trans_selector);
        }
        this.cuy.wR();
        this.cuy.m10do(d.g.pb_foot_more_trans_selector);
        this.cuy.dp(d.g.pb_foot_more_trans_selector);
        this.eQe = this.eHK.findViewById(d.h.viewstub_progress);
        this.eHK.registerListener(this.eRN);
        this.ePG = com.baidu.tbadk.ala.b.nw().h(this.eHK.getActivity(), 2);
        if (this.ePG != null) {
            this.ePG.setVisibility(8);
            this.ePH.addView(this.ePG);
        }
        this.eLN = new PbFakeFloorModel(this.eHK.getPageContext());
        this.eRr = new q(this.eHK.getPageContext(), this.eLN, this.ccS);
        this.eLN.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                an.this.eLN.m(postData);
                an.this.ePY.notifyDataSetChanged();
                an.this.eRr.aRt();
            }
        });
        if (this.eHK.aQn() != null && !StringUtils.isNull(this.eHK.aQn().aSi())) {
            this.eHK.showToast(this.eHK.aQn().aSi());
        }
        this.eQY = this.eHK.findViewById(d.h.pb_expand_blank_view);
        this.eQZ = this.eHK.findViewById(d.h.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eQZ.getLayoutParams();
        if (this.eHK.aQn() != null && this.eHK.aQn().aRF()) {
            this.eQY.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.eQZ.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = eRb;
            this.eQZ.setLayoutParams(layoutParams2);
        }
        this.eRa = new ah(this.eHK.getPageContext(), this.eHK.findViewById(d.h.pb_reply_expand_view));
        this.eRa.eOK.setVisibility(8);
        this.eRa.B(this.cry);
        this.eHK.registerListener(this.dNI);
        jI(false);
    }

    public View aST() {
        return this.eQY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSU() {
        if (this.eRf != null) {
            int[] iArr = new int[2];
            this.eQE.getLocationOnScreen(iArr);
            this.eRf.setBottomMargin((((ViewGroup) this.eHK.getPageContext().getPageActivity().getWindow().getDecorView()).getHeight() - this.eQO) - iArr[1]);
        }
    }

    public void aSV() {
        if (this.ePo != null) {
            this.ePo.removeHeaderView(this.ePs);
            this.ePo.removeHeaderView(this.ePu);
            this.ePo.removeHeaderView(this.ePq);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eRf == null) {
            this.eRf = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eHK.getPageContext().getPageActivity());
            jI(true);
            ViewGroup viewGroup = (ViewGroup) this.eHK.getPageContext().getPageActivity().getWindow().getDecorView();
            int[] iArr = new int[2];
            this.eQE.getLocationOnScreen(iArr);
            this.eRf.a(viewGroup, (viewGroup.getHeight() - this.eQM) - iArr[1], aVar, this.eQE.getVisibility() == 0);
            this.eRf.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void cE(List<String> list) {
                    an.this.eHK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(an.this.eHK.getPageContext().getPageActivity(), 25016, (ArrayList) list)));
                }
            });
            this.eRf.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.an.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void V(float f) {
                    if (an.this.eQE != null) {
                        ViewGroup.LayoutParams layoutParams = an.this.eQE.getLayoutParams();
                        layoutParams.height = (int) (((an.this.eQN - an.this.eQM) * f) + an.this.eQM);
                        an.this.eQF.setAlpha(1.0f - f);
                        an.this.eQH.setAlpha(1.0f - f);
                        an.this.eQG.setAlpha(1.0f - f);
                        an.this.eQE.setLayoutParams(layoutParams);
                        an.this.eQO = layoutParams.height;
                    }
                }
            });
        }
    }

    private void aSW() {
        if (this.ePs == null) {
            int f = com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds34);
            this.ePs = new LinearLayout(this.eHK.getPageContext().getPageActivity());
            this.ePs.setOrientation(1);
            this.ePs.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.ePs.setPadding(f, com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds40), f, com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds46));
            this.ePs.setGravity(17);
            this.ePt = new TextView(this.eHK.getPageContext().getPageActivity());
            this.ePt.setGravity(3);
            this.ePt.setMaxLines(2);
            this.ePt.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            this.ePt.setPadding(0, 0, 0, 0);
            this.ePt.setLineSpacing(com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.aj.i(this.ePt, d.e.cp_cont_b);
            this.ePt.setTextSize(0, com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds48));
            this.ePt.setVisibility(8);
            this.ePs.addView(this.ePt);
            this.ePs.setOnTouchListener(this.aRw);
            this.ePs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.6
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSX() {
        if (this.eHK.aQK()) {
            this.ePn = (ViewStub) this.eHK.findViewById(d.h.manga_mention_controller_view_stub);
            this.ePn.setVisibility(0);
            if (this.ePR == null) {
                this.ePR = (LinearLayout) this.eHK.findViewById(d.h.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.eHK.getPageContext(), this.ePR);
            }
            if (this.ePS == null) {
                this.ePS = (TextView) this.ePR.findViewById(d.h.manga_prev_btn);
            }
            if (this.ePT == null) {
                this.ePT = (TextView) this.ePR.findViewById(d.h.manga_next_btn);
            }
            this.ePS.setOnClickListener(this.cry);
            this.ePT.setOnClickListener(this.cry);
        }
    }

    private void aSY() {
        if (this.eHK.aQK()) {
            if (this.eHK.aQN() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.ePS, d.e.cp_cont_e, 1);
            }
            if (this.eHK.aQO() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.ePT, d.e.cp_cont_e, 1);
            }
        }
    }

    public void aSZ() {
        if (this.ePR == null) {
            aSX();
        }
        this.ePn.setVisibility(8);
        if (this.eRL != null && this.eRM != null) {
            this.eRL.removeCallbacks(this.eRM);
        }
    }

    public void aTa() {
        if (this.eRL != null) {
            if (this.eRM != null) {
                this.eRL.removeCallbacks(this.eRM);
            }
            this.eRM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.7
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.ePR == null) {
                        an.this.aSX();
                    }
                    an.this.ePn.setVisibility(0);
                }
            };
            this.eRL.postDelayed(this.eRM, 2000L);
        }
    }

    public void jF(boolean z) {
        this.ePk.jF(z);
        if (z && this.eQQ) {
            this.cuy.setText(this.eHK.getResources().getString(d.l.click_load_more));
            this.ePo.setNextPage(this.cuy);
            this.ePj = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.Jp = iVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ccS.addView(this.Jp, layoutParams);
        this.Jp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aSN();
    }

    public void aTb() {
        if (this.eHK != null && this.Jp != null) {
            this.Jp.lK();
            aTA();
        }
    }

    public void U(String str, boolean z) {
        this.eQL = z;
        aO(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void aO(boolean z) {
        if (this.eQJ != null) {
            if (this.eQL) {
                com.baidu.tbadk.core.util.aj.j(this.eQJ, d.g.pb_praise_already_click_selector);
                this.eQJ.setContentDescription(this.eHK.getResources().getString(d.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.j(this.eQJ, d.g.pb_praise_normal_click_selector);
            this.eQJ.setContentDescription(this.eHK.getResources().getString(d.l.frs_item_praise_text));
        }
    }

    public TextView aTc() {
        return this.eQJ;
    }

    public void jG(boolean z) {
        if (this.ePo != null && this.axP != null && this.ceZ != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.ceZ.setVisibility(0);
                } else {
                    this.ceZ.setVisibility(8);
                    this.ePo.removeHeaderView(this.axP);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.axP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = eRb;
                    this.axP.setLayoutParams(layoutParams);
                }
                aTs();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.axP.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jO(true);
                this.axP.setLayoutParams(layoutParams2);
            }
            aTs();
            aTI();
        }
    }

    public g aTd() {
        return this.ePY;
    }

    public void aTe() {
        if (this.ePY != null) {
            this.ePY.aRi();
        }
    }

    public void a(PbActivity.c cVar) {
        this.eJq = cVar;
    }

    private void a(bm bmVar) {
        if (bmVar == null || bmVar.tb() == 0) {
            if (this.eQD != null) {
                this.eQD.setVisibility(8);
            }
            if (this.ePU != null) {
                this.ePU.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eQD == null) {
            this.eHK.getLayoutMode().t(((ViewStub) this.ePq.findViewById(d.h.live_talk_layout)).inflate());
            this.eQD = (Button) this.ePq.findViewById(d.h.pb_head_function_manage_go_to_live_post);
            this.ePU = this.ePq.findViewById(d.h.new_pb_header_item_line_above_livepost);
        }
        int tc = bmVar.tc();
        String string = this.eHK.getPageContext().getString(d.l.go_to_live_post_prefix);
        if (tc == 0) {
            string = string + this.eHK.getPageContext().getString(d.l.go_to_interview_post);
        } else if (tc == 1) {
            string = string + this.eHK.getPageContext().getString(d.l.go_to_discuss_post);
        }
        this.eQD.setText(string);
        this.eQD.setVisibility(0);
        this.eQD.setOnClickListener(this.cry);
        this.eRR = true;
        aTt();
    }

    public void bn(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.eQg == null) {
            this.eQg = LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eHK.getLayoutMode().t(this.eQg);
        if (this.eQf == null) {
            this.eQf = new Dialog(this.eHK.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eQf.setCanceledOnTouchOutside(true);
            this.eQf.setCancelable(true);
            this.eQf.setContentView(this.eQg);
            WindowManager.LayoutParams attributes = this.eQf.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.ae(this.eHK.getPageContext().getPageActivity()) * 0.9d);
            this.eQf.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eQf.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eQf.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eQf.findViewById(d.h.disable_reply_btn);
        int intValue = sparseArray.get(d.h.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(d.h.tag_del_post_id)) || intValue == 2) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                textView.setTag(sparseArray4);
                sparseArray2 = sparseArray4;
            } else {
                sparseArray2 = sparseArray3;
            }
            textView.setVisibility(0);
            if ((sparseArray.get(d.h.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(d.l.delete);
            } else {
                textView.setText(d.l.delete_post);
            }
            sparseArray2.put(d.h.tag_del_post_id, sparseArray.get(d.h.tag_del_post_id));
            sparseArray2.put(d.h.tag_del_post_type, sparseArray.get(d.h.tag_del_post_type));
            sparseArray2.put(d.h.tag_del_post_is_self, sparseArray.get(d.h.tag_del_post_is_self));
            sparseArray2.put(d.h.tag_manage_user_identity, sparseArray.get(d.h.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eQf != null && (an.this.eQf instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.eQf, an.this.eHK.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        an.this.a(((Integer) sparseArray5.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.h.tag_del_post_id), ((Integer) sparseArray5.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.h.tag_forbid_user_name)) || aTF()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(d.h.tag_forbid_user_name, sparseArray.get(d.h.tag_forbid_user_name));
            sparseArray5.put(d.h.tag_manage_user_identity, sparseArray.get(d.h.tag_manage_user_identity));
            sparseArray5.put(d.h.tag_forbid_user_post_id, sparseArray.get(d.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eQf != null && (an.this.eQf instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.eQf, an.this.eHK.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && an.this.eRO != null) {
                        an.this.eRO.f(new Object[]{sparseArray6.get(d.h.tag_manage_user_identity), sparseArray6.get(d.h.tag_forbid_user_name), sparseArray6.get(d.h.tag_forbid_user_post_id)});
                    }
                }
            });
        }
        if (!((sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(d.l.un_mute);
            } else {
                textView3.setText(d.l.mute);
            }
            sparseArray6.put(d.h.tag_is_mem, sparseArray.get(d.h.tag_is_mem));
            sparseArray6.put(d.h.tag_user_mute_mute_userid, sparseArray.get(d.h.tag_user_mute_mute_userid));
            sparseArray6.put(d.h.tag_user_mute_mute_username, sparseArray.get(d.h.tag_user_mute_mute_username));
            sparseArray6.put(d.h.tag_user_mute_post_id, sparseArray.get(d.h.tag_user_mute_post_id));
            sparseArray6.put(d.h.tag_user_mute_thread_id, sparseArray.get(d.h.tag_user_mute_thread_id));
            sparseArray6.put(d.h.tag_user_mute_msg, sparseArray.get(d.h.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eQf != null && (an.this.eQf instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.eQf, an.this.eHK.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        an.this.eHK.a(z, (String) sparseArray7.get(d.h.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.eQf, this.eHK.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.eRO = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eRj, Integer.valueOf(eRk));
        int i3 = d.l.del_post_confirm;
        if (i == 0) {
            i3 = d.l.del_thread_confirm;
        }
        this.eQh = new com.baidu.tbadk.core.dialog.a(this.eHK.getActivity());
        this.eQh.cc(i3);
        this.eQh.z(sparseArray);
        this.eQh.a(d.l.dialog_ok, this.eHK);
        this.eQh.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eQh.ar(true);
        this.eQh.b(this.eHK.getPageContext());
        this.eQh.to();
    }

    public void al(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eQs == null) {
            this.eQs = LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(d.j.commit_good, (ViewGroup) null);
        }
        this.eHK.getLayoutMode().t(this.eQs);
        if (this.eQr == null) {
            this.eQr = new Dialog(this.eHK.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eQr.setCanceledOnTouchOutside(true);
            this.eQr.setCancelable(true);
            this.eQC = (ScrollView) this.eQs.findViewById(d.h.good_scroll);
            this.eQr.setContentView(this.eQs);
            WindowManager.LayoutParams attributes = this.eQr.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds540);
            this.eQr.getWindow().setAttributes(attributes);
            this.eQu = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.eQx = (String) compoundButton.getTag();
                        if (an.this.ePp != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : an.this.ePp) {
                                String str = (String) aVar.getTag();
                                if (str != null && an.this.eQx != null && !str.equals(an.this.eQx)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.eQt = (LinearLayout) this.eQs.findViewById(d.h.good_class_group);
            this.eQw = (TextView) this.eQs.findViewById(d.h.dialog_button_cancel);
            this.eQw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eQr instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(an.this.eQr, an.this.eHK.getPageContext());
                    }
                }
            });
            this.eQv = (TextView) this.eQs.findViewById(d.h.dialog_button_ok);
            this.eQv.setOnClickListener(this.cry);
        }
        this.eQt.removeAllViews();
        this.ePp = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bO = bO("0", this.eHK.getPageContext().getString(d.l.def_good_class));
        this.ePp.add(bO);
        bO.setChecked(true);
        this.eQt.addView(bO);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bO2 = bO(String.valueOf(arrayList.get(i2).pW()), arrayList.get(i2).pV());
                this.ePp.add(bO2);
                View view = new View(this.eHK.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds1));
                com.baidu.tbadk.core.util.aj.k(view, d.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eQt.addView(view);
                this.eQt.addView(bO2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eQC.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eHK.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eHK.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eHK.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eQC.setLayoutParams(layoutParams2);
            this.eQC.removeAllViews();
            this.eQC.addView(this.eQt);
        }
        com.baidu.adp.lib.g.g.a(this.eQr, this.eHK.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bO(String str, String str2) {
        Activity pageActivity = this.eHK.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.f(pageActivity, d.f.ds100));
        aVar.setOnCheckedChangeListener(this.eQu);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aTf() {
        this.eHK.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eHK.hideProgressBar();
        if (z && z2) {
            this.eHK.showToast(this.eHK.getPageContext().getString(d.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.l.neterror);
            }
            this.eHK.showToast(str);
        }
    }

    public void ayq() {
        this.eQe.setVisibility(0);
    }

    public void ayp() {
        this.eQe.setVisibility(8);
    }

    public View aTg() {
        if (this.eQs != null) {
            return this.eQs.findViewById(d.h.dialog_button_ok);
        }
        return null;
    }

    public String aTh() {
        return this.eQx;
    }

    public View getView() {
        return this.ccS;
    }

    public void aTi() {
        com.baidu.adp.lib.util.k.a(this.eHK.getPageContext().getPageActivity(), this.eHK.getCurrentFocus());
    }

    public void jH(boolean z) {
        this.eHK.hideProgressBar();
        aDM();
    }

    public void aTj() {
        this.cuy.wR();
        this.cuy.wV();
    }

    public void aTk() {
        this.eHK.hideProgressBar();
        wW();
        this.ePo.completePullRefreshPostDelayed(2000L);
        aTt();
    }

    public void aTl() {
        this.ePo.completePullRefreshPostDelayed(2000L);
        aTt();
    }

    private void jI(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eQF.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eHK.getResources().getDimensionPixelSize(d.f.ds130) : this.eHK.getResources().getDimensionPixelSize(d.f.ds34);
        this.eQF.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.ePY.setOnLongClickListener(onLongClickListener);
    }

    public void a(b.InterfaceC0046b interfaceC0046b, boolean z, boolean z2) {
        if (this.eQy != null) {
            this.eQy.dismiss();
            this.eQy = null;
        }
        this.eQy = new com.baidu.tbadk.core.dialog.b(this.eHK.getPageContext().getPageActivity());
        this.eQy.cf(d.l.operation);
        if (z2) {
            this.eQy.a(new String[]{this.eHK.getPageContext().getString(d.l.copy)}, interfaceC0046b);
        } else if (!z) {
            this.eQy.a(new String[]{this.eHK.getPageContext().getString(d.l.copy), this.eHK.getPageContext().getString(d.l.mark)}, interfaceC0046b);
        } else {
            this.eQy.a(new String[]{this.eHK.getPageContext().getString(d.l.copy), this.eHK.getPageContext().getString(d.l.remove_mark)}, interfaceC0046b);
        }
        this.eQy.d(this.eHK.getPageContext());
        this.eQy.tr();
    }

    public void a(b.InterfaceC0046b interfaceC0046b, boolean z) {
        if (this.eQz != null) {
            this.eQz.dismiss();
            this.eQz = null;
        }
        this.eQz = new com.baidu.tbadk.core.dialog.b(this.eHK.getPageContext().getPageActivity());
        this.eQz.cf(d.l.operation);
        if (z) {
            this.eQz.a(new String[]{this.eHK.getPageContext().getString(d.l.save_to_emotion)}, interfaceC0046b);
        } else {
            this.eQz.a(new String[]{this.eHK.getPageContext().getString(d.l.save_to_emotion), this.eHK.getPageContext().getString(d.l.save_to_local)}, interfaceC0046b);
        }
        this.eQz.d(this.eHK.getPageContext());
        this.eQz.tr();
    }

    public int aTm() {
        return pz(this.ePo.getFirstVisiblePosition());
    }

    private int pz(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.ePo.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.ePo.getAdapter() == null || !(this.ePo.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.ePo.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aTn() {
        int lastVisiblePosition = this.ePo.getLastVisiblePosition();
        if (this.ePf != null) {
            if (lastVisiblePosition == this.ePo.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.ePY.aRj();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pz(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.ePo.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eQb.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.f fVar) {
        this.ePY.a(fVar, false);
        this.ePY.notifyDataSetChanged();
        aTt();
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        if (this.ePK == null) {
            this.eHK.getLayoutMode().t(((ViewStub) this.ePq.findViewById(d.h.praise_layout)).inflate());
            this.ePK = (FrsPraiseView) this.ePq.findViewById(d.h.pb_head_praise_view);
            this.ePK.setIsFromPb(true);
            this.ePW = this.ePq.findViewById(d.h.new_pb_header_item_line_above_praise);
            this.ePK.du(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.ePK != null) {
            boolean aTt = aTt();
            this.ePK.setVisibility(8);
            if (fVar != null && fVar.qD() != null && fVar.qD().qA() == 0 && this.eGE) {
                if (aTt) {
                    this.ePV.setVisibility(0);
                } else {
                    this.ePV.setVisibility(8);
                }
            } else {
                this.ePV.setVisibility(8);
            }
            com.baidu.tieba.graffiti.b.az(this.ePV);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPr() != null) {
            return fVar.aPr();
        }
        if (!com.baidu.tbadk.core.util.v.v(fVar.aPk())) {
            Iterator<PostData> it = fVar.aPk().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bsz() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aPp();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
            postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPi() == null || fVar.aPi().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aPi().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPi().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.tw(1);
        postData.setId(fVar.aPi().rR());
        postData.setTitle(fVar.aPi().getTitle());
        postData.setTime(fVar.aPi().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0784  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0317  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        int i2;
        String e;
        ArrayList<IconData> tShowInfoNew;
        int f;
        com.baidu.tbadk.data.h bsC;
        String portrait;
        if (fVar != null && fVar.aPi() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            aTG();
            this.ePw.setVisibility(8);
            if (fVar.aPi() != null && fVar.aPi().so() && fVar.aPi().rS() != null) {
                this.eRv = true;
                this.ePk.jX(this.eRv);
                if (this.ePf == null) {
                    this.ePf = new com.baidu.tieba.pb.video.i(this.eHK, this.ePk, fVar.aPi().rS());
                    this.ePf.a(fVar.aPi().rS(), fVar.aPi(), fVar.getForumId());
                    this.ePf.startPlay();
                } else if (this.ePi) {
                    this.ePf.a(fVar.aPi().rS(), fVar.aPi(), fVar.getForumId());
                    this.ePf.startPlay();
                } else {
                    this.ePf.pI(fVar.getForumId());
                }
                if (fVar.aPj() != null && fVar.aPj().size() >= 1) {
                    bj bjVar = fVar.aPj().get(0);
                    this.ePf.ah(bjVar);
                    this.ePf.pJ(bjVar.getTitle());
                }
                this.ePf.b(b, fVar.aPi(), fVar.aPE());
                this.ePi = false;
                this.ePo.removeHeaderView(this.ePf.aWh());
                this.ePo.addHeaderView(this.ePf.aWh(), 0);
                if (this.ePf.aWf() != null && this.ePf.aWf().getParent() == null) {
                    this.eQX.addView(this.ePf.aWf());
                }
                if (this.ePg == null) {
                    this.ePg = new com.baidu.tieba.pb.video.h(this.eHK);
                }
                this.ePg.a(fVar.aPi().sF(), fVar.aPi(), fVar.aPB());
                this.ePo.removeHeaderView(this.ePg.aVW());
                this.ePo.addHeaderView(this.ePg.aVW(), 1);
                if (fVar.aPi().sF() != null) {
                    this.ePo.removeHeaderView(this.ePg.aVX());
                    this.ePo.removeHeaderView(this.ePu);
                    this.ePo.addHeaderView(this.ePg.aVX(), 2);
                } else {
                    if (this.ePg.aVX() != null) {
                        this.ePo.removeHeaderView(this.ePg.aVX());
                    }
                    this.ePo.removeHeaderView(this.ePu);
                    this.ePo.addHeaderView(this.ePu, 2);
                }
                if (this.ePf != null) {
                    this.ePf.pM(0);
                }
                aTs();
            } else {
                this.eRv = false;
                this.ePk.jX(this.eRv);
                if (this.ePf != null) {
                    this.ePo.removeHeaderView(this.ePf.aWh());
                }
                if (this.ePg != null) {
                    this.ePg.e(this.ePo);
                }
            }
            if (this.eHK.aQl() != null) {
                this.eHK.aQl().jU(this.eRv);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eRv) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").r("obj_id", 2));
                    }
                    if (an.this.eHK.eIz.eVb != null) {
                        if (!an.this.eRv && an.this.eMm != null && an.this.eMm.aPi() != null && an.this.eMm.aPi().getAuthor() != null && an.this.eMm.aPi().getAuthor().isBigV()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").r("obj_locate", 1));
                        }
                        an.this.eHK.eIz.eVb.onClick(view);
                    }
                }
            };
            if (this.ePf != null) {
                this.ePf.D(onClickListener);
            }
            if (b != null) {
                this.eQP = b;
                if (fVar != null && fVar.aPi() != null && fVar.aPi().getAuthor() != null) {
                    fVar.aPi().getAuthor().getUserId();
                    if (fVar.qD() != null) {
                        this.eRB = fVar.qD().qw();
                        if (fVar.qD().qz() == 1) {
                        }
                    }
                }
                this.ePw.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.ePw.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.ePw.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_clip_board, b);
                sparseArray.put(d.h.tag_is_subpb, false);
                if (!this.eRG) {
                    this.ePs.setVisibility(0);
                }
                if (!fVar.aPi().so() && this.ePt.getText() != null && this.ePt.getText().length() > 0) {
                    this.ePt.setVisibility(0);
                } else {
                    this.ePt.setVisibility(8);
                }
                n(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rM = fVar.aPi().rM();
                if (rM != null && rM.size() > 0 && !this.eRG) {
                    this.eQS.setText(String.valueOf(rM.get(0).pm()));
                    this.eQR.setVisibility(0);
                    this.eRQ = true;
                } else {
                    this.eQR.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.j(this.eQR, d.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.c(this.eQS, d.e.cp_link_tip_d, 1);
                if (b.getAuthor() != null) {
                    this.rank = b.getAuthor().getLevel_id();
                    String string = b.getAuthor().getName_show() == null ? StringUtils.string(b.getAuthor().getUserName()) : StringUtils.string(b.getAuthor().getName_show());
                    if (StringUtils.isNull(b.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aP(b.getAuthor().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aP(string) > 12) {
                            e = com.baidu.tbadk.core.util.am.e(string, 12, "...");
                            int i3 = 3;
                            if (!StringUtils.isNull(string)) {
                                int aP = com.baidu.adp.lib.util.j.aP(b.getAuthor().getName_show());
                                if (aP + i2 > 14) {
                                    i3 = 0;
                                } else if (aP + i2 >= 12) {
                                    i3 = 1;
                                } else if (aP + i2 >= 10) {
                                    i3 = 2;
                                }
                            }
                            ArrayList<IconData> iconInfo = b.getAuthor().getIconInfo();
                            tShowInfoNew = b.getAuthor().getTShowInfoNew();
                            if (this.eLq != null) {
                                this.eLq.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                                this.eLq.setOnClickListener(this.eHK.eIz.cAv);
                                this.eLq.a(iconInfo, i3, this.eHK.getResources().getDimensionPixelSize(d.f.ds26), this.eHK.getResources().getDimensionPixelSize(d.f.ds26), this.eHK.getResources().getDimensionPixelSize(d.f.ds8));
                            }
                            if (this.eLp != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eLp.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eLp.setOnClickListener(this.eHK.eIz.eVc);
                                this.eLp.a(tShowInfoNew, 3, this.eHK.getResources().getDimensionPixelSize(d.f.ds36), this.eHK.getResources().getDimensionPixelSize(d.f.ds36), this.eHK.getResources().getDimensionPixelSize(d.f.ds8), true);
                            }
                            this.ePy.setText(ah(b.getAuthor().getSealPrefix(), e));
                            this.ePy.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                            this.ePy.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.v.v(tShowInfoNew) || b.getAuthor().isBigV()) {
                                com.baidu.tbadk.core.util.aj.c(this.ePy, d.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.c(this.ePy, d.e.cp_cont_f, 1);
                            }
                            if (b == null && !TextUtils.isEmpty(b.getAuthor().getGodIntro())) {
                                this.ePz.setVisibility(0);
                                this.ePz.setText(am.a(b.getAuthor()));
                                this.ePA.setVisibility(0);
                            } else {
                                this.ePz.setVisibility(8);
                                this.ePA.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.aj.c(this.ePB, d.e.cp_link_tip_a, 1);
                            this.ePB.setVisibility(0);
                            if (fVar.aPi().getAuthor() != null && fVar.aPi().getAuthor().getAlaUserData() != null && this.ePG != null) {
                                if (fVar.aPi().getAuthor().getAlaUserData().anchor_live != 0) {
                                    this.ePG.setVisibility(8);
                                } else {
                                    this.ePG.setVisibility(0);
                                    if (this.ePh == null) {
                                        this.ePh = new com.baidu.tieba.d.a(this.eHK.getPageContext(), this.ePG);
                                        this.ePh.hY(1);
                                    }
                                    this.ePh.aM(this.eHK.getResources().getString(d.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Qs = fVar.aPi().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.ePG.setTag(aVar);
                                }
                            }
                            this.ePF.setUserId(b.getAuthor().getUserId());
                            this.ePF.setUserName(b.getAuthor().getUserName());
                            this.ePF.setImageDrawable(null);
                            this.ePF.setRadius(com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds40));
                            this.ePF.setTag(b.getAuthor().getUserId());
                            this.ePP.setText(b.bsB());
                            f = com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds8);
                            if (this.ePz == null && this.ePz.getVisibility() == 0) {
                                this.ePP.setPadding(f, 0, f, 0);
                            } else {
                                this.ePP.setPadding(0, 0, f, 0);
                            }
                            bsC = b.bsC();
                            if (bsC == null && !TextUtils.isEmpty(bsC.getName()) && !TextUtils.isEmpty(bsC.getName().trim())) {
                                final String name = bsC.getName();
                                final String lat = bsC.getLat();
                                final String lng = bsC.getLng();
                                this.bIg.setVisibility(0);
                                this.ePQ.setVisibility(0);
                                this.bIg.setText(bsC.getName());
                                this.bIg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.18
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.i.hi()) {
                                                an.this.eHK.showToast(d.l.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.T(an.this.eHK.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, an.this.eHK.getPageContext().getString(d.l.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.bIg.setVisibility(8);
                                this.ePQ.setVisibility(8);
                            }
                            this.ePN.a(b.getAuthor());
                            this.ePN.ePa = this.eRv;
                            if (!this.eQB) {
                                this.ePM.setVisibility(8);
                                this.ePO.setVisibility(0);
                                this.ePO.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aPD())));
                            } else if (!PbNormalLikeButtonSwitchStatic.GQ() || (b.getAuthor().hadConcerned() && b.getAuthor().getGodUserData() != null && b.getAuthor().getGodUserData().getIsFromNetWork())) {
                                this.ePM.setVisibility(8);
                                this.ePO.setVisibility(8);
                            } else {
                                this.ePM.setVisibility(0);
                                this.ePM.setTextSize(0, com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.fontsize26));
                                this.ePO.setVisibility(8);
                            }
                            portrait = b.getAuthor().getPortrait();
                            if (b.getAuthor().getPendantData() == null && !StringUtils.isNull(b.getAuthor().getPendantData().pR())) {
                                UtilHelper.showHeadImageViewBigV(this.ePD.getHeadView(), b.getAuthor());
                                this.ePF.setVisibility(8);
                                this.ePD.setVisibility(0);
                                if (this.ePL != null) {
                                    this.ePL.setVisibility(8);
                                }
                                this.ePy.setOnClickListener(onClickListener);
                                this.ePD.getHeadView().c(portrait, 28, false);
                                this.ePD.getHeadView().setUserId(b.getAuthor().getUserId());
                                this.ePD.getHeadView().setUserName(b.getAuthor().getUserName());
                                this.ePD.getHeadView().setOnClickListener(onClickListener);
                                this.ePD.eq(b.getAuthor().getPendantData().pR());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.ePF, b.getAuthor());
                                this.ePF.setVisibility(0);
                                this.ePw.setOnClickListener(onClickListener);
                                this.ePy.setOnClickListener(onClickListener);
                                this.ePF.setOnClickListener(onClickListener);
                                this.ePD.setVisibility(8);
                                this.ePF.c(portrait, 28, false);
                            }
                            String name_show = b.getAuthor().getName_show();
                            String userName = b.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ac.fT() && name_show != null && !name_show.equals(userName)) {
                                this.ePy.setText(com.baidu.tieba.pb.d.ao(this.eHK.getPageContext().getPageActivity(), this.ePy.getText().toString()));
                                this.ePy.setGravity(16);
                                this.ePy.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOJ());
                                com.baidu.tbadk.core.util.aj.c(this.ePy, d.e.cp_other_e, 1);
                            }
                        }
                        e = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = b.getAuthor().getIconInfo();
                        tShowInfoNew = b.getAuthor().getTShowInfoNew();
                        if (this.eLq != null) {
                        }
                        if (this.eLp != null) {
                        }
                        this.ePy.setText(ah(b.getAuthor().getSealPrefix(), e));
                        this.ePy.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                        this.ePy.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.ePy, d.e.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.ePz.setVisibility(8);
                        this.ePA.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.ePB, d.e.cp_link_tip_a, 1);
                        this.ePB.setVisibility(0);
                        if (fVar.aPi().getAuthor() != null) {
                            if (fVar.aPi().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.ePF.setUserId(b.getAuthor().getUserId());
                        this.ePF.setUserName(b.getAuthor().getUserName());
                        this.ePF.setImageDrawable(null);
                        this.ePF.setRadius(com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds40));
                        this.ePF.setTag(b.getAuthor().getUserId());
                        this.ePP.setText(b.bsB());
                        f = com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds8);
                        if (this.ePz == null) {
                        }
                        this.ePP.setPadding(0, 0, f, 0);
                        bsC = b.bsC();
                        if (bsC == null) {
                        }
                        this.bIg.setVisibility(8);
                        this.ePQ.setVisibility(8);
                        this.ePN.a(b.getAuthor());
                        this.ePN.ePa = this.eRv;
                        if (!this.eQB) {
                        }
                        portrait = b.getAuthor().getPortrait();
                        if (b.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.ePF, b.getAuthor());
                        this.ePF.setVisibility(0);
                        this.ePw.setOnClickListener(onClickListener);
                        this.ePy.setOnClickListener(onClickListener);
                        this.ePF.setOnClickListener(onClickListener);
                        this.ePD.setVisibility(8);
                        this.ePF.c(portrait, 28, false);
                        String name_show2 = b.getAuthor().getName_show();
                        String userName2 = b.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ac.fT()) {
                            this.ePy.setText(com.baidu.tieba.pb.d.ao(this.eHK.getPageContext().getPageActivity(), this.ePy.getText().toString()));
                            this.ePy.setGravity(16);
                            this.ePy.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOJ());
                            com.baidu.tbadk.core.util.aj.c(this.ePy, d.e.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.j.aP(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = b.getAuthor().getIconInfo();
                            tShowInfoNew = b.getAuthor().getTShowInfoNew();
                            if (this.eLq != null) {
                            }
                            if (this.eLp != null) {
                            }
                            this.ePy.setText(ah(b.getAuthor().getSealPrefix(), e));
                            this.ePy.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                            this.ePy.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.c(this.ePy, d.e.cp_cont_h, 1);
                            if (b == null) {
                            }
                            this.ePz.setVisibility(8);
                            this.ePA.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.c(this.ePB, d.e.cp_link_tip_a, 1);
                            this.ePB.setVisibility(0);
                            if (fVar.aPi().getAuthor() != null) {
                            }
                            this.ePF.setUserId(b.getAuthor().getUserId());
                            this.ePF.setUserName(b.getAuthor().getUserName());
                            this.ePF.setImageDrawable(null);
                            this.ePF.setRadius(com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds40));
                            this.ePF.setTag(b.getAuthor().getUserId());
                            this.ePP.setText(b.bsB());
                            f = com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds8);
                            if (this.ePz == null) {
                            }
                            this.ePP.setPadding(0, 0, f, 0);
                            bsC = b.bsC();
                            if (bsC == null) {
                            }
                            this.bIg.setVisibility(8);
                            this.ePQ.setVisibility(8);
                            this.ePN.a(b.getAuthor());
                            this.ePN.ePa = this.eRv;
                            if (!this.eQB) {
                            }
                            portrait = b.getAuthor().getPortrait();
                            if (b.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.ePF, b.getAuthor());
                            this.ePF.setVisibility(0);
                            this.ePw.setOnClickListener(onClickListener);
                            this.ePy.setOnClickListener(onClickListener);
                            this.ePF.setOnClickListener(onClickListener);
                            this.ePD.setVisibility(8);
                            this.ePF.c(portrait, 28, false);
                            String name_show22 = b.getAuthor().getName_show();
                            String userName22 = b.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ac.fT()) {
                            }
                        }
                        e = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = b.getAuthor().getIconInfo();
                        tShowInfoNew = b.getAuthor().getTShowInfoNew();
                        if (this.eLq != null) {
                        }
                        if (this.eLp != null) {
                        }
                        this.ePy.setText(ah(b.getAuthor().getSealPrefix(), e));
                        this.ePy.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                        this.ePy.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.ePy, d.e.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.ePz.setVisibility(8);
                        this.ePA.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.ePB, d.e.cp_link_tip_a, 1);
                        this.ePB.setVisibility(0);
                        if (fVar.aPi().getAuthor() != null) {
                        }
                        this.ePF.setUserId(b.getAuthor().getUserId());
                        this.ePF.setUserName(b.getAuthor().getUserName());
                        this.ePF.setImageDrawable(null);
                        this.ePF.setRadius(com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds40));
                        this.ePF.setTag(b.getAuthor().getUserId());
                        this.ePP.setText(b.bsB());
                        f = com.baidu.adp.lib.util.k.f(this.eHK.getActivity(), d.f.ds8);
                        if (this.ePz == null) {
                        }
                        this.ePP.setPadding(0, 0, f, 0);
                        bsC = b.bsC();
                        if (bsC == null) {
                        }
                        this.bIg.setVisibility(8);
                        this.ePQ.setVisibility(8);
                        this.ePN.a(b.getAuthor());
                        this.ePN.ePa = this.eRv;
                        if (!this.eQB) {
                        }
                        portrait = b.getAuthor().getPortrait();
                        if (b.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.ePF, b.getAuthor());
                        this.ePF.setVisibility(0);
                        this.ePw.setOnClickListener(onClickListener);
                        this.ePy.setOnClickListener(onClickListener);
                        this.ePF.setOnClickListener(onClickListener);
                        this.ePD.setVisibility(8);
                        this.ePF.c(portrait, 28, false);
                        String name_show222 = b.getAuthor().getName_show();
                        String userName222 = b.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ac.fT()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.ePv.aa(fVar.aPi());
                }
                if (this.eRa != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eFF);
                    if (fVar != null && fVar.aPi() != null) {
                        jVar.eFH = fVar.aPi().rt();
                    }
                    jVar.aFm = !this.eGE;
                    jVar.eFI = this.eHK.aQX();
                    this.eRa.a(jVar);
                }
            }
        }
    }

    public void jJ(boolean z) {
        if (z) {
            aTo();
        } else {
            aTp();
        }
        this.eRe.eSj = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eRe));
        a(this.eRe.eSj, false);
    }

    public void aTo() {
        if (this.ePk != null && !this.eRw) {
            this.ePk.jY(!StringUtils.isNull(this.eHK.aQu()));
            this.eRw = true;
        }
    }

    public void aTp() {
        if (this.ePk != null) {
            this.ePk.aUI();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rW() != null) {
            this.ePx.a(this.eHK.getPageContext(), fVar.aPk().get(0).rW(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aPg().getId(), fVar.aPg().getName(), fVar.aPi().getId(), this.eHK.aQU() ? "FRS" : null));
            this.ePw.setPadding(this.ePw.getPaddingLeft(), (int) this.eHK.getResources().getDimension(d.f.ds20), this.ePw.getPaddingRight(), this.ePw.getPaddingBottom());
            return;
        }
        this.ePx.a(null, null, null);
    }

    public void aTq() {
        if (this.ePf != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").r("obj_type", 1));
            this.ePf.aWg();
            this.ePo.smoothScrollToPosition(0);
        }
    }

    public boolean aTr() {
        return this.eRS;
    }

    private boolean Pk() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean S(bj bjVar) {
        if (bjVar == null || bjVar.getAuthor() == null || bjVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.ePk.aUG();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.ePk.nx(eVar.forumName);
            }
            String string = this.eHK.getResources().getString(d.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eHK.getResources().getString(d.l.self);
                    break;
                case 300:
                    str = this.eHK.getResources().getString(d.l.bawu);
                    break;
                case 400:
                    str = this.eHK.getResources().getString(d.l.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eEU;
            this.eHK.showNetRefreshView(this.ccS, format, null, this.eHK.getResources().getString(d.l.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.k.hz()) {
                        au.wd().c(an.this.eHK.getPageContext(), new String[]{str2});
                        an.this.eHK.finish();
                        return;
                    }
                    an.this.eHK.showToast(d.l.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aSF;
        String str;
        if (fVar != null) {
            this.eMm = fVar;
            this.mType = i;
            if (fVar.aPi() != null) {
                this.eRg = fVar.aPi().ro();
                this.Zq = fVar.aPi().rk();
                if (fVar.aPi().getAnchorLevel() != 0) {
                    this.eRS = true;
                }
                this.eQB = S(fVar.aPi());
                if (this.ePN != null && fVar.aPi().getAuthor() != null) {
                    this.ePN.isBigV = fVar.aPi().getAuthor().isBigV();
                }
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            p(fVar);
            this.eQQ = false;
            this.eGE = z;
            aTk();
            b(fVar, z, i);
            if (this.eHK.aQK()) {
                if (this.eQc == null) {
                    this.eQc = new com.baidu.tieba.pb.view.i(this.eHK.getPageContext());
                    this.eQc.lb();
                    this.eQc.a(this.anf);
                }
                this.ePo.setPullRefresh(this.eQc);
                aTs();
                if (this.eQc != null) {
                    this.eQc.dq(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qD().qA() == 0 && z) {
                this.ePo.setPullRefresh(null);
                this.ePe = 1;
            } else {
                if (this.eQc == null) {
                    this.eQc = new com.baidu.tieba.pb.view.i(this.eHK.getPageContext());
                    this.eQc.lb();
                    this.eQc.a(this.anf);
                }
                this.ePo.setPullRefresh(this.eQc);
                aTs();
                this.ePe = 2;
                if (this.eQc != null) {
                    this.eQc.dq(TbadkCoreApplication.getInst().getSkinType());
                }
                Sb();
            }
            aTt();
            this.ePY.iU(this.eGE);
            this.ePY.iV(false);
            this.ePY.jg(i == 5);
            this.ePY.jh(i == 6);
            this.ePY.ji(z2 && this.eRP);
            this.ePY.a(fVar, false);
            this.ePY.notifyDataSetChanged();
            if (this.eHK.aQY()) {
                if (fVar.aPh() != null) {
                    this.mForumName = fVar.aPh().getForumName();
                    this.mForumId = fVar.aPh().getForumId();
                }
                if (this.mForumName == null && this.eHK.aQn() != null && this.eHK.aQn().aRC() != null) {
                    this.mForumName = this.eHK.aQn().aRC();
                }
                this.ePk.nx(this.mForumName);
            } else {
                this.ePk.nx(null);
            }
            if (this.eHK.aQY()) {
                int i4 = 0;
                PostData b = b(fVar, z);
                if (b != null && b.getAuthor() != null) {
                    i4 = b.getAuthor().getLevel_id();
                }
                if (i4 > 0) {
                    this.ePC.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.ePC, BitmapHelper.getGradeResourceIdInEnterForum(i4));
                } else {
                    this.ePC.setVisibility(8);
                }
            } else {
                this.ePC.setVisibility(8);
            }
            if (fVar.aPi() != null && fVar.aPi().rr() != null) {
                if (fVar.aPi().rr().getNum() < 1) {
                    str = this.eHK.getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = fVar.aPi().rr().getNum() + "";
                }
                if (this.ePd != -1) {
                    fVar.aPi().rr().setIsLike(this.ePd);
                }
                U(str, fVar.aPi().rr().getIsLike() == 1);
            }
            if (fVar.qD().qz() == 0 && !z) {
                this.ePo.setNextPage(null);
                this.ePj = 1;
            } else if (this.eHK.isLogin()) {
                this.ePo.setNextPage(this.cuy);
                this.ePj = 2;
                Sb();
            } else if (fVar.qD().qz() == 1) {
                this.eQQ = true;
                if (this.eQd == null) {
                    this.eQd = new com.baidu.tieba.pb.view.b(this.eHK.getPageContext());
                }
                this.ePo.setNextPage(this.eQd);
                this.ePj = 3;
            }
            ArrayList<PostData> aPk = fVar.aPk();
            if (fVar.qD().qz() == 0 || aPk == null || aPk.size() < fVar.qD().qy()) {
                if (com.baidu.tbadk.core.util.v.u(aPk) == 0 || (com.baidu.tbadk.core.util.v.u(aPk) == 1 && aPk.get(0) != null && aPk.get(0).bsz() == 1)) {
                    this.cuy.setText(this.eHK.getResources().getString(d.l.list_no_more_new));
                } else {
                    this.cuy.setText(this.eHK.getResources().getString(d.l.list_has_no_more));
                }
                if (this.eHK.aQK() && this.ePo != null && this.ePo.getData() != null && this.ePo.getData().size() == 1 && (this.ePo.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.cuy.setText("");
                }
                aTy();
            } else if (z2) {
                if (this.eRP) {
                    wW();
                    if (fVar.qD().qz() != 0) {
                        this.cuy.setText(this.eHK.getResources().getString(d.l.pb_load_more));
                    }
                } else {
                    this.cuy.wR();
                    this.cuy.showLoading();
                }
            } else {
                this.cuy.wR();
                this.cuy.showLoading();
            }
            switch (i) {
                case 2:
                    int i5 = 0;
                    if (this.ePo.getData() != null || fVar.aPk() != null) {
                        i5 = (this.ePo.getData().size() - fVar.aPk().size()) + this.ePo.getHeaderViewsCount();
                    }
                    this.ePo.setSelection(i2 > 1 ? (i5 + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aSF = af.aSE().aSF()) != null) {
                        this.eRK = true;
                        this.ePo.onRestoreInstanceState(aSF);
                        break;
                    } else {
                        this.ePo.setSelection(0);
                        break;
                    }
                case 4:
                    this.eRP = false;
                    break;
                case 5:
                    this.ePo.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aSF2 = af.aSE().aSF();
                        this.eRK = true;
                        if (aSF2 != null) {
                            this.ePo.onRestoreInstanceState(aSF2);
                            break;
                        }
                    }
                    this.ePo.setSelection(0);
                    break;
            }
            if (this.eRg == eRi && Pk()) {
                aTB();
            }
            if (this.eRt) {
                aSK();
                this.eRt = false;
                if (i3 == 0) {
                    jE(true);
                }
            }
            if (this.ePg != null) {
                this.ePg.ag(fVar.aPi());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aTs() {
        if (this.ePf != null && this.ePf.aWf() != null) {
            this.ePo.removeHeaderView(this.axP);
            if (this.mType != 1) {
                this.ePo.removeHeaderView(this.ePf.aWh());
                this.ePo.addHeaderView(this.ePf.aWh(), 0);
                return;
            }
            return;
        }
        if (this.ePf != null) {
            this.ePo.removeHeaderView(this.ePf.aWh());
        }
        this.ePo.removeHeaderView(this.axP);
        this.ePo.addHeaderView(this.axP, 0);
    }

    public void jK(boolean z) {
        this.eQA = z;
    }

    public void wW() {
        if (this.cuy != null) {
            this.cuy.wS();
            this.cuy.wW();
        }
        Sb();
    }

    public void NI() {
        this.ePo.setVisibility(0);
    }

    private boolean aTt() {
        boolean z;
        if (this.eQD != null && this.eQD.getVisibility() == 0) {
            if (this.ePU != null) {
                this.ePU.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.ePU != null) {
                this.ePU.setVisibility(8);
            }
            z = false;
        }
        if ((this.ePW == null || this.ePW.getVisibility() == 8) && z && this.eGE) {
            this.ePV.setVisibility(0);
        } else {
            this.ePV.setVisibility(8);
        }
        com.baidu.tieba.graffiti.b.az(this.ePV);
        return z;
    }

    private boolean o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPi() == null) {
            return false;
        }
        if (fVar.aPi().ry() == 1 || fVar.aPi().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aPi().rA() == null || fVar.aPi().rA().tb() == 0) || fVar.aPi().rw() == 1 || fVar.aPi().rx() == 1 || fVar.aPi().sg() || fVar.aPi().st() || fVar.aPi().sn() || fVar.aPi().rN() != null || fVar.aPi().su() || fVar.aPi().su() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aPi().getCategory()) || fVar.aPi().rE() || fVar.aPi().rD();
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eHK.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.ePs != null) {
                if (fVar.aPi() != null && fVar.aPi().rQ() == 0 && !fVar.aPi().so() && !this.eRG) {
                    this.ePs.setVisibility(0);
                    if (fVar.aPi() != null) {
                        fVar.aPi().e(true, o(fVar));
                    }
                    SpannableStringBuilder sb = fVar.aPi().sb();
                    this.ePt.setOnTouchListener(new com.baidu.tieba.view.m(sb));
                    this.ePt.setText(sb);
                    this.ePt.setVisibility(0);
                } else if (fVar.aPi().rQ() == 1) {
                    if (fVar.aPi() != null) {
                        fVar.aPi().e(true, o(fVar));
                        SpannableStringBuilder sb2 = fVar.aPi().sb();
                        if (sb2 == null || sb2.length() == 0) {
                            this.ePs.setVisibility(8);
                            this.ePo.removeHeaderView(this.ePs);
                            if (fVar.aPi() != null && !fVar.aPi().so()) {
                                this.ePw.setPadding(this.ePw.getPaddingLeft(), com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds48), this.ePw.getPaddingRight(), this.ePw.getPaddingBottom());
                            }
                        } else {
                            this.ePs.setVisibility(0);
                            this.ePt.setOnTouchListener(new com.baidu.tieba.view.m(sb2));
                            this.ePt.setText(sb2);
                            this.ePt.setVisibility(0);
                        }
                    }
                } else {
                    this.ePs.setVisibility(8);
                    this.ePo.removeHeaderView(this.ePs);
                    if (fVar.aPi() != null && fVar.aPi().so()) {
                        this.ePw.setPadding(this.ePw.getPaddingLeft(), 0, this.ePw.getPaddingRight(), this.ePw.getPaddingBottom());
                    } else {
                        this.ePw.setPadding(this.ePw.getPaddingLeft(), com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds48), this.ePw.getPaddingRight(), this.ePw.getPaddingBottom());
                    }
                }
            }
            this.eGE = z;
            bj aPi = fVar.aPi();
            if (aPi != null) {
                a(aPi.rA());
            }
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            aTt();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        if (fVar == null || (b = b(fVar, z)) == null) {
            return null;
        }
        String userId = b.getAuthor().getUserId();
        boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 0) {
            sparseArray.put(d.h.tag_del_post_id, b.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPt()));
            sparseArray.put(d.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (b.getAuthor() != null) {
                sparseArray.put(d.h.tag_forbid_user_name, b.getAuthor().getUserName());
                sparseArray.put(d.h.tag_forbid_user_post_id, b.getId());
            }
            sparseArray.put(d.h.tag_del_post_id, b.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPt()));
            sparseArray.put(d.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aIu;
    }

    public void pr(String str) {
        if (this.cuy != null) {
            this.cuy.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.ePo;
    }

    public int aTu() {
        return d.h.richText;
    }

    public TextView aQh() {
        return this.ePv.aQh();
    }

    public void d(BdListView.e eVar) {
        this.ePo.setOnSrollToBottomListener(eVar);
    }

    public void a(k.b bVar) {
        this.anf = bVar;
        if (this.eQc != null) {
            this.eQc.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, a.b bVar) {
        if (arVar != null) {
            int qx = arVar.qx();
            int qu = arVar.qu();
            if (this.ePZ != null) {
                this.ePZ.to();
            } else {
                this.ePZ = new com.baidu.tbadk.core.dialog.a(this.eHK.getPageContext().getPageActivity());
                this.eQa = LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(d.j.dialog_direct_pager, (ViewGroup) null);
                this.ePZ.v(this.eQa);
                this.ePZ.a(d.l.dialog_ok, bVar);
                this.ePZ.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.aDM();
                        aVar.dismiss();
                    }
                });
                this.ePZ.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.eRp == null) {
                            an.this.eRp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.eHK.HidenSoftKeyPad((InputMethodManager) an.this.eHK.getSystemService("input_method"), an.this.ccS);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fQ().postDelayed(an.this.eRp, 150L);
                    }
                });
                this.ePZ.b(this.eHK.getPageContext()).to();
            }
            this.eQb = (EditText) this.eQa.findViewById(d.h.input_page_number);
            this.eQb.setText("");
            TextView textView = (TextView) this.eQa.findViewById(d.h.current_page_number);
            if (qx <= 0) {
                qx = 1;
            }
            if (qu <= 0) {
                qu = 1;
            }
            textView.setText(MessageFormat.format(this.eHK.getApplicationContext().getResources().getString(d.l.current_page), Integer.valueOf(qx), Integer.valueOf(qu)));
            this.eHK.ShowSoftKeyPadDelay(this.eQb, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.ePo.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eHK.showToast(str);
    }

    public boolean jL(boolean z) {
        if (this.Jp == null || !this.Jp.CY()) {
            return false;
        }
        this.Jp.Bp();
        return true;
    }

    public void aTv() {
        if (this.eRT != null) {
            while (this.eRT.size() > 0) {
                TbImageView remove = this.eRT.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aTv();
        this.ePY.po(1);
        if (this.ePf != null) {
            this.ePf.onPause();
        }
    }

    public void onResume() {
        this.ePY.po(2);
        if (this.ePf != null) {
            this.ePf.onResume();
        }
        if (this.eRf != null) {
            this.eRf.onResume();
        }
    }

    public void onDestroy() {
        this.eRs.ZO();
        if (this.ePh != null) {
            this.ePh.ZO();
        }
        if (this.ePg != null) {
            this.ePg.onDestroy();
        }
        this.eHK.hideProgressBar();
        if (this.bJn != null && this.bJq != null) {
            this.bJn.b(this.bJq);
        }
        aDM();
        wW();
        if (this.eRp != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.eRp);
        }
        if (this.eRq != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.eRq);
        }
        if (this.eRF != null) {
            this.eRF.removeAllViews();
        }
        if (this.ePw != null && this.ePL != null) {
            this.ePw.removeView(this.ePE);
            this.ePL = null;
        }
        if (this.eQU != null) {
            this.eQU.clearStatus();
        }
        this.eRL = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.ePY.po(3);
        if (this.ceZ != null) {
            this.ceZ.setBackgroundDrawable(null);
        }
        if (this.ePf != null) {
            this.ePf.destroy();
        }
        if (this.ePY != null) {
            this.ePY.onDestory();
        }
        this.ePo.setOnLayoutListener(null);
        this.ccS.getViewTreeObserver().removeGlobalOnLayoutListener(this.eRU);
    }

    public boolean pA(int i) {
        if (this.ePf != null) {
            return this.ePf.je(i);
        }
        return false;
    }

    public void aDM() {
        this.ePk.ol();
        this.eRs.ZO();
        if (this.ePh != null) {
            this.ePh.ZO();
        }
        com.baidu.adp.lib.util.k.a(this.eHK.getPageContext().getPageActivity(), this.eQb);
        aSN();
        if (this.eQy != null) {
            this.eQy.dismiss();
        }
        aTw();
        if (this.ePg != null) {
            this.ePg.aVY();
        }
        if (this.ePZ != null) {
            this.ePZ.dismiss();
        }
        if (this.crx != null) {
            this.crx.dismiss();
        }
    }

    public void iT(boolean z) {
        this.ePY.iT(z);
    }

    public void ht(boolean z) {
        this.dSZ = z;
    }

    public void aTw() {
        if (this.eQh != null) {
            this.eQh.dismiss();
        }
        if (this.eQi != null) {
            com.baidu.adp.lib.g.g.b(this.eQi, this.eHK.getPageContext());
        }
        if (this.eQr != null) {
            com.baidu.adp.lib.g.g.b(this.eQr, this.eHK.getPageContext());
        }
        if (this.eQf != null) {
            com.baidu.adp.lib.g.g.b(this.eQf, this.eHK.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.eMm, this.eGE);
            d(this.eMm, this.eGE, this.mType);
            this.eHK.getLayoutMode().ah(i == 1);
            this.eHK.getLayoutMode().t(this.ccS);
            this.eHK.getLayoutMode().t(this.ePt);
            this.eHK.getLayoutMode().t(this.ePu);
            this.eHK.getLayoutMode().t(this.ePq);
            if (this.ePJ != null) {
                com.baidu.tbadk.core.util.aj.c(this.ePJ, d.e.cp_cont_d, 1);
            }
            if (this.ePI != null) {
                com.baidu.tbadk.core.util.aj.c(this.ePI, d.e.cp_cont_d, 1);
            }
            if (this.ePg != null) {
                this.ePg.onChangeSkinType(i);
            }
            this.eHK.getLayoutMode().t(this.ePq);
            com.baidu.tbadk.core.util.aj.i(this.ePt, d.e.cp_cont_b);
            this.ePt.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            this.eHK.getLayoutMode().t(this.aIu);
            if (this.eQa != null) {
                this.eHK.getLayoutMode().t(this.eQa);
            }
            jK(this.eQA);
            this.ePY.notifyDataSetChanged();
            if (this.eQc != null) {
                this.eQc.dq(i);
            }
            if (this.cuy != null) {
                this.cuy.dq(i);
                com.baidu.tbadk.core.util.aj.j(this.aIu, d.g.pb_foot_more_trans_selector);
                this.cuy.m10do(d.g.pb_foot_more_trans_selector);
            }
            if (this.Jp != null) {
                this.Jp.onChangeSkinType(i);
            }
            if (this.ePK != null) {
                this.ePK.du(i);
            }
            if (this.eQd != null) {
                this.eQd.dq(i);
            }
            if (this.ePp != null && this.ePp.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.ePp) {
                    aVar.aUz();
                }
            }
            if (this.eRF != null) {
                com.baidu.tbadk.core.util.aj.k(this.eRF, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.k(this.eRD, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(this.eRE, d.e.cp_cont_c, 1);
            }
            aO(i == 1);
            aSY();
            UtilHelper.setStatusBarBackground(this.ceZ, i);
            UtilHelper.setStatusBarBackground(this.eQZ, i);
            if (this.ePM != null) {
                this.ePM.onChangeSkinType(i);
            }
            if (this.bIg != null) {
                com.baidu.tbadk.core.util.aj.i(this.bIg, d.e.cp_cont_j);
            }
            if (this.ePP != null) {
                com.baidu.tbadk.core.util.aj.i(this.ePP, d.e.cp_cont_j);
            }
            if (this.ePQ != null) {
                com.baidu.tbadk.core.util.aj.j(this.ePQ, d.e.cp_cont_e);
            }
            if (this.ePB != null) {
                com.baidu.tbadk.core.util.aj.i(this.ePB, d.e.cp_link_tip_a);
            }
            if (this.ePO != null) {
                com.baidu.tbadk.core.util.aj.i(this.ePO, d.e.cp_cont_j);
            }
            if (this.ePR != null) {
                com.baidu.tbadk.o.a.a(this.eHK.getPageContext(), this.ePR);
            }
            if (this.eRr != null) {
                this.eRr.onChangeSkinType(i);
            }
            if (this.ePk != null) {
                if (this.ePf != null) {
                    this.ePf.pM(i);
                } else {
                    this.ePk.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.aj.i(this.ePz, d.e.cp_cont_j);
            if (this.ePA != null) {
                com.baidu.tbadk.core.util.aj.j(this.ePA, d.e.cp_cont_e);
            }
            this.mSkinType = i;
            if (this.eQF != null) {
                com.baidu.tbadk.core.util.aj.i(this.eQF, d.e.cp_cont_e);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRv = eVar;
        this.ePY.setOnImageClickListener(this.aRv);
    }

    public void c(NoNetworkView.a aVar) {
        this.bJq = aVar;
        if (this.bJn != null) {
            this.bJn.a(this.bJq);
        }
    }

    public void jM(boolean z) {
        this.ePY.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aTx() {
        return this.eQD;
    }

    public void aTy() {
        if (this.ePj != 2) {
            this.ePo.setNextPage(this.cuy);
            this.ePj = 2;
        }
    }

    public void aTz() {
        if (com.baidu.tbadk.l.r.Gx().Gy()) {
            int lastVisiblePosition = this.ePo.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.ePo.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog = tbImageView.getPerfLog();
                                perfLog.fi(1001);
                                perfLog.aJC = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wy();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.l.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.fi(1001);
                        perfLog2.aJC = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.wy();
                    }
                }
            }
        }
    }

    public void hu(boolean z) {
        if (this.eQE != null) {
            if (this.dSZ) {
                hv(z);
            } else {
                hw(z);
            }
        }
    }

    public void aTA() {
        if (this.eQE != null) {
            this.eQE.setVisibility(8);
            this.eQK = false;
            if (this.eRf != null) {
                this.eRf.setVisibility(8);
                jI(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.bpr == null) {
            this.bpr = new com.baidu.tbadk.core.view.a(this.eHK.getPageContext());
        }
        this.bpr.aH(true);
    }

    public void Sb() {
        if (this.bpr != null) {
            this.bpr.aH(false);
        }
    }

    private int getScrollY() {
        View childAt = this.ePo.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.ePo.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.ePf != null) {
            this.ePf.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eRV = getScrollY();
            this.eRe.eSj = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eRe));
            a(this.eRe.eSj, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        this.eRy = false;
        if (this.ePf != null) {
            this.ePf.b(absListView, i);
        }
        int headerViewsCount = (i - this.ePo.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.ePY.pn(headerViewsCount) != com.baidu.tieba.pb.data.l.eFL) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.ePY.aRp().jD(z);
        this.eRe.eSh = i;
        this.eRe.eSi = this.ePo.getHeaderViewsCount();
        this.eRe.eSj = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eRe));
        a(this.eRe.eSj, false);
    }

    private void a(ah ahVar, boolean z) {
        int measuredHeight;
        if (!this.eRv && this.eQY != null && this.ePk.aUC() != null) {
            int aRn = this.ePY.aRn();
            if (aRn > 0 && (ahVar == null || ahVar.getView().getParent() == null)) {
                if (aRn > this.ePo.getFirstVisiblePosition() - this.ePo.getHeaderViewsCount()) {
                    this.eQY.setVisibility(8);
                } else {
                    this.eQY.setVisibility(0);
                }
            } else if (ahVar != null && ahVar.getView() != null && ahVar.eOK != null) {
                int top = ahVar.getView().getTop();
                if (ahVar.getView().getParent() != null) {
                    if (this.eRd) {
                        this.eRc = top;
                        this.eRd = false;
                    }
                    this.eRc = top < this.eRc ? top : this.eRc;
                }
                if (top != 0 || ahVar.getView().isShown()) {
                    if (this.ePX.getY() < 0.0f) {
                        measuredHeight = eRb - ahVar.eOK.getMeasuredHeight();
                    } else {
                        measuredHeight = this.ePk.aUC().getMeasuredHeight() - ahVar.eOK.getMeasuredHeight();
                    }
                    if (ahVar.getView().getParent() == null && top <= this.eRc) {
                        this.eQY.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.eQY.setVisibility(0);
                    } else {
                        this.eQY.setVisibility(8);
                    }
                    if (z) {
                        this.eRd = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int eSh;
        public int eSi;
        public ah eSj;

        public a() {
        }
    }

    public void aTB() {
        if (!this.eRW) {
            TiebaStatic.log("c10490");
            this.eRW = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHK.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eRj, Integer.valueOf(eRl));
            aVar.cb(d.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.h.function_description_view)).setText(d.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.h.title_view)).setText(d.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.z(sparseArray);
            aVar.a(d.l.grade_button_tips, this.eHK);
            aVar.b(d.l.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eHK.getPageContext()).to();
        }
    }

    public void ps(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHK.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eRj, Integer.valueOf(eRm));
        aVar.z(sparseArray);
        aVar.a(d.l.view, this.eHK);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eHK.getPageContext()).to();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.getAuthor() != null) {
            MetaData author = b.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
    }

    public PbInterviewStatusView aTC() {
        return this.eQU;
    }

    private void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPi() != null && fVar.aPi().st() && this.eQU == null) {
            this.eQU = (PbInterviewStatusView) this.eQT.inflate();
            this.eQU.setOnClickListener(this.cry);
            this.eQU.setCallback(this.eHK.aQT());
            this.eQU.b(this.eHK, fVar);
        }
    }

    public LinearLayout aTD() {
        return this.ePX;
    }

    public View aTE() {
        return this.ceZ;
    }

    public boolean aTF() {
        return this.eRG;
    }

    public void iY(boolean z) {
        this.ePv.iY(z);
    }

    private void aTG() {
        if (this.eRG) {
            if (this.eRH == null) {
                d.a aVar = d.eHN.get();
                if (aVar != null) {
                    this.eRH = aVar.a(this.eHK);
                    ListAdapter adapter = this.ePo.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.axP) {
                            this.ePo.addHeaderView(this.eRH.aQf(), 1);
                        } else {
                            this.ePo.addHeaderView(this.eRH.aQf(), 0);
                        }
                    }
                } else {
                    this.ePu.setVisibility(0);
                    return;
                }
            }
            this.ePu.setVisibility(8);
            this.ePo.removeHeaderView(this.ePu);
            return;
        }
        this.ePu.setVisibility(0);
    }

    public void jN(boolean z) {
        this.eRG = z;
    }

    public void aTH() {
        this.eHK.showNetRefreshView(getView(), "");
        View EO = this.eHK.getRefreshView().EO();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EO.getLayoutParams();
        layoutParams.addRule(3, aTD().getId());
        EO.setLayoutParams(layoutParams);
        this.eHK.hideLoadingView(getView());
        if (this.eRH != null) {
            this.ePo.removeHeaderView(this.eRH.aQf());
            this.eRH = null;
        }
    }

    public void pt(String str) {
        if (this.ePl != null) {
            this.ePl.setTitle(str);
        }
    }

    private int jO(boolean z) {
        if (this.eQU == null || this.eQU.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds72);
    }

    private void aTI() {
        if (this.eQU != null && this.eQU.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQU.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eQU.setLayoutParams(layoutParams);
        }
    }

    public boolean aQo() {
        return false;
    }

    public TextView aTJ() {
        return this.ePJ;
    }

    public void pu(String str) {
        this.eQF.performClick();
        if (!StringUtils.isNull(str) && this.eHK.aQi() != null && this.eHK.aQi().Dv() != null && this.eHK.aQi().Dv().Do() != null) {
            EditText Do = this.eHK.aQi().Dv().Do();
            Do.setText(str);
            Do.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aDM();
            aTA();
            aSN();
            if (this.eRr != null) {
                this.eRr.aRt();
            }
            this.eHK.aho();
            this.ePX.setVisibility(8);
            this.ePk.setTitleVisibility(false);
            this.eHK.je(false);
            if (this.ePf != null) {
                if (configuration.orientation == 1) {
                    aTD().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.ePo.setIsLandscape(true);
                    this.ePo.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.ePo.setIsLandscape(false);
                    if (this.eRV > 0) {
                        this.ePo.smoothScrollBy(this.eRV, 0);
                    }
                }
                this.ePf.onConfigurationChanged(configuration);
            }
        }
    }

    public void jP(boolean z) {
        this.ePi = z;
    }

    public boolean aTK() {
        return this.ePf != null && this.ePf.aTK();
    }

    public void aTL() {
        if (this.ePf != null) {
            this.ePf.onPause();
        }
    }

    public void w(long j, int i) {
        if (this.ePg != null) {
            this.ePg.w(j, i);
        }
        if (this.ePf != null) {
            this.ePf.w(j, i);
        }
    }

    public void aTM() {
        if (this.eRf != null) {
            this.eRf.aUx();
        }
    }

    public void aTN() {
        if (this.eRf != null) {
            this.eRf.setVisibility(8);
            jI(false);
        }
    }

    public void jj(boolean z) {
        this.ePY.jj(z);
    }

    public void aTO() {
        if (this.eQV == null) {
            LayoutInflater.from(this.eHK.getActivity()).inflate(d.j.add_experienced_text, (ViewGroup) this.ccS, true);
            this.eQV = (ViewGroup) this.ccS.findViewById(d.h.add_experienced_layout);
            this.eQW = (TextView) this.ccS.findViewById(d.h.add_experienced);
            com.baidu.tbadk.core.util.aj.i(this.eQW, d.e.cp_cont_i);
            String string = this.eHK.getResources().getString(d.l.experienced_add_success);
            String string2 = this.eHK.getResources().getString(d.l.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_h)));
            this.eQW.setText(spannableString);
        }
        this.eQV.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.an.26
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.an.26.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        an.this.eQV.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                an.this.eQW.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eQW.startAnimation(scaleAnimation);
    }
}
