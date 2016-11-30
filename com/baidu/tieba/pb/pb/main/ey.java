package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
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
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.an;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ey {
    public static int eCd = 2;
    public static int eCe = 3;
    public static int eCf = 0;
    public static int eCg = 3;
    public static int eCh = 4;
    public static int eCi = 5;
    public static int eCj = 6;
    private com.baidu.tbadk.editortools.l EL;
    private View aBs;
    private BdTypeListView aML;
    private boolean aez;
    private z.b ahd;
    private TextView ark;
    private View bMp;
    private View.OnClickListener bTO;
    private ViewStub bbQ;
    private TbImageView bbR;
    private NoNetworkView bpe;
    private ViewStub eAA;
    private List<com.baidu.tieba.pb.pb.main.view.a> eAB;
    private View eAC;
    private LinearLayout eAG;
    private com.baidu.tieba.pb.data.b eAI;
    private g eAJ;
    private df eAK;
    private ColumnLayout eAL;
    private ThreadSkinView eAM;
    private TextView eAN;
    private FrameLayout eAO;
    private HeadPendantView eAP;
    private HeadImageView eAQ;
    private ImageView eAR;
    private ImageView eAS;
    private UserIconBox eAT;
    private UserIconBox eAU;
    private EntelechyUserLikeButton eAZ;
    public int eAu;
    public final com.baidu.tieba.pb.pb.main.view.g eAx;
    public com.baidu.tieba.pb.pb.main.view.e eAy;
    private ViewStub eAz;
    private View eBP;
    private TextView eBQ;
    private TextView eBR;
    private ViewGroup eBS;
    private TextView eBT;
    private boolean eBV;
    private View eBY;
    private TextView eBZ;
    private com.baidu.tbadk.core.view.userLike.c eBa;
    private LinearLayout eBb;
    private TextView eBc;
    private TextView eBd;
    private View eBe;
    private View eBf;
    private ObservedChangeLinearLayout eBi;
    private ck eBj;
    private PbListView eBo;
    private View eBq;
    private TbImageView eCA;
    private FrameLayout eCB;
    private TextView eCC;
    private LinearLayout eCD;
    private boolean eCE;
    private f eCF;
    private com.baidu.tbadk.core.view.userLike.c eCG;
    private com.baidu.tbadk.core.view.userLike.c eCH;
    private Runnable eCK;
    private PbActivity.a eCM;
    private boolean eCO;
    private boolean eCP;
    private ViewStub eCa;
    private PbInterviewStatusView eCb;
    private Runnable eCk;
    private Runnable eCl;
    private FloatingLayout eCm;
    private cz eCn;
    private com.baidu.tieba.pb.pb.main.a.f eCo;
    private View eCx;
    private EntelechyUserLikeButton eCy;
    private ClickableHeaderImageView eCz;
    private RelativeLayout efO;
    private com.baidu.tieba.pb.a.d esT;
    private View.OnClickListener etl;
    private PbActivity eug;
    PbActivity.c evx;
    private com.baidu.tieba.pb.pb.main.view.c ewJ;
    private int eAv = 1;
    private int eAw = 0;
    private final Handler mHandler = new Handler();
    private View eAD = null;
    private LinearLayout eAE = null;
    private TextView eAF = null;
    private com.baidu.tieba.pb.pb.a.t eAH = null;
    private TextView eAV = null;
    private TextView eAW = null;
    public FrsPraiseView eAX = null;
    private ClickableHeaderImageView ezk = null;
    private ClickableHeaderImageView eAY = null;
    private View eBg = null;
    private boolean eBh = false;
    private com.baidu.tbadk.core.dialog.a eBk = null;
    private com.baidu.tbadk.core.dialog.c bTJ = null;
    private View eBl = null;
    private EditText eBm = null;
    private com.baidu.tieba.pb.view.u eBn = null;
    private com.baidu.tieba.pb.view.b eBp = null;
    private c.b dlp = null;
    private TbRichTextView.e aJZ = null;
    private NoNetworkView.a aTn = null;
    private Dialog eBr = null;
    private View eBs = null;
    private com.baidu.tbadk.core.dialog.a eBt = null;
    private Dialog eBu = null;
    private View eBv = null;
    private int eBw = 0;
    private RadioGroup Hw = null;
    private RadioButton eBx = null;
    private RadioButton eBy = null;
    private RadioButton eBz = null;
    private Button eBA = null;
    private Button eBB = null;
    private TextView eBC = null;
    private Dialog eBD = null;
    private View eBE = null;
    private LinearLayout eBF = null;
    private CompoundButton.OnCheckedChangeListener eBG = null;
    private TextView eBH = null;
    private TextView eBI = null;
    private String eBJ = null;
    private com.baidu.tbadk.core.dialog.c eBK = null;
    private boolean eBL = false;
    private boolean eBM = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eBN = null;
    private boolean dEi = false;
    private Button eBO = null;
    private boolean eBU = true;
    private com.baidu.tbadk.core.view.a eBW = null;
    private boolean eth = false;
    private boolean eBX = false;
    private boolean mIsFromCDN = true;
    private int eCc = 0;
    private a.InterfaceC0078a eCp = new ez(this);
    private boolean eCq = false;
    private boolean eCr = false;
    private boolean eCs = false;
    private LinearLayout eCt = null;
    private TextView eCu = null;
    private int eCv = 0;
    private boolean eCw = false;
    private boolean eCI = false;
    private Handler eCJ = new Handler();
    private CustomMessageListener eCL = new fj(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eCN = true;
    private boolean eCQ = false;
    private boolean UU = false;
    String userId = null;
    private final List<TbImageView> eCR = new ArrayList();
    private boolean eCS = false;
    private Runnable bWk = new fs(this);

    public f aRE() {
        return this.eCF;
    }

    public NoNetworkView aRF() {
        return this.bpe;
    }

    public boolean isFullScreen() {
        return this.eCr;
    }

    public void aRG() {
        if (this.EL != null) {
            this.EL.hide();
        }
    }

    public com.baidu.tieba.pb.pb.main.view.c aRH() {
        return this.ewJ;
    }

    public cz aRI() {
        return this.eCn;
    }

    public void aRJ() {
        reset();
        this.eBU = true;
        if (this.EL != null) {
            this.EL.hide();
        }
        this.eCn.aPU();
        if (this.eBP != null) {
            if (this.dEi && !aSF()) {
                gZ(false);
            } else {
                ha(false);
            }
        }
        aQj();
    }

    private void reset() {
        if (this.eug != null && this.eug.aOY() != null && this.EL != null) {
            com.baidu.tbadk.editortools.e.b.Dp().setStatus(0);
            com.baidu.tbadk.editortools.e.e aOY = this.eug.aOY();
            aOY.DK();
            if (aOY.getWriteImagesInfo() != null) {
                aOY.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aOY.eK(10);
            aOY.eI(SendView.ALL);
            aOY.eJ(SendView.ALL);
            aOY.fH(this.eug.getActivity().getString(r.j.pb_reply_hint));
            com.baidu.tbadk.editortools.s ez = this.EL.ez(23);
            com.baidu.tbadk.editortools.s ez2 = this.EL.ez(2);
            com.baidu.tbadk.editortools.s ez3 = this.EL.ez(5);
            if (ez2 != null) {
                ez2.lz();
            }
            if (ez3 != null) {
                ez3.lz();
            }
            if (ez != null) {
                ez.hide();
            }
            this.EL.invalidate();
        }
    }

    public boolean aRK() {
        return this.eBU;
    }

    public void gZ(boolean z) {
        if (this.eBP != null && this.eBQ != null && this.eBR != null) {
            this.eBQ.setText(r.j.draft_to_send);
            this.eBR.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eBP.startAnimation(alphaAnimation);
            }
            this.eBP.setVisibility(0);
        }
    }

    public void ha(boolean z) {
        if (this.eBP != null && this.eBQ != null && this.eBR != null) {
            this.eBQ.setText(r.j.reply_floor_host);
            this.eBR.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eBP.startAnimation(alphaAnimation);
            }
            this.eBP.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.q aRL() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aML == null) {
            return null;
        }
        int firstVisiblePosition = this.aML.getFirstVisiblePosition();
        int lastVisiblePosition = this.aML.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aML.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aML.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aML.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.eBj.oy(headerViewsCount) != null && this.eBj.oy(headerViewsCount) != com.baidu.tieba.tbadkCore.data.q.fCr) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.q) this.eBj.aJ(i2);
    }

    public ey(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.eug = null;
        this.efO = null;
        this.bMp = null;
        this.aML = null;
        this.eAC = null;
        this.eAG = null;
        this.eAL = null;
        this.eAN = null;
        this.eAO = null;
        this.eAP = null;
        this.eAQ = null;
        this.eAR = null;
        this.eAS = null;
        this.eAT = null;
        this.eAU = null;
        this.eAZ = null;
        this.eBe = null;
        this.eBf = null;
        this.eBj = null;
        this.eBo = null;
        this.aBs = null;
        this.bTO = null;
        this.etl = null;
        this.eBP = null;
        this.eBQ = null;
        this.eBS = null;
        this.eBT = null;
        this.eBY = null;
        this.eBZ = null;
        this.eCa = null;
        this.eug = pbActivity;
        this.bTO = onClickListener;
        this.esT = dVar;
        this.efO = (RelativeLayout) LayoutInflater.from(this.eug.getPageContext().getPageActivity()).inflate(r.h.new_pb_activity, (ViewGroup) null);
        this.eug.addContentView(this.efO, new FrameLayout.LayoutParams(-1, -1));
        this.bMp = this.eug.findViewById(r.g.statebar_view);
        this.eBi = (ObservedChangeLinearLayout) this.eug.findViewById(r.g.title_wrapper);
        this.bpe = (NoNetworkView) this.eug.findViewById(r.g.view_no_network);
        this.aML = (BdTypeListView) this.eug.findViewById(r.g.new_pb_list);
        this.ark = new TextView(this.eug.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.eug.getActivity(), r.e.ds98));
        this.aML.f(this.ark, 0);
        View view = new View(this.eug.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.eug.getResources().getDimensionPixelSize(r.e.ds100)));
        view.setVisibility(4);
        this.aML.addFooterView(view);
        this.aML.setOnTouchListener(this.eug.aKw);
        this.eAx = new com.baidu.tieba.pb.pb.main.view.g(pbActivity);
        this.eCo = new com.baidu.tieba.pb.pb.main.a.f(pbActivity.getPageContext(), this.eAx.eDJ);
        this.eAK = new df(this.eug, this.efO);
        this.eAK.init();
        this.eAK.a(this.eAK.aQk(), this.bTO);
        if (this.eug.aPv()) {
            this.eAz = (ViewStub) this.eug.findViewById(r.g.manga_view_stub);
            this.eAz.setVisibility(0);
            this.eAy = new com.baidu.tieba.pb.pb.main.view.e(pbActivity);
            this.eAy.show();
            this.eAx.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
            this.eAK.cC(1000L);
        }
        this.ark.setLayoutParams(layoutParams);
        this.eAx.aSN().setOnTouchListener(new com.baidu.tieba.pb.a.a(new gc(this)));
        this.eBP = this.eug.findViewById(r.g.pb_editor_tool_comment);
        this.eBQ = (TextView) this.eug.findViewById(r.g.pb_editor_tool_comment_reply_text);
        this.eBS = (ViewGroup) this.eug.findViewById(r.g.pb_editor_tool_comment_reply_layout);
        this.eBT = (TextView) this.eug.findViewById(r.g.pb_editor_tool_comment_praise_icon);
        boolean ak = com.baidu.tieba.graffiti.d.ak(this.eBT);
        if (ak) {
            iW(ak);
            this.eBT.setVisibility(0);
        }
        this.eBR = (TextView) this.eug.findViewById(r.g.pb_editor_tool_comment_reply_count_text);
        this.eBS.setOnClickListener(new gd(this));
        this.eBT.setOnClickListener(this.bTO);
        this.eBT.setOnTouchListener(this.eug);
        this.eAC = LayoutInflater.from(this.eug.getPageContext().getPageActivity()).inflate(r.h.new_pb_header_item, (ViewGroup) null);
        this.eAG = (LinearLayout) LayoutInflater.from(this.eug.getPageContext().getPageActivity()).inflate(r.h.new_pb_header_user_item, (ViewGroup) null);
        this.eAI = new com.baidu.tieba.pb.data.b(0);
        this.eAI.erE = this.eug;
        this.eAI.aNX();
        this.eAI = new com.baidu.tieba.pb.data.b(0);
        this.eAI.erE = this.eug;
        this.eAI.aNX();
        this.eAJ = new g(this.eug, this.eAG);
        this.eAJ.init();
        this.eAJ.a(this.eAJ.aOX(), this.bTO);
        this.eAL = (ColumnLayout) this.eAG.findViewById(r.g.pb_head_owner_root);
        this.eCm = (FloatingLayout) this.eAG.findViewById(r.g.pb_head_owner_info_root);
        this.eAM = (ThreadSkinView) this.eAG.findViewById(r.g.pb_thread_skin);
        this.eAL.setOnLongClickListener(this.onLongClickListener);
        this.eAL.setOnTouchListener(this.esT);
        this.eAL.setVisibility(8);
        this.eAC.setOnTouchListener(this.esT);
        this.eBY = this.eAC.findViewById(r.g.pb_head_activity_join_number_container);
        this.eBY.setVisibility(8);
        this.eBZ = (TextView) this.eAC.findViewById(r.g.pb_head_activity_join_number);
        this.eAN = (TextView) this.eAL.findViewById(r.g.pb_head_owner_info_user_name);
        this.eAO = (FrameLayout) this.eAL.findViewById(r.g.pb_head_headImage_container);
        this.eAQ = (HeadImageView) this.eAL.findViewById(r.g.pb_head_owner_photo);
        this.eAP = (HeadPendantView) this.eAL.findViewById(r.g.pb_pendant_head_owner_photo);
        this.bbQ = (ViewStub) this.eAL.findViewById(r.g.viewstub_headimage_mask);
        this.eAP.wo();
        if (this.eAP.getHeadView() != null) {
            this.eAP.getHeadView().setIsRound(true);
            this.eAP.getHeadView().setDrawBorder(false);
        }
        if (this.eAP.getPendantView() != null) {
            this.eAP.getPendantView().setIsRound(true);
            this.eAP.getPendantView().setDrawBorder(false);
        }
        this.eAR = (ImageView) this.eAL.findViewById(r.g.pb_head_owner_info_user_rank);
        this.eAS = (ImageView) this.eAL.findViewById(r.g.pb_head_owner_info_user_bawu);
        this.eAT = (UserIconBox) this.eAL.findViewById(r.g.pb_head_owner_info_user_icon);
        this.eAU = (UserIconBox) this.eAL.findViewById(r.g.pb_head_owner_info_tshow_icon);
        this.eAZ = (EntelechyUserLikeButton) this.eAL.findViewById(r.g.pb_like_button);
        this.eBa = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext(), this.eAZ);
        this.eCG = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eCH = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eBe = this.eAC.findViewById(r.g.new_pb_header_item_line_above_livepost);
        this.eBf = this.eAC.findViewById(r.g.new_pb_header_item_line_below_livepost);
        this.eAC.setOnLongClickListener(new ge(this));
        this.eCa = (ViewStub) this.efO.findViewById(r.g.interview_status_stub);
        this.eBj = new ck(this.eug, this.aML);
        this.eBj.x(this.bTO);
        this.eBj.a(this.esT);
        this.eBj.setOnImageClickListener(this.aJZ);
        this.etl = new gf(this);
        this.eBj.I(this.etl);
        aRN();
        aRO();
        this.aML.addHeaderView(this.eAE);
        this.aML.addHeaderView(this.eAH.getView());
        this.aML.addHeaderView(this.eAG);
        this.aML.addHeaderView(this.eAC);
        this.eBo = new PbListView(this.eug.getPageContext().getPageActivity());
        this.aBs = this.eBo.getView().findViewById(r.g.pb_more_view);
        if (this.aBs != null) {
            this.aBs.setOnClickListener(this.bTO);
            com.baidu.tbadk.core.util.at.k(this.aBs, r.f.pb_foot_more_trans_selector);
        }
        this.eBo.wy();
        this.eBo.dg(r.f.pb_foot_more_trans_selector);
        this.eBo.dh(r.f.pb_foot_more_trans_selector);
        this.eBq = this.eug.findViewById(r.g.viewstub_progress);
        this.eug.registerListener(this.eCL);
        this.ewJ = new com.baidu.tieba.pb.pb.main.view.c(this.eug.getPageContext());
        this.eCn = new cz(this.eug.getPageContext(), this.ewJ, this.efO);
        this.ewJ.a(new gg(this));
    }

    public void aRM() {
        if (this.aML != null) {
            this.aML.removeHeaderView(this.eAE);
            this.aML.removeHeaderView(this.eAH.getView());
            if (this.eBj.aPP() != null) {
                this.eBj.aPP().aqw();
            }
            this.aML.removeHeaderView(this.eAG);
            this.aML.removeHeaderView(this.eAC);
        }
    }

    private void aRN() {
        if (this.eAE == null) {
            int e = com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds32);
            int e2 = com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds40);
            this.eAE = new LinearLayout(this.eug.getPageContext().getPageActivity());
            this.eAE.setOrientation(1);
            this.eAE.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eAE.setPadding(0, e2, 0, e2);
            this.eAE.setGravity(17);
            this.eAF = new TextView(this.eug.getPageContext().getPageActivity());
            this.eAF.setGravity(3);
            this.eAF.setMaxLines(2);
            this.eAF.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_c));
            this.eAF.setPadding(e, 0, e, 0);
            com.baidu.tbadk.core.util.at.j((View) this.eAF, r.d.cp_cont_b);
            this.eAF.setTextSize(0, e2);
            this.eAF.setVisibility(8);
            this.eAE.addView(this.eAF);
            this.eAE.setOnTouchListener(this.esT);
            this.eAE.setOnLongClickListener(new gh(this));
        }
    }

    private void aRO() {
        if (this.eAH == null && this.eBj.aPP() != null) {
            this.eAH = this.eBj.aPP().a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRP() {
        if (this.eug.aPv()) {
            this.eAA = (ViewStub) this.eug.findViewById(r.g.manga_mention_controller_view_stub);
            this.eAA.setVisibility(0);
            if (this.eBb == null) {
                this.eBb = (LinearLayout) this.eug.findViewById(r.g.manga_controller_layout);
                com.baidu.tbadk.i.a.a(this.eug.getPageContext(), this.eBb);
            }
            if (this.eBc == null) {
                this.eBc = (TextView) this.eBb.findViewById(r.g.manga_prev_btn);
            }
            if (this.eBd == null) {
                this.eBd = (TextView) this.eBb.findViewById(r.g.manga_next_btn);
            }
            this.eBc.setOnClickListener(this.bTO);
            this.eBd.setOnClickListener(this.bTO);
        }
    }

    private void aRQ() {
        if (this.eug.aPv()) {
            if (this.eug.aPy() == -1) {
                com.baidu.tbadk.core.util.at.c(this.eBc, r.d.cp_cont_e, 1);
            }
            if (this.eug.aPz() == -1) {
                com.baidu.tbadk.core.util.at.c(this.eBd, r.d.cp_cont_e, 1);
            }
        }
    }

    public void aRR() {
        if (this.eBb == null) {
            aRP();
        }
        this.eAA.setVisibility(8);
        if (this.eCJ != null && this.eCK != null) {
            this.eCJ.removeCallbacks(this.eCK);
        }
    }

    private void a(DealInfoData dealInfoData, boolean z) {
        if (this.eCq) {
            View findViewWithTag = this.eAG.findViewWithTag("pb_god_bottom_line_view_tag");
            if (findViewWithTag != null) {
                this.eAG.removeView(findViewWithTag);
            }
            this.eAW.setPadding(this.eAW.getPaddingLeft(), this.eAW.getCompoundPaddingTop(), this.eAW.getPaddingRight(), this.eug.getResources().getDimensionPixelSize(r.e.ds10));
            this.eAL.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds30), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds20), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32), 0);
        } else {
            this.eAL.setPadding(this.eug.getResources().getDimensionPixelSize(r.e.ds30), this.eug.getResources().getDimensionPixelSize(r.e.ds18), this.eug.getResources().getDimensionPixelSize(r.e.ds30), this.eug.getResources().getDimensionPixelSize(r.e.ds10));
            this.eCm.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds16), 0, 0);
        }
        this.aML.setOverScrollMode(2);
        this.eBP.setPadding(this.eBP.getPaddingLeft(), 0, 0, 0);
        com.baidu.tbadk.core.util.at.k(this.eBP, r.f.pb_ecomm_comment_bg);
        this.eBS.setBackgroundResource(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eBS.getLayoutParams();
        marginLayoutParams.rightMargin = this.eug.getResources().getDimensionPixelSize(r.e.ds234);
        this.eBS.setLayoutParams(marginLayoutParams);
        TextView textView = (TextView) this.eug.findViewById(r.g.pb_editor_tool_comment_ecomm_buy_layout);
        textView.setVisibility(0);
        View findViewById = this.efO.findViewById(r.g.pb_editor_tool_comment_layout);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
        if (z || !appResponseToIntentClass) {
            textView.setVisibility(8);
        } else if (dealInfoData.status != 1) {
            textView.setText(r.j.pb_ecomm_status_off_shelf_text);
            com.baidu.tbadk.core.util.at.l(textView, r.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else if (dealInfoData.stock == 0) {
            textView.setText(r.j.pb_ecomm_buy_button_none_text);
            com.baidu.tbadk.core.util.at.l(textView, r.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else {
            textView.setText(r.j.pb_ecomm_buy_button_text);
            com.baidu.tbadk.core.util.at.l(textView, r.d.cp_other_e);
            if (this.bTO != null) {
                textView.setOnClickListener(this.bTO);
            }
        }
    }

    public void aRS() {
        if (this.eCJ != null) {
            if (this.eCK != null) {
                this.eCJ.removeCallbacks(this.eCK);
            }
            this.eCK = new fa(this);
            this.eCJ.postDelayed(this.eCK, 2000L);
        }
    }

    public void iQ(boolean z) {
        this.eAx.iQ(z);
        if (z && this.eBX) {
            this.eBo.setText(this.eug.getResources().getString(r.j.click_load_more));
            this.aML.setNextPage(this.eBo);
            this.eAw = 2;
        }
    }

    public void aRT() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.efO.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EL = lVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.efO.addView(this.EL, layoutParams);
        this.EL.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.EL.hide();
    }

    public void aRU() {
        if (this.eug != null && this.EL != null) {
            this.EL.lz();
        }
    }

    public void pz(String str) {
        if (this.eBR != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.eBR.setText(this.eug.getPageContext().getResources().getString(r.j.pb_reply_count_text, str));
        }
    }

    public void N(String str, boolean z) {
        this.eBV = z;
        iR(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void iR(boolean z) {
        if (this.eBT != null) {
            if (this.eBV) {
                com.baidu.tbadk.core.util.at.k(this.eBT, r.f.pb_praise_already_click_selector);
                this.eBT.setContentDescription(this.eug.getResources().getString(r.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.at.k(this.eBT, r.f.pb_praise_normal_click_selector);
            this.eBT.setContentDescription(this.eug.getResources().getString(r.j.frs_item_praise_text));
        }
    }

    public TextView aRV() {
        return this.eBT;
    }

    public void iS(boolean z) {
        if (this.aML != null) {
            if (!z) {
                this.aML.setEnabled(z);
                return;
            }
            if (this.eCl == null) {
                this.eCl = new fb(this, z);
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.eCl, 10L);
        }
    }

    public void iT(boolean z) {
        if (this.aML != null && this.ark != null && this.bMp != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bMp.setVisibility(0);
                    this.aML.removeHeaderView(this.ark);
                    this.aML.f(this.ark, 0);
                } else {
                    this.bMp.setVisibility(8);
                    this.aML.removeHeaderView(this.ark);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ark.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.ark.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ark.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jb(true);
                this.ark.setLayoutParams(layoutParams2);
            }
            this.aML.removeHeaderView(this.ark);
            this.aML.f(this.ark, 0);
            aSE();
        }
    }

    public void aW(View view) {
        boolean z;
        View view2;
        if (this.eBi != null && view != null) {
            if (this.eBU) {
                z = this.eBP.getVisibility() == 0;
            } else {
                z = this.EL != null && this.EL.getVisibility() == 0;
            }
            boolean z2 = this.eBi.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.eCr = true;
                View findViewById = this.eug.findViewById(r.g.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.eBi.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.eug, this.eBi, r.a.top_fold_up, new fc(this, findViewById));
            } else {
                this.eCr = false;
                com.baidu.tieba.tbadkCore.a.a(this.eug, this.eBi, r.a.top_fold_down, new fd(this));
            }
            if (this.eBU) {
                view2 = this.eBP;
            } else {
                view2 = this.EL;
            }
            if (z) {
                if (z2) {
                    if (this.EL != null) {
                        this.EL.Bc();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.eug, view2, r.a.bottom_fold_down, new fe(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.eug, view2, r.a.bottom_fold_up, new ff(this));
            }
            aQj();
        }
    }

    public ck aRW() {
        return this.eBj;
    }

    public void a(PbActivity.c cVar) {
        this.evx = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bq bqVar) {
        if (bqVar == null || bqVar.td() == 0) {
            if (this.eBO != null) {
                this.eBO.setVisibility(8);
            }
            if (this.eBe != null) {
                this.eBe.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eBO == null) {
            this.eug.getLayoutMode().x(((ViewStub) this.eAC.findViewById(r.g.live_talk_layout)).inflate());
            this.eBO = (Button) this.eAC.findViewById(r.g.pb_head_function_manage_go_to_live_post);
            this.eBe = this.eAC.findViewById(r.g.new_pb_header_item_line_above_livepost);
        }
        int te = bqVar.te();
        String string = this.eug.getPageContext().getString(r.j.go_to_live_post_prefix);
        if (te == 0) {
            string = String.valueOf(string) + this.eug.getPageContext().getString(r.j.go_to_interview_post);
        } else if (te == 1) {
            string = String.valueOf(string) + this.eug.getPageContext().getString(r.j.go_to_discuss_post);
        }
        this.eBO.setText(string);
        this.eBO.setVisibility(0);
        this.eBO.setOnClickListener(this.bTO);
        this.eCP = true;
        aSj();
    }

    public void aX(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.eBs == null) {
            this.eBs = LayoutInflater.from(this.eug.getPageContext().getPageActivity()).inflate(r.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.eug.getLayoutMode().x(this.eBs);
        if (this.eBr == null) {
            this.eBr = new Dialog(this.eug.getPageContext().getPageActivity(), r.k.common_alert_dialog);
            this.eBr.setCanceledOnTouchOutside(true);
            this.eBr.setCancelable(true);
            this.eBr.setContentView(this.eBs);
            WindowManager.LayoutParams attributes = this.eBr.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.eug.getPageContext().getPageActivity()) * 0.9d);
            this.eBr.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eBr.findViewById(r.g.del_post_btn);
        TextView textView2 = (TextView) this.eBr.findViewById(r.g.forbid_user_btn);
        TextView textView3 = (TextView) this.eBr.findViewById(r.g.disable_reply_btn);
        int intValue = sparseArray.get(r.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(r.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(r.g.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(r.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(r.j.delete);
            } else {
                textView.setText(r.j.delete_post);
            }
            sparseArray2.put(r.g.tag_del_post_id, sparseArray.get(r.g.tag_del_post_id));
            sparseArray2.put(r.g.tag_del_post_type, sparseArray.get(r.g.tag_del_post_type));
            sparseArray2.put(r.g.tag_del_post_is_self, sparseArray.get(r.g.tag_del_post_is_self));
            sparseArray2.put(r.g.tag_manage_user_identity, sparseArray.get(r.g.tag_manage_user_identity));
            textView.setOnClickListener(new fg(this));
        }
        if ("".equals(sparseArray.get(r.g.tag_forbid_user_name)) || aSA()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(r.g.tag_forbid_user_name, sparseArray.get(r.g.tag_forbid_user_name));
            sparseArray5.put(r.g.tag_manage_user_identity, sparseArray.get(r.g.tag_manage_user_identity));
            sparseArray5.put(r.g.tag_forbid_user_post_id, sparseArray.get(r.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new fh(this));
        }
        if (!((sparseArray.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(r.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(r.j.un_mute);
            } else {
                textView3.setText(r.j.mute);
            }
            sparseArray6.put(r.g.tag_is_mem, sparseArray.get(r.g.tag_is_mem));
            sparseArray6.put(r.g.tag_user_mute_mute_userid, sparseArray.get(r.g.tag_user_mute_mute_userid));
            sparseArray6.put(r.g.tag_user_mute_mute_username, sparseArray.get(r.g.tag_user_mute_mute_username));
            sparseArray6.put(r.g.tag_user_mute_post_id, sparseArray.get(r.g.tag_user_mute_post_id));
            sparseArray6.put(r.g.tag_user_mute_thread_id, sparseArray.get(r.g.tag_user_mute_thread_id));
            sparseArray6.put(r.g.tag_user_mute_msg, sparseArray.get(r.g.tag_user_mute_msg));
            textView3.setOnClickListener(new fi(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.eBr, this.eug.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.eCM = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.g.tag_del_post_id, str);
        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eCf, Integer.valueOf(eCg));
        int i3 = r.j.del_post_confirm;
        if (i == 0) {
            i3 = r.j.del_thread_confirm;
        }
        this.eBt = new com.baidu.tbadk.core.dialog.a(this.eug.getActivity());
        this.eBt.ca(i3);
        this.eBt.A(sparseArray);
        this.eBt.a(r.j.dialog_ok, this.eug);
        this.eBt.b(r.j.dialog_cancel, new fk(this));
        this.eBt.at(true);
        this.eBt.b(this.eug.getPageContext());
        this.eBt.tq();
    }

    public void ap(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eBE == null) {
            this.eBE = LayoutInflater.from(this.eug.getPageContext().getPageActivity()).inflate(r.h.commit_good, (ViewGroup) null);
        }
        this.eug.getLayoutMode().x(this.eBE);
        if (this.eBD == null) {
            this.eBD = new Dialog(this.eug.getPageContext().getPageActivity(), r.k.common_alert_dialog);
            this.eBD.setCanceledOnTouchOutside(true);
            this.eBD.setCancelable(true);
            this.eBN = (ScrollView) this.eBE.findViewById(r.g.good_scroll);
            this.eBD.setContentView(this.eBE);
            WindowManager.LayoutParams attributes = this.eBD.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds540);
            this.eBD.getWindow().setAttributes(attributes);
            this.eBG = new fl(this);
            this.eBF = (LinearLayout) this.eBE.findViewById(r.g.good_class_group);
            this.eBI = (TextView) this.eBE.findViewById(r.g.dialog_button_cancel);
            this.eBI.setOnClickListener(new fm(this));
            this.eBH = (TextView) this.eBE.findViewById(r.g.dialog_button_ok);
            this.eBH.setOnClickListener(this.bTO);
        }
        this.eBF.removeAllViews();
        this.eAB = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bJ = bJ("0", this.eug.getPageContext().getString(r.j.def_good_class));
        this.eAB.add(bJ);
        bJ.setChecked(true);
        this.eBF.addView(bJ);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bJ2 = bJ(String.valueOf(arrayList.get(i2).qc()), arrayList.get(i2).qb());
                this.eAB.add(bJ2);
                View view = new View(this.eug.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds1));
                com.baidu.tbadk.core.util.at.l(view, r.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eBF.addView(view);
                this.eBF.addView(bJ2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eBN.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eug.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eug.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eug.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eBN.setLayoutParams(layoutParams2);
            this.eBN.removeAllViews();
            this.eBN.addView(this.eBF);
        }
        com.baidu.adp.lib.h.j.a(this.eBD, this.eug.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bJ(String str, String str2) {
        Activity pageActivity = this.eug.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds100));
        aVar.setOnCheckedChangeListener(this.eBG);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aRX() {
        this.eug.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eug.hideProgressBar();
        if (z && z2) {
            this.eug.showToast(this.eug.getPageContext().getString(r.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ax.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(r.j.neterror);
            }
            this.eug.showToast(str);
        }
    }

    public void awz() {
        this.eBq.setVisibility(0);
    }

    public void awy() {
        this.eBq.setVisibility(8);
    }

    public View aRY() {
        if (this.eBE != null) {
            return this.eBE.findViewById(r.g.dialog_button_ok);
        }
        return null;
    }

    public String aRZ() {
        return this.eBJ;
    }

    public View getView() {
        return this.efO;
    }

    public void aSa() {
        com.baidu.adp.lib.util.k.b(this.eug.getPageContext().getPageActivity(), this.eug.getCurrentFocus());
    }

    public void iU(boolean z) {
        this.eug.hideProgressBar();
        aCY();
    }

    public void aSb() {
        this.eBo.wF();
    }

    public void aSc() {
        this.eug.hideProgressBar();
        this.eBo.wG();
        aMZ();
        this.aML.l(2000L);
        aSj();
    }

    public void aSd() {
        this.aML.l(2000L);
        aSj();
    }

    public void iV(boolean z) {
        this.eAK.f(this.eAK.aQk(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eBS.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eug.getResources().getDimensionPixelSize(r.e.ds84) : 0;
        this.eBS.setLayoutParams(marginLayoutParams);
    }

    private void iW(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds16);
        int dimensionPixelSize2 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds16);
        int dimensionPixelSize3 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds84);
        int dimensionPixelSize4 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds14);
        if (z) {
            i = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds16);
            i2 = 0;
        } else {
            i = dimensionPixelSize;
            i2 = dimensionPixelSize3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eBS.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.eBS.setLayoutParams(layoutParams);
    }

    public void c(com.baidu.tbadk.core.data.af afVar) {
        this.eAK.c(afVar);
    }

    public boolean aQh() {
        return this.eAK.aQh();
    }

    public void aQi() {
        this.eAK.aQi();
    }

    public void aQj() {
        this.eAK.aQj();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eBj.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.eBK != null) {
            this.eBK.dismiss();
            this.eBK = null;
        }
        this.eBK = new com.baidu.tbadk.core.dialog.c(this.eug.getPageContext().getPageActivity());
        this.eBK.cd(r.j.operation);
        if (z2) {
            this.eBK.a(new String[]{this.eug.getPageContext().getString(r.j.copy)}, bVar);
        } else if (!z) {
            this.eBK.a(new String[]{this.eug.getPageContext().getString(r.j.copy), this.eug.getPageContext().getString(r.j.mark)}, bVar);
        } else {
            this.eBK.a(new String[]{this.eug.getPageContext().getString(r.j.copy), this.eug.getPageContext().getString(r.j.remove_mark)}, bVar);
        }
        this.eBK.d(this.eug.getPageContext());
        this.eBK.tt();
    }

    public int aSe() {
        return oN(this.aML.getFirstVisiblePosition());
    }

    private int oN(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aML.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.f)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.kq()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.aML.getAdapter() == null || !(this.aML.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aML.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aSf() {
        return oN(this.aML.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.aML.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eBm.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.data.h hVar) {
        this.eBj.b(hVar);
        this.eBj.notifyDataSetChanged();
        if (hVar == null) {
            pz("");
        } else {
            pz(com.baidu.tbadk.core.util.ax.y(hVar.aOl().rJ()));
        }
        aSj();
    }

    public void k(com.baidu.tieba.pb.data.h hVar) {
        PraiseData rH;
        if (this.eAX == null) {
            this.eug.getLayoutMode().x(((ViewStub) this.eAC.findViewById(r.g.praise_layout)).inflate());
            this.eAX = (FrsPraiseView) this.eAC.findViewById(r.g.pb_head_praise_view);
            this.eAX.setIsFromPb(true);
            this.eBg = this.eAC.findViewById(r.g.new_pb_header_item_line_above_praise);
            this.eAX.dm(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.eAX != null) {
            boolean aSj = aSj();
            if (hVar != null && hVar.aOm() != null && hVar.aOm().size() > 0) {
                com.baidu.tieba.tbadkCore.data.q qVar = hVar.aOm().get(0);
                if ((!this.eth || qVar.bml() != 1) && (rH = hVar.aOl().rH()) != null && rH.getUser() != null && rH.getUser().size() > 0) {
                    this.eAX.setVisibility(0);
                    this.eAX.setIsFromPb(true);
                    this.eAX.a(rH, hVar.aOl().getId(), rH.getPostId(), true);
                    this.eAX.getVisibility();
                    com.baidu.tieba.graffiti.d.ak(this.eAX);
                    return;
                }
            }
            this.eAX.setVisibility(8);
            if (hVar != null && hVar.getPage() != null && hVar.getPage().qE() == 0 && this.eth) {
                if (aSj) {
                    this.eBf.setVisibility(0);
                } else {
                    this.eBf.setVisibility(8);
                }
            } else {
                this.eBf.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(this.eBf);
        }
    }

    private com.baidu.tieba.tbadkCore.data.q a(com.baidu.tieba.pb.data.h hVar, boolean z) {
        if (hVar != null && hVar.aOs() != null) {
            return hVar.aOs();
        }
        if (z) {
            if (hVar == null || hVar.aOm() == null || hVar.aOm().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.q qVar = hVar.aOm().get(0);
            if (qVar.bml() != 1) {
                qVar = a(hVar);
            }
            if (qVar.getAuthor() != null && qVar.getAuthor().getUserTbVipInfoData() != null && qVar.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                qVar.getAuthor().getGodUserData().setIntro(qVar.getAuthor().getUserTbVipInfoData().getvipIntro());
                return qVar;
            }
            return qVar;
        }
        return a(hVar);
    }

    private com.baidu.tieba.tbadkCore.data.q a(com.baidu.tieba.pb.data.h hVar) {
        MetaData metaData;
        if (hVar == null || hVar.aOl() == null || hVar.aOl().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
        MetaData author = hVar.aOl().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = hVar.aOl().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        qVar.sf(1);
        qVar.setId(hVar.aOl().se());
        qVar.setTitle(hVar.aOl().getTitle());
        qVar.setTime(hVar.aOl().getCreateTime());
        qVar.setAuthor(metaData);
        return qVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v253, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        int i2;
        if (hVar != null && hVar.aOl() != null) {
            this.eCm.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds30), 0, 0);
            com.baidu.tieba.tbadkCore.data.q a2 = a(hVar, z);
            if (a2 != null && a2.si() != null) {
                String str = null;
                if (this.eug.aPF()) {
                    str = "FRS";
                }
                this.eAM.a(this.eug.getPageContext(), hVar.aOm().get(0).si(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", hVar.aOk().getId(), hVar.aOk().getName(), hVar.aOl().getId(), str));
                this.eAL.setPadding(this.eAL.getPaddingLeft(), (int) this.eug.getResources().getDimension(r.e.ds20), this.eAL.getPaddingRight(), this.eAL.getPaddingBottom());
            } else {
                this.eAM.a(null, null, null);
            }
            aSB();
            this.eAL.setVisibility(8);
            if (this.eAH != null) {
                this.aML.removeHeaderView(this.eAH.getView());
                if (this.eBj.aPP() != null) {
                    this.eBj.aPP().aqw();
                }
            }
            if (hVar.aOl() != null && hVar.aOl().sB() && hVar.aOs() != null && this.eBj.aPP() != null && this.eAH != null) {
                this.aML.f(this.eAH.getView(), 1);
                this.eAH.getView().setVisibility(0);
                this.eBj.aPP().b(hVar);
                this.eBj.aPP().a(0, this.eAH.getView(), (ViewGroup) this.aML, hVar.aOs(), this.eAH);
            } else {
                this.eAH.getView().setVisibility(8);
            }
            if (a2 != null) {
                String str2 = null;
                boolean z2 = false;
                if (hVar != null && hVar.aOl() != null && hVar.aOl().getAuthor() != null) {
                    str2 = hVar.aOl().getAuthor().getUserId();
                    if (hVar.getPage() != null) {
                        this.eCv = hVar.getPage().qA();
                        z2 = hVar.getPage().qD() == 1;
                    }
                }
                boolean sA = hVar.aOl().sA();
                if (a2.getAuthor() != null && a2.getAuthor().getUserTbVipInfoData() != null) {
                    this.aez = !StringUtils.isNull(a2.getAuthor().getUserTbVipInfoData().getvipV_url());
                }
                this.eCq = !sA && b(a2, hVar.aOl().getId(), str2, z2, z);
                this.eAL.setVisibility(0);
                if (this.eAI != null && this.eAI.erI != null && this.eAI.erJ != null && hVar.aOl() != null && hVar.aOl().Ve != null) {
                    this.eBh = true;
                    DealInfoData sM = hVar.aOl().sM();
                    String userId = hVar.aOl().getAuthor().getUserId();
                    boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
                    com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(1);
                    bVar.erI = this.eAI.erI;
                    bVar.erJ = this.eAI.erJ;
                    bVar.erF = sM;
                    bVar.aNX();
                    a(a2, hVar.aOl().getId(), str2, z2, z);
                    a(sM, z3);
                    if (this.eAE != null) {
                        this.aML.removeHeaderView(this.eAE);
                    }
                    if (this.eAH != null) {
                        this.aML.removeHeaderView(this.eAH.getView());
                        if (this.eBj.aPP() != null) {
                            this.eBj.aPP().aqw();
                        }
                    }
                    if (this.eAG != null) {
                        this.aML.removeHeaderView(this.eAG);
                    }
                    if (this.eAC != null) {
                        this.aML.removeHeaderView(this.eAC);
                    }
                    com.baidu.tieba.pb.data.b bVar2 = new com.baidu.tieba.pb.data.b(2);
                    bVar2.erI = this.eAI.erI;
                    bVar2.erJ = this.eAI.erJ;
                    bVar2.aRx = this.eAG;
                    bVar2.aML = this.aML;
                    bVar2.aNX();
                    this.aML.addHeaderView(this.eAC);
                    aSr();
                    if (this.eug.aPb() != null) {
                        this.eug.aPb().je(true);
                    }
                }
                SparseArray sparseArray = (SparseArray) this.eAL.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eAL.setTag(sparseArray);
                }
                sparseArray.put(r.g.tag_clip_board, a2);
                sparseArray.put(r.g.tag_is_subpb, false);
                hVar.aOl().sx();
                if (!this.eCE) {
                    this.eAE.setVisibility(0);
                }
                if (!hVar.aOl().sB() && this.eAF.getText() != null && this.eAF.getText().length() > 0) {
                    this.eAF.setVisibility(0);
                } else {
                    this.eAF.setVisibility(8);
                }
                k(hVar);
                ArrayList<com.baidu.tbadk.core.data.a> rZ = hVar.aOl().rZ();
                if (rZ != null && rZ.size() > 0 && !this.eCE) {
                    this.eBZ.setText(String.valueOf(rZ.get(0).pd()));
                    this.eBY.setVisibility(0);
                    this.eCO = true;
                } else {
                    this.eBY.setVisibility(8);
                }
                com.baidu.tbadk.core.util.at.k(this.eBY, r.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.at.c(this.eBZ, r.d.cp_link_tip_d, 1);
                if (a2.getAuthor() != null) {
                    int level_id = a2.getAuthor().getLevel_id();
                    int is_bawu = a2.getAuthor().getIs_bawu();
                    String bawu_type = a2.getAuthor().getBawu_type();
                    int i3 = 3;
                    if (level_id != 0) {
                        this.eAR.setVisibility(0);
                        com.baidu.tbadk.core.util.at.c(this.eAR, BitmapHelper.getGradeResourceIdNew(level_id));
                        this.eAR.setAlpha(179);
                        this.eAR.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                        this.eAR.setOnClickListener(null);
                    } else {
                        this.eAR.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.eAS.setAlpha(179);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.at.c(this.eAS, r.f.pb_manager);
                            this.eAR.setVisibility(8);
                            this.eAS.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.at.c(this.eAS, r.f.pb_assist);
                            this.eAR.setVisibility(8);
                            this.eAS.setVisibility(0);
                        }
                    }
                    String string = a2.getAuthor().getName_show() == null ? StringUtils.string(a2.getAuthor().getUserName()) : StringUtils.string(a2.getAuthor().getName_show());
                    if (StringUtils.isNull(a2.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aR(a2.getAuthor().getSealPrefix()) + 2;
                    }
                    if (!StringUtils.isNull(string)) {
                        int aR = com.baidu.adp.lib.util.j.aR(a2.getAuthor().getName_show());
                        if (aR + i2 > 14) {
                            i3 = 0;
                        } else if (aR + i2 >= 12) {
                            i3 = 1;
                        } else if (aR + i2 >= 10) {
                            i3 = 2;
                            if (is_bawu == 0) {
                                i3 = 1;
                            }
                        }
                    }
                    ArrayList<IconData> iconInfo = a2.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = a2.getAuthor().getTShowInfoNew();
                    if (this.eAT != null) {
                        this.eAT.setTag(r.g.tag_user_id, a2.getAuthor().getUserId());
                        this.eAT.setOnClickListener(this.eug.euQ.bXu);
                        this.eAT.wQ();
                        this.eAT.a(iconInfo, i3, this.eug.getResources().getDimensionPixelSize(r.e.ds30), this.eug.getResources().getDimensionPixelSize(r.e.ds30), this.eug.getResources().getDimensionPixelSize(r.e.ds10));
                    }
                    if (this.eAU != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.eAU.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.eAU.setOnClickListener(this.eug.euQ.eDk);
                        this.eAU.a(tShowInfoNew, 3, this.eug.getResources().getDimensionPixelSize(r.e.ds32), this.eug.getResources().getDimensionPixelSize(r.e.ds32), this.eug.getResources().getDimensionPixelSize(r.e.ds8), true);
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aR(string) > 12) {
                            string = com.baidu.tbadk.core.util.ax.d(string, 12, "...");
                        }
                    } else if (com.baidu.adp.lib.util.j.aR(string) > 14) {
                        string = com.baidu.tbadk.core.util.ax.d(string, 14, "...");
                    }
                    this.eAN.setText(ag(a2.getAuthor().getSealPrefix(), string));
                    this.eAN.setTag(r.g.tag_user_id, a2.getAuthor().getUserId());
                    this.eAN.setTag(r.g.tag_user_name, a2.getAuthor().getName_show());
                    if (!com.baidu.tbadk.core.util.x.t(tShowInfoNew)) {
                        com.baidu.tbadk.core.util.at.c(this.eAN, r.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.at.c(this.eAN, r.d.cp_cont_f, 1);
                    }
                    this.eAQ.setUserId(a2.getAuthor().getUserId());
                    this.eAQ.setUserName(a2.getAuthor().getUserName());
                    this.eAQ.setImageDrawable(null);
                    this.eAQ.setRadius(com.baidu.adp.lib.util.k.e(this.eug.getActivity(), r.e.ds40));
                    this.eAQ.setTag(a2.getAuthor().getUserId());
                    this.eBa.a(a2.getAuthor());
                    if (!PbNormalLikeButtonSwitchStatic.GN() || this.eBM || (a2.getAuthor().hadConcerned() && a2.getAuthor().getGodUserData() != null && a2.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.eAZ.setVisibility(8);
                    } else {
                        this.eAZ.setVisibility(0);
                    }
                    String portrait = a2.getAuthor().getPortrait();
                    if (a2.getAuthor() != null && a2.getAuthor().getPendantData() != null && !StringUtils.isNull(a2.getAuthor().getPendantData().pR())) {
                        this.eAQ.setVisibility(8);
                        this.eAP.setVisibility(0);
                        if (this.ezk != null) {
                            this.ezk.setVisibility(8);
                        }
                        this.eAN.setOnClickListener(this.eug.euQ.eDj);
                        this.eAN.setOnClickListener(this.eug.euQ.eDj);
                        this.eAP.getHeadView().c(portrait, 28, false);
                        this.eAP.getHeadView().setUserId(a2.getAuthor().getUserId());
                        this.eAP.getHeadView().setUserName(a2.getAuthor().getUserName());
                        this.eAP.getHeadView().setOnClickListener(this.eug.euQ.eDj);
                        this.eAP.dZ(a2.getAuthor().getPendantData().pR());
                    } else if (this.aez) {
                        this.eAQ.setVisibility(0);
                        UserTbVipInfoData userTbVipInfoData = a2.getAuthor().getUserTbVipInfoData();
                        if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null && this.bbQ != null) {
                            if (this.bbR == null) {
                                this.bbQ.inflate();
                                this.bbR = (TbImageView) this.eAG.findViewById(r.g.user_head_mask);
                            }
                            this.bbR.c(userTbVipInfoData.getvipV_url(), 10, false);
                        }
                        this.eAN.setOnClickListener(this.eug.euQ.eDj);
                        this.eAQ.setOnClickListener(this.eug.euQ.eDj);
                        this.eAP.setVisibility(8);
                    } else {
                        if (this.eCq) {
                            fn fnVar = new fn(this, a2);
                            this.eAN.setOnClickListener(fnVar);
                            this.eAQ.setOnClickListener(fnVar);
                            this.eAL.setOnClickListener(fnVar);
                            this.eAQ.setVisibility(8);
                            this.eAP.setVisibility(8);
                        } else {
                            this.eAQ.setVisibility(0);
                            this.eAL.setOnClickListener(this.eug.euQ.eDj);
                            this.eAN.setOnClickListener(this.eug.euQ.eDj);
                            this.eAQ.setOnClickListener(this.eug.euQ.eDj);
                        }
                        this.eAP.setVisibility(8);
                    }
                    this.eAQ.c(portrait, 28, false);
                }
                if (hVar != null) {
                    this.eAJ.v(hVar.aOl());
                }
            }
        }
    }

    public boolean aSg() {
        return this.eCQ;
    }

    private boolean aSh() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean t(com.baidu.tbadk.core.data.bk bkVar) {
        if (bkVar == null || bkVar.getAuthor() == null || bkVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bkVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.g gVar) {
        if (gVar != null) {
            this.eAx.aSR();
            if (!StringUtils.isNull(gVar.forumName)) {
                this.eAx.nh(gVar.forumName);
            }
            String string = this.eug.getResources().getString(r.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.h.b.g(gVar.source, 0)) {
                case 100:
                    str = this.eug.getResources().getString(r.j.self);
                    break;
                case 300:
                    str = this.eug.getResources().getString(r.j.bawu);
                    break;
                case 400:
                    str = this.eug.getResources().getString(r.j.system);
                    break;
            }
            this.eug.showNetRefreshView(this.efO, String.format(string, str), null, this.eug.getResources().getString(r.j.appeal_restore), true, new fo(this, gVar.erT));
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aRB;
        String sb;
        if (hVar != null) {
            if (hVar.aOl() != null) {
                this.eCc = hVar.aOl().rF();
                this.UU = hVar.aOl().rC();
                if (hVar.aOl().getAnchorLevel() != 0) {
                    this.eCQ = true;
                }
                this.eBM = t(hVar.aOl());
            }
            if (hVar.getUserData() != null) {
                this.userId = hVar.getUserData().getUserId();
            }
            n(hVar);
            this.eBX = false;
            this.eth = z;
            aSc();
            b(hVar, z, i);
            if (this.eug.aPv()) {
                if (this.eBn == null) {
                    this.eBn = new com.baidu.tieba.pb.view.u(this.eug.getPageContext());
                    this.eBn.kk();
                    this.eBn.a(this.ahd);
                }
                this.aML.setPullRefresh(this.eBn);
                this.aML.removeHeaderView(this.ark);
                this.aML.f(this.ark, 0);
                if (this.eBn != null) {
                    this.eBn.di(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (hVar.getPage().qE() == 0 && z) {
                this.aML.setPullRefresh(null);
                this.eAv = 1;
            } else {
                if (this.eBn == null) {
                    this.eBn = new com.baidu.tieba.pb.view.u(this.eug.getPageContext());
                    this.eBn.kk();
                    this.eBn.a(this.ahd);
                }
                this.aML.setPullRefresh(this.eBn);
                this.aML.removeHeaderView(this.ark);
                this.aML.f(this.ark, 0);
                this.eAv = 2;
                if (this.eBn != null) {
                    this.eBn.di(TbadkCoreApplication.m9getInst().getSkinType());
                }
                aMZ();
            }
            aSj();
            this.eBj.ik(this.eth);
            this.eBj.il(false);
            this.eBj.b(hVar);
            this.eBj.notifyDataSetChanged();
            if (hVar.aOk() != null) {
                this.mForumName = hVar.aOk().getName();
                this.mForumId = hVar.getForumId();
            }
            this.eAx.nh(this.mForumName);
            if (hVar.aOl() != null) {
                pz(com.baidu.tbadk.core.util.ax.y(hVar.aOl().rJ()));
                if (hVar.aOl().rH() != null) {
                    if (hVar.aOl().rH().getNum() < 1) {
                        sb = this.eug.getResources().getString(r.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(hVar.aOl().rH().getNum())).toString();
                    }
                    if (this.eAu != -1) {
                        hVar.aOl().rH().setIsLike(this.eAu);
                    }
                    N(sb, hVar.aOl().rH().getIsLike() == 1);
                }
            }
            if (hVar.getPage().qD() == 0 && !z) {
                this.aML.setNextPage(null);
                this.eAw = 1;
            } else if (this.eug.isLogin()) {
                this.aML.setNextPage(this.eBo);
                this.eAw = 2;
                aMZ();
            } else if (hVar.getPage().qD() == 1) {
                this.eBX = true;
                if (this.eBp == null) {
                    this.eBp = new com.baidu.tieba.pb.view.b(this.eug.getPageContext());
                }
                this.aML.setNextPage(this.eBp);
                this.eAw = 3;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = hVar.aOm();
            if (hVar.getPage().qD() == 0 || aOm == null || aOm.size() < hVar.getPage().qC()) {
                this.eBo.setText(this.eug.getResources().getString(r.j.list_no_more));
                if (this.eug.aPv() && this.aML != null && this.aML.getData() != null && this.aML.getData().size() == 1 && (this.aML.getData().get(0) instanceof com.baidu.tieba.pb.data.m)) {
                    this.eBo.setText("");
                }
                aSo();
            } else if (z2) {
                if (this.eCN) {
                    wG();
                    if (hVar.getPage().qD() != 0) {
                        this.eBo.setText(this.eug.getResources().getString(r.j.pb_load_more));
                    }
                } else {
                    this.eBo.wI();
                }
            } else {
                this.eBo.wI();
            }
            if (hVar.aOl() != null && hVar.aOl().getAuthor() != null && hVar.aOl().getAuthor().getType() == 0) {
                this.eAx.aSO();
            }
            switch (i) {
                case 2:
                    this.aML.setSelection(i2 > 1 ? i2 - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aRB = eq.aRA().aRB()) != null) {
                        this.eCI = true;
                        this.aML.onRestoreInstanceState(aRB);
                        break;
                    } else {
                        this.aML.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.eCN = false;
                    this.aML.setSelection(0);
                    break;
                case 5:
                    this.aML.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aRB2 = eq.aRA().aRB();
                        this.eCI = true;
                        if (aRB2 != null) {
                            this.aML.onRestoreInstanceState(aRB2);
                            break;
                        }
                    }
                    this.aML.setSelection(0);
                    break;
            }
            if (this.eCc == eCe && aSh()) {
                aSv();
            }
            l(hVar);
            if (!this.eCI && hVar.aOs() == null && !hVar.aOl().sB()) {
                this.eCo.pI(this.eug.getResources().getString(r.j.pb_more_tools_guide_tip));
                this.eCI = true;
            }
        }
    }

    private void l(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aOl() != null && hVar.aOl().sB() && this.eAH != null && this.eAH.getView() != null && this.eAH.getView().getVisibility() == 0) {
            int i = com.baidu.tbadk.core.sharedPref.b.um().getInt(com.baidu.tbadk.core.sharedPref.b.cQ("pb_video_immersive_guide_count_"), 0);
            if (this.eug.aPb() != null) {
                this.eug.aPb().dv(true);
                this.eug.aPb().jd(true);
            }
            if (i < 3) {
                this.mHandler.postDelayed(new fp(this, i), 600L);
            } else {
                this.mHandler.post(new fq(this));
            }
        }
    }

    public boolean aSi() {
        return (this.eAH == null || this.eAH.getView() == null || this.eAH.getView().getParent() == null || this.eAH.getView().getTop() != 0) ? false : true;
    }

    public void iX(boolean z) {
        this.eBL = z;
        this.eAx.iX(z);
    }

    public void wG() {
        if (this.eBo != null) {
            this.eBo.wG();
        }
        aMZ();
    }

    public void Km() {
        this.aML.setVisibility(0);
    }

    private boolean aSj() {
        boolean z;
        if (this.eBO != null && this.eBO.getVisibility() == 0) {
            z = true;
            if (this.eBe != null) {
                this.eBe.setVisibility(0);
            }
        } else {
            if (this.eBe != null) {
                this.eBe.setVisibility(8);
            }
            z = false;
        }
        if ((this.eBg == null || this.eBg.getVisibility() == 8) && z && this.eth) {
            this.eBf.setVisibility(0);
        } else {
            this.eBf.setVisibility(8);
        }
        com.baidu.tieba.graffiti.d.ak(this.eBf);
        return z;
    }

    private boolean m(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null || hVar.aOl() == null) {
            return false;
        }
        if (hVar.aOl().rN() == 1 || hVar.aOl().getThreadType() == 33) {
            return true;
        }
        return !(hVar.aOl().rP() == null || hVar.aOl().rP().td() == 0) || hVar.aOl().rL() == 1 || hVar.aOl().rM() == 1 || hVar.aOl().st() || hVar.aOl().sG() || hVar.aOl().sA() || hVar.aOl().sa() != null || hVar.aOl().sH() || hVar.aOl().sH() || !com.baidu.tbadk.core.util.ax.isEmpty(hVar.aOl().rI());
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new an.a(str));
            return com.baidu.tieba.card.an.a((Context) this.eug.getActivity(), str2, (ArrayList<an.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, boolean z, boolean z2) {
        if (hVar != null) {
            if (this.eAE != null) {
                if (hVar.aOl() != null && hVar.aOl().sd() == 0 && !hVar.aOl().sB() && !this.eCE) {
                    this.eAE.setVisibility(0);
                    hVar.aOl().sx();
                    if (hVar.aOl() != null) {
                        hVar.aOl().e(true, m(hVar));
                    }
                    SpannableStringBuilder so = hVar.aOl().so();
                    this.eAF.setOnTouchListener(new com.baidu.tieba.view.x(so));
                    if (so == null || so.length() == 0) {
                        this.eAF.setVisibility(8);
                    } else {
                        this.eAF.setText(so);
                        this.eAF.setVisibility(0);
                    }
                    this.eAL.setPadding(this.eAL.getPaddingLeft(), this.eAL.getPaddingTop(), com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds32), this.eAL.getPaddingBottom());
                } else {
                    this.eAE.setVisibility(8);
                    this.aML.removeHeaderView(this.eAE);
                    if (hVar.aOl() != null && hVar.aOl().sB()) {
                        this.eAL.setPadding(this.eAL.getPaddingLeft(), 0, this.eAL.getPaddingRight(), this.eAL.getPaddingBottom());
                    } else {
                        this.eAL.setPadding(this.eAL.getPaddingLeft(), com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds48), this.eAL.getPaddingRight(), this.eAL.getPaddingBottom());
                    }
                }
            }
            this.eth = z;
            com.baidu.tbadk.core.data.bk aOl = hVar.aOl();
            if (aOl != null) {
                a(aOl.rP());
            }
        }
        return false;
    }

    public void a(com.baidu.tieba.pb.data.h hVar, boolean z, boolean z2, int i) {
        if (hVar != null) {
            a(hVar, z, z2);
            aSj();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.q a2;
        if (hVar == null || (a2 = a(hVar, z)) == null) {
            return null;
        }
        String userId = a2.getAuthor().getUserId();
        boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 0) {
            sparseArray.put(r.g.tag_del_post_id, a2.getId());
            sparseArray.put(r.g.tag_del_post_type, 0);
            sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(hVar.aOt()));
            sparseArray.put(r.g.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (a2.getAuthor() != null) {
                sparseArray.put(r.g.tag_forbid_user_name, a2.getAuthor().getUserName());
                sparseArray.put(r.g.tag_forbid_user_post_id, a2.getId());
            }
            sparseArray.put(r.g.tag_del_post_id, a2.getId());
            sparseArray.put(r.g.tag_del_post_type, 0);
            sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(hVar.aOt()));
            sparseArray.put(r.g.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aBs;
    }

    public void pA(String str) {
        if (this.eBo != null && !StringUtils.isNull(str)) {
            this.eBo.setText(str);
        }
    }

    public BdListView PW() {
        return this.aML;
    }

    public int aSk() {
        return r.g.richText;
    }

    public TextView aOX() {
        return this.eAJ.aOX();
    }

    public void c(BdListView.e eVar) {
        this.aML.setOnSrollToBottomListener(eVar);
    }

    public void a(z.b bVar) {
        this.ahd = bVar;
        if (this.eBn != null) {
            this.eBn.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, a.b bVar) {
        if (aoVar != null) {
            int qB = aoVar.qB();
            int qy = aoVar.qy();
            if (this.eBk != null) {
                this.eBk.tq();
            } else {
                this.eBk = new com.baidu.tbadk.core.dialog.a(this.eug.getPageContext().getPageActivity());
                this.eBl = LayoutInflater.from(this.eug.getPageContext().getPageActivity()).inflate(r.h.dialog_direct_pager, (ViewGroup) null);
                this.eBk.z(this.eBl);
                this.eBk.a(r.j.dialog_ok, bVar);
                this.eBk.b(r.j.dialog_cancel, new fr(this));
                this.eBk.a(new ft(this));
                this.eBk.b(this.eug.getPageContext()).tq();
            }
            this.eBm = (EditText) this.eBl.findViewById(r.g.input_page_number);
            this.eBm.setText("");
            TextView textView = (TextView) this.eBl.findViewById(r.g.current_page_number);
            if (qB <= 0) {
                qB = 1;
            }
            if (qy <= 0) {
                qy = 1;
            }
            textView.setText(MessageFormat.format(this.eug.getApplicationContext().getResources().getString(r.j.current_page), Integer.valueOf(qB), Integer.valueOf(qy)));
            this.eug.ShowSoftKeyPadDelay(this.eBm, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aML.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eug.showToast(str);
    }

    public boolean iY(boolean z) {
        if (this.EL == null || !this.EL.CR()) {
            return false;
        }
        this.EL.Bc();
        return true;
    }

    public void aSl() {
        if (this.eCR != null) {
            while (this.eCR.size() > 0) {
                TbImageView remove = this.eCR.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aSl();
        this.eBj.oz(1);
    }

    public void onResume() {
        this.eBj.oz(2);
    }

    public void onDestroy() {
        this.eCo.aSJ();
        this.eug.hideProgressBar();
        if (this.bpe != null && this.aTn != null) {
            this.bpe.b(this.aTn);
        }
        aCY();
        this.eBo.wG();
        if (this.eCk != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eCk);
        }
        if (this.eCl != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eCl);
        }
        aSs();
        if (this.eCD != null) {
            this.eCD.removeAllViews();
        }
        if (this.eAL != null && this.ezk != null) {
            this.eAL.removeView(this.eAO);
            this.ezk = null;
        }
        if (this.eCb != null) {
            this.eCb.clearStatus();
        }
        this.eCJ = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eBj.oz(3);
        if (this.bMp != null) {
            this.bMp.setBackgroundDrawable(null);
        }
    }

    public void aCY() {
        this.eAx.od();
        this.eCo.aSJ();
        com.baidu.adp.lib.util.k.b(this.eug.getPageContext().getPageActivity(), this.eBm);
        if (this.eBK != null) {
            this.eBK.dismiss();
        }
        aSm();
    }

    public void ij(boolean z) {
        this.eBj.ij(z);
    }

    public void gX(boolean z) {
        this.dEi = z;
    }

    public void aSm() {
        if (this.eBt != null) {
            this.eBt.dismiss();
        }
        if (this.eBu != null) {
            com.baidu.adp.lib.h.j.b(this.eBu, this.eug.getPageContext());
        }
        if (this.eBD != null) {
            com.baidu.adp.lib.h.j.b(this.eBD, this.eug.getPageContext());
        }
        if (this.eBr != null) {
            com.baidu.adp.lib.h.j.b(this.eBr, this.eug.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.eug.getLayoutMode().ai(i == 1);
        this.eug.getLayoutMode().x(this.efO);
        this.eug.getLayoutMode().x(this.eAF);
        this.eug.getLayoutMode().x(this.eAG);
        this.eug.getLayoutMode().x(this.eAC);
        com.baidu.tbadk.core.util.at.j((View) this.eAF, r.d.cp_cont_b);
        this.eAF.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_c));
        if (this.eAI != null) {
            com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(3);
            bVar.erI = this.eAI.erI;
            bVar.erJ = this.eAI.erJ;
            bVar.aiA = i;
            bVar.erE = this.eug;
            bVar.aNX();
        }
        this.eug.getLayoutMode().x(this.aBs);
        if (this.eBl != null) {
            this.eug.getLayoutMode().x(this.eBl);
        }
        iX(this.eBL);
        this.eBj.notifyDataSetChanged();
        if (this.eBn != null) {
            this.eBn.di(i);
        }
        if (this.eBo != null) {
            this.eBo.di(i);
            com.baidu.tbadk.core.util.at.k(this.aBs, r.f.pb_foot_more_trans_selector);
            this.eBo.dg(r.f.pb_foot_more_trans_selector);
        }
        if (this.EL != null) {
            this.EL.onChangeSkinType(i);
        }
        if (this.eAX != null) {
            this.eAX.dm(i);
        }
        if (this.eBp != null) {
            this.eBp.di(i);
        }
        if (this.eAB != null && this.eAB.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eAB) {
                aVar.aSK();
            }
        }
        if (this.eCD != null) {
            com.baidu.tbadk.core.util.at.l(this.eCD, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(this.eCx, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(this.eCC, r.d.cp_cont_c, 1);
        }
        iR(i == 1);
        this.eAK.changeSkinType(i);
        aRQ();
        UtilHelper.setStatusBarBackground(this.bMp, i);
        if (this.eAZ != null) {
            this.eAZ.onChangeSkinType(i);
        }
        if (this.eBb != null) {
            com.baidu.tbadk.i.a.a(this.eug.getPageContext(), this.eBb);
        }
        if (this.eCn != null) {
            this.eCn.onChangeSkinType(i);
        }
        if (this.eAx != null) {
            this.eAx.onChangeSkinType(i);
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJZ = eVar;
        this.eBj.setOnImageClickListener(this.aJZ);
    }

    public void g(NoNetworkView.a aVar) {
        this.aTn = aVar;
        if (this.bpe != null) {
            this.bpe.a(this.aTn);
        }
    }

    public void iZ(boolean z) {
        this.eBj.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aSn() {
        return this.eBO;
    }

    public void aSo() {
        if (this.eAw != 2) {
            this.aML.setNextPage(this.eBo);
            this.eAw = 2;
        }
    }

    public void aSp() {
        if (com.baidu.tbadk.performanceLog.aa.Gu().Gv()) {
            int lastVisiblePosition = this.aML.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aML.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(r.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.fg(1001);
                                perfLog.aCC = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.wm();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(r.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fg(1001);
                        perfLog2.aCC = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.wm();
                    }
                }
            }
        }
    }

    public void gY(boolean z) {
        if (this.eBP != null && this.eBP != null) {
            if (this.dEi && !aSF()) {
                gZ(z);
            } else {
                ha(z);
            }
        }
    }

    public void aSq() {
        if (this.eBP != null) {
            this.eBP.setVisibility(8);
        }
    }

    public void aAF() {
        if (this.eBW == null) {
            this.eBW = new com.baidu.tbadk.core.view.a(this.eug.getPageContext());
        }
        this.eBW.aI(true);
    }

    public void aMZ() {
        if (this.eBW != null) {
            this.eBW.aI(false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.q qVar, String str, String str2, boolean z, boolean z2) {
        this.eAQ.setIsRound(true);
        if (this.eAx != null) {
            this.eAx.mNavigationBar.setBackgroundResource(0);
            ((ViewGroup.MarginLayoutParams) this.eAx.eDH.getLayoutParams()).leftMargin = this.eug.getResources().getDimensionPixelOffset(r.e.ds6);
            this.aML.removeHeaderView(this.ark);
        }
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.q qVar, String str, String str2, boolean z, boolean z2) {
        FrameLayout.LayoutParams layoutParams;
        if (qVar == null || qVar.getAuthor() == null || qVar.getAuthor().getGodUserData() == null) {
            return false;
        }
        GodUserData godUserData = qVar.getAuthor().getGodUserData();
        if (2 != godUserData.getType()) {
            return false;
        }
        MetaData author = qVar.getAuthor();
        long userIdLong = qVar.getAuthor().getUserIdLong();
        String userName = qVar.getAuthor().getUserName();
        int fansNum = qVar.getAuthor().getFansNum();
        qVar.getId();
        String portrait = qVar.getAuthor().getPortrait();
        if (this.eAZ.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.eAZ.getLayoutParams();
            aVar.gravity = 48;
            this.eAZ.setLayoutParams(aVar);
        }
        this.eAL.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32), 0);
        this.eCm.setPadding(0, com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds8), 0, 0);
        if (qVar.getType() == null || qVar.getType().getId() != com.baidu.tieba.tbadkCore.data.q.TP.getId()) {
            this.eAC.setPadding(0, 0, 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds76);
        if (this.eAQ.getLayoutParams() == null) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eAQ.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        this.eAQ.setLayoutParams(layoutParams);
        this.eAQ.setVisibility(8);
        View findViewWithTag = this.eAL.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.ezk = new ClickableHeaderImageView(this.eug.getApplicationContext());
            this.ezk.setGodIconMargin(0);
            this.ezk.setTag("pb_god_head_image_view_tag");
            this.ezk.setUserId(String.valueOf(userIdLong));
            this.ezk.setUserName(userName);
            layoutParams.leftMargin = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds0);
            this.eAO.addView(this.ezk, 0, layoutParams);
        } else {
            this.ezk = (ClickableHeaderImageView) findViewWithTag;
        }
        if (this.aez) {
            this.ezk.setIsBigV(true);
        }
        fv fvVar = new fv(this, qVar);
        this.eAL.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
        this.eAL.setTag(r.g.tag_user_name, userName);
        this.eAG.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
        this.eAG.setTag(r.g.tag_user_name, userName);
        this.ezk.setVisibility(0);
        this.ezk.setOnClickListener(fvVar);
        this.ezk.c(portrait, 28, false);
        if (this.eAW == null) {
            this.eAW = new TextView(this.eug.getActivity());
            this.eAW.setClickable(true);
            this.eAW.setTextSize(0, this.eug.getResources().getDimensionPixelSize(r.e.fontsize24));
            ColumnLayout.a aVar2 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar2.topMargin = this.eug.getResources().getDimensionPixelSize(r.e.ds10);
            this.eAW.setSingleLine(true);
            this.eAW.setEllipsize(TextUtils.TruncateAt.END);
            this.eAW.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
            this.eAW.setTag(r.g.tag_user_name, userName);
            com.baidu.tbadk.core.util.at.c(this.eAW, r.d.cp_cont_d, 1);
            this.eAW.setOnTouchListener(this.esT);
            this.eAL.addView(this.eAW, -1, aVar2);
        }
        String string = this.eug.getResources().getString(r.j.tieba_certification);
        this.eAW.setText(StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.eug.getResources().getString(r.j.god_intro_default)) : String.format(string, godUserData.getIntro()));
        if (this.eAV == null) {
            this.eAV = new TextView(this.eug.getActivity());
            this.eAV.setClickable(false);
            this.eAV.setIncludeFontPadding(false);
            this.eAV.setGravity(16);
            this.eAV.setTextSize(0, this.eug.getResources().getDimensionPixelSize(r.e.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.eug.getResources().getDimensionPixelSize(r.e.ds5);
            aVar3.bottomMargin = this.eug.getResources().getDimensionPixelSize(r.e.ds10);
            this.eAV.setSingleLine(true);
            com.baidu.tbadk.core.util.at.c(this.eAV, r.d.cp_cont_d, 1);
            this.eAL.addView(this.eAV, -1, aVar3);
        }
        String format = String.format(this.eug.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ax.v(fansNum));
        this.eAV.setText(format);
        this.eAV.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
        this.eAV.setTag(r.g.tag_user_name, userName);
        this.eAV.setOnClickListener(fvVar);
        if (this.eCu == null) {
            this.eCu = new TextView(this.eug.getApplicationContext());
            this.eCu.setId(r.g.pb_god_user_tip_content);
            this.eCu.setEllipsize(TextUtils.TruncateAt.END);
            this.eCu.setGravity(17);
            this.eCu.setSingleLine(true);
            this.eCu.setHeight(this.eug.getResources().getDimensionPixelSize(r.e.ds56));
            this.eCu.setTextSize(0, this.eug.getResources().getDimensionPixelSize(r.e.fontsize24));
            this.eCu.setVisibility(8);
            if (aSy() != null) {
                aSy().addView(this.eCu);
            }
            this.eug.getLayoutMode().x(this.eCu);
        }
        com.baidu.tbadk.core.util.at.k(this.eCu, r.d.common_color_10260);
        com.baidu.tbadk.core.util.at.j((View) this.eCu, r.d.cp_cont_g);
        this.eCu.setOnClickListener(new fw(this));
        this.eCu.setText(String.format(this.eug.getResources().getString(r.j.god_user_floor_owner_tip), com.baidu.tbadk.core.util.ax.v(this.eCv)));
        oO(this.eCv);
        if (this.eCt == null) {
            this.eCt = (LinearLayout) LayoutInflater.from(this.eug.getActivity()).inflate(r.h.god_floating_view, (ViewGroup) null);
            this.eCt.setOnClickListener(fvVar);
            this.eCt.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
            this.eCt.setTag(r.g.tag_user_name, userName);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.eCt.findViewById(r.g.god_floating_owner_photo);
            if (this.aez) {
                ViewStub viewStub = (ViewStub) this.eCt.findViewById(r.g.viewstub_headimage_mask);
                if (viewStub != null && 0 == 0) {
                    viewStub.inflate();
                    TbImageView tbImageView = (TbImageView) this.eCt.findViewById(r.g.user_head_mask);
                    if (tbImageView != null && author != null && author.getUserTbVipInfoData() != null && !StringUtils.isNull(author.getUserTbVipInfoData().getvipV_url())) {
                        tbImageView.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                        clickableHeaderImageView.setIsBigV(true);
                    }
                }
            } else {
                clickableHeaderImageView.setGodIconMargin(0);
            }
            clickableHeaderImageView.setOnClickListener(fvVar);
            clickableHeaderImageView.setTag(qVar.getAuthor().getUserId());
            clickableHeaderImageView.c(qVar.getAuthor().getPortrait(), 28, false);
            ImageView imageView = (ImageView) this.eCt.findViewById(r.g.god_floating_owner_info_user_rank);
            int level_id = qVar.getAuthor().getLevel_id();
            int is_bawu = qVar.getAuthor().getIs_bawu();
            String bawu_type = qVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.at.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                imageView.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.eCt.findViewById(r.g.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.at.c(imageView2, r.f.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.at.c(imageView2, r.f.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            if (!StringUtils.isNull(qVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aR(qVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = qVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.eCt.findViewById(r.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.eCt.findViewById(r.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.eug.euQ.bXu);
                userIconBox.a(iconInfo, i, this.eug.getResources().getDimensionPixelSize(r.e.ds30), this.eug.getResources().getDimensionPixelSize(r.e.ds30), this.eug.getResources().getDimensionPixelSize(r.e.ds10));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.eug.euQ.eDk);
                userIconBox2.a(tShowInfoNew, 3, this.eug.getResources().getDimensionPixelSize(r.e.ds32), this.eug.getResources().getDimensionPixelSize(r.e.ds32), this.eug.getResources().getDimensionPixelSize(r.e.ds8), true);
            }
            TextView textView = (TextView) this.eCt.findViewById(r.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_f, 1);
            }
            textView.setText(qVar.getAuthor().getName_show());
            if (aSy() != null) {
                aSy().addView(this.eCt);
            }
            this.eug.getLayoutMode().x(this.eCt);
        }
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) this.eCt.findViewById(r.g.god_floating_gift);
        this.eCG.a(entelechyUserLikeButton);
        this.eCG.a(qVar.getAuthor());
        ImageView imageView3 = (ImageView) this.eCt.findViewById(r.g.god_floating_arrow);
        com.baidu.tbadk.core.util.at.c(imageView3, r.f.icon_arrow_tab);
        if (this.eBM || (godUserData.getIsLike() && godUserData.getIsFromNetWork())) {
            entelechyUserLikeButton.setVisibility(8);
            imageView3.setVisibility(0);
        } else {
            entelechyUserLikeButton.setVisibility(0);
            imageView3.setVisibility(8);
        }
        TextView textView2 = (TextView) this.eCt.findViewById(r.g.god_floating_intro);
        if (textView2 != null) {
            textView2.setText(format);
        }
        this.eCD = this.eBo.wC();
        if (this.eCD != null && !this.eBM && !z && z2 && (!godUserData.getIsLike() || !godUserData.getIsFromNetWork())) {
            this.eBo.wD();
            this.eBo.wz();
            this.eCx = this.eCD.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.eCx == null) {
                this.eCx = new View(this.eug.getApplicationContext());
                this.eCx.setTag("pb_god_bottom_extra_line_view_tag");
                this.eCD.addView(this.eCx, new LinearLayout.LayoutParams(-1, this.eug.getResources().getDimensionPixelSize(r.e.ds20)));
                this.eCB = new FrameLayout(this.eug.getApplicationContext());
                this.eCB.setTag("pb_god_bottom_extra_god_avatar_frame_tag");
                this.eCz = new ClickableHeaderImageView(this.eug.getApplicationContext());
                this.eCz.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.eCz.c(portrait, 28, false);
                this.eCz.setUserId(String.valueOf(userIdLong));
                this.eCz.setUserName(userName);
                this.eCz.setOnClickListener(fvVar);
                this.eCB.addView(this.eCz, new FrameLayout.LayoutParams(this.eug.getResources().getDimensionPixelSize(r.e.ds130), this.eug.getResources().getDimensionPixelSize(r.e.ds130)));
                if (this.aez) {
                    this.eCA = new TbImageView(this.eug.getApplicationContext());
                    this.eCA.setTag("pb_god_bottom_extra_god_avatar_mask_tag");
                    this.eCA.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.eug.getResources().getDimensionPixelSize(r.e.ds45), this.eug.getResources().getDimensionPixelSize(r.e.ds45));
                    layoutParams3.gravity = 85;
                    this.eCB.addView(this.eCA, layoutParams3);
                } else {
                    this.eCz.setGodIconMargin(0);
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(this.eug.getResources().getDimensionPixelSize(r.e.ds130), this.eug.getResources().getDimensionPixelSize(r.e.ds130));
                layoutParams4.gravity = 17;
                layoutParams4.topMargin = this.eug.getResources().getDimensionPixelSize(r.e.ds40);
                this.eCD.addView(this.eCB, layoutParams4);
                this.eCC = new TextView(this.eug.getApplicationContext());
                this.eCC.setTag("pb_god_bottom_extra_text_view_tag");
                this.eCC.setSingleLine(true);
                this.eCC.setTextSize(0, this.eug.getResources().getDimensionPixelSize(r.e.fontsize24));
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams5.topMargin = this.eug.getResources().getDimensionPixelSize(r.e.ds36);
                layoutParams5.gravity = 1;
                this.eCC.setText(this.eug.getResources().getString(r.j.god_user_attention_tip));
                this.eCD.addView(this.eCC, layoutParams5);
                if (this.eCy == null) {
                    this.eCy = new EntelechyUserLikeButton(this.eug.getApplicationContext());
                    this.eCH.a(this.eCy);
                }
                this.eCy.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.eCy.setTextSize(0, this.eug.getResources().getDimensionPixelSize(r.e.fontsize24));
                this.eCy.setGravity(17);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, this.eug.getResources().getDimensionPixelSize(r.e.ds54));
                layoutParams6.topMargin = this.eug.getResources().getDimensionPixelSize(r.e.ds30);
                layoutParams6.bottomMargin = this.eug.getResources().getDimensionPixelSize(r.e.ds40);
                layoutParams6.gravity = 1;
                this.eCD.addView(this.eCy, layoutParams6);
            } else {
                this.eCy = (EntelechyUserLikeButton) this.eCD.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.eCz = (ClickableHeaderImageView) this.eCD.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.eCC = (TextView) this.eCD.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.eCx = this.eCD.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            this.eCH.a(qVar.getAuthor());
            com.baidu.tbadk.core.util.at.l(this.eCD, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(this.eCx, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(this.eCC, r.d.cp_cont_c, 1);
            this.eCD.setOnTouchListener(new fx(this));
        } else {
            this.eBo.wE();
            this.eBo.wy();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.eCq && !this.eCr && i > this.eAv) {
            this.eCs = true;
        } else {
            this.eCs = false;
            aSt();
        }
        a aVar = new a();
        aVar.eCZ = i;
        aVar.eDa = this.aML.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
        aSr();
    }

    /* loaded from: classes.dex */
    public class a {
        public int eCZ;
        public int eDa;

        public a() {
        }
    }

    public void aSr() {
        float f = 1.0f;
        if (this.eAI != null && this.eAI.erI != null && this.eBh) {
            int dimension = (int) this.eug.getResources().getDimension(r.e.ds98);
            int dimension2 = ((int) this.eug.getResources().getDimension(r.e.ds450)) - (-this.eAI.erI.getTop());
            if (this.aML.getChildAt(0) == this.eAI.erI && dimension2 >= dimension) {
                if (dimension2 < dimension || dimension2 > dimension * 2) {
                    f = dimension2 > dimension * 2 ? 0.0f : 0.0f;
                } else {
                    f = 1.0f - (((dimension2 - dimension) * 1.0f) / dimension);
                }
            }
            this.eAx.aq(f);
        }
    }

    private void oO(int i) {
        boolean z;
        if (this.eCu != null && this.eCu.getVisibility() != 0 && i >= 2 && !this.eBM) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.eCw = true;
                this.eCu.setVisibility(0);
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.bWk, 3000L);
        }
    }

    public void aSs() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bWk);
        if (this.eCu != null && 8 != this.eCu.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.eug, this.eCu, r.a.fade_out, new fy(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.um().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.um().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aSt() {
        if (this.eCt != null) {
            this.eCt.clearAnimation();
            if (this.eCt.getVisibility() != 8) {
                this.eCt.setVisibility(8);
            }
        }
    }

    public void aSu() {
        if (this.eCq && this.eCs && this.eCt != null && this.eCt.getVisibility() != 0 && !this.eCw) {
            this.eCt.clearAnimation();
            this.eCt.setVisibility(0);
        }
    }

    public void aSv() {
        if (!this.eCS) {
            TiebaStatic.log("c10490");
            this.eCS = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eug.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eCf, Integer.valueOf(eCh));
            aVar.bZ(r.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eug.getPageContext().getPageActivity()).inflate(r.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(r.g.function_description_view)).setText(r.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(r.g.title_view)).setText(r.j.grade_thread_tips);
            aVar.z(inflate);
            aVar.A(sparseArray);
            aVar.a(r.j.grade_button_tips, this.eug);
            aVar.b(r.j.look_again, new fz(this));
            aVar.b(this.eug.getPageContext()).tq();
        }
    }

    public void aSw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eug.getPageContext().getPageActivity());
        aVar.cF(this.eug.getResources().getString(r.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eCf, Integer.valueOf(eCj));
        aVar.A(sparseArray);
        aVar.a(r.j.upgrade_to_new, this.eug);
        aVar.b(r.j.cancel, new ga(this));
        aVar.b(this.eug.getPageContext()).tq();
    }

    public int rF() {
        return this.eCc;
    }

    public void pB(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eug.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eug.getPageContext().getPageActivity()).inflate(r.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(r.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(r.g.function_description_view)).setVisibility(8);
        aVar.z(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eCf, Integer.valueOf(eCi));
        aVar.A(sparseArray);
        aVar.a(r.j.view, this.eug);
        aVar.b(r.j.cancel, new gb(this));
        aVar.b(this.eug.getPageContext()).tq();
    }

    public void a(int i, com.baidu.tieba.pb.data.h hVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.q a2;
        if (i > 0 && (a2 = a(hVar, z)) != null && a2.getAuthor() != null) {
            MetaData author = a2.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        b(hVar, z, i);
    }

    public PbInterviewStatusView aSx() {
        return this.eCb;
    }

    private void n(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aOl() != null && hVar.aOl().sG() && this.eCb == null) {
            this.eCb = (PbInterviewStatusView) this.eCa.inflate();
            this.eCb.setOnClickListener(this.bTO);
            this.eCb.setCallback(this.eug.aPE());
            this.eCb.a(this.eug, hVar);
        }
    }

    public LinearLayout aSy() {
        return this.eBi;
    }

    public View aSz() {
        return this.bMp;
    }

    public boolean aSA() {
        return this.eCE;
    }

    public void aQg() {
        this.eAK.aQg();
    }

    public void im(boolean z) {
        this.eAJ.im(z);
    }

    private void aSB() {
        if (this.eCE) {
            if (this.eCF == null) {
                f.a aVar = f.eui.get();
                if (aVar != null) {
                    this.eCF = aVar.a(this.eug);
                    ListAdapter adapter = this.aML.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.ark) {
                            this.aML.f(this.eCF.aOV(), 1);
                        } else {
                            this.aML.f(this.eCF.aOV(), 0);
                        }
                    }
                } else {
                    this.eAG.setVisibility(0);
                    return;
                }
            }
            this.eAG.setVisibility(8);
            this.aML.removeHeaderView(this.eAG);
            return;
        }
        this.eAG.setVisibility(0);
    }

    public void ja(boolean z) {
        this.eCE = z;
    }

    public View aQk() {
        return this.eAK.aQk();
    }

    public void aSC() {
        this.eug.showNetRefreshView(getView(), "");
        View EF = this.eug.getRefreshView().EF();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EF.getLayoutParams();
        layoutParams.addRule(3, aSy().getId());
        EF.setLayoutParams(layoutParams);
        this.eug.hideLoadingView(getView());
        if (this.eCF != null) {
            this.aML.removeHeaderView(this.eCF.aOV());
            this.eCF = null;
        }
    }

    public void pC(String str) {
        if (this.eAy != null) {
            this.eAy.setTitle(str);
        }
    }

    public void Da() {
        this.eAK.Da();
    }

    public void aSD() {
        if (this.eBj != null) {
            if (this.eBj.aPQ() != null) {
                this.eBj.aPQ().aEh();
            }
            if (this.eBj.aPR() != null) {
                this.eBj.aPR().aEh();
            }
        }
    }

    private int jb(boolean z) {
        if (this.eCb == null || this.eCb.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.e(this.eug.getPageContext().getPageActivity(), r.e.ds72);
    }

    private void aSE() {
        if (this.eCb != null && this.eCb.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCb.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eCb.setLayoutParams(layoutParams);
        }
    }

    public boolean aSF() {
        return this.eBh;
    }

    public boolean aPe() {
        return this.eCq;
    }

    public TextView aSG() {
        return this.eAW;
    }
}
