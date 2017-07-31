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
    public static int eQc = 2;
    public static int eQd = 3;
    public static int eQe = 0;
    public static int eQf = 3;
    public static int eQg = 4;
    public static int eQh = 5;
    public static int eQi = 6;
    private com.baidu.tbadk.editortools.i Lr;
    private View aIR;
    private com.baidu.tieba.pb.a.c aRN;
    private int aRo;
    private k.b anM;
    private TextView ayF;
    private TextView bDL;
    private NoNetworkView bES;
    private RelativeLayout bYq;
    private View caD;
    private View.OnClickListener ckz;
    private View.OnClickListener eFz;
    private PbActivity eGA;
    PbActivity.c eIn;
    private PbFakeFloorModel eKG;
    private UserIconBox eKi;
    private UserIconBox eKj;
    private com.baidu.tieba.pb.data.f eLd;
    private ColumnLayout eOA;
    private ThreadSkinView eOB;
    private TextView eOC;
    private TextView eOD;
    private TextView eOE;
    private ImageView eOF;
    private HeadPendantView eOG;
    private FrameLayout eOH;
    private HeadImageView eOI;
    private View eOJ;
    private FloatingLayout eOK;
    private PbFirstFloorUserLikeButton eOP;
    private ao eOQ;
    private TextView eOR;
    private TextView eOS;
    private LinearLayout eOT;
    private TextView eOU;
    private TextView eOV;
    private View eOW;
    private View eOX;
    private ObservedChangeLinearLayout eOZ;
    public int eOc;
    private int eOd;
    private int eOe;
    private int eOf;
    private com.baidu.tieba.pb.video.i eOh;
    private com.baidu.tieba.pb.video.h eOi;
    private com.baidu.tieba.d.a eOj;
    public final com.baidu.tieba.pb.pb.main.view.d eOm;
    public com.baidu.tieba.pb.pb.main.view.c eOn;
    private ViewStub eOo;
    private ViewStub eOp;
    private PbLandscapeListView eOq;
    private List<com.baidu.tieba.pb.pb.main.view.a> eOr;
    private View eOs;
    private LinearLayout eOw;
    private TextView eOx;
    private View eOy;
    private e eOz;
    private View ePI;
    private TextView ePJ;
    private ViewGroup ePK;
    private TextView ePM;
    private boolean ePO;
    private int ePP;
    private int ePQ;
    private int ePR;
    private PostData ePS;
    private View ePU;
    private TextView ePV;
    private ViewStub ePW;
    private PbInterviewStatusView ePX;
    private ViewGroup ePY;
    private TextView ePZ;
    private g ePa;
    private PbListView ePf;
    private View ePh;
    private d eQA;
    private com.baidu.tbadk.core.view.userLike.c eQB;
    private com.baidu.tbadk.core.view.userLike.c eQC;
    private Runnable eQF;
    private PbActivity.a eQH;
    private boolean eQJ;
    private boolean eQK;
    private int eQO;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eQa;
    private Runnable eQj;
    private Runnable eQk;
    private q eQl;
    private com.baidu.tieba.d.a eQm;
    private View eQw;
    private TextView eQx;
    private LinearLayout eQy;
    private boolean eQz;
    private boolean isLandscape;
    private int mType;
    private int eOg = 1;
    private boolean eOk = false;
    private int eOl = 0;
    private final Handler mHandler = new Handler();
    private View eOt = null;
    private LinearLayout eOu = null;
    private TextView eOv = null;
    private TextView eOL = null;
    private TextView eOM = null;
    public FrsPraiseView eON = null;
    private ClickableHeaderImageView eOO = null;
    private View eOY = null;
    private com.baidu.tbadk.core.dialog.a ePb = null;
    private com.baidu.tbadk.core.dialog.b cky = null;
    private View ePc = null;
    private EditText ePd = null;
    private com.baidu.tieba.pb.view.j ePe = null;
    private com.baidu.tieba.pb.view.b ePg = null;
    private b.InterfaceC0043b drW = null;
    private TbRichTextView.e aRM = null;
    private NoNetworkView.a bEV = null;
    private Dialog ePi = null;
    private View ePj = null;
    private com.baidu.tbadk.core.dialog.a ePk = null;
    private Dialog ePl = null;
    private View ePm = null;
    private int ePn = 0;
    private RadioGroup ePo = null;
    private RadioButton ePp = null;
    private RadioButton ePq = null;
    private RadioButton ePr = null;
    private Button ePs = null;
    private Button ePt = null;
    private TextView ePu = null;
    private Dialog ePv = null;
    private View ePw = null;
    private LinearLayout ePx = null;
    private CompoundButton.OnCheckedChangeListener ePy = null;
    private TextView ePz = null;
    private TextView ePA = null;
    private String ePB = null;
    private com.baidu.tbadk.core.dialog.b ePC = null;
    private com.baidu.tbadk.core.dialog.b ePD = null;
    private boolean ePE = false;
    private boolean ePF = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView ePG = null;
    private boolean dJE = false;
    private Button ePH = null;
    public ImageView ePL = null;
    private boolean ePN = true;
    private com.baidu.tbadk.core.view.a bnY = null;
    private boolean eFv = false;
    private int mSkinType = 3;
    private boolean ePT = false;
    private boolean mIsFromCDN = true;
    private int eQb = 0;
    private float eQn = -1.0f;
    private int eQo = -1;
    private boolean eQp = false;
    private a.InterfaceC0118a eQq = new a.InterfaceC0118a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0118a
        public void lj() {
        }
    };
    private boolean eHi = false;
    private boolean eQr = false;
    private LinearLayout eQs = null;
    private TextView eQt = null;
    private int eQu = 0;
    private boolean eQv = false;
    private boolean eQD = false;
    private int rank = 0;
    private CustomMessageListener dEn = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aq.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.ePa != null) {
                aq.this.ePa.notifyDataSetChanged();
            }
        }
    };
    private Handler eQE = new Handler();
    private CustomMessageListener eQG = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.aq.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.ePN = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eQI = true;
    private boolean eQL = false;
    private boolean aak = false;
    String userId = null;
    private final List<TbImageView> eQM = new ArrayList();
    private ViewTreeObserver.OnGlobalLayoutListener eQN = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.pb.main.aq.18
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            aq.this.aSW();
        }
    };
    private boolean eQP = false;

    public void i(int i, float f) {
        this.eQo = i;
        this.eQn = f;
    }

    public d aSO() {
        return this.eQA;
    }

    public NoNetworkView aSP() {
        return this.bES;
    }

    public void aSQ() {
        if (this.Lr != null) {
            this.Lr.hide();
        }
    }

    public PbFakeFloorModel aSR() {
        return this.eKG;
    }

    public q aSS() {
        return this.eQl;
    }

    public void aST() {
        reset();
        aSQ();
        this.eQl.aRp();
        hi(false);
    }

    private void reset() {
        if (this.eGA != null && this.eGA.aQi() != null && this.Lr != null) {
            com.baidu.tbadk.editortools.pb.a.Dw().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aQi = this.eGA.aQi();
            aQi.DQ();
            if (aQi.getWriteImagesInfo() != null) {
                aQi.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aQi.eN(10);
            aQi.eL(SendView.ALL);
            aQi.eM(SendView.ALL);
            com.baidu.tbadk.editortools.l eC = this.Lr.eC(23);
            com.baidu.tbadk.editortools.l eC2 = this.Lr.eC(2);
            com.baidu.tbadk.editortools.l eC3 = this.Lr.eC(5);
            if (eC2 != null) {
                eC2.lT();
            }
            if (eC3 != null) {
                eC3.lT();
            }
            if (eC != null) {
                eC.hide();
            }
            this.Lr.invalidate();
        }
    }

    public boolean aSU() {
        return this.ePN;
    }

    public void hj(boolean z) {
        if (this.ePI != null && this.ePJ != null) {
            this.ePJ.setText(d.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ePI.startAnimation(alphaAnimation);
            }
            this.ePI.setVisibility(0);
            this.ePN = true;
            if (this.eQa != null) {
                this.eQa.setVisibility(0);
            }
        }
    }

    public void hk(boolean z) {
        if (this.ePI != null && this.ePJ != null) {
            this.ePJ.setText(d.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ePI.startAnimation(alphaAnimation);
            }
            this.ePI.setVisibility(0);
            this.ePN = true;
            if (this.eQa != null) {
                this.eQa.setVisibility(0);
            }
        }
    }

    public PostData aSV() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.eOq == null) {
            return null;
        }
        int firstVisiblePosition = this.eOq.getFirstVisiblePosition();
        int lastVisiblePosition = this.eOq.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eOq.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.eOq.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.eOq.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.ePa.oU(headerViewsCount) != null && this.ePa.oU(headerViewsCount) != PostData.ghN) {
            i2 = headerViewsCount + 1;
        }
        return this.ePa.getItem(i2) instanceof PostData ? (PostData) this.ePa.getItem(i2) : null;
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.aRo = 0;
        this.eOd = 0;
        this.eOe = 0;
        this.eOf = 0;
        this.eGA = null;
        this.bYq = null;
        this.caD = null;
        this.eOq = null;
        this.eOs = null;
        this.eOw = null;
        this.eOx = null;
        this.eOy = null;
        this.eOA = null;
        this.eOC = null;
        this.eOE = null;
        this.eOH = null;
        this.eOI = null;
        this.eOJ = null;
        this.eOP = null;
        this.eOR = null;
        this.eOS = null;
        this.bDL = null;
        this.eOW = null;
        this.eOX = null;
        this.ePa = null;
        this.ePf = null;
        this.aIR = null;
        this.ckz = null;
        this.eFz = null;
        this.ePI = null;
        this.ePJ = null;
        this.ePK = null;
        this.ePM = null;
        this.ePU = null;
        this.ePV = null;
        this.ePW = null;
        this.eGA = pbActivity;
        this.ckz = onClickListener;
        this.aRN = cVar;
        this.bYq = (RelativeLayout) LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.new_pb_activity, (ViewGroup) null);
        this.bYq.getViewTreeObserver().addOnGlobalLayoutListener(this.eQN);
        this.eGA.addContentView(this.bYq, new FrameLayout.LayoutParams(-1, -1));
        this.caD = this.eGA.findViewById(d.h.statebar_view);
        this.eOZ = (ObservedChangeLinearLayout) this.eGA.findViewById(d.h.title_wrapper);
        this.bES = (NoNetworkView) this.eGA.findViewById(d.h.view_no_network);
        this.eOq = (PbLandscapeListView) this.eGA.findViewById(d.h.new_pb_list);
        this.ayF = new TextView(this.eGA.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eGA.getActivity(), d.f.ds98));
        this.eOq.addHeaderView(this.ayF, 0);
        View view = new View(this.eGA.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.eGA.getResources().getDimensionPixelSize(d.f.ds100)));
        view.setVisibility(4);
        this.eOq.addFooterView(view);
        this.eOq.setOnTouchListener(this.eGA.aMS);
        this.eOm = new com.baidu.tieba.pb.pb.main.view.d(pbActivity);
        this.eQm = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.eOm.eUw);
        this.eQm.hK(1);
        if (this.eGA.aQJ()) {
            this.eOo = (ViewStub) this.eGA.findViewById(d.h.manga_view_stub);
            this.eOo.setVisibility(0);
            this.eOn = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
            this.eOn.show();
            this.eOm.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.ayF.setLayoutParams(layoutParams);
        this.eOm.aUF().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0107a() { // from class: com.baidu.tieba.pb.pb.main.aq.6
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0107a
            public void aga() {
                if (aq.this.eOq != null) {
                    if (aq.this.eOh != null) {
                        aq.this.eOh.aWf();
                    }
                    aq.this.eOq.smoothScrollToPosition(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0107a
            public void afZ() {
                aq.this.eGA.afp();
            }
        }));
        this.ePI = this.eGA.findViewById(d.h.pb_editor_tool_comment);
        this.ePP = com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds110);
        this.ePQ = com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds156);
        this.ePR = this.ePP;
        this.ePJ = (TextView) this.eGA.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_text);
        this.ePK = (ViewGroup) this.eGA.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_layout);
        this.ePM = (TextView) this.eGA.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_praise_icon);
        this.ePM.setVisibility(8);
        this.ePK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!aq.this.eGA.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", aq.this.mForumId));
                } else if (aq.this.eLd == null || !com.baidu.tieba.pb.e.T(aq.this.eLd.aPj())) {
                    if (aq.this.Lr != null) {
                        aq.this.aTf();
                    }
                    if (aq.this.Lr != null) {
                        aq.this.ePN = false;
                        com.baidu.tieba.tbadkCore.b.a.a(aq.this.eGA, (View) aq.this.Lr.eE(2).aCc, false, aq.this.eQq);
                    }
                    aq.this.aTC();
                }
            }
        });
        this.ePM.setOnClickListener(this.ckz);
        this.ePM.setOnTouchListener(this.eGA);
        this.eOs = LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_item, (ViewGroup) null);
        this.eOw = (LinearLayout) LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_user_item, (ViewGroup) null);
        this.eOz = new e(this.eGA, this.eOw);
        this.eOz.init();
        this.eOz.b(this.eOz.aQh(), this.ckz);
        this.eOA = (ColumnLayout) this.eOw.findViewById(d.h.pb_head_owner_root);
        this.eOB = (ThreadSkinView) this.eOw.findViewById(d.h.pb_thread_skin);
        this.eOA.setOnLongClickListener(this.onLongClickListener);
        this.eOA.setOnTouchListener(this.aRN);
        this.eOA.setVisibility(8);
        this.eOs.setOnTouchListener(this.aRN);
        this.ePU = this.eOs.findViewById(d.h.pb_head_activity_join_number_container);
        this.ePU.setVisibility(8);
        this.ePV = (TextView) this.eOs.findViewById(d.h.pb_head_activity_join_number);
        this.eOC = (TextView) this.eOA.findViewById(d.h.pb_head_owner_info_user_name);
        this.eOD = (TextView) this.eOw.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eOE = (TextView) this.eOA.findViewById(d.h.floor_owner);
        this.eOF = (ImageView) this.eOA.findViewById(d.h.icon_forum_level);
        this.eOH = (FrameLayout) this.eOA.findViewById(d.h.pb_head_headImage_container);
        this.eOI = (HeadImageView) this.eOA.findViewById(d.h.pb_head_owner_photo);
        this.eOG = (HeadPendantView) this.eOA.findViewById(d.h.pb_pendant_head_owner_photo);
        this.eOG.wD();
        if (this.eOG.getHeadView() != null) {
            this.eOG.getHeadView().setIsRound(true);
            this.eOG.getHeadView().setDrawBorder(false);
        }
        if (this.eOG.getPendantView() != null) {
            this.eOG.getPendantView().setIsRound(true);
            this.eOG.getPendantView().setDrawBorder(false);
        }
        this.eKi = (UserIconBox) this.eOA.findViewById(d.h.show_icon_vip);
        this.eKj = (UserIconBox) this.eOA.findViewById(d.h.show_icon_yinji);
        this.eOK = (FloatingLayout) this.eOw.findViewById(d.h.pb_head_owner_info_root);
        this.eOP = (PbFirstFloorUserLikeButton) this.eOA.findViewById(d.h.pb_like_button);
        this.eOQ = new ao(pbActivity.getPageContext(), this.eOP, 1);
        this.eOR = (TextView) this.eOA.findViewById(d.h.pb_views);
        this.eOS = (TextView) this.eOA.findViewById(d.h.pb_item_first_floor_reply_time);
        this.bDL = (TextView) this.eOA.findViewById(d.h.pb_item_first_floor_location_address);
        this.eQB = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eQC = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eOW = this.eOs.findViewById(d.h.new_pb_header_item_line_above_livepost);
        this.eOy = LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.layout_read_thread, (ViewGroup) null);
        this.eOx = (TextView) this.eOy.findViewById(d.h.pb_head_read_button);
        this.eOw.addView(this.eOy);
        this.eOx.setOnClickListener(this.ckz);
        this.eOf = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds2);
        this.eOe = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds18);
        this.eOd = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds20);
        this.aRo = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds32);
        this.eOX = this.eOs.findViewById(d.h.new_pb_header_item_line_below_livepost);
        this.eOs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.23
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return false;
            }
        });
        this.ePW = (ViewStub) this.bYq.findViewById(d.h.interview_status_stub);
        this.ePa = new g(this.eGA, this.eOq);
        this.ePa.t(this.ckz);
        this.ePa.setTbGestureDetector(this.aRN);
        this.ePa.setOnImageClickListener(this.aRM);
        this.eFz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.Vm() || !com.baidu.tieba.c.a.a(aq.this.eGA.getBaseContext(), aq.this.eGA.aQn().getThreadID(), (String) sparseArray.get(d.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.h.tag_from, 1);
                                aq.this.eGA.d(sparseArray);
                                return;
                            }
                            aq.this.bf(view2);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.h.tag_from, 0);
                        sparseArray.put(d.h.tag_check_mute_from, 1);
                        aq.this.eGA.d(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.ePa.G(this.eFz);
        aSZ();
        this.eOq.addHeaderView(this.eOu);
        this.eOq.addHeaderView(this.eOw);
        this.eOq.addHeaderView(this.eOs);
        this.ePf = new PbListView(this.eGA.getPageContext().getPageActivity());
        this.aIR = this.ePf.getView().findViewById(d.h.pb_more_view);
        if (this.aIR != null) {
            this.aIR.setOnClickListener(this.ckz);
            com.baidu.tbadk.core.util.ai.j(this.aIR, d.g.pb_foot_more_trans_selector);
        }
        this.ePf.wS();
        this.ePf.dn(d.g.pb_foot_more_trans_selector);
        this.ePf.m10do(d.g.pb_foot_more_trans_selector);
        this.ePh = this.eGA.findViewById(d.h.viewstub_progress);
        this.eGA.registerListener(this.eQG);
        this.eOJ = com.baidu.tbadk.ala.b.nC().h(this.eGA.getActivity(), 2);
        if (this.eOJ != null) {
            this.eOJ.setVisibility(8);
            this.eOK.addView(this.eOJ);
        }
        this.eKG = new PbFakeFloorModel(this.eGA.getPageContext());
        this.eQl = new q(this.eGA.getPageContext(), this.eKG, this.bYq);
        this.eKG.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.25
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                aq.this.eKG.m(postData);
                aq.this.ePa.notifyDataSetChanged();
                aq.this.eQl.aRp();
            }
        });
        if (this.eGA.aQn() != null && !StringUtils.isNull(this.eGA.aQn().aSd())) {
            this.eGA.showToast(this.eGA.aQn().aSd());
        }
        this.eGA.registerListener(this.dEn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSW() {
        if (this.eQa != null) {
            int[] iArr = new int[2];
            this.ePI.getLocationOnScreen(iArr);
            this.eQa.setBottomMargin((((ViewGroup) this.eGA.getPageContext().getPageActivity().getWindow().getDecorView()).getHeight() - this.ePR) - iArr[1]);
        }
    }

    public void aSX() {
        if (this.eOq != null) {
            this.eOq.removeHeaderView(this.eOu);
            this.eOq.removeHeaderView(this.eOw);
            this.eOq.removeHeaderView(this.eOs);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eQa == null) {
            this.eQa = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eGA.getPageContext().getPageActivity());
            ViewGroup viewGroup = (ViewGroup) this.eGA.getPageContext().getPageActivity().getWindow().getDecorView();
            int[] iArr = new int[2];
            this.ePI.getLocationOnScreen(iArr);
            this.eQa.a(viewGroup, (viewGroup.getHeight() - this.ePP) - iArr[1], aVar);
            this.eQa.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.26
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void cD(List<String> list) {
                    aq.this.eGA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(aq.this.eGA.getPageContext().getPageActivity(), 25016, (ArrayList) list)));
                }
            });
            this.eQa.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.aq.27
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void ag(float f) {
                    if (aq.this.ePI != null) {
                        ViewGroup.LayoutParams layoutParams = aq.this.ePI.getLayoutParams();
                        layoutParams.height = (int) (((aq.this.ePQ - aq.this.ePP) * f) + aq.this.ePP);
                        aq.this.ePK.setAlpha(1.0f - f);
                        aq.this.ePI.setLayoutParams(layoutParams);
                        aq.this.ePR = layoutParams.height;
                    }
                }
            });
        }
    }

    private boolean l(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPj() == null || !fVar.aPD() || !TbadkCoreApplication.getInst().isTTSCanUse() || fVar.aPj().rC() == 1 || fVar.aPj().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aPj().rE() == null || fVar.aPj().rE().te() == 0) && !fVar.aPj().sx()) {
            BdUniqueId type = fVar.aPj().getType();
            return type == bl.Za || type == bl.Zc || type == bl.YZ;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.eOy != null) {
            if (!z) {
                this.eOy.setVisibility(8);
            } else if (!l(fVar)) {
                this.eOy.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aPl() != null && fVar.aPl().size() > 0) {
                    postData = fVar.aPl().get(0);
                }
                if (postData != null && postData.bsy() == 1) {
                    t(this.aRo, this.eOe, this.aRo, this.eOf);
                } else {
                    t(this.aRo, this.eOe, this.aRo, this.eOd);
                }
                this.eOy.setVisibility(0);
            }
        }
    }

    private void t(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOx.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.eOx.setLayoutParams(layoutParams);
    }

    public TextView aSY() {
        return this.eOx;
    }

    private void aSZ() {
        if (this.eOu == null) {
            int g = com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds34);
            this.eOu = new LinearLayout(this.eGA.getPageContext().getPageActivity());
            this.eOu.setOrientation(1);
            this.eOu.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eOu.setPadding(g, com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds40), g, com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds46));
            this.eOu.setGravity(17);
            this.eOv = new TextView(this.eGA.getPageContext().getPageActivity());
            this.eOv.setGravity(3);
            this.eOv.setMaxLines(2);
            this.eOv.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            this.eOv.setPadding(0, 0, 0, 0);
            this.eOv.setLineSpacing(com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.ai.i(this.eOv, d.e.cp_cont_b);
            this.eOv.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds48));
            this.eOv.setVisibility(8);
            this.eOu.addView(this.eOv);
            this.eOu.setOnTouchListener(this.aRN);
            this.eOu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTa() {
        if (this.eGA.aQJ()) {
            this.eOp = (ViewStub) this.eGA.findViewById(d.h.manga_mention_controller_view_stub);
            this.eOp.setVisibility(0);
            if (this.eOT == null) {
                this.eOT = (LinearLayout) this.eGA.findViewById(d.h.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.eGA.getPageContext(), this.eOT);
            }
            if (this.eOU == null) {
                this.eOU = (TextView) this.eOT.findViewById(d.h.manga_prev_btn);
            }
            if (this.eOV == null) {
                this.eOV = (TextView) this.eOT.findViewById(d.h.manga_next_btn);
            }
            this.eOU.setOnClickListener(this.ckz);
            this.eOV.setOnClickListener(this.ckz);
        }
    }

    private void aTb() {
        if (this.eGA.aQJ()) {
            if (this.eGA.aQM() == -1) {
                com.baidu.tbadk.core.util.ai.c(this.eOU, d.e.cp_cont_e, 1);
            }
            if (this.eGA.aQN() == -1) {
                com.baidu.tbadk.core.util.ai.c(this.eOV, d.e.cp_cont_e, 1);
            }
        }
    }

    public void aTc() {
        if (this.eOT == null) {
            aTa();
        }
        this.eOp.setVisibility(8);
        if (this.eQE != null && this.eQF != null) {
            this.eQE.removeCallbacks(this.eQF);
        }
    }

    public void aTd() {
        if (this.eQE != null) {
            if (this.eQF != null) {
                this.eQE.removeCallbacks(this.eQF);
            }
            this.eQF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.eOT == null) {
                        aq.this.aTa();
                    }
                    aq.this.eOp.setVisibility(0);
                }
            };
            this.eQE.postDelayed(this.eQF, 2000L);
        }
    }

    public void jD(boolean z) {
        this.eOm.jD(z);
        if (z && this.ePT) {
            this.ePf.setText(this.eGA.getResources().getString(d.l.click_load_more));
            this.eOq.setNextPage(this.ePf);
            this.eOl = 2;
        }
    }

    public void aTe() {
        TbadkCoreApplication.getInst().setReadThreadPlayerScreenMaxHeight(this.bYq.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.Lr = iVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.bYq.addView(this.Lr, layoutParams);
        this.Lr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aSQ();
    }

    public void aTf() {
        if (this.eGA != null && this.Lr != null) {
            this.Lr.lT();
            aTC();
        }
    }

    public void S(String str, boolean z) {
        this.ePO = z;
        aO(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void aO(boolean z) {
        if (this.ePM != null) {
            if (this.ePO) {
                com.baidu.tbadk.core.util.ai.j(this.ePM, d.g.pb_praise_already_click_selector);
                this.ePM.setContentDescription(this.eGA.getResources().getString(d.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.ai.j(this.ePM, d.g.pb_praise_normal_click_selector);
            this.ePM.setContentDescription(this.eGA.getResources().getString(d.l.frs_item_praise_text));
        }
    }

    public TextView aTg() {
        return this.ePM;
    }

    public void jE(boolean z) {
        if (this.eOq != null && this.ayF != null && this.caD != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.caD.setVisibility(0);
                } else {
                    this.caD.setVisibility(8);
                    this.eOq.removeHeaderView(this.ayF);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ayF.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.ayF.setLayoutParams(layoutParams);
                }
                aTu();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ayF.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jL(true);
                this.ayF.setLayoutParams(layoutParams2);
            }
            aTu();
            aTL();
        }
    }

    public g aTh() {
        return this.ePa;
    }

    public void aTi() {
        if (this.ePa != null) {
            this.ePa.aRg();
        }
    }

    public void a(PbActivity.c cVar) {
        this.eIn = cVar;
    }

    private void a(bo boVar) {
        if (boVar == null || boVar.te() == 0) {
            if (this.ePH != null) {
                this.ePH.setVisibility(8);
            }
            if (this.eOW != null) {
                this.eOW.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ePH == null) {
            this.eGA.getLayoutMode().t(((ViewStub) this.eOs.findViewById(d.h.live_talk_layout)).inflate());
            this.ePH = (Button) this.eOs.findViewById(d.h.pb_head_function_manage_go_to_live_post);
            this.eOW = this.eOs.findViewById(d.h.new_pb_header_item_line_above_livepost);
        }
        int tf = boVar.tf();
        String string = this.eGA.getPageContext().getString(d.l.go_to_live_post_prefix);
        if (tf == 0) {
            string = string + this.eGA.getPageContext().getString(d.l.go_to_interview_post);
        } else if (tf == 1) {
            string = string + this.eGA.getPageContext().getString(d.l.go_to_discuss_post);
        }
        this.ePH.setText(string);
        this.ePH.setVisibility(0);
        this.ePH.setOnClickListener(this.ckz);
        this.eQK = true;
        aTv();
    }

    public void bf(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.ePj == null) {
            this.ePj = LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eGA.getLayoutMode().t(this.ePj);
        if (this.ePi == null) {
            this.ePi = new Dialog(this.eGA.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.ePi.setCanceledOnTouchOutside(true);
            this.ePi.setCancelable(true);
            this.ePi.setContentView(this.ePj);
            WindowManager.LayoutParams attributes = this.ePi.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.ag(this.eGA.getPageContext().getPageActivity()) * 0.9d);
            this.ePi.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ePi.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.ePi.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.ePi.findViewById(d.h.disable_reply_btn);
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
                    if (aq.this.ePi != null && (aq.this.ePi instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.ePi, aq.this.eGA.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        aq.this.a(((Integer) sparseArray5.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.h.tag_del_post_id), ((Integer) sparseArray5.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.h.tag_forbid_user_name)) || aTI()) {
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
                    if (aq.this.ePi != null && (aq.this.ePi instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.ePi, aq.this.eGA.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && aq.this.eQH != null) {
                        aq.this.eQH.g(new Object[]{sparseArray6.get(d.h.tag_manage_user_identity), sparseArray6.get(d.h.tag_forbid_user_name), sparseArray6.get(d.h.tag_forbid_user_post_id)});
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
                    if (aq.this.ePi != null && (aq.this.ePi instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.ePi, aq.this.eGA.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        aq.this.eGA.a(z, (String) sparseArray7.get(d.h.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ePi, this.eGA.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.eQH = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eQe, Integer.valueOf(eQf));
        int i3 = d.l.del_post_confirm;
        if (i == 0) {
            i3 = d.l.del_thread_confirm;
        }
        this.ePk = new com.baidu.tbadk.core.dialog.a(this.eGA.getActivity());
        this.ePk.cc(i3);
        this.ePk.A(sparseArray);
        this.ePk.a(d.l.dialog_ok, this.eGA);
        this.ePk.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ePk.ar(true);
        this.ePk.b(this.eGA.getPageContext());
        this.ePk.tr();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.ePw == null) {
            this.ePw = LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.commit_good, (ViewGroup) null);
        }
        this.eGA.getLayoutMode().t(this.ePw);
        if (this.ePv == null) {
            this.ePv = new Dialog(this.eGA.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.ePv.setCanceledOnTouchOutside(true);
            this.ePv.setCancelable(true);
            this.ePG = (ScrollView) this.ePw.findViewById(d.h.good_scroll);
            this.ePv.setContentView(this.ePw);
            WindowManager.LayoutParams attributes = this.ePv.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds540);
            this.ePv.getWindow().setAttributes(attributes);
            this.ePy = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.ePB = (String) compoundButton.getTag();
                        if (aq.this.eOr != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : aq.this.eOr) {
                                String str = (String) aVar.getTag();
                                if (str != null && aq.this.ePB != null && !str.equals(aq.this.ePB)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.ePx = (LinearLayout) this.ePw.findViewById(d.h.good_class_group);
            this.ePA = (TextView) this.ePw.findViewById(d.h.dialog_button_cancel);
            this.ePA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.ePv instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.ePv, aq.this.eGA.getPageContext());
                    }
                }
            });
            this.ePz = (TextView) this.ePw.findViewById(d.h.dialog_button_ok);
            this.ePz.setOnClickListener(this.ckz);
        }
        this.ePx.removeAllViews();
        this.eOr = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bM = bM("0", this.eGA.getPageContext().getString(d.l.def_good_class));
        this.eOr.add(bM);
        bM.setChecked(true);
        this.ePx.addView(bM);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bM2 = bM(String.valueOf(arrayList.get(i2).qa()), arrayList.get(i2).pZ());
                this.eOr.add(bM2);
                View view = new View(this.eGA.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds1));
                com.baidu.tbadk.core.util.ai.k(view, d.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.ePx.addView(view);
                this.ePx.addView(bM2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.ePG.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eGA.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eGA.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eGA.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.ePG.setLayoutParams(layoutParams2);
            this.ePG.removeAllViews();
            this.ePG.addView(this.ePx);
        }
        com.baidu.adp.lib.g.g.a(this.ePv, this.eGA.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bM(String str, String str2) {
        Activity pageActivity = this.eGA.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, d.f.ds100));
        aVar.setOnCheckedChangeListener(this.ePy);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aTj() {
        this.eGA.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eGA.hideProgressBar();
        if (z && z2) {
            this.eGA.showToast(this.eGA.getPageContext().getString(d.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.al.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.l.neterror);
            }
            this.eGA.showToast(str);
        }
    }

    public void avO() {
        this.ePh.setVisibility(0);
    }

    public void avN() {
        this.ePh.setVisibility(8);
    }

    public View aTk() {
        if (this.ePw != null) {
            return this.ePw.findViewById(d.h.dialog_button_ok);
        }
        return null;
    }

    public String aTl() {
        return this.ePB;
    }

    public View getView() {
        return this.bYq;
    }

    public void aTm() {
        com.baidu.adp.lib.util.k.b(this.eGA.getPageContext().getPageActivity(), this.eGA.getCurrentFocus());
    }

    public void jF(boolean z) {
        this.eGA.hideProgressBar();
        aBk();
    }

    public void aTn() {
        this.ePf.wS();
        this.ePf.wW();
    }

    public void aTo() {
        this.eGA.hideProgressBar();
        wX();
        this.eOq.completePullRefreshPostDelayed(2000L);
        aTv();
    }

    public void aTp() {
        this.eOq.completePullRefreshPostDelayed(2000L);
        aTv();
    }

    public void jG(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ePK.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eGA.getResources().getDimensionPixelSize(d.f.ds84) : 0;
        this.ePK.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.ePa.setOnLongClickListener(onLongClickListener);
    }

    public void a(b.InterfaceC0043b interfaceC0043b, boolean z, boolean z2) {
        if (this.ePC != null) {
            this.ePC.dismiss();
            this.ePC = null;
        }
        this.ePC = new com.baidu.tbadk.core.dialog.b(this.eGA.getPageContext().getPageActivity());
        this.ePC.cf(d.l.operation);
        if (z2) {
            this.ePC.a(new String[]{this.eGA.getPageContext().getString(d.l.copy)}, interfaceC0043b);
        } else if (!z) {
            this.ePC.a(new String[]{this.eGA.getPageContext().getString(d.l.copy), this.eGA.getPageContext().getString(d.l.mark)}, interfaceC0043b);
        } else {
            this.ePC.a(new String[]{this.eGA.getPageContext().getString(d.l.copy), this.eGA.getPageContext().getString(d.l.remove_mark)}, interfaceC0043b);
        }
        this.ePC.d(this.eGA.getPageContext());
        this.ePC.tu();
    }

    public void a(b.InterfaceC0043b interfaceC0043b, boolean z) {
        if (this.ePD != null) {
            this.ePD.dismiss();
            this.ePD = null;
        }
        this.ePD = new com.baidu.tbadk.core.dialog.b(this.eGA.getPageContext().getPageActivity());
        this.ePD.cf(d.l.operation);
        if (z) {
            this.ePD.a(new String[]{this.eGA.getPageContext().getString(d.l.save_to_emotion)}, interfaceC0043b);
        } else {
            this.ePD.a(new String[]{this.eGA.getPageContext().getString(d.l.save_to_emotion), this.eGA.getPageContext().getString(d.l.pb_save_image)}, interfaceC0043b);
        }
        this.ePD.d(this.eGA.getPageContext());
        this.ePD.tu();
    }

    public int aTq() {
        return pj(this.eOq.getFirstVisiblePosition());
    }

    private int pj(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.eOq.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eOq.getAdapter() == null || !(this.eOq.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.eOq.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aTr() {
        int lastVisiblePosition = this.eOq.getLastVisiblePosition();
        if (this.eOh != null) {
            if (lastVisiblePosition == this.eOq.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.ePa.aRh();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pj(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.eOq.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.ePd.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.f fVar) {
        this.ePa.a(fVar, false);
        this.ePa.notifyDataSetChanged();
        aTv();
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        if (this.eON == null) {
            this.eGA.getLayoutMode().t(((ViewStub) this.eOs.findViewById(d.h.praise_layout)).inflate());
            this.eON = (FrsPraiseView) this.eOs.findViewById(d.h.pb_head_praise_view);
            this.eON.setIsFromPb(true);
            this.eOY = this.eOs.findViewById(d.h.new_pb_header_item_line_above_praise);
            this.eON.dt(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eON != null) {
            boolean aTv = aTv();
            this.eON.setVisibility(8);
            if (fVar != null && fVar.qH() != null && fVar.qH().qE() == 0 && this.eFv) {
                if (aTv) {
                    this.eOX.setVisibility(0);
                } else {
                    this.eOX.setVisibility(8);
                }
            } else {
                this.eOX.setVisibility(8);
            }
            com.baidu.tieba.graffiti.b.aq(this.eOX);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aPs() != null) {
            return fVar.aPs();
        }
        if (z) {
            if (fVar == null || fVar.aPl() == null || fVar.aPl().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPl().get(0);
            if (postData.bsy() != 1) {
                postData = a(fVar);
            }
            if (postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
                return postData;
            }
            return postData;
        }
        PostData aPq = fVar.aPq();
        if (aPq == null) {
            return a(fVar);
        }
        return aPq;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPj() == null || fVar.aPj().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aPj().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPj().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.ti(1);
        postData.setId(fVar.aPj().rV());
        postData.setTitle(fVar.aPj().getTitle());
        postData.setTime(fVar.aPj().getCreateTime());
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
        com.baidu.tbadk.data.h bsB;
        String portrait;
        if (fVar != null && fVar.aPj() != null) {
            PostData c = c(fVar, z);
            a(c, fVar);
            aTJ();
            this.eOA.setVisibility(8);
            if (fVar.aPj() != null && fVar.aPj().ss() && fVar.aPj().rW() != null) {
                this.eQp = true;
                this.eOm.jV(this.eQp);
                if (this.eOh == null) {
                    this.eOh = new com.baidu.tieba.pb.video.i(this.eGA, this.eOm, fVar.aPj().rW());
                    this.eOh.a(fVar.aPj().rW(), fVar.aPj(), fVar.getForumId());
                    this.eOh.startPlay();
                } else if (this.eOk) {
                    this.eOh.a(fVar.aPj().rW(), fVar.aPj(), fVar.getForumId());
                    this.eOh.startPlay();
                }
                if (fVar.aPk() != null && fVar.aPk().size() >= 1) {
                    bl blVar = fVar.aPk().get(0);
                    this.eOh.ab(blVar);
                    this.eOh.pN(blVar.getTitle());
                }
                this.eOh.b(c, fVar.aPj(), fVar.aPG());
                this.eOk = false;
                this.eOq.removeHeaderView(this.eOh.aWe());
                this.eOq.addHeaderView(this.eOh.aWe(), 0);
                if (this.eOi == null) {
                    this.eOi = new com.baidu.tieba.pb.video.h(this.eGA);
                }
                this.eOi.a(fVar.aPj().sJ(), fVar.aPj(), fVar.aPC());
                this.eOq.removeHeaderView(this.eOi.aVV());
                this.eOq.addHeaderView(this.eOi.aVV(), 1);
                if (fVar.aPj().sJ() != null) {
                    this.eOq.removeHeaderView(this.eOi.aVW());
                    this.eOq.removeHeaderView(this.eOw);
                    this.eOq.addHeaderView(this.eOi.aVW(), 2);
                } else {
                    if (this.eOi.aVW() != null) {
                        this.eOq.removeHeaderView(this.eOi.aVW());
                    }
                    this.eOq.removeHeaderView(this.eOw);
                    this.eOq.addHeaderView(this.eOw, 2);
                }
                if (this.eOh != null) {
                    this.eOh.px(0);
                }
                aTu();
            } else {
                this.eQp = false;
                this.eOm.jV(this.eQp);
                this.eOm.eUv.setVisibility(0);
                if (this.eOh != null) {
                    this.eOq.removeHeaderView(this.eOh.aWe());
                }
                if (this.eOi != null) {
                    this.eOi.e(this.eOq);
                }
            }
            if (this.eGA.aQl() != null) {
                this.eGA.aQl().jR(this.eQp);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eQp) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11923").r("obj_id", 2));
                    }
                    if (aq.this.eGA.eHq.eTL != null) {
                        if (!aq.this.eQp && aq.this.eLd != null && aq.this.eLd.aPj() != null && aq.this.eLd.aPj().getAuthor() != null && aq.this.eLd.aPj().getAuthor().isBigV()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12151").r("obj_locate", 1));
                        }
                        aq.this.eGA.eHq.eTL.onClick(view);
                    }
                }
            };
            if (this.eOh != null) {
                this.eOh.J(onClickListener);
            }
            b(fVar, z);
            if (c != null) {
                this.ePS = c;
                if (fVar != null && fVar.aPj() != null && fVar.aPj().getAuthor() != null) {
                    fVar.aPj().getAuthor().getUserId();
                    if (fVar.qH() != null) {
                        this.eQu = fVar.qH().qA();
                        if (fVar.qH().qD() == 1) {
                        }
                    }
                }
                this.eOA.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eOA.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eOA.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_clip_board, c);
                sparseArray.put(d.h.tag_is_subpb, false);
                if (!this.eQz) {
                    this.eOu.setVisibility(0);
                }
                if (!fVar.aPj().ss() && this.eOv.getText() != null && this.eOv.getText().length() > 0) {
                    this.eOv.setVisibility(0);
                } else {
                    this.eOv.setVisibility(8);
                }
                n(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rQ = fVar.aPj().rQ();
                if (rQ != null && rQ.size() > 0 && !this.eQz) {
                    this.ePV.setText(String.valueOf(rQ.get(0).pr()));
                    this.ePU.setVisibility(0);
                    this.eQJ = true;
                } else {
                    this.ePU.setVisibility(8);
                }
                com.baidu.tbadk.core.util.ai.j(this.ePU, d.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.ai.c(this.ePV, d.e.cp_link_tip_d, 1);
                if (c.getAuthor() != null) {
                    this.rank = c.getAuthor().getLevel_id();
                    String string = c.getAuthor().getName_show() == null ? StringUtils.string(c.getAuthor().getUserName()) : StringUtils.string(c.getAuthor().getName_show());
                    if (StringUtils.isNull(c.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aS(c.getAuthor().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aS(string) > 12) {
                            d = com.baidu.tbadk.core.util.al.d(string, 12, "...");
                            int i3 = 3;
                            if (!StringUtils.isNull(string)) {
                                int aS = com.baidu.adp.lib.util.j.aS(c.getAuthor().getName_show());
                                if (aS + i2 > 14) {
                                    i3 = 0;
                                } else if (aS + i2 >= 12) {
                                    i3 = 1;
                                } else if (aS + i2 >= 10) {
                                    i3 = 2;
                                }
                            }
                            ArrayList<IconData> iconInfo = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eKj != null) {
                                this.eKj.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                                this.eKj.setOnClickListener(this.eGA.eHq.cst);
                                this.eKj.a(iconInfo, i3, this.eGA.getResources().getDimensionPixelSize(d.f.ds26), this.eGA.getResources().getDimensionPixelSize(d.f.ds26), this.eGA.getResources().getDimensionPixelSize(d.f.ds8));
                            }
                            if (this.eKi != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eKi.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eKi.setOnClickListener(this.eGA.eHq.eTM);
                                this.eKi.a(tShowInfoNew, 3, this.eGA.getResources().getDimensionPixelSize(d.f.ds36), this.eGA.getResources().getDimensionPixelSize(d.f.ds36), this.eGA.getResources().getDimensionPixelSize(d.f.ds8), true);
                            }
                            this.eOC.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.eOC.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                            this.eOC.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.u.v(tShowInfoNew) || c.getAuthor().isBigV()) {
                                com.baidu.tbadk.core.util.ai.c(this.eOC, d.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.ai.c(this.eOC, d.e.cp_cont_f, 1);
                            }
                            if (c == null && !TextUtils.isEmpty(c.getAuthor().getGodIntro())) {
                                this.eOD.setVisibility(0);
                                this.eOD.setText(ap.a(c.getAuthor()));
                            } else {
                                this.eOD.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.ai.c(this.eOE, d.e.cp_link_tip_a, 1);
                            this.eOE.setVisibility(0);
                            if (fVar.aPj().getAuthor() != null && fVar.aPj().getAuthor().getAlaUserData() != null && this.eOJ != null) {
                                if (fVar.aPj().getAuthor().getAlaUserData().anchor_live != 0) {
                                    this.eOJ.setVisibility(8);
                                } else {
                                    this.eOJ.setVisibility(0);
                                    if (this.eOj == null) {
                                        this.eOj = new com.baidu.tieba.d.a(this.eGA.getPageContext(), this.eOJ);
                                        this.eOj.hK(1);
                                    }
                                    this.eOj.aH(this.eGA.getResources().getString(d.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Ro = fVar.aPj().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.eOJ.setTag(aVar);
                                }
                            }
                            this.eOI.setUserId(c.getAuthor().getUserId());
                            this.eOI.setUserName(c.getAuthor().getUserName());
                            this.eOI.setImageDrawable(null);
                            this.eOI.setRadius(com.baidu.adp.lib.util.k.g(this.eGA.getActivity(), d.f.ds40));
                            this.eOI.setTag(c.getAuthor().getUserId());
                            this.eOS.setText(c.bsA());
                            bsB = c.bsB();
                            if (bsB == null && !TextUtils.isEmpty(bsB.getName()) && !TextUtils.isEmpty(bsB.getName().trim())) {
                                final String name = bsB.getName();
                                final String lat = bsB.getLat();
                                final String lng = bsB.getLng();
                                this.bDL.setVisibility(0);
                                this.bDL.setText(bsB.getName());
                                this.bDL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.i.hr()) {
                                                aq.this.eGA.showToast(d.l.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.T(aq.this.eGA.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, aq.this.eGA.getPageContext().getString(d.l.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.bDL.setVisibility(8);
                            }
                            this.eOQ.a(c.getAuthor());
                            this.eOQ.eOa = this.eQp;
                            if (!this.ePF) {
                                this.eOP.setVisibility(8);
                                this.eOR.setVisibility(0);
                                this.eOR.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_thread_views), com.baidu.tbadk.core.util.al.x(fVar.aPF())));
                            } else if (!PbNormalLikeButtonSwitchStatic.GS() || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                                this.eOP.setVisibility(8);
                                this.eOR.setVisibility(8);
                            } else {
                                this.eOP.setVisibility(0);
                                this.eOP.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eGA.getActivity(), d.f.ds24));
                                this.eOR.setVisibility(8);
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null && !StringUtils.isNull(c.getAuthor().getPendantData().pV())) {
                                UtilHelper.showHeadImageViewBigV(this.eOG.getHeadView(), c.getAuthor());
                                this.eOI.setVisibility(8);
                                this.eOG.setVisibility(0);
                                if (this.eOO != null) {
                                    this.eOO.setVisibility(8);
                                }
                                this.eOC.setOnClickListener(onClickListener);
                                this.eOG.getHeadView().c(portrait, 28, false);
                                this.eOG.getHeadView().setUserId(c.getAuthor().getUserId());
                                this.eOG.getHeadView().setUserName(c.getAuthor().getUserName());
                                this.eOG.getHeadView().setOnClickListener(onClickListener);
                                this.eOG.et(c.getAuthor().getPendantData().pV());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eOI, c.getAuthor());
                                this.eOI.setVisibility(0);
                                this.eOA.setOnClickListener(onClickListener);
                                this.eOC.setOnClickListener(onClickListener);
                                this.eOI.setOnClickListener(onClickListener);
                                this.eOG.setVisibility(8);
                                this.eOI.c(portrait, 28, false);
                            }
                            String name_show = c.getAuthor().getName_show();
                            String userName = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ab.ge() && name_show != null && !name_show.equals(userName)) {
                                this.eOC.setText(com.baidu.tieba.pb.c.ao(this.eGA.getPageContext().getPageActivity(), this.eOC.getText().toString()));
                                this.eOC.setGravity(16);
                                this.eOC.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aOK());
                                com.baidu.tbadk.core.util.ai.c(this.eOC, d.e.cp_other_e, 1);
                            }
                        }
                        d = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eKj != null) {
                        }
                        if (this.eKi != null) {
                        }
                        this.eOC.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.eOC.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                        this.eOC.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ai.c(this.eOC, d.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eOD.setVisibility(8);
                        com.baidu.tbadk.core.util.ai.c(this.eOE, d.e.cp_link_tip_a, 1);
                        this.eOE.setVisibility(0);
                        if (fVar.aPj().getAuthor() != null) {
                            if (fVar.aPj().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eOI.setUserId(c.getAuthor().getUserId());
                        this.eOI.setUserName(c.getAuthor().getUserName());
                        this.eOI.setImageDrawable(null);
                        this.eOI.setRadius(com.baidu.adp.lib.util.k.g(this.eGA.getActivity(), d.f.ds40));
                        this.eOI.setTag(c.getAuthor().getUserId());
                        this.eOS.setText(c.bsA());
                        bsB = c.bsB();
                        if (bsB == null) {
                        }
                        this.bDL.setVisibility(8);
                        this.eOQ.a(c.getAuthor());
                        this.eOQ.eOa = this.eQp;
                        if (!this.ePF) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eOI, c.getAuthor());
                        this.eOI.setVisibility(0);
                        this.eOA.setOnClickListener(onClickListener);
                        this.eOC.setOnClickListener(onClickListener);
                        this.eOI.setOnClickListener(onClickListener);
                        this.eOG.setVisibility(8);
                        this.eOI.c(portrait, 28, false);
                        String name_show2 = c.getAuthor().getName_show();
                        String userName2 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ab.ge()) {
                            this.eOC.setText(com.baidu.tieba.pb.c.ao(this.eGA.getPageContext().getPageActivity(), this.eOC.getText().toString()));
                            this.eOC.setGravity(16);
                            this.eOC.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aOK());
                            com.baidu.tbadk.core.util.ai.c(this.eOC, d.e.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.j.aS(string) > 14) {
                            d = com.baidu.tbadk.core.util.al.d(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eKj != null) {
                            }
                            if (this.eKi != null) {
                            }
                            this.eOC.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.eOC.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                            this.eOC.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.ai.c(this.eOC, d.e.cp_cont_h, 1);
                            if (c == null) {
                            }
                            this.eOD.setVisibility(8);
                            com.baidu.tbadk.core.util.ai.c(this.eOE, d.e.cp_link_tip_a, 1);
                            this.eOE.setVisibility(0);
                            if (fVar.aPj().getAuthor() != null) {
                            }
                            this.eOI.setUserId(c.getAuthor().getUserId());
                            this.eOI.setUserName(c.getAuthor().getUserName());
                            this.eOI.setImageDrawable(null);
                            this.eOI.setRadius(com.baidu.adp.lib.util.k.g(this.eGA.getActivity(), d.f.ds40));
                            this.eOI.setTag(c.getAuthor().getUserId());
                            this.eOS.setText(c.bsA());
                            bsB = c.bsB();
                            if (bsB == null) {
                            }
                            this.bDL.setVisibility(8);
                            this.eOQ.a(c.getAuthor());
                            this.eOQ.eOa = this.eQp;
                            if (!this.ePF) {
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eOI, c.getAuthor());
                            this.eOI.setVisibility(0);
                            this.eOA.setOnClickListener(onClickListener);
                            this.eOC.setOnClickListener(onClickListener);
                            this.eOI.setOnClickListener(onClickListener);
                            this.eOG.setVisibility(8);
                            this.eOI.c(portrait, 28, false);
                            String name_show22 = c.getAuthor().getName_show();
                            String userName22 = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ab.ge()) {
                            }
                        }
                        d = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eKj != null) {
                        }
                        if (this.eKi != null) {
                        }
                        this.eOC.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.eOC.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                        this.eOC.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ai.c(this.eOC, d.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eOD.setVisibility(8);
                        com.baidu.tbadk.core.util.ai.c(this.eOE, d.e.cp_link_tip_a, 1);
                        this.eOE.setVisibility(0);
                        if (fVar.aPj().getAuthor() != null) {
                        }
                        this.eOI.setUserId(c.getAuthor().getUserId());
                        this.eOI.setUserName(c.getAuthor().getUserName());
                        this.eOI.setImageDrawable(null);
                        this.eOI.setRadius(com.baidu.adp.lib.util.k.g(this.eGA.getActivity(), d.f.ds40));
                        this.eOI.setTag(c.getAuthor().getUserId());
                        this.eOS.setText(c.bsA());
                        bsB = c.bsB();
                        if (bsB == null) {
                        }
                        this.bDL.setVisibility(8);
                        this.eOQ.a(c.getAuthor());
                        this.eOQ.eOa = this.eQp;
                        if (!this.ePF) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eOI, c.getAuthor());
                        this.eOI.setVisibility(0);
                        this.eOA.setOnClickListener(onClickListener);
                        this.eOC.setOnClickListener(onClickListener);
                        this.eOI.setOnClickListener(onClickListener);
                        this.eOG.setVisibility(8);
                        this.eOI.c(portrait, 28, false);
                        String name_show222 = c.getAuthor().getName_show();
                        String userName222 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ab.ge()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eOz.V(fVar.aPj());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.sa() != null) {
            this.eOB.a(this.eGA.getPageContext(), fVar.aPl().get(0).sa(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aPh().getId(), fVar.aPh().getName(), fVar.aPj().getId(), this.eGA.aQT() ? "FRS" : null));
            this.eOA.setPadding(this.eOA.getPaddingLeft(), (int) this.eGA.getResources().getDimension(d.f.ds20), this.eOA.getPaddingRight(), this.eOA.getPaddingBottom());
            return;
        }
        this.eOB.a(null, null, null);
    }

    public void aTs() {
        if (this.eOh != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11997").r("obj_type", 1));
            this.eOh.aWf();
            this.eOq.smoothScrollToPosition(0);
        }
    }

    public boolean aTt() {
        return this.eQL;
    }

    private boolean OQ() {
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
            this.eOm.aUJ();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eOm.mU(eVar.forumName);
            }
            String string = this.eGA.getResources().getString(d.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eGA.getResources().getString(d.l.self);
                    break;
                case 300:
                    str = this.eGA.getResources().getString(d.l.bawu);
                    break;
                case 400:
                    str = this.eGA.getResources().getString(d.l.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eDK;
            this.eGA.showNetRefreshView(this.bYq, format, null, this.eGA.getResources().getString(d.l.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.k.hI()) {
                        com.baidu.tbadk.core.util.at.wf().c(aq.this.eGA.getPageContext(), new String[]{str2});
                        aq.this.eGA.finish();
                        return;
                    }
                    aq.this.eGA.showToast(d.l.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aSK;
        String str;
        if (fVar != null) {
            this.eLd = fVar;
            this.mType = i;
            if (fVar.aPj() != null) {
                this.eQb = fVar.aPj().rs();
                this.aak = fVar.aPj().rp();
                if (fVar.aPj().getAnchorLevel() != 0) {
                    this.eQL = true;
                }
                this.ePF = O(fVar.aPj());
                if (this.eOQ != null && fVar.aPj().getAuthor() != null) {
                    this.eOQ.isBigV = fVar.aPj().getAuthor().isBigV();
                }
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            p(fVar);
            this.ePT = false;
            this.eFv = z;
            aTo();
            b(fVar, z, i);
            if (this.eGA.aQJ()) {
                if (this.ePe == null) {
                    this.ePe = new com.baidu.tieba.pb.view.j(this.eGA.getPageContext());
                    this.ePe.lk();
                    this.ePe.a(this.anM);
                }
                this.eOq.setPullRefresh(this.ePe);
                aTu();
                if (this.ePe != null) {
                    this.ePe.dp(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qH().qE() == 0 && z) {
                this.eOq.setPullRefresh(null);
                this.eOg = 1;
            } else {
                if (this.ePe == null) {
                    this.ePe = new com.baidu.tieba.pb.view.j(this.eGA.getPageContext());
                    this.ePe.lk();
                    this.ePe.a(this.anM);
                }
                this.eOq.setPullRefresh(this.ePe);
                aTu();
                this.eOg = 2;
                if (this.ePe != null) {
                    this.ePe.dp(TbadkCoreApplication.getInst().getSkinType());
                }
                QY();
            }
            aTv();
            this.ePa.iQ(this.eFv);
            this.ePa.iR(false);
            this.ePa.jc(i == 5);
            this.ePa.jd(i == 6);
            this.ePa.a(fVar, false);
            this.ePa.notifyDataSetChanged();
            if (this.eGA.aQX()) {
                if (fVar.aPi() != null) {
                    this.mForumName = fVar.aPi().getForumName();
                    this.mForumId = fVar.aPi().getForumId();
                }
                if (this.mForumName == null && this.eGA.aQn() != null && this.eGA.aQn().aRx() != null) {
                    this.mForumName = this.eGA.aQn().aRx();
                }
                this.eOm.mU(this.mForumName);
            } else {
                this.eOm.mU(null);
            }
            if (this.eGA.aQX()) {
                int i4 = 0;
                PostData c = c(fVar, z);
                if (c != null && c.getAuthor() != null) {
                    i4 = c.getAuthor().getLevel_id();
                }
                if (i4 > 0) {
                    this.eOF.setVisibility(0);
                    com.baidu.tbadk.core.util.ai.c(this.eOF, BitmapHelper.getGradeResourceIdInEnterForum(i4));
                } else {
                    this.eOF.setVisibility(8);
                }
            } else {
                this.eOF.setVisibility(8);
            }
            if (fVar.aPj() != null && fVar.aPj().rv() != null) {
                if (fVar.aPj().rv().getNum() < 1) {
                    str = this.eGA.getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = fVar.aPj().rv().getNum() + "";
                }
                if (this.eOc != -1) {
                    fVar.aPj().rv().setIsLike(this.eOc);
                }
                S(str, fVar.aPj().rv().getIsLike() == 1);
            }
            if (fVar.qH().qD() == 0 && !z) {
                this.eOq.setNextPage(null);
                this.eOl = 1;
            } else if (this.eGA.isLogin()) {
                this.eOq.setNextPage(this.ePf);
                this.eOl = 2;
                QY();
            } else if (fVar.qH().qD() == 1) {
                this.ePT = true;
                if (this.ePg == null) {
                    this.ePg = new com.baidu.tieba.pb.view.b(this.eGA.getPageContext());
                }
                this.eOq.setNextPage(this.ePg);
                this.eOl = 3;
            }
            ArrayList<PostData> aPl = fVar.aPl();
            if (fVar.qH().qD() == 0 || aPl == null || aPl.size() < fVar.qH().qC()) {
                if (com.baidu.tbadk.core.util.u.u(aPl) == 0 || (com.baidu.tbadk.core.util.u.u(aPl) == 1 && aPl.get(0) != null && aPl.get(0).bsy() == 1)) {
                    this.ePf.setText(this.eGA.getResources().getString(d.l.list_no_more_new));
                } else {
                    this.ePf.setText("");
                }
                if (this.eGA.aQJ() && this.eOq != null && this.eOq.getData() != null && this.eOq.getData().size() == 1 && (this.eOq.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.ePf.setText("");
                }
                aTA();
            } else if (z2) {
                if (this.eQI) {
                    wX();
                    if (fVar.qH().qD() != 0) {
                        this.ePf.setText(this.eGA.getResources().getString(d.l.pb_load_more));
                    }
                } else {
                    this.ePf.wS();
                    this.ePf.wZ();
                }
            } else {
                this.ePf.wS();
                this.ePf.wZ();
            }
            if (fVar.aPj() != null && fVar.aPj().getAuthor() != null && fVar.aPj().getAuthor().getType() == 0) {
                this.eOm.aUG();
            }
            switch (i) {
                case 2:
                    int i5 = 0;
                    if (this.eOq.getData() != null || fVar.aPl() != null) {
                        i5 = (this.eOq.getData().size() - fVar.aPl().size()) + this.eOq.getHeaderViewsCount();
                    }
                    this.eOq.setSelection(i2 > 1 ? (i5 + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aSK = ai.aSJ().aSK()) != null) {
                        this.eQD = true;
                        this.eOq.onRestoreInstanceState(aSK);
                        break;
                    } else {
                        this.eOq.setSelection(0);
                        break;
                    }
                case 4:
                    this.eQI = false;
                    break;
                case 5:
                    this.eOq.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aSK2 = ai.aSJ().aSK();
                        this.eQD = true;
                        if (aSK2 != null) {
                            this.eOq.onRestoreInstanceState(aSK2);
                            break;
                        }
                    }
                    this.eOq.setSelection(0);
                    break;
            }
            if (this.eQo >= 0) {
                this.eOq.setSelectionFromTop(this.eQo, (int) this.eQn);
                this.eQo = -1;
            }
            if (this.eQb == eQd && OQ()) {
                aTD();
            }
            if (this.eOi != null) {
                this.eOi.aa(fVar.aPj());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aTu() {
        if (this.eOh != null && this.eOh.aWe() != null) {
            this.eOq.removeHeaderView(this.ayF);
            if (this.mType != 1) {
                this.eOq.removeHeaderView(this.eOh.aWe());
                this.eOq.addHeaderView(this.eOh.aWe(), 0);
                this.eOq.setSelection(0);
                return;
            }
            return;
        }
        if (this.eOh != null) {
            this.eOq.removeHeaderView(this.eOh.aWe());
        }
        this.eOq.removeHeaderView(this.ayF);
        this.eOq.addHeaderView(this.ayF, 0);
    }

    public void jH(boolean z) {
        this.ePE = z;
        this.eOm.jH(z);
    }

    public void wX() {
        if (this.ePf != null) {
            this.ePf.wT();
            this.ePf.wX();
        }
        QY();
    }

    public void Nr() {
        this.eOq.setVisibility(0);
    }

    private boolean aTv() {
        boolean z;
        if (this.ePH != null && this.ePH.getVisibility() == 0) {
            if (this.eOW != null) {
                this.eOW.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.eOW != null) {
                this.eOW.setVisibility(8);
            }
            z = false;
        }
        if ((this.eOY == null || this.eOY.getVisibility() == 8) && z && this.eFv) {
            this.eOX.setVisibility(0);
        } else {
            this.eOX.setVisibility(8);
        }
        com.baidu.tieba.graffiti.b.aq(this.eOX);
        return z;
    }

    private boolean o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPj() == null) {
            return false;
        }
        if (fVar.aPj().rC() == 1 || fVar.aPj().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aPj().rE() == null || fVar.aPj().rE().te() == 0) || fVar.aPj().rA() == 1 || fVar.aPj().rB() == 1 || fVar.aPj().sk() || fVar.aPj().sx() || fVar.aPj().sr() || fVar.aPj().rR() != null || fVar.aPj().sy() || fVar.aPj().sy() || !com.baidu.tbadk.core.util.al.isEmpty(fVar.aPj().getCategory()) || fVar.aPj().rI() || fVar.aPj().rH();
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eGA.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eOu != null) {
                if (fVar.aPj() != null && fVar.aPj().rU() == 0 && !fVar.aPj().ss() && !this.eQz) {
                    this.eOu.setVisibility(0);
                    if (fVar.aPj() != null) {
                        fVar.aPj().e(true, o(fVar));
                    }
                    SpannableStringBuilder sf = fVar.aPj().sf();
                    this.eOv.setOnTouchListener(new com.baidu.tieba.view.l(sf));
                    this.eOv.setText(sf);
                    this.eOv.setVisibility(0);
                } else if (fVar.aPj().rU() == 1) {
                    if (fVar.aPj() != null) {
                        fVar.aPj().e(true, o(fVar));
                        SpannableStringBuilder sf2 = fVar.aPj().sf();
                        if (sf2 == null || sf2.length() == 0) {
                            this.eOu.setVisibility(8);
                            this.eOq.removeHeaderView(this.eOu);
                            if (fVar.aPj() != null && !fVar.aPj().ss()) {
                                this.eOA.setPadding(this.eOA.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds48), this.eOA.getPaddingRight(), this.eOA.getPaddingBottom());
                            }
                        } else {
                            this.eOu.setVisibility(0);
                            this.eOv.setOnTouchListener(new com.baidu.tieba.view.l(sf2));
                            this.eOv.setText(sf2);
                            this.eOv.setVisibility(0);
                        }
                    }
                } else {
                    this.eOu.setVisibility(8);
                    this.eOq.removeHeaderView(this.eOu);
                    if (fVar.aPj() != null && fVar.aPj().ss()) {
                        this.eOA.setPadding(this.eOA.getPaddingLeft(), 0, this.eOA.getPaddingRight(), this.eOA.getPaddingBottom());
                    } else {
                        this.eOA.setPadding(this.eOA.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds48), this.eOA.getPaddingRight(), this.eOA.getPaddingBottom());
                    }
                }
            }
            this.eFv = z;
            bl aPj = fVar.aPj();
            if (aPj != null) {
                a(aPj.rE());
            }
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aTv();
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
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPu()));
            sparseArray.put(d.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(d.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(d.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(d.h.tag_del_post_id, c.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPu()));
            sparseArray.put(d.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aIR;
    }

    public void pv(String str) {
        if (this.ePf != null) {
            this.ePf.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eOq;
    }

    public int aTw() {
        return d.h.richText;
    }

    public TextView aQh() {
        return this.eOz.aQh();
    }

    public void d(BdListView.e eVar) {
        this.eOq.setOnSrollToBottomListener(eVar);
    }

    public void a(k.b bVar) {
        this.anM = bVar;
        if (this.ePe != null) {
            this.ePe.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, a.b bVar) {
        if (arVar != null) {
            int qB = arVar.qB();
            int qy = arVar.qy();
            if (this.ePb != null) {
                this.ePb.tr();
            } else {
                this.ePb = new com.baidu.tbadk.core.dialog.a(this.eGA.getPageContext().getPageActivity());
                this.ePc = LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.dialog_direct_pager, (ViewGroup) null);
                this.ePb.v(this.ePc);
                this.ePb.a(d.l.dialog_ok, bVar);
                this.ePb.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.aBk();
                        aVar.dismiss();
                    }
                });
                this.ePb.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.eQj == null) {
                            aq.this.eQj = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.eGA.HidenSoftKeyPad((InputMethodManager) aq.this.eGA.getSystemService("input_method"), aq.this.bYq);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.ga().postDelayed(aq.this.eQj, 150L);
                    }
                });
                this.ePb.b(this.eGA.getPageContext()).tr();
            }
            this.ePd = (EditText) this.ePc.findViewById(d.h.input_page_number);
            this.ePd.setText("");
            TextView textView = (TextView) this.ePc.findViewById(d.h.current_page_number);
            if (qB <= 0) {
                qB = 1;
            }
            if (qy <= 0) {
                qy = 1;
            }
            textView.setText(MessageFormat.format(this.eGA.getApplicationContext().getResources().getString(d.l.current_page), Integer.valueOf(qB), Integer.valueOf(qy)));
            this.eGA.ShowSoftKeyPadDelay(this.ePd, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eOq.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eGA.showToast(str);
    }

    public boolean jI(boolean z) {
        if (this.Lr == null || !this.Lr.Dd()) {
            return false;
        }
        this.Lr.Bu();
        return true;
    }

    public void aTx() {
        if (this.eQM != null) {
            while (this.eQM.size() > 0) {
                TbImageView remove = this.eQM.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aTx();
        this.ePa.oV(1);
        if (this.eOh != null) {
            this.eOh.onPause();
        }
    }

    public void onResume() {
        this.ePa.oV(2);
        if (this.eOh != null) {
            this.eOh.onResume();
        }
        if (this.eQa != null) {
            this.eQa.onResume();
        }
    }

    public void onDestroy() {
        this.eQm.Yi();
        if (this.eOj != null) {
            this.eOj.Yi();
        }
        if (this.eOi != null) {
            this.eOi.onDestroy();
        }
        this.eGA.hideProgressBar();
        if (this.bES != null && this.bEV != null) {
            this.bES.b(this.bEV);
        }
        aBk();
        wX();
        if (this.eQj != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.eQj);
        }
        if (this.eQk != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.eQk);
        }
        if (this.eQy != null) {
            this.eQy.removeAllViews();
        }
        if (this.eOA != null && this.eOO != null) {
            this.eOA.removeView(this.eOH);
            this.eOO = null;
        }
        if (this.ePX != null) {
            this.ePX.clearStatus();
        }
        this.eQE = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.ePa.oV(3);
        if (this.caD != null) {
            this.caD.setBackgroundDrawable(null);
        }
        if (this.eOh != null) {
            this.eOh.destroy();
        }
        if (this.ePa != null) {
            this.ePa.onDestory();
        }
        this.bYq.getViewTreeObserver().removeGlobalOnLayoutListener(this.eQN);
    }

    public boolean pk(int i) {
        if (this.eOh != null) {
            return this.eOh.pD(i);
        }
        return false;
    }

    public void aBk() {
        this.eOm.oq();
        this.eQm.Yi();
        if (this.eOj != null) {
            this.eOj.Yi();
        }
        com.baidu.adp.lib.util.k.b(this.eGA.getPageContext().getPageActivity(), this.ePd);
        if (this.ePC != null) {
            this.ePC.dismiss();
        }
        aTy();
        if (this.eOi != null) {
            this.eOi.aVX();
        }
        if (this.ePb != null) {
            this.ePb.dismiss();
        }
        if (this.cky != null) {
            this.cky.dismiss();
        }
    }

    public void iP(boolean z) {
        this.ePa.iP(z);
    }

    public void hh(boolean z) {
        this.dJE = z;
    }

    public void aTy() {
        if (this.ePk != null) {
            this.ePk.dismiss();
        }
        if (this.ePl != null) {
            com.baidu.adp.lib.g.g.b(this.ePl, this.eGA.getPageContext());
        }
        if (this.ePv != null) {
            com.baidu.adp.lib.g.g.b(this.ePv, this.eGA.getPageContext());
        }
        if (this.ePi != null) {
            com.baidu.adp.lib.g.g.b(this.ePi, this.eGA.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.eLd, this.eFv);
            d(this.eLd, this.eFv, this.mType);
            this.eGA.getLayoutMode().ah(i == 1);
            this.eGA.getLayoutMode().t(this.bYq);
            this.eGA.getLayoutMode().t(this.eOv);
            this.eGA.getLayoutMode().t(this.eOw);
            this.eGA.getLayoutMode().t(this.eOs);
            if (this.eOM != null) {
                com.baidu.tbadk.core.util.ai.c(this.eOM, d.e.cp_cont_d, 1);
            }
            if (this.eOL != null) {
                com.baidu.tbadk.core.util.ai.c(this.eOL, d.e.cp_cont_d, 1);
            }
            if (this.eOi != null) {
                this.eOi.onChangeSkinType(i);
            }
            this.eGA.getLayoutMode().t(this.eOs);
            com.baidu.tbadk.core.util.ai.i(this.eOv, d.e.cp_cont_b);
            this.eOv.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            this.eGA.getLayoutMode().t(this.aIR);
            if (this.ePc != null) {
                this.eGA.getLayoutMode().t(this.ePc);
            }
            jH(this.ePE);
            this.ePa.notifyDataSetChanged();
            if (this.ePe != null) {
                this.ePe.dp(i);
            }
            if (this.ePf != null) {
                this.ePf.dp(i);
                com.baidu.tbadk.core.util.ai.j(this.aIR, d.g.pb_foot_more_trans_selector);
                this.ePf.dn(d.g.pb_foot_more_trans_selector);
            }
            if (this.Lr != null) {
                this.Lr.onChangeSkinType(i);
            }
            if (this.eON != null) {
                this.eON.dt(i);
            }
            if (this.ePg != null) {
                this.ePg.dp(i);
            }
            if (this.eOr != null && this.eOr.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eOr) {
                    aVar.aUA();
                }
            }
            if (this.eQy != null) {
                com.baidu.tbadk.core.util.ai.k(this.eQy, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ai.k(this.eQw, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_cont_c, 1);
            }
            aO(i == 1);
            aTb();
            UtilHelper.setStatusBarBackground(this.caD, i);
            if (this.eOP != null) {
                this.eOP.onChangeSkinType(i);
            }
            if (this.bDL != null) {
                com.baidu.tbadk.core.util.ai.i(this.bDL, d.e.cp_cont_d);
            }
            if (this.eOS != null) {
                com.baidu.tbadk.core.util.ai.i(this.eOS, d.e.cp_cont_f);
            }
            if (this.eOE != null) {
                com.baidu.tbadk.core.util.ai.i(this.eOE, d.e.cp_link_tip_a);
            }
            if (this.eOR != null) {
                com.baidu.tbadk.core.util.ai.i(this.eOR, d.e.cp_cont_f);
            }
            if (this.eOT != null) {
                com.baidu.tbadk.o.a.a(this.eGA.getPageContext(), this.eOT);
            }
            if (this.eQl != null) {
                this.eQl.onChangeSkinType(i);
            }
            if (this.eOm != null) {
                if (this.eOh != null) {
                    this.eOh.px(i);
                } else {
                    this.eOm.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.ai.i(this.eOD, d.e.cp_cont_f);
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRM = eVar;
        this.ePa.setOnImageClickListener(this.aRM);
    }

    public void c(NoNetworkView.a aVar) {
        this.bEV = aVar;
        if (this.bES != null) {
            this.bES.a(this.bEV);
        }
    }

    public void jJ(boolean z) {
        this.ePa.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aTz() {
        return this.ePH;
    }

    public void aTA() {
        if (this.eOl != 2) {
            this.eOq.setNextPage(this.ePf);
            this.eOl = 2;
        }
    }

    public void aTB() {
        if (com.baidu.tbadk.l.r.Gz().GA()) {
            int lastVisiblePosition = this.eOq.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eOq.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog = tbImageView.getPerfLog();
                                perfLog.fi(1001);
                                perfLog.aJZ = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wA();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.l.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.fi(1001);
                        perfLog2.aJZ = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.wA();
                    }
                }
            }
        }
    }

    public void hi(boolean z) {
        if (this.ePI != null) {
            if (this.dJE) {
                hj(z);
            } else {
                hk(z);
            }
        }
    }

    public void aTC() {
        if (this.ePI != null) {
            this.ePI.setVisibility(8);
            this.ePN = false;
            if (this.eQa != null) {
                this.eQa.setVisibility(8);
            }
        }
    }

    public void QX() {
        if (this.bnY == null) {
            this.bnY = new com.baidu.tbadk.core.view.a(this.eGA.getPageContext());
        }
        this.bnY.aH(true);
    }

    public void QY() {
        if (this.bnY != null) {
            this.bnY.aH(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eOq.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eOq.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eOh != null) {
            this.eOh.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eQO = getScrollY();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z = false;
        this.eQr = false;
        if (this.eOh != null) {
            this.eOh.b(absListView, i);
        }
        a aVar = new a();
        aVar.eQU = i;
        aVar.eQV = this.eOq.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
        int headerViewsCount = (i - this.eOq.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                break;
            } else if (this.ePa.oU(headerViewsCount) != com.baidu.tieba.pb.data.m.eEC) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.ePa.aRl().jC(z);
    }

    /* loaded from: classes.dex */
    public class a {
        public int eQU;
        public int eQV;

        public a() {
        }
    }

    public void aTD() {
        if (!this.eQP) {
            TiebaStatic.log("c10490");
            this.eQP = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGA.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eQe, Integer.valueOf(eQg));
            aVar.cb(d.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.h.function_description_view)).setText(d.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.h.title_view)).setText(d.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(d.l.grade_button_tips, this.eGA);
            aVar.b(d.l.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eGA.getPageContext()).tr();
        }
    }

    public void aTE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGA.getPageContext().getPageActivity());
        aVar.cT(this.eGA.getResources().getString(d.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eQe, Integer.valueOf(eQi));
        aVar.A(sparseArray);
        aVar.a(d.l.upgrade_to_new, this.eGA);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eGA.getPageContext()).tr();
    }

    public int rs() {
        return this.eQb;
    }

    public void pw(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGA.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eGA.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eQe, Integer.valueOf(eQh));
        aVar.A(sparseArray);
        aVar.a(d.l.view, this.eGA);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eGA.getPageContext()).tr();
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

    public PbInterviewStatusView aTF() {
        return this.ePX;
    }

    private void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPj() != null && fVar.aPj().sx() && this.ePX == null) {
            this.ePX = (PbInterviewStatusView) this.ePW.inflate();
            this.ePX.setOnClickListener(this.ckz);
            this.ePX.setCallback(this.eGA.aQS());
            this.ePX.a(this.eGA, fVar);
        }
    }

    public LinearLayout aTG() {
        return this.eOZ;
    }

    public View aTH() {
        return this.caD;
    }

    public boolean aTI() {
        return this.eQz;
    }

    public void iU(boolean z) {
        this.eOz.iU(z);
    }

    private void aTJ() {
        if (this.eQz) {
            if (this.eQA == null) {
                d.a aVar = d.eGD.get();
                if (aVar != null) {
                    this.eQA = aVar.a(this.eGA);
                    ListAdapter adapter = this.eOq.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.ayF) {
                            this.eOq.addHeaderView(this.eQA.aQf(), 1);
                        } else {
                            this.eOq.addHeaderView(this.eQA.aQf(), 0);
                        }
                    }
                } else {
                    this.eOw.setVisibility(0);
                    return;
                }
            }
            this.eOw.setVisibility(8);
            this.eOq.removeHeaderView(this.eOw);
            return;
        }
        this.eOw.setVisibility(0);
    }

    public void jK(boolean z) {
        this.eQz = z;
    }

    public void aTK() {
        this.eGA.showNetRefreshView(getView(), "");
        View EQ = this.eGA.getRefreshView().EQ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EQ.getLayoutParams();
        layoutParams.addRule(3, aTG().getId());
        EQ.setLayoutParams(layoutParams);
        this.eGA.hideLoadingView(getView());
        if (this.eQA != null) {
            this.eOq.removeHeaderView(this.eQA.aQf());
            this.eQA = null;
        }
    }

    public void px(String str) {
        if (this.eOn != null) {
            this.eOn.setTitle(str);
        }
    }

    private int jL(boolean z) {
        if (this.ePX == null || this.ePX.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.eGA.getPageContext().getPageActivity(), d.f.ds72);
    }

    private void aTL() {
        if (this.ePX != null && this.ePX.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ePX.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.ePX.setLayoutParams(layoutParams);
        }
    }

    public boolean aQo() {
        return false;
    }

    public boolean aTM() {
        return this.eQp;
    }

    public TextView aTN() {
        return this.eOM;
    }

    public void py(String str) {
        this.ePK.performClick();
        if (!StringUtils.isNull(str) && this.eGA.aQi() != null && this.eGA.aQi().DA() != null && this.eGA.aQi().DA().Dt() != null) {
            EditText Dt = this.eGA.aQi().DA().Dt();
            Dt.setText(str);
            Dt.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aBk();
            aTC();
            aSQ();
            if (this.eQl != null) {
                this.eQl.aRp();
            }
            this.eGA.afp();
            this.eOZ.setVisibility(8);
            this.eOm.setTitleVisibility(false);
            this.eGA.ja(false);
            if (this.eOh != null) {
                if (configuration.orientation == 1) {
                    aTG().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eOq.setIsLandscape(true);
                    this.eOq.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eOq.setIsLandscape(false);
                    if (this.eQO > 0) {
                        this.eOq.smoothScrollBy(this.eQO, 0);
                    }
                }
                this.eOh.onConfigurationChanged(configuration);
            }
        }
    }

    public void jM(boolean z) {
        this.eOk = z;
    }

    public boolean aTO() {
        return this.eOh != null && this.eOh.aTO();
    }

    public void aTP() {
        if (this.eOh != null) {
            this.eOh.onPause();
        }
    }

    public void w(long j, int i) {
        if (this.eOi != null) {
            this.eOi.w(j, i);
        }
        if (this.eOh != null) {
            this.eOh.w(j, i);
        }
    }

    public void aTQ() {
        if (this.eQa != null) {
            this.eQa.aUz();
        }
    }

    public void aTR() {
        if (this.eQa != null) {
            this.eQa.setVisibility(8);
        }
    }

    public void je(boolean z) {
        this.ePa.je(z);
    }

    public void aTS() {
        if (this.ePY == null) {
            LayoutInflater.from(this.eGA.getActivity()).inflate(d.j.add_experienced_text, (ViewGroup) this.bYq, true);
            this.ePY = (ViewGroup) this.bYq.findViewById(d.h.add_experienced_layout);
            this.ePZ = (TextView) this.bYq.findViewById(d.h.add_experienced);
            com.baidu.tbadk.core.util.ai.i(this.ePZ, d.e.cp_cont_i);
            String string = this.eGA.getResources().getString(d.l.experienced_add_success);
            String string2 = this.eGA.getResources().getString(d.l.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_h)));
            this.ePZ.setText(spannableString);
        }
        this.ePY.setVisibility(0);
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
                        aq.this.ePY.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.ePZ.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.ePZ.startAnimation(scaleAnimation);
    }
}
