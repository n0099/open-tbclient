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
import com.baidu.tieba.card.ap;
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
public class er {
    public static int egj = 2;
    public static int egk = 3;
    public static int egl = 0;
    public static int egm = 3;
    public static int egn = 4;
    public static int ego = 5;
    public static int egp = 6;
    private com.baidu.tbadk.editortools.j EM;
    private View aAM;
    private BdTypeListView aMc;
    private boolean adS;
    private z.b agw;
    private TextView aqN;
    private ViewStub baW;
    private TbImageView baX;
    private NoNetworkView bpG;
    private View bst;
    private View.OnClickListener bzZ;
    private RelativeLayout dKv;
    private View.OnClickListener dXG;
    private com.baidu.tieba.pb.a.d dXp;
    private PbActivity dYB;
    PbActivity.c dZT;
    private com.baidu.tieba.pb.pb.main.view.c ebe;
    public int eeD;
    public final com.baidu.tieba.pb.pb.main.view.g eeG;
    public com.baidu.tieba.pb.pb.main.view.e eeH;
    private ViewStub eeI;
    private ViewStub eeJ;
    private List<com.baidu.tieba.pb.pb.main.view.a> eeK;
    private View eeL;
    private LinearLayout eeP;
    private g eeR;
    private db eeS;
    private ColumnLayout eeT;
    private ThreadSkinView eeU;
    private TextView eeV;
    private FrameLayout eeW;
    private HeadPendantView eeX;
    private HeadImageView eeY;
    private ImageView eeZ;
    private View efV;
    private TextView efW;
    private TextView efX;
    private ViewGroup efY;
    private TextView efZ;
    private ImageView efa;
    private UserIconBox efb;
    private UserIconBox efc;
    private EntelechyUserLikeButton efg;
    private com.baidu.tbadk.core.view.userLike.c efh;
    private LinearLayout efi;
    private TextView efj;
    private TextView efk;
    private View efl;
    private View efm;
    private ObservedChangeLinearLayout efo;
    private cj efp;
    private PbListView efu;
    private View efw;
    private View egD;
    private EntelechyUserLikeButton egE;
    private ClickableHeaderImageView egF;
    private TbImageView egG;
    private FrameLayout egH;
    private TextView egI;
    private LinearLayout egJ;
    private boolean egK;
    private f egL;
    private com.baidu.tbadk.core.view.userLike.c egM;
    private com.baidu.tbadk.core.view.userLike.c egN;
    private Runnable egQ;
    private PbActivity.a egS;
    private boolean egU;
    private boolean egV;
    private boolean egb;
    private View ege;
    private TextView egf;
    private ViewStub egg;
    private PbInterviewStatusView egh;
    private Runnable egq;
    private Runnable egr;
    private FloatingLayout egs;
    private cv egt;
    private com.baidu.tieba.pb.pb.main.a.f egu;
    private int eeE = 1;
    private int eeF = 0;
    private final Handler mHandler = new Handler();
    private View eeM = null;
    private LinearLayout eeN = null;
    private TextView eeO = null;
    private com.baidu.tieba.pb.pb.a.s eeQ = null;
    private TextView efd = null;
    private TextView efe = null;
    public FrsPraiseView eff = null;
    private ClickableHeaderImageView edv = null;
    private View efn = null;
    private com.baidu.tbadk.core.dialog.a efq = null;
    private com.baidu.tbadk.core.dialog.c bzQ = null;
    private View efr = null;
    private EditText efs = null;
    private com.baidu.tieba.pb.view.m eft = null;
    private com.baidu.tieba.pb.view.b efv = null;
    private c.b cQl = null;
    private TbRichTextView.e aJq = null;
    private NoNetworkView.a aSE = null;
    private Dialog efx = null;
    private View efy = null;
    private com.baidu.tbadk.core.dialog.a efz = null;
    private Dialog efA = null;
    private View efB = null;
    private int efC = 0;
    private RadioGroup Hv = null;
    private RadioButton efD = null;
    private RadioButton efE = null;
    private RadioButton efF = null;
    private Button efG = null;
    private Button efH = null;
    private TextView efI = null;
    private Dialog efJ = null;
    private View efK = null;
    private LinearLayout efL = null;
    private CompoundButton.OnCheckedChangeListener efM = null;
    private TextView efN = null;
    private TextView efO = null;
    private String efP = null;
    private com.baidu.tbadk.core.dialog.c efQ = null;
    private boolean efR = false;
    private boolean efS = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView efT = null;
    private boolean dhg = false;
    private Button efU = null;
    private boolean ega = true;
    private com.baidu.tbadk.core.view.a egc = null;
    private boolean dXC = false;
    private boolean egd = false;
    private boolean mIsFromCDN = true;
    private int egi = 0;
    private a.InterfaceC0072a egv = new es(this);
    private boolean egw = false;
    private boolean egx = false;
    private boolean egy = false;
    private LinearLayout egz = null;
    private TextView egA = null;
    private int egB = 0;
    private boolean egC = false;
    private boolean egO = false;
    private Handler egP = new Handler();
    private CustomMessageListener egR = new fc(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean egT = true;
    private boolean egW = false;
    private boolean Us = false;
    String userId = null;
    private final List<TbImageView> egX = new ArrayList();
    private boolean egY = false;
    private Runnable bCu = new fl(this);

    public f aLy() {
        return this.egL;
    }

    public NoNetworkView aLz() {
        return this.bpG;
    }

    public boolean isFullScreen() {
        return this.egx;
    }

    public void aLA() {
        if (this.EM != null) {
            this.EM.hide();
        }
    }

    public com.baidu.tieba.pb.pb.main.view.c aLB() {
        return this.ebe;
    }

    public cv aLC() {
        return this.egt;
    }

    public void aLD() {
        reset();
        this.ega = true;
        if (this.EM != null) {
            this.EM.hide();
        }
        this.egt.aJT();
        if (this.efV != null) {
            if (this.dhg) {
                gJ(false);
            } else {
                gK(false);
            }
        }
        aKg();
    }

    private void reset() {
        if (this.dYB != null && this.dYB.aIX() != null && this.EM != null) {
            com.baidu.tbadk.editortools.e.b.CY().setStatus(0);
            com.baidu.tbadk.editortools.e.e aIX = this.dYB.aIX();
            aIX.Ds();
            if (aIX.getWriteImagesInfo() != null) {
                aIX.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aIX.eL(10);
            aIX.eJ(SendView.ALL);
            aIX.eK(SendView.ALL);
            com.baidu.tbadk.editortools.p eA = this.EM.eA(23);
            com.baidu.tbadk.editortools.p eA2 = this.EM.eA(2);
            com.baidu.tbadk.editortools.p eA3 = this.EM.eA(5);
            if (eA2 != null) {
                eA2.lz();
            }
            if (eA3 != null) {
                eA3.lz();
            }
            if (eA != null) {
                eA.hide();
            }
            this.EM.invalidate();
        }
    }

    public boolean aLE() {
        return this.ega;
    }

    public void gJ(boolean z) {
        if (this.efV != null && this.efW != null && this.efX != null) {
            this.efW.setText(r.j.draft_to_send);
            this.efX.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.efV.startAnimation(alphaAnimation);
            }
            this.efV.setVisibility(0);
        }
    }

    public void gK(boolean z) {
        if (this.efV != null && this.efW != null && this.efX != null) {
            this.efW.setText(r.j.reply_floor_host);
            this.efX.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.efV.startAnimation(alphaAnimation);
            }
            this.efV.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.q aLF() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aMc == null) {
            return null;
        }
        int firstVisiblePosition = this.aMc.getFirstVisiblePosition();
        int lastVisiblePosition = this.aMc.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aMc.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aMc.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aMc.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.efp.nA(headerViewsCount) != null && this.efp.nA(headerViewsCount) != com.baidu.tieba.tbadkCore.data.q.fgw) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.q) this.efp.aK(i2);
    }

    public er(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.dYB = null;
        this.dKv = null;
        this.bst = null;
        this.aMc = null;
        this.eeL = null;
        this.eeP = null;
        this.eeT = null;
        this.eeV = null;
        this.eeW = null;
        this.eeX = null;
        this.eeY = null;
        this.eeZ = null;
        this.efa = null;
        this.efb = null;
        this.efc = null;
        this.efg = null;
        this.efl = null;
        this.efm = null;
        this.efp = null;
        this.efu = null;
        this.aAM = null;
        this.bzZ = null;
        this.dXG = null;
        this.efV = null;
        this.efW = null;
        this.efY = null;
        this.efZ = null;
        this.ege = null;
        this.egf = null;
        this.egg = null;
        this.dYB = pbActivity;
        this.bzZ = onClickListener;
        this.dXp = dVar;
        this.dKv = (RelativeLayout) LayoutInflater.from(this.dYB.getPageContext().getPageActivity()).inflate(r.h.new_pb_activity, (ViewGroup) null);
        this.dYB.addContentView(this.dKv, new FrameLayout.LayoutParams(-1, -1));
        this.bst = this.dYB.findViewById(r.g.statebar_view);
        this.efo = (ObservedChangeLinearLayout) this.dYB.findViewById(r.g.title_wrapper);
        this.bpG = (NoNetworkView) this.dYB.findViewById(r.g.view_no_network);
        this.aMc = (BdTypeListView) this.dYB.findViewById(r.g.new_pb_list);
        this.aqN = new TextView(this.dYB.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.dYB.getActivity(), r.e.ds98));
        this.aMc.f(this.aqN, 0);
        View view = new View(this.dYB.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.dYB.getResources().getDimensionPixelSize(r.e.ds100)));
        view.setVisibility(4);
        this.aMc.addFooterView(view);
        this.aMc.setOnTouchListener(this.dYB.aJN);
        this.eeG = new com.baidu.tieba.pb.pb.main.view.g(pbActivity);
        this.egu = new com.baidu.tieba.pb.pb.main.a.f(pbActivity.getPageContext(), this.eeG.ehK);
        this.eeS = new db(this.dYB, this.dKv);
        this.eeS.init();
        this.eeS.a(this.eeS.aKh(), this.bzZ);
        if (this.dYB.aJu()) {
            this.eeI = (ViewStub) this.dYB.findViewById(r.g.manga_view_stub);
            this.eeI.setVisibility(0);
            this.eeH = new com.baidu.tieba.pb.pb.main.view.e(pbActivity);
            this.eeH.show();
            this.eeG.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.aqN.setLayoutParams(layoutParams);
        this.eeG.aME().setOnTouchListener(new com.baidu.tieba.pb.a.a(new fv(this)));
        this.efV = this.dYB.findViewById(r.g.pb_editor_tool_comment);
        this.efW = (TextView) this.dYB.findViewById(r.g.pb_editor_tool_comment_reply_text);
        this.efY = (ViewGroup) this.dYB.findViewById(r.g.pb_editor_tool_comment_reply_layout);
        this.efZ = (TextView) this.dYB.findViewById(r.g.pb_editor_tool_comment_praise_icon);
        boolean ak = com.baidu.tieba.graffiti.d.ak(this.efZ);
        if (ak) {
            iI(ak);
            this.efZ.setVisibility(0);
        }
        this.efX = (TextView) this.dYB.findViewById(r.g.pb_editor_tool_comment_reply_count_text);
        this.efY.setOnClickListener(new fw(this));
        this.efZ.setOnClickListener(this.bzZ);
        this.efZ.setOnTouchListener(this.dYB);
        this.eeL = LayoutInflater.from(this.dYB.getPageContext().getPageActivity()).inflate(r.h.new_pb_header_item, (ViewGroup) null);
        this.eeP = (LinearLayout) LayoutInflater.from(this.dYB.getPageContext().getPageActivity()).inflate(r.h.new_pb_header_user_item, (ViewGroup) null);
        this.eeR = new g(this.dYB, this.eeP);
        this.eeR.init();
        this.eeR.a(this.eeR.aIW(), this.bzZ);
        this.eeT = (ColumnLayout) this.eeP.findViewById(r.g.pb_head_owner_root);
        this.egs = (FloatingLayout) this.eeP.findViewById(r.g.pb_head_owner_info_root);
        this.eeU = (ThreadSkinView) this.eeP.findViewById(r.g.pb_thread_skin);
        this.eeT.setOnLongClickListener(this.onLongClickListener);
        this.eeT.setOnTouchListener(this.dXp);
        this.eeT.setVisibility(8);
        this.eeL.setOnTouchListener(this.dXp);
        this.ege = this.eeL.findViewById(r.g.pb_head_activity_join_number_container);
        this.ege.setVisibility(8);
        this.egf = (TextView) this.eeL.findViewById(r.g.pb_head_activity_join_number);
        this.eeV = (TextView) this.eeT.findViewById(r.g.pb_head_owner_info_user_name);
        this.eeW = (FrameLayout) this.eeT.findViewById(r.g.pb_head_headImage_container);
        this.eeY = (HeadImageView) this.eeT.findViewById(r.g.pb_head_owner_photo);
        this.eeX = (HeadPendantView) this.eeT.findViewById(r.g.pb_pendant_head_owner_photo);
        this.baW = (ViewStub) this.eeT.findViewById(r.g.viewstub_headimage_mask);
        this.eeX.vY();
        if (this.eeX.getHeadView() != null) {
            this.eeX.getHeadView().setIsRound(true);
            this.eeX.getHeadView().setDrawBorder(false);
        }
        if (this.eeX.getPendantView() != null) {
            this.eeX.getPendantView().setIsRound(true);
            this.eeX.getPendantView().setDrawBorder(false);
        }
        this.eeZ = (ImageView) this.eeT.findViewById(r.g.pb_head_owner_info_user_rank);
        this.efa = (ImageView) this.eeT.findViewById(r.g.pb_head_owner_info_user_bawu);
        this.efb = (UserIconBox) this.eeT.findViewById(r.g.pb_head_owner_info_user_icon);
        this.efc = (UserIconBox) this.eeT.findViewById(r.g.pb_head_owner_info_tshow_icon);
        this.efg = (EntelechyUserLikeButton) this.eeT.findViewById(r.g.pb_like_button);
        this.efh = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext(), this.efg);
        this.egM = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.egN = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.efl = this.eeL.findViewById(r.g.new_pb_header_item_line_above_livepost);
        this.efm = this.eeL.findViewById(r.g.new_pb_header_item_line_below_livepost);
        this.eeL.setOnLongClickListener(new fx(this));
        this.egg = (ViewStub) this.dKv.findViewById(r.g.interview_status_stub);
        this.efp = new cj(this.dYB, this.aMc);
        this.efp.u(this.bzZ);
        this.efp.a(this.dXp);
        this.efp.setOnImageClickListener(this.aJq);
        this.dXG = new fy(this);
        this.efp.F(this.dXG);
        aLH();
        aLI();
        this.aMc.addHeaderView(this.eeN);
        this.aMc.addHeaderView(this.eeQ.getView());
        this.aMc.addHeaderView(this.eeP);
        this.aMc.addHeaderView(this.eeL);
        this.efu = new PbListView(this.dYB.getPageContext().getPageActivity());
        this.aAM = this.efu.getView().findViewById(r.g.pb_more_view);
        if (this.aAM != null) {
            this.aAM.setOnClickListener(this.bzZ);
            com.baidu.tbadk.core.util.ar.k(this.aAM, r.f.pb_foot_more_trans_selector);
        }
        this.efu.wi();
        this.efu.di(r.f.pb_foot_more_trans_selector);
        this.efu.dj(r.f.pb_foot_more_trans_selector);
        this.efw = this.dYB.findViewById(r.g.viewstub_progress);
        this.dYB.registerListener(this.egR);
        this.ebe = new com.baidu.tieba.pb.pb.main.view.c(this.dYB.getPageContext());
        this.egt = new cv(this.dYB.getPageContext(), this.ebe, this.dKv);
        this.ebe.a(new fz(this));
    }

    public void aLG() {
        if (this.aMc != null) {
            this.aMc.removeHeaderView(this.eeN);
            this.aMc.removeHeaderView(this.eeQ.getView());
            if (this.efp.aJO() != null) {
                this.efp.aJO().akY();
            }
            this.aMc.removeHeaderView(this.eeP);
            this.aMc.removeHeaderView(this.eeL);
        }
    }

    private void aLH() {
        if (this.eeN == null) {
            int e = com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds32);
            int e2 = com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds40);
            this.eeN = new LinearLayout(this.dYB.getPageContext().getPageActivity());
            this.eeN.setOrientation(1);
            this.eeN.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eeN.setPadding(0, e2, 0, e2);
            this.eeN.setGravity(17);
            this.eeO = new TextView(this.dYB.getPageContext().getPageActivity());
            this.eeO.setGravity(3);
            this.eeO.setMaxLines(2);
            this.eeO.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_link_tip_c));
            this.eeO.setPadding(e, 0, e, 0);
            com.baidu.tbadk.core.util.ar.j((View) this.eeO, r.d.cp_cont_b);
            this.eeO.setTextSize(0, e2);
            this.eeO.setVisibility(8);
            this.eeN.addView(this.eeO);
            this.eeN.setOnTouchListener(this.dXp);
            this.eeN.setOnLongClickListener(new ga(this));
        }
    }

    private void aLI() {
        if (this.eeQ == null && this.efp.aJO() != null) {
            this.eeQ = this.efp.aJO().a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLJ() {
        if (this.dYB.aJu()) {
            this.eeJ = (ViewStub) this.dYB.findViewById(r.g.manga_mention_controller_view_stub);
            this.eeJ.setVisibility(0);
            if (this.efi == null) {
                this.efi = (LinearLayout) this.dYB.findViewById(r.g.manga_controller_layout);
                com.baidu.tbadk.i.a.a(this.dYB.getPageContext(), this.efi);
            }
            if (this.efj == null) {
                this.efj = (TextView) this.efi.findViewById(r.g.manga_prev_btn);
            }
            if (this.efk == null) {
                this.efk = (TextView) this.efi.findViewById(r.g.manga_next_btn);
            }
            this.efj.setOnClickListener(this.bzZ);
            this.efk.setOnClickListener(this.bzZ);
        }
    }

    private void aLK() {
        if (this.dYB.aJu()) {
            if (this.dYB.aJx() == -1) {
                com.baidu.tbadk.core.util.ar.c(this.efj, r.d.cp_cont_e, 1);
            }
            if (this.dYB.aJy() == -1) {
                com.baidu.tbadk.core.util.ar.c(this.efk, r.d.cp_cont_e, 1);
            }
        }
    }

    public void aLL() {
        if (this.efi == null) {
            aLJ();
        }
        this.eeJ.setVisibility(8);
        if (this.egP != null && this.egQ != null) {
            this.egP.removeCallbacks(this.egQ);
        }
    }

    public void aLM() {
        if (this.egP != null) {
            if (this.egQ != null) {
                this.egP.removeCallbacks(this.egQ);
            }
            this.egQ = new et(this);
            this.egP.postDelayed(this.egQ, 2000L);
        }
    }

    public void iC(boolean z) {
        this.eeG.iC(z);
        if (z && this.egd) {
            this.efu.setText(this.dYB.getResources().getString(r.j.click_load_more));
            this.aMc.setNextPage(this.efu);
            this.eeF = 2;
        }
    }

    public void aLN() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.dKv.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.EM = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dKv.addView(this.EM, layoutParams);
        this.EM.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.EM.hide();
    }

    public void aLO() {
        if (this.dYB != null && this.EM != null) {
            this.EM.lz();
        }
    }

    public void oa(String str) {
        if (this.efX != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.efX.setText(this.dYB.getPageContext().getResources().getString(r.j.pb_reply_count_text, str));
        }
    }

    public void O(String str, boolean z) {
        this.egb = z;
        iD(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void iD(boolean z) {
        if (this.efZ != null) {
            if (this.egb) {
                com.baidu.tbadk.core.util.ar.k(this.efZ, r.f.pb_praise_already_click_selector);
                this.efZ.setContentDescription(this.dYB.getResources().getString(r.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.ar.k(this.efZ, r.f.pb_praise_normal_click_selector);
            this.efZ.setContentDescription(this.dYB.getResources().getString(r.j.frs_item_praise_text));
        }
    }

    public TextView aLP() {
        return this.efZ;
    }

    public void iE(boolean z) {
        if (this.aMc != null) {
            if (!z) {
                this.aMc.setEnabled(z);
                return;
            }
            if (this.egr == null) {
                this.egr = new eu(this, z);
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.egr, 10L);
        }
    }

    public void iF(boolean z) {
        if (this.aMc != null && this.aqN != null && this.bst != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bst.setVisibility(0);
                    this.aMc.removeHeaderView(this.aqN);
                    this.aMc.f(this.aqN, 0);
                } else {
                    this.bst.setVisibility(8);
                    this.aMc.removeHeaderView(this.aqN);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aqN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.aqN.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aqN.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + iN(true);
                this.aqN.setLayoutParams(layoutParams2);
            }
            this.aMc.removeHeaderView(this.aqN);
            this.aMc.f(this.aqN, 0);
            aMx();
        }
    }

    public void aV(View view) {
        boolean z;
        View view2;
        if (this.efo != null && view != null) {
            if (this.ega) {
                z = this.efV.getVisibility() == 0;
            } else {
                z = this.EM != null && this.EM.getVisibility() == 0;
            }
            boolean z2 = this.efo.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.egx = true;
                View findViewById = this.dYB.findViewById(r.g.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.efo.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.dYB, this.efo, r.a.top_fold_up, new ev(this, findViewById));
            } else {
                this.egx = false;
                com.baidu.tieba.tbadkCore.a.a(this.dYB, this.efo, r.a.top_fold_down, new ew(this));
            }
            if (this.ega) {
                view2 = this.efV;
            } else {
                view2 = this.EM;
            }
            if (z) {
                if (z2) {
                    if (this.EM != null) {
                        this.EM.AP();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.dYB, view2, r.a.bottom_fold_down, new ex(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.dYB, view2, r.a.bottom_fold_up, new ey(this));
            }
            aKg();
        }
    }

    public cj aLQ() {
        return this.efp;
    }

    public void a(PbActivity.c cVar) {
        this.dZT = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bl blVar) {
        if (blVar == null || blVar.sO() == 0) {
            if (this.efU != null) {
                this.efU.setVisibility(8);
            }
            if (this.efl != null) {
                this.efl.setVisibility(8);
                return;
            }
            return;
        }
        if (this.efU == null) {
            this.dYB.getLayoutMode().x(((ViewStub) this.eeL.findViewById(r.g.live_talk_layout)).inflate());
            this.efU = (Button) this.eeL.findViewById(r.g.pb_head_function_manage_go_to_live_post);
            this.efl = this.eeL.findViewById(r.g.new_pb_header_item_line_above_livepost);
        }
        int sP = blVar.sP();
        String string = this.dYB.getPageContext().getString(r.j.go_to_live_post_prefix);
        if (sP == 0) {
            string = String.valueOf(string) + this.dYB.getPageContext().getString(r.j.go_to_interview_post);
        } else if (sP == 1) {
            string = String.valueOf(string) + this.dYB.getPageContext().getString(r.j.go_to_discuss_post);
        }
        this.efU.setText(string);
        this.efU.setVisibility(0);
        this.efU.setOnClickListener(this.bzZ);
        this.egV = true;
        aMd();
    }

    public void aW(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.efy == null) {
            this.efy = LayoutInflater.from(this.dYB.getPageContext().getPageActivity()).inflate(r.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.dYB.getLayoutMode().x(this.efy);
        if (this.efx == null) {
            this.efx = new Dialog(this.dYB.getPageContext().getPageActivity(), r.k.common_alert_dialog);
            this.efx.setCanceledOnTouchOutside(true);
            this.efx.setCancelable(true);
            this.efx.setContentView(this.efy);
            WindowManager.LayoutParams attributes = this.efx.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.I(this.dYB.getPageContext().getPageActivity()) * 0.9d);
            this.efx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.efx.findViewById(r.g.del_post_btn);
        TextView textView2 = (TextView) this.efx.findViewById(r.g.forbid_user_btn);
        TextView textView3 = (TextView) this.efx.findViewById(r.g.disable_reply_btn);
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
            textView.setOnClickListener(new ez(this));
        }
        if ("".equals(sparseArray.get(r.g.tag_forbid_user_name)) || aMt()) {
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
            textView2.setOnClickListener(new fa(this));
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
            textView3.setOnClickListener(new fb(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.efx, this.dYB.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.egS = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.g.tag_del_post_id, str);
        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(egl, Integer.valueOf(egm));
        int i3 = r.j.del_post_confirm;
        if (i == 0) {
            i3 = r.j.del_thread_confirm;
        }
        this.efz = new com.baidu.tbadk.core.dialog.a(this.dYB.getActivity());
        this.efz.cb(i3);
        this.efz.A(sparseArray);
        this.efz.a(r.j.dialog_ok, this.dYB);
        this.efz.b(r.j.dialog_cancel, new fd(this));
        this.efz.au(true);
        this.efz.b(this.dYB.getPageContext());
        this.efz.tb();
    }

    public void ag(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.efK == null) {
            this.efK = LayoutInflater.from(this.dYB.getPageContext().getPageActivity()).inflate(r.h.commit_good, (ViewGroup) null);
        }
        this.dYB.getLayoutMode().x(this.efK);
        if (this.efJ == null) {
            this.efJ = new Dialog(this.dYB.getPageContext().getPageActivity(), r.k.common_alert_dialog);
            this.efJ.setCanceledOnTouchOutside(true);
            this.efJ.setCancelable(true);
            this.efT = (ScrollView) this.efK.findViewById(r.g.good_scroll);
            this.efJ.setContentView(this.efK);
            WindowManager.LayoutParams attributes = this.efJ.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds540);
            this.efJ.getWindow().setAttributes(attributes);
            this.efM = new fe(this);
            this.efL = (LinearLayout) this.efK.findViewById(r.g.good_class_group);
            this.efO = (TextView) this.efK.findViewById(r.g.dialog_button_cancel);
            this.efO.setOnClickListener(new ff(this));
            this.efN = (TextView) this.efK.findViewById(r.g.dialog_button_ok);
            this.efN.setOnClickListener(this.bzZ);
        }
        this.efL.removeAllViews();
        this.eeK = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bM = bM("0", this.dYB.getPageContext().getString(r.j.def_good_class));
        this.eeK.add(bM);
        bM.setChecked(true);
        this.efL.addView(bM);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bM2 = bM(String.valueOf(arrayList.get(i2).qd()), arrayList.get(i2).qc());
                this.eeK.add(bM2);
                View view = new View(this.dYB.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds1));
                com.baidu.tbadk.core.util.ar.l(view, r.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.efL.addView(view);
                this.efL.addView(bM2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.efT.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dYB.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dYB.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dYB.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.efT.setLayoutParams(layoutParams2);
            this.efT.removeAllViews();
            this.efT.addView(this.efL);
        }
        com.baidu.adp.lib.h.j.a(this.efJ, this.dYB.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bM(String str, String str2) {
        Activity pageActivity = this.dYB.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds100));
        aVar.setOnCheckedChangeListener(this.efM);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aLR() {
        this.dYB.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.dYB.hideProgressBar();
        if (z && z2) {
            this.dYB.showToast(this.dYB.getPageContext().getString(r.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.av.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(r.j.neterror);
            }
            this.dYB.showToast(str);
        }
    }

    public void aqY() {
        this.efw.setVisibility(0);
    }

    public void aqX() {
        this.efw.setVisibility(8);
    }

    public View aLS() {
        if (this.efK != null) {
            return this.efK.findViewById(r.g.dialog_button_ok);
        }
        return null;
    }

    public String aLT() {
        return this.efP;
    }

    public View getView() {
        return this.dKv;
    }

    public void aLU() {
        com.baidu.adp.lib.util.k.b(this.dYB.getPageContext().getPageActivity(), this.dYB.getCurrentFocus());
    }

    public void iG(boolean z) {
        this.dYB.hideProgressBar();
        awl();
    }

    public void aLV() {
        this.efu.wp();
    }

    public void aLW() {
        this.dYB.hideProgressBar();
        this.efu.wq();
        aHa();
        this.aMc.l(2000L);
        aMd();
    }

    public void aLX() {
        this.aMc.l(2000L);
        aMd();
    }

    public void iH(boolean z) {
        this.eeS.f(this.eeS.aKh(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.efY.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.dYB.getResources().getDimensionPixelSize(r.e.ds84) : 0;
        this.efY.setLayoutParams(marginLayoutParams);
    }

    private void iI(boolean z) {
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.efY.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.efY.setLayoutParams(layoutParams);
    }

    public void c(com.baidu.tbadk.core.data.ae aeVar) {
        this.eeS.c(aeVar);
    }

    public boolean aKe() {
        return this.eeS.aKe();
    }

    public void aKf() {
        this.eeS.aKf();
    }

    public void aKg() {
        this.eeS.aKg();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.efp.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.efQ != null) {
            this.efQ.dismiss();
            this.efQ = null;
        }
        this.efQ = new com.baidu.tbadk.core.dialog.c(this.dYB.getPageContext().getPageActivity());
        this.efQ.ce(r.j.operation);
        if (z2) {
            this.efQ.a(new String[]{this.dYB.getPageContext().getString(r.j.copy)}, bVar);
        } else if (!z) {
            this.efQ.a(new String[]{this.dYB.getPageContext().getString(r.j.copy), this.dYB.getPageContext().getString(r.j.mark)}, bVar);
        } else {
            this.efQ.a(new String[]{this.dYB.getPageContext().getString(r.j.copy), this.dYB.getPageContext().getString(r.j.remove_mark)}, bVar);
        }
        this.efQ.d(this.dYB.getPageContext());
        this.efQ.te();
    }

    public int aLY() {
        return nP(this.aMc.getFirstVisiblePosition());
    }

    private int nP(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aMc.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.kq()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.aMc.getAdapter() == null || !(this.aMc.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aMc.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aLZ() {
        return nP(this.aMc.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.aMc.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.efs.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        this.efp.b(fVar);
        this.efp.notifyDataSetChanged();
        if (fVar == null) {
            oa("");
        } else {
            oa(com.baidu.tbadk.core.util.av.y(fVar.aIl().rx()));
        }
        aMd();
    }

    public void k(com.baidu.tieba.pb.data.f fVar) {
        PraiseData rv;
        if (this.eff == null) {
            this.dYB.getLayoutMode().x(((ViewStub) this.eeL.findViewById(r.g.praise_layout)).inflate());
            this.eff = (FrsPraiseView) this.eeL.findViewById(r.g.pb_head_praise_view);
            this.eff.setIsFromPb(true);
            this.efn = this.eeL.findViewById(r.g.new_pb_header_item_line_above_praise);
            this.eff.m24do(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.eff != null) {
            boolean aMd = aMd();
            if (fVar != null && fVar.aIm() != null && fVar.aIm().size() > 0) {
                com.baidu.tieba.tbadkCore.data.q qVar = fVar.aIm().get(0);
                if ((!this.dXC || qVar.bga() != 1) && (rv = fVar.aIl().rv()) != null && rv.getUser() != null && rv.getUser().size() > 0) {
                    this.eff.setVisibility(0);
                    this.eff.setIsFromPb(true);
                    this.eff.a(rv, fVar.aIl().getId(), rv.getPostId(), true);
                    this.eff.getVisibility();
                    com.baidu.tieba.graffiti.d.ak(this.eff);
                    return;
                }
            }
            this.eff.setVisibility(8);
            if (fVar != null && fVar.getPage() != null && fVar.getPage().qF() == 0 && this.dXC) {
                if (aMd) {
                    this.efm.setVisibility(0);
                } else {
                    this.efm.setVisibility(8);
                }
            } else {
                this.efm.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(this.efm);
        }
    }

    private com.baidu.tieba.tbadkCore.data.q a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aIt() != null) {
            return fVar.aIt();
        }
        if (z) {
            if (fVar == null || fVar.aIm() == null || fVar.aIm().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.q qVar = fVar.aIm().get(0);
            if (qVar.bga() != 1) {
                qVar = a(fVar);
            }
            if (qVar.getAuthor() != null && qVar.getAuthor().getUserTbVipInfoData() != null && qVar.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                qVar.getAuthor().getGodUserData().setIntro(qVar.getAuthor().getUserTbVipInfoData().getvipIntro());
                return qVar;
            }
            return qVar;
        }
        return a(fVar);
    }

    private com.baidu.tieba.tbadkCore.data.q a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aIl() == null || fVar.aIl().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
        MetaData author = fVar.aIl().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aIl().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        qVar.ri(1);
        qVar.setId(fVar.aIl().rV());
        qVar.setTitle(fVar.aIl().getTitle());
        qVar.setTime(fVar.aIl().getCreateTime());
        qVar.setAuthor(metaData);
        return qVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v217, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        int i2;
        if (fVar != null && fVar.aIl() != null) {
            this.egs.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds30), 0, 0);
            com.baidu.tieba.tbadkCore.data.q a2 = a(fVar, z);
            if (a2 != null && a2.rZ() != null) {
                String str = null;
                if (this.dYB.aJE()) {
                    str = "FRS";
                }
                this.eeU.a(this.dYB.getPageContext(), fVar.aIm().get(0).rZ(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", fVar.aIk().getId(), fVar.aIk().getName(), fVar.aIl().getId(), str));
                this.eeT.setPadding(this.eeT.getPaddingLeft(), (int) this.dYB.getResources().getDimension(r.e.ds20), this.eeT.getPaddingRight(), this.eeT.getPaddingBottom());
            } else {
                this.eeU.a(null, null, null);
            }
            aMu();
            this.eeT.setVisibility(8);
            if (this.eeQ != null) {
                this.aMc.removeHeaderView(this.eeQ.getView());
                if (this.efp.aJO() != null) {
                    this.efp.aJO().akY();
                }
            }
            if (fVar.aIl() != null && fVar.aIl().sq() && fVar.aIt() != null && this.efp.aJO() != null && this.eeQ != null) {
                this.aMc.f(this.eeQ.getView(), 1);
                this.eeQ.getView().setVisibility(0);
                this.efp.aJO().b(fVar);
                this.efp.aJO().a(0, this.eeQ.getView(), (ViewGroup) this.aMc, fVar.aIt(), this.eeQ);
            } else if (this.eeQ != null) {
                this.eeQ.getView().setVisibility(8);
            }
            if (a2 != null) {
                String str2 = null;
                boolean z2 = false;
                if (fVar != null && fVar.aIl() != null && fVar.aIl().getAuthor() != null) {
                    str2 = fVar.aIl().getAuthor().getUserId();
                    if (fVar.getPage() != null) {
                        this.egB = fVar.getPage().qB();
                        z2 = fVar.getPage().qE() == 1;
                    }
                }
                boolean sp = fVar.aIl().sp();
                if (a2.getAuthor() != null && a2.getAuthor().getUserTbVipInfoData() != null) {
                    this.adS = !StringUtils.isNull(a2.getAuthor().getUserTbVipInfoData().getvipV_url());
                }
                this.egw = !sp && a(a2, fVar.aIl().getId(), str2, z2, z);
                this.eeT.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eeT.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eeT.setTag(sparseArray);
                }
                sparseArray.put(r.g.tag_clip_board, a2);
                sparseArray.put(r.g.tag_is_subpb, false);
                fVar.aIl().sm();
                if (!this.egK) {
                    this.eeN.setVisibility(0);
                }
                if (!fVar.aIl().sq() && this.eeO.getText() != null && this.eeO.getText().length() > 0) {
                    this.eeO.setVisibility(0);
                } else {
                    this.eeO.setVisibility(8);
                }
                k(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rQ = fVar.aIl().rQ();
                if (rQ != null && rQ.size() > 0 && !this.egK) {
                    this.egf.setText(String.valueOf(rQ.get(0).pd()));
                    this.ege.setVisibility(0);
                    this.egU = true;
                } else {
                    this.ege.setVisibility(8);
                }
                com.baidu.tbadk.core.util.ar.k(this.ege, r.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.ar.c(this.egf, r.d.cp_link_tip_d, 1);
                if (a2.getAuthor() != null) {
                    int level_id = a2.getAuthor().getLevel_id();
                    int is_bawu = a2.getAuthor().getIs_bawu();
                    String bawu_type = a2.getAuthor().getBawu_type();
                    int i3 = 3;
                    if (level_id != 0) {
                        this.eeZ.setVisibility(0);
                        com.baidu.tbadk.core.util.ar.c(this.eeZ, BitmapHelper.getGradeResourceIdNew(level_id));
                        this.eeZ.setAlpha(179);
                        this.eeZ.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                        this.eeZ.setOnClickListener(null);
                    } else {
                        this.eeZ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.efa.setAlpha(179);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.ar.c(this.efa, r.f.pb_manager);
                            this.eeZ.setVisibility(8);
                            this.efa.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.ar.c(this.efa, r.f.pb_assist);
                            this.eeZ.setVisibility(8);
                            this.efa.setVisibility(0);
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
                    if (this.efb != null) {
                        this.efb.setTag(r.g.tag_user_id, a2.getAuthor().getUserId());
                        this.efb.setOnClickListener(this.dYB.dZl.bJq);
                        this.efb.wD();
                        this.efb.a(iconInfo, i3, this.dYB.getResources().getDimensionPixelSize(r.e.ds30), this.dYB.getResources().getDimensionPixelSize(r.e.ds30), this.dYB.getResources().getDimensionPixelSize(r.e.ds10));
                    }
                    if (this.efc != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.efc.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.efc.setOnClickListener(this.dYB.dZl.ehq);
                        this.efc.a(tShowInfoNew, 3, this.dYB.getResources().getDimensionPixelSize(r.e.ds32), this.dYB.getResources().getDimensionPixelSize(r.e.ds32), this.dYB.getResources().getDimensionPixelSize(r.e.ds8), true);
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aR(string) > 12) {
                            string = com.baidu.tbadk.core.util.av.d(string, 12, "...");
                        }
                    } else if (com.baidu.adp.lib.util.j.aR(string) > 14) {
                        string = com.baidu.tbadk.core.util.av.d(string, 14, "...");
                    }
                    this.eeV.setText(ag(a2.getAuthor().getSealPrefix(), string));
                    this.eeV.setTag(r.g.tag_user_id, a2.getAuthor().getUserId());
                    this.eeV.setTag(r.g.tag_user_name, a2.getAuthor().getName_show());
                    if (!com.baidu.tbadk.core.util.x.t(tShowInfoNew)) {
                        com.baidu.tbadk.core.util.ar.c(this.eeV, r.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ar.c(this.eeV, r.d.cp_cont_f, 1);
                    }
                    this.eeY.setUserId(a2.getAuthor().getUserId());
                    this.eeY.setUserName(a2.getAuthor().getUserName());
                    this.eeY.setImageDrawable(null);
                    this.eeY.setRadius(com.baidu.adp.lib.util.k.e(this.dYB.getActivity(), r.e.ds40));
                    this.eeY.setTag(a2.getAuthor().getUserId());
                    this.efh.a(a2.getAuthor());
                    if (!PbNormalLikeButtonSwitchStatic.Gj() || this.efS || (a2.getAuthor().hadConcerned() && a2.getAuthor().getGodUserData() != null && a2.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.efg.setVisibility(8);
                    } else {
                        this.efg.setVisibility(0);
                    }
                    String portrait = a2.getAuthor().getPortrait();
                    if (a2.getAuthor() != null && a2.getAuthor().getPendantData() != null && !StringUtils.isNull(a2.getAuthor().getPendantData().pS())) {
                        this.eeY.setVisibility(8);
                        this.eeX.setVisibility(0);
                        if (this.edv != null) {
                            this.edv.setVisibility(8);
                        }
                        this.eeV.setOnClickListener(this.dYB.dZl.ehp);
                        this.eeV.setOnClickListener(this.dYB.dZl.ehp);
                        this.eeX.getHeadView().c(portrait, 28, false);
                        this.eeX.getHeadView().setUserId(a2.getAuthor().getUserId());
                        this.eeX.getHeadView().setUserName(a2.getAuthor().getUserName());
                        this.eeX.getHeadView().setOnClickListener(this.dYB.dZl.ehp);
                        this.eeX.dW(a2.getAuthor().getPendantData().pS());
                    } else if (this.adS) {
                        this.eeY.setVisibility(0);
                        UserTbVipInfoData userTbVipInfoData = a2.getAuthor().getUserTbVipInfoData();
                        if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null && this.baW != null) {
                            if (this.baX == null) {
                                this.baW.inflate();
                                this.baX = (TbImageView) this.eeP.findViewById(r.g.user_head_mask);
                            }
                            this.baX.c(userTbVipInfoData.getvipV_url(), 10, false);
                        }
                        this.eeV.setOnClickListener(this.dYB.dZl.ehp);
                        this.eeY.setOnClickListener(this.dYB.dZl.ehp);
                        this.eeX.setVisibility(8);
                    } else {
                        if (this.egw) {
                            fg fgVar = new fg(this, a2);
                            this.eeV.setOnClickListener(fgVar);
                            this.eeY.setOnClickListener(fgVar);
                            this.eeT.setOnClickListener(fgVar);
                            this.eeY.setVisibility(8);
                            this.eeX.setVisibility(8);
                        } else {
                            this.eeY.setVisibility(0);
                            this.eeT.setOnClickListener(this.dYB.dZl.ehp);
                            this.eeV.setOnClickListener(this.dYB.dZl.ehp);
                            this.eeY.setOnClickListener(this.dYB.dZl.ehp);
                        }
                        this.eeX.setVisibility(8);
                    }
                    this.eeY.c(portrait, 28, false);
                }
                if (fVar != null) {
                    this.eeR.A(fVar.aIl());
                }
            }
        }
    }

    public boolean aMa() {
        return this.egW;
    }

    private boolean aMb() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean y(com.baidu.tbadk.core.data.bg bgVar) {
        if (bgVar == null || bgVar.getAuthor() == null || bgVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.eeG.aMI();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eeG.lu(eVar.forumName);
            }
            String string = this.dYB.getResources().getString(r.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.h.b.g(eVar.source, 0)) {
                case 100:
                    str = this.dYB.getResources().getString(r.j.self);
                    break;
                case 300:
                    str = this.dYB.getResources().getString(r.j.bawu);
                    break;
                case 400:
                    str = this.dYB.getResources().getString(r.j.system);
                    break;
            }
            this.dYB.showNetRefreshView(this.dKv, String.format(string, str), null, this.dYB.getResources().getString(r.j.appeal_restore), true, new fh(this, eVar.dWv));
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aLv;
        String sb;
        if (fVar != null) {
            if (fVar.aIl() != null) {
                this.egi = fVar.aIl().rt();
                this.Us = fVar.aIl().rq();
                if (fVar.aIl().getAnchorLevel() != 0) {
                    this.egW = true;
                }
                this.efS = y(fVar.aIl());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            n(fVar);
            this.egd = false;
            this.dXC = z;
            aLW();
            b(fVar, z, i);
            if (this.dYB.aJu()) {
                if (this.eft == null) {
                    this.eft = new com.baidu.tieba.pb.view.m(this.dYB.getPageContext());
                    this.eft.kk();
                    this.eft.a(this.agw);
                }
                this.aMc.setPullRefresh(this.eft);
                this.aMc.removeHeaderView(this.aqN);
                this.aMc.f(this.aqN, 0);
                if (this.eft != null) {
                    this.eft.dk(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (fVar.getPage().qF() == 0 && z) {
                this.aMc.setPullRefresh(null);
                this.eeE = 1;
            } else {
                if (this.eft == null) {
                    this.eft = new com.baidu.tieba.pb.view.m(this.dYB.getPageContext());
                    this.eft.kk();
                    this.eft.a(this.agw);
                }
                this.aMc.setPullRefresh(this.eft);
                this.aMc.removeHeaderView(this.aqN);
                this.aMc.f(this.aqN, 0);
                this.eeE = 2;
                if (this.eft != null) {
                    this.eft.dk(TbadkCoreApplication.m9getInst().getSkinType());
                }
                aHa();
            }
            aMd();
            this.efp.hY(this.dXC);
            this.efp.hZ(false);
            this.efp.b(fVar);
            this.efp.notifyDataSetChanged();
            if (fVar.aIk() != null) {
                this.mForumName = fVar.aIk().getName();
                this.mForumId = fVar.getForumId();
            }
            this.eeG.lu(this.mForumName);
            if (fVar.aIl() != null) {
                oa(com.baidu.tbadk.core.util.av.y(fVar.aIl().rx()));
                if (fVar.aIl().rv() != null) {
                    if (fVar.aIl().rv().getNum() < 1) {
                        sb = this.dYB.getResources().getString(r.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(fVar.aIl().rv().getNum())).toString();
                    }
                    if (this.eeD != -1) {
                        fVar.aIl().rv().setIsLike(this.eeD);
                    }
                    O(sb, fVar.aIl().rv().getIsLike() == 1);
                }
            }
            if (fVar.getPage().qE() == 0 && !z) {
                this.aMc.setNextPage(null);
                this.eeF = 1;
            } else if (this.dYB.isLogin()) {
                this.aMc.setNextPage(this.efu);
                this.eeF = 2;
                aHa();
            } else if (fVar.getPage().qE() == 1) {
                this.egd = true;
                if (this.efv == null) {
                    this.efv = new com.baidu.tieba.pb.view.b(this.dYB.getPageContext());
                }
                this.aMc.setNextPage(this.efv);
                this.eeF = 3;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = fVar.aIm();
            if (fVar.getPage().qE() == 0 || aIm == null || aIm.size() < fVar.getPage().qD()) {
                this.efu.setText(this.dYB.getResources().getString(r.j.list_no_more));
                if (this.dYB.aJu() && this.aMc != null && this.aMc.getData() != null && this.aMc.getData().size() == 1 && (this.aMc.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.efu.setText("");
                }
                aMi();
            } else if (z2) {
                if (this.egT) {
                    wq();
                    if (fVar.getPage().qE() != 0) {
                        this.efu.setText(this.dYB.getResources().getString(r.j.pb_load_more));
                    }
                } else {
                    this.efu.ws();
                }
            } else {
                this.efu.ws();
            }
            if (fVar.aIl() != null && fVar.aIl().getAuthor() != null && fVar.aIl().getAuthor().getType() == 0) {
                this.eeG.aMF();
            }
            switch (i) {
                case 2:
                    this.aMc.setSelection(i2 > 1 ? i2 - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aLv = ej.aLu().aLv()) != null) {
                        this.egO = true;
                        this.aMc.onRestoreInstanceState(aLv);
                        break;
                    } else {
                        this.aMc.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.egT = false;
                    this.aMc.setSelection(0);
                    break;
                case 5:
                    this.aMc.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aLv2 = ej.aLu().aLv();
                        this.egO = true;
                        if (aLv2 != null) {
                            this.aMc.onRestoreInstanceState(aLv2);
                            break;
                        }
                    }
                    this.aMc.setSelection(0);
                    break;
            }
            if (this.egi == egk && aMb()) {
                aMo();
            }
            l(fVar);
            if (!this.egO && fVar.aIt() == null && !fVar.aIl().sq()) {
                this.egu.iz(this.dYB.getResources().getString(r.j.pb_more_tools_guide_tip));
                this.egO = true;
            }
        }
    }

    private void l(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aIl() != null && fVar.aIl().sq() && this.eeQ != null && this.eeQ.getView() != null && this.eeQ.getView().getVisibility() == 0) {
            int i = com.baidu.tbadk.core.sharedPref.b.tW().getInt(com.baidu.tbadk.core.sharedPref.b.cR("pb_video_immersive_guide_count_"), 0);
            if (this.dYB.aJa() != null) {
                this.dYB.aJa().dd(true);
                this.dYB.aJa().iP(true);
            }
            if (i < 3) {
                this.mHandler.postDelayed(new fi(this, i), 600L);
            } else {
                this.mHandler.post(new fj(this));
            }
        }
    }

    public boolean aMc() {
        return (this.eeQ == null || this.eeQ.getView() == null || this.eeQ.getView().getParent() == null || this.eeQ.getView().getTop() != 0) ? false : true;
    }

    public void iJ(boolean z) {
        this.efR = z;
        this.eeG.iJ(z);
    }

    public void wq() {
        if (this.efu != null) {
            this.efu.wq();
        }
        aHa();
    }

    public void JF() {
        this.aMc.setVisibility(0);
    }

    private boolean aMd() {
        boolean z;
        if (this.efU != null && this.efU.getVisibility() == 0) {
            z = true;
            if (this.efl != null) {
                this.efl.setVisibility(0);
            }
        } else {
            if (this.efl != null) {
                this.efl.setVisibility(8);
            }
            z = false;
        }
        if ((this.efn == null || this.efn.getVisibility() == 8) && z && this.dXC) {
            this.efm.setVisibility(0);
        } else {
            this.efm.setVisibility(8);
        }
        com.baidu.tieba.graffiti.d.ak(this.efm);
        return z;
    }

    private boolean m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aIl() == null) {
            return false;
        }
        if (fVar.aIl().rC() == 1 || fVar.aIl().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aIl().rE() == null || fVar.aIl().rE().sO() == 0) || fVar.aIl().rA() == 1 || fVar.aIl().rB() == 1 || fVar.aIl().si() || fVar.aIl().sv() || fVar.aIl().sp() || fVar.aIl().rR() != null || fVar.aIl().sw() || fVar.aIl().sw() || !com.baidu.tbadk.core.util.av.isEmpty(fVar.aIl().rw()) || fVar.aIl().rH();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str));
            return com.baidu.tieba.card.ap.a((Context) this.dYB.getActivity(), str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null) {
            if (this.eeN != null) {
                if (fVar.aIl() != null && fVar.aIl().rU() == 0 && !fVar.aIl().sq() && !this.egK) {
                    this.eeN.setVisibility(0);
                    fVar.aIl().sm();
                    if (fVar.aIl() != null) {
                        fVar.aIl().e(true, m(fVar));
                    }
                    SpannableStringBuilder sd = fVar.aIl().sd();
                    this.eeO.setOnTouchListener(new com.baidu.tieba.view.x(sd));
                    if (sd == null || sd.length() == 0) {
                        this.eeO.setVisibility(8);
                    } else {
                        this.eeO.setText(sd);
                        this.eeO.setVisibility(0);
                    }
                    this.eeT.setPadding(this.eeT.getPaddingLeft(), this.eeT.getPaddingTop(), com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds32), this.eeT.getPaddingBottom());
                } else {
                    this.eeN.setVisibility(8);
                    this.aMc.removeHeaderView(this.eeN);
                    if (fVar.aIl() != null && fVar.aIl().sq()) {
                        this.eeT.setPadding(this.eeT.getPaddingLeft(), 0, this.eeT.getPaddingRight(), this.eeT.getPaddingBottom());
                    } else {
                        this.eeT.setPadding(this.eeT.getPaddingLeft(), com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds48), this.eeT.getPaddingRight(), this.eeT.getPaddingBottom());
                    }
                }
            }
            this.dXC = z;
            com.baidu.tbadk.core.data.bg aIl = fVar.aIl();
            if (aIl != null) {
                a(aIl.rE());
            }
        }
        return false;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2, int i) {
        if (fVar != null) {
            a(fVar, z, z2);
            aMd();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.q a2;
        if (fVar == null || (a2 = a(fVar, z)) == null) {
            return null;
        }
        String userId = a2.getAuthor().getUserId();
        boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 0) {
            sparseArray.put(r.g.tag_del_post_id, a2.getId());
            sparseArray.put(r.g.tag_del_post_type, 0);
            sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(fVar.aIu()));
            sparseArray.put(r.g.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (a2.getAuthor() != null) {
                sparseArray.put(r.g.tag_forbid_user_name, a2.getAuthor().getUserName());
                sparseArray.put(r.g.tag_forbid_user_post_id, a2.getId());
            }
            sparseArray.put(r.g.tag_del_post_id, a2.getId());
            sparseArray.put(r.g.tag_del_post_type, 0);
            sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(fVar.aIu()));
            sparseArray.put(r.g.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aAM;
    }

    public void ob(String str) {
        if (this.efu != null && !StringUtils.isNull(str)) {
            this.efu.setText(str);
        }
    }

    public BdListView Pv() {
        return this.aMc;
    }

    public int aMe() {
        return r.g.richText;
    }

    public TextView aIW() {
        return this.eeR.aIW();
    }

    public void c(BdListView.e eVar) {
        this.aMc.setOnSrollToBottomListener(eVar);
    }

    public void a(z.b bVar) {
        this.agw = bVar;
        if (this.eft != null) {
            this.eft.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int qC = anVar.qC();
            int qz = anVar.qz();
            if (this.efq != null) {
                this.efq.tb();
            } else {
                this.efq = new com.baidu.tbadk.core.dialog.a(this.dYB.getPageContext().getPageActivity());
                this.efr = LayoutInflater.from(this.dYB.getPageContext().getPageActivity()).inflate(r.h.dialog_direct_pager, (ViewGroup) null);
                this.efq.z(this.efr);
                this.efq.a(r.j.dialog_ok, bVar);
                this.efq.b(r.j.dialog_cancel, new fk(this));
                this.efq.a(new fm(this));
                this.efq.b(this.dYB.getPageContext()).tb();
            }
            this.efs = (EditText) this.efr.findViewById(r.g.input_page_number);
            this.efs.setText("");
            TextView textView = (TextView) this.efr.findViewById(r.g.current_page_number);
            if (qC <= 0) {
                qC = 1;
            }
            if (qz <= 0) {
                qz = 1;
            }
            textView.setText(MessageFormat.format(this.dYB.getApplicationContext().getResources().getString(r.j.current_page), Integer.valueOf(qC), Integer.valueOf(qz)));
            this.dYB.ShowSoftKeyPadDelay(this.efs, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aMc.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.dYB.showToast(str);
    }

    public boolean iK(boolean z) {
        if (this.EM == null || !this.EM.CE()) {
            return false;
        }
        this.EM.AP();
        return true;
    }

    public void aMf() {
        if (this.egX != null) {
            while (this.egX.size() > 0) {
                TbImageView remove = this.egX.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aMf();
        this.efp.nB(1);
    }

    public void onResume() {
        this.efp.nB(2);
    }

    public void onDestroy() {
        this.egu.VY();
        this.dYB.hideProgressBar();
        if (this.bpG != null && this.aSE != null) {
            this.bpG.b(this.aSE);
        }
        awl();
        this.efu.wq();
        if (this.egq != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.egq);
        }
        if (this.egr != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.egr);
        }
        aMl();
        if (this.egJ != null) {
            this.egJ.removeAllViews();
        }
        if (this.eeT != null && this.edv != null) {
            this.eeT.removeView(this.eeW);
            this.edv = null;
        }
        if (this.egh != null) {
            this.egh.clearStatus();
        }
        this.egP = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.efp.nB(3);
        if (this.bst != null) {
            this.bst.setBackgroundDrawable(null);
        }
    }

    public void awl() {
        this.eeG.od();
        this.egu.VY();
        com.baidu.adp.lib.util.k.b(this.dYB.getPageContext().getPageActivity(), this.efs);
        if (this.efQ != null) {
            this.efQ.dismiss();
        }
        aMg();
    }

    public void hX(boolean z) {
        this.efp.hX(z);
    }

    public void gH(boolean z) {
        this.dhg = z;
    }

    public void aMg() {
        if (this.efz != null) {
            this.efz.dismiss();
        }
        if (this.efA != null) {
            com.baidu.adp.lib.h.j.b(this.efA, this.dYB.getPageContext());
        }
        if (this.efJ != null) {
            com.baidu.adp.lib.h.j.b(this.efJ, this.dYB.getPageContext());
        }
        if (this.efx != null) {
            com.baidu.adp.lib.h.j.b(this.efx, this.dYB.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.dYB.getLayoutMode().ai(i == 1);
        this.dYB.getLayoutMode().x(this.dKv);
        this.dYB.getLayoutMode().x(this.eeO);
        this.dYB.getLayoutMode().x(this.eeP);
        this.dYB.getLayoutMode().x(this.eeL);
        com.baidu.tbadk.core.util.ar.j((View) this.eeO, r.d.cp_cont_b);
        this.eeO.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_link_tip_c));
        this.dYB.getLayoutMode().x(this.aAM);
        if (this.efr != null) {
            this.dYB.getLayoutMode().x(this.efr);
        }
        iJ(this.efR);
        this.efp.notifyDataSetChanged();
        if (this.eft != null) {
            this.eft.dk(i);
        }
        if (this.efu != null) {
            this.efu.dk(i);
            com.baidu.tbadk.core.util.ar.k(this.aAM, r.f.pb_foot_more_trans_selector);
            this.efu.di(r.f.pb_foot_more_trans_selector);
        }
        if (this.EM != null) {
            this.EM.onChangeSkinType(i);
        }
        if (this.eff != null) {
            this.eff.m24do(i);
        }
        if (this.efv != null) {
            this.efv.dk(i);
        }
        if (this.eeK != null && this.eeK.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eeK) {
                aVar.aMB();
            }
        }
        if (this.egJ != null) {
            com.baidu.tbadk.core.util.ar.l(this.egJ, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.l(this.egD, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.c(this.egI, r.d.cp_cont_c, 1);
        }
        iD(i == 1);
        this.eeS.changeSkinType(i);
        aLK();
        UtilHelper.setStatusBarBackground(this.bst, i);
        if (this.efg != null) {
            this.efg.onChangeSkinType(i);
        }
        if (this.efi != null) {
            com.baidu.tbadk.i.a.a(this.dYB.getPageContext(), this.efi);
        }
        if (this.egt != null) {
            this.egt.onChangeSkinType(i);
        }
        if (this.eeG != null) {
            this.eeG.onChangeSkinType(i);
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJq = eVar;
        this.efp.setOnImageClickListener(this.aJq);
    }

    public void g(NoNetworkView.a aVar) {
        this.aSE = aVar;
        if (this.bpG != null) {
            this.bpG.a(this.aSE);
        }
    }

    public void iL(boolean z) {
        this.efp.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aMh() {
        return this.efU;
    }

    public void aMi() {
        if (this.eeF != 2) {
            this.aMc.setNextPage(this.efu);
            this.eeF = 2;
        }
    }

    public void aMj() {
        if (com.baidu.tbadk.performanceLog.aa.FU().FV()) {
            int lastVisiblePosition = this.aMc.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aMc.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(r.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.fg(1001);
                                perfLog.aBW = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.vW();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(r.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fg(1001);
                        perfLog2.aBW = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.vW();
                    }
                }
            }
        }
    }

    public void gI(boolean z) {
        if (this.efV != null && this.efV != null) {
            if (this.dhg) {
                gJ(z);
            } else {
                gK(z);
            }
        }
    }

    public void aMk() {
        if (this.efV != null) {
            this.efV.setVisibility(8);
        }
    }

    public void aub() {
        if (this.egc == null) {
            this.egc = new com.baidu.tbadk.core.view.a(this.dYB.getPageContext());
        }
        this.egc.aJ(true);
    }

    public void aHa() {
        if (this.egc != null) {
            this.egc.aJ(false);
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.q qVar, String str, String str2, boolean z, boolean z2) {
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
        if (this.efg.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.efg.getLayoutParams();
            aVar.gravity = 48;
            this.efg.setLayoutParams(aVar);
        }
        this.eeT.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32), 0);
        this.egs.setPadding(0, com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds8), 0, 0);
        if (qVar.getType() == null || qVar.getType().getId() != com.baidu.tieba.tbadkCore.data.q.Tp.getId()) {
            this.eeL.setPadding(0, 0, 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds76);
        if (this.eeY.getLayoutParams() == null) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eeY.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        this.eeY.setLayoutParams(layoutParams);
        this.eeY.setVisibility(8);
        View findViewWithTag = this.eeT.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.edv = new ClickableHeaderImageView(this.dYB.getApplicationContext());
            this.edv.setGodIconMargin(0);
            this.edv.setTag("pb_god_head_image_view_tag");
            this.edv.setUserId(String.valueOf(userIdLong));
            this.edv.setUserName(userName);
            layoutParams.leftMargin = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds0);
            this.eeW.addView(this.edv, 0, layoutParams);
        } else {
            this.edv = (ClickableHeaderImageView) findViewWithTag;
        }
        if (this.adS) {
            this.edv.setIsBigV(true);
        }
        fo foVar = new fo(this, qVar);
        this.eeT.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
        this.eeT.setTag(r.g.tag_user_name, userName);
        this.eeP.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
        this.eeP.setTag(r.g.tag_user_name, userName);
        this.edv.setVisibility(0);
        this.edv.setOnClickListener(foVar);
        this.edv.c(portrait, 28, false);
        if (this.efe == null) {
            this.efe = new TextView(this.dYB.getActivity());
            this.efe.setClickable(true);
            this.efe.setTextSize(0, this.dYB.getResources().getDimensionPixelSize(r.e.fontsize24));
            ColumnLayout.a aVar2 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar2.topMargin = this.dYB.getResources().getDimensionPixelSize(r.e.ds10);
            this.efe.setSingleLine(true);
            this.efe.setEllipsize(TextUtils.TruncateAt.END);
            this.efe.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
            this.efe.setTag(r.g.tag_user_name, userName);
            com.baidu.tbadk.core.util.ar.c(this.efe, r.d.cp_cont_d, 1);
            this.efe.setOnTouchListener(this.dXp);
            this.eeT.addView(this.efe, -1, aVar2);
        }
        String string = this.dYB.getResources().getString(r.j.tieba_certification);
        this.efe.setText(StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.dYB.getResources().getString(r.j.god_intro_default)) : String.format(string, godUserData.getIntro()));
        if (this.efd == null) {
            this.efd = new TextView(this.dYB.getActivity());
            this.efd.setClickable(false);
            this.efd.setIncludeFontPadding(false);
            this.efd.setGravity(16);
            this.efd.setTextSize(0, this.dYB.getResources().getDimensionPixelSize(r.e.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.dYB.getResources().getDimensionPixelSize(r.e.ds5);
            aVar3.bottomMargin = this.dYB.getResources().getDimensionPixelSize(r.e.ds10);
            this.efd.setSingleLine(true);
            com.baidu.tbadk.core.util.ar.c(this.efd, r.d.cp_cont_d, 1);
            this.eeT.addView(this.efd, -1, aVar3);
        }
        String format = String.format(this.dYB.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.av.v(fansNum));
        this.efd.setText(format);
        this.efd.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
        this.efd.setTag(r.g.tag_user_name, userName);
        this.efd.setOnClickListener(foVar);
        if (this.egA == null) {
            this.egA = new TextView(this.dYB.getApplicationContext());
            this.egA.setId(r.g.pb_god_user_tip_content);
            this.egA.setEllipsize(TextUtils.TruncateAt.END);
            this.egA.setGravity(17);
            this.egA.setSingleLine(true);
            this.egA.setHeight(this.dYB.getResources().getDimensionPixelSize(r.e.ds56));
            this.egA.setTextSize(0, this.dYB.getResources().getDimensionPixelSize(r.e.fontsize24));
            this.egA.setVisibility(8);
            if (aMr() != null) {
                aMr().addView(this.egA);
            }
            this.dYB.getLayoutMode().x(this.egA);
        }
        com.baidu.tbadk.core.util.ar.k(this.egA, r.d.common_color_10260);
        com.baidu.tbadk.core.util.ar.j((View) this.egA, r.d.cp_cont_g);
        this.egA.setOnClickListener(new fp(this));
        this.egA.setText(String.format(this.dYB.getResources().getString(r.j.god_user_floor_owner_tip), com.baidu.tbadk.core.util.av.v(this.egB)));
        nQ(this.egB);
        if (this.egz == null) {
            this.egz = (LinearLayout) LayoutInflater.from(this.dYB.getActivity()).inflate(r.h.god_floating_view, (ViewGroup) null);
            this.egz.setOnClickListener(foVar);
            this.egz.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
            this.egz.setTag(r.g.tag_user_name, userName);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.egz.findViewById(r.g.god_floating_owner_photo);
            if (this.adS) {
                ViewStub viewStub = (ViewStub) this.egz.findViewById(r.g.viewstub_headimage_mask);
                if (viewStub != null && 0 == 0) {
                    viewStub.inflate();
                    TbImageView tbImageView = (TbImageView) this.egz.findViewById(r.g.user_head_mask);
                    if (tbImageView != null && author != null && author.getUserTbVipInfoData() != null && !StringUtils.isNull(author.getUserTbVipInfoData().getvipV_url())) {
                        tbImageView.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                        clickableHeaderImageView.setIsBigV(true);
                    }
                }
            } else {
                clickableHeaderImageView.setGodIconMargin(0);
            }
            clickableHeaderImageView.setOnClickListener(foVar);
            clickableHeaderImageView.setTag(qVar.getAuthor().getUserId());
            clickableHeaderImageView.c(qVar.getAuthor().getPortrait(), 28, false);
            ImageView imageView = (ImageView) this.egz.findViewById(r.g.god_floating_owner_info_user_rank);
            int level_id = qVar.getAuthor().getLevel_id();
            int is_bawu = qVar.getAuthor().getIs_bawu();
            String bawu_type = qVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.ar.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                imageView.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.egz.findViewById(r.g.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.ar.c(imageView2, r.f.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.ar.c(imageView2, r.f.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            if (!StringUtils.isNull(qVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aR(qVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = qVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.egz.findViewById(r.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.egz.findViewById(r.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.dYB.dZl.bJq);
                userIconBox.a(iconInfo, i, this.dYB.getResources().getDimensionPixelSize(r.e.ds30), this.dYB.getResources().getDimensionPixelSize(r.e.ds30), this.dYB.getResources().getDimensionPixelSize(r.e.ds10));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.dYB.dZl.ehq);
                userIconBox2.a(tShowInfoNew, 3, this.dYB.getResources().getDimensionPixelSize(r.e.ds32), this.dYB.getResources().getDimensionPixelSize(r.e.ds32), this.dYB.getResources().getDimensionPixelSize(r.e.ds8), true);
            }
            TextView textView = (TextView) this.egz.findViewById(r.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.ar.c(textView, r.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.ar.c(textView, r.d.cp_cont_f, 1);
            }
            textView.setText(qVar.getAuthor().getName_show());
            if (aMr() != null) {
                aMr().addView(this.egz);
            }
            this.dYB.getLayoutMode().x(this.egz);
        }
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) this.egz.findViewById(r.g.god_floating_gift);
        this.egM.a(entelechyUserLikeButton);
        this.egM.a(qVar.getAuthor());
        ImageView imageView3 = (ImageView) this.egz.findViewById(r.g.god_floating_arrow);
        com.baidu.tbadk.core.util.ar.c(imageView3, r.f.icon_arrow_tab);
        if (this.efS || (godUserData.getIsLike() && godUserData.getIsFromNetWork())) {
            entelechyUserLikeButton.setVisibility(8);
            imageView3.setVisibility(0);
        } else {
            entelechyUserLikeButton.setVisibility(0);
            imageView3.setVisibility(8);
        }
        TextView textView2 = (TextView) this.egz.findViewById(r.g.god_floating_intro);
        if (textView2 != null) {
            textView2.setText(format);
        }
        this.egJ = this.efu.wm();
        if (this.egJ != null && !this.efS && !z && z2 && (!godUserData.getIsLike() || !godUserData.getIsFromNetWork())) {
            this.efu.wn();
            this.efu.wj();
            this.egD = this.egJ.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.egD == null) {
                this.egD = new View(this.dYB.getApplicationContext());
                this.egD.setTag("pb_god_bottom_extra_line_view_tag");
                this.egJ.addView(this.egD, new LinearLayout.LayoutParams(-1, this.dYB.getResources().getDimensionPixelSize(r.e.ds20)));
                this.egH = new FrameLayout(this.dYB.getApplicationContext());
                this.egH.setTag("pb_god_bottom_extra_god_avatar_frame_tag");
                this.egF = new ClickableHeaderImageView(this.dYB.getApplicationContext());
                this.egF.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.egF.c(portrait, 28, false);
                this.egF.setUserId(String.valueOf(userIdLong));
                this.egF.setUserName(userName);
                this.egF.setOnClickListener(foVar);
                this.egH.addView(this.egF, new FrameLayout.LayoutParams(this.dYB.getResources().getDimensionPixelSize(r.e.ds130), this.dYB.getResources().getDimensionPixelSize(r.e.ds130)));
                if (this.adS) {
                    this.egG = new TbImageView(this.dYB.getApplicationContext());
                    this.egG.setTag("pb_god_bottom_extra_god_avatar_mask_tag");
                    this.egG.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.dYB.getResources().getDimensionPixelSize(r.e.ds45), this.dYB.getResources().getDimensionPixelSize(r.e.ds45));
                    layoutParams3.gravity = 85;
                    this.egH.addView(this.egG, layoutParams3);
                } else {
                    this.egF.setGodIconMargin(0);
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(this.dYB.getResources().getDimensionPixelSize(r.e.ds130), this.dYB.getResources().getDimensionPixelSize(r.e.ds130));
                layoutParams4.gravity = 17;
                layoutParams4.topMargin = this.dYB.getResources().getDimensionPixelSize(r.e.ds40);
                this.egJ.addView(this.egH, layoutParams4);
                this.egI = new TextView(this.dYB.getApplicationContext());
                this.egI.setTag("pb_god_bottom_extra_text_view_tag");
                this.egI.setSingleLine(true);
                this.egI.setTextSize(0, this.dYB.getResources().getDimensionPixelSize(r.e.fontsize24));
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams5.topMargin = this.dYB.getResources().getDimensionPixelSize(r.e.ds36);
                layoutParams5.gravity = 1;
                this.egI.setText(this.dYB.getResources().getString(r.j.god_user_attention_tip));
                this.egJ.addView(this.egI, layoutParams5);
                if (this.egE == null) {
                    this.egE = new EntelechyUserLikeButton(this.dYB.getApplicationContext());
                    this.egN.a(this.egE);
                }
                this.egE.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.egE.setTextSize(0, this.dYB.getResources().getDimensionPixelSize(r.e.fontsize24));
                this.egE.setGravity(17);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, this.dYB.getResources().getDimensionPixelSize(r.e.ds54));
                layoutParams6.topMargin = this.dYB.getResources().getDimensionPixelSize(r.e.ds30);
                layoutParams6.bottomMargin = this.dYB.getResources().getDimensionPixelSize(r.e.ds40);
                layoutParams6.gravity = 1;
                this.egJ.addView(this.egE, layoutParams6);
            } else {
                this.egE = (EntelechyUserLikeButton) this.egJ.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.egF = (ClickableHeaderImageView) this.egJ.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.egI = (TextView) this.egJ.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.egD = this.egJ.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            this.egN.a(qVar.getAuthor());
            com.baidu.tbadk.core.util.ar.l(this.egJ, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.l(this.egD, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.c(this.egI, r.d.cp_cont_c, 1);
            this.egJ.setOnTouchListener(new fq(this));
        } else {
            this.efu.wo();
            this.efu.wi();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.egw && !this.egx && i > this.eeE) {
            this.egy = true;
        } else {
            this.egy = false;
            aMm();
        }
        a aVar = new a();
        aVar.ehf = i;
        aVar.ehg = this.aMc.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
    }

    /* loaded from: classes.dex */
    public class a {
        public int ehf;
        public int ehg;

        public a() {
        }
    }

    private void nQ(int i) {
        boolean z;
        if (this.egA != null && this.egA.getVisibility() != 0 && i >= 2 && !this.efS) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.egC = true;
                this.egA.setVisibility(0);
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.bCu, 3000L);
        }
    }

    public void aMl() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bCu);
        if (this.egA != null && 8 != this.egA.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.dYB, this.egA, r.a.fade_out, new fr(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aMm() {
        if (this.egz != null) {
            this.egz.clearAnimation();
            if (this.egz.getVisibility() != 8) {
                this.egz.setVisibility(8);
            }
        }
    }

    public void aMn() {
        if (this.egw && this.egy && this.egz != null && this.egz.getVisibility() != 0 && !this.egC) {
            this.egz.clearAnimation();
            this.egz.setVisibility(0);
        }
    }

    public void aMo() {
        if (!this.egY) {
            TiebaStatic.log("c10490");
            this.egY = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dYB.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(egl, Integer.valueOf(egn));
            aVar.ca(r.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.dYB.getPageContext().getPageActivity()).inflate(r.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(r.g.function_description_view)).setText(r.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(r.g.title_view)).setText(r.j.grade_thread_tips);
            aVar.z(inflate);
            aVar.A(sparseArray);
            aVar.a(r.j.grade_button_tips, this.dYB);
            aVar.b(r.j.look_again, new fs(this));
            aVar.b(this.dYB.getPageContext()).tb();
        }
    }

    public void aMp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dYB.getPageContext().getPageActivity());
        aVar.cG(this.dYB.getResources().getString(r.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(egl, Integer.valueOf(egp));
        aVar.A(sparseArray);
        aVar.a(r.j.upgrade_to_new, this.dYB);
        aVar.b(r.j.cancel, new ft(this));
        aVar.b(this.dYB.getPageContext()).tb();
    }

    public int rt() {
        return this.egi;
    }

    public void oc(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dYB.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.dYB.getPageContext().getPageActivity()).inflate(r.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(r.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(r.g.function_description_view)).setVisibility(8);
        aVar.z(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(egl, Integer.valueOf(ego));
        aVar.A(sparseArray);
        aVar.a(r.j.view, this.dYB);
        aVar.b(r.j.cancel, new fu(this));
        aVar.b(this.dYB.getPageContext()).tb();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.q a2;
        if (i > 0 && (a2 = a(fVar, z)) != null && a2.getAuthor() != null) {
            MetaData author = a2.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
    }

    public PbInterviewStatusView aMq() {
        return this.egh;
    }

    private void n(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aIl() != null && fVar.aIl().sv() && this.egh == null) {
            this.egh = (PbInterviewStatusView) this.egg.inflate();
            this.egh.setOnClickListener(this.bzZ);
            this.egh.setCallback(this.dYB.aJD());
            this.egh.a(this.dYB, fVar);
        }
    }

    public LinearLayout aMr() {
        return this.efo;
    }

    public View aMs() {
        return this.bst;
    }

    public boolean aMt() {
        return this.egK;
    }

    public void ia(boolean z) {
        this.eeR.ia(z);
    }

    private void aMu() {
        if (this.egK) {
            if (this.egL == null) {
                f.a aVar = f.dYD.get();
                if (aVar != null) {
                    this.egL = aVar.a(this.dYB);
                    ListAdapter adapter = this.aMc.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.aqN) {
                            this.aMc.f(this.egL.aIU(), 1);
                        } else {
                            this.aMc.f(this.egL.aIU(), 0);
                        }
                    }
                } else {
                    this.eeP.setVisibility(0);
                    return;
                }
            }
            this.eeP.setVisibility(8);
            this.aMc.removeHeaderView(this.eeP);
            return;
        }
        this.eeP.setVisibility(0);
    }

    public void iM(boolean z) {
        this.egK = z;
    }

    public View aKh() {
        return this.eeS.aKh();
    }

    public void aMv() {
        this.dYB.showNetRefreshView(getView(), "");
        View En = this.dYB.getRefreshView().En();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) En.getLayoutParams();
        layoutParams.addRule(3, aMr().getId());
        En.setLayoutParams(layoutParams);
        this.dYB.hideLoadingView(getView());
        if (this.egL != null) {
            this.aMc.removeHeaderView(this.egL.aIU());
            this.egL = null;
        }
    }

    public void od(String str) {
        if (this.eeH != null) {
            this.eeH.setTitle(str);
        }
    }

    public void aMw() {
        if (this.efp != null) {
            if (this.efp.aJP() != null) {
                this.efp.aJP().axy();
            }
            if (this.efp.aJQ() != null) {
                this.efp.aJQ().axy();
            }
        }
    }

    private int iN(boolean z) {
        if (this.egh == null || this.egh.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.e(this.dYB.getPageContext().getPageActivity(), r.e.ds72);
    }

    private void aMx() {
        if (this.egh != null && this.egh.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.egh.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.egh.setLayoutParams(layoutParams);
        }
    }

    public boolean aJd() {
        return this.egw;
    }

    public TextView aMy() {
        return this.efe;
    }

    public void aMz() {
        this.efY.performClick();
    }
}
