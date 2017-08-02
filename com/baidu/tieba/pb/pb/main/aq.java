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
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.k;
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
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class aq {
    public static int eOP = 2;
    public static int eOQ = 3;
    public static int eOR = 0;
    public static int eOS = 3;
    public static int eOT = 4;
    public static int eOU = 5;
    public static int eOV = 6;
    private com.baidu.tbadk.editortools.i JT;
    private View aHC;
    private com.baidu.tieba.pb.a.c aQB;
    private int aQb;
    private k.b amt;
    private TextView axo;
    private TextView bCB;
    private NoNetworkView bDI;
    private RelativeLayout bXk;
    private View bZx;
    private View.OnClickListener cjs;
    private View.OnClickListener eEm;
    private PbActivity eFn;
    PbActivity.c eHa;
    private UserIconBox eIV;
    private UserIconBox eIW;
    private com.baidu.tieba.pb.data.f eJQ;
    private PbFakeFloorModel eJt;
    public int eMP;
    private int eMQ;
    private int eMR;
    private int eMS;
    private com.baidu.tieba.pb.video.i eMU;
    private com.baidu.tieba.pb.video.h eMV;
    private com.baidu.tieba.d.b eMW;
    public final com.baidu.tieba.pb.pb.main.view.d eMZ;
    private PbFirstFloorUserLikeButton eNC;
    private ao eND;
    private TextView eNE;
    private TextView eNF;
    private LinearLayout eNG;
    private TextView eNH;
    private TextView eNI;
    private View eNJ;
    private View eNK;
    private ObservedChangeLinearLayout eNM;
    private g eNN;
    private PbListView eNS;
    private View eNU;
    public com.baidu.tieba.pb.pb.main.view.c eNa;
    private ViewStub eNb;
    private ViewStub eNc;
    private PbLandscapeListView eNd;
    private List<com.baidu.tieba.pb.pb.main.view.a> eNe;
    private View eNf;
    private LinearLayout eNj;
    private TextView eNk;
    private View eNl;
    private e eNm;
    private ColumnLayout eNn;
    private ThreadSkinView eNo;
    private TextView eNp;
    private TextView eNq;
    private TextView eNr;
    private ImageView eNs;
    private HeadPendantView eNt;
    private FrameLayout eNu;
    private HeadImageView eNv;
    private View eNw;
    private FloatingLayout eNx;
    private boolean eOB;
    private int eOC;
    private int eOD;
    private int eOE;
    private PostData eOF;
    private View eOH;
    private TextView eOI;
    private ViewStub eOJ;
    private PbInterviewStatusView eOK;
    private ViewGroup eOL;
    private TextView eOM;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eON;
    private Runnable eOW;
    private Runnable eOX;
    private q eOY;
    private com.baidu.tieba.d.b eOZ;
    private View eOv;
    private TextView eOw;
    private ViewGroup eOx;
    private TextView eOz;
    private int ePB;
    private View ePj;
    private TextView ePk;
    private LinearLayout ePl;
    private boolean ePm;
    private d ePn;
    private com.baidu.tbadk.core.view.userLike.c ePo;
    private com.baidu.tbadk.core.view.userLike.c ePp;
    private Runnable ePs;
    private PbActivity.a ePu;
    private boolean ePw;
    private boolean ePx;
    private boolean isLandscape;
    private int mType;
    private int eMT = 1;
    private boolean eMX = false;
    private int eMY = 0;
    private final Handler mHandler = new Handler();
    private View eNg = null;
    private LinearLayout eNh = null;
    private TextView eNi = null;
    private TextView eNy = null;
    private TextView eNz = null;
    public FrsPraiseView eNA = null;
    private ClickableHeaderImageView eNB = null;
    private View eNL = null;
    private com.baidu.tbadk.core.dialog.a eNO = null;
    private com.baidu.tbadk.core.dialog.b cjr = null;
    private View eNP = null;
    private EditText eNQ = null;
    private com.baidu.tieba.pb.view.j eNR = null;
    private com.baidu.tieba.pb.view.b eNT = null;
    private b.InterfaceC0043b dqE = null;
    private TbRichTextView.e aQA = null;
    private NoNetworkView.a bDL = null;
    private Dialog eNV = null;
    private View eNW = null;
    private com.baidu.tbadk.core.dialog.a eNX = null;
    private Dialog eNY = null;
    private View eNZ = null;
    private int eOa = 0;
    private RadioGroup eOb = null;
    private RadioButton eOc = null;
    private RadioButton eOd = null;
    private RadioButton eOe = null;
    private Button eOf = null;
    private Button eOg = null;
    private TextView eOh = null;
    private Dialog eOi = null;
    private View eOj = null;
    private LinearLayout eOk = null;
    private CompoundButton.OnCheckedChangeListener eOl = null;
    private TextView eOm = null;
    private TextView eOn = null;
    private String eOo = null;
    private com.baidu.tbadk.core.dialog.b eOp = null;
    private com.baidu.tbadk.core.dialog.b eOq = null;
    private boolean eOr = false;
    private boolean eOs = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eOt = null;
    private boolean dIn = false;
    private Button eOu = null;
    public ImageView eOy = null;
    private boolean eOA = true;
    private com.baidu.tbadk.core.view.a bmO = null;
    private boolean eEi = false;
    private int mSkinType = 3;
    private boolean eOG = false;
    private boolean mIsFromCDN = true;
    private int eOO = 0;
    private float ePa = -1.0f;
    private int ePb = -1;
    private boolean ePc = false;
    private a.InterfaceC0119a ePd = new a.InterfaceC0119a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0119a
        public void kZ() {
        }
    };
    private boolean eFV = false;
    private boolean ePe = false;
    private LinearLayout ePf = null;
    private TextView ePg = null;
    private int ePh = 0;
    private boolean ePi = false;
    private boolean ePq = false;
    private int rank = 0;
    private CustomMessageListener dCW = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aq.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.eNN != null) {
                aq.this.eNN.notifyDataSetChanged();
            }
        }
    };
    private Handler ePr = new Handler();
    private CustomMessageListener ePt = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.aq.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.eOA = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean ePv = true;
    private boolean ePy = false;
    private boolean YO = false;
    String userId = null;
    private final List<TbImageView> ePz = new ArrayList();
    private ViewTreeObserver.OnGlobalLayoutListener ePA = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.pb.main.aq.18
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            aq.this.aSL();
        }
    };
    private boolean ePC = false;

    public void i(int i, float f) {
        this.ePb = i;
        this.ePa = f;
    }

    public d aSD() {
        return this.ePn;
    }

    public NoNetworkView aSE() {
        return this.bDI;
    }

    public void aSF() {
        if (this.JT != null) {
            this.JT.hide();
        }
    }

    public PbFakeFloorModel aSG() {
        return this.eJt;
    }

    public q aSH() {
        return this.eOY;
    }

    public void aSI() {
        reset();
        aSF();
        this.eOY.aRe();
        hi(false);
    }

    private void reset() {
        if (this.eFn != null && this.eFn.aPX() != null && this.JT != null) {
            com.baidu.tbadk.editortools.pb.a.Do().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aPX = this.eFn.aPX();
            aPX.DI();
            if (aPX.getWriteImagesInfo() != null) {
                aPX.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aPX.eL(10);
            aPX.eJ(SendView.ALL);
            aPX.eK(SendView.ALL);
            com.baidu.tbadk.editortools.l eA = this.JT.eA(23);
            com.baidu.tbadk.editortools.l eA2 = this.JT.eA(2);
            com.baidu.tbadk.editortools.l eA3 = this.JT.eA(5);
            if (eA2 != null) {
                eA2.lJ();
            }
            if (eA3 != null) {
                eA3.lJ();
            }
            if (eA != null) {
                eA.hide();
            }
            this.JT.invalidate();
        }
    }

    public boolean aSJ() {
        return this.eOA;
    }

    public void hj(boolean z) {
        if (this.eOv != null && this.eOw != null) {
            this.eOw.setText(d.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eOv.startAnimation(alphaAnimation);
            }
            this.eOv.setVisibility(0);
            this.eOA = true;
            if (this.eON != null) {
                this.eON.setVisibility(0);
            }
        }
    }

    public void hk(boolean z) {
        if (this.eOv != null && this.eOw != null) {
            this.eOw.setText(d.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eOv.startAnimation(alphaAnimation);
            }
            this.eOv.setVisibility(0);
            this.eOA = true;
            if (this.eON != null) {
                this.eON.setVisibility(0);
            }
        }
    }

    public PostData aSK() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.eNd == null) {
            return null;
        }
        int firstVisiblePosition = this.eNd.getFirstVisiblePosition();
        int lastVisiblePosition = this.eNd.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eNd.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.eNd.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.eNd.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.eNN.oV(headerViewsCount) != null && this.eNN.oV(headerViewsCount) != PostData.ggC) {
            i2 = headerViewsCount + 1;
        }
        return this.eNN.getItem(i2) instanceof PostData ? (PostData) this.eNN.getItem(i2) : null;
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.aQb = 0;
        this.eMQ = 0;
        this.eMR = 0;
        this.eMS = 0;
        this.eFn = null;
        this.bXk = null;
        this.bZx = null;
        this.eNd = null;
        this.eNf = null;
        this.eNj = null;
        this.eNk = null;
        this.eNl = null;
        this.eNn = null;
        this.eNp = null;
        this.eNr = null;
        this.eNu = null;
        this.eNv = null;
        this.eNw = null;
        this.eNC = null;
        this.eNE = null;
        this.eNF = null;
        this.bCB = null;
        this.eNJ = null;
        this.eNK = null;
        this.eNN = null;
        this.eNS = null;
        this.aHC = null;
        this.cjs = null;
        this.eEm = null;
        this.eOv = null;
        this.eOw = null;
        this.eOx = null;
        this.eOz = null;
        this.eOH = null;
        this.eOI = null;
        this.eOJ = null;
        this.eFn = pbActivity;
        this.cjs = onClickListener;
        this.aQB = cVar;
        this.bXk = (RelativeLayout) LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.new_pb_activity, (ViewGroup) null);
        this.bXk.getViewTreeObserver().addOnGlobalLayoutListener(this.ePA);
        this.eFn.addContentView(this.bXk, new FrameLayout.LayoutParams(-1, -1));
        this.bZx = this.eFn.findViewById(d.h.statebar_view);
        this.eNM = (ObservedChangeLinearLayout) this.eFn.findViewById(d.h.title_wrapper);
        this.bDI = (NoNetworkView) this.eFn.findViewById(d.h.view_no_network);
        this.eNd = (PbLandscapeListView) this.eFn.findViewById(d.h.new_pb_list);
        this.axo = new TextView(this.eFn.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eFn.getActivity(), d.f.ds98));
        this.eNd.addHeaderView(this.axo, 0);
        View view = new View(this.eFn.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.eFn.getResources().getDimensionPixelSize(d.f.ds100)));
        view.setVisibility(4);
        this.eNd.addFooterView(view);
        this.eNd.setOnTouchListener(this.eFn.aLD);
        this.eMZ = new com.baidu.tieba.pb.pb.main.view.d(pbActivity);
        this.eOZ = new com.baidu.tieba.d.b(pbActivity.getPageContext(), this.eMZ.eTj);
        this.eOZ.hK(1);
        if (this.eFn.aQy()) {
            this.eNb = (ViewStub) this.eFn.findViewById(d.h.manga_view_stub);
            this.eNb.setVisibility(0);
            this.eNa = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
            this.eNa.show();
            this.eMZ.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.axo.setLayoutParams(layoutParams);
        this.eMZ.aUu().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0108a() { // from class: com.baidu.tieba.pb.pb.main.aq.6
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0108a
            public void afT() {
                if (aq.this.eNd != null) {
                    if (aq.this.eMU != null) {
                        aq.this.eMU.aVU();
                    }
                    aq.this.eNd.smoothScrollToPosition(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0108a
            public void afS() {
                aq.this.eFn.afk();
            }
        }));
        this.eOv = this.eFn.findViewById(d.h.pb_editor_tool_comment);
        this.eOC = com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds110);
        this.eOD = com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds156);
        this.eOE = this.eOC;
        this.eOw = (TextView) this.eFn.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_text);
        this.eOx = (ViewGroup) this.eFn.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_layout);
        this.eOz = (TextView) this.eFn.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_praise_icon);
        this.eOz.setVisibility(8);
        this.eOx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!aq.this.eFn.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", aq.this.mForumId));
                } else if (aq.this.eJQ == null || !com.baidu.tieba.pb.f.T(aq.this.eJQ.aOY())) {
                    if (aq.this.JT != null) {
                        aq.this.aSU();
                    }
                    if (aq.this.JT != null) {
                        aq.this.eOA = false;
                        com.baidu.tieba.tbadkCore.b.a.a(aq.this.eFn, (View) aq.this.JT.eC(2).aAL, false, aq.this.ePd);
                    }
                    aq.this.aTr();
                }
            }
        });
        this.eOz.setOnClickListener(this.cjs);
        this.eOz.setOnTouchListener(this.eFn);
        this.eNf = LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_item, (ViewGroup) null);
        this.eNj = (LinearLayout) LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_user_item, (ViewGroup) null);
        this.eNm = new e(this.eFn, this.eNj);
        this.eNm.init();
        this.eNm.b(this.eNm.aPW(), this.cjs);
        this.eNn = (ColumnLayout) this.eNj.findViewById(d.h.pb_head_owner_root);
        this.eNo = (ThreadSkinView) this.eNj.findViewById(d.h.pb_thread_skin);
        this.eNn.setOnLongClickListener(this.onLongClickListener);
        this.eNn.setOnTouchListener(this.aQB);
        this.eNn.setVisibility(8);
        this.eNf.setOnTouchListener(this.aQB);
        this.eOH = this.eNf.findViewById(d.h.pb_head_activity_join_number_container);
        this.eOH.setVisibility(8);
        this.eOI = (TextView) this.eNf.findViewById(d.h.pb_head_activity_join_number);
        this.eNp = (TextView) this.eNn.findViewById(d.h.pb_head_owner_info_user_name);
        this.eNq = (TextView) this.eNj.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eNr = (TextView) this.eNn.findViewById(d.h.floor_owner);
        this.eNs = (ImageView) this.eNn.findViewById(d.h.icon_forum_level);
        this.eNu = (FrameLayout) this.eNn.findViewById(d.h.pb_head_headImage_container);
        this.eNv = (HeadImageView) this.eNn.findViewById(d.h.pb_head_owner_photo);
        this.eNt = (HeadPendantView) this.eNn.findViewById(d.h.pb_pendant_head_owner_photo);
        this.eNt.wt();
        if (this.eNt.getHeadView() != null) {
            this.eNt.getHeadView().setIsRound(true);
            this.eNt.getHeadView().setDrawBorder(false);
        }
        if (this.eNt.getPendantView() != null) {
            this.eNt.getPendantView().setIsRound(true);
            this.eNt.getPendantView().setDrawBorder(false);
        }
        this.eIV = (UserIconBox) this.eNn.findViewById(d.h.show_icon_vip);
        this.eIW = (UserIconBox) this.eNn.findViewById(d.h.show_icon_yinji);
        this.eNx = (FloatingLayout) this.eNj.findViewById(d.h.pb_head_owner_info_root);
        this.eNC = (PbFirstFloorUserLikeButton) this.eNn.findViewById(d.h.pb_like_button);
        this.eND = new ao(pbActivity.getPageContext(), this.eNC, 1);
        this.eNE = (TextView) this.eNn.findViewById(d.h.pb_views);
        this.eNF = (TextView) this.eNn.findViewById(d.h.pb_item_first_floor_reply_time);
        this.bCB = (TextView) this.eNn.findViewById(d.h.pb_item_first_floor_location_address);
        this.ePo = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.ePp = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eNJ = this.eNf.findViewById(d.h.new_pb_header_item_line_above_livepost);
        this.eNl = LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.layout_read_thread, (ViewGroup) null);
        this.eNk = (TextView) this.eNl.findViewById(d.h.pb_head_read_button);
        this.eNj.addView(this.eNl);
        this.eNk.setOnClickListener(this.cjs);
        this.eMS = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds2);
        this.eMR = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds18);
        this.eMQ = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds20);
        this.aQb = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds32);
        this.eNK = this.eNf.findViewById(d.h.new_pb_header_item_line_below_livepost);
        this.eNf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.23
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return false;
            }
        });
        this.eOJ = (ViewStub) this.bXk.findViewById(d.h.interview_status_stub);
        this.eNN = new g(this.eFn, this.eNd);
        this.eNN.t(this.cjs);
        this.eNN.setTbGestureDetector(this.aQB);
        this.eNN.setOnImageClickListener(this.aQA);
        this.eEm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.Vh() || !com.baidu.tieba.c.a.a(aq.this.eFn.getBaseContext(), aq.this.eFn.aQc().getThreadID(), (String) sparseArray.get(d.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.h.tag_from, 1);
                                aq.this.eFn.d(sparseArray);
                                return;
                            }
                            aq.this.bf(view2);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.h.tag_from, 0);
                        sparseArray.put(d.h.tag_check_mute_from, 1);
                        aq.this.eFn.d(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.eNN.G(this.eEm);
        aSO();
        this.eNd.addHeaderView(this.eNh);
        this.eNd.addHeaderView(this.eNj);
        this.eNd.addHeaderView(this.eNf);
        this.eNS = new PbListView(this.eFn.getPageContext().getPageActivity());
        this.aHC = this.eNS.getView().findViewById(d.h.pb_more_view);
        if (this.aHC != null) {
            this.aHC.setOnClickListener(this.cjs);
            com.baidu.tbadk.core.util.ai.j(this.aHC, d.g.pb_foot_more_trans_selector);
        }
        this.eNS.wJ();
        this.eNS.dl(d.g.pb_foot_more_trans_selector);
        this.eNS.dm(d.g.pb_foot_more_trans_selector);
        this.eNU = this.eFn.findViewById(d.h.viewstub_progress);
        this.eFn.registerListener(this.ePt);
        this.eNw = com.baidu.tbadk.ala.b.ns().h(this.eFn.getActivity(), 2);
        if (this.eNw != null) {
            this.eNw.setVisibility(8);
            this.eNx.addView(this.eNw);
        }
        this.eJt = new PbFakeFloorModel(this.eFn.getPageContext());
        this.eOY = new q(this.eFn.getPageContext(), this.eJt, this.bXk);
        this.eJt.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.25
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                aq.this.eJt.m(postData);
                aq.this.eNN.notifyDataSetChanged();
                aq.this.eOY.aRe();
            }
        });
        if (this.eFn.aQc() != null && !StringUtils.isNull(this.eFn.aQc().aRS())) {
            this.eFn.showToast(this.eFn.aQc().aRS());
        }
        this.eFn.registerListener(this.dCW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSL() {
        if (this.eON != null) {
            int[] iArr = new int[2];
            this.eOv.getLocationOnScreen(iArr);
            this.eON.setBottomMargin((((ViewGroup) this.eFn.getPageContext().getPageActivity().getWindow().getDecorView()).getHeight() - this.eOE) - iArr[1]);
        }
    }

    public void aSM() {
        if (this.eNd != null) {
            this.eNd.removeHeaderView(this.eNh);
            this.eNd.removeHeaderView(this.eNj);
            this.eNd.removeHeaderView(this.eNf);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eON == null) {
            this.eON = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eFn.getPageContext().getPageActivity());
            ViewGroup viewGroup = (ViewGroup) this.eFn.getPageContext().getPageActivity().getWindow().getDecorView();
            int[] iArr = new int[2];
            this.eOv.getLocationOnScreen(iArr);
            this.eON.a(viewGroup, (viewGroup.getHeight() - this.eOC) - iArr[1], aVar);
            this.eON.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.26
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void cD(List<String> list) {
                    aq.this.eFn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(aq.this.eFn.getPageContext().getPageActivity(), 25016, (ArrayList) list)));
                }
            });
            this.eON.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.aq.27
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void ag(float f) {
                    if (aq.this.eOv != null) {
                        ViewGroup.LayoutParams layoutParams = aq.this.eOv.getLayoutParams();
                        layoutParams.height = (int) (((aq.this.eOD - aq.this.eOC) * f) + aq.this.eOC);
                        aq.this.eOx.setAlpha(1.0f - f);
                        aq.this.eOv.setLayoutParams(layoutParams);
                        aq.this.eOE = layoutParams.height;
                    }
                }
            });
        }
    }

    private boolean l(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aOY() == null || !fVar.aPs() || !TbadkCoreApplication.getInst().isTTSCanUse() || fVar.aOY().rs() == 1 || fVar.aOY().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aOY().ru() == null || fVar.aOY().ru().sU() == 0) && !fVar.aOY().sn()) {
            BdUniqueId type = fVar.aOY().getType();
            return type == bl.XE || type == bl.XG || type == bl.XD;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.eNl != null) {
            if (!z) {
                this.eNl.setVisibility(8);
            } else if (!l(fVar)) {
                this.eNl.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aPa() != null && fVar.aPa().size() > 0) {
                    postData = fVar.aPa().get(0);
                }
                if (postData != null && postData.bsr() == 1) {
                    s(this.aQb, this.eMR, this.aQb, this.eMS);
                } else {
                    s(this.aQb, this.eMR, this.aQb, this.eMQ);
                }
                this.eNl.setVisibility(0);
            }
        }
    }

    private void s(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNk.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.eNk.setLayoutParams(layoutParams);
    }

    public TextView aSN() {
        return this.eNk;
    }

    private void aSO() {
        if (this.eNh == null) {
            int g = com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds34);
            this.eNh = new LinearLayout(this.eFn.getPageContext().getPageActivity());
            this.eNh.setOrientation(1);
            this.eNh.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eNh.setPadding(g, com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds40), g, com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds46));
            this.eNh.setGravity(17);
            this.eNi = new TextView(this.eFn.getPageContext().getPageActivity());
            this.eNi.setGravity(3);
            this.eNi.setMaxLines(2);
            this.eNi.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            this.eNi.setPadding(0, 0, 0, 0);
            this.eNi.setLineSpacing(com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.ai.i(this.eNi, d.e.cp_cont_b);
            this.eNi.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds48));
            this.eNi.setVisibility(8);
            this.eNh.addView(this.eNi);
            this.eNh.setOnTouchListener(this.aQB);
            this.eNh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSP() {
        if (this.eFn.aQy()) {
            this.eNc = (ViewStub) this.eFn.findViewById(d.h.manga_mention_controller_view_stub);
            this.eNc.setVisibility(0);
            if (this.eNG == null) {
                this.eNG = (LinearLayout) this.eFn.findViewById(d.h.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.eFn.getPageContext(), this.eNG);
            }
            if (this.eNH == null) {
                this.eNH = (TextView) this.eNG.findViewById(d.h.manga_prev_btn);
            }
            if (this.eNI == null) {
                this.eNI = (TextView) this.eNG.findViewById(d.h.manga_next_btn);
            }
            this.eNH.setOnClickListener(this.cjs);
            this.eNI.setOnClickListener(this.cjs);
        }
    }

    private void aSQ() {
        if (this.eFn.aQy()) {
            if (this.eFn.aQB() == -1) {
                com.baidu.tbadk.core.util.ai.c(this.eNH, d.e.cp_cont_e, 1);
            }
            if (this.eFn.aQC() == -1) {
                com.baidu.tbadk.core.util.ai.c(this.eNI, d.e.cp_cont_e, 1);
            }
        }
    }

    public void aSR() {
        if (this.eNG == null) {
            aSP();
        }
        this.eNc.setVisibility(8);
        if (this.ePr != null && this.ePs != null) {
            this.ePr.removeCallbacks(this.ePs);
        }
    }

    public void aSS() {
        if (this.ePr != null) {
            if (this.ePs != null) {
                this.ePr.removeCallbacks(this.ePs);
            }
            this.ePs = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.eNG == null) {
                        aq.this.aSP();
                    }
                    aq.this.eNc.setVisibility(0);
                }
            };
            this.ePr.postDelayed(this.ePs, 2000L);
        }
    }

    public void jD(boolean z) {
        this.eMZ.jD(z);
        if (z && this.eOG) {
            this.eNS.setText(this.eFn.getResources().getString(d.l.click_load_more));
            this.eNd.setNextPage(this.eNS);
            this.eMY = 2;
        }
    }

    public void aST() {
        TbadkCoreApplication.getInst().setReadThreadPlayerScreenMaxHeight(this.bXk.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.JT = iVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.bXk.addView(this.JT, layoutParams);
        this.JT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aSF();
    }

    public void aSU() {
        if (this.eFn != null && this.JT != null) {
            this.JT.lJ();
            aTr();
        }
    }

    public void T(String str, boolean z) {
        this.eOB = z;
        aO(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void aO(boolean z) {
        if (this.eOz != null) {
            if (this.eOB) {
                com.baidu.tbadk.core.util.ai.j(this.eOz, d.g.pb_praise_already_click_selector);
                this.eOz.setContentDescription(this.eFn.getResources().getString(d.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.ai.j(this.eOz, d.g.pb_praise_normal_click_selector);
            this.eOz.setContentDescription(this.eFn.getResources().getString(d.l.frs_item_praise_text));
        }
    }

    public TextView aSV() {
        return this.eOz;
    }

    public void jE(boolean z) {
        if (this.eNd != null && this.axo != null && this.bZx != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bZx.setVisibility(0);
                } else {
                    this.bZx.setVisibility(8);
                    this.eNd.removeHeaderView(this.axo);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.axo.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.axo.setLayoutParams(layoutParams);
                }
                aTj();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.axo.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jL(true);
                this.axo.setLayoutParams(layoutParams2);
            }
            aTj();
            aTA();
        }
    }

    public g aSW() {
        return this.eNN;
    }

    public void aSX() {
        if (this.eNN != null) {
            this.eNN.aQV();
        }
    }

    public void a(PbActivity.c cVar) {
        this.eHa = cVar;
    }

    private void a(bo boVar) {
        if (boVar == null || boVar.sU() == 0) {
            if (this.eOu != null) {
                this.eOu.setVisibility(8);
            }
            if (this.eNJ != null) {
                this.eNJ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eOu == null) {
            this.eFn.getLayoutMode().t(((ViewStub) this.eNf.findViewById(d.h.live_talk_layout)).inflate());
            this.eOu = (Button) this.eNf.findViewById(d.h.pb_head_function_manage_go_to_live_post);
            this.eNJ = this.eNf.findViewById(d.h.new_pb_header_item_line_above_livepost);
        }
        int sV = boVar.sV();
        String string = this.eFn.getPageContext().getString(d.l.go_to_live_post_prefix);
        if (sV == 0) {
            string = string + this.eFn.getPageContext().getString(d.l.go_to_interview_post);
        } else if (sV == 1) {
            string = string + this.eFn.getPageContext().getString(d.l.go_to_discuss_post);
        }
        this.eOu.setText(string);
        this.eOu.setVisibility(0);
        this.eOu.setOnClickListener(this.cjs);
        this.ePx = true;
        aTk();
    }

    public void bf(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.eNW == null) {
            this.eNW = LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eFn.getLayoutMode().t(this.eNW);
        if (this.eNV == null) {
            this.eNV = new Dialog(this.eFn.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eNV.setCanceledOnTouchOutside(true);
            this.eNV.setCancelable(true);
            this.eNV.setContentView(this.eNW);
            WindowManager.LayoutParams attributes = this.eNV.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.eFn.getPageContext().getPageActivity()) * 0.9d);
            this.eNV.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eNV.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eNV.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eNV.findViewById(d.h.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eNV != null && (aq.this.eNV instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.eNV, aq.this.eFn.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        aq.this.a(((Integer) sparseArray5.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.h.tag_del_post_id), ((Integer) sparseArray5.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.h.tag_forbid_user_name)) || aTx()) {
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eNV != null && (aq.this.eNV instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.eNV, aq.this.eFn.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && aq.this.ePu != null) {
                        aq.this.ePu.g(new Object[]{sparseArray6.get(d.h.tag_manage_user_identity), sparseArray6.get(d.h.tag_forbid_user_name), sparseArray6.get(d.h.tag_forbid_user_post_id)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eNV != null && (aq.this.eNV instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.eNV, aq.this.eFn.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        aq.this.eFn.a(z, (String) sparseArray7.get(d.h.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.eNV, this.eFn.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.ePu = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eOR, Integer.valueOf(eOS));
        int i3 = d.l.del_post_confirm;
        if (i == 0) {
            i3 = d.l.del_thread_confirm;
        }
        this.eNX = new com.baidu.tbadk.core.dialog.a(this.eFn.getActivity());
        this.eNX.ca(i3);
        this.eNX.A(sparseArray);
        this.eNX.a(d.l.dialog_ok, this.eFn);
        this.eNX.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eNX.ar(true);
        this.eNX.b(this.eFn.getPageContext());
        this.eNX.th();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eOj == null) {
            this.eOj = LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.commit_good, (ViewGroup) null);
        }
        this.eFn.getLayoutMode().t(this.eOj);
        if (this.eOi == null) {
            this.eOi = new Dialog(this.eFn.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eOi.setCanceledOnTouchOutside(true);
            this.eOi.setCancelable(true);
            this.eOt = (ScrollView) this.eOj.findViewById(d.h.good_scroll);
            this.eOi.setContentView(this.eOj);
            WindowManager.LayoutParams attributes = this.eOi.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds540);
            this.eOi.getWindow().setAttributes(attributes);
            this.eOl = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.eOo = (String) compoundButton.getTag();
                        if (aq.this.eNe != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : aq.this.eNe) {
                                String str = (String) aVar.getTag();
                                if (str != null && aq.this.eOo != null && !str.equals(aq.this.eOo)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.eOk = (LinearLayout) this.eOj.findViewById(d.h.good_class_group);
            this.eOn = (TextView) this.eOj.findViewById(d.h.dialog_button_cancel);
            this.eOn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eOi instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.eOi, aq.this.eFn.getPageContext());
                    }
                }
            });
            this.eOm = (TextView) this.eOj.findViewById(d.h.dialog_button_ok);
            this.eOm.setOnClickListener(this.cjs);
        }
        this.eOk.removeAllViews();
        this.eNe = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bM = bM("0", this.eFn.getPageContext().getString(d.l.def_good_class));
        this.eNe.add(bM);
        bM.setChecked(true);
        this.eOk.addView(bM);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bM2 = bM(String.valueOf(arrayList.get(i2).pQ()), arrayList.get(i2).pP());
                this.eNe.add(bM2);
                View view = new View(this.eFn.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds1));
                com.baidu.tbadk.core.util.ai.k(view, d.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eOk.addView(view);
                this.eOk.addView(bM2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eOt.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eFn.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eFn.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eFn.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eOt.setLayoutParams(layoutParams2);
            this.eOt.removeAllViews();
            this.eOt.addView(this.eOk);
        }
        com.baidu.adp.lib.g.g.a(this.eOi, this.eFn.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bM(String str, String str2) {
        Activity pageActivity = this.eFn.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, d.f.ds100));
        aVar.setOnCheckedChangeListener(this.eOl);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aSY() {
        this.eFn.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eFn.hideProgressBar();
        if (z && z2) {
            this.eFn.showToast(this.eFn.getPageContext().getString(d.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.al.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.l.neterror);
            }
            this.eFn.showToast(str);
        }
    }

    public void avD() {
        this.eNU.setVisibility(0);
    }

    public void avC() {
        this.eNU.setVisibility(8);
    }

    public View aSZ() {
        if (this.eOj != null) {
            return this.eOj.findViewById(d.h.dialog_button_ok);
        }
        return null;
    }

    public String aTa() {
        return this.eOo;
    }

    public View getView() {
        return this.bXk;
    }

    public void aTb() {
        com.baidu.adp.lib.util.k.b(this.eFn.getPageContext().getPageActivity(), this.eFn.getCurrentFocus());
    }

    public void jF(boolean z) {
        this.eFn.hideProgressBar();
        aAZ();
    }

    public void aTc() {
        this.eNS.wJ();
        this.eNS.wN();
    }

    public void aTd() {
        this.eFn.hideProgressBar();
        wO();
        this.eNd.completePullRefreshPostDelayed(2000L);
        aTk();
    }

    public void aTe() {
        this.eNd.completePullRefreshPostDelayed(2000L);
        aTk();
    }

    public void jG(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eOx.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eFn.getResources().getDimensionPixelSize(d.f.ds84) : 0;
        this.eOx.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eNN.setOnLongClickListener(onLongClickListener);
    }

    public void a(b.InterfaceC0043b interfaceC0043b, boolean z, boolean z2) {
        if (this.eOp != null) {
            this.eOp.dismiss();
            this.eOp = null;
        }
        this.eOp = new com.baidu.tbadk.core.dialog.b(this.eFn.getPageContext().getPageActivity());
        this.eOp.cd(d.l.operation);
        if (z2) {
            this.eOp.a(new String[]{this.eFn.getPageContext().getString(d.l.copy)}, interfaceC0043b);
        } else if (!z) {
            this.eOp.a(new String[]{this.eFn.getPageContext().getString(d.l.copy), this.eFn.getPageContext().getString(d.l.mark)}, interfaceC0043b);
        } else {
            this.eOp.a(new String[]{this.eFn.getPageContext().getString(d.l.copy), this.eFn.getPageContext().getString(d.l.remove_mark)}, interfaceC0043b);
        }
        this.eOp.d(this.eFn.getPageContext());
        this.eOp.tk();
    }

    public void a(b.InterfaceC0043b interfaceC0043b, boolean z) {
        if (this.eOq != null) {
            this.eOq.dismiss();
            this.eOq = null;
        }
        this.eOq = new com.baidu.tbadk.core.dialog.b(this.eFn.getPageContext().getPageActivity());
        this.eOq.cd(d.l.operation);
        if (z) {
            this.eOq.a(new String[]{this.eFn.getPageContext().getString(d.l.save_to_emotion)}, interfaceC0043b);
        } else {
            this.eOq.a(new String[]{this.eFn.getPageContext().getString(d.l.save_to_emotion), this.eFn.getPageContext().getString(d.l.pb_save_image)}, interfaceC0043b);
        }
        this.eOq.d(this.eFn.getPageContext());
        this.eOq.tk();
    }

    public int aTf() {
        return pk(this.eNd.getFirstVisiblePosition());
    }

    private int pk(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.eNd.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eNd.getAdapter() == null || !(this.eNd.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.eNd.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aTg() {
        int lastVisiblePosition = this.eNd.getLastVisiblePosition();
        if (this.eMU != null) {
            if (lastVisiblePosition == this.eNd.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.eNN.aQW();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pk(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.eNd.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eNQ.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.f fVar) {
        this.eNN.a(fVar, false);
        this.eNN.notifyDataSetChanged();
        aTk();
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        if (this.eNA == null) {
            this.eFn.getLayoutMode().t(((ViewStub) this.eNf.findViewById(d.h.praise_layout)).inflate());
            this.eNA = (FrsPraiseView) this.eNf.findViewById(d.h.pb_head_praise_view);
            this.eNA.setIsFromPb(true);
            this.eNL = this.eNf.findViewById(d.h.new_pb_header_item_line_above_praise);
            this.eNA.dr(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eNA != null) {
            boolean aTk = aTk();
            this.eNA.setVisibility(8);
            if (fVar != null && fVar.qx() != null && fVar.qx().qu() == 0 && this.eEi) {
                if (aTk) {
                    this.eNK.setVisibility(0);
                } else {
                    this.eNK.setVisibility(8);
                }
            } else {
                this.eNK.setVisibility(8);
            }
            com.baidu.tieba.graffiti.b.aq(this.eNK);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aPh() != null) {
            return fVar.aPh();
        }
        if (z) {
            if (fVar == null || fVar.aPa() == null || fVar.aPa().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPa().get(0);
            if (postData.bsr() != 1) {
                postData = a(fVar);
            }
            if (postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
                return postData;
            }
            return postData;
        }
        PostData aPf = fVar.aPf();
        if (aPf == null) {
            return a(fVar);
        }
        return aPf;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aOY() == null || fVar.aOY().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aOY().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aOY().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.tj(1);
        postData.setId(fVar.aOY().rL());
        postData.setTitle(fVar.aOY().getTitle());
        postData.setTime(fVar.aOY().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0577 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x06f0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0386  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        int i2;
        String d;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.h bsu;
        String portrait;
        if (fVar != null && fVar.aOY() != null) {
            PostData c = c(fVar, z);
            a(c, fVar);
            aTy();
            this.eNn.setVisibility(8);
            if (fVar.aOY() != null && fVar.aOY().si() && fVar.aOY().rM() != null) {
                this.ePc = true;
                this.eMZ.jV(this.ePc);
                if (this.eMU == null) {
                    this.eMU = new com.baidu.tieba.pb.video.i(this.eFn, this.eMZ, fVar.aOY().rM());
                    this.eMU.a(fVar.aOY().rM(), fVar.aOY(), fVar.getForumId());
                    this.eMU.startPlay();
                } else if (this.eMX) {
                    this.eMU.a(fVar.aOY().rM(), fVar.aOY(), fVar.getForumId());
                    this.eMU.startPlay();
                }
                if (fVar.aOZ() != null && fVar.aOZ().size() >= 1) {
                    bl blVar = fVar.aOZ().get(0);
                    this.eMU.ab(blVar);
                    this.eMU.pI(blVar.getTitle());
                }
                this.eMU.b(c, fVar.aOY(), fVar.aPv());
                this.eMX = false;
                this.eNd.removeHeaderView(this.eMU.aVT());
                this.eNd.addHeaderView(this.eMU.aVT(), 0);
                if (this.eMV == null) {
                    this.eMV = new com.baidu.tieba.pb.video.h(this.eFn);
                }
                this.eMV.a(fVar.aOY().sz(), fVar.aOY(), fVar.aPr());
                this.eNd.removeHeaderView(this.eMV.aVK());
                this.eNd.addHeaderView(this.eMV.aVK(), 1);
                if (fVar.aOY().sz() != null) {
                    this.eNd.removeHeaderView(this.eMV.aVL());
                    this.eNd.removeHeaderView(this.eNj);
                    this.eNd.addHeaderView(this.eMV.aVL(), 2);
                } else {
                    if (this.eMV.aVL() != null) {
                        this.eNd.removeHeaderView(this.eMV.aVL());
                    }
                    this.eNd.removeHeaderView(this.eNj);
                    this.eNd.addHeaderView(this.eNj, 2);
                }
                if (this.eMU != null) {
                    this.eMU.py(0);
                }
                aTj();
            } else {
                this.ePc = false;
                this.eMZ.jV(this.ePc);
                this.eMZ.eTi.setVisibility(0);
                if (this.eMU != null) {
                    this.eNd.removeHeaderView(this.eMU.aVT());
                }
                if (this.eMV != null) {
                    this.eMV.e(this.eNd);
                }
            }
            if (this.eFn.aQa() != null) {
                this.eFn.aQa().jR(this.ePc);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.ePc) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11923").r("obj_id", 2));
                    }
                    if (aq.this.eFn.eGd.eSy != null) {
                        if (!aq.this.ePc && aq.this.eJQ != null && aq.this.eJQ.aOY() != null && aq.this.eJQ.aOY().getAuthor() != null && aq.this.eJQ.aOY().getAuthor().isBigV()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12151").r("obj_locate", 1));
                        }
                        aq.this.eFn.eGd.eSy.onClick(view);
                    }
                }
            };
            if (this.eMU != null) {
                this.eMU.J(onClickListener);
            }
            b(fVar, z);
            if (c != null) {
                this.eOF = c;
                if (fVar != null && fVar.aOY() != null && fVar.aOY().getAuthor() != null) {
                    fVar.aOY().getAuthor().getUserId();
                    if (fVar.qx() != null) {
                        this.ePh = fVar.qx().qq();
                        if (fVar.qx().qt() == 1) {
                        }
                    }
                }
                this.eNn.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eNn.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eNn.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_clip_board, c);
                sparseArray.put(d.h.tag_is_subpb, false);
                if (!this.ePm) {
                    this.eNh.setVisibility(0);
                }
                if (!fVar.aOY().si() && this.eNi.getText() != null && this.eNi.getText().length() > 0) {
                    this.eNi.setVisibility(0);
                } else {
                    this.eNi.setVisibility(8);
                }
                n(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rG = fVar.aOY().rG();
                if (rG != null && rG.size() > 0 && !this.ePm) {
                    this.eOI.setText(String.valueOf(rG.get(0).ph()));
                    this.eOH.setVisibility(0);
                    this.ePw = true;
                } else {
                    this.eOH.setVisibility(8);
                }
                com.baidu.tbadk.core.util.ai.j(this.eOH, d.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.ai.c(this.eOI, d.e.cp_link_tip_d, 1);
                if (c.getAuthor() != null) {
                    this.rank = c.getAuthor().getLevel_id();
                    String string = c.getAuthor().getName_show() == null ? StringUtils.string(c.getAuthor().getUserName()) : StringUtils.string(c.getAuthor().getName_show());
                    if (StringUtils.isNull(c.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aM(c.getAuthor().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aM(string) > 12) {
                            d = com.baidu.tbadk.core.util.al.d(string, 12, "...");
                            int i3 = 3;
                            if (!StringUtils.isNull(string)) {
                                int aM = com.baidu.adp.lib.util.j.aM(c.getAuthor().getName_show());
                                if (aM + i2 > 14) {
                                    i3 = 0;
                                } else if (aM + i2 >= 12) {
                                    i3 = 1;
                                } else if (aM + i2 >= 10) {
                                    i3 = 2;
                                }
                            }
                            ArrayList<IconData> iconInfo = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eIW != null) {
                                this.eIW.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                                this.eIW.setOnClickListener(this.eFn.eGd.cri);
                                this.eIW.a(iconInfo, i3, this.eFn.getResources().getDimensionPixelSize(d.f.ds26), this.eFn.getResources().getDimensionPixelSize(d.f.ds26), this.eFn.getResources().getDimensionPixelSize(d.f.ds8));
                            }
                            if (this.eIV != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eIV.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eIV.setOnClickListener(this.eFn.eGd.eSz);
                                this.eIV.a(tShowInfoNew, 3, this.eFn.getResources().getDimensionPixelSize(d.f.ds36), this.eFn.getResources().getDimensionPixelSize(d.f.ds36), this.eFn.getResources().getDimensionPixelSize(d.f.ds8), true);
                            }
                            this.eNp.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.eNp.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                            this.eNp.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.u.v(tShowInfoNew) || c.getAuthor().isBigV()) {
                                com.baidu.tbadk.core.util.ai.c(this.eNp, d.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.ai.c(this.eNp, d.e.cp_cont_f, 1);
                            }
                            if (c == null && !TextUtils.isEmpty(c.getAuthor().getGodIntro())) {
                                this.eNq.setVisibility(0);
                                this.eNq.setText(ap.a(c.getAuthor()));
                            } else {
                                this.eNq.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.ai.c(this.eNr, d.e.cp_link_tip_a, 1);
                            this.eNr.setVisibility(0);
                            if (fVar.aOY().getAuthor() != null && fVar.aOY().getAuthor().getAlaUserData() != null && this.eNw != null) {
                                if (fVar.aOY().getAuthor().getAlaUserData().anchor_live != 0) {
                                    this.eNw.setVisibility(8);
                                } else {
                                    this.eNw.setVisibility(0);
                                    if (this.eMW == null) {
                                        this.eMW = new com.baidu.tieba.d.b(this.eFn.getPageContext(), this.eNw);
                                        this.eMW.hK(1);
                                    }
                                    this.eMW.aH(this.eFn.getResources().getString(d.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.PQ = fVar.aOY().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.eNw.setTag(aVar);
                                }
                            }
                            this.eNv.setUserId(c.getAuthor().getUserId());
                            this.eNv.setUserName(c.getAuthor().getUserName());
                            this.eNv.setImageDrawable(null);
                            this.eNv.setRadius(com.baidu.adp.lib.util.k.g(this.eFn.getActivity(), d.f.ds40));
                            this.eNv.setTag(c.getAuthor().getUserId());
                            this.eNF.setText(c.bst());
                            bsu = c.bsu();
                            if (bsu == null && !TextUtils.isEmpty(bsu.getName()) && !TextUtils.isEmpty(bsu.getName().trim())) {
                                final String name = bsu.getName();
                                final String lat = bsu.getLat();
                                final String lng = bsu.getLng();
                                this.bCB.setVisibility(0);
                                this.bCB.setText(bsu.getName());
                                this.bCB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.i.hh()) {
                                                aq.this.eFn.showToast(d.l.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.T(aq.this.eFn.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, aq.this.eFn.getPageContext().getString(d.l.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.bCB.setVisibility(8);
                            }
                            this.eND.a(c.getAuthor());
                            this.eND.eMN = this.ePc;
                            if (!this.eOs) {
                                this.eNC.setVisibility(8);
                                this.eNE.setVisibility(0);
                                this.eNE.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_thread_views), com.baidu.tbadk.core.util.al.x(fVar.aPu())));
                            } else if (!PbNormalLikeButtonSwitchStatic.GK() || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                                this.eNC.setVisibility(8);
                                this.eNE.setVisibility(8);
                            } else {
                                this.eNC.setVisibility(0);
                                this.eNC.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eFn.getActivity(), d.f.ds24));
                                this.eNE.setVisibility(8);
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null && !StringUtils.isNull(c.getAuthor().getPendantData().pL())) {
                                UtilHelper.showHeadImageViewBigV(this.eNt.getHeadView(), c.getAuthor());
                                this.eNv.setVisibility(8);
                                this.eNt.setVisibility(0);
                                if (this.eNB != null) {
                                    this.eNB.setVisibility(8);
                                }
                                this.eNp.setOnClickListener(onClickListener);
                                this.eNt.getHeadView().c(portrait, 28, false);
                                this.eNt.getHeadView().setUserId(c.getAuthor().getUserId());
                                this.eNt.getHeadView().setUserName(c.getAuthor().getUserName());
                                this.eNt.getHeadView().setOnClickListener(onClickListener);
                                this.eNt.en(c.getAuthor().getPendantData().pL());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eNv, c.getAuthor());
                                this.eNv.setVisibility(0);
                                this.eNn.setOnClickListener(onClickListener);
                                this.eNp.setOnClickListener(onClickListener);
                                this.eNv.setOnClickListener(onClickListener);
                                this.eNt.setVisibility(8);
                                this.eNv.c(portrait, 28, false);
                            }
                            String name_show = c.getAuthor().getName_show();
                            String userName = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ab.fS() && name_show != null && !name_show.equals(userName)) {
                                this.eNp.setText(com.baidu.tieba.pb.d.ao(this.eFn.getPageContext().getPageActivity(), this.eNp.getText().toString()));
                                this.eNp.setGravity(16);
                                this.eNp.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOz());
                                com.baidu.tbadk.core.util.ai.c(this.eNp, d.e.cp_other_e, 1);
                            }
                        }
                        d = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eIW != null) {
                        }
                        if (this.eIV != null) {
                        }
                        this.eNp.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.eNp.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                        this.eNp.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ai.c(this.eNp, d.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eNq.setVisibility(8);
                        com.baidu.tbadk.core.util.ai.c(this.eNr, d.e.cp_link_tip_a, 1);
                        this.eNr.setVisibility(0);
                        if (fVar.aOY().getAuthor() != null) {
                            if (fVar.aOY().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eNv.setUserId(c.getAuthor().getUserId());
                        this.eNv.setUserName(c.getAuthor().getUserName());
                        this.eNv.setImageDrawable(null);
                        this.eNv.setRadius(com.baidu.adp.lib.util.k.g(this.eFn.getActivity(), d.f.ds40));
                        this.eNv.setTag(c.getAuthor().getUserId());
                        this.eNF.setText(c.bst());
                        bsu = c.bsu();
                        if (bsu == null) {
                        }
                        this.bCB.setVisibility(8);
                        this.eND.a(c.getAuthor());
                        this.eND.eMN = this.ePc;
                        if (!this.eOs) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eNv, c.getAuthor());
                        this.eNv.setVisibility(0);
                        this.eNn.setOnClickListener(onClickListener);
                        this.eNp.setOnClickListener(onClickListener);
                        this.eNv.setOnClickListener(onClickListener);
                        this.eNt.setVisibility(8);
                        this.eNv.c(portrait, 28, false);
                        String name_show2 = c.getAuthor().getName_show();
                        String userName2 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ab.fS()) {
                            this.eNp.setText(com.baidu.tieba.pb.d.ao(this.eFn.getPageContext().getPageActivity(), this.eNp.getText().toString()));
                            this.eNp.setGravity(16);
                            this.eNp.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOz());
                            com.baidu.tbadk.core.util.ai.c(this.eNp, d.e.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.j.aM(string) > 14) {
                            d = com.baidu.tbadk.core.util.al.d(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eIW != null) {
                            }
                            if (this.eIV != null) {
                            }
                            this.eNp.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.eNp.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                            this.eNp.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.ai.c(this.eNp, d.e.cp_cont_h, 1);
                            if (c == null) {
                            }
                            this.eNq.setVisibility(8);
                            com.baidu.tbadk.core.util.ai.c(this.eNr, d.e.cp_link_tip_a, 1);
                            this.eNr.setVisibility(0);
                            if (fVar.aOY().getAuthor() != null) {
                            }
                            this.eNv.setUserId(c.getAuthor().getUserId());
                            this.eNv.setUserName(c.getAuthor().getUserName());
                            this.eNv.setImageDrawable(null);
                            this.eNv.setRadius(com.baidu.adp.lib.util.k.g(this.eFn.getActivity(), d.f.ds40));
                            this.eNv.setTag(c.getAuthor().getUserId());
                            this.eNF.setText(c.bst());
                            bsu = c.bsu();
                            if (bsu == null) {
                            }
                            this.bCB.setVisibility(8);
                            this.eND.a(c.getAuthor());
                            this.eND.eMN = this.ePc;
                            if (!this.eOs) {
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eNv, c.getAuthor());
                            this.eNv.setVisibility(0);
                            this.eNn.setOnClickListener(onClickListener);
                            this.eNp.setOnClickListener(onClickListener);
                            this.eNv.setOnClickListener(onClickListener);
                            this.eNt.setVisibility(8);
                            this.eNv.c(portrait, 28, false);
                            String name_show22 = c.getAuthor().getName_show();
                            String userName22 = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ab.fS()) {
                            }
                        }
                        d = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eIW != null) {
                        }
                        if (this.eIV != null) {
                        }
                        this.eNp.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.eNp.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                        this.eNp.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ai.c(this.eNp, d.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eNq.setVisibility(8);
                        com.baidu.tbadk.core.util.ai.c(this.eNr, d.e.cp_link_tip_a, 1);
                        this.eNr.setVisibility(0);
                        if (fVar.aOY().getAuthor() != null) {
                        }
                        this.eNv.setUserId(c.getAuthor().getUserId());
                        this.eNv.setUserName(c.getAuthor().getUserName());
                        this.eNv.setImageDrawable(null);
                        this.eNv.setRadius(com.baidu.adp.lib.util.k.g(this.eFn.getActivity(), d.f.ds40));
                        this.eNv.setTag(c.getAuthor().getUserId());
                        this.eNF.setText(c.bst());
                        bsu = c.bsu();
                        if (bsu == null) {
                        }
                        this.bCB.setVisibility(8);
                        this.eND.a(c.getAuthor());
                        this.eND.eMN = this.ePc;
                        if (!this.eOs) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eNv, c.getAuthor());
                        this.eNv.setVisibility(0);
                        this.eNn.setOnClickListener(onClickListener);
                        this.eNp.setOnClickListener(onClickListener);
                        this.eNv.setOnClickListener(onClickListener);
                        this.eNt.setVisibility(8);
                        this.eNv.c(portrait, 28, false);
                        String name_show222 = c.getAuthor().getName_show();
                        String userName222 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ab.fS()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eNm.V(fVar.aOY());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rQ() != null) {
            this.eNo.a(this.eFn.getPageContext(), fVar.aPa().get(0).rQ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aOW().getId(), fVar.aOW().getName(), fVar.aOY().getId(), this.eFn.aQI() ? "FRS" : null));
            this.eNn.setPadding(this.eNn.getPaddingLeft(), (int) this.eFn.getResources().getDimension(d.f.ds20), this.eNn.getPaddingRight(), this.eNn.getPaddingBottom());
            return;
        }
        this.eNo.a(null, null, null);
    }

    public void aTh() {
        if (this.eMU != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11997").r("obj_type", 1));
            this.eMU.aVU();
            this.eNd.smoothScrollToPosition(0);
        }
    }

    public boolean aTi() {
        return this.ePy;
    }

    private boolean OL() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean O(bl blVar) {
        if (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), blVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.eMZ.aUy();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eMZ.mQ(eVar.forumName);
            }
            String string = this.eFn.getResources().getString(d.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eFn.getResources().getString(d.l.self);
                    break;
                case 300:
                    str = this.eFn.getResources().getString(d.l.bawu);
                    break;
                case 400:
                    str = this.eFn.getResources().getString(d.l.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eCx;
            this.eFn.showNetRefreshView(this.bXk, format, null, this.eFn.getResources().getString(d.l.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.k.hy()) {
                        com.baidu.tbadk.core.util.at.vV().c(aq.this.eFn.getPageContext(), new String[]{str2});
                        aq.this.eFn.finish();
                        return;
                    }
                    aq.this.eFn.showToast(d.l.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aSz;
        String str;
        if (fVar != null) {
            this.eJQ = fVar;
            this.mType = i;
            if (fVar.aOY() != null) {
                this.eOO = fVar.aOY().ri();
                this.YO = fVar.aOY().rf();
                if (fVar.aOY().getAnchorLevel() != 0) {
                    this.ePy = true;
                }
                this.eOs = O(fVar.aOY());
                if (this.eND != null && fVar.aOY().getAuthor() != null) {
                    this.eND.isBigV = fVar.aOY().getAuthor().isBigV();
                }
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            p(fVar);
            this.eOG = false;
            this.eEi = z;
            aTd();
            b(fVar, z, i);
            if (this.eFn.aQy()) {
                if (this.eNR == null) {
                    this.eNR = new com.baidu.tieba.pb.view.j(this.eFn.getPageContext());
                    this.eNR.la();
                    this.eNR.a(this.amt);
                }
                this.eNd.setPullRefresh(this.eNR);
                aTj();
                if (this.eNR != null) {
                    this.eNR.dn(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qx().qu() == 0 && z) {
                this.eNd.setPullRefresh(null);
                this.eMT = 1;
            } else {
                if (this.eNR == null) {
                    this.eNR = new com.baidu.tieba.pb.view.j(this.eFn.getPageContext());
                    this.eNR.la();
                    this.eNR.a(this.amt);
                }
                this.eNd.setPullRefresh(this.eNR);
                aTj();
                this.eMT = 2;
                if (this.eNR != null) {
                    this.eNR.dn(TbadkCoreApplication.getInst().getSkinType());
                }
                QT();
            }
            aTk();
            this.eNN.iQ(this.eEi);
            this.eNN.iR(false);
            this.eNN.jc(i == 5);
            this.eNN.jd(i == 6);
            this.eNN.a(fVar, false);
            this.eNN.notifyDataSetChanged();
            if (this.eFn.aQM()) {
                if (fVar.aOX() != null) {
                    this.mForumName = fVar.aOX().getForumName();
                    this.mForumId = fVar.aOX().getForumId();
                }
                if (this.mForumName == null && this.eFn.aQc() != null && this.eFn.aQc().aRm() != null) {
                    this.mForumName = this.eFn.aQc().aRm();
                }
                this.eMZ.mQ(this.mForumName);
            } else {
                this.eMZ.mQ(null);
            }
            if (this.eFn.aQM()) {
                int i4 = 0;
                PostData c = c(fVar, z);
                if (c != null && c.getAuthor() != null) {
                    i4 = c.getAuthor().getLevel_id();
                }
                if (i4 > 0) {
                    this.eNs.setVisibility(0);
                    com.baidu.tbadk.core.util.ai.c(this.eNs, BitmapHelper.getGradeResourceIdInEnterForum(i4));
                } else {
                    this.eNs.setVisibility(8);
                }
            } else {
                this.eNs.setVisibility(8);
            }
            if (fVar.aOY() != null && fVar.aOY().rl() != null) {
                if (fVar.aOY().rl().getNum() < 1) {
                    str = this.eFn.getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = fVar.aOY().rl().getNum() + "";
                }
                if (this.eMP != -1) {
                    fVar.aOY().rl().setIsLike(this.eMP);
                }
                T(str, fVar.aOY().rl().getIsLike() == 1);
            }
            if (fVar.qx().qt() == 0 && !z) {
                this.eNd.setNextPage(null);
                this.eMY = 1;
            } else if (this.eFn.isLogin()) {
                this.eNd.setNextPage(this.eNS);
                this.eMY = 2;
                QT();
            } else if (fVar.qx().qt() == 1) {
                this.eOG = true;
                if (this.eNT == null) {
                    this.eNT = new com.baidu.tieba.pb.view.b(this.eFn.getPageContext());
                }
                this.eNd.setNextPage(this.eNT);
                this.eMY = 3;
            }
            ArrayList<PostData> aPa = fVar.aPa();
            if (fVar.qx().qt() == 0 || aPa == null || aPa.size() < fVar.qx().qs()) {
                if (com.baidu.tbadk.core.util.u.u(aPa) == 0 || (com.baidu.tbadk.core.util.u.u(aPa) == 1 && aPa.get(0) != null && aPa.get(0).bsr() == 1)) {
                    this.eNS.setText(this.eFn.getResources().getString(d.l.list_no_more_new));
                } else {
                    this.eNS.setText("");
                }
                if (this.eFn.aQy() && this.eNd != null && this.eNd.getData() != null && this.eNd.getData().size() == 1 && (this.eNd.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.eNS.setText("");
                }
                aTp();
            } else if (z2) {
                if (this.ePv) {
                    wO();
                    if (fVar.qx().qt() != 0) {
                        this.eNS.setText(this.eFn.getResources().getString(d.l.pb_load_more));
                    }
                } else {
                    this.eNS.wJ();
                    this.eNS.wQ();
                }
            } else {
                this.eNS.wJ();
                this.eNS.wQ();
            }
            if (fVar.aOY() != null && fVar.aOY().getAuthor() != null && fVar.aOY().getAuthor().getType() == 0) {
                this.eMZ.aUv();
            }
            switch (i) {
                case 2:
                    int i5 = 0;
                    if (this.eNd.getData() != null || fVar.aPa() != null) {
                        i5 = (this.eNd.getData().size() - fVar.aPa().size()) + this.eNd.getHeaderViewsCount();
                    }
                    this.eNd.setSelection(i2 > 1 ? (i5 + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aSz = ai.aSy().aSz()) != null) {
                        this.ePq = true;
                        this.eNd.onRestoreInstanceState(aSz);
                        break;
                    } else {
                        this.eNd.setSelection(0);
                        break;
                    }
                case 4:
                    this.ePv = false;
                    break;
                case 5:
                    this.eNd.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aSz2 = ai.aSy().aSz();
                        this.ePq = true;
                        if (aSz2 != null) {
                            this.eNd.onRestoreInstanceState(aSz2);
                            break;
                        }
                    }
                    this.eNd.setSelection(0);
                    break;
            }
            if (this.ePb >= 0) {
                this.eNd.setSelectionFromTop(this.ePb, (int) this.ePa);
                this.ePb = -1;
            }
            if (this.eOO == eOQ && OL()) {
                aTs();
            }
            if (this.eMV != null) {
                this.eMV.aa(fVar.aOY());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aTj() {
        if (this.eMU != null && this.eMU.aVT() != null) {
            this.eNd.removeHeaderView(this.axo);
            if (this.mType != 1) {
                this.eNd.removeHeaderView(this.eMU.aVT());
                this.eNd.addHeaderView(this.eMU.aVT(), 0);
                this.eNd.setSelection(0);
                return;
            }
            return;
        }
        if (this.eMU != null) {
            this.eNd.removeHeaderView(this.eMU.aVT());
        }
        this.eNd.removeHeaderView(this.axo);
        this.eNd.addHeaderView(this.axo, 0);
    }

    public void jH(boolean z) {
        this.eOr = z;
        this.eMZ.jH(z);
    }

    public void wO() {
        if (this.eNS != null) {
            this.eNS.wK();
            this.eNS.wO();
        }
        QT();
    }

    public void Nm() {
        this.eNd.setVisibility(0);
    }

    private boolean aTk() {
        boolean z;
        if (this.eOu != null && this.eOu.getVisibility() == 0) {
            if (this.eNJ != null) {
                this.eNJ.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.eNJ != null) {
                this.eNJ.setVisibility(8);
            }
            z = false;
        }
        if ((this.eNL == null || this.eNL.getVisibility() == 8) && z && this.eEi) {
            this.eNK.setVisibility(0);
        } else {
            this.eNK.setVisibility(8);
        }
        com.baidu.tieba.graffiti.b.aq(this.eNK);
        return z;
    }

    private boolean o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aOY() == null) {
            return false;
        }
        if (fVar.aOY().rs() == 1 || fVar.aOY().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aOY().ru() == null || fVar.aOY().ru().sU() == 0) || fVar.aOY().rq() == 1 || fVar.aOY().rr() == 1 || fVar.aOY().sa() || fVar.aOY().sn() || fVar.aOY().sh() || fVar.aOY().rH() != null || fVar.aOY().so() || fVar.aOY().so() || !com.baidu.tbadk.core.util.al.isEmpty(fVar.aOY().getCategory()) || fVar.aOY().ry() || fVar.aOY().rx();
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eFn.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eNh != null) {
                if (fVar.aOY() != null && fVar.aOY().rK() == 0 && !fVar.aOY().si() && !this.ePm) {
                    this.eNh.setVisibility(0);
                    if (fVar.aOY() != null) {
                        fVar.aOY().e(true, o(fVar));
                    }
                    SpannableStringBuilder rV = fVar.aOY().rV();
                    this.eNi.setOnTouchListener(new com.baidu.tieba.view.l(rV));
                    this.eNi.setText(rV);
                    this.eNi.setVisibility(0);
                } else if (fVar.aOY().rK() == 1) {
                    if (fVar.aOY() != null) {
                        fVar.aOY().e(true, o(fVar));
                        SpannableStringBuilder rV2 = fVar.aOY().rV();
                        if (rV2 == null || rV2.length() == 0) {
                            this.eNh.setVisibility(8);
                            this.eNd.removeHeaderView(this.eNh);
                            if (fVar.aOY() != null && !fVar.aOY().si()) {
                                this.eNn.setPadding(this.eNn.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds48), this.eNn.getPaddingRight(), this.eNn.getPaddingBottom());
                            }
                        } else {
                            this.eNh.setVisibility(0);
                            this.eNi.setOnTouchListener(new com.baidu.tieba.view.l(rV2));
                            this.eNi.setText(rV2);
                            this.eNi.setVisibility(0);
                        }
                    }
                } else {
                    this.eNh.setVisibility(8);
                    this.eNd.removeHeaderView(this.eNh);
                    if (fVar.aOY() != null && fVar.aOY().si()) {
                        this.eNn.setPadding(this.eNn.getPaddingLeft(), 0, this.eNn.getPaddingRight(), this.eNn.getPaddingBottom());
                    } else {
                        this.eNn.setPadding(this.eNn.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds48), this.eNn.getPaddingRight(), this.eNn.getPaddingBottom());
                    }
                }
            }
            this.eEi = z;
            bl aOY = fVar.aOY();
            if (aOY != null) {
                a(aOY.ru());
            }
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aTk();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData c;
        if (fVar == null || (c = c(fVar, z)) == null) {
            return null;
        }
        String userId = c.getAuthor().getUserId();
        boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 0) {
            sparseArray.put(d.h.tag_del_post_id, c.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPj()));
            sparseArray.put(d.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(d.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(d.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(d.h.tag_del_post_id, c.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPj()));
            sparseArray.put(d.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aHC;
    }

    public void pq(String str) {
        if (this.eNS != null) {
            this.eNS.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eNd;
    }

    public int aTl() {
        return d.h.richText;
    }

    public TextView aPW() {
        return this.eNm.aPW();
    }

    public void d(BdListView.e eVar) {
        this.eNd.setOnSrollToBottomListener(eVar);
    }

    public void a(k.b bVar) {
        this.amt = bVar;
        if (this.eNR != null) {
            this.eNR.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, a.b bVar) {
        if (arVar != null) {
            int qr = arVar.qr();
            int qo = arVar.qo();
            if (this.eNO != null) {
                this.eNO.th();
            } else {
                this.eNO = new com.baidu.tbadk.core.dialog.a(this.eFn.getPageContext().getPageActivity());
                this.eNP = LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.dialog_direct_pager, (ViewGroup) null);
                this.eNO.v(this.eNP);
                this.eNO.a(d.l.dialog_ok, bVar);
                this.eNO.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.aAZ();
                        aVar.dismiss();
                    }
                });
                this.eNO.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.eOW == null) {
                            aq.this.eOW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.eFn.HidenSoftKeyPad((InputMethodManager) aq.this.eFn.getSystemService("input_method"), aq.this.bXk);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(aq.this.eOW, 150L);
                    }
                });
                this.eNO.b(this.eFn.getPageContext()).th();
            }
            this.eNQ = (EditText) this.eNP.findViewById(d.h.input_page_number);
            this.eNQ.setText("");
            TextView textView = (TextView) this.eNP.findViewById(d.h.current_page_number);
            if (qr <= 0) {
                qr = 1;
            }
            if (qo <= 0) {
                qo = 1;
            }
            textView.setText(MessageFormat.format(this.eFn.getApplicationContext().getResources().getString(d.l.current_page), Integer.valueOf(qr), Integer.valueOf(qo)));
            this.eFn.ShowSoftKeyPadDelay(this.eNQ, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eNd.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eFn.showToast(str);
    }

    public boolean jI(boolean z) {
        if (this.JT == null || !this.JT.CV()) {
            return false;
        }
        this.JT.Bm();
        return true;
    }

    public void aTm() {
        if (this.ePz != null) {
            while (this.ePz.size() > 0) {
                TbImageView remove = this.ePz.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aTm();
        this.eNN.oW(1);
        if (this.eMU != null) {
            this.eMU.onPause();
        }
    }

    public void onResume() {
        this.eNN.oW(2);
        if (this.eMU != null) {
            this.eMU.onResume();
        }
        if (this.eON != null) {
            this.eON.onResume();
        }
    }

    public void onDestroy() {
        this.eOZ.Yd();
        if (this.eMW != null) {
            this.eMW.Yd();
        }
        if (this.eMV != null) {
            this.eMV.onDestroy();
        }
        this.eFn.hideProgressBar();
        if (this.bDI != null && this.bDL != null) {
            this.bDI.b(this.bDL);
        }
        aAZ();
        wO();
        if (this.eOW != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eOW);
        }
        if (this.eOX != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eOX);
        }
        if (this.ePl != null) {
            this.ePl.removeAllViews();
        }
        if (this.eNn != null && this.eNB != null) {
            this.eNn.removeView(this.eNu);
            this.eNB = null;
        }
        if (this.eOK != null) {
            this.eOK.clearStatus();
        }
        this.ePr = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eNN.oW(3);
        if (this.bZx != null) {
            this.bZx.setBackgroundDrawable(null);
        }
        if (this.eMU != null) {
            this.eMU.destroy();
        }
        if (this.eNN != null) {
            this.eNN.onDestory();
        }
        this.bXk.getViewTreeObserver().removeGlobalOnLayoutListener(this.ePA);
    }

    public boolean pl(int i) {
        if (this.eMU != null) {
            return this.eMU.pE(i);
        }
        return false;
    }

    public void aAZ() {
        this.eMZ.og();
        this.eOZ.Yd();
        if (this.eMW != null) {
            this.eMW.Yd();
        }
        com.baidu.adp.lib.util.k.b(this.eFn.getPageContext().getPageActivity(), this.eNQ);
        if (this.eOp != null) {
            this.eOp.dismiss();
        }
        aTn();
        if (this.eMV != null) {
            this.eMV.aVM();
        }
        if (this.eNO != null) {
            this.eNO.dismiss();
        }
        if (this.cjr != null) {
            this.cjr.dismiss();
        }
    }

    public void iP(boolean z) {
        this.eNN.iP(z);
    }

    public void hh(boolean z) {
        this.dIn = z;
    }

    public void aTn() {
        if (this.eNX != null) {
            this.eNX.dismiss();
        }
        if (this.eNY != null) {
            com.baidu.adp.lib.g.g.b(this.eNY, this.eFn.getPageContext());
        }
        if (this.eOi != null) {
            com.baidu.adp.lib.g.g.b(this.eOi, this.eFn.getPageContext());
        }
        if (this.eNV != null) {
            com.baidu.adp.lib.g.g.b(this.eNV, this.eFn.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.eJQ, this.eEi);
            d(this.eJQ, this.eEi, this.mType);
            this.eFn.getLayoutMode().ah(i == 1);
            this.eFn.getLayoutMode().t(this.bXk);
            this.eFn.getLayoutMode().t(this.eNi);
            this.eFn.getLayoutMode().t(this.eNj);
            this.eFn.getLayoutMode().t(this.eNf);
            if (this.eNz != null) {
                com.baidu.tbadk.core.util.ai.c(this.eNz, d.e.cp_cont_d, 1);
            }
            if (this.eNy != null) {
                com.baidu.tbadk.core.util.ai.c(this.eNy, d.e.cp_cont_d, 1);
            }
            if (this.eMV != null) {
                this.eMV.onChangeSkinType(i);
            }
            this.eFn.getLayoutMode().t(this.eNf);
            com.baidu.tbadk.core.util.ai.i(this.eNi, d.e.cp_cont_b);
            this.eNi.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            this.eFn.getLayoutMode().t(this.aHC);
            if (this.eNP != null) {
                this.eFn.getLayoutMode().t(this.eNP);
            }
            jH(this.eOr);
            this.eNN.notifyDataSetChanged();
            if (this.eNR != null) {
                this.eNR.dn(i);
            }
            if (this.eNS != null) {
                this.eNS.dn(i);
                com.baidu.tbadk.core.util.ai.j(this.aHC, d.g.pb_foot_more_trans_selector);
                this.eNS.dl(d.g.pb_foot_more_trans_selector);
            }
            if (this.JT != null) {
                this.JT.onChangeSkinType(i);
            }
            if (this.eNA != null) {
                this.eNA.dr(i);
            }
            if (this.eNT != null) {
                this.eNT.dn(i);
            }
            if (this.eNe != null && this.eNe.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eNe) {
                    aVar.aUp();
                }
            }
            if (this.ePl != null) {
                com.baidu.tbadk.core.util.ai.k(this.ePl, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ai.k(this.ePj, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.ai.c(this.ePk, d.e.cp_cont_c, 1);
            }
            aO(i == 1);
            aSQ();
            UtilHelper.setStatusBarBackground(this.bZx, i);
            if (this.eNC != null) {
                this.eNC.onChangeSkinType(i);
            }
            if (this.bCB != null) {
                com.baidu.tbadk.core.util.ai.i(this.bCB, d.e.cp_cont_d);
            }
            if (this.eNF != null) {
                com.baidu.tbadk.core.util.ai.i(this.eNF, d.e.cp_cont_f);
            }
            if (this.eNr != null) {
                com.baidu.tbadk.core.util.ai.i(this.eNr, d.e.cp_link_tip_a);
            }
            if (this.eNE != null) {
                com.baidu.tbadk.core.util.ai.i(this.eNE, d.e.cp_cont_f);
            }
            if (this.eNG != null) {
                com.baidu.tbadk.o.a.a(this.eFn.getPageContext(), this.eNG);
            }
            if (this.eOY != null) {
                this.eOY.onChangeSkinType(i);
            }
            if (this.eMZ != null) {
                if (this.eMU != null) {
                    this.eMU.py(i);
                } else {
                    this.eMZ.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.ai.i(this.eNq, d.e.cp_cont_f);
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aQA = eVar;
        this.eNN.setOnImageClickListener(this.aQA);
    }

    public void c(NoNetworkView.a aVar) {
        this.bDL = aVar;
        if (this.bDI != null) {
            this.bDI.a(this.bDL);
        }
    }

    public void jJ(boolean z) {
        this.eNN.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aTo() {
        return this.eOu;
    }

    public void aTp() {
        if (this.eMY != 2) {
            this.eNd.setNextPage(this.eNS);
            this.eMY = 2;
        }
    }

    public void aTq() {
        if (com.baidu.tbadk.l.r.Gr().Gs()) {
            int lastVisiblePosition = this.eNd.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eNd.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog = tbImageView.getPerfLog();
                                perfLog.fg(1001);
                                perfLog.aIK = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wq();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.l.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.fg(1001);
                        perfLog2.aIK = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.wq();
                    }
                }
            }
        }
    }

    public void hi(boolean z) {
        if (this.eOv != null) {
            if (this.dIn) {
                hj(z);
            } else {
                hk(z);
            }
        }
    }

    public void aTr() {
        if (this.eOv != null) {
            this.eOv.setVisibility(8);
            this.eOA = false;
            if (this.eON != null) {
                this.eON.setVisibility(8);
            }
        }
    }

    public void QS() {
        if (this.bmO == null) {
            this.bmO = new com.baidu.tbadk.core.view.a(this.eFn.getPageContext());
        }
        this.bmO.aH(true);
    }

    public void QT() {
        if (this.bmO != null) {
            this.bmO.aH(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eNd.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eNd.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eMU != null) {
            this.eMU.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.ePB = getScrollY();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z = false;
        this.ePe = false;
        if (this.eMU != null) {
            this.eMU.b(absListView, i);
        }
        a aVar = new a();
        aVar.ePH = i;
        aVar.ePI = this.eNd.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
        int headerViewsCount = (i - this.eNd.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                break;
            } else if (this.eNN.oV(headerViewsCount) != com.baidu.tieba.pb.data.m.eDp) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.eNN.aRa().jC(z);
    }

    /* loaded from: classes.dex */
    public class a {
        public int ePH;
        public int ePI;

        public a() {
        }
    }

    public void aTs() {
        if (!this.ePC) {
            TiebaStatic.log("c10490");
            this.ePC = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eFn.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eOR, Integer.valueOf(eOT));
            aVar.bZ(d.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.h.function_description_view)).setText(d.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.h.title_view)).setText(d.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(d.l.grade_button_tips, this.eFn);
            aVar.b(d.l.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eFn.getPageContext()).th();
        }
    }

    public void aTt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eFn.getPageContext().getPageActivity());
        aVar.cN(this.eFn.getResources().getString(d.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eOR, Integer.valueOf(eOV));
        aVar.A(sparseArray);
        aVar.a(d.l.upgrade_to_new, this.eFn);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eFn.getPageContext()).th();
    }

    public int ri() {
        return this.eOO;
    }

    public void pr(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eFn.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eFn.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eOR, Integer.valueOf(eOU));
        aVar.A(sparseArray);
        aVar.a(d.l.view, this.eFn);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eFn.getPageContext()).th();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData c;
        if (i > 0 && (c = c(fVar, z)) != null && c.getAuthor() != null) {
            MetaData author = c.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
    }

    public PbInterviewStatusView aTu() {
        return this.eOK;
    }

    private void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aOY() != null && fVar.aOY().sn() && this.eOK == null) {
            this.eOK = (PbInterviewStatusView) this.eOJ.inflate();
            this.eOK.setOnClickListener(this.cjs);
            this.eOK.setCallback(this.eFn.aQH());
            this.eOK.a(this.eFn, fVar);
        }
    }

    public LinearLayout aTv() {
        return this.eNM;
    }

    public View aTw() {
        return this.bZx;
    }

    public boolean aTx() {
        return this.ePm;
    }

    public void iU(boolean z) {
        this.eNm.iU(z);
    }

    private void aTy() {
        if (this.ePm) {
            if (this.ePn == null) {
                d.a aVar = d.eFq.get();
                if (aVar != null) {
                    this.ePn = aVar.a(this.eFn);
                    ListAdapter adapter = this.eNd.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.axo) {
                            this.eNd.addHeaderView(this.ePn.aPU(), 1);
                        } else {
                            this.eNd.addHeaderView(this.ePn.aPU(), 0);
                        }
                    }
                } else {
                    this.eNj.setVisibility(0);
                    return;
                }
            }
            this.eNj.setVisibility(8);
            this.eNd.removeHeaderView(this.eNj);
            return;
        }
        this.eNj.setVisibility(0);
    }

    public void jK(boolean z) {
        this.ePm = z;
    }

    public void aTz() {
        this.eFn.showNetRefreshView(getView(), "");
        View EI = this.eFn.getRefreshView().EI();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EI.getLayoutParams();
        layoutParams.addRule(3, aTv().getId());
        EI.setLayoutParams(layoutParams);
        this.eFn.hideLoadingView(getView());
        if (this.ePn != null) {
            this.eNd.removeHeaderView(this.ePn.aPU());
            this.ePn = null;
        }
    }

    public void ps(String str) {
        if (this.eNa != null) {
            this.eNa.setTitle(str);
        }
    }

    private int jL(boolean z) {
        if (this.eOK == null || this.eOK.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds72);
    }

    private void aTA() {
        if (this.eOK != null && this.eOK.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOK.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eOK.setLayoutParams(layoutParams);
        }
    }

    public boolean aQd() {
        return false;
    }

    public boolean aTB() {
        return this.ePc;
    }

    public TextView aTC() {
        return this.eNz;
    }

    public void pt(String str) {
        this.eOx.performClick();
        if (!StringUtils.isNull(str) && this.eFn.aPX() != null && this.eFn.aPX().Ds() != null && this.eFn.aPX().Ds().Dl() != null) {
            EditText Dl = this.eFn.aPX().Ds().Dl();
            Dl.setText(str);
            Dl.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aAZ();
            aTr();
            aSF();
            if (this.eOY != null) {
                this.eOY.aRe();
            }
            this.eFn.afk();
            this.eNM.setVisibility(8);
            this.eMZ.setTitleVisibility(false);
            this.eFn.ja(false);
            if (this.eMU != null) {
                if (configuration.orientation == 1) {
                    aTv().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eNd.setIsLandscape(true);
                    this.eNd.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eNd.setIsLandscape(false);
                    if (this.ePB > 0) {
                        this.eNd.smoothScrollBy(this.ePB, 0);
                    }
                }
                this.eMU.onConfigurationChanged(configuration);
            }
        }
    }

    public void jM(boolean z) {
        this.eMX = z;
    }

    public boolean aTD() {
        return this.eMU != null && this.eMU.aTD();
    }

    public void aTE() {
        if (this.eMU != null) {
            this.eMU.onPause();
        }
    }

    public void w(long j, int i) {
        if (this.eMV != null) {
            this.eMV.w(j, i);
        }
        if (this.eMU != null) {
            this.eMU.w(j, i);
        }
    }

    public void aTF() {
        if (this.eON != null) {
            this.eON.aUo();
        }
    }

    public void aTG() {
        if (this.eON != null) {
            this.eON.setVisibility(8);
        }
    }

    public void je(boolean z) {
        this.eNN.je(z);
    }

    public void aTH() {
        if (this.eOL == null) {
            LayoutInflater.from(this.eFn.getActivity()).inflate(d.j.add_experienced_text, (ViewGroup) this.bXk, true);
            this.eOL = (ViewGroup) this.bXk.findViewById(d.h.add_experienced_layout);
            this.eOM = (TextView) this.bXk.findViewById(d.h.add_experienced);
            com.baidu.tbadk.core.util.ai.i(this.eOM, d.e.cp_cont_i);
            String string = this.eFn.getResources().getString(d.l.experienced_add_success);
            String string2 = this.eFn.getResources().getString(d.l.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_h)));
            this.eOM.setText(spannableString);
        }
        this.eOL.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.22
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.22.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        aq.this.eOL.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.eOM.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eOM.startAnimation(scaleAnimation);
    }
}
