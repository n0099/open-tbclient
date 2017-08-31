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
    private static final int eQh = UtilHelper.getLightStatusBarHeight();
    public static int eQn = 2;
    public static int eQo = 3;
    public static int eQp = 0;
    public static int eQq = 3;
    public static int eQr = 4;
    public static int eQs = 5;
    public static int eQt = 6;
    private com.baidu.tbadk.editortools.i Jp;
    private View aIx;
    private com.baidu.tieba.pb.a.c aRz;
    private k.b anh;
    private TextView axS;
    private TextView bHp;
    private NoNetworkView bIw;
    private View bQs;
    private RelativeLayout cca;
    private View ceh;
    private View.OnClickListener cqF;
    private PbListView ctG;
    private View.OnClickListener eFO;
    private PbActivity eGQ;
    PbActivity.c eIw;
    private PbFakeFloorModel eKT;
    private UserIconBox eKv;
    private UserIconBox eKw;
    private com.baidu.tieba.pb.data.f eLs;
    private LinearLayout eOA;
    private e eOB;
    private ColumnLayout eOC;
    private ThreadSkinView eOD;
    private TextView eOE;
    private TextView eOF;
    private View eOG;
    private TextView eOH;
    private ImageView eOI;
    private HeadPendantView eOJ;
    private FrameLayout eOK;
    private HeadImageView eOL;
    private View eOM;
    private FloatingLayout eON;
    private PbFirstFloorUserLikeButton eOS;
    private al eOT;
    private TextView eOU;
    private TextView eOV;
    private View eOW;
    private LinearLayout eOX;
    private TextView eOY;
    private TextView eOZ;
    public int eOj;
    private com.baidu.tieba.pb.video.i eOl;
    private com.baidu.tieba.pb.video.h eOm;
    private com.baidu.tieba.d.a eOn;
    public final com.baidu.tieba.pb.pb.main.view.c eOq;
    public com.baidu.tieba.pb.pb.main.view.b eOr;
    private ViewStub eOs;
    private ViewStub eOt;
    private PbLandscapeListView eOu;
    private List<com.baidu.tieba.pb.pb.main.view.a> eOv;
    private View eOw;
    private View ePK;
    private TextView ePL;
    private ImageView ePM;
    private ImageView ePN;
    private TextView ePP;
    private boolean ePR;
    private int ePS;
    private int ePT;
    private int ePU;
    private PostData ePV;
    private View ePX;
    private TextView ePY;
    private ViewStub ePZ;
    private View ePa;
    private View ePb;
    private ObservedChangeLinearLayout ePd;
    private g ePe;
    private View ePk;
    private View eQJ;
    private TextView eQK;
    private LinearLayout eQL;
    private boolean eQM;
    private d eQN;
    private com.baidu.tbadk.core.view.userLike.c eQO;
    private com.baidu.tbadk.core.view.userLike.c eQP;
    private Runnable eQS;
    private PbActivity.a eQU;
    private boolean eQW;
    private boolean eQX;
    private PbInterviewStatusView eQa;
    private ViewGroup eQb;
    private TextView eQc;
    private FrameLayout eQd;
    private View eQe;
    private View eQf;
    private ah eQg;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eQl;
    private int eQu;
    private Runnable eQv;
    private Runnable eQw;
    private q eQx;
    private com.baidu.tieba.d.a eQy;
    private int eRb;
    private boolean isLandscape;
    private int mType;
    private int eOk = 1;
    private boolean eOo = false;
    private int eOp = 0;
    private final Handler mHandler = new Handler();
    private View eOx = null;
    private LinearLayout eOy = null;
    private TextView eOz = null;
    private TextView eOO = null;
    private TextView eOP = null;
    public FrsPraiseView eOQ = null;
    private ClickableHeaderImageView eOR = null;
    private View ePc = null;
    private com.baidu.tbadk.core.dialog.a ePf = null;
    private com.baidu.tbadk.core.dialog.b cqE = null;
    private View ePg = null;
    private EditText ePh = null;
    private com.baidu.tieba.pb.view.i ePi = null;
    private com.baidu.tieba.pb.view.b ePj = null;
    private b.InterfaceC0047b dAx = null;
    private TbRichTextView.e aRy = null;
    private NoNetworkView.a bIz = null;
    private Dialog ePl = null;
    private View ePm = null;
    private com.baidu.tbadk.core.dialog.a ePn = null;
    private Dialog ePo = null;
    private View ePp = null;
    private int ePq = 0;
    private RadioGroup btC = null;
    private RadioButton ePr = null;
    private RadioButton ePs = null;
    private RadioButton ePt = null;
    private Button ePu = null;
    private Button ePv = null;
    private TextView ePw = null;
    private Dialog ePx = null;
    private View ePy = null;
    private LinearLayout ePz = null;
    private CompoundButton.OnCheckedChangeListener ePA = null;
    private TextView ePB = null;
    private TextView ePC = null;
    private String ePD = null;
    private com.baidu.tbadk.core.dialog.b ePE = null;
    private com.baidu.tbadk.core.dialog.b ePF = null;
    private boolean ePG = false;
    private boolean ePH = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView ePI = null;
    private boolean dSf = false;
    private Button ePJ = null;
    public ImageView ePO = null;
    private boolean ePQ = true;
    private com.baidu.tbadk.core.view.a bpe = null;
    private boolean eFK = false;
    private int mSkinType = 3;
    private boolean ePW = false;
    private boolean mIsFromCDN = true;
    private int eQi = 0;
    private boolean eQj = true;
    private a eQk = new a();
    private int eQm = 0;
    private boolean eQz = false;
    private int eQA = 0;
    private boolean eQB = false;
    private boolean eQC = false;
    private a.InterfaceC0122a eQD = new a.InterfaceC0122a() { // from class: com.baidu.tieba.pb.pb.main.an.9
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0122a
        public void la() {
        }
    };
    private boolean csX = false;
    private boolean eQE = false;
    private LinearLayout eQF = null;
    private TextView eQG = null;
    private int eQH = 0;
    private boolean eQI = false;
    private boolean eQQ = false;
    private int rank = 0;
    private CustomMessageListener dMO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.ePe != null) {
                an.this.ePe.notifyDataSetChanged();
            }
        }
    };
    private Handler eQR = new Handler();
    private CustomMessageListener eQT = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.ePQ = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eQV = true;
    private boolean eQY = false;
    private boolean Zq = false;
    String userId = null;
    private final List<TbImageView> eQZ = new ArrayList();
    private ViewTreeObserver.OnGlobalLayoutListener eRa = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.pb.main.an.22
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            an.this.aSJ();
        }
    };
    private boolean eRc = false;

    public void jD(boolean z) {
        this.eQz = z;
        if (this.eOu != null) {
            this.eQA = this.eOu.getHeaderViewsCount();
        }
    }

    public void aSz() {
        if (this.eOu != null) {
            int headerViewsCount = this.eOu.getHeaderViewsCount() - this.eQA;
            final int firstVisiblePosition = (this.eOu.getFirstVisiblePosition() == 0 || this.eOu.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.eOu.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.eOu.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.eQk.eRp = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eQk));
            final ah ahVar = this.eQk.eRp;
            final int d = d(ahVar);
            final int y = ((int) this.ePd.getY()) + this.ePd.getMeasuredHeight();
            final boolean z = this.eQe.getVisibility() == 0;
            boolean z2 = this.ePd.getY() < 0.0f;
            if ((z && ahVar != null) || firstVisiblePosition >= this.ePe.aRc() + this.eOu.getHeaderViewsCount()) {
                int measuredHeight = ahVar != null ? ahVar.eNQ.getMeasuredHeight() : 0;
                if (z2) {
                    this.eOu.setSelectionFromTop(this.ePe.aRc() + this.eOu.getHeaderViewsCount(), eQh - measuredHeight);
                } else {
                    this.eOu.setSelectionFromTop(this.ePe.aRc() + this.eOu.getHeaderViewsCount(), this.eOq.aUr().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.eOu.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.eQB) {
                this.eOu.setSelectionFromTop(this.ePe.aRc() + this.eOu.getHeaderViewsCount(), this.eOl.aVU().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.eOu.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aRo() {
                        if (d >= 0 && d <= an.this.cca.getMeasuredHeight()) {
                            int d2 = an.this.d(ahVar);
                            int i = d2 - d;
                            if (z && i != 0 && d <= y) {
                                i = d2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = an.this.bQs.getLayoutParams();
                            if (i == 0 || i > an.this.cca.getMeasuredHeight() || d2 >= an.this.cca.getMeasuredHeight()) {
                                layoutParams.height = an.this.eQu;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.cca.getMeasuredHeight()) {
                                layoutParams.height = an.this.eQu;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                an.this.eOu.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            an.this.bQs.setLayoutParams(layoutParams);
                        }
                        an.this.eOu.setOnLayoutListener(null);
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

    public d aSA() {
        return this.eQN;
    }

    public NoNetworkView aSB() {
        return this.bIw;
    }

    public void aSC() {
        if (this.Jp != null) {
            this.Jp.hide();
        }
    }

    public PbFakeFloorModel aSD() {
        return this.eKT;
    }

    public q aSE() {
        return this.eQx;
    }

    public void aSF() {
        reset();
        aSC();
        this.eQx.aRi();
        ht(false);
    }

    private void reset() {
        if (this.eGQ != null && this.eGQ.aPX() != null && this.Jp != null) {
            com.baidu.tbadk.editortools.pb.a.Dr().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aPX = this.eGQ.aPX();
            aPX.DL();
            if (aPX.getWriteImagesInfo() != null) {
                aPX.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aPX.eN(10);
            aPX.eL(SendView.ALL);
            aPX.eM(SendView.ALL);
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

    public boolean aSG() {
        return this.ePQ;
    }

    public void hu(boolean z) {
        if (this.ePK != null && this.ePL != null) {
            this.ePL.setText(d.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ePK.startAnimation(alphaAnimation);
            }
            this.ePK.setVisibility(0);
            this.ePQ = true;
            if (this.eQl != null) {
                this.eQl.setVisibility(0);
                jH(true);
            }
        }
    }

    public void hv(boolean z) {
        if (this.ePK != null && this.ePL != null) {
            this.ePL.setText(d.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ePK.startAnimation(alphaAnimation);
            }
            this.ePK.setVisibility(0);
            this.ePQ = true;
            if (this.eQl != null) {
                this.eQl.setVisibility(0);
                jH(true);
            }
        }
    }

    public PostData aSH() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.eOu == null) {
            return null;
        }
        int firstVisiblePosition = this.eOu.getFirstVisiblePosition();
        int lastVisiblePosition = this.eOu.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eOu.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.eOu.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.eOu.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.ePe.pl(headerViewsCount) != null && this.ePe.pl(headerViewsCount) != PostData.gii) {
            i2 = headerViewsCount + 1;
        }
        return this.ePe.getItem(i2) instanceof PostData ? (PostData) this.ePe.getItem(i2) : null;
    }

    public an(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.eGQ = null;
        this.cca = null;
        this.ceh = null;
        this.eOu = null;
        this.eOw = null;
        this.eOA = null;
        this.eOC = null;
        this.eOE = null;
        this.eOG = null;
        this.eOH = null;
        this.eOK = null;
        this.eOL = null;
        this.eOM = null;
        this.eOS = null;
        this.eOU = null;
        this.eOV = null;
        this.bHp = null;
        this.eOW = null;
        this.ePa = null;
        this.ePb = null;
        this.ePe = null;
        this.ctG = null;
        this.aIx = null;
        this.cqF = null;
        this.eFO = null;
        this.ePK = null;
        this.ePL = null;
        this.ePM = null;
        this.ePN = null;
        this.ePP = null;
        this.ePX = null;
        this.ePY = null;
        this.ePZ = null;
        this.eGQ = pbActivity;
        this.cqF = onClickListener;
        this.aRz = cVar;
        this.cca = (RelativeLayout) LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(d.j.new_pb_activity, (ViewGroup) null);
        this.cca.getViewTreeObserver().addOnGlobalLayoutListener(this.eRa);
        this.eGQ.addContentView(this.cca, new FrameLayout.LayoutParams(-1, -1));
        this.ceh = this.eGQ.findViewById(d.h.statebar_view);
        this.ePd = (ObservedChangeLinearLayout) this.eGQ.findViewById(d.h.title_wrapper);
        this.bIw = (NoNetworkView) this.eGQ.findViewById(d.h.view_no_network);
        this.eOu = (PbLandscapeListView) this.eGQ.findViewById(d.h.new_pb_list);
        this.eQd = (FrameLayout) this.eGQ.findViewById(d.h.root_float_header);
        this.axS = new TextView(this.eGQ.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds98));
        this.eOu.addHeaderView(this.axS, 0);
        this.eQu = this.eGQ.getResources().getDimensionPixelSize(d.f.ds100);
        this.bQs = new View(this.eGQ.getPageContext().getPageActivity());
        this.bQs.setLayoutParams(new AbsListView.LayoutParams(-1, this.eQu));
        this.bQs.setVisibility(4);
        this.eOu.addFooterView(this.bQs);
        this.eOu.setOnTouchListener(this.eGQ.aMA);
        this.eOq = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        this.eQy = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.eOq.eUP);
        this.eQy.hW(1);
        if (this.eGQ.aQz()) {
            this.eOs = (ViewStub) this.eGQ.findViewById(d.h.manga_view_stub);
            this.eOs.setVisibility(0);
            this.eOr = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.eOr.show();
            this.eOq.mNavigationBar.setVisibility(8);
            layoutParams.height -= eQh;
        }
        this.axS.setLayoutParams(layoutParams);
        this.eOq.aUr().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0110a() { // from class: com.baidu.tieba.pb.pb.main.an.15
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0110a
            public void ahN() {
                if (an.this.eOu != null) {
                    if (an.this.eOl != null) {
                        an.this.eOl.aVV();
                    }
                    an.this.eOu.smoothScrollToPosition(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0110a
            public void ahM() {
                an.this.eGQ.ahd();
            }
        }));
        this.ePK = this.eGQ.findViewById(d.h.pb_editor_tool_comment);
        this.ePS = com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds90);
        this.ePT = com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds156);
        this.ePU = this.ePS;
        this.ePL = (TextView) this.eGQ.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_text);
        this.ePN = (ImageView) this.eGQ.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_more_img);
        this.ePM = (ImageView) this.eGQ.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_emotion_img);
        this.ePP = (TextView) this.eGQ.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_praise_icon);
        this.ePP.setVisibility(8);
        this.ePL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!an.this.eGQ.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ad("fid", an.this.mForumId));
                } else if (an.this.eLs == null || !com.baidu.tieba.pb.f.Y(an.this.eLs.aOX())) {
                    if (an.this.Jp != null) {
                        an.this.aSQ();
                    }
                    if (an.this.Jp != null) {
                        an.this.ePQ = false;
                        com.baidu.tieba.tbadkCore.b.a.a(an.this.eGQ, (View) an.this.Jp.eE(2).aBq, false, an.this.eQD);
                    }
                    an.this.aTp();
                }
            }
        });
        this.ePM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (an.this.eGQ.checkUpIsLogin()) {
                    if (an.this.eLs == null || !com.baidu.tieba.pb.f.Y(an.this.eLs.aOX())) {
                        if (an.this.Jp != null) {
                            an.this.aSQ();
                            an.this.Jp.K((View) an.this.Jp.eC(5));
                        }
                        if (an.this.Jp != null) {
                            an.this.ePQ = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eGQ, (View) an.this.Jp.eE(2).aBq, false, an.this.eQD);
                        }
                        an.this.aTp();
                    }
                }
            }
        });
        this.ePN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (an.this.eGQ.checkUpIsLogin()) {
                    if (an.this.eLs == null || !com.baidu.tieba.pb.f.Y(an.this.eLs.aOX())) {
                        if (an.this.Jp != null) {
                            an.this.aSQ();
                            an.this.Jp.K((View) an.this.Jp.eC(2));
                        }
                        if (an.this.Jp != null) {
                            an.this.ePQ = false;
                            com.baidu.tieba.tbadkCore.b.a.a(an.this.eGQ, (View) an.this.Jp.eE(2).aBq, false, an.this.eQD);
                        }
                        an.this.aTp();
                    }
                }
            }
        });
        this.ePP.setOnClickListener(this.cqF);
        this.ePP.setOnTouchListener(this.eGQ);
        this.eOw = LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_item, (ViewGroup) null);
        this.eOA = (LinearLayout) LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_user_item, (ViewGroup) null);
        this.eOB = new e(this.eGQ, this.eOA);
        this.eOB.init();
        this.eOB.a(this.eOB.aPW(), this.cqF);
        this.eOC = (ColumnLayout) this.eOA.findViewById(d.h.pb_head_owner_root);
        this.eOD = (ThreadSkinView) this.eOA.findViewById(d.h.pb_thread_skin);
        this.eOC.setOnLongClickListener(this.onLongClickListener);
        this.eOC.setOnTouchListener(this.aRz);
        this.eOC.setVisibility(8);
        this.eOw.setOnTouchListener(this.aRz);
        this.ePX = this.eOw.findViewById(d.h.pb_head_activity_join_number_container);
        this.ePX.setVisibility(8);
        this.ePY = (TextView) this.eOw.findViewById(d.h.pb_head_activity_join_number);
        this.eOE = (TextView) this.eOC.findViewById(d.h.pb_head_owner_info_user_name);
        this.eOF = (TextView) this.eOA.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eOG = this.eOA.findViewById(d.h.line_right_user_intro);
        this.eOH = (TextView) this.eOC.findViewById(d.h.floor_owner);
        this.eOI = (ImageView) this.eOC.findViewById(d.h.icon_forum_level);
        this.eOK = (FrameLayout) this.eOC.findViewById(d.h.pb_head_headImage_container);
        this.eOL = (HeadImageView) this.eOC.findViewById(d.h.pb_head_owner_photo);
        this.eOJ = (HeadPendantView) this.eOC.findViewById(d.h.pb_pendant_head_owner_photo);
        this.eOJ.wB();
        if (this.eOJ.getHeadView() != null) {
            this.eOJ.getHeadView().setIsRound(true);
            this.eOJ.getHeadView().setDrawBorder(false);
        }
        if (this.eOJ.getPendantView() != null) {
            this.eOJ.getPendantView().setIsRound(true);
            this.eOJ.getPendantView().setDrawBorder(false);
        }
        this.eKv = (UserIconBox) this.eOC.findViewById(d.h.show_icon_vip);
        this.eKw = (UserIconBox) this.eOC.findViewById(d.h.show_icon_yinji);
        this.eON = (FloatingLayout) this.eOA.findViewById(d.h.pb_head_owner_info_root);
        this.eOS = (PbFirstFloorUserLikeButton) this.eOC.findViewById(d.h.pb_like_button);
        this.eOT = new al(pbActivity.getPageContext(), this.eOS, 1);
        this.eOT.i(this.eGQ.getUniqueId());
        this.eOT.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.29
            @Override // com.baidu.tbadk.core.view.userLike.c.a
            public void aR(boolean z) {
                int i;
                if (an.this.eGQ != null && z && (i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0)) < 2) {
                    am.z(an.this.eGQ.getPageContext());
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                }
            }
        });
        this.eOU = (TextView) this.eOC.findViewById(d.h.pb_views);
        this.eOV = (TextView) this.eOC.findViewById(d.h.pb_item_first_floor_reply_time);
        this.bHp = (TextView) this.eOC.findViewById(d.h.pb_item_first_floor_location_address);
        this.eOW = this.eOC.findViewById(d.h.line_between_time_and_locate);
        this.eQO = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eQP = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.ePa = this.eOw.findViewById(d.h.new_pb_header_item_line_above_livepost);
        this.ePb = this.eOw.findViewById(d.h.new_pb_header_item_line_below_livepost);
        this.eOw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.30
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.ePZ = (ViewStub) this.cca.findViewById(d.h.interview_status_stub);
        this.ePe = new g(this.eGQ, this.eOu);
        this.ePe.p(this.cqF);
        this.ePe.setTbGestureDetector(this.aRz);
        this.ePe.setOnImageClickListener(this.aRy);
        this.eFO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.WI() || !com.baidu.tieba.c.a.a(an.this.eGQ.getBaseContext(), an.this.eGQ.aQc().getThreadID(), (String) sparseArray.get(d.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.h.tag_from, 1);
                                an.this.eGQ.c(sparseArray);
                                return;
                            }
                            an.this.bn(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.h.tag_from, 0);
                        sparseArray.put(d.h.tag_check_mute_from, 1);
                        an.this.eGQ.c(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.ePe.A(this.eFO);
        aSL();
        this.eOu.addHeaderView(this.eOy);
        this.eOu.addHeaderView(this.eOA);
        this.eOu.addHeaderView(this.eOw);
        this.ctG = new PbListView(this.eGQ.getPageContext().getPageActivity());
        this.aIx = this.ctG.getView().findViewById(d.h.pb_more_view);
        if (this.aIx != null) {
            this.aIx.setOnClickListener(this.cqF);
            com.baidu.tbadk.core.util.aj.j(this.aIx, d.g.pb_foot_more_trans_selector);
        }
        this.ctG.wR();
        this.ctG.m10do(d.g.pb_foot_more_trans_selector);
        this.ctG.dp(d.g.pb_foot_more_trans_selector);
        this.ePk = this.eGQ.findViewById(d.h.viewstub_progress);
        this.eGQ.registerListener(this.eQT);
        this.eOM = com.baidu.tbadk.ala.b.nw().i(this.eGQ.getActivity(), 2);
        if (this.eOM != null) {
            this.eOM.setVisibility(8);
            this.eON.addView(this.eOM);
        }
        this.eKT = new PbFakeFloorModel(this.eGQ.getPageContext());
        this.eQx = new q(this.eGQ.getPageContext(), this.eKT, this.cca);
        this.eKT.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                an.this.eKT.m(postData);
                an.this.ePe.notifyDataSetChanged();
                an.this.eQx.aRi();
            }
        });
        if (this.eGQ.aQc() != null && !StringUtils.isNull(this.eGQ.aQc().aRX())) {
            this.eGQ.showToast(this.eGQ.aQc().aRX());
        }
        this.eQe = this.eGQ.findViewById(d.h.pb_expand_blank_view);
        this.eQf = this.eGQ.findViewById(d.h.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eQf.getLayoutParams();
        if (this.eGQ.aQc() != null && this.eGQ.aQc().aRu()) {
            this.eQe.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.eQf.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = eQh;
            this.eQf.setLayoutParams(layoutParams2);
        }
        this.eQg = new ah(this.eGQ.getPageContext(), this.eGQ.findViewById(d.h.pb_reply_expand_view));
        this.eQg.eNQ.setVisibility(8);
        this.eQg.B(this.cqF);
        this.eGQ.registerListener(this.dMO);
        jH(false);
    }

    public View aSI() {
        return this.eQe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSJ() {
        if (this.eQl != null) {
            int[] iArr = new int[2];
            this.ePK.getLocationOnScreen(iArr);
            this.eQl.setBottomMargin((((ViewGroup) this.eGQ.getPageContext().getPageActivity().getWindow().getDecorView()).getHeight() - this.ePU) - iArr[1]);
        }
    }

    public void aSK() {
        if (this.eOu != null) {
            this.eOu.removeHeaderView(this.eOy);
            this.eOu.removeHeaderView(this.eOA);
            this.eOu.removeHeaderView(this.eOw);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eQl == null) {
            this.eQl = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eGQ.getPageContext().getPageActivity());
            jH(true);
            ViewGroup viewGroup = (ViewGroup) this.eGQ.getPageContext().getPageActivity().getWindow().getDecorView();
            int[] iArr = new int[2];
            this.ePK.getLocationOnScreen(iArr);
            this.eQl.a(viewGroup, (viewGroup.getHeight() - this.ePS) - iArr[1], aVar, this.ePK.getVisibility() == 0);
            this.eQl.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.an.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void cD(List<String> list) {
                    an.this.eGQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(an.this.eGQ.getPageContext().getPageActivity(), 25016, (ArrayList) list)));
                }
            });
            this.eQl.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.an.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void V(float f) {
                    if (an.this.ePK != null) {
                        ViewGroup.LayoutParams layoutParams = an.this.ePK.getLayoutParams();
                        layoutParams.height = (int) (((an.this.ePT - an.this.ePS) * f) + an.this.ePS);
                        an.this.ePL.setAlpha(1.0f - f);
                        an.this.ePN.setAlpha(1.0f - f);
                        an.this.ePM.setAlpha(1.0f - f);
                        an.this.ePK.setLayoutParams(layoutParams);
                        an.this.ePU = layoutParams.height;
                    }
                }
            });
        }
    }

    private void aSL() {
        if (this.eOy == null) {
            int g = com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds34);
            this.eOy = new LinearLayout(this.eGQ.getPageContext().getPageActivity());
            this.eOy.setOrientation(1);
            this.eOy.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eOy.setPadding(g, com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds40), g, com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds46));
            this.eOy.setGravity(17);
            this.eOz = new TextView(this.eGQ.getPageContext().getPageActivity());
            this.eOz.setGravity(3);
            this.eOz.setMaxLines(2);
            this.eOz.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            this.eOz.setPadding(0, 0, 0, 0);
            this.eOz.setLineSpacing(com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.aj.i(this.eOz, d.e.cp_cont_b);
            this.eOz.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds48));
            this.eOz.setVisibility(8);
            this.eOy.addView(this.eOz);
            this.eOy.setOnTouchListener(this.aRz);
            this.eOy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.6
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSM() {
        if (this.eGQ.aQz()) {
            this.eOt = (ViewStub) this.eGQ.findViewById(d.h.manga_mention_controller_view_stub);
            this.eOt.setVisibility(0);
            if (this.eOX == null) {
                this.eOX = (LinearLayout) this.eGQ.findViewById(d.h.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.eGQ.getPageContext(), this.eOX);
            }
            if (this.eOY == null) {
                this.eOY = (TextView) this.eOX.findViewById(d.h.manga_prev_btn);
            }
            if (this.eOZ == null) {
                this.eOZ = (TextView) this.eOX.findViewById(d.h.manga_next_btn);
            }
            this.eOY.setOnClickListener(this.cqF);
            this.eOZ.setOnClickListener(this.cqF);
        }
    }

    private void aSN() {
        if (this.eGQ.aQz()) {
            if (this.eGQ.aQC() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eOY, d.e.cp_cont_e, 1);
            }
            if (this.eGQ.aQD() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.eOZ, d.e.cp_cont_e, 1);
            }
        }
    }

    public void aSO() {
        if (this.eOX == null) {
            aSM();
        }
        this.eOt.setVisibility(8);
        if (this.eQR != null && this.eQS != null) {
            this.eQR.removeCallbacks(this.eQS);
        }
    }

    public void aSP() {
        if (this.eQR != null) {
            if (this.eQS != null) {
                this.eQR.removeCallbacks(this.eQS);
            }
            this.eQS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.7
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.eOX == null) {
                        an.this.aSM();
                    }
                    an.this.eOt.setVisibility(0);
                }
            };
            this.eQR.postDelayed(this.eQS, 2000L);
        }
    }

    public void jE(boolean z) {
        this.eOq.jE(z);
        if (z && this.ePW) {
            this.ctG.setText(this.eGQ.getResources().getString(d.l.click_load_more));
            this.eOu.setNextPage(this.ctG);
            this.eOp = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.Jp = iVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.cca.addView(this.Jp, layoutParams);
        this.Jp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aSC();
    }

    public void aSQ() {
        if (this.eGQ != null && this.Jp != null) {
            this.Jp.lK();
            aTp();
        }
    }

    public void U(String str, boolean z) {
        this.ePR = z;
        aO(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void aO(boolean z) {
        if (this.ePP != null) {
            if (this.ePR) {
                com.baidu.tbadk.core.util.aj.j(this.ePP, d.g.pb_praise_already_click_selector);
                this.ePP.setContentDescription(this.eGQ.getResources().getString(d.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.j(this.ePP, d.g.pb_praise_normal_click_selector);
            this.ePP.setContentDescription(this.eGQ.getResources().getString(d.l.frs_item_praise_text));
        }
    }

    public TextView aSR() {
        return this.ePP;
    }

    public void jF(boolean z) {
        if (this.eOu != null && this.axS != null && this.ceh != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.ceh.setVisibility(0);
                } else {
                    this.ceh.setVisibility(8);
                    this.eOu.removeHeaderView(this.axS);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.axS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = eQh;
                    this.axS.setLayoutParams(layoutParams);
                }
                aTh();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.axS.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jN(true);
                this.axS.setLayoutParams(layoutParams2);
            }
            aTh();
            aTx();
        }
    }

    public g aSS() {
        return this.ePe;
    }

    public void aST() {
        if (this.ePe != null) {
            this.ePe.aQX();
        }
    }

    public void a(PbActivity.c cVar) {
        this.eIw = cVar;
    }

    private void a(bm bmVar) {
        if (bmVar == null || bmVar.tb() == 0) {
            if (this.ePJ != null) {
                this.ePJ.setVisibility(8);
            }
            if (this.ePa != null) {
                this.ePa.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ePJ == null) {
            this.eGQ.getLayoutMode().t(((ViewStub) this.eOw.findViewById(d.h.live_talk_layout)).inflate());
            this.ePJ = (Button) this.eOw.findViewById(d.h.pb_head_function_manage_go_to_live_post);
            this.ePa = this.eOw.findViewById(d.h.new_pb_header_item_line_above_livepost);
        }
        int tc = bmVar.tc();
        String string = this.eGQ.getPageContext().getString(d.l.go_to_live_post_prefix);
        if (tc == 0) {
            string = string + this.eGQ.getPageContext().getString(d.l.go_to_interview_post);
        } else if (tc == 1) {
            string = string + this.eGQ.getPageContext().getString(d.l.go_to_discuss_post);
        }
        this.ePJ.setText(string);
        this.ePJ.setVisibility(0);
        this.ePJ.setOnClickListener(this.cqF);
        this.eQX = true;
        aTi();
    }

    public void bn(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.ePm == null) {
            this.ePm = LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eGQ.getLayoutMode().t(this.ePm);
        if (this.ePl == null) {
            this.ePl = new Dialog(this.eGQ.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.ePl.setCanceledOnTouchOutside(true);
            this.ePl.setCancelable(true);
            this.ePl.setContentView(this.ePm);
            WindowManager.LayoutParams attributes = this.ePl.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.ad(this.eGQ.getPageContext().getPageActivity()) * 0.9d);
            this.ePl.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ePl.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.ePl.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.ePl.findViewById(d.h.disable_reply_btn);
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
                    if (an.this.ePl != null && (an.this.ePl instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.ePl, an.this.eGQ.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        an.this.a(((Integer) sparseArray5.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.h.tag_del_post_id), ((Integer) sparseArray5.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.h.tag_forbid_user_name)) || aTu()) {
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
                    if (an.this.ePl != null && (an.this.ePl instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.ePl, an.this.eGQ.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && an.this.eQU != null) {
                        an.this.eQU.f(new Object[]{sparseArray6.get(d.h.tag_manage_user_identity), sparseArray6.get(d.h.tag_forbid_user_name), sparseArray6.get(d.h.tag_forbid_user_post_id)});
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
                    if (an.this.ePl != null && (an.this.ePl instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(an.this.ePl, an.this.eGQ.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        an.this.eGQ.a(z, (String) sparseArray7.get(d.h.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ePl, this.eGQ.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.eQU = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eQp, Integer.valueOf(eQq));
        int i3 = d.l.del_post_confirm;
        if (i == 0) {
            i3 = d.l.del_thread_confirm;
        }
        this.ePn = new com.baidu.tbadk.core.dialog.a(this.eGQ.getActivity());
        this.ePn.cc(i3);
        this.ePn.z(sparseArray);
        this.ePn.a(d.l.dialog_ok, this.eGQ);
        this.ePn.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ePn.ar(true);
        this.ePn.b(this.eGQ.getPageContext());
        this.ePn.to();
    }

    public void al(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.ePy == null) {
            this.ePy = LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(d.j.commit_good, (ViewGroup) null);
        }
        this.eGQ.getLayoutMode().t(this.ePy);
        if (this.ePx == null) {
            this.ePx = new Dialog(this.eGQ.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.ePx.setCanceledOnTouchOutside(true);
            this.ePx.setCancelable(true);
            this.ePI = (ScrollView) this.ePy.findViewById(d.h.good_scroll);
            this.ePx.setContentView(this.ePy);
            WindowManager.LayoutParams attributes = this.ePx.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds540);
            this.ePx.getWindow().setAttributes(attributes);
            this.ePA = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.ePD = (String) compoundButton.getTag();
                        if (an.this.eOv != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : an.this.eOv) {
                                String str = (String) aVar.getTag();
                                if (str != null && an.this.ePD != null && !str.equals(an.this.ePD)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.ePz = (LinearLayout) this.ePy.findViewById(d.h.good_class_group);
            this.ePC = (TextView) this.ePy.findViewById(d.h.dialog_button_cancel);
            this.ePC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.ePx instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(an.this.ePx, an.this.eGQ.getPageContext());
                    }
                }
            });
            this.ePB = (TextView) this.ePy.findViewById(d.h.dialog_button_ok);
            this.ePB.setOnClickListener(this.cqF);
        }
        this.ePz.removeAllViews();
        this.eOv = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bO = bO("0", this.eGQ.getPageContext().getString(d.l.def_good_class));
        this.eOv.add(bO);
        bO.setChecked(true);
        this.ePz.addView(bO);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bO2 = bO(String.valueOf(arrayList.get(i2).pW()), arrayList.get(i2).pV());
                this.eOv.add(bO2);
                View view = new View(this.eGQ.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds1));
                com.baidu.tbadk.core.util.aj.k(view, d.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.ePz.addView(view);
                this.ePz.addView(bO2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.ePI.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eGQ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eGQ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eGQ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.ePI.setLayoutParams(layoutParams2);
            this.ePI.removeAllViews();
            this.ePI.addView(this.ePz);
        }
        com.baidu.adp.lib.g.g.a(this.ePx, this.eGQ.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bO(String str, String str2) {
        Activity pageActivity = this.eGQ.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, d.f.ds100));
        aVar.setOnCheckedChangeListener(this.ePA);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aSU() {
        this.eGQ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eGQ.hideProgressBar();
        if (z && z2) {
            this.eGQ.showToast(this.eGQ.getPageContext().getString(d.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.l.neterror);
            }
            this.eGQ.showToast(str);
        }
    }

    public void ayf() {
        this.ePk.setVisibility(0);
    }

    public void aye() {
        this.ePk.setVisibility(8);
    }

    public View aSV() {
        if (this.ePy != null) {
            return this.ePy.findViewById(d.h.dialog_button_ok);
        }
        return null;
    }

    public String aSW() {
        return this.ePD;
    }

    public View getView() {
        return this.cca;
    }

    public void aSX() {
        com.baidu.adp.lib.util.k.a(this.eGQ.getPageContext().getPageActivity(), this.eGQ.getCurrentFocus());
    }

    public void jG(boolean z) {
        this.eGQ.hideProgressBar();
        aDB();
    }

    public void aSY() {
        this.ctG.wR();
        this.ctG.wV();
    }

    public void aSZ() {
        this.eGQ.hideProgressBar();
        wW();
        this.eOu.completePullRefreshPostDelayed(2000L);
        aTi();
    }

    public void aTa() {
        this.eOu.completePullRefreshPostDelayed(2000L);
        aTi();
    }

    private void jH(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ePL.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eGQ.getResources().getDimensionPixelSize(d.f.ds130) : this.eGQ.getResources().getDimensionPixelSize(d.f.ds34);
        this.ePL.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.ePe.setOnLongClickListener(onLongClickListener);
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z, boolean z2) {
        if (this.ePE != null) {
            this.ePE.dismiss();
            this.ePE = null;
        }
        this.ePE = new com.baidu.tbadk.core.dialog.b(this.eGQ.getPageContext().getPageActivity());
        this.ePE.cf(d.l.operation);
        if (z2) {
            this.ePE.a(new String[]{this.eGQ.getPageContext().getString(d.l.copy)}, interfaceC0047b);
        } else if (!z) {
            this.ePE.a(new String[]{this.eGQ.getPageContext().getString(d.l.copy), this.eGQ.getPageContext().getString(d.l.mark)}, interfaceC0047b);
        } else {
            this.ePE.a(new String[]{this.eGQ.getPageContext().getString(d.l.copy), this.eGQ.getPageContext().getString(d.l.remove_mark)}, interfaceC0047b);
        }
        this.ePE.d(this.eGQ.getPageContext());
        this.ePE.tr();
    }

    public void a(b.InterfaceC0047b interfaceC0047b, boolean z) {
        if (this.ePF != null) {
            this.ePF.dismiss();
            this.ePF = null;
        }
        this.ePF = new com.baidu.tbadk.core.dialog.b(this.eGQ.getPageContext().getPageActivity());
        this.ePF.cf(d.l.operation);
        if (z) {
            this.ePF.a(new String[]{this.eGQ.getPageContext().getString(d.l.save_to_emotion)}, interfaceC0047b);
        } else {
            this.ePF.a(new String[]{this.eGQ.getPageContext().getString(d.l.save_to_emotion), this.eGQ.getPageContext().getString(d.l.save_to_local)}, interfaceC0047b);
        }
        this.ePF.d(this.eGQ.getPageContext());
        this.ePF.tr();
    }

    public int aTb() {
        return px(this.eOu.getFirstVisiblePosition());
    }

    private int px(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.eOu.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eOu.getAdapter() == null || !(this.eOu.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.eOu.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aTc() {
        int lastVisiblePosition = this.eOu.getLastVisiblePosition();
        if (this.eOl != null) {
            if (lastVisiblePosition == this.eOu.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.ePe.aQY();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return px(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.eOu.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.ePh.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.f fVar) {
        this.ePe.a(fVar, false);
        this.ePe.notifyDataSetChanged();
        aTi();
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        if (this.eOQ == null) {
            this.eGQ.getLayoutMode().t(((ViewStub) this.eOw.findViewById(d.h.praise_layout)).inflate());
            this.eOQ = (FrsPraiseView) this.eOw.findViewById(d.h.pb_head_praise_view);
            this.eOQ.setIsFromPb(true);
            this.ePc = this.eOw.findViewById(d.h.new_pb_header_item_line_above_praise);
            this.eOQ.du(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eOQ != null) {
            boolean aTi = aTi();
            this.eOQ.setVisibility(8);
            if (fVar != null && fVar.qD() != null && fVar.qD().qA() == 0 && this.eFK) {
                if (aTi) {
                    this.ePb.setVisibility(0);
                } else {
                    this.ePb.setVisibility(8);
                }
            } else {
                this.ePb.setVisibility(8);
            }
            com.baidu.tieba.graffiti.b.az(this.ePb);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPg() != null) {
            return fVar.aPg();
        }
        if (!com.baidu.tbadk.core.util.v.v(fVar.aOZ())) {
            Iterator<PostData> it = fVar.aOZ().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bso() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aPe();
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
        if (fVar == null || fVar.aOX() == null || fVar.aOX().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aOX().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aOX().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.tu(1);
        postData.setId(fVar.aOX().rR());
        postData.setTitle(fVar.aOX().getTitle());
        postData.setTime(fVar.aOX().getCreateTime());
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
        int g;
        com.baidu.tbadk.data.h bsr;
        String portrait;
        if (fVar != null && fVar.aOX() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            aTv();
            this.eOC.setVisibility(8);
            if (fVar.aOX() != null && fVar.aOX().so() && fVar.aOX().rS() != null) {
                this.eQB = true;
                this.eOq.jW(this.eQB);
                if (this.eOl == null) {
                    this.eOl = new com.baidu.tieba.pb.video.i(this.eGQ, this.eOq, fVar.aOX().rS());
                    this.eOl.a(fVar.aOX().rS(), fVar.aOX(), fVar.getForumId());
                    this.eOl.startPlay();
                } else if (this.eOo) {
                    this.eOl.a(fVar.aOX().rS(), fVar.aOX(), fVar.getForumId());
                    this.eOl.startPlay();
                } else {
                    this.eOl.pG(fVar.getForumId());
                }
                if (fVar.aOY() != null && fVar.aOY().size() >= 1) {
                    bj bjVar = fVar.aOY().get(0);
                    this.eOl.ah(bjVar);
                    this.eOl.pH(bjVar.getTitle());
                }
                this.eOl.b(b, fVar.aOX(), fVar.aPt());
                this.eOo = false;
                this.eOu.removeHeaderView(this.eOl.aVW());
                this.eOu.addHeaderView(this.eOl.aVW(), 0);
                if (this.eOl.aVU() != null && this.eOl.aVU().getParent() == null) {
                    this.eQd.addView(this.eOl.aVU());
                }
                if (this.eOm == null) {
                    this.eOm = new com.baidu.tieba.pb.video.h(this.eGQ);
                }
                this.eOm.a(fVar.aOX().sF(), fVar.aOX(), fVar.aPq());
                this.eOu.removeHeaderView(this.eOm.aVL());
                this.eOu.addHeaderView(this.eOm.aVL(), 1);
                if (fVar.aOX().sF() != null) {
                    this.eOu.removeHeaderView(this.eOm.aVM());
                    this.eOu.removeHeaderView(this.eOA);
                    this.eOu.addHeaderView(this.eOm.aVM(), 2);
                } else {
                    if (this.eOm.aVM() != null) {
                        this.eOu.removeHeaderView(this.eOm.aVM());
                    }
                    this.eOu.removeHeaderView(this.eOA);
                    this.eOu.addHeaderView(this.eOA, 2);
                }
                if (this.eOl != null) {
                    this.eOl.pK(0);
                }
                aTh();
            } else {
                this.eQB = false;
                this.eOq.jW(this.eQB);
                if (this.eOl != null) {
                    this.eOu.removeHeaderView(this.eOl.aVW());
                }
                if (this.eOm != null) {
                    this.eOm.e(this.eOu);
                }
            }
            if (this.eGQ.aQa() != null) {
                this.eGQ.aQa().jT(this.eQB);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.eQB) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").r("obj_id", 2));
                    }
                    if (an.this.eGQ.eHF.eUh != null) {
                        if (!an.this.eQB && an.this.eLs != null && an.this.eLs.aOX() != null && an.this.eLs.aOX().getAuthor() != null && an.this.eLs.aOX().getAuthor().isBigV()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").r("obj_locate", 1));
                        }
                        an.this.eGQ.eHF.eUh.onClick(view);
                    }
                }
            };
            if (this.eOl != null) {
                this.eOl.D(onClickListener);
            }
            if (b != null) {
                this.ePV = b;
                if (fVar != null && fVar.aOX() != null && fVar.aOX().getAuthor() != null) {
                    fVar.aOX().getAuthor().getUserId();
                    if (fVar.qD() != null) {
                        this.eQH = fVar.qD().qw();
                        if (fVar.qD().qz() == 1) {
                        }
                    }
                }
                this.eOC.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eOC.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eOC.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_clip_board, b);
                sparseArray.put(d.h.tag_is_subpb, false);
                if (!this.eQM) {
                    this.eOy.setVisibility(0);
                }
                if (!fVar.aOX().so() && this.eOz.getText() != null && this.eOz.getText().length() > 0) {
                    this.eOz.setVisibility(0);
                } else {
                    this.eOz.setVisibility(8);
                }
                n(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rM = fVar.aOX().rM();
                if (rM != null && rM.size() > 0 && !this.eQM) {
                    this.ePY.setText(String.valueOf(rM.get(0).pm()));
                    this.ePX.setVisibility(0);
                    this.eQW = true;
                } else {
                    this.ePX.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.j(this.ePX, d.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.c(this.ePY, d.e.cp_link_tip_d, 1);
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
                            if (this.eKw != null) {
                                this.eKw.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                                this.eKw.setOnClickListener(this.eGQ.eHF.czD);
                                this.eKw.a(iconInfo, i3, this.eGQ.getResources().getDimensionPixelSize(d.f.ds26), this.eGQ.getResources().getDimensionPixelSize(d.f.ds26), this.eGQ.getResources().getDimensionPixelSize(d.f.ds8));
                            }
                            if (this.eKv != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eKv.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eKv.setOnClickListener(this.eGQ.eHF.eUi);
                                this.eKv.a(tShowInfoNew, 3, this.eGQ.getResources().getDimensionPixelSize(d.f.ds36), this.eGQ.getResources().getDimensionPixelSize(d.f.ds36), this.eGQ.getResources().getDimensionPixelSize(d.f.ds8), true);
                            }
                            this.eOE.setText(ah(b.getAuthor().getSealPrefix(), e));
                            this.eOE.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                            this.eOE.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.v.v(tShowInfoNew) || b.getAuthor().isBigV()) {
                                com.baidu.tbadk.core.util.aj.c(this.eOE, d.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.c(this.eOE, d.e.cp_cont_f, 1);
                            }
                            if (b == null && !TextUtils.isEmpty(b.getAuthor().getGodIntro())) {
                                this.eOF.setVisibility(0);
                                this.eOF.setText(am.a(b.getAuthor()));
                                this.eOG.setVisibility(0);
                            } else {
                                this.eOF.setVisibility(8);
                                this.eOG.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eOH, d.e.cp_link_tip_a, 1);
                            this.eOH.setVisibility(0);
                            if (fVar.aOX().getAuthor() != null && fVar.aOX().getAuthor().getAlaUserData() != null && this.eOM != null) {
                                if (fVar.aOX().getAuthor().getAlaUserData().anchor_live != 0) {
                                    this.eOM.setVisibility(8);
                                } else {
                                    this.eOM.setVisibility(0);
                                    if (this.eOn == null) {
                                        this.eOn = new com.baidu.tieba.d.a(this.eGQ.getPageContext(), this.eOM);
                                        this.eOn.hW(1);
                                    }
                                    this.eOn.aM(this.eGQ.getResources().getString(d.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Qs = fVar.aOX().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.eOM.setTag(aVar);
                                }
                            }
                            this.eOL.setUserId(b.getAuthor().getUserId());
                            this.eOL.setUserName(b.getAuthor().getUserName());
                            this.eOL.setImageDrawable(null);
                            this.eOL.setRadius(com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds40));
                            this.eOL.setTag(b.getAuthor().getUserId());
                            this.eOV.setText(b.bsq());
                            g = com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds8);
                            if (this.eOF == null && this.eOF.getVisibility() == 0) {
                                this.eOV.setPadding(g, 0, g, 0);
                            } else {
                                this.eOV.setPadding(0, 0, g, 0);
                            }
                            bsr = b.bsr();
                            if (bsr == null && !TextUtils.isEmpty(bsr.getName()) && !TextUtils.isEmpty(bsr.getName().trim())) {
                                final String name = bsr.getName();
                                final String lat = bsr.getLat();
                                final String lng = bsr.getLng();
                                this.bHp.setVisibility(0);
                                this.eOW.setVisibility(0);
                                this.bHp.setText(bsr.getName());
                                this.bHp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.18
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.i.hi()) {
                                                an.this.eGQ.showToast(d.l.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.T(an.this.eGQ.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, an.this.eGQ.getPageContext().getString(d.l.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.bHp.setVisibility(8);
                                this.eOW.setVisibility(8);
                            }
                            this.eOT.a(b.getAuthor());
                            this.eOT.eOg = this.eQB;
                            if (!this.ePH) {
                                this.eOS.setVisibility(8);
                                this.eOU.setVisibility(0);
                                this.eOU.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aPs())));
                            } else if (!PbNormalLikeButtonSwitchStatic.GQ() || (b.getAuthor().hadConcerned() && b.getAuthor().getGodUserData() != null && b.getAuthor().getGodUserData().getIsFromNetWork())) {
                                this.eOS.setVisibility(8);
                                this.eOU.setVisibility(8);
                            } else {
                                this.eOS.setVisibility(0);
                                this.eOS.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.fontsize26));
                                this.eOU.setVisibility(8);
                            }
                            portrait = b.getAuthor().getPortrait();
                            if (b.getAuthor().getPendantData() == null && !StringUtils.isNull(b.getAuthor().getPendantData().pR())) {
                                UtilHelper.showHeadImageViewBigV(this.eOJ.getHeadView(), b.getAuthor());
                                this.eOL.setVisibility(8);
                                this.eOJ.setVisibility(0);
                                if (this.eOR != null) {
                                    this.eOR.setVisibility(8);
                                }
                                this.eOE.setOnClickListener(onClickListener);
                                this.eOJ.getHeadView().c(portrait, 28, false);
                                this.eOJ.getHeadView().setUserId(b.getAuthor().getUserId());
                                this.eOJ.getHeadView().setUserName(b.getAuthor().getUserName());
                                this.eOJ.getHeadView().setOnClickListener(onClickListener);
                                this.eOJ.eq(b.getAuthor().getPendantData().pR());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eOL, b.getAuthor());
                                this.eOL.setVisibility(0);
                                this.eOC.setOnClickListener(onClickListener);
                                this.eOE.setOnClickListener(onClickListener);
                                this.eOL.setOnClickListener(onClickListener);
                                this.eOJ.setVisibility(8);
                                this.eOL.c(portrait, 28, false);
                            }
                            String name_show = b.getAuthor().getName_show();
                            String userName = b.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ac.fT() && name_show != null && !name_show.equals(userName)) {
                                this.eOE.setText(com.baidu.tieba.pb.d.ao(this.eGQ.getPageContext().getPageActivity(), this.eOE.getText().toString()));
                                this.eOE.setGravity(16);
                                this.eOE.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOy());
                                com.baidu.tbadk.core.util.aj.c(this.eOE, d.e.cp_other_e, 1);
                            }
                        }
                        e = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = b.getAuthor().getIconInfo();
                        tShowInfoNew = b.getAuthor().getTShowInfoNew();
                        if (this.eKw != null) {
                        }
                        if (this.eKv != null) {
                        }
                        this.eOE.setText(ah(b.getAuthor().getSealPrefix(), e));
                        this.eOE.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                        this.eOE.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eOE, d.e.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eOF.setVisibility(8);
                        this.eOG.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eOH, d.e.cp_link_tip_a, 1);
                        this.eOH.setVisibility(0);
                        if (fVar.aOX().getAuthor() != null) {
                            if (fVar.aOX().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eOL.setUserId(b.getAuthor().getUserId());
                        this.eOL.setUserName(b.getAuthor().getUserName());
                        this.eOL.setImageDrawable(null);
                        this.eOL.setRadius(com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds40));
                        this.eOL.setTag(b.getAuthor().getUserId());
                        this.eOV.setText(b.bsq());
                        g = com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds8);
                        if (this.eOF == null) {
                        }
                        this.eOV.setPadding(0, 0, g, 0);
                        bsr = b.bsr();
                        if (bsr == null) {
                        }
                        this.bHp.setVisibility(8);
                        this.eOW.setVisibility(8);
                        this.eOT.a(b.getAuthor());
                        this.eOT.eOg = this.eQB;
                        if (!this.ePH) {
                        }
                        portrait = b.getAuthor().getPortrait();
                        if (b.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eOL, b.getAuthor());
                        this.eOL.setVisibility(0);
                        this.eOC.setOnClickListener(onClickListener);
                        this.eOE.setOnClickListener(onClickListener);
                        this.eOL.setOnClickListener(onClickListener);
                        this.eOJ.setVisibility(8);
                        this.eOL.c(portrait, 28, false);
                        String name_show2 = b.getAuthor().getName_show();
                        String userName2 = b.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ac.fT()) {
                            this.eOE.setText(com.baidu.tieba.pb.d.ao(this.eGQ.getPageContext().getPageActivity(), this.eOE.getText().toString()));
                            this.eOE.setGravity(16);
                            this.eOE.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOy());
                            com.baidu.tbadk.core.util.aj.c(this.eOE, d.e.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.j.aP(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = b.getAuthor().getIconInfo();
                            tShowInfoNew = b.getAuthor().getTShowInfoNew();
                            if (this.eKw != null) {
                            }
                            if (this.eKv != null) {
                            }
                            this.eOE.setText(ah(b.getAuthor().getSealPrefix(), e));
                            this.eOE.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                            this.eOE.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.c(this.eOE, d.e.cp_cont_h, 1);
                            if (b == null) {
                            }
                            this.eOF.setVisibility(8);
                            this.eOG.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.c(this.eOH, d.e.cp_link_tip_a, 1);
                            this.eOH.setVisibility(0);
                            if (fVar.aOX().getAuthor() != null) {
                            }
                            this.eOL.setUserId(b.getAuthor().getUserId());
                            this.eOL.setUserName(b.getAuthor().getUserName());
                            this.eOL.setImageDrawable(null);
                            this.eOL.setRadius(com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds40));
                            this.eOL.setTag(b.getAuthor().getUserId());
                            this.eOV.setText(b.bsq());
                            g = com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds8);
                            if (this.eOF == null) {
                            }
                            this.eOV.setPadding(0, 0, g, 0);
                            bsr = b.bsr();
                            if (bsr == null) {
                            }
                            this.bHp.setVisibility(8);
                            this.eOW.setVisibility(8);
                            this.eOT.a(b.getAuthor());
                            this.eOT.eOg = this.eQB;
                            if (!this.ePH) {
                            }
                            portrait = b.getAuthor().getPortrait();
                            if (b.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eOL, b.getAuthor());
                            this.eOL.setVisibility(0);
                            this.eOC.setOnClickListener(onClickListener);
                            this.eOE.setOnClickListener(onClickListener);
                            this.eOL.setOnClickListener(onClickListener);
                            this.eOJ.setVisibility(8);
                            this.eOL.c(portrait, 28, false);
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
                        if (this.eKw != null) {
                        }
                        if (this.eKv != null) {
                        }
                        this.eOE.setText(ah(b.getAuthor().getSealPrefix(), e));
                        this.eOE.setTag(d.h.tag_user_id, b.getAuthor().getUserId());
                        this.eOE.setTag(d.h.tag_user_name, b.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.v.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.eOE, d.e.cp_cont_h, 1);
                        if (b == null) {
                        }
                        this.eOF.setVisibility(8);
                        this.eOG.setVisibility(8);
                        com.baidu.tbadk.core.util.aj.c(this.eOH, d.e.cp_link_tip_a, 1);
                        this.eOH.setVisibility(0);
                        if (fVar.aOX().getAuthor() != null) {
                        }
                        this.eOL.setUserId(b.getAuthor().getUserId());
                        this.eOL.setUserName(b.getAuthor().getUserName());
                        this.eOL.setImageDrawable(null);
                        this.eOL.setRadius(com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds40));
                        this.eOL.setTag(b.getAuthor().getUserId());
                        this.eOV.setText(b.bsq());
                        g = com.baidu.adp.lib.util.k.g(this.eGQ.getActivity(), d.f.ds8);
                        if (this.eOF == null) {
                        }
                        this.eOV.setPadding(0, 0, g, 0);
                        bsr = b.bsr();
                        if (bsr == null) {
                        }
                        this.bHp.setVisibility(8);
                        this.eOW.setVisibility(8);
                        this.eOT.a(b.getAuthor());
                        this.eOT.eOg = this.eQB;
                        if (!this.ePH) {
                        }
                        portrait = b.getAuthor().getPortrait();
                        if (b.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eOL, b.getAuthor());
                        this.eOL.setVisibility(0);
                        this.eOC.setOnClickListener(onClickListener);
                        this.eOE.setOnClickListener(onClickListener);
                        this.eOL.setOnClickListener(onClickListener);
                        this.eOJ.setVisibility(8);
                        this.eOL.c(portrait, 28, false);
                        String name_show222 = b.getAuthor().getName_show();
                        String userName222 = b.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ac.fT()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eOB.aa(fVar.aOX());
                }
                if (this.eQg != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eEL);
                    if (fVar != null && fVar.aOX() != null) {
                        jVar.eEN = fVar.aOX().rt();
                    }
                    jVar.aFp = !this.eFK;
                    jVar.eEO = this.eGQ.aQM();
                    this.eQg.a(jVar);
                }
            }
        }
    }

    public void jI(boolean z) {
        if (z) {
            aTd();
        } else {
            aTe();
        }
        this.eQk.eRp = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eQk));
        a(this.eQk.eRp, false);
    }

    public void aTd() {
        if (this.eOq != null && !this.eQC) {
            this.eOq.jX(!StringUtils.isNull(this.eGQ.aQj()));
            this.eQC = true;
        }
    }

    public void aTe() {
        if (this.eOq != null) {
            this.eOq.aUx();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rW() != null) {
            this.eOD.a(this.eGQ.getPageContext(), fVar.aOZ().get(0).rW(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aOV().getId(), fVar.aOV().getName(), fVar.aOX().getId(), this.eGQ.aQJ() ? "FRS" : null));
            this.eOC.setPadding(this.eOC.getPaddingLeft(), (int) this.eGQ.getResources().getDimension(d.f.ds20), this.eOC.getPaddingRight(), this.eOC.getPaddingBottom());
            return;
        }
        this.eOD.a(null, null, null);
    }

    public void aTf() {
        if (this.eOl != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").r("obj_type", 1));
            this.eOl.aVV();
            this.eOu.smoothScrollToPosition(0);
        }
    }

    public boolean aTg() {
        return this.eQY;
    }

    private boolean Pi() {
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
            this.eOq.aUv();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eOq.nv(eVar.forumName);
            }
            String string = this.eGQ.getResources().getString(d.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eGQ.getResources().getString(d.l.self);
                    break;
                case 300:
                    str = this.eGQ.getResources().getString(d.l.bawu);
                    break;
                case 400:
                    str = this.eGQ.getResources().getString(d.l.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eEa;
            this.eGQ.showNetRefreshView(this.cca, format, null, this.eGQ.getResources().getString(d.l.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.k.hz()) {
                        au.wd().c(an.this.eGQ.getPageContext(), new String[]{str2});
                        an.this.eGQ.finish();
                        return;
                    }
                    an.this.eGQ.showToast(d.l.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aSu;
        String str;
        if (fVar != null) {
            this.eLs = fVar;
            this.mType = i;
            if (fVar.aOX() != null) {
                this.eQm = fVar.aOX().ro();
                this.Zq = fVar.aOX().rk();
                if (fVar.aOX().getAnchorLevel() != 0) {
                    this.eQY = true;
                }
                this.ePH = S(fVar.aOX());
                if (this.eOT != null && fVar.aOX().getAuthor() != null) {
                    this.eOT.isBigV = fVar.aOX().getAuthor().isBigV();
                }
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            p(fVar);
            this.ePW = false;
            this.eFK = z;
            aSZ();
            b(fVar, z, i);
            if (this.eGQ.aQz()) {
                if (this.ePi == null) {
                    this.ePi = new com.baidu.tieba.pb.view.i(this.eGQ.getPageContext());
                    this.ePi.lb();
                    this.ePi.a(this.anh);
                }
                this.eOu.setPullRefresh(this.ePi);
                aTh();
                if (this.ePi != null) {
                    this.ePi.dq(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qD().qA() == 0 && z) {
                this.eOu.setPullRefresh(null);
                this.eOk = 1;
            } else {
                if (this.ePi == null) {
                    this.ePi = new com.baidu.tieba.pb.view.i(this.eGQ.getPageContext());
                    this.ePi.lb();
                    this.ePi.a(this.anh);
                }
                this.eOu.setPullRefresh(this.ePi);
                aTh();
                this.eOk = 2;
                if (this.ePi != null) {
                    this.ePi.dq(TbadkCoreApplication.getInst().getSkinType());
                }
                RV();
            }
            aTi();
            this.ePe.iT(this.eFK);
            this.ePe.iU(false);
            this.ePe.jf(i == 5);
            this.ePe.jg(i == 6);
            this.ePe.jh(z2 && this.eQV);
            this.ePe.a(fVar, false);
            this.ePe.notifyDataSetChanged();
            if (this.eGQ.aQN()) {
                if (fVar.aOW() != null) {
                    this.mForumName = fVar.aOW().getForumName();
                    this.mForumId = fVar.aOW().getForumId();
                }
                if (this.mForumName == null && this.eGQ.aQc() != null && this.eGQ.aQc().aRr() != null) {
                    this.mForumName = this.eGQ.aQc().aRr();
                }
                this.eOq.nv(this.mForumName);
            } else {
                this.eOq.nv(null);
            }
            if (this.eGQ.aQN()) {
                int i4 = 0;
                PostData b = b(fVar, z);
                if (b != null && b.getAuthor() != null) {
                    i4 = b.getAuthor().getLevel_id();
                }
                if (i4 > 0) {
                    this.eOI.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.eOI, BitmapHelper.getGradeResourceIdInEnterForum(i4));
                } else {
                    this.eOI.setVisibility(8);
                }
            } else {
                this.eOI.setVisibility(8);
            }
            if (fVar.aOX() != null && fVar.aOX().rr() != null) {
                if (fVar.aOX().rr().getNum() < 1) {
                    str = this.eGQ.getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = fVar.aOX().rr().getNum() + "";
                }
                if (this.eOj != -1) {
                    fVar.aOX().rr().setIsLike(this.eOj);
                }
                U(str, fVar.aOX().rr().getIsLike() == 1);
            }
            if (fVar.qD().qz() == 0 && !z) {
                this.eOu.setNextPage(null);
                this.eOp = 1;
            } else if (this.eGQ.isLogin()) {
                this.eOu.setNextPage(this.ctG);
                this.eOp = 2;
                RV();
            } else if (fVar.qD().qz() == 1) {
                this.ePW = true;
                if (this.ePj == null) {
                    this.ePj = new com.baidu.tieba.pb.view.b(this.eGQ.getPageContext());
                }
                this.eOu.setNextPage(this.ePj);
                this.eOp = 3;
            }
            ArrayList<PostData> aOZ = fVar.aOZ();
            if (fVar.qD().qz() == 0 || aOZ == null || aOZ.size() < fVar.qD().qy()) {
                if (com.baidu.tbadk.core.util.v.u(aOZ) == 0 || (com.baidu.tbadk.core.util.v.u(aOZ) == 1 && aOZ.get(0) != null && aOZ.get(0).bso() == 1)) {
                    this.ctG.setText(this.eGQ.getResources().getString(d.l.list_no_more_new));
                } else {
                    this.ctG.setText(this.eGQ.getResources().getString(d.l.list_has_no_more));
                }
                if (this.eGQ.aQz() && this.eOu != null && this.eOu.getData() != null && this.eOu.getData().size() == 1 && (this.eOu.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.ctG.setText("");
                }
                aTn();
            } else if (z2) {
                if (this.eQV) {
                    wW();
                    if (fVar.qD().qz() != 0) {
                        this.ctG.setText(this.eGQ.getResources().getString(d.l.pb_load_more));
                    }
                } else {
                    this.ctG.wR();
                    this.ctG.showLoading();
                }
            } else {
                this.ctG.wR();
                this.ctG.showLoading();
            }
            switch (i) {
                case 2:
                    int i5 = 0;
                    if (this.eOu.getData() != null || fVar.aOZ() != null) {
                        i5 = (this.eOu.getData().size() - fVar.aOZ().size()) + this.eOu.getHeaderViewsCount();
                    }
                    this.eOu.setSelection(i2 > 1 ? (i5 + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aSu = af.aSt().aSu()) != null) {
                        this.eQQ = true;
                        this.eOu.onRestoreInstanceState(aSu);
                        break;
                    } else {
                        this.eOu.setSelection(0);
                        break;
                    }
                case 4:
                    this.eQV = false;
                    break;
                case 5:
                    this.eOu.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aSu2 = af.aSt().aSu();
                        this.eQQ = true;
                        if (aSu2 != null) {
                            this.eOu.onRestoreInstanceState(aSu2);
                            break;
                        }
                    }
                    this.eOu.setSelection(0);
                    break;
            }
            if (this.eQm == eQo && Pi()) {
                aTq();
            }
            if (this.eQz) {
                aSz();
                this.eQz = false;
                if (i3 == 0) {
                    jD(true);
                }
            }
            if (this.eOm != null) {
                this.eOm.ag(fVar.aOX());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aTh() {
        if (this.eOl != null && this.eOl.aVU() != null) {
            this.eOu.removeHeaderView(this.axS);
            if (this.mType != 1) {
                this.eOu.removeHeaderView(this.eOl.aVW());
                this.eOu.addHeaderView(this.eOl.aVW(), 0);
                return;
            }
            return;
        }
        if (this.eOl != null) {
            this.eOu.removeHeaderView(this.eOl.aVW());
        }
        this.eOu.removeHeaderView(this.axS);
        this.eOu.addHeaderView(this.axS, 0);
    }

    public void jJ(boolean z) {
        this.ePG = z;
    }

    public void wW() {
        if (this.ctG != null) {
            this.ctG.wS();
            this.ctG.wW();
        }
        RV();
    }

    public void NH() {
        this.eOu.setVisibility(0);
    }

    private boolean aTi() {
        boolean z;
        if (this.ePJ != null && this.ePJ.getVisibility() == 0) {
            if (this.ePa != null) {
                this.ePa.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.ePa != null) {
                this.ePa.setVisibility(8);
            }
            z = false;
        }
        if ((this.ePc == null || this.ePc.getVisibility() == 8) && z && this.eFK) {
            this.ePb.setVisibility(0);
        } else {
            this.ePb.setVisibility(8);
        }
        com.baidu.tieba.graffiti.b.az(this.ePb);
        return z;
    }

    private boolean o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aOX() == null) {
            return false;
        }
        if (fVar.aOX().ry() == 1 || fVar.aOX().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aOX().rA() == null || fVar.aOX().rA().tb() == 0) || fVar.aOX().rw() == 1 || fVar.aOX().rx() == 1 || fVar.aOX().sg() || fVar.aOX().st() || fVar.aOX().sn() || fVar.aOX().rN() != null || fVar.aOX().su() || fVar.aOX().su() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aOX().getCategory()) || fVar.aOX().rE() || fVar.aOX().rD();
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eGQ.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eOy != null) {
                if (fVar.aOX() != null && fVar.aOX().rQ() == 0 && !fVar.aOX().so() && !this.eQM) {
                    this.eOy.setVisibility(0);
                    if (fVar.aOX() != null) {
                        fVar.aOX().e(true, o(fVar));
                    }
                    SpannableStringBuilder sb = fVar.aOX().sb();
                    this.eOz.setOnTouchListener(new com.baidu.tieba.view.m(sb));
                    this.eOz.setText(sb);
                    this.eOz.setVisibility(0);
                } else if (fVar.aOX().rQ() == 1) {
                    if (fVar.aOX() != null) {
                        fVar.aOX().e(true, o(fVar));
                        SpannableStringBuilder sb2 = fVar.aOX().sb();
                        if (sb2 == null || sb2.length() == 0) {
                            this.eOy.setVisibility(8);
                            this.eOu.removeHeaderView(this.eOy);
                            if (fVar.aOX() != null && !fVar.aOX().so()) {
                                this.eOC.setPadding(this.eOC.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds48), this.eOC.getPaddingRight(), this.eOC.getPaddingBottom());
                            }
                        } else {
                            this.eOy.setVisibility(0);
                            this.eOz.setOnTouchListener(new com.baidu.tieba.view.m(sb2));
                            this.eOz.setText(sb2);
                            this.eOz.setVisibility(0);
                        }
                    }
                } else {
                    this.eOy.setVisibility(8);
                    this.eOu.removeHeaderView(this.eOy);
                    if (fVar.aOX() != null && fVar.aOX().so()) {
                        this.eOC.setPadding(this.eOC.getPaddingLeft(), 0, this.eOC.getPaddingRight(), this.eOC.getPaddingBottom());
                    } else {
                        this.eOC.setPadding(this.eOC.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds48), this.eOC.getPaddingRight(), this.eOC.getPaddingBottom());
                    }
                }
            }
            this.eFK = z;
            bj aOX = fVar.aOX();
            if (aOX != null) {
                a(aOX.rA());
            }
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            aTi();
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
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPi()));
            sparseArray.put(d.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (b.getAuthor() != null) {
                sparseArray.put(d.h.tag_forbid_user_name, b.getAuthor().getUserName());
                sparseArray.put(d.h.tag_forbid_user_post_id, b.getId());
            }
            sparseArray.put(d.h.tag_del_post_id, b.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPi()));
            sparseArray.put(d.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aIx;
    }

    public void pp(String str) {
        if (this.ctG != null) {
            this.ctG.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eOu;
    }

    public int aTj() {
        return d.h.richText;
    }

    public TextView aPW() {
        return this.eOB.aPW();
    }

    public void d(BdListView.e eVar) {
        this.eOu.setOnSrollToBottomListener(eVar);
    }

    public void a(k.b bVar) {
        this.anh = bVar;
        if (this.ePi != null) {
            this.ePi.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, a.b bVar) {
        if (arVar != null) {
            int qx = arVar.qx();
            int qu = arVar.qu();
            if (this.ePf != null) {
                this.ePf.to();
            } else {
                this.ePf = new com.baidu.tbadk.core.dialog.a(this.eGQ.getPageContext().getPageActivity());
                this.ePg = LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(d.j.dialog_direct_pager, (ViewGroup) null);
                this.ePf.v(this.ePg);
                this.ePf.a(d.l.dialog_ok, bVar);
                this.ePf.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.aDB();
                        aVar.dismiss();
                    }
                });
                this.ePf.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.eQv == null) {
                            an.this.eQv = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.eGQ.HidenSoftKeyPad((InputMethodManager) an.this.eGQ.getSystemService("input_method"), an.this.cca);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fQ().postDelayed(an.this.eQv, 150L);
                    }
                });
                this.ePf.b(this.eGQ.getPageContext()).to();
            }
            this.ePh = (EditText) this.ePg.findViewById(d.h.input_page_number);
            this.ePh.setText("");
            TextView textView = (TextView) this.ePg.findViewById(d.h.current_page_number);
            if (qx <= 0) {
                qx = 1;
            }
            if (qu <= 0) {
                qu = 1;
            }
            textView.setText(MessageFormat.format(this.eGQ.getApplicationContext().getResources().getString(d.l.current_page), Integer.valueOf(qx), Integer.valueOf(qu)));
            this.eGQ.ShowSoftKeyPadDelay(this.ePh, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eOu.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eGQ.showToast(str);
    }

    public boolean jK(boolean z) {
        if (this.Jp == null || !this.Jp.CY()) {
            return false;
        }
        this.Jp.Bp();
        return true;
    }

    public void aTk() {
        if (this.eQZ != null) {
            while (this.eQZ.size() > 0) {
                TbImageView remove = this.eQZ.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aTk();
        this.ePe.pm(1);
        if (this.eOl != null) {
            this.eOl.onPause();
        }
    }

    public void onResume() {
        this.ePe.pm(2);
        if (this.eOl != null) {
            this.eOl.onResume();
        }
        if (this.eQl != null) {
            this.eQl.onResume();
        }
    }

    public void onDestroy() {
        this.eQy.ZD();
        if (this.eOn != null) {
            this.eOn.ZD();
        }
        if (this.eOm != null) {
            this.eOm.onDestroy();
        }
        this.eGQ.hideProgressBar();
        if (this.bIw != null && this.bIz != null) {
            this.bIw.b(this.bIz);
        }
        aDB();
        wW();
        if (this.eQv != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.eQv);
        }
        if (this.eQw != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.eQw);
        }
        if (this.eQL != null) {
            this.eQL.removeAllViews();
        }
        if (this.eOC != null && this.eOR != null) {
            this.eOC.removeView(this.eOK);
            this.eOR = null;
        }
        if (this.eQa != null) {
            this.eQa.clearStatus();
        }
        this.eQR = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.ePe.pm(3);
        if (this.ceh != null) {
            this.ceh.setBackgroundDrawable(null);
        }
        if (this.eOl != null) {
            this.eOl.destroy();
        }
        if (this.ePe != null) {
            this.ePe.onDestory();
        }
        this.eOu.setOnLayoutListener(null);
        this.cca.getViewTreeObserver().removeGlobalOnLayoutListener(this.eRa);
    }

    public boolean py(int i) {
        if (this.eOl != null) {
            return this.eOl.jc(i);
        }
        return false;
    }

    public void aDB() {
        this.eOq.ol();
        this.eQy.ZD();
        if (this.eOn != null) {
            this.eOn.ZD();
        }
        com.baidu.adp.lib.util.k.a(this.eGQ.getPageContext().getPageActivity(), this.ePh);
        aSC();
        if (this.ePE != null) {
            this.ePE.dismiss();
        }
        aTl();
        if (this.eOm != null) {
            this.eOm.aVN();
        }
        if (this.ePf != null) {
            this.ePf.dismiss();
        }
        if (this.cqE != null) {
            this.cqE.dismiss();
        }
    }

    public void iS(boolean z) {
        this.ePe.iS(z);
    }

    public void hs(boolean z) {
        this.dSf = z;
    }

    public void aTl() {
        if (this.ePn != null) {
            this.ePn.dismiss();
        }
        if (this.ePo != null) {
            com.baidu.adp.lib.g.g.b(this.ePo, this.eGQ.getPageContext());
        }
        if (this.ePx != null) {
            com.baidu.adp.lib.g.g.b(this.ePx, this.eGQ.getPageContext());
        }
        if (this.ePl != null) {
            com.baidu.adp.lib.g.g.b(this.ePl, this.eGQ.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.eLs, this.eFK);
            d(this.eLs, this.eFK, this.mType);
            this.eGQ.getLayoutMode().ah(i == 1);
            this.eGQ.getLayoutMode().t(this.cca);
            this.eGQ.getLayoutMode().t(this.eOz);
            this.eGQ.getLayoutMode().t(this.eOA);
            this.eGQ.getLayoutMode().t(this.eOw);
            if (this.eOP != null) {
                com.baidu.tbadk.core.util.aj.c(this.eOP, d.e.cp_cont_d, 1);
            }
            if (this.eOO != null) {
                com.baidu.tbadk.core.util.aj.c(this.eOO, d.e.cp_cont_d, 1);
            }
            if (this.eOm != null) {
                this.eOm.onChangeSkinType(i);
            }
            this.eGQ.getLayoutMode().t(this.eOw);
            com.baidu.tbadk.core.util.aj.i(this.eOz, d.e.cp_cont_b);
            this.eOz.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            this.eGQ.getLayoutMode().t(this.aIx);
            if (this.ePg != null) {
                this.eGQ.getLayoutMode().t(this.ePg);
            }
            jJ(this.ePG);
            this.ePe.notifyDataSetChanged();
            if (this.ePi != null) {
                this.ePi.dq(i);
            }
            if (this.ctG != null) {
                this.ctG.dq(i);
                com.baidu.tbadk.core.util.aj.j(this.aIx, d.g.pb_foot_more_trans_selector);
                this.ctG.m10do(d.g.pb_foot_more_trans_selector);
            }
            if (this.Jp != null) {
                this.Jp.onChangeSkinType(i);
            }
            if (this.eOQ != null) {
                this.eOQ.du(i);
            }
            if (this.ePj != null) {
                this.ePj.dq(i);
            }
            if (this.eOv != null && this.eOv.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eOv) {
                    aVar.aUo();
                }
            }
            if (this.eQL != null) {
                com.baidu.tbadk.core.util.aj.k(this.eQL, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.k(this.eQJ, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(this.eQK, d.e.cp_cont_c, 1);
            }
            aO(i == 1);
            aSN();
            UtilHelper.setStatusBarBackground(this.ceh, i);
            UtilHelper.setStatusBarBackground(this.eQf, i);
            if (this.eOS != null) {
                this.eOS.onChangeSkinType(i);
            }
            if (this.bHp != null) {
                com.baidu.tbadk.core.util.aj.i(this.bHp, d.e.cp_cont_j);
            }
            if (this.eOV != null) {
                com.baidu.tbadk.core.util.aj.i(this.eOV, d.e.cp_cont_j);
            }
            if (this.eOW != null) {
                com.baidu.tbadk.core.util.aj.j(this.eOW, d.e.cp_cont_e);
            }
            if (this.eOH != null) {
                com.baidu.tbadk.core.util.aj.i(this.eOH, d.e.cp_link_tip_a);
            }
            if (this.eOU != null) {
                com.baidu.tbadk.core.util.aj.i(this.eOU, d.e.cp_cont_j);
            }
            if (this.eOX != null) {
                com.baidu.tbadk.o.a.a(this.eGQ.getPageContext(), this.eOX);
            }
            if (this.eQx != null) {
                this.eQx.onChangeSkinType(i);
            }
            if (this.eOq != null) {
                if (this.eOl != null) {
                    this.eOl.pK(i);
                } else {
                    this.eOq.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.aj.i(this.eOF, d.e.cp_cont_j);
            if (this.eOG != null) {
                com.baidu.tbadk.core.util.aj.j(this.eOG, d.e.cp_cont_e);
            }
            this.mSkinType = i;
            if (this.ePL != null) {
                com.baidu.tbadk.core.util.aj.i(this.ePL, d.e.cp_cont_e);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRy = eVar;
        this.ePe.setOnImageClickListener(this.aRy);
    }

    public void c(NoNetworkView.a aVar) {
        this.bIz = aVar;
        if (this.bIw != null) {
            this.bIw.a(this.bIz);
        }
    }

    public void jL(boolean z) {
        this.ePe.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aTm() {
        return this.ePJ;
    }

    public void aTn() {
        if (this.eOp != 2) {
            this.eOu.setNextPage(this.ctG);
            this.eOp = 2;
        }
    }

    public void aTo() {
        if (com.baidu.tbadk.l.r.Gx().Gy()) {
            int lastVisiblePosition = this.eOu.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eOu.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog = tbImageView.getPerfLog();
                                perfLog.fi(1001);
                                perfLog.aJF = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst().getContext())) {
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
                        perfLog2.aJF = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.wy();
                    }
                }
            }
        }
    }

    public void ht(boolean z) {
        if (this.ePK != null) {
            if (this.dSf) {
                hu(z);
            } else {
                hv(z);
            }
        }
    }

    public void aTp() {
        if (this.ePK != null) {
            this.ePK.setVisibility(8);
            this.ePQ = false;
            if (this.eQl != null) {
                this.eQl.setVisibility(8);
                jH(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.bpe == null) {
            this.bpe = new com.baidu.tbadk.core.view.a(this.eGQ.getPageContext());
        }
        this.bpe.aH(true);
    }

    public void RV() {
        if (this.bpe != null) {
            this.bpe.aH(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eOu.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eOu.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eOl != null) {
            this.eOl.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eRb = getScrollY();
            this.eQk.eRp = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eQk));
            a(this.eQk.eRp, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        this.eQE = false;
        if (this.eOl != null) {
            this.eOl.b(absListView, i);
        }
        int headerViewsCount = (i - this.eOu.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.ePe.pl(headerViewsCount) != com.baidu.tieba.pb.data.l.eER) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.ePe.aRe().jC(z);
        this.eQk.eRn = i;
        this.eQk.eRo = this.eOu.getHeaderViewsCount();
        this.eQk.eRp = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.eQk));
        a(this.eQk.eRp, false);
    }

    private void a(ah ahVar, boolean z) {
        int measuredHeight;
        if (!this.eQB && this.eQe != null && this.eOq.aUr() != null) {
            int aRc = this.ePe.aRc();
            if (aRc > 0 && (ahVar == null || ahVar.getView().getParent() == null)) {
                if (aRc > this.eOu.getFirstVisiblePosition() - this.eOu.getHeaderViewsCount()) {
                    this.eQe.setVisibility(8);
                } else {
                    this.eQe.setVisibility(0);
                }
            } else if (ahVar != null && ahVar.getView() != null && ahVar.eNQ != null) {
                int top = ahVar.getView().getTop();
                if (ahVar.getView().getParent() != null) {
                    if (this.eQj) {
                        this.eQi = top;
                        this.eQj = false;
                    }
                    this.eQi = top < this.eQi ? top : this.eQi;
                }
                if (top != 0 || ahVar.getView().isShown()) {
                    if (this.ePd.getY() < 0.0f) {
                        measuredHeight = eQh - ahVar.eNQ.getMeasuredHeight();
                    } else {
                        measuredHeight = this.eOq.aUr().getMeasuredHeight() - ahVar.eNQ.getMeasuredHeight();
                    }
                    if (ahVar.getView().getParent() == null && top <= this.eQi) {
                        this.eQe.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.eQe.setVisibility(0);
                    } else {
                        this.eQe.setVisibility(8);
                    }
                    if (z) {
                        this.eQj = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int eRn;
        public int eRo;
        public ah eRp;

        public a() {
        }
    }

    public void aTq() {
        if (!this.eRc) {
            TiebaStatic.log("c10490");
            this.eRc = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGQ.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eQp, Integer.valueOf(eQr));
            aVar.cb(d.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.h.function_description_view)).setText(d.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.h.title_view)).setText(d.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.z(sparseArray);
            aVar.a(d.l.grade_button_tips, this.eGQ);
            aVar.b(d.l.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eGQ.getPageContext()).to();
        }
    }

    public void pq(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGQ.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eQp, Integer.valueOf(eQs));
        aVar.z(sparseArray);
        aVar.a(d.l.view, this.eGQ);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eGQ.getPageContext()).to();
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

    public PbInterviewStatusView aTr() {
        return this.eQa;
    }

    private void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aOX() != null && fVar.aOX().st() && this.eQa == null) {
            this.eQa = (PbInterviewStatusView) this.ePZ.inflate();
            this.eQa.setOnClickListener(this.cqF);
            this.eQa.setCallback(this.eGQ.aQI());
            this.eQa.b(this.eGQ, fVar);
        }
    }

    public LinearLayout aTs() {
        return this.ePd;
    }

    public View aTt() {
        return this.ceh;
    }

    public boolean aTu() {
        return this.eQM;
    }

    public void iX(boolean z) {
        this.eOB.iX(z);
    }

    private void aTv() {
        if (this.eQM) {
            if (this.eQN == null) {
                d.a aVar = d.eGT.get();
                if (aVar != null) {
                    this.eQN = aVar.a(this.eGQ);
                    ListAdapter adapter = this.eOu.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.axS) {
                            this.eOu.addHeaderView(this.eQN.aPU(), 1);
                        } else {
                            this.eOu.addHeaderView(this.eQN.aPU(), 0);
                        }
                    }
                } else {
                    this.eOA.setVisibility(0);
                    return;
                }
            }
            this.eOA.setVisibility(8);
            this.eOu.removeHeaderView(this.eOA);
            return;
        }
        this.eOA.setVisibility(0);
    }

    public void jM(boolean z) {
        this.eQM = z;
    }

    public void aTw() {
        this.eGQ.showNetRefreshView(getView(), "");
        View EO = this.eGQ.getRefreshView().EO();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EO.getLayoutParams();
        layoutParams.addRule(3, aTs().getId());
        EO.setLayoutParams(layoutParams);
        this.eGQ.hideLoadingView(getView());
        if (this.eQN != null) {
            this.eOu.removeHeaderView(this.eQN.aPU());
            this.eQN = null;
        }
    }

    public void pr(String str) {
        if (this.eOr != null) {
            this.eOr.setTitle(str);
        }
    }

    private int jN(boolean z) {
        if (this.eQa == null || this.eQa.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds72);
    }

    private void aTx() {
        if (this.eQa != null && this.eQa.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQa.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eQa.setLayoutParams(layoutParams);
        }
    }

    public boolean aQd() {
        return false;
    }

    public TextView aTy() {
        return this.eOP;
    }

    public void ps(String str) {
        this.ePL.performClick();
        if (!StringUtils.isNull(str) && this.eGQ.aPX() != null && this.eGQ.aPX().Dv() != null && this.eGQ.aPX().Dv().Do() != null) {
            EditText Do = this.eGQ.aPX().Dv().Do();
            Do.setText(str);
            Do.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aDB();
            aTp();
            aSC();
            if (this.eQx != null) {
                this.eQx.aRi();
            }
            this.eGQ.ahd();
            this.ePd.setVisibility(8);
            this.eOq.setTitleVisibility(false);
            this.eGQ.jd(false);
            if (this.eOl != null) {
                if (configuration.orientation == 1) {
                    aTs().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eOu.setIsLandscape(true);
                    this.eOu.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eOu.setIsLandscape(false);
                    if (this.eRb > 0) {
                        this.eOu.smoothScrollBy(this.eRb, 0);
                    }
                }
                this.eOl.onConfigurationChanged(configuration);
            }
        }
    }

    public void jO(boolean z) {
        this.eOo = z;
    }

    public boolean aTz() {
        return this.eOl != null && this.eOl.aTz();
    }

    public void aTA() {
        if (this.eOl != null) {
            this.eOl.onPause();
        }
    }

    public void w(long j, int i) {
        if (this.eOm != null) {
            this.eOm.w(j, i);
        }
        if (this.eOl != null) {
            this.eOl.w(j, i);
        }
    }

    public void aTB() {
        if (this.eQl != null) {
            this.eQl.aUm();
        }
    }

    public void aTC() {
        if (this.eQl != null) {
            this.eQl.setVisibility(8);
            jH(false);
        }
    }

    public void ji(boolean z) {
        this.ePe.ji(z);
    }

    public void aTD() {
        if (this.eQb == null) {
            LayoutInflater.from(this.eGQ.getActivity()).inflate(d.j.add_experienced_text, (ViewGroup) this.cca, true);
            this.eQb = (ViewGroup) this.cca.findViewById(d.h.add_experienced_layout);
            this.eQc = (TextView) this.cca.findViewById(d.h.add_experienced);
            com.baidu.tbadk.core.util.aj.i(this.eQc, d.e.cp_cont_i);
            String string = this.eGQ.getResources().getString(d.l.experienced_add_success);
            String string2 = this.eGQ.getResources().getString(d.l.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_h)));
            this.eQc.setText(spannableString);
        }
        this.eQb.setVisibility(0);
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
                        an.this.eQb.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                an.this.eQc.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eQc.startAnimation(scaleAnimation);
    }
}
